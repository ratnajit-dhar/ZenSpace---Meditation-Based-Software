/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zenspace.pkgfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import javax.swing.JFrame;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Asus
 */
public class UserHomepage extends javax.swing.JFrame {

    /**
     * Creates new form UserHomepage
     */
    String filename = null;
    String NowPlaying = null;
    Vector<String> CartProduct = new Vector<>();
    Vector<String>CartType = new Vector<>();
    Vector<Integer> CartQuantity = new Vector<>();
    Vector<Integer> CartPrice = new Vector<>();
    Clip clip = null;
    String user=null;
    public UserHomepage(){
        initComponents();
    }
    public UserHomepage(String username) {
        user=username;
        this.CurrentFrame = 0L;
        Connect();
        initComponents();
        setColor(Home);
        
        ResumeButton.setVisible(false);
        ResumeButton1.setVisible(false);
        ResumeButton2.setVisible(false);
        enteramountlabel.setVisible(false);
        enteryouramount.setVisible(false);
        okbutton.setVisible(false);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        try {
            pst=con.prepareStatement("select * from doctor");
            rs=pst.executeQuery();
            while(rs.next()){
               //System.out.println(10);
                String doctorName=rs.getString("NAME");
                String doctorAddress=rs.getString("ADDRESS");
                String doctorNumber=rs.getString("CONTACT_NUMBER");
                //System.out.println(doctorNumber);
                model.addRow(new Object[]{doctorName,doctorAddress,doctorNumber});
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst = con.prepareStatement("Select * From musiclist WHERE Genre = ?");
            pst.setString(1,"Improve Focus");
            rs = pst.executeQuery();
            int yPan = 0;
            int cur = 0;
            while(rs.next()){
                cur++;
                JPanel pan = new JPanel();
                pan.setLayout(new AbsoluteLayout());
                pan.setPreferredSize(new Dimension(350,30));
                JLabel imagelab = new JLabel();
                imagelab.setPreferredSize(new Dimension(200,200));
                imagelab.setBackground(Color.red);
                imagelab.setOpaque(true);
                String name = rs.getString("Name");
                byte img[];
                img = rs.getBytes("Image");
                byte audio[] = rs.getBytes("Audio");
                JLabel namelab = new JLabel();
               // namelab.setBackground(Color.red);
                //namelab.setOpaque(true);
                namelab.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
                namelab.setText(name);
                JButton selectBut = new JButton();
                selectBut.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                selectBut.setText("Play");
                if(cur % 2 == 1) pan.setBackground(new Color(255,255,255));
                else pan.setBackground(new Color(242,242,242));
                pan.setOpaque(true);
                
                
                //lab.setIcon(new ImageIcon(img));
                //lab.setVisible(true);
                ImageIcon propic = null;
                Image image=null;
               // System.out.println(lab.getWidth());
                if(img!=null){
                    propic = new ImageIcon(img);
                    image = propic.getImage().getScaledInstance(200, 200,image.SCALE_SMOOTH);
                }
                imagelab.setIcon(new ImageIcon(image));
                selectBut.addActionListener(new ActionListener() {
                @Override
                 public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                jLabel123.setText(name);
                ResumeButton1.setVisible(true);
                PlayButton1.setVisible(false);
                jLabel123.setText(name);
                playAudio(audio);
                 }

                private void playAudio(byte[] audio) {
                    try {
            // Convert byte array to InputStream
            if(clip!=null) clip.close();
            InputStream inputStream = new ByteArrayInputStream(audio);

            // Create an AudioInputStream from the InputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

            // Get a Clip (part of the Java Sound API)
            clip = AudioSystem.getClip();
            
            // Open the AudioInputStream to the Clip
            clip.open(audioInputStream);

            // Start playing the audio
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                 });
                pan.add(imagelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,200,150));
                pan.add(namelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(220,50,800,50));
                pan.add(selectBut,new org.netbeans.lib.awtextra.AbsoluteConstraints(1030,50,100,50));
                FocusMusic.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,yPan,1180,170));
                yPan = yPan + 170;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst = con.prepareStatement("Select * From musiclist WHERE Genre = ?");
            pst.setString(1,"Self Improvement");
            rs = pst.executeQuery();
            int yPan = 0;
            int cur = 0;
            while(rs.next()){
                cur = cur+1;
                JPanel pan = new JPanel();
                pan.setLayout(new AbsoluteLayout());
                pan.setPreferredSize(new Dimension(350,30));
                JLabel imagelab = new JLabel();
                imagelab.setPreferredSize(new Dimension(200,200));
                imagelab.setBackground(Color.red);
                imagelab.setOpaque(true);
                String name = rs.getString("Name");
                byte img[];
                img = rs.getBytes("Image");
                byte audio[] = rs.getBytes("Audio");
                JLabel namelab = new JLabel();
               // namelab.setBackground(Color.red);
                //namelab.setOpaque(true);
                namelab.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
                namelab.setText(name);
                JButton selectBut = new JButton();
                selectBut.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                selectBut.setText("Play");
                System.out.println(cur);
                if(cur % 2 == 1) pan.setBackground(new Color(242,242,242));
                else pan.setBackground(new Color(255,255,255));
                pan.setOpaque(true);
                
                
                //lab.setIcon(new ImageIcon(img));
                //lab.setVisible(true);
                ImageIcon propic = null;
                Image image=null;
               // System.out.println(lab.getWidth());
                if(img!=null){
                    propic = new ImageIcon(img);
                    image = propic.getImage().getScaledInstance(200, 200,image.SCALE_SMOOTH);
                }
                imagelab.setIcon(new ImageIcon(image));
                selectBut.addActionListener(new ActionListener() {
                @Override
                 public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                jLabel123.setText(name);
                ResumeButton2.setVisible(true);
                PlayButton2.setVisible(false);
                jLabel68.setText(name);
                playAudio(audio);
                 }

                private void playAudio(byte[] audio) {
                    try {
            // Convert byte array to InputStream
            if(clip!=null) clip.close();
            InputStream inputStream = new ByteArrayInputStream(audio);

            // Create an AudioInputStream from the InputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

            // Get a Clip (part of the Java Sound API)
            clip = AudioSystem.getClip();
            
            // Open the AudioInputStream to the Clip
            clip.open(audioInputStream);

            // Start playing the audio
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                 });
                pan.add(imagelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,200,150));
                pan.add(namelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(220,50,800,50));
                pan.add(selectBut,new org.netbeans.lib.awtextra.AbsoluteConstraints(1030,50,100,50));
                SelfMusic.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,yPan,1180,170));
                yPan = yPan + 170;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst = con.prepareStatement("Select * From musiclist WHERE Genre = ?");
            pst.setString(1,"Stress Reduction");
            rs = pst.executeQuery();
            int yPan = 0;
            int cur = 0;
            while(rs.next()){
                cur = cur+1;
                JPanel pan = new JPanel();
                pan.setLayout(new AbsoluteLayout());
                pan.setPreferredSize(new Dimension(350,30));
                JLabel imagelab = new JLabel();
                imagelab.setPreferredSize(new Dimension(200,200));
                imagelab.setBackground(Color.red);
                imagelab.setOpaque(true);
                String name = rs.getString("Name");
                byte img[];
                img = rs.getBytes("Image");
                byte audio[] = rs.getBytes("Audio");
                JLabel namelab = new JLabel();
               // namelab.setBackground(Color.red);
                //namelab.setOpaque(true);
                namelab.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
                namelab.setText(name);
                JButton selectBut = new JButton();
                selectBut.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                selectBut.setText("Play");
                System.out.println(cur);
                if(cur % 2 == 1) pan.setBackground(new Color(242,242,242));
                else pan.setBackground(new Color(255,255,255));
                pan.setOpaque(true);
                
                
                //lab.setIcon(new ImageIcon(img));
                //lab.setVisible(true);
                ImageIcon propic = null;
                Image image=null;
               // System.out.println(lab.getWidth());
                if(img!=null){
                    propic = new ImageIcon(img);
                    image = propic.getImage().getScaledInstance(200, 200,image.SCALE_SMOOTH);
                }
                imagelab.setIcon(new ImageIcon(image));
                selectBut.addActionListener(new ActionListener() {
                @Override
                 public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                jLabel81.setText(name);
                ResumeButton.setVisible(true);
                PlayButton.setVisible(false);
                playAudio(audio);
                 }

                private void playAudio(byte[] audio) {
                    try {
            // Convert byte array to InputStream
            if(clip!=null) clip.close();
            InputStream inputStream = new ByteArrayInputStream(audio);

            // Create an AudioInputStream from the InputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

            // Get a Clip (part of the Java Sound API)
            clip = AudioSystem.getClip();
            
            // Open the AudioInputStream to the Clip
            clip.open(audioInputStream);

            // Start playing the audio
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                 });
                pan.add(imagelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,200,150));
                pan.add(namelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(220,50,800,50));
                pan.add(selectBut,new org.netbeans.lib.awtextra.AbsoluteConstraints(1030,50,100,50));
                StressMusic.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,yPan,1180,170));
                yPan = yPan + 170;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/zenspace","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        donateamount = new javax.swing.ButtonGroup();
        typeofdon = new javax.swing.ButtonGroup();
        cross = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tabbedpanels = new javax.swing.JTabbedPane();
        HomePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        stresspanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        quote2 = new javax.swing.JLabel();
        ResumeButton = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        PlayButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        StressMusic = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        quote4 = new javax.swing.JLabel();
        ResumeButton1 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        PlayButton1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        FocusMusic = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        quote5 = new javax.swing.JLabel();
        ResumeButton2 = new javax.swing.JButton();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        PlayButton2 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        SelfMusic = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        quote3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SearchMusic = new javax.swing.JPanel();
        anxlabel8 = new javax.swing.JLabel();
        helplinePanel = new javax.swing.JPanel();
        quote1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel92 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        profilee = new javax.swing.JPanel();
        donate = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tendol = new javax.swing.JRadioButton();
        twenfivedol = new javax.swing.JRadioButton();
        fifty = new javax.swing.JRadioButton();
        hundred = new javax.swing.JRadioButton();
        hundfifty = new javax.swing.JRadioButton();
        twohund = new javax.swing.JRadioButton();
        yourchoice = new javax.swing.JRadioButton();
        enteryouramount = new javax.swing.JTextField();
        jlabeldollar = new javax.swing.JLabel();
        totaldol = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        enteramountlabel = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel102 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel103 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        submit = new javax.swing.JButton();
        okbutton = new javax.swing.JButton();
        jLabel108 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        shoppanel = new javax.swing.JPanel();
        Courses = new javax.swing.JPanel();
        paidcourse = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cart = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        course1 = new javax.swing.JButton();
        course5 = new javax.swing.JButton();
        course2 = new javax.swing.JButton();
        course3 = new javax.swing.JButton();
        course4 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        cdpanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jSpinner10 = new javax.swing.JSpinner();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jSpinner13 = new javax.swing.JSpinner();
        jSpinner14 = new javax.swing.JSpinner();
        jLabel134 = new javax.swing.JLabel();
        cd1 = new javax.swing.JButton();
        cd2 = new javax.swing.JButton();
        cd3 = new javax.swing.JButton();
        cd4 = new javax.swing.JButton();
        cd5 = new javax.swing.JButton();
        cd6 = new javax.swing.JButton();
        cd7 = new javax.swing.JButton();
        cd8 = new javax.swing.JButton();
        cd9 = new javax.swing.JButton();
        cd10 = new javax.swing.JButton();
        cd11 = new javax.swing.JButton();
        cd12 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel98 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        cushion1info = new javax.swing.JButton();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jSpinner20 = new javax.swing.JSpinner();
        yogamat = new javax.swing.JButton();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jSpinner21 = new javax.swing.JSpinner();
        medibench = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jSpinner22 = new javax.swing.JSpinner();
        mediblanket = new javax.swing.JButton();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jSpinner23 = new javax.swing.JSpinner();
        timer = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jSpinner24 = new javax.swing.JSpinner();
        cushion2 = new javax.swing.JButton();
        cushion1 = new javax.swing.JButton();
        cushion1info2 = new javax.swing.JButton();
        cushion1info3 = new javax.swing.JButton();
        cushion1info4 = new javax.swing.JButton();
        cushion1info5 = new javax.swing.JButton();
        cushion1info6 = new javax.swing.JButton();
        books = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        book1 = new javax.swing.JButton();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        book2 = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jSpinner16 = new javax.swing.JSpinner();
        book3 = new javax.swing.JButton();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jSpinner17 = new javax.swing.JSpinner();
        book4 = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jSpinner18 = new javax.swing.JSpinner();
        book5 = new javax.swing.JButton();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jSpinner19 = new javax.swing.JSpinner();
        book6 = new javax.swing.JButton();
        cushion1info7 = new javax.swing.JButton();
        cushion1info8 = new javax.swing.JButton();
        cushion1info9 = new javax.swing.JButton();
        cushion1info10 = new javax.swing.JButton();
        cushion1info11 = new javax.swing.JButton();
        cushion1info12 = new javax.swing.JButton();
        LogoZenSpace = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Stress = new javax.swing.JLabel();
        focus = new javax.swing.JLabel();
        self = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        helpline = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        Donate = new javax.swing.JLabel();
        Shop = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancel-24.png"))); // NOI18N
        cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        getContentPane().add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 0, 40, 50));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-macos-minimize-30.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 40, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedpanels.setBackground(new java.awt.Color(255, 255, 255));

        HomePanel.setBackground(new java.awt.Color(255, 238, 221));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century", 1, 48)); // NOI18N
        jLabel12.setText("Welcome to");
        HomePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 100));

        jLabel13.setFont(new java.awt.Font("Paytone One", 1, 48)); // NOI18N
        jLabel13.setText("ZenSpace!");
        HomePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 290, 70));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel10.setText("think they ought to be. Answer each question individually.");
        HomePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 1110, 60));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel14.setText("Discover your Mindfulness Score in under 3 minutes! ");
        HomePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 640, 60));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel15.setText("Evaluate the following 20 statements regarding your daily life");
        HomePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1110, 60));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel16.setText("experiences and share how frequently you encounter each scen-");
        HomePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 1110, 60));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel17.setText("erio. There are no correct or incorrect responses; simply provide ");
        HomePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 720, 60));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel18.setText("honest feedback based on your actual experiences, not what you");
        HomePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 710, 60));

        jButton12.setBackground(new java.awt.Color(255, 205, 155));
        jButton12.setFont(new java.awt.Font("Century", 1, 17)); // NOI18N
        jButton12.setText("Take the quiz -->");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 228, 201)));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        HomePanel.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 210, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homepage medi.png"))); // NOI18N
        HomePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 390, 650));
        HomePanel.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1230, 790));

        tabbedpanels.addTab("home", HomePanel);

        stresspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        stresspanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1060, 70));

        quote2.setFont(new java.awt.Font("Century", 3, 32)); // NOI18N
        quote2.setText("In the midst of movement and chaos keep the stillness inside you.");
        stresspanel.add(quote2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1060, 60));

        ResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pause-30.png"))); // NOI18N
        ResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeButtonActionPerformed(evt);
            }
        });
        stresspanel.add(ResumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jLabel81.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stresspanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 770, 40));

        jLabel82.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel82.setText("Now Playing");
        stresspanel.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, 200, 50));

        PlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-play-30.png"))); // NOI18N
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
        stresspanel.add(PlayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        StressMusic.setBackground(new java.awt.Color(255, 246, 237));
        StressMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane6.setViewportView(StressMusic);

        stresspanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1180, 480));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg2 small.png"))); // NOI18N
        stresspanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabbedpanels.addTab("stress", stresspanel);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1060, 70));

        quote4.setFont(new java.awt.Font("Century", 3, 32)); // NOI18N
        quote4.setText("In the midst of movement and chaos keep the stillness inside you.");
        jPanel4.add(quote4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1060, 60));

        ResumeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pause-30.png"))); // NOI18N
        ResumeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(ResumeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jLabel123.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 770, 40));

        jLabel161.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel161.setText("Now Playing");
        jPanel4.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, 200, 50));

        PlayButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-play-30.png"))); // NOI18N
        PlayButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(PlayButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        FocusMusic.setBackground(new java.awt.Color(255, 246, 237));
        FocusMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane10.setViewportView(FocusMusic);

        jPanel4.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1180, 500));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg2 small.png"))); // NOI18N
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabbedpanels.addTab("focus", jPanel4);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1060, 70));

        quote5.setFont(new java.awt.Font("Century", 3, 32)); // NOI18N
        quote5.setText("In the midst of movement and chaos keep the stillness inside you.");
        jPanel7.add(quote5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1060, 60));

        ResumeButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pause-30.png"))); // NOI18N
        ResumeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(ResumeButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jLabel168.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel168.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 770, 40));

        jLabel169.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel169.setText("Now Playing");
        jPanel7.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, 200, 50));

        PlayButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-play-30.png"))); // NOI18N
        PlayButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(PlayButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 720, 30, 30));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        SelfMusic.setBackground(new java.awt.Color(255, 246, 237));
        SelfMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane11.setViewportView(SelfMusic);

        jPanel7.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1180, 510));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg2 small.png"))); // NOI18N
        jPanel7.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabbedpanels.addTab("self", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabbedpanels.addTab("articles", jPanel8);

        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        searchPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 80, 40));

        SearchField.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        searchPanel.add(SearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 660, 80));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        searchPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1060, 10));

        quote3.setFont(new java.awt.Font("Century", 3, 32)); // NOI18N
        quote3.setText("In the midst of movement and chaos keep the stillness inside you.");
        searchPanel.add(quote3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1060, 60));

        SearchMusic.setBackground(new java.awt.Color(255, 246, 237));
        SearchMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(SearchMusic);

        searchPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1180, 370));

        anxlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg big.png"))); // NOI18N
        searchPanel.add(anxlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, -120, -1, 1210));

        tabbedpanels.addTab("search", searchPanel);

        helplinePanel.setBackground(new java.awt.Color(241, 242, 242));
        helplinePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quote1.setBackground(new java.awt.Color(0, 0, 0));
        quote1.setFont(new java.awt.Font("Century", 3, 31)); // NOI18N
        quote1.setText("In the midst of movement and chaos, keep the stillness inside of you.");
        helplinePanel.add(quote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1060, 60));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor", "Address", "Contact No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(51, 0, 255));
        jScrollPane3.setViewportView(jTable1);

        helplinePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 740, 190));

        jLabel86.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel86.setText("If you are suffering from:");
        helplinePanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 270, 30));

        jLabel87.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel87.setText("Insomnia");
        helplinePanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 220, 20));

        jLabel88.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel88.setText("Depression");
        helplinePanel.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 140, -1));

        jLabel89.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel89.setText("Excessive Stress");
        helplinePanel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabel90.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel90.setText("Anxiety");
        helplinePanel.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel91.setBackground(new java.awt.Color(255, 255, 255));
        jLabel91.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel91.setText("Find Help");
        jLabel91.setOpaque(true);
        helplinePanel.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 210, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        helplinePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1060, 20));

        jLabel92.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel92.setText("Feedback:");
        helplinePanel.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        helplinePanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 910, 110));

        jButton11.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jButton11.setText("Submit");
        jButton11.setBorder(null);
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        helplinePanel.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 680, 80, 40));

        jLabel93.setBackground(new java.awt.Color(255, 204, 153));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.gif"))); // NOI18N
        helplinePanel.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 60, 60));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg big.png"))); // NOI18N
        jLabel85.setText("jLabel85");
        helplinePanel.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(-310, -10, 1500, 980));

        tabbedpanels.addTab("help", helplinePanel);

        profilee.setBackground(new java.awt.Color(255, 238, 221));
        profilee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabbedpanels.addTab("Profile", profilee);

        donate.setBackground(new java.awt.Color(255, 238, 221));
        donate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/donate icon.png"))); // NOI18N
        jLabel95.setText("Help our mindful journey!");
        donate.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 420, 70));

        jLabel8.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel8.setText("Your donation supports ZenSpace’s work, and makes it possible for these teachings to be offered as widely as possible. Please");
        donate.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1130, 60));

        jLabel96.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel96.setText("know that whatever you offer is recieved with much gratitude!");
        donate.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 1120, 50));

        jLabel97.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel97.setText("You can use the donation form below for your act of kindness.");
        donate.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 970, 40));

        jPanel12.setBackground(new java.awt.Color(255, 246, 237));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("Donation");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, 50));

        donateamount.add(tendol);
        tendol.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tendol.setText(" $10.00");
        tendol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tendolActionPerformed(evt);
            }
        });
        jPanel12.add(tendol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 63, 100, 40));

        donateamount.add(twenfivedol);
        twenfivedol.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        twenfivedol.setText(" $25.00");
        twenfivedol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twenfivedolActionPerformed(evt);
            }
        });
        jPanel12.add(twenfivedol, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        donateamount.add(fifty);
        fifty.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        fifty.setText(" $50.00");
        fifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyActionPerformed(evt);
            }
        });
        jPanel12.add(fifty, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        donateamount.add(hundred);
        hundred.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        hundred.setText(" $100.00");
        hundred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredActionPerformed(evt);
            }
        });
        jPanel12.add(hundred, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        donateamount.add(hundfifty);
        hundfifty.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        hundfifty.setText(" $150.00");
        hundfifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundfiftyActionPerformed(evt);
            }
        });
        jPanel12.add(hundfifty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        donateamount.add(twohund);
        twohund.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        twohund.setText(" $200.00");
        twohund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twohundActionPerformed(evt);
            }
        });
        jPanel12.add(twohund, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        donateamount.add(yourchoice);
        yourchoice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        yourchoice.setText(" Your choice");
        yourchoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourchoiceActionPerformed(evt);
            }
        });
        jPanel12.add(yourchoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        enteryouramount.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        enteryouramount.setText(" $");
        jPanel12.add(enteryouramount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, 30));

        jlabeldollar.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jlabeldollar.setText("Total:");
        jPanel12.add(jlabeldollar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 50));

        totaldol.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(totaldol, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 170, 30));

        jLabel99.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(153, 153, 153));
        jLabel99.setText("Last name");
        jPanel12.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 770, 140, 30));

        enteramountlabel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        enteramountlabel.setText("Enter your amount:");
        jPanel12.add(enteramountlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 50));

        donateamount.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jRadioButton2.setText(" $10.00");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel12.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 63, 100, 40));

        typeofdon.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jRadioButton8.setText("Monthly contribution");
        jPanel12.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        typeofdon.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jRadioButton10.setText("One time donation");
        jPanel12.add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel102.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel102.setText("Any message for us?");
        jPanel12.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 920, 240, 30));

        jComboBox2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "PayPal", "Bkash", "Rocket", "Nagad", " " }));
        jComboBox2.setBorder(null);
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.setOpaque(true);
        jPanel12.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 160, 30));

        jLabel103.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel103.setText("What type of donation would you like to make?");
        jPanel12.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 450, 30));

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 740, 290, 30));

        jLabel104.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel104.setText("(If you're using Credit Card)");
        jPanel12.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 440, 30));

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 860, 290, 30));

        jLabel105.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(153, 153, 153));
        jLabel105.setText("First name");
        jPanel12.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, 260, 30));

        jLabel106.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel106.setText("Name");
        jPanel12.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 70, 30));

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 310, 30));

        jTextField4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 960, 700, 70));

        jLabel107.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel107.setText("Email");
        jPanel12.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 820, 70, 30));

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jCheckBox1.setText("I would like to recieve email for monthly recurring payments through PayPal, Bkash, Nagad or Rocket.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel12.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1040, -1, -1));

        submit.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        submit.setText("Submit");
        submit.setBorder(null);
        submit.setOpaque(true);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel12.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1090, 160, 50));

        okbutton.setText("OK");
        okbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbuttonActionPerformed(evt);
            }
        });
        jPanel12.add(okbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 112, -1, -1));

        jLabel108.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel108.setText("How would you like to pay?");
        jPanel12.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 450, 30));

        jTextField5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 290, 30));

        jLabel109.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel109.setText("Enter your PayPal/Credit card number or Bkash/Nagad/Rocket number:");
        jPanel12.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 660, 30));

        jLabel110.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel110.setText("Select country");
        jPanel12.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 240, 30));

        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel12.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 310, 30));

        jLabel111.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel111.setText("Security code (CVV/CVC) ");
        jPanel12.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 240, 30));

        jComboBox3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Argentina", "Australia", "Austria", "Bangladesh", "Belgium", "Bhutan", "Brazil", "Cambodia", "Canada", "Chile", "China", "Columbia", "Costa Rica", "France", "Germany", "Greenland", "Hongkong", "India", "Japan", "Malaysia", "Maldives", "Nepal", "New Zealand", "Pakistan", "Qatar", "Russia", "Singapore", "South Korea", "Sri Lanka", "Thailand", "United Kingdom", "United States", "Zimbabwe" }));
        jComboBox3.setBorder(null);
        jPanel12.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, -1, -1));

        jScrollPane5.setViewportView(jPanel12);

        donate.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 1070, 360));

        tabbedpanels.addTab("donate", donate);

        shoppanel.setBackground(new java.awt.Color(255, 238, 221));
        shoppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Courses.setBackground(new java.awt.Color(255, 238, 221));
        Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paidcourse.setBackground(new java.awt.Color(137, 108, 79));
        paidcourse.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        paidcourse.setForeground(new java.awt.Color(255, 255, 255));
        paidcourse.setText("     Paid Courses");
        paidcourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paidcourse.setOpaque(true);
        paidcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paidcourseMouseClicked(evt);
            }
        });
        Courses.add(paidcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 160, 50));

        jLabel22.setBackground(new java.awt.Color(137, 108, 79));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("   Digital Albums");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        Courses.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 160, 50));

        jLabel23.setBackground(new java.awt.Color(137, 108, 79));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("           Books");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        Courses.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 160, 50));

        jLabel24.setBackground(new java.awt.Color(137, 108, 79));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("    Merchandise");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        Courses.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 160, 50));

        cart.setBackground(new java.awt.Color(255, 255, 255));
        cart.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart icon.png"))); // NOI18N
        cart.setText(" Cart");
        cart.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        Courses.add(cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 110, 50));

        shoppanel.add(Courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 130));

        jPanel5.setBackground(new java.awt.Color(255, 238, 221));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane9.setBorder(null);
        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setPreferredSize(new java.awt.Dimension(1182, 1475));

        jPanel14.setBackground(new java.awt.Color(255, 238, 221));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/COURSE3.png"))); // NOI18N
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 280, 290));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/courses 2.png"))); // NOI18N
        jPanel14.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 300, 290));

        jLabel28.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel28.setText("Price: TK 4,500 ");
        jPanel14.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 820, 150, 30));

        jLabel29.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel29.setText("Breaking Bad Habit Course");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1320, 260, 30));

        jLabel30.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel30.setText("tion Challenge");
        jPanel14.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 810, 300, 30));

        jLabel31.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel31.setText("Self Care Essentials");
        jPanel14.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 790, 260, 30));

        jSpinner1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner1.setBorder(null);
        jPanel14.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 855, -1, -1));

        jLabel32.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel32.setText("Quantity: ");
        jPanel14.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1380, 90, 30));

        jLabel33.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel33.setText("Quantity: ");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 870, 90, 30));

        jSpinner2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner2.setBorder(null);
        jPanel14.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1390, -1, -1));

        jLabel34.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel34.setText("Quantity: ");
        jPanel14.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 850, 90, 30));

        jLabel35.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel35.setText("Price: TK 5,500");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1350, 150, 30));

        jLabel36.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel36.setText("Price: TK 8,000 ");
        jPanel14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 840, 150, 30));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/courses1.png"))); // NOI18N
        jPanel14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 260, 290));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/COURSE5.png"))); // NOI18N
        jPanel14.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1010, 260, 310));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/COURSE4.png"))); // NOI18N
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1020, 260, 310));

        jLabel39.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel39.setText("How To Meditate Course");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 790, 260, 30));

        jLabel40.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel40.setText("Nature Meditation Course");
        jPanel14.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1330, 260, 30));

        jLabel41.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel41.setText("Price: TK 6,500 ");
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 820, 150, 30));

        jLabel42.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel42.setText("Price: TK 3,000");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1360, 150, 30));

        jLabel43.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel43.setText("Quantity: ");
        jPanel14.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, 90, 30));

        jLabel44.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel44.setText("Quantity: ");
        jPanel14.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1390, 90, 30));

        jSpinner6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner6.setBorder(null);
        jPanel14.add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 870, -1, -1));

        jSpinner3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner3.setBorder(null);
        jPanel14.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 855, -1, -1));

        jSpinner7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner7.setBorder(null);
        jPanel14.add(jSpinner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 1385, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buy our online courses.png"))); // NOI18N
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        jLabel70.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel70.setText("Zen Harmony - 30 Day Medita-");
        jPanel14.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 790, 300, 30));

        jButton19.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        jButton19.setText("Add to cart");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1430, 120, 40));

        course1.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        course1.setText("More Info");
        course1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course1ActionPerformed(evt);
            }
        });
        jPanel14.add(course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 890, 110, 40));

        course5.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        course5.setText("More Info");
        course5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course5ActionPerformed(evt);
            }
        });
        jPanel14.add(course5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1420, 110, 40));

        course2.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        course2.setText("More Info");
        course2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course2ActionPerformed(evt);
            }
        });
        jPanel14.add(course2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 910, 110, 40));

        course3.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        course3.setText("More Info");
        course3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course3ActionPerformed(evt);
            }
        });
        jPanel14.add(course3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 890, 110, 40));

        course4.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        course4.setText("More Info");
        course4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course4ActionPerformed(evt);
            }
        });
        jPanel14.add(course4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1430, 110, 40));

        jButton20.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        jButton20.setText("Add to cart");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 890, 120, 40));

        jButton21.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        jButton21.setText("Add to cart");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 910, 120, 40));

        jButton22.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        jButton22.setText("Add to cart");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 890, 120, 40));

        jButton23.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        jButton23.setText("Add to cart");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1420, 120, 40));

        jScrollPane9.setViewportView(jPanel14);

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 660));

        jTabbedPane1.addTab("courses", jPanel5);

        cdpanel.setBackground(new java.awt.Color(255, 238, 221));
        cdpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(1182, 1472));

        jPanel9.setBackground(new java.awt.Color(255, 238, 221));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/audio shop2.png"))); // NOI18N
        jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 440));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd3.png"))); // NOI18N
        jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 270, 310));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd6.png"))); // NOI18N
        jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1020, 270, 310));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd2.png"))); // NOI18N
        jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 270, 310));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd1 (2).png"))); // NOI18N
        jPanel9.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 270, 310));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd4.png"))); // NOI18N
        jPanel9.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1030, 270, 310));

        jLabel51.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel51.setText("Sountrack");
        jPanel9.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 830, 270, 30));

        jLabel52.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel52.setText("Breathe Easy Digital Album");
        jPanel9.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 810, 260, 30));

        jLabel53.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel53.setText("Calm The Chaos Digital Album");
        jPanel9.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 810, 290, 30));

        jLabel54.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel54.setText("Price: TK 200");
        jPanel9.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 860, 210, 30));

        jLabel55.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel55.setText("itation Soundtracks");
        jPanel9.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1350, 270, 30));

        jLabel56.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel56.setText("track");
        jPanel9.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1360, 60, 30));

        jLabel57.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel57.setText("Price: TK 50");
        jPanel9.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1390, 210, 30));

        jLabel58.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel58.setText("Price: TK 110");
        jPanel9.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1380, 210, 30));

        jLabel59.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel59.setText("Quantity:");
        jPanel9.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 890, 90, 30));

        jLabel60.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel60.setText("Price: TK 70");
        jPanel9.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 840, 210, 30));

        jSpinner4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner4.setBorder(null);
        jPanel9.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 895, -1, -1));

        jLabel61.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel61.setText("Price: TK 120");
        jPanel9.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 840, 210, 30));

        jLabel62.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel62.setText("Quantity:");
        jPanel9.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 90, 30));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cd5.png"))); // NOI18N
        jPanel9.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1020, 270, 310));

        jLabel101.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel101.setText("Focus Meditations");
        jPanel9.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1350, 260, 30));

        jLabel112.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel112.setText("Price: TK 150");
        jPanel9.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1380, 210, 30));

        jSpinner9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner9.setBorder(null);
        jPanel9.add(jSpinner9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 1415, -1, -1));

        jSpinner10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner10.setBorder(null);
        jPanel9.add(jSpinner10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 875, -1, -1));

        jLabel127.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel127.setText("Quantity:");
        jPanel9.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 870, 90, 30));

        jLabel128.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel128.setText("NIRVANA- Sleep Meditation");
        jPanel9.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 810, 270, 30));

        jLabel129.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel129.setText("Euphoria- Relaxation Sound-");
        jPanel9.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1340, 270, 30));

        jLabel130.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel130.setText("Mind's Eye Mystery-Guided");
        jPanel9.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1330, 260, 30));

        jLabel131.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel131.setText("Cognitive Zenith-Focus Med-");
        jPanel9.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1330, 270, 30));

        jSpinner11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner11.setBorder(null);
        jPanel9.add(jSpinner11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 875, -1, -1));

        jLabel132.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel132.setText("Quantity:");
        jPanel9.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 870, 90, 30));

        jLabel133.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel133.setText("Quantity:");
        jPanel9.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1420, 90, 30));

        jSpinner12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner12.setBorder(null);
        jPanel9.add(jSpinner12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1425, -1, -1));

        jSpinner13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner13.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner13.setBorder(null);
        jPanel9.add(jSpinner13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1415, -1, -1));

        jSpinner14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner14.setBorder(null);
        jPanel9.add(jSpinner14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1420, -1, -1));

        jLabel134.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel134.setText("Quantity:");
        jPanel9.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1410, 90, 30));

        cd1.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd1.setText("Add to cart");
        cd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd1ActionPerformed(evt);
            }
        });
        jPanel9.add(cd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 1450, 120, 40));

        cd2.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd2.setText("More Info");
        cd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd2ActionPerformed(evt);
            }
        });
        jPanel9.add(cd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 910, 110, 40));

        cd3.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd3.setText("More Info");
        cd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd3ActionPerformed(evt);
            }
        });
        jPanel9.add(cd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 930, 110, 40));

        cd4.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd4.setText("More Info");
        cd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd4ActionPerformed(evt);
            }
        });
        jPanel9.add(cd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1460, 110, 40));

        cd5.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd5.setText("More Info");
        cd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd5ActionPerformed(evt);
            }
        });
        jPanel9.add(cd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1450, 110, 40));

        cd6.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd6.setText("More Info");
        cd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd6ActionPerformed(evt);
            }
        });
        jPanel9.add(cd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1450, 110, 40));

        cd7.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd7.setText("More Info");
        cd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd7ActionPerformed(evt);
            }
        });
        jPanel9.add(cd7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 910, 110, 40));

        cd8.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd8.setText("Add to cart");
        cd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd8ActionPerformed(evt);
            }
        });
        jPanel9.add(cd8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 910, 120, 40));

        cd9.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd9.setText("Add to cart");
        cd9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd9ActionPerformed(evt);
            }
        });
        jPanel9.add(cd9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 910, 120, 40));

        cd10.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd10.setText("Add to cart");
        cd10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd10ActionPerformed(evt);
            }
        });
        jPanel9.add(cd10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 930, 120, 40));

        cd11.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd11.setText("Add to cart");
        cd11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd11ActionPerformed(evt);
            }
        });
        jPanel9.add(cd11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1460, 120, 40));

        cd12.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cd12.setText("Add to cart");
        cd12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cd12ActionPerformed(evt);
            }
        });
        jPanel9.add(cd12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 1450, 120, 40));

        jScrollPane4.setViewportView(jPanel9);

        cdpanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 660));

        jTabbedPane1.addTab("CD", cdpanel);

        jPanel10.setBackground(new java.awt.Color(255, 238, 221));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setBorder(null);
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setPreferredSize(new java.awt.Dimension(1182, 1472));

        jPanel13.setBackground(new java.awt.Color(255, 238, 221));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merch banner 2.png"))); // NOI18N
        jPanel13.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 450));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seiza bench.jpg"))); // NOI18N
        jPanel13.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 300, 310));

        jLabel72.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel72.setText("Meditation Seiza Bench");
        jPanel13.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 860, 260, 30));

        jLabel73.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel73.setText("Quantity:");
        jPanel13.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 920, 90, 30));

        jSpinner8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner8.setBorder(null);
        jPanel13.add(jSpinner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 925, -1, -1));

        jLabel98.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel98.setText("Price: TK 120");
        jPanel13.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 890, 210, 30));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/the  calm medi cushion.png"))); // NOI18N
        jPanel13.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 300, 330));

        jLabel118.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel118.setText("The Calm Meditation Cushion");
        jPanel13.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, 290, 30));

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cushion merch1.png"))); // NOI18N
        jPanel13.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 1050, 300, 330));

        jLabel120.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel120.setText("Motorized Meditation Timer");
        jPanel13.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1370, 260, 30));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black and white round yoga mat 1.jpg"))); // NOI18N
        jPanel13.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 300, 330));

        jLabel122.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel122.setText("Black and White Round Yoga Mat");
        jPanel13.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 860, 320, 30));

        jLabel124.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel124.setText("Comfy Meditation Blanket");
        jPanel13.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1370, 260, 30));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/motorized medi timer.jpg"))); // NOI18N
        jPanel13.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1140, 300, 230));

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medi blanket.jpg"))); // NOI18N
        jPanel13.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1040, 300, 330));

        cushion1info.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info.setText("Add to cart");
        cushion1info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1infoActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 1470, 120, 30));

        jLabel151.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel151.setText("Price: TK 120");
        jPanel13.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 890, 210, 30));

        jLabel152.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel152.setText("Quantity:");
        jPanel13.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 920, 90, 30));

        jSpinner20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner20.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner20.setBorder(null);
        jPanel13.add(jSpinner20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 920, -1, -1));

        yogamat.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        yogamat.setText("More Info");
        yogamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yogamatActionPerformed(evt);
            }
        });
        jPanel13.add(yogamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 960, 120, 30));

        jLabel153.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel153.setText("Price: TK 120");
        jPanel13.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 890, 210, 30));

        jLabel154.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel154.setText("Quantity:");
        jPanel13.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 920, 90, 30));

        jSpinner21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner21.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner21.setBorder(null);
        jPanel13.add(jSpinner21, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 920, -1, -1));

        medibench.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        medibench.setText("More Info");
        medibench.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medibenchActionPerformed(evt);
            }
        });
        jPanel13.add(medibench, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 960, 120, 30));

        jLabel155.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel155.setText("Price: TK 120");
        jPanel13.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1400, 210, 30));

        jLabel156.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel156.setText("Quantity:");
        jPanel13.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1430, 90, 30));

        jSpinner22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner22.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner22.setBorder(null);
        jPanel13.add(jSpinner22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1430, -1, -1));

        mediblanket.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        mediblanket.setText("More Info");
        mediblanket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediblanketActionPerformed(evt);
            }
        });
        jPanel13.add(mediblanket, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1470, 120, 30));

        jLabel157.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel157.setText("Price: TK 120");
        jPanel13.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1400, 210, 30));

        jLabel158.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel158.setText("Quantity:");
        jPanel13.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1430, 90, 30));

        jSpinner23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner23.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner23.setBorder(null);
        jPanel13.add(jSpinner23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1430, -1, -1));

        timer.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        timer.setText("More Info");
        timer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerActionPerformed(evt);
            }
        });
        jPanel13.add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1470, 120, 30));

        jLabel150.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel150.setText("ZenSpace Cushion for Meditation");
        jPanel13.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 1380, 310, 30));

        jLabel159.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel159.setText("Price: TK 120");
        jPanel13.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 1410, 210, 30));

        jLabel160.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel160.setText("Quantity:");
        jPanel13.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 1440, 90, 30));

        jSpinner24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner24.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner24.setBorder(null);
        jPanel13.add(jSpinner24, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 1440, -1, -1));

        cushion2.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion2.setText("More Info");
        cushion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion2ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 1480, 120, 30));

        cushion1.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1.setText("More Info");
        cushion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 960, 120, 30));

        cushion1info2.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info2.setText("Add to cart");
        cushion1info2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info2ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 960, 120, 30));

        cushion1info3.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info3.setText("Add to cart");
        cushion1info3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info3ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 960, 120, 30));

        cushion1info4.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info4.setText("Add to cart");
        cushion1info4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info4ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 960, 120, 30));

        cushion1info5.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info5.setText("Add to cart");
        cushion1info5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info5ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 1470, 120, 30));

        cushion1info6.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info6.setText("Add to cart");
        cushion1info6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info6ActionPerformed(evt);
            }
        });
        jPanel13.add(cushion1info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 1480, 120, 30));

        jScrollPane8.setViewportView(jPanel13);

        jPanel10.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 670));

        jTabbedPane1.addTab("merchandise", jPanel10);

        books.setBackground(new java.awt.Color(255, 238, 221));
        books.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1182, 1472));

        jPanel3.setBackground(new java.awt.Color(255, 238, 221));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookshop banner.png"))); // NOI18N
        jPanel3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1190, 450));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book6.png"))); // NOI18N
        jPanel3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 990, 260, 330));

        jLabel65.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel65.setText("Soulful Serenity");
        jPanel3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 830, 260, 30));

        jLabel66.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel66.setText("Quantity:");
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 890, 90, 30));

        jSpinner5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner5.setBorder(null);
        jPanel3.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 895, -1, -1));

        jLabel67.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel67.setText("Price: TK 320");
        jPanel3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 860, 120, 30));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book5.png"))); // NOI18N
        jPanel3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 280, 330));

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book4.png"))); // NOI18N
        jPanel3.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 260, 330));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/booook2.png"))); // NOI18N
        jPanel3.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 500, 260, 330));

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book1.jpeg"))); // NOI18N
        jPanel3.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1000, 280, 330));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book3.png"))); // NOI18N
        jPanel3.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1000, 260, 330));

        book1.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book1.setText("More Info");
        book1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book1ActionPerformed(evt);
            }
        });
        jPanel3.add(book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 930, 120, 30));

        jLabel135.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel135.setText("Radiant Presence");
        jPanel3.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 830, 260, 30));

        jLabel136.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel136.setText("Price: TK 400");
        jPanel3.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 860, 120, 30));

        jLabel137.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel137.setText("Quantity:");
        jPanel3.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 890, 90, 30));

        jSpinner15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner15.setBorder(null);
        jPanel3.add(jSpinner15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 890, -1, -1));

        book2.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book2.setText("More Info");
        book2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book2ActionPerformed(evt);
            }
        });
        jPanel3.add(book2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 930, 120, 30));

        jLabel138.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel138.setText("The Zen Mindset");
        jPanel3.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 830, 260, 30));

        jLabel139.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel139.setText("Price: TK 550");
        jPanel3.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 860, 120, 30));

        jLabel140.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel140.setText("Quantity:");
        jPanel3.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 890, 90, 30));

        jSpinner16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner16.setBorder(null);
        jPanel3.add(jSpinner16, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 890, -1, -1));

        book3.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book3.setText("More Info");
        book3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book3ActionPerformed(evt);
            }
        });
        jPanel3.add(book3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 930, 120, 30));

        jLabel141.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel141.setText("Journey to Stillness");
        jPanel3.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1330, 260, 30));

        jLabel142.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel142.setText("Price: TK 220");
        jPanel3.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1360, 120, 30));

        jLabel143.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel143.setText("Quantity:");
        jPanel3.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1390, 90, 30));

        jSpinner17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner17.setBorder(null);
        jPanel3.add(jSpinner17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1390, -1, -1));

        book4.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book4.setText("More Info");
        book4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book4ActionPerformed(evt);
            }
        });
        jPanel3.add(book4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1430, 120, 30));

        jLabel144.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel144.setText("Mindful Musings");
        jPanel3.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1330, 260, 30));

        jLabel145.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel145.setText("Price: TK 380");
        jPanel3.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1360, 120, 30));

        jLabel146.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel146.setText("Quantity:");
        jPanel3.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1390, 90, 30));

        jSpinner18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner18.setBorder(null);
        jPanel3.add(jSpinner18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1390, -1, -1));

        book5.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book5.setText("More Info");
        book5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book5ActionPerformed(evt);
            }
        });
        jPanel3.add(book5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1430, 120, 30));

        jLabel147.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel147.setText("Awakening the Soul");
        jPanel3.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1320, 260, 30));

        jLabel148.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel148.setText("Price: TK 530");
        jPanel3.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1350, 120, 30));

        jLabel149.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel149.setText("Quantity:");
        jPanel3.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1380, 90, 30));

        jSpinner19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSpinner19.setBorder(null);
        jPanel3.add(jSpinner19, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 1380, -1, -1));

        book6.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        book6.setText("More Info");
        book6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book6ActionPerformed(evt);
            }
        });
        jPanel3.add(book6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1420, 120, 30));

        cushion1info7.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info7.setText("Add to cart");
        cushion1info7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info7ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 930, 120, 30));

        cushion1info8.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info8.setText("Add to cart");
        cushion1info8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info8ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 930, 120, 30));

        cushion1info9.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info9.setText("Add to cart");
        cushion1info9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info9ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 930, 120, 30));

        cushion1info10.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info10.setText("Add to cart");
        cushion1info10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info10ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1430, 120, 30));

        cushion1info11.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info11.setText("Add to cart");
        cushion1info11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info11ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 1430, 120, 30));

        cushion1info12.setFont(new java.awt.Font("Century", 1, 15)); // NOI18N
        cushion1info12.setText("Add to cart");
        cushion1info12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cushion1info12ActionPerformed(evt);
            }
        });
        jPanel3.add(cushion1info12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 1420, 120, 30));

        jScrollPane1.setViewportView(jPanel3);

        books.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1180, 650));

        jTabbedPane1.addTab("books", books);

        shoppanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1180, 1910));

        tabbedpanels.addTab("shop", shoppanel);

        jPanel1.add(tabbedpanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -40, 1180, 830));

        LogoZenSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ZenSpace Logo.png"))); // NOI18N
        jPanel1.add(LogoZenSpace, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -10, 390, 150));

        jPanel2.setBackground(new java.awt.Color(255, 228, 201));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Stress.setBackground(new java.awt.Color(255, 255, 255));
        Stress.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        Stress.setText("     Stress Reduction");
        Stress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        Stress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stress.setOpaque(true);
        Stress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StressMouseClicked(evt);
            }
        });
        jPanel2.add(Stress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 210, 40));

        focus.setBackground(new java.awt.Color(255, 255, 255));
        focus.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        focus.setText("     Improve Focus");
        focus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        focus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        focus.setOpaque(true);
        focus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                focusMouseClicked(evt);
            }
        });
        jPanel2.add(focus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 210, 40));

        self.setBackground(new java.awt.Color(255, 255, 255));
        self.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        self.setText("    Self Improvement");
        self.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        self.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        self.setOpaque(true);
        self.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selfMouseClicked(evt);
            }
        });
        jPanel2.add(self, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 210, 40));

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        Home.setText("Home");
        Home.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home.setOpaque(true);
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        jPanel2.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 40));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search icon.png"))); // NOI18N
        search.setText("Search");
        search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.setOpaque(true);
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 110, 40));

        helpline.setBackground(new java.awt.Color(255, 255, 255));
        helpline.setFont(new java.awt.Font("Century", 1, 17)); // NOI18N
        helpline.setText("            Helpline");
        helpline.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        helpline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpline.setOpaque(true);
        helpline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helplineMouseClicked(evt);
            }
        });
        jPanel2.add(helpline, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 210, 40));

        profile.setBackground(new java.awt.Color(255, 255, 255));
        profile.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user icon.png"))); // NOI18N
        profile.setText("Profile");
        profile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.setOpaque(true);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 100, 40));

        Donate.setBackground(new java.awt.Color(255, 255, 255));
        Donate.setFont(new java.awt.Font("Century", 1, 17)); // NOI18N
        Donate.setText("             Donate");
        Donate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        Donate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Donate.setOpaque(true);
        Donate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DonateMouseClicked(evt);
            }
        });
        jPanel2.add(Donate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 210, 40));

        Shop.setBackground(new java.awt.Color(255, 255, 255));
        Shop.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        Shop.setText("              Shop");
        Shop.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        Shop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Shop.setOpaque(true);
        Shop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShopMouseClicked(evt);
            }
        });
        jPanel2.add(Shop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 210, 40));

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jLabel74.setText("Logout");
        jLabel74.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel74.setOpaque(true);
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, 100, 40));

        mainpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg2.png"))); // NOI18N
        jPanel2.add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1540, 880));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 790));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Homepage Background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 790));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
        
    public void setColor(JLabel p){
        p.setBackground(new Color(255,208,153));
    }
    
    public void resetColor(JLabel p1){
        p1.setBackground(new Color(255,255,255));
    }   
    public void setColor(JButton p){
        p.setBackground(new Color(255,208,153));
    }
    
    public void resetColor(JButton p1){
        p1.setBackground(new Color(255,255,255));
    }   
    
    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_crossMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(0);
        setColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
       // resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(Shop);
        resetColor(Donate);
        resetColor(profile);
    }//GEN-LAST:event_HomeMouseClicked

    private void StressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StressMouseClicked
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(1);
        resetColor(Home);
        setColor(Stress);
        resetColor(focus);
        resetColor(self);
       // resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Donate);
        resetColor(Shop);
    }//GEN-LAST:event_StressMouseClicked

    private void focusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_focusMouseClicked
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(2);
        resetColor(Home);
        resetColor(Stress);
        setColor(focus);
        resetColor(self);
       // resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Shop);
        resetColor(Donate);
    }//GEN-LAST:event_focusMouseClicked

    private void selfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selfMouseClicked
        // TODO add your handling code here:
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(3);
        resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        setColor(self);
        //resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Donate);
        resetColor(Shop);
    }//GEN-LAST:event_selfMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(5);
        resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
       // resetColor(article);
        setColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Donate);
        resetColor(Shop);
    }//GEN-LAST:event_searchMouseClicked

    private void helplineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helplineMouseClicked
        // TODO add your handling code here:
        if(clip!=null) clip.close();
        tabbedpanels.setSelectedIndex(6);
        resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
       // resetColor(article);
        resetColor(search);
        setColor(helpline);
        resetColor(profile);
        resetColor(Donate);
        resetColor(Shop);
    }//GEN-LAST:event_helplineMouseClicked

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
        if (clip != null) {
            // Set the position to the saved value
            clip.setMicrosecondPosition(CurrentFrame);
            
            // Start playing from the saved position
            clip.start();
        }
        //jLabel123.setText(NowPlaying);
        PlayButton.setVisible(false);
        ResumeButton.setVisible(true);
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void ResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeButtonActionPerformed
        if (clip != null && clip.isRunning()) {
            // Save the current position
            CurrentFrame = clip.getMicrosecondPosition();
            
            // Stop the clip
            clip.stop();
        }
        PlayButton.setVisible(true);
        ResumeButton.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_ResumeButtonActionPerformed

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
        new homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel74MouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        // TODO add your handling code here:
        if(clip!=null) clip.close();
        UserProfile up = new UserProfile(user);
        up.setVisible(true);
        this.setVisible(false);
        resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
       // resetColor(article);
        resetColor(search);
        resetColor(helpline);
        setColor(profile);
        resetColor(Shop);
        resetColor(Donate);
        
    }//GEN-LAST:event_profileMouseClicked

    private void DonateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DonateMouseClicked
        // TODO add your handling code here:
        tabbedpanels.setSelectedIndex(8);
        if(clip!=null) clip.close();
        resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
