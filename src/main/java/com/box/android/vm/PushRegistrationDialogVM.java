package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.box.android.repo.NotificationRegistrationCategoriesRepo;
import com.box.android.utilities.ISystemInfo;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateUserNotificationCategories;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class PushRegistrationDialogVM extends ViewModel {
    private NotificationRegistrationCategoriesRepo mNotificationCategoriesRepo;
    LiveData<RegistrationStatus> mNotificationRegistrationCategoriesLiveData;
    private ISystemInfo mSystemInfo;
    LiveData<RegistrationStatus> mUserDeviceTokenRegistrationStatusLiveData;

    public static class RegistrationStatus {
        private StatusCode status;

        public enum StatusCode {
            SUCCESS,
            ERROR,
            SUCCESS_WITH_OS_NOTIFICATIONS_OFF,
            UNKNOWN
        }

        public StatusCode getStatus() {
            return this.status;
        }

        public void setStatus(StatusCode statusCode) {
            this.status = statusCode;
        }
    }

    @Inject
    public PushRegistrationDialogVM(NotificationRegistrationCategoriesRepo notificationRegistrationCategoriesRepo, ISystemInfo iSystemInfo) {
        this.mNotificationCategoriesRepo = notificationRegistrationCategoriesRepo;
        this.mSystemInfo = iSystemInfo;
        this.mNotificationRegistrationCategoriesLiveData = Transformations.map(notificationRegistrationCategoriesRepo.getNotificationRegistrationCategories(), new Function1() { // from class: com.box.android.vm.PushRegistrationDialogVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$new$0((BoxResponse) obj);
            }
        });
        this.mUserDeviceTokenRegistrationStatusLiveData = Transformations.map(this.mNotificationCategoriesRepo.getNotificationRegistrationDeviceTokenSettings(), new Function1() { // from class: com.box.android.vm.PushRegistrationDialogVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PushRegistrationDialogVM.lambda$new$1((BoxResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RegistrationStatus lambda$new$0(BoxResponse boxResponse) {
        RegistrationStatus registrationStatus = new RegistrationStatus();
        if (boxResponse == null) {
            registrationStatus.setStatus(RegistrationStatus.StatusCode.UNKNOWN);
            return registrationStatus;
        }
        if (boxResponse.isSuccess()) {
            if (this.mSystemInfo.isAppNotificationsEnabled()) {
                registrationStatus.setStatus(RegistrationStatus.StatusCode.SUCCESS);
                return registrationStatus;
            }
            registrationStatus.setStatus(RegistrationStatus.StatusCode.SUCCESS_WITH_OS_NOTIFICATIONS_OFF);
            return registrationStatus;
        }
        registrationStatus.setStatus(RegistrationStatus.StatusCode.ERROR);
        return registrationStatus;
    }

    static /* synthetic */ RegistrationStatus lambda$new$1(BoxResponse boxResponse) {
        RegistrationStatus registrationStatus = new RegistrationStatus();
        if (boxResponse == null) {
            registrationStatus.setStatus(RegistrationStatus.StatusCode.UNKNOWN);
            return registrationStatus;
        }
        if (boxResponse.isSuccess()) {
            registrationStatus.setStatus(RegistrationStatus.StatusCode.SUCCESS);
            return registrationStatus;
        }
        registrationStatus.setStatus(RegistrationStatus.StatusCode.ERROR);
        return registrationStatus;
    }

    public LiveData<RegistrationStatus> getBoxUserNotificationCategoriesStatus() {
        return this.mNotificationRegistrationCategoriesLiveData;
    }

    public LiveData<RegistrationStatus> getBoxUserDeviceTokenSettingsStatus() {
        return this.mUserDeviceTokenRegistrationStatusLiveData;
    }

    public void updateNotificationAllowCollab(Boolean bool) {
        this.mNotificationCategoriesRepo.updateNotificationRegistrationCategory(BoxRequestUpdateUserNotificationCategories.NotificationCategories.CATEGORY_SHARING, bool);
    }

    public void updateNotificationAllowComments(Boolean bool) {
        this.mNotificationCategoriesRepo.updateNotificationRegistrationCategory(BoxRequestUpdateUserNotificationCategories.NotificationCategories.CATEGORY_MENTIONS, bool);
    }

    public void updateNotificationAllowTasks(Boolean bool) {
        this.mNotificationCategoriesRepo.updateNotificationRegistrationCategory(BoxRequestUpdateUserNotificationCategories.NotificationCategories.CATEGORY_TASKS, bool);
    }

    public void updateNotificationAllowUpdates(Boolean bool) {
        this.mNotificationCategoriesRepo.updateNotificationRegistrationCategory(BoxRequestUpdateUserNotificationCategories.NotificationCategories.CATEGORY_RELEVANT_UPDATES, bool);
    }

    public void updateNotificationRegistrationDeviceTokenSettings(String str, Boolean bool) {
        this.mNotificationCategoriesRepo.updateNotificationRegistrationDeviceTokenSettings(str, bool);
    }
}
