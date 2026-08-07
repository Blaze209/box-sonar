package com.box.android.preview.previewtype.document.copytext;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxTypography;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectedTextOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SelectedTextOverlayKt {
    public static final ComposableSingletons$SelectedTextOverlayKt INSTANCE = new ComposableSingletons$SelectedTextOverlayKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1481805436 = ComposableLambdaKt.composableLambdaInstance(1481805436, false, new Function3() { // from class: com.box.android.preview.previewtype.document.copytext.ComposableSingletons$SelectedTextOverlayKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SelectedTextOverlayKt.lambda_1481805436$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1481805436$preview_generalProdRelease() {
        return lambda$1481805436;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1481805436$lambda$0(RowScope PreviewPopupButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PreviewPopupButton, "$this$PreviewPopupButton");
        ComposerKt.sourceInformation(composer, "C76@2956L47,78@3081L6,75@2931L184:SelectedTextOverlay.kt#afh64s");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1481805436, i, -1, "com.box.android.preview.previewtype.document.copytext.ComposableSingletons$SelectedTextOverlayKt.lambda$1481805436.<anonymous> (SelectedTextOverlay.kt:75)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.copy_button_label, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxMedium12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
