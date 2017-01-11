
package ir.nikagram.ui.Cells;

import android.content.Context;
import android.view.View;

import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.R;

public class ShadowBottomSectionCell extends View {

    public ShadowBottomSectionCell(Context context) {
        super(context);
        setBackgroundResource(R.drawable.greydivider_bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(6), MeasureSpec.EXACTLY));
    }
}
