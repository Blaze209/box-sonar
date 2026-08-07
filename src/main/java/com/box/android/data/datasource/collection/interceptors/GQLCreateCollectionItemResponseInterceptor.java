package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.box.android.data.CreateCollectionItemMutation;
import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.BoxGQLEndpointSupport;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.service.impl.CollectionItemRelationEntity;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCreateCollectionItemResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLCreateCollectionItemResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "Lcom/box/android/data/datasource/gql/BoxGQLEndpointSupport;", "collectionItemsRemoteDataSource", "Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "apolloStore", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "getApolloStore", "()Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "setApolloStore", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateCollectionItemResponseInterceptor extends GQLBaseInterceptor implements BoxGQLEndpointSupport {
    public ApolloStore apolloStore;
    private final CollectionItemsRemoteDataSource collectionItemsRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCreateCollectionItemResponseInterceptor(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(collectionItemsRemoteDataSource, "collectionItemsRemoteDataSource");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionItemsRemoteDataSource = collectionItemsRemoteDataSource;
        this.requestParser = requestParser;
        this.moshi = moshi;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    public final ApolloStore getApolloStore() {
        ApolloStore apolloStore = this.apolloStore;
        if (apolloStore != null) {
            return apolloStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apolloStore");
        return null;
    }

    public final void setApolloStore(ApolloStore apolloStore) {
        Intrinsics.checkNotNullParameter(apolloStore, "<set-?>");
        this.apolloStore = apolloStore;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCreateCollectionItemResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor$intercept$1", f = "GQLCreateCollectionItemResponseInterceptor.kt", i = {0, 1, 1}, l = {53, 59}, m = "invokeSuspend", n = {"remoteId", "remoteId", "remoteResult"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $itemId;
        final /* synthetic */ String $itemType;
        final /* synthetic */ Ref.ObjectRef<CreateCollectionItemMutation.CreateCollectionItem> $mutation;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.IntRef $statusCode;
        final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ GQLCreateCollectionItemResponseInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, GQLCreateCollectionItemResponseInterceptor gQLCreateCollectionItemResponseInterceptor, String str3, Ref.ObjectRef<CreateCollectionItemMutation.CreateCollectionItem> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef2, Ref.ObjectRef<IOException> objectRef3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = str2;
            this.this$0 = gQLCreateCollectionItemResponseInterceptor;
            this.$collectionId = str3;
            this.$mutation = objectRef;
            this.$statusCode = intRef;
            this.$responseError = objectRef2;
            this.$thrownException = objectRef3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$itemId, this.$itemType, this.this$0, this.$collectionId, this.$mutation, this.$statusCode, this.$responseError, this.$thrownException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
        
            if (r11 == r0) goto L15;
         */
        /* JADX WARN: Type inference failed for: r11v15, types: [T, com.box.android.data.CreateCollectionItemMutation$CreateCollectionItem] */
        /* JADX WARN: Type inference failed for: r11v29, types: [T, com.apollographql.apollo3.api.Error] */
        /* JADX WARN: Type inference failed for: r1v8, types: [T, java.io.IOException] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 322
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(String str) {
            return StringsKt.replace$default(str, "_", "", false, 4, (Object) null);
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor$intercept$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCreateCollectionItemResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/IGenericError;", "results", "", "Lcom/box/android/data/service/impl/CollectionItemRelationEntity;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor$intercept$1$1", f = "GQLCreateCollectionItemResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01631 extends SuspendLambda implements Function2<List<? extends Result<? extends CollectionItemRelationEntity, ? extends RemoteError>>, Continuation<? super Result<? extends Unit, ? extends IGenericError>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C01631(Continuation<? super C01631> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01631 c01631 = new C01631(continuation);
                c01631.L$0 = obj;
                return c01631;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends Result<? extends CollectionItemRelationEntity, ? extends RemoteError>> list, Continuation<? super Result<? extends Unit, ? extends IGenericError>> continuation) {
                return invoke2((List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>>) list, (Continuation<? super Result<Unit, ? extends IGenericError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>> list, Continuation<? super Result<Unit, ? extends IGenericError>> continuation) {
                return ((C01631) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List list = (List) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Result result = (Result) list.get(0);
                if (result instanceof Result.Success) {
                    new Result.Success(Unit.INSTANCE);
                    return new Result.Success(Unit.INSTANCE);
                }
                if (result instanceof Result.Error) {
                    return result;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        GQLRequestParser.RequestVariables allVariables = this.requestParser.parseAllVariables(request);
        if (allVariables == null) {
            throw new IOException("No variables provided for the request!");
        }
        String itemId = allVariables.getItemId();
        if (itemId == null) {
            throw new IOException("No Item ID provided for the request!");
        }
        String itemType = allVariables.getItemType();
        if (itemType == null) {
            throw new IOException("No Item Type for the request!");
        }
        String collectionId = allVariables.getCollectionId();
        if (collectionId == null) {
            throw new IOException("No Collection ID provided for the request!");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(itemId, itemType, this, collectionId, objectRef, intRef, objectRef2, objectRef3, null), 1, null);
        IOException iOException = (IOException) objectRef3.element;
        if (iOException != null) {
            throw iOException;
        }
        return getResponse(intRef.element, request, (Error) objectRef2.element, new CreateCollectionItemMutation.Data((CreateCollectionItemMutation.CreateCollectionItem) objectRef.element));
    }
}
