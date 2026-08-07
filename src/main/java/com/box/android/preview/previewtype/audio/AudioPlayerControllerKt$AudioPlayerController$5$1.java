package com.box.android.preview.previewtype.audio;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.session.MediaController;
import com.box.android.cpl.Store;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.previewtype.audio.listener.AudioPlayerCurrentTrackStateListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioPlayerController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$AudioPlayerController$5$1", f = "AudioPlayerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AudioPlayerControllerKt$AudioPlayerController$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> $audioStore;
    final /* synthetic */ MutableState<AudioPlayerCurrentTrackStateListener> $currentAudioTrackListener$delegate;
    final /* synthetic */ Function0<Media3AudioPlayerManager> $getAudioPlayerManager;
    final /* synthetic */ MutableState<MediaController> $mediaController$delegate;
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioPlayerControllerKt$AudioPlayerController$5$1(Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> store, Function0<Media3AudioPlayerManager> function0, MutableState<MediaController> mutableState, MutableState<AudioPlayerCurrentTrackStateListener> mutableState2, State<PreviewReducer.State> state, Continuation<? super AudioPlayerControllerKt$AudioPlayerController$5$1> continuation) {
        super(2, continuation);
        this.$audioStore = store;
        this.$getAudioPlayerManager = function0;
        this.$mediaController$delegate = mutableState;
        this.$currentAudioTrackListener$delegate = mutableState2;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayerControllerKt$AudioPlayerController$5$1(this.$audioStore, this.$getAudioPlayerManager, this.$mediaController$delegate, this.$currentAudioTrackListener$delegate, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioPlayerControllerKt$AudioPlayerController$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MediaController mediaControllerAudioPlayerController$lambda$2 = AudioPlayerControllerKt.AudioPlayerController$lambda$2(this.$mediaController$delegate);
            if (mediaControllerAudioPlayerController$lambda$2 == null) {
                return Unit.INSTANCE;
            }
            AudioPlayerCurrentTrackStateListener audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10 = AudioPlayerControllerKt.AudioPlayerController$lambda$10(this.$currentAudioTrackListener$delegate);
            if (!Intrinsics.areEqual(audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10 != null ? audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$10.getItemId() : null, AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getSelectedItemId())) {
                AudioPlayerCurrentTrackStateListener audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$11 = AudioPlayerControllerKt.AudioPlayerController$lambda$10(this.$currentAudioTrackListener$delegate);
                if (audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$11 != null) {
                    mediaControllerAudioPlayerController$lambda$2.removeListener(audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$11);
                }
                this.$currentAudioTrackListener$delegate.setValue(new AudioPlayerCurrentTrackStateListener(this.$audioStore));
                AudioPlayerCurrentTrackStateListener audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$12 = AudioPlayerControllerKt.AudioPlayerController$lambda$10(this.$currentAudioTrackListener$delegate);
                Intrinsics.checkNotNull(audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$12);
                mediaControllerAudioPlayerController$lambda$2.addListener(audioPlayerCurrentTrackStateListenerAudioPlayerController$lambda$12);
                this.$getAudioPlayerManager.invoke().seekToItemInPlaylist(AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getSelectedItemId().toString());
                AudioPlayerControllerKt.sendInitialStateInfo(mediaControllerAudioPlayerController$lambda$2.isPlaying(), this.$audioStore);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
