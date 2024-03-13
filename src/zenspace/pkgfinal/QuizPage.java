/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zenspace.pkgfinal;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class QuizPage extends javax.swing.JFrame {

    /**
     * Creates new form QuizPage
     */
    CardLayout cardLayout;
    int prevScore=50;
    String user = null;
    String prevScoreValue=Integer.toString(prevScore);
    int score=0;
            boolean never1selected = false;
        boolean always1selected = false;
        boolean rarely1selected = false;
        boolean sometimes1selected = false;
        boolean often1selected = false;

        boolean never2selected = false;
        boolean always2selected = false;
        boolean rarely2selected = false;
        boolean sometimes2selected = false;
        boolean often2selected = false;

        boolean never3selected = false;
        boolean always3selected = false;
        boolean rarely3selected = false;
        boolean sometimes3selected = false;
        boolean often3selected = false;

        boolean never4selected = false;
        boolean always4selected = false;
        boolean rarely4selected = false;
        boolean sometimes4selected = false;
        boolean often4selected = false;

        boolean never5selected = false;
        boolean always5selected = false;
        boolean rarely5selected = false;
        boolean sometimes5selected = false;
        boolean often5selected = false;

        boolean never6selected = false;
        boolean always6selected = false;
        boolean rarely6selected = false;
        boolean sometimes6selected = false;
        boolean often6selected = false;

        boolean never7selected = false;
        boolean always7selected = false;
        boolean rarely7selected = false;
        boolean sometimes7selected = false;
        boolean often7selected = false;

        boolean never8selected = false;
        boolean always8selected = false;
        boolean rarely8selected = false;
        boolean sometimes8selected = false;
        boolean often8selected = false;

        boolean never9selected = false;
        boolean always9selected = false;
        boolean rarely9selected = false;
        boolean sometimes9selected = false;
        boolean often9selected = false;

        boolean never10selected = false;
        boolean always10selected = false;
        boolean rarely10selected = false;
        boolean sometimes10selected = false;
        boolean often10selected = false;
    public QuizPage() {
        initComponents();
        jLabel2.setText(prevScoreValue);
        cardLayout = (CardLayout)(PanelForQuiz.getLayout());
        jLabel34.setVisible(false);
        jLabel35.setVisible(false);
        jLabel36.setVisible(false);
        jLabel37.setVisible(false);
        jLabel38.setVisible(false);
        jLabel39.setVisible(false);
        jLabel40.setVisible(false);
        jLabel41.setVisible(false);
        jLabel42.setVisible(false);
        jLabel43.setVisible(false);
    }
    public QuizPage(String Username){
        initComponents();
        Connect();
        jLabel2.setText(prevScoreValue);
        cardLayout = (CardLayout)(PanelForQuiz.getLayout());
        jLabel34.setVisible(false);
        jLabel35.setVisible(false);
        jLabel36.setVisible(false);
        jLabel37.setVisible(false);
        jLabel38.setVisible(false);
        jLabel39.setVisible(false);
        jLabel40.setVisible(false);
        jLabel41.setVisible(false);
        jLabel42.setVisible(false);
        jLabel43.setVisible(false);
        try {
            pst = con.prepareStatement("select * from userprofileinfo where USERNAME = ?");
            pst.setString(1, Username);
            rs = pst.executeQuery();
            while(rs.next()){
                int Score = rs.getInt("MindfulnessScore");
                jLabel2.setText(Integer.toString(Score));
            }
            //String sc = score.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuizPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        PanelForQuiz = new javax.swing.JPanel();
        Start = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        Question1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Always1 = new javax.swing.JButton();
        Never1 = new javax.swing.JButton();
        Rarely1 = new javax.swing.JButton();
        Sometimes1 = new javax.swing.JButton();
        Often1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Question2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Always2 = new javax.swing.JButton();
        Never2 = new javax.swing.JButton();
        Rarely2 = new javax.swing.JButton();
        Sometimes2 = new javax.swing.JButton();
        Often2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Question3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Always3 = new javax.swing.JButton();
        Never3 = new javax.swing.JButton();
        Rarely3 = new javax.swing.JButton();
        Sometimes3 = new javax.swing.JButton();
        Often3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Question4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Always4 = new javax.swing.JButton();
        Never4 = new javax.swing.JButton();
        Rarely4 = new javax.swing.JButton();
        Sometimes4 = new javax.swing.JButton();
        Often4 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Question5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Always5 = new javax.swing.JButton();
        Never5 = new javax.swing.JButton();
        Rarely5 = new javax.swing.JButton();
        Sometimes5 = new javax.swing.JButton();
        Often5 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Question6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Always6 = new javax.swing.JButton();
        Never6 = new javax.swing.JButton();
        Rarely6 = new javax.swing.JButton();
        Sometimes6 = new javax.swing.JButton();
        Often6 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Question7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Always7 = new javax.swing.JButton();
        Never7 = new javax.swing.JButton();
        Rarely7 = new javax.swing.JButton();
        Sometimes7 = new javax.swing.JButton();
        Often7 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Question8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Always8 = new javax.swing.JButton();
        Never8 = new javax.swing.JButton();
        Rarely8 = new javax.swing.JButton();
        Sometimes8 = new javax.swing.JButton();
        Often8 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Question9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Always9 = new javax.swing.JButton();
        Never9 = new javax.swing.JButton();
        Rarely9 = new javax.swing.JButton();
        Sometimes9 = new javax.swing.JButton();
        Often9 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Question10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Always10 = new javax.swing.JButton();
        Never10 = new javax.swing.JButton();
        Rarely10 = new javax.swing.JButton();
        Sometimes10 = new javax.swing.JButton();
        Often10 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        End = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        cross = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 238, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel1.setText("Previous Score:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 131, 156, 53));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 131, 86, 53));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 238, 221));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("This test is based on the Philadelphia Mindfulness Scale,\na scale used in academic research. [Cardaciotto, Herbert, Forman, Moitra, Farrow, 2008]");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 196, 1123, 67));

        PanelForQuiz.setBackground(new java.awt.Color(255, 204, 204));
        PanelForQuiz.setLayout(new java.awt.CardLayout());

        Start.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(224, 155, 85));
        jButton1.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Start the Quiz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Start.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 299, 84));

        jLabel32.setBackground(new java.awt.Color(255, 227, 196));
        jLabel32.setOpaque(true);
        Start.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Start, "Start");

        Question1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel4.setText("Question 1:");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Question1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("When I am startled, I notice what is going on inside my body");
        Question1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always1.setBackground(new java.awt.Color(202, 133, 64));
        Always1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always1.setForeground(new java.awt.Color(255, 255, 255));
        Always1.setText("Always");
        Always1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always1ActionPerformed(evt);
            }
        });
        Question1.add(Always1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never1.setBackground(new java.awt.Color(202, 133, 64));
        Never1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never1.setForeground(new java.awt.Color(255, 255, 255));
        Never1.setText("Never");
        Never1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never1ActionPerformed(evt);
            }
        });
        Question1.add(Never1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely1.setBackground(new java.awt.Color(202, 133, 64));
        Rarely1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely1.setForeground(new java.awt.Color(255, 255, 255));
        Rarely1.setText("Rarely");
        Rarely1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely1ActionPerformed(evt);
            }
        });
        Question1.add(Rarely1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes1.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes1.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes1.setText("Sometimes");
        Sometimes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes1ActionPerformed(evt);
            }
        });
        Question1.add(Sometimes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often1.setBackground(new java.awt.Color(202, 133, 64));
        Often1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often1.setForeground(new java.awt.Color(255, 255, 255));
        Often1.setText("Often");
        Often1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often1ActionPerformed(evt);
            }
        });
        Question1.add(Often1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel34.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel34.setText("*Select one option to proceed");
        Question1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel44.setBackground(new java.awt.Color(197, 121, 45));
        jLabel44.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("            Next");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel44.setOpaque(true);
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel44MouseEntered(evt);
            }
        });
        Question1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel5.setBackground(new java.awt.Color(255, 227, 196));
        jLabel5.setOpaque(true);
        Question1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question1, "Question1");

        Question2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel6.setText("Question 2:");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        Question2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel9.setText("I find it hard to calm my mind while sleeping");
        Question2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always2.setBackground(new java.awt.Color(202, 133, 64));
        Always2.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always2.setForeground(new java.awt.Color(255, 255, 255));
        Always2.setText("Always");
        Always2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always2ActionPerformed(evt);
            }
        });
        Question2.add(Always2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never2.setBackground(new java.awt.Color(202, 133, 64));
        Never2.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never2.setForeground(new java.awt.Color(255, 255, 255));
        Never2.setText("Never");
        Never2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never2ActionPerformed(evt);
            }
        });
        Question2.add(Never2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely2.setBackground(new java.awt.Color(202, 133, 64));
        Rarely2.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely2.setForeground(new java.awt.Color(255, 255, 255));
        Rarely2.setText("Rarely");
        Rarely2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely2ActionPerformed(evt);
            }
        });
        Question2.add(Rarely2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes2.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes2.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes2.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes2.setText("Sometimes");
        Sometimes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes2ActionPerformed(evt);
            }
        });
        Question2.add(Sometimes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often2.setBackground(new java.awt.Color(202, 133, 64));
        Often2.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often2.setForeground(new java.awt.Color(255, 255, 255));
        Often2.setText("Often");
        Often2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often2ActionPerformed(evt);
            }
        });
        Question2.add(Often2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel35.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel35.setText("*Select one option to proceed");
        Question2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel45.setBackground(new java.awt.Color(202, 133, 64));
        jLabel45.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("            Next");
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel45.setOpaque(true);
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Question2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel10.setBackground(new java.awt.Color(255, 227, 196));
        jLabel10.setOpaque(true);
        Question2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question2, "Question2");

        Question3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel11.setText("Question 3:");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        Question3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel12.setText("I am aware of what thoughts are passing through my mind");
        Question3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always3.setBackground(new java.awt.Color(202, 133, 64));
        Always3.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always3.setForeground(new java.awt.Color(255, 255, 255));
        Always3.setText("Always");
        Always3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always3ActionPerformed(evt);
            }
        });
        Question3.add(Always3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never3.setBackground(new java.awt.Color(202, 133, 64));
        Never3.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never3.setForeground(new java.awt.Color(255, 255, 255));
        Never3.setText("Never");
        Never3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never3ActionPerformed(evt);
            }
        });
        Question3.add(Never3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely3.setBackground(new java.awt.Color(202, 133, 64));
        Rarely3.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely3.setForeground(new java.awt.Color(255, 255, 255));
        Rarely3.setText("Rarely");
        Rarely3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely3ActionPerformed(evt);
            }
        });
        Question3.add(Rarely3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes3.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes3.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes3.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes3.setText("Sometimes");
        Sometimes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes3ActionPerformed(evt);
            }
        });
        Question3.add(Sometimes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often3.setBackground(new java.awt.Color(202, 133, 64));
        Often3.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often3.setForeground(new java.awt.Color(255, 255, 255));
        Often3.setText("Often");
        Often3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often3ActionPerformed(evt);
            }
        });
        Question3.add(Often3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel36.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel36.setText("*Select one option to proceed");
        Question3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel46.setBackground(new java.awt.Color(202, 133, 64));
        jLabel46.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("            Next");
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel46.setOpaque(true);
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        Question3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel13.setBackground(new java.awt.Color(255, 227, 196));
        jLabel13.setOpaque(true);
        Question3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question3, "Question3");

        Question4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel14.setText("Question 4:");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        Question4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel15.setText("I try to distract myself when I feel unpleasant emotions");
        Question4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always4.setBackground(new java.awt.Color(202, 133, 64));
        Always4.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always4.setForeground(new java.awt.Color(255, 255, 255));
        Always4.setText("Always");
        Always4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always4ActionPerformed(evt);
            }
        });
        Question4.add(Always4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never4.setBackground(new java.awt.Color(202, 133, 64));
        Never4.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never4.setForeground(new java.awt.Color(255, 255, 255));
        Never4.setText("Never");
        Never4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never4ActionPerformed(evt);
            }
        });
        Question4.add(Never4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely4.setBackground(new java.awt.Color(202, 133, 64));
        Rarely4.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely4.setForeground(new java.awt.Color(255, 255, 255));
        Rarely4.setText("Rarely");
        Rarely4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely4ActionPerformed(evt);
            }
        });
        Question4.add(Rarely4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes4.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes4.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes4.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes4.setText("Sometimes");
        Sometimes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes4ActionPerformed(evt);
            }
        });
        Question4.add(Sometimes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often4.setBackground(new java.awt.Color(202, 133, 64));
        Often4.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often4.setForeground(new java.awt.Color(255, 255, 255));
        Often4.setText("Often");
        Often4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often4ActionPerformed(evt);
            }
        });
        Question4.add(Often4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel37.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel37.setText("*Select one option to proceed");
        Question4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel47.setBackground(new java.awt.Color(202, 133, 64));
        jLabel47.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("            Next");
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel47.setOpaque(true);
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        Question4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel16.setBackground(new java.awt.Color(255, 227, 196));
        jLabel16.setOpaque(true);
        Question4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question4, "Question4");

        Question5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel17.setText("Question 5:");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        Question5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel18.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel18.setText("I try to put my problems out of mind");
        Question5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always5.setBackground(new java.awt.Color(202, 133, 64));
        Always5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always5.setForeground(new java.awt.Color(255, 255, 255));
        Always5.setText("Always");
        Always5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always5ActionPerformed(evt);
            }
        });
        Question5.add(Always5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never5.setBackground(new java.awt.Color(202, 133, 64));
        Never5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never5.setForeground(new java.awt.Color(255, 255, 255));
        Never5.setText("Never");
        Never5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never5ActionPerformed(evt);
            }
        });
        Question5.add(Never5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely5.setBackground(new java.awt.Color(202, 133, 64));
        Rarely5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely5.setForeground(new java.awt.Color(255, 255, 255));
        Rarely5.setText("Rarely");
        Rarely5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely5ActionPerformed(evt);
            }
        });
        Question5.add(Rarely5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes5.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes5.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes5.setText("Sometimes");
        Sometimes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes5ActionPerformed(evt);
            }
        });
        Question5.add(Sometimes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often5.setBackground(new java.awt.Color(202, 133, 64));
        Often5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often5.setForeground(new java.awt.Color(255, 255, 255));
        Often5.setText("Often");
        Often5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often5ActionPerformed(evt);
            }
        });
        Question5.add(Often5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel38.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel38.setText("*Select one option to proceed");
        Question5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel48.setBackground(new java.awt.Color(202, 133, 64));
        jLabel48.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("            Next");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel48.setOpaque(true);
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        Question5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel19.setBackground(new java.awt.Color(255, 227, 196));
        jLabel19.setOpaque(true);
        Question5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 370));

        PanelForQuiz.add(Question5, "Question5");

        Question6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel20.setText("Question 6:");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        Question6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel21.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel21.setText("When I am startled, I notice what is going on inside my body");
        Question6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always6.setBackground(new java.awt.Color(202, 133, 64));
        Always6.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always6.setForeground(new java.awt.Color(255, 255, 255));
        Always6.setText("Always");
        Always6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always6ActionPerformed(evt);
            }
        });
        Question6.add(Always6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never6.setBackground(new java.awt.Color(202, 133, 64));
        Never6.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never6.setForeground(new java.awt.Color(255, 255, 255));
        Never6.setText("Never");
        Never6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never6ActionPerformed(evt);
            }
        });
        Question6.add(Never6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely6.setBackground(new java.awt.Color(202, 133, 64));
        Rarely6.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely6.setForeground(new java.awt.Color(255, 255, 255));
        Rarely6.setText("Rarely");
        Rarely6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely6ActionPerformed(evt);
            }
        });
        Question6.add(Rarely6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes6.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes6.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes6.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes6.setText("Sometimes");
        Sometimes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes6ActionPerformed(evt);
            }
        });
        Question6.add(Sometimes6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often6.setBackground(new java.awt.Color(202, 133, 64));
        Often6.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often6.setForeground(new java.awt.Color(255, 255, 255));
        Often6.setText("Often");
        Often6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often6ActionPerformed(evt);
            }
        });
        Question6.add(Often6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel39.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel39.setText("*Select one option to proceed");
        Question6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel49.setBackground(new java.awt.Color(202, 133, 64));
        jLabel49.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("            Next");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel49.setOpaque(true);
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        Question6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel22.setBackground(new java.awt.Color(255, 227, 196));
        jLabel22.setOpaque(true);
        Question6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question6, "Question6");

        Question7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel23.setText("Question 7:");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        Question7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel24.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel24.setText("When someone asks how I am feeling, I can identify my emotions easily");
        Question7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always7.setBackground(new java.awt.Color(202, 133, 64));
        Always7.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always7.setForeground(new java.awt.Color(255, 255, 255));
        Always7.setText("Always");
        Always7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always7ActionPerformed(evt);
            }
        });
        Question7.add(Always7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never7.setBackground(new java.awt.Color(202, 133, 64));
        Never7.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never7.setForeground(new java.awt.Color(255, 255, 255));
        Never7.setText("Never");
        Never7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never7ActionPerformed(evt);
            }
        });
        Question7.add(Never7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely7.setBackground(new java.awt.Color(202, 133, 64));
        Rarely7.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely7.setForeground(new java.awt.Color(255, 255, 255));
        Rarely7.setText("Rarely");
        Rarely7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely7ActionPerformed(evt);
            }
        });
        Question7.add(Rarely7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes7.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes7.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes7.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes7.setText("Sometimes");
        Sometimes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes7ActionPerformed(evt);
            }
        });
        Question7.add(Sometimes7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often7.setBackground(new java.awt.Color(202, 133, 64));
        Often7.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often7.setForeground(new java.awt.Color(255, 255, 255));
        Often7.setText("Often");
        Often7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often7ActionPerformed(evt);
            }
        });
        Question7.add(Often7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel40.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel40.setText("*Select one option to proceed");
        Question7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel50.setBackground(new java.awt.Color(202, 133, 64));
        jLabel50.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("            Next");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel50.setOpaque(true);
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        Question7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel25.setBackground(new java.awt.Color(255, 227, 196));
        jLabel25.setOpaque(true);
        Question7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question7, "Question7");

        Question8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel26.setText("Question 8:");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        Question8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel27.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel27.setText("When talking with other people, I am aware of the emotions I am experiencing");
        Question8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always8.setBackground(new java.awt.Color(202, 133, 64));
        Always8.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always8.setForeground(new java.awt.Color(255, 255, 255));
        Always8.setText("Always");
        Always8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always8ActionPerformed(evt);
            }
        });
        Question8.add(Always8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never8.setBackground(new java.awt.Color(202, 133, 64));
        Never8.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never8.setForeground(new java.awt.Color(255, 255, 255));
        Never8.setText("Never");
        Never8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never8ActionPerformed(evt);
            }
        });
        Question8.add(Never8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely8.setBackground(new java.awt.Color(202, 133, 64));
        Rarely8.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely8.setForeground(new java.awt.Color(255, 255, 255));
        Rarely8.setText("Rarely");
        Rarely8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely8ActionPerformed(evt);
            }
        });
        Question8.add(Rarely8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes8.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes8.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes8.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes8.setText("Sometimes");
        Sometimes8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes8ActionPerformed(evt);
            }
        });
        Question8.add(Sometimes8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often8.setBackground(new java.awt.Color(202, 133, 64));
        Often8.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often8.setForeground(new java.awt.Color(255, 255, 255));
        Often8.setText("Often");
        Often8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often8ActionPerformed(evt);
            }
        });
        Question8.add(Often8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel41.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel41.setText("*Select one option to proceed");
        Question8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel51.setBackground(new java.awt.Color(202, 133, 64));
        jLabel51.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("            Next");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel51.setOpaque(true);
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });
        Question8.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel28.setBackground(new java.awt.Color(255, 227, 196));
        jLabel28.setOpaque(true);
        Question8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question8, "Question8");

        Question9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel29.setText("Question 9:");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        Question9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel30.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel30.setText("Whenever my emotions change, I am conscious of them immediately");
        Question9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always9.setBackground(new java.awt.Color(202, 133, 64));
        Always9.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always9.setForeground(new java.awt.Color(255, 255, 255));
        Always9.setText("Always");
        Always9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always9ActionPerformed(evt);
            }
        });
        Question9.add(Always9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never9.setBackground(new java.awt.Color(202, 133, 64));
        Never9.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never9.setForeground(new java.awt.Color(255, 255, 255));
        Never9.setText("Never");
        Never9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never9ActionPerformed(evt);
            }
        });
        Question9.add(Never9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely9.setBackground(new java.awt.Color(202, 133, 64));
        Rarely9.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely9.setForeground(new java.awt.Color(255, 255, 255));
        Rarely9.setText("Rarely");
        Rarely9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely9ActionPerformed(evt);
            }
        });
        Question9.add(Rarely9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes9.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes9.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes9.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes9.setText("Sometimes");
        Sometimes9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes9ActionPerformed(evt);
            }
        });
        Question9.add(Sometimes9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often9.setBackground(new java.awt.Color(202, 133, 64));
        Often9.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often9.setForeground(new java.awt.Color(255, 255, 255));
        Often9.setText("Often");
        Often9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often9ActionPerformed(evt);
            }
        });
        Question9.add(Often9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel42.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel42.setText("*Select one option to proceed");
        Question9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel52.setBackground(new java.awt.Color(202, 133, 64));
        jLabel52.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("            Next");
        jLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel52.setOpaque(true);
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        Question9.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel31.setBackground(new java.awt.Color(255, 227, 196));
        jLabel31.setOpaque(true);
        Question9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question9, "Question9");

        Question10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel7.setText("Question 10:");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        Question10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 143, 47));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setText("When I am startled, I notice what is going on inside my body");
        Question10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 50));

        Always10.setBackground(new java.awt.Color(202, 133, 64));
        Always10.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Always10.setForeground(new java.awt.Color(255, 255, 255));
        Always10.setText("Always");
        Always10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Always10ActionPerformed(evt);
            }
        });
        Question10.add(Always10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 160, 70));

        Never10.setBackground(new java.awt.Color(202, 133, 64));
        Never10.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Never10.setForeground(new java.awt.Color(255, 255, 255));
        Never10.setText("Never");
        Never10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Never10ActionPerformed(evt);
            }
        });
        Question10.add(Never10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 70));

        Rarely10.setBackground(new java.awt.Color(202, 133, 64));
        Rarely10.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Rarely10.setForeground(new java.awt.Color(255, 255, 255));
        Rarely10.setText("Rarely");
        Rarely10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rarely10ActionPerformed(evt);
            }
        });
        Question10.add(Rarely10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 70));

        Sometimes10.setBackground(new java.awt.Color(202, 133, 64));
        Sometimes10.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Sometimes10.setForeground(new java.awt.Color(255, 255, 255));
        Sometimes10.setText("Sometimes");
        Sometimes10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sometimes10ActionPerformed(evt);
            }
        });
        Question10.add(Sometimes10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 70));

        Often10.setBackground(new java.awt.Color(202, 133, 64));
        Often10.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        Often10.setForeground(new java.awt.Color(255, 255, 255));
        Often10.setText("Often");
        Often10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Often10ActionPerformed(evt);
            }
        });
        Question10.add(Often10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 160, 70));

        jLabel43.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel43.setText("*Select one option to proceed");
        Question10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 480, -1));

        jLabel53.setBackground(new java.awt.Color(202, 133, 64));
        jLabel53.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("            Next");
        jLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel53.setOpaque(true);
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        Question10.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 40));

        jLabel33.setBackground(new java.awt.Color(255, 227, 196));
        jLabel33.setOpaque(true);
        Question10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(Question10, "Question10");

        End.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel54.setText("Your Mindfulness score is ");
        End.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 69, -1, 62));

        jLabel55.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        End.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 85, 43, 30));

        jButton2.setBackground(new java.awt.Color(202, 133, 64));
        jButton2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homeeeicon.png"))); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        End.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, 60));

        jLabel56.setBackground(new java.awt.Color(255, 227, 196));
        jLabel56.setOpaque(true);
        End.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 460));

        PanelForQuiz.add(End, "End");

        jPanel1.add(PanelForQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 305, 1047, -1));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ZenSpace Logo.png"))); // NOI18N
        jPanel1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 7, 396, 120));

        cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancel-24.png"))); // NOI18N
        cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        jPanel1.add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 0, 40, 50));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-macos-minimize-30.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 40, 50));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-30.png"))); // NOI18N
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 80, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // if()
        cardLayout.show(PanelForQuiz, "Question1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void Always1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always1ActionPerformed
        // TODO add your handling code here:
        never1selected = false;
always1selected = true;
rarely1selected = false;
sometimes1selected = false;
often1selected = false;
    }//GEN-LAST:event_Always1ActionPerformed

    private void Never1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never1ActionPerformed
        // TODO add your handling code here:
        never1selected = true;
        always1selected = false;
        rarely1selected = false;
        sometimes1selected = false;
        often1selected = false;
    }//GEN-LAST:event_Never1ActionPerformed

    private void Rarely1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely1ActionPerformed
        // TODO add your handling code here:
        never1selected = false;
