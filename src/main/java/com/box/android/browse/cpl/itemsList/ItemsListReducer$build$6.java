package com.box.android.browse.cpl.itemsList;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemsListReducer$build$6 extends FunctionReferenceImpl implements Function1<FilesDisplayConfigReducer.Action, ItemsListReducer.Action.FilesConfig> {
    public static final ItemsListReducer$build$6 INSTANCE = new ItemsListReducer$build$6();

    ItemsListReducer$build$6() {
        super(1, ItemsListReducer.Action.FilesConfig.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemsListReducer.Action.FilesConfig invoke(FilesDisplayConfigReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemsListReducer.Action.FilesConfig(p0);
    }
}
