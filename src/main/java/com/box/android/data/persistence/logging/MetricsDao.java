package com.box.android.data.persistence.logging;

import com.box.androidsdk.content.auth.OAuthActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MetricsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\t¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/logging/MetricsDao;", "", "insertLog", "", "metricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "(Lcom/box/android/data/persistence/logging/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLogs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCount", "", "deleteMetrics", "metricsEntityList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetricsByUserId", OAuthActivity.USER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetricsByUserIdNotNullOrEmpty", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MetricsDao {
    Object deleteMetrics(List<MetricsEntity> list, Continuation<? super Unit> continuation);

    Object deleteMetricsByUserId(String str, Continuation<? super Unit> continuation);

    Object deleteMetricsByUserIdNotNullOrEmpty(Continuation<? super Unit> continuation);

    Object getAllLogs(Continuation<? super List<MetricsEntity>> continuation);

    Object getCount(Continuation<? super Integer> continuation);

    Object insertLog(MetricsEntity metricsEntity, Continuation<? super Unit> continuation);
}
