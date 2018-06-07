package com.example.auspicious.preparation.Views;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class EmptyView extends View {
    private Context context;
    private Paint paint;

    private void init(Context context){
        this.context = context;
        this.paint = new Paint();
        this.paint.setColor(Color.BLACK);
        this.paint.setStrokeWidth(5);
    }
    public EmptyView(Context context) {
        super(context);
        init(context);
    }
    public EmptyView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 100, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(0, 0, 0, 200, paint);
        canvas.drawLine(0, 200, 200, 200, paint);
        canvas.drawLine(200, 200, 200, 0, paint);
        canvas.drawLine(200, 0, 0, 0, paint);
        paint.setColor(Color.BLACK);
    }
}
