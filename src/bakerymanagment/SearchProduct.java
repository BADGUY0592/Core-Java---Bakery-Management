
package bakerymanagment;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SearchProduct extends javax.swing.JInternalFrame implements MyVariables{

   
    public SearchProduct() {
        initComponents();
        try
     {
        Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
        try
        {
            String m1="select catname from addcat";
            String m2="select brandname from addbrand";
            PreparedStatement mystatement1=myconnection.prepareStatement(m1);
            ResultSet r1=mystatement1.executeQuery();
            PreparedStatement mystatement2=myconnection.prepareStatement(m2);
            ResultSet r2=mystatement2.executeQuery();
            if(r1.next())
            {
                do{
                    t1.addItem(r1.getString("catname"));
                }while(r1.next());
            }
            else
            {
                t1.addItem("No Category Added");
            }
            if(r2.next())
            {
                do{
                    t3.addItem(r2.getString("brandname"));
                }while(r2.next());
            }
            else
            {
                t3.addItem("No Brand Added");
            }
        }
        catch(Exception et)
        {
            JOptionPane.showMessageDialog(rootPane, "Error in querry due to "+et.getMessage());
        }
        finally
        {
            myconnection.close();
        }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(rootPane, "Error in connection due to "+e.getMessage());
     }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t1 = new javax.swing.JComboBox<>();
        t2 = new javax.swing.JComboBox<>();
        t3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Search Product");

        t1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur Category" }));
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur SubCategory" }));
        t2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t2MousePressed(evt);
            }
        });
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        t3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur Brand" }));

        jLabel1.setText("Name");

        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t4KeyPressed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Price", "Discount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t2MousePressed
        try
     {
        Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
        try
        {
            String myquery="select subcatname from addsubcat where catname =?";
            PreparedStatement mystatement=myconnection.prepareStatement(myquery);
            mystatement.setString(1, t1.getSelectedItem().toString());
            ResultSet r1=mystatement.executeQuery();
                if(r1.next())
                {   
                    do{
                    t2.addItem(r1.getString("subcatname"));
                }while(r1.next());
            }
            else
            {
                t3.addItem("No Sub Category Added");
            }
        }
        catch(Exception et)
        {
            JOptionPane.showMessageDialog(rootPane, "Error in querry due to "+et.getMessage());
        }
        finally
        {
            myconnection.close();
        }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(rootPane, "Error in connection due to "+e.getMessage());
     }
    }//GEN-LAST:event_t2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(t2.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Select Sub Categoty First");
        }
        else if(t1.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Select Categoty First");
        }
        else if(t3.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Select Brand First");
        }
        else
        {
            try
         {
            Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
            try
            {
                DefaultTableModel mymodel=(DefaultTableModel) jTable1.getModel();
                String myquery="select * from addproduct where prodname like ? and catname =? and subcatname=? and brandname=?";
                PreparedStatement mystatement=myconnection.prepareStatement(myquery);
                mystatement.setString(1, t4.getText());
                mystatement.setString(2, t1.getSelectedItem().toString());
                mystatement.setString(3, t2.getSelectedItem().toString());
                mystatement.setString(4, t3.getSelectedItem().toString());
                ResultSet r1=mystatement.executeQuery();
                if(r1.next())
                {
                    do
                    {
                        String prodname1,quantity1,price1,discount1;
                        prodname1=r1.getString("prodname");
                        quantity1=r1.getString("quantity");
                        price1=r1.getString("price");
                        discount1=r1.getString("discount");
                        mymodel.addRow(new String[]{prodname1,quantity1,price1,discount1});
                    }while(r1.next());
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Some Problem Occured");
                }
            }
            catch(Exception et)
            {
                JOptionPane.showMessageDialog(rootPane, "Error in querry due to "+et.getMessage());
            }
            finally
            {
                myconnection.close();
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(rootPane, "Error in connection due to "+e.getMessage());
         }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jButton1.doClick();
        }
    }//GEN-LAST:event_t4KeyPressed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
          try
     {
        Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
        try
        {
            String myquery="select subcatname from addsubcat where catname =?";
            PreparedStatement mystatement=myconnection.prepareStatement(myquery);
            mystatement.setString(1, t1.getSelectedItem().toString());
            ResultSet r1=mystatement.executeQuery();
                if(r1.next())
                {   
                    do{
                    t2.addItem(r1.getString("subcatname"));
                }while(r1.next());
            }
            else
            {
                t2.addItem("No Sub Category Added");
            }
        }
        catch(Exception et)
        {
            JOptionPane.showMessageDialog(null, "Error in querry due to "+et.getMessage());
        }
        finally
        {
            myconnection.close();
        }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, "Error in connection due to "+e.getMessage());
     }
    }//GEN-LAST:event_t1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> t1;
    private javax.swing.JComboBox<String> t2;
    private javax.swing.JComboBox<String> t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
