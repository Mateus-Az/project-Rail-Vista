package br.com.railvista.RailVista.Exceptions;

import br.com.railsUtils.ErrorDTO;
import br.com.railsUtils.TrainNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "br.com.railvista.RailVista.Controller")
public class ExceptionHandling {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TrainNotFoundException.class)
    public ErrorDTO handlerTrainNotFound(TrainNotFoundException trainNotFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Não foi possivel localizar esse trem");
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
