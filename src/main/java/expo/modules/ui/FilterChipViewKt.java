package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterChipView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"FilterChipContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/FilterChipProps;", "onPress", "Lkotlin/Function1;", "Lexpo/modules/ui/FilterChipPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/FilterChipProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FilterChipViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChipContent$lambda$4(FunctionalComposableScope functionalComposableScope, FilterChipProps filterChipProps, Function1 function1, int i, Composer composer, int i2) {
        FilterChipContent(functionalComposableScope, filterChipProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FilterChipContent(final FunctionalComposableScope functionalComposableScope, final FilterChipProps props, final Function1<? super FilterChipPressedEvent, Unit> onPress, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1188111706);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChipContent)P(1)26@837L83,54@1589L18,55@1641L68,33@1118L37,34@1169L21,31@1061L677:FilterChipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1188111706, i3, -1, "expo.modules.ui.FilterChipContent (FilterChipView.kt:25)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "leadingIcon");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "trailingIcon");
            boolean selected = props.getSelected();
            boolean enabled = props.getEnabled();
            composerStartRestartGroup.startReplaceGroup(685970340);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*37@1272L108");
            ComposableLambda composableLambdaRememberComposableLambda = slotViewFindChildSlotView == null ? null : ComposableLambdaKt.rememberComposableLambda(827981914, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.FilterChipViewKt$FilterChipContent$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C:FilterChipView.kt#v15e7d");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(827981914, i4, -1, "expo.modules.ui.FilterChipContent.<anonymous>.<anonymous> (FilterChipView.kt:38)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView;
                    composer2.startReplaceGroup(1121671110);
                    ComposerKt.sourceInformation(composer2, "*40@1341L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(685975748);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*46@1441L108");
            ComposableLambda composableLambdaRememberComposableLambda2 = slotViewFindChildSlotView2 != null ? ComposableLambdaKt.rememberComposableLambda(-671474169, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.FilterChipViewKt$FilterChipContent$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C:FilterChipView.kt#v15e7d");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-671474169, i4, -1, "expo.modules.ui.FilterChipContent.<anonymous>.<anonymous> (FilterChipView.kt:47)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView2;
                    composer2.startReplaceGroup(-1041580493);
                    ComposerKt.sourceInformation(composer2, "*49@1510L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54) : null;
            composerStartRestartGroup.endReplaceGroup();
            SelectableChipColors selectableChipColorsFilterChipColors = FilterChipDefaults.INSTANCE.filterChipColors(composerStartRestartGroup, FilterChipDefaults.$stable);
            BorderStroke borderStrokeM3365filterChipBorder_7El2pE = FilterChipDefaults.INSTANCE.m3365filterChipBorder_7El2pE(props.getEnabled(), props.getSelected(), 0L, 0L, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, FilterChipDefaults.$stable << 24, 252);
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):FilterChipView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.FilterChipViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilterChipViewKt.FilterChipContent$lambda$3$lambda$2(onPress);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            ChipKt.m2976FilterChipQi0uq5o(selected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-2130717351, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.FilterChipViewKt.FilterChipContent.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C34@1171L17:FilterChipView.kt#v15e7d");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2130717351, i4, -1, "expo.modules.ui.FilterChipContent.<anonymous> (FilterChipView.kt:34)");
                    }
                    TextKt.m4494TextNvy7gAk(props.getLabel(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), modifierApplyModifiers, enabled, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, null, selectableChipColorsFilterChipColors, null, borderStrokeM3365filterChipBorder_7El2pE, 0.0f, null, null, composerStartRestartGroup, 384, 0, 14976);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.FilterChipViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilterChipViewKt.FilterChipContent$lambda$4(functionalComposableScope, props, onPress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChipContent$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(new FilterChipPressedEvent());
        return Unit.INSTANCE;
    }
}