always1selected = false;
rarely1selected = true;
sometimes1selected = false;
often1selected = false;
        
    }//GEN-LAST:event_Rarely1ActionPerformed

    private void Sometimes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes1ActionPerformed
        // TODO add your handling code here:
        never1selected = false;
always1selected = false;
rarely1selected = false;
sometimes1selected = true;
often1selected = false;
    }//GEN-LAST:event_Sometimes1ActionPerformed

    private void Often1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often1ActionPerformed
        // TODO add your handling code here:
        never1selected = false;
always1selected = false;
rarely1selected = false;
sometimes1selected = false;
often1selected = true;
    }//GEN-LAST:event_Often1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void Always3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always3ActionPerformed
        // TODO add your handling code here:
        never3selected = false;
always3selected = true;
rarely3selected = false;
sometimes3selected = false;
often3selected = false;
    }//GEN-LAST:event_Always3ActionPerformed

    private void Never3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never3ActionPerformed
        // TODO add your handling code here:
        never3selected = true;
always3selected = false;
rarely3selected = false;
sometimes3selected = false;
often3selected = false;
    }//GEN-LAST:event_Never3ActionPerformed

    private void Rarely3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely3ActionPerformed
        // TODO add your handling code here:
        never3selected = false;
always3selected = false;
rarely3selected = true;
sometimes3selected = false;
often3selected = false;
        
    }//GEN-LAST:event_Rarely3ActionPerformed

    private void Sometimes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes3ActionPerformed
        // TODO add your handling code here:
        never3selected = false;
