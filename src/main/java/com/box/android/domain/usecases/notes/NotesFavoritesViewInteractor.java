package com.box.android.domain.usecases.notes;

import androidx.paging.PagedList;
import com.box.android.common.extensions.ListExtensionsKt;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.domain.usecases.browse.ItemsViewUseCase;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import java.util.Set;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NotesFavoritesViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/usecases/notes/NotesFavoritesViewInteractor;", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "collectionsService", "Lcom/box/android/domain/services/ICollectionsService;", "getFavoritesCollectionIdUseCase", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "favoritesService", "Lcom/box/android/domain/services/IFavoritesService;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;Lcom/box/android/domain/services/IFavoritesService;)V", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesFavoritesViewInteractor implements ItemsViewUseCase {
    private static final int PAGE_SIZE = 50;
    private final ICollectionsService collectionsService;
    private final IFavoritesService favoritesService;
    private final GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase;

    @Inject
    public NotesFavoritesViewInteractor(ICollectionsService collectionsService, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, IFavoritesService favoritesService) {
        Intrinsics.checkNotNullParameter(collectionsService, "collectionsService");
        Intrinsics.checkNotNullParameter(getFavoritesCollectionIdUseCase, "getFavoritesCollectionIdUseCase");
        Intrinsics.checkNotNullParameter(favoritesService, "favoritesService");
        this.collectionsService = collectionsService;
        this.getFavoritesCollectionIdUseCase = getFavoritesCollectionIdUseCase;
        this.favoritesService = favoritesService;
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor$fetchItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotesFavoritesViewInteractor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor$fetchItems$1", f = "NotesFavoritesViewInteractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {34, 36, 47}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$getOr$iv", "it", "$i$f$getOr", "$i$a$-getOr-NotesFavoritesViewInteractor$fetchItems$1$dataSourceFactory$2", "$this$flow", "dataSourceFactory", "allFavoriteItemsFlow"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = NotesFavoritesViewInteractor.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00c8, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.combine(r2, r7.this$0.favoritesService.getFavoriteItemIdsResultFlow(), new com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor.AnonymousClass1.C01741(null)).collect(new com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor.AnonymousClass1.AnonymousClass2(), r7) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00fd, code lost:
        
            if (r0.emit(r3, r7) == r1) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 271
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor$fetchItems$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NotesFavoritesViewInteractor.kt */
        @Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00060\u00062\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00040\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "allFavorites", "Landroidx/paging/PagedList;", "kotlin.jvm.PlatformType", "favoriteNoteIdsResult", "", "Lcom/box/android/domain/models/ItemId$Remote;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor$fetchItems$1$1", f = "NotesFavoritesViewInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01741 extends SuspendLambda implements Function3<PagedList<ItemModel>, Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            C01741(Continuation<? super C01741> continuation) {
                super(3, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(PagedList<ItemModel> pagedList, Result<? extends Set<ItemId.Remote>, ? extends DomainError> result, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
                C01741 c01741 = new C01741(continuation);
                c01741.L$0 = pagedList;
                c01741.L$1 = result;
                return c01741.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PagedList<ItemModel> pagedList, Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError> result, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
                return invoke2(pagedList, (Result<? extends Set<ItemId.Remote>, ? extends DomainError>) result, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                PagedList pagedList = (PagedList) this.L$0;
                Result result = (Result) this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (result instanceof Result.Success) {
                    Set set = (Set) ((Result.Success) result).getValue();
                    Intrinsics.checkNotNull(pagedList);
                    return com.box.android.domain.utils.result.ResultKt.toResultSuccess(NotesListUtilsKt.withAllMarkedAsFavorite(ListExtensionsKt.filterBy(NotesListUtilsKt.filterByBoxNote(pagedList), set, new Function1() { // from class: com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor$fetchItems$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ((ItemModel) obj2).getItemId();
                        }
                    })));
                }
                if (result instanceof Result.Error) {
                    return new Result.Error((DomainError) ((Result.Error) result).getValue());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return FlowKt.flow(new AnonymousClass1(null));
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object refreshFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.favoritesService.refreshFromRemote(continuation);
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return FlowKt.first(fetchItems(remote), continuation);
    }
}
