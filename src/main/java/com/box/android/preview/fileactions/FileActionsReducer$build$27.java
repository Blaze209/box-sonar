package com.box.android.preview.fileactions;

import com.box.android.boxai.BoxAiCenterReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$27 extends FunctionReferenceImpl implements Function1<BoxAiCenterReducer.Action, FileActionsReducer.Action.BoxAiCenter> {
    public static final FileActionsReducer$build$27 INSTANCE = new FileActionsReducer$build$27();

    FileActionsReducer$build$27() {
        super(1, FileActionsReducer.Action.BoxAiCenter.class, "<init>", "<init>(Lcom/box/android/boxai/BoxAiCenterReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.BoxAiCenter invoke(BoxAiCenterReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.BoxAiCenter(p0);
    }
}
