import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
public class Login1 extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1,b2;
	ResultSet res=null;
	Statement stmt=null;
	Connection con=null;
	public Login1()
	{
		l1=new Label("UserID");
		l2=new Label("Password");
		t1=new TextField(20);
		t2=new TextField(20);
		b1=new Button("Login");
		b2=new Button("Exit");
		setLayout(null);
		l1.setBounds(25,50,50,25);
		t1.setBounds(100,50,70,25);
		l2.setBounds(25,80,70,25);
		t2.setBounds(100,80,70,25);
		b1.setBounds(25,110,50,25);
		b2.setBounds(100,110,50,25);
		add(l1);add(t1);add(l2);add(t2);add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ac)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:odbc:thin:@localhost:1521:xe","system","arush.1998");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e)
		{
			System.out.println("Error1");
		}
		if(ac.getSource()==b1)
		{
			try
			{
				res=stmt.executeQuery("Select * from lg1");
				while(res.next())
				{
					String s1,s2;
					s1=t1.getText();
					s2=t2.getText();
					if(s1.equals(res.getString(1)) && s2.equals(res.getString(2)))
					{
						System.out.println("Successful");
					}else
						System.out.println("Unsuccessful");
				}
			}
			catch(Exception e1)
			{
				System.out.println("Error2");
			}
		}
		if(ac.getSource()==b2)
		{
			System.exit(1);
		}
	}
	public static void main(String args[])
	{
		Login1 obj=new Login1();
		obj.setSize(200,300);
		obj.setVisible(true);
	}

}
