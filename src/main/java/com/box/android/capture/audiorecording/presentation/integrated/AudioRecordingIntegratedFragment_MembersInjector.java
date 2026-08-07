package com.box.android.capture.audiorecording.presentation.integrated;

import com.box.android.base.presentation.fragments.BoxFragment_MembersInjector;
import com.box.android.capture.audiorecording.logic.IAudioRecordingHelper;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiUser;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class AudioRecordingIntegratedFragment_MembersInjector implements MembersInjector<AudioRecordingIntegratedFragment> {
    private final Provider<IAudioRecordingHelper> audioRecordingHelperProvider;
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private AudioRecordingIntegratedFragment_MembersInjector(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<IAudioRecordingHelper> provider4) {
        this.mBaseModelControllerProvider = provider;
        this.mBoxApiUserProvider = provider2;
        this.mUserContextManagerProvider = provider3;
        this.audioRecordingHelperProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment) {
        BoxFragment_MembersInjector.injectMBaseModelController(audioRecordingIntegratedFragment, this.mBaseModelControllerProvider.get());
        BoxFragment_MembersInjector.injectMBoxApiUser(audioRecordingIntegratedFragment, this.mBoxApiUserProvider.get());
        BoxFragment_MembersInjector.injectMUserContextManager(audioRecordingIntegratedFragment, this.mUserContextManagerProvider.get());
        injectAudioRecordingHelper(audioRecordingIntegratedFragment, this.audioRecordingHelperProvider.get());
    }

    public static MembersInjector<AudioRecordingIntegratedFragment> create(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<IAudioRecordingHelper> provider4) {
        return new AudioRecordingIntegratedFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectAudioRecordingHelper(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, IAudioRecordingHelper iAudioRecordingHelper) {
        audioRecordingIntegratedFragment.audioRecordingHelper = iAudioRecordingHelper;
    }
}
