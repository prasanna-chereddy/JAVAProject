
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


/**
 *
 * @author prasannachereddy
 */
public class PaintFrame extends javax.swing.JFrame {

    Color color = Color.red;
    Drawpanel dp;
    String selectshape = "Line";
    int x1, y1, x2, y2;
    ArrayList<Shape> shapes = new ArrayList<>();
    Stack<Shape> undo = new Stack<>();
    Stack<Shape> redo = new Stack<>();
    Shape tempShape;
    int strokeSize=4;
    boolean isFill;
    FreeShape fs;
    File f;

    class Drawpanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (Shape s : shapes) {
                if (s != null) {
                    s.draw(g);
                }
            }
            if (tempShape != null) {
                tempShape.draw(g);
            }
        }

        public Drawpanel() {
            setBackground(Color.white);
            pnlColor.setBackground(color);

            this.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    lbllocation.setText(e.getX() + "," + e.getY() + "px");

                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    x2 = e.getX();
                    y2 = e.getY();
                    switch (selectshape) {
                        case "Line":
                            tempShape = (Shape) new LineShape(x1, y1, x2, y2, color,strokeSize);
                            break;
                        case "Oval":
                            tempShape = (Shape) new OvalShape(x1, y1, x2, y2, color, isFill,strokeSize);
                            break;
                        case "Rectangle":
                            tempShape = (Shape) new RectShape(x1, y1, x2, y2, color, isFill,strokeSize);
                            break;

                        case "Freedraw":
                            /*  tempShape = (Shape) new LineShape(x1, y1, x2, y2, color);
                             x1=x2;
                             y1=y2;
                             shapes.add(tempShape);*/
                            if (fs == null) {
                                fs = new FreeShape(color);
                            }
                            fs.addLine(x1, y1, x2, y2,strokeSize);
                            x1 = x2;
                            y1 = y2;
                            tempShape = fs;

                            break;
                    }
                    repaint();
                }
            });
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    x1 = e.getX();
                    y1 = e.getY();

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    x2 = e.getX();
                    y2 = e.getY();
                    tempShape = null;
                    Shape s = null;
                    switch (selectshape) {
                        case "Line":
                            s = (Shape) new LineShape(x1, y1, x2, y2, color,strokeSize);
                            break;
                        case "Oval":
                            s = (Shape) new OvalShape(x1, y1, x2, y2, color, isFill,strokeSize);
                            break;
                        case "Rectangle":
                            s = (Shape) new RectShape(x1, y1, x2, y2, color, isFill,strokeSize);
                            break;
                        case "Freedraw":
                            shapes.add(fs);
                            undo.push(fs);
                            fs = null;
                            break;

                    }
                    if (s != null) {
                        shapes.add(s);
                        //BufferedWriter bw = new BufferedWriter(new FileWriter(f));

                        undo.push(s);
                    }
                    repaint();
                }

            });

            //repaint();    
        }
    }

    public PaintFrame() {
        initComponents();
        dp = new Drawpanel();
        setSize(500, 350);
        getContentPane().add(dp);
        btnColorChooser.setBackground(Color.RED);
    }

    // private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    //   shapes.remove(shapes.size() - 1);
    // repaint();
    //}//
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbllocation = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnColorChooser = new javax.swing.JButton();
        list = new javax.swing.JComboBox();
        finalundo = new javax.swing.JButton();
        finalredo = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        CmbStroke = new javax.swing.JComboBox();
        pnlColor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(584, 452));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(584, 30));

        lbllocation.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 502, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllocation, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(281, 92));
        jToolBar1.setMinimumSize(new java.awt.Dimension(264, 32));
        jToolBar1.setPreferredSize(new java.awt.Dimension(264, 32));

        btnColorChooser.setText("Color Chooser");
        btnColorChooser.setFocusable(false);
        btnColorChooser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnColorChooser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnColorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorChooserActionPerformed(evt);
            }
        });
        jToolBar1.add(btnColorChooser);

        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Line", "Oval", "Rectangle", "Freedraw" }));
        list.setMaximumSize(new java.awt.Dimension(90, 90));
        list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listItemStateChanged(evt);
            }
        });
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });
        jToolBar1.add(list);

        finalundo.setText("Undo ");
        finalundo.setFocusable(false);
        finalundo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finalundo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        finalundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalundoActionPerformed(evt);
            }
        });
        jToolBar1.add(finalundo);

        finalredo.setText("Redo");
        finalredo.setFocusable(false);
        finalredo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finalredo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        finalredo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalredoActionPerformed(evt);
            }
        });
        jToolBar1.add(finalredo);

        jToggleButton1.setText("Filled");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton1ItemStateChanged(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton1);

        CmbStroke.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        CmbStroke.setMaximumSize(new java.awt.Dimension(90, 90));
        CmbStroke.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbStrokeItemStateChanged(evt);
            }
        });
        CmbStroke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbStrokeActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbStroke);

        pnlColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlColor.setPreferredSize(new java.awt.Dimension(30, 30));
        pnlColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColorLayout = new javax.swing.GroupLayout(pnlColor);
        pnlColor.setLayout(pnlColorLayout);
        pnlColorLayout.setHorizontalGroup(
            pnlColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        pnlColorLayout.setVerticalGroup(
            pnlColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jToolBar1.add(pnlColor);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("New");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorChooserActionPerformed

        Color c = JColorChooser.showDialog(rootPane, null, Color.yellow);
        //  btnColorChooser.setBackground(c);
        btnColorChooser.setBackground(c);
        color = c;

// TODO add your handling code here:
    }//GEN-LAST:event_btnColorChooserActionPerformed

    private void pnlColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColorMouseClicked

        Color c = JColorChooser.showDialog(rootPane, null, Color.yellow);
        if (c == null) {
            c = Color.RED;
        }
        pnlColor.setBackground(c);
        color = c;

        // TODO add your handling code here:
    }//GEN-LAST:event_pnlColorMouseClicked

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listActionPerformed

    private void listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listItemStateChanged
        selectshape = list.getSelectedItem().toString();
    }//GEN-LAST:event_listItemStateChanged

    private void finalundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalundoActionPerformed

        if (undo.isEmpty()) {
            return;
        }
        tempShape = null;
        Shape us = undo.pop();
        shapes.remove(us);
        redo.push(us);

        repaint();

    }//GEN-LAST:event_finalundoActionPerformed

    private void finalredoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalredoActionPerformed

       if(redo.isEmpty()) return;
       
        Shape rs = redo.pop();
        shapes.add(rs);
        undo.push(rs);
      
            repaint();
        

    }//GEN-LAST:event_finalredoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // Serialize data object to a file
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showSaveDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(jfc.getSelectedFile()));
                out.writeObject(shapes);
                out.close();
            }

        } catch (IOException e) {
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

 try {
            // Serialize data object to a file
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showOpenDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {

                ObjectInputStream in = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
             shapes= (ArrayList < Shape >)in.readObject();
             repaint();
                in.close();
            }

        } catch (IOException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaintFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton1ItemStateChanged
  
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            isFill = true;
        } else {
            isFill = false;
        }
    
    }//GEN-LAST:event_jToggleButton1ItemStateChanged

    private void CmbStrokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbStrokeActionPerformed
             // TODO add your handling code here:
    }//GEN-LAST:event_CmbStrokeActionPerformed

    private void CmbStrokeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbStrokeItemStateChanged
        strokeSize = Integer.parseInt(CmbStroke.getSelectedItem().toString());

    }//GEN-LAST:event_CmbStrokeItemStateChanged

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
              
            shapes.clear();
              repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaintFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbStroke;
    private javax.swing.JButton btnColorChooser;
    private javax.swing.JButton finalredo;
    private javax.swing.JButton finalundo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbllocation;
    private javax.swing.JComboBox list;
    private javax.swing.JPanel pnlColor;
    // End of variables declaration//GEN-END:variables
}
