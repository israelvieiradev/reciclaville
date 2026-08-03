package reciclaville.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reciclaville.dtos.materiais.MaterialRequestDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.services.MaterialServiceImpl;

import java.util.List;

@RestController
@RequestMapping("materiais")
public class MaterialController {

    private final MaterialServiceImpl service;

    public MaterialController(MaterialServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDto post(@RequestBody MaterialRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MaterialResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MaterialResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MaterialResponseDto putById(@PathVariable Long id, @RequestBody MaterialRequestDto dto) {
        return service.updateById(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("OK");
    }
}
