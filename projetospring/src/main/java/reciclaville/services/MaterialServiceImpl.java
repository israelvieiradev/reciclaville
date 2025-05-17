package reciclaville.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reciclaville.dtos.materiais.MaterialRequestDto;
import reciclaville.dtos.materiais.MaterialResponseDto;
import reciclaville.entities.Material;
import reciclaville.erros.excessoes.requiredattributes.MaterialRequiredAttributeException;
import reciclaville.erros.excessoes.notfounds.MaterialNotFoundException;
import reciclaville.mappers.MaterialMapper;
import reciclaville.repositories.MaterialRepository;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    public MaterialServiceImpl(MaterialRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaterialResponseDto create(MaterialRequestDto requestDto) {
        validateDto(requestDto); // valida os atributos

        Material material = MaterialMapper.toEntity(new Material(), requestDto);
        repository.save(material);

        return MaterialMapper.toResponseDto(material);
    }
    @Override
    public List<MaterialResponseDto> findAll() {
        List<Material> materiais = repository.findAll();
        return MaterialMapper.toResponseDtos(materiais);
    }

    @Override
    public MaterialResponseDto findById(Long id) {
        return MaterialMapper.toResponseDto(findEntityById(id));
    }

    @Override
    public MaterialResponseDto updateById(Long id, MaterialRequestDto requestDto) {
        Material material = findEntityById(id);
        validateDto(requestDto);

        MaterialMapper.toEntity(material, requestDto);
        return MaterialMapper.toResponseDto(repository.save(material));
    }
    @Override
    public void deleteById(Long id) {
        repository.delete(findEntityById(id));
    }

    private Material findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new MaterialNotFoundException(id));
    }

    private void validateDto(MaterialRequestDto requestDto) {
        if (!StringUtils.hasText(requestDto.nome())) {
            throw new MaterialRequiredAttributeException("nome");
        }

        if (requestDto.percCompensacaoMaterial() == 0) {
            throw new MaterialRequiredAttributeException("percCompensacaoMaterial");
        }
    }
}
