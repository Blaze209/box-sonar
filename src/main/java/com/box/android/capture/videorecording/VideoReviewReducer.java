package com.box.android.capture.videorecording;

import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoReviewReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$State;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoReviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final CaptureEnvironment environment;

    public VideoReviewReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: VideoReviewReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$State;", "", "isDiscarding", "", "outputFile", "Ljava/io/File;", "<init>", "(ZLjava/io/File;)V", "()Z", "getOutputFile", "()Ljava/io/File;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean isDiscarding;
        private final File outputFile;

        public static /* synthetic */ State copy$default(State state, boolean z, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isDiscarding;
            }
            if ((i & 2) != 0) {
                file = state.outputFile;
            }
            return state.copy(z, file);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsDiscarding() {
            return this.isDiscarding;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final File getOutputFile() {
            return this.outputFile;
        }

        public final State copy(boolean isDiscarding, File outputFile) {
            return new State(isDiscarding, outputFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isDiscarding == state.isDiscarding && Intrinsics.areEqual(this.outputFile, state.outputFile);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isDiscarding) * 31;
            File file = this.outputFile;
            return iHashCode + (file == null ? 0 : file.hashCode());
        }

        public String toString() {
            return "State(isDiscarding=" + this.isDiscarding + ", outputFile=" + this.outputFile + ")";
        }

        public State(boolean z, File file) {
            this.isDiscarding = z;
            this.outputFile = file;
        }

        public final File getOutputFile() {
            return this.outputFile;
        }

        public final boolean isDiscarding() {
            return this.isDiscarding;
        }
    }

    /* JADX INFO: compiled from: VideoReviewReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "", "<init>", "()V", "TryDiscardRecording", "DiscardRecording", "KeepRecording", "PrepareRecording", "UploadRecording", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$DiscardRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$KeepRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$PrepareRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$TryDiscardRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$UploadRecording;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VideoReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$TryDiscardRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TryDiscardRecording extends Action {
            public static final int $stable = 0;
            public static final TryDiscardRecording INSTANCE = new TryDiscardRecording();

            private TryDiscardRecording() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: VideoReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$DiscardRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DiscardRecording extends Action {
            public static final int $stable = 0;
            public static final DiscardRecording INSTANCE = new DiscardRecording();

            private DiscardRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$KeepRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class KeepRecording extends Action {
            public static final int $stable = 0;
            public static final KeepRecording INSTANCE = new KeepRecording();

            private KeepRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoReviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$PrepareRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PrepareRecording extends Action {
            public static final int $stable = 0;
            public static final PrepareRecording INSTANCE = new PrepareRecording();

            private PrepareRecording() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoReviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/videorecording/VideoReviewReducer$Action$UploadRecording;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "recordedFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getRecordedFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.TryDiscardRecording) {
            return new ReducerResult<>(State.copy$default(state, true, null, 2, null), null, 2, null);
        }
        if (action instanceof Action.DiscardRecording) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, null)));
        }
        if (action instanceof Action.KeepRecording) {
            return new ReducerResult<>(State.copy$default(state, false, null, 2, null), null, 2, null);
        }
        if (action instanceof Action.PrepareRecording) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass2(null)));
        }
        if (!(action instanceof Action.UploadRecording)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoReviewReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoReviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoReviewReducer$reduce$1", f = "VideoReviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File outputFile = this.$state.getOutputFile();
            if (outputFile != null) {
                Boxing.boxBoolean(outputFile.delete());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.VideoReviewReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: VideoReviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.VideoReviewReducer$reduce$2", f = "VideoReviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoReviewReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Action.UploadRecording(VideoReviewReducer.this.environment.getVideoRecordingFileManager().prepareVideoRecording());
        }
    }
}
