package com.box.android.preview.previewtype.boxnote;

import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.compose.ComposePreviewMocks;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxNotesCABView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxNotesCABViewKt {
    public static final ComposableSingletons$BoxNotesCABViewKt INSTANCE = new ComposableSingletons$BoxNotesCABViewKt();
    private static Function2<Composer, Integer, Unit> lambda$979032001 = ComposableLambdaKt.composableLambdaInstance(979032001, false, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.ComposableSingletons$BoxNotesCABViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxNotesCABViewKt.lambda_979032001$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2122963942 = ComposableLambdaKt.composableLambdaInstance(2122963942, false, new Function2() { // from class: com.box.android.preview.previewtype.boxnote.ComposableSingletons$BoxNotesCABViewKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxNotesCABViewKt.lambda_2122963942$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$2122963942$preview_generalProdRelease() {
        return lambda$2122963942;
    }

    public final Function2<Composer, Integer, Unit> getLambda$979032001$preview_generalProdRelease() {
        return lambda$979032001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2122963942$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C217@8979L463:BoxNotesCABView.kt#m6nu90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2122963942, i, -1, "com.box.android.preview.previewtype.boxnote.ComposableSingletons$BoxNotesCABViewKt.lambda$2122963942.<anonymous> (BoxNotesCABView.kt:217)");
            }
            SurfaceKt.m4323SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, lambda$979032001, composer, 12582912, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_979032001$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C218@9001L431:BoxNotesCABView.kt#m6nu90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(979032001, i, -1, "com.box.android.preview.previewtype.boxnote.ComposableSingletons$BoxNotesCABViewKt.lambda$979032001.<anonymous> (BoxNotesCABView.kt:218)");
            }
            BoxNotesCABViewKt.BoxNotesCABView(ComposePreviewUtilsKt.createMockStore(new BoxNoteEditModeReducer.State(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL(), "https://www.box.com/notes/...", true, null, true, true, false, null, null, null, 968, null)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
