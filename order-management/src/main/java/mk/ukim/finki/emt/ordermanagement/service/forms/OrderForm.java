package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    @NotNull
    private Currency currency;//ova pole da ne bide prazno

    @Valid
    @NotEmpty
    //lista od stavki sto gi dodal korisnikot
    private List<OrderItemForm> items = new ArrayList<>();
}
