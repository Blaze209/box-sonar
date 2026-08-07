package expo.modules.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullToRefreshBoxView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"PullToRefreshBoxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/PullToRefreshBoxProps;", "onRefresh", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/PullToRefreshBoxProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PullToRefreshBoxViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshBoxContent$lambda$2(FunctionalComposableScope functionalComposableScope, PullToRefreshBoxProps pullToRefreshBoxProps, Function0 function0, int i, Composer composer, int i2) {
        PullToRefreshBoxContent(functionalComposableScope, pullToRefreshBoxProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PullToRefreshBoxContent(final FunctionalComposableScope functionalComposableScope, final PullToRefreshBoxProps props, final Function0<Unit> onRefresh, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        Composer composerStartRestartGroup = composer.startRestartGroup(1583733953);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullToRefreshBoxContent)P(1)22@940L28,35@1408L83,26@1039L15,28@1104L270,36@1496L37,24@972L561:PullToRefreshBoxView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRefresh) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1583733953, i3, -1, "expo.modules.ui.PullToRefreshBoxContent (PullToRefreshBoxView.kt:20)");
            }
            final boolean zIsRefreshing = props.isRefreshing();
            final PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PullToRefreshBoxView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$1$lambda$0(onRefresh);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            PullToRefreshKt.PullToRefreshBox(zIsRefreshing, (Function0) objRememberedValue, modifierApplyModifiers, pullToRefreshStateRememberPullToRefreshState, null, ComposableLambdaKt.rememberComposableLambda(558816218, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.PullToRefreshBoxViewKt.PullToRefreshBoxContent.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                    invoke(boxScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope PullToRefreshBox, Composer composer3, int i4) {
                    Intrinsics.checkNotNullParameter(PullToRefreshBox, "$this$PullToRefreshBox");
                    ComposerKt.sourceInformation(composer3, "C32@1261L99,29@1134L234:PullToRefreshBoxView.kt#v15e7d");
                    if ((i4 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(558816218, i4, -1, "expo.modules.ui.PullToRefreshBoxContent.<anonymous> (PullToRefreshBoxView.kt:29)");
                    }
                    PullToRefreshDefaults.INSTANCE.m5108LoadingIndicator4eDdRP8(pullToRefreshStateRememberPullToRefreshState, zIsRefreshing, ModifierRegistry.INSTANCE.applyModifiers(props.getLoadingIndicatorModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer3, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), 0L, 0L, 0.0f, 0.0f, composer3, PullToRefreshDefaults.$stable << 21, 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(808094619, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.PullToRefreshBoxViewKt.PullToRefreshBoxContent.3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                    invoke(boxScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope PullToRefreshBox, Composer composer3, int i4) {
                    Intrinsics.checkNotNullParameter(PullToRefreshBox, "$this$PullToRefreshBox");
                    ComposerKt.sourceInformation(composer3, "C37@1502L27:PullToRefreshBoxView.kt#v15e7d");
                    if ((i4 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(808094619, i4, -1, "expo.modules.ui.PullToRefreshBoxContent.<anonymous> (PullToRefreshBoxView.kt:37)");
                    }
                    functionalComposableScope.Children(new ComposableScope(null, null, null, null, 15, null), composer3, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769472, 16);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$2(functionalComposableScope, props, onRefresh, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshBoxContent$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
