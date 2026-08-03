package reciclaville.mappers;

import org.springframework.context.annotation.Configuration;
import reciclaville.dtos.declaracoes.DeclaracaoRequestDto;
import reciclaville.dtos.declaracoes.DeclaracaoResponseDto;
import reciclaville.dtos.itens.ItemDeclaracaoRequestDto;
import reciclaville.dtos.itens.ItemDeclaracaoResponseDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.entities.Declaracao;
import reciclaville.entities.ItemDeclaracao;
import reciclaville.entities.Material;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoMapper {

    public DeclaracaoMapper() {
    }

    public static Declaracao toEntity(Declaracao declaracao, DeclaracaoRequestDto dto) {

        double totalPeso = 0;
        double totalPerc = 0;

        declaracao.setCliente(dto.cliente());
        declaracao.setDataInicial(dto.dataInicial());
        declaracao.setDataFinal(dto.dataFinal());

        for (ItemDeclaracaoRequestDto itemRequestDto : dto.itens()) {
            ItemDeclaracao item = new ItemDeclaracao();
            item.setDeclaracao(declaracao);
            item.setMaterial(itemRequestDto.material());
            item.setPercCompensacao(itemRequestDto.material().getPercCompensacaoMaterial());
            item.setPeso(itemRequestDto.peso());
            double toneladasCompensadas = (item.getPeso() * item.getPercCompensacao()) / 100;
            item.setToneladasCompensadas(toneladasCompensadas);

            totalPeso = totalPeso + item.getPeso();
            totalPerc = totalPerc + item.getPercCompensacao();

            declaracao.getItens().add(item);
        }

        declaracao.setPesoTotalMateriais(totalPeso);
        declaracao.setPercTotalCompensacao(totalPerc);

        return declaracao;
    }

    public static DeclaracaoResponseDto toResponseDto(Declaracao declaracao) {
        List<ItemDeclaracaoResponseDto> itemDeclaracaoResponseDto = new ArrayList();
        for (ItemDeclaracao item : declaracao.getItens()) {
            ItemDeclaracaoResponseDto itemResponseDto = new ItemDeclaracaoResponseDto(
                    item.getId(),
                    item.getDeclaracao().getId(),
                    item.getMaterial(),
                    item.getPercCompensacao(),
                    item.getPeso(),
                    item.getToneladasCompensadas()
            );
            itemDeclaracaoResponseDto.add(itemResponseDto);
        }
        return new DeclaracaoResponseDto(
                declaracao.getId(),
                declaracao.getCliente(),
                declaracao.getDataDeclaracao(),
                declaracao.getDataInicial(),
                declaracao.getDataFinal(),
                declaracao.getPesoTotalMateriais(),
                declaracao.getPercTotalCompensacao(),
                itemDeclaracaoResponseDto
        );
    }

    public static List<DeclaracaoResponseDto> toResponseDtos(List<Declaracao> declaracoes) {
        return declaracoes.stream().map(DeclaracaoMapper::toResponseDto).toList();
    }
}
