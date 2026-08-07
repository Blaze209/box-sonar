package com.box.android.domain.usecases.collections;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ListCollectionsUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0004\u0012\u00020\u00070\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦B¢\u0006\u0002\u0010\u000bJ\\\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0004\u0012\u00020\u00070\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/collections/ListCollectionsUseCase;", "", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "types", "", "Lcom/box/android/domain/models/CollectionType;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listCollections", "collectionTypes", "pageSize", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;ILjava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ListCollectionsUseCase {
    Object invoke(List<? extends CollectionType> list, Continuation<? super Result<? extends LiveData<PagedList<CollectionModel>>, ? extends DomainError>> continuation);

    Object listCollections(List<? extends CollectionType> list, int i, Comparator<CollectionModel> comparator, Continuation<? super Result<? extends LiveData<PagedList<CollectionModel>>, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: ListCollectionsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object listCollections$default(ListCollectionsUseCase listCollectionsUseCase, List list, int i, Comparator comparator, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listCollections");
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            comparator = null;
        }
        return listCollectionsUseCase.listCollections(list, i, comparator, continuation);
    }
}
