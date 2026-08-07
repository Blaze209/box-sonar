package com.box.android.data.datasource.hubs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.box.android.data.GetHubsQuery;
import com.box.android.data.api.graphql.GetHubsGraphQLQuery;
import com.box.android.data.datasource.GQLErrorUtil;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.data.type.HubsDirectionEnum;
import com.box.android.data.type.HubsSortEnum;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: HubsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013JR\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/datasource/hubs/HubsDataSource;", "", "getHubsGraphQLQuery", "Lcom/box/android/data/api/graphql/GetHubsGraphQLQuery;", "<init>", "(Lcom/box/android/data/api/graphql/GetHubsGraphQLQuery;)V", "getHubs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/GetHubsQuery$Edge;", "Lcom/box/android/domain/models/DomainError;", "sort", "Lcom/box/android/data/type/HubsSortEnum;", "direction", "Lcom/box/android/data/type/HubsDirectionEnum;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "query", "", "fetchHubsPage", "Lcom/box/android/data/GetHubsQuery$Hubs;", "first", "", "fetchPolicy", "Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", TtmlNode.ANNOTATION_POSITION_AFTER, "(ILcom/box/android/data/type/HubsSortEnum;Lcom/box/android/data/type/HubsDirectionEnum;Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsDataSource {
    private static final int DEFAULT_HUBS_LIMIT = 30;
    private final GetHubsGraphQLQuery getHubsGraphQLQuery;

    /* JADX INFO: renamed from: com.box.android.data.datasource.hubs.HubsDataSource$fetchHubsPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.hubs.HubsDataSource", f = "HubsDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {85}, m = "fetchHubsPage", n = {"sort", "direction", "fetchPolicy", "query", TtmlNode.ANNOTATION_POSITION_AFTER, "first", "$i$f$resultOf", "$i$a$-resultOf-HubsDataSource$fetchHubsPage$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubsDataSource.this.fetchHubsPage(0, null, null, null, null, null, this);
        }
    }

    @Inject
    public HubsDataSource(GetHubsGraphQLQuery getHubsGraphQLQuery) {
        Intrinsics.checkNotNullParameter(getHubsGraphQLQuery, "getHubsGraphQLQuery");
        this.getHubsGraphQLQuery = getHubsGraphQLQuery;
    }

    public static /* synthetic */ Flow getHubs$default(HubsDataSource hubsDataSource, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, DataPolicy dataPolicy, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        return hubsDataSource.getHubs(hubsSortEnum, hubsDirectionEnum, dataPolicy, str);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.hubs.HubsDataSource$getHubs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HubsDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/GetHubsQuery$Edge;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.hubs.HubsDataSource$getHubs$1", f = "HubsDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {61, 67, 71}, m = "invokeSuspend", n = {"$this$flow", "cursor", "hasNextPage", SupportedFileExtensions.PAGES_EXTENSION, "$this$flow", "cursor", "hasNextPage", SupportedFileExtensions.PAGES_EXTENSION, "$this$onSuccess$iv", "hubsPage", "pageInfo", "$i$f$onSuccess", "$i$a$-onSuccess-HubsDataSource$getHubs$1$1", "$this$flow", "cursor", "hasNextPage", SupportedFileExtensions.PAGES_EXTENSION, "$this$onError$iv", "domainError", "$i$f$onError", "$i$a$-onError-HubsDataSource$getHubs$1$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C11591 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends GetHubsQuery.Edge>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        final /* synthetic */ HubsDirectionEnum $direction;
        final /* synthetic */ String $query;
        final /* synthetic */ HubsSortEnum $sort;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11591(HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, DataPolicy dataPolicy, String str, Continuation<? super C11591> continuation) {
            super(2, continuation);
            this.$sort = hubsSortEnum;
            this.$direction = hubsDirectionEnum;
            this.$dataPolicy = dataPolicy;
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11591 c11591 = HubsDataSource.this.new C11591(this.$sort, this.$direction, this.$dataPolicy, this.$query, continuation);
            c11591.L$0 = obj;
            return c11591;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends GetHubsQuery.Edge>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<GetHubsQuery.Edge>, ? extends DomainError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<GetHubsQuery.Edge>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11591) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:19:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:23:0x0115  */
        /* JADX WARN: Code duplicated, block: B:28:0x011e  */
        /* JADX WARN: Code duplicated, block: B:30:0x0122  */
        /* JADX WARN: Code duplicated, block: B:35:0x017d  */
        /* JADX WARN: Code duplicated, block: B:37:0x0183  */
        /* JADX WARN: Code duplicated, block: B:39:0x0188  */
        /* JADX WARN: Code duplicated, block: B:45:0x019a  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0177, code lost:
        
            if (r1.emit(r5, r20) == r2) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x010c -> B:22:0x010f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0117 -> B:22:0x010f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 416
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.hubs.HubsDataSource.C11591.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Result<List<GetHubsQuery.Edge>, DomainError>> getHubs(HubsSortEnum sort, HubsDirectionEnum direction, DataPolicy dataPolicy, String query) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(dataPolicy, "dataPolicy");
        return FlowKt.flow(new C11591(sort, direction, dataPolicy, query, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object fetchHubsPage(int i, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, FetchPolicy fetchPolicy, String str, String str2, Continuation<? super Result<GetHubsQuery.Hubs, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        Result.Error error2;
        GetHubsQuery.Data data;
        GetHubsQuery.Hubs hubs;
        DomainError.UnknownError unknownError;
        Error error3;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object hubs2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(hubs2);
                GetHubsGraphQLQuery getHubsGraphQLQuery = this.getHubsGraphQLQuery;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(hubsSortEnum);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(hubsDirectionEnum);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(fetchPolicy);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.I$0 = i;
                anonymousClass2.I$1 = 0;
                anonymousClass2.I$2 = 0;
                anonymousClass2.label = 1;
                hubs2 = getHubsGraphQLQuery.getHubs(i, str2, hubsSortEnum, hubsDirectionEnum, fetchPolicy, str, anonymousClass2);
                if (hubs2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = anonymousClass2.I$2;
                int i4 = anonymousClass2.I$1;
                int i5 = anonymousClass2.I$0;
                ResultKt.throwOnFailure(hubs2);
            }
            error = new Result.Success((ApolloResponse) hubs2);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, GQLErrorUtil.INSTANCE.getRemoteError((Exception) ((Result.Error) error).getValue()), null, 2, null));
        }
        if (error instanceof Result.Success) {
            ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
            if (apolloResponse != null && apolloResponse.hasErrors()) {
                List<Error> list = apolloResponse.errors;
                if (list == null || (error3 = (Error) CollectionsKt.firstOrNull((List) list)) == null || (unknownError = DomainErrorMapper.INSTANCE.toDomainError(error3)) == null) {
                    unknownError = new DomainError.UnknownError("Could not fetch hubs. Response has errors.");
                }
                error2 = new Result.Error(unknownError);
            } else if (apolloResponse != null && (data = (GetHubsQuery.Data) apolloResponse.data) != null && (hubs = data.getHubs()) != null) {
                error2 = new Result.Success(hubs);
            } else {
                error2 = new Result.Error(new DomainError.UnknownError("Could not fetch hubs. Response is null."));
            }
            return error2;
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ Object fetchHubsPage$default(HubsDataSource hubsDataSource, int i, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, FetchPolicy fetchPolicy, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str = null;
        }
        if ((i2 & 32) != 0) {
            str2 = null;
        }
        return hubsDataSource.fetchHubsPage(i, hubsSortEnum, hubsDirectionEnum, fetchPolicy, str, str2, continuation);
    }
}