always3selected = false;
rarely3selected = false;
sometimes3selected = true;
often3selected = false;
    }//GEN-LAST:event_Sometimes3ActionPerformed

    private void Often3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often3ActionPerformed
        // TODO add your handling code here:
        never3selected = false;
always3selected = false;
rarely3selected = false;
sometimes3selected = false;
often3selected = true;
    }//GEN-LAST:event_Often3ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void Always4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always4ActionPerformed
        // TODO add your handling code here:
        never4selected = false;
always4selected = true;
rarely4selected = false;
sometimes4selected = false;
often4selected = false;

    }//GEN-LAST:event_Always4ActionPerformed

    private void Never4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never4ActionPerformed
        // TODO add your handling code here:
        never4selected = true;
always4selected = false;
rarely4selected = false;
sometimes4selected = false;
often4selected = false;

    }//GEN-LAST:event_Never4ActionPerformed

    private void Rarely4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely4ActionPerformed
        // TODO add your handling code here:
        never4selected = false;
always4selected = false;
rarely4selected = true;
sometimes4selected = false;
often4selected = false;

    }//GEN-LAST:event_Rarely4ActionPerformed

    private void Sometimes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes4ActionPerformed
        // TODO add your handling code here:
        never4selected = false;
always4selected = false;
rarely4selected = false;
sometimes4selected = true;
often4selected = false;

    }//GEN-LAST:event_Sometimes4ActionPerformed

    private void Often4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often4ActionPerformed
        // TODO add your handling code here:
        never4selected = false;
