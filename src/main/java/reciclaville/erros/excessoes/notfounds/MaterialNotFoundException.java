package reciclaville.erros.excessoes.notfounds;

public class MaterialNotFoundException extends NotFoundException {
    public MaterialNotFoundException(Long id) {
        super("Material não encontrado com o id: " + id);
    }
}
