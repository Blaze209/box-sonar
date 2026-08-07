package com.box.android.base.compose;

import android.app.Activity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: IsInActionMode.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\u0012\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00010\u0001X\u008a\u0084\u0002"}, d2 = {"isInActionMode", "", "(Landroidx/compose/runtime/Composer;I)Z", "base_generalProdRelease", "isActionMode", "kotlin.jvm.PlatformType"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IsInActionModeKt {
    public static final boolean isInActionMode(Composer composer, int i) {
        composer.startReplaceGroup(1824668970);
        ComposerKt.sourceInformation(composer, "C(isInActionMode)16@494L7,17@594L16:IsInActionMode.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1824668970, i, -1, "com.box.android.base.compose.isInActionMode (IsInActionMode.kt:15)");
        }
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        BoxFragmentActivity boxFragmentActivity = objConsume instanceof BoxFragmentActivity ? (BoxFragmentActivity) objConsume : null;
        if (boxFragmentActivity == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return false;
        }
        StateFlow<Boolean> isInActionModeFlow = boxFragmentActivity.getIsInActionModeFlow();
        Intrinsics.checkNotNullExpressionValue(isInActionModeFlow, "getIsInActionModeFlow(...)");
        Boolean boolIsInActionMode$lambda$0 = isInActionMode$lambda$0(SnapshotStateKt.collectAsState(isInActionModeFlow, null, composer, 0, 1));
        Intrinsics.checkNotNullExpressionValue(boolIsInActionMode$lambda$0, "isInActionMode$lambda$0(...)");
        boolean zBooleanValue = boolIsInActionMode$lambda$0.booleanValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return zBooleanValue;
    }

    private static final Boolean isInActionMode$lambda$0(State<Boolean> state) {
        return state.getValue();
    }
}
