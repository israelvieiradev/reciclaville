package reciclaville.erros.excessoes.notfounds;

// classes abstratas não são usadas para ser um objeto mas sim um complemento de uma classe concreta
public abstract class NotFoundException extends RuntimeException { // não necessita de throw
    NotFoundException(String mensagem) {
        super(mensagem); // chama o construtor da classe pai (RunTime) - possui vários tipos
    }
}
