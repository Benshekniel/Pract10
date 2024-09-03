object BankApp {
  class Account(val id: String, private var balance: Double) {

    // Method to deposit money into the account
    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited $$${amount} into account $id. New balance: $$${balance}")
      } else {
        println("Deposit amount must be positive.")
      }
    }

    // Method to withdraw money from the account
    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(s"Withdrew $$${amount} from account $id. New balance: $$${balance}")
      } else if (amount > balance) {
        println("Insufficient funds.")
      } else {
        println("Withdrawal amount must be positive.")
      }
    }

    // Method to transfer money from this account to another account
    def transfer(amount: Double, targetAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount)
        targetAccount.deposit(amount)
        println(s"Transferred $$${amount} from account $id to account ${targetAccount.id}.")
      } else {
        println("Transfer failed due to insufficient funds or invalid amount.")
      }
    }

    // Method to check the current balance
    def getBalance: Double = balance

    override def toString: String = s"Account(id=$id, balance=$balance)"
  }

  def main(args: Array[String]): Unit = {
    // Creating two accounts
    val account1 = new Account("001", 500.0)
    val account2 = new Account("002", 300.0)

    // Demonstrating the basic functions
    account1.deposit(200.0)  // Deposits 200 into account1
    account1.withdraw(100.0) // Withdraws 100 from account1

    // Transferring 150 from account1 to account2
    account1.transfer(150.0, account2)

    // Checking final balances
    println(s"Final balance in account 1: $$${account1.getBalance}")
    println(s"Final balance in account 2: $$${account2.getBalance}")
  }
}
