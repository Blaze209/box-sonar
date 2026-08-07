package com.box.android.preview.previousversion;

import android.graphics.Bitmap;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.fileversions.FileVersionModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.services.IFileVersionService;
import com.box.android.domain.services.IPreviousVersionPreviewService;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.integration.nutrient.NutrientPdfConfigMapperKt;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.item.LoadingPlaceholder;
import com.box.android.preview.item.labels.classification.PreviewClassificationReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.PdfPreviewConfiguration;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00040123B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010\"\u001a\u00020\u0007H\u0002J$\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0015\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J$\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0015\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J$\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0015\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "environment", "Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;", "observabilityId", "", "<init>", "(Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;Ljava/lang/String;)V", "getEnvironment", "()Lcom/box/android/preview/previousversion/PreviousVersionEnvironment;", "getObservabilityId", "()Ljava/lang/String;", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reducePreviousVersion", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "onPdfPreviewReady", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Ready;", "onImagePreviewReady", "onVideoPreviewReady", "setLoadingPlaceholderAndLoadData", "loadPreviousFileVersion", "(Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPreviousVersionPreview", "createAnnotationsState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "navigateToFileActivityEffect", "Lcom/box/android/cpl/Effect;", "annotationId", "reduceDocument", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "reduceImage", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "reduceVideo", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "reduceAnnotationAction", "annotationAction", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "processEnqueuedAnnotation", "toVersionInfo", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;", "Lcom/box/android/domain/models/fileversions/FileVersionModel;", "PreviousVersionRoute", "State", "VersionInfo", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Combine<State, Action> build;
    private final PreviousVersionEnvironment environment;
    private final String observabilityId;

    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewerType.values().length];
            try {
                iArr[PreviewerType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewerType.Image.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreviewerType.Video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionReducer$loadPreviousFileVersion$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previousversion.PreviousVersionReducer", f = "PreviousVersionReducer.kt", i = {0}, l = {270}, m = "loadPreviousFileVersion", n = {"state"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviousVersionReducer.this.loadPreviousFileVersion(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionReducer$loadPreviousVersionPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previousversion.PreviousVersionReducer", f = "PreviousVersionReducer.kt", i = {0}, l = {283}, m = "loadPreviousVersionPreview", n = {"state"}, s = {"L$0"}, v = 1)
    static final class C17091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C17091(Continuation<? super C17091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviousVersionReducer.this.loadPreviousVersionPreview(null, this);
        }
    }

    public PreviousVersionReducer(PreviousVersionEnvironment environment, String str) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.observabilityId = str;
        Reduce reduce = new Reduce(new PreviousVersionReducer$build$1(this));
        final PreviousVersionReducer$build$2 previousVersionReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviousVersionReducer.State) obj).getItemState();
            }
        };
        final PreviousVersionReducer$build$3 previousVersionReducer$build$3 = PreviousVersionReducer$build$3.INSTANCE;
        final PreviousVersionReducer$build$4 previousVersionReducer$build$4 = PreviousVersionReducer$build$4.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new DocumentPreviewReducer(environment.getDocumentPreviewEnvironment()), new Function1<State, DocumentPreviewReducer.State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.State invoke(PreviousVersionReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = previousVersionReducer$build$2.invoke(it);
                if (!(objInvoke instanceof ItemState.Document)) {
                    objInvoke = null;
                }
                ItemState.Document document = (ItemState.Document) objInvoke;
                if (document != null) {
                    return document.getAction();
                }
                return null;
            }
        }, new Function1<Action, DocumentPreviewReducer.Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(PreviousVersionReducer.Action action) {
                if (!(action instanceof PreviousVersionReducer.Action.Document)) {
                    action = null;
                }
                PreviousVersionReducer.Action.Document document = (PreviousVersionReducer.Action.Document) action;
                if (document != null) {
                    return document.getAction();
                }
                return null;
            }
        }, new Function2<State, DocumentPreviewReducer.State, State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviousVersionReducer.State invoke(PreviousVersionReducer.State parentState, DocumentPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = previousVersionReducer$build$2;
                Object objInvoke = previousVersionReducer$build$3.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviousVersionReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (PreviousVersionReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DocumentPreviewReducer.Action, Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviousVersionReducer.Action invoke(DocumentPreviewReducer.Action action) {
                Object objInvoke = previousVersionReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (PreviousVersionReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.Action");
            }
        });
        final PreviousVersionReducer$build$6 previousVersionReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviousVersionReducer.State) obj).getItemState();
            }
        };
        final PreviousVersionReducer$build$7 previousVersionReducer$build$7 = PreviousVersionReducer$build$7.INSTANCE;
        final PreviousVersionReducer$build$8 previousVersionReducer$build$8 = PreviousVersionReducer$build$8.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new ImagePreviewReducer(environment.getImagePreviewEnvironment()), new Function1<State, ImagePreviewReducer.State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.State invoke(PreviousVersionReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = previousVersionReducer$build$6.invoke(it);
                if (!(objInvoke instanceof ItemState.Image)) {
                    objInvoke = null;
                }
                ItemState.Image image = (ItemState.Image) objInvoke;
                if (image != null) {
                    return image.getAction();
                }
                return null;
            }
        }, new Function1<Action, ImagePreviewReducer.Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.Action invoke(PreviousVersionReducer.Action action) {
                if (!(action instanceof PreviousVersionReducer.Action.Image)) {
                    action = null;
                }
                PreviousVersionReducer.Action.Image image = (PreviousVersionReducer.Action.Image) action;
                if (image != null) {
                    return image.getAction();
                }
                return null;
            }
        }, new Function2<State, ImagePreviewReducer.State, State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviousVersionReducer.State invoke(PreviousVersionReducer.State parentState, ImagePreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = previousVersionReducer$build$6;
                Object objInvoke = previousVersionReducer$build$7.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviousVersionReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (PreviousVersionReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ImagePreviewReducer.Action, Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviousVersionReducer.Action invoke(ImagePreviewReducer.Action action) {
                Object objInvoke = previousVersionReducer$build$8.invoke(action);
                if (objInvoke != null) {
                    return (PreviousVersionReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.Action");
            }
        });
        final PreviousVersionReducer$build$10 previousVersionReducer$build$10 = new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$build$10
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviousVersionReducer.State) obj).getItemState();
            }
        };
        final PreviousVersionReducer$build$11 previousVersionReducer$build$11 = PreviousVersionReducer$build$11.INSTANCE;
        final PreviousVersionReducer$build$12 previousVersionReducer$build$12 = PreviousVersionReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new VideoPreviewReducer(environment.getVideoPreviewEnvironment()), new Function1<State, VideoPreviewReducer.State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoPreviewReducer.State invoke(PreviousVersionReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = previousVersionReducer$build$10.invoke(it);
                if (!(objInvoke instanceof ItemState.Video)) {
                    objInvoke = null;
                }
                ItemState.Video video = (ItemState.Video) objInvoke;
                if (video != null) {
                    return video.getAction();
                }
                return null;
            }
        }, new Function1<Action, VideoPreviewReducer.Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$10
            @Override // kotlin.jvm.functions.Function1
            public final VideoPreviewReducer.Action invoke(PreviousVersionReducer.Action action) {
                if (!(action instanceof PreviousVersionReducer.Action.Video)) {
                    action = null;
                }
                PreviousVersionReducer.Action.Video video = (PreviousVersionReducer.Action.Video) action;
                if (video != null) {
                    return video.getAction();
                }
                return null;
            }
        }, new Function2<State, VideoPreviewReducer.State, State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviousVersionReducer.State invoke(PreviousVersionReducer.State parentState, VideoPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = previousVersionReducer$build$10;
                Object objInvoke = previousVersionReducer$build$11.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviousVersionReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (PreviousVersionReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<VideoPreviewReducer.Action, Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$ifCaseScope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviousVersionReducer.Action invoke(VideoPreviewReducer.Action action) {
                Object objInvoke = previousVersionReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (PreviousVersionReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.Action");
            }
        });
        final PreviousVersionReducer$build$14 previousVersionReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviousVersionReducer.State) obj).getClassification();
            }
        };
        final PreviousVersionReducer$build$15 previousVersionReducer$build$15 = PreviousVersionReducer$build$15.INSTANCE;
        this.build = new Combine<>(new IfLetReducer(ifLetReducer3, new PreviewClassificationReducer(), new Function1<State, PreviewClassificationReducer.State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.item.labels.classification.PreviewClassificationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PreviewClassificationReducer.State invoke(PreviousVersionReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return previousVersionReducer$build$14.invoke(it);
            }
        }, new Function1<Action, PreviewClassificationReducer.Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final PreviewClassificationReducer.Action invoke(PreviousVersionReducer.Action action) {
                if (!(action instanceof PreviousVersionReducer.Action.Classification)) {
                    action = null;
                }
                PreviousVersionReducer.Action.Classification classification = (PreviousVersionReducer.Action.Classification) action;
                if (classification != null) {
                    return classification.getAction();
                }
                return null;
            }
        }, new Function2<State, PreviewClassificationReducer.State, State>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviousVersionReducer.State invoke(PreviousVersionReducer.State parentState, PreviewClassificationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = previousVersionReducer$build$14;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviousVersionReducer.State.class)).iterator();
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
                            return (PreviousVersionReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PreviewClassificationReducer.Action, Action>() { // from class: com.box.android.preview.previousversion.PreviousVersionReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviousVersionReducer.Action invoke(PreviewClassificationReducer.Action action) {
                Object objInvoke = previousVersionReducer$build$15.invoke(action);
                if (objInvoke != null) {
                    return (PreviousVersionReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previousversion.PreviousVersionReducer.Action");
            }
        }), new Reduce(new PreviousVersionReducer$build$17(this)));
    }

    public /* synthetic */ PreviousVersionReducer(PreviousVersionEnvironment previousVersionEnvironment, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(previousVersionEnvironment, (i & 2) != 0 ? null : str);
    }

    public final PreviousVersionEnvironment getEnvironment() {
        return this.environment;
    }

    public final String getObservabilityId() {
        return this.observabilityId;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "", "<init>", "()V", "None", "FileActivities", "Close", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$Close;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$FileActivities;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$None;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class PreviousVersionRoute {
        public static final int $stable = 0;

        public /* synthetic */ PreviousVersionRoute(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$None;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends PreviousVersionRoute {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1095597699;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private PreviousVersionRoute() {
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$FileActivities;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "activityId", "", "<init>", "(Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileActivities extends PreviousVersionRoute {
            public static final int $stable = 0;
            private final String activityId;

            /* JADX WARN: Multi-variable type inference failed */
            public FileActivities() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ FileActivities copy$default(FileActivities fileActivities, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fileActivities.activityId;
                }
                return fileActivities.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getActivityId() {
                return this.activityId;
            }

            public final FileActivities copy(String activityId) {
                return new FileActivities(activityId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileActivities) && Intrinsics.areEqual(this.activityId, ((FileActivities) other).activityId);
            }

            public int hashCode() {
                String str = this.activityId;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "FileActivities(activityId=" + this.activityId + ")";
            }

            public FileActivities(String str) {
                super(null);
                this.activityId = str;
            }

            public /* synthetic */ FileActivities(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getActivityId() {
                return this.activityId;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute$Close;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends PreviousVersionRoute {
            public static final int $stable = 0;
            public static final Close INSTANCE = new Close();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Close)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 385963091;
            }

            public String toString() {
                return "Close";
            }

            private Close() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JS\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "", "fileVersionId", "", "enqueuedAnnotationNavigation", "itemState", "Lcom/box/android/preview/item/ItemState;", "versionInfo", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;", "navigationRoute", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "isImmersiveMode", "", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/preview/item/ItemState;Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;ZLcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;)V", "getFileVersionId", "()Ljava/lang/String;", "getEnqueuedAnnotationNavigation", "getItemState", "()Lcom/box/android/preview/item/ItemState;", "getVersionInfo", "()Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;", "getNavigationRoute", "()Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "()Z", "getClassification", "()Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final PreviewClassificationReducer.State classification;
        private final String enqueuedAnnotationNavigation;
        private final FileModel fileModel;
        private final String fileVersionId;
        private final boolean isImmersiveMode;
        private final ItemState itemState;
        private final PreviousVersionRoute navigationRoute;
        private final VersionInfo versionInfo;

        public static /* synthetic */ State copy$default(State state, String str, String str2, ItemState itemState, VersionInfo versionInfo, PreviousVersionRoute previousVersionRoute, boolean z, PreviewClassificationReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.fileVersionId;
            }
            if ((i & 2) != 0) {
                str2 = state.enqueuedAnnotationNavigation;
            }
            if ((i & 4) != 0) {
                itemState = state.itemState;
            }
            if ((i & 8) != 0) {
                versionInfo = state.versionInfo;
            }
            if ((i & 16) != 0) {
                previousVersionRoute = state.navigationRoute;
            }
            if ((i & 32) != 0) {
                z = state.isImmersiveMode;
            }
            if ((i & 64) != 0) {
                state2 = state.classification;
            }
            boolean z2 = z;
            PreviewClassificationReducer.State state3 = state2;
            PreviousVersionRoute previousVersionRoute2 = previousVersionRoute;
            ItemState itemState2 = itemState;
            return state.copy(str, str2, itemState2, versionInfo, previousVersionRoute2, z2, state3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFileVersionId() {
            return this.fileVersionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEnqueuedAnnotationNavigation() {
            return this.enqueuedAnnotationNavigation;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemState getItemState() {
            return this.itemState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final VersionInfo getVersionInfo() {
            return this.versionInfo;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final PreviousVersionRoute getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsImmersiveMode() {
            return this.isImmersiveMode;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final PreviewClassificationReducer.State getClassification() {
            return this.classification;
        }

        public final State copy(String fileVersionId, String enqueuedAnnotationNavigation, ItemState itemState, VersionInfo versionInfo, PreviousVersionRoute navigationRoute, boolean isImmersiveMode, PreviewClassificationReducer.State classification) {
            Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
            Intrinsics.checkNotNullParameter(itemState, "itemState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(classification, "classification");
            return new State(fileVersionId, enqueuedAnnotationNavigation, itemState, versionInfo, navigationRoute, isImmersiveMode, classification);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileVersionId, state.fileVersionId) && Intrinsics.areEqual(this.enqueuedAnnotationNavigation, state.enqueuedAnnotationNavigation) && Intrinsics.areEqual(this.itemState, state.itemState) && Intrinsics.areEqual(this.versionInfo, state.versionInfo) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && this.isImmersiveMode == state.isImmersiveMode && Intrinsics.areEqual(this.classification, state.classification);
        }

        public int hashCode() {
            int iHashCode = this.fileVersionId.hashCode() * 31;
            String str = this.enqueuedAnnotationNavigation;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.itemState.hashCode()) * 31;
            VersionInfo versionInfo = this.versionInfo;
            return ((((((iHashCode2 + (versionInfo != null ? versionInfo.hashCode() : 0)) * 31) + this.navigationRoute.hashCode()) * 31) + Boolean.hashCode(this.isImmersiveMode)) * 31) + this.classification.hashCode();
        }

        public String toString() {
            return "State(fileVersionId=" + this.fileVersionId + ", enqueuedAnnotationNavigation=" + this.enqueuedAnnotationNavigation + ", itemState=" + this.itemState + ", versionInfo=" + this.versionInfo + ", navigationRoute=" + this.navigationRoute + ", isImmersiveMode=" + this.isImmersiveMode + ", classification=" + this.classification + ")";
        }

        public State(String fileVersionId, String str, ItemState itemState, VersionInfo versionInfo, PreviousVersionRoute navigationRoute, boolean z, PreviewClassificationReducer.State classification) {
            Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
            Intrinsics.checkNotNullParameter(itemState, "itemState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(classification, "classification");
            this.fileVersionId = fileVersionId;
            this.enqueuedAnnotationNavigation = str;
            this.itemState = itemState;
            this.versionInfo = versionInfo;
            this.navigationRoute = navigationRoute;
            this.isImmersiveMode = z;
            this.classification = classification;
            this.fileModel = itemState.getFileModel();
        }

        public final String getFileVersionId() {
            return this.fileVersionId;
        }

        public final String getEnqueuedAnnotationNavigation() {
            return this.enqueuedAnnotationNavigation;
        }

        public final ItemState getItemState() {
            return this.itemState;
        }

        public final VersionInfo getVersionInfo() {
            return this.versionInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(String str, String str2, ItemState itemState, VersionInfo versionInfo, PreviousVersionRoute.None none, boolean z, PreviewClassificationReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, itemState, (i & 8) != 0 ? null : versionInfo, (i & 16) != 0 ? PreviousVersionRoute.None.INSTANCE : none, z, (i & 64) != 0 ? new PreviewClassificationReducer.State(null, 1, 0 == true ? 1 : 0) : state);
        }

        public final PreviousVersionRoute getNavigationRoute() {
            return this.navigationRoute;
        }

        public final boolean isImmersiveMode() {
            return this.isImmersiveMode;
        }

        public final PreviewClassificationReducer.State getClassification() {
            return this.classification;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }
    }

    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;", "", "name", "", "number", "", "lastModified", "Ljava/util/Date;", "modifiedBy", "Lcom/box/android/domain/models/item/UserModel;", "<init>", "(Ljava/lang/String;ILjava/util/Date;Lcom/box/android/domain/models/item/UserModel;)V", "getName", "()Ljava/lang/String;", "getNumber", "()I", "getLastModified", "()Ljava/util/Date;", "getModifiedBy", "()Lcom/box/android/domain/models/item/UserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VersionInfo {
        public static final int $stable = 8;
        private final Date lastModified;
        private final UserModel modifiedBy;
        private final String name;
        private final int number;

        public static /* synthetic */ VersionInfo copy$default(VersionInfo versionInfo, String str, int i, Date date, UserModel userModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = versionInfo.name;
            }
            if ((i2 & 2) != 0) {
                i = versionInfo.number;
            }
            if ((i2 & 4) != 0) {
                date = versionInfo.lastModified;
            }
            if ((i2 & 8) != 0) {
                userModel = versionInfo.modifiedBy;
            }
            return versionInfo.copy(str, i, date, userModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Date getLastModified() {
            return this.lastModified;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UserModel getModifiedBy() {
            return this.modifiedBy;
        }

        public final VersionInfo copy(String name, int number, Date lastModified, UserModel modifiedBy) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new VersionInfo(name, number, lastModified, modifiedBy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VersionInfo)) {
                return false;
            }
            VersionInfo versionInfo = (VersionInfo) other;
            return Intrinsics.areEqual(this.name, versionInfo.name) && this.number == versionInfo.number && Intrinsics.areEqual(this.lastModified, versionInfo.lastModified) && Intrinsics.areEqual(this.modifiedBy, versionInfo.modifiedBy);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + Integer.hashCode(this.number)) * 31;
            Date date = this.lastModified;
            int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
            UserModel userModel = this.modifiedBy;
            return iHashCode2 + (userModel != null ? userModel.hashCode() : 0);
        }

        public String toString() {
            return "VersionInfo(name=" + this.name + ", number=" + this.number + ", lastModified=" + this.lastModified + ", modifiedBy=" + this.modifiedBy + ")";
        }

        public VersionInfo(String name, int i, Date date, UserModel userModel) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.number = i;
            this.lastModified = date;
            this.modifiedBy = userModel;
        }

        public final String getName() {
            return this.name;
        }

        public final int getNumber() {
            return this.number;
        }

        public final Date getLastModified() {
            return this.lastModified;
        }

        public final UserModel getModifiedBy() {
            return this.modifiedBy;
        }
    }

    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "", "<init>", "()V", "Initialize", "FileVersionLoaded", "Ready", "Error", "Retry", "Navigate", "ToggleImmersiveMode", "Document", "Image", "Video", "Classification", "Companion", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Classification;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Document;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Error;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$FileVersionLoaded;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Image;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Initialize;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Navigate;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Ready;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Retry;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$ToggleImmersiveMode;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Video;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Initialize;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2105658951;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$FileVersionLoaded;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "fileVersionData", "Lcom/box/android/domain/models/fileversions/FileVersionModel;", "<init>", "(Lcom/box/android/domain/models/fileversions/FileVersionModel;)V", "getFileVersionData", "()Lcom/box/android/domain/models/fileversions/FileVersionModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileVersionLoaded extends Action {
            public static final int $stable = 8;
            private final FileVersionModel fileVersionData;

            public static /* synthetic */ FileVersionLoaded copy$default(FileVersionLoaded fileVersionLoaded, FileVersionModel fileVersionModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileVersionModel = fileVersionLoaded.fileVersionData;
                }
                return fileVersionLoaded.copy(fileVersionModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileVersionModel getFileVersionData() {
                return this.fileVersionData;
            }

            public final FileVersionLoaded copy(FileVersionModel fileVersionData) {
                Intrinsics.checkNotNullParameter(fileVersionData, "fileVersionData");
                return new FileVersionLoaded(fileVersionData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileVersionLoaded) && Intrinsics.areEqual(this.fileVersionData, ((FileVersionLoaded) other).fileVersionData);
            }

            public int hashCode() {
                return this.fileVersionData.hashCode();
            }

            public String toString() {
                return "FileVersionLoaded(fileVersionData=" + this.fileVersionData + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileVersionLoaded(FileVersionModel fileVersionData) {
                super(null);
                Intrinsics.checkNotNullParameter(fileVersionData, "fileVersionData");
                this.fileVersionData = fileVersionData;
            }

            public final FileVersionModel getFileVersionData() {
                return this.fileVersionData;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Ready;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "previewData", "Lcom/box/android/domain/models/preview/PreviewData;", "<init>", "(Lcom/box/android/domain/models/preview/PreviewData;)V", "getPreviewData", "()Lcom/box/android/domain/models/preview/PreviewData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Ready extends Action {
            public static final int $stable = 8;
            private final PreviewData previewData;

            public static /* synthetic */ Ready copy$default(Ready ready, PreviewData previewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    previewData = ready.previewData;
                }
                return ready.copy(previewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewData getPreviewData() {
                return this.previewData;
            }

            public final Ready copy(PreviewData previewData) {
                Intrinsics.checkNotNullParameter(previewData, "previewData");
                return new Ready(previewData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Ready) && Intrinsics.areEqual(this.previewData, ((Ready) other).previewData);
            }

            public int hashCode() {
                return this.previewData.hashCode();
            }

            public String toString() {
                return "Ready(previewData=" + this.previewData + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Ready(PreviewData previewData) {
                super(null);
                Intrinsics.checkNotNullParameter(previewData, "previewData");
                this.previewData = previewData;
            }

            public final PreviewData getPreviewData() {
                return this.previewData;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Error;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.domainError;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final Error copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new Error(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.domainError, ((Error) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "Error(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Retry;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Retry extends Action {
            public static final int $stable = 0;
            public static final Retry INSTANCE = new Retry();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Retry)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -497481327;
            }

            public String toString() {
                return "Retry";
            }

            private Retry() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Navigate;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "route", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "<init>", "(Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;)V", "getRoute", "()Lcom/box/android/preview/previousversion/PreviousVersionReducer$PreviousVersionRoute;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Navigate extends Action {
            public static final int $stable = 0;
            private final PreviousVersionRoute route;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, PreviousVersionRoute previousVersionRoute, int i, Object obj) {
                if ((i & 1) != 0) {
                    previousVersionRoute = navigate.route;
                }
                return navigate.copy(previousVersionRoute);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviousVersionRoute getRoute() {
                return this.route;
            }

            public final Navigate copy(PreviousVersionRoute route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new Navigate(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && Intrinsics.areEqual(this.route, ((Navigate) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "Navigate(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Navigate(PreviousVersionRoute route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final PreviousVersionRoute getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$ToggleImmersiveMode;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleImmersiveMode extends Action {
            public static final int $stable = 0;
            public static final ToggleImmersiveMode INSTANCE = new ToggleImmersiveMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ToggleImmersiveMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1016339251;
            }

            public String toString() {
                return "ToggleImmersiveMode";
            }

            private ToggleImmersiveMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Document;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Document extends Action implements Embedded<DocumentPreviewReducer.Action> {
            public static final int $stable = 0;
            private final DocumentPreviewReducer.Action action;

            public static /* synthetic */ Document copy$default(Document document, DocumentPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = document.action;
                }
                return document.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPreviewReducer.Action getAction() {
                return this.action;
            }

            public final Document copy(DocumentPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Document(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Document) && Intrinsics.areEqual(this.action, ((Document) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Document(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Document(DocumentPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DocumentPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Image;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Image extends Action implements Embedded<ImagePreviewReducer.Action> {
            public static final int $stable = 0;
            private final ImagePreviewReducer.Action action;

            public static /* synthetic */ Image copy$default(Image image, ImagePreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = image.action;
                }
                return image.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImagePreviewReducer.Action getAction() {
                return this.action;
            }

            public final Image copy(ImagePreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Image(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Image) && Intrinsics.areEqual(this.action, ((Image) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Image(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Image(ImagePreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ImagePreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Video;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Video extends Action implements Embedded<VideoPreviewReducer.Action> {
            public static final int $stable = 0;
            private final VideoPreviewReducer.Action action;

            public static /* synthetic */ Video copy$default(Video video, VideoPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = video.action;
                }
                return video.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoPreviewReducer.Action getAction() {
                return this.action;
            }

            public final Video copy(VideoPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Video(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Video) && Intrinsics.areEqual(this.action, ((Video) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Video(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Video(VideoPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VideoPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Classification;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Classification extends Action implements Embedded<PreviewClassificationReducer.Action> {
            public static final int $stable = 0;
            private final PreviewClassificationReducer.Action action;

            public static /* synthetic */ Classification copy$default(Classification classification, PreviewClassificationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = classification.action;
                }
                return classification.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewClassificationReducer.Action getAction() {
                return this.action;
            }

            public final Classification copy(PreviewClassificationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Classification(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Classification) && Intrinsics.areEqual(this.action, ((Classification) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Classification(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Classification(PreviewClassificationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PreviewClassificationReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: PreviousVersionReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    public final ReducerResult<State, Action> reducePreviousVersion(State state, Action action) {
        State stateOnPdfPreviewReady;
        ItemState.Loading itemState;
        if (action instanceof Action.Initialize) {
            if (state.getItemState() instanceof ItemState.Uninitialized) {
                return setLoadingPlaceholderAndLoadData(state);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.FileVersionLoaded) {
            ItemState itemState2 = state.getItemState();
            ItemState.Loading loading = itemState2 instanceof ItemState.Loading ? (ItemState.Loading) itemState2 : null;
            if (loading != null) {
                ItemState.Loading loadingCopy$default = ItemState.Loading.copy$default(loading, null, LoadingPlaceholder.copy$default(loading.getPlaceholder(), SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(((Action.FileVersionLoaded) action).getFileVersionData().getFileName(), "")), null, 2, null), 1, null);
                if (loadingCopy$default != null) {
                    itemState = loadingCopy$default;
                } else {
                    itemState = state.getItemState();
                }
            } else {
                itemState = state.getItemState();
            }
            return new ReducerResult<>(State.copy$default(state, null, null, itemState, toVersionInfo(((Action.FileVersionLoaded) action).getFileVersionData()), null, false, null, 115, null), null, 2, null);
        }
        if (action instanceof Action.Ready) {
            Action.Ready ready = (Action.Ready) action;
            int i = WhenMappings.$EnumSwitchMapping$0[ready.getPreviewData().getPreviewerType().ordinal()];
            if (i == 1) {
                stateOnPdfPreviewReady = onPdfPreviewReady(state, ready, this.environment);
            } else if (i == 2) {
                stateOnPdfPreviewReady = onImagePreviewReady(state, ready);
            } else {
                stateOnPdfPreviewReady = i != 3 ? state : onVideoPreviewReady(state, ready);
            }
            return new ReducerResult<>(stateOnPdfPreviewReady, new Effect(new Action.Classification(new PreviewClassificationReducer.Action.UpdateLabel(state.getFileModel()))));
        }
        if (action instanceof Action.Error) {
            return new ReducerResult<>(State.copy$default(state, null, null, new ItemState.Error(state.getFileModel(), ((Action.Error) action).getDomainError()), null, null, false, null, 123, null), null, 2, null);
        }
        if (action instanceof Action.Retry) {
            return setLoadingPlaceholderAndLoadData(state);
        }
        if (action instanceof Action.Navigate) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, ((Action.Navigate) action).getRoute(), false, null, 111, null), null, 2, null);
        }
        if (action instanceof Action.Document) {
            return reduceDocument(((Action.Document) action).getAction(), state);
        }
        if (action instanceof Action.Image) {
            return reduceImage(((Action.Image) action).getAction(), state);
        }
        if (action instanceof Action.Video) {
            return reduceVideo(((Action.Video) action).getAction(), state);
        }
        if (action instanceof Action.ToggleImmersiveMode) {
            boolean zIsImmersiveMode = state.isImmersiveMode();
            boolean z = !zIsImmersiveMode;
            Action actionAnnotationAction = PreviousVersionReducerKt.annotationAction(Action.INSTANCE, state, new AnnotationsReducer.Action.AnnotationsVisibilityChanged(zIsImmersiveMode));
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, z, null, 95, null), actionAnnotationAction != null ? new Effect(actionAnnotationAction) : Effect.INSTANCE.none());
        }
        if (action instanceof Action.Classification) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final State onPdfPreviewReady(State state, Action.Ready action, PreviousVersionEnvironment environment) {
        DocumentPreviewEnvironment documentPreviewEnvironment = environment.getDocumentPreviewEnvironment();
        ScrollSettings pageScrollSettings = documentPreviewEnvironment.getPreviewSettingsService().getPageScrollSettings(documentPreviewEnvironment.getScrollableFileTypeResolver().getScrollableFileType(state.getFileModel()));
        return State.copy$default(state, null, null, new ItemState.Document(new DocumentPreviewReducer.State(state.getFileModel(), action.getPreviewData().getUrl(), state.getItemState().getLoadingPlaceholder(), new PdfPreviewConfiguration(documentPreviewEnvironment.getBoxAccountManagerHelper().isMobileCopyPasteEnabled(), null, NutrientPdfConfigMapperKt.toPSPDFKitDirection(pageScrollSettings.getDirection()), NutrientPdfConfigMapperKt.toPSPDFKitMode(pageScrollSettings.getMode()), false, 18, null), null, null, 0, 0, createAnnotationsState(state), null, null, null, null, null, 16112, null)), null, null, false, null, 123, null);
    }

    private final State onImagePreviewReady(State state, Action.Ready action) {
        return State.copy$default(state, null, null, new ItemState.Image(new ImagePreviewReducer.State(state.getFileModel(), action.getPreviewData().getUrl(), state.getItemState().getLoadingPlaceholder(), createAnnotationsState(state), null, 16, null)), null, null, false, null, 123, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final State onVideoPreviewReady(State state, Action.Ready action) {
        return State.copy$default(state, null, null, new ItemState.Video(new VideoPreviewReducer.State(state.getFileModel(), action.getPreviewData().getUrl(), 0L, state.getItemState().getLoadingPlaceholder(), new FrameAnnotationReducer.State(state.getFileModel(), null, null, createAnnotationsState(state), false, null, 54, null), 4, 0 == true ? 1 : 0)), null, null, false, null, 123, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> setLoadingPlaceholderAndLoadData(State state) {
        String name;
        VersionInfo versionInfo = state.getVersionInfo();
        Bitmap bitmap = null;
        Object[] objArr = 0;
        String fileExtension = (versionInfo == null || (name = versionInfo.getName()) == null) ? null : CommonBoxUtil.getFileExtension(name, "");
        State stateCopy$default = State.copy$default(state, null, null, new ItemState.Loading(state.getFileModel(), new LoadingPlaceholder(SupportedFileExtensionIcons.INSTANCE.findFileIcon(fileExtension != null ? fileExtension : ""), bitmap, 2, objArr == true ? 1 : 0)), null, null, false, null, 123, null);
        Effect.Companion companion = Effect.INSTANCE;
        Effect[] effectArr = new Effect[2];
        effectArr[0] = state.getVersionInfo() == null ? new Effect((Function1) new C17101(state, null)) : Effect.INSTANCE.none();
        effectArr[1] = new Effect((Function1) new AnonymousClass2(state, null));
        return new ReducerResult<>(stateCopy$default, companion.merge(effectArr));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionReducer$setLoadingPlaceholderAndLoadData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previousversion.PreviousVersionReducer$setLoadingPlaceholderAndLoadData$1", f = "PreviousVersionReducer.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17101 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17101(State state, Continuation<? super C17101> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PreviousVersionReducer.this.new C17101(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C17101) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objLoadPreviousFileVersion = PreviousVersionReducer.this.loadPreviousFileVersion(this.$state, this);
            return objLoadPreviousFileVersion == coroutine_suspended ? coroutine_suspended : objLoadPreviousFileVersion;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionReducer$setLoadingPlaceholderAndLoadData$2, reason: invalid class name */
    /* JADX INFO: compiled from: PreviousVersionReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previousversion.PreviousVersionReducer$setLoadingPlaceholderAndLoadData$2", f = "PreviousVersionReducer.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PreviousVersionReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objLoadPreviousVersionPreview = PreviousVersionReducer.this.loadPreviousVersionPreview(this.$state, this);
            return objLoadPreviousVersionPreview == coroutine_suspended ? coroutine_suspended : objLoadPreviousVersionPreview;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadPreviousFileVersion(State state, Continuation<? super Action> continuation) {
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
        Object fileVersion = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileVersion);
            IFileVersionService fileVersionService = this.environment.getFileVersionService();
            ItemId itemId = state.getFileModel().getItemId();
            String fileVersionId = state.getFileVersionId();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state);
            anonymousClass1.label = 1;
            fileVersion = fileVersionService.getFileVersion(itemId, fileVersionId, anonymousClass1);
            if (fileVersion == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(fileVersion);
        }
        Result result = (Result) fileVersion;
        if (result instanceof Result.Success) {
            return new Action.FileVersionLoaded((FileVersionModel) ((Result.Success) result).getValue());
        }
        if (result instanceof Result.Error) {
            return new Action.Error((DomainError) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadPreviousVersionPreview(State state, Continuation<? super Action> continuation) {
        C17091 c17091;
        if (continuation instanceof C17091) {
            c17091 = (C17091) continuation;
            if ((c17091.label & Integer.MIN_VALUE) != 0) {
                c17091.label -= Integer.MIN_VALUE;
            } else {
                c17091 = new C17091(continuation);
            }
        } else {
            c17091 = new C17091(continuation);
        }
        Object previousVersionPreviewData = c17091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(previousVersionPreviewData);
            IPreviousVersionPreviewService previousVersionPreviewService = this.environment.getPreviousVersionPreviewService();
            ItemId itemId = state.getFileModel().getItemId();
            String fileVersionId = state.getFileVersionId();
            c17091.L$0 = SpillingKt.nullOutSpilledVariable(state);
            c17091.label = 1;
            previousVersionPreviewData = previousVersionPreviewService.getPreviousVersionPreviewData(itemId, fileVersionId, c17091);
            if (previousVersionPreviewData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(previousVersionPreviewData);
        }
        Result result = (Result) previousVersionPreviewData;
        if (result instanceof Result.Success) {
            return new Action.Ready((PreviewData) ((Result.Success) result).getValue());
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Action.Error((DomainError) ((Result.Error) result).getValue());
    }

    private final AnnotationsReducer.State createAnnotationsState(State state) {
        return new AnnotationsReducer.State(state.getItemState().getFileModel().getItemId(), state.getFileVersionId(), null, null, null, null, null, false, 252, null);
    }

    private final Effect<Action> navigateToFileActivityEffect(String annotationId) {
        return new Effect<>(new Action.Navigate(new PreviousVersionRoute.FileActivities(annotationId)));
    }

    private final ReducerResult<State, Action> reduceDocument(DocumentPreviewReducer.Action action, State state) {
        if (action instanceof DocumentPreviewReducer.Action.Annotations) {
            return reduceAnnotationAction(state, ((DocumentPreviewReducer.Action.Annotations) action).getAction());
        }
        if (action instanceof DocumentPreviewReducer.Action.DocumentLoaded) {
            this.environment.getAnalytics().previousVersionPreviewScreenLoaded(state.getFileModel());
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof DocumentPreviewReducer.Action.PageClicked) {
            return new ReducerResult<>(state, new Effect(Action.ToggleImmersiveMode.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceImage(ImagePreviewReducer.Action action, State state) {
        if (action instanceof ImagePreviewReducer.Action.Annotations) {
            return reduceAnnotationAction(state, ((ImagePreviewReducer.Action.Annotations) action).getAction());
        }
        if (action instanceof ImagePreviewReducer.Action.ImageLoaded) {
            this.environment.getAnalytics().previousVersionPreviewScreenLoaded(state.getFileModel());
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof ImagePreviewReducer.Action.ImageClicked) {
            return new ReducerResult<>(state, new Effect(Action.ToggleImmersiveMode.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceVideo(VideoPreviewReducer.Action action, State state) {
        if (action instanceof VideoPreviewReducer.Action.FrameAnnotation) {
            VideoPreviewReducer.Action.FrameAnnotation frameAnnotation = (VideoPreviewReducer.Action.FrameAnnotation) action;
            if (frameAnnotation.getAction() instanceof FrameAnnotationReducer.Action.Annotations) {
                return reduceAnnotationAction(state, ((FrameAnnotationReducer.Action.Annotations) frameAnnotation.getAction()).getAction());
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof VideoPreviewReducer.Action.VideoLoaded) {
            this.environment.getAnalytics().previousVersionPreviewScreenLoaded(state.getFileModel());
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof VideoPreviewReducer.Action.VideoClicked) {
            return new ReducerResult<>(state, new Effect(Action.ToggleImmersiveMode.INSTANCE));
        }
        if (action instanceof VideoPreviewReducer.Action.Error) {
            return new ReducerResult<>(state, new Effect(new Action.Error(((VideoPreviewReducer.Action.Error) action).getError())));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceAnnotationAction(State state, AnnotationsReducer.Action annotationAction) {
        if (annotationAction instanceof AnnotationsReducer.Action.UpdateAnnotations) {
            List<AnnotationWithLocation> annotations = ((AnnotationsReducer.Action.UpdateAnnotations) annotationAction).getAnnotations();
            if (!(annotations instanceof Collection) || !annotations.isEmpty()) {
                Iterator<T> it = annotations.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((AnnotationWithLocation) it.next()).getAnnotation().getAnnotationId(), state.getEnqueuedAnnotationNavigation())) {
                        return processEnqueuedAnnotation(state);
                    }
                }
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (annotationAction instanceof AnnotationsReducer.Action.ViewComments) {
            return new ReducerResult<>(state, navigateToFileActivityEffect(((AnnotationsReducer.Action.ViewComments) annotationAction).getAnnotationId()));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> processEnqueuedAnnotation(State state) {
        String enqueuedAnnotationNavigation = state.getEnqueuedAnnotationNavigation();
        if (enqueuedAnnotationNavigation == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        Action actionAnnotationAction = PreviousVersionReducerKt.annotationAction(Action.INSTANCE, state, new AnnotationsReducer.Action.NavigateToAnnotation(enqueuedAnnotationNavigation));
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, 125, null), actionAnnotationAction != null ? new Effect(actionAnnotationAction) : Effect.INSTANCE.none());
    }

    private final VersionInfo toVersionInfo(FileVersionModel fileVersionModel) {
        return new VersionInfo(fileVersionModel.getFileName(), fileVersionModel.getNumber(), fileVersionModel.getModifiedAt(), fileVersionModel.getModifiedBy());
    }
}
