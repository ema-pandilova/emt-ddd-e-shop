package mk.ukim.finki.client.domain.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.address.Address;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "client")
@Getter
public class Client extends AbstractEntity<ClientId> {
    private String name;
    private int embg;
    private String phoneNumber;
    private String email;
    @Embedded
    private Address address;

    public Client() {
        super(ClientId.randomId(ClientId.class));
    }


    public static Client build(String name, int embg, String phoneNumber, String email, Address address) {
        Client user = new Client();
        user.name = name;
        user.embg = embg;
        user.phoneNumber = phoneNumber;
        user.email = email;
        user.address = address;
        return user;
    }
}