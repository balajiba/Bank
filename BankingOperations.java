package Account;

public class BankingOperations {
	
	double balance;
	int accountType;
	public BankingOperations(Account account)
	{
		
	}
	public boolean accountWithDraw(double amount)
	{
		if((balance-amount)<amount)
		{
			System.out.println("Insufficient Balance");
			return false;
		}
		else
		{
			balance=balance-amount;
			System.out.println("Withdraw Success");
			return true;
		}
		
	}

	public boolean accountDeposit(double amount) 
	{
		balance=balance+amount;
		return true;
		
	}

	
	public boolean fundTrasfer(Account account, double amount)
	{
		if((balance-amount)<1000)
		{
			System.out.println("Insufficient Balance");
			return false;
		}
		else
		{
			balance=balance-amount;
			account.setBalance(amount);
			return true;
			
		}
	}


}
