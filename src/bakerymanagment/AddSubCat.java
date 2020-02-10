
package bakerymanagment;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class AddSubCat extends javax.swing.JInternalFrame implements MyVariables
{
    
    public AddSubCat() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t1 = new javax.swing.JComboBox<>();
        t2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Add SubCategory");

        jLabel1.setText("Category");

        jLabel2.setText("SubCategory");

        t1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Ur Category" }));

        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });

        jButton1.setText("ADD SUB CATEGORY");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t1, 0, 197, Short.MAX_VALUE)
                            .addComponent(t2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(t1.getSelectedIndex()==0)
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
            String myquery="insert into addsubcat(catname,subcatname) values(?,?)";
            PreparedStatement mystatement=myconnection.prepareStatement(myquery);
            mystatement.setString(1, t1.getSelectedItem().toString());
            mystatement.setString(2, t2.getText());
            if(mystatement.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(rootPane, "Sub Category Added Successfully");
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

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jButton1.doClick();
        }
    }//GEN-LAST:event_t2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
