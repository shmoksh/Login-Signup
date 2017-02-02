//Login and Signup
import java.util.*;
import java.io.*;
class Regs
{
	String log="";
	static int get=0;
	static String user="";
	static String pass="";
	static String user1="";
	static String pass1="";
	static Scanner val=new Scanner(System.in);
	public static void main(String[] args) throws Exception
	{
		System.out.println("\n"+"1.Signup"+"\t"+"2.Login on");
		get=val.nextInt();
		if(get==1)
		{
			signup();
		}
		else if(get==2) 
		{
			 login();
		}
		
	}
	public static void signup() throws Exception
	{
		    System.out.println("\t"+"Signup"+"\n");
			System.out.print("Username:");
			user=val.next();
			System.out.print("Password:");
			pass=val.next();
			FileReader fr=new FileReader("Registration.txt"); 
			FileWriter fw=new FileWriter("Registration.txt",true);
			BufferedReader br=new BufferedReader(fr);
			String User_name="";
			boolean flag=true;
			while((User_name=br.readLine())!=null)
			{
				String[] S=User_name.split(",");
				if(S[0].equals(user))
				{
					System.out.println("This username is already exist");
					flag=false;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("You are new for us");
				fw.write("\r\n");
				fw.write(user+","+pass);
				fw.close();
				login();
			}
		
	}
	public static void login() throws Exception
	{
		Scanner val1=new Scanner(System.in);
		System.out.println("\t"+"Login"+"\n");
		System.out.print("Enter your Registered Username:");
		user1=val1.next();
		System.out.print("Enter your Registered Password:");
		pass1=val1.next();
		FileReader fr1=new FileReader("Registration.txt");
		BufferedReader br1=new BufferedReader(fr1);
		String log="";
		while((log=br1.readLine())!=null)
		{
			String s1[]=log.split(",");
				if(s1[0].equals(user1)&&s1[1].equals(pass1)==true)
				{	
				  System.out.println("Login Successfull");
				} 
				else
				{
				  System.out.println("Your Login is Unsuccessfull Please try again");
				  login();
				}
		}	
	}
	
}
