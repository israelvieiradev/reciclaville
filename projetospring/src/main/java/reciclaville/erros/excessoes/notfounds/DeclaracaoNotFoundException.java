package reciclaville.erros.excessoes.notfounds;

public class DeclaracaoNotFoundException extends NotFoundException {
    public DeclaracaoNotFoundException(Long id) {
        super("Declaração não encontrada com o id: " + id);
    }
}
