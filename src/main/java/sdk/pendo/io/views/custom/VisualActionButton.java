package sdk.pendo.io.views.custom;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.j4.b;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n3.a;
import sdk.pendo.io.s7.t0;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes5.dex */
public final class VisualActionButton extends AppCompatButton implements ActionableBlock, PendoCustomView {
    public static final int DISABLED_STATE_POSITION = 1;
    public static final int NORMAL_STATE_POSITION = 2;
    public static final int NUMBER_OF_STATES = 3;
    public static final int PRESSED_STATE_POSITION = 0;
    public static final String TAG = "VisualActionButton";
    public static final t0 VOID_TRIGGER = new t0();
    private final o<t0> clickObserver;
    private final b<t0> clickSubject;
    int[] mButtonTextColors;
    private List<PendoCommand> mCommands;
    private float[] mCornerRadii;
    private GradientDrawable mDisabledBackgroundDrawable;
    private GradientDrawable mNormalBackgroundDrawable;
    private String mOnSubmit;
    private GradientDrawable mPressedBackgroundDrawable;
    private final Set<String> mRecentlyDispatchedCommandIds;
    private StateListDrawable mStateListDrawable;
    int[][] mStates;
    private int mStrokeColor;
    private int mStrokeWidth;
    boolean setDisabledTextColor;
    boolean setPressedTextColor;

    public VisualActionButton(Context context) {
        this(context, null);
    }

    private void generateStateListDrawableBackground() {
        this.mStateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = this.mPressedBackgroundDrawable;
        if (gradientDrawable != null) {
            ((GradientDrawable) gradientDrawable.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mPressedBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[]{R.attr.state_pressed}, this.mPressedBackgroundDrawable);
        }
        GradientDrawable gradientDrawable2 = this.mDisabledBackgroundDrawable;
        if (gradientDrawable2 != null) {
            ((GradientDrawable) gradientDrawable2.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mDisabledBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[]{-16842910}, this.mDisabledBackgroundDrawable);
        }
        GradientDrawable gradientDrawable3 = this.mNormalBackgroundDrawable;
        if (gradientDrawable3 != null) {
            ((GradientDrawable) gradientDrawable3.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mNormalBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[0], this.mNormalBackgroundDrawable);
        }
        setBackground(this.mStateListDrawable);
    }

    private boolean setColorsIfNeeded() {
        int[] iArr = this.mButtonTextColors;
        boolean z = false;
        if (iArr != null) {
            if (!this.setPressedTextColor) {
                iArr[0] = iArr[2];
            }
            z = true;
            if (!this.setDisabledTextColor) {
                iArr[1] = iArr[2];
            }
        }
        return z;
    }

    private boolean shouldChangeDefaultBackground() {
        return (this.mNormalBackgroundDrawable == null && this.mPressedBackgroundDrawable == null && this.mDisabledBackgroundDrawable == null) ? false : true;
    }

