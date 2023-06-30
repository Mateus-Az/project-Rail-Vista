package br.com.railvista.RailVista.Exceptions;

import br.com.railsUtils.Errors.ErrorDTO;
import br.com.railsUtils.Exceptions.TrainInMaintenanceException;
import br.com.railsUtils.Exceptions.TrainNotFoundException;
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

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(TrainInMaintenanceException.class)
    public ErrorDTO handlerTrainMaintenance(TrainInMaintenanceException trainInMaintenanceException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorDTO.setMessage("Não foi possível remover, trem em manutenção");
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
