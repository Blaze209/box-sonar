package expo.modules.nativeelementsexpo.keyboardavoidingview;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.viewevent.ViewEventDelegateKt;
import expo.modules.kotlin.views.ExpoView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NativeKeyboardAvoidingView.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0014J\b\u0010!\u001a\u00020\u001aH\u0017J\b\u0010\"\u001a\u00020\u001aH\u0014J\b\u0010#\u001a\u00020\u001aH\u0014J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0015H\u0002J0\u0010/\u001a\u00020\u001a2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001a01H\u0003¢\u0006\u0002\u00104R-\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lexpo/modules/nativeelementsexpo/keyboardavoidingview/NativeKeyboardAvoidingView;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "onKeyboardHeightChange", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "", "", "getOnKeyboardHeightChange", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onKeyboardHeightChange$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "density", "", "lastReportedHeightDp", "lastImeBottomPx", "", "imeProbe", "Landroidx/compose/ui/platform/ComposeView;", "bottomGapAtRestPx", "onLayout", "", "changed", "", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "requestLayout", "onAttachedToWindow", "onDetachedFromWindow", "attachImeProbe", "detachImeProbe", "resolveContentRoot", "Landroid/view/ViewGroup;", "measureBottomGap", "applyImeOffset", "imeBottomPx", "computeShiftPx", "bottomGapPx", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "ImeInsetObserver", "onImeChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeKeyboardAvoidingView extends ExpoView {
    private static final String HEIGHT_KEY = "height";
    private static final String TAG = "NativeKeyboardAvoidingView";
    private int bottomGapAtRestPx;
    private final float density;
    private ComposeView imeProbe;
    private int lastImeBottomPx;
    private float lastReportedHeightDp;
    private final View.OnLayoutChangeListener layoutChangeListener;

    /* JADX INFO: renamed from: onKeyboardHeightChange$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onKeyboardHeightChange;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NativeKeyboardAvoidingView.class, "onKeyboardHeightChange", "getOnKeyboardHeightChange()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImeInsetObserver$lambda$6(NativeKeyboardAvoidingView nativeKeyboardAvoidingView, Function1 function1, int i, Composer composer, int i2) {
        nativeKeyboardAvoidingView.ImeInsetObserver(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // expo.modules.kotlin.views.ExpoView, android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeKeyboardAvoidingView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.onKeyboardHeightChange = ViewEventDelegateKt.MapEventDispatcher$default(this, null, 1, null);
        this.density = context.getResources().getDisplayMetrics().density;
        this.layoutChangeListener = new View.OnLayoutChangeListener() { // from class: expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                NativeKeyboardAvoidingView.layoutChangeListener$lambda$4(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
    }

    public final ViewEventCallback<Map<String, Object>> getOnKeyboardHeightChange() {
        return this.onKeyboardHeightChange.getValue(this, $$delegatedProperties[0]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow, root view: " + getRootView());
        addOnLayoutChangeListener(this.layoutChangeListener);
        attachImeProbe();
        this.bottomGapAtRestPx = measureBottomGap();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        removeOnLayoutChangeListener(this.layoutChangeListener);
        detachImeProbe();
        setTranslationY(0.0f);
        this.lastReportedHeightDp = 0.0f;
        this.lastImeBottomPx = 0;
        getOnKeyboardHeightChange().invoke(MapsKt.mapOf(TuplesKt.to("height", Float.valueOf(0.0f))));
        super.onDetachedFromWindow();
    }

    private final void attachImeProbe() {
        if (this.imeProbe != null) {
            return;
        }
        ViewGroup viewGroupResolveContentRoot = resolveContentRoot();
        if (viewGroupResolveContentRoot == null) {
            Log.w(TAG, "No content root found; IME probe not attached");
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-843885879, true, new NativeKeyboardAvoidingView$attachImeProbe$probe$1$1(this)));
        viewGroupResolveContentRoot.addView(composeView);
        this.imeProbe = composeView;
    }

    private final void detachImeProbe() {
        final ComposeView composeView = this.imeProbe;
        if (composeView == null) {
            return;
        }
        this.imeProbe = null;
        composeView.disposeComposition();
        ViewParent parent = composeView.getParent();
        final ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NativeKeyboardAvoidingView.detachImeProbe$lambda$2(viewGroup, composeView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detachImeProbe$lambda$2(ViewGroup viewGroup, ComposeView composeView) {
        viewGroup.removeView(composeView);
    }

    private final ViewGroup resolveContentRoot() {
        View rootView = getRootView();
        View viewFindViewById = rootView.findViewById(R.id.content);
        ViewGroup viewGroup = viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView instanceof ViewGroup) {
            return (ViewGroup) rootView;
        }
        return null;
    }

    private final int measureBottomGap() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int height = iArr[1] + getHeight();
        int[] iArr2 = new int[2];
        getRootView().getLocationOnScreen(iArr2);
        return RangesKt.coerceAtLeast((iArr2[1] + getRootView().getHeight()) - height, 0) + ((int) getTranslationY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyImeOffset(int imeBottomPx) {
        this.lastImeBottomPx = imeBottomPx;
        int iComputeShiftPx = computeShiftPx(imeBottomPx, this.bottomGapAtRestPx);
        float f = iComputeShiftPx;
        setTranslationY(-f);
        Log.d(TAG, "applyImeOffset bottomGap=" + this.bottomGapAtRestPx + " shift=" + iComputeShiftPx + " translationY=" + getTranslationY());
        float f2 = f / this.density;
        if (f2 == this.lastReportedHeightDp) {
            return;
        }
        this.lastReportedHeightDp = f2;
        Log.d(TAG, "onKeyboardHeightChange. shiftDp=" + f2);
        getOnKeyboardHeightChange().invoke(MapsKt.mapOf(TuplesKt.to("height", Float.valueOf(f2))));
    }

    private final int computeShiftPx(int imeBottomPx, int bottomGapPx) {
        if (imeBottomPx > 0) {
            return RangesKt.coerceAtLeast(imeBottomPx - bottomGapPx, 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutChangeListener$lambda$4(NativeKeyboardAvoidingView nativeKeyboardAvoidingView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        Log.d(TAG, "layoutChangeListener lastImeBottomPx=" + nativeKeyboardAvoidingView.lastImeBottomPx);
        nativeKeyboardAvoidingView.bottomGapAtRestPx = nativeKeyboardAvoidingView.measureBottomGap();
        nativeKeyboardAvoidingView.applyImeOffset(nativeKeyboardAvoidingView.lastImeBottomPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ImeInsetObserver(final Function1<? super Integer, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1119410423);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImeInsetObserver)192@7464L7,193@7511L3,194@7570L101,194@7542L129:NativeKeyboardAvoidingView.kt#s1kn6k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119410423, i2, -1, "expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView.ImeInsetObserver (NativeKeyboardAvoidingView.kt:191)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int bottom = WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom((Density) objConsume);
            Integer numValueOf = Integer.valueOf(bottom);
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):NativeKeyboardAvoidingView.kt#9igjgp");
            boolean zChanged = ((i2 & 14) == 4) | composerStartRestartGroup.changed(bottom);
            NativeKeyboardAvoidingView$ImeInsetObserver$1$1 nativeKeyboardAvoidingView$ImeInsetObserver$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || nativeKeyboardAvoidingView$ImeInsetObserver$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                nativeKeyboardAvoidingView$ImeInsetObserver$1$1RememberedValue = new NativeKeyboardAvoidingView$ImeInsetObserver$1$1(bottom, function1, null);
                composerStartRestartGroup.updateRememberedValue(nativeKeyboardAvoidingView$ImeInsetObserver$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) nativeKeyboardAvoidingView$ImeInsetObserver$1$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NativeKeyboardAvoidingView.ImeInsetObserver$lambda$6(this.f$0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
