package reciclaville.erros.excessoes.requiredattributes;

// classes abstratas não são usadas para ser um objeto mas sim um complemento de uma classe concreta
public abstract class RequiredAttributeException extends RuntimeException { // não necessita de throw
    RequiredAttributeException(String attribute) {
        super("Atributo '" + attribute + "' não informado"); // chama o construtor da classe pai (RunTime) - possui vários tipos
    }
}
