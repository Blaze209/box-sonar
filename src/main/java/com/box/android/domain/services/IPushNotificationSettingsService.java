package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.domain.models.pushnotifications.PushDeviceModel;
import com.box.android.domain.utils.result.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IPushNotificationSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H¦@¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH¦@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0017\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IPushNotificationSettingsService;", "", "categories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "fetchCategoriesFromRemote", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategories", "updates", "", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDevice", "Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;", "deviceToken", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceRegistration", "deviceModel", "(Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPushNotificationSettingsService {
    Flow<NotificationCategoriesModel> categories();

    Object fetchCategoriesFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object registerDevice(String str, String str2, Continuation<? super Result<PushDeviceModel, ? extends DomainError>> continuation);

    Object updateCategories(Map<NotificationCategory, Boolean> map, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object updateDeviceRegistration(PushDeviceModel pushDeviceModel, Continuation<? super Result<PushDeviceModel, ? extends DomainError>> continuation);
}
