package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.domain.services.IRecentNotesService;
import com.box.android.domain.usecases.browse.ItemsViewUseCase;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NotesRecentsViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/usecases/notes/NotesRecentsViewInteractor;", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "recentNotesService", "Lcom/box/android/domain/services/IRecentNotesService;", "favoritesService", "Lcom/box/android/domain/services/IFavoritesService;", "<init>", "(Lcom/box/android/domain/services/IRecentNotesService;Lcom/box/android/domain/services/IFavoritesService;)V", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesRecentsViewInteractor implements ItemsViewUseCase {
    private final IFavoritesService favoritesService;
    private final IRecentNotesService recentNotesService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$refreshFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotesRecentsViewInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.notes.NotesRecentsViewInteractor", f = "NotesRecentsViewInteractor.kt", i = {0, 1, 1, 1, 1, 1}, l = {35, 36}, m = "refreshFromRemote", n = {"folderId", "folderId", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-NotesRecentsViewInteractor$refreshFromRemote$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C16361 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C16361(Continuation<? super C16361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotesRecentsViewInteractor.this.refreshFromRemote(null, this);
        }
    }

    @Inject
    public NotesRecentsViewInteractor(IRecentNotesService recentNotesService, IFavoritesService favoritesService) {
        Intrinsics.checkNotNullParameter(recentNotesService, "recentNotesService");
        Intrinsics.checkNotNullParameter(favoritesService, "favoritesService");
        this.recentNotesService = recentNotesService;
        this.favoritesService = favoritesService;
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$fetchItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotesRecentsViewInteractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "allRecentsResult", "Lcom/box/android/domain/models/item/RecentFileModel;", "favoriteNoteIdsResult", "", "Lcom/box/android/domain/models/ItemId$Remote;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$fetchItems$1", f = "NotesRecentsViewInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Result<? extends List<? extends RecentFileModel>, ? extends DomainError>, Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Result<? extends List<RecentFileModel>, ? extends DomainError> result, Result<? extends Set<ItemId.Remote>, ? extends DomainError> result2, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = result;
            anonymousClass1.L$1 = result2;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Result<? extends List<? extends RecentFileModel>, ? extends DomainError> result, Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError> result2, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
            return invoke2((Result<? extends List<RecentFileModel>, ? extends DomainError>) result, (Result<? extends Set<ItemId.Remote>, ? extends DomainError>) result2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result result = (Result) this.L$0;
            Result result2 = (Result) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (result instanceof Result.Success) {
                List list = (List) ((Result.Success) result).getValue();
                if (result2 instanceof Result.Success) {
                    return new Result.Success(NotesListUtilsKt.withIdsMarkedAsFavorite(NotesListUtilsKt.filterByBoxNote(list), (Set<ItemId.Remote>) ((Result.Success) result2).getValue()));
                }
                if (result2 instanceof Result.Error) {
                    return new Result.Error((DomainError) ((Result.Error) result2).getValue());
                }
                throw new NoWhenBranchMatchedException();
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return FlowKt.flowCombine(this.recentNotesService.recentNoteItems(), this.favoritesService.getFavoriteItemIdsResultFlow(), new AnonymousClass1(null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object refreshFromRemote(com.box.android.domain.models.ItemId.Remote r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.domain.usecases.notes.NotesRecentsViewInteractor.C16361
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$refreshFromRemote$1 r0 = (com.box.android.domain.usecases.notes.NotesRecentsViewInteractor.C16361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$refreshFromRemote$1 r0 = new com.box.android.domain.usecases.notes.NotesRecentsViewInteractor$refreshFromRemote$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$2
            kotlin.Unit r5 = (kotlin.Unit) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L92
        L3d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L45:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId$Remote r6 = (com.box.android.domain.models.ItemId.Remote) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L61
        L4d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.domain.services.IRecentNotesService r7 = r5.recentNotesService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.fetchRecentNotesFromRemote(r0)
            if (r7 != r1) goto L61
            goto L91
        L61:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L95
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            kotlin.Unit r2 = (kotlin.Unit) r2
            com.box.android.domain.services.IFavoritesService r5 = r5.favoritesService
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$2 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.refreshFromRemote(r0)
            if (r7 != r1) goto L92
        L91:
            return r1
        L92:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            return r7
        L95:
            boolean r5 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L9a
            return r7
        L9a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.notes.NotesRecentsViewInteractor.refreshFromRemote(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return FlowKt.first(fetchItems(remote), continuation);
    }
}
