package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$6 extends FunctionReferenceImpl implements Function1<OfflineFilesReducer.Action, ActionableItemsListReducer.Action.OfflineFilesAction> {
    public static final ActionableItemsListReducer$build$6 INSTANCE = new ActionableItemsListReducer$build$6();

    ActionableItemsListReducer$build$6() {
        super(1, ActionableItemsListReducer.Action.OfflineFilesAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.OfflineFilesAction invoke(OfflineFilesReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.OfflineFilesAction(p0);
    }
}
