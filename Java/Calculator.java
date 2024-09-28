import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Calculator implements ActionListener{
   JFrame frame;
   JTextField textField;
   JButton[] numberButtons = new JButton[10];
   JButton[] functionButtons = new JButton[9];
   JButton addButton,subButton,mulButton,divButton,decButton,equButton,clrButton, negButton;
   JPanel panel;
   
   Font myFont = new Font("Serif",Font.ITALIC,22);
   
   double num1=0,num2=0,result=0;
   char operator;
   
   Calculator(){
      frame = new JFrame("My Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(480, 420);
      frame.setLayout(null);
      
      textField = new JTextField();
      textField.setBounds(25,300,180,50);
      textField.setFont(myFont);
      textField.setEditable(false);
      
      addButton = new JButton("+");
      subButton = new JButton("-");
      mulButton = new JButton("*");
      divButton = new JButton("/");
      decButton = new JButton(".");
      equButton = new JButton("=");
      JButton delButton = new JButton("Delete");
      clrButton = new JButton("Clear");
      negButton = new JButton("(-)");
      
      functionButtons[0] = addButton;
      functionButtons[1] = subButton;
      functionButtons[2] = mulButton;
      functionButtons[3] = divButton;
      functionButtons[4] = decButton;
      functionButtons[5] = equButton;
      functionButtons[6] = delButton;
      functionButtons[7] = clrButton;
      functionButtons[8] = negButton;
      for(int i=0;i<9;i++){
         functionButtons[i].addActionListener(this);
         functionButtons[i].setFont(myFont);
         functionButtons[i].setFocusable(false);
      }
      for(int i=0;i<10;i++){
         numberButtons[i] = new JButton(String.valueOf(i));
         numberButtons[i].addActionListener(this);
         numberButtons[i].setFont(myFont);
         numberButtons[i].setFocusable(false);
      }
      panel=new JPanel();
      panel.setLayout(new GridLayout(4,4));
      panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      for(int i=0;i<10;i++)   
         panel.add(numberButtons[i]);
      for(int i=0;i<6;i++)   
         panel.add(functionButtons[i]);
      panel.setBounds(25,25,365,250);
      frame.add(panel);
      
      
      //delButton.setBounds(50,430,145,50);
      clrButton.setBounds(215,300,85,50);
      negButton.setBounds(310,300,80,50);
      
      frame.add(negButton);
      frame.add(clrButton);
      frame.add(textField);
      frame.setVisible(true);
   }
   
   public static void main (String[] args){
      Calculator calc = new Calculator();
   }
   @Override
   public void actionPerformed(ActionEvent e){
      for(int i=0;i<10;i++){
         if(e.getSource()== numberButtons[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
         }
      }
      if(e.getSource()== decButton){
         textField.setText(textField.getText().concat("."));
      }
      if(e.getSource()== addButton){
         num1 = Double.parseDouble(textField.getText());
         operator = '+';
         textField.setText("");
      }
      if(e.getSource()== subButton){
         num1 = Double.parseDouble(textField.getText());
         operator = '-';
         textField.setText("");
      }
      if(e.getSource()== mulButton){
         num1 = Double.parseDouble(textField.getText());
         operator = '*';
         textField.setText("");
      }
      if(e.getSource()== divButton){
         num1 = Double.parseDouble(textField.getText());
         operator = '/';
         textField.setText("");
      }
      if(e.getSource()== equButton){
         num2=Double.parseDouble(textField.getText());
         switch(operator){
         case'+':
            result=num1+num2;
            break;
         case'-':
            result=num1-num2;
            break; 
         case'*':
            result=num1*num2;
            break; 
         case'/':
            result=num1/num2;
            break;             
         }
         textField.setText(String.valueOf(result));
         num1=result;
      }
      if(e.getSource()== clrButton){
         textField.setText("");
      }
      if(e.getSource()== negButton){
         double temp = Double.parseDouble(textField.getText());
         temp*=-1;
         textField.setText(String.valueOf(temp));
      }
      
   }

}