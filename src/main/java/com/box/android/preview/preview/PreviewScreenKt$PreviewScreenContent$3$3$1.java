package com.box.android.preview.preview;

import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewScreenKt$PreviewScreenContent$3$3$1 extends FunctionReferenceImpl implements Function0<Media3AudioPlayerManager> {
    PreviewScreenKt$PreviewScreenContent$3$3$1(Object obj) {
        super(0, obj, PreviewUIDependencyProvider.class, "getAudioPlayerManager", "getAudioPlayerManager()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Media3AudioPlayerManager invoke() {
        return ((PreviewUIDependencyProvider) this.receiver).getAudioPlayerManager();
    }
}
