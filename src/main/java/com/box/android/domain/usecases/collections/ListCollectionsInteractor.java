package com.box.android.domain.usecases.collections;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.utils.result.Result;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListCollectionsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0004\u0012\u00020\u00130\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096B¢\u0006\u0002\u0010\u0017JX\u0010\u0018\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0004\u0012\u00020\u00130\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010#\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006&"}, d2 = {"Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;", "Lcom/box/android/domain/usecases/collections/ListCollectionsUseCase;", "collectionsService", "Lcom/box/android/domain/services/ICollectionsService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;Lcom/box/android/domain/identity/IUserContextManager;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "types", "", "Lcom/box/android/domain/models/CollectionType;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listCollections", "collectionTypes", "pageSize", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;ILjava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldFetchFromRemote", "", "fetchCollectionsFromRemote", "type", "(Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListCollectionsInteractor implements ListCollectionsUseCase {
    public static final String PREF_KEY_LAST_COLLECTIONS_REFRESH_TS = "last_collections_refresh_timestamp";
    private final ICollectionsService collectionsService;

    /* JADX INFO: renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.ListCollectionsInteractor$listCollections$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListCollectionsInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.ListCollectionsInteractor", f = "ListCollectionsInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {52}, m = "listCollections", n = {"collectionTypes", "comparator", "$this$map$iv", "dataSourceFactory", "pageListBuilder", "pageSize", "$i$f$map", "$i$a$-map-ListCollectionsInteractor$listCollections$result$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ListCollectionsInteractor.this.listCollections(null, 0, null, this);
        }
    }

    @Inject
    public ListCollectionsInteractor(ICollectionsService collectionsService, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(collectionsService, "collectionsService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.collectionsService = collectionsService;
        this.userContextManager = userContextManager;
        this.sharedPreferences = LazyKt.lazy(new Function0() { // from class: com.box.android.domain.usecases.collections.ListCollectionsInteractor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ListCollectionsInteractor.sharedPreferences_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences sharedPreferences_delegate$lambda$0(ListCollectionsInteractor listCollectionsInteractor) {
        IUserContextComponent userContextComponent = listCollectionsInteractor.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalSharedPreferences");
        return ((ILocalSharedPreferences) userContextComponent).getSharedPreferences(ILocalSharedPreferences.PreferenceName.COLLECTIONS);
    }

    @Override // com.box.android.domain.usecases.collections.ListCollectionsUseCase
    public Object invoke(List<? extends CollectionType> list, Continuation<? super Result<? extends LiveData<PagedList<CollectionModel>>, ? extends DomainError>> continuation) {
        return ListCollectionsUseCase.listCollections$default(this, list, 0, null, continuation, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.collections.ListCollectionsUseCase
    public Object listCollections(List<? extends CollectionType> list, int i, Comparator<CollectionModel> comparator, Continuation<? super Result<? extends LiveData<PagedList<CollectionModel>>, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        LiveData liveDataBuild;
        LiveData liveData;
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
        Object objFetchCollectionsFromRemote = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFetchCollectionsFromRemote);
            Result<DataSource.Factory<Integer, CollectionModel>, DomainError> collections = this.collectionsService.getCollections(list, comparator);
            if (collections instanceof Result.Success) {
                DataSource.Factory factory = (DataSource.Factory) ((Result.Success) collections).getValue();
                liveDataBuild = new LivePagedListBuilder(factory, i).build();
                Intrinsics.checkNotNullExpressionValue(liveDataBuild, "build(...)");
                if (shouldFetchFromRemote()) {
                    CollectionType collectionType = CollectionType.PERSONAL;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(comparator);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(collections);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(factory);
                    anonymousClass1.L$4 = liveDataBuild;
                    anonymousClass1.I$0 = i;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 1;
                    objFetchCollectionsFromRemote = fetchCollectionsFromRemote(collectionType, anonymousClass1);
                    if (objFetchCollectionsFromRemote == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveData = liveDataBuild;
                }
                return new Result.Success(liveDataBuild);
            }
            if (collections instanceof Result.Error) {
                return collections;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = anonymousClass1.I$2;
        int i4 = anonymousClass1.I$1;
        int i5 = anonymousClass1.I$0;
        liveData = (LiveData) anonymousClass1.L$4;
        ResultKt.throwOnFailure(objFetchCollectionsFromRemote);
        Result result = (Result) objFetchCollectionsFromRemote;
        boolean z = result instanceof Result.Success;
        if (z) {
            if (z) {
                ((Boolean) ((Result.Success) result).getValue()).booleanValue();
                getSharedPreferences().edit().putLong(PREF_KEY_LAST_COLLECTIONS_REFRESH_TS, System.currentTimeMillis()).apply();
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            liveDataBuild = liveData;
            return new Result.Success(liveDataBuild);
        }
        if (result instanceof Result.Error) {
            return new Result.Error(new DomainError.CachedDomainError(liveData, (DomainError) ((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean shouldFetchFromRemote() {
        return getSharedPreferences().getLong(PREF_KEY_LAST_COLLECTIONS_REFRESH_TS, 0L) < System.currentTimeMillis() - ((long) 90000);
    }

    public final Object fetchCollectionsFromRemote(CollectionType collectionType, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return this.collectionsService.fetchCollectionsFromRemote(collectionType, continuation);
    }
}
