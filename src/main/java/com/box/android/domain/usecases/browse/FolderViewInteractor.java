package com.box.android.domain.usecases.browse;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.ItemSorter;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: FolderViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0012J6\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\nH\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/usecases/browse/FolderViewInteractor;", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "itemSorter", "Lcom/box/android/domain/utils/ItemSorter;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/utils/ItemSorter;)V", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "sortItems", "(Lcom/box/android/domain/utils/result/Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FolderViewInteractor implements ItemsViewUseCase {
    private final IRemoteItemService itemService;
    private final ItemSorter itemSorter;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItemsFromLegacyCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: FolderViewInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderViewInteractor", f = "FolderViewInteractor.kt", i = {0, 0, 1, 1}, l = {28, 28}, m = "fetchItemsFromLegacyCache$suspendImpl", n = {"$this", "folderId", "$this", "folderId"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FolderViewInteractor.fetchItemsFromLegacyCache$suspendImpl(FolderViewInteractor.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderViewInteractor$sortItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FolderViewInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderViewInteractor", f = "FolderViewInteractor.kt", i = {0, 0, 0, 0, 0}, l = {31}, m = "sortItems", n = {"$this$sortItems", "$this$map$iv", AlertFragment.ARG_ITEMS, "$i$f$map", "$i$a$-map-FolderViewInteractor$sortItems$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C16251 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C16251(Continuation<? super C16251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FolderViewInteractor.this.sortItems(null, this);
        }
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return fetchItemsFromLegacyCache$suspendImpl(this, remote, continuation);
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object refreshFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return refreshFromRemote$suspendImpl(this, remote, continuation);
    }

    @Inject
    public FolderViewInteractor(IRemoteItemService itemService, ItemSorter itemSorter) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(itemSorter, "itemSorter");
        this.itemService = itemService;
        this.itemSorter = itemSorter;
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        final Flow<Result<List<ItemModel>, DomainError>> flowItems = this.itemService.items(folderId);
        return (Flow) new Flow<Result<? extends List<? extends ItemModel>, ? extends DomainError>>() { // from class: com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItems$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItems$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ FolderViewInteractor this$0;

                /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItems$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItems$$inlined$map$1$2", f = "FolderViewInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {51, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-FolderViewInteractor$fetchItems$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FolderViewInteractor folderViewInteractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = folderViewInteractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00d3, code lost:
                
                    if (r8.emit(r9, r0) == r1) goto L22;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        Method dump skipped, instruction units count: 217
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.browse.FolderViewInteractor$fetchItems$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flowItems.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    static /* synthetic */ Object refreshFromRemote$suspendImpl(FolderViewInteractor folderViewInteractor, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return folderViewInteractor.itemService.fetchFolderItemsFromRemote(remote, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object fetchItemsFromLegacyCache$suspendImpl(FolderViewInteractor folderViewInteractor, ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        FolderViewInteractor folderViewInteractor2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = folderViewInteractor.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = folderViewInteractor.new AnonymousClass1(continuation);
        }
        Object objFetchItemsFromLegacyCache = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchItemsFromLegacyCache);
            IRemoteItemService iRemoteItemService = folderViewInteractor.itemService;
            String boxId = remote.getBoxId();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(folderViewInteractor);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
            anonymousClass1.L$2 = folderViewInteractor;
            anonymousClass1.label = 1;
            objFetchItemsFromLegacyCache = iRemoteItemService.fetchItemsFromLegacyCache(boxId, anonymousClass1);
            if (objFetchItemsFromLegacyCache != coroutine_suspended) {
                folderViewInteractor2 = folderViewInteractor;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchItemsFromLegacyCache);
            return objFetchItemsFromLegacyCache;
        }
        folderViewInteractor = (FolderViewInteractor) anonymousClass1.L$2;
        remote = (ItemId.Remote) anonymousClass1.L$1;
        folderViewInteractor2 = (FolderViewInteractor) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objFetchItemsFromLegacyCache);
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(folderViewInteractor2);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        Object objSortItems = folderViewInteractor.sortItems((Result) objFetchItemsFromLegacyCache, anonymousClass1);
        return objSortItems == coroutine_suspended ? coroutine_suspended : objSortItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sortItems(Result<? extends List<? extends ItemModel>, ? extends DomainError> result, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        C16251 c16251;
        if (continuation instanceof C16251) {
            c16251 = (C16251) continuation;
            if ((c16251.label & Integer.MIN_VALUE) != 0) {
                c16251.label -= Integer.MIN_VALUE;
            } else {
                c16251 = new C16251(continuation);
            }
        } else {
            c16251 = new C16251(continuation);
        }
        Object objWithContext = c16251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (result instanceof Result.Success) {
                List list = (List) ((Result.Success) result).getValue();
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                FolderViewInteractor$sortItems$2$1 folderViewInteractor$sortItems$2$1 = new FolderViewInteractor$sortItems$2$1(this, list, null);
                c16251.L$0 = SpillingKt.nullOutSpilledVariable(result);
                c16251.L$1 = SpillingKt.nullOutSpilledVariable(result);
                c16251.L$2 = SpillingKt.nullOutSpilledVariable(list);
                c16251.I$0 = 0;
                c16251.I$1 = 0;
                c16251.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, folderViewInteractor$sortItems$2$1, c16251);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (result instanceof Result.Error) {
                    return result;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c16251.I$1;
            int i3 = c16251.I$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        return new Result.Success((List) objWithContext);
    }
}
