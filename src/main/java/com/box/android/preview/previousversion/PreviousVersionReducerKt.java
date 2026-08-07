package com.box.android.preview.previousversion;

import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"annotationAction", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Companion;", "state", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", Analytics.Data.ACTION, "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionReducerKt {
    public static final PreviousVersionReducer.Action annotationAction(PreviousVersionReducer.Action.Companion companion, PreviousVersionReducer.State state, AnnotationsReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        ItemState itemState = state.getItemState();
        if (itemState instanceof ItemState.Document) {
            return new PreviousVersionReducer.Action.Document(new DocumentPreviewReducer.Action.Annotations(action));
        }
        if (itemState instanceof ItemState.Image) {
            return new PreviousVersionReducer.Action.Image(new ImagePreviewReducer.Action.Annotations(action));
        }
        if (itemState instanceof ItemState.Video) {
            return new PreviousVersionReducer.Action.Video(new VideoPreviewReducer.Action.FrameAnnotation(new FrameAnnotationReducer.Action.Annotations(action)));
        }
        return null;
    }
}
