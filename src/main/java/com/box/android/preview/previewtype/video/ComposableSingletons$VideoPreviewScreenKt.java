package com.box.android.preview.previewtype.video;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$VideoPreviewScreenKt {
    public static final ComposableSingletons$VideoPreviewScreenKt INSTANCE = new ComposableSingletons$VideoPreviewScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1691579990 = ComposableLambdaKt.composableLambdaInstance(1691579990, false, new Function2() { // from class: com.box.android.preview.previewtype.video.ComposableSingletons$VideoPreviewScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$VideoPreviewScreenKt.lambda_1691579990$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1691579990$preview_generalProdRelease() {
        return lambda$1691579990;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1691579990$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C319@13691L29,317@13585L246:VideoPreviewScreen.kt#278b2y");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691579990, i, -1, "com.box.android.preview.previewtype.video.ComposableSingletons$VideoPreviewScreenKt.lambda$1691579990.<anonymous> (VideoPreviewScreen.kt:317)");
            }
            IconKt.m3576Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.play, composer, 0), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), Color.INSTANCE.m6851getWhite0d7_KjU(), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
