package com.box.brownfieldApi.featuresNavigator;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ReactNativeBackDismiss.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001a\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"TOPIC_BACK_DISMISSIBLE", "", "TOPIC_BACK_PRESSED", "RnBackDismissHandler", "", "recipientId", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "brownfieldApi_release", "dismissible", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeBackDismissKt {
    public static final String TOPIC_BACK_DISMISSIBLE = "back_dismissible_changed";
    public static final String TOPIC_BACK_PRESSED = "back_pressed";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RnBackDismissHandler$lambda$4(String str, int i, Composer composer, int i2) {
        RnBackDismissHandler(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RnBackDismissHandler(final String recipientId, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Composer composerStartRestartGroup = composer.startRestartGroup(1635996353);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RnBackDismissHandler)20@803L137,20@748L192,24@957L24,25@1021L94,25@986L129:ReactNativeBackDismiss.kt#bsg48e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(recipientId) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1635996353, i2, -1, "com.box.brownfieldApi.featuresNavigator.RnBackDismissHandler (ReactNativeBackDismiss.kt:19)");
            }
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeBackDismiss.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1 reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1RememberedValue = new ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1(recipientId, null);
                composerStartRestartGroup.updateRememberedValue(reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateProduceState = SnapshotStateKt.produceState(false, recipientId, (Function2<? super ProduceStateScope<boolean>, ? super Continuation<? super Unit>, ? extends Object>) reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1RememberedValue, composerStartRestartGroup, ((i2 << 3) & 112) | 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zRnBackDismissHandler$lambda$1 = RnBackDismissHandler$lambda$1(stateProduceState);
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeBackDismiss.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | (i3 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeBackDismissKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ReactNativeBackDismissKt.RnBackDismissHandler$lambda$3$lambda$2(coroutineScope, recipientId);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(zRnBackDismissHandler$lambda$1, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeBackDismissKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactNativeBackDismissKt.RnBackDismissHandler$lambda$4(recipientId, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RnBackDismissHandler$lambda$3$lambda$2(CoroutineScope coroutineScope, String str) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ReactNativeBackDismissKt$RnBackDismissHandler$1$1$1(str, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final boolean RnBackDismissHandler$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
