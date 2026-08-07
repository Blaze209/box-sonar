package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEvent;
import expo.modules.kotlin.views.ComposeProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010!\u001a\u00020\u001e*\u00020\"H'¢\u0006\u0002\u0010#J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0014J0\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)H\u0014J\u0017\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0002\u0010#J>\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u00010\"2%\u00103\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0000¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\t04H\u0007¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\"2\u0006\u0010:\u001a\u00020)H\u0007¢\u0006\u0002\u0010;J\u0015\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020)H\u0007¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\u001eH\u0002J \u0010>\u001a\u00020\u001e2\u0006\u00107\u001a\u00020?2\u0006\u0010:\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0016J\u0012\u0010B\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010C\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010?H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0016\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0019\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0019\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006D"}, d2 = {"Lexpo/modules/kotlin/views/ExpoComposeView;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "withHostingView", "", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Z)V", "props", "getProps", "()Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "setRecomposeScope", "(Landroidx/compose/runtime/RecomposeScope;)V", "globalEvent", "Lexpo/modules/kotlin/viewevent/ViewEvent;", "Lkotlin/Pair;", "", "", "", "globalEventDispatcher", "Lkotlin/Function2;", "", "getGlobalEventDispatcher", "()Lkotlin/jvm/functions/Function2;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "shouldUseAndroidLayout", "getShouldUseAndroidLayout", "()Z", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "Children", "composableScope", ViewProps.FILTER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "child", "(Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Child", FirebaseAnalytics.Param.INDEX, "(Lexpo/modules/kotlin/views/ComposableScope;ILandroidx/compose/runtime/Composer;I)V", "(ILandroidx/compose/runtime/Composer;I)V", "addComposeView", "addView", "Landroid/view/View;", SerializedNames.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "onViewAdded", "onViewRemoved", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ExpoComposeView<T extends ComposeProps> extends ExpoView {
    public static final int $stable = 8;
    private final ViewEvent<Pair<String, Map<String, Object>>> globalEvent;
    private final Function2<String, Map<String, ? extends Object>, Unit> globalEventDispatcher;
    private final T props;
    private RecomposeScope recomposeScope;
    private final boolean shouldUseAndroidLayout;
    private final boolean withHostingView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Child$lambda$10(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Child$lambda$11(ExpoComposeView expoComposeView, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Child$lambda$7(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$3(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, Composer composer, int i2) {
        expoComposeView.Children(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$6(ExpoComposeView expoComposeView, ComposableScope composableScope, Function1 function1, int i, Composer composer, int i2) {
        expoComposeView.Children(composableScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public abstract void Content(ComposableScope composableScope, Composer composer, int i);

    public /* synthetic */ ExpoComposeView(Context context, AppContext appContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, appContext, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoComposeView(Context context, AppContext appContext, boolean z) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.withHostingView = z;
        this.globalEvent = new ViewEvent<>(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME, this, null);
        this.globalEventDispatcher = new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ExpoComposeView.globalEventDispatcher$lambda$0(this.f$0, (String) obj, (Map) obj2);
            }
        };
        this.shouldUseAndroidLayout = z;
        if (z) {
            addComposeView();
        } else {
            setVisibility(8);
            setWillNotDraw(true);
        }
    }

    public T getProps() {
        return this.props;
    }

    protected final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    protected final void setRecomposeScope(RecomposeScope recomposeScope) {
        this.recomposeScope = recomposeScope;
    }

    public final Function2<String, Map<String, ? extends Object>, Unit> getGlobalEventDispatcher() {
        return this.globalEventDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit globalEventDispatcher$lambda$0(ExpoComposeView expoComposeView, String name, Map params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        expoComposeView.globalEvent.invoke(new Pair<>(name, params));
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.views.ExpoView
    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getShouldUseAndroidLayout() && !isAttachedToWindow()) {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.withHostingView) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ComposeView) {
                    int paddingLeft = getPaddingLeft();
                    int paddingRight = getPaddingRight();
                    ((ComposeView) childAt).layout(paddingLeft, paddingRight, getWidth() + paddingLeft, getHeight() + paddingRight);
                }
            }
        }
    }

    public final void Children(final ComposableScope composableScope, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1482095158);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)106@3609L21:ExpoComposeView.kt#sri11g");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482095158, i2, -1, "expo.modules.kotlin.views.ExpoComposeView.Children (ExpoComposeView.kt:105)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                composerStartRestartGroup.startReplaceGroup(-832904357);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                View childAt = getChildAt(i3);
                ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
                if (expoComposeView == null) {
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    ComposableScope composableScope2 = composableScope == null ? new ComposableScope(null, null, null, null, 15, null) : composableScope;
                    composerStartRestartGroup.startReplaceGroup(1635704181);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@3820L9");
                    expoComposeView.Content(composableScope2, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Children$lambda$3(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, final Function1<? super ExpoComposeView<?>, Boolean> filter, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1547638819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)119@3994L21:ExpoComposeView.kt#sri11g");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(filter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1547638819, i2, -1, "expo.modules.kotlin.views.ExpoComposeView.Children (ExpoComposeView.kt:118)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                composerStartRestartGroup.startReplaceGroup(766059731);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                View childAt = getChildAt(i3);
                ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
                if (expoComposeView == null) {
                    composerStartRestartGroup.endReplaceGroup();
                } else if (filter.invoke(expoComposeView).booleanValue()) {
                    ComposableScope composableScope2 = composableScope == null ? new ComposableScope(null, null, null, null, 15, null) : composableScope;
                    composerStartRestartGroup.startReplaceGroup(-1222208664);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*127@4258L9");
                    expoComposeView.Content(composableScope2, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Children$lambda$6(this.f$0, composableScope, filter, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Child(final ComposableScope composableScope, final int i, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2114978266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)135@4392L21:ExpoComposeView.kt#sri11g");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2114978266, i3, -1, "expo.modules.kotlin.views.ExpoComposeView.Child (ExpoComposeView.kt:134)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            View childAt = getChildAt(i);
            ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
            if (expoComposeView == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExpoComposeView.Child$lambda$7(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.startReplaceGroup(-974575667);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*139@4537L9");
            expoComposeView.Content(composableScope, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Child$lambda$10(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Child(final int i, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(685328065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)146@4610L31:ExpoComposeView.kt#sri11g");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685328065, i3, -1, "expo.modules.kotlin.views.ExpoComposeView.Child (ExpoComposeView.kt:145)");
            }
            Child(new ComposableScope(null, null, null, null, 15, null), i, composerStartRestartGroup, (i3 << 3) & 1008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Child$lambda$11(this.f$0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final void addComposeView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1677560839, true, new Function2<Composer, Integer, Unit>(this) { // from class: expo.modules.kotlin.views.ExpoComposeView$addComposeView$composeView$1$1
            final /* synthetic */ ExpoComposeView<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C*164@5128L9:ExpoComposeView.kt#sri11g");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1677560839, i, -1, "expo.modules.kotlin.views.ExpoComposeView.addComposeView.<anonymous>.<anonymous> (ExpoComposeView.kt:163)");
                }
                this.this$0.Content(new ComposableScope(null, null, null, null, 15, null), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        composeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: expo.modules.kotlin.views.ExpoComposeView$addComposeView$composeView$1$2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                composeView.disposeComposition();
            }
        });
        addView(composeView);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(child instanceof ExpoComposeView) && !(child instanceof ComposeView) && !(this instanceof RNHostViewInterface)) {
            child = new ExpoComposeAndroidView(child, getAppContext());
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        RecomposeScope recomposeScope = this.recomposeScope;
        if (recomposeScope != null) {
            recomposeScope.invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        RecomposeScope recomposeScope = this.recomposeScope;
        if (recomposeScope != null) {
            recomposeScope.invalidate();
        }
    }
}
