package com.box.android.domain.usecases.collections;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;

/* JADX INFO: compiled from: CreateCollectionUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/collections/CreateCollectionUseCase;", "", "createCollection", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "collectionName", "", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CreateCollectionUseCase {
    Result<CollectionModel, DomainError> createCollection(String collectionName, CollectionType collectionType);
}
