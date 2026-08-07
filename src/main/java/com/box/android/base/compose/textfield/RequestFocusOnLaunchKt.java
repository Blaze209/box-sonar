package com.box.android.base.compose.textfield;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.focus.FocusRequester;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RequestFocusOnLaunch.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"RequestFocusOnLaunch", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY, "", "(Landroidx/compose/ui/focus/FocusRequester;JLandroidx/compose/runtime/Composer;II)V", "base_generalProdRelease", "wasKeyboardOpened", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RequestFocusOnLaunchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RequestFocusOnLaunch$lambda$4(FocusRequester focusRequester, long j, int i, int i2, Composer composer, int i3) {
        RequestFocusOnLaunch(focusRequester, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RequestFocusOnLaunch(final FocusRequester focusRequester, long j, Composer composer, final int i, final int i2) {
        int i3;
        final long j2;
        long j3;
        RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1 requestFocusOnLaunchKt$RequestFocusOnLaunch$1$1;
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Composer composerStartRestartGroup = composer.startRestartGroup(-571729873);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RequestFocusOnLaunch)N(focusRequester,delay)17@639L37,17@622L54,21@703L253,21@682L274:RequestFocusOnLaunch.kt#fjpkir");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(focusRequester) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            j2 = j;
        } else {
            long j4 = i4 != 0 ? 200L : j;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-571729873, i3, -1, "com.box.android.base.compose.textfield.RequestFocusOnLaunch (RequestFocusOnLaunch.kt:16)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 323410260, "CC(remember):RequestFocusOnLaunch.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.textfield.RequestFocusOnLaunchKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RequestFocusOnLaunchKt.RequestFocusOnLaunch$lambda$0$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 323412524, "CC(remember):RequestFocusOnLaunch.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState) | ((i3 & 112) == 32) | ((i3 & 14) == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                j3 = j4;
                requestFocusOnLaunchKt$RequestFocusOnLaunch$1$1 = new RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1(j3, focusRequester, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(requestFocusOnLaunchKt$RequestFocusOnLaunch$1$1);
            } else {
                requestFocusOnLaunchKt$RequestFocusOnLaunch$1$1 = objRememberedValue2;
                j3 = j4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) requestFocusOnLaunchKt$RequestFocusOnLaunch$1$1, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.textfield.RequestFocusOnLaunchKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RequestFocusOnLaunchKt.RequestFocusOnLaunch$lambda$4(focusRequester, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RequestFocusOnLaunch$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RequestFocusOnLaunch$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState RequestFocusOnLaunch$lambda$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }
}
