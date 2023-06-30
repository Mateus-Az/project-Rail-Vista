package br.com.railvista.Maintenance.Controller;

import br.com.railsUtils.DTO.MaintenanceDTO;
import br.com.railsUtils.DTO.TrainDTO;
import br.com.railvista.Maintenance.Entities.Maintenance;
import br.com.railvista.Maintenance.Service.MaintenanceService;
import br.com.railvista.Maintenance.UseCase.TrainService;
import br.com.railvista.Maintenance.Utils.DTOConverter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<MaintenanceDTO> getAll(){
       return maintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public MaintenanceDTO getById(@PathVariable UUID id){
        return maintenanceService.findById(id);
    }
    @GetMapping("/byTrainId/{id}")
    public MaintenanceDTO getByTrainId(@PathVariable UUID id){
        return maintenanceService.findByTrainId(id);
    }

    @PostMapping
    @Transactional
    public MaintenanceDTO newMaintence(@RequestBody @Valid MaintenanceDTO maintenanceDTO){
        TrainDTO trainDTO = trainService.getTrainById(maintenanceDTO.getTrainId());
        return maintenanceService.save(maintenanceDTO);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteById(@PathVariable UUID id){
        maintenanceService.deleteById(id);
    }

}
