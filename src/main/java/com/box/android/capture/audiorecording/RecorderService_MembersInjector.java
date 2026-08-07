package com.box.android.capture.audiorecording;

import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecorderService_MembersInjector implements MembersInjector<RecorderService> {
    private final Provider<IRecordingFileManager> recordingFileManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private RecorderService_MembersInjector(Provider<IRecordingFileManager> provider, Provider<IUserContextManager> provider2) {
        this.recordingFileManagerProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(RecorderService recorderService) {
        injectRecordingFileManager(recorderService, this.recordingFileManagerProvider.get());
        injectUserContextManager(recorderService, this.userContextManagerProvider.get());
    }

    public static MembersInjector<RecorderService> create(Provider<IRecordingFileManager> provider, Provider<IUserContextManager> provider2) {
        return new RecorderService_MembersInjector(provider, provider2);
    }

    public static void injectRecordingFileManager(RecorderService recorderService, IRecordingFileManager iRecordingFileManager) {
        recorderService.recordingFileManager = iRecordingFileManager;
    }

    public static void injectUserContextManager(RecorderService recorderService, IUserContextManager iUserContextManager) {
        recorderService.userContextManager = iUserContextManager;
    }
}
