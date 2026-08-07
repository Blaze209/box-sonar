package com.box.android.capture.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.capture.cpl.CaptureSettingsEnvironment;
import com.box.android.capture.cpl.CaptureSettingsReducer;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSettingsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "captureSettingsEnvironment", "Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$State;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureSettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> store;

    @Inject
    public CaptureSettingsViewModel(CaptureSettingsEnvironment captureSettingsEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(captureSettingsEnvironment, "captureSettingsEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.store = storeFactory.create(new CaptureSettingsReducer.State(captureSettingsEnvironment.getLaunchIntoCaptureUseCase().getLaunchIntoCapturePreference(), captureSettingsEnvironment.getCapturePreferencesService().getReviewPhotoAfterCapture(), captureSettingsEnvironment.getCapturePreferencesService().getPhotoQuality(), captureSettingsEnvironment.getCapturePreferencesService().getVideoQuality(), captureSettingsEnvironment.getCapturePreferencesService().getSaveGpsLocation(), false, 32, null), new CaptureSettingsReducer(captureSettingsEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<CaptureSettingsReducer.State, CaptureSettingsReducer.Action> getStore() {
        return this.store;
    }
}
