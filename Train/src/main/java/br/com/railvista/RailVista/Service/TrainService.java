package br.com.railvista.RailVista.Service;

import br.com.railsUtils.DTO.MaintenanceDTO;
import br.com.railsUtils.DTO.TrainDTO;
import br.com.railsUtils.Exceptions.TrainInMaintenanceException;
import br.com.railsUtils.Exceptions.TrainNotFoundException;
import br.com.railvista.RailVista.Entities.Train;
import br.com.railvista.RailVista.Repository.TrainRepository;
import br.com.railvista.RailVista.Usecase.MaintenanceService;
import br.com.railvista.RailVista.Utilis.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private MaintenanceService maintenanceService;


    public TrainDTO save(TrainDTO trainDTO) {
        Train train = trainRepository.save(Train.convert(trainDTO));
        return DTOConverter.convert(train);
    }

    public List<TrainDTO> findAll() {
        List<Train> trains = trainRepository.findAll();
        if (trains.isEmpty()){
            throw new TrainNotFoundException();
        }
        return trains.stream().map(DTOConverter::convert).toList();
    }

    public TrainDTO deleteById(UUID id) {
        Optional<Train> train = trainRepository.findById(id);

        if (maintenanceService.getMaintenanceByIdTrain(id) == null) {
            if (train.isEmpty()) {
                throw new TrainNotFoundException();
            }
            if (train.isPresent()) {
                trainRepository.deleteById(id);
            }
        } else {
            throw new TrainInMaintenanceException();
        }
        return DTOConverter.convert(train.get());
    }

    public TrainDTO findById(UUID id) {
        Optional<Train> train = trainRepository.findById(id);
        if (train.isEmpty()){
            throw new TrainNotFoundException();
        }
        return DTOConverter.convert(train.get());
    }
}
