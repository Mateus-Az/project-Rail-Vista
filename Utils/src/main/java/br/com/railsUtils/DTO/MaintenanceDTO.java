package br.com.railsUtils.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MaintenanceDTO {

    private UUID id;
    @NotNull
    private double valueOfMaintenance;
    private LocalDateTime timeService;
    @NotNull
    private UUID trainId;

}
