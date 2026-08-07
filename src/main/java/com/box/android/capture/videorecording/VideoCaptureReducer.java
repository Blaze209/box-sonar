package com.box.android.capture.videorecording;

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
import com.box.android.domain.models.capture.FlashMode;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceVideoCapture", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "recordingState", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Recording;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoCaptureReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CaptureEnvironment environment;

    public VideoCaptureReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new VideoCaptureReducer$build$1(this));
        final VideoCaptureReducer$build$2 videoCaptureReducer$build$2 = VideoCaptureReducer$build$2.INSTANCE;
        final VideoCaptureReducer$build$3 videoCaptureReducer$build$3 = VideoCaptureReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new VideoRecordingReducer(environment), new Function1<State, VideoRecordingReducer.State>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$1
            @Override // kotlin.jvm.functions.Function1
            public final VideoRecordingReducer.State invoke(VideoCaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof VideoCaptureReducer.State.Recording)) {
                    it = null;
                }
                VideoCaptureReducer.State.Recording recording = (VideoCaptureReducer.State.Recording) it;
                if (recording != null) {
                    return recording.getRoute();
                }
                return null;
            }
        }, new Function1<Action, VideoRecordingReducer.Action>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$2
            @Override // kotlin.jvm.functions.Function1
            public final VideoRecordingReducer.Action invoke(VideoCaptureReducer.Action action) {
                if (!(action instanceof VideoCaptureReducer.Action.Recording)) {
                    action = null;
                }
                VideoCaptureReducer.Action.Recording recording = (VideoCaptureReducer.Action.Recording) action;
                if (recording != null) {
                    return recording.getRoute();
                }
                return null;
            }
        }, new Function2<State, VideoRecordingReducer.State, State>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final VideoCaptureReducer.State invoke(VideoCaptureReducer.State state, VideoRecordingReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = videoCaptureReducer$build$2.invoke(state2);
                if (objInvoke != null) {
                    return (VideoCaptureReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.videorecording.VideoCaptureReducer.State");
            }
        }, new Function1<VideoRecordingReducer.Action, Action>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoCaptureReducer.Action invoke(VideoRecordingReducer.Action action) {
                Object objInvoke = videoCaptureReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (VideoCaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.videorecording.VideoCaptureReducer.Action");
            }
        });
        final VideoCaptureReducer$build$5 videoCaptureReducer$build$5 = VideoCaptureReducer$build$5.INSTANCE;
        final VideoCaptureReducer$build$6 videoCaptureReducer$build$6 = VideoCaptureReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new VideoReviewReducer(environment), new Function1<State, VideoReviewReducer.State>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$5
            @Override // kotlin.jvm.functions.Function1
            public final VideoReviewReducer.State invoke(VideoCaptureReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof VideoCaptureReducer.State.Reviewing)) {
                    it = null;
                }
                VideoCaptureReducer.State.Reviewing reviewing = (VideoCaptureReducer.State.Reviewing) it;
                if (reviewing != null) {
                    return reviewing.getRoute();
                }
                return null;
            }
        }, new Function1<Action, VideoReviewReducer.Action>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$6
            @Override // kotlin.jvm.functions.Function1
            public final VideoReviewReducer.Action invoke(VideoCaptureReducer.Action action) {
                if (!(action instanceof VideoCaptureReducer.Action.Reviewing)) {
                    action = null;
                }
                VideoCaptureReducer.Action.Reviewing reviewing = (VideoCaptureReducer.Action.Reviewing) action;
                if (reviewing != null) {
                    return reviewing.getRoute();
                }
                return null;
            }
        }, new Function2<State, VideoReviewReducer.State, State>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$7
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final VideoCaptureReducer.State invoke(VideoCaptureReducer.State state, VideoReviewReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = videoCaptureReducer$build$5.invoke(state2);
                if (objInvoke != null) {
                    return (VideoCaptureReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.videorecording.VideoCaptureReducer.State");
            }
        }, new Function1<VideoReviewReducer.Action, Action>() { // from class: com.box.android.capture.videorecording.VideoCaptureReducer$special$$inlined$ifCaseLet$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoCaptureReducer.Action invoke(VideoReviewReducer.Action action) {
                Object objInvoke = videoCaptureReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (VideoCaptureReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.capture.videorecording.VideoCaptureReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: VideoCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureModeState;", "<init>", "()V", "Initializing", "PermissionsRequired", "Recording", "Reviewing", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Initializing;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$PermissionsRequired;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Recording;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Reviewing;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State extends CaptureModeState {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Initializing;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initializing extends State {
            public static final int $stable = 0;
            public static final Initializing INSTANCE = new Initializing();

            private Initializing() {
                super(null);
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$PermissionsRequired;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionsRequired extends State {
            public static final int $stable = 0;
            public static final PermissionsRequired INSTANCE = new PermissionsRequired();

            private PermissionsRequired() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Recording;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "state", "<init>", "(Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;)V", "getState", "()Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Recording extends State implements Embedded<VideoRecordingReducer.State> {
            public static final int $stable = 8;
            private final VideoRecordingReducer.State state;

            public static /* synthetic */ Recording copy$default(Recording recording, VideoRecordingReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = recording.state;
                }
                return recording.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoRecordingReducer.State getRoute() {
                return this.state;
            }

            public final Recording copy(VideoRecordingReducer.State state) {
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
            public Recording(VideoRecordingReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final VideoRecordingReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$State$Reviewing;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$State;", "state", "<init>", "(Lcom/box/android/capture/videorecording/VideoReviewReducer$State;)V", "getState", "()Lcom/box/android/capture/videorecording/VideoReviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Reviewing extends State implements Embedded<VideoReviewReducer.State> {
            public static final int $stable = 8;
            private final VideoReviewReducer.State state;

            public static /* synthetic */ Reviewing copy$default(Reviewing reviewing, VideoReviewReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = reviewing.state;
                }
                return reviewing.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoReviewReducer.State getRoute() {
                return this.state;
            }

            public final Reviewing copy(VideoReviewReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Reviewing(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Reviewing) && Intrinsics.areEqual(this.state, ((Reviewing) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Reviewing(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Reviewing(VideoReviewReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final VideoReviewReducer.State getState() {
                return this.state;
            }
        }
    }

    /* JADX INFO: compiled from: VideoCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "", "<init>", "()V", "CheckPermissions", "PermissionsGranted", "Recording", "Reviewing", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$CheckPermissions;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$PermissionsGranted;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$Recording;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$Reviewing;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$CheckPermissions;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CheckPermissions extends Action {
            public static final int $stable = 0;
            public static final CheckPermissions INSTANCE = new CheckPermissions();

            private CheckPermissions() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$PermissionsGranted;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionsGranted extends Action {
            public static final int $stable = 0;
            public static final PermissionsGranted INSTANCE = new PermissionsGranted();

            private PermissionsGranted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$Recording;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;)V", "getAction", "()Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Recording extends Action implements Embedded<VideoRecordingReducer.Action> {
            public static final int $stable = 0;
            private final VideoRecordingReducer.Action action;

            public static /* synthetic */ Recording copy$default(Recording recording, VideoRecordingReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = recording.action;
                }
                return recording.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoRecordingReducer.Action getRoute() {
                return this.action;
            }

            public final Recording copy(VideoRecordingReducer.Action action) {
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
            public Recording(VideoRecordingReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VideoRecordingReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: VideoCaptureReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action$Reviewing;", "Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;)V", "getAction", "()Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Reviewing extends Action implements Embedded<VideoReviewReducer.Action> {
            public static final int $stable = 0;
            private final VideoReviewReducer.Action action;

            public static /* synthetic */ Reviewing copy$default(Reviewing reviewing, VideoReviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = reviewing.action;
                }
                return reviewing.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoReviewReducer.Action getAction() {
                return this.action;
            }

            public final Reviewing copy(VideoReviewReducer.Action action) {
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
            public Reviewing(VideoReviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VideoReviewReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceVideoCapture(State state, Action action) {
        VideoRecordingReducer.State state2;
        if (action instanceof Action.CheckPermissions) {
            if (this.environment.getPermissionsHandler().areAllPermissionsGranted(CaptureMode.VIDEO.getRequiredPermissions())) {
                return new ReducerResult<>(state, new Effect(Action.PermissionsGranted.INSTANCE));
            }
            return new ReducerResult<>(State.PermissionsRequired.INSTANCE, null, 2, null);
        }
        if (action instanceof Action.PermissionsGranted) {
            if (this.environment.getVideoRecordingFileManager().hasRecordedFile()) {
                return new ReducerResult<>(new State.Reviewing(new VideoReviewReducer.State(false, this.environment.getVideoRecordingFileManager().getRecordingFile())), null, 2, null);
            }
            return new ReducerResult<>(recordingState(), null, 2, null);
        }
        if (action instanceof Action.Recording) {
            if (((Action.Recording) action).getAction() instanceof VideoRecordingReducer.Action.ReviewRecording) {
                State.Recording recording = state instanceof State.Recording ? (State.Recording) state : null;
                return new ReducerResult<>(new State.Reviewing(new VideoReviewReducer.State(false, (recording == null || (state2 = recording.getState()) == null) ? null : state2.getOutputFile())), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.Reviewing)) {
            throw new NoWhenBranchMatchedException();
        }
        VideoReviewReducer.Action action2 = ((Action.Reviewing) action).getAction();
        if ((action2 instanceof VideoReviewReducer.Action.DiscardRecording) || (action2 instanceof VideoReviewReducer.Action.UploadRecording)) {
            return new ReducerResult<>(recordingState(), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final State.Recording recordingState() {
        return new State.Recording(new VideoRecordingReducer.State(this.environment.getCapturePreferencesService().getFlashModeOrDefaultVideo(FlashMode.OFF), this.environment.getCameraSession().getCameraSelector(), this.environment.getCapturePreferencesService().getVideoQuality(), false, null, RecordingUtils.INSTANCE.parseElapsedTime(0L), null));
    }
}
