package reciclaville.dtos.itens;

import reciclaville.entities.Declaracao;
import reciclaville.entities.Material;

public record ItemDeclaracaoRequestDto(
        Material material,
        double peso
) { }
