package br.com.railvista.Maintenance.UseCase;

import br.com.railsUtils.DTO.TrainDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class TrainService {

    private String trainApiURL = "http://localhost:8080";

    public TrainDTO getTrainById(UUID id){
        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(trainApiURL)
                    .build();

            Mono<TrainDTO> train = webClient.get()
                    .uri("/train/" + id)
                    .retrieve()
                    .bodyToMono(TrainDTO.class);
            return train.block();
        }catch (Exception e){
            throw new RuntimeException("Trem não existe");
        }
    }
}
