
package ir.nikagram.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import co.ronash.pushe.Pushe;

public class AppStartReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, Intent intent) {
        AndroidUtilities.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                Pushe.initialize(context,true);
            }
        });
    }
}
