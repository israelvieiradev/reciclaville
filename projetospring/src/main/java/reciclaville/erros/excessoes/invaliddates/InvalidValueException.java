package reciclaville.erros.excessoes.invaliddates;


public abstract class InvalidValueException extends RuntimeException {
    InvalidValueException(String attribute) {
        super("O atributo '" + attribute + "' é inválido");
    }
}
