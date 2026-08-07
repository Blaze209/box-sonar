package com.pspdfkit.ui.forms;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.fk;
import com.pspdfkit.internal.gk;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.of;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.z70;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class FormEditingBar extends FrameLayout implements View.OnClickListener, FormManager.OnFormElementUpdatedListener, FormManager.OnFormElementEditingModeChangeListener, FormManager.OnFormElementViewUpdatedListener {
    private static final int ANIMATION_DURATION_MS = 250;
    private Integer backgroundColor;
    private TextView clearFieldButton;
    private FormEditingController controller;
    private TextView doneButton;
    private View formsEditingBarLayout;
    private TextView formsValidationError;
    private Integer iconColor;
    private final of immersiveHelper;
    private boolean isDisplayed;
    private final go<OnFormEditingBarLifecycleListener> lifecycleListeners;
    private ImageButton nextButton;
    private Drawable nextIcon;
    private Integer nextIconResId;
    private Integer prevIconResId;
    private ImageButton previousButton;
    private Drawable previousIcon;
    private Integer textColor;

    public interface OnFormEditingBarLifecycleListener {
        void onDisplayFormEditingBar(FormEditingBar formEditingBar);

        void onPrepareFormEditingBar(FormEditingBar formEditingBar);

        void onRemoveFormEditingBar(FormEditingBar formEditingBar);
    }

    public FormEditingBar(Context context) {
        super(context);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        init(context, null, 0, 0);
    }

    private void hide() {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            of ofVar = this.immersiveHelper;
            hn.c cVar = ofVar.b;
            if (cVar != null) {
                cVar.b();
            }
            ofVar.b = null;
            Runnable runnable = ofVar.c;
            if (runnable != null) {
                removeCallbacks(runnable);
                ofVar.c = null;
            }
            final boolean z = this.immersiveHelper.a;
            hideFormValidationError();
            setTranslationY(0.0f);
            animate().translationY(getHeight()).setInterpolator(new AccelerateInterpolator()).setDuration(250L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.forms.FormEditingBar$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$2(z);
                }
            });
            FormEditingController formEditingController = this.controller;
            if (formEditingController != null) {
                formEditingController.finishEditing();
            }
            Iterator<OnFormEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
            while (it.hasNext()) {
                it.next().onRemoveFormEditingBar(this);
            }
        }
    }

    private void hideFormValidationError() {
        TextView textView = this.formsValidationError;
        if (textView != null && textView.getVisibility() == 0) {
            this.formsValidationError.animate().translationY(this.formsValidationError.getHeight()).setDuration(250L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.forms.FormEditingBar$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hideFormValidationError$4();
                }
            });
        }
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.elevation}, i, i2);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, context.getResources().getDimensionPixelOffset(com.pspdfkit.R.dimen.pspdf__form_editing_bar_elevation));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setElevation(this, dimensionPixelOffset);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindController$0() {
        show();
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hide$2(boolean z) {
        setVisibility(4);
        this.immersiveHelper.a(getContext(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideFormValidationError$4() {
        this.formsValidationError.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1() {
        Iterator<OnFormEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDisplayFormEditingBar(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showValidationError$3() {
        TextView textView = this.formsValidationError;
        textView.setTranslationY(textView.getMeasuredHeight());
        this.formsValidationError.animate().translationY(0.0f).setDuration(250L).setInterpolator(new DecelerateInterpolator());
        return true;
    }

    private void prepareForDisplay() {
        if (this.formsEditingBarLayout != null) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(com.pspdfkit.R.layout.pspdf__form_editing_bar, (ViewGroup) this, true);
        this.previousButton = (ImageButton) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__forms_navigation_button_previous);
        this.nextButton = (ImageButton) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__forms_navigation_button_next);
        this.clearFieldButton = (TextView) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__forms_clear_field_button);
        this.doneButton = (TextView) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__forms_done_button);
        this.formsValidationError = (TextView) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__forms_validation_error);
        this.formsEditingBarLayout = viewInflate.findViewById(com.pspdfkit.R.id.pspdf__form_editing_bar_layout);
        this.previousButton.setOnClickListener(this);
        this.nextButton.setOnClickListener(this);
        this.clearFieldButton.setOnClickListener(this);
        this.doneButton.setOnClickListener(this);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, com.pspdfkit.R.styleable.pspdf__FormEditingBar, com.pspdfkit.R.attr.pspdf__formEditingBarStyle, com.pspdfkit.R.style.PSPDFKit_FormEditingBar);
        int iA = f60.a(getContext(), androidx.appcompat.R.attr.colorAccent, com.pspdfkit.R.color.pspdf__primaryLight);
        int iA2 = f60.a(getContext(), R.attr.colorBackground, com.pspdfkit.R.color.pspdf__onPrimaryLight);
        Integer num = this.backgroundColor;
        int iIntValue = num != null ? num.intValue() : typedArrayObtainStyledAttributes.getColor(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__backgroundColor, iA2);
        Integer num2 = this.textColor;
        int iIntValue2 = num2 != null ? num2.intValue() : typedArrayObtainStyledAttributes.getColor(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__textColor, iA);
        Integer num3 = this.iconColor;
        int iIntValue3 = num3 != null ? num3.intValue() : typedArrayObtainStyledAttributes.getColor(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__iconsColor, iA);
        Integer num4 = this.prevIconResId;
        int iIntValue4 = num4 != null ? num4.intValue() : typedArrayObtainStyledAttributes.getResourceId(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__prevIconDrawable, com.pspdfkit.R.drawable.pspdf__ic_chevron_left);
        Integer num5 = this.nextIconResId;
        int iIntValue5 = num5 != null ? num5.intValue() : typedArrayObtainStyledAttributes.getResourceId(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__nextIconDrawable, com.pspdfkit.R.drawable.pspdf__ic_chevron_right);
        int color = typedArrayObtainStyledAttributes.getColor(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__validationErrorBackgroundColor, ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__form_validation_error_background_color));
        int color2 = typedArrayObtainStyledAttributes.getColor(com.pspdfkit.R.styleable.pspdf__FormEditingBar_pspdf__validationErrorTextColor, ContextCompat.getColor(getContext(), com.pspdfkit.R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.recycle();
        setIconsColor(iIntValue3);
        setBackgroundColor(iIntValue);
        setTextColor(iIntValue2);
        setPrevIcon(iIntValue4);
        setNextIcon(iIntValue5);
        this.formsValidationError.setBackgroundColor(color);
        this.formsValidationError.setTextColor(color2);
    }

    private void refresh() {
        FormEditingController formEditingController = this.controller;
        if (formEditingController == null || this.formsEditingBarLayout == null) {
            return;
        }
        Drawable drawable = this.previousIcon;
        if (drawable != null) {
            drawable.setAlpha(formEditingController.hasPreviousElement() ? 255 : 128);
        }
        this.previousButton.setEnabled(this.controller.hasPreviousElement());
        Drawable drawable2 = this.nextIcon;
        if (drawable2 != null) {
            drawable2.setAlpha(this.controller.hasNextElement() ? 255 : 128);
        }
        this.nextButton.setEnabled(this.controller.hasNextElement());
        this.clearFieldButton.setEnabled(this.controller.canClearFormField());
    }

    private void setPrimaryTextColor(TextView textView, int i) {
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, FrameLayout.EMPTY_STATE_SET}, new int[]{i, textView.getTextColors() != null ? textView.getTextColors().getColorForState(FrameLayout.EMPTY_STATE_SET, i) : i}));
    }

    private void show() {
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        setVisibility(0);
        animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(250L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.forms.FormEditingBar$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$1();
            }
        });
        of ofVar = this.immersiveHelper;
        Context context = getContext();
        ofVar.getClass();
        context.getClass();
        fk fkVarA = gk.a(context);
        if (fkVarA != null && fkVarA.c) {
            ofVar.d = gk.a(context, ofVar.d);
        }
        Iterator<OnFormEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPrepareFormEditingBar(this);
        }
    }

    private void showValidationError(String str) {
        TextView textView = this.formsValidationError;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        if (this.formsValidationError.getVisibility() != 0) {
            this.formsValidationError.setVisibility(0);
            TextView textView2 = this.formsValidationError;
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.pspdfkit.ui.forms.FormEditingBar$$ExternalSyntheticLambda2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return this.f$0.lambda$showValidationError$3();
                }
            };
            textView2.getClass();
            textView2.getViewTreeObserver().addOnPreDrawListener(new z70(textView2, onPreDrawListener));
        }
    }

    public void addOnFormEditingBarLifecycleListener(OnFormEditingBarLifecycleListener onFormEditingBarLifecycleListener) {
        uw.a(onFormEditingBarLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.lifecycleListeners.a(onFormEditingBarLifecycleListener);
    }

    public void bindController(FormEditingController formEditingController) {
        this.controller = formEditingController;
        formEditingController.getFormManager().addOnFormElementUpdatedListener(this);
        formEditingController.getFormManager().addOnFormElementEditingModeChangeListener(this);
        formEditingController.getFormManager().addOnFormElementViewUpdatedListener(this);
        this.immersiveHelper.a(this, new Runnable() { // from class: com.pspdfkit.ui.forms.FormEditingBar$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$bindController$0();
            }
        });
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, 0, rect.right, rect.bottom);
        return false;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public int getIconsColor() {
        return this.iconColor.intValue();
    }

    public int getNextIcon() {
        return this.nextIconResId.intValue();
    }

    public int getPrevIcon() {
        return this.prevIconResId.intValue();
    }

    public int getTextColor() {
        return this.textColor.intValue();
    }

    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        hideFormValidationError();
        refresh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FormEditingController formEditingController = this.controller;
        if (formEditingController == null) {
            return;
        }
        if (view == this.previousButton) {
            formEditingController.selectPreviousFormElement();
            return;
        }
        if (view == this.nextButton) {
            formEditingController.selectNextFormElement();
        } else if (view == this.doneButton) {
            formEditingController.finishEditing();
        } else if (view == this.clearFieldButton) {
            formEditingController.clearFormField();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onEnterFormElementEditingMode(FormEditingController formEditingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onExitFormElementEditingMode(FormEditingController formEditingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementUpdatedListener
    public void onFormElementUpdated(FormElement formElement) {
        refresh();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public void onFormElementValidationFailed(FormElement formElement, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        showValidationError(str);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public void onFormElementValidationSuccess(FormElement formElement) {
        hideFormValidationError();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public void onFormElementViewUpdated(FormElement formElement) {
        refresh();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.isDisplayed) {
            return;
        }
        setTranslationY(getMeasuredHeight());
    }

    public void removeOnFormEditingBarLifecycleListener(OnFormEditingBarLifecycleListener onFormEditingBarLifecycleListener) {
        uw.a(onFormEditingBarLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.lifecycleListeners.b(onFormEditingBarLifecycleListener);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        View view = this.formsEditingBarLayout;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    public void setIconsColor(int i) {
        this.iconColor = Integer.valueOf(i);
    }

    public void setNextIcon(int i) {
        this.nextIconResId = Integer.valueOf(i);
        Drawable drawableB = a80.b(getContext(), i);
        this.nextIcon = drawableB;
        if (drawableB != null) {
            int iIntValue = this.iconColor.intValue();
            Drawable drawableWrap = DrawableCompat.wrap(drawableB);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, iIntValue);
            this.nextIcon = drawableWrap;
        }
        ImageButton imageButton = this.nextButton;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.nextIcon);
        }
    }

    public void setPrevIcon(int i) {
        this.prevIconResId = Integer.valueOf(i);
        Drawable drawableB = a80.b(getContext(), i);
        this.previousIcon = drawableB;
        if (drawableB != null) {
            int iIntValue = this.iconColor.intValue();
            Drawable drawableWrap = DrawableCompat.wrap(drawableB);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, iIntValue);
            this.previousIcon = drawableWrap;
        }
        ImageButton imageButton = this.previousButton;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.previousIcon);
        }
    }

    public void setTextColor(int i) {
        this.textColor = Integer.valueOf(i);
        TextView textView = this.clearFieldButton;
        if (textView != null) {
            setPrimaryTextColor(textView, i);
        }
        TextView textView2 = this.doneButton;
        if (textView2 != null) {
            setPrimaryTextColor(textView2, i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            prepareForDisplay();
        }
    }

    public void unbindController() {
        of ofVar = this.immersiveHelper;
        hn.c cVar = ofVar.b;
        if (cVar != null) {
            cVar.b();
        }
        ofVar.b = null;
        Runnable runnable = ofVar.c;
        if (runnable != null) {
            removeCallbacks(runnable);
            ofVar.c = null;
        }
        FormEditingController formEditingController = this.controller;
        if (formEditingController != null) {
            formEditingController.getFormManager().removeOnFormElementUpdatedListener(this);
            this.controller.getFormManager().removeOnFormElementEditingModeChangeListener(this);
            this.controller.getFormManager().removeOnFormElementViewUpdatedListener(this);
        }
        this.controller = null;
        hide();
    }

    public boolean wasInImmersiveModeBeforeShowing() {
        return this.immersiveHelper.a;
    }

    public FormEditingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        init(context, attributeSet, 0, 0);
    }

    public FormEditingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        init(context, attributeSet, i, 0);
    }

    public FormEditingBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        init(context, attributeSet, i, i2);
    }
}
