package com.box.android.vm;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PushNotificationSettingsViewModelFactory.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/vm/PushNotificationSettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "notificationCategoriesUseCase", "Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;", "<init>", "(Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushNotificationSettingsViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final NotificationCategoriesUseCase notificationCategoriesUseCase;

    @Inject
    public PushNotificationSettingsViewModelFactory(NotificationCategoriesUseCase notificationCategoriesUseCase) {
        Intrinsics.checkNotNullParameter(notificationCategoriesUseCase, "notificationCategoriesUseCase");
        this.notificationCategoriesUseCase = notificationCategoriesUseCase;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        return (T) super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
        return (T) super.create(kClass, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(PushNotificationSettingsVM.class)) {
            return new PushNotificationSettingsVM(this.notificationCategoriesUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
