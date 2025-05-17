package reciclaville.erros.excessoes.requiredattributes;

public class ClienteRequiredAttributeException extends RequiredAttributeException {
    public ClienteRequiredAttributeException(String attribute) {
        super(attribute);
    }
}
