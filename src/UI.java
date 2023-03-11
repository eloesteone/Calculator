import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {

    static JFrame frame;
    static JTextField text;
    static JPanel panel;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, clrBtn;

    Font myFont = new Font("",Font.BOLD,30);


    UI(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);

        text = new JTextField();
        text.setBounds(50, 25, 300,50);
        text.setFont(myFont);
        text.setEditable(false);


        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        clrBtn= new JButton("C");

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = equBtn;
        functionButtons[6] = clrBtn;

        for(int i = 0; i < 7; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        clrBtn.setBounds(50, 430, 300, 50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4 , 10, 10));
        panel.setBackground(Color.gray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(equBtn);
        panel.add(divBtn);


        frame.add(panel);
        frame.add(clrBtn);
        frame.add(text);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) == 'C') {
            text.setText("");
        }else if (command.charAt(0) == '=') {
            text.setText(evaluate(text.getText()));
        }else {
            text.setText(text.getText() + command);
        }
    }

    public static String evaluate(String expression) {
        char[] arr = expression.toCharArray();
        String num1 = "";
        String num2 = "";
        String operator = "";
        double result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
                if(operator.isEmpty()){
                    num1 += arr[i];
                }else{
                    num2 += arr[i];
                }
            }

            if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
                operator += arr[i];
            }
        }

        if (operator.equals("+"))
            result = (Double.parseDouble(num1) + Double.parseDouble(num2));
        else if (operator.equals("-"))
            result = (Double.parseDouble(num1) - Double.parseDouble(num2));
        else if (operator.equals("/"))
            result = (Double.parseDouble(num1) / Double.parseDouble(num2));
        else
            result = (Double.parseDouble(num1) * Double.parseDouble(num2));
        return num1 + operator + num2 + "=" +result;
    }
}
