// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Window.java

package frames;

import classes.Message;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Referenced classes of package frames:
//            MainFrame

public class Window extends JFrame
{

    public Window(String title)
    {
        setResizable(false);
        setTitle(title);
        setIconImage(null);
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        setLocationRelativeTo(null);
        setSize(1000, 1100);
        m = new Message(new Object[] {
            "S\355", "No"
        }, "Salir", "\277Desea salir?");
        close();
    }

    public void close()
    {
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt)
            {
                if(m.showMessage() == 0)
                    ownClose();
            }
        });
    }

    public void ownClose()
    {
        System.exit(0);
    }

    void addKeyListener()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Message m;
}
