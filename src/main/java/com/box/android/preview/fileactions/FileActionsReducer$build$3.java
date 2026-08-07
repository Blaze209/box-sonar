package com.box.android.preview.fileactions;

import com.box.android.preview.fileactions.copylink.CopyLinkReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$3 extends FunctionReferenceImpl implements Function1<CopyLinkReducer.Action, FileActionsReducer.Action.CopyLink> {
    public static final FileActionsReducer$build$3 INSTANCE = new FileActionsReducer$build$3();

    FileActionsReducer$build$3() {
        super(1, FileActionsReducer.Action.CopyLink.class, "<init>", "<init>(Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.CopyLink invoke(CopyLinkReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.CopyLink(p0);
    }
}
