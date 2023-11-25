package or.sid.bankaccountservice.services;

import or.sid.bankaccountservice.dto.BankAccountRequestDTO;
import or.sid.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequest);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequesters);

     void deleteAccount(String id);
}
