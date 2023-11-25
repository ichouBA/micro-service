package or.sid.bankaccountservice.web.BankAccountGraphqlController;

import or.sid.bankaccountservice.dto.BankAccountRequestDTO;
import or.sid.bankaccountservice.dto.BankAccountResponseDTO;
import or.sid.bankaccountservice.entities.BankAccount;
import or.sid.bankaccountservice.entities.Customer;
import or.sid.bankaccountservice.repositories.BankAccountRepository;
import or.sid.bankaccountservice.repositories.CustomerRepository;
import or.sid.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Struct;
import java.util.Date;
import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
       return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
       return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id){
         accountService.deleteAccount(id);
         return true;
    }
}

/* create an object (java 14+)
record BankAccountDTO(Double balance, String type, String currency){
} */