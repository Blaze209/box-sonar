package com.box.android.domain.usecases.observability;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MetricsUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "", "uploadMetrics", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMetricsOnLogOut", OAuthActivity.USER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMetricsOnLogOutAllUsers", "getMetricsCountInCache", "", "log", "event", "Lcom/box/android/domain/models/observability/Gen204Event;", "(Lcom/box/android/domain/models/observability/Gen204Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MetricsUseCase {
    Object getMetricsCountInCache(Continuation<? super Result<Integer, ? extends DomainError>> continuation);

    Object log(Gen204Event gen204Event, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object uploadMetrics(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object uploadMetricsOnLogOut(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object uploadMetricsOnLogOutAllUsers(Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
