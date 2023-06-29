package br.com.railvista.RailVista.Controller;

import br.com.railsUtils.TrainDTO;
import br.com.railvista.RailVista.Service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainDTO newTrain(@RequestBody @Valid TrainDTO trainDTO){
        return trainService.save(trainDTO);
    }

    @GetMapping
    public List<TrainDTO> getAll(){
        return trainService.findAll();
    }

    @DeleteMapping("/{id}")
    public TrainDTO deleteById(@PathVariable UUID id){
        return trainService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        trainService.deleteAll();
    }
}
