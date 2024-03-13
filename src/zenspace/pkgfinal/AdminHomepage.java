/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zenspace.pkgfinal;

import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.ByteArrayOutputStream;
import java.awt.Font;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Asus
 */
public class AdminHomepage extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomepage
     */
    String filename=null;
    byte img[];
    byte audio[];
    String admin=null;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private int pend = 0;
    public AdminHomepage(){
        initComponents();
    }
    public AdminHomepage(String ad) {
        admin=ad;
        initComponents();
        Connect();
        int x=0,y=0,tot=0;
        int xr=0,yr=0,totr=0;
        
        int pending = 0;
        jTabbedPane2.setSelectedIndex(0);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(50, "Users joined", "Jan");
        dataset.setValue(65, "Users joined", "Feb");
        dataset.setValue(60, "Users joined", "Mar");
        dataset.setValue(40, "Users joined", "Apr");
        dataset.setValue(51, "Users joined", "May");
        dataset.setValue(57, "Users joined", "Jun");
        dataset.setValue(40, "Users joined", "Jul");
        dataset.setValue(38, "Users joined", "Aug");
        dataset.setValue(20, "Users joined", "Sep");
        dataset.setValue(46, "Users joined", "Oct");
        dataset.setValue(65, "Users joined", "Nov");
        dataset.setValue(80, "Users joined", "Dec");


        JFreeChart chart = ChartFactory.createBarChart3D("Monthly Users", "Month", "Users Joined", dataset,PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        
        ChartPanel chartPanel = new ChartPanel(chart);

    
    //userchart.removeAll(); 
    dashpanel.add(chartPanel); 
    dashpanel.revalidate();
    
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // Customize the line color for the series
        CategoryItemRenderer renderer = p.getRenderer();
renderer.setSeriesPaint(0, new Color(192, 172, 231));
       try {
            JLabel label1 = new JLabel();
            label1.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
            label1.setText("Name");
            Color color1 = new Color(221,251,210);
            label1.setBackground(Color.WHITE);
            label1.setForeground(Color.BLACK);
            label1.setOpaque(true);
            JLabel label2 = new JLabel();
            label2.setFont(new java.awt.Font("Georgia",Font.BOLD,22));
            label2.setText("|");
            label2.setBackground(Color.yellow);
            //label2.setOpaque(true);
            JLabel label3 = new JLabel();
            label3.setFont(new java.awt.Font("Georgia",Font.BOLD,18));
            label3.setText("Username");
            Color color2 = new Color(245,255,198);
            label3.setBackground(Color.WHITE);
            label3.setForeground(Color.BLACK);
            label3.setOpaque(true);
            JPanel panel1 =  new JPanel();
            panel1.setLayout(new AbsoluteLayout());
            panel1.setPreferredSize(new Dimension(350,30));
            panel1.add(label1,new org.netbeans.lib.awtextra.AbsoluteConstraints(x,0,200,30));
            //panel1.add(label2,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+205,0,10,30));
            panel1.add(label3,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+200,0,200,30));
            jPanel17.add(panel1,new org.netbeans.lib.awtextra.AbsoluteConstraints(x,y,350,30));
            y=y+30;
            pst=con.prepareStatement("select * from userinformation");
            rs=pst.executeQuery();
            while(rs.next()){
                tot++;
                String name=rs.getString("NAME");
                String username=rs.getString("USERNAME");
                JPanel panelLp = new JPanel();
                panelLp.setLayout(new AbsoluteLayout());
                panelLp.setPreferredSize(new Dimension(350,30));
                JLabel label4 = new JLabel();
                label4.setFont(new java.awt.Font("Georgia",Font.BOLD,12));
                label4.setText(name);
                Color color4 = null;
                if(tot%2==1) color4 = new Color(233, 234, 236);
                else color4=Color.WHITE;
                label4.setBackground(color4);
                label4.setForeground(Color.BLACK);
                label4.setOpaque(true);
                JLabel label5 = new JLabel();
                label5.setFont(new java.awt.Font("Georgia",Font.BOLD,28));
                label5.setText("|");
                JLabel label6 = new JLabel();
                label6.setFont(new java.awt.Font("Georgia",Font.BOLD,12));
                label6.setText(username);
                label6.setBackground(color4);
                label6.setForeground(Color.BLACK);
                label6.setOpaque(true);
//                JL
                panelLp.add(label4,new org.netbeans.lib.awtextra.AbsoluteConstraints(x,0,200,30));
                panelLp.add(label6,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+200,0,200,30));
                jPanel17.add(panelLp,new org.netbeans.lib.awtextra.AbsoluteConstraints(x,y,350,30));
               // jPanel17.add(label5,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+205,y,10,30));
               // jPanel17.add(label6,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+220,y,200,30));
                //model.addRow(new Object[]{name,username});
                y=y+30;
            }
            String total=Integer.toString(tot);
            System.out.println(total);
            jLabel53.setText(total);
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String Item = "Item Name";
            String Rem = "Remaining";
            JPanel panel1 = new JPanel();
            panel1.setLayout(new AbsoluteLayout());
            panel1.setPreferredSize((new Dimension(370,30)));
            JLabel label1 = new JLabel();
            label1.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
            label1.setText(Item);
            JLabel label2 = new JLabel();
            label2.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
            label2.setText(Rem);
            label1.setBackground(Color.white);
            label1.setOpaque(true);
            label2.setBackground(Color.white);
            label2.setOpaque(true);
            panel1.setBackground(Color.white);
            panel1.setOpaque(true);
            panel1.add(label1,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,250,30));
            panel1.add(label2,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+280,0,120,30));
            jPanel14.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,370,30));
            pst = con.prepareStatement("select * from stock");
            rs=pst.executeQuery();
            int y_cur = 30;
            while(rs.next()){
                String ItemName = rs.getString("ItemName");
                Integer rem = rs.getInt("Remaining");
                if(rem<=10){
//                    JLabel label = new JLabel();
//                    label.setFont(new java.awt.Font("Century",1,18));
//                    label.setText(ItemName+"-"+rem);
                    //jPanel14.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(x,y,300,30));
                    JPanel panel2 = new JPanel();
                    panel2.setLayout(new AbsoluteLayout());
                    panel2.setPreferredSize((new Dimension(370,30)));
                    JLabel label3 = new JLabel();
                    label3.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                    label3.setText(ItemName);
                    JLabel label4 = new JLabel();
                    label4.setFont(new java.awt.Font("Georgia",Font.BOLD,14));
                    label4.setText(Integer.toString(rem)+"x");
                    Color color45 = null;
                    if(totr%2==0) color45 = new Color(233, 234, 236);
                    else color45=Color.WHITE;
                    label3.setBackground(color45);
                    label3.setOpaque(true);
                    label4.setForeground(Color.red);
                    label4.setBackground(color45);
                    label4.setOpaque(true);
                    panel2.setBackground(Color.white);
                    panel2.setOpaque(true);
                    panel2.add(label3,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,330,30));
                    panel2.add(label4,new org.netbeans.lib.awtextra.AbsoluteConstraints(x+330,0,40,30));
                    jPanel14.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,y_cur,370,30));
                    y_cur=y_cur+30;
                    totr++;
                    //model.addRow(new Object[]{ItemName,rem});
                }
            }
            String totalRestock = Integer.toString(totr);
            RestockNeeded.setText(totalRestock);
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.WHITE);
            panel1.setOpaque(true);
            panel1.setPreferredSize(new Dimension(1088,40));
            panel1.setLayout(new AbsoluteLayout());
            JLabel label1 = new JLabel();
            label1.setFont(new java.awt.Font("Century Gothic",0,22));
            label1.setText(" Order");
            panel1.add(label1,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,100,30));
             JLabel label2 = new JLabel();
            label2.setFont(new java.awt.Font("Century Gothic", 0, 22));
            label2.setText("Status");
            panel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 0, 100, 30));

            JLabel label3 = new JLabel();
            label3.setFont(new java.awt.Font("Century Gothic", 0, 22));
            label3.setText("Location");
            panel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 0, 200, 30));

            JLabel label4 = new JLabel();
            label4.setFont(new java.awt.Font("Century Gothic", 0, 22));
            label4.setText("Payment Status");
            panel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 200, 30));

            JLabel label5 = new JLabel();
            label5.setFont(new java.awt.Font("Century Gothic", 0, 22));
            label5.setText("Amount");
            panel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 100, 30));
            jPanel19.add(panel1,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,1080,40));
            pst = con.prepareStatement("SELECT * FROM dispatched_orders ORDER BY CASE WHEN Status = 'Pending' THEN 1 WHEN Status = 'Moving' THEN 2 WHEN Status = 'Cancelled' THEN 3 ELSE 4 END, Status");
            rs = pst.executeQuery();
            y =0;
            y = y+40;
            
            while(rs.next()){
                String Order_No = rs.getString("Order_No");
                String Status = rs.getString("Status");
                String location = rs.getString("Location");
                String PaymentStatus = rs.getString("PaymentStatus");
                Integer Amount = rs.getInt("Amount");
                String ITEM = rs.getString("Items");
                JPanel panel2 = new JPanel();
                panel2.setBackground(Color.WHITE);
                panel2.setOpaque(true);
                panel2.setPreferredSize(new Dimension(1088,40));
                panel2.setLayout(new AbsoluteLayout());
                
                JLabel label6 = new JLabel();
                label6.setFont(new java.awt.Font("Century Gothic",0,14));
                label6.setText(" " + Order_No);
                panel2.add(label6,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,200,30));
                
                JLabel label11 = new JLabel();
                label11.setFont(new java.awt.Font("Berlin Sans FB",1, 22));
                label11.setText("O");
                //label11.setBackground(Color.blue);
                //label11.setOpaque(true);
                if("Pending".equals(Status)) pend++;
                jLabel211.setText(Integer.toString(pend));
                if("Pending".equals(Status)) label11.setForeground(Color.yellow);
                if("Moving".equals(Status)) label11.setForeground(Color.green);
                if("Cancelled".equals(Status)) label11.setForeground(Color.red);
                label11.setHorizontalAlignment(SwingConstants.CENTER);
                label11.setVerticalAlignment(SwingConstants.CENTER);
                panel2.add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 40, 30));
                
                JLabel label7 = new JLabel();
                label7.setFont(new java.awt.Font("Century Gothic", 0, 14));
                label7.setText(Status);
                panel2.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 0, 100, 30));

                JLabel label8 = new JLabel();
                label8.setFont(new java.awt.Font("Century Gothic", 0, 14));
                label8.setText(location);
                panel2.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 0, 300, 30));

                JLabel label9 = new JLabel();
                label9.setFont(new java.awt.Font("Century Gothic", 0, 14));
                label9.setText(PaymentStatus);
                panel2.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 200, 30));

                JLabel label10 = new JLabel();
                label10.setFont(new java.awt.Font("Century Gothic", 0, 14));
                label10.setText(Integer.toString(Amount)+" TK");
                //label10.setBackground(Color.red);
                //label10.setOpaque(true);
                panel2.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 100, 30));
                JLabel label14 = new JLabel();
                    label14.setFont(new java.awt.Font("Century Gothic",1,12));
                    label14.setText(" Details ");
                    label14.setBackground(Color.CYAN);
                   // label13.setForeground(Color.WHITE);
                    label14.setOpaque(true);
                    panel2.add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 0, 55, 30));
                label14.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(null, ITEM);
                    }
                });
                if("Pending".equals(Status)){
                    JLabel label12 = new JLabel();
                    label12.setFont(new java.awt.Font("Century Gothic",1,12));
                    label12.setText(" Accept ");
                    label12.setBackground(Color.GREEN);
                    //label12.setForeground(Color.WHITE);
                    label12.setOpaque(true);
                    panel2.add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 0, 55, 30));
                    JLabel label13 = new JLabel();
                    label13.setFont(new java.awt.Font("Century Gothic",1,12));
                    label13.setText(" Cancel ");
                    label13.setBackground(Color.RED);
                   // label13.setForeground(Color.WHITE);
                    label13.setOpaque(true);
                    panel2.add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 0, 55, 30));
                    
                    label12.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Handle mouse click on the label here
                        label12.setVisible(false);
                        label13.setVisible(false);
                        label11.setForeground(Color.green);
                        label7.setText("Moving");
                        //Status = "Moving";
                        try {
                            pst = con.prepareStatement("UPDATE dispatched_orders SET Status = ? WHERE Order_No = ?");
                            pst.setString(1, "Moving");
                            pst.setString(2, Order_No);
                            pst.executeUpdate();
                            pend=pend-1;
                            jLabel211.setText(Integer.toString(pend));
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                    label13.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Handle mouse click on the label here
                        label12.setVisible(false);
                        label13.setVisible(false);
                        label11.setForeground(Color.red);
                        label7.setText("Cancelled");
                        //Status = "Moving";
                        try {
                            pst = con.prepareStatement("UPDATE dispatched_orders SET Status = ? WHERE Order_No = ?");
                            pst.setString(1, "Cancelled");
                            pst.setString(2, Order_No);
                            pst.executeUpdate();
                            pend=pend-1;
                            jLabel211.setText(Integer.toString(pend));
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                }
                jPanel19.add(panel2,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,y,1080,40));
                y = y+40;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst = con.prepareStatement("select * from orderstats");
            rs = pst.executeQuery();
            int totalsale = 0;
            while(rs.next()){
                String str = rs.getString("Category");
                //System.out.println(str);
                int Tot = rs.getInt("Total Sale");
                if("Courses".equals(str)) jLabel151.setText(Integer.toString(Tot));
                if("Digital Albums".equals(str)) jLabel152.setText(Integer.toString(Tot));
                if("Books".equals(str)) jLabel153.setText(Integer.toString(Tot));
                if("Merchandise".equals(str)) jLabel142.setText(Integer.toString(Tot));
                totalsale = totalsale+Tot;
            }
            jLabel134.setText(Integer.toString(totalsale));
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst = con.prepareStatement("select * from doctor");
            rs = pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel)doctable.getModel();
            TableColumn column1 = doctable.getColumnModel().getColumn(0);
            TableColumn column2 = doctable.getColumnModel().getColumn(1);
            TableColumn column3 = doctable.getColumnModel().getColumn(2);
            column1.setPreferredWidth(175);
            column2.setPreferredWidth(100);
            column3.setPreferredWidth(100);
            while(rs.next()){
                String name = rs.getString("NAME");
                String Address = rs.getString("ADDRESS");
                String Num= rs.getString("CONTACT_NUMBER");
                model.addRow(new Object[]{name,Address,Num});
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
     * WARNING: Do NOT modify this code. The con tent of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        LogoZenSpace = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        DocDetails = new javax.swing.JLabel();
        DocDetails1 = new javax.swing.JLabel();
        itemtoshop1 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JLabel();
        Minimize = new javax.swing.JLabel();
        Cross = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        dashhboard = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        dailyuser = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        dashpanel = new javax.swing.JPanel();
        pieshop = new javax.swing.JPanel();
        donchart = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        RestockNeeded = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        orderscrollpane = new javax.swing.JScrollPane();
        orderr2 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        SelectSegment1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        AddAudioFile1 = new javax.swing.JLabel();
        AudioFilepath1 = new javax.swing.JTextField();
        AddPictureFile1 = new javax.swing.JLabel();
        PictureFilepath1 = new javax.swing.JTextField();
        UploadAudio = new javax.swing.JButton();
        UploadPicture = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        AddPictureFile2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        docname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        docadd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        docno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addbutdoc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        itemprice = new javax.swing.JTextField();
        addtoitem = new javax.swing.JButton();
        itembox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        shoptable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoZenSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ZenSpace Logo.png"))); // NOI18N
        jPanel1.add(LogoZenSpace, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -10, 390, 150));

        jPanel2.setBackground(new java.awt.Color(255, 228, 201));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setBackground(new java.awt.Color(255, 255, 255));
        dashboard.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        dashboard.setText("         Dashboard");
        dashboard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.setOpaque(true);
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });
        jPanel2.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 40));

        DocDetails.setBackground(new java.awt.Color(255, 255, 255));
        DocDetails.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        DocDetails.setText("  Add Doctors' Details");
        DocDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        DocDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DocDetails.setOpaque(true);
        DocDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DocDetailsMouseEntered(evt);
            }
        });
        jPanel2.add(DocDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 40));

        DocDetails1.setBackground(new java.awt.Color(255, 255, 255));
        DocDetails1.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        DocDetails1.setText("      Add Soundtrack");
        DocDetails1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        DocDetails1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DocDetails1.setOpaque(true);
        DocDetails1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocDetails1MouseClicked(evt);
            }
        });
        jPanel2.add(DocDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 230, 40));

        itemtoshop1.setBackground(new java.awt.Color(255, 255, 255));
        itemtoshop1.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        itemtoshop1.setText("Log Out");
        itemtoshop1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        itemtoshop1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemtoshop1.setOpaque(true);
        itemtoshop1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemtoshop1MouseClicked(evt);
            }
        });
        jPanel2.add(itemtoshop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 90, 40));

        jLabel132.setBackground(new java.awt.Color(255, 255, 255));
        jLabel132.setFont(new java.awt.Font("Century", 1, 19)); // NOI18N
        jLabel132.setText("        Order Detail");
        jLabel132.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jLabel132.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel132.setOpaque(true);
        jLabel132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel132MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel132MouseEntered(evt);
            }
        });
        jPanel2.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 230, 40));

        mainpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userbg2.png"))); // NOI18N
        jPanel2.add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, -50, 1540, 880));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 790));

        Minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-macos-minimize-30.png"))); // NOI18N
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
        });
        jPanel1.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 40, 50));

        Cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancel-24.png"))); // NOI18N
        Cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrossMouseClicked(evt);
            }
        });
        jPanel1.add(Cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 0, 40, 50));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        dashhboard.setBackground(new java.awt.Color(255, 246, 237));
        dashhboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel4.setText("Dashboard");
        dashhboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 210, 70));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(182, 113, 43));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Donations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 140, 40));

        dailyuser.setBackground(new java.awt.Color(182, 113, 43));
        dailyuser.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        dailyuser.setForeground(new java.awt.Color(255, 255, 255));
        dailyuser.setText("Daily User");
        dailyuser.setBorderPainted(false);
        dailyuser.setOpaque(true);
        dailyuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dailyuserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dailyuserMouseEntered(evt);
            }
        });
        jPanel7.add(dailyuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, 40));

        jButton3.setBackground(new java.awt.Color(182, 113, 43));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sells");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 40));

        dashhboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 740, 70));

        dashpanel.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.addTab("sells", dashpanel);

        pieshop.setBackground(new java.awt.Color(255, 255, 255));
        pieshop.setPreferredSize(new java.awt.Dimension(500, 500));
        jTabbedPane2.addTab("pie", pieshop);

        donchart.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.addTab("donation", donchart);

        dashhboard.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 740, 460));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel30.setText("$10,589");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ofit.png"))); // NOI18N
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel33.setText("Profit");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 40));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel34.setText("$10,589");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 255, 102));
        jLabel35.setText("↑ 72.8%");
        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 40));

        dashhboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 170, 230));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usericoon.png"))); // NOI18N
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("New Users");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 102));
        jLabel17.setText("30");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 40));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setText("User Boost");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 40));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 255, 102));
        jLabel25.setText("↑ 28%");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 40));

        dashhboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 160, 230));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mediicon.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 70));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setText("Meditaition Frequency");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 160, 40));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel29.setText("Avg");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 50, 40));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel23.setText("55");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 30, 40));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel31.setText("per week");
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 80, 30));

        dashhboard.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 170, 230));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trans.png"))); // NOI18N
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 70));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel27.setText("Transactions");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 40));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel28.setText("$18,300");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 40));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setText("↓ 3.11%");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 40));

        dashhboard.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, 170, 230));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel59.setText("items need restocking");
        jPanel13.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, 40));

        jLabel38.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel38.setText("Restocking needed");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 40));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restocking.png"))); // NOI18N
        jPanel13.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, 130));

        RestockNeeded.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jPanel13.add(RestockNeeded, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 20, 30));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane6.setViewportView(jPanel14);

        jPanel13.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 380, 470));

        dashhboard.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 670, 380, 540));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel36.setText("Users");
        jPanel15.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jLabel53.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel53.setText("0");
        jPanel15.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 40, 30));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(0, 217, 165));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane5.setViewportView(jPanel17);

        jPanel15.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 350, 430));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/useradmin (2).png"))); // NOI18N
        jPanel15.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 140, 130));

        jLabel61.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel61.setText("Total Users:");
        jPanel15.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));

        dashhboard.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 350, 540));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel37.setText("Social Media Engagements");
        jPanel18.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 40));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/socialmedia.png"))); // NOI18N
        jPanel18.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 200, 130));

        jLabel109.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel109.setText("Users joined through Ads");
        jPanel18.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 40));

        jLabel108.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/youtube.png"))); // NOI18N
        jLabel108.setText("Youtube Ads");
        jPanel18.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 330, 40));

        jLabel110.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/facebook.png"))); // NOI18N
        jLabel110.setText("Facebook Ads");
        jPanel18.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 40));

        jLabel111.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/twitter.png"))); // NOI18N
        jLabel111.setText("Twitter Ads");
        jPanel18.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 330, 40));

        jLabel112.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insta.png"))); // NOI18N
        jLabel112.setText("Instagram Ads");
        jPanel18.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 330, 40));

        jLabel113.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinterest.png"))); // NOI18N
        jLabel113.setText("Pinterest Ads");
        jPanel18.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 330, 40));

        jLabel82.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 204, 204));
        jLabel82.setText("12%");
        jPanel18.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 50, 40));

        jLabel83.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 204, 204));
        jLabel83.setText("2.33%");
        jPanel18.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 50, 40));

        jLabel84.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 204, 204));
        jLabel84.setText("0.25%");
        jPanel18.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 50, 40));

        jLabel85.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 204, 204));
        jLabel85.setText("21.4%");
        jPanel18.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 50, 40));

        jLabel86.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 204, 204));
        jLabel86.setText("1.05%");
        jPanel18.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 50, 40));

        dashhboard.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 670, 400, 540));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/propic5.jpg"))); // NOI18N
        jPanel12.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 170, 180));

        jLabel114.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel114.setText("like a daily mental spa!");
        jPanel12.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 220, 40));

        jLabel115.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel115.setText("ZenSpace is a lifesaver- it's'");
        jPanel12.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, 40));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4star.png"))); // NOI18N
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 150, 40));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/propic1.jpg"))); // NOI18N
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 160));

        jLabel116.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel116.setText("\"Simply the best meditation");
        jPanel12.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 220, 40));

        jLabel117.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel117.setText("reommended.\"");
        jPanel12.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 220, 20));

        jLabel118.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel118.setText("software out there. Highly");
        jPanel12.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 220, 40));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5star.png"))); // NOI18N
        jPanel12.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 150, 40));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/propic4.jpg"))); // NOI18N
        jPanel12.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 200, 160));

        jLabel119.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel119.setText("\"I like ZenSpace, but it could");
        jPanel12.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 240, 40));

        jLabel120.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel120.setText("offer more variety in");
        jPanel12.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 220, 40));

        jLabel121.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel121.setText("meditation styles.");
        jPanel12.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 140, 20));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5star.png"))); // NOI18N
        jPanel12.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 150, 40));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/propic22.jpg"))); // NOI18N
        jPanel12.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 180, 180));

        jLabel122.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel122.setText("\"Brilliant software– ");
        jPanel12.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, -1, 40));

        jLabel123.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel123.setText("it's like a personal Zen coach");
        jPanel12.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 230, 40));

        jLabel124.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel124.setText("in my pocket.");
        jPanel12.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 140, 20));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4star.png"))); // NOI18N
        jPanel12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, 150, 40));

        dashhboard.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1250, 1170, 310));

        jScrollPane4.setViewportView(dashhboard);

        jTabbedPane1.addTab("dashboard", jScrollPane4);

        orderscrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        orderr2.setBackground(new java.awt.Color(255, 238, 221));
        orderr2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel206.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel206.setText("823 ");
        jPanel32.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 40));

        jLabel207.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel207.setText("Orders");
        jPanel32.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, 30));

        jLabel208.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(0, 255, 102));
        jLabel208.setText("+2.7%");
        jPanel32.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 50, 40));

        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graph2.png"))); // NOI18N
        jPanel32.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 260, 160));

        orderr2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 270, 180));

        jLabel210.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel210.setText("Order Details");
        orderr2.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 260, 70));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel211.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel211.setText("21");
        jPanel33.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        jLabel212.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel212.setText("Orders Pending");
        jPanel33.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pending.jpg"))); // NOI18N
        jPanel33.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 200));

        orderr2.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 280, 180));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jPanel23.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 40));

        jLabel135.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel135.setText("Weekly");
        jPanel23.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 80, 40));

        jLabel136.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel136.setText("48%");
        jPanel23.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 60, 40));

        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled_design__1_-removebg-preview.png"))); // NOI18N
        jPanel23.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 130, 130));

        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shopping-bag-48.png"))); // NOI18N
        jPanel23.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 50, 60));

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-course-96.png"))); // NOI18N
        jPanel23.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 60));

        jLabel140.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel140.setText("Focus, Stress Relief, Relaxation");
        jPanel23.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 220, 30));

        jLabel141.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel141.setText("Merchandise");
        jPanel23.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 170, 40));

        jLabel142.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel142.setText("18.3K");
        jPanel23.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 80, 40));

        jLabel143.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel143.setText("Focus, Stress Relief, Relaxation");
        jPanel23.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 260, 30));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-music-library-96.png"))); // NOI18N
        jPanel23.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 60));

        jLabel145.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel145.setText("Digital Albums");
        jPanel23.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 140, 40));

        jLabel146.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel146.setText("Focus, Stress Relief, Relaxation");
        jPanel23.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 260, 30));

        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N
        jPanel23.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 50, 50));

        jLabel148.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel148.setText("Books");
        jPanel23.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 80, 30));

        jLabel149.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel149.setText("Focus, Stress Relief, Relaxation");
        jPanel23.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 260, 20));

        jLabel150.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel150.setText("Courses");
        jPanel23.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 80, 40));

        jLabel151.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel151.setText("3K");
        jPanel23.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 80, 40));

        jLabel152.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel152.setText("8.9K");
        jPanel23.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 80, 40));

        jLabel153.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel153.setText("14.4K");
        jPanel23.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 80, 40));

        jSeparator16.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel23.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 30, 320));

        jLabel154.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel154.setText("Order Statistics");
        jPanel23.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 40));

        jLabel155.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel155.setText("Total Sales");
        jPanel23.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 120, 40));

        orderr2.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 410, 510));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rejectwd.png"))); // NOI18N
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 160, 160));

        jLabel217.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel217.setText("21");
        jPanel4.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        jLabel218.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel218.setText("Rejected");
        jPanel4.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        jLabel219.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel219.setText("Orders");
        jPanel4.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        orderr2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 270, 180));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel156.setText("Dispatched Orders");
        jPanel16.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 40));

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel16.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1070, 20));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane8.setViewportView(jPanel19);

        jPanel16.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1080, 320));

        orderr2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 690, 1090, 390));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel214.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel214.setText("150");
        jPanel22.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 40));

        jLabel215.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel215.setText("Customers");
        jPanel22.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 30));

        jLabel216.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 102, 0));
        jLabel216.setText("-1.08%");
        jPanel22.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 60, 40));

        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graaph2.png"))); // NOI18N
        jPanel22.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 180));

        orderr2.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 270, 180));

        orderscrollpane.setViewportView(orderr2);

        jTabbedPane1.addTab("order", orderscrollpane);

        jPanel6.setBackground(new java.awt.Color(255, 238, 221));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectSegment1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        SelectSegment1.setText("Select Segment");
        jPanel6.add(SelectSegment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 390, 60));

        jComboBox2.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stress Reduction", "Improve Focus", "Self Improvement", " " }));
        jPanel6.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 300, 70));

        AddAudioFile1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        AddAudioFile1.setText("Add Audio File");
        jPanel6.add(AddAudioFile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 390, 60));

        AudioFilepath1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jPanel6.add(AudioFilepath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 670, 40));

        AddPictureFile1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        AddPictureFile1.setText("Name");
        jPanel6.add(AddPictureFile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 390, 60));

        PictureFilepath1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jPanel6.add(PictureFilepath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 670, 40));

        UploadAudio.setBackground(new java.awt.Color(231, 174, 117));
        UploadAudio.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        UploadAudio.setText("Upload");
        UploadAudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadAudioMouseClicked(evt);
            }
        });
        UploadAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadAudioActionPerformed(evt);
            }
        });
        UploadAudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UploadAudioKeyPressed(evt);
            }
        });
        jPanel6.add(UploadAudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 120, -1));

        UploadPicture.setBackground(new java.awt.Color(231, 174, 117));
        UploadPicture.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        UploadPicture.setText("Upload");
        UploadPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadPictureMouseClicked(evt);
            }
        });
        UploadPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadPictureActionPerformed(evt);
            }
        });
        jPanel6.add(UploadPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 430, 120, -1));

        jButton2.setBackground(new java.awt.Color(231, 174, 117));
        jButton2.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jButton2.setText("Add to Database");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 630, 170, 40));

        jTextField1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 670, 50));

        AddPictureFile2.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        AddPictureFile2.setText("Add Picture File");
        jPanel6.add(AddPictureFile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 390, 60));

        jTabbedPane1.addTab("segment", jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 238, 221));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel6.setText("Updated Info");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 210, 50));

        docname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docnameActionPerformed(evt);
            }
        });
        jPanel3.add(docname, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 340, 41));

        jLabel7.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel7.setText("Address:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 154, 40));

        docadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docaddActionPerformed(evt);
            }
        });
        jPanel3.add(docadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 340, 40));

        jLabel8.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel8.setText("Contact No:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 154, 40));
        jPanel3.add(docno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 340, 41));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/docedit.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 510, 500));

        addbutdoc.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        addbutdoc.setText("Add");
        addbutdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbutdocActionPerformed(evt);
            }
        });
        jPanel3.add(addbutdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 103, 33));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 200, 10));

        doctable.setFont(new java.awt.Font("Kalpurush", 0, 12)); // NOI18N
        doctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Contact No"
            }
        ));
        doctable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(doctable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 540, 220));

        jLabel13.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel13.setText("Doctor Name:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 154, 50));

        jLabel14.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel14.setText("Add Doctors' Info");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 210, 50));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 250, 30));

        jTabbedPane1.addTab("doc", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 238, 221));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel10.setText("Item Name:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 154, 50));
        jPanel5.add(itemname, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 380, 41));

        jLabel11.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel11.setText("Category:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 100, 40));

        jLabel12.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel12.setText("Price:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 70, 40));
        jPanel5.add(itemprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 380, 41));

        addtoitem.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        addtoitem.setText("Add");
        addtoitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoitemActionPerformed(evt);
            }
        });
        jPanel5.add(addtoitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 103, 33));

        itembox.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        itembox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Course", "Digital Album", "Merchandise", "Book" }));
        jPanel5.add(itembox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 380, 40));

        shoptable.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        shoptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM NAME", "CATEGORY", "PRICE"
            }
        ));
        shoptable.setFocusable(false);
        shoptable.setGridColor(new java.awt.Color(255, 255, 255));
        shoptable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jScrollPane2.setViewportView(shoptable);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, -1, 240));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopp.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 110, 610, 560));

        jLabel15.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel15.setText("Updated Info");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 170, 50));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 270, 30));

        jLabel16.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel16.setText("Add New Item To Shop");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 330, 50));

        jTabbedPane1.addTab("shop", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -30, 1200, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Homepage Background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1500, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1506, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

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
    
    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_MinimizeMouseClicked

    private void CrossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrossMouseClicked
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CrossMouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        jTabbedPane1.setSelectedIndex(0);
        setColor(dashboard);
        resetColor(jLabel132);
        resetColor(DocDetails);
        resetColor(DocDetails1);
    }//GEN-LAST:event_dashboardMouseClicked

    private void DocDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocDetailsMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        resetColor(dashboard);
        resetColor(jLabel132);
        setColor(DocDetails);
        resetColor(DocDetails1);
    }//GEN-LAST:event_DocDetailsMouseClicked

    private void addbutdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbutdocActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)doctable.getModel();
        model.addRow(new Object[]{
            docname.getText(),docadd.getText(),docno.getText()
        });
        try {
            pst=con.prepareStatement("insert into doctor(NAME,ADDRESS,CONTACT_NUMBER) values(?,?,?)");
            pst.setString(1, docname.getText());
            pst.setString(2, docadd.getText());
            pst.setString(3, docno.getText());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addbutdocActionPerformed

    private void UploadAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadAudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UploadAudioActionPerformed

    private void UploadPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadPictureActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_UploadPictureActionPerformed

    private void docaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docaddActionPerformed

    private void addtoitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoitemActionPerformed
        // TODO add your handling code here:
        DefaultTableModel mdl = (DefaultTableModel)shoptable.getModel();
        mdl.addRow(new Object[]{
            itemname.getText(),itembox.getSelectedItem(),itemprice.getText()
        });
    }//GEN-LAST:event_addtoitemActionPerformed

    private void docnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(2);
        int jan=0,feb=0,mar=0,apr=0,may=0,june=0,july=0,aug=0,sep=0,oct=0,nov=0,dec=0;
        try {
            pst = con.prepareStatement("select * from donationamountmonth");
            rs = pst.executeQuery();
            while(rs.next()){
                String type = rs.getString("Month");
                int cur = rs.getInt("Amount");
                if ("January".equals(type)) {
                    jan = cur;
                }

                if ("February".equals(type)) {
                    feb = cur;
                }

                if ("March".equals(type)) {
                    mar = cur;
                }

                if ("April".equals(type)) {
                    apr = cur;
                }

                if ("May".equals(type)) {
                    may = cur;
                }

                if ("June".equals(type)) {
                    june = cur;
                }

                if ("July".equals(type)) {
                    july = cur;
                }

                if ("August".equals(type)) {
                    aug = cur;
                }

                if ("September".equals(type)) {
                    sep = cur;
                }

                if ("October".equals(type)) {
                    oct = cur;
                }

                if ("November".equals(type)) {
                    nov = cur;
                }

                if ("December".equals(type)) {
                    dec = cur;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(jan, "Donation received", "Jan");
        dataset.setValue(feb, "Donation received", "Feb");
        dataset.setValue(mar, "Donation received", "Mar");
        dataset.setValue(apr, "Donation received", "Apr");
        dataset.setValue(may, "Donation received", "May");
        dataset.setValue(june, "Donation received", "Jun");
        dataset.setValue(july, "Donation received", "Jul");
        dataset.setValue(aug, "Donation received", "Aug");
        dataset.setValue(sep, "Donation received", "Sep");
        dataset.setValue(oct, "Donation received", "Oct");
        dataset.setValue(nov, "Donation received", "Nov");
        dataset.setValue(dec, "Donation received", "Dec");



        JFreeChart chart = ChartFactory.createBarChart3D("Monthly donation received", "Month", "Donation in Dollars", dataset,PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        
        ChartPanel chartPanel = new ChartPanel(chart);

    
    //userchart.removeAll(); 
    donchart.add(chartPanel); 
    donchart.revalidate();
    
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // Customize the line color for the series
        CategoryItemRenderer renderer = p.getRenderer();
renderer.setSeriesPaint(0, new Color(109, 168, 227));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        int crs=0,dalb=0,book=0,march=0,t=0;
        try {
            pst = con.prepareStatement("select * from orderstats");
            rs = pst.executeQuery();
            while(rs.next()){
                String type = rs.getString("Category");
                int cur = rs.getInt("Total Sale");
                if("Courses".equals(type)) crs=cur;
                if("Digital Albums".equals(type)) dalb=cur;
                if("Books".equals(type)) book=cur;
                if("Merchandise".equals(type)) march=cur;
                t=t+cur;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieDataset.setValue("Courses", Double.valueOf(crs));
        pieDataset.setValue("Books", Double.valueOf(dalb));
        pieDataset.setValue("Digital Albums", Double.valueOf(book));
        pieDataset.setValue("Merchandise", Double.valueOf(march));
        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart",pieDataset, true, true, true);
        PiePlot3D P = (PiePlot3D)chart.getPlot();
        P.setBackgroundPaint(Color.WHITE);
        P.setOutlinePaint(new Color(0, 0, 0, 0));
        //P.setForegroundAlpha(TOP_ALIGNMENT);
        ChartPanel chartPanel = new ChartPanel(chart);
        
        
        Paint[] customColors = new Paint[] {
    new Color(245, 189, 122),    // Color for the "One" segment
    new Color(122, 122, 245),   // Color for the "Two" segment
    new Color(185, 242, 242),  // Color for the "Three" segment
    new Color(139, 69, 19)  // Color for the "Four" segment
};

// Set the custom color palette
P.setSectionPaint("Courses", customColors[0]);
P.setSectionPaint("Books", customColors[1]);
P.setSectionPaint("Digital Albums", customColors[2]);
P.setSectionPaint("Merchandise", customColors[3]);
        
        pieshop.removeAll(); // Remove any previous components in the pieshop panel
    pieshop.add(chartPanel); // Add the chart to the pieshop panel
    pieshop.revalidate(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dailyuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dailyuserMouseClicked
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.setValue(50, "Users joined", "Jan");
dataset.setValue(65, "Users joined", "Feb");
dataset.setValue(60, "Users joined", "Mar");
dataset.setValue(40, "Users joined", "Apr");
dataset.setValue(51, "Users joined", "May");
dataset.setValue(57, "Users joined", "Jun");
dataset.setValue(40, "Users joined", "Jul");
dataset.setValue(38, "Users joined", "Aug");
dataset.setValue(20, "Users joined", "Sep");
dataset.setValue(46, "Users joined", "Oct");
dataset.setValue(65, "Users joined", "Nov");
dataset.setValue(80, "Users joined", "Dec");


        JFreeChart chart = ChartFactory.createBarChart3D("Monthly Users", "Month", "Users Joined", dataset,PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        
        ChartPanel chartPanel = new ChartPanel(chart);

    
    //userchart.removeAll(); 
    dashpanel.add(chartPanel); 
    dashpanel.revalidate();
    
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // Customize the line color for the series
        CategoryItemRenderer renderer = p.getRenderer();
renderer.setSeriesPaint(0, new Color(192, 172, 231));
        
    }//GEN-LAST:event_dailyuserMouseClicked

    private void itemtoshop1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemtoshop1MouseClicked
        // TODO add your handling code here:
        new homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itemtoshop1MouseClicked

    private void jLabel132MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        resetColor(dashboard);
        setColor(jLabel132);
        resetColor(DocDetails);
        resetColor(DocDetails1);
    }//GEN-LAST:event_jLabel132MouseClicked

    private void jLabel132MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel132MouseEntered

    private void dailyuserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dailyuserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dailyuserMouseEntered

    private void DocDetails1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocDetails1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        resetColor(dashboard);
        resetColor(jLabel132);
        resetColor(DocDetails);
        setColor(DocDetails1);
    }//GEN-LAST:event_DocDetails1MouseClicked

    private void DocDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocDetailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DocDetailsMouseEntered

    private void UploadAudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadAudioMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        //jLabel5.setText(filename);
        AudioFilepath1.setText(filename);
        
        try {
            FileInputStream fis = new FileInputStream(f);
            byte [] audioData = new byte[(int)f.length()];
            try {
                fis.read(audioData);
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            audio = audioData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UploadAudioMouseClicked

    private void UploadAudioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UploadAudioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UploadAudioKeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String Genre = jComboBox2.getSelectedItem().toString();
        String Name = jTextField1.getText();
        try {
            pst = con.prepareStatement("Insert into musiclist(Name,Genre,Image,Audio) values(?,?,?,?)");
            pst.setString(1, Name);
            pst.setString(2, Genre);
            pst.setBytes(3, img);
            pst.setBytes(4, audio);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Added to database!");
    }//GEN-LAST:event_jButton2MouseClicked

    private void UploadPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadPictureMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        //jLabel3.setText(filename);
        PictureFilepath1.setText(filename);
        ImageIcon image = new ImageIcon(filename);
        try {
            FileInputStream fis = new FileInputStream(f);
            byte [] imageData = new byte[(int)f.length()];
            try {
                fis.read(imageData);
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            img=imageData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_UploadPictureMouseClicked

    

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
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomepage("ratnajit_dhar").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddAudioFile1;
    private javax.swing.JLabel AddPictureFile1;
    private javax.swing.JLabel AddPictureFile2;
    private javax.swing.JTextField AudioFilepath1;
    private javax.swing.JLabel Cross;
    private javax.swing.JLabel DocDetails;
    private javax.swing.JLabel DocDetails1;
    private javax.swing.JLabel LogoZenSpace;
    private javax.swing.JLabel Minimize;
    private javax.swing.JTextField PictureFilepath1;
    private javax.swing.JLabel RestockNeeded;
    private javax.swing.JLabel SelectSegment1;
    private javax.swing.JButton UploadAudio;
    private javax.swing.JButton UploadPicture;
    private javax.swing.JButton addbutdoc;
    private javax.swing.JButton addtoitem;
    private javax.swing.JButton dailyuser;
    private javax.swing.JLabel dashboard;
    private javax.swing.JPanel dashhboard;
    private javax.swing.JPanel dashpanel;
    private javax.swing.JTextField docadd;
    private javax.swing.JTextField docname;
    private javax.swing.JTextField docno;
    private javax.swing.JTable doctable;
    private javax.swing.JPanel donchart;
    private javax.swing.JComboBox<String> itembox;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemprice;
    private javax.swing.JLabel itemtoshop1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mainpanel;
    private javax.swing.JPanel orderr2;
    private javax.swing.JScrollPane orderscrollpane;
    private javax.swing.JPanel pieshop;
    private javax.swing.JTable shoptable;
    // End of variables declaration//GEN-END:variables
}
