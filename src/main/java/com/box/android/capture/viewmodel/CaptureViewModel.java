package com.box.android.capture.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.capture.cpl.CaptureReducer;
import com.box.android.capture.cpl.UninitializedCaptureModeState;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.capture.CaptureMode;
import com.google.android.material.internal.ViewUtils;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureViewModel;", "Landroidx/lifecycle/ViewModel;", "captureUploadFileManager", "Lcom/box/android/capture/CaptureUploadFileManager;", "captureEnvironment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "factory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/capture/CaptureUploadFileManager;Lcom/box/android/capture/cpl/CaptureEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/CaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getInitialCaptureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "getNewFile", "Ljava/io/File;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureViewModel extends ViewModel {
    public static final int $stable = 8;
    private final CaptureUploadFileManager captureUploadFileManager;
    private final Store<CaptureReducer.State, CaptureReducer.Action> store;

    @Inject
    public CaptureViewModel(CaptureUploadFileManager captureUploadFileManager, CaptureEnvironment captureEnvironment, IStoreFactory factory) {
        Intrinsics.checkNotNullParameter(captureUploadFileManager, "captureUploadFileManager");
        Intrinsics.checkNotNullParameter(captureEnvironment, "captureEnvironment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.captureUploadFileManager = captureUploadFileManager;
        this.store = factory.create("CaptureViewModel", new CaptureReducer.State(getInitialCaptureMode(captureEnvironment), null, null, null, false, false, false, UninitializedCaptureModeState.INSTANCE, false, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null), new CaptureReducer(captureEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<CaptureReducer.State, CaptureReducer.Action> getStore() {
        return this.store;
    }

    private final CaptureMode getInitialCaptureMode(CaptureEnvironment captureEnvironment) {
        CaptureMode captureMode = CaptureMode.PHOTO;
        if (captureEnvironment.getAudioCaptureEnvironment().getRecordingFileManager().hasRecordedFile()) {
            return CaptureMode.AUDIO;
        }
        return captureEnvironment.getCapturePreferencesService().getLastUsedMode(captureMode);
    }

    public final File getNewFile() {
        return this.captureUploadFileManager.getNewFile(this.store.getState().getValue().getCaptureMode());
    }
}
