package setting;

 import main.Tetris;

 import javax.swing.*;

import file.ScoreBoardFile;
import file.SettingFile;

import java.awt.*;
import java.io.IOException;

 public class SettingMenu extends JFrame {

     private JLabel sizeLabel;
     private JRadioButton[] sizeBtns;
     private ButtonGroup sizeBtnGroup;
     private JPanel sizePanel;
     private JPanel keyPanel;
     private JPanel keySettingPanel;
     private JButton gameBtn;
     private JButton startMenuBtn;
     private JButton initSettingBtn;
     private JButton saveSettingBtn;
     private JLabel colorBlindLabel;
     private JRadioButton colorBlindOnBtn;
     private JRadioButton colorBlindOffBtn;
     private ButtonGroup colorBlindBtnGroup;
     private JButton initScoreBoardBtn;
     private JPanel initScoreBoardPanel;
     private JPanel settingBtnPanel;
     private JLabel modeLabel;
     private ButtonGroup modeBtnGroup;
     private JRadioButton[] modeBtns;
     private JPanel modePanel;

     private SettingItem settingItem;
     private SettingFile settingfile;
     
     private int size = 1;
     
     public SettingMenu() {

         settingItem = SettingItem.getInstance();
         settingfile = new SettingFile();
         
         setTitle("�����޴�");
         setSize(600, 800);
         setBackground(Color.WHITE);
         setLocationRelativeTo(null);

         // ȭ�� ũ�� ���� ��ư & �̺�Ʈ ����
         String[] sizeNames = {"SMALL", "MEDIUM", "LARGE"};
         sizeLabel = new JLabel("ȭ�� ũ��");
         sizeBtns = new JRadioButton[3];
         sizeBtnGroup = new ButtonGroup();

         for(int i = 0; i < sizeBtns.length; i++){
             sizeBtns[i] = new JRadioButton(sizeNames[i]);
             sizeBtnGroup.add(sizeBtns[i]);
         }

         sizePanel = new JPanel(new GridLayout(0, 4));
         sizePanel.add(sizeLabel);
         for(int i = 0; i < sizeBtns.length; i++){
             sizePanel.add(sizeBtns[i]);
         }
         sizeBtns[1].setSelected(true); // medium
         sizeBtns[0].addActionListener(e -> settingItem.btnSmallBtnActionPerformed());
         sizeBtns[1].addActionListener(e -> settingItem.btnMediumBtnActionPerformed());
         sizeBtns[2].addActionListener(e -> settingItem.btnLargeBtnActionPerformed());

         // ����Ű ����
         keyPanel = new JPanel(new BorderLayout());
         keySettingPanel = displayKeySetting();
         keyPanel.add(new JLabel("����Ű ����"), BorderLayout.NORTH);
         keyPanel.add(keySettingPanel,BorderLayout.CENTER);
         // Ű�е� �߰� �ʿ�

         // ���̵� ����
         String[] modeNames = {"EASY", "NORMAL", "HARD"};
         modeLabel = new JLabel("���̵� ����");
         modeBtns = new JRadioButton[3];
         modeBtnGroup = new ButtonGroup();

         for(int i = 0; i < modeBtns.length; i++){
             modeBtns[i] = new JRadioButton(modeNames[i]);
             modeBtnGroup.add(modeBtns[i]);
         }

         modePanel = new JPanel(new GridLayout(0, 4));
         modePanel.add(modeLabel);
         for(int i = 0; i < modeBtns.length; i++){
             modePanel.add(modeBtns[i]);
         }
         modeBtns[1].setSelected(true); // NORMAL
         modeBtns[0].addActionListener(e -> settingItem.btnEasyModeActionPerformed());
         modeBtns[1].addActionListener(e -> settingItem.btnNormalModeActionPerformed());
         modeBtns[2].addActionListener(e -> settingItem.btnHardModeActionPerformed());

         // ���� ��� �Ѱ� ����
         colorBlindLabel = new JLabel("���� ���");
         colorBlindOnBtn = new JRadioButton("on");
         colorBlindOffBtn = new JRadioButton("off");
         colorBlindBtnGroup = new ButtonGroup();
         colorBlindBtnGroup.add(colorBlindOnBtn);
         colorBlindBtnGroup.add(colorBlindOffBtn);

         colorBlindOffBtn.setSelected(true); // default
         colorBlindOnBtn.addActionListener(e -> settingItem.btnColorBlindOnActionPerformed());
         colorBlindOffBtn.addActionListener(e -> settingItem.btnColorBlindOffActionPerformed());

         JPanel colorBlindPanel = new JPanel(new GridLayout(0, 3));
         colorBlindPanel.add(colorBlindLabel);
         colorBlindPanel.add(colorBlindOnBtn);
         colorBlindPanel.add(colorBlindOffBtn);

         // ���ھ� ���� ��� �ʱ�ȭ
         initScoreBoardBtn = new JButton("���ھ� ���� ��� �ʱ�ȭ");
         initScoreBoardBtn.addActionListener(e -> settingItem.btnInitScoreBoardActionPerformed());

         initScoreBoardPanel = new JPanel();
         initScoreBoardPanel.add(initScoreBoardBtn);

         // ���� ���� ��ư, ���� �޴� ��ư & �̺�Ʈ ����
         gameBtn = new JButton("��������");
         startMenuBtn = new JButton("���۸޴���");
         initSettingBtn = new JButton("���� �ʱ�ȭ");
         saveSettingBtn = new JButton("���� ����");

         gameBtn.addActionListener(e -> btnGameActionPerformed());
         startMenuBtn.addActionListener(e -> Tetris.start());
         initSettingBtn.addActionListener(e -> btnInitSettingActionPerformed());
         // saveSettingBtn.addActionListener(e -> btnSaveSettingActionPerformed());

         settingBtnPanel = new JPanel(new GridLayout(5, 0));
         settingBtnPanel.add(gameBtn);
         settingBtnPanel.add(startMenuBtn);
         settingBtnPanel.add(initSettingBtn);
         settingBtnPanel.add(saveSettingBtn);

         // panel �߰�
         this.getContentPane().setLayout(new GridLayout(6, 0));
         this.getContentPane().add(sizePanel);
         this.getContentPane().add(keyPanel);
         this.getContentPane().add(modePanel);
         this.getContentPane().add(initScoreBoardPanel);
         this.getContentPane().add(colorBlindPanel);
         this.getContentPane().add(settingBtnPanel);

         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     }

     public JPanel displayKeySetting(){

         JButton leftKey = new JButton("LEFT");
         JButton rightKey = new JButton("RIGHT");
         JButton downKey = new JButton("DOWN");
         JButton rotateKey = new JButton("ROTATE");
         JButton dropKey = new JButton("DROP");

         // btnKeyAction�ȿ� String �� ���޸� �ϸ� ��
         leftKey.addActionListener(e -> settingItem.btnLeftKeyActionPerformed("J"));
         rightKey.addActionListener(e -> settingItem.btnRightKeyActionPerformed("L"));
         downKey.addActionListener(e -> settingItem.btnDownKeyActionPerformed("K"));
         rotateKey.addActionListener(e -> settingItem.btnRotateKeyActionPerformed("I"));
         dropKey.addActionListener(e -> settingItem.btnDropKeyActionPerformed("SPACE"));

         JPanel keySettingPanel = new JPanel();
         keySettingPanel.add(leftKey);
         keySettingPanel.add(rightKey);
         keySettingPanel.add(downKey);
         keySettingPanel.add(rotateKey);
         keySettingPanel.add(dropKey);

         return keySettingPanel;
     }

     public void btnGameActionPerformed(){
         dispose();
         Tetris.start();
     }

     public void btnStartMenuActionPerformed(){
         dispose();
         Tetris.showStartMenu();
     }

     /**
      * ���� �ʱ�ȭ
      */
     public void btnInitSettingActionPerformed() {
         settingItem.btnMediumBtnActionPerformed();
         sizeBtns[1].setSelected(true);

         settingItem.initKeySetting();

         settingItem.btnColorBlindOffActionPerformed();
         colorBlindOffBtn.setSelected(true);

         settingItem.btnNormalModeActionPerformed();
         modeBtns[1].setSelected(true);

         JOptionPane.showMessageDialog(initScoreBoardPanel,"������ �ʱ�ȭ�Ǿ����ϴ�.");
         settingfile.saveSetting(1);
     }
 }