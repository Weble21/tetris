package game;

 import main.Tetris;
 import setting.SettingItem;

 import javax.swing.*;
 import java.awt.*;

 public class GameMenu extends JFrame{
     // private itemGameBoard gameBoard;
     private SettingItem settingItem;
     private GameBoard gameBoard;

     public GameMenu() {

         settingItem = SettingItem.getInstance();

         setSize(settingItem.getBoardWidth(), settingItem.getBoardHeight());
         setBackground(Color.WHITE);
         setForeground(Color.BLACK);
         setLocationRelativeTo(null);
         
         JButton settingButton = new JButton("����");
         JButton startMenuBtn = new JButton("���۸޴���");
         JButton scoreBoardBtn = new JButton("���ھ��");

         settingButton.addActionListener(e -> btnSettingActionPerformed());
         startMenuBtn.addActionListener(e -> btnStartMenuActionPerformed());
         scoreBoardBtn.addActionListener(e -> btnScoreBoardActionPerformed());

         JPanel panel = new JPanel(new GridLayout(0,3));
         panel.add(settingButton);
         panel.add(startMenuBtn);
         panel.add(scoreBoardBtn);

         gameBoard = new GameBoard();

         this.add(gameBoard, BorderLayout.CENTER);
         this.add(panel, BorderLayout.SOUTH);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     private void btnSettingActionPerformed(){
         dispose();
         Tetris.showSettingMenu();
     }

     private void btnStartMenuActionPerformed(){
         dispose();
         Tetris.showStartMenu();
     }

     private void btnScoreBoardActionPerformed(){
         dispose();
         Tetris.showScoreBoard();
     }
 }