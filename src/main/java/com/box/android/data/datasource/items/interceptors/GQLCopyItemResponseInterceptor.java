package com.box.android.data.datasource.items.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.CopyItemMutation;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.mappers.GQLCopyItemToIItemDTOMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCopyItemResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J>\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0087@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/datasource/items/interceptors/GQLCopyItemResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "itemRemoteDataSource", "Lcom/box/android/data/datasource/ItemRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/ItemRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "copyItem", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "newParent", "newName", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapItemDTOToMutation", "Lcom/box/android/data/CopyItemMutation$CopyItem;", "dto", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCopyItemResponseInterceptor extends GQLBaseInterceptor {
    private final ItemRemoteDataSource itemRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCopyItemResponseInterceptor(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(itemRemoteDataSource, "itemRemoteDataSource");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.itemRemoteDataSource = itemRemoteDataSource;
        this.requestParser = requestParser;
        this.moshi = moshi;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String intercept$lambda$0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return StringsKt.replace$default(value, "_", "", false, 4, (Object) null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCopyItemResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor$intercept$1", f = "GQLCopyItemResponseInterceptor.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ Ref.ObjectRef<CopyItemMutation.CopyItem> $mutation;
        final /* synthetic */ String $newName;
        final /* synthetic */ String $parentId;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ ItemType $safeItemType;
        final /* synthetic */ Ref.IntRef $statusCode;
        final /* synthetic */ Ref.ObjectRef<Exception> $thrownException;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, ItemType itemType, String str2, String str3, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef, Ref.ObjectRef<Exception> objectRef2, Ref.ObjectRef<CopyItemMutation.CopyItem> objectRef3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$safeItemType = itemType;
            this.$parentId = str2;
            this.$newName = str3;
            this.$statusCode = intRef;
            this.$responseError = objectRef;
            this.$thrownException = objectRef2;
            this.$mutation = objectRef3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCopyItemResponseInterceptor.this.new AnonymousClass1(this.$itemId, this.$safeItemType, this.$parentId, this.$newName, this.$statusCode, this.$responseError, this.$thrownException, this.$mutation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, com.box.android.data.CopyItemMutation$CopyItem] */
        /* JADX WARN: Type inference failed for: r8v21, types: [T, com.apollographql.apollo3.api.Error] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GQLCopyItemResponseInterceptor.this.copyItem(this.$itemId, this.$safeItemType, this.$parentId, this.$newName, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            Ref.IntRef intRef = this.$statusCode;
            Ref.ObjectRef<Error> objectRef = this.$responseError;
            GQLCopyItemResponseInterceptor gQLCopyItemResponseInterceptor = GQLCopyItemResponseInterceptor.this;
            Ref.ObjectRef<Exception> objectRef2 = this.$thrownException;
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    RemoteError remoteError = (RemoteError) ((Result.Error) error).getValue();
                    if (ItemRemoteDataSource.INSTANCE.isKnownCopyMoveError(remoteError)) {
                        intRef.element = remoteError.getCode();
                        objectRef.element = gQLCopyItemResponseInterceptor.getError(remoteError);
                    } else {
                        objectRef2.element = new IOException(remoteError + " Code: " + remoteError.getCode());
                    }
                    error = new Result.Error(Unit.INSTANCE);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Ref.ObjectRef<CopyItemMutation.CopyItem> objectRef3 = this.$mutation;
            GQLCopyItemResponseInterceptor gQLCopyItemResponseInterceptor2 = GQLCopyItemResponseInterceptor.this;
            if (error instanceof Result.Success) {
                objectRef3.element = gQLCopyItemResponseInterceptor2.mapItemDTOToMutation((IItemDTO) ((Result.Success) error).getValue());
                return new Result.Success(Unit.INSTANCE);
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String id = this.requestParser.parseId(request);
        if (id == null) {
            throw new IOException("No Item ID provided for the request!");
        }
        String newParentId = this.requestParser.parseNewParentId(request);
        if (newParentId == null) {
            throw new IOException("No New Parent ID provided for the request!");
        }
        String itemType = this.requestParser.parseItemType(request);
        if (itemType == null) {
            throw new IOException("No Item Type provided for the request!");
        }
        String newName = this.requestParser.parseNewName(request);
        ItemType itemTypeValueOfWithTransform = ItemType.INSTANCE.valueOfWithTransform(itemType, new Function1() { // from class: com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GQLCopyItemResponseInterceptor.intercept$lambda$0((String) obj);
            }
        });
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(id, itemTypeValueOfWithTransform, newParentId, newName, intRef, objectRef, objectRef3, objectRef2, null), 1, null);
        Exception exc = (Exception) objectRef3.element;
        if (exc != null) {
            throw exc;
        }
        return getResponse(intRef.element, request, (Error) objectRef.element, new CopyItemMutation.Data((CopyItemMutation.CopyItem) objectRef2.element));
    }

    public static /* synthetic */ Object copyItem$default(GQLCopyItemResponseInterceptor gQLCopyItemResponseInterceptor, String str, ItemType itemType, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return gQLCopyItemResponseInterceptor.copyItem(str, itemType, str2, str3, continuation);
    }

    public final Object copyItem(String str, ItemType itemType, String str2, String str3, Continuation<? super Result<? extends IItemDTO, ? extends RemoteError>> continuation) {
        return this.itemRemoteDataSource.copy(new ItemId.Remote(str, itemType), str2, str3, continuation);
    }

    public final CopyItemMutation.CopyItem mapItemDTOToMutation(IItemDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return (CopyItemMutation.CopyItem) GraphQLMapper.toGraphQL$default(GQLCopyItemToIItemDTOMapper.INSTANCE, dto, null, 2, null);
    }
}
