package com.box.android.browse.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.browse.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxBrowseToolbars.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxBrowseToolbarsKt {
    public static final ComposableSingletons$BoxBrowseToolbarsKt INSTANCE = new ComposableSingletons$BoxBrowseToolbarsKt();
    private static Function2<Composer, Integer, Unit> lambda$540913569 = ComposableLambdaKt.composableLambdaInstance(540913569, false, new Function2() { // from class: com.box.android.browse.compose.ComposableSingletons$BoxBrowseToolbarsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxBrowseToolbarsKt.lambda_540913569$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$540913569$browse_generalProdRelease() {
        return lambda$540913569;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_540913569$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1488L53,41@1588L50,39@1447L213:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(540913569, i, -1, "com.box.android.browse.compose.ComposableSingletons$BoxBrowseToolbarsKt.lambda$540913569.<anonymous> (BoxBrowseToolbars.kt:39)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_toolbar_close_btn, composer, 0), StringResources_androidKt.stringResource(R.string.talkback_label_close, composer, 0), (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
