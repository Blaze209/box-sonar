package com.box.android.browse.search;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FilesSearchReducer$build$1 extends FunctionReferenceImpl implements Function2<FilesSearchReducer.State, FilesSearchReducer.Action, ReducerResult<FilesSearchReducer.State, FilesSearchReducer.Action>> {
    FilesSearchReducer$build$1(Object obj) {
        super(2, obj, FilesSearchReducer.class, "reduceFilesSearch", "reduceFilesSearch(Lcom/box/android/browse/search/FilesSearchReducer$State;Lcom/box/android/browse/search/FilesSearchReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<FilesSearchReducer.State, FilesSearchReducer.Action> invoke(FilesSearchReducer.State p0, FilesSearchReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((FilesSearchReducer) this.receiver).reduceFilesSearch(p0, p1);
    }
}
