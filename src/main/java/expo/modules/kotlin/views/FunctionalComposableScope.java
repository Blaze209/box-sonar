package expo.modules.kotlin.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001dJ>\u0010\u001c\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052%\u0010\u001e\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0007¢\u0006\u0002\u0010%JM\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0006\b\u0000\u0010(\u0018\u000121\b\n\u0010)\u001a+\u0012\u0013\u0012\u0011H(¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+\u0018\u00010\u001fj\n\u0012\u0004\u0012\u0002H(\u0018\u0001`,H\u0086\bø\u0001\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2 = {"Lexpo/modules/kotlin/views/FunctionalComposableScope;", "", "view", "Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "composableScope", "Lexpo/modules/kotlin/views/ComposableScope;", "<init>", "(Lexpo/modules/kotlin/views/ComposeFunctionHolder;Lexpo/modules/kotlin/views/ComposableScope;)V", "getView", "()Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "getComposableScope", "()Lexpo/modules/kotlin/views/ComposableScope;", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "globalEventDispatcher", "Lkotlin/Function2;", "", "", "", "getGlobalEventDispatcher", "()Lkotlin/jvm/functions/Function2;", "Child", FirebaseAnalytics.Param.INDEX, "", "(Lexpo/modules/kotlin/views/ComposableScope;ILandroidx/compose/runtime/Composer;I)V", "(ILandroidx/compose/runtime/Composer;I)V", "Children", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", ViewProps.FILTER, "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lkotlin/ParameterName;", "name", "child", "", "(Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EventDispatcher", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "coalescingKey", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FunctionalComposableScope {
    public static final int $stable = 8;
    private final AppContext appContext;
    private final ComposableScope composableScope;
    private final Function2<String, Map<String, ? extends Object>, Unit> globalEventDispatcher;
    private final ComposeFunctionHolder<?> view;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Child$lambda$0(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        functionalComposableScope.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Child$lambda$1(FunctionalComposableScope functionalComposableScope, int i, int i2, Composer composer, int i3) {
        functionalComposableScope.Child(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$2(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, int i, Composer composer, int i2) {
        functionalComposableScope.Children(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$3(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, Function1 function1, int i, Composer composer, int i2) {
        functionalComposableScope.Children(composableScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public FunctionalComposableScope(ComposeFunctionHolder<?> view, ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        this.view = view;
        this.composableScope = composableScope;
        this.appContext = view.getAppContext();
        this.globalEventDispatcher = view.getGlobalEventDispatcher();
    }

    public final ComposeFunctionHolder<?> getView() {
        return this.view;
    }

    public final ComposableScope getComposableScope() {
        return this.composableScope;
    }

    public final AppContext getAppContext() {
        return this.appContext;
    }

    public final Function2<String, Map<String, ? extends Object>, Unit> getGlobalEventDispatcher() {
        return this.globalEventDispatcher;
    }

    public final void Child(final ComposableScope composableScope, final int i, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        Composer composerStartRestartGroup = composer.startRestartGroup(1968519269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)213@6505L29:ExpoComposeView.kt#sri11g");
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
                ComposerKt.traceEventStart(1968519269, i3, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Child (ExpoComposeView.kt:212)");
            }
            this.view.Child(composableScope, i, composerStartRestartGroup, i3 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Child$lambda$0(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Child(final int i, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-977487040);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)218@6589L12:ExpoComposeView.kt#sri11g");
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
                ComposerKt.traceEventStart(-977487040, i3, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Child (ExpoComposeView.kt:217)");
            }
            this.view.Child(i, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Child$lambda$1(this.f$0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(724828937);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)223@6682L25:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(724828937, i2, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Children (ExpoComposeView.kt:222)");
            }
            this.view.Children(composableScope, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Children$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, final Function1<? super ExpoComposeView<?>, Boolean> filter, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(filter, "filter");
        Composer composerStartRestartGroup = composer.startRestartGroup(693283164);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)228@6836L33:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(filter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(693283164, i2, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Children (ExpoComposeView.kt:227)");
            }
            this.view.Children(composableScope, filter, composerStartRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Children$lambda$3(this.f$0, composableScope, filter, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static /* synthetic */ ViewEventDelegate EventDispatcher$default(FunctionalComposableScope functionalComposableScope, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return new ViewEventDelegate(functionalComposableScope.getView(), function1);
    }

    public final /* synthetic */ <T> ViewEventDelegate<T> EventDispatcher(Function1<? super T, Short> coalescingKey) {
        return new ViewEventDelegate<>(getView(), coalescingKey);
    }
}
