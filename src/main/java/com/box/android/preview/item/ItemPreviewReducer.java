package com.box.android.preview.item;

import android.graphics.Bitmap;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.services.PreviewDataState;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.box.android.preview.item.labels.ItemPreviewLabelsReducer;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
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
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003012B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\f\u0010%\u001a\u00020&*\u00020\u001fH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020*H\u0002J\u0014\u0010+\u001a\u00020,*\u00020-2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J$\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020/H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00063"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "environment", "Lcom/box/android/preview/item/ItemPreviewEnvironment;", "observabilityId", "", "editOnLoad", "", "<init>", "(Lcom/box/android/preview/item/ItemPreviewEnvironment;Ljava/lang/String;Z)V", "getEnvironment", "()Lcom/box/android/preview/item/ItemPreviewEnvironment;", "getObservabilityId", "()Ljava/lang/String;", "getEditOnLoad", "()Z", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reduceItemPreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleItemUpdate", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateItem;", "loadPreview", "Lkotlinx/coroutines/flow/Flow;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "observeFileChanges", "itemId", "Lcom/box/android/domain/models/ItemId;", "setLoadingPlaceholderAndFetchPreview", "loadThumbnail", "getTypeIcon", "Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "createAnnotationState", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "processItemAnnotation", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "toItemState", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/domain/models/preview/PreviewData;", "processEnqueuedAnnotation", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action$UpdateAnnotations;", "State", "Action", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemPreviewReducer implements Reducable<State, Action> {
    private final Combine<State, Action> build;
    private final boolean editOnLoad;
    private final ItemPreviewEnvironment environment;
    private final String observabilityId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
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
                iArr[PreviewerType.Code.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreviewerType.BoxNote.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreviewerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreviewerType.GIF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreviewerType.Video.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreviewerType.Audio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ItemPreviewReducer(ItemPreviewEnvironment environment, String str, boolean z) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.observabilityId = str;
        this.editOnLoad = z;
        Reduce reduce = new Reduce(new ItemPreviewReducer$build$1(this));
        final ItemPreviewReducer$build$2 itemPreviewReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$3 itemPreviewReducer$build$3 = ItemPreviewReducer$build$3.INSTANCE;
        final ItemPreviewReducer$build$4 itemPreviewReducer$build$4 = ItemPreviewReducer$build$4.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new DocumentPreviewReducer(environment.getDocumentPreviewEnvironment()), new Function1<State, DocumentPreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$2.invoke(it);
                if (!(objInvoke instanceof ItemState.Document)) {
                    objInvoke = null;
                }
                ItemState.Document document = (ItemState.Document) objInvoke;
                if (document != null) {
                    return document.getAction();
                }
                return null;
            }
        }, new Function1<Action, DocumentPreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final DocumentPreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.DocumentPreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.DocumentPreview documentPreview = (ItemPreviewReducer.Action.DocumentPreview) action;
                if (documentPreview != null) {
                    return documentPreview.getAction();
                }
                return null;
            }
        }, new Function2<State, DocumentPreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, DocumentPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$2;
                Object objInvoke = itemPreviewReducer$build$3.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DocumentPreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(DocumentPreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$6 itemPreviewReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$7 itemPreviewReducer$build$7 = ItemPreviewReducer$build$7.INSTANCE;
        final ItemPreviewReducer$build$8 itemPreviewReducer$build$8 = ItemPreviewReducer$build$8.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new ImagePreviewReducer(environment.getImagePreviewEnvironment()), new Function1<State, ImagePreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$6.invoke(it);
                if (!(objInvoke instanceof ItemState.Image)) {
                    objInvoke = null;
                }
                ItemState.Image image = (ItemState.Image) objInvoke;
                if (image != null) {
                    return image.getAction();
                }
                return null;
            }
        }, new Function1<Action, ImagePreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final ImagePreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.ImagePreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.ImagePreview imagePreview = (ItemPreviewReducer.Action.ImagePreview) action;
                if (imagePreview != null) {
                    return imagePreview.getAction();
                }
                return null;
            }
        }, new Function2<State, ImagePreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, ImagePreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$6;
                Object objInvoke = itemPreviewReducer$build$7.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ImagePreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(ImagePreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$8.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$10 itemPreviewReducer$build$10 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$10
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$11 itemPreviewReducer$build$11 = ItemPreviewReducer$build$11.INSTANCE;
        final ItemPreviewReducer$build$12 itemPreviewReducer$build$12 = ItemPreviewReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new GifPreviewReducer(environment.getGifPreviewEnvironment()), new Function1<State, GifPreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final GifPreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$10.invoke(it);
                if (!(objInvoke instanceof ItemState.Gif)) {
                    objInvoke = null;
                }
                ItemState.Gif gif = (ItemState.Gif) objInvoke;
                if (gif != null) {
                    return gif.getAction();
                }
                return null;
            }
        }, new Function1<Action, GifPreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$10
            @Override // kotlin.jvm.functions.Function1
            public final GifPreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.GifPreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.GifPreview gifPreview = (ItemPreviewReducer.Action.GifPreview) action;
                if (gifPreview != null) {
                    return gifPreview.getAction();
                }
                return null;
            }
        }, new Function2<State, GifPreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, GifPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$10;
                Object objInvoke = itemPreviewReducer$build$11.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<GifPreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(GifPreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$14 itemPreviewReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$15 itemPreviewReducer$build$15 = ItemPreviewReducer$build$15.INSTANCE;
        final ItemPreviewReducer$build$16 itemPreviewReducer$build$16 = ItemPreviewReducer$build$16.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, new VideoPreviewReducer(environment.getVideoPreviewEnvironment()), new Function1<State, VideoPreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VideoPreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$14.invoke(it);
                if (!(objInvoke instanceof ItemState.Video)) {
                    objInvoke = null;
                }
                ItemState.Video video = (ItemState.Video) objInvoke;
                if (video != null) {
                    return video.getAction();
                }
                return null;
            }
        }, new Function1<Action, VideoPreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$14
            @Override // kotlin.jvm.functions.Function1
            public final VideoPreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.VideoPreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.VideoPreview videoPreview = (ItemPreviewReducer.Action.VideoPreview) action;
                if (videoPreview != null) {
                    return videoPreview.getAction();
                }
                return null;
            }
        }, new Function2<State, VideoPreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, VideoPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$14;
                Object objInvoke = itemPreviewReducer$build$15.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<VideoPreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(VideoPreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$16.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$18 itemPreviewReducer$build$18 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$18
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$19 itemPreviewReducer$build$19 = ItemPreviewReducer$build$19.INSTANCE;
        final ItemPreviewReducer$build$20 itemPreviewReducer$build$20 = ItemPreviewReducer$build$20.INSTANCE;
        IfLetReducer ifLetReducer5 = new IfLetReducer(ifLetReducer4, new CodePreviewReducer(environment.getCodePreviewEnvironment()), new Function1<State, CodePreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$17
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CodePreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$18.invoke(it);
                if (!(objInvoke instanceof ItemState.Code)) {
                    objInvoke = null;
                }
                ItemState.Code code = (ItemState.Code) objInvoke;
                if (code != null) {
                    return code.getAction();
                }
                return null;
            }
        }, new Function1<Action, CodePreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$18
            @Override // kotlin.jvm.functions.Function1
            public final CodePreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.CodePreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.CodePreview codePreview = (ItemPreviewReducer.Action.CodePreview) action;
                if (codePreview != null) {
                    return codePreview.getAction();
                }
                return null;
            }
        }, new Function2<State, CodePreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, CodePreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$18;
                Object objInvoke = itemPreviewReducer$build$19.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CodePreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(CodePreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$20.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$22 itemPreviewReducer$build$22 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$22
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$23 itemPreviewReducer$build$23 = ItemPreviewReducer$build$23.INSTANCE;
        final ItemPreviewReducer$build$24 itemPreviewReducer$build$24 = ItemPreviewReducer$build$24.INSTANCE;
        IfLetReducer ifLetReducer6 = new IfLetReducer(ifLetReducer5, new AudioPreviewReducer(), new Function1<State, AudioPreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$21
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AudioPreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$22.invoke(it);
                if (!(objInvoke instanceof ItemState.Audio)) {
                    objInvoke = null;
                }
                ItemState.Audio audio = (ItemState.Audio) objInvoke;
                if (audio != null) {
                    return audio.getAction();
                }
                return null;
            }
        }, new Function1<Action, AudioPreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$22
            @Override // kotlin.jvm.functions.Function1
            public final AudioPreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.AudioPreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.AudioPreview audioPreview = (ItemPreviewReducer.Action.AudioPreview) action;
                if (audioPreview != null) {
                    return audioPreview.getAction();
                }
                return null;
            }
        }, new Function2<State, AudioPreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$23
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, AudioPreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$22;
                Object objInvoke = itemPreviewReducer$build$23.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AudioPreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$24
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(AudioPreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$24.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$26 itemPreviewReducer$build$26 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$26
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        };
        final ItemPreviewReducer$build$27 itemPreviewReducer$build$27 = ItemPreviewReducer$build$27.INSTANCE;
        final ItemPreviewReducer$build$28 itemPreviewReducer$build$28 = ItemPreviewReducer$build$28.INSTANCE;
        IfLetReducer ifLetReducer7 = new IfLetReducer(ifLetReducer6, new BoxNotePreviewReducer(environment.getBoxNotesEnvironment()), new Function1<State, BoxNotePreviewReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$25
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxNotePreviewReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = itemPreviewReducer$build$26.invoke(it);
                if (!(objInvoke instanceof ItemState.BoxNote)) {
                    objInvoke = null;
                }
                ItemState.BoxNote boxNote = (ItemState.BoxNote) objInvoke;
                if (boxNote != null) {
                    return boxNote.getAction();
                }
                return null;
            }
        }, new Function1<Action, BoxNotePreviewReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$26
            @Override // kotlin.jvm.functions.Function1
            public final BoxNotePreviewReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.BoxNotePreview)) {
                    action = null;
                }
                ItemPreviewReducer.Action.BoxNotePreview boxNotePreview = (ItemPreviewReducer.Action.BoxNotePreview) action;
                if (boxNotePreview != null) {
                    return boxNotePreview.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxNotePreviewReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$27
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, BoxNotePreviewReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = itemPreviewReducer$build$26;
                Object objInvoke = itemPreviewReducer$build$27.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxNotePreviewReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$ifCaseScope$28
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(BoxNotePreviewReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$28.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        });
        final ItemPreviewReducer$build$30 itemPreviewReducer$build$30 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.ItemPreviewReducer$build$30
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getLabels();
            }
        };
        final ItemPreviewReducer$build$31 itemPreviewReducer$build$31 = ItemPreviewReducer$build$31.INSTANCE;
        this.build = new Combine<>(new IfLetReducer(ifLetReducer7, new ItemPreviewLabelsReducer(environment.getLabelsEnvironment()), new Function1<State, ItemPreviewLabelsReducer.State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.item.labels.ItemPreviewLabelsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewLabelsReducer.State invoke(ItemPreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemPreviewReducer$build$30.invoke(it);
            }
        }, new Function1<Action, ItemPreviewLabelsReducer.Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewLabelsReducer.Action invoke(ItemPreviewReducer.Action action) {
                if (!(action instanceof ItemPreviewReducer.Action.Labels)) {
                    action = null;
                }
                ItemPreviewReducer.Action.Labels labels = (ItemPreviewReducer.Action.Labels) action;
                if (labels != null) {
                    return labels.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemPreviewLabelsReducer.State, State>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewReducer.State invoke(ItemPreviewReducer.State parentState, ItemPreviewLabelsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemPreviewReducer$build$30;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewReducer.State.class)).iterator();
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
                            return (ItemPreviewReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemPreviewLabelsReducer.Action, Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewReducer.Action invoke(ItemPreviewLabelsReducer.Action action) {
                Object objInvoke = itemPreviewReducer$build$31.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.ItemPreviewReducer.Action");
            }
        }), new Reduce(new ItemPreviewReducer$build$33(this)), new Reduce(new ItemPreviewReducer$build$34(this)));
    }

    public /* synthetic */ ItemPreviewReducer(ItemPreviewEnvironment itemPreviewEnvironment, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemPreviewEnvironment, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }

    public final boolean getEditOnLoad() {
        return this.editOnLoad;
    }

    public final ItemPreviewEnvironment getEnvironment() {
        return this.environment;
    }

    public final String getObservabilityId() {
        return this.observabilityId;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$State;", "Lcom/box/android/cpl/Identifiable;", "Lcom/box/android/domain/models/ItemId;", "itemState", "Lcom/box/android/preview/item/ItemState;", "initialItemId", "labels", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;", "isAiEnabled", "", "enqueuedAnnotationNavigation", "", "<init>", "(Lcom/box/android/preview/item/ItemState;Lcom/box/android/domain/models/ItemId;Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;ZLjava/lang/String;)V", "getItemState", "()Lcom/box/android/preview/item/ItemState;", "getInitialItemId", "()Lcom/box/android/domain/models/ItemId;", "getLabels", "()Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;", "()Z", "getEnqueuedAnnotationNavigation", "()Ljava/lang/String;", "id", "getId", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<ItemId> {
        public static final int $stable = 8;
        private final String enqueuedAnnotationNavigation;
        private final FileModel fileModel;
        private final ItemId initialItemId;
        private final boolean isAiEnabled;
        private final ItemState itemState;
        private final ItemPreviewLabelsReducer.State labels;

        public static /* synthetic */ State copy$default(State state, ItemState itemState, ItemId itemId, ItemPreviewLabelsReducer.State state2, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                itemState = state.itemState;
            }
            if ((i & 2) != 0) {
                itemId = state.initialItemId;
            }
            if ((i & 4) != 0) {
                state2 = state.labels;
            }
            if ((i & 8) != 0) {
                z = state.isAiEnabled;
            }
            if ((i & 16) != 0) {
                str = state.enqueuedAnnotationNavigation;
            }
            String str2 = str;
            ItemPreviewLabelsReducer.State state3 = state2;
            return state.copy(itemState, itemId, state3, z, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemState getItemState() {
            return this.itemState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemId getInitialItemId() {
            return this.initialItemId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemPreviewLabelsReducer.State getLabels() {
            return this.labels;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsAiEnabled() {
            return this.isAiEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEnqueuedAnnotationNavigation() {
            return this.enqueuedAnnotationNavigation;
        }

        public final State copy(ItemState itemState, ItemId initialItemId, ItemPreviewLabelsReducer.State labels, boolean isAiEnabled, String enqueuedAnnotationNavigation) {
            Intrinsics.checkNotNullParameter(itemState, "itemState");
            Intrinsics.checkNotNullParameter(initialItemId, "initialItemId");
            Intrinsics.checkNotNullParameter(labels, "labels");
            return new State(itemState, initialItemId, labels, isAiEnabled, enqueuedAnnotationNavigation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemState, state.itemState) && Intrinsics.areEqual(this.initialItemId, state.initialItemId) && Intrinsics.areEqual(this.labels, state.labels) && this.isAiEnabled == state.isAiEnabled && Intrinsics.areEqual(this.enqueuedAnnotationNavigation, state.enqueuedAnnotationNavigation);
        }

        public int hashCode() {
            int iHashCode = ((((((this.itemState.hashCode() * 31) + this.initialItemId.hashCode()) * 31) + this.labels.hashCode()) * 31) + Boolean.hashCode(this.isAiEnabled)) * 31;
            String str = this.enqueuedAnnotationNavigation;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "State(itemState=" + this.itemState + ", initialItemId=" + this.initialItemId + ", labels=" + this.labels + ", isAiEnabled=" + this.isAiEnabled + ", enqueuedAnnotationNavigation=" + this.enqueuedAnnotationNavigation + ")";
        }

        public State(ItemState itemState, ItemId initialItemId, ItemPreviewLabelsReducer.State labels, boolean z, String str) {
            Intrinsics.checkNotNullParameter(itemState, "itemState");
            Intrinsics.checkNotNullParameter(initialItemId, "initialItemId");
            Intrinsics.checkNotNullParameter(labels, "labels");
            this.itemState = itemState;
            this.initialItemId = initialItemId;
            this.labels = labels;
            this.isAiEnabled = z;
            this.enqueuedAnnotationNavigation = str;
            this.fileModel = itemState.getFileModel();
        }

        public final ItemState getItemState() {
            return this.itemState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(ItemState itemState, ItemId itemId, ItemPreviewLabelsReducer.State state, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemState, (i & 2) != 0 ? itemState.getFileModel().getItemId() : itemId, (i & 4) != 0 ? new ItemPreviewLabelsReducer.State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : state, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str);
        }

        public final ItemId getInitialItemId() {
            return this.initialItemId;
        }

        public final ItemPreviewLabelsReducer.State getLabels() {
            return this.labels;
        }

        public final boolean isAiEnabled() {
            return this.isAiEnabled;
        }

        public final String getEnqueuedAnnotationNavigation() {
            return this.enqueuedAnnotationNavigation;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Identifiable
        public ItemId getId() {
            return this.initialItemId;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }
    }

    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "", "<init>", "()V", "Initialize", "Retry", "Ready", "Error", "UpdateItem", "ThumbnailLoaded", "EvaluateAiAvailability", "UpdateAiAvailability", "EnterAnnotationCreation", "EnqueueAnnotationNavigation", "Labels", "DocumentPreview", "ImagePreview", "GifPreview", "VideoPreview", "CodePreview", "AudioPreview", "BoxNotePreview", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$AudioPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$BoxNotePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$CodePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$DocumentPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$EnqueueAnnotationNavigation;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$Error;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$EvaluateAiAvailability;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$GifPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$ImagePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$Initialize;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$Labels;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$Ready;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$Retry;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$ThumbnailLoaded;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateAiAvailability;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateItem;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$VideoPreview;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$Initialize;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 953238679;
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

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$Retry;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -2127765183;
            }

            public String toString() {
                return "Retry";
            }

            private Retry() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$Ready;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "previewData", "Lcom/box/android/domain/models/preview/PreviewData;", "<init>", "(Lcom/box/android/domain/models/preview/PreviewData;)V", "getPreviewData", "()Lcom/box/android/domain/models/preview/PreviewData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$Error;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateItem;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateItem extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ UpdateItem copy$default(UpdateItem updateItem, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = updateItem.itemModel;
                }
                return updateItem.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final UpdateItem copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new UpdateItem(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateItem) && Intrinsics.areEqual(this.itemModel, ((UpdateItem) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "UpdateItem(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateItem(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$ThumbnailLoaded;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "thumbnail", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getThumbnail", "()Landroid/graphics/Bitmap;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ThumbnailLoaded extends Action {
            public static final int $stable = 8;
            private final Bitmap thumbnail;

            public static /* synthetic */ ThumbnailLoaded copy$default(ThumbnailLoaded thumbnailLoaded, Bitmap bitmap, int i, Object obj) {
                if ((i & 1) != 0) {
                    bitmap = thumbnailLoaded.thumbnail;
                }
                return thumbnailLoaded.copy(bitmap);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Bitmap getThumbnail() {
                return this.thumbnail;
            }

            public final ThumbnailLoaded copy(Bitmap thumbnail) {
                return new ThumbnailLoaded(thumbnail);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ThumbnailLoaded) && Intrinsics.areEqual(this.thumbnail, ((ThumbnailLoaded) other).thumbnail);
            }

            public int hashCode() {
                Bitmap bitmap = this.thumbnail;
                if (bitmap == null) {
                    return 0;
                }
                return bitmap.hashCode();
            }

            public String toString() {
                return "ThumbnailLoaded(thumbnail=" + this.thumbnail + ")";
            }

            public ThumbnailLoaded(Bitmap bitmap) {
                super(null);
                this.thumbnail = bitmap;
            }

            public final Bitmap getThumbnail() {
                return this.thumbnail;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$EvaluateAiAvailability;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EvaluateAiAvailability extends Action {
            public static final int $stable = 0;
            public static final EvaluateAiAvailability INSTANCE = new EvaluateAiAvailability();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EvaluateAiAvailability)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1897961763;
            }

            public String toString() {
                return "EvaluateAiAvailability";
            }

            private EvaluateAiAvailability() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateAiAvailability;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "isAiEnabled", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateAiAvailability extends Action {
            public static final int $stable = 0;
            private final boolean isAiEnabled;

            public static /* synthetic */ UpdateAiAvailability copy$default(UpdateAiAvailability updateAiAvailability, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = updateAiAvailability.isAiEnabled;
                }
                return updateAiAvailability.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsAiEnabled() {
                return this.isAiEnabled;
            }

            public final UpdateAiAvailability copy(boolean isAiEnabled) {
                return new UpdateAiAvailability(isAiEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateAiAvailability) && this.isAiEnabled == ((UpdateAiAvailability) other).isAiEnabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isAiEnabled);
            }

            public String toString() {
                return "UpdateAiAvailability(isAiEnabled=" + this.isAiEnabled + ")";
            }

            public UpdateAiAvailability(boolean z) {
                super(null);
                this.isAiEnabled = z;
            }

            public final boolean isAiEnabled() {
                return this.isAiEnabled;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$EnterAnnotationCreation;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1720485503;
            }

            public String toString() {
                return "EnterAnnotationCreation";
            }

            private EnterAnnotationCreation() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$EnqueueAnnotationNavigation;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "annotationId", "", "<init>", "(Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EnqueueAnnotationNavigation extends Action {
            public static final int $stable = 0;
            private final String annotationId;

            public static /* synthetic */ EnqueueAnnotationNavigation copy$default(EnqueueAnnotationNavigation enqueueAnnotationNavigation, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = enqueueAnnotationNavigation.annotationId;
                }
                return enqueueAnnotationNavigation.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final EnqueueAnnotationNavigation copy(String annotationId) {
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                return new EnqueueAnnotationNavigation(annotationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnqueueAnnotationNavigation) && Intrinsics.areEqual(this.annotationId, ((EnqueueAnnotationNavigation) other).annotationId);
            }

            public int hashCode() {
                return this.annotationId.hashCode();
            }

            public String toString() {
                return "EnqueueAnnotationNavigation(annotationId=" + this.annotationId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnqueueAnnotationNavigation(String annotationId) {
                super(null);
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                this.annotationId = annotationId;
            }

            public final String getAnnotationId() {
                return this.annotationId;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$Labels;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;)V", "getAction", "()Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Labels extends Action implements Embedded<ItemPreviewLabelsReducer.Action> {
            public static final int $stable = 0;
            private final ItemPreviewLabelsReducer.Action action;

            public static /* synthetic */ Labels copy$default(Labels labels, ItemPreviewLabelsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = labels.action;
                }
                return labels.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemPreviewLabelsReducer.Action getAction() {
                return this.action;
            }

            public final Labels copy(ItemPreviewLabelsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Labels(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Labels) && Intrinsics.areEqual(this.action, ((Labels) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Labels(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Labels(ItemPreviewLabelsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemPreviewLabelsReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$DocumentPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DocumentPreview extends Action implements Embedded<DocumentPreviewReducer.Action> {
            public static final int $stable = 0;
            private final DocumentPreviewReducer.Action action;

            public static /* synthetic */ DocumentPreview copy$default(DocumentPreview documentPreview, DocumentPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = documentPreview.action;
                }
                return documentPreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentPreviewReducer.Action getAction() {
                return this.action;
            }

            public final DocumentPreview copy(DocumentPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new DocumentPreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DocumentPreview) && Intrinsics.areEqual(this.action, ((DocumentPreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "DocumentPreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DocumentPreview(DocumentPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DocumentPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$ImagePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImagePreview extends Action implements Embedded<ImagePreviewReducer.Action> {
            public static final int $stable = 0;
            private final ImagePreviewReducer.Action action;

            public static /* synthetic */ ImagePreview copy$default(ImagePreview imagePreview, ImagePreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = imagePreview.action;
                }
                return imagePreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImagePreviewReducer.Action getAction() {
                return this.action;
            }

            public final ImagePreview copy(ImagePreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ImagePreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImagePreview) && Intrinsics.areEqual(this.action, ((ImagePreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ImagePreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImagePreview(ImagePreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ImagePreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$GifPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GifPreview extends Action implements Embedded<GifPreviewReducer.Action> {
            public static final int $stable = 0;
            private final GifPreviewReducer.Action action;

            public static /* synthetic */ GifPreview copy$default(GifPreview gifPreview, GifPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = gifPreview.action;
                }
                return gifPreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GifPreviewReducer.Action getAction() {
                return this.action;
            }

            public final GifPreview copy(GifPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new GifPreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof GifPreview) && Intrinsics.areEqual(this.action, ((GifPreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "GifPreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GifPreview(GifPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final GifPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$VideoPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class VideoPreview extends Action implements Embedded<VideoPreviewReducer.Action> {
            public static final int $stable = 0;
            private final VideoPreviewReducer.Action action;

            public static /* synthetic */ VideoPreview copy$default(VideoPreview videoPreview, VideoPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = videoPreview.action;
                }
                return videoPreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoPreviewReducer.Action getAction() {
                return this.action;
            }

            public final VideoPreview copy(VideoPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new VideoPreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof VideoPreview) && Intrinsics.areEqual(this.action, ((VideoPreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "VideoPreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VideoPreview(VideoPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final VideoPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$CodePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CodePreview extends Action implements Embedded<CodePreviewReducer.Action> {
            public static final int $stable = 0;
            private final CodePreviewReducer.Action action;

            public static /* synthetic */ CodePreview copy$default(CodePreview codePreview, CodePreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = codePreview.action;
                }
                return codePreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CodePreviewReducer.Action getAction() {
                return this.action;
            }

            public final CodePreview copy(CodePreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CodePreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CodePreview) && Intrinsics.areEqual(this.action, ((CodePreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CodePreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CodePreview(CodePreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CodePreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$AudioPreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AudioPreview extends Action implements Embedded<AudioPreviewReducer.Action> {
            public static final int $stable = 0;
            private final AudioPreviewReducer.Action action;

            public static /* synthetic */ AudioPreview copy$default(AudioPreview audioPreview, AudioPreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = audioPreview.action;
                }
                return audioPreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioPreviewReducer.Action getAction() {
                return this.action;
            }

            public final AudioPreview copy(AudioPreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new AudioPreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AudioPreview) && Intrinsics.areEqual(this.action, ((AudioPreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "AudioPreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AudioPreview(AudioPreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AudioPreviewReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Action$BoxNotePreview;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;)V", "getAction", "()Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxNotePreview extends Action implements Embedded<BoxNotePreviewReducer.Action> {
            public static final int $stable = 0;
            private final BoxNotePreviewReducer.Action action;

            public static /* synthetic */ BoxNotePreview copy$default(BoxNotePreview boxNotePreview, BoxNotePreviewReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxNotePreview.action;
                }
                return boxNotePreview.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxNotePreviewReducer.Action getAction() {
                return this.action;
            }

            public final BoxNotePreview copy(BoxNotePreviewReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxNotePreview(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxNotePreview) && Intrinsics.areEqual(this.action, ((BoxNotePreview) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxNotePreview(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxNotePreview(BoxNotePreviewReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxNotePreviewReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceItemPreview(State state, Action action) {
        Effect effectNone;
        Effect effect;
        if (action instanceof Action.Initialize) {
            if (state.getItemState() instanceof ItemState.Uninitialized) {
                return setLoadingPlaceholderAndFetchPreview(state);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.Retry) {
            return setLoadingPlaceholderAndFetchPreview(state);
        }
        if (action instanceof Action.Ready) {
            Action.Ready ready = (Action.Ready) action;
            int i = WhenMappings.$EnumSwitchMapping$0[ready.getPreviewData().getPreviewerType().ordinal()];
            if (i == 1) {
                effect = new Effect(new Action.DocumentPreview(DocumentPreviewReducer.Action.RefreshPdfPreviewConfiguration.INSTANCE));
            } else if (i == 2) {
                effect = new Effect(new Action.CodePreview(CodePreviewReducer.Action.Init.INSTANCE));
            } else if (i == 3) {
                effect = new Effect(new Action.BoxNotePreview(new BoxNotePreviewReducer.Action.Initialize(state.getFileModel(), this.editOnLoad)));
            } else {
                effect = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(State.copy$default(state, toItemState(ready.getPreviewData(), state), null, null, false, null, 30, null), Effect.INSTANCE.merge(new Effect(new Action.Labels(new ItemPreviewLabelsReducer.Action.UpdateLabels(state.getFileModel()))), Effect.INSTANCE.fireAndForget(new C16771(state, null)), effect));
        }
        if (action instanceof Action.Error) {
            return new ReducerResult<>(State.copy$default(state, new ItemState.Error(state.getFileModel(), ((Action.Error) action).getError()), null, null, false, null, 30, null), null, 2, null);
        }
        if (action instanceof Action.UpdateItem) {
            return handleItemUpdate(state, (Action.UpdateItem) action);
        }
        if (action instanceof Action.ThumbnailLoaded) {
            LoadingPlaceholder loadingPlaceholder = state.getItemState().getLoadingPlaceholder();
            if (loadingPlaceholder != null) {
                return new ReducerResult<>(State.copy$default(state, state.getItemState().withLoadingPlaceholder(LoadingPlaceholder.copy$default(loadingPlaceholder, null, ((Action.ThumbnailLoaded) action).getThumbnail(), 1, null)), null, null, false, null, 30, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.EvaluateAiAvailability) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass2(state, null))));
        }
        if (action instanceof Action.UpdateAiAvailability) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, ((Action.UpdateAiAvailability) action).isAiEnabled(), null, 23, null), null, 2, null);
        }
        if (action instanceof Action.EnterAnnotationCreation) {
            ItemState itemState = state.getItemState();
            if (itemState instanceof ItemState.Document) {
                effectNone = new Effect(new Action.DocumentPreview(DocumentPreviewReducer.Action.EnterAnnotationCreation.INSTANCE));
            } else if (itemState instanceof ItemState.Image) {
                effectNone = new Effect(new Action.ImagePreview(ImagePreviewReducer.Action.EnterAnnotationCreation.INSTANCE));
            } else if (itemState instanceof ItemState.Video) {
                effectNone = new Effect(new Action.VideoPreview(VideoPreviewReducer.Action.EnterAnnotationCreation.INSTANCE));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.DocumentPreview) {
            DocumentPreviewReducer.Action action2 = ((Action.DocumentPreview) action).getAction();
            if (action2 instanceof DocumentPreviewReducer.Action.Error) {
                return new ReducerResult<>(state, new Effect(new Action.Error(((DocumentPreviewReducer.Action.Error) action2).getError())));
            }
            return action2 instanceof DocumentPreviewReducer.Action.Annotations ? processItemAnnotation(state, ((DocumentPreviewReducer.Action.Annotations) action2).getAction()) : new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.ImagePreview) {
            ImagePreviewReducer.Action action3 = ((Action.ImagePreview) action).getAction();
            if (action3 instanceof ImagePreviewReducer.Action.Error) {
                return new ReducerResult<>(state, new Effect(new Action.Error(((ImagePreviewReducer.Action.Error) action3).getError())));
            }
            return action3 instanceof ImagePreviewReducer.Action.Annotations ? processItemAnnotation(state, ((ImagePreviewReducer.Action.Annotations) action3).getAction()) : new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.GifPreview) {
            Action.GifPreview gifPreview = (Action.GifPreview) action;
            if (gifPreview.getAction() instanceof GifPreviewReducer.Action.Error) {
                return new ReducerResult<>(state, new Effect(new Action.Error(((GifPreviewReducer.Action.Error) gifPreview.getAction()).getError())));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.VideoPreview) {
            VideoPreviewReducer.Action action4 = ((Action.VideoPreview) action).getAction();
            if (action4 instanceof VideoPreviewReducer.Action.Error) {
                return new ReducerResult<>(state, new Effect(new Action.Error(((VideoPreviewReducer.Action.Error) action4).getError())));
            }
            if (action4 instanceof VideoPreviewReducer.Action.FrameAnnotation) {
                VideoPreviewReducer.Action.FrameAnnotation frameAnnotation = (VideoPreviewReducer.Action.FrameAnnotation) action4;
                if (frameAnnotation.getAction() instanceof FrameAnnotationReducer.Action.Annotations) {
                    return processItemAnnotation(state, ((FrameAnnotationReducer.Action.Annotations) frameAnnotation.getAction()).getAction());
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.CodePreview) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.AudioPreview) {
            if (((Action.AudioPreview) action).getAction() instanceof AudioPreviewReducer.Action.Opened) {
                return new ReducerResult<>(state, new Effect((Flow) observeFileChanges(state.getFileModel().getItemId())).cancellable("PREVIEW_AUDIO_OBSERVE_EFFECT_" + state.getFileModel().getItemId(), true));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.BoxNotePreview) {
            Action.BoxNotePreview boxNotePreview = (Action.BoxNotePreview) action;
            if (boxNotePreview.getAction() instanceof BoxNotePreviewReducer.Action.Error) {
                return new ReducerResult<>(state, new Effect(new Action.Error(((BoxNotePreviewReducer.Action.Error) boxNotePreview.getAction()).getError())));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.Labels) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.EnqueueAnnotationNavigation)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.EnqueueAnnotationNavigation enqueueAnnotationNavigation = (Action.EnqueueAnnotationNavigation) action;
        return new ReducerResult<>(State.copy$default(state, null, null, null, false, enqueueAnnotationNavigation.getAnnotationId(), 15, null), new Effect(INSTANCE.annotationAction(state, new AnnotationsReducer.Action.NavigateToAnnotation(enqueueAnnotationNavigation.getAnnotationId()))));
    }

    /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$reduceItemPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$reduceItemPreview$1", f = "ItemPreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16771 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16771(State state, Continuation<? super C16771> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemPreviewReducer.this.new C16771(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16771) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ItemPreviewReducer.this.getEnvironment().getThumbnailPreviewInteractor().cancelThumbnailUpdate(this.$state.getInitialItemId());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$reduceItemPreview$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action$UpdateAiAvailability;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$reduceItemPreview$2", f = "ItemPreviewReducer.kt", i = {0, 1, 1}, l = {227, 231}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "availabilityStatus"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdateAiAvailability>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ItemPreviewReducer.this.new AnonymousClass2(this.$state, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdateAiAvailability> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
        
            if (r0.emit(new com.box.android.preview.item.ItemPreviewReducer.Action.UpdateAiAvailability(r7 instanceof com.box.android.domain.models.boxai.AiItemAvailabilityStatus.Available), r6) == r1) goto L15;
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
                if (r2 == 0) goto L26
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r6 = r6.L$1
                com.box.android.domain.models.boxai.AiItemAvailabilityStatus r6 = (com.box.android.domain.models.boxai.AiItemAvailabilityStatus) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L6b
            L1a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L22:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4a
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.preview.item.ItemPreviewReducer r7 = com.box.android.preview.item.ItemPreviewReducer.this
                com.box.android.preview.item.ItemPreviewEnvironment r7 = r7.getEnvironment()
                com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase r7 = r7.getGetBoxAiAvailabilityUseCase()
                com.box.android.preview.item.ItemPreviewReducer$State r2 = r6.$state
                com.box.android.domain.models.item.FileModel r2 = r2.getFileModel()
                com.box.android.domain.models.item.ItemModel r2 = (com.box.android.domain.models.item.ItemModel) r2
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.L$0 = r0
                r6.label = r4
                r4 = 0
                java.lang.Object r7 = r7.getAiAvailabilityForItem(r2, r4, r5)
                if (r7 != r1) goto L4a
                goto L6a
            L4a:
                com.box.android.domain.models.boxai.AiItemAvailabilityStatus r7 = (com.box.android.domain.models.boxai.AiItemAvailabilityStatus) r7
                com.box.android.preview.item.ItemPreviewReducer$Action$UpdateAiAvailability r2 = new com.box.android.preview.item.ItemPreviewReducer$Action$UpdateAiAvailability
                boolean r4 = r7 instanceof com.box.android.domain.models.boxai.AiItemAvailabilityStatus.Available
                r2.<init>(r4)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r5
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$1 = r7
                r6.label = r3
                java.lang.Object r6 = r0.emit(r2, r4)
                if (r6 != r1) goto L6b
            L6a:
                return r1
            L6b:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.item.ItemPreviewReducer.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleItemUpdate(State state, Action.UpdateItem action) {
        Continuation continuation;
        ItemState.BoxNote boxNote;
        ItemState itemState;
        ItemState.Image image;
        ItemModel itemModel = action.getItemModel();
        Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.FileModel");
        FileModel fileModel = (FileModel) itemModel;
        ItemState itemState2 = state.getItemState();
        if (!(itemState2 instanceof ItemState.Uninitialized)) {
            if (itemState2 instanceof ItemState.Image) {
                image = new ItemState.Image(ImagePreviewReducer.State.copy$default(((ItemState.Image) state.getItemState()).getState(), fileModel, null, null, null, null, 30, null));
            } else {
                if (itemState2 instanceof ItemState.Document) {
                    continuation = null;
                    boxNote = new ItemState.Document(DocumentPreviewReducer.State.copy$default(((ItemState.Document) state.getItemState()).getState(), fileModel, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 16382, null));
                } else {
                    continuation = null;
                    if (itemState2 instanceof ItemState.Gif) {
                        boxNote = new ItemState.Gif(GifPreviewReducer.State.copy$default(((ItemState.Gif) state.getItemState()).getState(), fileModel, null, null, 6, null));
                    } else if (itemState2 instanceof ItemState.Error) {
                        boxNote = ItemState.Error.copy$default((ItemState.Error) state.getItemState(), fileModel, null, 2, null);
                    } else if (itemState2 instanceof ItemState.Loading) {
                        boxNote = ItemState.Loading.copy$default((ItemState.Loading) state.getItemState(), fileModel, null, 2, null);
                    } else if (itemState2 instanceof ItemState.Video) {
                        boxNote = new ItemState.Video(VideoPreviewReducer.State.copy$default(((ItemState.Video) state.getItemState()).getState(), fileModel, null, 0L, null, null, 30, null));
                    } else if (itemState2 instanceof ItemState.Code) {
                        boxNote = new ItemState.Code(CodePreviewReducer.State.copy$default(((ItemState.Code) state.getItemState()).getState(), fileModel, null, null, null, false, 30, null));
                    } else if (itemState2 instanceof ItemState.Audio) {
                        boxNote = new ItemState.Audio(AudioPreviewReducer.State.copy$default(((ItemState.Audio) state.getItemState()).getState(), fileModel, null, false, null, null, false, 62, null));
                    } else {
                        if (!(itemState2 instanceof ItemState.BoxNote)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        boxNote = new ItemState.BoxNote(((ItemState.BoxNote) state.getItemState()).getState().withFile(fileModel));
                    }
                }
                itemState = boxNote;
            }
            return new ReducerResult<>(State.copy$default(state, itemState, null, null, false, null, 30, null), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(!Intrinsics.areEqual(state.getFileModel().getItemId(), fileModel.getItemId()), state, fileModel, continuation))));
        }
        image = ((ItemState.Uninitialized) state.getItemState()).copy(fileModel);
        itemState = image;
        continuation = null;
        return new ReducerResult<>(State.copy$default(state, itemState, null, null, false, null, 30, null), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(!Intrinsics.areEqual(state.getFileModel().getItemId(), fileModel.getItemId()), state, fileModel, continuation))));
    }

    /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$handleItemUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$handleItemUpdate$1", f = "ItemPreviewReducer.kt", i = {0, 1}, l = {379, 382}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $itemIdChanged;
        final /* synthetic */ State $state;
        final /* synthetic */ FileModel $updatedFile;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, State state, FileModel fileModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemIdChanged = z;
            this.$state = state;
            this.$updatedFile = fileModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$itemIdChanged, this.$state, this.$updatedFile, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        
            if (r0.emit(new com.box.android.preview.item.ItemPreviewReducer.Action.Labels(new com.box.android.preview.item.labels.ItemPreviewLabelsReducer.Action.UpdateLabels(r5.$updatedFile)), r5) == r1) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r6)
                goto L65
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L39
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                boolean r6 = r5.$itemIdChanged
                if (r6 == 0) goto L39
                com.box.android.preview.item.ItemPreviewReducer$Action$EvaluateAiAvailability r6 = com.box.android.preview.item.ItemPreviewReducer.Action.EvaluateAiAvailability.INSTANCE
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.L$0 = r0
                r5.label = r4
                java.lang.Object r6 = r0.emit(r6, r2)
                if (r6 != r1) goto L39
                goto L64
            L39:
                com.box.android.preview.item.ItemPreviewReducer$State r6 = r5.$state
                com.box.android.preview.item.ItemState r6 = r6.getItemState()
                boolean r6 = r6.previewContentLoaded()
                if (r6 == 0) goto L65
                com.box.android.preview.item.ItemPreviewReducer$Action$Labels r6 = new com.box.android.preview.item.ItemPreviewReducer$Action$Labels
                com.box.android.preview.item.labels.ItemPreviewLabelsReducer$Action$UpdateLabels r2 = new com.box.android.preview.item.labels.ItemPreviewLabelsReducer$Action$UpdateLabels
                com.box.android.domain.models.item.FileModel r4 = r5.$updatedFile
                r2.<init>(r4)
                com.box.android.preview.item.labels.ItemPreviewLabelsReducer$Action r2 = (com.box.android.preview.item.labels.ItemPreviewLabelsReducer.Action) r2
                r6.<init>(r2)
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r5.L$0 = r4
                r5.label = r3
                java.lang.Object r5 = r0.emit(r6, r2)
                if (r5 != r1) goto L65
            L64:
                return r1
            L65:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.item.ItemPreviewReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Flow<Action> loadPreview(FileModel fileModel) {
        final Flow<PreviewDataState> previewData = this.environment.getPreviewService().getPreviewData(fileModel, this.observabilityId);
        return new Flow<Action>() { // from class: com.box.android.preview.item.ItemPreviewReducer$loadPreview$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ItemPreviewReducer.Action> flowCollector, Continuation continuation) {
                Object objCollect = previewData.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$loadPreview$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$loadPreview$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$loadPreview$$inlined$map$1$2", f = "ItemPreviewReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                        PreviewDataState previewDataState = (PreviewDataState) obj;
                        if (previewDataState instanceof PreviewDataState.Ready) {
                            obj2 = (ItemPreviewReducer.Action) new ItemPreviewReducer.Action.Ready(((PreviewDataState.Ready) previewDataState).getData());
                        } else {
                            if (!(previewDataState instanceof PreviewDataState.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            obj2 = (ItemPreviewReducer.Action) new ItemPreviewReducer.Action.Error(((PreviewDataState.Error) previewDataState).getError());
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
        };
    }

    private final Flow<Action> observeFileChanges(ItemId itemId) {
        final Flow<Result<ItemModel, DomainError>> flowObserveItem = this.environment.getItemService().observeItem(itemId, DataPolicy.CACHE);
        return new Flow<Action.UpdateItem>() { // from class: com.box.android.preview.item.ItemPreviewReducer$observeFileChanges$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ItemPreviewReducer.Action.UpdateItem> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveItem.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$observeFileChanges$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$observeFileChanges$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$observeFileChanges$$inlined$mapNotNull$1$2", f = "ItemPreviewReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {54}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        ItemModel itemModel = (ItemModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                        ItemPreviewReducer.Action.UpdateItem updateItem = itemModel != null ? new ItemPreviewReducer.Action.UpdateItem(itemModel) : null;
                        if (updateItem != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(updateItem);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(updateItem, anonymousClass1) == coroutine_suspended) {
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
        };
    }

    private final ReducerResult<State, Action> setLoadingPlaceholderAndFetchPreview(State state) {
        FileModel fileModel = state.getItemState().getFileModel();
        return new ReducerResult<>(State.copy$default(state, new ItemState.Loading(fileModel, new LoadingPlaceholder(getTypeIcon(fileModel), null, 2, null)), null, null, false, null, 22, null), Effect.INSTANCE.merge(new Effect((Flow) observeFileChanges(fileModel.getItemId())), new Effect((Flow) loadPreview(fileModel)), new Effect((Flow) loadThumbnail(fileModel)), new Effect(Action.EvaluateAiAvailability.INSTANCE)).cancellable("PREVIEW_LOAD_EFFECT_" + fileModel.getItemId(), true));
    }

    private final Flow<Action> loadThumbnail(FileModel fileModel) {
        final Flow<Bitmap> thumbnail = this.environment.getThumbnailPreviewInteractor().getThumbnail(fileModel);
        return new Flow<Action.ThumbnailLoaded>() { // from class: com.box.android.preview.item.ItemPreviewReducer$loadThumbnail$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ItemPreviewReducer.Action.ThumbnailLoaded> flowCollector, Continuation continuation) {
                Object objCollect = thumbnail.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$loadThumbnail$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.preview.item.ItemPreviewReducer$loadThumbnail$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.preview.item.ItemPreviewReducer$loadThumbnail$$inlined$map$1$2", f = "ItemPreviewReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                        ItemPreviewReducer.Action.ThumbnailLoaded thumbnailLoaded = new ItemPreviewReducer.Action.ThumbnailLoaded((Bitmap) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(thumbnailLoaded, anonymousClass1) == coroutine_suspended) {
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
        };
    }

    private final FileTypeIcon getTypeIcon(FileModel fileModel) {
        return SupportedFileExtensionIcons.INSTANCE.findFileIcon(fileModel.getExtension());
    }

    private final AnnotationsReducer.State createAnnotationState(FileModel fileModel) {
        if (this.environment.getFileActionsManager().isViewingAnnotationsEnabled(fileModel)) {
            FileVersionMiniModel fileVersion = fileModel.getFileVersion();
            if (fileVersion != null) {
                return new AnnotationsReducer.State(fileModel.getItemId(), fileVersion.getId(), null, null, null, null, null, false, 252, null);
            }
            BoxLogUtils.e("AnnotationsReducer", "Unexpected null file version in file model with id " + fileModel.getItemId());
        }
        return null;
    }

    private final ReducerResult<State, Action> processItemAnnotation(State state, AnnotationsReducer.Action action) {
        return action instanceof AnnotationsReducer.Action.UpdateAnnotations ? processEnqueuedAnnotation(state, (AnnotationsReducer.Action.UpdateAnnotations) action) : new ReducerResult<>(state, null, 2, null);
    }

    private final ItemState toItemState(PreviewData previewData, State state) {
        LoadingPlaceholder loadingPlaceholder = state.getItemState().getLoadingPlaceholder();
        switch (WhenMappings.$EnumSwitchMapping$0[previewData.getPreviewerType().ordinal()]) {
            case 1:
                return new ItemState.Document(new DocumentPreviewReducer.State(state.getFileModel(), previewData.getUrl(), loadingPlaceholder, null, null, null, 0, 0, createAnnotationState(state.getFileModel()), null, null, null, null, null, 16120, null));
            case 2:
                return new ItemState.Code(new CodePreviewReducer.State(state.getFileModel(), previewData.getUrl(), null, null, false, 28, null));
            case 3:
                return new ItemState.BoxNote(new BoxNotePreviewReducer.State.Initializing(state.getFileModel(), false));
            case 4:
                return new ItemState.Image(new ImagePreviewReducer.State(state.getFileModel(), previewData.getUrl(), loadingPlaceholder, createAnnotationState(state.getFileModel()), null, 16, null));
            case 5:
                FileModel fileModel = state.getFileModel();
                String string = previewData.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return new ItemState.Gif(new GifPreviewReducer.State(fileModel, string, loadingPlaceholder));
            case 6:
                return new ItemState.Video(new VideoPreviewReducer.State(state.getItemState().getFileModel(), previewData.getUrl(), 0L, loadingPlaceholder, null, 20, null));
            case 7:
                return new ItemState.Audio(new AudioPreviewReducer.State(state.getFileModel(), previewData.getUrl(), false, null, null, false, 60, null));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    private final ReducerResult<State, Action> processEnqueuedAnnotation(State state, AnnotationsReducer.Action.UpdateAnnotations action) {
        String enqueuedAnnotationNavigation = state.getEnqueuedAnnotationNavigation();
        if (enqueuedAnnotationNavigation == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        for (Object obj : action.getAnnotations()) {
            if (Intrinsics.areEqual(((AnnotationWithLocation) obj).getAnnotation().getAnnotationId(), enqueuedAnnotationNavigation)) {
                return obj == null ? new ReducerResult<>(state, null, 2, null) : new ReducerResult<>(State.copy$default(state, null, null, null, false, null, 15, null), new Effect(INSTANCE.annotationAction(state, new AnnotationsReducer.Action.NavigateToAnnotation(enqueuedAnnotationNavigation))));
            }
        }
        obj = null;
        if (obj == null) {
        }
    }

    /* JADX INFO: compiled from: ItemPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/item/ItemPreviewReducer$Companion;", "", "<init>", "()V", "annotationAction", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "state", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", Analytics.Data.ACTION, "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Action annotationAction(State state, AnnotationsReducer.Action action) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
            ItemState itemState = state.getItemState();
            if (itemState instanceof ItemState.Document) {
                return new Action.DocumentPreview(new DocumentPreviewReducer.Action.Annotations(action));
            }
            if (itemState instanceof ItemState.Video) {
                return new Action.VideoPreview(new VideoPreviewReducer.Action.FrameAnnotation(new FrameAnnotationReducer.Action.Annotations(action)));
            }
            return new Action.ImagePreview(new ImagePreviewReducer.Action.Annotations(action));
        }
    }
}
