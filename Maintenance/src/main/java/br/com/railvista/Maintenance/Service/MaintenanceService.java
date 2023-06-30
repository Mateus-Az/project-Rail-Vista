package br.com.railvista.Maintenance.Service;

import br.com.railsUtils.DTO.MaintenanceDTO;
import br.com.railsUtils.Exceptions.MaintenanceNotFound;
import br.com.railvista.Maintenance.Entities.Maintenance;
import br.com.railvista.Maintenance.Repository.MaintenanceRepository;
import br.com.railvista.Maintenance.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<MaintenanceDTO> findAll() {
        //return maintenanceRepository.findAll().stream().map(DTOConverter::convert).toList();
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        if (maintenances.isEmpty()){
            throw new MaintenanceNotFound();
        }
        return maintenances.stream().map(DTOConverter::convert).toList();
    }

    public MaintenanceDTO findById(UUID id) {
        return DTOConverter.convert(maintenanceRepository.getReferenceById(id));
    }

    public MaintenanceDTO save(MaintenanceDTO maintenanceDTO) {
        return DTOConverter.convert(maintenanceRepository.save(Maintenance.convert(maintenanceDTO)));
    }

    public void deleteById(UUID id) {
        maintenanceRepository.deleteById(id);
    }

    public MaintenanceDTO findByTrainId(UUID id) {
        return DTOConverter.convert(maintenanceRepository.findByTrainId(id));
    }
}
