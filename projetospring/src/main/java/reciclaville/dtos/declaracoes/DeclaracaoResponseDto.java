package reciclaville.dtos.declaracoes;

import reciclaville.dtos.itens.ItemDeclaracaoResponseDto;
import reciclaville.entities.Cliente;
import java.time.LocalDate;
import java.util.List;

public record DeclaracaoResponseDto(
        Long id,
        Cliente cliente,
        LocalDate dataDeclaracao,
        LocalDate dataInicial,
        LocalDate dataFinal,
        double pesoTotal,
        double percTotalCompensacao,
        List<ItemDeclaracaoResponseDto> itens
) { }
