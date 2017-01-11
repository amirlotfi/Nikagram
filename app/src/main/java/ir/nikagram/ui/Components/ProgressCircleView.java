
package ir.nikagram.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ProgressCircleView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ProgressCircleView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
