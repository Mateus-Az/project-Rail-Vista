package br.com.railvista.Maintenance.Exceptions;

import br.com.railsUtils.Errors.ErrorDTO;
import br.com.railsUtils.Exceptions.MaintenanceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "br.com.railvista.Maintenance.Controller")
public class ExceptionHandling {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MaintenanceNotFound.class)
    public ErrorDTO handlerMaintenceNotFound(MaintenanceNotFound maintenanceNotFound){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Maintenance Not Found");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
