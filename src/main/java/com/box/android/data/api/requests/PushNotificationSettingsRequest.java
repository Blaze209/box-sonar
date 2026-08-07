package com.box.android.data.api.requests;

import com.box.android.data.api.models.pushnotifications.NotificationCategoriesDTO;
import com.box.android.data.api.models.pushnotifications.PushDeviceDTO;
import com.box.android.data.api.models.pushnotifications.RegisterPushDeviceDTO;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/* JADX INFO: compiled from: PushNotificationSettingsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/PushNotificationSettingsRequest;", "", "getNotificationCategories", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationCategories", "categories", "(Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDevice", "Lcom/box/android/data/api/models/pushnotifications/PushDeviceDTO;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;", "(Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceRegistration", "deviceID", "", "(Ljava/lang/String;Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PushNotificationSettingsRequest {
    @GET("push_devices/{id}")
    Object getDevice(@Path("id") String str, Continuation<? super PushDeviceDTO> continuation);

    @GET("settings/users/notification_categories")
    Object getNotificationCategories(Continuation<? super NotificationCategoriesDTO> continuation);

    @POST("push_devices")
    Object registerDevice(@Body RegisterPushDeviceDTO registerPushDeviceDTO, Continuation<? super PushDeviceDTO> continuation);

    @PUT("push_devices/{id}")
    Object updateDeviceRegistration(@Path("id") String str, @Body RegisterPushDeviceDTO registerPushDeviceDTO, Continuation<? super PushDeviceDTO> continuation);

    @PUT("settings/users/notification_categories")
    Object updateNotificationCategories(@Body NotificationCategoriesDTO notificationCategoriesDTO, Continuation<? super NotificationCategoriesDTO> continuation);
}
