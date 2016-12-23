package Core_javaS6;


class M1 extends Thread
{
	bank s;
	M1(bank s)
	{
		this.s=s;
	}
	public void run()
	{
		s.deposit(1000);		
		
	}
	
}
class M2 extends Thread
{
	bank s;
	M1 m;
	M2(bank s,M1 m)
	{
		this.s=s;
		this.m=m;
	}
	public void run()
	{
		s.withrraw(500);
		
		
	}
	
}
public class bank {
	int bal=1000;
	synchronized void deposit(int amt)
	{
		int temp=bal;
		temp=temp+amt;
		try{Thread.sleep(2000);}
		catch(Exception e){}
		bal=temp;
		System.out.println("Accont Balance= "+bal);
	}
	
	synchronized void withrraw(int amt)
	{
		int temp_bal=bal;
		if(bal>amt)
		temp_bal=bal-amt;
		try{Thread.sleep(500);}
		catch(Exception e){}
		bal=temp_bal;
		System.out.println("Accont Balance= "+bal);
	}
	public static void main(String args[])
	{
		bank s=new bank();
		M1 m=new M1(s);
		m.start();
		M2 m1=new M2(s,m);
		m1.start();
		
	}

}
