package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.datasource.collection.CollectionsRemoteDataSource;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.BoxGQLEndpointSupport;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.mappers.GQLGetAllCollectionsToCollectionDTOMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.utils.exceptions.AbortFlowCollectionException;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCollectionsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionsResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "Lcom/box/android/data/datasource/gql/BoxGQLEndpointSupport;", "collectionsRemoteDataSource", "Lcom/box/android/data/datasource/collection/CollectionsRemoteDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/collection/CollectionsRemoteDataSource;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionsResponseInterceptor extends GQLBaseInterceptor implements BoxGQLEndpointSupport {
    private final CollectionsRemoteDataSource collectionsRemoteDataSource;
    private final Moshi moshi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCollectionsResponseInterceptor(CollectionsRemoteDataSource collectionsRemoteDataSource, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(collectionsRemoteDataSource, "collectionsRemoteDataSource");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionsRemoteDataSource = collectionsRemoteDataSource;
        this.moshi = moshi;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ArrayList arrayList = new ArrayList();
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(objectRef2, objectRef, arrayList, null), 1, null);
        if (objectRef.element != 0) {
            T t = objectRef.element;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type java.io.IOException");
            throw ((IOException) t);
        }
        return getResponse(200, chain.request(), (Error) objectRef2.element, new GetAllCollectionsQuery.Data(new GetAllCollectionsQuery.Collections(arrayList)));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionsResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1", f = "GQLCollectionsResponseInterceptor.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {CustomAttributeKeys.REMOTE_ERROR}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<GetAllCollectionsQuery.Edge> $list;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<Error> objectRef, Ref.ObjectRef<IOException> objectRef2, List<GetAllCollectionsQuery.Edge> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$responseError = objectRef;
            this.$thrownException = objectRef2;
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCollectionsResponseInterceptor.this.new AnonymousClass1(this.$responseError, this.$thrownException, this.$list, continuation);
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
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Flow flowOnCompletion = FlowKt.onCompletion(FlowKt.m16356catch(FlowKt.onEach(GQLCollectionsResponseInterceptor.this.collectionsRemoteDataSource.getCollections(), new C01621(objectRef, null)), new AnonymousClass2(objectRef, GQLCollectionsResponseInterceptor.this, null)), new AnonymousClass3(objectRef, null));
                final Ref.ObjectRef<Error> objectRef2 = this.$responseError;
                final GQLCollectionsResponseInterceptor gQLCollectionsResponseInterceptor = GQLCollectionsResponseInterceptor.this;
                final Ref.ObjectRef<IOException> objectRef3 = this.$thrownException;
                final List<GetAllCollectionsQuery.Edge> list = this.$list;
                this.L$0 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.label = 1;
                if (flowOnCompletion.collect(new FlowCollector() { // from class: com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor.intercept.1.4
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Result<? extends List<CollectionDTO>, ? extends RemoteError>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Result<? extends List<CollectionDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                        if (result instanceof Result.Success) {
                            Iterable iterable = (Iterable) ((Result.Success) result).getValue();
                            ArrayList<GetAllCollectionsQuery.Node> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            Iterator<T> it = iterable.iterator();
                            while (it.hasNext()) {
                                arrayList.add((GetAllCollectionsQuery.Node) GraphQLMapper.toGraphQL$default(GQLGetAllCollectionsToCollectionDTOMapper.INSTANCE, (CollectionDTO) it.next(), null, 2, null));
                            }
                            List<GetAllCollectionsQuery.Edge> list2 = list;
                            for (GetAllCollectionsQuery.Node node : arrayList) {
                                list2.add(new GetAllCollectionsQuery.Edge(node.getId(), new GetAllCollectionsQuery.Node(node.getId(), node.getCollectionType(), node.getName())));
                            }
                        } else {
                            if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Result.Error error = (Result.Error) result;
                            if (((RemoteError) error.getValue()) instanceof CollectionsRemoteError) {
                                Ref.ObjectRef<Error> objectRef4 = objectRef2;
                                GQLCollectionsResponseInterceptor gQLCollectionsResponseInterceptor2 = gQLCollectionsResponseInterceptor;
                                Object value = error.getValue();
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.data.datasource.errors.CollectionsRemoteError");
                                objectRef4.element = (T) gQLCollectionsResponseInterceptor2.getError((CollectionsRemoteError) value);
                            } else {
                                objectRef3.element = (T) new IOException(error.getValue() + " Code: " + ((RemoteError) error.getValue()).getCode());
                            }
                        }
                        return Unit.INSTANCE;
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

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCollectionsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "remoteCallResult", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$1", f = "GQLCollectionsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01621 extends SuspendLambda implements Function2<Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01621(Ref.ObjectRef<RemoteError> objectRef, Continuation<? super C01621> continuation) {
                super(2, continuation);
                this.$remoteError = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01621 c01621 = new C01621(this.$remoteError, continuation);
                c01621.L$0 = obj;
                return c01621;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Result<? extends List<CollectionDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                return ((C01621) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Result<? extends List<? extends CollectionDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                return invoke2((Result<? extends List<CollectionDTO>, ? extends RemoteError>) result, continuation);
            }

            /* JADX WARN: Type inference failed for: r3v5, types: [T, com.box.android.data.datasource.errors.RemoteError] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws AbortFlowCollectionException {
                Result result = (Result) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<RemoteError> objectRef = this.$remoteError;
                if (result instanceof Result.Success) {
                    return Unit.INSTANCE;
                }
                if (result instanceof Result.Error) {
                    objectRef.element = (RemoteError) ((Result.Error) result).getValue();
                    throw new AbortFlowCollectionException("Abort flow processing", null, 2, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$2", f = "GQLCollectionsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GQLCollectionsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Ref.ObjectRef<RemoteError> objectRef, GQLCollectionsResponseInterceptor gQLCollectionsResponseInterceptor, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
                this.this$0 = gQLCollectionsResponseInterceptor;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
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

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor$intercept$1$3", f = "GQLCollectionsResponseInterceptor.kt", i = {0, 0, 0, 0}, l = {66}, m = "invokeSuspend", n = {"$this$onCompletion", "cause", "it", "$i$a$-let-GQLCollectionsResponseInterceptor$intercept$1$3$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            int I$0;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Ref.ObjectRef<RemoteError> objectRef, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$remoteError, continuation);
                anonymousClass3.L$0 = flowCollector;
                anonymousClass3.L$1 = th;
                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                RemoteError remoteError;
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if ((th != null || this.$remoteError.element != null) && (remoteError = this.$remoteError.element) != null) {
                        Result.Error error = new Result.Error(remoteError);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(remoteError);
                        this.I$0 = 0;
                        this.label = 1;
                        if (flowCollector.emit(error, this) == coroutine_suspended) {
                            return coroutine_suspended;
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
    }
}
