package com.box.android.data.service.impl.boxai;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1", f = "BoxAiStreamingRateLimiter.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {40, 41, 46}, m = "emit", n = {"partResult", "$this$onSuccess$iv", BoxUploadSessionPart.FIELD_PART, "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$1", "partResult", "$this$onSuccess$iv", BoxUploadSessionPart.FIELD_PART, "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$1", "partResult", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BoxAiStreamingRateLimiterKt.AnonymousClass1.C01711.C01721<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$emit$1(BoxAiStreamingRateLimiterKt.AnonymousClass1.C01711.C01721<? super T> c01721, Continuation<? super BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01721;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends AiAnswerStreamingModel, ? extends DomainError>) null, (Continuation<? super Unit>) this);
    }
}