always4selected = false;
rarely4selected = false;
sometimes4selected = false;
often4selected = true;

    }//GEN-LAST:event_Often4ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void Always5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always5ActionPerformed
        // TODO add your handling code here:
        never5selected = false;
always5selected = true;
rarely5selected = false;
sometimes5selected = false;
often5selected = false;

    }//GEN-LAST:event_Always5ActionPerformed

    private void Never5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never5ActionPerformed
        // TODO add your handling code here:
        never5selected = true;
always5selected = false;
rarely5selected = false;
sometimes5selected = false;
often5selected = false;

    }//GEN-LAST:event_Never5ActionPerformed

    private void Rarely5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely5ActionPerformed
        // TODO add your handling code here:
        never5selected = false;
always5selected = false;
rarely5selected = true;
sometimes5selected = false;
often5selected = false;

    }//GEN-LAST:event_Rarely5ActionPerformed

    private void Sometimes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes5ActionPerformed
        // TODO add your handling code here:
        never5selected = false;
always5selected = false;
rarely5selected = false;
sometimes5selected = true;
often5selected = false;

    }//GEN-LAST:event_Sometimes5ActionPerformed

    private void Often5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often5ActionPerformed
        // TODO add your handling code here:
        never5selected = false;
always5selected = false;
rarely5selected = false;
sometimes5selected = false;
often5selected = true;

    }//GEN-LAST:event_Often5ActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void Always6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always6ActionPerformed
        // TODO add your handling code here:
        never6selected = false;
