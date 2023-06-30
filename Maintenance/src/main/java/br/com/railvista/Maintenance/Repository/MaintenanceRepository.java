package br.com.railvista.Maintenance.Repository;

import br.com.railvista.Maintenance.Entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {
    public Maintenance findByTrainId(UUID id);
}
