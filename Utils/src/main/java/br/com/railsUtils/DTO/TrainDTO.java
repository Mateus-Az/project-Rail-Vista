package br.com.railsUtils.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TrainDTO {

    private UUID id;
    @NotNull
    private int numberOfPassagers;
    @NotNull
    private int wagons;
    @NotNull
    private double valueOfTicket;
}
