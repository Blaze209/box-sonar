package com.box.android.browse.cpl.itemsList;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.multidoc.BoxAiMultidocStatus;
import com.box.android.browse.compose.BoxAiTopBarButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MultiselectActionMode.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MultiselectActionMode this$0;

    MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1(MultiselectActionMode multiselectActionMode) {
        this.this$0 = multiselectActionMode;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C110@4337L29,112@4405L410,112@4396L419:MultiselectActionMode.kt#j5t2uy");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(879470506, i, -1, "com.box.android.browse.cpl.itemsList.MultiselectActionMode.createMultiselectActionsCallback.<no name provided>.setupBoxAiButton.<anonymous>.<anonymous>.<anonymous> (MultiselectActionMode.kt:110)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(this.this$0.actionableItemsListStore.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            final MultiselectActionMode multiselectActionMode = this.this$0;
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1123830977, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C115@4581L170,113@4439L346:MultiselectActionMode.kt#j5t2uy");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1123830977, i2, -1, "com.box.android.browse.cpl.itemsList.MultiselectActionMode.createMultiselectActionsCallback.<no name provided>.setupBoxAiButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiselectActionMode.kt:113)");
                    }
                    BoxAiMultidocStatus boxAiMultidocStatus = stateCollectAsStateWithLifecycle.getValue().getBoxAiMultidocStatus();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1964771799, "CC(remember):MultiselectActionMode.kt#9igjgp");
                    boolean zChangedInstance = composer2.changedInstance(multiselectActionMode);
                    final MultiselectActionMode multiselectActionMode2 = multiselectActionMode;
                    Object objRememberedValue = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.browse.cpl.itemsList.MultiselectActionMode$createMultiselectActionsCallback$1$setupBoxAiButton$1$composeView$1$1$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                multiselectActionMode2.actionableItemsListStore.send(ActionableItemsListReducer.Action.OpenBoxAiForSelectedFiles.INSTANCE);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoxAiTopBarButtonKt.BoxAiTopBarButton(boxAiMultidocStatus, (Function0) objRememberedValue, null, composer2, 0, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
