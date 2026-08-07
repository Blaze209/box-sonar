package com.box.android.preview.iteminformation;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ItemInformationScreenWithBackHandler", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "defaultAvatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;ZLandroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreenWithBackHandler$lambda$1(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, boolean z, int i, int i2, Composer composer, int i3) {
        ItemInformationScreenWithBackHandler(store, defaultAvatarControllerWrapper, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ItemInformationScreenWithBackHandler(final Store<ItemInformationReducer.State, ItemInformationReducer.Action> store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        DefaultAvatarControllerWrapper defaultAvatarControllerWrapper2;
        final Store<ItemInformationReducer.State, ItemInformationReducer.Action> store2;
        final boolean z2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(defaultAvatarControllerWrapper, "defaultAvatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-840372244);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemInformationScreenWithBackHandler)N(store,defaultAvatarControllerWrapper,isRedesignedVersion)128@5129L7,129@5153L94,129@5141L106,133@5252L160:ItemInformationActivity.kt#kcqqv0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(defaultAvatarControllerWrapper) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
            store2 = store;
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
        } else {
            boolean z3 = i4 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840372244, i3, -1, "com.box.android.preview.iteminformation.ItemInformationScreenWithBackHandler (ItemInformationActivity.kt:127)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -143865462, "CC(remember):ItemInformationActivity.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager) | ((i3 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.iteminformation.ItemInformationActivityKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemInformationActivityKt.ItemInformationScreenWithBackHandler$lambda$0$0(focusManager, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
            defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
            ItemInformationScreenKt.ItemInformationScreen(store, defaultAvatarControllerWrapper2, z3, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
            store2 = store;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper3 = defaultAvatarControllerWrapper2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationActivityKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemInformationActivityKt.ItemInformationScreenWithBackHandler$lambda$1(store2, defaultAvatarControllerWrapper3, z2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemInformationScreenWithBackHandler$lambda$0$0(FocusManager focusManager, Store store) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        store.send(ItemInformationReducer.Action.TriggerExit.INSTANCE);
        return Unit.INSTANCE;
    }
}
