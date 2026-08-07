package com.box.android.boxai.markdown;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: MarkdownView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.markdown.MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2", f = "MarkdownView.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    int label;

    MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2(Continuation<? super MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(RangesKt.random(new LongRange(1L, 200L), Random.INSTANCE), this) == coroutine_suspended) {
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
}
