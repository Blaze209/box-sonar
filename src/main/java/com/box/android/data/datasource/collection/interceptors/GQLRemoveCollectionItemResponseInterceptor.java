package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.DeleteCollectionItemMutation;
import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLRemoveCollectionItemResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLRemoveCollectionItemResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "collectionItemsRemoteDataSource", "Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLRemoveCollectionItemResponseInterceptor extends GQLBaseInterceptor {
    private final CollectionItemsRemoteDataSource collectionItemsRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLRemoveCollectionItemResponseInterceptor(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
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

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLRemoveCollectionItemResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor$intercept$1", f = "GQLRemoveCollectionItemResponseInterceptor.kt", i = {0, 1, 1, 1}, l = {49, 101}, m = "invokeSuspend", n = {"remoteId", "remoteId", "remoteResult", "cacheOperation"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $itemId;
        final /* synthetic */ String $itemType;
        final /* synthetic */ Ref.ObjectRef<DeleteCollectionItemMutation.DeleteCollectionItem> $mutation;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.IntRef $statusCode;
        final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ GQLRemoveCollectionItemResponseInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, GQLRemoveCollectionItemResponseInterceptor gQLRemoveCollectionItemResponseInterceptor, String str3, Ref.ObjectRef<DeleteCollectionItemMutation.DeleteCollectionItem> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef2, Ref.ObjectRef<IOException> objectRef3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = str2;
            this.this$0 = gQLRemoveCollectionItemResponseInterceptor;
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

        /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
        
            if (r12 == r0) goto L15;
         */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, java.io.IOException] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(String str) {
            return StringsKt.replace$default(str, "_", "", false, 4, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        GQLRequestParser.RequestVariables allVariables = this.requestParser.parseAllVariables(chain.request());
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
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(itemId, itemType, this, collectionId, objectRef, intRef, objectRef3, objectRef2, null), 1, null);
        IOException iOException = (IOException) objectRef2.element;
        if (iOException != null) {
            throw iOException;
        }
        return getResponse(intRef.element, chain.request(), (Error) objectRef3.element, new DeleteCollectionItemMutation.Data((DeleteCollectionItemMutation.DeleteCollectionItem) objectRef.element));
    }
}
