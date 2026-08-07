package com.box.android.domain.usecases.pushnotifications;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.domain.utils.result.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NotificationCategoriesUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H¦@¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;", "", "notificationCategories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "fetchNotificationCategoriesFromRemote", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationCategories", "updates", "", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationCategoriesUseCase {
    Object fetchNotificationCategoriesFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Flow<NotificationCategoriesModel> notificationCategories();

    Object updateNotificationCategories(Map<NotificationCategory, Boolean> map, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
