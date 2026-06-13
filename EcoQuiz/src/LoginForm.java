import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class LoginForm extends javax.swing.JFrame {
    
    private musica musica;

    public LoginForm() {
        initComponents();
        UIManager.put("OptionPane.background", new java.awt.Color(220, 255, 220));
        UIManager.put("Panel.background", new java.awt.Color(220, 255, 220));
        UIManager.put("OptionPane.messageFont",
        new java.awt.Font("Segoe UI Emoji", java.awt.Font.PLAIN, 14));

UIManager.put("OptionPane.buttonFont",
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        getContentPane().setBackground(new java.awt.Color(220, 255, 220));

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 20));
        lblTitulo.setForeground(new java.awt.Color(0, 102, 0));

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 14));
        txtNombre.setBackground(new java.awt.Color(245, 255, 245));

        btnIngresar.setText("Comienza tu misión");
        btnIngresar.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 14));
        btnIngresar.setBackground(new java.awt.Color(102, 204, 102));
        btnIngresar.setForeground(java.awt.Color.BLACK);

        setTitle("🌎 EcoQuiz - Misión Guardián del Planeta"); 
        musica = new musica();
        musica.reproducirMusica("src/sonidos/musica.wav");
           
        
        
        
        tutorial tutorial = new tutorial();
        tutorial.mostrarTutorial();            
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("¡Bienvenido, Guardián del Planeta!");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        jLabel1.setText("Ingresa tu nombre para comenzar tu misión ecológica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        String nombre = txtNombre.getText();

        if (nombre.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese un nombre");

        } else {

            Usuario usuario = new Usuario(nombre);

            QuizForm quiz =
                    new QuizForm(new Juego(usuario));

            quiz.setVisible(true);

            dispose();
        }
        

        
    }//GEN-LAST:event_btnIngresarActionPerformed

        public static void main(String args[]) {
            
        
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
