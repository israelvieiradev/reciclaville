package reciclaville.services;

import reciclaville.dtos.materiais.MaterialRequestDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.entities.Material;

import java.util.List;

public interface MaterialService {

    List<MaterialResponseDto> findAll();
    MaterialResponseDto findById(Long id);
    MaterialResponseDto create(MaterialRequestDto requestDto);
    MaterialResponseDto updateById(Long id, MaterialRequestDto requestDto);
    void deleteById(Long id);
}
