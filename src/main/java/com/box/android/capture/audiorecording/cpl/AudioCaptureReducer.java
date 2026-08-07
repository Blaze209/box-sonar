package com.box.android.capture.audiorecording.cpl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.lifecycle.LiveData;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.capture.audiorecording.IRecordManager;
import com.box.android.capture.audiorecording.RecorderService;
import com.box.android.capture.audiorecording.RecordingUtils;
import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.capture.cpl.CaptureModeState;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.capture.CaptureMode;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceAudioCapture", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "pendingRecordingState", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Recording;", "awaitServiceConnectionCallback", "", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "block", "Lkotlin/Function1;", "Landroid/content/ServiceConnection;", "(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioCaptureReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CaptureEnvironment environment;

    public AudioCaptureReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new AudioCaptureReducer$build$1(this));
        final AudioCaptureReducer$build$2 audioCaptureReducer$build$2 = AudioCaptureReducer$build$2.INSTANCE;
        final AudioCaptureReducer$build$3 audioCaptureReducer$build$3 = AudioCaptureReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new AudioRecordingReducer(environment.getAudioCaptureEnvironment()), new Function1<State, AudioRecordingReducer.State>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$1
            @Override // kotlin.jvm.functions.Function1
            public final AudioRecordingReducer.State invoke(AudioCaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof AudioCaptureReducer.State.Recording)) {
                    it = null;
                }
                AudioCaptureReducer.State.Recording recording = (AudioCaptureReducer.State.Recording) it;
                if (recording != null) {
                    return recording.getAction();
                }
                return null;
            }
        }, new Function1<Action, AudioRecordingReducer.Action>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$2
            @Override // kotlin.jvm.functions.Function1
            public final AudioRecordingReducer.Action invoke(AudioCaptureReducer.Action action) {
                if (!(action instanceof AudioCaptureReducer.Action.Recording)) {
                    action = null;
                }
                AudioCaptureReducer.Action.Recording recording = (AudioCaptureReducer.Action.Recording) action;
                if (recording != null) {
                    return recording.getAction();
                }
                return null;
            }
        }, new Function2<State, AudioRecordingReducer.State, State>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final AudioCaptureReducer.State invoke(AudioCaptureReducer.State state, AudioRecordingReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = audioCaptureReducer$build$2.invoke(state2);
                if (objInvoke != null) {
                    return (AudioCaptureReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.audiorecording.cpl.AudioCaptureReducer.State");
            }
        }, new Function1<AudioRecordingReducer.Action, Action>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AudioCaptureReducer.Action invoke(AudioRecordingReducer.Action action) {
                Object objInvoke = audioCaptureReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (AudioCaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.audiorecording.cpl.AudioCaptureReducer.Action");
            }
        });
        final AudioCaptureReducer$build$5 audioCaptureReducer$build$5 = AudioCaptureReducer$build$5.INSTANCE;
        final AudioCaptureReducer$build$6 audioCaptureReducer$build$6 = AudioCaptureReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new AudioReviewReducer(environment.getAudioCaptureEnvironment()), new Function1<State, AudioReviewReducer.State>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$5
            @Override // kotlin.jvm.functions.Function1
            public final AudioReviewReducer.State invoke(AudioCaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof AudioCaptureReducer.State.Review)) {
                    it = null;
                }
                AudioCaptureReducer.State.Review review = (AudioCaptureReducer.State.Review) it;
                if (review != null) {
                    return review.getAction();
                }
                return null;
            }
        }, new Function1<Action, AudioReviewReducer.Action>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$6
            @Override // kotlin.jvm.functions.Function1
            public final AudioReviewReducer.Action invoke(AudioCaptureReducer.Action action) {
                if (!(action instanceof AudioCaptureReducer.Action.Reviewing)) {
                    action = null;
                }
                AudioCaptureReducer.Action.Reviewing reviewing = (AudioCaptureReducer.Action.Reviewing) action;
                if (reviewing != null) {
                    return reviewing.getAction();
                }
                return null;
            }
        }, new Function2<State, AudioReviewReducer.State, State>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$7
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final AudioCaptureReducer.State invoke(AudioCaptureReducer.State state, AudioReviewReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = audioCaptureReducer$build$5.invoke(state2);
                if (objInvoke != null) {
                    return (AudioCaptureReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.audiorecording.cpl.AudioCaptureReducer.State");
            }
        }, new Function1<AudioReviewReducer.Action, Action>() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$special$$inlined$ifCaseLet$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AudioCaptureReducer.Action invoke(AudioReviewReducer.Action action) {
                Object objInvoke = audioCaptureReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (AudioCaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.audiorecording.cpl.AudioCaptureReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AudioCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureModeState;", "<init>", "()V", "Initialize", "PermissionRequired", "Recording", "Review", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Initialize;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$PermissionRequired;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Recording;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Review;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State extends CaptureModeState {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Initialize;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialize extends State {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            private Initialize() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$PermissionRequired;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionRequired extends State {
            public static final int $stable = 0;
            public static final PermissionRequired INSTANCE = new PermissionRequired();

            private PermissionRequired() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Recording;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;", "state", "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;)V", "getState", "()Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Recording extends State implements Embedded<AudioRecordingReducer.State> {
            public static final int $stable = 8;
            private final AudioRecordingReducer.State state;

            public static /* synthetic */ Recording copy$default(Recording recording, AudioRecordingReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = recording.state;
                }
                return recording.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioRecordingReducer.State getAction() {
                return this.state;
            }

            public final Recording copy(AudioRecordingReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Recording(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Recording) && Intrinsics.areEqual(this.state, ((Recording) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Recording(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Recording(AudioRecordingReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final AudioRecordingReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State$Review;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;", "state", "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;)V", "getState", "()Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Review extends State implements Embedded<AudioReviewReducer.State> {
            public static final int $stable = 8;
            private final AudioReviewReducer.State state;

            public static /* synthetic */ Review copy$default(Review review, AudioReviewReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = review.state;
                }
                return review.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioReviewReducer.State getAction() {
                return this.state;
            }

            public final Review copy(AudioReviewReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Review(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Review) && Intrinsics.areEqual(this.state, ((Review) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Review(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Review(AudioReviewReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final AudioReviewReducer.State getState() {
                return this.state;
            }
        }
    }

    /* JADX INFO: compiled from: AudioCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "", "<init>", "()V", "Initialized", "CheckPermissions", "PermissionsGranted", "Recording", "Reviewing", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$CheckPermissions;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Initialized;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$PermissionsGranted;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Recording;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Reviewing;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Initialized;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialized extends Action {
            public static final int $stable = 0;
            public static final Initialized INSTANCE = new Initialized();

            private Initialized() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$CheckPermissions;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CheckPermissions extends Action {
            public static final int $stable = 0;
            public static final CheckPermissions INSTANCE = new CheckPermissions();

            private CheckPermissions() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$PermissionsGranted;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionsGranted extends Action {
            public static final int $stable = 0;
            public static final PermissionsGranted INSTANCE = new PermissionsGranted();

            private PermissionsGranted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Recording;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;)V", "getAction", "()Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Recording extends Action implements Embedded<AudioRecordingReducer.Action> {
            public static final int $stable = 0;
            private final AudioRecordingReducer.Action action;

            public static /* synthetic */ Recording copy$default(Recording recording, AudioRecordingReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = recording.action;
                }
                return recording.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioRecordingReducer.Action getAction() {
                return this.action;
            }

            public final Recording copy(AudioRecordingReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Recording(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Recording) && Intrinsics.areEqual(this.action, ((Recording) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Recording(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Recording(AudioRecordingReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AudioRecordingReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: AudioCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action$Reviewing;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;)V", "getAction", "()Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Reviewing extends Action implements Embedded<AudioReviewReducer.Action> {
            public static final int $stable = 0;
            private final AudioReviewReducer.Action action;

            public static /* synthetic */ Reviewing copy$default(Reviewing reviewing, AudioReviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = reviewing.action;
                }
                return reviewing.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioReviewReducer.Action getAction() {
                return this.action;
            }

            public final Reviewing copy(AudioReviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Reviewing(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Reviewing) && Intrinsics.areEqual(this.action, ((Reviewing) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Reviewing(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Reviewing(AudioReviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AudioReviewReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceAudioCapture(State state, Action action) {
        IRecordManager recordManager;
        List listEmptyList;
        LiveData<List<Double>> recordedSamples;
        List<Double> value;
        if (Intrinsics.areEqual(action, Action.CheckPermissions.INSTANCE)) {
            if (this.environment.getPermissionsHandler().areAllPermissionsGranted(CaptureMode.AUDIO.getRequiredPermissions())) {
                return new ReducerResult<>(state, new Effect(Action.PermissionsGranted.INSTANCE));
            }
            return new ReducerResult<>(State.PermissionRequired.INSTANCE, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.PermissionsGranted.INSTANCE)) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.Initialized.INSTANCE)) {
            if (this.environment.getAudioCaptureEnvironment().getRecordingFileManager().hasRecordedFile() && (recordManager = this.environment.getAudioCaptureEnvironment().getRecordManager()) != null && !recordManager.hasPendingRecording()) {
                IRecordManager recordManager2 = this.environment.getAudioCaptureEnvironment().getRecordManager();
                if (recordManager2 == null || (recordedSamples = recordManager2.getRecordedSamples()) == null || (value = recordedSamples.getValue()) == null || (listEmptyList = CollectionsKt.toList(value)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return new ReducerResult<>(new State.Review(new AudioReviewReducer.State(false, false, 0L, 0L, listEmptyList, this.environment.getAudioCaptureEnvironment().getRecordingFileManager().getRecordingFileUri(), null, 79, null)), null, 2, null);
            }
            return new ReducerResult<>(pendingRecordingState(), new Effect(new Action.Recording(AudioRecordingReducer.Action.ResumePendingRecording.INSTANCE)));
        }
        if (action instanceof Action.Recording) {
            if (Intrinsics.areEqual(((Action.Recording) action).getAction(), AudioRecordingReducer.Action.ReviewRecording.INSTANCE)) {
                Intrinsics.checkNotNull(state, "null cannot be cast to non-null type com.box.android.capture.audiorecording.cpl.AudioCaptureReducer.State.Recording");
                return new ReducerResult<>(new State.Review(new AudioReviewReducer.State(false, false, 0L, 0L, ((State.Recording) state).getState().getRecordedSamples(), this.environment.getAudioCaptureEnvironment().getRecordingFileManager().getRecordingFileUri(), null, 79, null)), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.Reviewing)) {
            throw new NoWhenBranchMatchedException();
        }
        AudioReviewReducer.Action action2 = ((Action.Reviewing) action).getAction();
        if (Intrinsics.areEqual(action2, AudioReviewReducer.Action.DiscardRecording.INSTANCE) || (action2 instanceof AudioReviewReducer.Action.UploadRecording)) {
            return new ReducerResult<>(new State.Recording(new AudioRecordingReducer.State(false, false, false, false, false, null, null, null, 255, null)), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$reduceAudioCapture$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$reduceAudioCapture$1", f = "AudioCaptureReducer.kt", i = {0, 0}, l = {124}, m = "invokeSuspend", n = {"env", "$i$a$-let-AudioCaptureReducer$reduceAudioCapture$1$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int I$0;
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AudioCaptureReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AudioCaptureEnvironment audioCaptureEnvironment = AudioCaptureReducer.this.environment.getAudioCaptureEnvironment();
                AudioCaptureReducer audioCaptureReducer = AudioCaptureReducer.this;
                Function1 function1 = new Function1() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$reduceAudioCapture$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AudioCaptureReducer.AnonymousClass1.invokeSuspend$lambda$0$0(audioCaptureEnvironment, (ServiceConnection) obj2);
                    }
                };
                this.L$0 = SpillingKt.nullOutSpilledVariable(audioCaptureEnvironment);
                this.I$0 = 0;
                this.label = 1;
                if (audioCaptureReducer.awaitServiceConnectionCallback(audioCaptureEnvironment, function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Action.Initialized.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(AudioCaptureEnvironment audioCaptureEnvironment, ServiceConnection serviceConnection) {
            audioCaptureEnvironment.getRecorderServiceManager().bindService(audioCaptureEnvironment.getApplication(), null, CaptureActivity.class, serviceConnection);
            return Unit.INSTANCE;
        }
    }

    private final State.Recording pendingRecordingState() {
        List listEmptyList;
        LiveData<List<Double>> recordedSamples;
        List<Double> value;
        boolean zHasRecordedFile = this.environment.getAudioCaptureEnvironment().getRecordingFileManager().hasRecordedFile();
        IRecordManager recordManager = this.environment.getAudioCaptureEnvironment().getRecordManager();
        boolean zIsRecording = recordManager != null ? recordManager.isRecording() : false;
        IRecordManager recordManager2 = this.environment.getAudioCaptureEnvironment().getRecordManager();
        if (recordManager2 == null || (recordedSamples = recordManager2.getRecordedSamples()) == null || (value = recordedSamples.getValue()) == null || (listEmptyList = CollectionsKt.toList(value)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new State.Recording(new AudioRecordingReducer.State(zHasRecordedFile, zIsRecording, false, false, false, listEmptyList, RecordingUtils.INSTANCE.parseElapsedTime(RecorderService.INSTANCE.getFileDuration(this.environment.getAudioCaptureEnvironment().getRecordingFileManager().getRecordingFile())), null, Token.SETCONST, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitServiceConnectionCallback(final AudioCaptureEnvironment audioCaptureEnvironment, Function1<? super ServiceConnection, Unit> function1, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        function1.invoke(new ServiceConnection() { // from class: com.box.android.capture.audiorecording.cpl.AudioCaptureReducer$awaitServiceConnectionCallback$2$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.checkNotNull(service, "null cannot be cast to non-null type com.box.android.capture.audiorecording.RecorderService.RecorderBinder");
                audioCaptureEnvironment.setRecordManager(((RecorderService.RecorderBinder) service).getRecordManager());
                cancellableContinuationImpl2.resume(Unit.INSTANCE, (Function1<? super Throwable, Unit>) null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
