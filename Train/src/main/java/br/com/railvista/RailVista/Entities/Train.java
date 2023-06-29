package br.com.railvista.RailVista.Entities;

import br.com.railsUtils.TrainDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int numberOfPassagers;
    private int wagons;
    private double valueOfTicket;


    public static Train convert(TrainDTO trainDTO){
        Train train = new Train();
        train.setWagons(trainDTO.getWagons());
        train.setNumberOfPassagers(trainDTO.getNumberOfPassagers());
        train.setValueOfTicket(trainDTO.getValueOfTicket());
        return train;
    }
}
