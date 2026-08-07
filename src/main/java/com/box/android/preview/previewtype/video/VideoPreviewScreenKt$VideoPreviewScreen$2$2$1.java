package com.box.android.preview.previewtype.video;

import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.video.VideoPreviewScreenKt$VideoPreviewScreen$2$2$1", f = "VideoPreviewScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VideoPreviewScreenKt$VideoPreviewScreen$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enqueuedAnnotationId;
    final /* synthetic */ Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPreviewScreenKt$VideoPreviewScreen$2$2$1(String str, Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store, Continuation<? super VideoPreviewScreenKt$VideoPreviewScreen$2$2$1> continuation) {
        super(2, continuation);
        this.$enqueuedAnnotationId = str;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPreviewScreenKt$VideoPreviewScreen$2$2$1(this.$enqueuedAnnotationId, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPreviewScreenKt$VideoPreviewScreen$2$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$enqueuedAnnotationId != null) {
            this.$store.send(new VideoPreviewReducer.Action.FrameAnnotation(new FrameAnnotationReducer.Action.HandleEnqueuedAnnotation(this.$enqueuedAnnotationId)));
        }
        return Unit.INSTANCE;
    }
}
