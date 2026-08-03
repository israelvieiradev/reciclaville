package reciclaville.services;

import reciclaville.dtos.declaracoes.DeclaracaoRequestDto;
import reciclaville.dtos.declaracoes.DeclaracaoResponseDto;
import reciclaville.entities.Declaracao;

import java.util.List;

public interface DeclaracaoService {

    List<DeclaracaoResponseDto> findAll();
    DeclaracaoResponseDto findById(Long id);
    DeclaracaoResponseDto create(DeclaracaoRequestDto requestDto);
    void deleteById(Long id);
}
