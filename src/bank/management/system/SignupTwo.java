package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, income, category, occupation, education;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(100, 20, 600, 40);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 80, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 80, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 130, 200, 30);
        add(fname);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 130, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 180, 200, 30);
        add(dob);
        
        String incomecategory[] = {"Null", "<1,00,000", "<2,00,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 180, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 230, 200, 30);
        add(gender);

        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 250, 200, 30);
        add(email);
        
        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 240, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(100, 300, 200, 30);
        add(marital);
        
        String ocupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        occupation = new JComboBox(ocupationValues);
        occupation.setBounds(300, 300, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN no:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 380, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 380, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar no:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 430, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 430, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 480, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 480, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400, 480, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100, 530, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 530, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400, 530, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 580, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 650);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) { // Corrected method name
     
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";  
        }
        
        
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        } 
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Sign up successful!");
                

                
                //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
