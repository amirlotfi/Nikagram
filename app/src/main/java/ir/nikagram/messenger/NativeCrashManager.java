package ir.nikagram.messenger;

import android.app.Activity;
import android.net.Uri;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class NativeCrashManager {

    public static String createLogFile() {
        final Date now = new Date();

        try {
            String filename = UUID.randomUUID().toString();
            return filename + ".faketrace";
        } catch (Exception e) {
            FileLog.e("tmessages", e);
        }

        return null;
    }

    public static void uploadDumpAndLog(final Activity activity, final String identifier, final String dumpFilename, final String logFilename) {
        new Thread() {
            @Override
            public void run() {
            }
        }.start();
    }

}
