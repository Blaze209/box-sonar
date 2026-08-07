package com.box.android.data.service.impl.preview;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.AudioItem;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AudioPlaylistItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/services/AudioItem;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1", f = "AudioPlaylistItemsService.kt", i = {0, 1}, l = {65, 65}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
final class AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends AudioItem>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileModel $fileModel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AudioPlaylistItemsService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1(AudioPlaylistItemsService audioPlaylistItemsService, FileModel fileModel, Continuation<? super AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1> continuation) {
        super(2, continuation);
        this.this$0 = audioPlaylistItemsService;
        this.$fileModel = fileModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1 audioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1 = new AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1(this.this$0, this.$fileModel, continuation);
        audioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1.L$0 = obj;
        return audioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Result<? extends List<? extends AudioItem>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
        return ((AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r2.emit(new com.box.android.domain.utils.result.Result.Success(r8), r7) == r1) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.io.UnsupportedEncodingException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r8)
            goto L60
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            java.lang.Object r2 = r7.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L46
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.data.service.impl.preview.AudioPlaylistItemsService r8 = r7.this$0
            com.box.android.domain.models.item.FileModel r2 = r7.$fileModel
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r6
            r7.L$1 = r0
            r7.label = r4
            java.lang.Object r8 = com.box.android.data.service.impl.preview.AudioPlaylistItemsService.access$mapToAudioTracks(r8, r2, r5)
            if (r8 != r1) goto L45
            goto L5f
        L45:
            r2 = r0
        L46:
            com.box.android.domain.utils.result.Result$Success r4 = new com.box.android.domain.utils.result.Result$Success
            r4.<init>(r8)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r0
            r0 = 0
            r7.L$1 = r0
            r7.label = r3
            java.lang.Object r7 = r2.emit(r4, r8)
            if (r7 != r1) goto L60
        L5f:
            return r1
        L60:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
