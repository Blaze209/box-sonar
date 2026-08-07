package com.box.android.preview.gallery;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalleryItemsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class GalleryItemsReducer$build$1 extends FunctionReferenceImpl implements Function2<GalleryItemsReducer.State, GalleryItemsReducer.Action, ReducerResult<GalleryItemsReducer.State, GalleryItemsReducer.Action>> {
    GalleryItemsReducer$build$1(Object obj) {
        super(2, obj, GalleryItemsReducer.class, "reduceGallery", "reduceGallery(Lcom/box/android/preview/gallery/GalleryItemsReducer$State;Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<GalleryItemsReducer.State, GalleryItemsReducer.Action> invoke(GalleryItemsReducer.State p0, GalleryItemsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((GalleryItemsReducer) this.receiver).reduceGallery(p0, p1);
    }
}
