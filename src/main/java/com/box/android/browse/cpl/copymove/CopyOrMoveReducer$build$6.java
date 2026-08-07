package com.box.android.browse.cpl.copymove;

import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyOrMoveReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopyOrMoveReducer$build$6 extends FunctionReferenceImpl implements Function1<CreateFolderReducer.Action, CopyOrMoveReducer.Action.CreateFolderParentAction> {
    public static final CopyOrMoveReducer$build$6 INSTANCE = new CopyOrMoveReducer$build$6();

    CopyOrMoveReducer$build$6() {
        super(1, CopyOrMoveReducer.Action.CreateFolderParentAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CopyOrMoveReducer.Action.CreateFolderParentAction invoke(CreateFolderReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CopyOrMoveReducer.Action.CreateFolderParentAction(p0);
    }
}
