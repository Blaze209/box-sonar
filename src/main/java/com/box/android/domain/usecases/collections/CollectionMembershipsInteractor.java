package com.box.android.domain.usecases.collections;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CollectionMembershipsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096@¢\u0006\u0002\u0010\u001dJ0\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/domain/usecases/collections/CollectionMembershipsInteractor;", "Lcom/box/android/domain/usecases/collections/CollectionMembershipsUseCase;", "collectionsService", "Lcom/box/android/domain/services/ICollectionsService;", "boxExtendedApiFile", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "boxExtendedApiWeblink", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;", "baseModelControllerService", "Lcom/box/android/domain/services/IBaseModelControllerService;", "captureHistoryFilesService", "Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;Lcom/box/android/domain/services/IBaseModelControllerService;Lcom/box/android/domain/services/ICaptureHistoryFilesService;)V", "getCollectionMemberships", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addItemToCollections", "", "collectionIds", "", "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeItemFromCollections", "fetchChangedBoxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionMembershipsInteractor implements CollectionMembershipsUseCase {
    public static final String LOGTAG = "CollectionMembershipsInteractor";
    private final IBaseModelControllerService baseModelControllerService;
    private final BoxExtendedApiFile boxExtendedApiFile;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final BoxExtendedApiWeblink boxExtendedApiWeblink;
    private final ICaptureHistoryFilesService captureHistoryFilesService;
    private final ICollectionsService collectionsService;

    /* JADX INFO: compiled from: CollectionMembershipsInteractor.kt */
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

    @Inject
    public CollectionMembershipsInteractor(ICollectionsService collectionsService, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelControllerService baseModelControllerService, ICaptureHistoryFilesService captureHistoryFilesService) {
        Intrinsics.checkNotNullParameter(collectionsService, "collectionsService");
        Intrinsics.checkNotNullParameter(boxExtendedApiFile, "boxExtendedApiFile");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(boxExtendedApiWeblink, "boxExtendedApiWeblink");
        Intrinsics.checkNotNullParameter(baseModelControllerService, "baseModelControllerService");
        Intrinsics.checkNotNullParameter(captureHistoryFilesService, "captureHistoryFilesService");
        this.collectionsService = collectionsService;
        this.boxExtendedApiFile = boxExtendedApiFile;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.boxExtendedApiWeblink = boxExtendedApiWeblink;
        this.baseModelControllerService = baseModelControllerService;
        this.captureHistoryFilesService = captureHistoryFilesService;
    }

    @Override // com.box.android.domain.usecases.collections.CollectionMembershipsUseCase
    public Object getCollectionMemberships(ItemId.Remote remote, Continuation<? super Result<? extends Set<CollectionModel>, ? extends DomainError>> continuation) {
        return ICollectionsService.getCollections$default(this.collectionsService, remote, null, continuation, 2, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.box.android.domain.utils.result.Result$Success] */
    @Override // com.box.android.domain.usecases.collections.CollectionMembershipsUseCase
    public Object addItemToCollections(ItemId.Remote remote, Iterable<String> iterable, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new Result.Success(Unit.INSTANCE);
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(iterable, objectRef, this, remote, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.CollectionMembershipsInteractor$addItemToCollections$2, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionMembershipsInteractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.CollectionMembershipsInteractor$addItemToCollections$2", f = "CollectionMembershipsInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 2, 2}, l = {42, 52, 53}, m = "invokeSuspend", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-CollectionMembershipsInteractor$addItemToCollections$2$1", "it", "$i$a$-let-CollectionMembershipsInteractor$addItemToCollections$2$2"}, s = {"L$0", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ Iterable<String> $collectionIds;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ CollectionMembershipsInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Iterable<String> iterable, Ref.ObjectRef<Result<Unit, DomainError>> objectRef, CollectionMembershipsInteractor collectionMembershipsInteractor, ItemId.Remote remote, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$collectionIds = iterable;
            this.$result = objectRef;
            this.this$0 = collectionMembershipsInteractor;
            this.$remoteId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$collectionIds, this.$result, this.this$0, this.$remoteId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0088  */
        /* JADX WARN: Code duplicated, block: B:18:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:21:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:22:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:25:0x00de  */
        /* JADX WARN: Type inference failed for: r3v6, types: [T, com.box.android.domain.utils.result.Result] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00c8 -> B:19:0x00c9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.collections.CollectionMembershipsInteractor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.box.android.domain.utils.result.Result$Success] */
    @Override // com.box.android.domain.usecases.collections.CollectionMembershipsUseCase
    public Object removeItemFromCollections(ItemId.Remote remote, Iterable<String> iterable, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new Result.Success(Unit.INSTANCE);
        return BuildersKt.withContext(Dispatchers.getIO(), new C16302(iterable, objectRef, this, remote, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.CollectionMembershipsInteractor$removeItemFromCollections$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionMembershipsInteractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.CollectionMembershipsInteractor$removeItemFromCollections$2", f = "CollectionMembershipsInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 2, 2}, l = {66, 76, 77}, m = "invokeSuspend", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-CollectionMembershipsInteractor$removeItemFromCollections$2$1", "it", "$i$a$-let-CollectionMembershipsInteractor$removeItemFromCollections$2$2"}, s = {"L$0", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "I$0"}, v = 1)
    static final class C16302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ Iterable<String> $collectionIds;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ Ref.ObjectRef<Result<Unit, DomainError>> $result;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ CollectionMembershipsInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16302(Iterable<String> iterable, Ref.ObjectRef<Result<Unit, DomainError>> objectRef, CollectionMembershipsInteractor collectionMembershipsInteractor, ItemId.Remote remote, Continuation<? super C16302> continuation) {
            super(2, continuation);
            this.$collectionIds = iterable;
            this.$result = objectRef;
            this.this$0 = collectionMembershipsInteractor;
            this.$remoteId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16302(this.$collectionIds, this.$result, this.this$0, this.$remoteId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C16302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0088  */
        /* JADX WARN: Code duplicated, block: B:18:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:21:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:22:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:25:0x00de  */
        /* JADX WARN: Type inference failed for: r3v6, types: [T, com.box.android.domain.utils.result.Result] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00c8 -> B:19:0x00c9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.collections.CollectionMembershipsInteractor.C16302.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object fetchChangedBoxItem(ItemId.Remote remote, Continuation<? super BoxItem> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[remote.getType().ordinal()];
        if (i == 1) {
            IBaseModelControllerService iBaseModelControllerService = this.baseModelControllerService;
            BoxRequestsFile.GetFileInfo infoRequest = this.boxExtendedApiFile.getInfoRequest(remote.getBoxId());
            Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
            return ExtensionsKt.perform(iBaseModelControllerService, infoRequest, continuation);
        }
        if (i == 2) {
            IBaseModelControllerService iBaseModelControllerService2 = this.baseModelControllerService;
            BoxRequestsFolder.GetFolderInfo infoRequest2 = this.boxExtendedApiFolder.getInfoRequest(remote.getBoxId());
            Intrinsics.checkNotNullExpressionValue(infoRequest2, "getInfoRequest(...)");
            return ExtensionsKt.perform(iBaseModelControllerService2, infoRequest2, continuation);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        IBaseModelControllerService iBaseModelControllerService3 = this.baseModelControllerService;
        BoxRequestsBookmark.GetBookmarkInfo infoRequest3 = this.boxExtendedApiWeblink.getInfoRequest(remote.getBoxId());
        Intrinsics.checkNotNullExpressionValue(infoRequest3, "getInfoRequest(...)");
        return ExtensionsKt.perform(iBaseModelControllerService3, infoRequest3, continuation);
    }
}
