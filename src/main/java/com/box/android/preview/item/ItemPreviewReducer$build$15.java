package com.box.android.preview.item;

import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$15 extends FunctionReferenceImpl implements Function1<VideoPreviewReducer.State, ItemState.Video> {
    public static final ItemPreviewReducer$build$15 INSTANCE = new ItemPreviewReducer$build$15();

    ItemPreviewReducer$build$15() {
        super(1, ItemState.Video.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Video invoke(VideoPreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Video(p0);
    }
}
