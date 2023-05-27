package mk.ukim.finki.client.domain.repository;

import mk.ukim.finki.client.domain.models.Client;
import mk.ukim.finki.client.domain.models.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, ClientId> {
}
