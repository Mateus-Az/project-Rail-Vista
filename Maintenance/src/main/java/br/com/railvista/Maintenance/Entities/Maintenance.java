package br.com.railvista.Maintenance.Entities;

import br.com.railsUtils.DTO.MaintenanceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private double valueOfMaintenance;
    private LocalDateTime timeService;
    private UUID trainId;

    public static Maintenance convert(MaintenanceDTO maintenanceDTO){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Maintenance maintenance = new Maintenance();
        maintenance.setTrainId(maintenanceDTO.getTrainId());
        maintenance.setValueOfMaintenance(maintenanceDTO.getValueOfMaintenance());
        maintenance.setTimeService(LocalDateTime.now());
        return maintenance;
    }
}
