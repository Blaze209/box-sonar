package com.box.android.browse.compose;

import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderListingScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FolderListingScreenKt$ItemsList$1$1$2$4$1 extends FunctionReferenceImpl implements Function1<FilesDisplayConfigReducer.Action, ItemsListReducer.Action.FilesConfig> {
    public static final FolderListingScreenKt$ItemsList$1$1$2$4$1 INSTANCE = new FolderListingScreenKt$ItemsList$1$1$2$4$1();

    FolderListingScreenKt$ItemsList$1$1$2$4$1() {
        super(1, ItemsListReducer.Action.FilesConfig.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemsListReducer.Action.FilesConfig invoke(FilesDisplayConfigReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemsListReducer.Action.FilesConfig(p0);
    }
}
