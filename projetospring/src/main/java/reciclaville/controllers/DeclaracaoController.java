package reciclaville.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reciclaville.dtos.declaracoes.DeclaracaoRequestDto;
import reciclaville.dtos.declaracoes.DeclaracaoResponseDto;
import reciclaville.services.DeclaracaoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("declaracoes")
public class DeclaracaoController {

    private final DeclaracaoServiceImpl service;

    public DeclaracaoController(DeclaracaoServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeclaracaoResponseDto post(@RequestBody DeclaracaoRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeclaracaoResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeclaracaoResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
