package com.box.android.common.utilities;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenericSavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\f\u001a\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/common/utilities/GenericSavedStateViewModelFactory;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "viewModelFactory", "Lcom/box/android/common/utilities/ViewModelAssistedFactoryLegacy;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "<init>", "(Lcom/box/android/common/utilities/ViewModelAssistedFactoryLegacy;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, ExifInterface.GPS_DIRECTION_TRUE, "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GenericSavedStateViewModelFactory<V extends ViewModel> extends AbstractSavedStateViewModelFactory {
    private final ViewModelAssistedFactoryLegacy<V> viewModelFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericSavedStateViewModelFactory(ViewModelAssistedFactoryLegacy<V> viewModelFactory, SavedStateRegistryOwner owner, Bundle bundle) {
        super(owner, bundle);
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.viewModelFactory = viewModelFactory;
    }

    public /* synthetic */ GenericSavedStateViewModelFactory(ViewModelAssistedFactoryLegacy viewModelAssistedFactoryLegacy, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelAssistedFactoryLegacy, savedStateRegistryOwner, (i & 4) != 0 ? null : bundle);
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        T t = (T) this.viewModelFactory.create(handle);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.box.android.common.utilities.GenericSavedStateViewModelFactory.create");
        return t;
    }
}
