package com.box.android.browse.compose;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderListingScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FolderListingScreenKt {
    public static final ComposableSingletons$FolderListingScreenKt INSTANCE = new ComposableSingletons$FolderListingScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1444657248 = ComposableLambdaKt.composableLambdaInstance(1444657248, false, new Function3() { // from class: com.box.android.browse.compose.ComposableSingletons$FolderListingScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$FolderListingScreenKt.lambda_1444657248$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1444657248$browse_generalProdRelease() {
        return lambda$1444657248;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1444657248$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C353@15361L14:FolderListingScreen.kt#9mvyw3");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444657248, i, -1, "com.box.android.browse.compose.ComposableSingletons$FolderListingScreenKt.lambda$1444657248.<anonymous> (FolderListingScreen.kt:353)");
            }
            FolderListingScreenKt.LoadMoreItem(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
