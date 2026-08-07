package com.box.android.data.datasource.boxai;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource", f = "BoxAiRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {90}, m = "createSession$request", n = {"this$0", "$itemIds", "token", "$i$f$resultOf", "$i$a$-resultOf-BoxAiRemoteDataSource$createSession$request$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class BoxAiRemoteDataSource$createSession$request$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    BoxAiRemoteDataSource$createSession$request$1(Continuation<? super BoxAiRemoteDataSource$createSession$request$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BoxAiRemoteDataSource.createSession$request(null, null, null, this);
    }
}
