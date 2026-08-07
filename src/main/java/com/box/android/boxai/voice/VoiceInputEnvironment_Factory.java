package com.box.android.boxai.voice;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class VoiceInputEnvironment_Factory implements Factory<VoiceInputEnvironment> {
    private final Provider<ISpeechRecognitionManager> speechRecognitionManagerProvider;

    private VoiceInputEnvironment_Factory(Provider<ISpeechRecognitionManager> provider) {
        this.speechRecognitionManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VoiceInputEnvironment get() {
        return newInstance(this.speechRecognitionManagerProvider.get());
    }

    public static VoiceInputEnvironment_Factory create(Provider<ISpeechRecognitionManager> provider) {
        return new VoiceInputEnvironment_Factory(provider);
    }

    public static VoiceInputEnvironment newInstance(ISpeechRecognitionManager iSpeechRecognitionManager) {
        return new VoiceInputEnvironment(iSpeechRecognitionManager);
    }
}
