package br.com.railvista.RailVista.Service;

import br.com.railsUtils.TrainDTO;
import br.com.railsUtils.TrainNotFoundException;
import br.com.railvista.RailVista.Entities.Train;
import br.com.railvista.RailVista.Repository.TrainRepository;
import br.com.railvista.RailVista.Utilis.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;


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
        trainRepository.deleteById(id);
        return DTOConverter.convert(train.get());
    }

    public void deleteAll() {
        trainRepository.deleteAll();
    }
}
