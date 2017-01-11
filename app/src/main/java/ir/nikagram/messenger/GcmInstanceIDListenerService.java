
package ir.nikagram.messenger;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

public class GcmInstanceIDListenerService extends InstanceIDListenerService {

    @Override
    public void onTokenRefresh() {
        AndroidUtilities.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                ApplicationLoader.postInitApplication();
                Intent intent = new Intent(ApplicationLoader.applicationContext, GcmRegistrationIntentService.class);
                startService(intent);
            }
        });
    }
}
