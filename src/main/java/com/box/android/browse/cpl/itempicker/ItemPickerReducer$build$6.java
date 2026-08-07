package com.box.android.browse.cpl.itempicker;

import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPickerReducer$build$6 extends FunctionReferenceImpl implements Function1<CreateFolderReducer.Action, ItemPickerReducer.Action.CreateFolderParentAction> {
    public static final ItemPickerReducer$build$6 INSTANCE = new ItemPickerReducer$build$6();

    ItemPickerReducer$build$6() {
        super(1, ItemPickerReducer.Action.CreateFolderParentAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPickerReducer.Action.CreateFolderParentAction invoke(CreateFolderReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPickerReducer.Action.CreateFolderParentAction(p0);
    }
}
