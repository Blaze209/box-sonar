package com.pspdfkit.ui;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.c30;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingHintEditText extends LocalizedEditText {
    private static final int VALUE_ANIMATOR_DURATION = 300;
    private final ArgbEvaluator argbEvaluator;
    private int bottomSpace;
    private int errorColor;
    private View.OnFocusChangeListener externalFocusChangeListener;
    private int floatingHintColor;
    private float floatingHintRatioAlpha;
    private float floatingHintRatioY;
    private boolean floatingHintShown;
    private String floatingHintText;
    private int floatingHintTextSize;
    private View.OnFocusChangeListener focusChangeListener;
    private ValueAnimator hintAnimator;
    private ColorStateList hintColorStateList;
    private ValueAnimator hintFocusAnimator;
    private EditTextListener listener;
    private int offsetPaddingBottom;
    private int offsetPaddingTop;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private final Paint paint;
    private int primaryColor;
    private boolean showingError;
    private ColorStateList textColorStateList;
    private final TextPaint textPaint;

    public interface EditTextListener {
        void afterTextChanged(Editable editable);

        void onErrorDismissed();

        void onKeyPress(int i, KeyEvent keyEvent);
    }

    public FloatingHintEditText(Context context) {
        super(context);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, null, null);
    }

    private void drawBottomLine(Canvas canvas) {
        int pixel;
        int height = ((getHeight() + getScrollY()) - getPaddingBottom()) + this.bottomSpace;
        if (this.showingError) {
            this.paint.setColor(this.errorColor);
            pixel = getPixel(2);
        } else if (isEnabled()) {
            boolean zHasFocus = hasFocus();
            Paint paint = this.paint;
            if (zHasFocus) {
                paint.setColor(this.primaryColor);
                pixel = getPixel(2);
            } else {
                paint.setColor(this.primaryColor);
                pixel = getPixel(1);
            }
        } else {
            this.paint.setColor(this.primaryColor);
            pixel = getPixel(1);
        }
        canvas.drawRect(getScrollX(), height, getWidth() + getScrollX(), height + pixel, this.paint);
    }

    private void drawFloatingHint(Canvas canvas) {
        if (TextUtils.isEmpty(this.floatingHintText)) {
            return;
        }
        this.textPaint.setTextSize(this.floatingHintTextSize);
        boolean z = this.showingError;
        TextPaint textPaint = this.textPaint;
        if (z) {
            textPaint.setColor(((Integer) this.argbEvaluator.evaluate(this.floatingHintRatioAlpha * (isEnabled() ? 1.0f : 0.0f), Integer.valueOf(this.errorColor), Integer.valueOf(this.errorColor))).intValue());
        } else {
            textPaint.setColor(((Integer) this.argbEvaluator.evaluate(this.floatingHintRatioAlpha * (isEnabled() ? 1.0f : 0.0f), Integer.valueOf(this.floatingHintColor), Integer.valueOf(this.floatingHintColor))).intValue());
        }
        int i = this.paddingTop + this.floatingHintTextSize;
        int i2 = this.bottomSpace;
        int scrollY = (int) (((i + i2) - (i2 * this.floatingHintRatioY)) + getScrollY());
        this.textPaint.setAlpha((int) (((this.floatingHintRatioAlpha * 0.74f * (isEnabled() ? 1.0f : 0.0f)) + 0.26f) * this.floatingHintRatioY * 255.0f));
        canvas.drawText(this.floatingHintText, getScrollX(), scrollY, this.textPaint);
    }

    private ValueAnimator getHintAnimator() {
        if (this.hintAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.hintAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.hintAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.ui.FloatingHintEditText$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$getHintAnimator$0(valueAnimator);
                }
            });
        }
        return this.hintAnimator;
    }

    private ValueAnimator getHintFocusAnimator() {
        if (this.hintFocusAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.hintFocusAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.hintFocusAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.ui.FloatingHintEditText$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$getHintFocusAnimator$1(valueAnimator);
                }
            });
        }
        return this.hintFocusAnimator;
    }

    private int getPixel(int i) {
        return a80.a(getContext(), i);
    }

    private void init(Context context, AttributeSet attributeSet, String str) {
        if (isInEditMode()) {
            return;
        }
        initStateValues(str);
        initPaddings(context, attributeSet);
        initPaddingOffsets();
        initText();
        initTextWatcher();
        initFloatingHint();
    }

    private void initFloatingHint() {
        addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.FloatingHintEditText.2
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FloatingHintEditText.this.onTextChanged(editable);
            }
        });
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.FloatingHintEditText$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.onFocusChanged(view, z);
            }
        };
        this.focusChangeListener = onFocusChangeListener;
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    private void initPaddingOffsets() {
        int i = this.floatingHintTextSize;
        int i2 = this.bottomSpace;
        this.offsetPaddingTop = i + i2;
        this.offsetPaddingBottom = i2 * 2;
        setPaddings();
    }

    private void initPaddings(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.paddingLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.paddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        this.paddingRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.paddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initStateValues(String str) {
        ViewCompat.setBackground(this, null);
        this.bottomSpace = getResources().getDimensionPixelSize(com.pspdfkit.R.dimen.pspdf__password_edit_text_default_bottom_space);
        this.errorColor = ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__errorContainerLight);
        this.floatingHintColor = ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__primaryContainerLight);
        if (str == null) {
            str = "";
        }
        this.floatingHintText = str;
        this.floatingHintTextSize = getResources().getDimensionPixelSize(com.pspdfkit.R.dimen.pspdf__password_edit_text_default_floating_hint_text_size);
        resetPrimaryColor(ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__primaryLight));
        resetHintColor(ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__outlineVariantLight));
        if (isInEditMode()) {
            return;
        }
        TextPaint textPaint = this.textPaint;
        Typeface typeface = Typeface.DEFAULT;
        textPaint.setTypeface(typeface);
        setTypeface(typeface);
    }

    private void initText() {
        if (TextUtils.isEmpty(getText())) {
            resetHintTextColor();
        } else {
            resetHintTextColor();
            setText(getText());
            setSelection(getText().length());
            this.floatingHintRatioY = 1.0f;
            this.floatingHintShown = true;
        }
        resetTextColor();
    }

    private void initTextWatcher() {
        addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.FloatingHintEditText.1
            private void dismissErrorIfShowing() {
                FloatingHintEditText floatingHintEditText = FloatingHintEditText.this;
                if (floatingHintEditText.showingError) {
                    floatingHintEditText.showError(false);
                    EditTextListener editTextListener = FloatingHintEditText.this.listener;
                    if (editTextListener != null) {
                        editTextListener.onErrorDismissed();
                    }
                }
            }

            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                dismissErrorIfShowing();
                EditTextListener editTextListener = FloatingHintEditText.this.listener;
                if (editTextListener != null) {
                    editTextListener.afterTextChanged(editable);
                }
                FloatingHintEditText.this.postInvalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHintAnimator$0(ValueAnimator valueAnimator) {
        setFloatingHintRatioY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHintFocusAnimator$1(ValueAnimator valueAnimator) {
        setFloatingHintRatioAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFocusChanged(View view, boolean z) {
        if (z) {
            getHintFocusAnimator().start();
        } else {
            getHintFocusAnimator().reverse();
        }
        View.OnFocusChangeListener onFocusChangeListener = this.externalFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTextChanged(Editable editable) {
        int length = editable.length();
        boolean z = this.floatingHintShown;
        if (length == 0) {
            if (z) {
                this.floatingHintShown = false;
                getHintAnimator().reverse();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.floatingHintShown = true;
        getHintAnimator().start();
    }

    private void resetHintColor(int i) {
        this.hintColorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, AppCompatEditText.EMPTY_STATE_SET}, new int[]{i, i});
    }

    private void resetHintTextColor() {
        setHintTextColor(this.hintColorStateList);
    }

    private void resetPrimaryColor(int i) {
        this.primaryColor = i;
        this.textColorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, AppCompatEditText.EMPTY_STATE_SET}, new int[]{i, i});
    }

    private void resetTextColor() {
        setTextColor(this.textColorStateList);
    }

    private void setFloatingHintRatioAlpha(float f) {
        this.floatingHintRatioAlpha = f;
        invalidate();
    }

    private void setFloatingHintRatioY(float f) {
        this.floatingHintRatioY = f;
        invalidate();
    }

    private void setPaddings() {
        super.setPadding(this.paddingLeft, this.paddingTop + this.offsetPaddingTop, this.paddingRight, this.paddingBottom + this.offsetPaddingBottom);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        drawBottomLine(canvas);
        drawFloatingHint(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        boolean zOnKeyPreIme = super.onKeyPreIme(i, keyEvent);
        EditTextListener editTextListener = this.listener;
        if (editTextListener != null) {
            editTextListener.onKeyPress(i, keyEvent);
        }
        return zOnKeyPreIme;
    }

    public void setErrorColor(int i) {
        this.errorColor = i;
        postInvalidate();
    }

    public void setFloatingHintColor(int i) {
        this.floatingHintColor = i;
        postInvalidate();
    }

    public void setHintColor(int i) {
        resetHintColor(i);
        resetHintTextColor();
        postInvalidate();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.focusChangeListener == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.externalFocusChangeListener = onFocusChangeListener;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        this.paddingTop = i2;
        this.paddingBottom = i4;
        this.paddingLeft = i;
        this.paddingRight = i3;
        setPaddings();
    }

    public void setPdfEditTextListener(EditTextListener editTextListener) {
        this.listener = editTextListener;
    }

    public void setPrimaryColor(int i) {
        resetPrimaryColor(i);
        postInvalidate();
    }

    public void showError() {
        if (this.showingError) {
            return;
        }
        showError(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(boolean z) {
        this.showingError = z;
        postInvalidate();
    }

    public FloatingHintEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, attributeSet, null);
    }

    public FloatingHintEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, attributeSet, null);
    }

    public FloatingHintEditText(Context context, String str) {
        super(context);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, null, str);
    }

    public FloatingHintEditText(Context context, AttributeSet attributeSet, String str) {
        super(context, attributeSet);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, attributeSet, str);
    }

    public FloatingHintEditText(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        this.argbEvaluator = new ArgbEvaluator();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        init(context, attributeSet, str);
    }
}
