package com.box.android.preview.item;

import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$23 extends FunctionReferenceImpl implements Function1<AudioPreviewReducer.State, ItemState.Audio> {
    public static final ItemPreviewReducer$build$23 INSTANCE = new ItemPreviewReducer$build$23();

    ItemPreviewReducer$build$23() {
        super(1, ItemState.Audio.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Audio invoke(AudioPreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Audio(p0);
    }
}
