package com.box.android.preview.item;

import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$24 extends FunctionReferenceImpl implements Function1<AudioPreviewReducer.Action, ItemPreviewReducer.Action.AudioPreview> {
    public static final ItemPreviewReducer$build$24 INSTANCE = new ItemPreviewReducer$build$24();

    ItemPreviewReducer$build$24() {
        super(1, ItemPreviewReducer.Action.AudioPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.AudioPreview invoke(AudioPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.AudioPreview(p0);
    }
}
