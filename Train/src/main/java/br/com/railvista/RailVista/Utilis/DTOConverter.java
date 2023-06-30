package br.com.railvista.RailVista.Utilis;

import br.com.railsUtils.DTO.TrainDTO;
import br.com.railvista.RailVista.Entities.Train;

public class DTOConverter {

    public static TrainDTO convert(Train train){
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setId(train.getId());
        trainDTO.setNumberOfPassagers(train.getNumberOfPassagers());
        trainDTO.setWagons(train.getWagons());
        trainDTO.setValueOfTicket(train.getValueOfTicket());
        return trainDTO;
    }
}
