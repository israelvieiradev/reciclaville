package reciclaville.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reciclaville.dtos.erros.ErroResponseDto;
import reciclaville.erros.excessoes.invaliddates.InvalidValueException;
import reciclaville.erros.excessoes.requiredattributes.RequiredAttributeException;
import reciclaville.erros.excessoes.notfounds.NotFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponseDto> handle(Exception e) {
        return ResponseEntity.internalServerError().body(new ErroResponseDto(
                "500",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage(): null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErroResponseDto> handle(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage(): null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResponseDto> handle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage(): null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(RequiredAttributeException.class)
    public ResponseEntity<ErroResponseDto> handle(RequiredAttributeException e) {
        return ResponseEntity.badRequest().body(new ErroResponseDto(
                "400",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage(): null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErroResponseDto> handle(InvalidValueException e) {
        return ResponseEntity.badRequest().body(new ErroResponseDto(
                "400",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage(): null,
                e.getClass().getSimpleName()
        ));
    }
}
