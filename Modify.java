package app;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class Modify extends Frame implements ActionListener 
{Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
Button b1,b2;
Font f,f1;
public Modify()
{
	l1=new Label("Pnr_no");
	l2=new Label("Pr_name");
	l3=new Label("Sector");
	l4=new Label("F_no");
	l5=new Label("Class");
	l6=new Label("Date");
	l7=new Label("Status_no");
	l8=new Label("WL_no");
	l9=new Label("DOI");
	l10=new Label("R_Status");
	l11=new Label("Fare");
	l12=new Label("Modification");
	t1=new TextField(20);
	t2=new TextField(20);
	t3=new TextField(20);
	t4=new TextField(20);
	t5=new TextField(20);
	t6=new TextField(20);
	t7=new TextField(20);
	t8=new TextField(20);
	t9=new TextField(20);
	t10=new TextField(20);
	t11=new TextField(20);
	b1=new Button("OK");
	b2=new Button("Cancel");
	setLayout(null);
	f=new Font("Mono Corsiva",Font.ITALIC/Font.BOLD,20);
	setFont(f);
	f1=new Font("Mono Corsiva",Font.ITALIC/Font.BOLD,80);
	l12.setFont(f1);
	l12.setBounds(50,50,450,100);
	l1.setBounds(50,150,100,30);
	t1.setBounds(150,150,100,30);
	l2.setBounds(50,200,100,30);
	t2.setBounds(150,200,100,30);
	l3.setBounds(50,250,100,30);
	t3.setBounds(150,250,100,30);
	l4.setBounds(50,300,100,30);
	t4.setBounds(150,300,100,30);
	l5.setBounds(50,350,100,30);
	t5.setBounds(150,350,100,30);
	l6.setBounds(50,400,100,30);
	t6.setBounds(150,400,100,30);
	l7.setBounds(50,450,100,30);
	t7.setBounds(150,450,100,30);
	l8.setBounds(50,500,100,30);
	t8.setBounds(150,500,100,30);
	l9.setBounds(50,550,100,30);
	t9.setBounds(150,550,100,30);
	l10.setBounds(50,600,100,30);
	t10.setBounds(150,600,100,30);
	l11.setBounds(50,650,100,30);
	t11.setBounds(150,650,100,30);
	b1.setBounds(50,700,100,30);
	b2.setBounds(150,700,70,30);
	add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
	add(l7);add(l8);add(l9);add(l10);add(l11);add(l12);
	add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
	add(t7);add(t8);add(t9);add(t10);add(t11);
	add(b1);add(b2);
	b1.addActionListener(this);
	b2.addActionListener(this);
}
	public void actionPerformed(ActionEvent ac)
	{
		if(ac.getSource()==b2)
		{
			System.exit(1);
		}
	}
	public static void main(String[] args) {
		Modify obj=new Modify();
		obj.setSize(1000,1000);
		obj.setVisible(true);
		obj.setBackground(Color.cyan);

	}

}
