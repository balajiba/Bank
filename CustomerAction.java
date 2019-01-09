package Customer;
import java.util.Scanner;
import Branch.Branch;
import Manager.ManagerAction;

public class CustomerAction 
{
	//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	Scanner sc=new Scanner(System.in);
	static int indexValue=0;
	static int customerId=100;
	int option=0;
	ManagerAction manager=new ManagerAction();
	
	
	
	public void createNewCustomerAccount() 
	{
		System.out.println("Select Branch");
		
		int branchId=selectBranch();

		System.out.println("Slect Account Type");
		int accountType=selectAccountType();
		
		System.out.println("Enter Your Name");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Aadhar Number");
		String aadharNumber=sc.nextLine();
		
		if(!manager.checkAlreadyExistingCustomer(aadharNumber))
		{
			System.out.println("Enter Your MailId");
			String mailId=sc.nextLine();
			System.out.println("Enter Mobile Number");
			String mobileNumber=sc.nextLine();
		
			System.out.println("Enter password");
			String password=sc.nextLine();
		
			System.out.println("Enter Confirm Password");
			String confirmPassword=sc.nextLine();
			if(password.equals(confirmPassword))
			{
				customerId++;
				Customer newCustomer= new Customer(customerId,name,password,aadharNumber,mailId,mobileNumber);
	
				if(manager.addNewCustomer(newCustomer))
				{
					System.out.println("your customer id is "+customerId);
					System.out.println("Enter Initial Amount to Deposit");
					double amount=sc.nextDouble();
					if(accountType==2 && amount<1000)
					{
						System.out.println("Savings Account Must Maintain minimun Amount rs.1000");
						createNewCustomerAccount();
					}
					else
					{
						manager.addAccount(customerId,accountType,branchId,amount);
						createNewCustomerAccount();
					}
				}
				
		
			}
		else
			{
				System.out.println("Password Must Same");
			
			}
		}
		else
		{
			System.out.println("You have Already Account");
			System.out.println("Please Make Account your Exisiting Account");
			customerLogin();
		}
	
	}
	
//select branches
	
	public int selectBranch()
	{
		for(Branch list:ManagerAction.branchList)
		{
			System.out.println(list.getBranchId()+"."+list.getBranchName());
		}
		int branchId=readInt(0,ManagerAction.branchList.size());
		return branchId;
	}
	
//select Account type
	public int selectAccountType()
	{
		System.out.println("1.Current Account");
		System.out.println("2.Savings Account");
		System.out.println("3.Loan Account");
		
		int accounttype=readInt(0,3);
		return accounttype;
		
	}
	
	
//Existing Customer Login
	
	public void customerLogin()
	{
		System.out.println("Enert Customer Id");
		int userId=sc.nextInt();
		System.out.println("Enter Password");
		sc.nextLine();
		String password=sc.nextLine();
		
		if(manager.customerLoginValidation(userId,password))
		{
			customerOperation();
		}
		else
		{
			System.out.println("Incorrect Id or Password");
		}
	}

	
	public void customerOperation()

	{
		
		System.out.println("1.Banking");
		System.out.println("2.View Account Summary");
		System.out.println("3.View Profile");
		System.out.println("4.Add Account");
		System.out.println("5.Logout");
		
		option=readInt(0,5);
		switch(option)
		{
			case 1:
				bankingOperations();
				break;
			case 2:
				viewAccountSummary();
				break;
			case 3:
				viewProfile();
				break;
			case 4:
				addAccount();
				break;
			case 5:
				break;
		}
		
		
	}
	
	
	
	
	
	
	
	
	private void addAccount() {
		
		
	}

	private void viewProfile() {
	
		
	}

	private void viewAccountSummary() {
		
		
	}

	private void bankingOperations() 
	{
		System.out.println("1.Cash WithDraw");
		System.out.println("2.Cash Deposit");
		System.out.println("3.Money Transfer to Another Account");
		System.out.println("4.Main Menu");
		option=readInt(0,4);
		switch(option)
		{
		case 1:
			makeCashWithdraw();
			break;
		case 2:
			makeCashDeposit();
			break;
		case 3:
			makeCashTransfer();
			break;
			
		}
	}
	

	private void makeCashTransfer() 
	{
		
		
	}

	private void makeCashDeposit() 
	{
		
		
	}

	private void makeCashWithdraw() 
	{
	
		
	}

	public  int readInt(int min,int max)
	{
		
		boolean stop=false;
		int choice = 0;
		while(!stop)
		{
			try
			{
				choice=sc.nextInt();
				if(choice>=min && choice<=max)
				{
					stop=true;
					break;
					
				}
				else
				{
					System.out.println("Enter Correct Input");
				}
			}catch(Exception e)
			{
				System.out.println("Enter Valid Number");
			}
		}
		return choice;
	}

}
