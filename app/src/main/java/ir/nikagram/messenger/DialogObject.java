
package ir.nikagram.messenger;

import ir.nikagram.tgnet.TLRPC;

public class DialogObject {

    public static boolean isChannel(TLRPC.TL_dialog dialog) {
        return dialog != null && (dialog.flags & 1) != 0;
    }
}
