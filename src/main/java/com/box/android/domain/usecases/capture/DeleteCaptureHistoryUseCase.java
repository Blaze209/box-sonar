package com.box.android.domain.usecases.capture;

import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: DeleteCaptureHistoryUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryUseCase;", "", "deleteCaptureHistoryItems", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "captureHistoryModels", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeleteCaptureHistoryUseCase {
    Object deleteCaptureHistoryItems(Set<CaptureHistoryModel> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
