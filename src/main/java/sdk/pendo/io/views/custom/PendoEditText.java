package sdk.pendo.io.views.custom;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes5.dex */
public final class PendoEditText extends AppCompatEditText implements PendoCustomView, ViewBaseScriptBridge.TextFieldScriptBridge {
    private int mBackgroundColor;
    private final GradientDrawable mBackgroundDrawable;
    private float[] mCornerRadii;
    private int mStrokeColor;
    private int mStrokeWidth;

    public PendoEditText(Context context) {
        this(context, null);
    }

    private void adjustTextPadding(int i) {
        setPadding(getPaddingLeft() + i, getPaddingTop() + i, getPaddingRight() + i, getPaddingBottom() + i);
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge.TextFieldScriptBridge
    public String getTextFieldResponse() {
        return getText() != null ? getText().toString() : "";
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public String getType() {
        return "PendoEditText";
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public ViewBaseScriptBridge getViewScriptBridge() {
        return this;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            clearFocus();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        this.mBackgroundDrawable.setColor(this.mBackgroundColor);
        int i = this.mStrokeWidth;
        if (i > 0) {
            this.mBackgroundDrawable.setStroke(i, this.mStrokeColor);
        }
        float[] fArr = this.mCornerRadii;
        if (fArr != null) {
            this.mBackgroundDrawable.setCornerRadii(fArr);
        }
        setBackground(this.mBackgroundDrawable);
        setGravity(48);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
        if (fArr != null) {
            this.mCornerRadii = (float[]) fArr.clone();
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
        this.mCornerRadii = new float[]{f, f, f, f, f, f, f, f};
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        adjustTextPadding(i);
    }

    public PendoEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public PendoEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBackgroundColor = 0;
        this.mBackgroundDrawable = new GradientDrawable();
    }
}
