package com.box.android.boxai.markdown;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: MarkdownView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "acc", "value"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.markdown.MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1", f = "MarkdownView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1 extends SuspendLambda implements Function3<String, String, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1(Continuation<? super MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(String str, String str2, Continuation<? super String> continuation) {
        MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1 markdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1 = new MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1(continuation);
        markdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1.L$0 = str;
        markdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1.L$1 = str2;
        return markdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        String str2 = (String) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return str + " " + str2;
    }
}
