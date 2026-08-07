package com.box.android.boxai.voice;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceInputReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputEnvironment;", "", "speechRecognitionManager", "Lcom/box/android/boxai/voice/ISpeechRecognitionManager;", "<init>", "(Lcom/box/android/boxai/voice/ISpeechRecognitionManager;)V", "getSpeechRecognitionManager", "()Lcom/box/android/boxai/voice/ISpeechRecognitionManager;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VoiceInputEnvironment {
    public static final int $stable = 8;
    private final ISpeechRecognitionManager speechRecognitionManager;

    public static /* synthetic */ VoiceInputEnvironment copy$default(VoiceInputEnvironment voiceInputEnvironment, ISpeechRecognitionManager iSpeechRecognitionManager, int i, Object obj) {
        if ((i & 1) != 0) {
            iSpeechRecognitionManager = voiceInputEnvironment.speechRecognitionManager;
        }
        return voiceInputEnvironment.copy(iSpeechRecognitionManager);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ISpeechRecognitionManager getSpeechRecognitionManager() {
        return this.speechRecognitionManager;
    }

    public final VoiceInputEnvironment copy(ISpeechRecognitionManager speechRecognitionManager) {
        Intrinsics.checkNotNullParameter(speechRecognitionManager, "speechRecognitionManager");
        return new VoiceInputEnvironment(speechRecognitionManager);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VoiceInputEnvironment) && Intrinsics.areEqual(this.speechRecognitionManager, ((VoiceInputEnvironment) other).speechRecognitionManager);
    }

    public int hashCode() {
        return this.speechRecognitionManager.hashCode();
    }

    public String toString() {
        return "VoiceInputEnvironment(speechRecognitionManager=" + this.speechRecognitionManager + ")";
    }

    @Inject
    public VoiceInputEnvironment(ISpeechRecognitionManager speechRecognitionManager) {
        Intrinsics.checkNotNullParameter(speechRecognitionManager, "speechRecognitionManager");
        this.speechRecognitionManager = speechRecognitionManager;
    }

    public final ISpeechRecognitionManager getSpeechRecognitionManager() {
        return this.speechRecognitionManager;
    }
}
