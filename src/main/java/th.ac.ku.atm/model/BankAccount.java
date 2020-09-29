package th.ac.ku.atm.model;

public class BankAccount {
    private int id;
    private String customerId;
    private String type;
    private double balance;

    public BankAccount(int id, String customerId, String type, double balance) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }

    public int getIdBank() {
        return id;
    }

    public String getCustomerIdBank() {
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

    public void setCustomerIdBank(String customerId) {
        this.customerId = customerId;
    }

    public void setTypeBank(String type) {
        this.type = type;
    }


}
