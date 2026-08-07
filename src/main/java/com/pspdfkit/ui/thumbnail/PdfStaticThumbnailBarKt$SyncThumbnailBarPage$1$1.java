package com.pspdfkit.ui.thumbnail;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1", f = "PdfStaticThumbnailBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ ThumbnailBarStateManager $stateManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1(ThumbnailBarStateManager thumbnailBarStateManager, int i, Continuation<? super PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1> continuation) {
        super(2, continuation);
        this.$stateManager = thumbnailBarStateManager;
        this.$pageIndex = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1(this.$stateManager, this.$pageIndex, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$stateManager.onEvent(new ThumbnailBarEvent.PageChanged(this.$pageIndex));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
