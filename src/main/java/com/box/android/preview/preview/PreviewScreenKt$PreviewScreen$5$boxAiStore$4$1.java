package com.box.android.preview.preview;

import com.box.android.boxai.BoxAiReducer;
import com.box.android.preview.fileactions.FileActionsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewScreenKt$PreviewScreen$5$boxAiStore$4$1 extends FunctionReferenceImpl implements Function1<BoxAiReducer.Action, FileActionsReducer.Action.BoxAi> {
    public static final PreviewScreenKt$PreviewScreen$5$boxAiStore$4$1 INSTANCE = new PreviewScreenKt$PreviewScreen$5$boxAiStore$4$1();

    PreviewScreenKt$PreviewScreen$5$boxAiStore$4$1() {
        super(1, FileActionsReducer.Action.BoxAi.class, "<init>", "<init>(Lcom/box/android/boxai/BoxAiReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.BoxAi invoke(BoxAiReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.BoxAi(p0);
    }
}
