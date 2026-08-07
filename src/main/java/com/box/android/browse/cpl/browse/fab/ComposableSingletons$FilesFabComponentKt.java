package com.box.android.browse.cpl.browse.fab;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.browse.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FilesFabComponent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FilesFabComponentKt {
    public static final ComposableSingletons$FilesFabComponentKt INSTANCE = new ComposableSingletons$FilesFabComponentKt();

    /* JADX INFO: renamed from: lambda$-1333148454, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f220lambda$1333148454 = ComposableLambdaKt.composableLambdaInstance(-1333148454, false, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.ComposableSingletons$FilesFabComponentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FilesFabComponentKt.lambda__1333148454$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-75142895, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f221lambda$75142895 = ComposableLambdaKt.composableLambdaInstance(-75142895, false, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.ComposableSingletons$FilesFabComponentKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FilesFabComponentKt.lambda__75142895$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1333148454$browse_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12199getLambda$1333148454$browse_generalProdRelease() {
        return f220lambda$1333148454;
    }

    /* JADX INFO: renamed from: getLambda$-75142895$browse_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12200getLambda$75142895$browse_generalProdRelease() {
        return f221lambda$75142895;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1333148454$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C264@10982L37,263@10949L149:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1333148454, i, -1, "com.box.android.browse.cpl.browse.fab.ComposableSingletons$FilesFabComponentKt.lambda$-1333148454.<anonymous> (FilesFabComponent.kt:263)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.select_files, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__75142895$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C275@11361L38,274@11328L150:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-75142895, i, -1, "com.box.android.browse.cpl.browse.fab.ComposableSingletons$FilesFabComponentKt.lambda$-75142895.<anonymous> (FilesFabComponent.kt:274)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.select_folder, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
