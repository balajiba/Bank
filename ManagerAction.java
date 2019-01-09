package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Account.Account;
import Branch.Branch;
import Customer.Customer;

public class ManagerAction {
	
	
	
	private HashMap<Integer,ArrayList<Account>> customerAccount=new HashMap<>();
	public static ArrayList<Branch> branchList=new ArrayList<>();
	HashMap<Integer, Customer> customerList=new HashMap<>();
	static int branchId=5;
	static int accountNumber=100000;
	
	Scanner sc=new Scanner(System.in);
	static
	{
		branchList.add(new Branch(1,"Adayar"));
		branchList.add(new Branch(2,"Egmore"));
		branchList.add(new Branch(3,"Potheri"));
	}
	
//	public  void managerLogin()
//	{
//		bankmanager=new BankManager();
//		boolean stop=false;
//		
//		while(!stop)
//		{
//		System.out.println("Enter Manager Name");
//		String name=sc.nextLine();
//		System.out.println("Enter your Password");
//		String password=sc.nextLine();
//		
//		if(name.equals(managerName)&&password.equals(managerPassword))
//			{
//				bankmanager.bankManagerMenu();
//				stop=true;
//			}
//		else
//		{
//			System.out.println("Incorrect Name/Password");
//		}
//		
//		}
//		
//		
//	}
	
	
	
	
	public void addBranch()

	{
		String branchName=sc.nextLine();
		branchList.add(new Branch(branchId,branchName));
		branchId++;
	}
	
//check customer login access	
	
	public boolean customerLoginValidation(int custId,String password)
	{
		
		boolean flag=false;
		for(Map.Entry<Integer,Customer> cust:customerList.entrySet())
		{
			Customer value=cust.getValue();
			if(value.getCustomerId()==custId && value.getpassword().equals(password))
					{
					 flag=true;
					 break;
					}
		}
		if(flag)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	
	
//check customer already have an account	
	public boolean checkAlreadyExistingCustomer(String aadharNumber)
	{
		
		boolean flag=false;
		for(Map.Entry<Integer,Customer> cust:customerList.entrySet())
		{
			Customer value=cust.getValue();
			if(value.getaadharNumber().equals(aadharNumber))
					{
					 flag=true;
					 break;
					}
		}
		if(flag)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	
	
	
	public boolean addNewCustomer(Customer cus)
	{
		customerList.put(cus.getCustomerId(),cus);
		return true;
	}	
	
	
	
	public int generteAccountNumber()
	{
		return accountNumber++;
	}
	
	
	public boolean addAccount(int customerId,int accountType,int branchId,double balance)
	{
	
		accountNumber=generteAccountNumber();
		
		Account account=new Account(accountNumber,accountType,branchId,balance);
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		if(customerAccount.containsKey(customerId))
		{
		
			accountList = customerAccount.get(customerId);
			accountList.add(account);
			System.out.println("new customer");
			System.out.println(accountList.get(customerId));
		}
		else 
		{
		accountList.add(account);
		customerAccount.put(customerId, accountList);
		
		System.out.println("success");
		
		for(Map.Entry<Integer,ArrayList<Account>> map:customerAccount.entrySet())
		{
			for(Account ac:map.getValue())
			
			System.out.println(ac.getAccountNumber()+" "+ac.getAccountType()+" "+ac.getBalance()+" "+ac.getBranchId() );
		}
		
		
		}
		
		return true;
	}
	
}
