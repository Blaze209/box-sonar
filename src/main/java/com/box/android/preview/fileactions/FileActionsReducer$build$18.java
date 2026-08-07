package com.box.android.preview.fileactions;

import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$18 extends FunctionReferenceImpl implements Function1<DownloadFilesReducer.Action, FileActionsReducer.Action.Download> {
    public static final FileActionsReducer$build$18 INSTANCE = new FileActionsReducer$build$18();

    FileActionsReducer$build$18() {
        super(1, FileActionsReducer.Action.Download.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.Download invoke(DownloadFilesReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.Download(p0);
    }
}