always6selected = true;
rarely6selected = false;
sometimes6selected = false;
often6selected = false;

    }//GEN-LAST:event_Always6ActionPerformed

    private void Never6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never6ActionPerformed
        // TODO add your handling code here:
        never6selected = true;
always6selected = false;
rarely6selected = false;
sometimes6selected = false;
often6selected = false;
    }//GEN-LAST:event_Never6ActionPerformed

    private void Rarely6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely6ActionPerformed
        // TODO add your handling code here:
        never6selected = false;
always6selected = false;
rarely6selected = true;
sometimes6selected = false;
often6selected = false;

    }//GEN-LAST:event_Rarely6ActionPerformed

    private void Sometimes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes6ActionPerformed
        // TODO add your handling code here:
        never6selected = false;
always6selected = false;
rarely6selected = false;
sometimes6selected = true;
often6selected = false;

    }//GEN-LAST:event_Sometimes6ActionPerformed

    private void Often6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often6ActionPerformed
        // TODO add your handling code here:
        never6selected = false;
always6selected = false;
rarely6selected = false;
sometimes6selected = false;
often6selected = true;

    }//GEN-LAST:event_Often6ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void Always7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always7ActionPerformed
        // TODO add your handling code here:
        never7selected = false;
always7selected = true;
rarely7selected = false;
sometimes7selected = false;
often7selected = false;

    }//GEN-LAST:event_Always7ActionPerformed

    private void Never7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never7ActionPerformed
        // TODO add your handling code here:
        never7selected = true;
