package com.box.android.search.presentation;

import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchActivity$onCreate$1 extends FunctionReferenceImpl implements Function1<FolderModel, Unit> {
    SearchActivity$onCreate$1(Object obj) {
        super(1, obj, SearchActivity.class, "finishWithSelectedFolder", "finishWithSelectedFolder$search_generalProdRelease(Lcom/box/android/domain/models/item/FolderModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderModel folderModel) {
        invoke2(folderModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SearchActivity) this.receiver).finishWithSelectedFolder$search_generalProdRelease(p0);
    }
}
