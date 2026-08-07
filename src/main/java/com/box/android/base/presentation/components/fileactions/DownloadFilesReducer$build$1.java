package com.box.android.base.presentation.components.fileactions;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DownloadFilesReducer$build$1 extends FunctionReferenceImpl implements Function2<DownloadFilesReducer.State, DownloadFilesReducer.Action, ReducerResult<DownloadFilesReducer.State, DownloadFilesReducer.Action>> {
    DownloadFilesReducer$build$1(Object obj) {
        super(2, obj, DownloadFilesReducer.class, "reduceDownload", "reduceDownload(Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<DownloadFilesReducer.State, DownloadFilesReducer.Action> invoke(DownloadFilesReducer.State p0, DownloadFilesReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((DownloadFilesReducer) this.receiver).reduceDownload(p0, p1);
    }
}
