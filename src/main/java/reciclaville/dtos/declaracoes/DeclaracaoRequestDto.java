package reciclaville.dtos.declaracoes;

import reciclaville.dtos.itens.ItemDeclaracaoRequestDto;
import reciclaville.entities.Cliente;
import java.time.LocalDate;
import java.util.List;

public record DeclaracaoRequestDto(
        Cliente cliente,
        LocalDate dataInicial,
        LocalDate dataFinal,
        List<ItemDeclaracaoRequestDto> itens
) { }
