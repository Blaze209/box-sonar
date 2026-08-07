package com.box.android.preview.previewtype.audio;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.session.MediaController;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioPlayerController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$AudioPlayerController$4$1", f = "AudioPlayerController.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"initialAudioTrack"}, s = {"L$0"}, v = 1)
final class AudioPlayerControllerKt$AudioPlayerController$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Media3AudioPlayerManager> $getAudioPlayerManager;
    final /* synthetic */ MutableState<MediaController> $mediaController$delegate;
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioPlayerControllerKt$AudioPlayerController$4$1(Function0<Media3AudioPlayerManager> function0, Context context, State<PreviewReducer.State> state, MutableState<MediaController> mutableState, Continuation<? super AudioPlayerControllerKt$AudioPlayerController$4$1> continuation) {
        super(2, continuation);
        this.$getAudioPlayerManager = function0;
        this.$context = context;
        this.$state$delegate = state;
        this.$mediaController$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayerControllerKt$AudioPlayerController$4$1(this.$getAudioPlayerManager, this.$context, this.$state$delegate, this.$mediaController$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioPlayerControllerKt$AudioPlayerController$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        MutableState<MediaController> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<AudioTrack> playlist = AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getPlaylist();
            State<PreviewReducer.State> state = this.$state$delegate;
            Iterator<T> it = playlist.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AudioTrack) next).getFileModel().getItemId(), AudioPlayerControllerKt.AudioPlayerController$lambda$0(state).getSelectedItemId()));
            AudioTrack audioTrack = (AudioTrack) next;
            if (audioTrack == null && (audioTrack = (AudioTrack) CollectionsKt.firstOrNull((List) AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getPlaylist())) == null) {
                return Unit.INSTANCE;
            }
            AudioTrack audioTrack2 = audioTrack;
            MutableState<MediaController> mutableState2 = this.$mediaController$delegate;
            this.L$0 = SpillingKt.nullOutSpilledVariable(audioTrack2);
            this.L$1 = mutableState2;
            this.label = 1;
            Object objInitializeMediaController = this.$getAudioPlayerManager.invoke().initializeMediaController(this.$context, AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getPlaylist(), audioTrack2, AudioPlayerControllerKt.AudioPlayerController$lambda$0(this.$state$delegate).getPreviewSource(), this);
            if (objInitializeMediaController == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableState = mutableState2;
            obj = objInitializeMediaController;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        mutableState.setValue((MediaController) obj);
        return Unit.INSTANCE;
    }
}
