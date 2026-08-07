package com.box.android.preview.previewtype.image;

import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducerKt;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.android.preview.item.LoadingPlaceholder;
import com.box.androidsdk.content.models.BoxUser;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: compiled from: ImagePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/image/ImagePreviewEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceImagePreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "enterAnnotationCreation", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final ImagePreviewEnvironment environment;

    /* JADX INFO: compiled from: ImagePreviewReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "url", "Ljava/net/URI;", "loadingPlaceholder", "Lcom/box/android/preview/item/LoadingPlaceholder;", "annotationsState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "createAnnotationState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;Lcom/box/android/preview/item/LoadingPlaceholder;Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getUrl", "()Ljava/net/URI;", "getLoadingPlaceholder", "()Lcom/box/android/preview/item/LoadingPlaceholder;", "getAnnotationsState", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "getCreateAnnotationState", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final AnnotationsReducer.State annotationsState;
        private final CreateAnnotationReducer.State createAnnotationState;
        private final FileModel file;
        private final LoadingPlaceholder loadingPlaceholder;
        private final URI url;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, LoadingPlaceholder loadingPlaceholder, AnnotationsReducer.State state2, CreateAnnotationReducer.State state3, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.file;
            }
            if ((i & 2) != 0) {
                uri = state.url;
            }
            if ((i & 4) != 0) {
                loadingPlaceholder = state.loadingPlaceholder;
            }
            if ((i & 8) != 0) {
                state2 = state.annotationsState;
            }
            if ((i & 16) != 0) {
                state3 = state.createAnnotationState;
            }
            CreateAnnotationReducer.State state4 = state3;
            LoadingPlaceholder loadingPlaceholder2 = loadingPlaceholder;
            return state.copy(fileModel, uri, loadingPlaceholder2, state2, state4);
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
        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        public final State copy(FileModel file, URI url, LoadingPlaceholder loadingPlaceholder, AnnotationsReducer.State annotationsState, CreateAnnotationReducer.State createAnnotationState) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            return new State(file, url, loadingPlaceholder, annotationsState, createAnnotationState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.url, state.url) && Intrinsics.areEqual(this.loadingPlaceholder, state.loadingPlaceholder) && Intrinsics.areEqual(this.annotationsState, state.annotationsState) && Intrinsics.areEqual(this.createAnnotationState, state.createAnnotationState);
        }

        public int hashCode() {
            int iHashCode = ((this.file.hashCode() * 31) + this.url.hashCode()) * 31;
            LoadingPlaceholder loadingPlaceholder = this.loadingPlaceholder;
            int iHashCode2 = (iHashCode + (loadingPlaceholder == null ? 0 : loadingPlaceholder.hashCode())) * 31;
            AnnotationsReducer.State state = this.annotationsState;
            int iHashCode3 = (iHashCode2 + (state == null ? 0 : state.hashCode())) * 31;
            CreateAnnotationReducer.State state2 = this.createAnnotationState;
            return iHashCode3 + (state2 != null ? state2.hashCode() : 0);
        }

        public String toString() {
            return "State(file=" + this.file + ", url=" + this.url + ", loadingPlaceholder=" + this.loadingPlaceholder + ", annotationsState=" + this.annotationsState + ", createAnnotationState=" + this.createAnnotationState + ")";
        }

        public State(FileModel file, URI url, LoadingPlaceholder loadingPlaceholder, AnnotationsReducer.State state, CreateAnnotationReducer.State state2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            this.file = file;
            this.url = url;
            this.loadingPlaceholder = loadingPlaceholder;
            this.annotationsState = state;
            this.createAnnotationState = state2;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final URI getUrl() {
            return this.url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileModel fileModel, URI uri, LoadingPlaceholder loadingPlaceholder, AnnotationsReducer.State state, CreateAnnotationReducer.State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, uri, (i & 4) != 0 ? new LoadingPlaceholder(FileTypeIcon.DEFAULT, null, 2, 0 == true ? 1 : 0) : loadingPlaceholder, (i & 8) != 0 ? null : state, (i & 16) != 0 ? null : state2);
        }

        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }
    }

    public ImagePreviewReducer(ImagePreviewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new ImagePreviewReducer$build$1(this));
        final ImagePreviewReducer$build$2 imagePreviewReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ImagePreviewReducer.State) obj).getAnnotationsState();
            }
        };
        final ImagePreviewReducer$build$3 imagePreviewReducer$build$3 = ImagePreviewReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new AnnotationsReducer(environment.getAnnotationsEnvironment()), new Function1<State, AnnotationsReducer.State>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.AnnotationsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.State invoke(ImagePreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return imagePreviewReducer$build$2.invoke(it);
            }
        }, new Function1<Action, AnnotationsReducer.Action>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.Action invoke(ImagePreviewReducer.Action action) {
                if (!(action instanceof ImagePreviewReducer.Action.Annotations)) {
                    action = null;
                }
                ImagePreviewReducer.Action.Annotations annotations = (ImagePreviewReducer.Action.Annotations) action;
                if (annotations != null) {
                    return annotations.getAction();
                }
                return null;
            }
        }, new Function2<State, AnnotationsReducer.State, State>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ImagePreviewReducer.State invoke(ImagePreviewReducer.State parentState, AnnotationsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = imagePreviewReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ImagePreviewReducer.State.class)).iterator();
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
                            return (ImagePreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.image.ImagePreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AnnotationsReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.Action invoke(AnnotationsReducer.Action action) {
                Object objInvoke = imagePreviewReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ImagePreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.image.ImagePreviewReducer.Action");
            }
        });
        final ImagePreviewReducer$build$5 imagePreviewReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ImagePreviewReducer.State) obj).getCreateAnnotationState();
            }
        };
        final ImagePreviewReducer$build$6 imagePreviewReducer$build$6 = ImagePreviewReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new CreateAnnotationReducer(environment.getCreateAnnotationEnvironment()), new Function1<State, CreateAnnotationReducer.State>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.CreateAnnotationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.State invoke(ImagePreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return imagePreviewReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CreateAnnotationReducer.Action>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.Action invoke(ImagePreviewReducer.Action action) {
                if (!(action instanceof ImagePreviewReducer.Action.CreateAnnotation)) {
                    action = null;
                }
                ImagePreviewReducer.Action.CreateAnnotation createAnnotation = (ImagePreviewReducer.Action.CreateAnnotation) action;
                if (createAnnotation != null) {
                    return createAnnotation.getAction();
                }
                return null;
            }
        }, new Function2<State, CreateAnnotationReducer.State, State>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ImagePreviewReducer.State invoke(ImagePreviewReducer.State parentState, CreateAnnotationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = imagePreviewReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ImagePreviewReducer.State.class)).iterator();
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
                            return (ImagePreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.image.ImagePreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateAnnotationReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.image.ImagePreviewReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.Action invoke(CreateAnnotationReducer.Action action) {
                Object objInvoke = imagePreviewReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ImagePreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.image.ImagePreviewReducer.Action");
            }
        });
    }

    public final ImagePreviewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ImagePreviewReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "", "<init>", "()V", "ImageLoaded", "Annotations", "EnterAnnotationCreation", "ImageClicked", "CreateAnnotation", "Error", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$ImageClicked;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$ImageLoaded;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$ImageLoaded;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "documentSize", "Lcom/box/android/preview/annotations/model/DocumentSize;", "<init>", "(Lcom/box/android/preview/annotations/model/DocumentSize;)V", "getDocumentSize", "()Lcom/box/android/preview/annotations/model/DocumentSize;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageLoaded extends Action {
            public static final int $stable = 0;
            private final DocumentSize documentSize;

            public static /* synthetic */ ImageLoaded copy$default(ImageLoaded imageLoaded, DocumentSize documentSize, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentSize = imageLoaded.documentSize;
                }
                return imageLoaded.copy(documentSize);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentSize getDocumentSize() {
                return this.documentSize;
            }

            public final ImageLoaded copy(DocumentSize documentSize) {
                Intrinsics.checkNotNullParameter(documentSize, "documentSize");
                return new ImageLoaded(documentSize);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageLoaded) && Intrinsics.areEqual(this.documentSize, ((ImageLoaded) other).documentSize);
            }

            public int hashCode() {
                return this.documentSize.hashCode();
            }

            public String toString() {
                return "ImageLoaded(documentSize=" + this.documentSize + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageLoaded(DocumentSize documentSize) {
                super(null);
                Intrinsics.checkNotNullParameter(documentSize, "documentSize");
                this.documentSize = documentSize;
            }

            public final DocumentSize getDocumentSize() {
                return this.documentSize;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final AnnotationsReducer.Action getAction() {
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

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1890333617;
            }

            public String toString() {
                return "EnterAnnotationCreation";
            }

            private EnterAnnotationCreation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$ImageClicked;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageClicked extends Action {
            public static final int $stable = 0;
            public static final ImageClicked INSTANCE = new ImageClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -989379679;
            }

            public String toString() {
                return "ImageClicked";
            }

            private ImageClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final CreateAnnotationReducer.Action getAction() {
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

        /* JADX INFO: compiled from: ImagePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    public final ReducerResult<State, Action> reduceImagePreview(State state, Action action) {
        if (action instanceof Action.ImageLoaded) {
            State stateCopy$default = State.copy$default(state, null, null, null, null, null, 27, null);
            List listSingletonList = Collections.singletonList(((Action.ImageLoaded) action).getDocumentSize());
            Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
            return new ReducerResult<>(stateCopy$default, new Effect(new Action.Annotations(new AnnotationsReducer.Action.Fetch(listSingletonList))));
        }
        if (action instanceof Action.ImageClicked) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.EnterAnnotationCreation.INSTANCE)) {
            return enterAnnotationCreation(state);
        }
        if (action instanceof Action.CreateAnnotation) {
            if (Intrinsics.areEqual(((Action.CreateAnnotation) action).getAction(), CreateAnnotationReducer.Action.Exit.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, 15, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.Annotations) && !(action instanceof Action.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> enterAnnotationCreation(State state) {
        BoxUser userInfo = this.environment.getUserContextManager().getUserInfo();
        CreateAnnotationReducer.State.Companion companion = CreateAnnotationReducer.State.INSTANCE;
        FileModel file = state.getFile();
        Intrinsics.checkNotNull(userInfo);
        CreateAnnotationReducer.State stateCreateState = CreateAnnotationReducerKt.createState(companion, file, userInfo, CollectionsKt.emptyList(), new AnnotationLocationModel.Page(1));
        if (stateCreateState != null) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, stateCreateState, 15, null), new Effect(new Action.Annotations(AnnotationsReducer.Action.UnselectAnnotation.INSTANCE)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
