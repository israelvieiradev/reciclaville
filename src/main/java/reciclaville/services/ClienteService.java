package reciclaville.services;

import reciclaville.dtos.clientes.ClienteRequestDto;
import reciclaville.dtos.clientes.ClienteResponseDto;
import reciclaville.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<ClienteResponseDto> findAll();
    ClienteResponseDto findById(Long id);
    ClienteResponseDto create(ClienteRequestDto requestDto);
    ClienteResponseDto updateById(Long id, ClienteRequestDto requestDto);
    void deleteById(Long id);
}
