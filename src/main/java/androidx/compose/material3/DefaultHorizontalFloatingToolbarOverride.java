package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultHorizontalFloatingToolbarOverride;", "Landroidx/compose/material3/HorizontalFloatingToolbarOverride;", "<init>", "()V", "HorizontalFloatingToolbar", "", "Landroidx/compose/material3/HorizontalFloatingToolbarOverrideScope;", "(Landroidx/compose/material3/HorizontalFloatingToolbarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "touchExplorationServiceEnabled", "", "forceCollapse", "shouldFocus"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultHorizontalFloatingToolbarOverride implements HorizontalFloatingToolbarOverride {
    public static final int $stable = 0;
    public static final DefaultHorizontalFloatingToolbarOverride INSTANCE = new DefaultHorizontalFloatingToolbarOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalFloatingToolbar$lambda$8(DefaultHorizontalFloatingToolbarOverride defaultHorizontalFloatingToolbarOverride, HorizontalFloatingToolbarOverrideScope horizontalFloatingToolbarOverrideScope, int i, Composer composer, int i2) {
        defaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar(horizontalFloatingToolbarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultHorizontalFloatingToolbarOverride() {
    }

    @Override // androidx.compose.material3.HorizontalFloatingToolbarOverride
    public void HorizontalFloatingToolbar(final HorizontalFloatingToolbarOverrideScope horizontalFloatingToolbarOverrideScope, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionFocusProperties;
        Composer composerStartRestartGroup = composer.startRestartGroup(949705644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalFloatingToolbar)210@11112L33,211@11192L25,211@11175L42,212@11245L95,222@11761L34,215@11349L901:FloatingToolbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(horizontalFloatingToolbarOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        boolean z = true;
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(949705644, i2, -1, "androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar (FloatingToolbar.kt:209)");
            }
            State stateRememberTouchExplorationService = FloatingToolbarKt.rememberTouchExplorationService(composerStartRestartGroup, 0);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2134063525, "CC(remember):FloatingToolbar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar$lambda$1$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2134065291, "CC(remember):FloatingToolbar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar$lambda$4$0(horizontalFloatingToolbarOverrideScope));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier = horizontalFloatingToolbarOverrideScope.getModifier();
            if (HorizontalFloatingToolbar$lambda$5((State) objRememberedValue2)) {
                composerStartRestartGroup.startReplaceGroup(2134075252);
                composerStartRestartGroup.endReplaceGroup();
                companionFocusProperties = Modifier.INSTANCE;
            } else {
                composerStartRestartGroup.startReplaceGroup(2134076016);
                ComposerKt.sourceInformation(composerStartRestartGroup, "219@11598L20");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2134076512, "CC(remember):FloatingToolbar.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar$lambda$6$0((FocusProperties) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionFocusProperties = FocusPropertiesKt.focusProperties(companion, (Function1) objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierThen = modifier.then(companionFocusProperties);
            if (HorizontalFloatingToolbar$lambda$2(mutableState) || (!HorizontalFloatingToolbar$lambda$0(stateRememberTouchExplorationService) && !horizontalFloatingToolbarOverrideScope.getIsExpanded())) {
                z = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2134081742, "CC(remember):FloatingToolbar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar$lambda$7$0(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FloatingToolbarKt.m3478HorizontalFloatingToolbarLayoutyndP2WQ(modifierThen, z, function1, horizontalFloatingToolbarOverrideScope.getColors(), horizontalFloatingToolbarOverrideScope.getContentPadding(), !HorizontalFloatingToolbar$lambda$0(stateRememberTouchExplorationService) ? horizontalFloatingToolbarOverrideScope.getScrollBehavior() : null, horizontalFloatingToolbarOverrideScope.getShape(), horizontalFloatingToolbarOverrideScope.getLeadingContent(), horizontalFloatingToolbarOverrideScope.getTrailingContent(), horizontalFloatingToolbarOverrideScope.getExpandedShadowElevation(), horizontalFloatingToolbarOverrideScope.getCollapsedShadowElevation(), horizontalFloatingToolbarOverrideScope.getContent(), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultHorizontalFloatingToolbarOverride$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultHorizontalFloatingToolbarOverride.HorizontalFloatingToolbar$lambda$8(this.f$0, horizontalFloatingToolbarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState HorizontalFloatingToolbar$lambda$1$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private static final boolean HorizontalFloatingToolbar$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HorizontalFloatingToolbar$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HorizontalFloatingToolbar$lambda$4$0(HorizontalFloatingToolbarOverrideScope horizontalFloatingToolbarOverrideScope) {
        FloatingToolbarState state;
        FloatingToolbarScrollBehavior scrollBehavior = horizontalFloatingToolbarOverrideScope.getScrollBehavior();
        return ((scrollBehavior == null || (state = scrollBehavior.getState()) == null) ? 0.0f : state.getOffset()) == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalFloatingToolbar$lambda$6$0(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalFloatingToolbar$lambda$7$0(MutableState mutableState, boolean z) {
        HorizontalFloatingToolbar$lambda$3(mutableState, z);
        return Unit.INSTANCE;
    }

    private static final boolean HorizontalFloatingToolbar$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean HorizontalFloatingToolbar$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
