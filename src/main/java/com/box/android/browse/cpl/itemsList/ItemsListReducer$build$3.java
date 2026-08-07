package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemsListReducer$build$3 extends FunctionReferenceImpl implements Function1<MultiselectReducer.Action, ItemsListReducer.Action.Multiselect> {
    public static final ItemsListReducer$build$3 INSTANCE = new ItemsListReducer$build$3();

    ItemsListReducer$build$3() {
        super(1, ItemsListReducer.Action.Multiselect.class, "<init>", "<init>(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemsListReducer.Action.Multiselect invoke(MultiselectReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemsListReducer.Action.Multiselect(p0);
    }
}
