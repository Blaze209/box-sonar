package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1 extends FunctionReferenceImpl implements Function1<FilesFabReducer.Action, BrowseReducer.Action.FabMenuChildAction> {
    public static final BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1 INSTANCE = new BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1();

    BrowseFragmentKt$BrowseFragmentContent$1$1$1$2$1() {
        super(1, BrowseReducer.Action.FabMenuChildAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BrowseReducer.Action.FabMenuChildAction invoke(FilesFabReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BrowseReducer.Action.FabMenuChildAction(p0);
    }
}
