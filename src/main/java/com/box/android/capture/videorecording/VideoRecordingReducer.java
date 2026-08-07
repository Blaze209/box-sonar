package com.box.android.capture.videorecording;

import androidx.camera.core.CameraSelector;
import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.capture.VideoQuality;
import com.pspdfkit.analytics.Analytics;
import java.io.File;
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

/* JADX INFO: compiled from: VideoRecordingReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "updateDuration", "Lcom/box/android/cpl/Effect;", "State", "Action", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoRecordingReducer implements Reducable<State, Action> {
    private static final String ELAPSED_TIME_EFFECT_ID = "elapsed_time_effect_id";
    private static final long PROGRESS_UPDATE_INTERVAL_IN_MS = 1000;
    private final CaptureEnvironment environment;
    public static final int $stable = 8;

    public VideoRecordingReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJX\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "isRecording", "", "outputFile", "Ljava/io/File;", "elapsedTime", "", "startedAtMs", "", "<init>", "(Lcom/box/android/domain/models/capture/FlashMode;Landroidx/camera/core/CameraSelector;Lcom/box/android/domain/models/capture/VideoQuality;ZLjava/io/File;Ljava/lang/String;Ljava/lang/Long;)V", "getFlashMode", "()Lcom/box/android/domain/models/capture/FlashMode;", "getCameraSelector", "()Landroidx/camera/core/CameraSelector;", "getVideoQuality", "()Lcom/box/android/domain/models/capture/VideoQuality;", "()Z", "getOutputFile", "()Ljava/io/File;", "getElapsedTime", "()Ljava/lang/String;", "getStartedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/capture/FlashMode;Landroidx/camera/core/CameraSelector;Lcom/box/android/domain/models/capture/VideoQuality;ZLjava/io/File;Ljava/lang/String;Ljava/lang/Long;)Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "equals", "other", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CameraSelector cameraSelector;
        private final String elapsedTime;
        private final FlashMode flashMode;
        private final boolean isRecording;
        private final File outputFile;
        private final Long startedAtMs;
        private final VideoQuality videoQuality;

        public static /* synthetic */ State copy$default(State state, FlashMode flashMode, CameraSelector cameraSelector, VideoQuality videoQuality, boolean z, File file, String str, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                flashMode = state.flashMode;
            }
            if ((i & 2) != 0) {
                cameraSelector = state.cameraSelector;
            }
            if ((i & 4) != 0) {
                videoQuality = state.videoQuality;
            }
            if ((i & 8) != 0) {
                z = state.isRecording;
            }
            if ((i & 16) != 0) {
                file = state.outputFile;
            }
            if ((i & 32) != 0) {
                str = state.elapsedTime;
            }
            if ((i & 64) != 0) {
                l = state.startedAtMs;
            }
            String str2 = str;
            Long l2 = l;
            File file2 = file;
            VideoQuality videoQuality2 = videoQuality;
            return state.copy(flashMode, cameraSelector, videoQuality2, z, file2, str2, l2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FlashMode getFlashMode() {
            return this.flashMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CameraSelector getCameraSelector() {
            return this.cameraSelector;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final VideoQuality getVideoQuality() {
            return this.videoQuality;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsRecording() {
            return this.isRecording;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final File getOutputFile() {
            return this.outputFile;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getElapsedTime() {
            return this.elapsedTime;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getStartedAtMs() {
            return this.startedAtMs;
        }

        public final State copy(FlashMode flashMode, CameraSelector cameraSelector, VideoQuality videoQuality, boolean isRecording, File outputFile, String elapsedTime, Long startedAtMs) {
            Intrinsics.checkNotNullParameter(flashMode, "flashMode");
            Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
            Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
            Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
            return new State(flashMode, cameraSelector, videoQuality, isRecording, outputFile, elapsedTime, startedAtMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.flashMode == state.flashMode && Intrinsics.areEqual(this.cameraSelector, state.cameraSelector) && this.videoQuality == state.videoQuality && this.isRecording == state.isRecording && Intrinsics.areEqual(this.outputFile, state.outputFile) && Intrinsics.areEqual(this.elapsedTime, state.elapsedTime) && Intrinsics.areEqual(this.startedAtMs, state.startedAtMs);
        }

        public int hashCode() {
            int iHashCode = ((((((this.flashMode.hashCode() * 31) + this.cameraSelector.hashCode()) * 31) + this.videoQuality.hashCode()) * 31) + Boolean.hashCode(this.isRecording)) * 31;
            File file = this.outputFile;
            int iHashCode2 = (((iHashCode + (file == null ? 0 : file.hashCode())) * 31) + this.elapsedTime.hashCode()) * 31;
            Long l = this.startedAtMs;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "State(flashMode=" + this.flashMode + ", cameraSelector=" + this.cameraSelector + ", videoQuality=" + this.videoQuality + ", isRecording=" + this.isRecording + ", outputFile=" + this.outputFile + ", elapsedTime=" + this.elapsedTime + ", startedAtMs=" + this.startedAtMs + ")";
        }

        public State(FlashMode flashMode, CameraSelector cameraSelector, VideoQuality videoQuality, boolean z, File file, String elapsedTime, Long l) {
            Intrinsics.checkNotNullParameter(flashMode, "flashMode");
            Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
            Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
            Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
            this.flashMode = flashMode;
            this.cameraSelector = cameraSelector;
            this.videoQuality = videoQuality;
            this.isRecording = z;
            this.outputFile = file;
            this.elapsedTime = elapsedTime;
            this.startedAtMs = l;
        }

        public final FlashMode getFlashMode() {
            return this.flashMode;
        }

        public final CameraSelector getCameraSelector() {
            return this.cameraSelector;
        }

        public final VideoQuality getVideoQuality() {
            return this.videoQuality;
        }

        public final boolean isRecording() {
            return this.isRecording;
        }

        public final File getOutputFile() {
            return this.outputFile;
        }

        public final String getElapsedTime() {
            return this.elapsedTime;
        }

        public final Long getStartedAtMs() {
            return this.startedAtMs;
        }
    }

    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "", "<init>", "()V", "ToggleCamera", "CloseCamera", "TryStartRecording", "StopRecording", "ReviewRecording", "UpdateDuration", "StartRecording", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$CloseCamera;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$ReviewRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$StartRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$StopRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$ToggleCamera;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$TryStartRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$UpdateDuration;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$ToggleCamera;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ToggleCamera extends Action {
            public static final int $stable = 0;
            public static final ToggleCamera INSTANCE = new ToggleCamera();

            private ToggleCamera() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$CloseCamera;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseCamera extends Action {
            public static final int $stable = 0;
            public static final CloseCamera INSTANCE = new CloseCamera();

            private CloseCamera() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$TryStartRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TryStartRecording extends Action {
            public static final int $stable = 0;
            public static final TryStartRecording INSTANCE = new TryStartRecording();

            private TryStartRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$StopRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StopRecording extends Action {
            public static final int $stable = 0;
            public static final StopRecording INSTANCE = new StopRecording();

            private StopRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$ReviewRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ReviewRecording extends Action {
            public static final int $stable = 0;
            public static final ReviewRecording INSTANCE = new ReviewRecording();

            private ReviewRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$UpdateDuration;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class UpdateDuration extends Action {
            public static final int $stable = 0;
            public static final UpdateDuration INSTANCE = new UpdateDuration();

            private UpdateDuration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoRecordingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$StartRecording;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "outputFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getOutputFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartRecording extends Action {
            public static final int $stable = 8;
            private final File outputFile;

            public static /* synthetic */ StartRecording copy$default(StartRecording startRecording, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = startRecording.outputFile;
                }
                return startRecording.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getOutputFile() {
                return this.outputFile;
            }

            public final StartRecording copy(File outputFile) {
                Intrinsics.checkNotNullParameter(outputFile, "outputFile");
                return new StartRecording(outputFile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartRecording) && Intrinsics.areEqual(this.outputFile, ((StartRecording) other).outputFile);
            }

            public int hashCode() {
                return this.outputFile.hashCode();
            }

            public String toString() {
                return "StartRecording(outputFile=" + this.outputFile + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StartRecording(File outputFile) {
                super(null);
                Intrinsics.checkNotNullParameter(outputFile, "outputFile");
                this.outputFile = outputFile;
            }

            public final File getOutputFile() {
                return this.outputFile;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        String elapsedTime;
        CameraSelector cameraSelector;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ToggleCamera) {
            if (Intrinsics.areEqual(state.getCameraSelector(), CameraSelector.DEFAULT_BACK_CAMERA)) {
                cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA;
            } else {
                cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
            }
            Intrinsics.checkNotNull(cameraSelector);
            this.environment.getCameraSession().setCameraSelector(cameraSelector);
            return new ReducerResult<>(State.copy$default(state, null, cameraSelector, null, false, null, null, null, 125, null), null, 2, null);
        }
        if (action instanceof Action.TryStartRecording) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect((Function1) new AnonymousClass1(null)), Effect.INSTANCE.fireAndForget(new AnonymousClass2(null))));
        }
        if (action instanceof Action.UpdateDuration) {
            if (state.getStartedAtMs() == null) {
                elapsedTime = RecordingUtils.INSTANCE.parseElapsedTime(0L);
            } else {
                elapsedTime = RecordingUtils.INSTANCE.parseElapsedTime(System.currentTimeMillis() - state.getStartedAtMs().longValue());
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, elapsedTime, null, 95, null), null, 2, null);
        }
        if (action instanceof Action.CloseCamera) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.StartRecording) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, true, ((Action.StartRecording) action).getOutputFile(), RecordingUtils.INSTANCE.parseElapsedTime(0L), Long.valueOf(System.currentTimeMillis()), 7, null), Effect.cancellable$default(updateDuration(), ELAPSED_TIME_EFFECT_ID, false, 2, null));
        }
        if (action instanceof Action.StopRecording) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, 119, null), Effect.INSTANCE.merge(Effect.INSTANCE.cancel(ELAPSED_TIME_EFFECT_ID), Effect.INSTANCE.fireAndForget(new AnonymousClass3(null))));
        }
        if (!(action instanceof Action.ReviewRecording)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoRecordingReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoRecordingReducer$reduce$1", f = "VideoRecordingReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoRecordingReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Action.StartRecording(VideoRecordingReducer.this.environment.getVideoRecordingFileManager().getRecordingFile());
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoRecordingReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoRecordingReducer$reduce$2", f = "VideoRecordingReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoRecordingReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VideoRecordingReducer.this.environment.getCaptureShutterSoundHelper().playVideoRecordingStartedSoundIfRequired();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoRecordingReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoRecordingReducer$reduce$3", f = "VideoRecordingReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoRecordingReducer.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VideoRecordingReducer.this.environment.getCaptureShutterSoundHelper().playVideoRecordingStoppedSoundIfRequired();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoRecordingReducer$updateDuration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VideoRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action$UpdateDuration;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoRecordingReducer$updateDuration$1", f = "VideoRecordingReducer.kt", i = {0, 1}, l = {124, 127}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C09951 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdateDuration>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C09951(Continuation<? super C09951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09951 c09951 = new C09951(continuation);
            c09951.L$0 = obj;
            return c09951;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdateDuration> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09951) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.box.android.capture.videorecording.VideoRecordingReducer$Action$UpdateDuration r8 = com.box.android.capture.videorecording.VideoRecordingReducer.Action.UpdateDuration.INSTANCE
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
                r5 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
                if (r8 != r1) goto L22
            L41:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.videorecording.VideoRecordingReducer.C09951.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> updateDuration() {
        Effect<Action> effect = EffectKt.toEffect(FlowKt.flow(new C09951(null)));
        Intrinsics.checkNotNull(effect, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.capture.videorecording.VideoRecordingReducer.Action>");
        return effect;
    }
}
