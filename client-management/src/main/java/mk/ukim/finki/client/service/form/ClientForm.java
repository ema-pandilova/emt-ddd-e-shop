package mk.ukim.finki.client.service.form;

import lombok.Data;
import mk.ukim.finki.sharedkernel.domain.address.Address;

@Data
public class ClientForm {
    private String name;
    private int embg;
    private String phoneNumber;
    private String email;
    private Address address;
}
