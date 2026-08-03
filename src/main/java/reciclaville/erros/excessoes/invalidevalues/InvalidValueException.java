package reciclaville.erros.excessoes.invalidevalues;


public abstract class InvalidValueException extends RuntimeException {
    InvalidValueException(String attribute) {
        super("O atributo '" + attribute + "' é inválido");
    }
}
