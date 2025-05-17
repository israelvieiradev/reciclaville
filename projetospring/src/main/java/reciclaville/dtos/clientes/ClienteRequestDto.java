package reciclaville.dtos.clientes;

public record ClienteRequestDto (
        String empresa,
        String cnpj,
        String nicho,
        String representante
) { }
