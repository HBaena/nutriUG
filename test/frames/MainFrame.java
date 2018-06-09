// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MainFrame.java

package frames;

import classes.*;
import classes.usrclasses.PersonalData;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// Referenced classes of package frames:
//            Window, RegistryFrame, ProfileFrame

public class MainFrame extends Window
    implements ActionListener
{

    public MainFrame(String title)
    {
        super(title);
        rute = "/home/"+ System.getProperty("user.name")+"/";
        rutePdf = rute + "Escritorio/";
        File file = new File((new StringBuilder()).append(rute).append(".USERDATA/conf").toString());
        if(!file.exists())
            try
            {
                file.createNewFile();
                FileWriter fileW = new FileWriter(file);
                PrintWriter writer = new PrintWriter(file);
                writer.println();
                writer.println();
                writer.println();
                writer.println();
                writer.println();
                writer.println("\nPara cambiar la configuraci\363n debes editar \351ste archivo.");
                writer.println("1ra Linea  ---- > rootpath");
                writer.println("2da Linea  ---- > pdfFiles");
                writer.println("3ra Linea  ---- > profileMail");
                writer.println("4ta Linea  ---- > passwordMail");
                writer.println("5ta Linea  ---- > nameOwner");
                writer.close();
            }
            catch(Exception exception) { }
        ConfFiles confFiles = new ConfFiles((new StringBuilder()).append(rute).append(".USERDATA/conf").toString());
        confFiles.read();
        String tmp = confFiles.getRootpath();
        if(!tmp.isEmpty())
            rute = tmp;
        tmp = confFiles.getPdfFiles();
        if(!tmp.isEmpty())
            rutePdf = tmp;
        initComponents();
        userList = new UserList(rute);
        userLst.setListData(userList.getNamesArray());
        selecBtn.addActionListener(this);
        addBtn.addActionListener(this);
        anottationTxtArea.setMargin(new Insets(10, 10, 10, 10));
        anottationTxtArea.setEditable(false);
        message = new Message();
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        Color color = new Color(0, 245, 255);
        super.setBackground(color);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == selecBtn)
        {
            if(userLst.isSelectionEmpty())
                message.showMessage(new Object[] {
                    "Ok"
                }, "Seleccione algo", "Debe seleccionar a un usuario");
            else
                itemSelected();
        } else
        if(e.getSource() == addBtn)
        {
            registryFrame = new RegistryFrame("Registro", this);
            setVisible(false);
            registryFrame.setVisible(true);
        }
    }

    public void deletItem(String fileName, int index)
    {
        File f = new File(fileName);
        f.delete();
        super.setVisible(true);
        userList.delete(index);
        refresh();
    }

    private void preferences()
    {
    }

    public void refresh()
    {
        userLst.setListData(userList.getNamesArray());
        nameLbl.setText("Nombre");
        eMailLbl.setText("Correo: ");
        phoneLbl.setText("Tel\351fono: ");
        edadLbl.setText("Edad: ");
        anottationTxtArea.setText("");
        ImageIcon photo = null;
        photo = new ImageIcon(getClass().getResource("/profileDefaultImage.png"));
        profilePhoto.setIcon(new ImageIcon(photo.getImage().getScaledInstance(160, 191, 0)));
    }

    private void itemSelected()
    {
        int index = userLst.getSelectedIndex();
        profileFrame = new ProfileFrame((User)userList.getUsersList().get(index), index, this);
        profileFrame.setVisible(true);
        super.setVisible(false);
    }

    public void editItem(int index, User user)
    {
        userList.getUsersList().set(index, user);
        userLst.setSelectedIndex(-1);
        refresh();
    }

    public void addItem(User user)
    {
        userList.userAdd(user);
        userLst.setListData(userList.getNamesArray());
    }

    public void ownClose()
    {
        userList.saveList();
        System.exit(0);
    }

    private void initComponents()
    {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        userLst = new JList();
        addBtn = new JButton();
        selecBtn = new JButton();
        jLabel4 = new JLabel();
        anotationLbl = new JLabel();
        eMailLbl = new JLabel();
        phoneLbl = new JLabel();
        edadLbl = new JLabel();
        nameLbl = new JLabel();
        jScrollPane2 = new JScrollPane();
        anottationTxtArea = new JTextArea();
        profilePhoto = new JLabel();
        setDefaultCloseOperation(3);
        jLabel1.setBackground(new Color(1, 1, 1));
        jLabel1.setFont(new Font("Dialog", 3, 26));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("Nutrici\363n");
        jLabel2.setFont(new Font("Dialog", 1, 18));
        jLabel2.setHorizontalAlignment(0);
        jLabel2.setText("Clientes");
        userLst.setFont(new Font("Dialog", 1, 16));
        userLst.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userLst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               userLstMouseClicked(evt);
            }
        });
        userLst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userLstKeyPressed(evt);
            }
        });
        userLst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt)
            {
                userLstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(userLst);
        addBtn.setText("A\361adir");
        selecBtn.setText("Select");
        jLabel4.setFont(new Font("Dialog", 1, 18));
        jLabel4.setHorizontalAlignment(0);
        jLabel4.setText("Vista previa");
        anotationLbl.setFont(new Font("Dialog", 1, 20));
        anotationLbl.setForeground(new Color(1, 1, 1));
        anotationLbl.setHorizontalAlignment(0);
        anotationLbl.setText("Anotaciones");
        eMailLbl.setFont(new Font("Dialog", 1, 18));
        eMailLbl.setForeground(new Color(1, 1, 1));
        eMailLbl.setHorizontalAlignment(2);
        eMailLbl.setText("   Correo:");
        phoneLbl.setFont(new Font("Dialog", 1, 18));
        phoneLbl.setForeground(new Color(1, 1, 1));
        phoneLbl.setHorizontalAlignment(2);
        phoneLbl.setText("Tel\351fono:");
        edadLbl.setFont(new Font("Dialog", 1, 18));
        edadLbl.setForeground(new Color(1, 1, 1));
        edadLbl.setHorizontalAlignment(2);
        edadLbl.setText("      Edad:");
        nameLbl.setFont(new Font("Dialog", 1, 20));
        nameLbl.setForeground(new Color(1, 1, 1));
        nameLbl.setHorizontalAlignment(0);
        nameLbl.setText("Nombre");
        anottationTxtArea.setColumns(20);
        anottationTxtArea.setFont(new Font("Dialog", 1, 18));
        anottationTxtArea.setRows(5);
        jScrollPane2.setViewportView(anottationTxtArea);
        profilePhoto.setHorizontalAlignment(0);
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2, -2, 460, -2).addGap(46, 46, 46).addComponent(jLabel4, -1, 515, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(addBtn, -2, 200, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(selecBtn, -2, 200, -2)).addComponent(jScrollPane1, -2, 460, -2)).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(46, 46, 46).addComponent(anotationLbl, -1, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(eMailLbl, -2, 250, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(edadLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(phoneLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(nameLbl, -2, 250, -2)).addGap(95, 95, 95))).addComponent(profilePhoto, -2, 160, -2).addGap(10, 10, 10))))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, -2, 54, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2, -2, 47, -2).addComponent(jLabel4, -2, 47, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(nameLbl).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(eMailLbl).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(phoneLbl).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(edadLbl).addGap(77, 77, 77)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(profilePhoto, -2, 191, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addComponent(anotationLbl).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2, -2, 135, -2)).addComponent(jScrollPane1, -2, 362, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(addBtn).addComponent(selecBtn)).addContainerGap(24, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1051, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 3, 32767).addComponent(jPanel1, -2, -1, -2).addGap(0, 3, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 548, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(jPanel1, -2, -1, -2).addGap(0, 0, 32767))));
        pack();
    }

    private void userLstMouseClicked(MouseEvent evt)
    {
        if(evt.getClickCount() == 2)
        {
            int index = userLst.locationToIndex(evt.getPoint());
            if(index < 0)
                return;
            itemSelected();
        }
    }

    private void userLstKeyPressed(KeyEvent evt)
    {
        if(evt.getKeyChar() == '\n')
            itemSelected();
    }

    private void userLstValueChanged(ListSelectionEvent evt)
    {
        if(userLst.isSelectionEmpty())
            return;
        int index = userLst.getSelectedIndex();
        nameLbl.setText(((User)userList.getUsersList().get(index)).getPersonalData().getName());
        eMailLbl.setText((new StringBuilder()).append("Correo: ").append(((User)userList.getUsersList().get(index)).getPersonalData().geteMail()).toString());
        phoneLbl.setText((new StringBuilder()).append("Tel\351fono: ").append(((User)userList.getUsersList().get(index)).getPersonalData().getPhone()).toString());
        edadLbl.setText((new StringBuilder()).append("    Edad: ").append(((User)userList.getUsersList().get(index)).getPersonalData().getNUA()).toString());
        FileReminder reminder = new FileReminder((new StringBuilder()).append(rute).append(".USERDATA/").append(((User)userList.getUsersList().get(index)).getPersonalData().getName()).toString());
        String filePhoto = reminder.PHOTO;
        anottationTxtArea.setText(reminder.getReminder());
        ImageIcon photo = null;
        if(filePhoto.isEmpty())
            photo = new ImageIcon(getClass().getResource("/profileDefaultImage.png"));
        else
            photo = new ImageIcon(filePhoto);
        profilePhoto.setIcon(new ImageIcon(photo.getImage().getScaledInstance(160, 191, 0)));
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new MainFrame("Nutruci\363n")).setVisible(true);
            }

        });
    }

    public String rute;
    public String rutePdf;
    UserList userList;
    Message message;
    RegistryFrame registryFrame;
    ProfileFrame profileFrame;
    private JButton addBtn;
    private JLabel anotationLbl;
    private JTextArea anottationTxtArea;
    private JLabel eMailLbl;
    private JLabel edadLbl;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel nameLbl;
    private JLabel phoneLbl;
    private JLabel profilePhoto;
    private JButton selecBtn;
    private JList userLst;



}
