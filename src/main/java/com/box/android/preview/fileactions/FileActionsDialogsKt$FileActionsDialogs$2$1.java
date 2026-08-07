package com.box.android.preview.fileactions;

import com.box.android.base.cpl.ItemActionConfirmationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsDialogs.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsDialogsKt$FileActionsDialogs$2$1 extends FunctionReferenceImpl implements Function1<ItemActionConfirmationReducer.Action, FileActionsReducer.Action.Delete> {
    public static final FileActionsDialogsKt$FileActionsDialogs$2$1 INSTANCE = new FileActionsDialogsKt$FileActionsDialogs$2$1();

    FileActionsDialogsKt$FileActionsDialogs$2$1() {
        super(1, FileActionsReducer.Action.Delete.class, "<init>", "<init>(Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.Delete invoke(ItemActionConfirmationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.Delete(p0);
    }
}
