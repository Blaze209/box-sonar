package com.box.android.contentpicker;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.compose.BoxThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContentPickerActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ContentPickerActivityKt {
    public static final ComposableSingletons$ContentPickerActivityKt INSTANCE = new ComposableSingletons$ContentPickerActivityKt();

    /* JADX INFO: renamed from: lambda$-424356967, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f227lambda$424356967 = ComposableLambdaKt.composableLambdaInstance(-424356967, false, new Function2() { // from class: com.box.android.contentpicker.ComposableSingletons$ContentPickerActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ContentPickerActivityKt.lambda__424356967$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$239491204 = ComposableLambdaKt.composableLambdaInstance(239491204, false, new Function2() { // from class: com.box.android.contentpicker.ComposableSingletons$ContentPickerActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ContentPickerActivityKt.lambda_239491204$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-424356967$content_picker_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12419getLambda$424356967$content_picker_generalProdRelease() {
        return f227lambda$424356967;
    }

    public final Function2<Composer, Integer, Unit> getLambda$239491204$content_picker_generalProdRelease() {
        return lambda$239491204;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_239491204$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2575L62:ContentPickerActivity.kt#tyt3w8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(239491204, i, -1, "com.box.android.contentpicker.ComposableSingletons$ContentPickerActivityKt.lambda$239491204.<anonymous> (ContentPickerActivity.kt:62)");
            }
            BoxThemeKt.BoxTheme(f227lambda$424356967, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__424356967$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2602L21:ContentPickerActivity.kt#tyt3w8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-424356967, i, -1, "com.box.android.contentpicker.ComposableSingletons$ContentPickerActivityKt.lambda$-424356967.<anonymous> (ContentPickerActivity.kt:63)");
            }
            ContentPickerScreenKt.ContentPickerScreen(null, null, null, null, null, composer, 0, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
