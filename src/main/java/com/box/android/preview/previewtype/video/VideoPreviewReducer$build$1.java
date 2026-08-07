package com.box.android.preview.previewtype.video;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoPreviewReducer$build$1 extends FunctionReferenceImpl implements Function2<VideoPreviewReducer.State, VideoPreviewReducer.Action, ReducerResult<VideoPreviewReducer.State, VideoPreviewReducer.Action>> {
    VideoPreviewReducer$build$1(Object obj) {
        super(2, obj, VideoPreviewReducer.class, "reduceVideoPreview", "reduceVideoPreview(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<VideoPreviewReducer.State, VideoPreviewReducer.Action> invoke(VideoPreviewReducer.State p0, VideoPreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((VideoPreviewReducer) this.receiver).reduceVideoPreview(p0, p1);
    }
}
