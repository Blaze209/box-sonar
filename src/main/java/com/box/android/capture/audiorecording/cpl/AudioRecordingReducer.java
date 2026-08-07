package com.box.android.capture.audiorecording.cpl;

import android.content.Intent;
import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.capture.audiorecording.IRecordManager;
import com.box.android.capture.audiorecording.RecorderService;
import com.box.android.capture.audiorecording.RecordingFileState;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.AudioRecordingError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AudioRecordingReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "environment", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "stopRecordingService", "", "getRecordedSamplesEffect", "Lcom/box/android/cpl/Effect;", "getRecordingStateEffect", "getElapsedTimeEffect", "State", "Action", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioRecordingReducer implements Reducable<State, Action> {
    private static final String ELAPSED_TIME_EFFECT_ID = "elapsed_time_effect_id";
    private static final long PROGRESS_UPDATE_INTERVAL_IN_MS = 100;
    private static final String RECORDING_STATE_EFFECT_ID = "recording_state_effect_id";
    private final AudioCaptureEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingFileState.values().length];
            try {
                iArr[RecordingFileState.RECORDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordingFileState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordingFileState.NOT_RECORDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RecordingFileState.AUTO_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudioRecordingReducer(AudioCaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;", "", "hasPendingRecording", "", "isRecording", "isClosing", "isDeleting", "isDone", "recordedSamples", "", "", "elapsedTime", "", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(ZZZZZLjava/util/List;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;)V", "getHasPendingRecording", "()Z", "getRecordedSamples", "()Ljava/util/List;", "getElapsedTime", "()Ljava/lang/String;", "getError", "()Lcom/box/android/domain/models/DomainError;", "toRecordingState", "Lcom/box/android/capture/audiorecording/RecordingFileState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String elapsedTime;
        private final DomainError error;
        private final boolean hasPendingRecording;
        private final boolean isClosing;
        private final boolean isDeleting;
        private final boolean isDone;
        private final boolean isRecording;
        private final List<Double> recordedSamples;

        public State() {
            this(false, false, false, false, false, null, null, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List list, String str, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.hasPendingRecording;
            }
            if ((i & 2) != 0) {
                z2 = state.isRecording;
            }
            if ((i & 4) != 0) {
                z3 = state.isClosing;
            }
            if ((i & 8) != 0) {
                z4 = state.isDeleting;
            }
            if ((i & 16) != 0) {
                z5 = state.isDone;
            }
            if ((i & 32) != 0) {
                list = state.recordedSamples;
            }
            if ((i & 64) != 0) {
                str = state.elapsedTime;
            }
            if ((i & 128) != 0) {
                domainError = state.error;
            }
            String str2 = str;
            DomainError domainError2 = domainError;
            boolean z6 = z5;
            List list2 = list;
            return state.copy(z, z2, z3, z4, z6, list2, str2, domainError2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHasPendingRecording() {
            return this.hasPendingRecording;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsRecording() {
            return this.isRecording;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsDeleting() {
            return this.isDeleting;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsDone() {
            return this.isDone;
        }

        public final List<Double> component6() {
            return this.recordedSamples;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getElapsedTime() {
            return this.elapsedTime;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final State copy(boolean hasPendingRecording, boolean isRecording, boolean isClosing, boolean isDeleting, boolean isDone, List<Double> recordedSamples, String elapsedTime, DomainError error) {
            Intrinsics.checkNotNullParameter(recordedSamples, "recordedSamples");
            Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
            return new State(hasPendingRecording, isRecording, isClosing, isDeleting, isDone, recordedSamples, elapsedTime, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.hasPendingRecording == state.hasPendingRecording && this.isRecording == state.isRecording && this.isClosing == state.isClosing && this.isDeleting == state.isDeleting && this.isDone == state.isDone && Intrinsics.areEqual(this.recordedSamples, state.recordedSamples) && Intrinsics.areEqual(this.elapsedTime, state.elapsedTime) && Intrinsics.areEqual(this.error, state.error);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((Boolean.hashCode(this.hasPendingRecording) * 31) + Boolean.hashCode(this.isRecording)) * 31) + Boolean.hashCode(this.isClosing)) * 31) + Boolean.hashCode(this.isDeleting)) * 31) + Boolean.hashCode(this.isDone)) * 31) + this.recordedSamples.hashCode()) * 31) + this.elapsedTime.hashCode()) * 31;
            DomainError domainError = this.error;
            return iHashCode + (domainError == null ? 0 : domainError.hashCode());
        }

        public String toString() {
            return "State(hasPendingRecording=" + this.hasPendingRecording + ", isRecording=" + this.isRecording + ", isClosing=" + this.isClosing + ", isDeleting=" + this.isDeleting + ", isDone=" + this.isDone + ", recordedSamples=" + this.recordedSamples + ", elapsedTime=" + this.elapsedTime + ", error=" + this.error + ")";
        }

        public State(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List<Double> recordedSamples, String elapsedTime, DomainError domainError) {
            Intrinsics.checkNotNullParameter(recordedSamples, "recordedSamples");
            Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
            this.hasPendingRecording = z;
            this.isRecording = z2;
            this.isClosing = z3;
            this.isDeleting = z4;
            this.isDone = z5;
            this.recordedSamples = recordedSamples;
            this.elapsedTime = elapsedTime;
            this.error = domainError;
        }

        public final boolean getHasPendingRecording() {
            return this.hasPendingRecording;
        }

        public final boolean isRecording() {
            return this.isRecording;
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public final boolean isDeleting() {
            return this.isDeleting;
        }

        public final boolean isDone() {
            return this.isDone;
        }

        public /* synthetic */ State(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List list, String str, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? "" : str, (i & 128) != 0 ? null : domainError);
        }

        public final List<Double> getRecordedSamples() {
            return this.recordedSamples;
        }

        public final String getElapsedTime() {
            return this.elapsedTime;
        }

        public final DomainError getError() {
            return this.error;
        }

        public final RecordingFileState toRecordingState() {
            if (this.isRecording) {
                return RecordingFileState.RECORDING;
            }
            return this.hasPendingRecording ? RecordingFileState.PAUSED : RecordingFileState.NOT_RECORDING;
        }
    }

    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0010\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "", "<init>", "()V", "StartRecording", "PauseRecording", "ResumeRecording", "ResumePendingRecording", "StopRecording", "CancelRecording", "KeepRecording", "DiscardRecording", "ReviewRecording", "StartUpdatesListening", "StopUpdatesListening", "CloseRecording", "DismissError", "Error", "SamplesUpdate", "ElapsedTimeUpdate", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$CancelRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$CloseRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$DiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$DismissError;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ElapsedTimeUpdate;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$Error;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$KeepRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$PauseRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ResumePendingRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ResumeRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ReviewRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$SamplesUpdate;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StartRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StartUpdatesListening;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StopRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StopUpdatesListening;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StartRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StartRecording extends Action {
            public static final int $stable = 0;
            public static final StartRecording INSTANCE = new StartRecording();

            private StartRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$PauseRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PauseRecording extends Action {
            public static final int $stable = 0;
            public static final PauseRecording INSTANCE = new PauseRecording();

            private PauseRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ResumeRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ResumeRecording extends Action {
            public static final int $stable = 0;
            public static final ResumeRecording INSTANCE = new ResumeRecording();

            private ResumeRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ResumePendingRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ResumePendingRecording extends Action {
            public static final int $stable = 0;
            public static final ResumePendingRecording INSTANCE = new ResumePendingRecording();

            private ResumePendingRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StopRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StopRecording extends Action {
            public static final int $stable = 0;
            public static final StopRecording INSTANCE = new StopRecording();

            private StopRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$CancelRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CancelRecording extends Action {
            public static final int $stable = 0;
            public static final CancelRecording INSTANCE = new CancelRecording();

            private CancelRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$KeepRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class KeepRecording extends Action {
            public static final int $stable = 0;
            public static final KeepRecording INSTANCE = new KeepRecording();

            private KeepRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$DiscardRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DiscardRecording extends Action {
            public static final int $stable = 0;
            public static final DiscardRecording INSTANCE = new DiscardRecording();

            private DiscardRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ReviewRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ReviewRecording extends Action {
            public static final int $stable = 0;
            public static final ReviewRecording INSTANCE = new ReviewRecording();

            private ReviewRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StartUpdatesListening;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StartUpdatesListening extends Action {
            public static final int $stable = 0;
            public static final StartUpdatesListening INSTANCE = new StartUpdatesListening();

            private StartUpdatesListening() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$StopUpdatesListening;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StopUpdatesListening extends Action {
            public static final int $stable = 0;
            public static final StopUpdatesListening INSTANCE = new StopUpdatesListening();

            private StopUpdatesListening() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$CloseRecording;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseRecording extends Action {
            public static final int $stable = 0;
            public static final CloseRecording INSTANCE = new CloseRecording();

            private CloseRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$DismissError;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DismissError extends Action {
            public static final int $stable = 0;
            public static final DismissError INSTANCE = new DismissError();

            private DismissError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$Error;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$SamplesUpdate;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "samples", "", "", "<init>", "(Ljava/util/List;)V", "getSamples", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SamplesUpdate extends Action {
            public static final int $stable = 8;
            private final List<Double> samples;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SamplesUpdate copy$default(SamplesUpdate samplesUpdate, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = samplesUpdate.samples;
                }
                return samplesUpdate.copy(list);
            }

            public final List<Double> component1() {
                return this.samples;
            }

            public final SamplesUpdate copy(List<Double> samples) {
                Intrinsics.checkNotNullParameter(samples, "samples");
                return new SamplesUpdate(samples);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SamplesUpdate) && Intrinsics.areEqual(this.samples, ((SamplesUpdate) other).samples);
            }

            public int hashCode() {
                return this.samples.hashCode();
            }

            public String toString() {
                return "SamplesUpdate(samples=" + this.samples + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SamplesUpdate(List<Double> samples) {
                super(null);
                Intrinsics.checkNotNullParameter(samples, "samples");
                this.samples = samples;
            }

            public final List<Double> getSamples() {
                return this.samples;
            }
        }

        /* JADX INFO: compiled from: AudioRecordingReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ElapsedTimeUpdate;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "elapsedTime", "", "<init>", "(Ljava/lang/String;)V", "getElapsedTime", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ElapsedTimeUpdate extends Action {
            public static final int $stable = 0;
            private final String elapsedTime;

            public static /* synthetic */ ElapsedTimeUpdate copy$default(ElapsedTimeUpdate elapsedTimeUpdate, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = elapsedTimeUpdate.elapsedTime;
                }
                return elapsedTimeUpdate.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getElapsedTime() {
                return this.elapsedTime;
            }

            public final ElapsedTimeUpdate copy(String elapsedTime) {
                Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
                return new ElapsedTimeUpdate(elapsedTime);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ElapsedTimeUpdate) && Intrinsics.areEqual(this.elapsedTime, ((ElapsedTimeUpdate) other).elapsedTime);
            }

            public int hashCode() {
                return this.elapsedTime.hashCode();
            }

            public String toString() {
                return "ElapsedTimeUpdate(elapsedTime=" + this.elapsedTime + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ElapsedTimeUpdate(String elapsedTime) {
                super(null);
                Intrinsics.checkNotNullParameter(elapsedTime, "elapsedTime");
                this.elapsedTime = elapsedTime;
            }

            public final String getElapsedTime() {
                return this.elapsedTime;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.PauseRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, this.environment.getRecordingFileManager().hasRecordedFile(), false, false, false, false, null, null, null, 252, null), new Effect(FlowKt.flow(new C09681(null))));
        }
        if (Intrinsics.areEqual(action, Action.ResumeRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, this.environment.getRecordingFileManager().hasRecordedFile(), true, false, false, false, null, null, null, 252, null), new Effect(FlowKt.flow(new AnonymousClass2(null))));
        }
        if (Intrinsics.areEqual(action, Action.ResumePendingRecording.INSTANCE)) {
            return new ReducerResult<>(state, getRecordingStateEffect(this.environment));
        }
        if (Intrinsics.areEqual(action, Action.StartRecording.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(FlowKt.flow(new AnonymousClass3(null))), getRecordingStateEffect(this.environment)));
        }
        if (Intrinsics.areEqual(action, Action.StopRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, true, null, null, null, 239, null), Effect.INSTANCE.merge(new Effect((Function1) new AnonymousClass4(null)), Effect.INSTANCE.cancel(RECORDING_STATE_EFFECT_ID)));
        }
        if (action instanceof Action.SamplesUpdate) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, ((Action.SamplesUpdate) action).getSamples(), null, null, 223, null), null, 2, null);
        }
        if (action instanceof Action.ElapsedTimeUpdate) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, null, ((Action.ElapsedTimeUpdate) action).getElapsedTime(), null, 191, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.KeepRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, null, null, null, 247, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.CancelRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, true, false, null, null, null, 247, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.DiscardRecording.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, null, null, null, 244, null), new Effect(FlowKt.flow(new AnonymousClass5(null))));
        }
        if (action instanceof Action.Error) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, null, null, ((Action.Error) action).getError(), 127, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.DismissError.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, false, false, false, false, null, null, null, 127, null), null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.ReviewRecording.INSTANCE) && !Intrinsics.areEqual(action, Action.CloseRecording.INSTANCE)) {
            if (Intrinsics.areEqual(action, Action.StartUpdatesListening.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, this.environment.getRecordingFileManager().hasRecordedFile(), true, false, false, false, null, null, null, 252, null), Effect.cancellable$default(Effect.INSTANCE.merge(getElapsedTimeEffect(this.environment), getRecordedSamplesEffect(this.environment)), ELAPSED_TIME_EFFECT_ID, false, 2, null));
            }
            if (!Intrinsics.areEqual(action, Action.StopUpdatesListening.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, this.environment.getRecordingFileManager().hasRecordedFile(), false, false, false, false, null, null, null, 252, null), Effect.INSTANCE.cancel(ELAPSED_TIME_EFFECT_ID));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$1", f = "AudioRecordingReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {139, 140}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-AudioRecordingReducer$reduce$1$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C09681 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C09681(Continuation<? super C09681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09681 c09681 = AudioRecordingReducer.this.new C09681(continuation);
            c09681.L$0 = obj;
            return c09681;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09681) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
        
            if (r0.emit(r5, r7) == r1) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L2b
                if (r2 == r5) goto L27
                if (r2 != r3) goto L1f
                java.lang.Object r0 = r7.L$2
                com.box.android.domain.models.AudioRecordingError r0 = (com.box.android.domain.models.AudioRecordingError) r0
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L85
            L1f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L27:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L49
            L2b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer r8 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.this
                com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment r8 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.access$getEnvironment$p(r8)
                com.box.android.capture.audiorecording.IRecordManager r8 = r8.getRecordManager()
                if (r8 == 0) goto L95
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r5
                r6 = 0
                java.lang.Object r8 = com.box.android.capture.audiorecording.IRecordManager.pauseRecording$default(r8, r4, r2, r5, r6)
                if (r8 != r1) goto L49
                goto L84
            L49:
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                if (r8 == 0) goto L95
                boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 != 0) goto L95
                boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto L8f
                r2 = r8
                com.box.android.domain.utils.result.Result$Error r2 = (com.box.android.domain.utils.result.Result.Error) r2
                java.lang.Object r2 = r2.getValue()
                com.box.android.domain.models.AudioRecordingError r2 = (com.box.android.domain.models.AudioRecordingError) r2
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error r5 = new com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error
                r6 = r2
                com.box.android.domain.models.DomainError r6 = (com.box.android.domain.models.DomainError) r6
                r5.<init>(r6)
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r7.L$2 = r8
                r7.I$0 = r4
                r7.I$1 = r4
                r7.label = r3
                java.lang.Object r7 = r0.emit(r5, r7)
                if (r7 != r1) goto L85
            L84:
                return r1
            L85:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                com.box.android.domain.utils.result.Result$Error r8 = new com.box.android.domain.utils.result.Result$Error
                r8.<init>(r7)
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                goto L95
            L8f:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            L95:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.C09681.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$2", f = "AudioRecordingReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {Token.SET, Token.LET}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-AudioRecordingReducer$reduce$2$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AudioRecordingReducer.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
        
            if (r0.emit(r4, r6) == r1) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2a
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r0 = r6.L$2
                com.box.android.domain.models.AudioRecordingError r0 = (com.box.android.domain.models.AudioRecordingError) r0
                java.lang.Object r6 = r6.L$1
                com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L84
            L1e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L47
            L2a:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer r7 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.this
                com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment r7 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.access$getEnvironment$p(r7)
                com.box.android.capture.audiorecording.IRecordManager r7 = r7.getRecordManager()
                if (r7 == 0) goto L94
                r2 = r6
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r6.L$0 = r0
                r6.label = r4
                java.lang.Object r7 = r7.resumeRecording(r2)
                if (r7 != r1) goto L47
                goto L83
            L47:
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                if (r7 == 0) goto L94
                boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 != 0) goto L94
                boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto L8e
                r2 = r7
                com.box.android.domain.utils.result.Result$Error r2 = (com.box.android.domain.utils.result.Result.Error) r2
                java.lang.Object r2 = r2.getValue()
                com.box.android.domain.models.AudioRecordingError r2 = (com.box.android.domain.models.AudioRecordingError) r2
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error r4 = new com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error
                r5 = r2
                com.box.android.domain.models.DomainError r5 = (com.box.android.domain.models.DomainError) r5
                r4.<init>(r5)
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r5
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$1 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r6.L$2 = r7
                r7 = 0
                r6.I$0 = r7
                r6.I$1 = r7
                r6.label = r3
                java.lang.Object r6 = r0.emit(r4, r6)
                if (r6 != r1) goto L84
            L83:
                return r1
            L84:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                com.box.android.domain.utils.result.Result$Error r7 = new com.box.android.domain.utils.result.Result$Error
                r7.<init>(r6)
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                goto L94
            L8e:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            L94:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$3", f = "AudioRecordingReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {Context.VERSION_1_7, TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-AudioRecordingReducer$reduce$3$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = AudioRecordingReducer.this.new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
        
            if (r0.emit(r4, r6) == r1) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2b
                if (r2 == r4) goto L27
                if (r2 != r3) goto L1f
                java.lang.Object r0 = r6.L$2
                com.box.android.domain.models.AudioRecordingError r0 = (com.box.android.domain.models.AudioRecordingError) r0
                java.lang.Object r6 = r6.L$1
                com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L93
            L1f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L27:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L56
            L2b:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer r7 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.this
                com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment r7 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.access$getEnvironment$p(r7)
                com.box.android.capture.audiorecording.IRecordManager r7 = r7.getRecordManager()
                if (r7 == 0) goto La3
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer r2 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.this
                com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment r2 = com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.access$getEnvironment$p(r2)
                com.box.android.capture.audiorecording.RecordingFileManager r2 = r2.getRecordingFileManager()
                java.io.File r2 = r2.getRecordingFile()
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.L$0 = r0
                r6.label = r4
                java.lang.Object r7 = r7.startRecording(r2, r5)
                if (r7 != r1) goto L56
                goto L92
            L56:
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                if (r7 == 0) goto La3
                boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 != 0) goto La3
                boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto L9d
                r2 = r7
                com.box.android.domain.utils.result.Result$Error r2 = (com.box.android.domain.utils.result.Result.Error) r2
                java.lang.Object r2 = r2.getValue()
                com.box.android.domain.models.AudioRecordingError r2 = (com.box.android.domain.models.AudioRecordingError) r2
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error r4 = new com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$Error
                r5 = r2
                com.box.android.domain.models.DomainError r5 = (com.box.android.domain.models.DomainError) r5
                r4.<init>(r5)
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r5
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$1 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r6.L$2 = r7
                r7 = 0
                r6.I$0 = r7
                r6.I$1 = r7
                r6.label = r3
                java.lang.Object r6 = r0.emit(r4, r6)
                if (r6 != r1) goto L93
            L92:
                return r1
            L93:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                com.box.android.domain.utils.result.Result$Error r7 = new com.box.android.domain.utils.result.Result$Error
                r7.<init>(r6)
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                goto La3
            L9d:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            La3:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$4", f = "AudioRecordingReducer.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AudioRecordingReducer.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IRecordManager recordManager = AudioRecordingReducer.this.environment.getRecordManager();
                if (recordManager != null) {
                    this.label = 1;
                    obj = recordManager.stopRecording(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Action.ReviewRecording.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Result.Success success = (Result) obj;
            if (success != null) {
                AudioRecordingReducer audioRecordingReducer = AudioRecordingReducer.this;
                if (success instanceof Result.Success) {
                    audioRecordingReducer.stopRecordingService();
                    success = new Result.Success(Unit.INSTANCE);
                } else if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(success instanceof Result.Success)) {
                    if (success instanceof Result.Error) {
                        return new Action.Error((AudioRecordingError) ((Result.Error) success).getValue());
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return Action.ReviewRecording.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$reduce$5", f = "AudioRecordingReducer.kt", i = {}, l = {BoxCommonConstants.REQUEST_DELETE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecordingReducer.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IRecordManager recordManager = AudioRecordingReducer.this.environment.getRecordManager();
                if (recordManager != null) {
                    this.label = 1;
                    obj = recordManager.stopRecording(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                AudioRecordingReducer.this.environment.getRecordingFileManager().deleteRecordingFiles();
                AudioRecordingReducer.this.stopRecordingService();
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AudioRecordingReducer.this.environment.getRecordingFileManager().deleteRecordingFiles();
            AudioRecordingReducer.this.stopRecordingService();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRecordingService() {
        this.environment.getApplication().stopService(new Intent(this.environment.getApplication(), (Class<?>) RecorderService.class));
    }

    private final Effect<Action> getRecordedSamplesEffect(AudioCaptureEnvironment environment) {
        final Flow<List<Double>> recordedSamplesAsFlow;
        IRecordManager recordManager = environment.getRecordManager();
        Effect<Action> effect = (recordManager == null || (recordedSamplesAsFlow = recordManager.getRecordedSamplesAsFlow()) == null) ? null : EffectKt.toEffect(new Flow<Action.SamplesUpdate>() { // from class: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordedSamplesEffect$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AudioRecordingReducer.Action.SamplesUpdate> flowCollector, Continuation continuation) {
                Object objCollect = recordedSamplesAsFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordedSamplesEffect$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordedSamplesEffect$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordedSamplesEffect$$inlined$map$1$2", f = "AudioRecordingReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        AudioRecordingReducer.Action.SamplesUpdate samplesUpdate = new AudioRecordingReducer.Action.SamplesUpdate(CollectionsKt.toMutableList((Collection) obj));
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(samplesUpdate, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
        Intrinsics.checkNotNull(effect, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.Action>");
        return effect;
    }

    private final Effect<Action> getRecordingStateEffect(AudioCaptureEnvironment environment) {
        StateFlow<RecordingFileState> recordingStateFlow;
        IRecordManager recordManager = environment.getRecordManager();
        Effect<Action> effectCancellable$default = null;
        if (recordManager != null && (recordingStateFlow = recordManager.getRecordingStateFlow()) != null) {
            final StateFlow<RecordingFileState> stateFlow = recordingStateFlow;
            Effect effect = EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordingStateEffect$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super AudioRecordingReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordingStateEffect$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordingStateEffect$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getRecordingStateEffect$$inlined$map$1$2", f = "AudioRecordingReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        AudioRecordingReducer.Action action;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            int i2 = AudioRecordingReducer.WhenMappings.$EnumSwitchMapping$0[((RecordingFileState) obj).ordinal()];
                            if (i2 == 1) {
                                action = AudioRecordingReducer.Action.StartUpdatesListening.INSTANCE;
                            } else {
                                if (i2 != 2 && i2 != 3 && i2 != 4) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                action = AudioRecordingReducer.Action.StopUpdatesListening.INSTANCE;
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(action, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i3 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            });
            if (effect != null) {
                effectCancellable$default = Effect.cancellable$default(effect, RECORDING_STATE_EFFECT_ID, false, 2, null);
            }
        }
        Intrinsics.checkNotNull(effectCancellable$default, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.Action>");
        return effectCancellable$default;
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getElapsedTimeEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action$ElapsedTimeUpdate;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$getElapsedTimeEffect$1", f = "AudioRecordingReducer.kt", i = {0, 1}, l = {284, 293}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action.ElapsedTimeUpdate>, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioCaptureEnvironment $environment;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudioCaptureEnvironment audioCaptureEnvironment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$environment = audioCaptureEnvironment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$environment, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.ElapsedTimeUpdate> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        /* JADX WARN: Code duplicated, block: B:14:0x004b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0058 -> B:11:0x0022). Please report as a decompilation issue!!! */
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
                goto L4b
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
            L22:
                com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$ElapsedTimeUpdate r8 = new com.box.android.capture.audiorecording.cpl.AudioRecordingReducer$Action$ElapsedTimeUpdate
                com.box.android.capture.audiorecording.RecordingUtils r2 = com.box.android.capture.audiorecording.RecordingUtils.INSTANCE
                com.box.android.capture.audiorecording.RecorderService$Companion r5 = com.box.android.capture.audiorecording.RecorderService.INSTANCE
                com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment r6 = r7.$environment
                com.box.android.capture.audiorecording.RecordingFileManager r6 = r6.getRecordingFileManager()
                java.io.File r6 = r6.getRecordingFile()
                long r5 = r5.getFileDuration(r6)
                java.lang.String r2 = r2.parseElapsedTime(r5)
                r8.<init>(r2)
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = r0.emit(r8, r2)
                if (r8 != r1) goto L4b
                goto L5a
            L4b:
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.L$0 = r0
                r7.label = r3
                r5 = 100
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
                if (r8 != r1) goto L22
            L5a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> getElapsedTimeEffect(AudioCaptureEnvironment environment) {
        Effect<Action> effect = EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(environment, null)));
        Intrinsics.checkNotNull(effect, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.capture.audiorecording.cpl.AudioRecordingReducer.Action>");
        return effect;
    }
}
