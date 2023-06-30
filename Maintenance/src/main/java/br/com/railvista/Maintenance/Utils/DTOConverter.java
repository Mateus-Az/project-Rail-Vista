package br.com.railvista.Maintenance.Utils;


import br.com.railsUtils.DTO.MaintenanceDTO;
import br.com.railvista.Maintenance.Entities.Maintenance;

public class DTOConverter {

    public static MaintenanceDTO convert(Maintenance maintenance){
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();
        maintenanceDTO.setId(maintenance.getId());
        maintenanceDTO.setTrainId(maintenance.getTrainId());
        maintenanceDTO.setValueOfMaintenance(maintenance.getValueOfMaintenance());
        maintenanceDTO.setTimeService(maintenance.getTimeService());
        return maintenanceDTO;

    }
}
