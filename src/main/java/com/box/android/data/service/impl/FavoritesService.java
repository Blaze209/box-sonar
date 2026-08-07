package com.box.android.data.service.impl;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: FavoritesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 92\u00020\u0001:\u000289B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u001d\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u001d\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u0015H\u0096@¢\u0006\u0002\u0010!JW\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%21\u0010&\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0+\u0012\u0006\u0012\u0004\u0018\u00010,0'H\u0082@¢\u0006\u0002\u0010-JJ\u0010.\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\u001d\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00122\u0006\u00100\u001a\u0002H#2\u001c\u0010&\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0+\u0012\u0006\u0012\u0004\u0018\u00010,01H\u0082@¢\u0006\u0002\u00102J \u00103\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0018\u00105\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u0015H\u0082@¢\u0006\u0002\u0010!J \u00107\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0082@¢\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006:"}, d2 = {"Lcom/box/android/data/service/impl/FavoritesService;", "Lcom/box/android/domain/services/IFavoritesService;", "collectionsService", "Lcom/box/android/domain/services/ICollectionsService;", "getFavoritesCollectionIdUseCase", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pendingStatesFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/data/service/impl/FavoritesService$PendingFavoriteState;", "favoritesCollectionId", "", "favoriteItemIdsResultFlowFromService", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "favoriteItemIdsResultFlow", "getFavoriteItemIdsResultFlow", "()Lkotlinx/coroutines/flow/Flow;", "addToFavorites", "", "itemId", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "refreshFromRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withPendingState", "R", "shouldBeFavorite", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "operationUuid", "Lkotlin/coroutines/Continuation;", "", "(Lcom/box/android/domain/models/ItemId$Remote;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withDebouncing", "Lcom/box/android/domain/models/ItemId;", "debouncedResult", "Lkotlin/Function1;", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPendingState", "isFavorite", "clearPendingState", "getFavoritesCollectionId", "getCurrentFavoriteIdsFromService", "PendingFavoriteState", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FavoritesService implements IFavoritesService {
    private static final long CACHE_UPDATE_DELAY;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEBOUNCE_DELAY;
    private static final int PAGE_SIZE = 50;
    private final ICollectionsService collectionsService;
    private final Flow<Result<Set<ItemId.Remote>, DomainError>> favoriteItemIdsResultFlow;
    private final Flow<Result<Set<ItemId.Remote>, DomainError>> favoriteItemIdsResultFlowFromService;
    private String favoritesCollectionId;
    private final GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase;
    private final MutableStateFlow<Map<ItemId.Remote, PendingFavoriteState>> pendingStatesFlow;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$getFavoritesCollectionId$1, reason: invalid class name */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService", f = "FavoritesService.kt", i = {}, l = {Token.LOCAL_BLOCK}, m = "getFavoritesCollectionId", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FavoritesService.this.getFavoritesCollectionId(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$refreshFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService", f = "FavoritesService.kt", i = {1, 1, 1, 1}, l = {98, 99}, m = "refreshFromRemote", n = {"$this$flatMap$iv", BoxItemJob.COLLECTION_ID, "$i$f$flatMap", "$i$a$-flatMap-FavoritesService$refreshFromRemote$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C14241 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14241(Continuation<? super C14241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FavoritesService.this.refreshFromRemote(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$withDebouncing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService", f = "FavoritesService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {128, 130}, m = "withDebouncing", n = {"itemId", "operationUuid", "debouncedResult", "block", "itemId", "operationUuid", "debouncedResult", "block"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14261<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14261(Continuation<? super C14261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FavoritesService.this.withDebouncing(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$withPendingState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService", f = "FavoritesService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {112, 115}, m = "withPendingState", n = {"itemId", "block", "operationUuid", "shouldBeFavorite", "itemId", "block", "operationUuid", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "shouldBeFavorite"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 1)
    static final class C14271<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14271(Continuation<? super C14271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FavoritesService.this.withPendingState(null, false, null, this);
        }
    }

    @Inject
    public FavoritesService(ICollectionsService collectionsService, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(collectionsService, "collectionsService");
        Intrinsics.checkNotNullParameter(getFavoritesCollectionIdUseCase, "getFavoritesCollectionIdUseCase");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.collectionsService = collectionsService;
        this.getFavoritesCollectionIdUseCase = getFavoritesCollectionIdUseCase;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(ioDispatcher));
        this.scope = CoroutineScope;
        MutableStateFlow<Map<ItemId.Remote, PendingFavoriteState>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.pendingStatesFlow = MutableStateFlow;
        SharedFlow sharedFlowShareIn = FlowKt.shareIn(FlowKt.flow(new FavoritesService$favoriteItemIdsResultFlowFromService$1(this, null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), 1);
        this.favoriteItemIdsResultFlowFromService = sharedFlowShareIn;
        this.favoriteItemIdsResultFlow = FlowKt.flowCombine(sharedFlowShareIn, MutableStateFlow, new FavoritesService$favoriteItemIdsResultFlow$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/service/impl/FavoritesService$PendingFavoriteState;", "", "isFavorite", "", "operationUuid", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getOperationUuid", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class PendingFavoriteState {
        private final boolean isFavorite;
        private final String operationUuid;

        public static /* synthetic */ PendingFavoriteState copy$default(PendingFavoriteState pendingFavoriteState, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pendingFavoriteState.isFavorite;
            }
            if ((i & 2) != 0) {
                str = pendingFavoriteState.operationUuid;
            }
            return pendingFavoriteState.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsFavorite() {
            return this.isFavorite;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOperationUuid() {
            return this.operationUuid;
        }

        public final PendingFavoriteState copy(boolean isFavorite, String operationUuid) {
            Intrinsics.checkNotNullParameter(operationUuid, "operationUuid");
            return new PendingFavoriteState(isFavorite, operationUuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingFavoriteState)) {
                return false;
            }
            PendingFavoriteState pendingFavoriteState = (PendingFavoriteState) other;
            return this.isFavorite == pendingFavoriteState.isFavorite && Intrinsics.areEqual(this.operationUuid, pendingFavoriteState.operationUuid);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isFavorite) * 31) + this.operationUuid.hashCode();
        }

        public String toString() {
            return "PendingFavoriteState(isFavorite=" + this.isFavorite + ", operationUuid=" + this.operationUuid + ")";
        }

        public PendingFavoriteState(boolean z, String operationUuid) {
            Intrinsics.checkNotNullParameter(operationUuid, "operationUuid");
            this.isFavorite = z;
            this.operationUuid = operationUuid;
        }

        public final String getOperationUuid() {
            return this.operationUuid;
        }

        public final boolean isFavorite() {
            return this.isFavorite;
        }
    }

    @Override // com.box.android.domain.services.IFavoritesService
    public Flow<Result<Set<ItemId.Remote>, DomainError>> getFavoriteItemIdsResultFlow() {
        return this.favoriteItemIdsResultFlow;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$addToFavorites$2, reason: invalid class name */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "operationUuid", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$addToFavorites$2", f = "FavoritesService.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"operationUuid"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<String, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId.Remote $itemId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId.Remote remote, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = FavoritesService.this.new AnonymousClass2(this.$itemId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(str, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$addToFavorites$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FavoritesService.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$addToFavorites$2$1", f = "FavoritesService.kt", i = {1, 2, 2, 2, 2, 2}, l = {81, 83, 84}, m = "invokeSuspend", n = {"favoritesIds", "favoritesIds", "$this$flatMap$iv", BoxItemJob.COLLECTION_ID, "$i$f$flatMap", "$i$a$-flatMap-FavoritesService$addToFavorites$2$1$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
            final /* synthetic */ ItemId.Remote $itemId;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FavoritesService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FavoritesService favoritesService, ItemId.Remote remote, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = favoritesService;
                this.$itemId = remote;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$itemId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
                return invoke2((Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0084  */
            /* JADX WARN: Code duplicated, block: B:31:0x00b4  */
            /* JADX WARN: Code duplicated, block: B:33:0x00b8 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
            
                if (r7 == r0) goto L28;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    Method dump skipped, instruction units count: 215
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FavoritesService.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            Object objWithDebouncing = FavoritesService.this.withDebouncing(this.$itemId, str, new Result.Success(Unit.INSTANCE), new AnonymousClass1(FavoritesService.this, this.$itemId, null), this);
            return objWithDebouncing == coroutine_suspended ? coroutine_suspended : objWithDebouncing;
        }
    }

    @Override // com.box.android.domain.services.IFavoritesService
    public Object addToFavorites(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return withPendingState(remote, true, new AnonymousClass2(remote, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$removeFromFavorites$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "operationUuid", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$removeFromFavorites$2", f = "FavoritesService.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"operationUuid"}, s = {"L$0"}, v = 1)
    static final class C14252 extends SuspendLambda implements Function2<String, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId.Remote $itemId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14252(ItemId.Remote remote, Continuation<? super C14252> continuation) {
            super(2, continuation);
            this.$itemId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14252 c14252 = FavoritesService.this.new C14252(this.$itemId, continuation);
            c14252.L$0 = obj;
            return c14252;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(str, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C14252) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.FavoritesService$removeFromFavorites$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FavoritesService.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$removeFromFavorites$2$1", f = "FavoritesService.kt", i = {1, 2, 2, 2, 2, 2}, l = {91, 93, 94}, m = "invokeSuspend", n = {"favoritesIds", "favoritesIds", "$this$flatMap$iv", BoxItemJob.COLLECTION_ID, "$i$f$flatMap", "$i$a$-flatMap-FavoritesService$removeFromFavorites$2$1$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
            final /* synthetic */ ItemId.Remote $itemId;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FavoritesService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FavoritesService favoritesService, ItemId.Remote remote, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = favoritesService;
                this.$itemId = remote;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$itemId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
                return invoke2((Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0084  */
            /* JADX WARN: Code duplicated, block: B:31:0x00b4  */
            /* JADX WARN: Code duplicated, block: B:33:0x00b8 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
            
                if (r7 == r0) goto L28;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    Method dump skipped, instruction units count: 215
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FavoritesService.C14252.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            Object objWithDebouncing = FavoritesService.this.withDebouncing(this.$itemId, str, new Result.Success(Unit.INSTANCE), new AnonymousClass1(FavoritesService.this, this.$itemId, null), this);
            return objWithDebouncing == coroutine_suspended ? coroutine_suspended : objWithDebouncing;
        }
    }

    @Override // com.box.android.domain.services.IFavoritesService
    public Object removeFromFavorites(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return withPendingState(remote, false, new C14252(remote, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0087  */
    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r6 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IFavoritesService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object refreshFromRemote(kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.box.android.data.service.impl.FavoritesService.C14241
            if (r0 == 0) goto L14
            r0 = r6
            com.box.android.data.service.impl.FavoritesService$refreshFromRemote$1 r0 = (com.box.android.data.service.impl.FavoritesService.C14241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.box.android.data.service.impl.FavoritesService$refreshFromRemote$1 r0 = new com.box.android.data.service.impl.FavoritesService$refreshFromRemote$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7c
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L45:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r4
            java.lang.Object r6 = r5.getFavoritesCollectionId(r0)
            if (r6 != r1) goto L51
            goto L7b
        L51:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            boolean r2 = r6 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L7f
            r2 = r6
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            com.box.android.domain.services.ICollectionsService r5 = r5.collectionsService
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r6 = r5.fetchCollectionItemsFromRemote(r2, r0)
            if (r6 != r1) goto L7c
        L7b:
            return r1
        L7c:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            goto L83
        L7f:
            boolean r5 = r6 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto La7
        L83:
            boolean r5 = r6 instanceof com.box.android.domain.utils.result.Result.Success
            if (r5 == 0) goto L9c
            com.box.android.domain.utils.result.Result$Success r6 = (com.box.android.domain.utils.result.Result.Success) r6
            java.lang.Object r5 = r6.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            com.box.android.domain.utils.result.Result$Success r6 = new com.box.android.domain.utils.result.Result$Success
            r6.<init>(r5)
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            return r6
        L9c:
            boolean r5 = r6 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto La1
            return r6
        La1:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        La7:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FavoritesService.refreshFromRemote(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> Object withPendingState(ItemId.Remote remote, boolean z, Function2<? super String, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        C14271 c14271;
        Object objInvoke;
        boolean z2;
        String str;
        Function2<? super String, ? super Continuation<? super R>, ? extends Object> function3;
        ItemId.Remote remote2;
        Object obj;
        if (continuation instanceof C14271) {
            c14271 = (C14271) continuation;
            if ((c14271.label & Integer.MIN_VALUE) != 0) {
                c14271.label -= Integer.MIN_VALUE;
            } else {
                c14271 = new C14271(continuation);
            }
        } else {
            c14271 = new C14271(continuation);
        }
        Object obj2 = c14271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            setPendingState(remote, z, string);
            c14271.L$0 = remote;
            c14271.L$1 = SpillingKt.nullOutSpilledVariable(function2);
            c14271.L$2 = string;
            c14271.Z$0 = z;
            c14271.label = 1;
            objInvoke = function2.invoke(string, c14271);
            if (objInvoke != coroutine_suspended) {
                z2 = z;
                str = string;
                function3 = function2;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            boolean z3 = c14271.Z$0;
            String str2 = (String) c14271.L$2;
            Function2<? super String, ? super Continuation<? super R>, ? extends Object> function4 = (Function2) c14271.L$1;
            ItemId.Remote remote3 = (ItemId.Remote) c14271.L$0;
            ResultKt.throwOnFailure(obj2);
            str = str2;
            remote = remote3;
            objInvoke = obj2;
            function3 = function4;
            z2 = z3;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z4 = c14271.Z$0;
            obj = c14271.L$3;
            str = (String) c14271.L$2;
            remote2 = (ItemId.Remote) c14271.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        clearPendingState(remote2, str);
        return obj;
        long j = CACHE_UPDATE_DELAY;
        c14271.L$0 = remote;
        c14271.L$1 = SpillingKt.nullOutSpilledVariable(function3);
        c14271.L$2 = str;
        c14271.L$3 = objInvoke;
        c14271.Z$0 = z2;
        c14271.label = 2;
        if (DelayKt.m16309delayVtjQ1oo(j, c14271) != coroutine_suspended) {
            remote2 = remote;
            obj = objInvoke;
            clearPendingState(remote2, str);
            return obj;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> Object withDebouncing(ItemId itemId, String str, R r, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        C14261 c14261;
        if (continuation instanceof C14261) {
            c14261 = (C14261) continuation;
            if ((c14261.label & Integer.MIN_VALUE) != 0) {
                c14261.label -= Integer.MIN_VALUE;
            } else {
                c14261 = new C14261(continuation);
            }
        } else {
            c14261 = new C14261(continuation);
        }
        Object obj = c14261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14261.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = DEBOUNCE_DELAY;
            c14261.L$0 = itemId;
            c14261.L$1 = str;
            c14261.L$2 = r;
            c14261.L$3 = function1;
            c14261.label = 1;
            if (DelayKt.m16309delayVtjQ1oo(j, c14261) != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c14261.L$2;
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        function1 = (Function1) c14261.L$3;
        r = (R) c14261.L$2;
        str = (String) c14261.L$1;
        itemId = (ItemId) c14261.L$0;
        ResultKt.throwOnFailure(obj);
        PendingFavoriteState pendingFavoriteState = this.pendingStatesFlow.getValue().get(itemId);
        if (!Intrinsics.areEqual(pendingFavoriteState != null ? pendingFavoriteState.getOperationUuid() : null, str)) {
            return r;
        }
        c14261.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        c14261.L$1 = SpillingKt.nullOutSpilledVariable(str);
        c14261.L$2 = SpillingKt.nullOutSpilledVariable(r);
        c14261.L$3 = SpillingKt.nullOutSpilledVariable(function1);
        c14261.label = 2;
        Object objInvoke = function1.invoke(c14261);
        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
    }

    private final void setPendingState(ItemId.Remote itemId, boolean isFavorite, String operationUuid) {
        Map<ItemId.Remote, PendingFavoriteState> value;
        MutableStateFlow<Map<ItemId.Remote, PendingFavoriteState>> mutableStateFlow = this.pendingStatesFlow;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, TuplesKt.to(itemId, new PendingFavoriteState(isFavorite, operationUuid)))));
    }

    private final void clearPendingState(ItemId.Remote itemId, String operationUuid) {
        Map<ItemId.Remote, PendingFavoriteState> value;
        Map<ItemId.Remote, PendingFavoriteState> mapMinus;
        MutableStateFlow<Map<ItemId.Remote, PendingFavoriteState>> mutableStateFlow = this.pendingStatesFlow;
        do {
            value = mutableStateFlow.getValue();
            mapMinus = value;
            PendingFavoriteState pendingFavoriteState = mapMinus.get(itemId);
            if (Intrinsics.areEqual(pendingFavoriteState != null ? pendingFavoriteState.getOperationUuid() : null, operationUuid)) {
                mapMinus = MapsKt.minus(mapMinus, itemId);
            }
        } while (!mutableStateFlow.compareAndSet(value, mapMinus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFavoritesCollectionId(Continuation<? super Result<String, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Success resultSuccess;
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
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            String str = this.favoritesCollectionId;
            if (str != null && (resultSuccess = com.box.android.domain.utils.result.ResultKt.toResultSuccess(str)) != null) {
                return resultSuccess;
            }
            GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase = this.getFavoritesCollectionIdUseCase;
            anonymousClass1.label = 1;
            objInvoke = getFavoritesCollectionIdUseCase.invoke(anonymousClass1);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        Result result = (Result) objInvoke;
        if (result instanceof Result.Success) {
            this.favoritesCollectionId = (String) ((Result.Success) result).getValue();
            return result;
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCurrentFavoriteIdsFromService(Continuation<? super Result<? extends Set<ItemId.Remote>, ? extends DomainError>> continuation) {
        return FlowKt.first(this.favoriteItemIdsResultFlowFromService, continuation);
    }

    /* JADX INFO: compiled from: FavoritesService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/box/android/data/service/impl/FavoritesService$Companion;", "", "<init>", "()V", "PAGE_SIZE", "", "DEBOUNCE_DELAY", "Lkotlin/time/Duration;", "getDEBOUNCE_DELAY-UwyO8pc", "()J", "J", "CACHE_UPDATE_DELAY", "getCACHE_UPDATE_DELAY-UwyO8pc", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDEBOUNCE_DELAY-UwyO8pc, reason: not valid java name */
        public final long m12566getDEBOUNCE_DELAYUwyO8pc() {
            return FavoritesService.DEBOUNCE_DELAY;
        }

        /* JADX INFO: renamed from: getCACHE_UPDATE_DELAY-UwyO8pc, reason: not valid java name */
        public final long m12565getCACHE_UPDATE_DELAYUwyO8pc() {
            return FavoritesService.CACHE_UPDATE_DELAY;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DEBOUNCE_DELAY = DurationKt.toDuration(500, DurationUnit.MILLISECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        CACHE_UPDATE_DELAY = DurationKt.toDuration(500, DurationUnit.MILLISECONDS);
    }
}
