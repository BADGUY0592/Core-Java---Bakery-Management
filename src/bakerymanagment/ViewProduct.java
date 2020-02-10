
package bakerymanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewProduct extends javax.swing.JInternalFrame implements MyVariables{

    
    public ViewProduct() {
        initComponents();
    try
     {
        Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
        try
        {
            String m1="select catname from addcat";
            PreparedStatement mystatement1=myconnection.prepareStatement(m1);
            ResultSet r1=mystatement1.executeQuery();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        t1 = new javax.swing.JComboBox<>();
        t2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("View Products");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Sub Category", "Brand", "Product", "Quantity", "Price", "Discount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        t1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur Category" }));
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur Sub Category" }));
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
     
    }//GEN-LAST:event_t2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(t2.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Select Sub Categoty First");
        }
        else if(t1.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "Select Categoty First");
        }
        else
        {
           try
         {
            Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
            try
            {
                DefaultTableModel mymodel=(DefaultTableModel) jTable1.getModel();
                
                String myquery="select * from addproduct where subcatname=? and catname=?";
                PreparedStatement mystatement=myconnection.prepareStatement(myquery);
                mystatement.setString(1, t2.getSelectedItem().toString());
                if(t1.getSelectedIndex()==0)
                mystatement.setString(2, t1.getSelectedItem().toString());
                ResultSet r1=mystatement.executeQuery();
                if(r1.next())
                {
                    do
                    {
                        String catname1,subcatname1,brandname1,prodname1,quantity1,price1,discount1;
                        catname1=r1.getString("catname");
                        subcatname1=r1.getString("subcatname");
                        brandname1=r1.getString("brandname");
                        prodname1=r1.getString("prodname");
                        quantity1=r1.getString("quantity");
                        price1=r1.getString("price");
                        discount1=r1.getString("discount");
                        mymodel.addRow(new String[]{catname1,subcatname1,brandname1,prodname1,quantity1,price1,discount1});
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> t1;
    private javax.swing.JComboBox<String> t2;
    // End of variables declaration//GEN-END:variables
}
