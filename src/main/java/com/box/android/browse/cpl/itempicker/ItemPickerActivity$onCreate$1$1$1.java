package com.box.android.browse.cpl.itempicker;

import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPickerActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPickerActivity$onCreate$1$1$1 extends FunctionReferenceImpl implements Function1<FolderModel, Unit> {
    ItemPickerActivity$onCreate$1$1$1(Object obj) {
        super(1, obj, ItemPickerActivity.class, "onInviteCollaborators", "onInviteCollaborators(Lcom/box/android/domain/models/item/FolderModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderModel folderModel) {
        invoke2(folderModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ItemPickerActivity) this.receiver).onInviteCollaborators(p0);
    }
}
