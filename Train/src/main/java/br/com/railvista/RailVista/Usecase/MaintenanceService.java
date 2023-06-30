package br.com.railvista.RailVista.Usecase;

import br.com.railsUtils.DTO.MaintenanceDTO;
import br.com.railsUtils.DTO.TrainDTO;
import br.com.railsUtils.Exceptions.MaintenanceNotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MaintenanceService {
    private String trainApiURL = "http://localhost:8081";

    public MaintenanceDTO getMaintenanceByIdTrain(UUID id) {
        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(trainApiURL)
                    .build();

            Mono<MaintenanceDTO> maintenance = webClient.get()
                    .uri("/maintenance/byTrainId/" + id)
                    .retrieve()
                    .bodyToMono(MaintenanceDTO.class);
            return maintenance.blockOptional().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}

