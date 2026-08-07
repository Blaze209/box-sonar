package com.box.android.base.presentation.message;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxMessageListenerEffect.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\u001a\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"BoxMessageListenerEffect", "", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "onBoxMessageReceived", "Lkotlin/Function1;", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "(Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease", "updatedOnBoxMessageReceived"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxMessageListenerEffectKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxMessageListenerEffect$lambda$2(BoxMessageDispatcher boxMessageDispatcher, Function1 function1, int i, Composer composer, int i2) {
        BoxMessageListenerEffect(boxMessageDispatcher, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxMessageListenerEffect(final BoxMessageDispatcher boxMessageDispatcher, final Function1<? super BoxMessage<?>, Unit> onBoxMessageReceived, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(onBoxMessageReceived, "onBoxMessageReceived");
        Composer composerStartRestartGroup = composer.startRestartGroup(991205151);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxMessageListenerEffect)N(boxMessageDispatcher,onBoxMessageReceived)17@778L42,19@865L274,19@826L313:BoxMessageListenerEffect.kt#koyhy9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBoxMessageReceived) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(991205151, i2, -1, "com.box.android.base.presentation.message.BoxMessageListenerEffect (BoxMessageListenerEffect.kt:16)");
            }
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onBoxMessageReceived, composerStartRestartGroup, (i2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -934581391, "CC(remember):BoxMessageListenerEffect.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(boxMessageDispatcher);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.message.BoxMessageListenerEffectKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxMessageListenerEffectKt.BoxMessageListenerEffect$lambda$1$0(boxMessageDispatcher, stateRememberUpdatedState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(boxMessageDispatcher, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.message.BoxMessageListenerEffectKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxMessageListenerEffectKt.BoxMessageListenerEffect$lambda$2(boxMessageDispatcher, onBoxMessageReceived, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BoxMessageListenerEffect$lambda$1$0(final BoxMessageDispatcher boxMessageDispatcher, final State state, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Function1<? super BoxMessage<?>, Unit> function1 = new Function1() { // from class: com.box.android.base.presentation.message.BoxMessageListenerEffectKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxMessageListenerEffectKt.BoxMessageListenerEffect$lambda$1$0$0(state, (BoxMessage) obj);
            }
        };
        boxMessageDispatcher.addListener(function1);
        return new DisposableEffectResult() { // from class: com.box.android.base.presentation.message.BoxMessageListenerEffectKt$BoxMessageListenerEffect$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                boxMessageDispatcher.removeListener(function1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxMessageListenerEffect$lambda$1$0$0(State state, BoxMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BoxMessageListenerEffect$lambda$0(state).invoke(message);
        return Unit.INSTANCE;
    }

    private static final Function1<BoxMessage<?>, Unit> BoxMessageListenerEffect$lambda$0(State<? extends Function1<? super BoxMessage<?>, Unit>> state) {
        return (Function1) state.getValue();
    }
}
