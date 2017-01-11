
package ir.nikagram.ui.Components;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

import ir.nikagram.messenger.AndroidUtilities;

public class ChipSpan extends ImageSpan {

    public int uid;

    public ChipSpan(Drawable d, int verticalAlignment) {
        super(d, verticalAlignment);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        if (fm == null) {
            fm = new Paint.FontMetricsInt();
        }

        int sz = super.getSize(paint, text, start, end, fm);
        int offset = AndroidUtilities.dp(6);
        int w = (fm.bottom - fm.top) / 2;
        fm.top = -w - offset;
        fm.bottom = w - offset;
        fm.ascent = -w - offset;
        fm.leading = 0;
        fm.descent = w - offset;
        return sz;
    }
}
