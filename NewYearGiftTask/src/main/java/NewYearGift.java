import java.util.*;
//Sweets class is parent class for choclates and candies
class Sweets
{
	static int no_of_chos;
	static int no_of_candies;
	int quan=0;
	public Sweets() {}
	public Sweets(int nchoco,int ncandi,int quantity)
	{
		no_of_chos=nchoco;
		no_of_candies=ncandi;
		quan=quantity;
	}
	public void cal_weight()
	{
		System.out.println("Total Weight:"+(no_of_chos+no_of_candies+quan));
	}

}
class Choclates extends Sweets
{
	String temp;
	Scanner sc=new Scanner(System.in);
	String names[]=new String[no_of_chos];
	public void input()
	{
		System.out.println("Enter the choclate names");
		for(int i=0;i<no_of_chos;i++)
		{
			names[i]=sc.nextLine();
		}
	}
	//Sorting the Chocolates
	public void sort(String ch)
	{
		for(int i = 0;i<no_of_chos-1; i++) 
		{
	         for (int j = i+1; j<names.length; j++) 
	         {
	            if(names[i].compareTo(names[j])>0) 
	            {
	               String temp = names[i];
	               names[i] = names[j];
	               names[j] = temp;
	            }
	         }
	      }
	if(ch.compareTo("d")<0)
		for(int i=0;i<no_of_chos;i++)
			System.out.println(names[i]);
	else
		for(int i=(no_of_chos-1);i>=0;i--)
			System.out.println(names[i]);
	}
}
//Defining Candies class to return the no_of_candies
class Candies extends Sweets
{
	public void count()
	{
		if(no_of_candies<=10 && no_of_candies>0)
			System.out.println("no. of candies lies in between 1 and 10: "+no_of_candies);
		else if(no_of_candies<=50 && no_of_candies>10)
			System.out.println("no. of candies lies in between 50 and 10: "+no_of_candies);
		else
			System.out.println("no. of candies greater than 50: "+no_of_candies);
 
	}
}
public class NewYearGift
{
public static void main(String arg[])
{
	Scanner sc=new Scanner(System.in);
	int nchoc,ncand,ch,nsweet;
	System.out.println("enter no. of gifts");
	int n=sc.nextInt();
	//System.out.println(n);
	for(int i=0;i<n;i++)
	{
			System.out.println("enter the things to keep in gift box "+(i+1));
			System.out.println("enter no. of sweets");
			nsweet=sc.nextInt();
			System.out.println("enter no. of candies");
			ncand=sc.nextInt();
			System.out.println("enter no. of choclates");
			nchoc=sc.nextInt();
			Sweets s1=new Sweets(nchoc,ncand,nsweet);
			Choclates c1=new Choclates();
			c1.input();
			while(true)
			{
				System.out.println("1.Total weight\n2.sorting the choclates\n3.no. of candies\n4.exit");
				ch=sc.nextInt();
				if(ch==1)
					s1.cal_weight();
				else if(ch==2)
				{
					if(nchoc==0)
						System.out.println("Zero choclates");
					else
					{
						System.out.println("enter 'a' for ascending order\n enter 'd' for descending order");
						String a=sc.next();
						c1.sort(a);
					}
				}
				else if(ch==3)
				{
					if(ncand==0)
						System.out.println("zero candies");
					else
					{
						Candies c2=new Candies();
						c2.count();
					}
				}
				else 
					break;
			}
			if(i+1==1)
				System.out.println((i+1)+" gift completed");
			else
				System.out.println((i+1)+" gifts completed");
	}
 
	}
}
