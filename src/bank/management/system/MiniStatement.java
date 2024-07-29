package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 360, 400);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        bank.setFont(new Font("Arial", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Arial", Font.PLAIN, 14));
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 120, 300, 20);
        balance.setFont(new Font("Arial", Font.PLAIN, 14));
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            if (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
            } else {
                card.setText("No card number found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin ='" + pinnumber + "'");
            StringBuilder miniStatement = new StringBuilder("<html>");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                miniStatement.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("amount")).append("<br><br>");
            }
            miniStatement.append("</html>");
            mini.setText(miniStatement.toString());
            balance.setText("Your current balance is: Rs " + bal);
        } catch (Exception e) {
            mini.setText("Error fetching mini statement.");
            System.out.println("Error: " + e.getMessage());
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
