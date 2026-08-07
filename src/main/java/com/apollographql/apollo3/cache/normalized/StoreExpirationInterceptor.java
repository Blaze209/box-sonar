package com.apollographql.apollo3.cache.normalized;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpKt;
import com.apollographql.apollo3.cache.normalized.api.ApolloCacheHeaders;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import com.apollographql.apollo3.mpp.UtilsKt;
import com.apollographql.apollo3.network.http.HttpInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/StoreExpirationInterceptor;", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "()V", "intercept", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "chain", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptorChain;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class StoreExpirationInterceptor implements ApolloInterceptor {
    @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
    public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(final ApolloRequest<D> request, ApolloInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        final Flow<ApolloResponse<D>> flowProceed = chain.proceed(request);
        return (Flow) new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.cache.normalized.StoreExpirationInterceptor$intercept$$inlined$map$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.StoreExpirationInterceptor$intercept$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ApolloRequest $request$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.StoreExpirationInterceptor$intercept$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.StoreExpirationInterceptor$intercept$$inlined$map$1$2", f = "ClientCacheExtensions.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ApolloRequest apolloRequest) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$request$inlined = apolloRequest;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Integer intOrNull;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ApolloResponse apolloResponseBuild = (ApolloResponse) obj;
                        StoreExpirationDateContext storeExpirationDateContext = (StoreExpirationDateContext) this.$request$inlined.getExecutionContext().get(StoreExpirationDateContext.INSTANCE);
                        if (Intrinsics.areEqual(storeExpirationDateContext != null ? Boxing.boxBoolean(storeExpirationDateContext.getValue()) : null, Boxing.boxBoolean(true))) {
                            HttpInfo httpInfo = (HttpInfo) apolloResponseBuild.executionContext.get(HttpInfo.INSTANCE);
                            List<HttpHeader> headers = httpInfo != null ? httpInfo.getHeaders() : null;
                            if (headers == null) {
                                headers = CollectionsKt.emptyList();
                            }
                            String str = HttpKt.get(headers, "cache-control");
                            if (str != null) {
                                String lowerCase = str.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                if (lowerCase != null) {
                                    List listSplit$default = StringsKt.split$default((CharSequence) lowerCase, new String[]{","}, false, 0, 6, (Object) null);
                                    ArrayList<String> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                                    Iterator<T> it = listSplit$default.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    for (String str2 : arrayList) {
                                        if (StringsKt.startsWith$default(str2, "max-age=", false, 2, (Object) null)) {
                                            String strSubstring = str2.substring(8);
                                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                            intOrNull = StringsKt.toIntOrNull(strSubstring);
                                        } else {
                                            intOrNull = null;
                                        }
                                        if (intOrNull != null) {
                                            arrayList2.add(intOrNull);
                                        }
                                    }
                                    Integer num = (Integer) CollectionsKt.firstOrNull((List) arrayList2);
                                    if (num != null) {
                                        int iIntValue = num.intValue();
                                        String str3 = HttpKt.get(headers, "age");
                                        Integer intOrNull2 = str3 != null ? StringsKt.toIntOrNull(str3) : null;
                                        apolloResponseBuild = NormalizedCache.cacheHeaders(apolloResponseBuild.newBuilder(), NormalizedCache.getCacheHeaders(apolloResponseBuild).newBuilder().addHeader(ApolloCacheHeaders.DATE, String.valueOf(intOrNull2 != null ? ((UtilsKt.currentTimeMillis() / ((long) 1000)) + ((long) iIntValue)) - ((long) intOrNull2.intValue()) : (UtilsKt.currentTimeMillis() / ((long) 1000)) + ((long) iIntValue))).build()).build();
                                    }
                                }
                            }
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(apolloResponseBuild, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowProceed.collect(new AnonymousClass2(flowCollector, request), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }
}
