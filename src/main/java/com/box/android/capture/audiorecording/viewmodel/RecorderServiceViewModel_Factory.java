package com.box.android.capture.audiorecording.viewmodel;

import com.box.android.capture.audiorecording.IRecordingFileManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecorderServiceViewModel_Factory implements Factory<RecorderServiceViewModel> {
    private final Provider<IRecordingFileManager> recordingFileManagerProvider;

    private RecorderServiceViewModel_Factory(Provider<IRecordingFileManager> provider) {
        this.recordingFileManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecorderServiceViewModel get() {
        return newInstance(this.recordingFileManagerProvider.get());
    }

    public static RecorderServiceViewModel_Factory create(Provider<IRecordingFileManager> provider) {
        return new RecorderServiceViewModel_Factory(provider);
    }

    public static RecorderServiceViewModel newInstance(IRecordingFileManager iRecordingFileManager) {
        return new RecorderServiceViewModel(iRecordingFileManager);
    }
}
