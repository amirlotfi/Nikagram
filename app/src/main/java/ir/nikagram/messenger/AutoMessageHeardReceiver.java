
package ir.nikagram.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoMessageHeardReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ApplicationLoader.postInitApplication();
        long dialog_id = intent.getLongExtra("dialog_id", 0);
        int max_id = intent.getIntExtra("max_id", 0);
        if (dialog_id == 0 || max_id == 0) {
            return;
        }
        MessagesController.getInstance().markDialogAsRead(dialog_id, max_id, max_id, 0, true, false);
    }
}
