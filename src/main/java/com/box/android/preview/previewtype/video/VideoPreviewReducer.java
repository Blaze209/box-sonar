package com.box.android.preview.previewtype.video;

import androidx.media3.effect.DebugTraceUtil;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.item.LoadingPlaceholder;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.net.URI;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: VideoPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/video/VideoPreviewEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceVideoPreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleObserve", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoPreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final VideoPreviewEnvironment environment;

    /* JADX INFO: compiled from: VideoPreviewReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006'"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "url", "Ljava/net/URI;", "seekPosition", "", "loadingPlaceholder", "Lcom/box/android/preview/item/LoadingPlaceholder;", "frameAnnotationState", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;JLcom/box/android/preview/item/LoadingPlaceholder;Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getUrl", "()Ljava/net/URI;", "getSeekPosition", "()J", "getLoadingPlaceholder", "()Lcom/box/android/preview/item/LoadingPlaceholder;", "getFrameAnnotationState", "()Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;", "isLoaded", "", "()Z", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final FileModel file;
        private final FrameAnnotationReducer.State frameAnnotationState;
        private final LoadingPlaceholder loadingPlaceholder;
        private final long seekPosition;
        private final URI url;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, long j, LoadingPlaceholder loadingPlaceholder, FrameAnnotationReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.file;
            }
            if ((i & 2) != 0) {
                uri = state.url;
            }
            if ((i & 4) != 0) {
                j = state.seekPosition;
            }
            if ((i & 8) != 0) {
                loadingPlaceholder = state.loadingPlaceholder;
            }
            if ((i & 16) != 0) {
                state2 = state.frameAnnotationState;
            }
            long j2 = j;
            return state.copy(fileModel, uri, j2, loadingPlaceholder, state2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URI getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getSeekPosition() {
            return this.seekPosition;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FrameAnnotationReducer.State getFrameAnnotationState() {
            return this.frameAnnotationState;
        }

        public final State copy(FileModel file, URI url, long seekPosition, LoadingPlaceholder loadingPlaceholder, FrameAnnotationReducer.State frameAnnotationState) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(frameAnnotationState, "frameAnnotationState");
            return new State(file, url, seekPosition, loadingPlaceholder, frameAnnotationState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.url, state.url) && this.seekPosition == state.seekPosition && Intrinsics.areEqual(this.loadingPlaceholder, state.loadingPlaceholder) && Intrinsics.areEqual(this.frameAnnotationState, state.frameAnnotationState);
        }

        public int hashCode() {
            int iHashCode = ((((this.file.hashCode() * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.seekPosition)) * 31;
            LoadingPlaceholder loadingPlaceholder = this.loadingPlaceholder;
            return ((iHashCode + (loadingPlaceholder == null ? 0 : loadingPlaceholder.hashCode())) * 31) + this.frameAnnotationState.hashCode();
        }

        public String toString() {
            return "State(file=" + this.file + ", url=" + this.url + ", seekPosition=" + this.seekPosition + ", loadingPlaceholder=" + this.loadingPlaceholder + ", frameAnnotationState=" + this.frameAnnotationState + ")";
        }

        public State(FileModel file, URI url, long j, LoadingPlaceholder loadingPlaceholder, FrameAnnotationReducer.State frameAnnotationState) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(frameAnnotationState, "frameAnnotationState");
            this.file = file;
            this.url = url;
            this.seekPosition = j;
            this.loadingPlaceholder = loadingPlaceholder;
            this.frameAnnotationState = frameAnnotationState;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final URI getUrl() {
            return this.url;
        }

        public final long getSeekPosition() {
            return this.seekPosition;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileModel fileModel, URI uri, long j, LoadingPlaceholder loadingPlaceholder, FrameAnnotationReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            LoadingPlaceholder loadingPlaceholder2;
            long j2 = (i & 4) != 0 ? 0L : j;
            if ((i & 8) != 0) {
                loadingPlaceholder2 = new LoadingPlaceholder(FileTypeIcon.DEFAULT, null, 2, 0 == true ? 1 : 0);
            } else {
                loadingPlaceholder2 = loadingPlaceholder;
            }
            this(fileModel, uri, j2, loadingPlaceholder2, (i & 16) != 0 ? new FrameAnnotationReducer.State(fileModel, null, null, null, false, null, 62, null) : state);
        }

        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        public final FrameAnnotationReducer.State getFrameAnnotationState() {
            return this.frameAnnotationState;
        }

        public final boolean isLoaded() {
            return this.loadingPlaceholder == null;
        }
    }

    public VideoPreviewReducer(VideoPreviewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new VideoPreviewReducer$build$1(this));
        final VideoPreviewReducer$build$2 videoPreviewReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((VideoPreviewReducer.State) obj).getFrameAnnotationState();
            }
        };
        final VideoPreviewReducer$build$3 videoPreviewReducer$build$3 = VideoPreviewReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new FrameAnnotationReducer(environment.getFrameAnnotationEnvironment()), new Function1<State, FrameAnnotationReducer.State>() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.previewtype.video.FrameAnnotationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final FrameAnnotationReducer.State invoke(VideoPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return videoPreviewReducer$build$2.invoke(it);
            }
        }, new Function1<Action, FrameAnnotationReducer.Action>() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final FrameAnnotationReducer.Action invoke(VideoPreviewReducer.Action action) {
                if (!(action instanceof VideoPreviewReducer.Action.FrameAnnotation)) {
                    action = null;
                }
                VideoPreviewReducer.Action.FrameAnnotation frameAnnotation = (VideoPreviewReducer.Action.FrameAnnotation) action;
                if (frameAnnotation != null) {
                    return frameAnnotation.getItem();
                }
                return null;
            }
        }, new Function2<State, FrameAnnotationReducer.State, State>() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final VideoPreviewReducer.State invoke(VideoPreviewReducer.State parentState, FrameAnnotationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = videoPreviewReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(VideoPreviewReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (VideoPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.VideoPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<FrameAnnotationReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoPreviewReducer.Action invoke(FrameAnnotationReducer.Action action) {
                Object objInvoke = videoPreviewReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (VideoPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.VideoPreviewReducer.Action");
            }
        });
    }

    public final VideoPreviewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: VideoPreviewReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "", "<init>", "()V", "Observe", "Error", DebugTraceUtil.EVENT_SEEK_TO, "PauseVideo", "SaveSeekPosition", "VideoClicked", "VideoLoaded", "EnterAnnotationCreation", "FrameAnnotation", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$FrameAnnotation;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$Observe;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$PauseVideo;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$SaveSeekPosition;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$SeekTo;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$VideoClicked;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$VideoLoaded;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$Observe;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Observe extends Action {
            public static final int $stable = 0;
            public static final Observe INSTANCE = new Observe();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Observe)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 530991207;
            }

            public String toString() {
                return "Observe";
            }

            private Observe() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$SeekTo;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", ViewProps.POSITION, "", "<init>", "(J)V", "getPosition", "()J", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SeekTo extends Action {
            public static final int $stable = 0;
            private final long position;

            public static /* synthetic */ SeekTo copy$default(SeekTo seekTo, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = seekTo.position;
                }
                return seekTo.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getPosition() {
                return this.position;
            }

            public final SeekTo copy(long position) {
                return new SeekTo(position);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SeekTo) && this.position == ((SeekTo) other).position;
            }

            public int hashCode() {
                return Long.hashCode(this.position);
            }

            public String toString() {
                return "SeekTo(position=" + this.position + ")";
            }

            public SeekTo(long j) {
                super(null);
                this.position = j;
            }

            public final long getPosition() {
                return this.position;
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$PauseVideo;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PauseVideo extends Action {
            public static final int $stable = 0;
            public static final PauseVideo INSTANCE = new PauseVideo();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PauseVideo)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 334727418;
            }

            public String toString() {
                return "PauseVideo";
            }

            private PauseVideo() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$SaveSeekPosition;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveSeekPosition extends Action {
            public static final int $stable = 0;
            public static final SaveSeekPosition INSTANCE = new SaveSeekPosition();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SaveSeekPosition)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 902898419;
            }

            public String toString() {
                return "SaveSeekPosition";
            }

            private SaveSeekPosition() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$VideoClicked;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class VideoClicked extends Action {
            public static final int $stable = 0;
            public static final VideoClicked INSTANCE = new VideoClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VideoClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1929411903;
            }

            public String toString() {
                return "VideoClicked";
            }

            private VideoClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$VideoLoaded;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class VideoLoaded extends Action {
            public static final int $stable = 0;
            public static final VideoLoaded INSTANCE = new VideoLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VideoLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 59408939;
            }

            public String toString() {
                return "VideoLoaded";
            }

            private VideoLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EnterAnnotationCreation extends Action {
            public static final int $stable = 0;
            public static final EnterAnnotationCreation INSTANCE = new EnterAnnotationCreation();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnterAnnotationCreation)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 570318193;
            }

            public String toString() {
                return "EnterAnnotationCreation";
            }

            private EnterAnnotationCreation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: VideoPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action$FrameAnnotation;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FrameAnnotation extends Action implements Embedded<FrameAnnotationReducer.Action> {
            public static final int $stable = 0;
            private final FrameAnnotationReducer.Action action;

            public static /* synthetic */ FrameAnnotation copy$default(FrameAnnotation frameAnnotation, FrameAnnotationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = frameAnnotation.action;
                }
                return frameAnnotation.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FrameAnnotationReducer.Action getItem() {
                return this.action;
            }

            public final FrameAnnotation copy(FrameAnnotationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FrameAnnotation(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FrameAnnotation) && Intrinsics.areEqual(this.action, ((FrameAnnotation) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FrameAnnotation(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FrameAnnotation(FrameAnnotationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FrameAnnotationReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceVideoPreview(State state, Action action) {
        if (action instanceof Action.Observe) {
            return handleObserve(state);
        }
        if (!(action instanceof Action.Error) && !(action instanceof Action.VideoClicked)) {
            if (action instanceof Action.VideoLoaded) {
                return new ReducerResult<>(State.copy$default(state, null, null, 0L, null, null, 23, null), null, 2, null);
            }
            if (action instanceof Action.PauseVideo) {
                return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass1(state, null)));
            }
            if (action instanceof Action.SeekTo) {
                return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass2(state, action, null)));
            }
            if (action instanceof Action.SaveSeekPosition) {
                return new ReducerResult<>(State.copy$default(state, null, null, this.environment.getVideoPlayerInteractor().getCurrentPosition(state.getFile().getItemId()), null, null, 27, null), null, 2, null);
            }
            if (action instanceof Action.EnterAnnotationCreation) {
                return new ReducerResult<>(state, Effect.INSTANCE.merge(Action.PauseVideo.INSTANCE, new Action.FrameAnnotation(FrameAnnotationReducer.Action.EnterAnnotationCreation.INSTANCE)));
            }
            if (action instanceof Action.FrameAnnotation) {
                return new ReducerResult<>(state, null, 2, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.VideoPreviewReducer$reduceVideoPreview$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.VideoPreviewReducer$reduceVideoPreview$1", f = "VideoPreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoPreviewReducer.this.new AnonymousClass1(this.$state, continuation);
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
            VideoPreviewReducer.this.getEnvironment().getVideoPlayerInteractor().pauseVideo(this.$state.getFile().getItemId());
            return Action.SaveSeekPosition.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.VideoPreviewReducer$reduceVideoPreview$2, reason: invalid class name */
    /* JADX INFO: compiled from: VideoPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.VideoPreviewReducer$reduceVideoPreview$2", f = "VideoPreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoPreviewReducer.this.new AnonymousClass2(this.$state, this.$action, continuation);
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
            VideoPreviewReducer.this.getEnvironment().getVideoPlayerInteractor().seekTo(this.$state.getFile().getItemId(), ((Action.SeekTo) this.$action).getPosition());
            return new Action.FrameAnnotation(FrameAnnotationReducer.Action.Release.INSTANCE);
        }
    }

    private final ReducerResult<State, Action> handleObserve(State state) {
        final Flow<PlayerState> flowObservePlayer = this.environment.getVideoPlayerInteractor().observePlayer(state.getFile().getItemId());
        return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.preview.previewtype.video.VideoPreviewReducer$handleObserve$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.VideoPreviewReducer$handleObserve$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.VideoPreviewReducer$handleObserve$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.preview.previewtype.video.VideoPreviewReducer$handleObserve$$inlined$map$1$2", f = "VideoPreviewReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                /* JADX WARN: Multi-variable type inference failed */
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
                    Object obj2;
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
                    Object obj3 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj3);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        PlayerState playerState = (PlayerState) obj;
                        if (playerState instanceof PlayerState.NetworkError) {
                            obj2 = (VideoPreviewReducer.Action) new VideoPreviewReducer.Action.Error(new DomainError.NetworkError(null, 1, null));
                        } else if (playerState instanceof PlayerState.VideoPlayError) {
                            obj2 = (VideoPreviewReducer.Action) new VideoPreviewReducer.Action.Error(((PlayerState.VideoPlayError) playerState).getDomainError());
                        } else {
                            if (!(playerState instanceof PlayerState.Ready)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            obj2 = (VideoPreviewReducer.Action) VideoPreviewReducer.Action.VideoLoaded.INSTANCE;
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj4 = anonymousClass1.L$2;
                        Object obj5 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj3);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super VideoPreviewReducer.Action> flowCollector, Continuation continuation) {
                Object objCollect = flowObservePlayer.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }));
    }
}
