package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.CreateCollectionMutation;
import com.box.android.data.datasource.collection.CollectionsRemoteDataSource;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.BoxGQLEndpointSupport;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.mappers.GQLCreateCollectionToCollectionDTOMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.io.IOException;
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
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCreateCollectionResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLCreateCollectionResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "Lcom/box/android/data/datasource/gql/BoxGQLEndpointSupport;", "collectionsRemoteDataSource", "Lcom/box/android/data/datasource/collection/CollectionsRemoteDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/collection/CollectionsRemoteDataSource;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "getCollectionType", "()Lcom/box/android/domain/models/CollectionType;", "setCollectionType", "(Lcom/box/android/domain/models/CollectionType;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateCollectionResponseInterceptor extends GQLBaseInterceptor implements BoxGQLEndpointSupport {
    private CollectionType collectionType;
    private final CollectionsRemoteDataSource collectionsRemoteDataSource;
    private final Moshi moshi;
    private String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCreateCollectionResponseInterceptor(CollectionsRemoteDataSource collectionsRemoteDataSource, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(collectionsRemoteDataSource, "collectionsRemoteDataSource");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionsRemoteDataSource = collectionsRemoteDataSource;
        this.moshi = moshi;
        this.name = "noname";
        this.collectionType = CollectionType.PERSONAL;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final CollectionType getCollectionType() {
        return this.collectionType;
    }

    public final void setCollectionType(CollectionType collectionType) {
        Intrinsics.checkNotNullParameter(collectionType, "<set-?>");
        this.collectionType = collectionType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(objectRef3, intRef, objectRef2, objectRef, null), 1, null);
        if (objectRef.element != 0) {
            T t = objectRef.element;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type java.io.IOException");
            throw ((IOException) t);
        }
        return getResponse(intRef.element, chain.request(), (Error) objectRef2.element, new CreateCollectionMutation.Data((CreateCollectionMutation.CreateCollection) objectRef3.element));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCreateCollectionResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionResponseInterceptor$intercept$1", f = "GQLCreateCollectionResponseInterceptor.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<CreateCollectionMutation.CreateCollection> $mutation;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.IntRef $statusCode;
        final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<CreateCollectionMutation.CreateCollection> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef2, Ref.ObjectRef<IOException> objectRef3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mutation = objectRef;
            this.$statusCode = intRef;
            this.$responseError = objectRef2;
            this.$thrownException = objectRef3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCreateCollectionResponseInterceptor.this.new AnonymousClass1(this.$mutation, this.$statusCode, this.$responseError, this.$thrownException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r5v3, types: [T, com.apollographql.apollo3.api.Error] */
        /* JADX WARN: Type inference failed for: r6v15, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GQLCreateCollectionResponseInterceptor.this.collectionsRemoteDataSource.createCollection(GQLCreateCollectionResponseInterceptor.this.getName(), GQLCreateCollectionResponseInterceptor.this.getCollectionType(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                this.$mutation.element = GraphQLMapper.toGraphQL$default(GQLCreateCollectionToCollectionDTOMapper.INSTANCE, ((Result.Success) result).getValue(), null, 2, null);
            } else {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result.Error error = (Result.Error) result;
                this.$statusCode.element = ((RemoteError) error.getValue()).getCode();
                RemoteError remoteError = (RemoteError) error.getValue();
                if ((remoteError instanceof CollectionsRemoteError) || this.$statusCode.element == 409) {
                    this.$responseError.element = GQLCreateCollectionResponseInterceptor.this.getError(remoteError);
                } else {
                    this.$thrownException.element = new IOException(error.getValue() + " Code: " + ((RemoteError) error.getValue()).getCode());
                }
            }
            return Unit.INSTANCE;
        }
    }
}
