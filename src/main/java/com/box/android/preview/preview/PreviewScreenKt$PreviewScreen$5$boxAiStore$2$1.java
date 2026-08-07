package com.box.android.preview.preview;

import com.box.android.preview.fileactions.FileActionsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewScreenKt$PreviewScreen$5$boxAiStore$2$1 extends FunctionReferenceImpl implements Function1<FileActionsReducer.Action, PreviewReducer.Action.FileActionsAction> {
    public static final PreviewScreenKt$PreviewScreen$5$boxAiStore$2$1 INSTANCE = new PreviewScreenKt$PreviewScreen$5$boxAiStore$2$1();

    PreviewScreenKt$PreviewScreen$5$boxAiStore$2$1() {
        super(1, PreviewReducer.Action.FileActionsAction.class, "<init>", "<init>(Lcom/box/android/preview/fileactions/FileActionsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviewReducer.Action.FileActionsAction invoke(FileActionsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviewReducer.Action.FileActionsAction(p0);
    }
}
