class Account(private var balance: Double) {

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive.")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive.")
    require(amount <= balance, "Insufficient funds.")
    balance -= amount
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive.")
    withdraw(amount)  
    toAccount.deposit(amount)  
  }

  def getBalance: Double = balance

  override def toString: String = "Balance: "+balance
}

object Main extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

  println("Initial account1 balance: "+account1.getBalance)  
  println("Initial account2 balance: "+account2.getBalance)  

  account1.deposit(200.0)
  println("After depositing "+200+" to account1: "+account1.getBalance)  

  account1.withdraw(150.0)
  println("After withdrawing "+150+"from account1: "+account1.getBalance) 

  account1.transfer(300.0, account2)
  println("After transferring "+300+" from account1 to account2 : ")
  println("account1 balance: "+account1.getBalance)  
  println("account2 balance: "+account2.getBalance)  
}