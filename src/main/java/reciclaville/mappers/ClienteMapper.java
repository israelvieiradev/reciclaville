package reciclaville.mappers;

import reciclaville.dtos.clientes.ClienteRequestDto;
import reciclaville.dtos.clientes.ClienteResponseDto;
import reciclaville.entities.Cliente;

import java.util.List;

public class ClienteMapper {

    private ClienteMapper() {}

    public static Cliente toEntity(Cliente cliente, ClienteRequestDto dto) {
        cliente.setEmpresa(dto.empresa());
        cliente.setCnpj(dto.cnpj());
        cliente.setNicho(dto.nicho());
        cliente.setRepresentante(dto.representante());
        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente) {
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getEmpresa(),
                cliente.getCnpj(),
                cliente.getNicho(),
                cliente.getRepresentante()
        );
    }

    public static List<ClienteResponseDto> toResponseDtos(List<Cliente> clientes) {
        return clientes.stream().map(ClienteMapper ::toResponseDto).toList();
    }
}
