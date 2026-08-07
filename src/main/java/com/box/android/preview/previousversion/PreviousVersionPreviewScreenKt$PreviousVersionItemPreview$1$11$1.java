package com.box.android.preview.previousversion;

import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1 extends FunctionReferenceImpl implements Function1<VideoPreviewReducer.Action, PreviousVersionReducer.Action.Video> {
    public static final PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1 INSTANCE = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1();

    PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1() {
        super(1, PreviousVersionReducer.Action.Video.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviousVersionReducer.Action.Video invoke(VideoPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviousVersionReducer.Action.Video(p0);
    }
}
