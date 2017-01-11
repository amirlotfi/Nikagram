package ir.nikagram.Nika.Helper;

import ir.nikagram.Nika.Setting.Setting;
import ir.nikagram.messenger.MessagesController;

public class GhostPorotocol {
    public static void toggleGhostPortocol(){
        boolean m=!Setting.getGhostMode();
        trun(m);
    }
    public static void update(){
        boolean m=Setting.getGhostMode();
        trun(m);
    }
    public static void trun(boolean on){
        Setting.setGhostMode(on);
        if(on){
            NotiFicationMaker.createNotification();
        }else{
            NotiFicationMaker.cancelNotification();
        }
        MessagesController.getInstance().reRunUpdateTimerProc();

    }

}
