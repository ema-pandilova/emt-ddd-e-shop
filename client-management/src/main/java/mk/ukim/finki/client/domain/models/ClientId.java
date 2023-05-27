package mk.ukim.finki.client.domain.models;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class ClientId extends DomainObjectId {
    private ClientId() {
        super(ClientId.randomId(ClientId.class).getId());
    }

    public ClientId(String uuid) {
        super(uuid);
    }

    public static ClientId of(String uuid) {
        return new ClientId(uuid);
    }
}