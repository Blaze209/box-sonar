package com.box.android.preview.previousversion;

import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionReducer$build$11 extends FunctionReferenceImpl implements Function1<VideoPreviewReducer.State, ItemState.Video> {
    public static final PreviousVersionReducer$build$11 INSTANCE = new PreviousVersionReducer$build$11();

    PreviousVersionReducer$build$11() {
        super(1, ItemState.Video.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Video invoke(VideoPreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Video(p0);
    }
}
