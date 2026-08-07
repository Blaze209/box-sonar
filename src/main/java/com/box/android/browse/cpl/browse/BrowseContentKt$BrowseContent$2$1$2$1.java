package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseContentKt$BrowseContent$2$1$2$1 extends FunctionReferenceImpl implements Function1<CreateFolderReducer.Action, BrowseReducer.Action.CreateFolderChildAction> {
    public static final BrowseContentKt$BrowseContent$2$1$2$1 INSTANCE = new BrowseContentKt$BrowseContent$2$1$2$1();

    BrowseContentKt$BrowseContent$2$1$2$1() {
        super(1, BrowseReducer.Action.CreateFolderChildAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BrowseReducer.Action.CreateFolderChildAction invoke(CreateFolderReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BrowseReducer.Action.CreateFolderChildAction(p0);
    }
}
