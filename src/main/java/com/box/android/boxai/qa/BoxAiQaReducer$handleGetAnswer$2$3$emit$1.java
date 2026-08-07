package com.box.android.boxai.qa;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaReducer$handleGetAnswer$2$3", f = "BoxAiQaReducer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {169, 173, 181}, m = "emit", n = {"it", "$this$onSuccess$iv", "answerModel", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiQaReducer$handleGetAnswer$2$3$1", "it", "$this$onSuccess$iv", "answerModel", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiQaReducer$handleGetAnswer$2$3$1", "it", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-BoxAiQaReducer$handleGetAnswer$2$3$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class BoxAiQaReducer$handleGetAnswer$2$3$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BoxAiQaReducer.AnonymousClass2.AnonymousClass3<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxAiQaReducer$handleGetAnswer$2$3$emit$1(BoxAiQaReducer.AnonymousClass2.AnonymousClass3<? super T> anonymousClass3, Continuation<? super BoxAiQaReducer$handleGetAnswer$2$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends AiAnswerStreamingModel, ? extends DomainError>) null, (Continuation<? super Unit>) this);
    }
}
