package expo.modules.ui;

import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u008a\u0084\u0002"}, d2 = {"SliderContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SliderProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SliderProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release", "onValueChanged", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/SliderValueChangedEvent;"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SliderViewKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(SliderViewKt.class, "onValueChanged", "<v#0>", 1))};

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderContent$lambda$4(FunctionalComposableScope functionalComposableScope, SliderProps sliderProps, int i, Composer composer, int i2) {
        SliderContent(functionalComposableScope, sliderProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SliderContent(final FunctionalComposableScope functionalComposableScope, final SliderProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(347902402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderContent)45@1145L74,54@1510L294,61@1838L83,51@1423L57,47@1257L668:SliderView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347902402, i2, -1, "expo.modules.ui.SliderContent (SliderView.kt:44)");
            }
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ViewEventDelegate viewEventDelegate = new ViewEventDelegate(functionalComposableScope.getView(), null);
                composerStartRestartGroup.updateRememberedValue(viewEventDelegate);
                objRememberedValue = viewEventDelegate;
            }
            final ViewEventDelegate viewEventDelegate2 = (ViewEventDelegate) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            SliderColors elementColors = props.getElementColors();
            float fCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(props.getValue(), props.getMin()), props.getMax());
            ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(props.getMin(), props.getMax());
            int steps = props.getSteps();
            androidx.compose.material3.SliderColors sliderColorsM4213colorsq0g_0yA = SliderDefaults.INSTANCE.m4213colorsq0g_0yA(UtilsKt.getCompose(elementColors.getThumbColor()), UtilsKt.getCompose(elementColors.getActiveTrackColor()), UtilsKt.getCompose(elementColors.getActiveTickColor()), UtilsKt.getCompose(elementColors.getInactiveTrackColor()), UtilsKt.getCompose(elementColors.getInactiveTickColor()), 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 992);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):SliderView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(viewEventDelegate2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderViewKt.SliderContent$lambda$3$lambda$2(viewEventDelegate2, ((Float) obj).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            SliderKt.Slider(fCoerceAtMost, (Function1) objRememberedValue2, modifierApplyModifiers, false, closedFloatingPointRangeRangeTo, steps, null, sliderColorsM4213colorsq0g_0yA, null, composerStartRestartGroup, 0, 328);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderViewKt.SliderContent$lambda$4(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ViewEventCallback<SliderValueChangedEvent> SliderContent$lambda$1(ViewEventDelegate<SliderValueChangedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderContent$lambda$3$lambda$2(ViewEventDelegate viewEventDelegate, float f) {
        SliderContent$lambda$1(viewEventDelegate).invoke(new SliderValueChangedEvent(f));
        return Unit.INSTANCE;
    }
}
