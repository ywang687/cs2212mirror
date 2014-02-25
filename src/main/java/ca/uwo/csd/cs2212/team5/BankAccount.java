package ca.uwo.csd.cs2212.jwang724;
 
public class BankAccount {
 
  private double balance;
 
  public BankAccount(double balance) {
    this.balance = balance;
  }
 
  public double debit(double amount) {
    if (balance < amount) {
      amount = balance;
    }
 
    balance -= amount;
    return amount;
  }
 
}
