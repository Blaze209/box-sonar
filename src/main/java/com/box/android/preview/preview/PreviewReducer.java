package com.box.android.preview.preview;

import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.AudioItem;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.fileactions.FileAction;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.item.ItemPreviewEnvironment;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer;
import com.box.android.preview.preview.previewbar.topbar.TopBarReducer;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.CitationHighlightReducer;
import com.box.android.preview.previewtype.document.DisplayMode;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.print.PrintReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.box.android.preview.routing.CloseSource;
import com.box.android.preview.routing.PreviewRoute;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.common.net.HttpHeaders;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
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
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002./B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020 H\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010+J$\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020-H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u00060"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "environment", "Lcom/box/android/preview/preview/PreviewEnvironment;", "config", "Lcom/box/android/preview/preview/PreviewConfig;", "<init>", "(Lcom/box/android/preview/preview/PreviewEnvironment;Lcom/box/android/preview/preview/PreviewConfig;)V", "getEnvironment", "()Lcom/box/android/preview/preview/PreviewEnvironment;", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reducePreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "setSelectedItem", "Lcom/box/android/preview/preview/PreviewReducer$Action$SetSelectedItem;", "itemState", "Lcom/box/android/preview/item/ItemState;", "trackRecentItemEffect", "Lcom/box/android/cpl/Effect;", "reduceHighlightDisabling", "videoStateEffect", "currentItemState", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "handleToggleImmersiveMode", "handleBackClicked", "Lcom/box/android/preview/preview/PreviewReducer$Action$BackClicked;", "observeForPreviewItemsLocationChanges", "awaitUntilLocalCacheUpdated", "", "updatedItem", "Lcom/box/android/domain/models/item/ItemModel;", "(Lcom/box/android/domain/models/item/ItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndObserveItemsForCarousel", "fetchAndObserveItemsForPlaylist", "getActualFileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/preview/preview/PreviewReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToTarget", "Lcom/box/android/preview/preview/PreviewReducer$Action$NavigateToTarget;", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Combine<State, Action> build;
    private final PreviewConfig config;
    private final PreviewEnvironment environment;

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$awaitUntilLocalCacheUpdated$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer", f = "PreviewReducer.kt", i = {0, 1}, l = {555, 556}, m = "awaitUntilLocalCacheUpdated", n = {"updatedItem", "updatedItem"}, s = {"L$0", "L$0"}, v = 1)
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
            return PreviewReducer.this.awaitUntilLocalCacheUpdated(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$getActualFileModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer", f = "PreviewReducer.kt", i = {0}, l = {590}, m = "getActualFileModel", n = {"state"}, s = {"L$0"}, v = 1)
    static final class C16821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C16821(Continuation<? super C16821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewReducer.this.getActualFileModel(null, this);
        }
    }

    public PreviewReducer(PreviewEnvironment environment, PreviewConfig config) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(config, "config");
        this.environment = environment;
        this.config = config;
        Reducable[] reducableArr = new Reducable[3];
        boolean z = false;
        reducableArr[0] = new Reduce(new PreviewReducer$build$1(this));
        reducableArr[1] = new Reduce(new PreviewReducer$build$2(this));
        Reduce reduce = new Reduce(new PreviewReducer$build$3(this));
        final PreviewReducer$build$4 previewReducer$build$4 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducer$build$4
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getPreviewItems();
            }
        };
        final PreviewReducer$build$5 previewReducer$build$5 = PreviewReducer$build$5.INSTANCE;
        ItemPreviewEnvironment itemPreviewEnvironment = environment.getItemPreviewEnvironment();
        String observabilityId = config.getObservabilityId();
        if (config.isNewlyCreatedFile() && !environment.getFeatureFlips().getNewNoteCreationFlow().getEnabled()) {
            z = true;
        }
        ForEachReducer forEachReducer = new ForEachReducer(reduce, new ItemPreviewReducer(itemPreviewEnvironment, observabilityId, z), previewReducer$build$4, new Function1<Action, EmbeddedItem<ItemId, ItemPreviewReducer.Action>>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<ItemId, ItemPreviewReducer.Action> invoke(PreviewReducer.Action action) {
                if (!(action instanceof PreviewReducer.Action.Items)) {
                    action = null;
                }
                return (PreviewReducer.Action.Items) action;
            }
        }, new Function2<State, ItemPreviewReducer.State, State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviewReducer.State invoke(PreviewReducer.State parentState, ItemPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) previewReducer$build$4.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = previewReducer$build$4;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviewReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        if (rCallBy != 0) {
                            return (PreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<ItemId, ItemPreviewReducer.Action, Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final PreviewReducer.Action invoke(ItemId id, ItemPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = previewReducer$build$5.invoke(id, action);
                if (objInvoke != null) {
                    return (PreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.Action");
            }
        });
        final PreviewReducer$build$7 previewReducer$build$7 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducer$build$7
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getFileActionsState();
            }
        };
        final PreviewReducer$build$8 previewReducer$build$8 = PreviewReducer$build$8.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(forEachReducer, new FileActionsReducer(environment.getFileActionsEnvironment()), new Function1<State, FileActionsReducer.State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.fileactions.FileActionsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.State invoke(PreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return previewReducer$build$7.invoke(it);
            }
        }, new Function1<Action, FileActionsReducer.Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final FileActionsReducer.Action invoke(PreviewReducer.Action action) {
                if (!(action instanceof PreviewReducer.Action.FileActionsAction)) {
                    action = null;
                }
                PreviewReducer.Action.FileActionsAction fileActionsAction = (PreviewReducer.Action.FileActionsAction) action;
                if (fileActionsAction != null) {
                    return fileActionsAction.getAction();
                }
                return null;
            }
        }, new Function2<State, FileActionsReducer.State, State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviewReducer.State invoke(PreviewReducer.State parentState, FileActionsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = previewReducer$build$7;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviewReducer.State.class)).iterator();
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
                            return (PreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<FileActionsReducer.Action, Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviewReducer.Action invoke(FileActionsReducer.Action action) {
                Object objInvoke = previewReducer$build$8.invoke(action);
                if (objInvoke != null) {
                    return (PreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.Action");
            }
        });
        final PreviewReducer$build$10 previewReducer$build$10 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducer$build$10
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getTopBarState();
            }
        };
        final PreviewReducer$build$11 previewReducer$build$11 = PreviewReducer$build$11.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new TopBarReducer(environment.getTopBarEnvironment()), new Function1<State, TopBarReducer.State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.preview.previewbar.topbar.TopBarReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final TopBarReducer.State invoke(PreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return previewReducer$build$10.invoke(it);
            }
        }, new Function1<Action, TopBarReducer.Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final TopBarReducer.Action invoke(PreviewReducer.Action action) {
                if (!(action instanceof PreviewReducer.Action.TopBarAction)) {
                    action = null;
                }
                PreviewReducer.Action.TopBarAction topBarAction = (PreviewReducer.Action.TopBarAction) action;
                if (topBarAction != null) {
                    return topBarAction.getAction();
                }
                return null;
            }
        }, new Function2<State, TopBarReducer.State, State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviewReducer.State invoke(PreviewReducer.State parentState, TopBarReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = previewReducer$build$10;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviewReducer.State.class)).iterator();
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
                            return (PreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<TopBarReducer.Action, Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviewReducer.Action invoke(TopBarReducer.Action action) {
                Object objInvoke = previewReducer$build$11.invoke(action);
                if (objInvoke != null) {
                    return (PreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.Action");
            }
        });
        final PreviewReducer$build$13 previewReducer$build$13 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducer$build$13
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getBottomBarState();
            }
        };
        final PreviewReducer$build$14 previewReducer$build$14 = PreviewReducer$build$14.INSTANCE;
        reducableArr[2] = new IfLetReducer(ifLetReducer2, new BottomBarReducer(environment.getBottomBarEnvironment()), new Function1<State, BottomBarReducer.State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BottomBarReducer.State invoke(PreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return previewReducer$build$13.invoke(it);
            }
        }, new Function1<Action, BottomBarReducer.Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final BottomBarReducer.Action invoke(PreviewReducer.Action action) {
                if (!(action instanceof PreviewReducer.Action.BottomBarAction)) {
                    action = null;
                }
                PreviewReducer.Action.BottomBarAction bottomBarAction = (PreviewReducer.Action.BottomBarAction) action;
                if (bottomBarAction != null) {
                    return bottomBarAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BottomBarReducer.State, State>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final PreviewReducer.State invoke(PreviewReducer.State parentState, BottomBarReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = previewReducer$build$13;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(PreviewReducer.State.class)).iterator();
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
                            return (PreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BottomBarReducer.Action, Action>() { // from class: com.box.android.preview.preview.PreviewReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PreviewReducer.Action invoke(BottomBarReducer.Action action) {
                Object objInvoke = previewReducer$build$14.invoke(action);
                if (objInvoke != null) {
                    return (PreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.preview.PreviewReducer.Action");
            }
        });
        this.build = new Combine<>(reducableArr);
    }

    public final PreviewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0082\u0001B\u0089\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0004HÆ\u0003J\t\u0010r\u001a\u00020\bHÆ\u0003J\t\u0010s\u001a\u00020\nHÆ\u0003J\t\u0010t\u001a\u00020\fHÆ\u0003J\t\u0010u\u001a\u00020\u000eHÆ\u0003J\t\u0010v\u001a\u00020\u0010HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010x\u001a\u00020\nHÆ\u0003J\t\u0010y\u001a\u00020\u0015HÆ\u0003J\t\u0010z\u001a\u00020\nHÆ\u0003J\t\u0010{\u001a\u00020\nHÆ\u0003J\u008f\u0001\u0010|\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\nHÆ\u0001J\u0013\u0010}\u001a\u00020\n2\b\u0010~\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u007f\u001a\u00020iHÖ\u0001J\u000b\u0010\u0080\u0001\u001a\u00030\u0081\u0001HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010 R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0016\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010 R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b@\u0010 R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bE\u0010 R\u0011\u0010F\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bF\u0010 R\u0011\u0010G\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bG\u0010 R\u0011\u0010H\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bH\u0010 R\u0011\u0010I\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bI\u0010 R\u0011\u0010J\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010 R\u0013\u0010L\u001a\u0004\u0018\u00010M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010P\u001a\u0004\u0018\u00010Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bT\u0010 R\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0011\u0010Y\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bY\u0010 R\u0011\u0010Z\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b[\u0010 R\u0011\u0010\\\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b]\u0010 R\u000e\u0010^\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010_\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b_\u0010 R\u0011\u0010`\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\ba\u0010 R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010g\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bg\u0010 R\u0011\u0010h\u001a\u00020i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010l\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006\u0083\u0001"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$State;", "", "previewItems", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "selectedItemId", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "isNewlyCreatedFile", "", "fileActionsState", "Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "topBarState", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$State;", "bottomBarState", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$State;", "closingFrom", "Lcom/box/android/preview/routing/CloseSource;", "isImmersiveMode", "navigationRoute", "Lcom/box/android/preview/routing/PreviewRoute;", "isPlaylistInitialLoadingInProgress", "taskCreatedSuccessfully", "<init>", "(Lcom/box/android/cpl/IdentifiedList;Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/preview/PreviewSource;ZLcom/box/android/preview/fileactions/FileActionsReducer$State;Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$State;Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$State;Lcom/box/android/preview/routing/CloseSource;ZLcom/box/android/preview/routing/PreviewRoute;ZZ)V", "getPreviewItems", "()Lcom/box/android/cpl/IdentifiedList;", "getSelectedItemId", "()Lcom/box/android/domain/models/ItemId;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "()Z", "getFileActionsState", "()Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "getTopBarState", "()Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$State;", "getBottomBarState", "()Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$State;", "getClosingFrom", "()Lcom/box/android/preview/routing/CloseSource;", "getNavigationRoute", "()Lcom/box/android/preview/routing/PreviewRoute;", "getTaskCreatedSuccessfully", "previewItem", "getPreviewItem", "()Lcom/box/android/preview/item/ItemPreviewReducer$State;", "itemState", "Lcom/box/android/preview/item/ItemState;", "getItemState", "()Lcom/box/android/preview/item/ItemState;", "documentState", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "imageState", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "codeState", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "videoState", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "boxNoteState", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "displayMode", "Lcom/box/android/preview/previewtype/document/DisplayMode;", "shouldShowPageLabel", "getShouldShowPageLabel", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "isRenaming", "isPermanentRenameMode", "isExplicitRenameMode", "isSearching", "isShowingThumbnailsOrOutline", "shouldHandleImmersiveModeToggleTap", "getShouldHandleImmersiveModeToggleTap", "createAnnotationState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "getCreateAnnotationState", "()Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "printState", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "getPrintState", "()Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;", "isCreateAnnotationMode", "boxNoteEditModeState", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "getBoxNoteEditModeState", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "isBoxNoteEditingMode", "hasUserLostAccessToFile", "getHasUserLostAccessToFile", "shouldBlockContentGestures", "getShouldBlockContentGestures", "isAlternateBottomBarsShowing", "isBottomBarVisible", "arePreviewLabelsVisible", "getArePreviewLabelsVisible", "playlist", "", "Lcom/box/android/preview/previewtype/audio/model/AudioTrack;", "getPlaylist", "()Ljava/util/List;", "isCarouselEnabled", "indexOfSelectedItemId", "", "getIndexOfSelectedItemId", "()I", "codePreviewMessage", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "getCodePreviewMessage", "()Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        private final boolean arePreviewLabelsVisible;
        private final BottomBarReducer.State bottomBarState;
        private final BoxNoteEditModeReducer.State boxNoteEditModeState;
        private final BoxNotePreviewReducer.State boxNoteState;
        private final CloseSource closingFrom;
        private final CodePreviewReducer.Message codePreviewMessage;
        private final CodePreviewReducer.State codeState;
        private final CreateAnnotationReducer.State createAnnotationState;
        private final DisplayMode displayMode;
        private final DocumentPreviewReducer.State documentState;
        private final FileActionsReducer.State fileActionsState;
        private final FileModel fileModel;
        private final boolean hasUserLostAccessToFile;
        private final ImagePreviewReducer.State imageState;
        private final int indexOfSelectedItemId;
        private final boolean isAlternateBottomBarsShowing;
        private final boolean isBottomBarVisible;
        private final boolean isBoxNoteEditingMode;
        private final boolean isCarouselEnabled;
        private final boolean isCreateAnnotationMode;
        private final boolean isExplicitRenameMode;
        private final boolean isImmersiveMode;
        private final boolean isNewlyCreatedFile;
        private final boolean isPermanentRenameMode;
        private final boolean isPlaylistInitialLoadingInProgress;
        private final boolean isRenaming;
        private final boolean isSearching;
        private final boolean isShowingThumbnailsOrOutline;
        private final ItemState itemState;
        private final PreviewRoute navigationRoute;
        private final ItemPreviewReducer.State previewItem;
        private final IdentifiedList<ItemId, ItemPreviewReducer.State> previewItems;
        private final PreviewSource previewSource;
        private final PrintReducer.State printState;
        private final ItemId selectedItemId;
        private final boolean shouldBlockContentGestures;
        private final boolean shouldHandleImmersiveModeToggleTap;
        private final boolean shouldShowPageLabel;
        private final boolean taskCreatedSuccessfully;
        private final TopBarReducer.State topBarState;
        private final VideoPreviewReducer.State videoState;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, IdentifiedList identifiedList, ItemId itemId, PreviewSource previewSource, boolean z, FileActionsReducer.State state2, TopBarReducer.State state3, BottomBarReducer.State state4, CloseSource closeSource, boolean z2, PreviewRoute previewRoute, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                identifiedList = state.previewItems;
            }
            if ((i & 2) != 0) {
                itemId = state.selectedItemId;
            }
            if ((i & 4) != 0) {
                previewSource = state.previewSource;
            }
            if ((i & 8) != 0) {
                z = state.isNewlyCreatedFile;
            }
            if ((i & 16) != 0) {
                state2 = state.fileActionsState;
            }
            if ((i & 32) != 0) {
                state3 = state.topBarState;
            }
            if ((i & 64) != 0) {
                state4 = state.bottomBarState;
            }
            if ((i & 128) != 0) {
                closeSource = state.closingFrom;
            }
            if ((i & 256) != 0) {
                z2 = state.isImmersiveMode;
            }
            if ((i & 512) != 0) {
                previewRoute = state.navigationRoute;
            }
            if ((i & 1024) != 0) {
                z3 = state.isPlaylistInitialLoadingInProgress;
            }
            if ((i & 2048) != 0) {
                z4 = state.taskCreatedSuccessfully;
            }
            boolean z5 = z3;
            boolean z6 = z4;
            boolean z7 = z2;
            PreviewRoute previewRoute2 = previewRoute;
            BottomBarReducer.State state5 = state4;
            CloseSource closeSource2 = closeSource;
            FileActionsReducer.State state6 = state2;
            TopBarReducer.State state7 = state3;
            return state.copy(identifiedList, itemId, previewSource, z, state6, state7, state5, closeSource2, z7, previewRoute2, z5, z6);
        }

        public final IdentifiedList<ItemId, ItemPreviewReducer.State> component1() {
            return this.previewItems;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final PreviewRoute getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsPlaylistInitialLoadingInProgress() {
            return this.isPlaylistInitialLoadingInProgress;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getTaskCreatedSuccessfully() {
            return this.taskCreatedSuccessfully;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemId getSelectedItemId() {
            return this.selectedItemId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FileActionsReducer.State getFileActionsState() {
            return this.fileActionsState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final TopBarReducer.State getTopBarState() {
            return this.topBarState;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BottomBarReducer.State getBottomBarState() {
            return this.bottomBarState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CloseSource getClosingFrom() {
            return this.closingFrom;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsImmersiveMode() {
            return this.isImmersiveMode;
        }

        public final State copy(IdentifiedList<ItemId, ItemPreviewReducer.State> previewItems, ItemId selectedItemId, PreviewSource previewSource, boolean isNewlyCreatedFile, FileActionsReducer.State fileActionsState, TopBarReducer.State topBarState, BottomBarReducer.State bottomBarState, CloseSource closingFrom, boolean isImmersiveMode, PreviewRoute navigationRoute, boolean isPlaylistInitialLoadingInProgress, boolean taskCreatedSuccessfully) {
            Intrinsics.checkNotNullParameter(previewItems, "previewItems");
            Intrinsics.checkNotNullParameter(selectedItemId, "selectedItemId");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(fileActionsState, "fileActionsState");
            Intrinsics.checkNotNullParameter(topBarState, "topBarState");
            Intrinsics.checkNotNullParameter(bottomBarState, "bottomBarState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            return new State(previewItems, selectedItemId, previewSource, isNewlyCreatedFile, fileActionsState, topBarState, bottomBarState, closingFrom, isImmersiveMode, navigationRoute, isPlaylistInitialLoadingInProgress, taskCreatedSuccessfully);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.previewItems, state.previewItems) && Intrinsics.areEqual(this.selectedItemId, state.selectedItemId) && Intrinsics.areEqual(this.previewSource, state.previewSource) && this.isNewlyCreatedFile == state.isNewlyCreatedFile && Intrinsics.areEqual(this.fileActionsState, state.fileActionsState) && Intrinsics.areEqual(this.topBarState, state.topBarState) && Intrinsics.areEqual(this.bottomBarState, state.bottomBarState) && Intrinsics.areEqual(this.closingFrom, state.closingFrom) && this.isImmersiveMode == state.isImmersiveMode && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && this.isPlaylistInitialLoadingInProgress == state.isPlaylistInitialLoadingInProgress && this.taskCreatedSuccessfully == state.taskCreatedSuccessfully;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((this.previewItems.hashCode() * 31) + this.selectedItemId.hashCode()) * 31) + this.previewSource.hashCode()) * 31) + Boolean.hashCode(this.isNewlyCreatedFile)) * 31) + this.fileActionsState.hashCode()) * 31) + this.topBarState.hashCode()) * 31) + this.bottomBarState.hashCode()) * 31;
            CloseSource closeSource = this.closingFrom;
            return ((((((((iHashCode + (closeSource == null ? 0 : closeSource.hashCode())) * 31) + Boolean.hashCode(this.isImmersiveMode)) * 31) + this.navigationRoute.hashCode()) * 31) + Boolean.hashCode(this.isPlaylistInitialLoadingInProgress)) * 31) + Boolean.hashCode(this.taskCreatedSuccessfully);
        }

        public String toString() {
            return "State(previewItems=" + this.previewItems + ", selectedItemId=" + this.selectedItemId + ", previewSource=" + this.previewSource + ", isNewlyCreatedFile=" + this.isNewlyCreatedFile + ", fileActionsState=" + this.fileActionsState + ", topBarState=" + this.topBarState + ", bottomBarState=" + this.bottomBarState + ", closingFrom=" + this.closingFrom + ", isImmersiveMode=" + this.isImmersiveMode + ", navigationRoute=" + this.navigationRoute + ", isPlaylistInitialLoadingInProgress=" + this.isPlaylistInitialLoadingInProgress + ", taskCreatedSuccessfully=" + this.taskCreatedSuccessfully + ")";
        }

        /* JADX WARN: Code duplicated, block: B:138:0x01bc A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:141:0x01c1  */
        /* JADX WARN: Code duplicated, block: B:144:0x01c6 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:148:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:151:0x01d3 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:154:0x01d9  */
        /* JADX WARN: Code duplicated, block: B:157:0x01e8 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:158:0x01ea A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:166:0x0206  */
        /* JADX WARN: Code duplicated, block: B:169:0x0219 A[LOOP:0: B:164:0x0200->B:169:0x0219, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:173:0x0223  */
        /* JADX WARN: Code duplicated, block: B:174:0x0228  */
        /* JADX WARN: Code duplicated, block: B:177:0x021c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:178:0x021d A[EDGE_INSN: B:178:0x021d->B:171:0x021d BREAK  A[LOOP:0: B:164:0x0200->B:169:0x0219], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x00e8  */
        public State(IdentifiedList<ItemId, ItemPreviewReducer.State> previewItems, ItemId selectedItemId, PreviewSource previewSource, boolean z, FileActionsReducer.State fileActionsState, TopBarReducer.State topBarState, BottomBarReducer.State bottomBarState, CloseSource closeSource, boolean z2, PreviewRoute navigationRoute, boolean z3, boolean z4) {
            boolean z5;
            CreateAnnotationReducer.State createAnnotationState;
            FrameAnnotationReducer.State frameAnnotationState;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            Iterator<ItemPreviewReducer.State> it;
            int i;
            CodePreviewReducer.State state;
            CodePreviewReducer.Message message;
            DomainError error;
            DocumentPreviewReducer.State state2;
            Intrinsics.checkNotNullParameter(previewItems, "previewItems");
            Intrinsics.checkNotNullParameter(selectedItemId, "selectedItemId");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(fileActionsState, "fileActionsState");
            Intrinsics.checkNotNullParameter(topBarState, "topBarState");
            Intrinsics.checkNotNullParameter(bottomBarState, "bottomBarState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            this.previewItems = previewItems;
            this.selectedItemId = selectedItemId;
            this.previewSource = previewSource;
            this.isNewlyCreatedFile = z;
            this.fileActionsState = fileActionsState;
            this.topBarState = topBarState;
            this.bottomBarState = bottomBarState;
            this.closingFrom = closeSource;
            this.isImmersiveMode = z2;
            this.navigationRoute = navigationRoute;
            this.isPlaylistInitialLoadingInProgress = z3;
            this.taskCreatedSuccessfully = z4;
            Identifiable byId = previewItems.getById(selectedItemId);
            Intrinsics.checkNotNull(byId);
            ItemPreviewReducer.State state3 = (ItemPreviewReducer.State) byId;
            this.previewItem = state3;
            ItemState itemState = state3.getItemState();
            this.itemState = itemState;
            ItemState.Document document = itemState instanceof ItemState.Document ? (ItemState.Document) itemState : null;
            DocumentPreviewReducer.State state4 = document != null ? document.getState() : null;
            this.documentState = state4;
            ItemState.Image image = itemState instanceof ItemState.Image ? (ItemState.Image) itemState : null;
            ImagePreviewReducer.State state5 = image != null ? image.getState() : null;
            this.imageState = state5;
            ItemState.Code code = itemState instanceof ItemState.Code ? (ItemState.Code) itemState : null;
            this.codeState = code != null ? code.getState() : null;
            ItemState.Video video = itemState instanceof ItemState.Video ? (ItemState.Video) itemState : null;
            VideoPreviewReducer.State state6 = video != null ? video.getState() : null;
            this.videoState = state6;
            ItemState.BoxNote boxNote = itemState instanceof ItemState.BoxNote ? (ItemState.BoxNote) itemState : null;
            BoxNotePreviewReducer.State state7 = boxNote != null ? boxNote.getState() : null;
            this.boxNoteState = state7;
            DisplayMode displayMode = state4 != null ? state4.getDisplayMode() : null;
            this.displayMode = displayMode;
            if (z2) {
                z5 = false;
            } else {
                if ((state4 != null ? state4.getDisplayMode() : null) == DisplayMode.FullItem && state4.getIsPageInfoReady()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            this.shouldShowPageLabel = z5;
            this.fileModel = itemState.getFileModel();
            boolean z11 = fileActionsState.getRenameItemState() != null;
            this.isRenaming = z11;
            boolean zIsPermanentRenameMode = fileActionsState.isPermanentRenameMode();
            this.isPermanentRenameMode = zIsPermanentRenameMode;
            boolean z12 = z11 && !zIsPermanentRenameMode;
            this.isExplicitRenameMode = z12;
            ItemState.Document document2 = itemState instanceof ItemState.Document ? (ItemState.Document) itemState : null;
            boolean z13 = ((document2 == null || (state2 = document2.getState()) == null) ? null : state2.getSearchState()) != null;
            this.isSearching = z13;
            boolean z14 = displayMode == DisplayMode.Thumbnails || displayMode == DisplayMode.Outline;
            this.isShowingThumbnailsOrOutline = z14;
            this.shouldHandleImmersiveModeToggleTap = displayMode == DisplayMode.FullItem && !z12;
            if (state4 == null || (createAnnotationState = state4.getCreateAnnotationState()) == null) {
                createAnnotationState = state5 != null ? state5.getCreateAnnotationState() : null;
                if (createAnnotationState == null) {
                    createAnnotationState = (state6 == null || (frameAnnotationState = state6.getFrameAnnotationState()) == null) ? null : frameAnnotationState.getCreateAnnotationState();
                }
            }
            this.createAnnotationState = createAnnotationState;
            this.printState = state4 != null ? state4.getPrintState() : null;
            boolean z15 = createAnnotationState != null;
            this.isCreateAnnotationMode = z15;
            BoxNotePreviewReducer.State.Editing editing = state7 instanceof BoxNotePreviewReducer.State.Editing ? (BoxNotePreviewReducer.State.Editing) state7 : null;
            BoxNoteEditModeReducer.State editState = editing != null ? editing.getEditState() : null;
            this.boxNoteEditModeState = editState;
            this.isBoxNoteEditingMode = editState != null;
            ItemState.Error error2 = itemState instanceof ItemState.Error ? (ItemState.Error) itemState : null;
            boolean zIsItemNotFoundError = (error2 == null || (error = error2.getError()) == null) ? false : DomainErrorKt.isItemNotFoundError(error);
            this.hasUserLostAccessToFile = zIsItemNotFoundError;
            if (!z12) {
                if (createAnnotationState != null) {
                    z6 = true;
                    if (createAnnotationState.getIsInWritingCommentState()) {
                    }
                    this.shouldBlockContentGestures = z7;
                    if (!z13 || z15) {
                        z8 = z6;
                    } else {
                        z8 = false;
                    }
                    this.isAlternateBottomBarsShowing = z8;
                    if (!zIsItemNotFoundError || z14 || z2 || z8) {
                        z9 = false;
                    } else {
                        z9 = z6;
                    }
                    this.isBottomBarVisible = z9;
                    if (!z2 || z15 || z13) {
                        z10 = false;
                    } else {
                        z10 = z6;
                    }
                    this.arePreviewLabelsVisible = z10;
                    this.isCarouselEnabled = ((fileActionsState.getAvailableActions().contains(FileAction.Gallery) || z15) && (z3 || !(state3.getItemState() instanceof ItemState.Audio))) ? false : z6;
                    it = previewItems.iterator();
                    i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (Intrinsics.areEqual(it.next().getId(), this.selectedItemId)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    this.indexOfSelectedItemId = i;
                    state = this.codeState;
                    if (state != null) {
                        message = state.getMessage();
                    } else {
                        message = null;
                    }
                    this.codePreviewMessage = message;
                }
                z6 = true;
                z7 = false;
                this.shouldBlockContentGestures = z7;
                if (z13) {
                    z8 = z6;
                } else {
                    z8 = z6;
                }
                this.isAlternateBottomBarsShowing = z8;
                if (zIsItemNotFoundError) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                this.isBottomBarVisible = z9;
                if (z2) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                this.arePreviewLabelsVisible = z10;
                this.isCarouselEnabled = ((fileActionsState.getAvailableActions().contains(FileAction.Gallery) || z15) && (z3 || !(state3.getItemState() instanceof ItemState.Audio))) ? false : z6;
                it = previewItems.iterator();
                i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(it.next().getId(), this.selectedItemId)) {
                            break;
                            break;
                        }
                        i++;
                    }
                }
                this.indexOfSelectedItemId = i;
                state = this.codeState;
                if (state != null) {
                    message = state.getMessage();
                } else {
                    message = null;
                }
                this.codePreviewMessage = message;
            }
            z6 = true;
            z7 = z6;
            this.shouldBlockContentGestures = z7;
            if (z13) {
                z8 = z6;
            } else {
                z8 = z6;
            }
            this.isAlternateBottomBarsShowing = z8;
            if (zIsItemNotFoundError) {
                z9 = false;
            } else {
                z9 = false;
            }
            this.isBottomBarVisible = z9;
            if (z2) {
                z10 = false;
            } else {
                z10 = false;
            }
            this.arePreviewLabelsVisible = z10;
            this.isCarouselEnabled = ((fileActionsState.getAvailableActions().contains(FileAction.Gallery) || z15) && (z3 || !(state3.getItemState() instanceof ItemState.Audio))) ? false : z6;
            it = previewItems.iterator();
            i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (Intrinsics.areEqual(it.next().getId(), this.selectedItemId)) {
                        break;
                        break;
                    }
                    i++;
                }
            }
            this.indexOfSelectedItemId = i;
            state = this.codeState;
            if (state != null) {
                message = state.getMessage();
            } else {
                message = null;
            }
            this.codePreviewMessage = message;
        }

        public final IdentifiedList<ItemId, ItemPreviewReducer.State> getPreviewItems() {
            return this.previewItems;
        }

        public final ItemId getSelectedItemId() {
            return this.selectedItemId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(IdentifiedList identifiedList, ItemId itemId, PreviewSource previewSource, boolean z, FileActionsReducer.State state, TopBarReducer.State state2, BottomBarReducer.State state3, CloseSource closeSource, boolean z2, PreviewRoute previewRoute, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            FileActionsReducer.State state4;
            BottomBarReducer.State state5;
            PreviewSource previewSource2 = (i & 4) != 0 ? PreviewSource.Unknown.INSTANCE : previewSource;
            boolean z5 = (i & 8) != 0 ? false : z;
            if ((i & 16) != 0) {
                Identifiable byId = identifiedList.getById(itemId);
                Intrinsics.checkNotNull(byId);
                state4 = new FileActionsReducer.State(((ItemPreviewReducer.State) byId).getItemState().getFileModel(), previewSource2, null, false, null, null, null, null, null, null, null, null, null, 8188, null);
            } else {
                state4 = state;
            }
            TopBarReducer.State state6 = (i & 32) != 0 ? new TopBarReducer.State(false, null, false, null, null, 31, null) : state2;
            int i2 = 1;
            List list = null;
            Object[] objArr = 0;
            if ((i & 64) != 0) {
                state5 = new BottomBarReducer.State(list, i2, objArr == true ? 1 : 0);
            } else {
                state5 = state3;
            }
            this(identifiedList, itemId, previewSource2, z5, state4, state6, state5, (i & 128) != 0 ? null : closeSource, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? PreviewRoute.None.INSTANCE : previewRoute, (i & 1024) != 0 ? true : z3, (i & 2048) != 0 ? false : z4);
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final boolean isNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }

        public final FileActionsReducer.State getFileActionsState() {
            return this.fileActionsState;
        }

        public final TopBarReducer.State getTopBarState() {
            return this.topBarState;
        }

        public final BottomBarReducer.State getBottomBarState() {
            return this.bottomBarState;
        }

        public final CloseSource getClosingFrom() {
            return this.closingFrom;
        }

        public final boolean isImmersiveMode() {
            return this.isImmersiveMode;
        }

        public final PreviewRoute getNavigationRoute() {
            return this.navigationRoute;
        }

        public final boolean isPlaylistInitialLoadingInProgress() {
            return this.isPlaylistInitialLoadingInProgress;
        }

        public final boolean getTaskCreatedSuccessfully() {
            return this.taskCreatedSuccessfully;
        }

        public final ItemPreviewReducer.State getPreviewItem() {
            return this.previewItem;
        }

        public final ItemState getItemState() {
            return this.itemState;
        }

        public final boolean getShouldShowPageLabel() {
            return this.shouldShowPageLabel;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: isRenaming, reason: from getter */
        public final boolean getIsRenaming() {
            return this.isRenaming;
        }

        /* JADX INFO: renamed from: isPermanentRenameMode, reason: from getter */
        public final boolean getIsPermanentRenameMode() {
            return this.isPermanentRenameMode;
        }

        /* JADX INFO: renamed from: isExplicitRenameMode, reason: from getter */
        public final boolean getIsExplicitRenameMode() {
            return this.isExplicitRenameMode;
        }

        /* JADX INFO: renamed from: isSearching, reason: from getter */
        public final boolean getIsSearching() {
            return this.isSearching;
        }

        /* JADX INFO: renamed from: isShowingThumbnailsOrOutline, reason: from getter */
        public final boolean getIsShowingThumbnailsOrOutline() {
            return this.isShowingThumbnailsOrOutline;
        }

        public final boolean getShouldHandleImmersiveModeToggleTap() {
            return this.shouldHandleImmersiveModeToggleTap;
        }

        public final CreateAnnotationReducer.State getCreateAnnotationState() {
            return this.createAnnotationState;
        }

        public final PrintReducer.State getPrintState() {
            return this.printState;
        }

        /* JADX INFO: renamed from: isCreateAnnotationMode, reason: from getter */
        public final boolean getIsCreateAnnotationMode() {
            return this.isCreateAnnotationMode;
        }

        public final BoxNoteEditModeReducer.State getBoxNoteEditModeState() {
            return this.boxNoteEditModeState;
        }

        /* JADX INFO: renamed from: isBoxNoteEditingMode, reason: from getter */
        public final boolean getIsBoxNoteEditingMode() {
            return this.isBoxNoteEditingMode;
        }

        public final boolean getHasUserLostAccessToFile() {
            return this.hasUserLostAccessToFile;
        }

        public final boolean getShouldBlockContentGestures() {
            return this.shouldBlockContentGestures;
        }

        /* JADX INFO: renamed from: isBottomBarVisible, reason: from getter */
        public final boolean getIsBottomBarVisible() {
            return this.isBottomBarVisible;
        }

        public final boolean getArePreviewLabelsVisible() {
            return this.arePreviewLabelsVisible;
        }

        public final List<AudioTrack> getPlaylist() {
            IdentifiedList<ItemId, ItemPreviewReducer.State> identifiedList = this.previewItems;
            ArrayList arrayList = new ArrayList();
            for (ItemPreviewReducer.State state : identifiedList) {
                if (state.getItemState() instanceof ItemState.Audio) {
                    arrayList.add(state);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ItemState itemState = ((ItemPreviewReducer.State) it.next()).getItemState();
                Intrinsics.checkNotNull(itemState, "null cannot be cast to non-null type com.box.android.preview.item.ItemState.Audio");
                AudioPreviewReducer.State state2 = ((ItemState.Audio) itemState).getState();
                arrayList3.add(new AudioTrack(state2.getFileModel(), state2.getUri()));
            }
            return arrayList3;
        }

        /* JADX INFO: renamed from: isCarouselEnabled, reason: from getter */
        public final boolean getIsCarouselEnabled() {
            return this.isCarouselEnabled;
        }

        public final int getIndexOfSelectedItemId() {
            return this.indexOfSelectedItemId;
        }

        public final CodePreviewReducer.Message getCodePreviewMessage() {
            return this.codePreviewMessage;
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$State$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action;", "", "<init>", "()V", "Initialize", HttpHeaders.REFRESH, "ContentGestureBlocked", "ToggleImmersiveMode", "BackClicked", "Navigate", "NavigateToTarget", "SelectedItem", "Items", "FileActionsAction", "TopBarAction", "BottomBarAction", "SetSelectedItem", "ShowTaskCreatedSnackbar", "TaskCreatedSnackbarShown", "ObserveForPreviewItemsLocationChanges", "FetchItemsForCarousel", "FetchItemsForPlaylist", "RefreshPreviewItems", "CreateGalleryItemStates", "CreatePlaylistItemStates", "PlaylistLoadingFinishedOrNotNeeded", "Lcom/box/android/preview/preview/PreviewReducer$Action$BackClicked;", "Lcom/box/android/preview/preview/PreviewReducer$Action$BottomBarAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action$ContentGestureBlocked;", "Lcom/box/android/preview/preview/PreviewReducer$Action$CreateGalleryItemStates;", "Lcom/box/android/preview/preview/PreviewReducer$Action$CreatePlaylistItemStates;", "Lcom/box/android/preview/preview/PreviewReducer$Action$FetchItemsForCarousel;", "Lcom/box/android/preview/preview/PreviewReducer$Action$FetchItemsForPlaylist;", "Lcom/box/android/preview/preview/PreviewReducer$Action$FileActionsAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action$Initialize;", "Lcom/box/android/preview/preview/PreviewReducer$Action$Items;", "Lcom/box/android/preview/preview/PreviewReducer$Action$Navigate;", "Lcom/box/android/preview/preview/PreviewReducer$Action$NavigateToTarget;", "Lcom/box/android/preview/preview/PreviewReducer$Action$ObserveForPreviewItemsLocationChanges;", "Lcom/box/android/preview/preview/PreviewReducer$Action$PlaylistLoadingFinishedOrNotNeeded;", "Lcom/box/android/preview/preview/PreviewReducer$Action$Refresh;", "Lcom/box/android/preview/preview/PreviewReducer$Action$RefreshPreviewItems;", "Lcom/box/android/preview/preview/PreviewReducer$Action$SelectedItem;", "Lcom/box/android/preview/preview/PreviewReducer$Action$SetSelectedItem;", "Lcom/box/android/preview/preview/PreviewReducer$Action$ShowTaskCreatedSnackbar;", "Lcom/box/android/preview/preview/PreviewReducer$Action$TaskCreatedSnackbarShown;", "Lcom/box/android/preview/preview/PreviewReducer$Action$ToggleImmersiveMode;", "Lcom/box/android/preview/preview/PreviewReducer$Action$TopBarAction;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$Initialize;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 898087001;
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

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$Refresh;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Refresh extends Action {
            public static final int $stable = 0;
            public static final Refresh INSTANCE = new Refresh();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Refresh)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1879966386;
            }

            public String toString() {
                return HttpHeaders.REFRESH;
            }

            private Refresh() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$ContentGestureBlocked;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ContentGestureBlocked extends Action {
            public static final int $stable = 0;
            public static final ContentGestureBlocked INSTANCE = new ContentGestureBlocked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContentGestureBlocked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 967437523;
            }

            public String toString() {
                return "ContentGestureBlocked";
            }

            private ContentGestureBlocked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$ToggleImmersiveMode;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 146761057;
            }

            public String toString() {
                return "ToggleImmersiveMode";
            }

            private ToggleImmersiveMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$BackClicked;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "closeSource", "Lcom/box/android/preview/routing/CloseSource;", "ignorePendingAnnotation", "", "<init>", "(Lcom/box/android/preview/routing/CloseSource;Z)V", "getCloseSource", "()Lcom/box/android/preview/routing/CloseSource;", "getIgnorePendingAnnotation", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BackClicked extends Action {
            public static final int $stable = 0;
            private final CloseSource closeSource;
            private final boolean ignorePendingAnnotation;

            public static /* synthetic */ BackClicked copy$default(BackClicked backClicked, CloseSource closeSource, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    closeSource = backClicked.closeSource;
                }
                if ((i & 2) != 0) {
                    z = backClicked.ignorePendingAnnotation;
                }
                return backClicked.copy(closeSource, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CloseSource getCloseSource() {
                return this.closeSource;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIgnorePendingAnnotation() {
                return this.ignorePendingAnnotation;
            }

            public final BackClicked copy(CloseSource closeSource, boolean ignorePendingAnnotation) {
                Intrinsics.checkNotNullParameter(closeSource, "closeSource");
                return new BackClicked(closeSource, ignorePendingAnnotation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BackClicked)) {
                    return false;
                }
                BackClicked backClicked = (BackClicked) other;
                return Intrinsics.areEqual(this.closeSource, backClicked.closeSource) && this.ignorePendingAnnotation == backClicked.ignorePendingAnnotation;
            }

            public int hashCode() {
                return (this.closeSource.hashCode() * 31) + Boolean.hashCode(this.ignorePendingAnnotation);
            }

            public String toString() {
                return "BackClicked(closeSource=" + this.closeSource + ", ignorePendingAnnotation=" + this.ignorePendingAnnotation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackClicked(CloseSource closeSource, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(closeSource, "closeSource");
                this.closeSource = closeSource;
                this.ignorePendingAnnotation = z;
            }

            public /* synthetic */ BackClicked(CloseSource closeSource, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(closeSource, (i & 2) != 0 ? false : z);
            }

            public final CloseSource getCloseSource() {
                return this.closeSource;
            }

            public final boolean getIgnorePendingAnnotation() {
                return this.ignorePendingAnnotation;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$Navigate;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "route", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "(Lcom/box/android/preview/routing/PreviewRoute;)V", "getRoute", "()Lcom/box/android/preview/routing/PreviewRoute;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Navigate extends Action {
            public static final int $stable = 0;
            private final PreviewRoute route;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, PreviewRoute previewRoute, int i, Object obj) {
                if ((i & 1) != 0) {
                    previewRoute = navigate.route;
                }
                return navigate.copy(previewRoute);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewRoute getRoute() {
                return this.route;
            }

            public final Navigate copy(PreviewRoute route) {
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
            public Navigate(PreviewRoute route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final PreviewRoute getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$NavigateToTarget;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "previewNavigationTarget", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "<init>", "(Lcom/box/android/base/routing/preview/PreviewNavigationTarget;)V", "getPreviewNavigationTarget", "()Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToTarget extends Action {
            public static final int $stable = PreviewNavigationTarget.$stable;
            private final PreviewNavigationTarget previewNavigationTarget;

            public static /* synthetic */ NavigateToTarget copy$default(NavigateToTarget navigateToTarget, PreviewNavigationTarget previewNavigationTarget, int i, Object obj) {
                if ((i & 1) != 0) {
                    previewNavigationTarget = navigateToTarget.previewNavigationTarget;
                }
                return navigateToTarget.copy(previewNavigationTarget);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewNavigationTarget getPreviewNavigationTarget() {
                return this.previewNavigationTarget;
            }

            public final NavigateToTarget copy(PreviewNavigationTarget previewNavigationTarget) {
                Intrinsics.checkNotNullParameter(previewNavigationTarget, "previewNavigationTarget");
                return new NavigateToTarget(previewNavigationTarget);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToTarget) && Intrinsics.areEqual(this.previewNavigationTarget, ((NavigateToTarget) other).previewNavigationTarget);
            }

            public int hashCode() {
                return this.previewNavigationTarget.hashCode();
            }

            public String toString() {
                return "NavigateToTarget(previewNavigationTarget=" + this.previewNavigationTarget + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToTarget(PreviewNavigationTarget previewNavigationTarget) {
                super(null);
                Intrinsics.checkNotNullParameter(previewNavigationTarget, "previewNavigationTarget");
                this.previewNavigationTarget = previewNavigationTarget;
            }

            public final PreviewNavigationTarget getPreviewNavigationTarget() {
                return this.previewNavigationTarget;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$SelectedItem;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "<init>", "(Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectedItem extends Action {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final ItemPreviewReducer.Action action;

            public static /* synthetic */ SelectedItem copy$default(SelectedItem selectedItem, ItemPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = selectedItem.action;
                }
                return selectedItem.copy(action);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemPreviewReducer.Action getAction() {
                return this.action;
            }

            public final SelectedItem copy(ItemPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new SelectedItem(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectedItem) && Intrinsics.areEqual(this.action, ((SelectedItem) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "SelectedItem(action=" + this.action + ")";
            }

            /* JADX INFO: compiled from: PreviewReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$SelectedItem$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectedItem(ItemPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$Items;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", "getId", "()Lcom/box/android/domain/models/ItemId;", "getAction", "()Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Items extends Action implements EmbeddedItem<ItemId, ItemPreviewReducer.Action> {
            public static final int $stable = 8;
            private final ItemPreviewReducer.Action action;
            private final ItemId id;

            public static /* synthetic */ Items copy$default(Items items, ItemId itemId, ItemPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemId = items.id;
                }
                if ((i & 2) != 0) {
                    action = items.action;
                }
                return items.copy(itemId, action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemPreviewReducer.Action getAction() {
                return this.action;
            }

            public final Items copy(ItemId id, ItemPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                return new Items(id, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Items)) {
                    return false;
                }
                Items items = (Items) other;
                return Intrinsics.areEqual(this.id, items.id) && Intrinsics.areEqual(this.action, items.action);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "Items(id=" + this.id + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Items(ItemId id, ItemPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final ItemPreviewReducer.Action getAction() {
                return this.action;
            }

            public final ItemId getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$FileActionsAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/fileactions/FileActionsReducer$Action;)V", "getAction", "()Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileActionsAction extends Action implements Embedded<FileActionsReducer.Action> {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final FileActionsReducer.Action action;

            public static /* synthetic */ FileActionsAction copy$default(FileActionsAction fileActionsAction, FileActionsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = fileActionsAction.action;
                }
                return fileActionsAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileActionsReducer.Action getAction() {
                return this.action;
            }

            public final FileActionsAction copy(FileActionsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FileActionsAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileActionsAction) && Intrinsics.areEqual(this.action, ((FileActionsAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FileActionsAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileActionsAction(FileActionsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FileActionsReducer.Action getAction() {
                return this.action;
            }

            /* JADX INFO: compiled from: PreviewReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$FileActionsAction$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$TopBarAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;)V", "getAction", "()Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TopBarAction extends Action implements Embedded<TopBarReducer.Action> {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final TopBarReducer.Action action;

            public static /* synthetic */ TopBarAction copy$default(TopBarAction topBarAction, TopBarReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = topBarAction.action;
                }
                return topBarAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TopBarReducer.Action getAction() {
                return this.action;
            }

            public final TopBarAction copy(TopBarReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new TopBarAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TopBarAction) && Intrinsics.areEqual(this.action, ((TopBarAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "TopBarAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopBarAction(TopBarReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final TopBarReducer.Action getAction() {
                return this.action;
            }

            /* JADX INFO: compiled from: PreviewReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$TopBarAction$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$BottomBarAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;)V", "getAction", "()Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BottomBarAction extends Action implements Embedded<BottomBarReducer.Action> {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final BottomBarReducer.Action action;

            public static /* synthetic */ BottomBarAction copy$default(BottomBarAction bottomBarAction, BottomBarReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = bottomBarAction.action;
                }
                return bottomBarAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BottomBarReducer.Action getAction() {
                return this.action;
            }

            public final BottomBarAction copy(BottomBarReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BottomBarAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BottomBarAction) && Intrinsics.areEqual(this.action, ((BottomBarAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BottomBarAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomBarAction(BottomBarReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BottomBarReducer.Action getAction() {
                return this.action;
            }

            /* JADX INFO: compiled from: PreviewReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$BottomBarAction$Companion;", "", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$SetSelectedItem;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewNavigationMethod", "Lcom/box/android/preview/preview/PreviewNavigationMethod;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/preview/preview/PreviewNavigationMethod;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewNavigationMethod", "()Lcom/box/android/preview/preview/PreviewNavigationMethod;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetSelectedItem extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;
            private final PreviewNavigationMethod previewNavigationMethod;

            public static /* synthetic */ SetSelectedItem copy$default(SetSelectedItem setSelectedItem, FileModel fileModel, PreviewNavigationMethod previewNavigationMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = setSelectedItem.fileModel;
                }
                if ((i & 2) != 0) {
                    previewNavigationMethod = setSelectedItem.previewNavigationMethod;
                }
                return setSelectedItem.copy(fileModel, previewNavigationMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PreviewNavigationMethod getPreviewNavigationMethod() {
                return this.previewNavigationMethod;
            }

            public final SetSelectedItem copy(FileModel fileModel, PreviewNavigationMethod previewNavigationMethod) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(previewNavigationMethod, "previewNavigationMethod");
                return new SetSelectedItem(fileModel, previewNavigationMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetSelectedItem)) {
                    return false;
                }
                SetSelectedItem setSelectedItem = (SetSelectedItem) other;
                return Intrinsics.areEqual(this.fileModel, setSelectedItem.fileModel) && this.previewNavigationMethod == setSelectedItem.previewNavigationMethod;
            }

            public int hashCode() {
                return (this.fileModel.hashCode() * 31) + this.previewNavigationMethod.hashCode();
            }

            public String toString() {
                return "SetSelectedItem(fileModel=" + this.fileModel + ", previewNavigationMethod=" + this.previewNavigationMethod + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetSelectedItem(FileModel fileModel, PreviewNavigationMethod previewNavigationMethod) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(previewNavigationMethod, "previewNavigationMethod");
                this.fileModel = fileModel;
                this.previewNavigationMethod = previewNavigationMethod;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final PreviewNavigationMethod getPreviewNavigationMethod() {
                return this.previewNavigationMethod;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$ShowTaskCreatedSnackbar;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowTaskCreatedSnackbar extends Action {
            public static final int $stable = 0;
            public static final ShowTaskCreatedSnackbar INSTANCE = new ShowTaskCreatedSnackbar();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowTaskCreatedSnackbar)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 210171746;
            }

            public String toString() {
                return "ShowTaskCreatedSnackbar";
            }

            private ShowTaskCreatedSnackbar() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$TaskCreatedSnackbarShown;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TaskCreatedSnackbarShown extends Action {
            public static final int $stable = 0;
            public static final TaskCreatedSnackbarShown INSTANCE = new TaskCreatedSnackbarShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TaskCreatedSnackbarShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1245937870;
            }

            public String toString() {
                return "TaskCreatedSnackbarShown";
            }

            private TaskCreatedSnackbarShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$ObserveForPreviewItemsLocationChanges;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveForPreviewItemsLocationChanges extends Action {
            public static final int $stable = 0;
            public static final ObserveForPreviewItemsLocationChanges INSTANCE = new ObserveForPreviewItemsLocationChanges();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ObserveForPreviewItemsLocationChanges)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 586774688;
            }

            public String toString() {
                return "ObserveForPreviewItemsLocationChanges";
            }

            private ObserveForPreviewItemsLocationChanges() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$FetchItemsForCarousel;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchItemsForCarousel extends Action {
            public static final int $stable = 0;
            public static final FetchItemsForCarousel INSTANCE = new FetchItemsForCarousel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchItemsForCarousel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2032344102;
            }

            public String toString() {
                return "FetchItemsForCarousel";
            }

            private FetchItemsForCarousel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$FetchItemsForPlaylist;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchItemsForPlaylist extends Action {
            public static final int $stable = 0;
            public static final FetchItemsForPlaylist INSTANCE = new FetchItemsForPlaylist();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchItemsForPlaylist)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -155777972;
            }

            public String toString() {
                return "FetchItemsForPlaylist";
            }

            private FetchItemsForPlaylist() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$RefreshPreviewItems;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshPreviewItems extends Action {
            public static final int $stable = 0;
            public static final RefreshPreviewItems INSTANCE = new RefreshPreviewItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshPreviewItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1603407018;
            }

            public String toString() {
                return "RefreshPreviewItems";
            }

            private RefreshPreviewItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$CreateGalleryItemStates;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateGalleryItemStates extends Action {
            public static final int $stable = 8;
            private final List<FileModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CreateGalleryItemStates copy$default(CreateGalleryItemStates createGalleryItemStates, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = createGalleryItemStates.items;
                }
                return createGalleryItemStates.copy(list);
            }

            public final List<FileModel> component1() {
                return this.items;
            }

            public final CreateGalleryItemStates copy(List<FileModel> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new CreateGalleryItemStates(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateGalleryItemStates) && Intrinsics.areEqual(this.items, ((CreateGalleryItemStates) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "CreateGalleryItemStates(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateGalleryItemStates(List<FileModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<FileModel> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$CreatePlaylistItemStates;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/services/AudioItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreatePlaylistItemStates extends Action {
            public static final int $stable = 8;
            private final List<AudioItem> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CreatePlaylistItemStates copy$default(CreatePlaylistItemStates createPlaylistItemStates, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = createPlaylistItemStates.items;
                }
                return createPlaylistItemStates.copy(list);
            }

            public final List<AudioItem> component1() {
                return this.items;
            }

            public final CreatePlaylistItemStates copy(List<? extends AudioItem> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new CreatePlaylistItemStates(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreatePlaylistItemStates) && Intrinsics.areEqual(this.items, ((CreatePlaylistItemStates) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "CreatePlaylistItemStates(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public CreatePlaylistItemStates(List<? extends AudioItem> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<AudioItem> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/PreviewReducer$Action$PlaylistLoadingFinishedOrNotNeeded;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PlaylistLoadingFinishedOrNotNeeded extends Action {
            public static final int $stable = 0;
            public static final PlaylistLoadingFinishedOrNotNeeded INSTANCE = new PlaylistLoadingFinishedOrNotNeeded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PlaylistLoadingFinishedOrNotNeeded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2097595474;
            }

            public String toString() {
                return "PlaylistLoadingFinishedOrNotNeeded";
            }

            private PlaylistLoadingFinishedOrNotNeeded() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reducePreview(State state, Action action) {
        ItemState itemState;
        ReducerResult<State, Action> selectedItem;
        Effect effectNone;
        int i = 2;
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(new Action.SelectedItem(ItemPreviewReducer.Action.Initialize.INSTANCE)), new Effect(PreviewReducerHelpersKt.evaluateFileActions(Action.FileActionsAction.INSTANCE, state.getPreviewItem().getItemState())), new Effect(Action.FetchItemsForCarousel.INSTANCE), new Effect(Action.FetchItemsForPlaylist.INSTANCE), trackRecentItemEffect(state.getItemState())));
        }
        if (action instanceof Action.ObserveForPreviewItemsLocationChanges) {
            return new ReducerResult<>(state, observeForPreviewItemsLocationChanges(state));
        }
        if (action instanceof Action.FetchItemsForCarousel) {
            return new ReducerResult<>(state, fetchAndObserveItemsForCarousel(state));
        }
        if (action instanceof Action.FetchItemsForPlaylist) {
            return new ReducerResult<>(state, fetchAndObserveItemsForPlaylist(state));
        }
        if (action instanceof Action.RefreshPreviewItems) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Action.FetchItemsForCarousel.INSTANCE, Action.FetchItemsForPlaylist.INSTANCE));
        }
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        if (action instanceof Action.CreateGalleryItemStates) {
            Action.CreateGalleryItemStates createGalleryItemStates = (Action.CreateGalleryItemStates) action;
            List<FileModel> items = createGalleryItemStates.getItems();
            if (!(items instanceof Collection) || !items.isEmpty()) {
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((FileModel) it.next()).getItemId(), state.getSelectedItemId())) {
                        List<FileModel> items2 = createGalleryItemStates.getItems();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
                        for (FileModel fileModel : items2) {
                            ItemPreviewReducer.State state2 = (ItemPreviewReducer.State) state.getPreviewItems().getById(fileModel.getItemId());
                            if (state2 == null) {
                                state2 = new ItemPreviewReducer.State(new ItemState.Uninitialized(fileModel), null, null, false, null, 30, null);
                            }
                            arrayList.add(state2);
                        }
                        return new ReducerResult<>(State.copy$default(state, new IdentifiedList((Identifiable[]) arrayList.toArray(new ItemPreviewReducer.State[0])), null, null, false, null, null, null, null, false, null, false, false, 4094, null), new Effect(Action.ObserveForPreviewItemsLocationChanges.INSTANCE));
                    }
                }
            }
            return new ReducerResult<>(state, effect, i, objArr11 == true ? 1 : 0);
        }
        if (action instanceof Action.CreatePlaylistItemStates) {
            List<AudioItem> items3 = ((Action.CreatePlaylistItemStates) action).getItems();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : items3) {
                if (obj instanceof AudioItem.Playable) {
                    arrayList2.add(obj);
                }
            }
            ArrayList<AudioItem.Playable> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (AudioItem.Playable playable : arrayList3) {
                arrayList4.add(new AudioTrack(playable.getFileModel(), playable.getUri()));
            }
            ArrayList<AudioTrack> arrayList5 = arrayList4;
            if (!(arrayList5 instanceof Collection) || !arrayList5.isEmpty()) {
                Iterator it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((AudioTrack) it2.next()).getFileModel().getItemId(), state.getSelectedItemId())) {
                        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                        for (AudioTrack audioTrack : arrayList5) {
                            ItemPreviewReducer.State state3 = (ItemPreviewReducer.State) state.getPreviewItems().getById(audioTrack.getFileModel().getItemId());
                            if (state3 == null) {
                                boolean z = false;
                                state3 = new ItemPreviewReducer.State(new ItemState.Audio(new AudioPreviewReducer.State(audioTrack.getFileModel(), audioTrack.getUri(), z, null, null, false, 60, null)), null, null, z, 0 == true ? 1 : 0, 30, null);
                            }
                            arrayList6.add(state3);
                        }
                        return new ReducerResult<>(State.copy$default(state, new IdentifiedList((Identifiable[]) arrayList6.toArray(new ItemPreviewReducer.State[0])), null, null, false, null, null, null, null, false, null, false, false, 4094, null), new Effect(Action.ObserveForPreviewItemsLocationChanges.INSTANCE));
                    }
                }
            }
            return new ReducerResult<>(state, objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
        }
        if (action instanceof Action.PlaylistLoadingFinishedOrNotNeeded) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, false, null, false, false, 3071, null), null, i, 0 == true ? 1 : 0);
        }
        if (action instanceof Action.Refresh) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.refreshPdfPreviewConfiguration(Action.SelectedItem.INSTANCE)));
        }
        if (action instanceof Action.ContentGestureBlocked) {
            if (state.getIsExplicitRenameMode()) {
                effectNone = new Effect(PreviewReducerHelpersKt.rename(Action.FileActionsAction.INSTANCE, UpdateItemInfoReducer.Action.Finish.INSTANCE));
            } else {
                CreateAnnotationReducer.State createAnnotationState = state.getCreateAnnotationState();
                if (createAnnotationState != null && createAnnotationState.getIsInWritingCommentState()) {
                    effectNone = new Effect(PreviewReducerHelpersKt.createAnnotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), CreateAnnotationReducer.Action.Drawing.INSTANCE));
                } else {
                    effectNone = Effect.INSTANCE.none();
                }
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.BackClicked) {
            return handleBackClicked(state, (Action.BackClicked) action);
        }
        if (action instanceof Action.ToggleImmersiveMode) {
            return handleToggleImmersiveMode(state);
        }
        if (action instanceof Action.Navigate) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, false, ((Action.Navigate) action).getRoute(), false, false, 3583, null), null, i, 0 == true ? 1 : 0);
        }
        if (action instanceof Action.ShowTaskCreatedSnackbar) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, false, null, false, true, 2047, null), null, i, 0 == true ? 1 : 0);
        }
        if (action instanceof Action.TaskCreatedSnackbarShown) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, false, null, false, false, 2047, null), null, i, 0 == true ? 1 : 0);
        }
        if (action instanceof Action.NavigateToTarget) {
            return navigateToTarget(state, (Action.NavigateToTarget) action);
        }
        if (action instanceof Action.SelectedItem) {
            return new ReducerResult<>(state, new Effect(new Action.Items(state.getSelectedItemId(), ((Action.SelectedItem) action).getAction())));
        }
        if (action instanceof Action.Items) {
            return PreviewReducerReducingItemKt.reduceItems(this, (Action.Items) action, state);
        }
        if (action instanceof Action.SetSelectedItem) {
            Action.SetSelectedItem setSelectedItem = (Action.SetSelectedItem) action;
            if (Intrinsics.areEqual(state.getSelectedItemId(), setSelectedItem.getFileModel().getItemId())) {
                return new ReducerResult<>(state, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
            }
            ItemPreviewReducer.State state4 = (ItemPreviewReducer.State) state.getPreviewItems().getById(setSelectedItem.getFileModel().getItemId());
            if (state4 == null || (itemState = state4.getItemState()) == null || (selectedItem = setSelectedItem(state, setSelectedItem, itemState)) == null) {
                return new ReducerResult<>(PreviewReducerHelpersKt.createState(State.INSTANCE, setSelectedItem.getFileModel(), state.getPreviewSource(), state.isNewlyCreatedFile()), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
            }
            return selectedItem;
        }
        if (action instanceof Action.FileActionsAction) {
            return PreviewReducerReducingActionsKt.reduceFileActions(state, ((Action.FileActionsAction) action).getAction(), this.environment);
        }
        if (action instanceof Action.BottomBarAction) {
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (action instanceof Action.TopBarAction) {
            return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ReducerResult<State, Action> setSelectedItem(State state, Action.SetSelectedItem action, ItemState itemState) {
        return new ReducerResult<>(State.copy$default(state, null, action.getFileModel().getItemId(), null, false, new FileActionsReducer.State(itemState.getFileModel(), state.getPreviewSource(), null, false, null, null, null, null, null, null, null, null, null, 8188, null), null, null, null, false, null, false, false, 4077, null), Effect.INSTANCE.merge(videoStateEffect(state.getPreviewItem()), new Effect(PreviewReducerHelpersKt.evaluateFileActions(Action.FileActionsAction.INSTANCE, itemState)), new Effect(PreviewReducerHelpersKt.annotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), new AnnotationsReducer.Action.AnnotationsVisibilityChanged(true ^ state.isImmersiveMode()))), trackRecentItemEffect(itemState)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$trackRecentItemEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$trackRecentItemEffect$1", f = "PreviewReducer.kt", i = {}, l = {393}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16851 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemState $itemState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16851(ItemState itemState, Continuation<? super C16851> continuation) {
            super(1, continuation);
            this.$itemState = itemState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PreviewReducer.this.new C16851(this.$itemState, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16851) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreviewReducer.this.getEnvironment().getTrackRecentPreviewItemInteractor().invoke(this.$itemState.getFileModel(), PreviewReducer.this.config.getSharedLink(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Effect<Action> trackRecentItemEffect(ItemState itemState) {
        return Effect.INSTANCE.fireAndForget(new C16851(itemState, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceHighlightDisabling(State state, Action action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (action instanceof Action.FileActionsAction) {
            Action.FileActionsAction fileActionsAction = (Action.FileActionsAction) action;
            if (fileActionsAction.getAction() instanceof FileActionsReducer.Action.PerformAction) {
                if (((FileActionsReducer.Action.PerformAction) fileActionsAction.getAction()).getAction() == FileAction.BoxAi) {
                    return new ReducerResult<>(state, effect, i, objArr5 == true ? 1 : 0);
                }
                return new ReducerResult<>(state, new Effect(new Action.Items(state.getSelectedItemId(), new ItemPreviewReducer.Action.DocumentPreview(new DocumentPreviewReducer.Action.Citations(CitationHighlightReducer.Action.Close.INSTANCE)))));
            }
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    private final Effect<Action> videoStateEffect(ItemPreviewReducer.State currentItemState) {
        if (currentItemState.getItemState() instanceof ItemState.Video) {
            return new Effect<>(new Action.Items(currentItemState.getId(), new ItemPreviewReducer.Action.VideoPreview(VideoPreviewReducer.Action.PauseVideo.INSTANCE)));
        }
        return Effect.INSTANCE.none();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> handleToggleImmersiveMode(State state) {
        if (!state.getIsSearching()) {
            boolean zIsImmersiveMode = state.isImmersiveMode();
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, null, !zIsImmersiveMode, null, false, false, 3839, null), new Effect(PreviewReducerHelpersKt.annotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), new AnnotationsReducer.Action.AnnotationsVisibilityChanged(zIsImmersiveMode))));
        }
        return new ReducerResult<>(state, null, 2, 0 == true ? 1 : 0);
    }

    private final ReducerResult<State, Action> handleBackClicked(State state, Action.BackClicked action) {
        Effect effectNone;
        UpdateItemInfoReducer.State renameItemState;
        UpdateItemInfoReducer.State renameItemState2;
        CreateAnnotationReducer.State createAnnotationState = state.getCreateAnnotationState();
        boolean z = createAnnotationState != null && createAnnotationState.hasPendingAnnotation();
        if (state.getIsExplicitRenameMode() && (renameItemState2 = state.getFileActionsState().getRenameItemState()) != null && !renameItemState2.isRenamePending()) {
            return new ReducerResult<>(state, new Effect(new Action.FileActionsAction(new FileActionsReducer.Action.Rename(UpdateItemInfoReducer.Action.Finish.INSTANCE))));
        }
        CreateAnnotationReducer.State createAnnotationState2 = state.getCreateAnnotationState();
        if (createAnnotationState2 != null && createAnnotationState2.getIsInWritingCommentState()) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.createAnnotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), CreateAnnotationReducer.Action.Drawing.INSTANCE)));
        }
        if (!action.getIgnorePendingAnnotation() && z) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.createAnnotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), CreateAnnotationReducer.Action.ExitSelected.INSTANCE)));
        }
        if (state.getIsCreateAnnotationMode()) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.createAnnotationAction(Action.SelectedItem.INSTANCE, state.getPreviewItem(), CreateAnnotationReducer.Action.Exit.INSTANCE)));
        }
        if (state.getIsSearching()) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.searchAction(Action.SelectedItem.INSTANCE, DocumentSearchReducer.Action.CloseSearchClicked.INSTANCE)));
        }
        if (state.getIsShowingThumbnailsOrOutline()) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.document(Action.SelectedItem.INSTANCE, new DocumentPreviewReducer.Action.SwitchDisplayMode(DisplayMode.FullItem))));
        }
        if (state.getIsPermanentRenameMode() && (renameItemState = state.getFileActionsState().getRenameItemState()) != null && renameItemState.getHasUnsavedNameChanges()) {
            effectNone = new Effect(PreviewReducerHelpersKt.rename(Action.FileActionsAction.INSTANCE, UpdateItemInfoReducer.Action.PerformUpdate.INSTANCE));
        } else {
            effectNone = Effect.INSTANCE.none();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, action.getCloseSource(), false, null, false, false, 3967, null), Effect.INSTANCE.merge(effectNone, Effect.INSTANCE.fireAndForget(new C16831(state, null))));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$handleBackClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$handleBackClicked$1", f = "PreviewReducer.kt", i = {}, l = {515}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16831 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16831(State state, Continuation<? super C16831> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PreviewReducer.this.new C16831(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16831) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = PreviewReducer.this.getEnvironment().getFileActionsManager().canSaveFileForOfflineUse(this.$state.getFileModel(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                PreviewReducer.this.getEnvironment().getItemPreviewEnvironment().getPreviewService().deleteCachedPreview(this.$state.getFileModel());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/preview/PreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1", f = "PreviewReducer.kt", i = {0, 0, 0}, l = {548}, m = "invokeSuspend", n = {"$this$flow", "previewItems", "itemFlows"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C16841 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PreviewReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16841(State state, PreviewReducer previewReducer, Continuation<? super C16841> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = previewReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16841 c16841 = new C16841(this.$state, this.this$0, continuation);
            c16841.L$0 = obj;
            return c16841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16841) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IdentifiedList<ItemId, ItemPreviewReducer.State> previewItems = this.$state.getPreviewItems();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(previewItems, 10));
                Iterator<ItemPreviewReducer.State> it = previewItems.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getFileModel());
                }
                ArrayList arrayList2 = arrayList;
                ArrayList<FileModel> arrayList3 = arrayList2;
                PreviewReducer previewReducer = this.this$0;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (final FileModel fileModel : arrayList3) {
                    final Flow<Result<ItemModel, DomainError>> flowObserveItem = previewReducer.getEnvironment().getItemService().observeItem(fileModel.getItemId(), DataPolicy.CACHE);
                    final Flow flowDrop = FlowKt.drop(new Flow<ItemModel>() { // from class: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$mapNotNull$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super ItemModel> flowCollector2, Continuation continuation) {
                            Object objCollect = flowObserveItem.collect(new AnonymousClass2(flowCollector2), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$mapNotNull$1$2, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$mapNotNull$1$2", f = "PreviewReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
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
                                    Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                                    if (orNull != null) {
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(orNull);
                                        anonymousClass1.I$0 = 0;
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(orNull, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    int i2 = anonymousClass1.I$0;
                                    Object obj3 = anonymousClass1.L$4;
                                    Object obj4 = anonymousClass1.L$2;
                                    Object obj5 = anonymousClass1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, 1);
                    arrayList4.add(FlowKt.transformLatest(FlowKt.distinctUntilChanged(new Flow<ItemModel>() { // from class: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$filter$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super ItemModel> flowCollector2, Continuation continuation) {
                            Object objCollect = flowDrop.collect(new AnonymousClass2(flowCollector2, fileModel), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$filter$1$2, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FileModel $fileModel$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$filter$1$2$1, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$filter$1$2", f = "PreviewReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                            public AnonymousClass2(FlowCollector flowCollector, FileModel fileModel) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$fileModel$inlined = fileModel;
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
                                    FolderModel parentFolder = ((ItemModel) obj).getParentFolder();
                                    ItemId itemId = parentFolder != null ? parentFolder.getItemId() : null;
                                    FolderModel parentFolder2 = this.$fileModel$inlined.getParentFolder();
                                    if (!Intrinsics.areEqual(itemId, parentFolder2 != null ? parentFolder2.getItemId() : null)) {
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                        anonymousClass1.I$0 = 0;
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
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
                    }), new PreviewReducer$observeForPreviewItemsLocationChanges$1$invokeSuspend$lambda$1$$inlined$flatMapLatest$1(null, previewReducer)));
                }
                ArrayList arrayList5 = arrayList4;
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList5);
                this.label = 1;
                if (FlowKt.merge(arrayList5).collect(new C01811(flowCollector), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$observeForPreviewItemsLocationChanges$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final /* synthetic */ class C01811 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ FlowCollector<Action> $tmp0;

            /* JADX WARN: Multi-variable type inference failed */
            C01811(FlowCollector<? super Action> flowCollector) {
                this.$tmp0 = flowCollector;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return new FunctionReferenceImpl(2, this.$tmp0, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            public final Object emit(Action action, Continuation<? super Unit> continuation) {
                Object objEmit = this.$tmp0.emit(action, continuation);
                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Action) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final Effect<Action> observeForPreviewItemsLocationChanges(State state) {
        return EffectKt.toEffect(FlowKt.flow(new C16841(state, this, null))).cancellable("observeForPreviewItemsLocationChanges", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0051 A[PHI: r8
      0x0051: PHI (r8v1 com.box.android.domain.models.item.ItemModel) = (r8v2 com.box.android.domain.models.item.ItemModel), (r8v5 com.box.android.domain.models.item.ItemModel) binds: [B:18:0x004e, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r9 == r1) goto L22;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0063 -> B:23:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitUntilLocalCacheUpdated(com.box.android.domain.models.item.ItemModel r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.box.android.preview.preview.PreviewReducer.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.preview.preview.PreviewReducer$awaitUntilLocalCacheUpdated$1 r0 = (com.box.android.preview.preview.PreviewReducer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.preview.preview.PreviewReducer$awaitUntilLocalCacheUpdated$1 r0 = new com.box.android.preview.preview.PreviewReducer$awaitUntilLocalCacheUpdated$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.L$0
            com.box.android.domain.models.item.ItemModel r8 = (com.box.android.domain.models.item.ItemModel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L66
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r8 = r0.L$0
            com.box.android.domain.models.item.ItemModel r8 = (com.box.android.domain.models.item.ItemModel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
        L44:
            r0.L$0 = r8
            r0.label = r4
            r5 = 50
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r9 != r1) goto L51
            goto L65
        L51:
            com.box.android.preview.preview.PreviewEnvironment r9 = r7.environment
            com.box.android.domain.services.ILocalItemService r9 = r9.getItemService()
            com.box.android.domain.models.ItemId r2 = r8.getItemId()
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.getItemByLocalId(r2, r0)
            if (r9 != r1) goto L66
        L65:
            return r1
        L66:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            java.lang.Object r9 = com.box.android.domain.utils.result.ResultKt.getOrNull(r9)
            com.box.android.domain.models.item.ItemModel r9 = (com.box.android.domain.models.item.ItemModel) r9
            r2 = 0
            if (r9 == 0) goto L7c
            com.box.android.domain.models.item.FolderModel r9 = r9.getParentFolder()
            if (r9 == 0) goto L7c
            com.box.android.domain.models.ItemId r9 = r9.getItemId()
            goto L7d
        L7c:
            r9 = r2
        L7d:
            com.box.android.domain.models.item.FolderModel r5 = r8.getParentFolder()
            if (r5 == 0) goto L87
            com.box.android.domain.models.ItemId r2 = r5.getItemId()
        L87:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r9 == 0) goto L44
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewReducer.awaitUntilLocalCacheUpdated(com.box.android.domain.models.item.ItemModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForCarousel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/preview/PreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForCarousel$1", f = "PreviewReducer.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {564, 565, 565}, m = "invokeSuspend", n = {"$this$flow", "isGalleryAvailable", "$this$flow", "actualModel", "isGalleryAvailable", "$this$flow", "actualModel", "isGalleryAvailable"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"}, v = 1)
    static final class C16801 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16801(State state, Continuation<? super C16801> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16801 c16801 = PreviewReducer.this.new C16801(this.$state, continuation);
            c16801.L$0 = obj;
            return c16801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16801) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0094  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r11).collect(new com.box.android.preview.preview.PreviewReducer.C16801.C01791(), r10) == r1) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r10.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L36
                if (r2 == r5) goto L30
                if (r2 == r4) goto L26
                if (r2 != r3) goto L1e
                java.lang.Object r10 = r10.L$1
                com.box.android.domain.models.item.FileModel r10 = (com.box.android.domain.models.item.FileModel) r10
                kotlin.ResultKt.throwOnFailure(r11)
                goto Lba
            L1e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L26:
                boolean r2 = r10.Z$0
                java.lang.Object r4 = r10.L$1
                com.box.android.domain.models.item.FileModel r4 = (com.box.android.domain.models.item.FileModel) r4
                kotlin.ResultKt.throwOnFailure(r11)
                goto L97
            L30:
                boolean r2 = r10.Z$0
                kotlin.ResultKt.throwOnFailure(r11)
                goto L6c
            L36:
                kotlin.ResultKt.throwOnFailure(r11)
                com.box.android.preview.preview.PreviewReducer r11 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewEnvironment r11 = r11.getEnvironment()
                com.box.android.domain.services.IGalleryItemsService r11 = r11.getGalleryItemsService()
                com.box.android.preview.preview.PreviewReducer$State r2 = r10.$state
                com.box.android.domain.models.preview.PreviewSource r2 = r2.getPreviewSource()
                com.box.android.preview.preview.PreviewReducer$State r6 = r10.$state
                com.box.android.domain.models.item.FileModel r6 = r6.getFileModel()
                boolean r11 = r11.isGalleryAvailable(r2, r6)
                if (r11 == 0) goto Lba
                com.box.android.preview.preview.PreviewReducer r2 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewReducer$State r6 = r10.$state
                r7 = r10
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r10.L$0 = r0
                r10.Z$0 = r11
                r10.label = r5
                java.lang.Object r2 = com.box.android.preview.preview.PreviewReducer.access$getActualFileModel(r2, r6, r7)
                if (r2 != r1) goto L69
                goto Lb9
            L69:
                r9 = r2
                r2 = r11
                r11 = r9
            L6c:
                com.box.android.domain.models.item.FileModel r11 = (com.box.android.domain.models.item.FileModel) r11
                com.box.android.preview.preview.PreviewReducer r5 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewEnvironment r5 = r5.getEnvironment()
                com.box.android.domain.services.IGalleryItemsService r5 = r5.getGalleryItemsService()
                com.box.android.preview.preview.PreviewReducer$State r6 = r10.$state
                com.box.android.domain.models.preview.PreviewSource r6 = r6.getPreviewSource()
                r7 = r10
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r10.L$0 = r0
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                r10.L$1 = r8
                r10.Z$0 = r2
                r10.label = r4
                java.lang.Object r4 = r5.fetchPreviewItems(r6, r11, r7)
                if (r4 != r1) goto L94
                goto Lb9
            L94:
                r9 = r4
                r4 = r11
                r11 = r9
            L97:
                kotlinx.coroutines.flow.Flow r11 = (kotlinx.coroutines.flow.Flow) r11
                com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForCarousel$1$1 r5 = new com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForCarousel$1$1
                r5.<init>()
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                r6 = r10
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r10.L$1 = r0
                r10.Z$0 = r2
                r10.label = r3
                java.lang.Object r10 = r11.collect(r5, r6)
                if (r10 != r1) goto Lba
            Lb9:
                return r1
            Lba:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewReducer.C16801.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> fetchAndObserveItemsForCarousel(State state) {
        return EffectKt.toEffect(FlowKt.flow(new C16801(state, null))).cancellable("fetchItemsForCarousel", true);
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/preview/PreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1", f = "PreviewReducer.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {574, 575, 584}, m = "invokeSuspend", n = {"$this$flow", "isPlaylistAvailable", "$this$flow", "actualModel", "isPlaylistAvailable", "$this$flow", "isPlaylistAvailable"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "Z$0"}, v = 1)
    static final class C16811 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16811(State state, Continuation<? super C16811> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16811 c16811 = PreviewReducer.this.new C16811(this.$state, continuation);
            c16811.L$0 = obj;
            return c16811;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16811) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
        
            if (r7.this$0.getEnvironment().getAudioPlaylistItemsService().fetchAudioPlaylistItems(r8, r7.$state.getPreviewSource()).collect(new com.box.android.preview.preview.PreviewReducer.C16811.C01801(r7.$state, r0), r7) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00b4, code lost:
        
            if (r0.emit(com.box.android.preview.preview.PreviewReducer.Action.PlaylistLoadingFinishedOrNotNeeded.INSTANCE, r7) == r1) goto L25;
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
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2d
                if (r2 == r5) goto L27
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L22
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r7 = r7.L$1
                com.box.android.domain.models.item.FileModel r7 = (com.box.android.domain.models.item.FileModel) r7
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                goto Lb7
            L27:
                boolean r2 = r7.Z$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L60
            L2d:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.preview.preview.PreviewReducer r8 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewEnvironment r8 = r8.getEnvironment()
                com.box.android.domain.services.IAudioPlaylistItemsService r8 = r8.getAudioPlaylistItemsService()
                com.box.android.preview.preview.PreviewReducer$State r2 = r7.$state
                com.box.android.domain.models.item.FileModel r2 = r2.getFileModel()
                com.box.android.preview.preview.PreviewReducer$State r6 = r7.$state
                com.box.android.domain.models.preview.PreviewSource r6 = r6.getPreviewSource()
                boolean r2 = r8.isAudioPlaylistAvailable(r2, r6)
                if (r2 == 0) goto L99
                com.box.android.preview.preview.PreviewReducer r8 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewReducer$State r3 = r7.$state
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.Z$0 = r2
                r7.label = r5
                java.lang.Object r8 = com.box.android.preview.preview.PreviewReducer.access$getActualFileModel(r8, r3, r6)
                if (r8 != r1) goto L60
                goto Lb6
            L60:
                com.box.android.domain.models.item.FileModel r8 = (com.box.android.domain.models.item.FileModel) r8
                com.box.android.preview.preview.PreviewReducer r3 = com.box.android.preview.preview.PreviewReducer.this
                com.box.android.preview.preview.PreviewEnvironment r3 = r3.getEnvironment()
                com.box.android.domain.services.IAudioPlaylistItemsService r3 = r3.getAudioPlaylistItemsService()
                com.box.android.preview.preview.PreviewReducer$State r5 = r7.$state
                com.box.android.domain.models.preview.PreviewSource r5 = r5.getPreviewSource()
                kotlinx.coroutines.flow.Flow r3 = r3.fetchAudioPlaylistItems(r8, r5)
                com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1 r5 = new com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1
                com.box.android.preview.preview.PreviewReducer$State r6 = r7.$state
                r5.<init>(r6, r0)
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r0
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.Z$0 = r2
                r7.label = r4
                java.lang.Object r7 = r3.collect(r5, r6)
                if (r7 != r1) goto Lb7
                goto Lb6
            L99:
                com.box.android.preview.preview.PreviewReducer$State r8 = r7.$state
                boolean r8 = r8.isPlaylistInitialLoadingInProgress()
                if (r8 == 0) goto Lb7
                com.box.android.preview.preview.PreviewReducer$Action$PlaylistLoadingFinishedOrNotNeeded r8 = com.box.android.preview.preview.PreviewReducer.Action.PlaylistLoadingFinishedOrNotNeeded.INSTANCE
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                r7.Z$0 = r2
                r7.label = r3
                java.lang.Object r7 = r0.emit(r8, r4)
                if (r7 != r1) goto Lb7
            Lb6:
                return r1
            Lb7:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewReducer.C16811.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PreviewReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class C01801<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Action> $$this$flow;
            final /* synthetic */ State $state;

            /* JADX WARN: Multi-variable type inference failed */
            C01801(State state, FlowCollector<? super Action> flowCollector) {
                this.$state = state;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
            
                if (r7.emit(r9, r0) == r1) goto L25;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends java.util.List<? extends com.box.android.domain.services.AudioItem>, ? extends com.box.android.domain.models.DomainError> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1
                    if (r0 == 0) goto L14
                    r0 = r9
                    com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1 r0 = (com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L19
                L14:
                    com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1 r0 = new com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1
                    r0.<init>(r7, r9)
                L19:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L47
                    if (r2 == r4) goto L39
                    if (r2 != r3) goto L31
                    java.lang.Object r7 = r0.L$0
                    com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L8f
                L31:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L39:
                    int r8 = r0.I$0
                    java.lang.Object r8 = r0.L$1
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Object r8 = r0.L$0
                    com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L71
                L47:
                    kotlin.ResultKt.throwOnFailure(r9)
                    java.lang.Object r9 = com.box.android.domain.utils.result.ResultKt.getOrNull(r8)
                    java.util.List r9 = (java.util.List) r9
                    if (r9 == 0) goto L71
                    kotlinx.coroutines.flow.FlowCollector<com.box.android.preview.preview.PreviewReducer$Action> r2 = r7.$$this$flow
                    com.box.android.preview.preview.PreviewReducer$Action$CreatePlaylistItemStates r5 = new com.box.android.preview.preview.PreviewReducer$Action$CreatePlaylistItemStates
                    r5.<init>(r9)
                    java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r0.L$0 = r6
                    java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                    r0.L$1 = r9
                    r9 = 0
                    r0.I$0 = r9
                    r0.label = r4
                    java.lang.Object r9 = r2.emit(r5, r0)
                    if (r9 != r1) goto L71
                    goto L8e
                L71:
                    com.box.android.preview.preview.PreviewReducer$State r9 = r7.$state
                    boolean r9 = r9.isPlaylistInitialLoadingInProgress()
                    if (r9 == 0) goto L92
                    kotlinx.coroutines.flow.FlowCollector<com.box.android.preview.preview.PreviewReducer$Action> r7 = r7.$$this$flow
                    com.box.android.preview.preview.PreviewReducer$Action$PlaylistLoadingFinishedOrNotNeeded r9 = com.box.android.preview.preview.PreviewReducer.Action.PlaylistLoadingFinishedOrNotNeeded.INSTANCE
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                    r0.L$0 = r8
                    r8 = 0
                    r0.L$1 = r8
                    r0.label = r3
                    java.lang.Object r7 = r7.emit(r9, r0)
                    if (r7 != r1) goto L8f
                L8e:
                    return r1
                L8f:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                L92:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewReducer.C16811.C01801.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result<? extends List<? extends AudioItem>, ? extends DomainError>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final Effect<Action> fetchAndObserveItemsForPlaylist(State state) {
        return EffectKt.toEffect(FlowKt.flow(new C16811(state, null))).cancellable("fetchItemsForPlaylist", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getActualFileModel(State state, Continuation<? super FileModel> continuation) {
        C16821 c16821;
        if (continuation instanceof C16821) {
            c16821 = (C16821) continuation;
            if ((c16821.label & Integer.MIN_VALUE) != 0) {
                c16821.label -= Integer.MIN_VALUE;
            } else {
                c16821 = new C16821(continuation);
            }
        } else {
            c16821 = new C16821(continuation);
        }
        Object itemByLocalId = c16821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ILocalItemService itemService = this.environment.getItemService();
            ItemId itemId = state.getFileModel().getItemId();
            c16821.L$0 = state;
            c16821.label = 1;
            itemByLocalId = itemService.getItemByLocalId(itemId, c16821);
            if (itemByLocalId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            state = (State) c16821.L$0;
            ResultKt.throwOnFailure(itemByLocalId);
        }
        FileModel fileModel = (FileModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) itemByLocalId);
        return fileModel == null ? state.getFileModel() : fileModel;
    }

    private final ReducerResult<State, Action> navigateToTarget(State state, Action.NavigateToTarget action) {
        PreviewNavigationTarget previewNavigationTarget = action.getPreviewNavigationTarget();
        Action.Navigate navigate = null;
        if ((previewNavigationTarget instanceof PreviewNavigationTarget.Comments) || (previewNavigationTarget instanceof PreviewNavigationTarget.FileActivityItemAnnotation)) {
            navigate = new Action.Navigate(new PreviewRoute.FileActivities(previewNavigationTarget.getActivityId(), null, 2, null));
        } else if (previewNavigationTarget instanceof PreviewNavigationTarget.AnnotationOnPreview) {
            navigate = new Action.Items(state.getFileModel().getItemId(), new ItemPreviewReducer.Action.EnqueueAnnotationNavigation(((PreviewNavigationTarget.AnnotationOnPreview) previewNavigationTarget).getAnnotationId()));
        } else if (previewNavigationTarget instanceof PreviewNavigationTarget.Timestamp) {
            navigate = PreviewReducerHelpersKt.video(Action.SelectedItem.INSTANCE, new VideoPreviewReducer.Action.SeekTo(((PreviewNavigationTarget.Timestamp) previewNavigationTarget).getTimestampMs()));
        } else if (!Intrinsics.areEqual(previewNavigationTarget, PreviewNavigationTarget.Collaborators.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, navigate != null ? new Effect(navigate) : Effect.INSTANCE.none());
    }
}
