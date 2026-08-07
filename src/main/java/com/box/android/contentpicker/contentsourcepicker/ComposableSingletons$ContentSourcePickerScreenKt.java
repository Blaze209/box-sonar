package com.box.android.contentpicker.contentsourcepicker;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentSourcePickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ContentSourcePickerScreenKt {
    public static final ComposableSingletons$ContentSourcePickerScreenKt INSTANCE = new ComposableSingletons$ContentSourcePickerScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$2128783273 = ComposableLambdaKt.composableLambdaInstance(2128783273, false, new Function3() { // from class: com.box.android.contentpicker.contentsourcepicker.ComposableSingletons$ContentSourcePickerScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ContentSourcePickerScreenKt.lambda_2128783273$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-908272000, reason: not valid java name */
    private static Function4<LazyItemScope, Integer, Composer, Integer, Unit> f228lambda$908272000 = ComposableLambdaKt.composableLambdaInstance(-908272000, false, new Function4() { // from class: com.box.android.contentpicker.contentsourcepicker.ComposableSingletons$ContentSourcePickerScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$ContentSourcePickerScreenKt.lambda__908272000$lambda$0((LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-908272000$content_picker_generalProdRelease, reason: not valid java name */
    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> m12427getLambda$908272000$content_picker_generalProdRelease() {
        return f228lambda$908272000;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$2128783273$content_picker_generalProdRelease() {
        return lambda$2128783273;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2128783273$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C246@10310L29:ContentSourcePickerScreen.kt#53w6ms");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128783273, i, -1, "com.box.android.contentpicker.contentsourcepicker.ComposableSingletons$ContentSourcePickerScreenKt.lambda$2128783273.<anonymous> (ContentSourcePickerScreen.kt:246)");
            }
            ContentSourcePickerScreenKt.SkeletonRecentsCarouselItem(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__908272000$lambda$0(LazyItemScope items, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation(composer, "CN(it)257@10715L29,258@10765L28:ContentSourcePickerScreen.kt#53w6ms");
        if (!composer.shouldExecute((i2 & 129) != 128, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-908272000, i2, -1, "com.box.android.contentpicker.contentsourcepicker.ComposableSingletons$ContentSourcePickerScreenKt.lambda$-908272000.<anonymous> (ContentSourcePickerScreen.kt:257)");
            }
            ContentSourcePickerScreenKt.SkeletonRecentsCarouselItem(composer, 0);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
