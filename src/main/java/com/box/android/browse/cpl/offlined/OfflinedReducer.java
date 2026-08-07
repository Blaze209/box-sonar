package com.box.android.browse.cpl.offlined;

import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducerKt;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
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

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "environment", "Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceOfflined", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceChildActionableItemsList", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$ChildActionableItemsListAction;", "reduceItemsList", "actionableItemAction", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "createNavigation", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "reduceTabVisible", "Route", "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final OfflinedEnvironment environment;

    public OfflinedReducer(OfflinedEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new OfflinedReducer$build$1(this));
        final OfflinedReducer$build$2 offlinedReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.offlined.OfflinedReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((OfflinedReducer.State) obj).getActionableItemsListState();
            }
        };
        final OfflinedReducer$build$3 offlinedReducer$build$3 = OfflinedReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new ActionableItemsListReducer(environment.getActionableItemsListEnvironment()), new Function1<State, ActionableItemsListReducer.State>() { // from class: com.box.android.browse.cpl.offlined.OfflinedReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.State invoke(OfflinedReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return offlinedReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ActionableItemsListReducer.Action>() { // from class: com.box.android.browse.cpl.offlined.OfflinedReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(OfflinedReducer.Action action) {
                if (!(action instanceof OfflinedReducer.Action.ChildActionableItemsListAction)) {
                    action = null;
                }
                OfflinedReducer.Action.ChildActionableItemsListAction childActionableItemsListAction = (OfflinedReducer.Action.ChildActionableItemsListAction) action;
                if (childActionableItemsListAction != null) {
                    return childActionableItemsListAction.getState();
                }
                return null;
            }
        }, new Function2<State, ActionableItemsListReducer.State, State>() { // from class: com.box.android.browse.cpl.offlined.OfflinedReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final OfflinedReducer.State invoke(OfflinedReducer.State parentState, ActionableItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = offlinedReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(OfflinedReducer.State.class)).iterator();
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
                            return (OfflinedReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.offlined.OfflinedReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ActionableItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.offlined.OfflinedReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final OfflinedReducer.Action invoke(ActionableItemsListReducer.Action action) {
                Object objInvoke = offlinedReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (OfflinedReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.offlined.OfflinedReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "", "<init>", "()V", "Folder", "File", "ItemAction", "None", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$File;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$Folder;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$None;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$Folder;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "state", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;)V", "getState", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends Route implements Embedded<BrowseReducer.State> {
            public static final int $stable = 8;
            private final BrowseReducer.State state;

            public static /* synthetic */ Folder copy$default(Folder folder, BrowseReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = folder.state;
                }
                return folder.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.State getState() {
                return this.state;
            }

            public final Folder copy(BrowseReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Folder(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Folder) && Intrinsics.areEqual(this.state, ((Folder) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Folder(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(BrowseReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final BrowseReducer.State getState() {
                return this.state;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$File;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/FileModel;", "file", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends Route implements Embedded<FileModel> {
            public static final int $stable = 8;
            private final FileModel file;

            public static /* synthetic */ File copy$default(File file, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = file.file;
                }
                return file.copy(fileModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getState() {
                return this.file;
            }

            public final File copy(FileModel file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new File(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof File) && Intrinsics.areEqual(this.file, ((File) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "File(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(FileModel file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final FileModel getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "route", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;)V", "getRoute", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemAction extends Route implements Embedded<ActionableItemsListReducer.Route> {
            public static final int $stable = 0;
            private final ActionableItemsListReducer.Route route;

            public static /* synthetic */ ItemAction copy$default(ItemAction itemAction, ActionableItemsListReducer.Route route, int i, Object obj) {
                if ((i & 1) != 0) {
                    route = itemAction.route;
                }
                return itemAction.copy(route);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActionableItemsListReducer.Route getState() {
                return this.route;
            }

            public final ItemAction copy(ActionableItemsListReducer.Route route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new ItemAction(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemAction) && Intrinsics.areEqual(this.route, ((ItemAction) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "ItemAction(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemAction(ActionableItemsListReducer.Route route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final ActionableItemsListReducer.Route getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route$None;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class None extends Route {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "", "actionableItemsListState", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "navigationRoute", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "outdatedItems", "", "Lcom/box/android/domain/models/item/ItemModel;", ViewProps.VISIBLE, "", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;Ljava/util/List;Z)V", "getActionableItemsListState", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "getNavigationRoute", "()Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Route;", "getOutdatedItems", "()Ljava/util/List;", "getVisible", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ActionableItemsListReducer.State actionableItemsListState;
        private final Route navigationRoute;
        private final List<ItemModel> outdatedItems;
        private final boolean visible;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ActionableItemsListReducer.State state2, Route route, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.actionableItemsListState;
            }
            if ((i & 2) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 4) != 0) {
                list = state.outdatedItems;
            }
            if ((i & 8) != 0) {
                z = state.visible;
            }
            return state.copy(state2, route, list, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final List<ItemModel> component3() {
            return this.outdatedItems;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public final State copy(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, List<? extends ItemModel> outdatedItems, boolean visible) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(outdatedItems, "outdatedItems");
            return new State(actionableItemsListState, navigationRoute, outdatedItems, visible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.actionableItemsListState, state.actionableItemsListState) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.outdatedItems, state.outdatedItems) && this.visible == state.visible;
        }

        public int hashCode() {
            return (((((this.actionableItemsListState.hashCode() * 31) + this.navigationRoute.hashCode()) * 31) + this.outdatedItems.hashCode()) * 31) + Boolean.hashCode(this.visible);
        }

        public String toString() {
            return "State(actionableItemsListState=" + this.actionableItemsListState + ", navigationRoute=" + this.navigationRoute + ", outdatedItems=" + this.outdatedItems + ", visible=" + this.visible + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, List<? extends ItemModel> outdatedItems, boolean z) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(outdatedItems, "outdatedItems");
            this.actionableItemsListState = actionableItemsListState;
            this.navigationRoute = navigationRoute;
            this.outdatedItems = outdatedItems;
            this.visible = z;
        }

        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        public /* synthetic */ State(ActionableItemsListReducer.State state, Route.None none, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, (i & 2) != 0 ? Route.None.INSTANCE : none, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? false : z);
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final List<ItemModel> getOutdatedItems() {
            return this.outdatedItems;
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }

    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "", "<init>", "()V", "ChildActionableItemsListAction", "LoadItems", "TabVisible", "TabHidden", "OutdatedItems", "SyncItems", "SyncError", "NavigationCompleted", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$OutdatedItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$SyncError;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$SyncItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$TabHidden;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$TabVisible;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChildActionableItemsListAction extends Action implements Embedded<ActionableItemsListReducer.Action> {
            public static final int $stable = 0;
            private final ActionableItemsListReducer.Action action;

            public static /* synthetic */ ChildActionableItemsListAction copy$default(ChildActionableItemsListAction childActionableItemsListAction, ActionableItemsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = childActionableItemsListAction.action;
                }
                return childActionableItemsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActionableItemsListReducer.Action getState() {
                return this.action;
            }

            public final ChildActionableItemsListAction copy(ActionableItemsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ChildActionableItemsListAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChildActionableItemsListAction) && Intrinsics.areEqual(this.action, ((ChildActionableItemsListAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ChildActionableItemsListAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChildActionableItemsListAction(ActionableItemsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ActionableItemsListReducer.Action getAction() {
                return this.action;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class LoadItems extends Action {
            public static final int $stable = 0;
            public static final LoadItems INSTANCE = new LoadItems();

            private LoadItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$TabVisible;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TabVisible extends Action {
            public static final int $stable = 0;
            public static final TabVisible INSTANCE = new TabVisible();

            private TabVisible() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$TabHidden;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TabHidden extends Action {
            public static final int $stable = 0;
            public static final TabHidden INSTANCE = new TabHidden();

            private TabHidden() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$OutdatedItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OutdatedItems extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OutdatedItems copy$default(OutdatedItems outdatedItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = outdatedItems.items;
                }
                return outdatedItems.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.items;
            }

            public final OutdatedItems copy(List<? extends ItemModel> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new OutdatedItems(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OutdatedItems) && Intrinsics.areEqual(this.items, ((OutdatedItems) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "OutdatedItems(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public OutdatedItems(List<? extends ItemModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<ItemModel> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$SyncItems;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class SyncItems extends Action {
            public static final int $stable = 0;
            public static final SyncItems INSTANCE = new SyncItems();

            private SyncItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$SyncError;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class SyncError extends Action {
            public static final int $stable = 0;
            public static final SyncError INSTANCE = new SyncError();

            private SyncError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OfflinedReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class NavigationCompleted extends Action {
            public static final int $stable = 0;
            public static final NavigationCompleted INSTANCE = new NavigationCompleted();

            private NavigationCompleted() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceOfflined(State state, Action action) {
        if (action instanceof Action.ChildActionableItemsListAction) {
            return reduceChildActionableItemsList((Action.ChildActionableItemsListAction) action, state);
        }
        if (Intrinsics.areEqual(action, Action.LoadItems.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(new Action.ChildActionableItemsListAction(ActionableItemsListReducerKt.loadItems(ActionableItemsListReducer.Action.INSTANCE))), new Effect((Function1) new AnonymousClass1(null))));
        }
        if (Intrinsics.areEqual(action, Action.SyncItems.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, CollectionsKt.emptyList(), false, 11, null), Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)), Effect.INSTANCE.fireAndForget(new AnonymousClass3(state, null))));
        }
        if (Intrinsics.areEqual(action, Action.TabVisible.INSTANCE)) {
            return reduceTabVisible(state);
        }
        if (Intrinsics.areEqual(action, Action.TabHidden.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, 7, null), null, 2, null);
        }
        if (action instanceof Action.OutdatedItems) {
            return new ReducerResult<>(State.copy$default(state, null, null, ((Action.OutdatedItems) action).getItems(), false, 11, null), null, 2, null);
        }
        if (action instanceof Action.NavigationCompleted) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, null, false, 13, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$1", f = "OfflinedReducer.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return OfflinedReducer.this.new AnonymousClass1(continuation);
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
                obj = OfflinedReducer.this.environment.getOfflinedViewInteractor().getOutdatedItems(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            if (error instanceof Result.Success) {
                error = new Result.Success(new Action.OutdatedItems((List) ((Result.Success) error).getValue()));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(Action.SyncError.INSTANCE);
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.browse.cpl.offlined.OfflinedReducer.Action");
            return (Action) obj2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$2", f = "OfflinedReducer.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {}, v = 1)
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
            return OfflinedReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OfflinedReducer.this.environment.getOfflinedViewInteractor().syncOfflineItems(this.$state.getOutdatedItems(), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$3, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedReducer$reduceOfflined$3", f = "OfflinedReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State state, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return OfflinedReducer.this.new AnonymousClass3(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OfflinedReducer.this.environment.getActionableItemsListEnvironment().getBrowseAnalytics().sendEventOnRefreshOfflinedItems(this.$state.getOutdatedItems());
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceChildActionableItemsList(Action.ChildActionableItemsListAction action, State state) {
        ActionableItemsListReducer.Action action2 = action.getAction();
        if (action2 instanceof ActionableItemsListReducer.Action.ItemsListAction) {
            return reduceItemsList((ActionableItemsListReducer.Action.ItemsListAction) action2, state);
        }
        if (action2 instanceof ActionableItemsListReducer.Action.NavigateTo) {
            return new ReducerResult<>(State.copy$default(state, null, new Route.ItemAction(((ActionableItemsListReducer.Action.NavigateTo) action2).getRoute()), null, false, 13, null), null, 2, null);
        }
        if ((action2 instanceof ActionableItemsListReducer.Action.NavigationCompleted) || (action2 instanceof ActionableItemsListReducer.Action.ExitMultiselectMode)) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, null, false, 13, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceItemsList(ActionableItemsListReducer.Action.ItemsListAction actionableItemAction, State state) {
        ItemsListReducer.Action itemsListViewAction = actionableItemAction.getItemsListViewAction();
        if (itemsListViewAction instanceof ItemsListReducer.Action.RefreshCompleted) {
            if (state.getVisible()) {
                return new ReducerResult<>(state, new Effect(Action.LoadItems.INSTANCE));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (itemsListViewAction instanceof ItemsListReducer.Action.OpenItem) {
            return new ReducerResult<>(State.copy$default(state, null, createNavigation(state.getActionableItemsListState().getItemsListViewState().getItem(((ItemsListReducer.Action.OpenItem) itemsListViewAction).getId())), null, false, 13, null), null, 2, null);
        }
        if (itemsListViewAction instanceof ItemsListReducer.Action.ItemAction) {
            ItemsListReducer.Action.ItemAction itemAction = (ItemsListReducer.Action.ItemAction) itemsListViewAction;
            ItemReducer.Action action = itemAction.getAction();
            if ((action instanceof ItemReducer.Action.UpdateOfflineState) && ((ItemReducer.Action.UpdateOfflineState) action).getOfflineState() == BoxModelOfflineManager.State.NONE) {
                return new ReducerResult<>(state, new Effect(Action.LoadItems.INSTANCE));
            }
            if (action instanceof ItemReducer.Action.UpdateClicked) {
                List<ItemModel> outdatedItems = state.getOutdatedItems();
                ArrayList arrayList = new ArrayList();
                for (Object obj : outdatedItems) {
                    if (!Intrinsics.areEqual(ItemModelKt.toItemIdRemoteId((ItemModel) obj), itemAction.getId())) {
                        arrayList.add(obj);
                    }
                }
                return new ReducerResult<>(State.copy$default(state, null, null, arrayList, false, 11, null), null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Route createNavigation(ItemModel itemModel) {
        if (!(itemModel instanceof FolderModel)) {
            return itemModel instanceof FileModel ? new Route.File((FileModel) itemModel) : Route.None.INSTANCE;
        }
        ItemsListReducer.LoadingState loadingState = null;
        IdentifiedList identifiedList = null;
        Integer num = null;
        boolean z = false;
        Set set = null;
        BoxFeatureBanner boxFeatureBanner = null;
        boolean z2 = false;
        MultiselectReducer.State state = null;
        Function1 function1 = null;
        FilesDisplayConfigReducer.State state2 = null;
        String str = null;
        ItemsListReducer.RefreshState refreshState = null;
        ItemsListReducer.CacheState cacheState = null;
        boolean z3 = false;
        boolean z4 = false;
        OfflineFilesReducer.State state3 = null;
        DownloadFilesReducer.State state4 = null;
        BoxAiCenterReducer.State state5 = null;
        return new Route.Folder(new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(loadingState, identifiedList, num, (FolderModel) itemModel, z, set, boxFeatureBanner, z2, state, function1, state2, str, refreshState, cacheState, z3, z4, 65527, null), 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, state3, state4, 0 == true ? 1 : 0, 0 == true ? 1 : 0, state5, 510, 0 == true ? 1 : 0), null, 0 == true ? 1 : 0, false, 0 == true ? 1 : 0, 30, 0 == true ? 1 : 0));
    }

    private final ReducerResult<State, Action> reduceTabVisible(State state) {
        return new ReducerResult<>(State.copy$default(state, null, null, null, true, 7, null), Effect.INSTANCE.merge(new Effect(Action.LoadItems.INSTANCE), new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)))));
    }
}