always7selected = false;
rarely7selected = false;
sometimes7selected = false;
often7selected = false;

    }//GEN-LAST:event_Never7ActionPerformed

    private void Rarely7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely7ActionPerformed
        // TODO add your handling code here:
        never7selected = false;
always7selected = false;
rarely7selected = true;
sometimes7selected = false;
often7selected = false;

    }//GEN-LAST:event_Rarely7ActionPerformed

    private void Sometimes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes7ActionPerformed
        // TODO add your handling code here:
        never7selected = false;
always7selected = false;
rarely7selected = false;
sometimes7selected = true;
often7selected = false;

    }//GEN-LAST:event_Sometimes7ActionPerformed

    private void Often7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often7ActionPerformed
        // TODO add your handling code here:
        never7selected = false;
always7selected = false;
rarely7selected = false;
sometimes7selected = false;
often7selected = true;

    }//GEN-LAST:event_Often7ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void Always8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always8ActionPerformed
        // TODO add your handling code here:
        never8selected = false;
always8selected = true;
rarely8selected = false;
sometimes8selected = false;
often8selected = false;

    }//GEN-LAST:event_Always8ActionPerformed

    private void Never8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never8ActionPerformed
        // TODO add your handling code here:
        never8selected = true;
always8selected = false;
rarely8selected = false;
sometimes8selected = false;
often8selected = false;

    }//GEN-LAST:event_Never8ActionPerformed

    private void Rarely8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely8ActionPerformed
        // TODO add your handling code here:
        never8selected = false;
