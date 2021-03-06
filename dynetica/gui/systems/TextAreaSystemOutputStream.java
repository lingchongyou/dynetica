/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynetica.gui.systems;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/**
 * 
 * @author lingchong
 */
public class TextAreaSystemOutputStream extends javax.swing.JPanel {
    private TextAreaOutputStream taOutputStream;

    /**
     * Creates new form TextAreaSystemOutputStream
     */
    public TextAreaSystemOutputStream() {
        initComponents();
        taOutputStream = new TextAreaOutputStream(sysOutputArea, "Dynetica");
        System.setOut(new PrintStream(taOutputStream));

        /*
         * int timerDelay = 1000; new Timer(timerDelay , new ActionListener() {
         * int count = 0;
         * 
         * @Override public void actionPerformed(ActionEvent arg0) {
         * 
         * // though this outputs via System.out.println, it actually displays
         * // in the JTextArea: System.out.println("Count is now: " + count +
         * " seconds"); count++; } }).start();
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sysOutputArea = new javax.swing.JTextArea();
        sysOutLabel = new javax.swing.JLabel();

        setSize(new java.awt.Dimension(200, 300));
        setLayout(new java.awt.BorderLayout());

        sysOutputArea.setColumns(20);
        sysOutputArea.setRows(5);
        jScrollPane1.setViewportView(sysOutputArea);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        sysOutLabel.setText("Output Infomation");
        add(sysOutLabel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sysOutLabel;
    private javax.swing.JTextArea sysOutputArea;

    // End of variables declaration//GEN-END:variables

    public static void createAndShowGui() {
        JFrame frame = new JFrame("Dynetica output");
        // frame.setDefaultCloseOperation(JFrame.);
        frame.getContentPane().add(new TextAreaSystemOutputStream());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    public class TextAreaOutputStream extends OutputStream {

        private final JTextArea textArea;
        private final StringBuilder sb = new StringBuilder();
        private String title;

        public TextAreaOutputStream(final JTextArea textArea, String title) {
            this.textArea = textArea;
            this.title = title;
            sb.append(title + "> ");
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }

        @Override
        public void write(int b) throws IOException {

            if (b == '\r')
                return;

            if (b == '\n') {
                final String text = sb.toString() + "\n";
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        textArea.append(text);
                    }
                });
                sb.setLength(0);
                sb.append(title + "> ");
                return;
            }

            sb.append((char) b);
        }
    }
}
