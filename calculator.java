import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


 public class calculator implements ActionListener{
     JFrame jf;
      JLabel label;
      Double num1,num2 ,result;
      JButton clear,modulus,back,seven,eight,nine,four,five,six,one,two, three,mul,minus,add,zeros,zero,dot,equal;
      private char operator;
      private boolean isOperatorClicked;
    public calculator() {
        jf=new JFrame("calculator");
        jf.setLayout(null); 
        jf.setSize(600, 600);
        jf.setVisible(true);
        jf.setLocation(300,150);
        label=new JLabel("hello");
        label.setSize(100, 300);
        label.setBounds(30,10, 540, 40); 
        label.setBackground(Color.gray);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setOpaque(true);
        jf.add(label);
        JButton clear=new JButton("C");
        clear.setBounds(30,80,80,80);
        clear.addActionListener(this);
   
        jf.add(clear);
        JButton modulus=new JButton("%");
        modulus.setBounds(130,80,80,80);
        modulus.addActionListener(this);
        jf.add(modulus);
        JButton back=new JButton("<");
        back.setBounds(230,80,80,80);
        back.addActionListener(this);
        jf.add(back);
        JButton divide=new JButton("/");
        divide.setBounds(320,80,80,80);
        divide.addActionListener(this);
        jf.add(divide);
        JButton seven=new JButton("7");
        seven.setBounds(30,180,80,80);
        seven.addActionListener(this);
        jf.add(seven);
        JButton eight=new JButton("8");
        eight.setBounds(130,180,80,80);
        eight.addActionListener(this);
        jf.add(eight);
        JButton nine=new JButton("9");
        nine.setBounds(230,180,80,80);
        nine.addActionListener(this);
        jf.add(nine);
        JButton mul=new JButton("x");
        mul.setBounds(320,180,80,80);
        mul.addActionListener(this);
        jf.add(mul);
        JButton four=new JButton("4");
        four.setBounds(30,280,80,80);
        four.addActionListener(this);
        jf.add(four);
        JButton five=new JButton("5");
        five.setBounds(130,280,80,80);
        five.addActionListener(this);
        jf.add(five);
        JButton six=new JButton("6");
        six.setBounds(230,280,80,80);
        six.addActionListener(this);
        jf.add(six);
        JButton minus=new JButton("-");
        minus.setBounds(320,280,80,80);
        minus.addActionListener(this);
        jf.add(minus);

        JButton one=new JButton("1");
        one.setBounds(30,380,80,80);

        one.addActionListener(this);
        jf.add(one);

         JButton two=new JButton("2");
        two.setBounds(130,380,80,80);
        two.addActionListener(this);
        jf.add(two);

        JButton three=new JButton("3");
        three.setBounds(230,380,80,80);
        three.addActionListener(this);
        jf.add(three);

        JButton add=new JButton("+");
        add.setBounds(320,380,80,80);
        jf.add(add);

         JButton zeros=new JButton("00");
        zeros.setBounds(30,480,80,80);
        zeros.addActionListener(this);
        jf.add(zeros);

         JButton zero=new JButton("0");
        zero.setBounds(130,480,80,80);
        zero.addActionListener(this);
        jf.add(zero);

         JButton dot=new JButton(".");
        dot.setBounds(230,480,80,80);
        dot.addActionListener(this);
        jf.add(dot);

        JButton equal=new JButton("=");
        equal.setBounds(320,480,80,80);
        equal.addActionListener(this);
        jf.add(equal);

    }
    public static void main(String args[]){
        new calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        char inputChar = command.charAt(0);

        if (Character.isDigit(inputChar)) {
            if (isOperatorClicked) {
                label.setText(command);
                isOperatorClicked = false;
            } else {
                label.setText(label.getText() + command);
            }

        } else if (command.equals(".") && !label.getText().contains(".")) {
            label.setText(label.getText() + command);
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(label.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        label.setText("Error");
                        return;
                    }
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }

       

        label.setText(String.valueOf(result));
        num1 = result;
        isOperatorClicked = true;
    } else if (command.equals("C")) {
        label.setText("");
       
        operator = '\0';
        isOperatorClicked = false;
    } else if (command.equals("<")) {
        String currentText = label.getText();
        if (!currentText.isEmpty()) {
            label.setText(currentText.substring(0, currentText.length() - 1));
        }
    } else {
        operator = inputChar;
        num1 = Double.parseDouble(label.getText());
        isOperatorClicked = true;
    }
}

     

    }

   




    
    

