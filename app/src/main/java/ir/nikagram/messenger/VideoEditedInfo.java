
package ir.nikagram.messenger;

import java.util.Locale;

public class VideoEditedInfo {
    public long startTime;
    public long endTime;
    public int rotationValue;
    public int originalWidth;
    public int originalHeight;
    public int resultWidth;
    public int resultHeight;
    public int bitrate;
    public String originalPath;

    public String getString() {
        return String.format(Locale.US, "-1_%d_%d_%d_%d_%d_%d_%d_%d_%s", startTime, endTime, rotationValue, originalWidth, originalHeight, bitrate, resultWidth, resultHeight, originalPath);
    }

    public boolean parseString(String string) {
        if (string.length() < 6) {
            return false;
        }
        try {
            String args[] = string.split("_");
            if (args.length >= 10) {
                startTime = Long.parseLong(args[1]);
                endTime = Long.parseLong(args[2]);
                rotationValue = Integer.parseInt(args[3]);
                originalWidth = Integer.parseInt(args[4]);
                originalHeight = Integer.parseInt(args[5]);
                bitrate = Integer.parseInt(args[6]);
                resultWidth = Integer.parseInt(args[7]);
                resultHeight = Integer.parseInt(args[8]);
                for (int a = 9; a < args.length; a++) {
                    if (originalPath == null) {
                        originalPath = args[a];
                    } else {
                        originalPath += "_" + args[a];
                    }
                }
            }
            return true;
        } catch (Exception e) {
            FileLog.e("tmessages", e);
        }
        return false;
    }
}
