package mk.ukim.finki.client.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.client.domain.models.Client;
import mk.ukim.finki.client.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientResource {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllUsers() {
        return clientService.getAllClients();
    }

}