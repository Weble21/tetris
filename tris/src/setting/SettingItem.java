package setting;

 import setting.exception.EmptyKeyException;

 import javax.swing.*;

import file.ScoreBoardFile;
import file.SettingFile;
import file.ScoreBoardFile;

import java.io.IOException;

 public class SettingItem {

     private static SettingItem instance = new SettingItem();

     private String leftKey;
     private String rightKey;
     private String downKey;
     private String rotateKey;
     private String dropKey;
     private String pauseKey;

     private int boardWidth;
     private int boardHeight;
     private int fontSize;

     private boolean isColorBlind;

     private int initInterval;
     private Mode mode;

     private ScoreBoardFile sb;
     private SettingFile settingfile;

     private SettingItem(){
         initKeySetting();
         initSizeSetting();
         initColorBlindMode();
         initInitInterval();
         initMode();
     }

     public static SettingItem getInstance(){
         if(instance == null){
             return new SettingItem();
         }
         return instance;
     }

     public void initKeySetting(){
         leftKey = "LEFT";
         rightKey = "RIGHT";
         downKey = "DOWN";
         rotateKey = "UP";
         dropKey = "SPACE";
         pauseKey = "P";
     }

     public void initSizeSetting(){
         boardWidth = 380;
         boardHeight = 800;
         fontSize = 23;
     }

     public void initColorBlindMode(){
         isColorBlind = false;
     }

     public void initInitInterval(){
         initInterval = 1000;
     }

     public void initMode() {
         mode = Mode.NORMAL;
     }

     /**
      * ȭ�� ũ�� ����
      */
     public void btnSmallBtnActionPerformed() {
         boardWidth = 304;
         boardHeight = 640;
         fontSize = 20;
     }

     // default
     public void btnMediumBtnActionPerformed() {
         boardWidth = 380;
         boardHeight = 800;
         fontSize = 22;
     }

     public void btnLargeBtnActionPerformed() {
         boardWidth = 456;
         boardHeight = 960;
         fontSize = 24;
     }

     /**
      * ����Ű ����
      */
     public void btnLeftKeyActionPerformed(String key){
         if(key == null){
             throw new EmptyKeyException("LEFT Ű ���� �����ϴ�.");
         }
         leftKey = key;
     }

     public void btnRightKeyActionPerformed(String key){
         if(key == null){
             throw new EmptyKeyException("RIGHT Ű ���� �����ϴ�.");
         }
         rightKey = key;
     }

     public void btnDownKeyActionPerformed(String key){
         if(key == null){
             throw new EmptyKeyException("DOWN Ű ���� �����ϴ�.");
         }
         downKey = key;
     }

     public void btnDropKeyActionPerformed(String key){
         if(key == null){
             throw new EmptyKeyException("DROP Ű ���� �����ϴ�.");
         }
         dropKey = key;
     }

     public void btnRotateKeyActionPerformed(String key){
         if(key == null){
             throw new EmptyKeyException("ROTATE Ű ���� �����ϴ�.");
         }
         rotateKey = key;
     }

     /**
      * ���� ���
      */
     public void btnColorBlindOnActionPerformed() {

     }

     public void btnColorBlindOffActionPerformed() {

     }

     /**
      * ���ھ�� �ʱ�ȭ
      */
     public void btnInitScoreBoardActionPerformed(){
         // score board init logic
    	 sb = new ScoreBoardFile();
    	 try {
			sb.eraseFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
     }

     /**
      * ���̵� ���
      */
     public void btnEasyModeActionPerformed(){
         initInterval = 1200;
         mode = Mode.EASY;
     }

     public void btnNormalModeActionPerformed(){
         initInterval = 1000;
         mode = Mode.NORMAL;
     }

     public void btnHardModeActionPerformed(){
         initInterval = 800;
         mode = Mode.HARD;
     }



     /**
      * ���� �ҷ�����
      */


     /**
      * ���� ����
      */
     public void btnSaveSettingActionPerformed() throws IOException {
    	 settingfile = new SettingFile();
         settingfile.saveSetting(1);
         JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "������ ����Ǿ����ϴ�.");
     }

     public String getLeftKey() {
         return leftKey;
     }

     public String getRightKey() {
         return rightKey;
     }

     public String getDownKey() {
         return downKey;
     }

     public String getRotateKey() {
         return rotateKey;
     }

     public String getDropKey() {
         return dropKey;
     }

     public String getPauseKey() {
         return pauseKey;
     }

     public int getBoardWidth() {
         return boardWidth;
     }

     public int getBoardHeight() {
         return boardHeight;
     }

     public int getFontSize() {
         return fontSize;
     }

     public boolean isColorBlind() {
         return isColorBlind;
     }

     public int getInitInterval() {
         return initInterval;
     }

     public Mode getMode(){
         return mode;
     }
 }