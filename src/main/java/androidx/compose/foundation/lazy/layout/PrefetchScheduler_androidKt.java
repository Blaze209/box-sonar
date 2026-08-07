package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.foundation.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrefetchScheduler.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0007\u0012\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "RobolectricImpl", "androidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1", "getRobolectricImpl$annotations", "()V", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrefetchScheduler_androidKt {
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    private static /* synthetic */ void getRobolectricImpl$annotations() {
    }

    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer composer, int i) {
        PrefetchScheduler_androidKt$RobolectricImpl$1 prefetchScheduler_androidKt$RobolectricImpl$1;
        ComposerKt.sourceInformationMarkerStart(composer, 1141871251, "C(rememberDefaultPrefetchScheduler):PrefetchScheduler.android.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141871251, i, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:36)");
        }
        PrefetchScheduler_androidKt$RobolectricImpl$1 prefetchScheduler_androidKt$RobolectricImpl$2 = RobolectricImpl;
        if (prefetchScheduler_androidKt$RobolectricImpl$2 != null) {
            composer.startReplaceGroup(1345554384);
            composer.endReplaceGroup();
            prefetchScheduler_androidKt$RobolectricImpl$1 = prefetchScheduler_androidKt$RobolectricImpl$2;
        } else {
            composer.startReplaceGroup(1345603457);
            ComposerKt.sourceInformation(composer, "40@1441L7,41@1457L377");
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composer);
            View view = (View) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 2121617996, "CC(remember):PrefetchScheduler.android.kt#9igjgp");
            boolean zChanged = composer.changed(view);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object tag = view.getTag(R.id.compose_prefetch_scheduler);
                Object obj = tag instanceof PrefetchScheduler ? (PrefetchScheduler) tag : null;
                if (obj == null) {
                    Object androidPrefetchScheduler = new AndroidPrefetchScheduler(view);
                    view.setTag(R.id.compose_prefetch_scheduler, androidPrefetchScheduler);
                    obj = (PrefetchScheduler) androidPrefetchScheduler;
                }
                objRememberedValue = obj;
                composer.updateRememberedValue(objRememberedValue);
            }
            prefetchScheduler_androidKt$RobolectricImpl$1 = (PrefetchScheduler) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return prefetchScheduler_androidKt$RobolectricImpl$1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrefetchScheduler_androidKt$RobolectricImpl$1 prefetchScheduler_androidKt$RobolectricImpl$1;
        if (Build.FINGERPRINT != null) {
            String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "robolectric")) {
                prefetchScheduler_androidKt$RobolectricImpl$1 = new PrefetchScheduler() { // from class: androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt$RobolectricImpl$1
                    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
                    public void schedulePrefetch(PrefetchRequest prefetchRequest) {
                    }
                };
            } else {
                prefetchScheduler_androidKt$RobolectricImpl$1 = 0;
            }
        } else {
            prefetchScheduler_androidKt$RobolectricImpl$1 = 0;
        }
        RobolectricImpl = prefetchScheduler_androidKt$RobolectricImpl$1;
    }
}
