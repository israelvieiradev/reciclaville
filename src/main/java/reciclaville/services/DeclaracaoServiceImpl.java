package reciclaville.services;

import org.springframework.stereotype.Service;
;
import reciclaville.dtos.clientes.ClienteResponseDto;
import reciclaville.dtos.declaracoes.DeclaracaoRequestDto;
import reciclaville.dtos.declaracoes.DeclaracaoResponseDto;
import reciclaville.dtos.itens.ItemDeclaracaoRequestDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.entities.Declaracao;
import reciclaville.erros.excessoes.invalidevalues.DeclaracaoInvalidValueException;
import reciclaville.erros.excessoes.notfounds.DeclaracaoNotFoundException;

import reciclaville.erros.excessoes.requiredattributes.DeclaracaoRequiredAttributeException;

import reciclaville.mappers.DeclaracaoMapper;
import reciclaville.repositories.DeclaracaoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeclaracaoServiceImpl implements DeclaracaoService {

    private final DeclaracaoRepository repository;
    private final MaterialService materialService;
    private final ClienteService clienteService;

    public DeclaracaoServiceImpl(DeclaracaoRepository repository, MaterialService materialService,
                                 ClienteService clienteService) {

        this.repository = repository;
        this.materialService = materialService;
        this.clienteService = clienteService;
    }

    @Override
    public DeclaracaoResponseDto create(DeclaracaoRequestDto requestDto) {
        if (requestDto.cliente() == null) {
            throw new DeclaracaoRequiredAttributeException("cliente");
        }
        if (requestDto.cliente().getId() == null) {
            throw new DeclaracaoRequiredAttributeException("cliente.id");
        }
        ClienteResponseDto responseDto = clienteService.findById(requestDto.cliente().getId());

        validateDto(requestDto);

        Declaracao declaracao = DeclaracaoMapper.toEntity(new Declaracao(), requestDto);

        declaracao.getCliente().setEmpresa(responseDto.empresa());
        declaracao.getCliente().setCnpj(responseDto.cnpj());
        declaracao.getCliente().setNicho(responseDto.nicho());
        declaracao.getCliente().setRepresentante(responseDto.representante());

        declaracao.setDataDeclaracao(LocalDate.now());
        repository.save(declaracao);

        return DeclaracaoMapper.toResponseDto(declaracao);
    }

    @Override
    public List<DeclaracaoResponseDto> findAll() {
        List<Declaracao> declaracoes = repository.findAll();
        return DeclaracaoMapper.toResponseDtos(declaracoes);
    }

    @Override
    public DeclaracaoResponseDto findById(Long id) {
        return DeclaracaoMapper.toResponseDto(findEntityById(id));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(findEntityById(id));
    }


    private Declaracao findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DeclaracaoNotFoundException(id));
    }

    private void validateDto(DeclaracaoRequestDto requestDto) {
        if (requestDto.dataInicial() == null ) {
            throw new DeclaracaoRequiredAttributeException("dataInicial");
        }
        if (requestDto.dataFinal() == null) {
            throw new DeclaracaoRequiredAttributeException("dataFinal");
        }

        if (requestDto.dataInicial().isAfter(requestDto.dataFinal())) {
            throw new DeclaracaoInvalidValueException("dataInicial");
        }

        if (requestDto.itens() == null || requestDto.itens().isEmpty()) {
            throw new DeclaracaoRequiredAttributeException("itens");
        }

        for(ItemDeclaracaoRequestDto itemRequestDto : requestDto.itens()) {
            if (itemRequestDto.material() == null) {
                throw new DeclaracaoRequiredAttributeException("material");
            }
            if (itemRequestDto.material().getId() == null) {
                throw new DeclaracaoRequiredAttributeException("material.id");
            }
            MaterialResponseDto responseDto = materialService.findById(itemRequestDto.material().getId());
            if (itemRequestDto.peso() <= 0) {
                throw new DeclaracaoInvalidValueException("peso");
            }

            itemRequestDto.material().setNome(responseDto.nome());
            itemRequestDto.material().setPercCompensacaoMaterial(responseDto.percCompensacaoMaterial());
        }
    }
}
