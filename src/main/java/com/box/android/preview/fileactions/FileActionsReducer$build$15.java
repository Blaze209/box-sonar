package com.box.android.preview.fileactions;

import com.box.android.preview.fileactions.openin.OpenInReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$15 extends FunctionReferenceImpl implements Function1<OpenInReducer.Action, FileActionsReducer.Action.OpenIn> {
    public static final FileActionsReducer$build$15 INSTANCE = new FileActionsReducer$build$15();

    FileActionsReducer$build$15() {
        super(1, FileActionsReducer.Action.OpenIn.class, "<init>", "<init>(Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.OpenIn invoke(OpenInReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.OpenIn(p0);
    }
}
