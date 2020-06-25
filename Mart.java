import java.awt.*;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.sun.jdi.connect.spi.Connection;

public class Mart extends JFrame implements ItemListener, ActionListener {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Choice typ, qua;
	List itm, pri, selt, seli, selp, selq, total, quap;
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	TextField gtotal, u;
	JButton b1;
	int t;
	String l;

	Mart(final String g) {
		l = g;

		setExtendedState(MAXIMIZED_BOTH);

		setLayout(null);
		typ = new Choice();
		typ.setBounds(225, 220, 100, 30);
		qua = new Choice();
		qua.setBounds(225, 500, 100, 50);
		quap = new List(10);
		itm = new List(10);
		itm.setBounds(100, 300, 100, 130);
		pri = new List(10);
		pri.setBounds(350, 300, 100, 130);
		selt = new List(10);
		selt.setBounds(800, 250, 100, 150);
		seli = new List(10);
		seli.setBounds(900, 250, 100, 150);
		selp = new List(10);
		selp.setBounds(1000, 250, 100, 150);
		selq = new List(10);
		selq.setBounds(1100, 250, 100, 150);
		total = new List(10);
		quap.setBounds(1200, 250, 100, 150);
		gtotal = new TextField(10);
		gtotal.setBounds(900, 450, 100, 30);

		b1 = new JButton("Logout");
		b1.setBounds(1100, 450, 100, 30);
		add(b1);
		l1 = new Label("Select type of product");
		l1.setFont(new Font("Arial", Font.BOLD, 17));
		l1.setBounds(175, 180, 200, 30);
		add(l1);
		add(typ);
		add(itm);
		typ.add("~~Select~~");
		typ.add("Soap");
		typ.add("Chocolate");
		typ.add("Shampoo");
		typ.add("Chips");
		typ.add("Rice");
		typ.add("Grains");
		typ.add("Juices");
		typ.add("BodySprays");
		typ.add("FaceWash");
		l2 = new Label("Select Type of Item");
		l2.setFont(new Font("Arial", Font.BOLD, 15));
		l2.setBounds(80, 260, 180, 30);
		add(l2);
		add(pri);
		l3 = new Label("Price (Rs)");
		l3.setFont(new Font("Arial", Font.BOLD, 15));
		l3.setBounds(350, 260, 180, 30);
		add(l3);
		l4 = new Label("Select Quantity");
		l4.setFont(new Font("Arial", Font.BOLD, 15));
		l4.setBounds(225, 450, 160, 50);
		add(l4);
		l5 = new Label("Product");
		l5.setFont(new Font("Arial", Font.BOLD, 12));
		l5.setBounds(800, 220, 100, 20);
		l6 = new Label("Item");
		l6.setFont(new Font("Arial", Font.BOLD, 12));
		l6.setBounds(900, 220, 100, 20);
		add(l6);
		add(l5);
		l7 = new Label("Price");
		l7.setFont(new Font("Arial", Font.BOLD, 12));

		l7.setBounds(1000, 220, 100, 20);
		add(l7);
		l8 = new Label("Quantity");
		l8.setFont(new Font("Arial", Font.BOLD, 12));
		l8.setBounds(1100, 220, 100, 20);
		add(l8);
		l9 = new Label("Total price");
		l9.setFont(new Font("Arial", Font.BOLD, 12));
		l9.setBounds(1200, 220, 100, 20);
		add(l9);
		l10 = new Label("Grand Total");
		l10.setFont(new Font("Arial", Font.BOLD, 15));
		l10.setBounds(800, 450, 100, 30);
		add(l10);
		l11 = new Label("BILLING DETAILS");
		l11.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		l11.setBounds(800, 100, 200, 30);
		add(l11);
		l12 = new Label("PRODUCT DETAILS");
		l12.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		l12.setBounds(130, 100, 200, 30);
		add(l12);
		l13 = new Label("Username");
		l13.setBounds(800, 150, 100, 30);
		l13.setFont(new Font("Arial", Font.BOLD, 16));
		add(l13);
		u = new TextField(20);
		u.setText(l);
		u.setBounds(900, 150, 100, 30);
		add(u);
		add(qua);
		for (int i = 0; i <= 30; i++) {
			qua.add(Integer.toString(i));
		}
		add(selt);
		add(seli);
		add(selp);
		add(selq);
		add(quap);
		add(gtotal);
		add(b1);
		setVisible(true);
		b1.addActionListener(this);
		typ.addItemListener(this);
		itm.addItemListener(this);
		pri.addItemListener(this);
		qua.addItemListener(this);
		selt.addItemListener(this);
		seli.addItemListener(this);
		selp.addItemListener(this);
		selq.addItemListener(this);
		total.addItemListener(this);
		pri.setEnabled(false);
		selt.setEnabled(false);
		seli.setEnabled(false);

		selp.setEnabled(false);
		selq.setEnabled(false);
	}

public void itemStateChanged1(final ItemEvent e)
{ 
	String s1 = null,s2=null,s3=null;

	if(e.getSource()==typ){
	itm.removeAll();
	pri.removeAll();
	if(typ.getSelectedItem().equals("Soap"))
	{
//	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mart", "root","");
//	String sql="select * from product where ptype=?"; pst=conn.prepareStatement(sql); pst.setString(1,s1);
//	rs=pst.executeQuery();
	try
	{
	s1= "Soap";
	while(rs.next()) { s1=rs.getString("ptype"); s3=rs.getString("pprice"); itm.add(s2); pri.add(s3); } } catch(Exception ex)
	{
	System.out.println(ex);
	}
	}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
}
}
	
	