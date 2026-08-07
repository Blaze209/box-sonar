package sdk.pendo.io.views.inserts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.b.a;
import sdk.pendo.io.b.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.custom.PendoScrollView;
import sdk.pendo.io.y5.c;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J0\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u001fj\u0002` 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001dH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0014J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lsdk/pendo/io/views/inserts/VisualGuideLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "forceNoPadding", "", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mGuideId", "", "findPendoScrollView", "Lsdk/pendo/io/views/custom/PendoScrollView;", "inflateView", "Landroid/view/View;", "stepContent", "Lsdk/pendo/io/models/StepGuideModel;", "parent", "Landroid/view/ViewGroup;", "guideId", "stepId", "visualGuideType", "Lsdk/pendo/io/actions/VisualGuideBase$VisualGuideType;", "logFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDetachedFromWindow", "onFinishInflate", "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VisualGuideLayout extends FrameLayout {
    public static final String TAG = "VisualGuideLayout";
    private String mGuideId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VisualGuideLayout(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final PendoScrollView findPendoScrollView() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this);
        while (!arrayDeque.isEmpty()) {
            View view = (View) arrayDeque.removeFirst();
            if (view instanceof PendoScrollView) {
                return (PendoScrollView) view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                    arrayDeque.add(childAt);
                }
            }
        }
        return null;
    }

    private final void logFailure(Exception e, String guideId, String stepId, VisualGuideBase.VisualGuideType visualGuideType) {
        String message = e.getMessage();
        if (guideId == null || guideId.length() == 0) {
            guideId = "no guide id";
        }
        if (stepId == null || stepId.length() == 0) {
            stepId = "no step id";
        }
        PendoLogger.e(e, message, "guideId: " + guideId + " stepId: " + stepId + " guideType: " + visualGuideType.name());
    }

    public final View inflateView(StepGuideModel stepContent, ViewGroup parent, String guideId, String stepId, VisualGuideBase.VisualGuideType visualGuideType) throws Exception {
        Intrinsics.checkNotNullParameter(stepContent, "stepContent");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        Intrinsics.checkNotNullParameter(visualGuideType, "visualGuideType");
        this.mGuideId = guideId;
        try {
            i screenContents = GuideActionConfiguration.getScreenContents(stepContent);
            try {
                if (screenContents != null && screenContents.j()) {
                    View viewA = d.a(getContext(), screenContents.e(), parent, GuideViewHolder.class, guideId, stepId);
                    if (viewA == null) {
                        throw new c("Couldn't create a view out of JSON.");
                    }
                    a.a(viewA);
                    addView(viewA);
                    if (visualGuideType == VisualGuideBase.VisualGuideType.FULL_SCREEN && !GuideActionConfiguration.hasBackdrop(screenContents)) {
                        PendoScrollView pendoScrollViewFindPendoScrollView = findPendoScrollView();
                        Integer numValueOf = pendoScrollViewFindPendoScrollView != null ? Integer.valueOf(pendoScrollViewFindPendoScrollView.getMBackgroundColor()) : null;
                        PendoLogger.i("VisualGuideLayout -> retrieved PendoScrollView background: " + numValueOf, new Object[0]);
                        if (numValueOf != null) {
                            setBackgroundColor(numValueOf.intValue());
                        }
                    }
                    return viewA;
                }
                PendoLogger.w("Cannot inflate the main screen, bad content.", new Object[0]);
                return null;
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                if (exc instanceof c) {
                    throw exc;
                }
                logFailure(exc, guideId, stepId, visualGuideType);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setFocusableInTouchMode(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        try {
            super.onFinishInflate();
            setFocusableInTouchMode(true);
            requestFocus();
            setClickable(true);
            setFocusable(true);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 4) {
            try {
                if (event.getAction() == 0) {
                    PendoCommand BACK_PRESSED = PendoCommandDispatcher.PredefinedCommands.BACK_PRESSED;
                    Intrinsics.checkNotNullExpressionValue(BACK_PRESSED, "BACK_PRESSED");
                    BACK_PRESSED.setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(this.mGuideId));
                    PendoCommandDispatcher.getInstance().dispatchCommand(BACK_PRESSED, true);
                    return true;
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VisualGuideLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisualGuideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisualGuideLayout(Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
