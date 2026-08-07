package com.box.android.domain.usecases.collections;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ListCollectionItemsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0004\u0012\u00020\f0\b0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0002J&\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0007JJ\u0010\u0012\u001a4\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t0\u00130\b0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/usecases/collections/ListCollectionItemsInteractor;", "Lcom/box/android/domain/usecases/collections/ListCollectionItemsUseCase;", "collectionsService", "Lcom/box/android/domain/services/ICollectionsService;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", BoxItemJob.COLLECTION_ID, "", "getPagedList", "pageSize", "", "listCollectionItems", "Lcom/box/android/domain/models/DomainError$CachedDomainError;", "fetchCollectionItemsFromRemote", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "areCollectionItemsFetched", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListCollectionItemsInteractor implements ListCollectionItemsUseCase {
    private final ICollectionsService collectionsService;

    @Inject
    public ListCollectionItemsInteractor(ICollectionsService collectionsService) {
        Intrinsics.checkNotNullParameter(collectionsService, "collectionsService");
        this.collectionsService = collectionsService;
    }

    @Override // com.box.android.domain.usecases.collections.ListCollectionItemsUseCase
    public Flow<Result<LiveData<PagedList<ItemModel>>, DomainError>> invoke(String collectionId) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        return ListCollectionItemsUseCase.listCollectionItems$default(this, collectionId, 0, 2, null);
    }

    public final LiveData<PagedList<ItemModel>> getPagedList(int pageSize, String collectionId) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Result.Success successGqlGetCollectionItems = this.collectionsService.gqlGetCollectionItems(collectionId);
        if (successGqlGetCollectionItems instanceof Result.Success) {
            successGqlGetCollectionItems = new Result.Success(new LivePagedListBuilder((DataSource.Factory) ((Result.Success) successGqlGetCollectionItems).getValue(), pageSize).build());
        } else if (!(successGqlGetCollectionItems instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return (LiveData) ResultKt.getOrNull(successGqlGetCollectionItems);
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.ListCollectionItemsInteractor$listCollectionItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListCollectionItemsInteractor.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*4\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00040\u00070\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError$CachedDomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.ListCollectionItemsInteractor$listCollectionItems$1", f = "ListCollectionItemsInteractor.kt", i = {0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {37, 40, 41, 47}, m = "invokeSuspend", n = {"$this$flow", "pagedList", "it", "$i$a$-let-ListCollectionItemsInteractor$listCollectionItems$1$1", "$this$flow", "pagedList", "$this$flow", "pagedList", "$this$onError$iv", "domainError", "$i$f$onError", "$i$a$-onError-ListCollectionItemsInteractor$listCollectionItems$1$2", "$this$flow", "pagedList", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "dataChanged", "$i$a$-onSuccess-ListCollectionItemsInteractor$listCollectionItems$1$3", "$i$a$-let-ListCollectionItemsInteractor$listCollectionItems$1$3$1"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "I$1", "I$2"}, v = 1)
    static final class C16311 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends LiveData<PagedList<ItemModel>>, ? extends DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ int $pageSize;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16311(int i, String str, Continuation<? super C16311> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16311 c16311 = ListCollectionItemsInteractor.this.new C16311(this.$pageSize, this.$collectionId, continuation);
            c16311.L$0 = obj;
            return c16311;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends LiveData<PagedList<ItemModel>>, ? extends DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16311) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:32:0x00d4 A[PHI: r2 r11
          0x00d4: PHI (r2v6 androidx.lifecycle.LiveData<androidx.paging.PagedList<com.box.android.domain.models.item.ItemModel>>) = 
          (r2v4 androidx.lifecycle.LiveData<androidx.paging.PagedList<com.box.android.domain.models.item.ItemModel>>)
          (r2v8 androidx.lifecycle.LiveData<androidx.paging.PagedList<com.box.android.domain.models.item.ItemModel>>)
         binds: [B:23:0x009d, B:31:0x00d2] A[DONT_GENERATE, DONT_INLINE]
          0x00d4: PHI (r11v8 com.box.android.domain.utils.result.Result) = (r11v7 com.box.android.domain.utils.result.Result), (r11v10 com.box.android.domain.utils.result.Result) binds: [B:23:0x009d, B:31:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:36:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:37:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:40:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:42:0x00f9 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:46:0x0125  */
        /* JADX WARN: Code duplicated, block: B:50:0x012c  */
        /* JADX WARN: Code duplicated, block: B:52:0x0132  */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0122, code lost:
        
            if (r0.emit(r5, r10) == r1) goto L45;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.collections.ListCollectionItemsInteractor.C16311.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.usecases.collections.ListCollectionItemsUseCase
    public Flow<Result<LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>> listCollectionItems(String collectionId, int pageSize) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        return FlowKt.flow(new C16311(pageSize, collectionId, null));
    }

    public final Object fetchCollectionItemsFromRemote(String str, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return this.collectionsService.fetchCollectionItemsFromRemote(str, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.ListCollectionItemsInteractor$areCollectionItemsFetched$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListCollectionItemsInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.ListCollectionItemsInteractor$areCollectionItemsFetched$1", f = "ListCollectionItemsInteractor.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ListCollectionItemsInteractor.this.new AnonymousClass1(this.$collectionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
                return obj;
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAreCollectionItemsFetched = ListCollectionItemsInteractor.this.collectionsService.areCollectionItemsFetched(this.$collectionId, this);
            return objAreCollectionItemsFetched == coroutine_suspended ? coroutine_suspended : objAreCollectionItemsFetched;
        }
    }

    public final boolean areCollectionItemsFetched(String collectionId) {
        return ((Boolean) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(collectionId, null))).booleanValue();
    }
}
