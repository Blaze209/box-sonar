package com.box.android.boxai.voice;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent;", "", "ListeningStarted", "AudioLevelSample", "ListeningFinished", "ListeningCancelled", "Error", "Lcom/box/android/boxai/voice/RecognitionEvent$AudioLevelSample;", "Lcom/box/android/boxai/voice/RecognitionEvent$Error;", "Lcom/box/android/boxai/voice/RecognitionEvent$ListeningCancelled;", "Lcom/box/android/boxai/voice/RecognitionEvent$ListeningFinished;", "Lcom/box/android/boxai/voice/RecognitionEvent$ListeningStarted;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecognitionEvent {

    /* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent$ListeningStarted;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ListeningStarted implements RecognitionEvent {
        public static final int $stable = 0;
        public static final ListeningStarted INSTANCE = new ListeningStarted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListeningStarted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1838649323;
        }

        public String toString() {
            return "ListeningStarted";
        }

        private ListeningStarted() {
        }
    }

    /* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent$AudioLevelSample;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "rmsdB", "", "<init>", "(F)V", "getRmsdB", "()F", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AudioLevelSample implements RecognitionEvent {
        public static final int $stable = 0;
        private final float rmsdB;

        public static /* synthetic */ AudioLevelSample copy$default(AudioLevelSample audioLevelSample, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = audioLevelSample.rmsdB;
            }
            return audioLevelSample.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getRmsdB() {
            return this.rmsdB;
        }

        public final AudioLevelSample copy(float rmsdB) {
            return new AudioLevelSample(rmsdB);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AudioLevelSample) && Float.compare(this.rmsdB, ((AudioLevelSample) other).rmsdB) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.rmsdB);
        }

        public String toString() {
            return "AudioLevelSample(rmsdB=" + this.rmsdB + ")";
        }

        public AudioLevelSample(float f) {
            this.rmsdB = f;
        }

        public final float getRmsdB() {
            return this.rmsdB;
        }
    }

    /* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent$ListeningFinished;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ListeningFinished implements RecognitionEvent {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ ListeningFinished copy$default(ListeningFinished listeningFinished, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listeningFinished.text;
            }
            return listeningFinished.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final ListeningFinished copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ListeningFinished(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ListeningFinished) && Intrinsics.areEqual(this.text, ((ListeningFinished) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "ListeningFinished(text=" + this.text + ")";
        }

        public ListeningFinished(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent$ListeningCancelled;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ListeningCancelled implements RecognitionEvent {
        public static final int $stable = 0;
        public static final ListeningCancelled INSTANCE = new ListeningCancelled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListeningCancelled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 20858427;
        }

        public String toString() {
            return "ListeningCancelled";
        }

        private ListeningCancelled() {
        }
    }

    /* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/voice/RecognitionEvent$Error;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "error", "Lcom/box/android/boxai/voice/RecognitionError;", "<init>", "(Lcom/box/android/boxai/voice/RecognitionError;)V", "getError", "()Lcom/box/android/boxai/voice/RecognitionError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error implements RecognitionEvent {
        public static final int $stable = 8;
        private final RecognitionError error;

        public static /* synthetic */ Error copy$default(Error error, RecognitionError recognitionError, int i, Object obj) {
            if ((i & 1) != 0) {
                recognitionError = error.error;
            }
            return error.copy(recognitionError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecognitionError getError() {
            return this.error;
        }

        public final Error copy(RecognitionError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        public Error(RecognitionError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final RecognitionError getError() {
            return this.error;
        }
    }
}
