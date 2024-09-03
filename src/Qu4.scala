object BankAccount{

  class Account(val id: String, private var balance: Double) {

    def deposit(amount: Double): Unit = {
      if (amount > 0) balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) balance -= amount
    }

    def transfer(amount: Double, targetAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount)
        targetAccount.deposit(amount)
      }
    }

    def getBalance: Double = balance

    def applyInterest(): Unit = {
      if (balance > 0) balance += balance * 0.05
      else balance += balance * 0.10
    }

    override def toString: String = s"Account(id=$id, balance=$balance)"
  }

  class Bank(val accounts: List[Account]) {

    // 4.1 List of Accounts with negative balances
    def accountsWithNegativeBalances: List[Account] = {
      accounts.filter(_.getBalance < 0)
    }

    // 4.2 Calculate the sum of all account balances
    def totalBalance: Double = {
      accounts.map(_.getBalance).sum
    }

    // 4.3 Apply interest to all accounts and return their final balances
    def applyInterestToAll(): List[Double] = {
      accounts.foreach(_.applyInterest())
      accounts.map(_.getBalance)
    }
  }

  def main(args: Array[String]): Unit = {
    // Create some accounts
    val account1 = new Account("001", 500.0)
    val account2 = new Account("002", -100.0)
    val account3 = new Account("003", 0.0)
    val account4 = new Account("004", -50.0)

    // Create a bank with the list of accounts
    val bank = new Bank(List(account1, account2, account3, account4))

    // 4.1 List of Accounts with negative balances
    println("Accounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(println)

    // 4.2 Calculate the sum of all account balances
    println(s"Total balance of all accounts: ${bank.totalBalance}")

    // 4.3 Apply interest to all accounts and calculate final balances
    println("Final balances after applying interest:")
    bank.applyInterestToAll().foreach(println)
  }
}
