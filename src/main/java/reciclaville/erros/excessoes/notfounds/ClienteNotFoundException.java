package reciclaville.erros.excessoes.notfounds;

public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException(Long id) {
        super("Cliente não encontrado com o id: " + id);
    }
}
