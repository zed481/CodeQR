package codeqr;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Création d'un Code QR
 *
 * @author (2020-30)
 */
public class frmPrincipale extends javax.swing.JFrame {

    BufferedImage imgCodeQR;

    /**
     * Creates new form frmPrincipale
     */
    public frmPrincipale() {
        initComponents();
        setIconImage( new ImageIcon( "QR.png" ).getImage() );
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtTexteCodeQR = new javax.swing.JTextField();
        cmdCreerCodeQR = new javax.swing.JButton();
        jlblCodeQR = new javax.swing.JLabel();
        cmdQuitter = new javax.swing.JButton();
        cmdEnregistrerCodeQR = new javax.swing.JButton();
        jSliderTaille = new javax.swing.JSlider();
        lblTaille = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Générateur de CodeQR");
        setIconImages(null);

        jtxtTexteCodeQR.setText("Texte pour encoder dans le code QR");
        jtxtTexteCodeQR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtTexteCodeQRKeyPressed(evt);
            }
        });

        cmdCreerCodeQR.setText("CodeQR");
        cmdCreerCodeQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCreerCodeQRActionPerformed(evt);
            }
        });

        jlblCodeQR.setText("Le code QR va appraitre ici");

        cmdQuitter.setText("Quitter");
        cmdQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdQuitterActionPerformed(evt);
            }
        });

        cmdEnregistrerCodeQR.setText("Enregistrer en PNG");
        cmdEnregistrerCodeQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnregistrerCodeQRActionPerformed(evt);
            }
        });

        jSliderTaille.setMaximum(1000);
        jSliderTaille.setMinimum(15);
        jSliderTaille.setValue(300);
        jSliderTaille.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderTailleStateChanged(evt);
            }
        });

        lblTaille.setText("Taille : 300");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCodeQR)
                    .addComponent(jtxtTexteCodeQR, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSliderTaille, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cmdCreerCodeQR)
                                .addGap(5, 5, 5)
                                .addComponent(cmdEnregistrerCodeQR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdQuitter)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTaille)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtTexteCodeQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCreerCodeQR)
                    .addComponent(cmdQuitter)
                    .addComponent(cmdEnregistrerCodeQR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderTaille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTaille))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblCodeQR)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCreerCodeQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCreerCodeQRActionPerformed
        try {
            imgCodeQR = CodeBarre.getCodeQR( jtxtTexteCodeQR.getText(), jSliderTaille.getValue() );
            jlblCodeQR.setText( "" );
            jlblCodeQR.setIcon( new javax.swing.ImageIcon( imgCodeQR ) );
            jlblCodeQR.setPreferredSize( new Dimension( imgCodeQR.getHeight(), imgCodeQR.getWidth() ) );

        } catch ( com.google.zxing.WriterException | java.awt.HeadlessException e ) {
            System.err.println( e );
        }
    }//GEN-LAST:event_cmdCreerCodeQRActionPerformed

    private void cmdQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdQuitterActionPerformed
        System.exit( 0 );
    }//GEN-LAST:event_cmdQuitterActionPerformed

    private void cmdEnregistrerCodeQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnregistrerCodeQRActionPerformed
        final FileDialog fd = new FileDialog( this, "Fichier source", FileDialog.SAVE );
        fd.setFile( "*.png" );
        fd.setVisible( true );
        if ( fd.getFile() != null ) {
            final String finalFileName = fd.getDirectory().concat( fd.getFile() );
            try {
                saveImageToPath( imgCodeQR, new File( finalFileName ), "png" );
            } catch ( IOException e ) {
                e.printStackTrace( System.err );
            }
        }
    }//GEN-LAST:event_cmdEnregistrerCodeQRActionPerformed

    private void jSliderTailleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderTailleStateChanged
        lblTaille.setText( "Taille : " + jSliderTaille.getValue() );
        try {
            imgCodeQR = CodeBarre.getCodeQR( jtxtTexteCodeQR.getText(), jSliderTaille.getValue() );
            jlblCodeQR.setText( "" );
            jlblCodeQR.setIcon( new javax.swing.ImageIcon( imgCodeQR ) );
            jlblCodeQR.setPreferredSize( new Dimension( imgCodeQR.getHeight(), imgCodeQR.getWidth() ) );
        } catch ( com.google.zxing.WriterException | java.awt.HeadlessException e ) {
            System.err.println( e );
        }
    }//GEN-LAST:event_jSliderTailleStateChanged

    private void jtxtTexteCodeQRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTexteCodeQRKeyPressed
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ) {
            cmdCreerCodeQRActionPerformed( null );
        }
    }//GEN-LAST:event_jtxtTexteCodeQRKeyPressed

    private static void saveImageToPath( BufferedImage image, File file, String extension ) throws IOException {
        file.delete();
        ImageIO.write( image, extension, file );
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Metal".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger( frmPrincipale.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( () -> {
            new frmPrincipale().setVisible( true );
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCreerCodeQR;
    private javax.swing.JButton cmdEnregistrerCodeQR;
    private javax.swing.JButton cmdQuitter;
    private javax.swing.JSlider jSliderTaille;
    private javax.swing.JLabel jlblCodeQR;
    private javax.swing.JTextField jtxtTexteCodeQR;
    private javax.swing.JLabel lblTaille;
    // End of variables declaration//GEN-END:variables
}
