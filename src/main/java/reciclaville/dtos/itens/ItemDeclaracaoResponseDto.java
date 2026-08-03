package reciclaville.dtos.itens;

import reciclaville.entities.Declaracao;
import reciclaville.entities.Material;

public record ItemDeclaracaoResponseDto(
        Long id,
        Long idDeclaracao,
        Material material,
        double percCompensacao,
        double peso,
        double toneladasCompensadas
) { }
