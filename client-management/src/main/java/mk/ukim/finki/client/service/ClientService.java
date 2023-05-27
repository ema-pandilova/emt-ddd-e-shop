package mk.ukim.finki.client.service;

import mk.ukim.finki.client.domain.models.Client;
import mk.ukim.finki.client.domain.models.ClientId;
import mk.ukim.finki.sharedkernel.domain.address.Address;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientById(ClientId clientId);

    List<Client> getAllClients();

    Client createClient(String name, int embg, String phoneNumber, String email, Address address);

    void updateClient(ClientId clientId);

    void deleteClient(ClientId clientId);
}
