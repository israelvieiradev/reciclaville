package reciclaville.erros.excessoes.requiredattributes;

public class MaterialRequiredAttributeException extends RequiredAttributeException {
    public MaterialRequiredAttributeException (String attribute) {
        super(attribute);
    }
}
