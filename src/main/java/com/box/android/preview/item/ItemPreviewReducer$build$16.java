package com.box.android.preview.item;

import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$16 extends FunctionReferenceImpl implements Function1<VideoPreviewReducer.Action, ItemPreviewReducer.Action.VideoPreview> {
    public static final ItemPreviewReducer$build$16 INSTANCE = new ItemPreviewReducer$build$16();

    ItemPreviewReducer$build$16() {
        super(1, ItemPreviewReducer.Action.VideoPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.VideoPreview invoke(VideoPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.VideoPreview(p0);
    }
}
