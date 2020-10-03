package th.ac.ku.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {

    private int id;
    private int customerId;
    private String type;
    private double balance;

    public BankAccount(int id, int customerId, String type, double balance) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }

    public int getIdBank() {
        return id;
    }

    public int getCustomerIdBank() {
        return customerId;
    }

    public String getTypeBank() {
        return type;
    }

    public double getBalanceBank() {
        return balance;
    }

    public void setBalanceBank(double balance) {
        this.balance = balance;
    }

    public void setIdBank(int id) {
        this.id = id;
    }

    public void setCustomerIdBank(int customerId) {
        this.customerId = customerId;
    }

    public void setTypeBank(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
