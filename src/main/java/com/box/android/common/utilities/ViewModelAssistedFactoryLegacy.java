package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: GenericSavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/common/utilities/ViewModelAssistedFactoryLegacy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ViewModelAssistedFactoryLegacy<T extends ViewModel> {
    T create(SavedStateHandle handle);
}
