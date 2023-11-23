package or.sid.bankaccountservice.enums;

import or.sid.bankaccountservice.entities.BankAccount;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
