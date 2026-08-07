package com.box.android.preview.fileactions;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$1 extends FunctionReferenceImpl implements Function2<FileActionsReducer.State, FileActionsReducer.Action, ReducerResult<FileActionsReducer.State, FileActionsReducer.Action>> {
    FileActionsReducer$build$1(Object obj) {
        super(2, obj, FileActionsReducer.class, "reducePreviewItemActions", "reducePreviewItemActions(Lcom/box/android/preview/fileactions/FileActionsReducer$State;Lcom/box/android/preview/fileactions/FileActionsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<FileActionsReducer.State, FileActionsReducer.Action> invoke(FileActionsReducer.State p0, FileActionsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((FileActionsReducer) this.receiver).reducePreviewItemActions(p0, p1);
    }
}
