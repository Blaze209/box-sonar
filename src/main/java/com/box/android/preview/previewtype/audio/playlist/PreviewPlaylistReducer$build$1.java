package com.box.android.preview.previewtype.audio.playlist;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewPlaylistReducer$build$1 extends FunctionReferenceImpl implements Function2<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action, ReducerResult<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action>> {
    PreviewPlaylistReducer$build$1(Object obj) {
        super(2, obj, PreviewPlaylistReducer.class, "reducePlaylist", "reducePlaylist(Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> invoke(PreviewPlaylistReducer.State p0, PreviewPlaylistReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((PreviewPlaylistReducer) this.receiver).reducePlaylist(p0, p1);
    }
}
