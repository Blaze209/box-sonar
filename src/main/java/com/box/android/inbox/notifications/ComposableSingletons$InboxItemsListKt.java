package com.box.android.inbox.notifications;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemsList.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxItemsListKt {
    public static final ComposableSingletons$InboxItemsListKt INSTANCE = new ComposableSingletons$InboxItemsListKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1977082503 = ComposableLambdaKt.composableLambdaInstance(1977082503, false, new Function3() { // from class: com.box.android.inbox.notifications.ComposableSingletons$InboxItemsListKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InboxItemsListKt.lambda_1977082503$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1977082503$box_generalProdRelease() {
        return lambda$1977082503;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1977082503$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C209@8617L19:InboxItemsList.kt#1rb0q9");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1977082503, i, -1, "com.box.android.inbox.notifications.ComposableSingletons$InboxItemsListKt.lambda$1977082503.<anonymous> (InboxItemsList.kt:209)");
            }
            InboxItemsListKt.InboxLoadMoreItem(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
