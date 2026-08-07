package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.f7;
import com.pspdfkit.internal.hn;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPasswordView extends LinearLayoutCompat implements FloatingHintEditText.EditTextListener {
    private static final float FOCUS_OFF_ALPHA = 0.25f;
    private static final float FOCUS_ON_ALPHA = 1.0f;
    private int color;
    private Animation errorAnimation;
    private int errorColor;
    private int floatingHintColor;
    private boolean hasPasswordEditTextFocus;
    private int hintColor;
    private ImageView icon;
    private int iconResourceId;
    private boolean isIconTintingEnabled;
    private OnPasswordSubmitListener onPasswordSubmitListener;
    private Integer originalSoftInputMode;
    private FloatingHintPasswordEditText passwordEditText;

    public interface OnPasswordSubmitListener {
        void onPasswordSubmit(PdfPasswordView pdfPasswordView, String str);
    }

    public PdfPasswordView(Context context) {
        super(context);
        this.hasPasswordEditTextFocus = false;
        this.originalSoftInputMode = null;
        init(context, null);
    }

    private void animateIcon(boolean z) {
        if (this.icon.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 1.0f : 0.25f, z ? 0.25f : 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.icon.startAnimation(alphaAnimation);
        }
    }

    private void applyTheme() {
        int i = this.iconResourceId;
        ImageView imageView = this.icon;
        if (i != -1) {
            imageView.setVisibility(0);
            this.icon.setImageResource(this.iconResourceId);
            boolean z = this.isIconTintingEnabled;
            ImageView imageView2 = this.icon;
            if (z) {
                imageView2.setColorFilter(this.color);
            } else {
                imageView2.clearColorFilter();
            }
        } else {
            imageView.setVisibility(8);
        }
        this.passwordEditText.setPrimaryColor(this.color);
        this.passwordEditText.setTextColor(this.color);
        this.passwordEditText.setHintColor(this.hintColor);
        this.passwordEditText.setErrorColor(this.errorColor);
        this.passwordEditText.setFloatingHintColor(this.floatingHintColor);
    }

    private Animation getErrorAnimation() {
        if (this.errorAnimation == null) {
            this.errorAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.pspdf__shake_view);
        }
        return this.errorAnimation;
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(getResources().getConfiguration().orientation == 2 ? 0 : 1);
        setFocusableInTouchMode(true);
        setFitsSystemWindows(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.pspdf__PasswordView, R.attr.pspdf__passwordViewStyle, R.style.PSPDFKit_PasswordView);
        this.color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PasswordView_pspdf__color, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.hintColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PasswordView_pspdf__hintColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.errorColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PasswordView_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        this.floatingHintColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PasswordView_pspdf__floatingHintColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.iconResourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__PasswordView_pspdf__icon, -1);
        this.isIconTintingEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.pspdf__PasswordView_pspdf__iconTintingEnabled, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.pspdf__password_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.pspdf__fragment_password_icon);
        this.icon = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.PdfPasswordView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        FloatingHintPasswordEditText floatingHintPasswordEditText = (FloatingHintPasswordEditText) findViewById(R.id.pspdf__fragment_password);
        this.passwordEditText = floatingHintPasswordEditText;
        floatingHintPasswordEditText.setPdfEditTextListener(this);
        this.passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.PdfPasswordView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.lambda$init$1(view, z);
            }
        });
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.PdfPasswordView$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$init$2(textView, i, keyEvent);
            }
        });
        applyTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        if (this.hasPasswordEditTextFocus ? notifyPasswordSubmit() : false) {
            return;
        }
        toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view, boolean z) {
        boolean z2 = this.hasPasswordEditTextFocus;
        if (z != z2) {
            if (z2 ? notifyPasswordSubmit() : false) {
                showKeyboard(false);
            } else {
                toggle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        if (notifyPasswordSubmit()) {
            return true;
        }
        toggle();
        return true;
    }

    private boolean notifyPasswordSubmit() {
        OnPasswordSubmitListener onPasswordSubmitListener;
        String password = getPassword();
        if (password.isEmpty() || (onPasswordSubmitListener = this.onPasswordSubmitListener) == null) {
            return false;
        }
        onPasswordSubmitListener.onPasswordSubmit(this, password);
        return true;
    }

    private void restoreSoftInputMode() {
        if (this.originalSoftInputMode != null) {
            hn.a(getContext(), this.originalSoftInputMode.intValue());
            this.originalSoftInputMode = null;
        }
    }

    private void showKeyboard(boolean z) {
        FloatingHintPasswordEditText floatingHintPasswordEditText = this.passwordEditText;
        if (z) {
            hn.a(floatingHintPasswordEditText, (f7) null);
        } else {
            hn.c(floatingHintPasswordEditText);
        }
    }

    private void toggle() {
        toggle(true);
    }

    @Override // com.pspdfkit.ui.FloatingHintEditText.EditTextListener
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(new Rect(rect));
        return false;
    }

    public int getColor() {
        return this.color;
    }

    public int getErrorColor() {
        return this.errorColor;
    }

    public int getFloatingHintColor() {
        return this.floatingHintColor;
    }

    public int getHintColor() {
        return this.hintColor;
    }

    public int getIconResourceId() {
        return this.iconResourceId;
    }

    public String getPassword() {
        return this.passwordEditText.getText().toString();
    }

    @Override // android.view.View
    public IBinder getWindowToken() {
        FloatingHintPasswordEditText floatingHintPasswordEditText = this.passwordEditText;
        if (floatingHintPasswordEditText == null) {
            return null;
        }
        return floatingHintPasswordEditText.getWindowToken();
    }

    public boolean isIconTintingEnabled() {
        return this.isIconTintingEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        restoreSoftInputMode();
    }

    @Override // com.pspdfkit.ui.FloatingHintEditText.EditTextListener
    public void onErrorDismissed() {
        if (this.isIconTintingEnabled) {
            this.icon.setColorFilter(this.color);
            invalidate();
        }
    }

    @Override // com.pspdfkit.ui.FloatingHintEditText.EditTextListener
    public void onKeyPress(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.hasPasswordEditTextFocus) {
            toggle(false);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.passwordEditText.requestFocus();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.passwordEditText.requestFocus();
        }
    }

    public void setColor(int i) {
        this.color = i;
        applyTheme();
    }

    public void setErrorColor(int i) {
        this.errorColor = i;
        applyTheme();
    }

    public void setFloatingHintColor(int i) {
        this.floatingHintColor = i;
        applyTheme();
    }

    public void setHintColor(int i) {
        this.hintColor = i;
        applyTheme();
    }

    public void setIconResourceId(int i) {
        this.iconResourceId = i;
        applyTheme();
    }

    public void setIconTintingEnabled(boolean z) {
        this.isIconTintingEnabled = z;
        applyTheme();
    }

    public void setOnPasswordSubmitListener(OnPasswordSubmitListener onPasswordSubmitListener) {
        this.onPasswordSubmitListener = onPasswordSubmitListener;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.originalSoftInputMode = Integer.valueOf(hn.a(getContext(), 37));
            this.passwordEditText.requestFocus();
            hn.a(this.passwordEditText, 2, (hn.d) null);
        } else if (i == 8 || i == 4) {
            restoreSoftInputMode();
        }
    }

    public void showPasswordError() {
        this.passwordEditText.showError();
        startAnimation(getErrorAnimation());
        if (this.isIconTintingEnabled) {
            this.icon.setColorFilter(this.errorColor);
        }
    }

    private void toggle(boolean z) {
        boolean z2 = this.hasPasswordEditTextFocus;
        this.hasPasswordEditTextFocus = !z2;
        FloatingHintPasswordEditText floatingHintPasswordEditText = this.passwordEditText;
        if (z2) {
            floatingHintPasswordEditText.clearFocus();
        } else {
            floatingHintPasswordEditText.requestFocus();
        }
        if (z) {
            showKeyboard(this.hasPasswordEditTextFocus);
        }
        animateIcon(this.hasPasswordEditTextFocus);
    }

    public PdfPasswordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasPasswordEditTextFocus = false;
        this.originalSoftInputMode = null;
        init(context, attributeSet);
    }

    public PdfPasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasPasswordEditTextFocus = false;
        this.originalSoftInputMode = null;
        init(context, attributeSet);
    }
}
