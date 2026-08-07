package com.box.android.browse.cpl.copymove;

import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyOrMoveReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopyOrMoveReducer$build$3 extends FunctionReferenceImpl implements Function2<Integer, ItemsListReducer.Action, CopyOrMoveReducer.Action.ItemsList> {
    public static final CopyOrMoveReducer$build$3 INSTANCE = new CopyOrMoveReducer$build$3();

    CopyOrMoveReducer$build$3() {
        super(2, CopyOrMoveReducer.Action.ItemsList.class, "<init>", "<init>(ILcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", 0);
    }

    public final CopyOrMoveReducer.Action.ItemsList invoke(int i, ItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new CopyOrMoveReducer.Action.ItemsList(i, p1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ CopyOrMoveReducer.Action.ItemsList invoke(Integer num, ItemsListReducer.Action action) {
        return invoke(num.intValue(), action);
    }
}
