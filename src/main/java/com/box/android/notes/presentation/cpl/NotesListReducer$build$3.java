package com.box.android.notes.presentation.cpl;

import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NotesListReducer$build$3 extends FunctionReferenceImpl implements Function1<ItemsListReducer.Action, NotesListReducer.Action.ItemsListAction> {
    public static final NotesListReducer$build$3 INSTANCE = new NotesListReducer$build$3();

    NotesListReducer$build$3() {
        super(1, NotesListReducer.Action.ItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NotesListReducer.Action.ItemsListAction invoke(ItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new NotesListReducer.Action.ItemsListAction(p0);
    }
}
