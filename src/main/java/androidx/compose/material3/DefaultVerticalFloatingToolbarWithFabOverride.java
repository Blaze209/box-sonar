package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material3/DefaultVerticalFloatingToolbarWithFabOverride;", "Landroidx/compose/material3/VerticalFloatingToolbarWithFabOverride;", "<init>", "()V", "VerticalFloatingToolbarWithFab", "", "Landroidx/compose/material3/VerticalFloatingToolbarWithFabOverrideScope;", "(Landroidx/compose/material3/VerticalFloatingToolbarWithFabOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "touchExplorationServiceEnabled", "", "forceCollapse"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultVerticalFloatingToolbarWithFabOverride implements VerticalFloatingToolbarWithFabOverride {
    public static final int $stable = 0;
    public static final DefaultVerticalFloatingToolbarWithFabOverride INSTANCE = new DefaultVerticalFloatingToolbarWithFabOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalFloatingToolbarWithFab$lambda$5(DefaultVerticalFloatingToolbarWithFabOverride defaultVerticalFloatingToolbarWithFabOverride, VerticalFloatingToolbarWithFabOverrideScope verticalFloatingToolbarWithFabOverrideScope, int i, Composer composer, int i2) {
        defaultVerticalFloatingToolbarWithFabOverride.VerticalFloatingToolbarWithFab(verticalFloatingToolbarWithFabOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultVerticalFloatingToolbarWithFabOverride() {
    }

    @Override // androidx.compose.material3.VerticalFloatingToolbarWithFabOverride
    public void VerticalFloatingToolbarWithFab(final VerticalFloatingToolbarWithFabOverrideScope verticalFloatingToolbarWithFabOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1450582729);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalFloatingToolbarWithFab)567@31323L33,568@31403L25,568@31386L42,572@31631L34,569@31437L815:FloatingToolbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(verticalFloatingToolbarWithFabOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        boolean z = true;
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1450582729, i2, -1, "androidx.compose.material3.DefaultVerticalFloatingToolbarWithFabOverride.VerticalFloatingToolbarWithFab (FloatingToolbar.kt:566)");
            }
            State stateRememberTouchExplorationService = FloatingToolbarKt.rememberTouchExplorationService(composerStartRestartGroup, 0);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1854375344, "CC(remember):FloatingToolbar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.DefaultVerticalFloatingToolbarWithFabOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultVerticalFloatingToolbarWithFabOverride.VerticalFloatingToolbarWithFab$lambda$1$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            Modifier modifier = verticalFloatingToolbarWithFabOverrideScope.getModifier();
            if (VerticalFloatingToolbarWithFab$lambda$2(mutableState) || (!VerticalFloatingToolbarWithFab$lambda$0(stateRememberTouchExplorationService) && !verticalFloatingToolbarWithFabOverrideScope.getIsExpanded())) {
                z = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1854382649, "CC(remember):FloatingToolbar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DefaultVerticalFloatingToolbarWithFabOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultVerticalFloatingToolbarWithFabOverride.VerticalFloatingToolbarWithFab$lambda$4$0(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            FloatingToolbarKt.m3483VerticalFloatingToolbarWithFabLayoutNur2B3k(modifier, z, function1, verticalFloatingToolbarWithFabOverrideScope.getColors(), FloatingToolbarDefaults.INSTANCE.m3432getToolbarToFabGapD9Ej5fM$material3(), verticalFloatingToolbarWithFabOverrideScope.getContentPadding(), !VerticalFloatingToolbarWithFab$lambda$0(stateRememberTouchExplorationService) ? verticalFloatingToolbarWithFabOverrideScope.getScrollBehavior() : null, verticalFloatingToolbarWithFabOverrideScope.getShape(), verticalFloatingToolbarWithFabOverrideScope.getAnimationSpec(), verticalFloatingToolbarWithFabOverrideScope.getFloatingActionButton(), verticalFloatingToolbarWithFabOverrideScope.getFloatingActionButtonPosition(), verticalFloatingToolbarWithFabOverrideScope.getExpandedShadowElevation(), verticalFloatingToolbarWithFabOverrideScope.getCollapsedShadowElevation(), verticalFloatingToolbarWithFabOverrideScope.getContent(), composer2, 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultVerticalFloatingToolbarWithFabOverride$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultVerticalFloatingToolbarWithFabOverride.VerticalFloatingToolbarWithFab$lambda$5(this.f$0, verticalFloatingToolbarWithFabOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState VerticalFloatingToolbarWithFab$lambda$1$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private static final boolean VerticalFloatingToolbarWithFab$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerticalFloatingToolbarWithFab$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalFloatingToolbarWithFab$lambda$4$0(MutableState mutableState, boolean z) {
        VerticalFloatingToolbarWithFab$lambda$3(mutableState, z);
        return Unit.INSTANCE;
    }

    private static final boolean VerticalFloatingToolbarWithFab$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
