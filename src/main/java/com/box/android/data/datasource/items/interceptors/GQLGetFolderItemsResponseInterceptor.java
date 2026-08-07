package com.box.android.data.datasource.items.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.JobCancellationHelper;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J0\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00170\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J,\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0015H\u0087@¢\u0006\u0002\u0010\"J,\u0010#\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0015H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/data/datasource/items/interceptors/GQLGetFolderItemsResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "itemRemoteDataSource", "Lcom/box/android/data/datasource/ItemRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "gqlCacheHelper", "Lcom/box/android/data/utilities/GQLCacheHelper;", "<init>", "(Lcom/box/android/data/datasource/ItemRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/utilities/GQLCacheHelper;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "getFolderItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "folderId", "", "cancellationJobContext", "Lkotlin/coroutines/CoroutineContext;", "asyncUpdateEdgesInCache", "", "pageNumber", "", "fetchedEdges", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "(Ljava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEdgesInCache", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderItemsResponseInterceptor extends GQLBaseInterceptor {
    private static final int ASYNC_CACHE_WRITE_PAGES_NUMBER = 2;
    private final GQLCacheHelper gqlCacheHelper;
    private final ItemRemoteDataSource itemRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$updateEdgesInCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0, 0, 0}, l = {Token.GENEXPR}, m = "updateEdgesInCache", n = {"folderId", "fetchedEdges", "pageNumber"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11701(Continuation<? super C11701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLGetFolderItemsResponseInterceptor.this.updateEdgesInCache(null, 0, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLGetFolderItemsResponseInterceptor(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi, GQLCacheHelper gqlCacheHelper) {
        super(moshi);
        Intrinsics.checkNotNullParameter(itemRemoteDataSource, "itemRemoteDataSource");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(gqlCacheHelper, "gqlCacheHelper");
        this.itemRemoteDataSource = itemRemoteDataSource;
        this.requestParser = requestParser;
        this.moshi = moshi;
        this.gqlCacheHelper = gqlCacheHelper;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        String id = this.requestParser.parseId(chain.request());
        if (id == null) {
            throw new Exception("Missing Folder ID");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        BuildersKt__BuildersKt.runBlocking$default(null, new C11691(id, JobCancellationHelper.INSTANCE.getCoroutineContext(JobCancellationHelper.INSTANCE.createFetchFolderKey(id)), linkedHashSet, objectRef, null), 1, null);
        List list = CollectionsKt.toList(linkedHashSet);
        return getResponse(200, chain.request(), (Error) objectRef.element, new GetFolderItemsQuery.Data(new GetFolderItemsQuery.Folder(id, new GetFolderItemsQuery.ItemConnection(GQLCacheConstants.TYPENAME_ITEM_CONNECTION, new ItemConnectionFragment(list.size(), list)))));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0, 0}, l = {81}, m = "invokeSuspend", n = {"pageNumber", CustomAttributeKeys.REMOTE_ERROR}, s = {"L$0", "L$1"}, v = 1)
    static final class C11691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<ItemConnectionFragment.Edge> $allFetchedEdgesSet;
        final /* synthetic */ CoroutineContext $coroutineContext;
        final /* synthetic */ String $folderId;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11691(String str, CoroutineContext coroutineContext, Set<ItemConnectionFragment.Edge> set, Ref.ObjectRef<Error> objectRef, Continuation<? super C11691> continuation) {
            super(2, continuation);
            this.$folderId = str;
            this.$coroutineContext = coroutineContext;
            this.$allFetchedEdgesSet = set;
            this.$responseError = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLGetFolderItemsResponseInterceptor.this.new C11691(this.$folderId, this.$coroutineContext, this.$allFetchedEdgesSet, this.$responseError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 1;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                this.L$0 = SpillingKt.nullOutSpilledVariable(intRef);
                this.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.label = 1;
                if (FlowKt.onCompletion(FlowKt.m16356catch(FlowKt.onEach(GQLGetFolderItemsResponseInterceptor.this.getFolderItems(this.$folderId, this.$coroutineContext), new C01661(this.$coroutineContext, objectRef, null)), new AnonymousClass2(objectRef, GQLGetFolderItemsResponseInterceptor.this, null)), new AnonymousClass3(objectRef, GQLGetFolderItemsResponseInterceptor.this, null)).collect(new AnonymousClass4(this.$allFetchedEdgesSet, intRef, GQLGetFolderItemsResponseInterceptor.this, this.$folderId, this.$responseError), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "pageResult", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$1", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01661 extends SuspendLambda implements Function2<Result<? extends List<? extends IItemDTO>, ? extends RemoteError>, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineContext $coroutineContext;
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01661(CoroutineContext coroutineContext, Ref.ObjectRef<RemoteError> objectRef, Continuation<? super C01661> continuation) {
                super(2, continuation);
                this.$coroutineContext = coroutineContext;
                this.$remoteError = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01661 c01661 = new C01661(this.$coroutineContext, this.$remoteError, continuation);
                c01661.L$0 = obj;
                return c01661;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Result<? extends List<? extends IItemDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                return ((C01661) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r3v6, types: [T, com.box.android.data.datasource.errors.RemoteError] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Exception {
                Result result = (Result) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                JobKt.ensureActive(this.$coroutineContext);
                Ref.ObjectRef<RemoteError> objectRef = this.$remoteError;
                if (result instanceof Result.Success) {
                    return Unit.INSTANCE;
                }
                if (result instanceof Result.Error) {
                    objectRef.element = (RemoteError) ((Result.Error) result).getValue();
                    throw new Exception("Fetching folder items from remote failed!");
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$2", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Ref.ObjectRef<RemoteError> objectRef, GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
                this.this$0 = gQLGetFolderItemsResponseInterceptor;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteError, this.this$0, continuation);
                anonymousClass2.L$0 = th;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                T tHandleException;
                Throwable th = (Throwable) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<RemoteError> objectRef = this.$remoteError;
                RemoteError remoteError = objectRef.element;
                if (remoteError == null) {
                    tHandleException = remoteError;
                    tHandleException = this.this$0.handleException(th);
                }
                tHandleException = remoteError;
                objectRef.element = tHandleException;
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$3", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"$this$onCompletion", "cause", "it", "$i$a$-let-GQLGetFolderItemsResponseInterceptor$intercept$1$3$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            int I$0;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Ref.ObjectRef<RemoteError> objectRef, GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
                this.this$0 = gQLGetFolderItemsResponseInterceptor;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$remoteError, this.this$0, continuation);
                anonymousClass3.L$0 = flowCollector;
                anonymousClass3.L$1 = th;
                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteError remoteError = this.$remoteError.element;
                    if (remoteError != null) {
                        Result.Error error = new Result.Error(remoteError);
                        this.L$0 = flowCollector;
                        this.L$1 = th;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(remoteError);
                        this.I$0 = 0;
                        this.label = 1;
                        if (flowCollector.emit(error, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor = this.this$0;
                        if (th != null) {
                            gQLGetFolderItemsResponseInterceptor.handleException(th);
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class AnonymousClass4<T> implements FlowCollector {
            final /* synthetic */ Set<ItemConnectionFragment.Edge> $allFetchedEdgesSet;
            final /* synthetic */ String $folderId;
            final /* synthetic */ Ref.IntRef $pageNumber;
            final /* synthetic */ Ref.ObjectRef<Error> $responseError;
            final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

            AnonymousClass4(Set<ItemConnectionFragment.Edge> set, Ref.IntRef intRef, GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, String str, Ref.ObjectRef<Error> objectRef) {
                this.$allFetchedEdgesSet = set;
                this.$pageNumber = intRef;
                this.this$0 = gQLGetFolderItemsResponseInterceptor;
                this.$folderId = str;
                this.$responseError = objectRef;
            }

            /* JADX WARN: Code duplicated, block: B:42:0x0117  */
            /* JADX WARN: Code duplicated, block: B:44:0x011b  */
            /* JADX WARN: Code duplicated, block: B:46:0x012b  */
            /* JADX WARN: Code duplicated, block: B:47:0x0132  */
            /* JADX WARN: Code duplicated, block: B:49:0x0153  */
            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
            
                if (r5.asyncUpdateEdgesInCache(r6, r15, r8, r0) == r1) goto L36;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            
                r1 = r14;
                r14 = r2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x0101, code lost:
            
                if (r5.updateEdgesInCache(r6, r15, r8, r0) == r1) goto L36;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x0103, code lost:
            
                return r1;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends java.util.List<? extends com.box.android.data.api.models.items.IItemDTO>, ? extends com.box.android.data.datasource.errors.RemoteError> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 354
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor.C11691.AnonymousClass4.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result<? extends List<? extends IItemDTO>, ? extends RemoteError>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$getFolderItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$getFolderItems$1", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0}, l = {Token.COLONCOLON}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $cancellationJobContext;
        final /* synthetic */ String $folderId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineContext coroutineContext, GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cancellationJobContext = coroutineContext;
            this.this$0 = gQLGetFolderItemsResponseInterceptor;
            this.$folderId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$cancellationJobContext, this.this$0, this.$folderId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO().plus(this.$cancellationJobContext), new C01641(this.this$0, this.$folderId, producerScope, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$getFolderItems$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$getFolderItems$1$1", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0}, l = {Token.DOTQUERY}, m = "invokeSuspend", n = {"flow"}, s = {"L$0"}, v = 1)
        static final class C01641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> $$this$channelFlow;
            final /* synthetic */ String $folderId;
            Object L$0;
            int label;
            final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01641(GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, String str, ProducerScope<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> producerScope, Continuation<? super C01641> continuation) {
                super(2, continuation);
                this.this$0 = gQLGetFolderItemsResponseInterceptor;
                this.$folderId = str;
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01641(this.this$0, this.$folderId, this.$$this$channelFlow, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<Result<List<IItemDTO>, RemoteError>> folderItemsFromRemote = this.this$0.itemRemoteDataSource.getFolderItemsFromRemote(this.$folderId);
                    final ProducerScope<Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> producerScope = this.$$this$channelFlow;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(folderItemsFromRemote);
                    this.label = 1;
                    if (folderItemsFromRemote.collect(new FlowCollector() { // from class: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor.getFolderItems.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((Result<? extends List<? extends IItemDTO>, ? extends RemoteError>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(Result<? extends List<? extends IItemDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                            Object objSend = producerScope.send(result, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Result<List<IItemDTO>, RemoteError>> getFolderItems(String folderId, CoroutineContext cancellationJobContext) {
        return FlowKt.channelFlow(new AnonymousClass1(cancellationJobContext, this, folderId, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$asyncUpdateEdgesInCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$asyncUpdateEdgesInCache$2", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Unit>>, Object> {
        final /* synthetic */ List<ItemConnectionFragment.Edge> $fetchedEdges;
        final /* synthetic */ String $folderId;
        final /* synthetic */ int $pageNumber;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, List<ItemConnectionFragment.Edge> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$folderId = str;
            this.$pageNumber = i;
            this.$fetchedEdges = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = GQLGetFolderItemsResponseInterceptor.this.new AnonymousClass2(this.$folderId, this.$pageNumber, this.$fetchedEdges, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Deferred<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Unit>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$asyncUpdateEdgesInCache$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$asyncUpdateEdgesInCache$2$1", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {}, l = {Token.SETCONSTVAR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<ItemConnectionFragment.Edge> $fetchedEdges;
            final /* synthetic */ String $folderId;
            final /* synthetic */ int $pageNumber;
            int label;
            final /* synthetic */ GQLGetFolderItemsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor, String str, int i, List<ItemConnectionFragment.Edge> list, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = gQLGetFolderItemsResponseInterceptor;
                this.$folderId = str;
                this.$pageNumber = i;
                this.$fetchedEdges = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$folderId, this.$pageNumber, this.$fetchedEdges, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.updateEdgesInCache(this.$folderId, this.$pageNumber, this.$fetchedEdges, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(GQLGetFolderItemsResponseInterceptor.this, this.$folderId, this.$pageNumber, this.$fetchedEdges, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object asyncUpdateEdgesInCache(String str, int i, List<ItemConnectionFragment.Edge> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, i, list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateEdgesInCache(String str, int i, List<ItemConnectionFragment.Edge> list, Continuation<? super Unit> continuation) {
        C11701 c11701;
        if (continuation instanceof C11701) {
            c11701 = (C11701) continuation;
            if ((c11701.label & Integer.MIN_VALUE) != 0) {
                c11701.label -= Integer.MIN_VALUE;
            } else {
                c11701 = new C11701(continuation);
            }
        } else {
            c11701 = new C11701(continuation);
        }
        Object obj = c11701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11701.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            GQLCacheHelper gQLCacheHelper = this.gqlCacheHelper;
            c11701.L$0 = str;
            c11701.L$1 = SpillingKt.nullOutSpilledVariable(list);
            c11701.I$0 = i;
            c11701.label = 1;
            if (gQLCacheHelper.gqlUpdateEdgesInCache(str, list, c11701) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c11701.I$0;
            str = (String) c11701.L$0;
            ResultKt.throwOnFailure(obj);
        }
        BoxLogUtils.v("Saved page " + i + " of folder " + str + " to GQL cache");
        return Unit.INSTANCE;
    }
}
