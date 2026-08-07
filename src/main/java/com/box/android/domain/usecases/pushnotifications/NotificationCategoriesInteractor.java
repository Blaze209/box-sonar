package com.box.android.domain.usecases.pushnotifications;

import androidx.core.app.NotificationCompat;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.domain.services.IPushNotificationSettingsService;
import com.box.android.domain.utils.result.Result;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NotificationCategoriesInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0096@¢\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesInteractor;", "Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;", NotificationCompat.CATEGORY_SERVICE, "Lcom/box/android/domain/services/IPushNotificationSettingsService;", "<init>", "(Lcom/box/android/domain/services/IPushNotificationSettingsService;)V", "notificationCategories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "fetchNotificationCategoriesFromRemote", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationCategories", "updates", "", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationCategoriesInteractor implements NotificationCategoriesUseCase {
    private final IPushNotificationSettingsService service;

    @Inject
    public NotificationCategoriesInteractor(IPushNotificationSettingsService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    @Override // com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase
    public Flow<NotificationCategoriesModel> notificationCategories() {
        return this.service.categories();
    }

    @Override // com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase
    public Object fetchNotificationCategoriesFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.service.fetchCategoriesFromRemote(continuation);
    }

    @Override // com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase
    public Object updateNotificationCategories(Map<NotificationCategory, Boolean> map, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.service.updateCategories(map, continuation);
    }
}
