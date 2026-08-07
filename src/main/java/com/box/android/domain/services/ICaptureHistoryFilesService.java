package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ICaptureHistoryFilesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "", "getHistoricalCaptures", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/domain/models/DomainError;", "addHistoricalCapture", "", "localItemId", "Lcom/box/android/domain/models/ItemId$Local;", "contentCreatedDate", "Ljava/util/Date;", "(Lcom/box/android/domain/models/ItemId$Local;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastUpdatedDate", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICaptureHistoryFilesService {
    Object addHistoricalCapture(ItemId.Local local, Date date, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Flow<Result<List<ItemId>, DomainError>> getHistoricalCaptures();

    Object updateLastUpdatedDate(ItemId.Local local, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object updateLastUpdatedDate(String str, Continuation<? super Unit> continuation);
}
