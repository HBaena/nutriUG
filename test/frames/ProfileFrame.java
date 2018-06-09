// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProfileFrame.java

package frames;

import classes.ConfFiles;
import classes.Date;
import classes.FileAppo;
import classes.FileReminder;
import classes.Message;
import classes.PDFGenerator;
import classes.SendEMail;
import classes.User;
import classes.usrclasses.AnthropometricData;
import classes.usrclasses.Diet;
import classes.usrclasses.HereditaryRecord;
import classes.usrclasses.MedicalRecord;
import classes.usrclasses.PersonalData;
import classes.usrclasses.PersonalHabits;
import classes.usrclasses.PhysicalActivity;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// Referenced classes of package frames:
//            Window, AppoFrame, MainFrame

public class ProfileFrame extends Window
    implements ActionListener
{

    public ProfileFrame(User user, int index, MainFrame main)
    {
        super(user.getPersonalData().getName());
        flag = true;
        rute = (new StringBuilder()).append(main.rute).append(".USERDATA/").toString();
        this.user = user;
        this.index = index;
        this.main = main;
        initComponents();
        init();
        buttonGroup1.add(sexFem);
        buttonGroup1.add(sexMale);
        initRegistry();
        addAppoBtn.addActionListener(this);
        super.setDefaultCloseOperation(0);
        super.setLocationRelativeTo(null);
        pdfBtn.removeActionListener(main);
        saveChangesBtn.addActionListener(this);
        File file = new File((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append("/REMINDER.txt").toString());
        if(!file.exists())
            saveReminder();
    }

    private void initRegistry()
    {
        nameTxt.setText(user.getPersonalData().getName());
        phone0Txt.setText(user.getPersonalData().getPhone());
        yearsTxt.setText(user.getPersonalData().getNUA());
        eMailTxt.setText(user.getPersonalData().geteMail());
        adressTxt.setText(user.getPersonalData().getAdress());
        if(user.getPersonalData().getGenere() == 'f')
            sexFem.setSelected(true);
        else
            sexMale.setSelected(true);
        actualAilmentTxt.setText(user.getMedicalRecord().getActualAilment());
        actualTreatmentTxt.setText(user.getMedicalRecord().getActualTreatment());
        surgeriesTxt.setText(user.getMedicalRecord().getSurgeries());
        complementsTxt.setText(user.getMedicalRecord().getComplemments());
        actvPhysTxt.setText(user.getPhysicalActivity().getWhich());
        actvPhysDurationTxt.setText((new StringBuilder()).append(user.getPhysicalActivity().getDuration()).append("").toString());
        actvPhysBox.setSelectedItem(user.getPhysicalActivity().getFrequency());
        weigthTxt.setText((new StringBuilder()).append(user.getAnthropometricData().getWeight()).append("").toString());
        heightTxt.setText((new StringBuilder()).append(user.getAnthropometricData().getHeight()).append("").toString());
        waistSizeTxt.setText((new StringBuilder()).append(user.getAnthropometricData().getWaistLine()).append("").toString());
        hipSizeTxt.setText((new StringBuilder()).append(user.getAnthropometricData().getHipLine()).append("").toString());
        dxTxt.setText(user.getAnthropometricData().getDX());
        riskTxt.setText(user.getAnthropometricData().getRisk());
        boolean record[] = user.getHereditaryRecord().getRecord();
        boolean symptoms[] = user.getHereditaryRecord().getSymptoms();
        sobrepeso_checkbox.setState(record[0]);
        obesidad_checkbox.setState(record[1]);
        cancer_checkbox.setState(record[2]);
        diabetes_checkbox.setState(record[3]);
        alcoholismo_checkbox.setState(record[4]);
        hiper_checkbox.setState(record[5]);
        cardiopatia_checkbox.setState(record[6]);
        dislipidemias_checkbox.setState(record[7]);
        enfhepaticas_checkbox.setState(record[8]);
        enfrespiratorias_checkbox.setState(record[9]);
        enfrenales_checkbox.setState(record[10]);
        otro_checkbox.setState(record[11]);
        nauseas_checkbox.setState(symptoms[0]);
        vomito_checkbox.setState(symptoms[1]);
        diarrea_checkbox.setState(symptoms[2]);
        profmasticacion_checkbox.setState(symptoms[3]);
        glucion_checkbox.setState(symptoms[4]);
        estomacal_checkbox.setState(symptoms[5]);
        cansancio_checkbox.setState(symptoms[6]);
        estreF1imiento_checkbox.setState(symptoms[7]);
        gastritis_checkbox.setState(symptoms[8]);
        mareos_checkbox.setState(symptoms[9]);
        alteracion_checkbox.setState(symptoms[10]);
        indigestion_checkbox.setState(symptoms[11]);
        eatCountBox.setSelectedItem(Integer.valueOf(user.getPersonalHabits().getCountEat()));
        colationsBox.setSelectedItem(Integer.valueOf(user.getPersonalHabits().getCounCol()));
        habitsYesNoBox01.setSelectedItem(user.getPersonalHabits().getYes_no()[0]);
        habitsYesNoBox02.setSelectedItem(user.getPersonalHabits().getYes_no()[1]);
        habitsYesNoBox03.setSelectedItem(user.getPersonalHabits().getYes_no()[2]);
        hungryHourTxt.setText(user.getPersonalHabits().getHungryHour());
        palceEatTxt.setText(user.getPersonalHabits().getPlaceFoods());
        whoFoodsTxt.setText(user.getPersonalHabits().getWhoFoods());
        watterTxt.setText((new StringBuilder()).append(user.getPersonalHabits().getWater()).append("").toString());
        drinkFrequentyBox.setSelectedItem(user.getPersonalHabits().getDrinkFrequenty());
        smokeFreqTxt.setSelectedItem(user.getPersonalHabits().getSmokeFrequenty());
        String type[] = user.getDiet().getTypes();
        String perDay[] = user.getDiet().getPerDay();
        String perWeek[] = user.getDiet().getPerWeek();
        String perMonth[] = user.getDiet().getPerMonth();
        yogurthType.setText(type[0]);
        yogurthDay.setText(perDay[0]);
        yogurthWeek.setText(perWeek[0]);
        yogurthMonth.setText(perMonth[0]);
        frutaType.setText(type[1]);
        frutaDay.setText(perDay[1]);
        frutaWeek.setText(perWeek[1]);
        frutaMonth.setText(perMonth[1]);
        verduraType.setText(type[2]);
        verduraDay.setText(perDay[2]);
        verduraWeek.setText(perWeek[2]);
        verduraMonth.setText(perMonth[2]);
        tortillaType.setText(type[3]);
        tortillaDay.setText(perDay[3]);
        tortillaWeek.setText(perWeek[3]);
        tortillaMonth.setText(perMonth[3]);
        panType.setText(type[4]);
        panDay.setText(perDay[4]);
        panWeek.setText(perWeek[4]);
        panMonth.setText(perMonth[4]);
        pastasType.setText(type[5]);
        pastasDay.setText(perDay[5]);
        pastasWeek.setText(perWeek[5]);
        pastasMonth.setText(perMonth[5]);
        arrozType.setText(type[6]);
        arrozDay.setText(perDay[6]);
        arrozWeek.setText(perWeek[6]);
        arrozMonth.setText(perMonth[6]);
        cerealType.setText(type[7]);
        cerealDay.setText(perDay[7]);
        cerealWeek.setText(perWeek[7]);
        cerealMonth.setText(perMonth[7]);
        carnesType.setText(type[8]);
        carnesDay.setText(perDay[8]);
        carnesWeek.setText(perWeek[8]);
        carnesMonth.setText(perMonth[8]);
        polloType.setText(type[9]);
        polloDay.setText(perDay[9]);
        polloWeek.setText(perWeek[9]);
        polloMonth.setText(perMonth[9]);
        huevosType.setText(type[10]);
        huevosDay.setText(perDay[10]);
        huevosWeek.setText(perWeek[10]);
        huevosMonth.setText(perMonth[10]);
        pescadoType.setText(type[11]);
        pescadoDay.setText(perDay[11]);
        pescadoWeek.setText(perWeek[11]);
        pescadoMonth.setText(perMonth[11]);
        jamonType.setText(type[12]);
        jamonDay.setText(perDay[12]);
        jamonWeek.setText(perWeek[12]);
        jamonMonth.setText(perMonth[12]);
        salchichaType.setText(type[13]);
        salchichaDay.setText(perDay[13]);
        salchichaWeek.setText(perWeek[13]);
        salchichaMonth.setText(perMonth[13]);
        quesoType.setText(type[14]);
        quesoDay.setText(perDay[14]);
        quesoWeek.setText(perWeek[14]);
        quesoMonth.setText(perMonth[14]);
        azucarType.setText(type[15]);
        azucarDay.setText(perDay[15]);
        azucarWeek.setText(perWeek[15]);
        azucarMonth.setText(perMonth[15]);
        grasasType.setText(type[16]);
        grasasDay.setText(perDay[16]);
        grasasWeek.setText(perWeek[16]);
        grasasMonth.setText(perMonth[16]);
        dulcesType.setText(type[17]);
        dulcesDay.setText(perDay[17]);
        dulcesWeek.setText(perWeek[17]);
        dulcesMonth.setText(perMonth[17]);
        papasType.setText(type[18]);
        papasDay.setText(perDay[18]);
        papasWeek.setText(perWeek[18]);
        papasMonth.setText(perMonth[18]);
        comidaType.setText(type[19]);
        comidaDay.setText(perDay[19]);
        comidaWeek.setText(perWeek[19]);
        comidaMonth.setText(perMonth[19]);
        refrescosType.setText(type[20]);
        refrescosDay.setText(perDay[20]);
        refrescosWeek.setText(perWeek[20]);
        refrescosMonth.setText(perMonth[20]);
        otrosType.setText(type[21]);
        otrosDay.setText(perDay[21]);
        otrosWeek.setText(perWeek[21]);
        otrosMonth.setText(perMonth[21]);
    }

    private void init()
    {
        filePhoto = "";
        profilePane.setTitleAt(0, user.getPersonalData().getName());
        reminder = new FileReminder((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).toString());
        remTxtArea.setText(reminder.getReminder());
        nameLbl.setText(user.getPersonalData().getName());
        yearsLbl.setText(user.getPersonalData().getNUA());
        imcLbl.setText((new StringBuilder()).append(user.getAnthropometricData().getBMI()).append("").toString());
        mailLbl.setText(user.getPersonalData().geteMail());
        phoneLbl.setText(user.getPersonalData().getPhone());
        exitBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        filePhoto = reminder.PHOTO;
        String tmp = reminder.APPOI;
        Message m = new Message();
        m.setMassage(tmp);
        if(!tmp.isEmpty())
            appoiments = Integer.parseInt(tmp);
        else
            appoiments = 0;
        ImageIcon photo = null;
        m.setMassage(filePhoto);
        if(filePhoto.isEmpty())
            photo = new ImageIcon(getClass().getResource("/profileDefaultImage.png"));
        else
            photo = new ImageIcon(filePhoto);
        photoLbl.setIcon(new ImageIcon(photo.getImage().getScaledInstance(340, 307, 0)));
        super.m.setMassage("Vas a abandonar el perfil, \277Est\341s seguro?");
        refreshLst();
    }

    public void setVisible(boolean state)
    {
        init();
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == exitBtn)
        {
            main.refresh();
            ownClose();
        } else
        if(event.getSource() == addAppoBtn)
        {
            AppoFrame frame = new AppoFrame(this, user.getAnthropometricData().getHeight(), (new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append('/').toString());
            frame.setVisible(true);
            frame.setAlwaysOnTop(true);
            super.setEnabled(false);
        } else
        if(event.getSource() == deleteBtn)
        {
            Object options[] = {
                "S\355", "No"
            };
            if(flag && JOptionPane.showOptionDialog(null, (new StringBuilder()).append("\277Est\341s realmente segura de que quiere eliminar a ").append(user.getPersonalData().getName()).append("?").toString(), "Eliminar cliente", -1, 3, null, options, ((Object) (options))) == 0)
            {
                flag = false;
                super.setVisible(false);
                super.setEnabled(false);
                File file = new File((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).toString());
                funcionEliminarCarpeta1(file);
                main.deletItem((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).toString(), index);
            }
        } else
        if(event.getSource() == saveChangesBtn && verify())
            editUser();
    }

    public void ownClose()
    {
        saveReminder();
        super.setVisible(false);
        main.setVisible(true);
    }

    private static void funcionEliminarCarpeta1(File pArchivo)
    {
        if(!pArchivo.exists())
            return;
        if(pArchivo.isDirectory())
        {
            File afile[] = pArchivo.listFiles();
            int i = afile.length;
            for(int j = 0; j < i; j++)
            {
                File f = afile[j];
                funcionEliminarCarpeta1(f);
            }

        }
        pArchivo.delete();
    }

    public void refreshLst()
    {
        String listAppoiments[] = new String[appoiments];
        for(int i = 0; i < listAppoiments.length; i++)
            listAppoiments[i] = (new StringBuilder()).append("Sesi\363n ").append(i + 1).toString();

        appoLst.setListData(listAppoiments);
    }

    public void refreshLst(float IMC, float w, float waist, float hip)
    {
        user.getAnthropometricData().setBMI(IMC);
        user.getAnthropometricData().setWeight(w);
        user.getAnthropometricData().setWaistLine(waist);
        user.getAnthropometricData().setHipLine(hip);
        main.editItem(index, user);
        imcLbl.setText((new StringBuilder()).append(IMC).append("").toString());
        refreshLst();
    }

    public void saveReminder()
    {
        reminder.PHOTO = filePhoto;
        reminder.APPOI = (new StringBuilder()).append(appoiments).append("").toString();
        reminder.saveReminder(remTxtArea.getText().toString());
    }

    private boolean verify()
    {
        Message message = new Message();
        boolean aux = true;
        if(nameTxt.getText().isEmpty() || yearsTxt.getText().isEmpty() || eMailTxt.getText().isEmpty() || phone0Txt.getText().isEmpty() || weigthTxt.getText().isEmpty() || waistSizeTxt.getText().isEmpty() || hipSizeTxt.getText().isEmpty() || heightTxt.getText().isEmpty() || actvPhysTxt.getText().isEmpty() || actvPhysDurationTxt.getText().isEmpty() || hungryHourTxt.getText().isEmpty() || palceEatTxt.getText().isEmpty() || whoFoodsTxt.getText().isEmpty() || watterTxt.getText().isEmpty())
        {
            message.showMessage();
            return false;
        }
        try
        {
            Float.parseFloat(weigthTxt.getText().toString());
            Float.parseFloat(heightTxt.getText().toString());
            Float.parseFloat(waistSizeTxt.getText().toString());
            Float.parseFloat(hipSizeTxt.getText().toString());
            Float.parseFloat(actvPhysDurationTxt.getText().toString());
            Float.parseFloat(watterTxt.getText().toString());
        }
        catch(Exception e)
        {
            message.showMessage(new Object[] {
                "Ok"
            }, "Datos incompatibles", "El peso, estatura y cintura deben ser datos num\351ricos.");
            return false;
        }
        return true;
    }

    private void editUser()
    {
        char gen = sexFem.isSelected() ? 'f' : 'm';
        user.setPersonalData(new PersonalData(nameTxt.getText(), yearsTxt.getText(), eMailTxt.getText(), gen, phone0Txt.getText(), adressTxt.getText()));
        float weigth = Float.parseFloat(weigthTxt.getText().toString());
        float height = Float.parseFloat(heightTxt.getText().toString()) / 100F;
        user.setAnthropometricData(new AnthropometricData(weigth, height * 100F, Float.parseFloat(waistSizeTxt.getText().toString()), Float.parseFloat(hipSizeTxt.getText().toString()), weigth / (height * height), riskTxt.getText().toString(), dxTxt.getText().toString()));
        user.setMedicalRecord(new MedicalRecord(actualAilmentTxt.getText(), actualTreatmentTxt.getText(), surgeriesTxt.getText(), complementsTxt.getText()));
        user.setPhysicalActivity(new PhysicalActivity(actvPhysBox.getSelectedItem().toString(), actvPhysTxt.getText().toString(), (int)Float.parseFloat(actvPhysDurationTxt.getText().toString()), atcvPhysFrequenBox.getSelectedItem().toString()));
        boolean record[] = new boolean[12];
        boolean symptoms[] = new boolean[12];
        record[0] = sobrepeso_checkbox.getState();
        record[1] = obesidad_checkbox.getState();
        record[2] = cancer_checkbox.getState();
        record[3] = diabetes_checkbox.getState();
        record[4] = alcoholismo_checkbox.getState();
        record[5] = hiper_checkbox.getState();
        record[6] = cardiopatia_checkbox.getState();
        record[7] = dislipidemias_checkbox.getState();
        record[8] = enfhepaticas_checkbox.getState();
        record[9] = enfrespiratorias_checkbox.getState();
        record[10] = enfrenales_checkbox.getState();
        record[11] = otro_checkbox.getState();
        symptoms[0] = nauseas_checkbox.getState();
        symptoms[1] = vomito_checkbox.getState();
        symptoms[2] = diarrea_checkbox.getState();
        symptoms[3] = profmasticacion_checkbox.getState();
        symptoms[4] = glucion_checkbox.getState();
        symptoms[5] = estomacal_checkbox.getState();
        symptoms[6] = cansancio_checkbox.getState();
        symptoms[7] = estreF1imiento_checkbox.getState();
        symptoms[8] = gastritis_checkbox.getState();
        symptoms[9] = mareos_checkbox.getState();
        symptoms[10] = alteracion_checkbox.getState();
        symptoms[11] = indigestion_checkbox.getState();
        user.setHereditaryRecord(new HereditaryRecord(record, symptoms));
        user.setPersonalHabits(new PersonalHabits(Integer.parseInt(eatCountBox.getSelectedItem().toString()), Integer.parseInt(colationsBox.getSelectedItem().toString()), new String[] {
            habitsYesNoBox01.getSelectedItem().toString(), habitsYesNoBox01.getSelectedItem().toString(), habitsYesNoBox01.getSelectedItem().toString()
        }, drinkFrequentyBox.getSelectedItem().toString(), smokeFreqTxt.getSelectedItem().toString(), hungryHourTxt.getText().toString(), palceEatTxt.getText().toString(), whoFoodsTxt.getText().toString(), Integer.parseInt(watterTxt.getText().toString())));
        String type[] = new String[22];
        String perDay[] = new String[22];
        String perWeek[] = new String[22];
        String perMonth[] = new String[22];
        type[0] = yogurthType.getText();
        perDay[0] = yogurthDay.getText();
        perWeek[0] = yogurthWeek.getText();
        perMonth[0] = yogurthMonth.getText();
        type[1] = frutaType.getText();
        perDay[1] = frutaDay.getText();
        perWeek[1] = frutaWeek.getText();
        perMonth[1] = frutaMonth.getText();
        type[2] = verduraType.getText();
        perDay[2] = verduraDay.getText();
        perWeek[2] = verduraWeek.getText();
        perMonth[2] = verduraMonth.getText();
        type[3] = tortillaType.getText();
        perDay[3] = tortillaDay.getText();
        perWeek[3] = tortillaWeek.getText();
        perMonth[3] = tortillaMonth.getText();
        type[4] = panType.getText();
        perDay[4] = panDay.getText();
        perWeek[4] = panWeek.getText();
        perMonth[4] = panMonth.getText();
        type[5] = pastasType.getText();
        perDay[5] = pastasDay.getText();
        perWeek[5] = pastasWeek.getText();
        perMonth[5] = pastasMonth.getText();
        type[6] = arrozType.getText();
        perDay[6] = arrozDay.getText();
        perWeek[6] = arrozWeek.getText();
        perMonth[6] = arrozMonth.getText();
        type[7] = cerealType.getText();
        perDay[7] = cerealDay.getText();
        perWeek[7] = cerealWeek.getText();
        perMonth[7] = cerealMonth.getText();
        type[8] = carnesType.getText();
        perDay[8] = carnesDay.getText();
        perWeek[8] = carnesWeek.getText();
        perMonth[8] = carnesMonth.getText();
        type[9] = polloType.getText();
        perDay[9] = polloDay.getText();
        perWeek[9] = polloWeek.getText();
        perMonth[9] = polloMonth.getText();
        type[10] = huevosType.getText();
        perDay[10] = huevosDay.getText();
        perWeek[10] = huevosWeek.getText();
        perMonth[10] = huevosMonth.getText();
        type[11] = pescadoType.getText();
        perDay[11] = pescadoDay.getText();
        perWeek[11] = pescadoWeek.getText();
        perMonth[11] = pescadoMonth.getText();
        type[12] = jamonType.getText();
        perDay[12] = jamonDay.getText();
        perWeek[12] = jamonWeek.getText();
        perMonth[12] = jamonMonth.getText();
        type[13] = salchichaType.getText();
        perDay[13] = salchichaDay.getText();
        perWeek[13] = salchichaWeek.getText();
        perMonth[13] = salchichaMonth.getText();
        type[14] = quesoType.getText();
        perDay[14] = quesoDay.getText();
        perWeek[14] = quesoWeek.getText();
        perMonth[14] = quesoMonth.getText();
        type[15] = azucarType.getText();
        perDay[15] = azucarDay.getText();
        perWeek[15] = azucarWeek.getText();
        perMonth[15] = azucarMonth.getText();
        type[16] = grasasType.getText();
        perDay[16] = grasasDay.getText();
        perWeek[16] = grasasWeek.getText();
        perMonth[16] = grasasMonth.getText();
        type[17] = dulcesType.getText();
        perDay[17] = dulcesDay.getText();
        perWeek[17] = dulcesWeek.getText();
        perMonth[17] = dulcesMonth.getText();
        type[18] = papasType.getText();
        perDay[18] = papasDay.getText();
        perWeek[18] = papasWeek.getText();
        perMonth[18] = papasMonth.getText();
        type[19] = comidaType.getText();
        perDay[19] = comidaDay.getText();
        perWeek[19] = comidaWeek.getText();
        perMonth[19] = comidaMonth.getText();
        type[20] = refrescosType.getText();
        perDay[20] = refrescosDay.getText();
        perWeek[20] = refrescosWeek.getText();
        perMonth[20] = refrescosMonth.getText();
        type[21] = otrosType.getText();
        perDay[21] = otrosDay.getText();
        perWeek[21] = otrosWeek.getText();
        perMonth[21] = otrosMonth.getText();
        user.setDiet(new Diet(type, perDay, perWeek, perMonth));
        main.editItem(index, user);
    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        profilePane = new JTabbedPane();
        jPanel8 = new JPanel();
        nameLbl = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jScrollPane1 = new JScrollPane();
        remTxtArea = new JTextArea();
        mailLbl = new JLabel();
        yearsLbl = new JLabel();
        phoneLbl = new JLabel();
        imcLbl = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        exitBtn = new JButton();
        deleteBtn = new JButton();
        photoLbl = new JLabel();
        jButton1 = new JButton();
        jPanel10 = new JPanel();
        jScrollPane2 = new JScrollPane();
        appoLst = new JList();
        jLabel14 = new JLabel();
        addAppoBtn = new JButton();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jScrollPane9 = new JScrollPane();
        anotAppoTxtArea = new JTextArea();
        sesionLbl = new JLabel();
        pdfBtn = new JButton();
        jTabbedPane2 = new JTabbedPane();
        jPanel2 = new JPanel();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        nameTxt = new TextField();
        yearsTxt = new TextField();
        eMailTxt = new TextField();
        label5 = new Label();
        phone0Txt = new TextField();
        sexFem = new JRadioButton();
        sexMale = new JRadioButton();
        label6 = new Label();
        adressTxt = new TextField();
        saveChangesBtn = new JButton();
        jLabel5 = new JLabel();
        jLabel8 = new JLabel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jScrollPane5 = new JScrollPane();
        actualTreatmentTxt = new JTextArea();
        jScrollPane6 = new JScrollPane();
        actualAilmentTxt = new JTextArea();
        jScrollPane7 = new JScrollPane();
        complementsTxt = new JTextArea();
        jScrollPane8 = new JScrollPane();
        surgeriesTxt = new JTextArea();
        label_fisica = new JLabel();
        fisica = new JLabel();
        actvPhysBox = new JComboBox();
        atcvPhysFrequenBox = new JComboBox();
        cual_fisica = new JLabel();
        jScrollPane12 = new JScrollPane();
        actvPhysTxt = new JTextPane();
        duracion = new JLabel();
        actvPhysDurationTxt = new JTextField();
        jPanel4 = new JPanel();
        label11 = new Label();
        label12 = new Label();
        heightTxt = new TextField();
        waistSizeTxt = new TextField();
        label13 = new Label();
        weigthTxt = new TextField();
        hipSizeTxt = new TextField();
        label14 = new Label();
        label15 = new Label();
        riskTxt = new TextField();
        dxTxt = new TextField();
        label16 = new Label();
        label17 = new Label();
        label18 = new Label();
        label19 = new Label();
        label20 = new Label();
        jPanel5 = new JPanel();
        sobrepeso_checkbox = new Checkbox();
        obesidad_checkbox = new Checkbox();
        cancer_checkbox = new Checkbox();
        diabetes_checkbox = new Checkbox();
        alcoholismo_checkbox = new Checkbox();
        hiper_checkbox = new Checkbox();
        cardiopatia_checkbox = new Checkbox();
        dislipidemias_checkbox = new Checkbox();
        enfhepaticas_checkbox = new Checkbox();
        enfrespiratorias_checkbox = new Checkbox();
        enfrenales_checkbox = new Checkbox();
        otro_checkbox = new Checkbox();
        label7 = new Label();
        nauseas_checkbox = new Checkbox();
        diarrea_checkbox = new Checkbox();
        cansancio_checkbox = new Checkbox();
        vomito_checkbox = new Checkbox();
        profmasticacion_checkbox = new Checkbox();
        glucion_checkbox = new Checkbox();
        estomacal_checkbox = new Checkbox();
        estreF1imiento_checkbox = new Checkbox();
        gastritis_checkbox = new Checkbox();
        mareos_checkbox = new Checkbox();
        alteracion_checkbox = new Checkbox();
        indigestion_checkbox = new Checkbox();
        jPanel6 = new JPanel();
        habitsYesNoBox03 = new JComboBox();
        label_saltar = new JLabel();
        habitsYesNoBox01 = new JComboBox();
        horarios_comida = new JLabel();
        colaciones = new JLabel();
        colationsBox = new JComboBox();
        comes = new JLabel();
        eatCountBox = new JComboBox();
        entre_comidas = new JLabel();
        habitsYesNoBox02 = new JComboBox();
        jScrollPane15 = new JScrollPane();
        hungryHourTxt = new JTextPane();
        hambre = new JLabel();
        lugar_comer = new JLabel();
        prepara = new JLabel();
        jScrollPane16 = new JScrollPane();
        palceEatTxt = new JTextPane();
        jScrollPane3 = new JScrollPane();
        whoFoodsTxt = new JTextPane();
        jScrollPane4 = new JScrollPane();
        watterTxt = new JTextPane();
        agua = new JLabel();
        frecuencia_fumas = new JLabel();
        frecuencia = new JLabel();
        drinkFrequentyBox = new JComboBox();
        smokeFreqTxt = new JComboBox();
        label_saltar1 = new JLabel();
        jTabbedPane3 = new JTabbedPane();
        jPanel7 = new JPanel();
        label31 = new Label();
        label32 = new Label();
        Yogurth_Label12 = new JLabel();
        yogurthType = new JTextField();
        Yogurth_Label13 = new JLabel();
        frutaType = new JTextField();
        Yogurth_Label14 = new JLabel();
        verduraType = new JTextField();
        tortillaType = new JTextField();
        Yogurth_Label15 = new JLabel();
        Yogurth_Label16 = new JLabel();
        Yogurth_Label17 = new JLabel();
        panType = new JTextField();
        pastasType = new JTextField();
        arrozType = new JTextField();
        cerealType = new JTextField();
        huevosType = new JTextField();
        polloType = new JTextField();
        carnesType = new JTextField();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        label33 = new Label();
        label34 = new Label();
        yogurthDay = new JTextField();
        frutaDay = new JTextField();
        verduraDay = new JTextField();
        pastasDay = new JTextField();
        panDay = new JTextField();
        tortillaDay = new JTextField();
        carnesDay = new JTextField();
        cerealDay = new JTextField();
        arrozDay = new JTextField();
        polloDay = new JTextField();
        huevosDay = new JTextField();
        frutaWeek = new JTextField();
        verduraWeek = new JTextField();
        tortillaWeek = new JTextField();
        panWeek = new JTextField();
        pastasWeek = new JTextField();
        arrozWeek = new JTextField();
        cerealWeek = new JTextField();
        carnesWeek = new JTextField();
        polloWeek = new JTextField();
        huevosWeek = new JTextField();
        panMonth = new JTextField();
        huevosMonth = new JTextField();
        frutaMonth = new JTextField();
        pastasMonth = new JTextField();
        polloMonth = new JTextField();
        arrozMonth = new JTextField();
        carnesMonth = new JTextField();
        cerealMonth = new JTextField();
        tortillaMonth = new JTextField();
        verduraMonth = new JTextField();
        label35 = new Label();
        yogurthWeek = new JTextField();
        yogurthMonth = new JTextField();
        jPanel9 = new JPanel();
        label36 = new Label();
        label37 = new Label();
        Yogurth_Label18 = new JLabel();
        pescadoType = new JTextField();
        Yogurth_Label19 = new JLabel();
        jamonType = new JTextField();
        Yogurth_Label20 = new JLabel();
        salchichaType = new JTextField();
        quesoType = new JTextField();
        Yogurth_Label21 = new JLabel();
        Yogurth_Label22 = new JLabel();
        Yogurth_Label23 = new JLabel();
        azucarType = new JTextField();
        grasasType = new JTextField();
        dulcesType = new JTextField();
        papasType = new JTextField();
        otrosType = new JTextField();
        refrescosType = new JTextField();
        comidaType = new JTextField();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        label38 = new Label();
        label39 = new Label();
        pescadoDay = new JTextField();
        jamonDay = new JTextField();
        salchichaDay = new JTextField();
        grasasDay = new JTextField();
        azucarDay = new JTextField();
        quesoDay = new JTextField();
        comidaDay = new JTextField();
        papasDay = new JTextField();
        dulcesDay = new JTextField();
        refrescosDay = new JTextField();
        otrosDay = new JTextField();
        pescadoWeek = new JTextField();
        jamonWeek = new JTextField();
        salchichaWeek = new JTextField();
        quesoWeek = new JTextField();
        azucarWeek = new JTextField();
        grasasWeek = new JTextField();
        dulcesWeek = new JTextField();
        comidaWeek = new JTextField();
        refrescosWeek = new JTextField();
        otrosWeek = new JTextField();
        azucarMonth = new JTextField();
        otrosMonth = new JTextField();
        pescadoMonth = new JTextField();
        grasasMonth = new JTextField();
        refrescosMonth = new JTextField();
        dulcesMonth = new JTextField();
        comidaMonth = new JTextField();
        papasMonth = new JTextField();
        quesoMonth = new JTextField();
        jamonMonth = new JTextField();
        label40 = new Label();
        salchichaMonth = new JTextField();
        papasWeek = new JTextField();
        setDefaultCloseOperation(3);
        nameLbl.setFont(new Font("Dialog", 1, 28));
        nameLbl.setForeground(new Color(1, 1, 1));
        nameLbl.setHorizontalAlignment(0);
        nameLbl.setText("Nombre");
        jLabel6.setFont(new Font("Dialog", 1, 24));
        jLabel6.setForeground(new Color(1, 1, 1));
        jLabel6.setHorizontalAlignment(4);
        jLabel6.setText("Correo");
        jLabel7.setFont(new Font("Dialog", 1, 24));
        jLabel7.setForeground(new Color(1, 1, 1));
        jLabel7.setHorizontalAlignment(4);
        jLabel7.setText("Edad");
        jLabel9.setFont(new Font("Dialog", 1, 24));
        jLabel9.setForeground(new Color(1, 1, 1));
        jLabel9.setHorizontalAlignment(4);
        jLabel9.setText("Tel\351fono");
        jLabel10.setFont(new Font("Dialog", 1, 24));
        jLabel10.setForeground(new Color(1, 1, 1));
        jLabel10.setHorizontalAlignment(4);
        jLabel10.setText("IMC");
        jLabel11.setFont(new Font("Dialog", 1, 24));
        jLabel11.setForeground(new Color(1, 1, 1));
        jLabel11.setHorizontalAlignment(0);
        jLabel11.setText("Anotaci\363n");
        remTxtArea.setColumns(20);
        remTxtArea.setRows(5);
        jScrollPane1.setViewportView(remTxtArea);
        mailLbl.setFont(new Font("Dialog", 2, 24));
        mailLbl.setHorizontalAlignment(2);
        yearsLbl.setFont(new Font("Dialog", 2, 24));
        yearsLbl.setHorizontalAlignment(2);
        phoneLbl.setFont(new Font("Dialog", 2, 24));
        phoneLbl.setHorizontalAlignment(2);
        imcLbl.setFont(new Font("Dialog", 2, 24));
        imcLbl.setHorizontalAlignment(2);
        exitBtn.setFont(new Font("Dialog", 1, 20));
        exitBtn.setForeground(new Color(1, 1, 1));
        exitBtn.setText("Atr\341s");
        deleteBtn.setFont(new Font("Dialog", 1, 20));
        deleteBtn.setForeground(new Color(1, 1, 1));
        deleteBtn.setText("Borrar");
        photoLbl.setHorizontalAlignment(0);
        jButton1.setText("Cambiar foto");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel12, -2, 200, -2).addGap(18, 18, 18).addComponent(exitBtn, -2, 200, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, 32767).addComponent(deleteBtn, -2, 200, -2).addGap(18, 18, 18).addComponent(jLabel13, -2, 200, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(nameLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6, -2, 200, -2).addComponent(jLabel7, -2, 200, -2).addComponent(jLabel9, -2, 200, -2).addComponent(jLabel10, -2, 200, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(phoneLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, 370, 32767).addComponent(yearsLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(mailLbl, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(imcLbl, -1, -1, 32767)))).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jButton1, -1, -1, 32767).addComponent(photoLbl, -2, 312, -2)))).addContainerGap()));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel8Layout.createSequentialGroup().addComponent(nameLbl, -2, 70, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6, -2, 30, -2).addComponent(mailLbl, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7, -2, 30, -2).addComponent(yearsLbl, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9, -2, 30, -2).addComponent(phoneLbl, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10, -2, 30, -2).addComponent(imcLbl, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel11, -2, 30, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, -2, 170, -2)).addGroup(jPanel8Layout.createSequentialGroup().addComponent(photoLbl, -2, 350, -2).addGap(18, 18, 18).addComponent(jButton1, -1, -1, 32767))).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel12, -1, -1, 32767).addComponent(jLabel13, -1, 57, 32767)).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(exitBtn).addComponent(deleteBtn)).addGap(0, 0, 32767))).addContainerGap()));
        profilePane.addTab("Perfil", jPanel8);
        appoLst.setModel(new AbstractListModel() {

            public int getSize()
            {
                return strings.length;
            }

            public String getElementAt(int i)
            {
                return strings[i];
            }
            String strings[] = {
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
            };
            
        });
        appoLst.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt)
            {
                appoLstMouseClicked(evt);
            }
        });
        appoLst.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent evt)
            {
                appoLstValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(appoLst);
        jLabel14.setFont(new Font("Dialog", 1, 24));
        jLabel14.setHorizontalAlignment(0);
        jLabel14.setText("Citas");
        addAppoBtn.setFont(new Font("Ubuntu", 0, 16));
        addAppoBtn.setText("Agregar");
        anotAppoTxtArea.setEditable(false);
        anotAppoTxtArea.setColumns(20);
        anotAppoTxtArea.setFont(new Font("Dialog", 1, 20));
        anotAppoTxtArea.setRows(5);
        jScrollPane9.setViewportView(anotAppoTxtArea);
        sesionLbl.setFont(new Font("Dialog", 1, 24));
        sesionLbl.setHorizontalAlignment(0);
        sesionLbl.setText("Sesi\363n");
        pdfBtn.setText("Generar PDF");
        pdfBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                pdfBtnActionPerformed(evt);
            }
        });
        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel14, -2, 300, -2).addComponent(jScrollPane2, -2, 300, -2).addGroup(jPanel10Layout.createSequentialGroup().addComponent(jLabel15, -2, 70, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(addAppoBtn, -2, 127, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jLabel16, -2, 70, -2))).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane9, -1, 618, 32767).addComponent(sesionLbl, -1, -1, 32767)).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(pdfBtn, -2, 205, -2).addGap(215, 215, 215)))));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(pdfBtn).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14, -2, 30, -2).addComponent(sesionLbl, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane2, -1, 382, 32767).addComponent(jScrollPane9)).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel15).addComponent(jLabel16))).addGroup(jPanel10Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(addAppoBtn))))).addContainerGap(55, 32767)));
        profilePane.addTab("Citas", jPanel10);
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(profilePane).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(profilePane).addContainerGap()));
        jTabbedPane1.addTab("Perfil", jPanel1);
        jTabbedPane2.setFont(new Font("Dialog", 1, 16));
        label1.setAlignment(2);
        label1.setFont(new Font("Dialog", 1, 16));
        label1.setText("Nombre");
        label2.setAlignment(2);
        label2.setFont(new Font("Dialog", 1, 16));
        label2.setText("Edad");
        label3.setAlignment(2);
        label3.setFont(new Font("Dialog", 1, 16));
        label3.setText("Correo");
        label4.setAlignment(2);
        label4.setFont(new Font("Dialog", 1, 16));
        label4.setText("G\351nero");
        nameTxt.setFont(new Font("Dialog", 0, 16));
        yearsTxt.setFont(new Font("Dialog", 0, 16));
        eMailTxt.setFont(new Font("Dialog", 0, 16));
        label5.setAlignment(2);
        label5.setFont(new Font("Dialog", 1, 16));
        label5.setText("Tel\351fono 1");
        phone0Txt.setFont(new Font("Dialog", 0, 16));
        sexFem.setFont(new Font("Dialog", 0, 16));
        sexFem.setSelected(true);
        sexFem.setText("Femenino");
        sexMale.setFont(new Font("Dialog", 0, 16));
        sexMale.setText("Masculino");
        label6.setAlignment(2);
        label6.setFont(new Font("Dialog", 1, 16));
        label6.setText("Direcci\363n");
        adressTxt.setFont(new Font("Dialog", 0, 16));
        saveChangesBtn.setText("Guardar cambios");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label4, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sexFem).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(sexMale)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label1, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(nameTxt, -2, 250, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label2, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(yearsTxt, -2, 250, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label3, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(eMailTxt, -2, 250, -2))).addGap(37, 37, 37).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label5, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(phone0Txt, -2, 250, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(label6, -2, 130, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(adressTxt, -2, 250, -2))).addContainerGap(155, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel8, -2, 330, -2).addGap(18, 18, 18).addComponent(saveChangesBtn, -1, -1, 32767).addGap(18, 18, 18).addComponent(jLabel5, -2, 330, -2)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(36, 36, 36).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label1, -2, 30, -2).addComponent(nameTxt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label2, -2, 30, -2)).addComponent(yearsTxt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label3, -2, 30, -2)).addComponent(eMailTxt, -2, 30, -2).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label5, -2, 30, -2).addComponent(phone0Txt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label6, -2, 30, -2).addComponent(adressTxt, -2, 30, -2)).addGap(40, 40, 40))).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label4, -2, 30, -2).addComponent(sexMale).addComponent(sexFem)).addGap(192, 192, 192).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel8, -2, 40, -2).addComponent(saveChangesBtn)).addContainerGap(129, 32767)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jLabel5, -2, 40, -2).addGap(93, 93, 93)))));
        jTabbedPane2.addTab("Personales", jPanel2);
        jPanel3.setForeground(new Color(1, 1, 1));
        jLabel1.setFont(new Font("Dialog", 1, 16));
        jLabel1.setForeground(new Color(1, 1, 1));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("Padecimientos actuales");
        jLabel2.setFont(new Font("Dialog", 1, 16));
        jLabel2.setForeground(new Color(1, 1, 1));
        jLabel2.setHorizontalAlignment(0);
        jLabel2.setText("Tratamiento actual");
        jLabel3.setFont(new Font("Dialog", 1, 16));
        jLabel3.setForeground(new Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(0);
        jLabel3.setText("Cirug\355as");
        jLabel4.setFont(new Font("Dialog", 1, 16));
        jLabel4.setForeground(new Color(1, 1, 1));
        jLabel4.setHorizontalAlignment(0);
        jLabel4.setText("Suplementos o complementos");
        actualTreatmentTxt.setColumns(20);
        actualTreatmentTxt.setRows(5);
        jScrollPane5.setViewportView(actualTreatmentTxt);
        actualAilmentTxt.setColumns(20);
        actualAilmentTxt.setRows(5);
        jScrollPane6.setViewportView(actualAilmentTxt);
        complementsTxt.setColumns(20);
        complementsTxt.setRows(5);
        jScrollPane7.setViewportView(complementsTxt);
        surgeriesTxt.setColumns(20);
        surgeriesTxt.setRows(5);
        jScrollPane8.setViewportView(surgeriesTxt);
        label_fisica.setFont(new Font("Dialog", 1, 16));
        label_fisica.setForeground(new Color(1, 1, 1));
        label_fisica.setText("\277Con qu\351 frecuencia realizas la actividad f\355sica?");
        fisica.setFont(new Font("Dialog", 1, 16));
        fisica.setForeground(new Color(1, 1, 1));
        fisica.setText("\277Realizas alguna actividad f\355sica?");
        actvPhysBox.setFont(new Font("Dialog", 0, 16));
        actvPhysBox.setForeground(new Color(1, 1, 1));
        actvPhysBox.setModel(new DefaultComboBoxModel(new String[] {
            "Si", "No"
        }));
        atcvPhysFrequenBox.setFont(new Font("Dialog", 0, 16));
        atcvPhysFrequenBox.setForeground(new Color(1, 1, 1));
        atcvPhysFrequenBox.setModel(new DefaultComboBoxModel(new String[] {
            "una vez por semana", "dos veces por semana", "tres veces por semana", "cuatro veces por semana", "todos los dias"
        }));
        cual_fisica.setFont(new Font("Dialog", 1, 16));
        cual_fisica.setForeground(new Color(1, 1, 1));
        cual_fisica.setText("\277Cu\341l?");
        jScrollPane12.setForeground(new Color(1, 1, 1));
        actvPhysTxt.setFont(new Font("Dialog", 0, 16));
        jScrollPane12.setViewportView(actvPhysTxt);
        duracion.setFont(new Font("Dialog", 1, 16));
        duracion.setForeground(new Color(1, 1, 1));
        duracion.setText("Duraci\363n");
        actvPhysDurationTxt.setFont(new Font("Dialog", 0, 16));
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(jPanel3Layout.createSequentialGroup().addGap(60, 60, 60).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(jScrollPane8, -2, 400, -2).addGap(18, 18, 18).addComponent(jScrollPane7, -2, 400, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel3, -2, 400, -2).addGap(18, 18, 18).addComponent(jLabel4, -2, 400, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(jScrollPane6, -1, 400, 32767).addComponent(jLabel1, -1, -1, 32767)).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jLabel2, -2, 400, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jScrollPane5, -2, 400, -2)))))).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(fisica).addGap(18, 18, 18).addComponent(actvPhysBox, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cual_fisica).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(label_fisica).addGap(25, 25, 25))).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(atcvPhysFrequenBox, -2, -1, -2).addGap(224, 224, 224)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(jScrollPane12).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(duracion).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(actvPhysDurationTxt, -2, 108, -2))))).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1, -2, 30, -2).addComponent(jLabel2, -2, 30, -2)).addGap(12, 12, 12).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane6, -1, 100, 32767).addComponent(jScrollPane5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, -2, 30, -2).addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane8).addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, -2, 100, -2)).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fisica).addComponent(actvPhysBox, -2, -1, -2).addComponent(cual_fisica))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(duracion, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(actvPhysDurationTxt, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2))))).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(jScrollPane12, -2, -1, -2))).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(label_fisica).addComponent(atcvPhysFrequenBox, -2, -1, -2)).addContainerGap(-1, 32767)));
        jTabbedPane2.addTab("Antecedentes", jPanel3);
        label11.setAlignment(2);
        label11.setFont(new Font("Dialog", 1, 16));
        label11.setText("Peso");
        label12.setAlignment(2);
        label12.setFont(new Font("Dialog", 1, 16));
        label12.setText("Altura");
        heightTxt.setFont(new Font("Dialog", 0, 16));
        waistSizeTxt.setFont(new Font("Dialog", 0, 16));
        label13.setAlignment(2);
        label13.setFont(new Font("Dialog", 1, 16));
        label13.setText("Medida de la cintura");
        weigthTxt.setFont(new Font("Dialog", 0, 16));
        hipSizeTxt.setFont(new Font("Dialog", 0, 16));
        label14.setAlignment(2);
        label14.setFont(new Font("Dialog", 1, 16));
        label14.setText("Medida de la cadera");
        label15.setAlignment(2);
        label15.setFont(new Font("Dialog", 1, 16));
        label15.setText("Riesgo de comorbilidad");
        riskTxt.setFont(new Font("Dialog", 0, 16));
        dxTxt.setFont(new Font("Dialog", 0, 16));
        label16.setAlignment(2);
        label16.setFont(new Font("Dialog", 1, 16));
        label16.setText("Dx");
        label17.setFont(new Font("Dialog", 1, 16));
        label17.setText("kilogramos");
        label18.setFont(new Font("Dialog", 1, 16));
        label18.setText("centimetros");
        label19.setFont(new Font("Dialog", 1, 16));
        label19.setText("centimetros");
        label20.setFont(new Font("Dialog", 1, 16));
        label20.setText("centimetros");
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label11, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(weigthTxt, -2, 250, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label17, -1, -1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label12, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(heightTxt, -2, 250, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label19, -2, 0, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label13, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(waistSizeTxt, -2, 250, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label18, -1, -1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label14, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(hipSizeTxt, -2, 250, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label20, -1, -1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label15, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(riskTxt, -2, 250, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(label16, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(dxTxt, -2, 250, -2))).addContainerGap(372, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(46, 46, 46).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label11, -2, 30, -2).addComponent(weigthTxt, -2, 30, -2).addComponent(label17, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label12, -2, 30, -2).addComponent(label19, javax.swing.GroupLayout.Alignment.TRAILING, -2, 30, -2))).addComponent(heightTxt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label13, -2, 30, -2).addComponent(label18, javax.swing.GroupLayout.Alignment.TRAILING, -2, 30, -2))).addComponent(waistSizeTxt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label14, -2, 30, -2).addComponent(hipSizeTxt, -2, 30, -2))).addComponent(label20, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label15, -2, 30, -2).addComponent(riskTxt, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label16, -2, 30, -2).addComponent(dxTxt, -2, 30, -2)).addContainerGap(271, 32767)));
        jTabbedPane2.addTab("Antropom\351tricos", jPanel4);
        sobrepeso_checkbox.setFont(new Font("Dialog", 1, 16));
        sobrepeso_checkbox.setLabel("sobrepeso");
        obesidad_checkbox.setFont(new Font("Dialog", 1, 16));
        obesidad_checkbox.setLabel("obesidad");
        cancer_checkbox.setFont(new Font("Dialog", 1, 16));
        cancer_checkbox.setLabel("c\341ncer");
        diabetes_checkbox.setFont(new Font("Dialog", 1, 16));
        diabetes_checkbox.setLabel("diabetes");
        alcoholismo_checkbox.setFont(new Font("Dialog", 1, 16));
        alcoholismo_checkbox.setLabel("alcoholismo");
        hiper_checkbox.setFont(new Font("Dialog", 1, 16));
        hiper_checkbox.setLabel("hipertensi\363n arterial");
        cardiopatia_checkbox.setFont(new Font("Dialog", 1, 16));
        cardiopatia_checkbox.setLabel("cardiopatia");
        dislipidemias_checkbox.setFont(new Font("Dialog", 1, 16));
        dislipidemias_checkbox.setLabel("disliepidemia");
        enfhepaticas_checkbox.setFont(new Font("Dialog", 1, 16));
        enfhepaticas_checkbox.setLabel("enfermedades hep\341ticas");
        enfrespiratorias_checkbox.setFont(new Font("Dialog", 1, 16));
        enfrespiratorias_checkbox.setLabel("enfermedades respiratorias");
        enfrenales_checkbox.setFont(new Font("Dialog", 1, 16));
        enfrenales_checkbox.setLabel("enfermedades renales");
        otro_checkbox.setFont(new Font("Dialog", 1, 16));
        otro_checkbox.setLabel("otro");
        label7.setFont(new Font("Dialog", 1, 22));
        label7.setText("S\355ntomas que presentan actualmente");
        nauseas_checkbox.setFont(new Font("Dialog", 1, 16));
        nauseas_checkbox.setLabel("Na\372seas");
        diarrea_checkbox.setFont(new Font("Dialog", 1, 16));
        diarrea_checkbox.setLabel("diarrea");
        cansancio_checkbox.setFont(new Font("Dialog", 1, 16));
        cansancio_checkbox.setLabel("cansancio");
        vomito_checkbox.setFont(new Font("Dialog", 1, 16));
        vomito_checkbox.setLabel("v\363mito");
        profmasticacion_checkbox.setFont(new Font("Dialog", 1, 16));
        profmasticacion_checkbox.setLabel("Problemas de masticaci\363n");
        glucion_checkbox.setFont(new Font("Dialog", 1, 16));
        glucion_checkbox.setLabel("problemas de gluci\363n");
        estomacal_checkbox.setFont(new Font("Dialog", 1, 16));
        estomacal_checkbox.setLabel("inflamaci\363n estomacal");
        estreF1imiento_checkbox.setFont(new Font("Dialog", 1, 16));
        estreF1imiento_checkbox.setLabel("estre\361imiento");
        gastritis_checkbox.setFont(new Font("Dialog", 1, 16));
        gastritis_checkbox.setLabel("gastritis");
        mareos_checkbox.setFont(new Font("Dialog", 1, 16));
        mareos_checkbox.setLabel("mareos");
        alteracion_checkbox.setFont(new Font("Dialog", 1, 16));
        alteracion_checkbox.setLabel("alteraciones del apetito");
        indigestion_checkbox.setFont(new Font("Dialog", 1, 16));
        indigestion_checkbox.setLabel("flatulencia, indigesti\363n");
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(sobrepeso_checkbox, -2, -1, -2).addComponent(obesidad_checkbox, -2, -1, -2).addComponent(cancer_checkbox, -2, -1, -2).addComponent(diabetes_checkbox, -2, -1, -2)).addGap(46, 46, 46).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(dislipidemias_checkbox, -2, -1, -2).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(alcoholismo_checkbox, -2, -1, -2).addComponent(hiper_checkbox, -2, -1, -2).addComponent(cardiopatia_checkbox, -2, -1, -2)).addGap(57, 57, 57).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(enfrenales_checkbox, -2, -1, -2).addComponent(enfrespiratorias_checkbox, -2, -1, -2).addComponent(enfhepaticas_checkbox, -2, -1, -2).addComponent(otro_checkbox, -2, -1, -2))))).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(diarrea_checkbox, -2, -1, -2).addGap(114, 114, 114)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(vomito_checkbox, -2, -1, -2).addGap(117, 117, 117))).addGroup(jPanel5Layout.createSequentialGroup().addComponent(nauseas_checkbox, -2, -1, -2).addGap(102, 102, 102))).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(glucion_checkbox, -2, -1, -2).addComponent(estomacal_checkbox, -2, -1, -2).addComponent(profmasticacion_checkbox, -2, -1, -2)).addGap(15, 15, 15).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(cansancio_checkbox, -2, -1, -2).addComponent(estreF1imiento_checkbox, -2, -1, -2).addComponent(gastritis_checkbox, -2, -1, -2)).addGap(54, 54, 54).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(indigestion_checkbox, -2, -1, -2).addComponent(alteracion_checkbox, -2, -1, -2).addComponent(mareos_checkbox, -2, -1, -2))).addComponent(label7, -2, -1, -2)))).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(sobrepeso_checkbox, -2, -1, -2).addComponent(alcoholismo_checkbox, -2, -1, -2).addComponent(enfhepaticas_checkbox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(obesidad_checkbox, -2, -1, -2).addComponent(hiper_checkbox, -2, -1, -2).addComponent(enfrespiratorias_checkbox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(cancer_checkbox, -2, -1, -2).addComponent(cardiopatia_checkbox, -2, -1, -2).addComponent(enfrenales_checkbox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(otro_checkbox, -2, -1, -2).addComponent(dislipidemias_checkbox, -2, -1, -2).addComponent(diabetes_checkbox, -2, -1, -2)).addGap(23, 23, 23).addComponent(label7, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(nauseas_checkbox, -2, -1, -2).addComponent(cansancio_checkbox, -2, -1, -2).addComponent(mareos_checkbox, -2, -1, -2).addComponent(profmasticacion_checkbox, -2, -1, -2)).addGap(25, 25, 25).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(vomito_checkbox, -2, -1, -2).addComponent(glucion_checkbox, -2, -1, -2).addComponent(estreF1imiento_checkbox, -2, -1, -2).addComponent(alteracion_checkbox, -2, -1, -2)).addGap(28, 28, 28).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(estomacal_checkbox, -2, -1, -2).addComponent(gastritis_checkbox, -2, -1, -2).addComponent(indigestion_checkbox, -2, -1, -2).addComponent(diarrea_checkbox, -2, -1, -2)).addContainerGap(217, 32767)));
        jTabbedPane2.addTab("Antecedentes heredofamiliares", jPanel5);
        habitsYesNoBox03.setFont(new Font("Dialog", 0, 16));
        habitsYesNoBox03.setModel(new DefaultComboBoxModel(new String[] {
            "S\355", "No"
        }));
        label_saltar.setFont(new Font("Dialog", 1, 16));
        label_saltar.setForeground(new Color(1, 1, 1));
        label_saltar.setText("Acostumbras a saltarte comidas?");
        habitsYesNoBox01.setFont(new Font("Dialog", 0, 16));
        habitsYesNoBox01.setModel(new DefaultComboBoxModel(new String[] {
            "S\355", "No", "De lunes a viernes"
        }));
        horarios_comida.setFont(new Font("Dialog", 1, 16));
        horarios_comida.setForeground(new Color(1, 1, 1));
        horarios_comida.setText("Sus horarios de comida son fijos");
        colaciones.setFont(new Font("Dialog", 1, 16));
        colaciones.setForeground(new Color(1, 1, 1));
        colaciones.setText("\277Cu\341ntas colaciones realizas?");
        colationsBox.setFont(new Font("Dialog", 0, 16));
        colationsBox.setModel(new DefaultComboBoxModel(new String[] {
            "0", "1", "2", "3", "4", "5", "6"
        }));
        comes.setFont(new Font("Dialog", 1, 16));
        comes.setForeground(new Color(1, 1, 1));
        comes.setText("\277Cu\341ntas veces comes al d\355a?");
        eatCountBox.setFont(new Font("Dialog", 0, 16));
        eatCountBox.setModel(new DefaultComboBoxModel(new String[] {
            "1", "2", "3", "4", "5", "6"
        }));
        entre_comidas.setFont(new Font("Dialog", 1, 16));
        entre_comidas.setForeground(new Color(1, 1, 1));
        entre_comidas.setText("\277Acostumbras a comer entre comidas?");
        habitsYesNoBox02.setFont(new Font("Dialog", 0, 16));
        habitsYesNoBox02.setModel(new DefaultComboBoxModel(new String[] {
            "S\355", "No"
        }));
        hungryHourTxt.setFont(new Font("Dialog", 0, 16));
        jScrollPane15.setViewportView(hungryHourTxt);
        hambre.setFont(new Font("Dialog", 1, 16));
        hambre.setForeground(new Color(1, 1, 1));
        hambre.setText("\277A qu\351 hora siente m\341s hambre?");
        lugar_comer.setFont(new Font("Dialog", 1, 16));
        lugar_comer.setForeground(new Color(1, 1, 1));
        lugar_comer.setText("Lugar donde acostumbra comer regularmente");
        prepara.setFont(new Font("Dialog", 1, 16));
        prepara.setForeground(new Color(1, 1, 1));
        prepara.setText("\277Qui\351n prepara tus alimentos?");
        palceEatTxt.setFont(new Font("Dialog", 0, 16));
        jScrollPane16.setViewportView(palceEatTxt);
        whoFoodsTxt.setFont(new Font("Dialog", 0, 16));
        jScrollPane3.setViewportView(whoFoodsTxt);
        watterTxt.setFont(new Font("Dialog", 0, 16));
        jScrollPane4.setViewportView(watterTxt);
        agua.setFont(new Font("Dialog", 1, 16));
        agua.setForeground(new Color(1, 1, 1));
        agua.setText("Consumo de agua");
        frecuencia_fumas.setFont(new Font("Dialog", 1, 16));
        frecuencia_fumas.setForeground(new Color(1, 1, 1));
        frecuencia_fumas.setText("\277Con qu\351 frecuencia fumas?");
        frecuencia.setFont(new Font("Dialog", 1, 16));
        frecuencia.setForeground(new Color(1, 1, 1));
        frecuencia.setText("\277Con qu\351 frecuencia tomas bebida alcoh\363licas?");
        drinkFrequentyBox.setFont(new Font("Dialog", 0, 16));
        drinkFrequentyBox.setModel(new DefaultComboBoxModel(new String[] {
            "Nunca", "Una vez por semana", "dos veces por semana", "tres veces por semana", "cada ocho dias", "una vez por mes", "una vez por a\361o", "dos veces por a\361o"
        }));
        smokeFreqTxt.setFont(new Font("Dialog", 0, 16));
        smokeFreqTxt.setModel(new DefaultComboBoxModel(new String[] {
            "Nunca", "Una vez por semana", "dos veces por semana", "tres veces por semana", "cada ocho dias", "una vez por mes", "una vez por a\361o", "dos veces por a\361o"
        }));
        label_saltar1.setFont(new Font("Dialog", 1, 16));
        label_saltar1.setForeground(new Color(1, 1, 1));
        label_saltar1.setText("Litros al d\355a");
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(frecuencia).addComponent(frecuencia_fumas).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(horarios_comida).addComponent(colaciones).addComponent(hambre).addComponent(lugar_comer).addComponent(prepara).addComponent(label_saltar).addComponent(entre_comidas).addComponent(agua).addComponent(comes)).addGap(29, 29, 29).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(eatCountBox, -2, 63, -2).addComponent(habitsYesNoBox01, -2, 63, -2).addComponent(habitsYesNoBox02, -2, -1, -2).addComponent(habitsYesNoBox03, -2, -1, -2).addComponent(colationsBox, -2, 63, -2).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(jScrollPane4, -2, 218, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label_saltar1, -2, 169, -2)).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, -2, 399, -2))).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(drinkFrequentyBox, -2, -1, -2).addComponent(smokeFreqTxt, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2)).addComponent(jScrollPane15, -2, 399, -2)))).addContainerGap(134, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(comes).addComponent(eatCountBox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(colaciones).addComponent(colationsBox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(horarios_comida).addComponent(habitsYesNoBox01, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(entre_comidas).addComponent(habitsYesNoBox02, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(habitsYesNoBox03, javax.swing.GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(label_saltar)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane15, -2, -1, -2).addComponent(hambre)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane16, -2, -1, -2).addComponent(lugar_comer)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane3, -2, -1, -2).addComponent(prepara)).addGap(9, 9, 9).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(label_saltar1)).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(agua).addComponent(jScrollPane4, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(frecuencia).addGap(29, 29, 29).addComponent(frecuencia_fumas)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(drinkFrequentyBox, -2, -1, -2).addGap(17, 17, 17).addComponent(smokeFreqTxt, -2, -1, -2))).addContainerGap(-1, 32767)));
        jTabbedPane2.addTab("H\341bitos", jPanel6);
        label31.setFont(new Font("Dialog", 1, 16));
        label31.setText("Alimento");
        label32.setFont(new Font("Dialog", 1, 16));
        label32.setText("Tipo");
        Yogurth_Label12.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label12.setText("Yogurth");
        yogurthType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label13.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label13.setText("Fruta");
        frutaType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label14.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label14.setText("Verdura");
        verduraType.setFont(new Font("Ubuntu", 0, 16));
        tortillaType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label15.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label15.setText("Pastas");
        Yogurth_Label16.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label16.setText("Tortilla");
        Yogurth_Label17.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label17.setText("Pan");
        panType.setFont(new Font("Ubuntu", 0, 16));
        pastasType.setFont(new Font("Ubuntu", 0, 16));
        arrozType.setFont(new Font("Ubuntu", 0, 16));
        cerealType.setFont(new Font("Ubuntu", 0, 16));
        huevosType.setFont(new Font("Ubuntu", 0, 16));
        polloType.setFont(new Font("Ubuntu", 0, 16));
        carnesType.setFont(new Font("Ubuntu", 0, 16));
        jLabel17.setFont(new Font("Ubuntu", 0, 16));
        jLabel17.setText("Arroz");
        jLabel18.setFont(new Font("Ubuntu", 0, 16));
        jLabel18.setText("Cereal en las ma\361anas");
        jLabel19.setFont(new Font("Ubuntu", 0, 16));
        jLabel19.setText("Carne roja");
        jLabel20.setFont(new Font("Ubuntu", 0, 16));
        jLabel20.setText("Pollo");
        jLabel21.setFont(new Font("Ubuntu", 0, 16));
        jLabel21.setText("Huevo");
        label33.setAlignment(1);
        label33.setFont(new Font("Dialog", 1, 16));
        label33.setText("Al d\355a");
        label34.setFont(new Font("Dialog", 1, 16));
        label34.setText("A la semana");
        yogurthDay.setFont(new Font("Ubuntu", 0, 16));
        frutaDay.setFont(new Font("Ubuntu", 0, 16));
        verduraDay.setFont(new Font("Ubuntu", 0, 16));
        pastasDay.setFont(new Font("Ubuntu", 0, 16));
        panDay.setFont(new Font("Ubuntu", 0, 16));
        tortillaDay.setFont(new Font("Ubuntu", 0, 16));
        carnesDay.setFont(new Font("Ubuntu", 0, 16));
        cerealDay.setFont(new Font("Ubuntu", 0, 16));
        arrozDay.setFont(new Font("Ubuntu", 0, 16));
        polloDay.setFont(new Font("Ubuntu", 0, 16));
        huevosDay.setFont(new Font("Ubuntu", 0, 16));
        frutaWeek.setFont(new Font("Ubuntu", 0, 16));
        verduraWeek.setFont(new Font("Ubuntu", 0, 16));
        tortillaWeek.setFont(new Font("Ubuntu", 0, 16));
        panWeek.setFont(new Font("Ubuntu", 0, 16));
        pastasWeek.setFont(new Font("Ubuntu", 0, 16));
        arrozWeek.setFont(new Font("Ubuntu", 0, 16));
        cerealWeek.setFont(new Font("Ubuntu", 0, 16));
        carnesWeek.setFont(new Font("Ubuntu", 0, 16));
        polloWeek.setFont(new Font("Ubuntu", 0, 16));
        huevosWeek.setFont(new Font("Ubuntu", 0, 16));
        panMonth.setFont(new Font("Ubuntu", 0, 16));
        huevosMonth.setFont(new Font("Ubuntu", 0, 16));
        frutaMonth.setFont(new Font("Ubuntu", 0, 16));
        pastasMonth.setFont(new Font("Ubuntu", 0, 16));
        polloMonth.setFont(new Font("Ubuntu", 0, 16));
        arrozMonth.setFont(new Font("Ubuntu", 0, 16));
        carnesMonth.setFont(new Font("Ubuntu", 0, 16));
        cerealMonth.setFont(new Font("Ubuntu", 0, 16));
        tortillaMonth.setFont(new Font("Ubuntu", 0, 16));
        verduraMonth.setFont(new Font("Ubuntu", 0, 16));
        label35.setFont(new Font("Dialog", 1, 16));
        label35.setText("Al mes");
        yogurthWeek.setFont(new Font("Ubuntu", 0, 16));
        yogurthMonth.setFont(new Font("Ubuntu", 0, 16));
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label31, -2, 200, -2).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(Yogurth_Label12, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label17, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label16, -1, -1, 32767).addComponent(Yogurth_Label14, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label13, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label15, javax.swing.GroupLayout.Alignment.LEADING, -1, 200, 32767).addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tortillaType).addComponent(label32, -1, -1, 32767).addComponent(yogurthType).addComponent(frutaType).addComponent(verduraType).addComponent(panType).addComponent(pastasType).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(arrozType, -2, 250, -2).addComponent(huevosType, -2, 250, -2).addComponent(polloType, -2, 250, -2).addComponent(carnesType, -2, 250, -2).addComponent(cerealType, -2, 250, -2)).addGap(0, 0, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(yogurthDay, -2, 120, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(yogurthWeek, -2, 120, -2)).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(frutaDay, -2, 120, -2).addComponent(verduraDay, -2, 120, -2).addComponent(tortillaDay, -2, 120, -2).addComponent(panDay, -2, 120, -2).addComponent(pastasDay, -2, 120, -2).addComponent(arrozDay, -2, 120, -2).addComponent(cerealDay, -2, 120, -2).addComponent(carnesDay, -2, 120, -2).addComponent(polloDay, -2, 120, -2).addComponent(huevosDay, -2, 120, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tortillaWeek, -2, 120, -2).addComponent(panWeek, -2, 120, -2).addComponent(pastasWeek, -2, 120, -2).addComponent(arrozWeek, -2, 120, -2).addComponent(cerealWeek, -2, 120, -2).addComponent(carnesWeek, -2, 120, -2).addComponent(polloWeek, -2, 120, -2).addComponent(huevosWeek, -2, 120, -2).addComponent(verduraWeek, javax.swing.GroupLayout.Alignment.TRAILING, -2, 120, -2).addComponent(frutaWeek, javax.swing.GroupLayout.Alignment.TRAILING, -2, 120, -2)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(label33, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label34, -2, 120, -2).addGap(14, 14, 14))).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label35, -2, 120, -2).addComponent(verduraMonth, -2, 120, -2).addComponent(tortillaMonth, -2, 120, -2).addComponent(panMonth, -2, 120, -2).addComponent(pastasMonth, -2, 120, -2).addComponent(arrozMonth, -2, 120, -2).addComponent(cerealMonth, -2, 120, -2).addComponent(carnesMonth, -2, 120, -2).addComponent(polloMonth, -2, 120, -2).addComponent(huevosMonth, -2, 120, -2).addComponent(frutaMonth, -2, 120, -2).addComponent(yogurthMonth, -2, 120, -2)).addGap(415, 415, 415)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label34, -2, 30, -2).addComponent(label32, -2, 30, -2).addComponent(label31, -2, 30, -2).addComponent(label33, -2, 30, -2).addComponent(label35, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label12).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(yogurthType, -2, -1, -2).addComponent(yogurthDay, -2, -1, -2).addComponent(yogurthWeek, -2, -1, -2).addComponent(yogurthMonth, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label13).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(frutaType, -2, -1, -2).addComponent(frutaDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label14).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(verduraType, -2, -1, -2).addComponent(verduraDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label16).addComponent(tortillaType, -2, -1, -2)).addGap(18, 18, 18).addComponent(Yogurth_Label17, -2, 17, -2).addGap(18, 18, 18).addComponent(Yogurth_Label15).addGap(18, 18, 18).addComponent(jLabel17).addGap(18, 18, 18).addComponent(jLabel18).addGap(18, 18, 18).addComponent(jLabel19).addGap(18, 18, 18).addComponent(jLabel20).addGap(18, 18, 18).addComponent(jLabel21)).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(panType, -2, -1, -2).addGap(6, 6, 6).addComponent(pastasType, -2, -1, -2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(tortillaDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pastasDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(arrozType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cerealType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(carnesType, -2, -1, -2).addGap(6, 6, 6).addComponent(polloType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(huevosType, -2, -1, -2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(arrozDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cerealDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(carnesDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(polloDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(huevosDay, -2, -1, -2)))))).addGroup(jPanel7Layout.createSequentialGroup().addComponent(frutaWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(verduraWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tortillaWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pastasWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(arrozWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cerealWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(carnesWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(polloWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(huevosWeek, -2, -1, -2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(frutaMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(verduraMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tortillaMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pastasMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(arrozMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cerealMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(carnesMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(polloMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(huevosMonth, -2, -1, -2))).addContainerGap(-1, 32767)));
        jTabbedPane3.addTab("Dieta", jPanel7);
        label36.setFont(new Font("Dialog", 1, 16));
        label36.setText("Alimento");
        label37.setFont(new Font("Dialog", 1, 16));
        label37.setText("Tipo");
        Yogurth_Label18.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label18.setText("Pescado");
        pescadoType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label19.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label19.setText("Jam\363n");
        jamonType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label20.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label20.setText("Salchicha");
        salchichaType.setFont(new Font("Ubuntu", 0, 16));
        quesoType.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label21.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label21.setText("Grasas");
        Yogurth_Label22.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label22.setText("Queso");
        Yogurth_Label23.setFont(new Font("Ubuntu", 0, 16));
        Yogurth_Label23.setText("Az\372car");
        azucarType.setFont(new Font("Ubuntu", 0, 16));
        grasasType.setFont(new Font("Ubuntu", 0, 16));
        dulcesType.setFont(new Font("Ubuntu", 0, 16));
        papasType.setFont(new Font("Ubuntu", 0, 16));
        otrosType.setFont(new Font("Ubuntu", 0, 16));
        refrescosType.setFont(new Font("Ubuntu", 0, 16));
        comidaType.setFont(new Font("Ubuntu", 0, 16));
        jLabel22.setFont(new Font("Ubuntu", 0, 16));
        jLabel22.setText("Dulces o golosinas");
        jLabel23.setFont(new Font("Ubuntu", 0, 16));
        jLabel23.setText("Papas fritas");
        jLabel24.setFont(new Font("Ubuntu", 0, 16));
        jLabel24.setText("Comida r\341pida");
        jLabel25.setFont(new Font("Ubuntu", 0, 16));
        jLabel25.setText("Refrescos");
        jLabel26.setFont(new Font("Ubuntu", 0, 16));
        jLabel26.setText("Otros");
        label38.setAlignment(1);
        label38.setFont(new Font("Dialog", 1, 16));
        label38.setText("Al d\355a");
        label39.setFont(new Font("Dialog", 1, 16));
        label39.setText("A la semana");
        pescadoDay.setFont(new Font("Ubuntu", 0, 16));
        jamonDay.setFont(new Font("Ubuntu", 0, 16));
        salchichaDay.setFont(new Font("Ubuntu", 0, 16));
        grasasDay.setFont(new Font("Ubuntu", 0, 16));
        azucarDay.setFont(new Font("Ubuntu", 0, 16));
        quesoDay.setFont(new Font("Ubuntu", 0, 16));
        comidaDay.setFont(new Font("Ubuntu", 0, 16));
        papasDay.setFont(new Font("Ubuntu", 0, 16));
        dulcesDay.setFont(new Font("Ubuntu", 0, 16));
        refrescosDay.setFont(new Font("Ubuntu", 0, 16));
        otrosDay.setFont(new Font("Ubuntu", 0, 16));
        pescadoWeek.setFont(new Font("Ubuntu", 0, 16));
        jamonWeek.setFont(new Font("Ubuntu", 0, 16));
        salchichaWeek.setFont(new Font("Ubuntu", 0, 16));
        quesoWeek.setFont(new Font("Ubuntu", 0, 16));
        azucarWeek.setFont(new Font("Ubuntu", 0, 16));
        grasasWeek.setFont(new Font("Ubuntu", 0, 16));
        dulcesWeek.setFont(new Font("Ubuntu", 0, 16));
        comidaWeek.setFont(new Font("Ubuntu", 0, 16));
        refrescosWeek.setFont(new Font("Ubuntu", 0, 16));
        otrosWeek.setFont(new Font("Ubuntu", 0, 16));
        azucarMonth.setFont(new Font("Ubuntu", 0, 16));
        otrosMonth.setFont(new Font("Ubuntu", 0, 16));
        pescadoMonth.setFont(new Font("Ubuntu", 0, 16));
        grasasMonth.setFont(new Font("Ubuntu", 0, 16));
        refrescosMonth.setFont(new Font("Ubuntu", 0, 16));
        dulcesMonth.setFont(new Font("Ubuntu", 0, 16));
        comidaMonth.setFont(new Font("Ubuntu", 0, 16));
        papasMonth.setFont(new Font("Ubuntu", 0, 16));
        quesoMonth.setFont(new Font("Ubuntu", 0, 16));
        jamonMonth.setFont(new Font("Ubuntu", 0, 16));
        label40.setFont(new Font("Dialog", 1, 16));
        label40.setText("Al mes");
        salchichaMonth.setFont(new Font("Ubuntu", 0, 16));
        papasWeek.setFont(new Font("Ubuntu", 0, 16));
        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label36, -2, 200, -2).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(Yogurth_Label18, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label23, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label22, -1, -1, 32767).addComponent(Yogurth_Label20, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label19, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(Yogurth_Label21, javax.swing.GroupLayout.Alignment.LEADING, -1, 200, 32767).addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label37, -1, -1, 32767).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(dulcesType, -1, 250, 32767).addComponent(otrosType, -1, 250, 32767).addComponent(refrescosType, -1, 250, 32767).addComponent(comidaType, -1, 250, 32767).addComponent(papasType, -1, 250, 32767).addComponent(grasasType).addComponent(azucarType).addComponent(quesoType).addComponent(salchichaType).addComponent(jamonType)).addComponent(pescadoType, -2, 250, -2)).addGap(0, 0, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pescadoDay, -2, 120, -2).addComponent(jamonDay, -2, 120, -2).addComponent(salchichaDay, -2, 120, -2).addComponent(quesoDay, -2, 120, -2).addComponent(azucarDay, -2, 120, -2).addComponent(grasasDay, -2, 120, -2).addComponent(dulcesDay, -2, 120, -2).addComponent(papasDay, -2, 120, -2).addComponent(comidaDay, -2, 120, -2).addComponent(refrescosDay, -2, 120, -2).addComponent(otrosDay, -2, 120, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(salchichaWeek, -2, 120, -2).addComponent(quesoWeek, -2, 120, -2).addComponent(azucarWeek, -2, 120, -2).addComponent(grasasWeek, -2, 120, -2).addComponent(dulcesWeek, -2, 120, -2).addComponent(comidaWeek, -2, 120, -2).addComponent(refrescosWeek, -2, 120, -2).addComponent(otrosWeek, -2, 120, -2).addComponent(jamonWeek, javax.swing.GroupLayout.Alignment.TRAILING, -2, 120, -2).addComponent(pescadoWeek, javax.swing.GroupLayout.Alignment.TRAILING, -2, 120, -2)).addComponent(papasWeek, -2, 120, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(label38, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(label39, -2, 120, -2).addGap(14, 14, 14))).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(label40, -2, 120, -2).addContainerGap()).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(salchichaMonth, javax.swing.GroupLayout.Alignment.LEADING).addComponent(jamonMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(quesoMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(azucarMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(grasasMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(dulcesMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(papasMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(comidaMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(refrescosMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(otrosMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767).addComponent(pescadoMonth, javax.swing.GroupLayout.Alignment.LEADING, -1, 120, 32767)).addGap(0, 96, 32767)))));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(label39, -2, 30, -2).addComponent(label37, -2, 30, -2).addComponent(label36, -2, 30, -2).addComponent(label38, -2, 30, -2).addComponent(label40, -2, 30, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label18).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(pescadoType, -2, -1, -2).addComponent(pescadoDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label19).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jamonType, -2, -1, -2).addComponent(jamonDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label20).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(salchichaType, -2, -1, -2).addComponent(salchichaDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(Yogurth_Label22).addComponent(quesoType, -2, -1, -2)).addGap(18, 18, 18).addComponent(Yogurth_Label23, -2, 17, -2).addGap(18, 18, 18).addComponent(Yogurth_Label21).addGap(18, 18, 18).addComponent(jLabel22).addGap(18, 18, 18).addComponent(jLabel23).addGap(18, 18, 18).addComponent(jLabel24).addGap(18, 18, 18).addComponent(jLabel25).addGap(18, 18, 18).addComponent(jLabel26)).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(azucarType, -2, -1, -2).addGap(6, 6, 6).addComponent(grasasType, -2, -1, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(quesoDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(azucarDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(grasasDay, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(dulcesType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(papasType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comidaType, -2, -1, -2).addGap(6, 6, 6).addComponent(refrescosType, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(otrosType, -2, -1, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(dulcesDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(papasDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comidaDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(refrescosDay, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(otrosDay, -2, -1, -2)))))).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(pescadoMonth, -2, -1, -2).addComponent(pescadoWeek, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jamonMonth, -2, -1, -2).addComponent(jamonWeek, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(salchichaWeek, -2, -1, -2).addComponent(salchichaMonth, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel9Layout.createSequentialGroup().addComponent(quesoWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(azucarWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(grasasWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(dulcesWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(comidaWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(refrescosWeek, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(otrosWeek, -2, -1, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(quesoMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(azucarMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(grasasMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(dulcesMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(papasMonth, -2, -1, -2).addComponent(papasWeek, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comidaMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(refrescosMonth, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(otrosMonth, -2, -1, -2))))).addContainerGap(-1, 32767)));
        jTabbedPane3.addTab("Dieta", jPanel9);
        jTabbedPane2.addTab("Dieta", jTabbedPane3);
        jTabbedPane1.addTab("Ver/Editar toda la informaci\363n", jTabbedPane2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1, -2, 1024, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jTabbedPane1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        File f = null;
        JFileChooser file = new JFileChooser();
        int option = file.showOpenDialog(this);
        if(option == 0)
        {
            f = file.getSelectedFile();
            filePhoto = f.toString();
            ImageIcon photo = new ImageIcon(filePhoto);
            photoLbl.setIcon(new ImageIcon(photo.getImage().getScaledInstance(340, 307, 0)));
        }
    }

    private void appoLstValueChanged(ListSelectionEvent evt)
    {
        FileAppo file = new FileAppo((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append('/').toString(), (new StringBuilder()).append("Sesi\363n ").append(appoLst.getSelectedIndex() + 1).toString());
        file.read();
        anotAppoTxtArea.setText(file.getAppoiment());
    }

    private void appoLstMouseClicked(MouseEvent evt)
    {
        if(evt.getClickCount() != 2);
    }

    private void pdfBtnActionPerformed(ActionEvent evt)
    {
        boolean flag1 = true;
        Message mes = new Message();
        mes.setTitle("\311xito");
        mes.setMassage((new StringBuilder()).append("Se ha creado la sesi\363n en tu directorio ").append(rute).append(user.getPersonalData().getName()).toString());
        mes.setOptions(new Object[] {
            "Entendido"
        });
        if((new File((new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append("/Sesi\363n ").append(appoLst.getSelectedIndex() + 1).append(".pdf").toString())).exists())
            flag1 = false;
        if(flag1)
        {
            pdfBtn.removeActionListener(this);
            PDFGenerator pdf = new PDFGenerator("", (new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append("/Sesi\363n ").append(appoLst.getSelectedIndex() + 1).append(".pdf").toString(), (new StringBuilder()).append("Sesi\363n ").append(appoLst.getSelectedIndex() + 1).append("\n").append(user.getPersonalData().getName()).toString(), (new StringBuilder()).append(anotAppoTxtArea.getText()).append("\n").append((new Date(new java.sql.Date((new java.util.Date()).getTime()))).getDate()).toString(), "NUTRICI\323N", filePhoto);
            pdf.createPDF();
            mes.showMessage();
            ConfFiles conf = new ConfFiles((new StringBuilder()).append(rute).append("tmp.txt").toString());
            conf.read();
            String clave = conf.getPasswordMail();
            String remitente = conf.getProfileMail();
            //JOptionPane.showConfirmDialog(null, (new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append("/Sesi\363n ").toString());
            SendEMail mail = new SendEMail(user.getPersonalData().geteMail(), "Nutrici\363n Lab", (new StringBuilder()).append("Hola, \277qu\351 tal?, te hacemos llegar el registro correspondiente a tu Sesi\363n n\372mero ").append(appoLst.getSelectedIndex() + 1).append(". \241Saludos!").toString(), (new StringBuilder()).append(rute).append(user.getPersonalData().getName()).append("/Sesi\363n ").append(appoLst.getSelectedIndex() + 1).append(".pdf").toString(), remitente, clave);
            if(mail.enviarConGMail())
            {
                mes.setMassage((new StringBuilder()).append("Se ha enviado con \351xito una copia a ").append(user.getPersonalData().geteMail()).toString());
                mes.showMessage();
            } else
            {
                mes.setTitle("Hubo un problema");
                mes.setMassage((new StringBuilder()).append("Hubo un problema al tartar de enviar una copia a ").append(user.getPersonalData().geteMail()).toString());
                mes.showMessage();
            }
        } else
        {
            pdfBtn.removeActionListener(this);
            mes.setMassage("\241Ya est\341 creado!");
            mes.showMessage();
        }
    }

    User user;
    int index;
    MainFrame main;
    FileReminder reminder;
    String filePhoto;
    public int appoiments;
    boolean flag;
    public String rute;
    private JLabel Yogurth_Label12;
    private JLabel Yogurth_Label13;
    private JLabel Yogurth_Label14;
    private JLabel Yogurth_Label15;
    private JLabel Yogurth_Label16;
    private JLabel Yogurth_Label17;
    private JLabel Yogurth_Label18;
    private JLabel Yogurth_Label19;
    private JLabel Yogurth_Label20;
    private JLabel Yogurth_Label21;
    private JLabel Yogurth_Label22;
    private JLabel Yogurth_Label23;
    private JTextArea actualAilmentTxt;
    private JTextArea actualTreatmentTxt;
    private JComboBox actvPhysBox;
    private JTextField actvPhysDurationTxt;
    private JTextPane actvPhysTxt;
    private JButton addAppoBtn;
    private TextField adressTxt;
    private JLabel agua;
    private Checkbox alcoholismo_checkbox;
    private Checkbox alteracion_checkbox;
    private JTextArea anotAppoTxtArea;
    private JList appoLst;
    private JTextField arrozDay;
    private JTextField arrozMonth;
    private JTextField arrozType;
    private JTextField arrozWeek;
    private JComboBox atcvPhysFrequenBox;
    private JTextField azucarDay;
    private JTextField azucarMonth;
    private JTextField azucarType;
    private JTextField azucarWeek;
    private ButtonGroup buttonGroup1;
    private Checkbox cancer_checkbox;
    private Checkbox cansancio_checkbox;
    private Checkbox cardiopatia_checkbox;
    private JTextField carnesDay;
    private JTextField carnesMonth;
    private JTextField carnesType;
    private JTextField carnesWeek;
    private JTextField cerealDay;
    private JTextField cerealMonth;
    private JTextField cerealType;
    private JTextField cerealWeek;
    private JLabel colaciones;
    private JComboBox colationsBox;
    private JLabel comes;
    private JTextField comidaDay;
    private JTextField comidaMonth;
    private JTextField comidaType;
    private JTextField comidaWeek;
    private JTextArea complementsTxt;
    private JLabel cual_fisica;
    private JButton deleteBtn;
    private Checkbox diabetes_checkbox;
    private Checkbox diarrea_checkbox;
    private Checkbox dislipidemias_checkbox;
    private JComboBox drinkFrequentyBox;
    private JTextField dulcesDay;
    private JTextField dulcesMonth;
    private JTextField dulcesType;
    private JTextField dulcesWeek;
    private JLabel duracion;
    private TextField dxTxt;
    private TextField eMailTxt;
    private JComboBox eatCountBox;
    private Checkbox enfhepaticas_checkbox;
    private Checkbox enfrenales_checkbox;
    private Checkbox enfrespiratorias_checkbox;
    private JLabel entre_comidas;
    private Checkbox estomacal_checkbox;
    private Checkbox estreF1imiento_checkbox;
    private JButton exitBtn;
    private JLabel fisica;
    private JLabel frecuencia;
    private JLabel frecuencia_fumas;
    private JTextField frutaDay;
    private JTextField frutaMonth;
    private JTextField frutaType;
    private JTextField frutaWeek;
    private Checkbox gastritis_checkbox;
    private Checkbox glucion_checkbox;
    private JTextField grasasDay;
    private JTextField grasasMonth;
    private JTextField grasasType;
    private JTextField grasasWeek;
    private JComboBox habitsYesNoBox01;
    private JComboBox habitsYesNoBox02;
    private JComboBox habitsYesNoBox03;
    private JLabel hambre;
    private TextField heightTxt;
    private TextField hipSizeTxt;
    private Checkbox hiper_checkbox;
    private JLabel horarios_comida;
    private JTextField huevosDay;
    private JTextField huevosMonth;
    private JTextField huevosType;
    private JTextField huevosWeek;
    private JTextPane hungryHourTxt;
    private JLabel imcLbl;
    private Checkbox indigestion_checkbox;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane15;
    private JScrollPane jScrollPane16;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JTabbedPane jTabbedPane3;
    private JTextField jamonDay;
    private JTextField jamonMonth;
    private JTextField jamonType;
    private JTextField jamonWeek;
    private Label label1;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label2;
    private Label label20;
    private Label label3;
    private Label label31;
    private Label label32;
    private Label label33;
    private Label label34;
    private Label label35;
    private Label label36;
    private Label label37;
    private Label label38;
    private Label label39;
    private Label label4;
    private Label label40;
    private Label label5;
    private Label label6;
    private Label label7;
    private JLabel label_fisica;
    private JLabel label_saltar;
    private JLabel label_saltar1;
    private JLabel lugar_comer;
    private JLabel mailLbl;
    private Checkbox mareos_checkbox;
    private JLabel nameLbl;
    private TextField nameTxt;
    private Checkbox nauseas_checkbox;
    private Checkbox obesidad_checkbox;
    private Checkbox otro_checkbox;
    private JTextField otrosDay;
    private JTextField otrosMonth;
    private JTextField otrosType;
    private JTextField otrosWeek;
    private JTextPane palceEatTxt;
    private JTextField panDay;
    private JTextField panMonth;
    private JTextField panType;
    private JTextField panWeek;
    private JTextField papasDay;
    private JTextField papasMonth;
    private JTextField papasType;
    private JTextField papasWeek;
    private JTextField pastasDay;
    private JTextField pastasMonth;
    private JTextField pastasType;
    private JTextField pastasWeek;
    private JButton pdfBtn;
    private JTextField pescadoDay;
    private JTextField pescadoMonth;
    private JTextField pescadoType;
    private JTextField pescadoWeek;
    private TextField phone0Txt;
    private JLabel phoneLbl;
    private JLabel photoLbl;
    private JTextField polloDay;
    private JTextField polloMonth;
    private JTextField polloType;
    private JTextField polloWeek;
    private JLabel prepara;
    private JTabbedPane profilePane;
    private Checkbox profmasticacion_checkbox;
    private JTextField quesoDay;
    private JTextField quesoMonth;
    private JTextField quesoType;
    private JTextField quesoWeek;
    private JTextField refrescosDay;
    private JTextField refrescosMonth;
    private JTextField refrescosType;
    private JTextField refrescosWeek;
    private JTextArea remTxtArea;
    private TextField riskTxt;
    private JTextField salchichaDay;
    private JTextField salchichaMonth;
    private JTextField salchichaType;
    private JTextField salchichaWeek;
    public JButton saveChangesBtn;
    private JLabel sesionLbl;
    private JRadioButton sexFem;
    private JRadioButton sexMale;
    private JComboBox smokeFreqTxt;
    private Checkbox sobrepeso_checkbox;
    private JTextArea surgeriesTxt;
    private JTextField tortillaDay;
    private JTextField tortillaMonth;
    private JTextField tortillaType;
    private JTextField tortillaWeek;
    private JTextField verduraDay;
    private JTextField verduraMonth;
    private JTextField verduraType;
    private JTextField verduraWeek;
    private Checkbox vomito_checkbox;
    private TextField waistSizeTxt;
    private JTextPane watterTxt;
    private TextField weigthTxt;
    private JTextPane whoFoodsTxt;
    private JLabel yearsLbl;
    private TextField yearsTxt;
    private JTextField yogurthDay;
    private JTextField yogurthMonth;
    private JTextField yogurthType;
    private JTextField yogurthWeek;




}
