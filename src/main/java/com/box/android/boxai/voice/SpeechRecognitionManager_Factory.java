package com.box.android.boxai.voice;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class SpeechRecognitionManager_Factory implements Factory<SpeechRecognitionManager> {
    private final Provider<Context> contextProvider;

    private SpeechRecognitionManager_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SpeechRecognitionManager get() {
        return newInstance(this.contextProvider.get());
    }

    public static SpeechRecognitionManager_Factory create(Provider<Context> provider) {
        return new SpeechRecognitionManager_Factory(provider);
    }

    public static SpeechRecognitionManager newInstance(Context context) {
        return new SpeechRecognitionManager(context);
    }
}
