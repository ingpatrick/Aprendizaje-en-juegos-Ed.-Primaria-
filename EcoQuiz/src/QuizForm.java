import javax.swing.JOptionPane;

public class QuizForm extends javax.swing.JFrame {

    private Juego juego;
    private sonidos sonido;

    public QuizForm(Juego juego) {

    initComponents();
    getContentPane().setBackground(new java.awt.Color(220, 255, 220));
    lblPregunta.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 18));
    lblPregunta.setForeground(new java.awt.Color(0, 102, 0));

    rb1.setBackground(new java.awt.Color(220, 255, 220));
    rb2.setBackground(new java.awt.Color(220, 255, 220));
    rb3.setBackground(new java.awt.Color(220, 255, 220));

    rb1.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 14));
    rb2.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 14));
    rb3.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 14));

btnSiguiente.setText("Responder");
btnSiguiente.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 14));
btnSiguiente.setBackground(new java.awt.Color(102, 204, 102));
btnSiguiente.setForeground(java.awt.Color.BLACK);

lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

btnSiguiente.setFocusPainted(false);
    grupo.add(rb1);
    grupo.add(rb2);
    grupo.add(rb3);

    sonido = new sonidos();  

    this.juego = juego;
    setLocationRelativeTo(null);
    mostrarPregunta();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        lblPregunta = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPregunta.setText("                                                   Pregunta");

        rb1.setText("1");

        rb2.setText("2");

        rb3.setText("3");

        btnSiguiente.setText("Responder");
        btnSiguiente.addActionListener(this::btnSiguienteActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSiguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE))
                            .addComponent(rb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rb2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb3)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mostrarPregunta() {

        Pregunta pregunta = juego.obtenerPreguntaActual();

        lblPregunta.setText(pregunta.getEnunciado());

        String[] alternativas =
                pregunta.getAlternativas();

        rb1.setText(alternativas[0]);
        rb2.setText(alternativas[1]);
        rb3.setText(alternativas[2]);
    }
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        int respuesta = -1;

        if (rb1.isSelected()) {
            respuesta = 0;
        }

        if (rb2.isSelected()) {
            respuesta = 1;
        }

        if (rb3.isSelected()) {
            respuesta = 2;
        }

        if (respuesta == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione una respuesta");
            return;
        }

        Pregunta preguntaActual = juego.obtenerPreguntaActual();
        boolean correcta = juego.verificarRespuesta(respuesta);
           
       
        
        if (correcta) {

    sonido.reproducirCorrecto();

    JOptionPane.showMessageDialog(
            this,
            "¡Correcto!\n\n" + preguntaActual.getExplicacion()
    );

            } else {

             sonido.reproducirIncorrecto();

            JOptionPane.showMessageDialog(
            this,
            "Respuesta incorrecta"
        );
        }
                       
        juego.siguientePregunta();
    
        if (juego.finJuego()) {

            Usuario usuario = juego.getUsuario();

            Archivo archivo = new Archivo();

            archivo.guardarResultado(
                    usuario.getNombre(),
                    usuario.getPuntaje());

            JOptionPane.showMessageDialog(this,"Juego terminado");
                  
   
            JOptionPane.showMessageDialog(this,                
            "Integrantes del proyecto:\n"
            + "Escalante Guevara; P\n"
            + "Quesada Lavado; J\n"
            + "Rojas Condorchoa; D\n",
            "Créditos",
            JOptionPane.INFORMATION_MESSAGE
            );       

            resultados_visual resultado = new resultados_visual(
                    usuario.getNombre(),
                    usuario.getPuntaje());

                    resultado.setVisible(true);
                    dispose();
        } 
        else {
        grupo.clearSelection();
        mostrarPregunta();
        }
         
         

    }//GEN-LAST:event_btnSiguienteActionPerformed
            
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    // End of variables declaration//GEN-END:variables
}
