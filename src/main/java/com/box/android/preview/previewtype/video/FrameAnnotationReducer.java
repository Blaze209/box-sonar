package com.box.android.preview.previewtype.video;

import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.AnnotationsReducerKt;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducerKt;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FrameAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/video/FrameAnnotationEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceFrameAnnotation", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "enterAnnotationCreation", "handleFetch", "handleDisplayAnnotation", "annotationId", "", "documentSize", "Lcom/box/android/preview/annotations/model/DocumentSize;", "Companion", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameAnnotationReducer implements Reducable<State, Action> {
    public static final String EXPORT_FRAME_KEY = "ExportFrameKey";
    private final Reducable<State, Action> build;
    private final FrameAnnotationEnvironment environment;
    public static final int $stable = 8;

    public FrameAnnotationReducer(FrameAnnotationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new FrameAnnotationReducer$build$1(this));
        final FrameAnnotationReducer$build$2 frameAnnotationReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FrameAnnotationReducer.State) obj).getCreateAnnotationState();
            }
        };
        final FrameAnnotationReducer$build$3 frameAnnotationReducer$build$3 = FrameAnnotationReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new CreateAnnotationReducer(environment.getCreateAnnotationEnvironment()), new Function1<State, CreateAnnotationReducer.State>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.CreateAnnotationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.State invoke(FrameAnnotationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return frameAnnotationReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CreateAnnotationReducer.Action>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.Action invoke(FrameAnnotationReducer.Action action) {
                if (!(action instanceof FrameAnnotationReducer.Action.CreateAnnotation)) {
                    action = null;
                }
                FrameAnnotationReducer.Action.CreateAnnotation createAnnotation = (FrameAnnotationReducer.Action.CreateAnnotation) action;
                if (createAnnotation != null) {
                    return createAnnotation.getCreateFolderAction();
                }
                return null;
            }
        }, new Function2<State, CreateAnnotationReducer.State, State>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FrameAnnotationReducer.State invoke(FrameAnnotationReducer.State parentState, CreateAnnotationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = frameAnnotationReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FrameAnnotationReducer.State.class)).iterator();
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
                            return (FrameAnnotationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.FrameAnnotationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateAnnotationReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FrameAnnotationReducer.Action invoke(CreateAnnotationReducer.Action action) {
                Object objInvoke = frameAnnotationReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (FrameAnnotationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.FrameAnnotationReducer.Action");
            }
        });
        final FrameAnnotationReducer$build$5 frameAnnotationReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FrameAnnotationReducer.State) obj).getAnnotationsState();
            }
        };
        final FrameAnnotationReducer$build$6 frameAnnotationReducer$build$6 = FrameAnnotationReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new AnnotationsReducer(environment.getAnnotationsEnvironment()), new Function1<State, AnnotationsReducer.State>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.AnnotationsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.State invoke(FrameAnnotationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return frameAnnotationReducer$build$5.invoke(it);
            }
        }, new Function1<Action, AnnotationsReducer.Action>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.Action invoke(FrameAnnotationReducer.Action action) {
                if (!(action instanceof FrameAnnotationReducer.Action.Annotations)) {
                    action = null;
                }
                FrameAnnotationReducer.Action.Annotations annotations = (FrameAnnotationReducer.Action.Annotations) action;
                if (annotations != null) {
                    return annotations.getCreateFolderAction();
                }
                return null;
            }
        }, new Function2<State, AnnotationsReducer.State, State>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final FrameAnnotationReducer.State invoke(FrameAnnotationReducer.State parentState, AnnotationsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = frameAnnotationReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(FrameAnnotationReducer.State.class)).iterator();
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
                            return (FrameAnnotationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.FrameAnnotationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AnnotationsReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.video.FrameAnnotationReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FrameAnnotationReducer.Action invoke(AnnotationsReducer.Action action) {
                Object objInvoke = frameAnnotationReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (FrameAnnotationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.video.FrameAnnotationReducer.Action");
            }
        });
    }

    public final FrameAnnotationEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "exportedFrameUri", "Ljava/net/URI;", "createAnnotationState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "annotationsState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "isExportingFrame", "", "annotations", "", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;ZLjava/util/List;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getExportedFrameUri", "()Ljava/net/URI;", "getCreateAnnotationState", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "getAnnotationsState", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "()Z", "getAnnotations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<FileActivityModel.AnnotationModel> annotations;
        private final AnnotationsReducer.State annotationsState;
        private final CreateAnnotationReducer.State createAnnotationState;
        private final URI exportedFrameUri;
        private final FileModel file;
        private final boolean isExportingFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, CreateAnnotationReducer.State state2, AnnotationsReducer.State state3, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.file;
            }
            if ((i & 2) != 0) {
                uri = state.exportedFrameUri;
            }
            if ((i & 4) != 0) {
                state2 = state.createAnnotationState;
            }
            if ((i & 8) != 0) {
                state3 = state.annotationsState;
            }
            if ((i & 16) != 0) {
                z = state.isExportingFrame;
            }
            if ((i & 32) != 0) {
                list = state.annotations;
            }
            boolean z2 = z;
            List list2 = list;
            return state.copy(fileModel, uri, state2, state3, z2, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URI getExportedFrameUri() {
            return this.exportedFrameUri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsExportingFrame() {
            return this.isExportingFrame;
        }

        public final List<FileActivityModel.AnnotationModel> component6() {
            return this.annotations;
        }

        public final State copy(FileModel file, URI exportedFrameUri, CreateAnnotationReducer.State createAnnotationState, AnnotationsReducer.State annotationsState, boolean isExportingFrame, List<FileActivityModel.AnnotationModel> annotations) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            return new State(file, exportedFrameUri, createAnnotationState, annotationsState, isExportingFrame, annotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.exportedFrameUri, state.exportedFrameUri) && Intrinsics.areEqual(this.createAnnotationState, state.createAnnotationState) && Intrinsics.areEqual(this.annotationsState, state.annotationsState) && this.isExportingFrame == state.isExportingFrame && Intrinsics.areEqual(this.annotations, state.annotations);
        }

        public int hashCode() {
            int iHashCode = this.file.hashCode() * 31;
            URI uri = this.exportedFrameUri;
            int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
            CreateAnnotationReducer.State state = this.createAnnotationState;
            int iHashCode3 = (iHashCode2 + (state == null ? 0 : state.hashCode())) * 31;
            AnnotationsReducer.State state2 = this.annotationsState;
            return ((((iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isExportingFrame)) * 31) + this.annotations.hashCode();
        }

        public String toString() {
            return "State(file=" + this.file + ", exportedFrameUri=" + this.exportedFrameUri + ", createAnnotationState=" + this.createAnnotationState + ", annotationsState=" + this.annotationsState + ", isExportingFrame=" + this.isExportingFrame + ", annotations=" + this.annotations + ")";
        }

        public State(FileModel file, URI uri, CreateAnnotationReducer.State state, AnnotationsReducer.State state2, boolean z, List<FileActivityModel.AnnotationModel> annotations) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            this.file = file;
            this.exportedFrameUri = uri;
            this.createAnnotationState = state;
            this.annotationsState = state2;
            this.isExportingFrame = z;
            this.annotations = annotations;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final URI getExportedFrameUri() {
            return this.exportedFrameUri;
        }

        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        public final boolean isExportingFrame() {
            return this.isExportingFrame;
        }

        public /* synthetic */ State(FileModel fileModel, URI uri, CreateAnnotationReducer.State state, AnnotationsReducer.State state2, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, (i & 2) != 0 ? null : uri, (i & 4) != 0 ? null : state, (i & 8) != 0 ? null : state2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<FileActivityModel.AnnotationModel> getAnnotations() {
            return this.annotations;
        }
    }

    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "", "<init>", "()V", "HandleEnqueuedAnnotation", "ExportFrame", "FrameExported", "EnterAnnotationCreation", "CreateAnnotation", "UpdateAnnotations", "FetchAnnotations", "Annotations", "DisplayAnnotation", DebugTraceUtil.EVENT_RELEASE, "Error", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$DisplayAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Error;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$ExportFrame;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$FetchAnnotations;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$FrameExported;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$HandleEnqueuedAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Release;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$UpdateAnnotations;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$HandleEnqueuedAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "activityId", "", "<init>", "(Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandleEnqueuedAnnotation extends Action {
            public static final int $stable = 0;
            private final String activityId;

            public static /* synthetic */ HandleEnqueuedAnnotation copy$default(HandleEnqueuedAnnotation handleEnqueuedAnnotation, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = handleEnqueuedAnnotation.activityId;
                }
                return handleEnqueuedAnnotation.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getActivityId() {
                return this.activityId;
            }

            public final HandleEnqueuedAnnotation copy(String activityId) {
                Intrinsics.checkNotNullParameter(activityId, "activityId");
                return new HandleEnqueuedAnnotation(activityId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HandleEnqueuedAnnotation) && Intrinsics.areEqual(this.activityId, ((HandleEnqueuedAnnotation) other).activityId);
            }

            public int hashCode() {
                return this.activityId.hashCode();
            }

            public String toString() {
                return "HandleEnqueuedAnnotation(activityId=" + this.activityId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleEnqueuedAnnotation(String activityId) {
                super(null);
                Intrinsics.checkNotNullParameter(activityId, "activityId");
                this.activityId = activityId;
            }

            public final String getActivityId() {
                return this.activityId;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$ExportFrame;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExportFrame extends Action {
            public static final int $stable = 0;
            public static final ExportFrame INSTANCE = new ExportFrame();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExportFrame)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 374596971;
            }

            public String toString() {
                return "ExportFrame";
            }

            private ExportFrame() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$FrameExported;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "uri", "Ljava/net/URI;", "<init>", "(Ljava/net/URI;)V", "getUri", "()Ljava/net/URI;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FrameExported extends Action {
            public static final int $stable = 8;
            private final URI uri;

            public static /* synthetic */ FrameExported copy$default(FrameExported frameExported, URI uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = frameExported.uri;
                }
                return frameExported.copy(uri);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final URI getUri() {
                return this.uri;
            }

            public final FrameExported copy(URI uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new FrameExported(uri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FrameExported) && Intrinsics.areEqual(this.uri, ((FrameExported) other).uri);
            }

            public int hashCode() {
                return this.uri.hashCode();
            }

            public String toString() {
                return "FrameExported(uri=" + this.uri + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FrameExported(URI uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
            }

            public final URI getUri() {
                return this.uri;
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -463503240;
            }

            public String toString() {
                return "EnterAnnotationCreation";
            }

            private EnterAnnotationCreation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateAnnotation extends Action implements Embedded<CreateAnnotationReducer.Action> {
            public static final int $stable = 0;
            private final CreateAnnotationReducer.Action action;

            public static /* synthetic */ CreateAnnotation copy$default(CreateAnnotation createAnnotation, CreateAnnotationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = createAnnotation.action;
                }
                return createAnnotation.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CreateAnnotationReducer.Action getCreateFolderAction() {
                return this.action;
            }

            public final CreateAnnotation copy(CreateAnnotationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CreateAnnotation(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateAnnotation) && Intrinsics.areEqual(this.action, ((CreateAnnotation) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CreateAnnotation(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateAnnotation(CreateAnnotationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CreateAnnotationReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$UpdateAnnotations;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "annotations", "", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "<init>", "(Ljava/util/List;)V", "getAnnotations", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateAnnotations extends Action {
            public static final int $stable = 8;
            private final List<FileActivityModel.AnnotationModel> annotations;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateAnnotations copy$default(UpdateAnnotations updateAnnotations, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = updateAnnotations.annotations;
                }
                return updateAnnotations.copy(list);
            }

            public final List<FileActivityModel.AnnotationModel> component1() {
                return this.annotations;
            }

            public final UpdateAnnotations copy(List<FileActivityModel.AnnotationModel> annotations) {
                Intrinsics.checkNotNullParameter(annotations, "annotations");
                return new UpdateAnnotations(annotations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateAnnotations) && Intrinsics.areEqual(this.annotations, ((UpdateAnnotations) other).annotations);
            }

            public int hashCode() {
                return this.annotations.hashCode();
            }

            public String toString() {
                return "UpdateAnnotations(annotations=" + this.annotations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAnnotations(List<FileActivityModel.AnnotationModel> annotations) {
                super(null);
                Intrinsics.checkNotNullParameter(annotations, "annotations");
                this.annotations = annotations;
            }

            public final List<FileActivityModel.AnnotationModel> getAnnotations() {
                return this.annotations;
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$FetchAnnotations;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchAnnotations extends Action {
            public static final int $stable = 0;
            public static final FetchAnnotations INSTANCE = new FetchAnnotations();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchAnnotations)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -171296776;
            }

            public String toString() {
                return "FetchAnnotations";
            }

            private FetchAnnotations() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Annotations extends Action implements Embedded<AnnotationsReducer.Action> {
            public static final int $stable = 0;
            private final AnnotationsReducer.Action action;

            public static /* synthetic */ Annotations copy$default(Annotations annotations, AnnotationsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = annotations.action;
                }
                return annotations.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AnnotationsReducer.Action getCreateFolderAction() {
                return this.action;
            }

            public final Annotations copy(AnnotationsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Annotations(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Annotations) && Intrinsics.areEqual(this.action, ((Annotations) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Annotations(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Annotations(AnnotationsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AnnotationsReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$DisplayAnnotation;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "annotationId", "", "documentSizes", "Lcom/box/android/preview/annotations/model/DocumentSize;", "<init>", "(Ljava/lang/String;Lcom/box/android/preview/annotations/model/DocumentSize;)V", "getAnnotationId", "()Ljava/lang/String;", "getDocumentSizes", "()Lcom/box/android/preview/annotations/model/DocumentSize;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DisplayAnnotation extends Action {
            public static final int $stable = 0;
            private final String annotationId;
            private final DocumentSize documentSizes;

            public static /* synthetic */ DisplayAnnotation copy$default(DisplayAnnotation displayAnnotation, String str, DocumentSize documentSize, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = displayAnnotation.annotationId;
                }
                if ((i & 2) != 0) {
                    documentSize = displayAnnotation.documentSizes;
                }
                return displayAnnotation.copy(str, documentSize);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAnnotationId() {
                return this.annotationId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DocumentSize getDocumentSizes() {
                return this.documentSizes;
            }

            public final DisplayAnnotation copy(String annotationId, DocumentSize documentSizes) {
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                return new DisplayAnnotation(annotationId, documentSizes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DisplayAnnotation)) {
                    return false;
                }
                DisplayAnnotation displayAnnotation = (DisplayAnnotation) other;
                return Intrinsics.areEqual(this.annotationId, displayAnnotation.annotationId) && Intrinsics.areEqual(this.documentSizes, displayAnnotation.documentSizes);
            }

            public int hashCode() {
                return (this.annotationId.hashCode() * 31) + this.documentSizes.hashCode();
            }

            public String toString() {
                return "DisplayAnnotation(annotationId=" + this.annotationId + ", documentSizes=" + this.documentSizes + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DisplayAnnotation(String annotationId, DocumentSize documentSizes) {
                super(null);
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                this.annotationId = annotationId;
                this.documentSizes = documentSizes;
            }

            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final DocumentSize getDocumentSizes() {
                return this.documentSizes;
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Release;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Release extends Action {
            public static final int $stable = 0;
            public static final Release INSTANCE = new Release();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Release)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -988630951;
            }

            public String toString() {
                return DebugTraceUtil.EVENT_RELEASE;
            }

            private Release() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$Error;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceFrameAnnotation(State state, Action action) {
        Object next;
        if (action instanceof Action.ExportFrame) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, true, null, 47, null), new Effect((Function1) new C17081(state, null)).cancellable(EXPORT_FRAME_KEY, true));
        }
        if (action instanceof Action.FrameExported) {
            return new ReducerResult<>(State.copy$default(state, null, ((Action.FrameExported) action).getUri(), null, null, false, null, 45, null), null, 2, null);
        }
        if (action instanceof Action.EnterAnnotationCreation) {
            return enterAnnotationCreation(state);
        }
        if (action instanceof Action.CreateAnnotation) {
            if (Intrinsics.areEqual(((Action.CreateAnnotation) action).getAction(), CreateAnnotationReducer.Action.Exit.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, 57, null), Effect.INSTANCE.cancel(EXPORT_FRAME_KEY));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.HandleEnqueuedAnnotation)) {
            if (action instanceof Action.UpdateAnnotations) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, ((Action.UpdateAnnotations) action).getAnnotations(), 31, null), null, 2, null);
            }
            if (action instanceof Action.FetchAnnotations) {
                return handleFetch(state);
            }
            if (action instanceof Action.Annotations) {
                Action.Annotations annotations = (Action.Annotations) action;
                if ((annotations.getAction() instanceof AnnotationsReducer.Action.AnnotationDeletionCompleted) && ((AnnotationsReducer.Action.AnnotationDeletionCompleted) annotations.getAction()).isSuccess()) {
                    return new ReducerResult<>(state, new Effect(Action.Release.INSTANCE));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action instanceof Action.DisplayAnnotation) {
                Action.DisplayAnnotation displayAnnotation = (Action.DisplayAnnotation) action;
                return handleDisplayAnnotation(state, displayAnnotation.getAnnotationId(), displayAnnotation.getDocumentSizes());
            }
            if (action instanceof Action.Error) {
                BoxLogUtils.e("FrameAnnotationReducer error: " + ((Action.Error) action).getError());
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, 47, null), new Effect(new Action.CreateAnnotation(CreateAnnotationReducer.Action.Exit.INSTANCE)));
            }
            if (!(action instanceof Action.Release)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, 57, null), Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)));
        }
        Iterator<T> it = state.getAnnotations().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((FileActivityModel.AnnotationModel) next).getId(), ((Action.HandleEnqueuedAnnotation) action).getActivityId()));
        FileActivityModel.AnnotationModel annotationModel = (FileActivityModel.AnnotationModel) next;
        AnnotationLocationModel location = annotationModel != null ? annotationModel.getLocation() : null;
        AnnotationLocationModel.Frame frame = location instanceof AnnotationLocationModel.Frame ? (AnnotationLocationModel.Frame) location : null;
        if (frame == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        this.environment.getVideoPlayersInteractor().seekTo(state.getFile().getItemId(), frame.getFrameTimestampMs());
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, 61, null), new Effect(Action.ExportFrame.INSTANCE));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameAnnotationReducer$reduceFrameAnnotation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameAnnotationReducer$reduceFrameAnnotation$1", f = "FrameAnnotationReducer.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17081 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17081(State state, Continuation<? super C17081> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FrameAnnotationReducer.this.new C17081(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C17081) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FrameAnnotationReducer.this.getEnvironment().getFrameExporter().exportCurrentFrame(this.$state.getFile(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            URI uri = (URI) obj;
            if (uri != null) {
                return new Action.FrameExported(uri);
            }
            return new Action.Error(new DomainError.CustomError("Failed to export frame"));
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameAnnotationReducer$reduceFrameAnnotation$2, reason: invalid class name */
    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameAnnotationReducer$reduceFrameAnnotation$2", f = "FrameAnnotationReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FrameAnnotationReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FrameAnnotationReducer.this.getEnvironment().getCreateAnnotationEnvironment().getAnnotationManagersProvider().removeAnnotationManagers(this.$state.getFile().getItemId());
            return Unit.INSTANCE;
        }
    }

    public final ReducerResult<State, Action> enterAnnotationCreation(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getCreateAnnotationState() != null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (state.getExportedFrameUri() != null) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, true, null, 45, null), new Effect((Function1) new AnonymousClass1(null)));
        }
        BoxUser userInfo = this.environment.getUserContextManager().getUserInfo();
        long currentPosition = this.environment.getVideoPlayersInteractor().getCurrentPosition(state.getFile().getItemId());
        CreateAnnotationReducer.State.Companion companion = CreateAnnotationReducer.State.INSTANCE;
        FileModel file = state.getFile();
        Intrinsics.checkNotNull(userInfo);
        CreateAnnotationReducer.State stateCreateState = CreateAnnotationReducerKt.createState(companion, file, userInfo, CollectionsKt.emptyList(), new AnnotationLocationModel.Frame((int) currentPosition));
        if (stateCreateState != null) {
            return new ReducerResult<>(State.copy$default(state, null, null, stateCreateState, null, false, null, 59, null), new Effect(Action.ExportFrame.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameAnnotationReducer$enterAnnotationCreation$1, reason: invalid class name */
    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameAnnotationReducer$enterAnnotationCreation$1", f = "FrameAnnotationReducer.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
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
                this.label = 1;
                if (DelayKt.delay(250L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Action.EnterAnnotationCreation.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> handleFetch(State state) {
        String id;
        if (!this.environment.getAnnotationsEnvironment().getFeatureFlips().getVideoAnnotations().getEnabled()) {
            return new ReducerResult<>(state, null, 2, null);
        }
        ItemId itemId = state.getFile().getItemId();
        FileVersionMiniModel fileVersion = state.getFile().getFileVersion();
        if (fileVersion == null || (id = fileVersion.getId()) == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        AnnotationsReducer.State annotationsState = state.getAnnotationsState();
        AnnotationsReducer.State state2 = annotationsState == null ? new AnnotationsReducer.State(itemId, id, null, null, null, null, null, false, 252, null) : annotationsState;
        return new ReducerResult<>(State.copy$default(state, null, null, null, AnnotationsReducer.State.copy$default(state2, null, null, null, null, null, null, null, this.environment.getAnnotationsEnvironment().getFeatureFlips().getCreateAnnotations().getEnabled(), 127, null), false, null, 55, null), EffectKt.toEffect(FlowKt.flow(new C17071(state2, null))).cancellable(AnnotationsReducerKt.createAnnotFetchKey(state2.getFileId(), state2.getFileVersionId()), true));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameAnnotationReducer$handleFetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FrameAnnotationReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action$UpdateAnnotations;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameAnnotationReducer$handleFetch$1", f = "FrameAnnotationReducer.kt", i = {0, 1, 1, 1, 1, 1}, l = {BoxCommonConstants.REQUEST_OPTIONS, 214}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FrameAnnotationReducer$handleFetch$1$1"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C17071 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdateAnnotations>, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnnotationsReducer.State $annotationState;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17071(AnnotationsReducer.State state, Continuation<? super C17071> continuation) {
            super(2, continuation);
            this.$annotationState = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C17071 c17071 = FrameAnnotationReducer.this.new C17071(this.$annotationState, continuation);
            c17071.L$0 = obj;
            return c17071;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdateAnnotations> flowCollector, Continuation<? super Unit> continuation) {
            return ((C17071) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r4, r7) == r1) goto L17;
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
                r4 = 1
                if (r2 == 0) goto L2a
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r0 = r7.L$2
                kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L8b
            L1e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L55
            L2a:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.preview.previewtype.video.FrameAnnotationReducer r8 = com.box.android.preview.previewtype.video.FrameAnnotationReducer.this
                com.box.android.preview.previewtype.video.FrameAnnotationEnvironment r8 = r8.getEnvironment()
                com.box.android.preview.annotations.cpl.AnnotationsEnvironment r8 = r8.getAnnotationsEnvironment()
                com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor r8 = r8.getGetAnnotationsVersionInteractor()
                com.box.android.preview.annotations.cpl.AnnotationsReducer$State r2 = r7.$annotationState
                com.box.android.domain.models.ItemId r2 = r2.getFileId()
                com.box.android.preview.annotations.cpl.AnnotationsReducer$State r5 = r7.$annotationState
                java.lang.String r5 = r5.getFileVersionId()
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = r8.getAnnotationsFlow(r2, r5, r6)
                if (r8 != r1) goto L55
                goto L86
            L55:
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                boolean r2 = r8 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 == 0) goto L87
                r2 = r8
                com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
                java.lang.Object r2 = r2.getValue()
                kotlinx.coroutines.flow.Flow r2 = (kotlinx.coroutines.flow.Flow) r2
                com.box.android.preview.previewtype.video.FrameAnnotationReducer$handleFetch$1$invokeSuspend$lambda$0$$inlined$map$1 r4 = new com.box.android.preview.previewtype.video.FrameAnnotationReducer$handleFetch$1$invokeSuspend$lambda$0$$inlined$map$1
                r4.<init>()
                kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                r7.L$1 = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r7.L$2 = r8
                r8 = 0
                r7.I$0 = r8
                r7.I$1 = r8
                r7.label = r3
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r4, r7)
                if (r7 != r1) goto L8b
            L86:
                return r1
            L87:
                boolean r7 = r8 instanceof com.box.android.domain.utils.result.Result.Error
                if (r7 == 0) goto L8e
            L8b:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L8e:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.video.FrameAnnotationReducer.C17071.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleDisplayAnnotation(State state, String annotationId, DocumentSize documentSize) {
        Object next;
        AnnotationWithLocation annotationWithLocation;
        if (state.getAnnotationsState() == null || state.getCreateAnnotationState() != null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        Iterator<T> it = state.getAnnotations().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((FileActivityModel.AnnotationModel) next).getId(), annotationId));
        FileActivityModel.AnnotationModel annotationModel = (FileActivityModel.AnnotationModel) next;
        if (annotationModel != null) {
            List listSingletonList = Collections.singletonList(documentSize);
            Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
            annotationWithLocation = AnnotationsReducerKt.toAnnotationWithLocation(annotationModel, listSingletonList, this.environment.getAnnotationsEnvironment().getAnnotationModelMapper());
        } else {
            annotationWithLocation = null;
        }
        if (annotationWithLocation == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        Effect.Companion companion = Effect.INSTANCE;
        List listSingletonList2 = Collections.singletonList(annotationWithLocation);
        Intrinsics.checkNotNullExpressionValue(listSingletonList2, "singletonList(...)");
        return new ReducerResult<>(state, companion.merge(new Action.Annotations(new AnnotationsReducer.Action.UpdateAnnotations(listSingletonList2))));
    }
}
