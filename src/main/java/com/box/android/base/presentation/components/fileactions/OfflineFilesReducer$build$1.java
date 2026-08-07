package com.box.android.base.presentation.components.fileactions;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class OfflineFilesReducer$build$1 extends FunctionReferenceImpl implements Function2<OfflineFilesReducer.State, OfflineFilesReducer.Action, ReducerResult<OfflineFilesReducer.State, OfflineFilesReducer.Action>> {
    OfflineFilesReducer$build$1(Object obj) {
        super(2, obj, OfflineFilesReducer.class, "reduceOffline", "reduceOffline(Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<OfflineFilesReducer.State, OfflineFilesReducer.Action> invoke(OfflineFilesReducer.State p0, OfflineFilesReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((OfflineFilesReducer) this.receiver).reduceOffline(p0, p1);
    }
}
