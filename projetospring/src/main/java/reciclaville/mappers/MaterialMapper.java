package reciclaville.mappers;

import reciclaville.dtos.materiais.MaterialRequestDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.entities.Material;

import java.util.List;

public class MaterialMapper {

    private MaterialMapper() {}

    public static Material toEntity(Material material, MaterialRequestDto dto) {
        material.setNome(dto.nome());
        material.setPercCompensacaoMaterial(dto.percCompensacaoMaterial());
        return material;
    }

    public static MaterialResponseDto toResponseDto(Material material) {
        return new MaterialResponseDto(
                material.getId(),
                material.getNome(),
                material.getPercCompensacaoMaterial()
        );
    }

    public static List<MaterialResponseDto> toResponseDtos(List<Material> materiais) {
        return materiais.stream().map(MaterialMapper::toResponseDto).toList();
    }
}
