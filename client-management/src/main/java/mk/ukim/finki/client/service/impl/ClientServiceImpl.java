package mk.ukim.finki.client.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.client.domain.exception.ClientNotFoundException;
import mk.ukim.finki.client.domain.models.Client;
import mk.ukim.finki.client.domain.models.ClientId;
import mk.ukim.finki.client.domain.repository.ClientRepository;
import mk.ukim.finki.sharedkernel.domain.address.Address;
import mk.ukim.finki.client.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> getClientById(ClientId clientId) {
        return clientRepository.findById(clientId);
    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(String name, int embg, String phoneNumber, String email, Address address) {
        Client client = Client.build(name, embg, phoneNumber, email, address);
        return clientRepository.save(client);
    }

    @Override
    public void updateClient(ClientId client) {
        Client client1=clientRepository.findById(client).orElseThrow(ClientNotFoundException::new);
        clientRepository.save(client1);
    }



    @Override
    public void deleteClient(ClientId clientId) {
        clientRepository.deleteById(clientId);
    }


}