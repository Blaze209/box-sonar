package com.box.android.preview.gallery;

import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.cpl.ThumbnailSource;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: GalleryItemsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$State;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "environment", "Lcom/box/android/preview/gallery/GalleryItemsEnvironment;", "<init>", "(Lcom/box/android/preview/gallery/GalleryItemsEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceGallery", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Close", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GalleryItemsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final GalleryItemsEnvironment environment;

    public GalleryItemsReducer(GalleryItemsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new GalleryItemsReducer$build$1(this));
        final GalleryItemsReducer$build$2 galleryItemsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.gallery.GalleryItemsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((GalleryItemsReducer.State) obj).getItems();
            }
        };
        final GalleryItemsReducer$build$3 galleryItemsReducer$build$3 = GalleryItemsReducer$build$3.INSTANCE;
        this.build = new ForEachReducer(reduce, new ItemThumbnailReducer(environment.getItemThumbnailEnvironment()), galleryItemsReducer$build$2, new Function1<Action, EmbeddedItem<String, ItemThumbnailReducer.Action>>() { // from class: com.box.android.preview.gallery.GalleryItemsReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<String, ItemThumbnailReducer.Action> invoke(GalleryItemsReducer.Action action) {
                if (!(action instanceof GalleryItemsReducer.Action.ItemThumbnailAction)) {
                    action = null;
                }
                return (GalleryItemsReducer.Action.ItemThumbnailAction) action;
            }
        }, new Function2<State, ItemThumbnailReducer.State, State>() { // from class: com.box.android.preview.gallery.GalleryItemsReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final GalleryItemsReducer.State invoke(GalleryItemsReducer.State parentState, ItemThumbnailReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) galleryItemsReducer$build$2.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = galleryItemsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(GalleryItemsReducer.State.class)).iterator();
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
                            return (GalleryItemsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.gallery.GalleryItemsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<String, ItemThumbnailReducer.Action, Action>() { // from class: com.box.android.preview.gallery.GalleryItemsReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final GalleryItemsReducer.Action invoke(String id, ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = galleryItemsReducer$build$3.invoke(id, action);
                if (objInvoke != null) {
                    return (GalleryItemsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.gallery.GalleryItemsReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: GalleryItemsReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Close;", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Close {
        public static final int $stable = 8;
        private final ItemModel itemModel;

        /* JADX WARN: Multi-variable type inference failed */
        public Close() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Close copy$default(Close close, ItemModel itemModel, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = close.itemModel;
            }
            return close.copy(itemModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public final Close copy(ItemModel itemModel) {
            return new Close(itemModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Close) && Intrinsics.areEqual(this.itemModel, ((Close) other).itemModel);
        }

        public int hashCode() {
            ItemModel itemModel = this.itemModel;
            if (itemModel == null) {
                return 0;
            }
            return itemModel.hashCode();
        }

        public String toString() {
            return "Close(itemModel=" + this.itemModel + ")";
        }

        public Close(ItemModel itemModel) {
            this.itemModel = itemModel;
        }

        public /* synthetic */ Close(ItemModel itemModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : itemModel);
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }
    }

    /* JADX INFO: compiled from: GalleryItemsReducer.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$State;", "", "initialFileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", AlertFragment.ARG_ITEMS, "Lcom/box/android/cpl/IdentifiedList;", "", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "closeRoute", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Close;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewSource;Lcom/box/android/cpl/IdentifiedList;Lcom/box/android/preview/gallery/GalleryItemsReducer$Close;)V", "getInitialFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getItems", "()Lcom/box/android/cpl/IdentifiedList;", "getCloseRoute", "()Lcom/box/android/preview/gallery/GalleryItemsReducer$Close;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final Close closeRoute;
        private final FileModel initialFileModel;
        private final IdentifiedList<String, ItemThumbnailReducer.State> items;
        private final PreviewSource previewSource;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, PreviewSource previewSource, IdentifiedList identifiedList, Close close, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.initialFileModel;
            }
            if ((i & 2) != 0) {
                previewSource = state.previewSource;
            }
            if ((i & 4) != 0) {
                identifiedList = state.items;
            }
            if ((i & 8) != 0) {
                close = state.closeRoute;
            }
            return state.copy(fileModel, previewSource, identifiedList, close);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getInitialFileModel() {
            return this.initialFileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final IdentifiedList<String, ItemThumbnailReducer.State> component3() {
            return this.items;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Close getCloseRoute() {
            return this.closeRoute;
        }

        public final State copy(FileModel initialFileModel, PreviewSource previewSource, IdentifiedList<String, ItemThumbnailReducer.State> items, Close closeRoute) {
            Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(items, "items");
            return new State(initialFileModel, previewSource, items, closeRoute);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.initialFileModel, state.initialFileModel) && Intrinsics.areEqual(this.previewSource, state.previewSource) && Intrinsics.areEqual(this.items, state.items) && Intrinsics.areEqual(this.closeRoute, state.closeRoute);
        }

        public int hashCode() {
            int iHashCode = ((((this.initialFileModel.hashCode() * 31) + this.previewSource.hashCode()) * 31) + this.items.hashCode()) * 31;
            Close close = this.closeRoute;
            return iHashCode + (close == null ? 0 : close.hashCode());
        }

        public String toString() {
            return "State(initialFileModel=" + this.initialFileModel + ", previewSource=" + this.previewSource + ", items=" + this.items + ", closeRoute=" + this.closeRoute + ")";
        }

        public State(FileModel initialFileModel, PreviewSource previewSource, IdentifiedList<String, ItemThumbnailReducer.State> items, Close close) {
            Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(items, "items");
            this.initialFileModel = initialFileModel;
            this.previewSource = previewSource;
            this.items = items;
            this.closeRoute = close;
        }

        public final FileModel getInitialFileModel() {
            return this.initialFileModel;
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public /* synthetic */ State(FileModel fileModel, PreviewSource previewSource, IdentifiedList identifiedList, Close close, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, previewSource, (i & 4) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList, (i & 8) != 0 ? null : close);
        }

        public final IdentifiedList<String, ItemThumbnailReducer.State> getItems() {
            return this.items;
        }

        public final Close getCloseRoute() {
            return this.closeRoute;
        }
    }

    /* JADX INFO: compiled from: GalleryItemsReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "", "<init>", "()V", "Close", "UpdateGalleryItems", "Fetch", "ItemThumbnailAction", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$Close;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$Fetch;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$ItemThumbnailAction;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$UpdateGalleryItems;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: GalleryItemsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$Close;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            /* JADX WARN: Multi-variable type inference failed */
            public Close() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Close copy$default(Close close, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = close.itemModel;
                }
                return close.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final Close copy(ItemModel itemModel) {
                return new Close(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Close) && Intrinsics.areEqual(this.itemModel, ((Close) other).itemModel);
            }

            public int hashCode() {
                ItemModel itemModel = this.itemModel;
                if (itemModel == null) {
                    return 0;
                }
                return itemModel.hashCode();
            }

            public String toString() {
                return "Close(itemModel=" + this.itemModel + ")";
            }

            public Close(ItemModel itemModel) {
                super(null);
                this.itemModel = itemModel;
            }

            public /* synthetic */ Close(ItemModel itemModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : itemModel);
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: GalleryItemsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$UpdateGalleryItems;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "updatedItems", "", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Ljava/util/List;)V", "getUpdatedItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateGalleryItems extends Action {
            public static final int $stable = 8;
            private final List<FileModel> updatedItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateGalleryItems copy$default(UpdateGalleryItems updateGalleryItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = updateGalleryItems.updatedItems;
                }
                return updateGalleryItems.copy(list);
            }

            public final List<FileModel> component1() {
                return this.updatedItems;
            }

            public final UpdateGalleryItems copy(List<FileModel> updatedItems) {
                Intrinsics.checkNotNullParameter(updatedItems, "updatedItems");
                return new UpdateGalleryItems(updatedItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateGalleryItems) && Intrinsics.areEqual(this.updatedItems, ((UpdateGalleryItems) other).updatedItems);
            }

            public int hashCode() {
                return this.updatedItems.hashCode();
            }

            public String toString() {
                return "UpdateGalleryItems(updatedItems=" + this.updatedItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateGalleryItems(List<FileModel> updatedItems) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedItems, "updatedItems");
                this.updatedItems = updatedItems;
            }

            public final List<FileModel> getUpdatedItems() {
                return this.updatedItems;
            }
        }

        /* JADX INFO: compiled from: GalleryItemsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$Fetch;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Fetch extends Action {
            public static final int $stable = 0;
            public static final Fetch INSTANCE = new Fetch();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fetch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1317748509;
            }

            public String toString() {
                return "Fetch";
            }

            private Fetch() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GalleryItemsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$ItemThumbnailAction;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "itemId", Analytics.Data.ACTION, "<init>", "(Ljava/lang/String;Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", "getItemId", "()Ljava/lang/String;", "getAction", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemThumbnailAction extends Action implements EmbeddedItem<String, ItemThumbnailReducer.Action> {
            public static final int $stable = ItemThumbnailReducer.Action.$stable;
            private final ItemThumbnailReducer.Action action;
            private final String itemId;

            public static /* synthetic */ ItemThumbnailAction copy$default(ItemThumbnailAction itemThumbnailAction, String str, ItemThumbnailReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemThumbnailAction.itemId;
                }
                if ((i & 2) != 0) {
                    action = itemThumbnailAction.action;
                }
                return itemThumbnailAction.copy(str, action);
            }

            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: avoid collision after fix types in other method and from getter */
            public final String getId() {
                return this.itemId;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemThumbnailReducer.Action getFileActivityAction() {
                return this.action;
            }

            public final ItemThumbnailAction copy(String itemId, ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemThumbnailAction(itemId, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemThumbnailAction)) {
                    return false;
                }
                ItemThumbnailAction itemThumbnailAction = (ItemThumbnailAction) other;
                return Intrinsics.areEqual(this.itemId, itemThumbnailAction.itemId) && Intrinsics.areEqual(this.action, itemThumbnailAction.action);
            }

            public int hashCode() {
                return (this.itemId.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "ItemThumbnailAction(itemId=" + this.itemId + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemThumbnailAction(String itemId, ItemThumbnailReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(action, "action");
                this.itemId = itemId;
                this.action = action;
            }

            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }

            public final String getItemId() {
                return this.itemId;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceGallery(State state, Action action) {
        ItemThumbnailReducer.State state2;
        int i = 2;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (action instanceof Action.Close) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, new Close(((Action.Close) action).getItemModel()), 7, null), null, 2, null);
        }
        if (action instanceof Action.ItemThumbnailAction) {
            Action.ItemThumbnailAction itemThumbnailAction = (Action.ItemThumbnailAction) action;
            if (itemThumbnailAction.getAction() instanceof ItemThumbnailReducer.Action.Clicked) {
                ItemThumbnailReducer.State state3 = (ItemThumbnailReducer.State) state.getItems().getById(itemThumbnailAction.getItemId());
                return new ReducerResult<>(state, new Effect(new Action.Close(state3 != null ? GalleryItemsReducerKt.itemModel(state3) : null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.Fetch) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, null))));
        }
        if (!(action instanceof Action.UpdateGalleryItems)) {
            throw new NoWhenBranchMatchedException();
        }
        List<FileModel> updatedItems = ((Action.UpdateGalleryItems) action).getUpdatedItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(updatedItems, 10));
        Iterator<T> it = updatedItems.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return new ReducerResult<>(State.copy$default(state, null, null, new IdentifiedList((Identifiable[]) arrayList.toArray(new ItemThumbnailReducer.State[0])), null, 11, null), null, 2, null);
            }
            FileModel fileModel = (FileModel) it.next();
            ItemThumbnailReducer.State state4 = (ItemThumbnailReducer.State) state.getItems().getById(fileModel.getItemId().toString());
            if (state4 == null || (state2 = ItemThumbnailReducer.State.copy$default(state4, new ThumbnailSource.Item(fileModel, z, i, objArr2 == true ? 1 : 0), null, false, 6, null)) == null) {
                state2 = new ItemThumbnailReducer.State(new ThumbnailSource.Item(fileModel, z, i, objArr == true ? 1 : 0), null, false, 6, null);
            }
            arrayList.add(state2);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.gallery.GalleryItemsReducer$reduceGallery$1, reason: invalid class name */
    /* JADX INFO: compiled from: GalleryItemsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action$UpdateGalleryItems;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.gallery.GalleryItemsReducer$reduceGallery$1", f = "GalleryItemsReducer.kt", i = {0, 1}, l = {85, 85}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action.UpdateGalleryItems>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = GalleryItemsReducer.this.new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action.UpdateGalleryItems> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r8).collect(new com.box.android.preview.gallery.GalleryItemsReducer.AnonymousClass1.C01781(), r7) == r1) goto L15;
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
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L64
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L49
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.preview.gallery.GalleryItemsReducer r8 = com.box.android.preview.gallery.GalleryItemsReducer.this
                com.box.android.preview.gallery.GalleryItemsEnvironment r8 = com.box.android.preview.gallery.GalleryItemsReducer.access$getEnvironment$p(r8)
                com.box.android.domain.services.IGalleryItemsService r8 = r8.getGalleryItemsService()
                com.box.android.preview.gallery.GalleryItemsReducer$State r2 = r7.$state
                com.box.android.domain.models.preview.PreviewSource r2 = r2.getPreviewSource()
                com.box.android.preview.gallery.GalleryItemsReducer$State r5 = r7.$state
                com.box.android.domain.models.item.FileModel r5 = r5.getInitialFileModel()
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = r8.fetchPreviewItems(r2, r5, r6)
                if (r8 != r1) goto L49
                goto L63
            L49:
                kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
                com.box.android.preview.gallery.GalleryItemsReducer$reduceGallery$1$1 r2 = new com.box.android.preview.gallery.GalleryItemsReducer$reduceGallery$1$1
                r2.<init>()
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r0
                r7.label = r3
                java.lang.Object r7 = r8.collect(r2, r4)
                if (r7 != r1) goto L64
            L63:
                return r1
            L64:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.gallery.GalleryItemsReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