//        resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Shop);
        setColor(Donate);
    }//GEN-LAST:event_DonateMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tendolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tendolActionPerformed
        // TODO add your handling code here:
        if(tendol.isSelected() == true){
            totaldol.setText("$10.00");
        }
    }//GEN-LAST:event_tendolActionPerformed

    private void yourchoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourchoiceActionPerformed
        if(yourchoice.isSelected()){
            enteramountlabel.setVisible(true);
            enteryouramount.setVisible(true);
            okbutton.setVisible(true);
        }
    }//GEN-LAST:event_yourchoiceActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void twenfivedolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twenfivedolActionPerformed
        // TODO add your handling code here:
        if(twenfivedol.isSelected() == true){
            totaldol.setText("$25.00");
        }
    }//GEN-LAST:event_twenfivedolActionPerformed

    private void fiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyActionPerformed
        // TODO add your handling code here:
        if(fifty.isSelected() == true){
            totaldol.setText("$50.00");
        }
    }//GEN-LAST:event_fiftyActionPerformed

    private void hundredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredActionPerformed
        // TODO add your handling code here:
        if(hundred.isSelected() == true){
            totaldol.setText("$100.00");
        }
    }//GEN-LAST:event_hundredActionPerformed

    private void hundfiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundfiftyActionPerformed
        // TODO add your handling code here:
        if(hundfifty.isSelected() == true){
            totaldol.setText("$150.00");
        }
    }//GEN-LAST:event_hundfiftyActionPerformed

    private void twohundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twohundActionPerformed
        // TODO add your handling code here:
        if(twohund.isSelected() == true){
            totaldol.setText("$200.00");
        }
    }//GEN-LAST:event_twohundActionPerformed

    private void okbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbuttonActionPerformed
        // TODO add your handling code here:
        totaldol.setText(enteryouramount.getText());
        
    }//GEN-LAST:event_okbuttonActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "You made a donation!");
    }//GEN-LAST:event_submitActionPerformed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
        setColor(jButton12);
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        // TODO add your handling code here:
       // resetColor(jButton);
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        new QuizPage(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void ShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopMouseClicked
        // TODO add your handling code here:
        if(clip!=null) clip.close(); 
        tabbedpanels.setSelectedIndex(9);
         resetColor(Home);
        resetColor(Stress);
        resetColor(focus);
        resetColor(self);
//        resetColor(article);
        resetColor(search);
        resetColor(helpline);
        resetColor(profile);
        resetColor(Donate);
        setColor(Shop);
        
    }//GEN-LAST:event_ShopMouseClicked

    private void cushion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b> In Stock<br>" +
        "<b>Design:</b> Custom App Logo<br>" +
        "<b>Material:</b> Soft Polyester Blend<br>" +
        "<b>Size:</b> 45x45 cm (18x18 inches)<br><br>" +
        //"Introducing our Merchandise Cushion featuring your favorite app's custom logo! Made from a soft and durable polyester blend, this cushion adds a touch of your app's identity to your living space. It's not just a cushion; it's a statement of your passion for our app.<br><br>" +
        "<b>Features:</b><br>" +
        "&bull; High-quality custom logo<br>" +
        "&bull; Comfortable and supportive<br>" +
        "&bull; Adds a personalized touch to your decor<br><br>" +
        "<b>Warning:</b> Spot clean with mild detergent for best care to preserve the logo's vibrancy.</html>");

    }//GEN-LAST:event_cushion2ActionPerformed

    private void timerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b> In Stock<br>" +
        "<b>Color:</b> Silver<br>" +
        "<b>Material:</b> High-Quality Plastic and Metal<br>" +
        "<b>Size:</b> 10x10x5 cm (4x4x2 inches)<br><br>" +
        "<b>Features:</b><br>" +
        "&bull; Adjustable timer settings<br>" +
        "&bull; Silent operation<br>" +
        "&bull; LED display<br>" +
        "&bull; Rechargeable battery<br><br>" +
        "<font color='red'><b>Warning:</b></font> Keep the timer away from water and extreme temperatures to ensure its longevity.</html>");

    }//GEN-LAST:event_timerActionPerformed

    private void mediblanketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediblanketActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b><font color='red'>Out of stock!<br></font>" +
        "<b>Color:</b> Grey and White<br>" +
        "<b>Material:</b> Soft Cotton Blend<br>" +
        "<b>Size:</b> 150x75 cm (59x29.5 inches)<br><br>" +
        "Made from a soft cotton blend.<br><br>" +
        "<font color='red'><b>Warning:</b></font> Machine wash in cold water with like colors, and tumble dry on low for best care.</html>");

    }//GEN-LAST:event_mediblanketActionPerformed

    private void medibenchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medibenchActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b> In Stock<br>" +
        "<b>Color:</b> Natural Wood Finish<br>" +
        "<b>Material:</b> Solid Pine Wood<br>" +
        "<b>Size:</b> 46x18x18 cm (18x7x7 inches)<br><br>" +
        "Crafted from solid pine wood, this bench provides excellent support for your meditation practice.<br><br>" +
        "<font color='red'><b>Warning:</b></font> Keep away from excessive moisture and direct sunlight to preserve the wood's beauty.</html>");

    }//GEN-LAST:event_medibenchActionPerformed

    private void yogamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yogamatActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b> In Stock<br>" +
        "<b>Color:</b> Ocean Blue<br>" +
        "<b>Material:</b> Eco-friendly TPE<br>" +
        "<b>Size:</b> 183x61 cm (72x24 inches)<br><br>" +
        "<font color='red'><b>Warning:</b></font> Clean with mild soap and water only. Avoid abrasive cleaners.</html>");

    }//GEN-LAST:event_yogamatActionPerformed

    private void cushion1infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1infoActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner22.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("Comfy Meditation Blanket");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner22.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }

    }//GEN-LAST:event_cushion1infoActionPerformed

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        // TODO add your handling code here:
        Cart c = new Cart(CartProduct,CartType,CartPrice,CartQuantity,user);
        c.setVisible(true);
        this.setVisible(false);
           
    }//GEN-LAST:event_cartMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void paidcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paidcourseMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_paidcourseMouseClicked

    private void cushion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Product Information:</b><br><br>" +
        "<b>Stock:</b> In Stock<br>" +
        "<b>Color:</b> Black and White<br>" +
        "<b>Material:</b> Cotton<br>" +
        "<b>Size:</b> 32x32 cm<br><br>" +
        "<font color='red'><b>Warning:</b></font> Do Not Bleach!</html>");
    }//GEN-LAST:event_cushion1ActionPerformed

    private void cushion1info2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info2ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner8.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("The Calm Meditation Cushion");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner8.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info2ActionPerformed

    private void cushion1info3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info3ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner20.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("Black and White Round Yoga Mat");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner20.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info3ActionPerformed

    private void cushion1info4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info4ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner21.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("Meditation Seiza Bench");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner21.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info4ActionPerformed

    private void cushion1info5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info5ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner23.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("Motorized Meditation Timer");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner23.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info5ActionPerformed

    private void cushion1info6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info6ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner24.getValue()!=0){
        CartType.add("Merchandise");
        CartProduct.add("ZenSpace Cushion for Meditation");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner24.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info6ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner2.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("Nature Meditation Course");
        CartPrice.add(3000);
        CartQuantity.add((Integer) jSpinner2.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void course1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Course Information:</b><br><br>" +
        "<b>Course Name:</b> How To Meditate<br>" +
        "<b>Teachers:</b> 2 Meditation Instructors<br>" +
        "&emsp;1. Sarah Johnson<br>" +
        "&emsp;2. David Lee<br>" +
        "<b>Duration:</b> 8 Weeks<br>" +
        //"<b>Course Description:</b><br>" +
        //"Embark on a transformative journey with our Mindful Meditation Mastery course. Led by experienced meditation instructors Sarah Johnson and David Lee, this 8-week program is designed to help you cultivate inner peace, reduce stress, and enhance your mindfulness practice. You'll learn a variety of meditation techniques and gain valuable insights into the art of meditation.<br><br>" +
        "<b>Key Highlights:</b><br>" +
        "&bull; Guided meditation sessions<br>" +
        "&bull; Mindfulness exercises<br>" +
        "&bull; Weekly assignments and feedback<br><br>" +
        "<b>Enrollment:</b> Limited seats available<br>" +
        "<b>Payment:</b> One-time fee of TK 6,500<br><br></html>");

    }//GEN-LAST:event_course1ActionPerformed

    private void course2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Course Information:</b><br><br>" +
        "<b>Course Name:</b>Zen Harmony<br>" +
        "<b>Teachers:</b> 1 Certified Meditation Instructor<br>" +
        "&emsp;1. Emily Davis<br>" +
        "<b>Duration:</b> 4 Weeks<br>" +
        //"<b>Course Description:</b><br>" +
        //"Embark on a journey of self-discovery and inner tranquility with our Mindfulness Meditation for Beginners course. Led by certified meditation instructor Emily Davis, this 6-week program is tailored for beginners. Learn the foundations of mindfulness meditation, breathing techniques, and simple practices that will help you find peace in the present moment.<br><br>" +
        "<b>Key Highlights:</b><br>" +
        "&bull; Step-by-step guidance for beginners<br>" +
        "&bull; Daily meditation exercises<br>" +
        "&bull; Stress reduction techniques<br><br>" +
        "<b>Enrollment:</b> Open year-round<br>" +
        "<b>Payment:</b> One-time fee of TK 8,000<br><br></html>");

    }//GEN-LAST:event_course2ActionPerformed

    private void course3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Course Information:</b><br><br>" +
        "<b>Course Name:</b> Stress Free Meditation<br>" +
        "<b>Teachers:</b> 2 Experienced Meditation Instructors<br>" +
        "&emsp;1. Maya Patel<br>" +
        "&emsp;2. Alex Tran<br>" +
        "<b>Duration:</b> 5 Days<br>" +
        //"<b>Course Description:</b><br>" +
        //"Join us on a transformative journey to discover inner harmony and deep relaxation with our Inner Harmony Meditation Retreat. Led by experienced meditation instructors Maya Patel and Alex Tran, this 14-day retreat offers an immersive experience in mindfulness and self-discovery. Dive into daily meditation sessions, yoga, nature walks, and mindfulness workshops amidst the serene backdrop of a tranquil retreat center.<br><br>" +
        "<b>Key Highlights:</b><br>" +
        "&bull; Daily meditation and yoga sessions<br>" +
        "&bull; Mindful excursions<br>" +
        "&bull; Group and one-on-one guidance on self care<br><br>" +
        "<b>Enrollment:</b> Limited spaces available<br>" +
        "<b>Payment:</b> Retreat package starting at TK 4,500<br><br></html>");

    }//GEN-LAST:event_course3ActionPerformed

    private void course4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Course Information:</b><br><br>" +
        "<b>Course Name:</b> Nature Meditation Journey<br>" +
        "<b>Teachers:</b> 1 Nature Meditation Guide<br>" +
        "&emsp;1. Rebecca Woods<br>" +
        "<b>Duration:</b> 30 Days<br>" +
        //"<b>Course Description:</b><br>" +
        //"Embark on a 30-day Nature Meditation Journey guided by experienced nature meditation guide, Rebecca Woods. Discover the profound healing and inner peace that connecting with nature can bring. This course will take you on a virtual journey through natural landscapes, teaching you how to use nature as a source of meditation, inspiration, and rejuvenation.<br><br>" +
        "<b>Key Highlights:</b><br>" +
        "&bull; Daily guided nature meditations<br>" +
        "&bull; Connection with the natural world<br>" +
        "&bull; Mindful practices for stress relief<br><br>" +
        "<b>Enrollment:</b> Open year-round<br>" +
        "<b>Payment:</b> One-time fee of TK 3,000<br><br></html>");

    }//GEN-LAST:event_course4ActionPerformed

    private void course5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Course Information:</b><br><br>" +
        "<b>Course Name:</b> Breaking Bad...Habits<br>" +
        "<b>Instructor:</b> Behavioral Psychologist, Dr. Lisa Adams<br>" +
        "<b>Duration:</b> 8 Weeks<br>" +
        //"<b>Course Description:</b><br>" +
        //"Join Dr. Lisa Adams in our Breaking Bad Habits Mastery course. Over 8 transformative weeks, you'll gain the tools and insights needed to break free from unwanted habits and lead a healthier, more fulfilling life. Dr. Adams, a seasoned behavioral psychologist, will guide you through evidence-based strategies, mindfulness techniques, and personalized coaching to help you overcome even the most stubborn habits.<br><br>" +
        "<b>Key Highlights:</b><br>" +
        "&bull; Weekly group coaching sessions<br>" +
        "&bull; Personalized habit analysis<br>" +
        "&bull; Practical exercises and assignments<br><br>" +
        "<b>Enrollment:</b> Limited seats available<br>" +
        "<b>Payment:</b> One-time fee of TK 5,500<br><br></html>");

    }//GEN-LAST:event_course5ActionPerformed

    private void cd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd1ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner11.getValue()!=0){
        CartType.add("Album");
        CartProduct.add("Cognitive Zenith-Focus Meditation Soundtracks");
        CartPrice.add(110);
        CartQuantity.add((Integer) jSpinner9.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }

    }//GEN-LAST:event_cd1ActionPerformed

    private void cd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Calm the Chaos<br>" +
        "<b>Artist:</b> Mindful Harmonies Ensemble<br>" +
        "<b>Genre:</b> Meditation and Relaxation<br>" +
        "<b>Duration:</b> 45 Minutes<br>" +
        "<b>Album Description:</b><br>" +
        "Escape the hustle and bustle of everyday life with 'Calm the Chaos,' an enchanting digital album by the Mindful Harmonies Ensemble.<br><br>" +
        
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> TK 70<br><br>" +
        "<b>Warning:</b> Find a quiet and comfortable space to fully appreciate the calming effects of this album. Allow yourself to be carried away by its soothing melodies.</html>");

        
    }//GEN-LAST:event_cd2ActionPerformed

    private void cd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Nirvana: Sleep Meditation Soundtrack<br>" +
        "<b>Artist:</b> Tranquil Dreams Ensemble<br>" +
        "<b>Genre:</b> Sleep Meditation Music<br>" +
        "<b>Duration:</b> 2 Hours<br>" +
        "<b>Album Description:</b><br>" +
        "Experience the ultimate relaxation with 'Nirvana: Sleep Meditation Soundtrack,' an extraordinary digital album by the Tranquil Dreams Ensemble.<br><br>" +
        
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> TK 200<br><br></html>");

    }//GEN-LAST:event_cd3ActionPerformed

    private void cd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Euphoria: Relaxation Soundtrack<br>" +
        "<b>Artist:</b> Serene Harmonies Collective<br>" +
        "<b>Genre:</b> Relaxation and Serenity<br>" +
        "<b>Duration:</b> 1 Hour and 30 Minutes<br>" +
        "<b>Album Description:</b><br>" +
        "Discover pure bliss and tranquility with 'Euphoria: Relaxation Soundtrack,' an enchanting digital album by the Serene Harmonies Collective.<br><br>" +
        
        "&bull; 'Serenity's Embrace'<br><br>" +
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> TK 50<br><br></html>");

    }//GEN-LAST:event_cd4ActionPerformed

    private void cd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Mind's Eye Mystery<br>" +
        "<b>Artist:</b> Enigmatic Soundscapes<br>" +
        "<b>Genre:</b> Ambient and Mystical<br>" +
        "<b>Duration:</b> 1 Hour and 15 Minutes<br>" +
        "<b>Album Description:</b><br>" +
        "Embark on an enigmatic journey of the imagination with 'Mind's Eye Mystery,' a captivating digital album by Enigmatic Soundscapes.<br><br>" +
        
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> $15.99<br><br></html>");

    }//GEN-LAST:event_cd5ActionPerformed

    private void cd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Cognitive Zenith<br>" +
        "<b>Artist:</b> ZenMind Compositions<br>" +
        "<b>Genre:</b> Ambient and Cognitive Enhancement<br>" +
        "<b>Duration:</b> 1 Hour and 45 Minutes<br>" +
        "<b>Album Description:<br><br>" +
        
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> $19.99<br><br></html>");

    }//GEN-LAST:event_cd6ActionPerformed

    private void cd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Album Information:</b><br><br>" +
        "<b>Album Title:</b> Breathe Easy<br>" +
        "<b>Artist:</b> Tranquil Waves Ensemble<br>" +
        "<b>Genre:</b> Relaxation and Meditation<br>" +
        "<b>Duration:</b> 1 Hour and 15 Minutes<br>" +
        "<b>Album Description:</b><br>" +
        "Experience a serene escape from the stresses of life with 'Breathe Easy,' a captivating digital album by the Tranquil Waves Ensemble.<br>" +
        
        "<b>Availability:</b> Digital download<br>" +
        "<b>Price:</b> TK 120</html>");

    }//GEN-LAST:event_cd7ActionPerformed

    private void cd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd8ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner11.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("Breathe Easy Digital Album");
        CartPrice.add(120);
        CartQuantity.add((Integer) jSpinner11.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cd8ActionPerformed

    private void cd9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd9ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner10.getValue()!=0){
        CartType.add("Album");
        CartProduct.add("Breathe Easy Digital Album");
        CartPrice.add(70);
        CartQuantity.add((Integer) jSpinner10.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cd9ActionPerformed

    private void cd10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd10ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner4.getValue()!=0){
        CartType.add("Album");
        CartProduct.add("NIRVANA- Sleep Meditation Soundtrack");
        CartPrice.add(200);
        CartQuantity.add((Integer) jSpinner4.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cd10ActionPerformed

    private void cd11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd11ActionPerformed
        // TODO add your handling code here:
                if((Integer)jSpinner12.getValue()!=0){
        CartType.add("Album");
        CartProduct.add("Euphoria- Relaxation Soundtrack");
        CartPrice.add(50);
        CartQuantity.add((Integer) jSpinner12.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cd11ActionPerformed

    private void cd12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cd12ActionPerformed
        // TODO add your handling code here:
                if((Integer)jSpinner13.getValue()!=0){
        CartType.add("Album");
        CartProduct.add("Mind's Eye Mystery-Guided Focus Meditation");
        CartPrice.add(150);
        CartQuantity.add((Integer) jSpinner13.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cd12ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner1.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("How To Meditate Course");
        CartPrice.add(6500);
        CartQuantity.add((Integer) jSpinner1.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner6.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("Zen Harmony - 30 Days Meditation Challange");
        CartPrice.add(8000);
        CartQuantity.add((Integer) jSpinner6.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner3.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("Self Care Essential");
        CartPrice.add(4500);
        CartQuantity.add((Integer) jSpinner3.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner7.getValue()!=0){
        CartType.add("Course");
        CartProduct.add("Breaking Bad Habit Course");
        CartPrice.add(5500);
        CartQuantity.add((Integer) jSpinner7.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void book6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> Awakening the Soul<br>" +
            "<b>Author:</b> Liam Carter<br>" +
            "<b>Genre:</b> Spiritual Awakening and Self-Discovery<br>" +
            "<b>Pages:</b> 620<br>" +
            "<b>Book Description:</b><br>" +
            "Embark on a profound spiritual journey towards self-discovery and soul awakening with 'Awakening the Soul,' an enlightening book by author Sophia Roberts.<br>" +
            "<b>Availability:</b> Hardcover and eBook<br>" +
            "<b>Price:</b> Hardcover TK 530, eBook TK 250</html>");
    }//GEN-LAST:event_book6ActionPerformed

    private void book5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> Mindful Musings<br>" +
            "<b>Author:</b> Olivia Benson<br>" +
            "<b>Genre:</b> Mindfulness and Reflection<br>" +
            "<b>Pages:</b> 350<br>" +
            "<b>Book Description:</b><br>" +
            "Embark on a reflective journey of mindfulness and self-discovery with 'Mindful Musings,' a thought-provoking book by author Jessica Miller.<br>" +
            "<b>Availability:</b> Paperback and eBook<br>" +
            "<b>Price:</b> Paperback TK 380, eBook TK 120</html>");
    }//GEN-LAST:event_book5ActionPerformed

    private void book4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> Journey to Stillness<br>" +
            "<b>Author:</b> Sophia Green<br>" +
            "<b>Genre:</b> Meditation and Inner Peace<br>" +
            "<b>Pages:</b> 176<br>" +
            "<b>Book Description:</b><br>" +
            "Embark on a profound inner journey towards tranquility and stillness with 'Journey to Stillness,' a heartfelt book by meditation enthusiast Sarah Davis.<br><br>" +
            "<b>Availability:</b> Paperback and eBook<br>" +
            "<b>Price:</b> Paperback $16.99, eBook $8.99</html>");
    }//GEN-LAST:event_book4ActionPerformed

    private void book3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> The Zen Mindset<br>" +
            "<b>Author:</b> Camille and Matthew<br>" +
            "<b>Genre:</b> Personal Development and Zen Philosophy<br>" +
            "<b>Pages:</b> 620<br>" +
            "<b>Book Description:</b><br>" +
            "Discover the path to personal transformation and inner peace with 'The Zen Mindset,' an enlightening book by author Jonathan Lee. <br><br>" +
            "<b>Availability:</b> Hardcover and eBook<br>" +
            "<b>Price:</b> Hardcover TK 550, eBook TK 200</html>");
    }//GEN-LAST:event_book3ActionPerformed

    private void book2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> Radiant Presence<br>" +
            "<b>Author:</b> Zenovar Peacehaven<br>" +
            "<b>Genre:</b> Meditation and Self-Discovery<br>" +
            "<b>Pages:</b> 344<br>" +
            "<b>Book Description:</b><br>" +
            "Embark on a profound journey of self-discovery and inner radiance with 'Radiant Presence,' a transformative book by meditation expert Laura Mitchell.<br><br>" +

            "<b>Availability:</b>Paperback, and eBook<br>" +
            "<b>Price:</b>Paperback TK 400, eBook TK 190</html>");
    }//GEN-LAST:event_book2ActionPerformed

    private void book1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "<html><b>Book Information:</b><br><br>" +
            "<b>Book Title:</b> Soulful Serenity<br>" +
            "<b>Author:</b> Emily Mitchell<br>" +
            "<b>Genre:</b> Self-Help and Mindfulness<br>" +
            "<b>Pages:</b> 240<br>" +
            "<b>Book Description:</b><br>" +
            "Explore the path to inner peace and personal transformation with 'Soulful Serenity,' an inspiring book by renowned author Emma Thompson.<br><br>" +
            "<b>Availability:</b> Paperback and eBook<br>" +
            "<b>Price:</b> Paperback TK 320, eBook TK 150</html>");
    }//GEN-LAST:event_book1ActionPerformed

    private void cushion1info7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info7ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner5.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("Soulful Serenity");
        CartPrice.add(320);
        CartQuantity.add((Integer) jSpinner5.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info7ActionPerformed

    private void cushion1info8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info8ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner15.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("Radiant Presence");
        CartPrice.add(400);
        CartQuantity.add((Integer) jSpinner15.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info8ActionPerformed

    private void cushion1info9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info9ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner16.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("The Zen Mindset");
        CartPrice.add(550);
        CartQuantity.add((Integer) jSpinner16.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info9ActionPerformed

    private void cushion1info10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info10ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner17.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("Journey to Stillness");
        CartPrice.add(220);
        CartQuantity.add((Integer) jSpinner17.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info10ActionPerformed

    private void cushion1info11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info11ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner18.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("Mindful Musings");
        CartPrice.add(380);
        CartQuantity.add((Integer) jSpinner18.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info11ActionPerformed

    private void cushion1info12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cushion1info12ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner19.getValue()!=0){
        CartType.add("Books");
        CartProduct.add("Awakening the Soul");
        CartPrice.add(580);
        CartQuantity.add((Integer) jSpinner19.getValue());
        JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cushion1info12ActionPerformed

    private void ResumeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeButton1ActionPerformed
        // TODO add your handling code here:
//                obj.pause();
//        CurrentFrame=obj.clip.getMicrosecondPosition();
            if (clip != null && clip.isRunning()) {
            // Save the current position
            CurrentFrame = clip.getMicrosecondPosition();
            
            // Stop the clip
            clip.stop();
        }
        PlayButton1.setVisible(true);
        ResumeButton1.setVisible(false);
    }//GEN-LAST:event_ResumeButton1ActionPerformed

    private void PlayButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButton1ActionPerformed
        // TODO add your handling code here:
        if (clip != null) {
            // Set the position to the saved value
            clip.setMicrosecondPosition(CurrentFrame);
            
            // Start playing from the saved position
            clip.start();
        }
        //jLabel123.setText(NowPlaying);
        PlayButton1.setVisible(false);
        ResumeButton1.setVisible(true);
    }//GEN-LAST:event_PlayButton1ActionPerformed

    private void ResumeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeButton2ActionPerformed
        // TODO add your handling code here:
        if (clip != null && clip.isRunning()) {
            // Save the current position
            CurrentFrame = clip.getMicrosecondPosition();
            
            // Stop the clip
            clip.stop();
        }
        PlayButton2.setVisible(true);
        ResumeButton2.setVisible(false);
    }//GEN-LAST:event_ResumeButton2ActionPerformed

    private void PlayButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButton2ActionPerformed
        // TODO add your handling code here:
        if (clip != null) {
            // Set the position to the saved value
            clip.setMicrosecondPosition(CurrentFrame);
            
            // Start playing from the saved position
            clip.start();
        }
        //jLabel123.setText(NowPlaying);
        PlayButton2.setVisible(false);
        ResumeButton2.setVisible(true);
    }//GEN-LAST:event_PlayButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(clip!=null) clip.close();
        SearchMusic.removeAll();
        String text = SearchField.getText();
        SearchMusic.requestFocus();
        try {
            System.out.println(text);
            pst = con.prepareStatement("Select * From musiclist WHERE Name Like ?");
            pst.setString(1,"%"+text+"%");
            rs = pst.executeQuery();
            int yPan = 0;
            int cur = 0;
            while(rs.next()){
                cur = cur+1;
                JPanel pan = new JPanel();
                pan.setLayout(new AbsoluteLayout());
                pan.setPreferredSize(new Dimension(350,30));
                JLabel imagelab = new JLabel();
                imagelab.setPreferredSize(new Dimension(200,200));
                imagelab.setBackground(Color.red);
                imagelab.setOpaque(true);
                String name = rs.getString("Name");
                byte img[];
                img = rs.getBytes("Image");
                byte audio[] = rs.getBytes("Audio");
                JLabel namelab = new JLabel();
               // namelab.setBackground(Color.red);
                //namelab.setOpaque(true);
                namelab.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
                namelab.setText(name);
                JButton selectBut = new JButton();
                selectBut.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                selectBut.setText("Play");
                System.out.println(cur);
                if(cur % 2 == 1) pan.setBackground(new Color(242,242,242));
                else pan.setBackground(new Color(255,255,255));
                pan.setOpaque(true);
                
                
                //lab.setIcon(new ImageIcon(img));
                //lab.setVisible(true);
                ImageIcon propic = null;
                Image image=null;
               // System.out.println(lab.getWidth());
                if(img!=null){
                    propic = new ImageIcon(img);
                    image = propic.getImage().getScaledInstance(200, 200,image.SCALE_SMOOTH);
                }
                imagelab.setIcon(new ImageIcon(image));
                selectBut.addActionListener(new ActionListener() {
                @Override
                 public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                jLabel123.setText(name);
                playAudio(audio);
                 }

                private void playAudio(byte[] audio) {
                    try {
            // Convert byte array to InputStream
            if(clip!=null) clip.close();
            InputStream inputStream = new ByteArrayInputStream(audio);

            // Create an AudioInputStream from the InputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

            // Get a Clip (part of the Java Sound API)
            clip = AudioSystem.getClip();
            
            // Open the AudioInputStream to the Clip
            clip.open(audioInputStream);

            // Start playing the audio
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                 });
                pan.add(imagelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,200,150));
                pan.add(namelab,new org.netbeans.lib.awtextra.AbsoluteConstraints(220,50,800,50));
                pan.add(selectBut,new org.netbeans.lib.awtextra.AbsoluteConstraints(1030,50,100,50));
                SearchMusic.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,yPan,1180,170));
                yPan = yPan + 170;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    AudioPlayer obj;
    Long CurrentFrame;    boolean isPaused=false;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomepage("ratnajit_dhar").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Courses;
    private javax.swing.JLabel Donate;
    private javax.swing.JPanel FocusMusic;
    private javax.swing.JLabel Home;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLabel LogoZenSpace;
    private javax.swing.JButton PlayButton;
    private javax.swing.JButton PlayButton1;
    private javax.swing.JButton PlayButton2;
    private javax.swing.JButton ResumeButton;
    private javax.swing.JButton ResumeButton1;
    private javax.swing.JButton ResumeButton2;
    private javax.swing.JTextField SearchField;
    private javax.swing.JPanel SearchMusic;
    private javax.swing.JPanel SelfMusic;
    private javax.swing.JLabel Shop;
    private javax.swing.JLabel Stress;
    private javax.swing.JPanel StressMusic;
    private javax.swing.JLabel anxlabel8;
    private javax.swing.JButton book1;
    private javax.swing.JButton book2;
    private javax.swing.JButton book3;
    private javax.swing.JButton book4;
    private javax.swing.JButton book5;
    private javax.swing.JButton book6;
    private javax.swing.JPanel books;
    private javax.swing.JLabel cart;
    private javax.swing.JButton cd1;
    private javax.swing.JButton cd10;
    private javax.swing.JButton cd11;
    private javax.swing.JButton cd12;
    private javax.swing.JButton cd2;
    private javax.swing.JButton cd3;
    private javax.swing.JButton cd4;
    private javax.swing.JButton cd5;
    private javax.swing.JButton cd6;
    private javax.swing.JButton cd7;
    private javax.swing.JButton cd8;
    private javax.swing.JButton cd9;
    private javax.swing.JPanel cdpanel;
    private javax.swing.JButton course1;
    private javax.swing.JButton course2;
    private javax.swing.JButton course3;
    private javax.swing.JButton course4;
    private javax.swing.JButton course5;
    private javax.swing.JLabel cross;
    private javax.swing.JButton cushion1;
    private javax.swing.JButton cushion1info;
    private javax.swing.JButton cushion1info10;
    private javax.swing.JButton cushion1info11;
    private javax.swing.JButton cushion1info12;
    private javax.swing.JButton cushion1info2;
    private javax.swing.JButton cushion1info3;
    private javax.swing.JButton cushion1info4;
    private javax.swing.JButton cushion1info5;
    private javax.swing.JButton cushion1info6;
    private javax.swing.JButton cushion1info7;
    private javax.swing.JButton cushion1info8;
    private javax.swing.JButton cushion1info9;
    private javax.swing.JButton cushion2;
    private javax.swing.JPanel donate;
    private javax.swing.ButtonGroup donateamount;
    private javax.swing.JLabel enteramountlabel;
    private javax.swing.JTextField enteryouramount;
    private javax.swing.JRadioButton fifty;
    private javax.swing.JLabel focus;
    private javax.swing.JLabel helpline;
    private javax.swing.JPanel helplinePanel;
    private javax.swing.JRadioButton hundfifty;
    private javax.swing.JRadioButton hundred;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner17;
    private javax.swing.JSpinner jSpinner18;
    private javax.swing.JSpinner jSpinner19;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner20;
    private javax.swing.JSpinner jSpinner21;
    private javax.swing.JSpinner jSpinner22;
    private javax.swing.JSpinner jSpinner23;
    private javax.swing.JSpinner jSpinner24;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel jlabeldollar;
    private javax.swing.JLabel mainpanel;
    private javax.swing.JButton medibench;
    private javax.swing.JButton mediblanket;
    private javax.swing.JLabel minimize;
    private javax.swing.JButton okbutton;
    private javax.swing.JLabel paidcourse;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel profilee;
    private javax.swing.JLabel quote1;
    private javax.swing.JLabel quote2;
    private javax.swing.JLabel quote3;
    private javax.swing.JLabel quote4;
    private javax.swing.JLabel quote5;
    private javax.swing.JLabel search;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel self;
    private javax.swing.JPanel shoppanel;
    private javax.swing.JPanel stresspanel;
    private javax.swing.JButton submit;
    private javax.swing.JTabbedPane tabbedpanels;
    private javax.swing.JRadioButton tendol;
    private javax.swing.JButton timer;
    private javax.swing.JLabel totaldol;
    private javax.swing.JRadioButton twenfivedol;
    private javax.swing.JRadioButton twohund;
    private javax.swing.ButtonGroup typeofdon;
    private javax.swing.JButton yogamat;
    private javax.swing.JRadioButton yourchoice;
    // End of variables declaration//GEN-END:variables
}
