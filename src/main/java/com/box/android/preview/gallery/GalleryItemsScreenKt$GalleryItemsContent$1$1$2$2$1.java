package com.box.android.preview.gallery;

import com.box.android.base.cpl.ItemThumbnailReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalleryItemsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1 extends FunctionReferenceImpl implements Function2<String, ItemThumbnailReducer.Action, GalleryItemsReducer.Action.ItemThumbnailAction> {
    public static final GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1 INSTANCE = new GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1();

    GalleryItemsScreenKt$GalleryItemsContent$1$1$2$2$1() {
        super(2, GalleryItemsReducer.Action.ItemThumbnailAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final GalleryItemsReducer.Action.ItemThumbnailAction invoke(String p0, ItemThumbnailReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new GalleryItemsReducer.Action.ItemThumbnailAction(p0, p1);
    }
}
