package br.com.railvista.RailVista.Repository;

import br.com.railvista.RailVista.Entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainRepository extends JpaRepository<Train, UUID> {
}
