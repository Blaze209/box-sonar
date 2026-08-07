package com.apollographql.apollo3.internal;

import com.apollographql.apollo3.api.http.HttpHeaders;
import com.apollographql.apollo3.api.http.HttpResponse;
import com.apollographql.apollo3.exception.ApolloException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.BufferedSource;

/* JADX INFO: compiled from: multipart.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u000b"}, d2 = {"isMultipart", "", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "(Lcom/apollographql/apollo3/api/http/HttpResponse;)Z", "getBoundaryParameter", "", "contentType", "multipartBodyFlow", "Lkotlinx/coroutines/flow/Flow;", "Lokio/BufferedSource;", "response", "apollo-runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class MultipartKt {

    /* JADX INFO: renamed from: com.apollographql.apollo3.internal.MultipartKt$multipartBodyFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: multipart.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lokio/BufferedSource;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.internal.MultipartKt$multipartBodyFlow$1", f = "multipart.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super BufferedSource>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<MultipartReader> $multipartReader;
        final /* synthetic */ HttpResponse $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<MultipartReader> objectRef, HttpResponse httpResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$multipartReader = objectRef;
            this.$response = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$multipartReader, this.$response, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super BufferedSource> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, com.apollographql.apollo3.internal.MultipartReader] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            FlowCollector flowCollector;
            MultipartReader.Part partNextPart;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                Ref.ObjectRef<MultipartReader> objectRef = this.$multipartReader;
                BufferedSource body = this.$response.getBody();
                Intrinsics.checkNotNull(body);
                String boundaryParameter = MultipartKt.getBoundaryParameter(HttpHeaders.valueOf(this.$response.getHeaders(), "Content-Type"));
                if (boundaryParameter != null) {
                    objectRef.element = new MultipartReader(body, boundaryParameter);
                    flowCollector = flowCollector2;
                } else {
                    throw new ApolloException("Expected the Content-Type to have a boundary parameter", null, 2, null);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            do {
                MultipartReader multipartReader = this.$multipartReader.element;
                Intrinsics.checkNotNull(multipartReader);
                partNextPart = multipartReader.nextPart();
                if (partNextPart == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = flowCollector;
                this.label = 1;
            } while (flowCollector.emit(partNextPart.getBody(), this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    public static final Flow<BufferedSource> multipartBodyFlow(HttpResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        return FlowKt.onCompletion(FlowKt.flow(new AnonymousClass1(objectRef, response, null)), new AnonymousClass2(objectRef, null));
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.internal.MultipartKt$multipartBodyFlow$2, reason: invalid class name */
    /* JADX INFO: compiled from: multipart.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lokio/BufferedSource;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.internal.MultipartKt$multipartBodyFlow$2", f = "multipart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super BufferedSource>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<MultipartReader> $multipartReader;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<MultipartReader> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$multipartReader = objectRef;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super BufferedSource> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$multipartReader, continuation);
            anonymousClass2.L$0 = flowCollector;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<MultipartReader> objectRef = this.$multipartReader;
            try {
                Result.Companion companion = Result.INSTANCE;
                MultipartReader multipartReader = objectRef.element;
                if (multipartReader != null) {
                    multipartReader.close();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m14780constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getBoundaryParameter(String str) {
        Object next;
        List listSplit$default;
        String str2;
        if (str == null) {
            return null;
        }
        List listSplit$default2 = StringsKt.split$default((CharSequence) str, new char[]{';'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it = listSplit$default2.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        Iterator it2 = arrayList.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!StringsKt.startsWith$default((String) next, "boundary=", false, 2, (Object) null));
        String str3 = (String) next;
        if (str3 == null || (listSplit$default = StringsKt.split$default((CharSequence) str3, new char[]{'='}, false, 0, 6, (Object) null)) == null || (str2 = (String) CollectionsKt.getOrNull(listSplit$default, 1)) == null) {
            return null;
        }
        return StringsKt.trim(str2, '\"', '\'');
    }

    public static final boolean isMultipart(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        String strValueOf = HttpHeaders.valueOf(httpResponse.getHeaders(), "Content-Type");
        return strValueOf != null && StringsKt.startsWith(strValueOf, "multipart/", true);
    }
}
