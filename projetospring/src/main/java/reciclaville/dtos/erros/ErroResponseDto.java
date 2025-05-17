package reciclaville.dtos.erros;

public record ErroResponseDto (
        String codErro,
        String mensagem,
        String causa,
        String excessaoClasseNome
){ }
