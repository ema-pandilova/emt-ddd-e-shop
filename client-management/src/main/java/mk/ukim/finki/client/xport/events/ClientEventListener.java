package mk.ukim.finki.client.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.client.domain.models.ClientId;
import mk.ukim.finki.client.service.ClientService;
import mk.ukim.finki.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.sharedkernel.domain.events.clients.ClientCreated;
import mk.ukim.finki.sharedkernel.domain.events.clients.ClientDeleted;
import mk.ukim.finki.sharedkernel.domain.events.clients.ClientUpdated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientEventListener {

    private final ClientService clientService;

    @KafkaListener(topics= TopicHolder.TOPIC_CLIENT_CREATED, groupId = "client")
    public void consumeUserCreatedEvent(String jsonMessage) {
        try {
            ClientCreated event = DomainEvent.fromJson(jsonMessage,ClientCreated.class);
            clientService.createClient(event.getName(), event.getEmbg(), event.getPhoneNumber(), event.getEmail(), event.getAddress());
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_CLIENT_UPDATED, groupId = "client")
    public void consumeUserUpdatedEvent(String jsonMessage) {
        try {
            ClientUpdated event = DomainEvent.fromJson(jsonMessage,ClientUpdated.class);
            clientService.updateClient(ClientId.of(event.getUserId()));
        } catch (Exception e){
        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_CLIENT_DELETED, groupId = "client")
    public void consumeUserDeletedEvent(String jsonMessage) {
        try {
            ClientDeleted event = DomainEvent.fromJson(jsonMessage,ClientDeleted.class);
            clientService.deleteClient(ClientId.of(event.getUserId()));
        } catch (Exception e){

        }

    }
}