
package ir.nikagram.ui.Cells;

import android.content.Context;
import android.view.View;

import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.R;

public class ShadowSectionCell extends View {

    private int size = 12;

    public ShadowSectionCell(Context context) {
        super(context);
        setBackgroundResource(R.drawable.greydivider);
    }

    public void setSize(int value) {
        size = value;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(size), MeasureSpec.EXACTLY));
    }
}
