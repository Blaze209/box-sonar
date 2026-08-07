package com.geniusscansdk.core;

import com.microsoft.identity.common.internal.broker.SerializedNames;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Retry.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\"\u0010\t\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0080@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"retry", "Lkotlin/Result;", "R", "maxRetries", "", "isRetryableError", "Lkotlin/Function1;", "", "", SerializedNames.OPERATION, "Lkotlin/coroutines/Continuation;", "", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RetryKt {

    /* JADX INFO: renamed from: com.geniusscansdk.core.RetryKt$retry$1, reason: invalid class name */
    /* JADX INFO: compiled from: Retry.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.core.RetryKt", f = "Retry.kt", i = {0, 0, 0, 1, 1}, l = {13, 18, 20}, m = "retry", n = {"isRetryableError", SerializedNames.OPERATION, "retry", "isRetryableError", SerializedNames.OPERATION}, s = {"L$0", "L$1", "I$2", "L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objRetry = RetryKt.retry(0, null, null, this);
            return objRetry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRetry : Result.m14779boximpl(objRetry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retry$lambda$0(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0071  */
    /* JADX WARN: Code duplicated, block: B:23:0x0085  */
    /* JADX WARN: Code duplicated, block: B:26:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        if (r0 == r2) goto L37;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ca -> B:33:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object retry(int r16, kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> r17, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, ? extends java.lang.Object> r18, kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>> r19) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.core.RetryKt.retry(int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retry$default(int i, Function1 function1, Function1 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: com.geniusscansdk.core.RetryKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(RetryKt.retry$lambda$0((Throwable) obj2));
                }
            };
        }
        return retry(i, function1, function2, continuation);
    }
}
