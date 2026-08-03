package reciclaville.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reciclaville.dtos.clientes.ClienteRequestDto;
import reciclaville.dtos.clientes.ClienteResponseDto;
import reciclaville.services.ClienteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteServiceImpl service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto post(@RequestBody ClienteRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto putById(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
        return service.updateById(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
