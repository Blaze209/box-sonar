package com.box.android.domain.usecases.pushnotifications;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RegisterPushDeviceUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\tJ8\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0004\u0012\u00020\u00040\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/pushnotifications/RegisterPushDeviceUseCase;", "", "registerPushDevice", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "deviceToken", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "Lkotlin/Function1;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RegisterPushDeviceUseCase {
    Object registerPushDevice(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    void registerPushDevice(String deviceToken, String language, Function1<? super Result<Unit, ? extends DomainError>, Unit> callback);
}
