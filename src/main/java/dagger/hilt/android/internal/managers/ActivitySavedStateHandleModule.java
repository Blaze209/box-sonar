package dagger.hilt.android.internal.managers;

import androidx.lifecycle.SavedStateHandle;
import dagger.Module;
import dagger.Provides;

/* JADX INFO: loaded from: classes3.dex */
@Module
abstract class ActivitySavedStateHandleModule {
    ActivitySavedStateHandleModule() {
    }

    @Provides
    static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        return savedStateHandleHolder.getSavedStateHandle();
    }
}
