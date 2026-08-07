package com.box.android.preview.iteminformation;

import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemInformationReducer$build$3 extends FunctionReferenceImpl implements Function1<UpdateItemInfoReducer.Action, ItemInformationReducer.Action.UpdateItemInfo> {
    public static final ItemInformationReducer$build$3 INSTANCE = new ItemInformationReducer$build$3();

    ItemInformationReducer$build$3() {
        super(1, ItemInformationReducer.Action.UpdateItemInfo.class, "<init>", "<init>(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemInformationReducer.Action.UpdateItemInfo invoke(UpdateItemInfoReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemInformationReducer.Action.UpdateItemInfo(p0);
    }
}
