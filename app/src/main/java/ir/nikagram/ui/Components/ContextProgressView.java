
package ir.nikagram.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import ir.nikagram.messenger.AndroidUtilities;

public class ContextProgressView extends View {

    private Paint innerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint outerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF cicleRect = new RectF();
    private int radOffset = 0;
    private long lastUpdateTime;

    public ContextProgressView(Context context, int colorType) {
        super(context);
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setStrokeWidth(AndroidUtilities.dp(2));
        outerPaint.setStyle(Paint.Style.STROKE);
        outerPaint.setStrokeWidth(AndroidUtilities.dp(2));
        outerPaint.setStrokeCap(Paint.Cap.ROUND);

        if (colorType == 0) {
            innerPaint.setColor(0xffCAF6BF);
            outerPaint.setColor(0xff50E22B);
        } else {
            innerPaint.setColor(0xffCAF6BF);
            outerPaint.setColor(0xffffffff);
        }
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getVisibility() != VISIBLE) {
            return;
        }
        long newTime = System.currentTimeMillis();
        long dt = newTime - lastUpdateTime;
        lastUpdateTime = newTime;
        radOffset += 360 * dt / 1000.0f;

        int x = getMeasuredWidth() / 2 - AndroidUtilities.dp(9);
        int y = getMeasuredHeight() / 2 - AndroidUtilities.dp(9);
        cicleRect.set(x, y, x + AndroidUtilities.dp(18), y + AndroidUtilities.dp(18));
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, AndroidUtilities.dp(9), innerPaint);
        canvas.drawArc(cicleRect, -90 + radOffset, 90, false, outerPaint);
        invalidate();
    }
}
