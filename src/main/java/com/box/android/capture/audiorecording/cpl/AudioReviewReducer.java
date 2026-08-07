package com.box.android.capture.audiorecording.cpl;

import android.net.Uri;
import androidx.media3.exoplayer.ExoPlayer;
import com.box.android.capture.audiorecording.RecordingUtils;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioReviewReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "environment", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "getUpdatePlaybackTimeEffect", "Lcom/box/android/cpl/Effect;", "State", "Action", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioReviewReducer implements Reducable<State, Action> {
    private static final String WAVE_FORM_UPDATE_ID = "wave_form_update_id";
    private final AudioCaptureEnvironment environment;
    public static final int $stable = 8;

    public AudioReviewReducer(AudioCaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: AudioReviewReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003JW\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u0006."}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;", "", "isInitialized", "", "isDiscarding", "playbackPosition", "", "playbackDuration", "recordedSamples", "", "", "recordedFileUri", "Landroid/net/Uri;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "<init>", "(ZZJJLjava/util/List;Landroid/net/Uri;Landroidx/media3/exoplayer/ExoPlayer;)V", "()Z", "getPlaybackPosition", "()J", "getPlaybackDuration", "getRecordedSamples", "()Ljava/util/List;", "getRecordedFileUri", "()Landroid/net/Uri;", "getPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "elapsedTime", "", "getElapsedTime", "()Ljava/lang/String;", "remainingTime", "getRemainingTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String elapsedTime;
        private final boolean isDiscarding;
        private final boolean isInitialized;
        private final long playbackDuration;
        private final long playbackPosition;
        private final ExoPlayer player;
        private final Uri recordedFileUri;
        private final List<Double> recordedSamples;
        private final String remainingTime;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, long j, long j2, List list, Uri uri, ExoPlayer exoPlayer, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isInitialized;
            }
            if ((i & 2) != 0) {
                z2 = state.isDiscarding;
            }
            if ((i & 4) != 0) {
                j = state.playbackPosition;
            }
            if ((i & 8) != 0) {
                j2 = state.playbackDuration;
            }
            if ((i & 16) != 0) {
                list = state.recordedSamples;
            }
            if ((i & 32) != 0) {
                uri = state.recordedFileUri;
            }
            if ((i & 64) != 0) {
                exoPlayer = state.player;
            }
            ExoPlayer exoPlayer2 = exoPlayer;
            List list2 = list;
            long j3 = j2;
            long j4 = j;
            return state.copy(z, z2, j4, j3, list2, uri, exoPlayer2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsInitialized() {
            return this.isInitialized;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDiscarding() {
            return this.isDiscarding;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getPlaybackPosition() {
            return this.playbackPosition;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getPlaybackDuration() {
            return this.playbackDuration;
        }

        public final List<Double> component5() {
            return this.recordedSamples;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Uri getRecordedFileUri() {
            return this.recordedFileUri;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ExoPlayer getPlayer() {
            return this.player;
        }

        public final State copy(boolean isInitialized, boolean isDiscarding, long playbackPosition, long playbackDuration, List<Double> recordedSamples, Uri recordedFileUri, ExoPlayer player) {
            Intrinsics.checkNotNullParameter(recordedSamples, "recordedSamples");
            Intrinsics.checkNotNullParameter(recordedFileUri, "recordedFileUri");
            return new State(isInitialized, isDiscarding, playbackPosition, playbackDuration, recordedSamples, recordedFileUri, player);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isInitialized == state.isInitialized && this.isDiscarding == state.isDiscarding && this.playbackPosition == state.playbackPosition && this.playbackDuration == state.playbackDuration && Intrinsics.areEqual(this.recordedSamples, state.recordedSamples) && Intrinsics.areEqual(this.recordedFileUri, state.recordedFileUri) && Intrinsics.areEqual(this.player, state.player);
        }

        public int hashCode() {
            int iHashCode = ((((((((((Boolean.hashCode(this.isInitialized) * 31) + Boolean.hashCode(this.isDiscarding)) * 31) + Long.hashCode(this.playbackPosition)) * 31) + Long.hashCode(this.playbackDuration)) * 31) + this.recordedSamples.hashCode()) * 31) + this.recordedFileUri.hashCode()) * 31;
            ExoPlayer exoPlayer = this.player;
            return iHashCode + (exoPlayer == null ? 0 : exoPlayer.hashCode());
        }

        public String toString() {
            return "State(isInitialized=" + this.isInitialized + ", isDiscarding=" + this.isDiscarding + ", playbackPosition=" + this.playbackPosition + ", playbackDuration=" + this.playbackDuration + ", recordedSamples=" + this.recordedSamples + ", recordedFileUri=" + this.recordedFileUri + ", player=" + this.player + ")";
        }

        public State(boolean z, boolean z2, long j, long j2, List<Double> recordedSamples, Uri recordedFileUri, ExoPlayer exoPlayer) {
            Intrinsics.checkNotNullParameter(recordedSamples, "recordedSamples");
            Intrinsics.checkNotNullParameter(recordedFileUri, "recordedFileUri");
            this.isInitialized = z;
            this.isDiscarding = z2;
            this.playbackPosition = j;
            this.playbackDuration = j2;
            this.recordedSamples = recordedSamples;
            this.recordedFileUri = recordedFileUri;
            this.player = exoPlayer;
            this.elapsedTime = RecordingUtils.INSTANCE.parseElapsedTime(j);
            this.remainingTime = RecordingUtils.INSTANCE.parseLeftTime(j2 - j);
        }

        public /* synthetic */ State(boolean z, boolean z2, long j, long j2, List list, Uri uri, ExoPlayer exoPlayer, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? 0L : j2, list, uri, (i & 64) != 0 ? null : exoPlayer);
        }

        public final boolean isInitialized() {
            return this.isInitialized;
        }

        public final boolean isDiscarding() {
            return this.isDiscarding;
        }

        public final long getPlaybackPosition() {
            return this.playbackPosition;
        }

        public final long getPlaybackDuration() {
            return this.playbackDuration;
        }

        public final List<Double> getRecordedSamples() {
            return this.recordedSamples;
        }

        public final Uri getRecordedFileUri() {
            return this.recordedFileUri;
        }

        public final ExoPlayer getPlayer() {
            return this.player;
        }

        public final String getElapsedTime() {
            return this.elapsedTime;
        }

        public final String getRemainingTime() {
            return this.remainingTime;
        }
    }

    /* JADX INFO: compiled from: AudioReviewReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "", "<init>", "()V", "PlaybackStarted", "PlaybackStopped", "TryDiscardRecording", "DiscardRecording", "KeepRecording", "PrepareAudioRecording", "PlayerInitialized", "UploadRecording", "UpdatePlaybackTime", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$DiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$KeepRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlaybackStarted;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlaybackStopped;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlayerInitialized;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PrepareAudioRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$TryDiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$UpdatePlaybackTime;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$UploadRecording;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlaybackStarted;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PlaybackStarted extends Action {
            public static final int $stable = 0;
            public static final PlaybackStarted INSTANCE = new PlaybackStarted();

            private PlaybackStarted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlaybackStopped;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PlaybackStopped extends Action {
            public static final int $stable = 0;
            public static final PlaybackStopped INSTANCE = new PlaybackStopped();

            private PlaybackStopped() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$TryDiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TryDiscardRecording extends Action {
            public static final int $stable = 0;
            public static final TryDiscardRecording INSTANCE = new TryDiscardRecording();

            private TryDiscardRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$DiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DiscardRecording extends Action {
            public static final int $stable = 0;
            public static final DiscardRecording INSTANCE = new DiscardRecording();

            private DiscardRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$KeepRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class KeepRecording extends Action {
            public static final int $stable = 0;
            public static final KeepRecording INSTANCE = new KeepRecording();

            private KeepRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PrepareAudioRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PrepareAudioRecording extends Action {
            public static final int $stable = 0;
            public static final PrepareAudioRecording INSTANCE = new PrepareAudioRecording();

            private PrepareAudioRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$PlayerInitialized;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "<init>", "(Landroidx/media3/exoplayer/ExoPlayer;)V", "getExoPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PlayerInitialized extends Action {
            public static final int $stable = 8;
            private final ExoPlayer exoPlayer;

            public static /* synthetic */ PlayerInitialized copy$default(PlayerInitialized playerInitialized, ExoPlayer exoPlayer, int i, Object obj) {
                if ((i & 1) != 0) {
                    exoPlayer = playerInitialized.exoPlayer;
                }
                return playerInitialized.copy(exoPlayer);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ExoPlayer getExoPlayer() {
                return this.exoPlayer;
            }

            public final PlayerInitialized copy(ExoPlayer exoPlayer) {
                Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
                return new PlayerInitialized(exoPlayer);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PlayerInitialized) && Intrinsics.areEqual(this.exoPlayer, ((PlayerInitialized) other).exoPlayer);
            }

            public int hashCode() {
                return this.exoPlayer.hashCode();
            }

            public String toString() {
                return "PlayerInitialized(exoPlayer=" + this.exoPlayer + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PlayerInitialized(ExoPlayer exoPlayer) {
                super(null);
                Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
                this.exoPlayer = exoPlayer;
            }

            public final ExoPlayer getExoPlayer() {
                return this.exoPlayer;
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$UploadRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "recordedFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getRecordedFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadRecording extends Action {
            public static final int $stable = 8;
            private final File recordedFile;

            public static /* synthetic */ UploadRecording copy$default(UploadRecording uploadRecording, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = uploadRecording.recordedFile;
                }
                return uploadRecording.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getRecordedFile() {
                return this.recordedFile;
            }

            public final UploadRecording copy(File recordedFile) {
                Intrinsics.checkNotNullParameter(recordedFile, "recordedFile");
                return new UploadRecording(recordedFile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UploadRecording) && Intrinsics.areEqual(this.recordedFile, ((UploadRecording) other).recordedFile);
            }

            public int hashCode() {
                return this.recordedFile.hashCode();
            }

            public String toString() {
                return "UploadRecording(recordedFile=" + this.recordedFile + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadRecording(File recordedFile) {
                super(null);
                Intrinsics.checkNotNullParameter(recordedFile, "recordedFile");
                this.recordedFile = recordedFile;
            }

            public final File getRecordedFile() {
                return this.recordedFile;
            }
        }

        /* JADX INFO: compiled from: AudioReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$UpdatePlaybackTime;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class UpdatePlaybackTime extends Action {
            public static final int $stable = 0;
            public static final UpdatePlaybackTime INSTANCE = new UpdatePlaybackTime();

            private UpdatePlaybackTime() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.PlaybackStopped.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.cancel(WAVE_FORM_UPDATE_ID));
        }
        if (Intrinsics.areEqual(action, Action.PlaybackStarted.INSTANCE)) {
            return new ReducerResult<>(state, getUpdatePlaybackTimeEffect());
        }
        if (action instanceof Action.UpdatePlaybackTime) {
            ExoPlayer player = state.getPlayer();
            return new ReducerResult<>(State.copy$default(state, false, false, player != null ? player.getCurrentPosition() : 0L, 0L, null, null, null, 123, null), null, 2, null);
        }
        if (action instanceof Action.PlayerInitialized) {
            Action.PlayerInitialized playerInitialized = (Action.PlayerInitialized) action;
            return new ReducerResult<>(State.copy$default(state, true, false, 0L, playerInitialized.getExoPlayer().getDuration(), null, null, playerInitialized.getExoPlayer(), 54, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.TryDiscardRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, true, 0L, 0L, null, null, null, 125, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.KeepRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, 0L, 0L, null, null, null, 125, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.DiscardRecording.INSTANCE)) {
            this.environment.getRecordingFileManager().deleteRecordingFiles();
            return new ReducerResult<>(State.copy$default(state, false, false, 0L, 0L, null, null, null, 125, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.PrepareAudioRecording.INSTANCE)) {
            this.environment.getAudioRecordingHelper().logAudioRecordingEvent(this.environment.getApplication(), BoxAnalyticsParams.EVENT_AUDIO_RECORDING_UPLOAD_INITIATED, RecordingUtils.INSTANCE.getRecordedFileDurationInMinutes(this.environment), RecordingUtils.INSTANCE.getRecordedFileSize(this.environment));
            return new ReducerResult<>(state, new Effect((Function1) new C09691(null)));
        }
        if (action instanceof Action.UploadRecording) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioReviewReducer$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AudioReviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioReviewReducer$reduce$1", f = "AudioReviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09691 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        C09691(Continuation<? super C09691> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AudioReviewReducer.this.new C09691(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C09691) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Action.UploadRecording(AudioReviewReducer.this.environment.getRecordingFileManager().prepareAudioRecording());
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioReviewReducer$getUpdatePlaybackTimeEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioReviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action$UpdatePlaybackTime;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioReviewReducer$getUpdatePlaybackTimeEffect$1", f = "AudioReviewReducer.kt", i = {0, 1}, l = {Token.XMLATTR, Token.XMLEND}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdatePlaybackTime>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdatePlaybackTime> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        /* JADX WARN: Code duplicated, block: B:14:0x0032  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003f -> B:11:0x0022). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L1f
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1f
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L32
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
            L22:
                com.box.android.capture.audiorecording.cpl.AudioReviewReducer$Action$UpdatePlaybackTime r8 = com.box.android.capture.audiorecording.cpl.AudioReviewReducer.Action.UpdatePlaybackTime.INSTANCE
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = r0.emit(r8, r2)
                if (r8 != r1) goto L32
                goto L41
            L32:
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.L$0 = r0
                r7.label = r3
                r5 = 30
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
                if (r8 != r1) goto L22
            L41:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.cpl.AudioReviewReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> getUpdatePlaybackTimeEffect() {
        Effect<Action> effectCancellable$default = Effect.cancellable$default(EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(null))), WAVE_FORM_UPDATE_ID, false, 2, null);
        Intrinsics.checkNotNull(effectCancellable$default, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.capture.audiorecording.cpl.AudioReviewReducer.Action>");
        return effectCancellable$default;
    }
}
