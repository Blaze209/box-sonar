package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.GetCollectionsWithItemQuery;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.mappers.GQLGetCollectionsWithItemToBoxItemMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: GQLCollectionsWithItemResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionsWithItemResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "boxExtendedApiFile", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "boxExtendedApiWeblink", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;", "baseModelControllerService", "Lcom/box/android/domain/services/IBaseModelControllerService;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;Lcom/box/android/domain/services/IBaseModelControllerService;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "fetchBoxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "itemId", "", "itemType", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionsWithItemResponseInterceptor extends GQLBaseInterceptor {
    private final IBaseModelControllerService baseModelControllerService;
    private final BoxExtendedApiFile boxExtendedApiFile;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final BoxExtendedApiWeblink boxExtendedApiWeblink;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX INFO: compiled from: GQLCollectionsWithItemResponseInterceptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCollectionsWithItemResponseInterceptor(GQLRequestParser requestParser, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelControllerService baseModelControllerService, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(boxExtendedApiFile, "boxExtendedApiFile");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(boxExtendedApiWeblink, "boxExtendedApiWeblink");
        Intrinsics.checkNotNullParameter(baseModelControllerService, "baseModelControllerService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.requestParser = requestParser;
        this.boxExtendedApiFile = boxExtendedApiFile;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.boxExtendedApiWeblink = boxExtendedApiWeblink;
        this.baseModelControllerService = baseModelControllerService;
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
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        String itemId = this.requestParser.parseItemId(chain.request());
        String itemType = this.requestParser.parseItemType(chain.request());
        if (itemId != null && itemType != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(itemId, itemType, objectRef, objectRef2, intRef, null), 1, null);
            int i = intRef.element;
            Request request = chain.request();
            RemoteError remoteError = (RemoteError) objectRef2.element;
            return getResponse(i, request, remoteError != null ? getError(remoteError) : null, new GetCollectionsWithItemQuery.Data((GetCollectionsWithItemQuery.Item) objectRef.element));
        }
        throw new IOException("expecting valid itemId (" + itemId + ") and itemType (" + itemType + ")");
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionsWithItemResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor$intercept$1", f = "GQLCollectionsWithItemResponseInterceptor.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<GetCollectionsWithItemQuery.Item> $gqlCollectionsWithItem;
        final /* synthetic */ String $itemId;
        final /* synthetic */ String $itemType;
        final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
        final /* synthetic */ Ref.IntRef $statusCode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Ref.ObjectRef<GetCollectionsWithItemQuery.Item> objectRef, Ref.ObjectRef<RemoteError> objectRef2, Ref.IntRef intRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemId = str;
            this.$itemType = str2;
            this.$gqlCollectionsWithItem = objectRef;
            this.$remoteError = objectRef2;
            this.$statusCode = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = GQLCollectionsWithItemResponseInterceptor.this.new AnonymousClass1(this.$itemId, this.$itemType, this.$gqlCollectionsWithItem, this.$remoteError, this.$statusCode, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, com.box.android.data.datasource.errors.RemoteError$Unknown] */
        /* JADX WARN: Type inference failed for: r7v6, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = GQLCollectionsWithItemResponseInterceptor.this.fetchBoxItem(this.$itemId, this.$itemType, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BoxItem boxItem = (BoxItem) obj;
            if (boxItem != null) {
                this.$gqlCollectionsWithItem.element = GraphQLMapper.toGraphQL$default(GQLGetCollectionsWithItemToBoxItemMapper.INSTANCE, boxItem, null, 2, null);
            } else {
                this.$remoteError.element = new RemoteError.Unknown(this.$statusCode.element, "Failed to fetch Box Item (itemId=" + this.$itemId + ", type=" + this.$itemType);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object fetchBoxItem(String str, String str2, Continuation<? super BoxItem> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[ItemType.INSTANCE.valueOfWithTransform(str2, new Function1() { // from class: com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GQLCollectionsWithItemResponseInterceptor.fetchBoxItem$lambda$0((String) obj);
            }
        }).ordinal()];
        if (i == 1) {
            IBaseModelControllerService iBaseModelControllerService = this.baseModelControllerService;
            BoxRequestsFile.GetFileInfo infoRequest = this.boxExtendedApiFile.getInfoRequest(str);
            Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
            return ExtensionsKt.perform(iBaseModelControllerService, infoRequest, continuation);
        }
        if (i == 2) {
            IBaseModelControllerService iBaseModelControllerService2 = this.baseModelControllerService;
            BoxRequestsFolder.GetFolderInfo infoRequest2 = this.boxExtendedApiFolder.getInfoRequest(str);
            Intrinsics.checkNotNullExpressionValue(infoRequest2, "getInfoRequest(...)");
            return ExtensionsKt.perform(iBaseModelControllerService2, infoRequest2, continuation);
        }
        if (i != 3) {
            return null;
        }
        IBaseModelControllerService iBaseModelControllerService3 = this.baseModelControllerService;
        BoxRequestsBookmark.GetBookmarkInfo infoRequest3 = this.boxExtendedApiWeblink.getInfoRequest(str);
        Intrinsics.checkNotNullExpressionValue(infoRequest3, "getInfoRequest(...)");
        return ExtensionsKt.perform(iBaseModelControllerService3, infoRequest3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fetchBoxItem$lambda$0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return StringsKt.replace$default(value, "_", "", false, 4, (Object) null);
    }
}
