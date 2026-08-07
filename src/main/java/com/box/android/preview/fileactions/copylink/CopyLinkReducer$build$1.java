package com.box.android.preview.fileactions.copylink;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyLinkReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopyLinkReducer$build$1 extends FunctionReferenceImpl implements Function2<CopyLinkReducer.State, CopyLinkReducer.Action, ReducerResult<CopyLinkReducer.State, CopyLinkReducer.Action>> {
    CopyLinkReducer$build$1(Object obj) {
        super(2, obj, CopyLinkReducer.class, "reduceCopyLink", "reduceCopyLink(Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CopyLinkReducer.State, CopyLinkReducer.Action> invoke(CopyLinkReducer.State p0, CopyLinkReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CopyLinkReducer) this.receiver).reduceCopyLink(p0, p1);
    }
}
