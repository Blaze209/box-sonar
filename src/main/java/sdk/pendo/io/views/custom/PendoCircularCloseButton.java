package sdk.pendo.io.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.c2.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes5.dex */
public final class PendoCircularCloseButton extends View implements ActionableBlock, PendoCustomView, View.OnClickListener {
    private int mCircleColor;
    private Paint mCirclePaint;
    private int mCircleStrokeColor;
    private Paint mCircleStrokePaint;
    private float mCircleWidth;
    private List<PendoCommand> mCommands;
    private int mXColor;
    private Paint mXPaint;
    private float mXWidth;

    public PendoCircularCloseButton(Context context) {
        this(context, null);
    }

    private void init(AttributeSet attributeSet, int i) {
        setContentDescription(getContext().getString(R.string.pnd_close_button_accessibility_description));
        setBackgroundColor(0);
        setOnClickListener(this);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.pnd_CircularCloseButton, i, 0);
        this.mXColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pnd_CircularCloseButton_pnd_guideXColor, -16777216);
        this.mCircleStrokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pnd_CircularCloseButton_pnd_guideFrameColor, -16777216);
        this.mCircleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pnd_CircularCloseButton_pnd_guideCircleColor, -1);
        this.mXWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.pnd_CircularCloseButton_pnd_guideXWidth, getResources().getDimension(R.dimen.pnd_circle_close_button_width));
        this.mCircleWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.pnd_CircularCloseButton_pnd_guideFrameWidth, getResources().getDimension(R.dimen.pnd_circle_close_button_width));
        this.mXPaint = new Paint(1);
        this.mCircleStrokePaint = new Paint(1);
        this.mCirclePaint = new Paint(1);
        this.mXPaint.setColor(this.mXColor);
        this.mCircleStrokePaint.setColor(this.mCircleStrokeColor);
        this.mCirclePaint.setColor(this.mCircleColor);
        this.mXPaint.setStyle(Paint.Style.STROKE);
        this.mCircleStrokePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        this.mXPaint.setStrokeWidth(this.mXWidth);
        this.mCircleStrokePaint.setStrokeWidth(this.mCircleWidth);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public CharSequence getElementId() {
        return getContentDescription();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public b<ActionableBlock.OnSubmitAction, String> getOnSubmit() {
        return b.a(ActionableBlock.OnSubmitAction.CLOSE, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<PendoCommand> list = this.mCommands;
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(this.mCommands);
            PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.UserEventType.TAP_ON, true);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getHeight() / 3.0f, this.mCirclePaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getHeight() / 3.0f, this.mCircleStrokePaint);
        canvas.drawLine(getWidth() / 3.0f, getHeight() / 3.0f, (getWidth() * 2) / 3.0f, (getHeight() * 2) / 3.0f, this.mXPaint);
        canvas.drawLine(getWidth() / 3.0f, (getWidth() * 2) / 3.0f, (getWidth() * 2) / 3.0f, getHeight() / 3.0f, this.mXPaint);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        invalidate();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setActions(List<PendoCommand> list) {
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            this.mCommands = list;
        }
    }

    public void setCircleColor(int i) {
        this.mCircleColor = i;
        this.mCirclePaint.setColor(i);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setOnSubmit(String str) {
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mCircleStrokeColor = i;
        this.mCircleStrokePaint.setColor(i);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        float f = i;
        this.mCircleWidth = f;
        this.mCircleStrokePaint.setStrokeWidth(f);
    }

    public void setXColor(int i) {
        this.mXColor = i;
        this.mXPaint.setColor(i);
    }

    public void setXWidth(int i) {
        float f = i;
        this.mXWidth = f;
        this.mXPaint.setStrokeWidth(f);
    }

    public PendoCircularCloseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PendoCircularCloseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCommands = null;
        init(attributeSet, i);
    }
}
