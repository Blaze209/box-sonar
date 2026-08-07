package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: BearerTokenInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "BearerTokenInterceptor was provided as an example but is too simple for most use cases.Define your own interceptor or take a look at https://www.apollographql.com/docs/kotlin/advanced/interceptors-http for more details.")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/network/http/BearerTokenInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "tokenProvider", "Lcom/apollographql/apollo3/network/http/TokenProvider;", "(Lcom/apollographql/apollo3/network/http/TokenProvider;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BearerTokenInterceptor implements HttpInterceptor {
    private final Mutex mutex;
    private final TokenProvider tokenProvider;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.BearerTokenInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: BearerTokenInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.BearerTokenInterceptor", f = "BearerTokenInterceptor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {37, 19, 21, 47, 24, 25}, m = "intercept", n = {"this", "request", "chain", "token", "$this$withLock_u24default$iv", "this", "request", "chain", "token", "$this$withLock_u24default$iv", "this", "request", "chain", "token", "this", "request", "chain", "token", "$this$withLock_u24default$iv", "request", "chain", "token", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BearerTokenInterceptor.this.intercept(null, null, this);
        }
    }

    public BearerTokenInterceptor(TokenProvider tokenProvider) {
        Intrinsics.checkNotNullParameter(tokenProvider, "tokenProvider");
        this.tokenProvider = tokenProvider;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public void dispose() {
        HttpInterceptor.DefaultImpls.dispose(this);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0103  */
    /* JADX WARN: Code duplicated, block: B:39:0x0146  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153  */
    /* JADX WARN: Code duplicated, block: B:45:0x016b  */
    /* JADX WARN: Code duplicated, block: B:48:0x018a  */
    /* JADX WARN: Code duplicated, block: B:49:0x018b A[Catch: all -> 0x004f, PHI: r2 r7 r11 r12 r13 r14
      0x018b: PHI (r2v19 com.apollographql.apollo3.network.http.HttpInterceptorChain) = 
      (r2v16 com.apollographql.apollo3.network.http.HttpInterceptorChain)
      (r2v21 com.apollographql.apollo3.network.http.HttpInterceptorChain)
     binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r7v16 ??) = (r7v19 ??), (r7v20 ??) binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r11v23 kotlin.jvm.internal.Ref$ObjectRef) = (r11v20 kotlin.jvm.internal.Ref$ObjectRef), (r11v29 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r12v24 ??) = (r12v31 ??), (r12v32 ??) binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r13v17 kotlin.jvm.internal.Ref$ObjectRef) = (r13v14 kotlin.jvm.internal.Ref$ObjectRef), (r13v21 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r14v17 java.lang.Object) = (r14v16 java.lang.Object), (r14v1 java.lang.Object) binds: [B:47:0x0188, B:15:0x004a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:15:0x004a, B:49:0x018b, B:46:0x016f), top: B:65:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x01c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.apollographql.apollo3.api.http.HttpRequest, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v24, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v8, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16, types: [com.apollographql.apollo3.api.http.HttpRequest] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.apollographql.apollo3.api.http.HttpRequest, java.lang.Object] */
    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        Mutex mutex;
        Ref.ObjectRef objectRef2;
        ?? r12;
        Mutex mutex2;
        Object objCurrentToken;
        BearerTokenInterceptor bearerTokenInterceptor;
        Ref.ObjectRef objectRef3;
        ?? r7;
        HttpInterceptorChain httpInterceptorChain2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        HttpInterceptorChain httpInterceptorChain3;
        ?? r13;
        HttpResponse httpResponse;
        Mutex mutex3;
        HttpInterceptorChain httpInterceptorChain4;
        ?? r8;
        Mutex mutex4;
        Ref.ObjectRef objectRef6;
        ?? r9;
        Object objProceed;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objProceed2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure(objProceed2);
                    objectRef = new Ref.ObjectRef();
                    mutex = this.mutex;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = httpRequest;
                    anonymousClass1.L$2 = httpInterceptorChain;
                    anonymousClass1.L$3 = objectRef;
                    anonymousClass1.L$4 = mutex;
                    anonymousClass1.L$5 = objectRef;
                    anonymousClass1.label = 1;
                    if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                        objectRef2 = objectRef;
                        r12 = httpRequest;
                        try {
                            TokenProvider tokenProvider = this.tokenProvider;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = r12;
                            anonymousClass1.L$2 = httpInterceptorChain;
                            anonymousClass1.L$3 = objectRef2;
                            anonymousClass1.L$4 = mutex;
                            anonymousClass1.L$5 = objectRef;
                            anonymousClass1.label = 2;
                            objCurrentToken = tokenProvider.currentToken(anonymousClass1);
                            if (objCurrentToken != coroutine_suspended) {
                                bearerTokenInterceptor = this;
                                objectRef3 = objectRef;
                                objProceed2 = objCurrentToken;
                                Ref.ObjectRef objectRef7 = objectRef2;
                                r7 = r12;
                                mutex2 = mutex;
                                httpInterceptorChain2 = httpInterceptorChain;
                                objectRef4 = objectRef7;
                                ?? r14 = (String) objProceed2;
                                mutex2.unlock(null);
                                objectRef3.element = r14;
                                HttpRequest httpRequestBuild = HttpRequest.newBuilder$default(r7, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef4.element)).build();
                                anonymousClass1.L$0 = bearerTokenInterceptor;
                                anonymousClass1.L$1 = r7;
                                anonymousClass1.L$2 = httpInterceptorChain2;
                                anonymousClass1.L$3 = objectRef4;
                                anonymousClass1.L$4 = null;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.label = 3;
                                objProceed2 = httpInterceptorChain2.proceed(httpRequestBuild, anonymousClass1);
                                if (objProceed2 != coroutine_suspended) {
                                    objectRef5 = objectRef4;
                                    httpInterceptorChain3 = httpInterceptorChain2;
                                    r13 = r7;
                                    httpResponse = (HttpResponse) objProceed2;
                                    if (httpResponse.getStatusCode() == 401) {
                                        return httpResponse;
                                    }
                                    mutex3 = bearerTokenInterceptor.mutex;
                                    anonymousClass1.L$0 = bearerTokenInterceptor;
                                    anonymousClass1.L$1 = r13;
                                    anonymousClass1.L$2 = httpInterceptorChain3;
                                    anonymousClass1.L$3 = objectRef5;
                                    anonymousClass1.L$4 = mutex3;
                                    anonymousClass1.L$5 = objectRef5;
                                    anonymousClass1.label = 4;
                                    if (mutex3.lock(null, anonymousClass1) != coroutine_suspended) {
                                        httpInterceptorChain4 = httpInterceptorChain3;
                                        r8 = r13;
                                        mutex4 = mutex3;
                                        objectRef6 = objectRef5;
                                        TokenProvider tokenProvider2 = bearerTokenInterceptor.tokenProvider;
                                        String str = (String) objectRef6.element;
                                        anonymousClass1.L$0 = r8;
                                        anonymousClass1.L$1 = httpInterceptorChain4;
                                        anonymousClass1.L$2 = objectRef6;
                                        anonymousClass1.L$3 = mutex4;
                                        anonymousClass1.L$4 = objectRef5;
                                        anonymousClass1.L$5 = null;
                                        anonymousClass1.label = 5;
                                        objProceed2 = tokenProvider2.refreshToken(str, anonymousClass1);
                                        r9 = r8;
                                        httpRequest = mutex4;
                                        if (objProceed2 != coroutine_suspended) {
                                            ?? r15 = (String) objProceed2;
                                            httpRequest.unlock(null);
                                            objectRef5.element = r15;
                                            HttpRequest httpRequestBuild2 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                                            anonymousClass1.L$0 = null;
                                            anonymousClass1.L$1 = null;
                                            anonymousClass1.L$2 = null;
                                            anonymousClass1.L$3 = null;
                                            anonymousClass1.L$4 = null;
                                            anonymousClass1.label = 6;
                                            objProceed = httpInterceptorChain4.proceed(httpRequestBuild2, anonymousClass1);
                                            if (objProceed != coroutine_suspended) {
                                                return objProceed;
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            mutex2 = mutex;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    Ref.ObjectRef objectRef8 = (Ref.ObjectRef) anonymousClass1.L$5;
                    Mutex mutex5 = (Mutex) anonymousClass1.L$4;
                    Ref.ObjectRef objectRef9 = (Ref.ObjectRef) anonymousClass1.L$3;
                    HttpInterceptorChain httpInterceptorChain5 = (HttpInterceptorChain) anonymousClass1.L$2;
                    HttpRequest httpRequest2 = (HttpRequest) anonymousClass1.L$1;
                    BearerTokenInterceptor bearerTokenInterceptor2 = (BearerTokenInterceptor) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objProceed2);
                    mutex = mutex5;
                    r12 = httpRequest2;
                    objectRef2 = objectRef9;
                    httpInterceptorChain = httpInterceptorChain5;
                    objectRef = objectRef8;
                    this = bearerTokenInterceptor2;
                    TokenProvider tokenProvider3 = this.tokenProvider;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = r12;
                    anonymousClass1.L$2 = httpInterceptorChain;
                    anonymousClass1.L$3 = objectRef2;
                    anonymousClass1.L$4 = mutex;
                    anonymousClass1.L$5 = objectRef;
                    anonymousClass1.label = 2;
                    objCurrentToken = tokenProvider3.currentToken(anonymousClass1);
                    if (objCurrentToken != coroutine_suspended) {
                        bearerTokenInterceptor = this;
                        objectRef3 = objectRef;
                        objProceed2 = objCurrentToken;
                        Ref.ObjectRef objectRef10 = objectRef2;
                        r7 = r12;
                        mutex2 = mutex;
                        httpInterceptorChain2 = httpInterceptorChain;
                        objectRef4 = objectRef10;
                        ?? r16 = (String) objProceed2;
                        mutex2.unlock(null);
                        objectRef3.element = r16;
                        HttpRequest httpRequestBuild3 = HttpRequest.newBuilder$default(r7, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef4.element)).build();
                        anonymousClass1.L$0 = bearerTokenInterceptor;
                        anonymousClass1.L$1 = r7;
                        anonymousClass1.L$2 = httpInterceptorChain2;
                        anonymousClass1.L$3 = objectRef4;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 3;
                        objProceed2 = httpInterceptorChain2.proceed(httpRequestBuild3, anonymousClass1);
                        if (objProceed2 != coroutine_suspended) {
                            objectRef5 = objectRef4;
                            httpInterceptorChain3 = httpInterceptorChain2;
                            r13 = r7;
                            httpResponse = (HttpResponse) objProceed2;
                            if (httpResponse.getStatusCode() == 401) {
                                return httpResponse;
                            }
                            mutex3 = bearerTokenInterceptor.mutex;
                            anonymousClass1.L$0 = bearerTokenInterceptor;
                            anonymousClass1.L$1 = r13;
                            anonymousClass1.L$2 = httpInterceptorChain3;
                            anonymousClass1.L$3 = objectRef5;
                            anonymousClass1.L$4 = mutex3;
                            anonymousClass1.L$5 = objectRef5;
                            anonymousClass1.label = 4;
                            if (mutex3.lock(null, anonymousClass1) != coroutine_suspended) {
                                httpInterceptorChain4 = httpInterceptorChain3;
                                r8 = r13;
                                mutex4 = mutex3;
                                objectRef6 = objectRef5;
                                TokenProvider tokenProvider4 = bearerTokenInterceptor.tokenProvider;
                                String str2 = (String) objectRef6.element;
                                anonymousClass1.L$0 = r8;
                                anonymousClass1.L$1 = httpInterceptorChain4;
                                anonymousClass1.L$2 = objectRef6;
                                anonymousClass1.L$3 = mutex4;
                                anonymousClass1.L$4 = objectRef5;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.label = 5;
                                objProceed2 = tokenProvider4.refreshToken(str2, anonymousClass1);
                                r9 = r8;
                                httpRequest = mutex4;
                                if (objProceed2 != coroutine_suspended) {
                                    ?? r17 = (String) objProceed2;
                                    httpRequest.unlock(null);
                                    objectRef5.element = r17;
                                    HttpRequest httpRequestBuild4 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.label = 6;
                                    objProceed = httpInterceptorChain4.proceed(httpRequestBuild4, anonymousClass1);
                                    if (objProceed != coroutine_suspended) {
                                        return objProceed;
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 2:
                    objectRef3 = (Ref.ObjectRef) anonymousClass1.L$5;
                    mutex2 = (Mutex) anonymousClass1.L$4;
                    objectRef4 = (Ref.ObjectRef) anonymousClass1.L$3;
                    httpInterceptorChain2 = (HttpInterceptorChain) anonymousClass1.L$2;
                    HttpRequest httpRequest3 = (HttpRequest) anonymousClass1.L$1;
                    bearerTokenInterceptor = (BearerTokenInterceptor) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(objProceed2);
                        r7 = httpRequest3;
                        ?? r18 = (String) objProceed2;
                        mutex2.unlock(null);
                        objectRef3.element = r18;
                        HttpRequest httpRequestBuild5 = HttpRequest.newBuilder$default(r7, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef4.element)).build();
                        anonymousClass1.L$0 = bearerTokenInterceptor;
                        anonymousClass1.L$1 = r7;
                        anonymousClass1.L$2 = httpInterceptorChain2;
                        anonymousClass1.L$3 = objectRef4;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 3;
                        objProceed2 = httpInterceptorChain2.proceed(httpRequestBuild5, anonymousClass1);
                        if (objProceed2 != coroutine_suspended) {
                            objectRef5 = objectRef4;
                            httpInterceptorChain3 = httpInterceptorChain2;
                            r13 = r7;
                            httpResponse = (HttpResponse) objProceed2;
                            if (httpResponse.getStatusCode() == 401) {
                                return httpResponse;
                            }
                            mutex3 = bearerTokenInterceptor.mutex;
                            anonymousClass1.L$0 = bearerTokenInterceptor;
                            anonymousClass1.L$1 = r13;
                            anonymousClass1.L$2 = httpInterceptorChain3;
                            anonymousClass1.L$3 = objectRef5;
                            anonymousClass1.L$4 = mutex3;
                            anonymousClass1.L$5 = objectRef5;
                            anonymousClass1.label = 4;
                            if (mutex3.lock(null, anonymousClass1) != coroutine_suspended) {
                                httpInterceptorChain4 = httpInterceptorChain3;
                                r8 = r13;
                                mutex4 = mutex3;
                                objectRef6 = objectRef5;
                                TokenProvider tokenProvider5 = bearerTokenInterceptor.tokenProvider;
                                String str3 = (String) objectRef6.element;
                                anonymousClass1.L$0 = r8;
                                anonymousClass1.L$1 = httpInterceptorChain4;
                                anonymousClass1.L$2 = objectRef6;
                                anonymousClass1.L$3 = mutex4;
                                anonymousClass1.L$4 = objectRef5;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.label = 5;
                                objProceed2 = tokenProvider5.refreshToken(str3, anonymousClass1);
                                r9 = r8;
                                httpRequest = mutex4;
                                if (objProceed2 != coroutine_suspended) {
                                    ?? r19 = (String) objProceed2;
                                    httpRequest.unlock(null);
                                    objectRef5.element = r19;
                                    HttpRequest httpRequestBuild6 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.label = 6;
                                    objProceed = httpInterceptorChain4.proceed(httpRequestBuild6, anonymousClass1);
                                    if (objProceed != coroutine_suspended) {
                                        return objProceed;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                case 3:
                    objectRef5 = (Ref.ObjectRef) anonymousClass1.L$3;
                    httpInterceptorChain3 = (HttpInterceptorChain) anonymousClass1.L$2;
                    HttpRequest httpRequest4 = (HttpRequest) anonymousClass1.L$1;
                    BearerTokenInterceptor bearerTokenInterceptor3 = (BearerTokenInterceptor) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objProceed2);
                    bearerTokenInterceptor = bearerTokenInterceptor3;
                    r13 = httpRequest4;
                    httpResponse = (HttpResponse) objProceed2;
                    if (httpResponse.getStatusCode() == 401) {
                        return httpResponse;
                    }
                    mutex3 = bearerTokenInterceptor.mutex;
                    anonymousClass1.L$0 = bearerTokenInterceptor;
                    anonymousClass1.L$1 = r13;
                    anonymousClass1.L$2 = httpInterceptorChain3;
                    anonymousClass1.L$3 = objectRef5;
                    anonymousClass1.L$4 = mutex3;
                    anonymousClass1.L$5 = objectRef5;
                    anonymousClass1.label = 4;
                    if (mutex3.lock(null, anonymousClass1) != coroutine_suspended) {
                        httpInterceptorChain4 = httpInterceptorChain3;
                        r8 = r13;
                        mutex4 = mutex3;
                        objectRef6 = objectRef5;
                        TokenProvider tokenProvider6 = bearerTokenInterceptor.tokenProvider;
                        String str4 = (String) objectRef6.element;
                        anonymousClass1.L$0 = r8;
                        anonymousClass1.L$1 = httpInterceptorChain4;
                        anonymousClass1.L$2 = objectRef6;
                        anonymousClass1.L$3 = mutex4;
                        anonymousClass1.L$4 = objectRef5;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 5;
                        objProceed2 = tokenProvider6.refreshToken(str4, anonymousClass1);
                        r9 = r8;
                        httpRequest = mutex4;
                        if (objProceed2 != coroutine_suspended) {
                            ?? r110 = (String) objProceed2;
                            httpRequest.unlock(null);
                            objectRef5.element = r110;
                            HttpRequest httpRequestBuild7 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.label = 6;
                            objProceed = httpInterceptorChain4.proceed(httpRequestBuild7, anonymousClass1);
                            if (objProceed != coroutine_suspended) {
                                return objProceed;
                            }
                        }
                    }
                    return coroutine_suspended;
                case 4:
                    objectRef5 = (Ref.ObjectRef) anonymousClass1.L$5;
                    Mutex mutex6 = (Mutex) anonymousClass1.L$4;
                    objectRef6 = (Ref.ObjectRef) anonymousClass1.L$3;
                    httpInterceptorChain4 = (HttpInterceptorChain) anonymousClass1.L$2;
                    HttpRequest httpRequest5 = (HttpRequest) anonymousClass1.L$1;
                    bearerTokenInterceptor = (BearerTokenInterceptor) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objProceed2);
                    r8 = httpRequest5;
                    mutex4 = mutex6;
                    TokenProvider tokenProvider7 = bearerTokenInterceptor.tokenProvider;
                    String str5 = (String) objectRef6.element;
                    anonymousClass1.L$0 = r8;
                    anonymousClass1.L$1 = httpInterceptorChain4;
                    anonymousClass1.L$2 = objectRef6;
                    anonymousClass1.L$3 = mutex4;
                    anonymousClass1.L$4 = objectRef5;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 5;
                    objProceed2 = tokenProvider7.refreshToken(str5, anonymousClass1);
                    r9 = r8;
                    httpRequest = mutex4;
                    if (objProceed2 != coroutine_suspended) {
                        ?? r111 = (String) objProceed2;
                        httpRequest.unlock(null);
                        objectRef5.element = r111;
                        HttpRequest httpRequestBuild8 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.label = 6;
                        objProceed = httpInterceptorChain4.proceed(httpRequestBuild8, anonymousClass1);
                        if (objProceed != coroutine_suspended) {
                            return objProceed;
                        }
                    }
                    return coroutine_suspended;
                case 5:
                    objectRef5 = (Ref.ObjectRef) anonymousClass1.L$4;
                    Mutex mutex7 = (Mutex) anonymousClass1.L$3;
                    objectRef6 = (Ref.ObjectRef) anonymousClass1.L$2;
                    httpInterceptorChain4 = (HttpInterceptorChain) anonymousClass1.L$1;
                    HttpRequest httpRequest6 = (HttpRequest) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objProceed2);
                    r9 = httpRequest6;
                    httpRequest = mutex7;
                    ?? r112 = (String) objProceed2;
                    httpRequest.unlock(null);
                    objectRef5.element = r112;
                    HttpRequest httpRequestBuild9 = HttpRequest.newBuilder$default(r9, null, null, 3, null).addHeader("Authorization", "Bearer " + ((String) objectRef6.element)).build();
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.label = 6;
                    objProceed = httpInterceptorChain4.proceed(httpRequestBuild9, anonymousClass1);
                    if (objProceed != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objProceed;
                case 6:
                    ResultKt.throwOnFailure(objProceed2);
                    return objProceed2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            httpRequest.unlock(null);
            throw th3;
        }
    }
}
