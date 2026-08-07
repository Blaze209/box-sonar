package com.box.android.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.tasksrepo.TasksRepo;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.dao.BoxUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.model.BoxUserNotificationCategories;
import com.box.boxandroidlibv2private.requests.BoxRequestGetNotificationCategories;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateUserNotificationCategories;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class NotificationRegistrationCategoriesRepo {
    private final IBaseModelController mBaseMoCo;
    private final BoxApiPrivate mBoxApiPrivate;
    private final IUserContextManager mUserContextManager;
    private final MutableLiveData<BoxResponse<BoxUserNotificationCategories>> statusNotificationCategoriesLiveData = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxUserDeviceTokenSettings>> statusNotificationDeviceSettingsLiveData = new MutableLiveData<>();
    private final String NOTIFICATION_CATEGORIES_LISTENER_NAME = "NotificationCategories";
    private final String NOTIFICATION_DEVICE_SETTINGS_LISTENER_NAME = "NotificationDeviceSettings";

    @Inject
    public NotificationRegistrationCategoriesRepo(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager) {
        this.mBaseMoCo = iBaseModelController;
        this.mBoxApiPrivate = boxApiPrivate;
        this.mUserContextManager = iUserContextManager;
        iUserContextManager.addUserContextListener("NotificationCategories", new IUserContextComponentListener() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.1
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String str) throws IUserContextComponentListener.UserContextComponentCreationException {
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                NotificationRegistrationCategoriesRepo.this.statusNotificationCategoriesLiveData.postValue(null);
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                NotificationRegistrationCategoriesRepo.this.statusNotificationCategoriesLiveData.postValue(null);
            }
        });
        iUserContextManager.addUserContextListener("NotificationDeviceSettings", new IUserContextComponentListener() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.2
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String str) throws IUserContextComponentListener.UserContextComponentCreationException {
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                NotificationRegistrationCategoriesRepo.this.statusNotificationDeviceSettingsLiveData.postValue(null);
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                NotificationRegistrationCategoriesRepo.this.statusNotificationDeviceSettingsLiveData.postValue(null);
            }
        });
    }

    public LiveData<BoxResponse<BoxUserNotificationCategories>> getNotificationRegistrationCategories() {
        return this.statusNotificationCategoriesLiveData;
    }

    BoxAppFutureTask.OnCompletedListener<BoxUserNotificationCategories> getNotificationRegistrationCategoriesCompletedListener() {
        return new BoxAppFutureTask.OnCompletedListener<BoxUserNotificationCategories>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.3
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserNotificationCategories> boxResponse) {
                NotificationRegistrationCategoriesRepo.this.statusNotificationCategoriesLiveData.postValue(boxResponse);
            }
        };
    }

    BoxAppFutureTask.OnCompletedListener<BoxUserNotificationCategories> updateNotificationRegistrationCategoriesCompletedListener() {
        return new BoxAppFutureTask.OnCompletedListener<BoxUserNotificationCategories>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.4
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserNotificationCategories> boxResponse) {
                NotificationRegistrationCategoriesRepo.this.statusNotificationCategoriesLiveData.postValue(boxResponse);
            }
        };
    }

    public void fetchNotificationRegistrationCategoriesFromCache() {
        fetchNotificationRegistrationCategoriesFromCache(this.mBoxApiPrivate.getNotificationCategories());
    }

    public void updateNotificationRegistrationCategories() {
        this.mBaseMoCo.performRemote(this.mBoxApiPrivate.getNotificationCategories(), getNotificationRegistrationCategoriesCompletedListener());
    }

    public void updateNotificationRegistrationCategory(BoxRequestUpdateUserNotificationCategories.NotificationCategories notificationCategories, Boolean bool) {
        this.mBaseMoCo.performRemote(this.mBoxApiPrivate.updateUserNotificationCategories(notificationCategories, bool), updateNotificationRegistrationCategoriesCompletedListener());
    }

    private void fetchNotificationRegistrationCategoriesFromCache(BoxRequestGetNotificationCategories boxRequestGetNotificationCategories) {
        this.mBaseMoCo.performLocal(boxRequestGetNotificationCategories, new BoxAppFutureTask.OnCompletedListener<BoxUserNotificationCategories>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.5
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserNotificationCategories> boxResponse) {
                if (boxResponse != null) {
                    NotificationRegistrationCategoriesRepo.this.postUserNotificationCategoriesResult(boxResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUserNotificationCategoriesResult(BoxResponse<BoxUserNotificationCategories> boxResponse) {
        this.statusNotificationCategoriesLiveData.postValue(boxResponse);
    }

    public LiveData<BoxResponse<BoxUserDeviceTokenSettings>> getNotificationRegistrationDeviceTokenSettings() {
        return this.statusNotificationDeviceSettingsLiveData;
    }

    BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings> updateNotificationRegistrationDeviceTokenSettingsCompletedListener() {
        return new BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.6
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
                NotificationRegistrationCategoriesRepo.this.statusNotificationDeviceSettingsLiveData.postValue(boxResponse);
            }
        };
    }

    public void fetchNotificationRegistrationDeviceTokenSettingsFromCache(String str) {
        fetchNotificationDeviceTokenSettingsFromCache(this.mBoxApiPrivate.getUserDeviceTokenSettings(str));
    }

    public void updateNotificationRegistrationDeviceTokenSettings(String str) {
        fetchNotificationDeviceTokenSettingsFromRemote(this.mBoxApiPrivate.getUserDeviceTokenSettings(str));
    }

    public void updateNotificationRegistrationDeviceTokenSettings(String str, final Boolean bool) {
        this.mBaseMoCo.performLocal(this.mBoxApiPrivate.getUserDeviceTokenSettings(str), new BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.7
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
                if (boxResponse.isSuccess()) {
                    NotificationRegistrationCategoriesRepo.this.mBaseMoCo.performRemote(NotificationRegistrationCategoriesRepo.this.mBoxApiPrivate.updateUserDeviceTokenSettings(((BoxUserDeviceTokenSettings) boxResponse.getResult()).getUserDeviceTokenId(), bool), NotificationRegistrationCategoriesRepo.this.updateNotificationRegistrationDeviceTokenSettingsCompletedListener());
                }
            }
        });
    }

    private void fetchNotificationDeviceTokenSettingsFromRemote(final BoxRequestGetUserDeviceTokenSettings boxRequestGetUserDeviceTokenSettings) {
        this.mBaseMoCo.performRemote(boxRequestGetUserDeviceTokenSettings, new BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.8
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
                if (boxResponse != null) {
                    if (!boxResponse.isSuccess()) {
                        NotificationRegistrationCategoriesRepo.this.fetchNotificationDeviceTokenSettingsFromCache(boxRequestGetUserDeviceTokenSettings, boxResponse.getException());
                        BoxLogUtils.e(TasksRepo.class.getName(), "Remote request to get tasks failed");
                    } else {
                        NotificationRegistrationCategoriesRepo.this.fetchNotificationDeviceTokenSettingsFromCache(boxRequestGetUserDeviceTokenSettings);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchNotificationDeviceTokenSettingsFromCache(BoxRequestGetUserDeviceTokenSettings boxRequestGetUserDeviceTokenSettings) {
        this.mBaseMoCo.performLocal(boxRequestGetUserDeviceTokenSettings, new BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.9
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
                if (boxResponse != null) {
                    NotificationRegistrationCategoriesRepo.this.postResult(boxResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchNotificationDeviceTokenSettingsFromCache(BoxRequestGetUserDeviceTokenSettings boxRequestGetUserDeviceTokenSettings, final Exception exc) {
        this.mBaseMoCo.performLocal(boxRequestGetUserDeviceTokenSettings, new BoxAppFutureTask.OnCompletedListener<BoxUserDeviceTokenSettings>() { // from class: com.box.android.repo.NotificationRegistrationCategoriesRepo.10
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
                if (boxResponse != null) {
                    NotificationRegistrationCategoriesRepo.this.postResultWithErrorInfo(boxResponse, exc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
        this.statusNotificationDeviceSettingsLiveData.postValue(boxResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultWithErrorInfo(BoxResponse<BoxUserDeviceTokenSettings> boxResponse, Exception exc) {
        postResult(new BoxResponse<>((BoxUserDeviceTokenSettings) boxResponse.getResult(), exc, boxResponse.getRequest()));
    }
}
