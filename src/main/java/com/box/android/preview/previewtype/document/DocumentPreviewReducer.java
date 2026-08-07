package com.box.android.preview.previewtype.document;

import android.graphics.Bitmap;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.models.preview.ScrollableFileType;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducerKt;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import com.box.android.preview.integration.nutrient.NutrientPdfConfigMapperKt;
import com.box.android.preview.item.LoadingPlaceholder;
import com.box.android.preview.previewtype.document.print.PrintReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.androidsdk.content.models.BoxUser;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.net.URI;
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

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0015H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reduceDocumentPreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceDocumentPreviewAnalytics", "enterAnnotationCreation", "reducePrint", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentPreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Combine<State, Action> build;
    private final DocumentPreviewEnvironment environment;

    public DocumentPreviewReducer(DocumentPreviewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new DocumentPreviewReducer$build$1(this));
        final DocumentPreviewReducer$build$2 documentPreviewReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getAnnotationsState();
            }
        };
        final DocumentPreviewReducer$build$3 documentPreviewReducer$build$3 = DocumentPreviewReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new AnnotationsReducer(environment.getAnnotationsEnvironment()), new Function1<State, AnnotationsReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.AnnotationsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$2.invoke(it);
            }
        }, new Function1<Action, AnnotationsReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationsReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.Annotations)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.Annotations annotations = (DocumentPreviewReducer.Action.Annotations) action;
                if (annotations != null) {
                    return annotations.getAction();
                }
                return null;
            }
        }, new Function2<State, AnnotationsReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, AnnotationsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AnnotationsReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(AnnotationsReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        });
        final DocumentPreviewReducer$build$5 documentPreviewReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getCreateAnnotationState();
            }
        };
        final DocumentPreviewReducer$build$6 documentPreviewReducer$build$6 = DocumentPreviewReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new CreateAnnotationReducer(environment.getCreateAnnotationEnvironment()), new Function1<State, CreateAnnotationReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.annotations.cpl.CreateAnnotationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CreateAnnotationReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final CreateAnnotationReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.CreateAnnotation)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.CreateAnnotation createAnnotation = (DocumentPreviewReducer.Action.CreateAnnotation) action;
                if (createAnnotation != null) {
                    return createAnnotation.getAction();
                }
                return null;
            }
        }, new Function2<State, CreateAnnotationReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, CreateAnnotationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateAnnotationReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(CreateAnnotationReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        });
        final DocumentPreviewReducer$build$8 documentPreviewReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getCopyTextState();
            }
        };
        final DocumentPreviewReducer$build$9 documentPreviewReducer$build$9 = DocumentPreviewReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new CopySelectedTextReducer(environment.getCopyTextEnvironment()), new Function1<State, CopySelectedTextReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.document.copytext.CopySelectedTextReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CopySelectedTextReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$8.invoke(it);
            }
        }, new Function1<Action, CopySelectedTextReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final CopySelectedTextReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.CopyText)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.CopyText copyText = (DocumentPreviewReducer.Action.CopyText) action;
                if (copyText != null) {
                    return copyText.getAction();
                }
                return null;
            }
        }, new Function2<State, CopySelectedTextReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, CopySelectedTextReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CopySelectedTextReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(CopySelectedTextReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        });
        final DocumentPreviewReducer$build$11 documentPreviewReducer$build$11 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getSearchState();
            }
        };
        final DocumentPreviewReducer$build$12 documentPreviewReducer$build$12 = DocumentPreviewReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, new DocumentSearchReducer(environment.getSearchEnvironment()), new Function1<State, DocumentSearchReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$13
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.previewtype.document.search.DocumentSearchReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final DocumentSearchReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$11.invoke(it);
            }
        }, new Function1<Action, DocumentSearchReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$14
            @Override // kotlin.jvm.functions.Function1
            public final DocumentSearchReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.Search)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.Search search = (DocumentPreviewReducer.Action.Search) action;
                if (search != null) {
                    return search.getAction();
                }
                return null;
            }
        }, new Function2<State, DocumentSearchReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$15
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, DocumentSearchReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$11;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DocumentSearchReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(DocumentSearchReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        });
        final DocumentPreviewReducer$build$14 documentPreviewReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getPrintState();
            }
        };
        final DocumentPreviewReducer$build$15 documentPreviewReducer$build$15 = DocumentPreviewReducer$build$15.INSTANCE;
        IfLetReducer ifLetReducer5 = new IfLetReducer(ifLetReducer4, new PrintReducer(environment.getPrintEnvironment()), new Function1<State, PrintReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$17
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.previewtype.document.print.PrintReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PrintReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$14.invoke(it);
            }
        }, new Function1<Action, PrintReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$18
            @Override // kotlin.jvm.functions.Function1
            public final PrintReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.Print)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.Print print = (DocumentPreviewReducer.Action.Print) action;
                if (print != null) {
                    return print.getAction();
                }
                return null;
            }
        }, new Function2<State, PrintReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$19
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, PrintReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$14;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PrintReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(PrintReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$15.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        });
        final DocumentPreviewReducer$build$17 documentPreviewReducer$build$17 = new PropertyReference1Impl() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$build$17
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getCitationState();
            }
        };
        final DocumentPreviewReducer$build$18 documentPreviewReducer$build$18 = DocumentPreviewReducer$build$18.INSTANCE;
        this.build = new Combine<>(new IfLetReducer(ifLetReducer5, new CitationHighlightReducer(environment.getCitationHighlightEnvironment()), new Function1<State, CitationHighlightReducer.State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$21
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.previewtype.document.CitationHighlightReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CitationHighlightReducer.State invoke(DocumentPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return documentPreviewReducer$build$17.invoke(it);
            }
        }, new Function1<Action, CitationHighlightReducer.Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$22
            @Override // kotlin.jvm.functions.Function1
            public final CitationHighlightReducer.Action invoke(DocumentPreviewReducer.Action action) {
                if (!(action instanceof DocumentPreviewReducer.Action.Citations)) {
                    action = null;
                }
                DocumentPreviewReducer.Action.Citations citations = (DocumentPreviewReducer.Action.Citations) action;
                if (citations != null) {
                    return citations.getAction();
                }
                return null;
            }
        }, new Function2<State, CitationHighlightReducer.State, State>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$23
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final DocumentPreviewReducer.State invoke(DocumentPreviewReducer.State parentState, CitationHighlightReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = documentPreviewReducer$build$17;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(DocumentPreviewReducer.State.class)).iterator();
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
                            return (DocumentPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CitationHighlightReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.document.DocumentPreviewReducer$special$$inlined$scope$24
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(CitationHighlightReducer.Action action) {
                Object objInvoke = documentPreviewReducer$build$18.invoke(action);
                if (objInvoke != null) {
                    return (DocumentPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.document.DocumentPreviewReducer.Action");
            }
        }), new Reduce(new DocumentPreviewReducer$build$20(this)));
    }

    public final DocumentPreviewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\t\u0010E\u001a\u00020\u0010HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010H\u001a\u00020\u0017HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010K\u001a\u00020\u001dHÆ\u0003J§\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001J\u0013\u0010M\u001a\u00020<2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u0010HÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b;\u0010=¨\u0006R"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "url", "Ljava/net/URI;", "loadingPlaceholder", "Lcom/box/android/preview/item/LoadingPlaceholder;", "pdfPreviewConfiguration", "Lcom/box/android/preview/previewtype/document/PdfPreviewConfiguration;", "documentSizes", "", "Lcom/box/android/preview/annotations/model/DocumentSize;", "displayMode", "Lcom/box/android/preview/previewtype/document/DisplayMode;", "currentPageNumber", "", "pageCount", "annotationsState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "createAnnotationState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "copyTextState", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "searchState", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "printState", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "citationState", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;Lcom/box/android/preview/item/LoadingPlaceholder;Lcom/box/android/preview/previewtype/document/PdfPreviewConfiguration;Ljava/util/List;Lcom/box/android/preview/previewtype/document/DisplayMode;IILcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getUrl", "()Ljava/net/URI;", "getLoadingPlaceholder", "()Lcom/box/android/preview/item/LoadingPlaceholder;", "getPdfPreviewConfiguration", "()Lcom/box/android/preview/previewtype/document/PdfPreviewConfiguration;", "getDocumentSizes", "()Ljava/util/List;", "getDisplayMode", "()Lcom/box/android/preview/previewtype/document/DisplayMode;", "getCurrentPageNumber", "()I", "getPageCount", "getAnnotationsState", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "getCreateAnnotationState", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "getCopyTextState", "()Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "getSearchState", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "getPrintState", "()Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "getCitationState", "()Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;", "isPageInfoReady", "", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final AnnotationsReducer.State annotationsState;
        private final CitationHighlightReducer.State citationState;
        private final CopySelectedTextReducer.State copyTextState;
        private final CreateAnnotationReducer.State createAnnotationState;
        private final int currentPageNumber;
        private final DisplayMode displayMode;
        private final List<DocumentSize> documentSizes;
        private final FileModel file;
        private final boolean isPageInfoReady;
        private final LoadingPlaceholder loadingPlaceholder;
        private final int pageCount;
        private final PdfPreviewConfiguration pdfPreviewConfiguration;
        private final PrintReducer.State printState;
        private final DocumentSearchReducer.State searchState;
        private final URI url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, LoadingPlaceholder loadingPlaceholder, PdfPreviewConfiguration pdfPreviewConfiguration, List list, DisplayMode displayMode, int i, int i2, AnnotationsReducer.State state2, CreateAnnotationReducer.State state3, CopySelectedTextReducer.State state4, DocumentSearchReducer.State state5, PrintReducer.State state6, CitationHighlightReducer.State state7, int i3, Object obj) {
            return state.copy((i3 & 1) != 0 ? state.file : fileModel, (i3 & 2) != 0 ? state.url : uri, (i3 & 4) != 0 ? state.loadingPlaceholder : loadingPlaceholder, (i3 & 8) != 0 ? state.pdfPreviewConfiguration : pdfPreviewConfiguration, (i3 & 16) != 0 ? state.documentSizes : list, (i3 & 32) != 0 ? state.displayMode : displayMode, (i3 & 64) != 0 ? state.currentPageNumber : i, (i3 & 128) != 0 ? state.pageCount : i2, (i3 & 256) != 0 ? state.annotationsState : state2, (i3 & 512) != 0 ? state.createAnnotationState : state3, (i3 & 1024) != 0 ? state.copyTextState : state4, (i3 & 2048) != 0 ? state.searchState : state5, (i3 & 4096) != 0 ? state.printState : state6, (i3 & 8192) != 0 ? state.citationState : state7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final CopySelectedTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final DocumentSearchReducer.State getSearchState() {
            return this.searchState;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final PrintReducer.State getPrintState() {
            return this.printState;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final CitationHighlightReducer.State getCitationState() {
            return this.citationState;
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
        public final PdfPreviewConfiguration getPdfPreviewConfiguration() {
            return this.pdfPreviewConfiguration;
        }

        public final List<DocumentSize> component5() {
            return this.documentSizes;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getCurrentPageNumber() {
            return this.currentPageNumber;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPageCount() {
            return this.pageCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        public final State copy(FileModel file, URI url, LoadingPlaceholder loadingPlaceholder, PdfPreviewConfiguration pdfPreviewConfiguration, List<DocumentSize> documentSizes, DisplayMode displayMode, int currentPageNumber, int pageCount, AnnotationsReducer.State annotationsState, CreateAnnotationReducer.State createAnnotationState, CopySelectedTextReducer.State copyTextState, DocumentSearchReducer.State searchState, PrintReducer.State printState, CitationHighlightReducer.State citationState) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(pdfPreviewConfiguration, "pdfPreviewConfiguration");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            Intrinsics.checkNotNullParameter(citationState, "citationState");
            return new State(file, url, loadingPlaceholder, pdfPreviewConfiguration, documentSizes, displayMode, currentPageNumber, pageCount, annotationsState, createAnnotationState, copyTextState, searchState, printState, citationState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.url, state.url) && Intrinsics.areEqual(this.loadingPlaceholder, state.loadingPlaceholder) && Intrinsics.areEqual(this.pdfPreviewConfiguration, state.pdfPreviewConfiguration) && Intrinsics.areEqual(this.documentSizes, state.documentSizes) && this.displayMode == state.displayMode && this.currentPageNumber == state.currentPageNumber && this.pageCount == state.pageCount && Intrinsics.areEqual(this.annotationsState, state.annotationsState) && Intrinsics.areEqual(this.createAnnotationState, state.createAnnotationState) && Intrinsics.areEqual(this.copyTextState, state.copyTextState) && Intrinsics.areEqual(this.searchState, state.searchState) && Intrinsics.areEqual(this.printState, state.printState) && Intrinsics.areEqual(this.citationState, state.citationState);
        }

        public int hashCode() {
            int iHashCode = ((this.file.hashCode() * 31) + this.url.hashCode()) * 31;
            LoadingPlaceholder loadingPlaceholder = this.loadingPlaceholder;
            int iHashCode2 = (((iHashCode + (loadingPlaceholder == null ? 0 : loadingPlaceholder.hashCode())) * 31) + this.pdfPreviewConfiguration.hashCode()) * 31;
            List<DocumentSize> list = this.documentSizes;
            int iHashCode3 = (((((((iHashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.displayMode.hashCode()) * 31) + Integer.hashCode(this.currentPageNumber)) * 31) + Integer.hashCode(this.pageCount)) * 31;
            AnnotationsReducer.State state = this.annotationsState;
            int iHashCode4 = (iHashCode3 + (state == null ? 0 : state.hashCode())) * 31;
            CreateAnnotationReducer.State state2 = this.createAnnotationState;
            int iHashCode5 = (((iHashCode4 + (state2 == null ? 0 : state2.hashCode())) * 31) + this.copyTextState.hashCode()) * 31;
            DocumentSearchReducer.State state3 = this.searchState;
            int iHashCode6 = (iHashCode5 + (state3 == null ? 0 : state3.hashCode())) * 31;
            PrintReducer.State state4 = this.printState;
            return ((iHashCode6 + (state4 != null ? state4.hashCode() : 0)) * 31) + this.citationState.hashCode();
        }

        public String toString() {
            return "State(file=" + this.file + ", url=" + this.url + ", loadingPlaceholder=" + this.loadingPlaceholder + ", pdfPreviewConfiguration=" + this.pdfPreviewConfiguration + ", documentSizes=" + this.documentSizes + ", displayMode=" + this.displayMode + ", currentPageNumber=" + this.currentPageNumber + ", pageCount=" + this.pageCount + ", annotationsState=" + this.annotationsState + ", createAnnotationState=" + this.createAnnotationState + ", copyTextState=" + this.copyTextState + ", searchState=" + this.searchState + ", printState=" + this.printState + ", citationState=" + this.citationState + ")";
        }

        public State(FileModel file, URI url, LoadingPlaceholder loadingPlaceholder, PdfPreviewConfiguration pdfPreviewConfiguration, List<DocumentSize> list, DisplayMode displayMode, int i, int i2, AnnotationsReducer.State state, CreateAnnotationReducer.State state2, CopySelectedTextReducer.State copyTextState, DocumentSearchReducer.State state3, PrintReducer.State state4, CitationHighlightReducer.State citationState) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(pdfPreviewConfiguration, "pdfPreviewConfiguration");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            Intrinsics.checkNotNullParameter(citationState, "citationState");
            this.file = file;
            this.url = url;
            this.loadingPlaceholder = loadingPlaceholder;
            this.pdfPreviewConfiguration = pdfPreviewConfiguration;
            this.documentSizes = list;
            this.displayMode = displayMode;
            this.currentPageNumber = i;
            this.pageCount = i2;
            this.annotationsState = state;
            this.createAnnotationState = state2;
            this.copyTextState = copyTextState;
            this.searchState = state3;
            this.printState = state4;
            this.citationState = citationState;
            this.isPageInfoReady = i2 > 0 && i > 0;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final URI getUrl() {
            return this.url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileModel fileModel, URI uri, LoadingPlaceholder loadingPlaceholder, PdfPreviewConfiguration pdfPreviewConfiguration, List list, DisplayMode displayMode, int i, int i2, AnnotationsReducer.State state, CreateAnnotationReducer.State state2, CopySelectedTextReducer.State state3, DocumentSearchReducer.State state4, PrintReducer.State state5, CitationHighlightReducer.State state6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            LoadingPlaceholder loadingPlaceholder2;
            CitationHighlightReducer.State state7;
            Bitmap bitmap = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if ((i3 & 4) != 0) {
                loadingPlaceholder2 = new LoadingPlaceholder(FileTypeIcon.DEFAULT, bitmap, 2, objArr3 == true ? 1 : 0);
            } else {
                loadingPlaceholder2 = loadingPlaceholder;
            }
            PdfPreviewConfiguration pdfPreviewConfiguration2 = (i3 & 8) != 0 ? new PdfPreviewConfiguration(false, null, null, null, false, 31, null) : pdfPreviewConfiguration;
            List list2 = (i3 & 16) != 0 ? null : list;
            DisplayMode displayMode2 = (i3 & 32) != 0 ? DisplayMode.FullItem : displayMode;
            int i4 = 1;
            int i5 = (i3 & 64) != 0 ? 1 : i;
            int i6 = (i3 & 128) != 0 ? 0 : i2;
            AnnotationsReducer.State state8 = (i3 & 256) != 0 ? null : state;
            CreateAnnotationReducer.State state9 = (i3 & 512) != 0 ? null : state2;
            CopySelectedTextReducer.State state10 = (i3 & 1024) != 0 ? new CopySelectedTextReducer.State(null, null, false, 7, null) : state3;
            DocumentSearchReducer.State state11 = (i3 & 2048) != 0 ? null : state4;
            PrintReducer.State state12 = (i3 & 4096) != 0 ? null : state5;
            if ((i3 & 8192) != 0) {
                state7 = new CitationHighlightReducer.State(objArr2 == true ? 1 : 0, i4, objArr == true ? 1 : 0);
            } else {
                state7 = state6;
            }
            this(fileModel, uri, loadingPlaceholder2, pdfPreviewConfiguration2, list2, displayMode2, i5, i6, state8, state9, state10, state11, state12, state7);
        }

        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        public final PdfPreviewConfiguration getPdfPreviewConfiguration() {
            return this.pdfPreviewConfiguration;
        }

        public final List<DocumentSize> getDocumentSizes() {
            return this.documentSizes;
        }

        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final int getCurrentPageNumber() {
            return this.currentPageNumber;
        }

        public final int getPageCount() {
            return this.pageCount;
        }

        public final AnnotationsReducer.State getAnnotationsState() {
            return this.annotationsState;
        }

        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        public final CopySelectedTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final DocumentSearchReducer.State getSearchState() {
            return this.searchState;
        }

        public final PrintReducer.State getPrintState() {
            return this.printState;
        }

        public final CitationHighlightReducer.State getCitationState() {
            return this.citationState;
        }

        /* JADX INFO: renamed from: isPageInfoReady, reason: from getter */
        public final boolean getIsPageInfoReady() {
            return this.isPageInfoReady;
        }
    }

    /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "", "<init>", "()V", "DocumentLoaded", "PasswordViewVisible", "UpdatePageNumber", "SwitchDisplayMode", "RefreshPdfPreviewConfiguration", "Annotations", "EnterAnnotationCreation", "PageClicked", "CreateAnnotation", "Error", "GestureStarted", "GestureEnded", "CopyText", "SearchDocumentClicked", "StartPrint", "Search", "Print", "Citations", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Citations;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$CopyText;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$DocumentLoaded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$GestureEnded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$GestureStarted;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$PageClicked;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$PasswordViewVisible;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Print;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$RefreshPdfPreviewConfiguration;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Search;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$SearchDocumentClicked;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$StartPrint;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$SwitchDisplayMode;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$UpdatePageNumber;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$DocumentLoaded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "pageCount", "", "documentSizes", "", "Lcom/box/android/preview/annotations/model/DocumentSize;", "<init>", "(ILjava/util/List;)V", "getPageCount", "()I", "getDocumentSizes", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentLoaded extends Action {
            public static final int $stable = 8;
            private final List<DocumentSize> documentSizes;
            private final int pageCount;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DocumentLoaded copy$default(DocumentLoaded documentLoaded, int i, List list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = documentLoaded.pageCount;
                }
                if ((i2 & 2) != 0) {
                    list = documentLoaded.documentSizes;
                }
                return documentLoaded.copy(i, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPageCount() {
                return this.pageCount;
            }

            public final List<DocumentSize> component2() {
                return this.documentSizes;
            }

            public final DocumentLoaded copy(int pageCount, List<DocumentSize> documentSizes) {
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                return new DocumentLoaded(pageCount, documentSizes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DocumentLoaded)) {
                    return false;
                }
                DocumentLoaded documentLoaded = (DocumentLoaded) other;
                return this.pageCount == documentLoaded.pageCount && Intrinsics.areEqual(this.documentSizes, documentLoaded.documentSizes);
            }

            public int hashCode() {
                return (Integer.hashCode(this.pageCount) * 31) + this.documentSizes.hashCode();
            }

            public String toString() {
                return "DocumentLoaded(pageCount=" + this.pageCount + ", documentSizes=" + this.documentSizes + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentLoaded(int i, List<DocumentSize> documentSizes) {
                super(null);
                Intrinsics.checkNotNullParameter(documentSizes, "documentSizes");
                this.pageCount = i;
                this.documentSizes = documentSizes;
            }

            public final List<DocumentSize> getDocumentSizes() {
                return this.documentSizes;
            }

            public final int getPageCount() {
                return this.pageCount;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$PasswordViewVisible;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PasswordViewVisible extends Action {
            public static final int $stable = 0;
            public static final PasswordViewVisible INSTANCE = new PasswordViewVisible();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PasswordViewVisible)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1306547785;
            }

            public String toString() {
                return "PasswordViewVisible";
            }

            private PasswordViewVisible() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$UpdatePageNumber;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "pageNumber", "", "<init>", "(I)V", "getPageNumber", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdatePageNumber extends Action {
            public static final int $stable = 0;
            private final int pageNumber;

            public static /* synthetic */ UpdatePageNumber copy$default(UpdatePageNumber updatePageNumber, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updatePageNumber.pageNumber;
                }
                return updatePageNumber.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPageNumber() {
                return this.pageNumber;
            }

            public final UpdatePageNumber copy(int pageNumber) {
                return new UpdatePageNumber(pageNumber);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdatePageNumber) && this.pageNumber == ((UpdatePageNumber) other).pageNumber;
            }

            public int hashCode() {
                return Integer.hashCode(this.pageNumber);
            }

            public String toString() {
                return "UpdatePageNumber(pageNumber=" + this.pageNumber + ")";
            }

            public UpdatePageNumber(int i) {
                super(null);
                this.pageNumber = i;
            }

            public final int getPageNumber() {
                return this.pageNumber;
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$SwitchDisplayMode;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "displayMode", "Lcom/box/android/preview/previewtype/document/DisplayMode;", "<init>", "(Lcom/box/android/preview/previewtype/document/DisplayMode;)V", "getDisplayMode", "()Lcom/box/android/preview/previewtype/document/DisplayMode;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SwitchDisplayMode extends Action {
            public static final int $stable = 0;
            private final DisplayMode displayMode;

            public static /* synthetic */ SwitchDisplayMode copy$default(SwitchDisplayMode switchDisplayMode, DisplayMode displayMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    displayMode = switchDisplayMode.displayMode;
                }
                return switchDisplayMode.copy(displayMode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DisplayMode getDisplayMode() {
                return this.displayMode;
            }

            public final SwitchDisplayMode copy(DisplayMode displayMode) {
                Intrinsics.checkNotNullParameter(displayMode, "displayMode");
                return new SwitchDisplayMode(displayMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SwitchDisplayMode) && this.displayMode == ((SwitchDisplayMode) other).displayMode;
            }

            public int hashCode() {
                return this.displayMode.hashCode();
            }

            public String toString() {
                return "SwitchDisplayMode(displayMode=" + this.displayMode + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SwitchDisplayMode(DisplayMode displayMode) {
                super(null);
                Intrinsics.checkNotNullParameter(displayMode, "displayMode");
                this.displayMode = displayMode;
            }

            public final DisplayMode getDisplayMode() {
                return this.displayMode;
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$RefreshPdfPreviewConfiguration;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshPdfPreviewConfiguration extends Action {
            public static final int $stable = 0;
            public static final RefreshPdfPreviewConfiguration INSTANCE = new RefreshPdfPreviewConfiguration();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshPdfPreviewConfiguration)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1903980128;
            }

            public String toString() {
                return "RefreshPdfPreviewConfiguration";
            }

            private RefreshPdfPreviewConfiguration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Annotations;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -2125360405;
            }

            public String toString() {
                return "EnterAnnotationCreation";
            }

            private EnterAnnotationCreation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$PageClicked;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageClicked extends Action {
            public static final int $stable = 0;
            public static final PageClicked INSTANCE = new PageClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PageClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 26315997;
            }

            public String toString() {
                return "PageClicked";
            }

            private PageClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$CreateAnnotation;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$GestureStarted;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GestureStarted extends Action {
            public static final int $stable = 0;
            public static final GestureStarted INSTANCE = new GestureStarted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GestureStarted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1190703469;
            }

            public String toString() {
                return "GestureStarted";
            }

            private GestureStarted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$GestureEnded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GestureEnded extends Action {
            public static final int $stable = 0;
            public static final GestureEnded INSTANCE = new GestureEnded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GestureEnded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -514902708;
            }

            public String toString() {
                return "GestureEnded";
            }

            private GestureEnded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$CopyText;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;)V", "getAction", "()Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyText extends Action implements Embedded<CopySelectedTextReducer.Action> {
            public static final int $stable = 0;
            private final CopySelectedTextReducer.Action action;

            public static /* synthetic */ CopyText copy$default(CopyText copyText, CopySelectedTextReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = copyText.action;
                }
                return copyText.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CopySelectedTextReducer.Action getAction() {
                return this.action;
            }

            public final CopyText copy(CopySelectedTextReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CopyText(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyText) && Intrinsics.areEqual(this.action, ((CopyText) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CopyText(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyText(CopySelectedTextReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CopySelectedTextReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$SearchDocumentClicked;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchDocumentClicked extends Action {
            public static final int $stable = 0;
            public static final SearchDocumentClicked INSTANCE = new SearchDocumentClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchDocumentClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1277566007;
            }

            public String toString() {
                return "SearchDocumentClicked";
            }

            private SearchDocumentClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$StartPrint;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartPrint extends Action {
            public static final int $stable = 0;
            public static final StartPrint INSTANCE = new StartPrint();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartPrint)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 917510278;
            }

            public String toString() {
                return "StartPrint";
            }

            private StartPrint() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Search;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Search extends Action implements Embedded<DocumentSearchReducer.Action> {
            public static final int $stable = 0;
            private final DocumentSearchReducer.Action action;

            public static /* synthetic */ Search copy$default(Search search, DocumentSearchReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = search.action;
                }
                return search.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentSearchReducer.Action getAction() {
                return this.action;
            }

            public final Search copy(DocumentSearchReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Search(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Search) && Intrinsics.areEqual(this.action, ((Search) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Search(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Search(DocumentSearchReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DocumentSearchReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Print;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Print extends Action implements Embedded<PrintReducer.Action> {
            public static final int $stable = 0;
            private final PrintReducer.Action action;

            public static /* synthetic */ Print copy$default(Print print, PrintReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = print.action;
                }
                return print.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PrintReducer.Action getAction() {
                return this.action;
            }

            public final Print copy(PrintReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Print(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Print) && Intrinsics.areEqual(this.action, ((Print) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Print(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Print(PrintReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PrintReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action$Citations;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Citations extends Action implements Embedded<CitationHighlightReducer.Action> {
            public static final int $stable = 0;
            private final CitationHighlightReducer.Action action;

            public static /* synthetic */ Citations copy$default(Citations citations, CitationHighlightReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = citations.action;
                }
                return citations.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CitationHighlightReducer.Action getAction() {
                return this.action;
            }

            public final Citations copy(CitationHighlightReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Citations(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Citations) && Intrinsics.areEqual(this.action, ((Citations) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Citations(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Citations(CitationHighlightReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CitationHighlightReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceDocumentPreview(State state, Action action) {
        if (action instanceof Action.DocumentLoaded) {
            Action.DocumentLoaded documentLoaded = (Action.DocumentLoaded) action;
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, documentLoaded.getDocumentSizes(), null, 0, documentLoaded.getPageCount(), null, null, null, null, null, null, 16235, null), new Effect(new Action.Annotations(new AnnotationsReducer.Action.Fetch(documentLoaded.getDocumentSizes()))));
        }
        if (action instanceof Action.PasswordViewVisible) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 16379, null), null, 2, null);
        }
        if (action instanceof Action.PageClicked) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.UpdatePageNumber) {
            Action.UpdatePageNumber updatePageNumber = (Action.UpdatePageNumber) action;
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, updatePageNumber.getPageNumber(), 0, null, null, null, null, null, null, 16319, null), new Effect(new Action.Search(new DocumentSearchReducer.Action.PageNumberUpdated(updatePageNumber.getPageNumber()))));
        }
        if (action instanceof Action.SwitchDisplayMode) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, ((Action.SwitchDisplayMode) action).getDisplayMode(), 0, 0, null, null, null, null, null, null, 16351, null), null, 2, null);
        }
        if (action instanceof Action.RefreshPdfPreviewConfiguration) {
            boolean z = state.getCreateAnnotationState() != null;
            ScrollableFileType scrollableFileType = this.environment.getScrollableFileTypeResolver().getScrollableFileType(state.getFile());
            PageFitMode pageFitMode = this.environment.getPreviewSettingsService().getPageFitMode();
            ScrollSettings pageScrollSettings = this.environment.getPreviewSettingsService().getPageScrollSettings(scrollableFileType);
            return new ReducerResult<>(State.copy$default(state, null, null, null, new PdfPreviewConfiguration(this.environment.getBoxAccountManagerHelper().isMobileCopyPasteEnabled(), NutrientPdfConfigMapperKt.toPSPDFKitPageFitMode(pageFitMode), NutrientPdfConfigMapperKt.toPSPDFKitDirection(pageScrollSettings.getDirection()), NutrientPdfConfigMapperKt.toPSPDFKitMode(pageScrollSettings.getMode()), !z), null, null, 0, 0, null, null, null, null, null, null, 16375, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.EnterAnnotationCreation.INSTANCE)) {
            return enterAnnotationCreation(state);
        }
        if (action instanceof Action.CreateAnnotation) {
            if (Intrinsics.areEqual(((Action.CreateAnnotation) action).getAction(), CreateAnnotationReducer.Action.Exit.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 15871, null), new Effect(Action.RefreshPdfPreviewConfiguration.INSTANCE));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.Annotations) && !(action instanceof Action.Error)) {
            if (action instanceof Action.GestureStarted) {
                return new ReducerResult<>(state, new Effect(new Action.CopyText(CopySelectedTextReducer.Action.HidePopup.INSTANCE)));
            }
            if (action instanceof Action.GestureEnded) {
                return new ReducerResult<>(state, new Effect(new Action.CopyText(CopySelectedTextReducer.Action.ShowPopup.INSTANCE)));
            }
            if (action instanceof Action.CopyText) {
                return new ReducerResult<>(state, null, 2, null);
            }
            if (Intrinsics.areEqual(action, Action.SearchDocumentClicked.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, new DocumentSearchReducer.State(state.getPageCount(), state.getCurrentPageNumber(), null, null, null, 28, null), null, null, 14335, null), null, 2, null);
            }
            if (action instanceof Action.Search) {
                if (((Action.Search) action).getAction() instanceof DocumentSearchReducer.Action.CloseSearchClicked) {
                    return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 14335, null), null, 2, null);
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action instanceof Action.Print) {
                return reducePrint(state, ((Action.Print) action).getAction());
            }
            if (Intrinsics.areEqual(action, Action.StartPrint.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, null, new PrintReducer.State(false, null, null, null, 15, null), null, 12287, null), new Effect(new Action.Print(PrintReducer.Action.Start.INSTANCE)));
            }
            if (action instanceof Action.Citations) {
                return new ReducerResult<>(state, null, 2, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceDocumentPreviewAnalytics(State state, Action action) {
        if (action instanceof Action.SwitchDisplayMode) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, action, null)));
        }
        if (action instanceof Action.SearchDocumentClicked) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.document.DocumentPreviewReducer$reduceDocumentPreviewAnalytics$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.document.DocumentPreviewReducer$reduceDocumentPreviewAnalytics$1", f = "DocumentPreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Action action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DocumentPreviewReducer.this.new AnonymousClass1(this.$state, this.$action, continuation);
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
            DocumentPreviewReducer.this.getEnvironment().getAnalytics().displayModeTriggered(this.$state.getFile(), ((Action.SwitchDisplayMode) this.$action).getDisplayMode());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.document.DocumentPreviewReducer$reduceDocumentPreviewAnalytics$2, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.document.DocumentPreviewReducer$reduceDocumentPreviewAnalytics$2", f = "DocumentPreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
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
            return DocumentPreviewReducer.this.new AnonymousClass2(this.$state, continuation);
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
            DocumentPreviewReducer.this.getEnvironment().getAnalytics().searchDocumentTriggered(this.$state.getFile());
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> enterAnnotationCreation(State state) {
        BoxUser userInfo = this.environment.getUserContextManager().getUserInfo();
        CreateAnnotationReducer.State.Companion companion = CreateAnnotationReducer.State.INSTANCE;
        FileModel file = state.getFile();
        Intrinsics.checkNotNull(userInfo);
        CreateAnnotationReducer.State stateCreateState = CreateAnnotationReducerKt.createState(companion, file, userInfo, CollectionsKt.listOf(BoxAnnotationMarkupType.HIGHLIGHT), new AnnotationLocationModel.Page(state.getCurrentPageNumber()));
        if (stateCreateState != null) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, stateCreateState, null, null, null, null, 15871, null), Effect.INSTANCE.merge(new Effect(Action.RefreshPdfPreviewConfiguration.INSTANCE), new Effect(new Action.Annotations(AnnotationsReducer.Action.UnselectAnnotation.INSTANCE))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reducePrint(State state, PrintReducer.Action action) {
        if (action instanceof PrintReducer.Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 12287, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
