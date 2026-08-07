package com.box.android.domain.services;

import com.box.android.domain.utils.BoxTypeIdPair;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IBatchOperationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IBatchOperationsService;", "", "deleteTypeIdPairs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/services/BatchOperationStatus;", "itemsToDelete", "", "Lcom/box/android/domain/utils/BoxTypeIdPair;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBatchOperationsService {
    Flow<BatchOperationStatus> deleteTypeIdPairs(List<? extends BoxTypeIdPair> itemsToDelete);
}
