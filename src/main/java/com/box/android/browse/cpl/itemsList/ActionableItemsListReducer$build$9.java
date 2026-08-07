package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$9 extends FunctionReferenceImpl implements Function1<DownloadFilesReducer.Action, ActionableItemsListReducer.Action.DownloadAction> {
    public static final ActionableItemsListReducer$build$9 INSTANCE = new ActionableItemsListReducer$build$9();

    ActionableItemsListReducer$build$9() {
        super(1, ActionableItemsListReducer.Action.DownloadAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.DownloadAction invoke(DownloadFilesReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.DownloadAction(p0);
    }
}
