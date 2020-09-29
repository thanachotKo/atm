package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount> bankAccountList;

    @PostConstruct
    public void postConstruct(){
        this.bankAccountList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount){
        String hashCustomerId = hash(bankAccount.getCustomerIdBank());
        bankAccount.setCustomerIdBank(hashCustomerId);
        bankAccountList.add(bankAccount);
    }

    public BankAccountService(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}