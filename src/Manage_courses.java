
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class Manage_courses extends javax.swing.JFrame {

    JFileChooser jfc;
    File ph;
    
    ArrayList<course> al = new ArrayList<>();
    
    myTableModel tm;
    
    public Manage_courses() {
        initComponents();
        load_category();
        
        tm = new myTableModel();
        
        mytable.setModel(tm);
        setSize(800, 400);
    }
    
    void load_category()
    {
        String ans = myClient.fetchCategories();
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        
        int n  = st.countTokens();
        
        cb1.addItem("Select");
        
        for (int i = 1; i <=n; i++) 
        {
          String name = st.nextToken();
          
          cb.addItem(name);
          cb1.addItem(name);
        }
    }
    
    void fetchData()
    {
        String category = (String) cb1.getSelectedItem();
      
      String ans = myClient.fetchCourses(category);
      
      StringTokenizer st = new StringTokenizer(ans,";;");
      
      al.clear();
      
      while(st.hasMoreTokens())
      {
       String row = st.nextToken();
       
       StringTokenizer st1 = new StringTokenizer(row,"$");
       
       int id = Integer.parseInt(st1.nextToken());
       String name = st1.nextToken();
       String desc = st1.nextToken();
       String photo = st1.nextToken();
       
       al.add(new course(id, name, desc, photo));
          
      }
    tm.fireTableDataChanged();
    }
    
 class myTableModel extends AbstractTableModel
 {

        @Override
        public int getRowCount() {
         return al.size();
        }

        @Override
        public int getColumnCount() {
        return 3;
        }

        @Override
        public Object getValueAt(int i, int j) {
            if(j==0)
            {
                return al.get(i).name;
            }
            else if(j==1)
            {
                return al.get(i).desc;
            }
            else
            {
                return al.get(i).photo;
            }
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        course_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        course_description = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Courses");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 40);

        jLabel2.setText("View Courses");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 67, 180, 10);

        jLabel3.setText("Add Course");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 180, 17);

        jLabel4.setText("Category");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 100, 150, 17);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        getContentPane().add(cb);
        cb.setBounds(30, 130, 210, 23);

        jLabel5.setText("Category");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 100, 150, 17);

        getContentPane().add(cb1);
        cb1.setBounds(460, 130, 220, 23);

        jLabel6.setText("Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 120, 17);

        course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_nameActionPerformed(evt);
            }
        });
        getContentPane().add(course_name);
        course_name.setBounds(30, 200, 210, 23);

        jLabel7.setText("Description");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 240, 100, 17);
        getContentPane().add(course_description);
        course_description.setBounds(30, 270, 210, 23);

        jLabel8.setText("photo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 310, 90, 17);

        photolb.setText("jLabel9");
        getContentPane().add(photolb);
        photolb.setBounds(30, 340, 150, 140);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 360, 120, 23);

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 410, 120, 23);

        jButton3.setText("View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(690, 130, 72, 23);

        mytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(mytable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(460, 180, 320, 230);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(590, 430, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    private void course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jfc = new JFileChooser();
       
       int ans = jfc.showOpenDialog(this);
       
       if(ans == JFileChooser.APPROVE_OPTION)
       {
           ph = jfc.getSelectedFile();
           
           ImageIcon ic = new ImageIcon(ph.getPath());
           
           Image img = ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
           
           ImageIcon ic1 = new ImageIcon(img);
           
           photolb.setIcon(ic1);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        String coursename = course_name.getText();
        String coursedescription = course_description.getText();
        String category = (String) cb.getSelectedItem();
        
        String ans = myClient.addCourse(category, coursename, coursedescription, ph);
        
        if(ans.trim().equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "success");
        }
        else
        {
             JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fetchData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int i = mytable.getSelectedRow();
        
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Row!");
            
        }
        else
        {
            int id = al.get(i).id;
            
           String ans = myClient.deleteCourse(id);
           
           if(ans.trim().equals("success"))
           {
               JOptionPane.showMessageDialog(rootPane, "deleted Successfully");
               fetchData();
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane,ans); 
           }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JTextField course_description;
    private javax.swing.JTextField course_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mytable;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}
