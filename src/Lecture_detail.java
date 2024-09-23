
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

public class Lecture_detail extends javax.swing.JFrame {

    int lecture_id;

    public Lecture_detail(int id) {
        initComponents();

        lecture_id = id;
        details();

        setSize(500, 400);
    }

    void details() {
        String ans = myClient.fetchdetails(lecture_id);

        StringTokenizer st = new StringTokenizer(ans, "$");

        int id = Integer.parseInt(st.nextToken());
        String name1 = st.nextToken();
        String description1 = st.nextToken();
        String duration = st.nextToken();
        String photo = st.nextToken();
        int course_id = Integer.parseInt(st.nextToken());
        String trailer1 = st.nextToken();
        String video1 = st.nextToken();

        ImageIcon ic = new ImageIcon(photo);

        Image img = ic.getImage().getScaledInstance(poster.getWidth(), poster.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon ic1 = new ImageIcon(img);

        poster.setIcon(ic1);

        name.setText(name1);

        description.setText(description1);

        trailer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    URI uri = new URI("https://www.youtube.com/watch?v=" + trailer1);

                    Desktop d = Desktop.getDesktop();

                    d.browse(uri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        lecture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    File f = new File(video1);

                    Desktop d = Desktop.getDesktop();

                    d.open(f);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poster = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        trailer = new javax.swing.JButton();
        lecture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        poster.setText("jLabel1");
        getContentPane().add(poster);
        poster.setBounds(-2, 0, 270, 400);

        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 40, 90, 17);
        getContentPane().add(name);
        name.setBounds(310, 70, 170, 23);

        jLabel2.setText("Derscription");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 120, 80, 20);

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 150, 170, 110);

        trailer.setText("Play Trailer");
        getContentPane().add(trailer);
        trailer.setBounds(310, 310, 170, 23);

        lecture.setText("Play Lecture");
        getContentPane().add(lecture);
        lecture.setBounds(310, 360, 170, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Lecture_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecture_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecture_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecture_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lecture_detail(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lecture;
    private javax.swing.JTextField name;
    private javax.swing.JLabel poster;
    private javax.swing.JButton trailer;
    // End of variables declaration//GEN-END:variables
}
