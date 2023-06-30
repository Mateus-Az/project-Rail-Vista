package br.com.railvista.RailVista.Controller;

import br.com.railsUtils.DTO.TrainDTO;
import br.com.railvista.RailVista.Service.TrainService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("/train")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainDTO newTrain(@RequestBody @Valid TrainDTO trainDTO){
        return trainService.save(trainDTO);
    }

    @GetMapping("/train")
    public List<TrainDTO> getAll(){
        return trainService.findAll();
    }

    @GetMapping("/train/{id}")
    public TrainDTO getById(@PathVariable UUID id){
        return trainService.findById(id);
    }

    @DeleteMapping("/train/{id}")
    @Transactional
    public TrainDTO deleteById(@PathVariable UUID id){
        return trainService.deleteById(id);
    }
}
