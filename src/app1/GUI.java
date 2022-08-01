package app1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GUI {


	public static void converter()
	{
		
		
		ArrayList<Currency> currencyList= new ArrayList<Currency>();
		ArrayList<Rates> RatesList= new ArrayList<Rates>();
		
		// Creating a new frame using JFrame
		JFrame f = new JFrame("Currency Exchange");

		// Creating  labels
		JLabel Symbol, CurrencyName, RateToUpdate,NewRate,Amount ,Rate , onee;
		JLabel line1,line2,line3,line4;
		// Creating  Text Field

		JTextField TextSymbol, TextCurrencyName ,TextRate ,TextNewRate,TextAmount;

		// Creating  buttons
		JButton AddCurrency, AddRate, Update ,Add , Remove;
		
		// Creating  Text Area
		JTextArea resulte ;
		
		// Creating  Combo Box
		JComboBox firstCurrency  ,secondCurrency ,rateCurrencyUpdate,rateToAdd;
////////////////////////////////////////////
		
		//   Add Lines
		
		line1=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		line1.setBounds(0, 95, 950, 10);
		line2=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		line2.setBounds(0, 175, 950, 10);
		line3=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		line3.setBounds(0, 255, 950, 10);
		line4=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		line4.setBounds(0, 335, 950, 10);
		
		
		// Naming the labels and setting
		// the bounds for the labels
		
		//               Part 1
		
		Symbol = new JLabel("Symbol :");
		Symbol.setBounds(220, 40, 60, 30);
		
		TextSymbol = new JTextField("$");
		TextSymbol.setBounds(290, 40, 50, 30);
		
		CurrencyName = new JLabel("Currency Name : ");
		CurrencyName.setBounds(350, 40, 100, 30);
		
		TextCurrencyName = new JTextField("");
		TextCurrencyName.setBounds(455, 40, 205, 30);
		
		AddCurrency = new JButton("Add Currency");
		AddCurrency.setBounds(735, 40, 125, 25);
		
		//               Part 2
		
		 onee = new JLabel("1 ");
		 onee.setBounds(140, 120, 30, 30);
		 
		 firstCurrency = new JComboBox();
		 firstCurrency.setBounds(160, 120, 200, 30);
		 
		 TextRate =new JTextField("1");
		 TextRate.setBounds(375, 120, 50, 30);
		 
		 secondCurrency = new JComboBox();
		 secondCurrency.setBounds(435, 120, 200, 30);
		 
		 AddRate = new JButton("Add Rate");
		AddRate.setBounds(735, 120, 125, 25);

		//               Part 3
		
		RateToUpdate = new JLabel("Rate To Update ");
		RateToUpdate.setBounds(145, 200, 100, 30);
		
		rateCurrencyUpdate = new JComboBox();
		rateCurrencyUpdate.setBounds(250, 200, 250, 30);
		
		 NewRate = new JLabel("New Rate ");
		 NewRate.setBounds(550, 200, 80, 30);
		 
		 TextNewRate =new JTextField("");
		 TextNewRate.setBounds(620, 200, 50, 30);
		 
		 Update = new JButton("Update");
		 Update.setBounds(735, 200, 125, 25);
		 
	   //               Part 4
		 
		 Amount = new JLabel("Amount ");
		 Amount.setBounds(200, 280, 100, 30);
		 
		 TextAmount =new JTextField("0");
		 TextAmount.setBounds(260, 280, 60, 30);
		 
		 Rate = new JLabel("Rate");
		 Rate.setBounds(340, 280, 50, 30);
		 
		 rateToAdd = new JComboBox();
		 rateToAdd.setBounds(380, 280, 290, 30);
		 
		 Add = new JButton("Add");
		 Add.setBounds(735, 280, 120, 25);
		 
	  //               Part 5
		 resulte =new JTextArea();
		 resulte.setBounds(130, 370, 590, 140);
		 
		

		 Remove = new JButton("Remove");
		 Remove.setBounds(735, 425, 125, 25);
		 
		 Font font = new Font("Verdana", Font.BOLD, 14);
		 resulte.setFont(font);
		 resulte.setForeground(Color.BLUE);
		 resulte.setEditable(false);
		 
/////////////////////////////////////////////
		
		
		// Adding action listener  for Button Add Currency
		 
		 
		AddCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				if(TextCurrencyName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(f,
						    "Name is empty",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				    
				}
				else {
				
				Currency newCurrency =new Currency() ;
				newCurrency.setSymbol(TextSymbol.getText());
				newCurrency.setName(TextCurrencyName.getText());
				boolean test =true;
				
				for (Currency k :currencyList)
				{
					if (newCurrency.getName().equals(k.getName()))
					{
						 JOptionPane.showMessageDialog(f,
								    "This  currency exists",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						    test=false;
					}
					
				}
				if (test) {
				currencyList.add(newCurrency);
				TextSymbol.setText("$");
				TextCurrencyName.setText("");
				firstCurrency.addItem(newCurrency.getName()+"("+newCurrency.getSymbol()+")");
				secondCurrency.addItem(newCurrency.getName()+"("+newCurrency.getSymbol()+")");
				}
			}
			}
		});
		
		// Adding action listener  for Button Add Rate
		 
		 
		AddRate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						
						
						int te=firstCurrency.getSelectedIndex();

						if (te>=0)
						{
						String firstCurr=(String) firstCurrency.getSelectedItem();
						String secondCurr=(String) secondCurrency.getSelectedItem();
						
						
						
						if (firstCurr.equals(secondCurr))
						{
							JOptionPane.showMessageDialog(f,
								    "You chose the same currency on both sides",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						}
						
						else {
						
						boolean test =isNumeric(TextRate.getText());
						
						
						if (test)
						{
							//RatesList
							double ratee=Double.parseDouble(TextRate.getText());  
							
							Rates newRate =new Rates();
							newRate.setfirstCurren(firstCurr);
							newRate.setsecondCurren(secondCurr);
							newRate.setRate(ratee);
							boolean test2=false;
							for (Rates k:RatesList)
							{
								if (newRate.getfirstCurren().equals(k.getfirstCurren())&&newRate.getsecondCurren().equals(k.getsecondCurren()))
								
								{
									 JOptionPane.showMessageDialog(f,
											    "This  Rate  exists !",
											    "Error",
											    JOptionPane.ERROR_MESSAGE);
									    test2=true;
									
								}
							}
							
							if(!test2)
							{
							RatesList.add(newRate);
							rateCurrencyUpdate.addItem("  1  "+newRate.getfirstCurren()+" = "+TextRate.getText()+"  "+newRate.getsecondCurren());
							rateToAdd.addItem("  1  "+newRate.getfirstCurren()+" = "+TextRate.getText()+"  "+newRate.getsecondCurren());
							
							TextRate.setText("");
							}
							
						}
						
						else 
						{
							JOptionPane.showMessageDialog(f,
								    "This  input is not Number",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							
						}
						
					}
						
					}
						
						else {
							JOptionPane.showMessageDialog(f,
								    "Add a currency first",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							
							
						}
					}
						
				});
				
				
		// Adding action listener  for Button Update
		 
		 
		Update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						int te=rateCurrencyUpdate.getSelectedIndex();

						if (te>=0)
						{
							
						Rates UpdateCurrency =new Rates() ;

						int ind=rateCurrencyUpdate.getSelectedIndex();
                        boolean test =isNumeric(TextNewRate.getText());
						
						
						if (test)
						{
							//RatesList
							double newratee=Double.parseDouble(TextNewRate.getText());  
							
									UpdateCurrency.setfirstCurren(RatesList.get(ind).getfirstCurren());
									UpdateCurrency.setsecondCurren(RatesList.get(ind).getsecondCurren());
									UpdateCurrency.setRate(RatesList.get(ind).getRate());

									RatesList.remove(ind);
									rateCurrencyUpdate.removeItemAt(ind);
									rateToAdd.removeItemAt(ind);
									
							
							UpdateCurrency.setRate(newratee);
							RatesList.add(UpdateCurrency);
							rateCurrencyUpdate.addItem("  1  "+UpdateCurrency.getfirstCurren()+" = "+TextNewRate.getText()+"  "+UpdateCurrency.getsecondCurren());
							rateToAdd.addItem("  1  "+UpdateCurrency.getfirstCurren()+" = "+TextNewRate.getText()+"  "+UpdateCurrency.getsecondCurren());
							
							TextNewRate.setText("");
							
							
							
							
						}
						else 
						{
							JOptionPane.showMessageDialog(f,
								    "This  input is not Number",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							
						}
						
					}
					
					else {
						JOptionPane.showMessageDialog(f,
							    "Add a Rate first",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						
						
					}
					}
				});
				
		// Adding action listener  for Button Add
		 
		 
		Add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						int te=rateToAdd.getSelectedIndex();

						if (te>=0)
						{
							
						boolean test =isNumeric(TextAmount.getText());
						
						
						if (test)
						{
							int ind=rateToAdd.getSelectedIndex();
							Rates AddCurrency =new Rates() ;
							double Amount=Double.parseDouble(TextAmount.getText());  

							AddCurrency.setfirstCurren(RatesList.get(ind).getfirstCurren());
							AddCurrency.setsecondCurren(RatesList.get(ind).getsecondCurren());
							AddCurrency.setRate(RatesList.get(ind).getRate());
							double Result = Amount *AddCurrency.getRate();
							
							resulte.append(TextAmount.getText() +" "+AddCurrency.getfirstCurren() +" = "+ Result+ "  " +AddCurrency.getsecondCurren()+"\n");
							
							TextAmount.setText("");
							
							
						}
						else 
						{
							JOptionPane.showMessageDialog(f,
								    "This  input is not Number",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							
						}
						
	}
					
					else {
						JOptionPane.showMessageDialog(f,
							    "Add a Rate first",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						
						
					}
					
					}
				});
				
		// Adding action listener  for Button Remove
		 
		 
		Remove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						
						resulte.replaceSelection("");
						

						
					}
				});
				
		
		

		// Default method for closing the frame
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		// Adding the created objects to the form

		// part 1
		f.add(Symbol);
		f.add(TextSymbol);
		f.add(CurrencyName);
		f.add(TextCurrencyName);
		f.add(AddCurrency);
		f.add(line1);
		
		// part 2
		f.add(onee);
		f.add(firstCurrency);
		f.add(TextRate);
		f.add(secondCurrency);
		f.add(AddRate);
		f.add(line2);

		// part 3
		
		f.add(RateToUpdate);
		f.add(rateCurrencyUpdate);
		f.add(NewRate);
		f.add(TextNewRate);
		f.add(Update);
		f.add(line3);

		// part 4
		
		f.add(Amount);
		f.add(TextAmount);
		f.add(Rate);
		f.add(rateToAdd);
		f.add(Add);
		f.add(line4);

		// part 5
		
		f.add(resulte);
		f.add(Remove);

		 
  
		//////////////////////
		

		f.setLayout(null);
		f.setSize(950, 560);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	

	// Driver code
	public static void main(String args[])
	{
		converter();
	}
}
