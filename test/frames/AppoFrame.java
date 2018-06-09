// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AppoFrame.java

package frames;

import classes.Date;
import classes.FileAppo;
import classes.Message;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

// Referenced classes of package frames:
//            Window, ProfileFrame

public class AppoFrame extends Window
    implements ActionListener
{

    public AppoFrame(ProfileFrame profileFrame, float heigth, String rute)
    {
        super("Cita");
        this.profileFrame = profileFrame;
        height = heigth;
        initComponents();
        super.m.setMassage("\277Deseas cancelar el registro de cita?");
        addBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        this.rute = rute;
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == exitBtn)
            ownClose();
        else
        if(event.getSource() == addBtn)
            if(weightTxt.getText().isEmpty() || waistTxt.getText().isEmpty() || hipTxt.getText().isEmpty())
                new Message().showMessage();
            else
                createFile();
    }

    public void ownClose()
    {
        super.setAlwaysOnTop(false);
        super.setVisible(false);
        profileFrame.setEnabled(true);
    }

    private void createFile()
    {
        FileAppo file = new FileAppo(rute, "Sesión " + ++profileFrame.appoiments);
        file.setDate((new Date(new java.sql.Date((new java.util.Date()).getTime()))).getDate());
        file.setWeight(weightTxt.getText());
        file.setWaist(waistTxt.getText());
        file.setHip(hipTxt.getText());
        file.setHeigth(height + "");
        float tmpF = height / 100;
        float IMC = Float.parseFloat(weightTxt.getText()) / (tmpF * tmpF);
        file.setImc(IMC + "");
        file.setAnnotations(obsTxt.getText());
        file.setDiet(dietTxt.getText());
        file.write();
        Message m = new Message();
        m.setTitle("\241Cita guardada!");
        m.setMassage("Se han guardado los datos exit\363samente.");
        profileFrame.refreshLst(IMC, Float.parseFloat(weightTxt.getText()), Float.parseFloat(waistTxt.getText()), Float.parseFloat(hipTxt.getText()));
        ownClose();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        weightTxt = new JTextField();
        imcLbl = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        dietTxt = new JTextArea();
        jScrollPane2 = new JScrollPane();
        obsTxt = new JTextArea();
        hipTxt = new JTextField();
        jLabel5 = new JLabel();
        waistTxt = new JTextField();
        jLabel6 = new JLabel();
        addBtn = new JButton();
        exitBtn = new JButton();
        setDefaultCloseOperation(3);
        jLabel1.setFont(new Font("Dialog", 1, 18));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("Citas");
        jLabel2.setFont(new Font("Dialog", 1, 16));
        jLabel2.setText("Peso");
      
        imcLbl.setFont(new Font("Dialog", 1, 16));
        imcLbl.setText("IMC");
        jLabel3.setFont(new Font("Dialog", 1, 18));
        jLabel3.setHorizontalAlignment(0);
        jLabel3.setText("Dieta");
        jLabel4.setFont(new Font("Dialog", 1, 18));
        jLabel4.setHorizontalAlignment(0);
        jLabel4.setText("Observaciones");
        dietTxt.setColumns(20);
        dietTxt.setRows(5);
        jScrollPane1.setViewportView(dietTxt);
        obsTxt.setColumns(20);
        obsTxt.setRows(5);
        jScrollPane2.setViewportView(obsTxt);
        jLabel5.setFont(new Font("Dialog", 1, 16));
        jLabel5.setText("Cadera");
        jLabel6.setFont(new Font("Dialog", 1, 16));
        jLabel6.setText("Cintura");
        addBtn.setText("Agregar");
        exitBtn.setText("Salir");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(jLabel2, -2, 100, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(weightTxt, -2, 193, -2)).addComponent(imcLbl, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jLabel5, -2, 100, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(hipTxt, -2, 193, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jLabel6, -2, 100, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(waistTxt, -2, 193, -2)))).addComponent(jLabel1, -1, -1, 32767).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3, -2, 360, -2).addComponent(jScrollPane1, -2, 360, -2).addComponent(exitBtn, javax.swing.GroupLayout.Alignment.TRAILING, -2, 150, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(addBtn, -2, 150, -2).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel4, -1, -1, 32767).addComponent(jScrollPane2, -1, 360, 32767))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(weightTxt, -2, -1, -2).addComponent(jLabel5).addComponent(hipTxt, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(imcLbl).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(waistTxt, -2, -1, -2))).addGap(18, 18, 18).addComponent(jSeparator1, -2, 17, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel4)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane2, -1, 150, 32767).addComponent(jScrollPane1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(addBtn).addComponent(exitBtn)).addContainerGap()));
        pack();
        weightTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                weightTxtFocusLost(evt);
            }
        });
    }

    private void weightTxtFocusLost(FocusEvent evt)
    {
        String tmp = weightTxt.getText();
        try
        {
            float tmpF = height / 100F;
            float IMC = Float.parseFloat(tmp) / (tmpF * tmpF);
            imcLbl.setText((new StringBuilder()).append("IMC:   ").append(IMC).toString());
        }
        catch(NumberFormatException e)
        {
            weightTxt.setText("");
        }
    }

    private void hipTxtFocusLost(FocusEvent evt)
    {
        String tmp = hipTxt.getText();
        try
        {
            Float.parseFloat(tmp);
        }
        catch(NumberFormatException e)
        {
            hipTxt.setText("");
        }
    }

    private void waistTxtFocusLost(FocusEvent evt)
    {
        String tmp = waistTxt.getText();
        try
        {
            Float.parseFloat(tmp);
        }
        catch(NumberFormatException e)
        {
            waistTxt.setText("");
        }
    }

    float height;
    String name;
    ProfileFrame profileFrame;
    String rute;
    private JButton addBtn;
    private JTextArea dietTxt;
    private JButton exitBtn;
    private JTextField hipTxt;
    private JLabel imcLbl;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JTextArea obsTxt;
    private JTextField waistTxt;
    private JTextField weightTxt;



}
