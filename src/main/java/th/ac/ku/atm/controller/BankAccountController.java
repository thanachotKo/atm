package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.accountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model){
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }

    @GetMapping("/deposit/{id}")
    public String getDepositBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-deposit";
    }

    @GetMapping("/withdraw/{id}")
    public String getWithdrawBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-withdraw";
    }

    @PostMapping("/deposit/{id}")
    public String depositAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {
        accountService.depositBankAccount(bankAccount, accountService.getBankAccount(id).getBalance());
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {
        accountService.withDrawBankAccount(bankAccount, accountService.getBankAccount(id).getBalance());
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id,
                                @ModelAttribute BankAccount bankAccount,
                                Model model) {
        accountService.deleteBankAccount(bankAccount);
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }
}
