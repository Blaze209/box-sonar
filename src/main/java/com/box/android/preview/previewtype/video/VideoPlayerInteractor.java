package com.box.android.preview.previewtype.video;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ItemId;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VideoPlayerInteractor.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPlayerInteractor;", "", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;)V", "observePlayer", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/preview/previewtype/video/PlayerState;", "itemId", "Lcom/box/android/domain/models/ItemId;", "pauseVideo", "", "seekTo", ViewProps.POSITION, "", "getCurrentPosition", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayerInteractor {
    public static final int $stable = 8;
    private final VideoPlayersProvider videoPlayersProvider;

    @Inject
    public VideoPlayerInteractor(VideoPlayersProvider videoPlayersProvider) {
        Intrinsics.checkNotNullParameter(videoPlayersProvider, "videoPlayersProvider");
        this.videoPlayersProvider = videoPlayersProvider;
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.VideoPlayerInteractor$observePlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoPlayerInteractor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/box/android/preview/previewtype/video/PlayerState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.VideoPlayerInteractor$observePlayer$1", f = "VideoPlayerInteractor.kt", i = {0, 0, 0}, l = {54}, m = "invokeSuspend", n = {"$this$callbackFlow", "player", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super PlayerState>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $itemId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId itemId, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = VideoPlayerInteractor.this.new AnonymousClass1(this.$itemId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super PlayerState> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [com.box.android.preview.previewtype.video.VideoPlayerInteractor$observePlayer$1$listener$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Player player = VideoPlayerInteractor.this.videoPlayersProvider.getPlayer(this.$itemId);
                if (player == null) {
                    producerScope.mo11206trySendJP2dKIU(new PlayerState.VideoPlayError(new FilePreviewDomainError.VideoPlayError("No player found")));
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    return Unit.INSTANCE;
                }
                if (player.getPlaybackState() == 3) {
                    producerScope.mo11206trySendJP2dKIU(PlayerState.Ready.INSTANCE);
                }
                final ?? r2 = new Player.Listener() { // from class: com.box.android.preview.previewtype.video.VideoPlayerInteractor$observePlayer$1$listener$1
                    @Override // androidx.media3.common.Player.Listener
                    public void onPlayerError(PlaybackException error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        super.onPlayerError(error);
                        if (VideoPlayerInteractorKt.isNetworkError(error)) {
                            producerScope.mo11206trySendJP2dKIU(PlayerState.NetworkError.INSTANCE);
                            return;
                        }
                        producerScope.mo11206trySendJP2dKIU(new PlayerState.VideoPlayError(new FilePreviewDomainError.VideoPlayError(error.getErrorCodeName() + " " + error.getMessage())));
                    }

                    @Override // androidx.media3.common.Player.Listener
                    public void onPlaybackStateChanged(int playbackState) {
                        if (playbackState == 3) {
                            producerScope.mo11206trySendJP2dKIU(PlayerState.Ready.INSTANCE);
                        }
                    }
                };
                player.addListener((Player.Listener) r2);
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(player);
                this.L$2 = SpillingKt.nullOutSpilledVariable(r2);
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.box.android.preview.previewtype.video.VideoPlayerInteractor$observePlayer$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VideoPlayerInteractor.AnonymousClass1.invokeSuspend$lambda$1(player, r2);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Player player, VideoPlayerInteractor$observePlayer$1$listener$1 videoPlayerInteractor$observePlayer$1$listener$1) {
            player.removeListener(videoPlayerInteractor$observePlayer$1$listener$1);
            return Unit.INSTANCE;
        }
    }

    public final Flow<PlayerState> observePlayer(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return FlowKt.callbackFlow(new AnonymousClass1(itemId, null));
    }

    public final void pauseVideo(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Player player = this.videoPlayersProvider.getPlayer(itemId);
        if (player != null) {
            player.pause();
        }
    }

    public final void seekTo(ItemId itemId, long position) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Player player = this.videoPlayersProvider.getPlayer(itemId);
        if (player != null) {
            player.seekTo(position);
        }
    }

    public final long getCurrentPosition(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Player player = this.videoPlayersProvider.getPlayer(itemId);
        if (player != null) {
            return player.getCurrentPosition();
        }
        return 0L;
    }
}
