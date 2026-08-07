package com.box.android.base.presentation.components.topbar;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxPrimaryTopBarKt {
    public static final ComposableSingletons$BoxPrimaryTopBarKt INSTANCE = new ComposableSingletons$BoxPrimaryTopBarKt();

    /* JADX INFO: renamed from: lambda$-910396438, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f186lambda$910396438 = ComposableLambdaKt.composableLambdaInstance(-910396438, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.ComposableSingletons$BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxPrimaryTopBarKt.lambda__910396438$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-910396438$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11836getLambda$910396438$base_generalProdRelease() {
        return f186lambda$910396438;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__910396438$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5018L37,116@5098L31,117@5167L6,114@4982L220:BoxPrimaryTopBar.kt#9psp5c");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-910396438, i, -1, "com.box.android.base.presentation.components.topbar.ComposableSingletons$BoxPrimaryTopBarKt.lambda$-910396438.<anonymous> (BoxPrimaryTopBar.kt:114)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_search, composer, 0), StringResources_androidKt.stringResource(R.string.search, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
