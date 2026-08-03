package reciclaville.dtos.clientes;

public record ClienteResponseDto(
        Long id,
        String empresa,
        String cnpj,
        String nicho,
        String representante
) { }
