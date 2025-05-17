package reciclaville.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reciclaville.dtos.clientes.ClienteRequestDto;
import reciclaville.dtos.clientes.ClienteResponseDto;

import reciclaville.entities.Cliente;
import reciclaville.erros.excessoes.notfounds.ClienteNotFoundException;
import reciclaville.erros.excessoes.requiredattributes.ClienteRequiredAttributeException;
import reciclaville.mappers.ClienteMapper;
import reciclaville.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteResponseDto create(ClienteRequestDto requestDto) {
        validateDto(requestDto);

        Cliente cliente = ClienteMapper.toEntity(new Cliente(), requestDto);
        repository.save(cliente);
        return ClienteMapper.toResponseDto(cliente);
    }

    @Override
    public List<ClienteResponseDto> findAll() {
        List<Cliente> clientes = repository.findAll();
        return ClienteMapper.toResponseDtos(clientes);
    }

    @Override
    public ClienteResponseDto findById(Long id) {
        return ClienteMapper.toResponseDto(findEntityById(id));
    }

    @Override
    public ClienteResponseDto updateById(Long id, ClienteRequestDto requestDto) {
        Cliente cliente = findEntityById(id);
        validateDto(requestDto);

        ClienteMapper.toEntity(cliente, requestDto);
        return ClienteMapper.toResponseDto(repository.save(cliente));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(findEntityById(id));
    }


    private Cliente findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
    }

    private void validateDto(ClienteRequestDto requestDto) {
        if (!StringUtils.hasText(requestDto.empresa())) {
            throw new ClienteRequiredAttributeException("empresa");
        }
        if (!StringUtils.hasText(requestDto.cnpj())) {
            throw new ClienteRequiredAttributeException("cnpj");
        }
        if (!StringUtils.hasText(requestDto.nicho())) {
            throw new ClienteRequiredAttributeException("nicho");
        }
        if (!StringUtils.hasText(requestDto.representante())) {
            throw new ClienteRequiredAttributeException("representante");
        }
    }
}
