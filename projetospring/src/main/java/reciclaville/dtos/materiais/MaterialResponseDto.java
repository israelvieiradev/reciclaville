package reciclaville.dtos.materiais;

public record MaterialResponseDto(
        Long id,
        String nome,
        double percCompensacaoMaterial
) { }
