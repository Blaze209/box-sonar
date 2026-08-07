package com.box.android.browse.cpl.browse;

import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseFragment$onCreateView$1$1$1$1$1 extends FunctionReferenceImpl implements Function2<FolderModel, String, Unit> {
    BrowseFragment$onCreateView$1$1$1$1$1(Object obj) {
        super(2, obj, BrowseFragment.class, "createNewDocument", "createNewDocument(Lcom/box/android/domain/models/item/FolderModel;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(FolderModel folderModel, String str) {
        invoke2(folderModel, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderModel p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((BrowseFragment) this.receiver).createNewDocument(p0, p1);
    }
}