always8selected = false;
rarely8selected = true;
sometimes8selected = false;
often8selected = false;

        
    }//GEN-LAST:event_Rarely8ActionPerformed

    private void Sometimes8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes8ActionPerformed
        // TODO add your handling code here:
        never8selected = false;
always8selected = false;
rarely8selected = false;
sometimes8selected = true;
often8selected = false;

    }//GEN-LAST:event_Sometimes8ActionPerformed

    private void Often8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often8ActionPerformed
        // TODO add your handling code here:
        never8selected = false;
always8selected = false;
rarely8selected = false;
sometimes8selected = false;
often8selected = true;

        
    }//GEN-LAST:event_Often8ActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void Always9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always9ActionPerformed
        // TODO add your handling code here:
        never9selected = false;
always9selected = true;
rarely9selected = false;
sometimes9selected = false;
often9selected = false;

    }//GEN-LAST:event_Always9ActionPerformed

    private void Never9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never9ActionPerformed
        // TODO add your handling code here:
        never9selected = true;
always9selected = false;
rarely9selected = false;
sometimes9selected = false;
often9selected = false;

    }//GEN-LAST:event_Never9ActionPerformed

    private void Rarely9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely9ActionPerformed
        // TODO add your handling code here:
        never9selected = false;
always9selected = false;
rarely9selected = true;
sometimes9selected = false;
often9selected = false;

    }//GEN-LAST:event_Rarely9ActionPerformed

    private void Sometimes9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes9ActionPerformed
        // TODO add your handling code here:
        never9selected = false;
always9selected = false;
rarely9selected = false;
sometimes9selected = true;
often9selected = false;

    }//GEN-LAST:event_Sometimes9ActionPerformed

    private void Often9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often9ActionPerformed
        // TODO add your handling code here:
        never9selected = false;
always9selected = false;
rarely9selected = false;
sometimes9selected = false;
often9selected = true;

    }//GEN-LAST:event_Often9ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void Always10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always10ActionPerformed
        // TODO add your handling code here:
        never10selected = false;
always10selected = true;
rarely10selected = false;
sometimes10selected = false;
often10selected = false;

    }//GEN-LAST:event_Always10ActionPerformed

    private void Never10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never10ActionPerformed
        // TODO add your handling code here:
        never10selected = true;
always10selected = false;
rarely10selected = false;
sometimes10selected = false;
often10selected = false;

    }//GEN-LAST:event_Never10ActionPerformed

    private void Rarely10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely10ActionPerformed
        // TODO add your handling code here:
        never10selected = false;
always10selected = false;
rarely10selected = true;
sometimes10selected = false;
often10selected = false;

    }//GEN-LAST:event_Rarely10ActionPerformed

    private void Sometimes10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes10ActionPerformed
        // TODO add your handling code here:
        never10selected = false;
always10selected = false;
rarely10selected = false;
sometimes10selected = true;
often10selected = false;

    }//GEN-LAST:event_Sometimes10ActionPerformed

    private void Often10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often10ActionPerformed
        // TODO add your handling code here:
        never10selected = false;
always10selected = false;
rarely10selected = false;
sometimes10selected = false;
often10selected = true;

    }//GEN-LAST:event_Often10ActionPerformed

    private void Often2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Often2ActionPerformed
        // TODO add your handling code here:
        never2selected = false;
always2selected = false;
rarely2selected = false;
sometimes2selected = false;
often2selected = true;
    }//GEN-LAST:event_Often2ActionPerformed

    private void Sometimes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sometimes2ActionPerformed
        // TODO add your handling code here:
        never2selected = false;
always2selected = false;
rarely2selected = false;
sometimes2selected = true;
often2selected = false;
        
    }//GEN-LAST:event_Sometimes2ActionPerformed

    private void Rarely2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rarely2ActionPerformed
        // TODO add your handling code here:
        never2selected = false;
always2selected = false;
rarely2selected = true;
sometimes2selected = false;
often2selected = false;
    }//GEN-LAST:event_Rarely2ActionPerformed

    private void Never2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Never2ActionPerformed
        // TODO add your handling code here:
        never2selected = true;
always2selected = false;
rarely2selected = false;
sometimes2selected = false;
often2selected = false;
    }//GEN-LAST:event_Never2ActionPerformed

    private void Always2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Always2ActionPerformed
        // TODO add your handling code here:
        never2selected = false;
