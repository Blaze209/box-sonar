package com.box.android.data.datasource.items.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.mappers.GQLGetItemWithWatermarkDataQueryToIItemDTOMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLGetItemWithWatermarkDataResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/items/interceptors/GQLGetItemWithWatermarkDataResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "itemRemoteDataSource", "Lcom/box/android/data/datasource/ItemRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/ItemRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemWithWatermarkDataResponseInterceptor extends GQLBaseInterceptor {
    private static final Companion Companion = new Companion(null);
    private static final String LOG_TAG = "GQLGetItemWithWatermarkDataResponseInterceptor";
    private final ItemRemoteDataSource itemRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLGetItemWithWatermarkDataResponseInterceptor(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String itemId = this.requestParser.parseItemId(request);
        if (itemId == null) {
            BoxLogUtils.e(LOG_TAG, "No Item ID provided for the request!");
            throw new IOException("No Item ID provided for the request!");
        }
        String itemType = this.requestParser.parseItemType(request);
        if (itemType == null) {
            BoxLogUtils.e(LOG_TAG, "No Item Type provided for the request!");
            throw new IOException("No Item Type provided for the request!");
        }
        try {
            ItemType itemTypeValueOfWithTransform = ItemType.INSTANCE.valueOfWithTransform(itemType, new Function1() { // from class: com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GQLGetItemWithWatermarkDataResponseInterceptor.intercept$lambda$2((String) obj);
                }
            });
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(itemId, itemTypeValueOfWithTransform, objectRef, objectRef2, null), 1, null);
            return getResponse(200, request, (Error) objectRef2.element, new GetItemWithWatermarkDataQuery.Data((GetItemWithWatermarkDataQuery.Item) objectRef.element));
        } catch (Exception e) {
            Exception exc = e;
            BoxLogUtils.e(LOG_TAG, "Invalid item type: " + itemType, exc);
            throw new IOException("Invalid item type: " + itemType, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String intercept$lambda$2(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return StringsKt.replace$default(value, "_", "", false, 4, (Object) null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLGetItemWithWatermarkDataResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor$intercept$1", f = "GQLGetItemWithWatermarkDataResponseInterceptor.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends IItemDTO, ? extends RemoteError>>, Object> {
        final /* synthetic */ String $itemId;
        final /* synthetic */ Ref.ObjectRef<GetItemWithWatermarkDataQuery.Item> $queryItem;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ ItemType $safeItemType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, ItemType itemType, Ref.ObjectRef<GetItemWithWatermarkDataQuery.Item> objectRef, Ref.ObjectRef<Error> objectRef2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$safeItemType = itemType;
            this.$queryItem = objectRef;
            this.$responseError = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLGetItemWithWatermarkDataResponseInterceptor.this.new AnonymousClass1(this.$itemId, this.$safeItemType, this.$queryItem, this.$responseError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends IItemDTO, ? extends RemoteError>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, com.apollographql.apollo3.api.Error] */
        /* JADX WARN: Type inference failed for: r7v5, types: [T, com.apollographql.apollo3.api.Error] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GQLGetItemWithWatermarkDataResponseInterceptor.this.itemRemoteDataSource.getItem(new ItemId.Remote(this.$itemId, this.$safeItemType), this);
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
            String str = this.$itemId;
            Ref.ObjectRef<GetItemWithWatermarkDataQuery.Item> objectRef = this.$queryItem;
            boolean z = result instanceof Result.Success;
            if (z) {
                IItemDTO iItemDTO = (IItemDTO) ((Result.Success) result).getValue();
                BoxLogUtils.v(GQLGetItemWithWatermarkDataResponseInterceptor.LOG_TAG, "Successfully fetched item " + str + " from V2 API");
                objectRef.element = GraphQLMapper.toGraphQL$default(GQLGetItemWithWatermarkDataQueryToIItemDTOMapper.INSTANCE, iItemDTO, null, 2, null);
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            String str2 = this.$itemId;
            Ref.ObjectRef<Error> objectRef2 = this.$responseError;
            GQLGetItemWithWatermarkDataResponseInterceptor gQLGetItemWithWatermarkDataResponseInterceptor = GQLGetItemWithWatermarkDataResponseInterceptor.this;
            if (z) {
                return result;
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            RemoteError remoteError = (RemoteError) ((Result.Error) result).getValue();
            BoxLogUtils.e(GQLGetItemWithWatermarkDataResponseInterceptor.LOG_TAG, "Failed to fetch item " + str2 + " from V2 API: " + remoteError);
            if (remoteError instanceof ItemsRemoteError) {
                objectRef2.element = gQLGetItemWithWatermarkDataResponseInterceptor.getError(remoteError);
                return result;
            }
            BoxLogUtils.e(GQLGetItemWithWatermarkDataResponseInterceptor.LOG_TAG, "Unexpected error type: " + remoteError.getClass().getSimpleName() + ", code: " + remoteError.getCode());
            objectRef2.element = gQLGetItemWithWatermarkDataResponseInterceptor.getError(remoteError);
            return result;
        }
    }

    /* JADX INFO: compiled from: GQLGetItemWithWatermarkDataResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/items/interceptors/GQLGetItemWithWatermarkDataResponseInterceptor$Companion;", "", "<init>", "()V", "LOG_TAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
