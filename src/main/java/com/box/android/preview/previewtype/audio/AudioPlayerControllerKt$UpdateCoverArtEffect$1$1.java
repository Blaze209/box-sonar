package com.box.android.preview.previewtype.audio;

import android.graphics.Bitmap;
import androidx.media3.common.Tracks;
import androidx.media3.session.MediaController;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: AudioPlayerController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$UpdateCoverArtEffect$1$1", f = "AudioPlayerController.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AudioPlayerControllerKt$UpdateCoverArtEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Media3AudioPlayerManager> $getAudioPlayerManager;
    final /* synthetic */ MediaController $mediaController;
    final /* synthetic */ Function1<Bitmap, Unit> $onCoverArtChanged;
    final /* synthetic */ ItemId $selectedItemId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AudioPlayerControllerKt$UpdateCoverArtEffect$1$1(Function0<Media3AudioPlayerManager> function0, ItemId itemId, MediaController mediaController, Function1<? super Bitmap, Unit> function1, Continuation<? super AudioPlayerControllerKt$UpdateCoverArtEffect$1$1> continuation) {
        super(2, continuation);
        this.$getAudioPlayerManager = function0;
        this.$selectedItemId = itemId;
        this.$mediaController = mediaController;
        this.$onCoverArtChanged = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayerControllerKt$UpdateCoverArtEffect$1$1(this.$getAudioPlayerManager, this.$selectedItemId, this.$mediaController, this.$onCoverArtChanged, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioPlayerControllerKt$UpdateCoverArtEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$getAudioPlayerManager.invoke().getCurrentItemId(), this.$selectedItemId.toString())) {
                this.label = 1;
                if (DelayKt.delay(150L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Media3AudioPlayerManager media3AudioPlayerManagerInvoke = this.$getAudioPlayerManager.invoke();
        Tracks currentTracks = this.$mediaController.getCurrentTracks();
        Intrinsics.checkNotNullExpressionValue(currentTracks, "getCurrentTracks(...)");
        Bitmap coverArt = media3AudioPlayerManagerInvoke.getCoverArt(currentTracks);
        if (coverArt != null) {
            this.$onCoverArtChanged.invoke(coverArt);
        }
        return Unit.INSTANCE;
    }
}