always2selected = true;
rarely2selected = false;
sometimes2selected = false;
often2selected = false;
    }//GEN-LAST:event_Always2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:\
        if (!never1selected && !always1selected && !rarely1selected && !sometimes1selected && !often1selected) {
                jLabel34.setVisible(true);
            }
        else {
            if (never1selected) score += 0;
            if (rarely1selected) score += 2;
            if (sometimes1selected) score += 5;
            if (often1selected) score += 8;
            if (always1selected) score += 10;
            cardLayout.show(PanelForQuiz, "Question2");
        }   
        
        
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        // TODO add your handling code here:
        if (!never2selected && !always2selected && !rarely2selected && !sometimes2selected && !often2selected) {
    jLabel35.setVisible(true);
} else {
    if (never2selected) score += 0;
    if (rarely2selected) score += 2;
    if (sometimes2selected) score += 5;
    if (often2selected) score += 8;
    if (always2selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question3");
}
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        if (!never3selected && !always3selected && !rarely3selected && !sometimes3selected && !often3selected) {
    jLabel36.setVisible(true);
} else {
    if (never3selected) score += 0;
    if (rarely3selected) score += 2;
    if (sometimes3selected) score += 5;
    if (often3selected) score += 8;
    if (always3selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question4");
}
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
      if (!never4selected && !always4selected && !rarely4selected && !sometimes4selected && !often4selected) {
    jLabel37.setVisible(true);
} else {
    if (never4selected) score += 0;
    if (rarely4selected) score += 2;
    if (sometimes4selected) score += 5;
    if (often4selected) score += 8;
    if (always4selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question5");
}
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        if (!never5selected && !always5selected && !rarely5selected && !sometimes5selected && !often5selected) {
    jLabel38.setVisible(true);
} else {
    if (never5selected) score += 0;
    if (rarely5selected) score += 2;
    if (sometimes5selected) score += 5;
    if (often5selected) score += 8;
    if (always5selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question6");
}
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
        if (!never6selected && !always6selected && !rarely6selected && !sometimes6selected && !often6selected) {
    jLabel39.setVisible(true);
} else {
    if (never6selected) score += 0;
    if (rarely6selected) score += 2;
    if (sometimes6selected) score += 5;
    if (often6selected) score += 8;
    if (always6selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question7");
}
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
        if (!never7selected && !always7selected && !rarely7selected && !sometimes7selected && !often7selected) {
    jLabel40.setVisible(true);
} else {
    if (never7selected) score += 0;
    if (rarely7selected) score += 2;
    if (sometimes7selected) score += 5;
    if (often7selected) score += 8;
    if (always7selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question8");
}
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        if (!never8selected && !always8selected && !rarely8selected && !sometimes8selected && !often8selected) {
    jLabel41.setVisible(true);
} else {
    if (never8selected) score += 0;
    if (rarely8selected) score += 2;
    if (sometimes8selected) score += 5;
    if (often8selected) score += 8;
    if (always8selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question9");
}
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        // TODO add your handling code here:
        if (!never9selected && !always9selected && !rarely9selected && !sometimes9selected && !often9selected) {
    jLabel42.setVisible(true);
} else {
    if (never9selected) score += 0;
    if (rarely9selected) score += 2;
    if (sometimes9selected) score += 5;
    if (often9selected) score += 8;
    if (always9selected) score += 10;
    cardLayout.show(PanelForQuiz, "Question10");
}
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        // TODO add your handling code here:
        if (!never10selected && !always10selected && !rarely10selected && !sometimes10selected && !often10selected) {
    jLabel43.setVisible(true);
} else {
    if (never10selected) score += 0;
    if (rarely10selected) score += 2;
    if (sometimes10selected) score += 5;
    if (often10selected) score += 8;
    if (always10selected) score += 10;
    cardLayout.show(PanelForQuiz, "End");
    String scoreValue= Integer.toString(score);
    jLabel55.setText(scoreValue);
    // You might want to handle the next step accordingly as this is the last iteration.
    // cardLayout.show(PanelForQuiz, "SomeNextStep"); 
}
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new UserHomepage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_crossMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseClicked

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
        new UserHomepage(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel58MouseClicked

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
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Always1;
    private javax.swing.JButton Always10;
    private javax.swing.JButton Always2;
    private javax.swing.JButton Always3;
    private javax.swing.JButton Always4;
    private javax.swing.JButton Always5;
    private javax.swing.JButton Always6;
    private javax.swing.JButton Always7;
    private javax.swing.JButton Always8;
    private javax.swing.JButton Always9;
    private javax.swing.JPanel End;
    private javax.swing.JButton Never1;
    private javax.swing.JButton Never10;
    private javax.swing.JButton Never2;
    private javax.swing.JButton Never3;
    private javax.swing.JButton Never4;
    private javax.swing.JButton Never5;
    private javax.swing.JButton Never6;
    private javax.swing.JButton Never7;
    private javax.swing.JButton Never8;
    private javax.swing.JButton Never9;
    private javax.swing.JButton Often1;
    private javax.swing.JButton Often10;
    private javax.swing.JButton Often2;
    private javax.swing.JButton Often3;
    private javax.swing.JButton Often4;
    private javax.swing.JButton Often5;
    private javax.swing.JButton Often6;
    private javax.swing.JButton Often7;
    private javax.swing.JButton Often8;
    private javax.swing.JButton Often9;
    private javax.swing.JPanel PanelForQuiz;
    private javax.swing.JPanel Question1;
    private javax.swing.JPanel Question10;
    private javax.swing.JPanel Question2;
    private javax.swing.JPanel Question3;
    private javax.swing.JPanel Question4;
    private javax.swing.JPanel Question5;
    private javax.swing.JPanel Question6;
    private javax.swing.JPanel Question7;
    private javax.swing.JPanel Question8;
    private javax.swing.JPanel Question9;
    private javax.swing.JButton Rarely1;
    private javax.swing.JButton Rarely10;
    private javax.swing.JButton Rarely2;
    private javax.swing.JButton Rarely3;
    private javax.swing.JButton Rarely4;
    private javax.swing.JButton Rarely5;
    private javax.swing.JButton Rarely6;
    private javax.swing.JButton Rarely7;
    private javax.swing.JButton Rarely8;
    private javax.swing.JButton Rarely9;
    private javax.swing.JButton Sometimes1;
    private javax.swing.JButton Sometimes10;
    private javax.swing.JButton Sometimes2;
    private javax.swing.JButton Sometimes3;
    private javax.swing.JButton Sometimes4;
    private javax.swing.JButton Sometimes5;
    private javax.swing.JButton Sometimes6;
    private javax.swing.JButton Sometimes7;
    private javax.swing.JButton Sometimes8;
    private javax.swing.JButton Sometimes9;
    private javax.swing.JPanel Start;
    private javax.swing.JLabel cross;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel minimize;
    // End of variables declaration//GEN-END:variables
}
