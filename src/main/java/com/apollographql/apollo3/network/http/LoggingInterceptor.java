package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.ByteStringHttpBody;
import com.apollographql.apollo3.api.http.HttpBody;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: LoggingInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u001d\b\u0017\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B#\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/network/http/LoggingInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "log", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", FirebaseAnalytics.Param.LEVEL, "Lcom/apollographql/apollo3/network/http/LoggingInterceptor$Level;", "(Lcom/apollographql/apollo3/network/http/LoggingInterceptor$Level;Lkotlin/jvm/functions/Function1;)V", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Level", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoggingInterceptor implements HttpInterceptor {
    private final Level level;
    private final Function1<String, Unit> log;

    /* JADX INFO: compiled from: LoggingInterceptor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/apollographql/apollo3/network/http/LoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.LoggingInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoggingInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.LoggingInterceptor", f = "LoggingInterceptor.kt", i = {1, 1, 1}, l = {82, 110}, m = "intercept", n = {"this", "logHeaders", "logBody"}, s = {"L$0", "I$0", "I$1"})
    static final class C09071 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09071(Continuation<? super C09071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoggingInterceptor.this.intercept(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoggingInterceptor(Level level, Function1<? super String, Unit> log) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(log, "log");
        this.level = level;
        this.log = log;
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public void dispose() {
        HttpInterceptor.DefaultImpls.dispose(this);
    }

    public /* synthetic */ LoggingInterceptor(Level level, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(level, (i & 2) != 0 ? new Function1<String, Unit>() { // from class: com.apollographql.apollo3.network.http.LoggingInterceptor.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                System.out.println((Object) it);
            }
        } : anonymousClass1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoggingInterceptor(Function1<? super String, Unit> log) {
        this(Level.BODY, log);
        Intrinsics.checkNotNullParameter(log, "log");
    }

    public /* synthetic */ LoggingInterceptor(AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<String, Unit>() { // from class: com.apollographql.apollo3.network.http.LoggingInterceptor.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                System.out.println((Object) it);
            }
        } : anonymousClass2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) throws IOException {
        C09071 c09071;
        int i;
        int i2;
        if (continuation instanceof C09071) {
            c09071 = (C09071) continuation;
            if ((c09071.label & Integer.MIN_VALUE) != 0) {
                c09071.label -= Integer.MIN_VALUE;
            } else {
                c09071 = new C09071(continuation);
            }
        } else {
            c09071 = new C09071(continuation);
        }
        Object obj = c09071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c09071.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.level == Level.NONE) {
                c09071.label = 1;
                Object objProceed = httpInterceptorChain.proceed(httpRequest, c09071);
                if (objProceed != coroutine_suspended) {
                    return objProceed;
                }
            } else {
                int i4 = (this.level == Level.HEADERS || this.level == Level.BODY) ? 1 : 0;
                i = this.level != Level.BODY ? 0 : 1;
                this.log.invoke(httpRequest.getMethod().name() + ' ' + httpRequest.getUrl());
                if (i4 != 0) {
                    for (HttpHeader httpHeader : httpRequest.getHeaders()) {
                        this.log.invoke(httpHeader.getName() + ": " + httpHeader.getValue());
                    }
                    this.log.invoke("[end of headers]");
                }
                HttpBody body = httpRequest.getBody();
                if (i != 0 && body != null) {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    ByteString byteString = buffer.readByteString();
                    this.log.invoke(byteString.utf8());
                    httpRequest = HttpRequest.newBuilder$default(httpRequest, null, null, 3, null).body(new ByteStringHttpBody(body.getContentType(), byteString)).build();
                }
                this.log.invoke("");
                c09071.L$0 = this;
                c09071.I$0 = i4;
                c09071.I$1 = i;
                c09071.label = 2;
                Object objProceed2 = httpInterceptorChain.proceed(httpRequest, c09071);
                if (objProceed2 != coroutine_suspended) {
                    int i5 = i4;
                    obj = objProceed2;
                    i2 = i5;
                }
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i6 = c09071.I$1;
        i2 = c09071.I$0;
        LoggingInterceptor loggingInterceptor = (LoggingInterceptor) c09071.L$0;
        ResultKt.throwOnFailure(obj);
        i = i6;
        this = loggingInterceptor;
        HttpResponse httpResponse = (HttpResponse) obj;
        this.log.invoke("HTTP: " + httpResponse.getStatusCode());
        if (i2 != 0) {
            for (HttpHeader httpHeader2 : httpResponse.getHeaders()) {
                this.log.invoke(httpHeader2.getName() + ": " + httpHeader2.getValue());
            }
            this.log.invoke("[end of headers]");
        }
        BufferedSource body2 = httpResponse.getBody();
        if (i == 0 || body2 == null) {
            return httpResponse;
        }
        ByteString byteString2 = body2.readByteString();
        this.log.invoke(byteString2.utf8());
        return new HttpResponse.Builder(httpResponse.getStatusCode()).body(byteString2).addHeaders(httpResponse.getHeaders()).build();
    }
}
