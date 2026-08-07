package com.box.android.preview.previewtype.gif;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GifPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.gif.GifPreviewScreenKt$GifImage$1$1", f = "GifPreviewScreen.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GifPreviewScreenKt$GifImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<IntSize> $fileDimension$delegate;
    final /* synthetic */ Uri $uri;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GifPreviewScreenKt$GifImage$1$1(Uri uri, Context context, MutableState<IntSize> mutableState, Continuation<? super GifPreviewScreenKt$GifImage$1$1> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.$context = context;
        this.$fileDimension$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GifPreviewScreenKt$GifImage$1$1(this.$uri, this.$context, this.$fileDimension$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GifPreviewScreenKt$GifImage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<IntSize> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState<IntSize> mutableState2 = this.$fileDimension$delegate;
            this.L$0 = mutableState2;
            this.label = 1;
            Object objFileDimension = GifPreviewScreenKt.fileDimension(this.$uri, this.$context, this);
            if (objFileDimension == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objFileDimension;
            mutableState = mutableState2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableState.setValue((IntSize) obj);
        return Unit.INSTANCE;
    }
}