    public void executeClick() {
        List<PendoCommand> list = this.mCommands;
        if (list == null || list.isEmpty()) {
            PendoLogger.d(TAG, "No commands.");
            return;
        }
        ArrayList arrayList = new ArrayList(this.mCommands);
        arrayList.removeIf(new Predicate() { // from class: sdk.pendo.io.views.custom.VisualActionButton$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m16867xa98efea2((PendoCommand) obj);
            }
        });
        if (arrayList.isEmpty()) {
            PendoLogger.d(TAG, "All commands were recently dispatched, skipping.");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mRecentlyDispatchedCommandIds.add(((PendoCommand) it.next()).getCommandId());
        }
        JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(arrayList);
        PendoCommandDispatcher.getInstance().dispatchCommands(arrayList, PendoCommandEventType.UserEventType.TAP_ON, true);
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public CharSequence getElementId() {
        return getContentDescription();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public sdk.pendo.io.c2.b<ActionableBlock.OnSubmitAction, String> getOnSubmit() {
        String str = this.mOnSubmit;
        if (str != null) {
            ActionableBlock.OnSubmitAction onSubmitAction = ActionableBlock.OnSubmitAction.CLOSE;
            if (str.equals(onSubmitAction.getOnSubmitActionName())) {
                return sdk.pendo.io.c2.b.a(onSubmitAction, null);
            }
            String str2 = this.mOnSubmit;
            ActionableBlock.OnSubmitAction onSubmitAction2 = ActionableBlock.OnSubmitAction.CHANGE_SCREEN;
            if (str2.startsWith(onSubmitAction2.getOnSubmitActionName())) {
                try {
                    return sdk.pendo.io.c2.b.a(onSubmitAction2, ActionableBlock.OnSubmitAction.getChangeScreenId(this.mOnSubmit));
                } catch (IllegalStateException e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            }
        }
        return sdk.pendo.io.c2.b.a(ActionableBlock.OnSubmitAction.CLOSE, null);
    }

    /* JADX INFO: renamed from: lambda$executeClick$0$sdk-pendo-io-views-custom-VisualActionButton, reason: not valid java name */
    /* synthetic */ boolean m16867xa98efea2(PendoCommand pendoCommand) {
        boolean zContains = this.mRecentlyDispatchedCommandIds.contains(pendoCommand.getCommandId());
        if (zContains) {
            PendoLogger.d(TAG, "Skipping duplicate command: " + pendoCommand.getCommandId());
        }
        return zContains;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<PendoCommand> list = this.mCommands;
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            this.clickSubject.onNext(VOID_TRIGGER);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (setColorsIfNeeded()) {
            setTextColor(new ColorStateList(this.mStates, this.mButtonTextColors));
        }
        if (shouldChangeDefaultBackground()) {
            generateStateListDrawableBackground();
        }
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

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
        this.mCornerRadii = (float[]) fArr.clone();
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
        this.mCornerRadii = new float[]{f, f, f, f, f, f, f, f};
    }

    public void setDisabledBackgroundColor(int i) {
        if (this.mDisabledBackgroundDrawable == null) {
            this.mDisabledBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mDisabledBackgroundDrawable.mutate()).setColor(i);
    }

    public void setDisabledTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[1] = i;
        this.setDisabledTextColor = true;
    }

    public void setNormalBackgroundColor(int i) {
        if (this.mNormalBackgroundDrawable == null) {
            this.mNormalBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mNormalBackgroundDrawable.mutate()).setColor(i);
    }

    public void setNormalTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[2] = i;
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setOnSubmit(String str) {
        this.mOnSubmit = str;
    }

    public void setPressedBackgroundColor(int i) {
        if (this.mPressedBackgroundDrawable == null) {
            this.mPressedBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mPressedBackgroundDrawable.mutate()).setColor(i);
    }

    public void setPressedTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[0] = i;
        this.setPressedTextColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public VisualActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public VisualActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b<t0> bVarM = b.m();
        this.clickSubject = bVarM;
        o<t0> oVar = new o<t0>() { // from class: sdk.pendo.io.views.custom.VisualActionButton.1
            @Override // sdk.pendo.io.k3.o
            public void onComplete() {
            }

            @Override // sdk.pendo.io.k3.o
            public void onError(Throwable th) {
            }

            @Override // sdk.pendo.io.k3.o
            public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            }

            @Override // sdk.pendo.io.k3.o
            public void onNext(t0 t0Var) {
                VisualActionButton.this.executeClick();
            }
        };
        this.clickObserver = oVar;
        this.mStates = new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]};
        this.mCommands = null;
        this.mRecentlyDispatchedCommandIds = ConcurrentHashMap.newKeySet();
        bVarM.a(a.a()).e(1000L, TimeUnit.MILLISECONDS).a(oVar);
        setOnClickListener(this);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: sdk.pendo.io.views.custom.VisualActionButton.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                accessibilityEvent.getText().add(VisualActionButton.this.getContentDescription());
            }
        });
    }
}
