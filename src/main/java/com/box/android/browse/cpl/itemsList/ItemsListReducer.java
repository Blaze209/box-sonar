package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.base.presentation.multiselect.SelectionIdKt;
import com.box.android.browse.R;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.PerformanceType;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.observability.BrowsePerformanceEvent;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006789:;<B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J,\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020!H\u0002J&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J.\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J&\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 H\u0002J\u0018\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010/\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u00020$032\u0006\u0010\u0010\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u00104J$\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u000206H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006="}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "environment", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;)V", "getEnvironment", "()Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "reduceItemsList", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceLoadItemsFailed", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadItemsFailed;", "shouldShowFeatureBanner", "", "featureBanner", "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "loadingStateAfterRefreshCompleted", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "getErrorResString", "", "error", "Lcom/box/android/domain/models/DomainError;", "reduceItem", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "reduceItemLongClick", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "reduceItemClick", "reduceItemCheckboxClick", "handleMultiSelectItemToggling", "logTTIStart", "", "folderId", "logTTIEnd", "size", "loadingStateAfterItemsUpdated", "loadingStateAfterFetchFromRemoteFailed", "createUpdatedItemsList", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", AlertFragment.ARG_ITEMS, "", "(Ljava/util/List;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduceFilesConfig", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FilesConfig;", "State", "LoadingState", "RefreshState", "CacheState", "Action", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemsListReducer implements Reducable<State, Action> {
    private final Combine<State, Action> build;
    private final IItemsListViewEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$CacheState;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "EMPTY", "HAS_DATA", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum CacheState {
        NONE,
        EMPTY,
        HAS_DATA;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<CacheState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$RefreshState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "IN_PROGRESS", "COMPLETED", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum RefreshState {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<RefreshState> getEntries() {
            return $ENTRIES;
        }
    }

    public ItemsListReducer(IItemsListViewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new ItemsListReducer$build$1(this));
        final ItemsListReducer$build$2 itemsListReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemsListReducer.State) obj).getMultiselect();
            }
        };
        final ItemsListReducer$build$3 itemsListReducer$build$3 = ItemsListReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new MultiselectReducer(environment.getMultiselectEnvironment()), new Function1<State, MultiselectReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.multiselect.MultiselectReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.State invoke(ItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemsListReducer$build$2.invoke(it);
            }
        }, new Function1<Action, MultiselectReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.Action invoke(ItemsListReducer.Action action) {
                if (!(action instanceof ItemsListReducer.Action.Multiselect)) {
                    action = null;
                }
                ItemsListReducer.Action.Multiselect multiselect = (ItemsListReducer.Action.Multiselect) action;
                if (multiselect != null) {
                    return multiselect.getAction();
                }
                return null;
            }
        }, new Function2<State, MultiselectReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemsListReducer.State invoke(ItemsListReducer.State parentState, MultiselectReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemsListReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemsListReducer.State.class)).iterator();
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
                            return (ItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<MultiselectReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.Action invoke(MultiselectReducer.Action action) {
                Object objInvoke = itemsListReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.Action");
            }
        });
        final ItemsListReducer$build$5 itemsListReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemsListReducer.State) obj).getFilesConfigState();
            }
        };
        final ItemsListReducer$build$6 itemsListReducer$build$6 = ItemsListReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new FilesDisplayConfigReducer(environment.getLocalSortPreferences(), environment.getBrowseAnalytics()), new Function1<State, FilesDisplayConfigReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final FilesDisplayConfigReducer.State invoke(ItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemsListReducer$build$5.invoke(it);
            }
        }, new Function1<Action, FilesDisplayConfigReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final FilesDisplayConfigReducer.Action invoke(ItemsListReducer.Action action) {
                if (!(action instanceof ItemsListReducer.Action.FilesConfig)) {
                    action = null;
                }
                ItemsListReducer.Action.FilesConfig filesConfig = (ItemsListReducer.Action.FilesConfig) action;
                if (filesConfig != null) {
                    return filesConfig.getAction();
                }
                return null;
            }
        }, new Function2<State, FilesDisplayConfigReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemsListReducer.State invoke(ItemsListReducer.State parentState, FilesDisplayConfigReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemsListReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemsListReducer.State.class)).iterator();
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
                            return (ItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<FilesDisplayConfigReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.Action invoke(FilesDisplayConfigReducer.Action action) {
                Object objInvoke = itemsListReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.Action");
            }
        });
        final ItemsListReducer$build$8 itemsListReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemsListReducer.State) obj).getItems();
            }
        };
        final ItemsListReducer$build$9 itemsListReducer$build$9 = ItemsListReducer$build$9.INSTANCE;
        this.build = new Combine<>(new ForEachReducer(ifLetReducer2, new ItemReducer(new ItemEnvironment(environment.getThumbnailEnvironment(), environment.getBoxModelOfflineManagerWrapper())), itemsListReducer$build$8, new Function1<Action, EmbeddedItem<ItemId.Remote, ItemReducer.Action>>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<ItemId.Remote, ItemReducer.Action> invoke(ItemsListReducer.Action action) {
                if (!(action instanceof ItemsListReducer.Action.ItemAction)) {
                    action = null;
                }
                return (ItemsListReducer.Action.ItemAction) action;
            }
        }, new Function2<State, ItemReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemsListReducer.State invoke(ItemsListReducer.State parentState, ItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) itemsListReducer$build$8.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = itemsListReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemsListReducer.State.class)).iterator();
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
                            return (ItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<ItemId.Remote, ItemReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ItemsListReducer.Action invoke(ItemId.Remote id, ItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = itemsListReducer$build$9.invoke(id, action);
                if (objInvoke != null) {
                    return (ItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.Action");
            }
        }), new Reduce(new ItemsListReducer$build$11(this)));
    }

    public final IItemsListViewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010 \n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\u000e\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006J\u0010\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010F\u001a\u00020\u0006J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170HJ\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u0015\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\u0017\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016HÆ\u0003J\t\u0010S\u001a\u00020\u0019HÆ\u0003J\t\u0010T\u001a\u00020\u001bHÆ\u0003J\t\u0010U\u001a\u00020\u001dHÆ\u0003J\t\u0010V\u001a\u00020\u001fHÆ\u0003J\t\u0010W\u001a\u00020\rHÆ\u0003J\t\u0010X\u001a\u00020\rHÆ\u0003JÒ\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010ZJ\u0013\u0010[\u001a\u00020\r2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\tHÖ\u0001J\t\u0010^\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010 \u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0011\u0010!\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0011\u0010B\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bB\u0010.¨\u0006_"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "", "itemLoadingState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", AlertFragment.ARG_ITEMS, "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "error", "", "currentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "shouldDisableNonFolderItems", "", "disabledItems", "", "featureBanner", "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "displayFeatureBanner", "multiselect", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "filterPredicate", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "filesConfigState", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;", "uniqueCancelEffectKey", "", "refreshState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$RefreshState;", "cacheState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$CacheState;", "allowLegacyCache", "pullToRefreshIsRefreshing", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;Lcom/box/android/cpl/IdentifiedList;Ljava/lang/Integer;Lcom/box/android/domain/models/item/FolderModel;ZLjava/util/Set;Lcom/box/android/browse/utilities/BoxFeatureBanner;ZLcom/box/android/base/presentation/multiselect/MultiselectReducer$State;Lkotlin/jvm/functions/Function1;Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;Ljava/lang/String;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$RefreshState;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$CacheState;ZZ)V", "getItemLoadingState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "getItems", "()Lcom/box/android/cpl/IdentifiedList;", "getError", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getShouldDisableNonFolderItems", "()Z", "getDisabledItems", "()Ljava/util/Set;", "getFeatureBanner", "()Lcom/box/android/browse/utilities/BoxFeatureBanner;", "getDisplayFeatureBanner", "getMultiselect", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "getFilterPredicate", "()Lkotlin/jvm/functions/Function1;", "getFilesConfigState", "()Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;", "getUniqueCancelEffectKey", "()Ljava/lang/String;", "getRefreshState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$RefreshState;", "getCacheState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$CacheState;", "getAllowLegacyCache", "getPullToRefreshIsRefreshing", "isSelecting", "isItemSelected", "itemId", "getItem", "id", "getSelectedItemModels", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;Lcom/box/android/cpl/IdentifiedList;Ljava/lang/Integer;Lcom/box/android/domain/models/item/FolderModel;ZLjava/util/Set;Lcom/box/android/browse/utilities/BoxFeatureBanner;ZLcom/box/android/base/presentation/multiselect/MultiselectReducer$State;Lkotlin/jvm/functions/Function1;Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;Ljava/lang/String;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$RefreshState;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$CacheState;ZZ)Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "equals", "other", "hashCode", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean allowLegacyCache;
        private final CacheState cacheState;
        private final FolderModel currentFolder;
        private final Set<ItemId.Remote> disabledItems;
        private final boolean displayFeatureBanner;
        private final Integer error;
        private final BoxFeatureBanner featureBanner;
        private final FilesDisplayConfigReducer.State filesConfigState;
        private final Function1<ItemModel, Boolean> filterPredicate;
        private final LoadingState itemLoadingState;
        private final IdentifiedList<ItemId.Remote, ItemReducer.State> items;
        private final MultiselectReducer.State multiselect;
        private final boolean pullToRefreshIsRefreshing;
        private final RefreshState refreshState;
        private final boolean shouldDisableNonFolderItems;
        private final String uniqueCancelEffectKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, LoadingState loadingState, IdentifiedList identifiedList, Integer num, FolderModel folderModel, boolean z, Set set, BoxFeatureBanner boxFeatureBanner, boolean z2, MultiselectReducer.State state2, Function1 function1, FilesDisplayConfigReducer.State state3, String str, RefreshState refreshState, CacheState cacheState, boolean z3, boolean z4, int i, Object obj) {
            LoadingState loadingState2 = (i & 1) != 0 ? state.itemLoadingState : loadingState;
            return state.copy(loadingState2, (i & 2) != 0 ? state.items : identifiedList, (i & 4) != 0 ? state.error : num, (i & 8) != 0 ? state.currentFolder : folderModel, (i & 16) != 0 ? state.shouldDisableNonFolderItems : z, (i & 32) != 0 ? state.disabledItems : set, (i & 64) != 0 ? state.featureBanner : boxFeatureBanner, (i & 128) != 0 ? state.displayFeatureBanner : z2, (i & 256) != 0 ? state.multiselect : state2, (i & 512) != 0 ? state.filterPredicate : function1, (i & 1024) != 0 ? state.filesConfigState : state3, (i & 2048) != 0 ? state.uniqueCancelEffectKey : str, (i & 4096) != 0 ? state.refreshState : refreshState, (i & 8192) != 0 ? state.cacheState : cacheState, (i & 16384) != 0 ? state.allowLegacyCache : z3, (i & 32768) != 0 ? state.pullToRefreshIsRefreshing : z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoadingState getItemLoadingState() {
            return this.itemLoadingState;
        }

        public final Function1<ItemModel, Boolean> component10() {
            return this.filterPredicate;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final FilesDisplayConfigReducer.State getFilesConfigState() {
            return this.filesConfigState;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getUniqueCancelEffectKey() {
            return this.uniqueCancelEffectKey;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final RefreshState getRefreshState() {
            return this.refreshState;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final CacheState getCacheState() {
            return this.cacheState;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final boolean getAllowLegacyCache() {
            return this.allowLegacyCache;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final boolean getPullToRefreshIsRefreshing() {
            return this.pullToRefreshIsRefreshing;
        }

        public final IdentifiedList<ItemId.Remote, ItemReducer.State> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getShouldDisableNonFolderItems() {
            return this.shouldDisableNonFolderItems;
        }

        public final Set<ItemId.Remote> component6() {
            return this.disabledItems;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BoxFeatureBanner getFeatureBanner() {
            return this.featureBanner;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getDisplayFeatureBanner() {
            return this.displayFeatureBanner;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final State copy(LoadingState itemLoadingState, IdentifiedList<ItemId.Remote, ItemReducer.State> items, Integer error, FolderModel currentFolder, boolean shouldDisableNonFolderItems, Set<ItemId.Remote> disabledItems, BoxFeatureBanner featureBanner, boolean displayFeatureBanner, MultiselectReducer.State multiselect, Function1<? super ItemModel, Boolean> filterPredicate, FilesDisplayConfigReducer.State filesConfigState, String uniqueCancelEffectKey, RefreshState refreshState, CacheState cacheState, boolean allowLegacyCache, boolean pullToRefreshIsRefreshing) {
            Intrinsics.checkNotNullParameter(itemLoadingState, "itemLoadingState");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
            Intrinsics.checkNotNullParameter(disabledItems, "disabledItems");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            Intrinsics.checkNotNullParameter(filesConfigState, "filesConfigState");
            Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
            Intrinsics.checkNotNullParameter(refreshState, "refreshState");
            Intrinsics.checkNotNullParameter(cacheState, "cacheState");
            return new State(itemLoadingState, items, error, currentFolder, shouldDisableNonFolderItems, disabledItems, featureBanner, displayFeatureBanner, multiselect, filterPredicate, filesConfigState, uniqueCancelEffectKey, refreshState, cacheState, allowLegacyCache, pullToRefreshIsRefreshing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemLoadingState, state.itemLoadingState) && Intrinsics.areEqual(this.items, state.items) && Intrinsics.areEqual(this.error, state.error) && Intrinsics.areEqual(this.currentFolder, state.currentFolder) && this.shouldDisableNonFolderItems == state.shouldDisableNonFolderItems && Intrinsics.areEqual(this.disabledItems, state.disabledItems) && this.featureBanner == state.featureBanner && this.displayFeatureBanner == state.displayFeatureBanner && Intrinsics.areEqual(this.multiselect, state.multiselect) && Intrinsics.areEqual(this.filterPredicate, state.filterPredicate) && Intrinsics.areEqual(this.filesConfigState, state.filesConfigState) && Intrinsics.areEqual(this.uniqueCancelEffectKey, state.uniqueCancelEffectKey) && this.refreshState == state.refreshState && this.cacheState == state.cacheState && this.allowLegacyCache == state.allowLegacyCache && this.pullToRefreshIsRefreshing == state.pullToRefreshIsRefreshing;
        }

        public int hashCode() {
            int iHashCode = ((this.itemLoadingState.hashCode() * 31) + this.items.hashCode()) * 31;
            Integer num = this.error;
            int iHashCode2 = (((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.currentFolder.hashCode()) * 31) + Boolean.hashCode(this.shouldDisableNonFolderItems)) * 31) + this.disabledItems.hashCode()) * 31;
            BoxFeatureBanner boxFeatureBanner = this.featureBanner;
            int iHashCode3 = (((((iHashCode2 + (boxFeatureBanner == null ? 0 : boxFeatureBanner.hashCode())) * 31) + Boolean.hashCode(this.displayFeatureBanner)) * 31) + this.multiselect.hashCode()) * 31;
            Function1<ItemModel, Boolean> function1 = this.filterPredicate;
            return ((((((((((((iHashCode3 + (function1 != null ? function1.hashCode() : 0)) * 31) + this.filesConfigState.hashCode()) * 31) + this.uniqueCancelEffectKey.hashCode()) * 31) + this.refreshState.hashCode()) * 31) + this.cacheState.hashCode()) * 31) + Boolean.hashCode(this.allowLegacyCache)) * 31) + Boolean.hashCode(this.pullToRefreshIsRefreshing);
        }

        public String toString() {
            return "State(itemLoadingState=" + this.itemLoadingState + ", items=" + this.items + ", error=" + this.error + ", currentFolder=" + this.currentFolder + ", shouldDisableNonFolderItems=" + this.shouldDisableNonFolderItems + ", disabledItems=" + this.disabledItems + ", featureBanner=" + this.featureBanner + ", displayFeatureBanner=" + this.displayFeatureBanner + ", multiselect=" + this.multiselect + ", filterPredicate=" + this.filterPredicate + ", filesConfigState=" + this.filesConfigState + ", uniqueCancelEffectKey=" + this.uniqueCancelEffectKey + ", refreshState=" + this.refreshState + ", cacheState=" + this.cacheState + ", allowLegacyCache=" + this.allowLegacyCache + ", pullToRefreshIsRefreshing=" + this.pullToRefreshIsRefreshing + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(LoadingState itemLoadingState, IdentifiedList<ItemId.Remote, ItemReducer.State> items, Integer num, FolderModel currentFolder, boolean z, Set<ItemId.Remote> disabledItems, BoxFeatureBanner boxFeatureBanner, boolean z2, MultiselectReducer.State multiselect, Function1<? super ItemModel, Boolean> function1, FilesDisplayConfigReducer.State filesConfigState, String uniqueCancelEffectKey, RefreshState refreshState, CacheState cacheState, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(itemLoadingState, "itemLoadingState");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
            Intrinsics.checkNotNullParameter(disabledItems, "disabledItems");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            Intrinsics.checkNotNullParameter(filesConfigState, "filesConfigState");
            Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
            Intrinsics.checkNotNullParameter(refreshState, "refreshState");
            Intrinsics.checkNotNullParameter(cacheState, "cacheState");
            this.itemLoadingState = itemLoadingState;
            this.items = items;
            this.error = num;
            this.currentFolder = currentFolder;
            this.shouldDisableNonFolderItems = z;
            this.disabledItems = disabledItems;
            this.featureBanner = boxFeatureBanner;
            this.displayFeatureBanner = z2;
            this.multiselect = multiselect;
            this.filterPredicate = function1;
            this.filesConfigState = filesConfigState;
            this.uniqueCancelEffectKey = uniqueCancelEffectKey;
            this.refreshState = refreshState;
            this.cacheState = cacheState;
            this.allowLegacyCache = z3;
            this.pullToRefreshIsRefreshing = z4;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(LoadingState loadingState, IdentifiedList identifiedList, Integer num, FolderModel folderModel, boolean z, Set set, BoxFeatureBanner boxFeatureBanner, boolean z2, MultiselectReducer.State state, Function1 function1, FilesDisplayConfigReducer.State state2, String str, RefreshState refreshState, CacheState cacheState, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str2;
            LoadingState loadingState2 = (i & 1) != 0 ? LoadingState.Loading.INSTANCE : loadingState;
            IdentifiedList identifiedListEmptyIdentifiedList = (i & 2) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList;
            Integer num2 = (i & 4) != 0 ? null : num;
            boolean z5 = (i & 16) != 0 ? false : z;
            Set setEmptySet = (i & 32) != 0 ? SetsKt.emptySet() : set;
            BoxFeatureBanner boxFeatureBanner2 = (i & 64) != 0 ? null : boxFeatureBanner;
            boolean z6 = (i & 128) != 0 ? false : z2;
            MultiselectReducer.State state3 = (i & 256) != 0 ? MultiselectReducer.State.Available.INSTANCE : state;
            Function1 function2 = (i & 512) != 0 ? null : function1;
            FilesDisplayConfigReducer.State state4 = (i & 1024) != 0 ? new FilesDisplayConfigReducer.State(null, null, null, null, 15, null) : state2;
            if ((i & 2048) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                str2 = string;
            } else {
                str2 = str;
            }
            this(loadingState2, identifiedListEmptyIdentifiedList, num2, folderModel, z5, setEmptySet, boxFeatureBanner2, z6, state3, function2, state4, str2, (i & 4096) != 0 ? RefreshState.NOT_STARTED : refreshState, (i & 8192) != 0 ? CacheState.NONE : cacheState, (i & 16384) != 0 ? false : z3, (i & 32768) != 0 ? false : z4);
        }

        public final LoadingState getItemLoadingState() {
            return this.itemLoadingState;
        }

        public final IdentifiedList<ItemId.Remote, ItemReducer.State> getItems() {
            return this.items;
        }

        public final Integer getError() {
            return this.error;
        }

        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        public final boolean getShouldDisableNonFolderItems() {
            return this.shouldDisableNonFolderItems;
        }

        public final Set<ItemId.Remote> getDisabledItems() {
            return this.disabledItems;
        }

        public final BoxFeatureBanner getFeatureBanner() {
            return this.featureBanner;
        }

        public final boolean getDisplayFeatureBanner() {
            return this.displayFeatureBanner;
        }

        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final Function1<ItemModel, Boolean> getFilterPredicate() {
            return this.filterPredicate;
        }

        public final FilesDisplayConfigReducer.State getFilesConfigState() {
            return this.filesConfigState;
        }

        public final String getUniqueCancelEffectKey() {
            return this.uniqueCancelEffectKey;
        }

        public final RefreshState getRefreshState() {
            return this.refreshState;
        }

        public final CacheState getCacheState() {
            return this.cacheState;
        }

        public final boolean getAllowLegacyCache() {
            return this.allowLegacyCache;
        }

        public final boolean getPullToRefreshIsRefreshing() {
            return this.pullToRefreshIsRefreshing;
        }

        public final boolean isSelecting() {
            return this.multiselect instanceof MultiselectReducer.State.Selecting;
        }

        public final boolean isItemSelected(ItemId.Remote itemId) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            MultiselectReducer.State state = this.multiselect;
            if (state instanceof MultiselectReducer.State.Selecting) {
                return ((MultiselectReducer.State.Selecting) state).isItemSelected(SelectionIdKt.toSelectionId(itemId));
            }
            return false;
        }

        public final ItemModel getItem(ItemId.Remote id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ItemReducer.State state = (ItemReducer.State) this.items.getById(id);
            if (state != null) {
                return state.getItemModel();
            }
            return null;
        }

        public final List<ItemModel> getSelectedItemModels() {
            if (this.multiselect instanceof MultiselectReducer.State.Selecting) {
                IdentifiedList<ItemId.Remote, ItemReducer.State> identifiedList = this.items;
                ArrayList arrayList = new ArrayList();
                for (ItemReducer.State state : identifiedList) {
                    if (isItemSelected(state.getId())) {
                        arrayList.add(state);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((ItemReducer.State) it.next()).getItemModel());
                }
                return arrayList3;
            }
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "", "<init>", "()V", "Error", "ForbiddenByPolicy", "Loading", "PartiallyLoaded", "FullyLoaded", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$Error;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$ForbiddenByPolicy;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$FullyLoaded;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$Loading;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$PartiallyLoaded;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class LoadingState {
        public static final int $stable = 0;

        public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$Error;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends LoadingState {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 106558651;
            }

            public String toString() {
                return "Error";
            }

            private Error() {
                super(null);
            }
        }

        private LoadingState() {
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$ForbiddenByPolicy;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ForbiddenByPolicy extends LoadingState {
            public static final int $stable = 0;
            public static final ForbiddenByPolicy INSTANCE = new ForbiddenByPolicy();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ForbiddenByPolicy)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -828021323;
            }

            public String toString() {
                return "ForbiddenByPolicy";
            }

            private ForbiddenByPolicy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$Loading;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends LoadingState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1139286831;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$PartiallyLoaded;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PartiallyLoaded extends LoadingState {
            public static final int $stable = 0;
            public static final PartiallyLoaded INSTANCE = new PartiallyLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PartiallyLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1473879194;
            }

            public String toString() {
                return "PartiallyLoaded";
            }

            private PartiallyLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState$FullyLoaded;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FullyLoaded extends LoadingState {
            public static final int $stable = 0;
            public static final FullyLoaded INSTANCE = new FullyLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FullyLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -284631838;
            }

            public String toString() {
                return "FullyLoaded";
            }

            private FullyLoaded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0017\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0017\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01¨\u00062"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "", "<init>", "()V", "FetchItems", "HandledError", "RefreshFromRemote", "LoadItems", "RefreshCompleted", "RefreshFeatureBannerVisibility", "FeatureBannerDismissed", "FeatureBannerClicked", "FeatureBannerDisplayed", "ItemAction", "OpenItem", "UpdateItems", "ItemsReceived", "RefreshFromRemoteFailed", "LoadItemsFailed", "Multiselect", "FilesConfig", "PulledToRefresh", "LoadFromLegacyCache", "LegacyCacheError", "RefreshToken", "TabChanged", "ScreenUpdated", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerDismissed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerDisplayed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FetchItems;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FilesConfig;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$HandledError;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ItemAction;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ItemsReceived;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LegacyCacheError;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadFromLegacyCache;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadItemsFailed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$Multiselect;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$OpenItem;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$PulledToRefresh;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshCompleted;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFeatureBannerVisibility;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFromRemote;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFromRemoteFailed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshToken;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ScreenUpdated;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$TabChanged;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$UpdateItems;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FetchItems;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchItems extends Action {
            public static final int $stable = 0;
            public static final FetchItems INSTANCE = new FetchItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1373794610;
            }

            public String toString() {
                return "FetchItems";
            }

            private FetchItems() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$HandledError;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandledError extends Action {
            public static final int $stable = 0;
            public static final HandledError INSTANCE = new HandledError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandledError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1158428984;
            }

            public String toString() {
                return "HandledError";
            }

            private HandledError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFromRemote;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFromRemote extends Action {
            public static final int $stable = 0;
            public static final RefreshFromRemote INSTANCE = new RefreshFromRemote();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshFromRemote)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 975449151;
            }

            public String toString() {
                return "RefreshFromRemote";
            }

            private RefreshFromRemote() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadItems extends Action {
            public static final int $stable = 0;
            public static final LoadItems INSTANCE = new LoadItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 18892014;
            }

            public String toString() {
                return "LoadItems";
            }

            private LoadItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshCompleted;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshCompleted extends Action {
            public static final int $stable = 0;
            public static final RefreshCompleted INSTANCE = new RefreshCompleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshCompleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1855345476;
            }

            public String toString() {
                return "RefreshCompleted";
            }

            private RefreshCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFeatureBannerVisibility;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFeatureBannerVisibility extends Action {
            public static final int $stable = 0;
            public static final RefreshFeatureBannerVisibility INSTANCE = new RefreshFeatureBannerVisibility();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshFeatureBannerVisibility)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -706484443;
            }

            public String toString() {
                return "RefreshFeatureBannerVisibility";
            }

            private RefreshFeatureBannerVisibility() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerDismissed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", HubsObservability.HUB_ASSET_BANNER, "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "<init>", "(Lcom/box/android/browse/utilities/BoxFeatureBanner;)V", "getBanner", "()Lcom/box/android/browse/utilities/BoxFeatureBanner;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeatureBannerDismissed extends Action {
            public static final int $stable = 0;
            private final BoxFeatureBanner banner;

            public static /* synthetic */ FeatureBannerDismissed copy$default(FeatureBannerDismissed featureBannerDismissed, BoxFeatureBanner boxFeatureBanner, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxFeatureBanner = featureBannerDismissed.banner;
                }
                return featureBannerDismissed.copy(boxFeatureBanner);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxFeatureBanner getBanner() {
                return this.banner;
            }

            public final FeatureBannerDismissed copy(BoxFeatureBanner banner) {
                Intrinsics.checkNotNullParameter(banner, "banner");
                return new FeatureBannerDismissed(banner);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureBannerDismissed) && this.banner == ((FeatureBannerDismissed) other).banner;
            }

            public int hashCode() {
                return this.banner.hashCode();
            }

            public String toString() {
                return "FeatureBannerDismissed(banner=" + this.banner + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureBannerDismissed(BoxFeatureBanner banner) {
                super(null);
                Intrinsics.checkNotNullParameter(banner, "banner");
                this.banner = banner;
            }

            public final BoxFeatureBanner getBanner() {
                return this.banner;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", HubsObservability.HUB_ASSET_BANNER, "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "<init>", "(Lcom/box/android/browse/utilities/BoxFeatureBanner;)V", "getBanner", "()Lcom/box/android/browse/utilities/BoxFeatureBanner;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeatureBannerClicked extends Action {
            public static final int $stable = 0;
            private final BoxFeatureBanner banner;

            public static /* synthetic */ FeatureBannerClicked copy$default(FeatureBannerClicked featureBannerClicked, BoxFeatureBanner boxFeatureBanner, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxFeatureBanner = featureBannerClicked.banner;
                }
                return featureBannerClicked.copy(boxFeatureBanner);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxFeatureBanner getBanner() {
                return this.banner;
            }

            public final FeatureBannerClicked copy(BoxFeatureBanner banner) {
                Intrinsics.checkNotNullParameter(banner, "banner");
                return new FeatureBannerClicked(banner);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureBannerClicked) && this.banner == ((FeatureBannerClicked) other).banner;
            }

            public int hashCode() {
                return this.banner.hashCode();
            }

            public String toString() {
                return "FeatureBannerClicked(banner=" + this.banner + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureBannerClicked(BoxFeatureBanner banner) {
                super(null);
                Intrinsics.checkNotNullParameter(banner, "banner");
                this.banner = banner;
            }

            public final BoxFeatureBanner getBanner() {
                return this.banner;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FeatureBannerDisplayed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeatureBannerDisplayed extends Action {
            public static final int $stable = 0;
            public static final FeatureBannerDisplayed INSTANCE = new FeatureBannerDisplayed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FeatureBannerDisplayed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -197473461;
            }

            public String toString() {
                return "FeatureBannerDisplayed";
            }

            private FeatureBannerDisplayed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ItemAction;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemAction extends Action implements EmbeddedItem<ItemId.Remote, ItemReducer.Action> {
            public static final int $stable = 8;
            private final ItemReducer.Action action;
            private final ItemId.Remote id;

            public static /* synthetic */ ItemAction copy$default(ItemAction itemAction, ItemId.Remote remote, ItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = itemAction.id;
                }
                if ((i & 2) != 0) {
                    action = itemAction.action;
                }
                return itemAction.copy(remote, action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemReducer.Action getAction() {
                return this.action;
            }

            public final ItemAction copy(ItemId.Remote id, ItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemAction(id, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemAction)) {
                    return false;
                }
                ItemAction itemAction = (ItemAction) other;
                return Intrinsics.areEqual(this.id, itemAction.id) && Intrinsics.areEqual(this.action, itemAction.action);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "ItemAction(id=" + this.id + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemAction(ItemId.Remote id, ItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final ItemReducer.Action getAction() {
                return this.action;
            }

            public final ItemId.Remote getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$OpenItem;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "id", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;)V", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItem extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote id;

            public static /* synthetic */ OpenItem copy$default(OpenItem openItem, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = openItem.id;
                }
                return openItem.copy(remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getId() {
                return this.id;
            }

            public final OpenItem copy(ItemId.Remote id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new OpenItem(id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenItem) && Intrinsics.areEqual(this.id, ((OpenItem) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "OpenItem(id=" + this.id + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItem(ItemId.Remote id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public final ItemId.Remote getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$UpdateItems;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "newItems", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "<init>", "(Lcom/box/android/cpl/IdentifiedList;)V", "getNewItems", "()Lcom/box/android/cpl/IdentifiedList;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateItems extends Action {
            public static final int $stable = 8;
            private final IdentifiedList<ItemId.Remote, ItemReducer.State> newItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateItems copy$default(UpdateItems updateItems, IdentifiedList identifiedList, int i, Object obj) {
                if ((i & 1) != 0) {
                    identifiedList = updateItems.newItems;
                }
                return updateItems.copy(identifiedList);
            }

            public final IdentifiedList<ItemId.Remote, ItemReducer.State> component1() {
                return this.newItems;
            }

            public final UpdateItems copy(IdentifiedList<ItemId.Remote, ItemReducer.State> newItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                return new UpdateItems(newItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateItems) && Intrinsics.areEqual(this.newItems, ((UpdateItems) other).newItems);
            }

            public int hashCode() {
                return this.newItems.hashCode();
            }

            public String toString() {
                return "UpdateItems(newItems=" + this.newItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateItems(IdentifiedList<ItemId.Remote, ItemReducer.State> newItems) {
                super(null);
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                this.newItems = newItems;
            }

            public final IdentifiedList<ItemId.Remote, ItemReducer.State> getNewItems() {
                return this.newItems;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ItemsReceived;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "newItems", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getNewItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsReceived extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> newItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsReceived copy$default(ItemsReceived itemsReceived, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsReceived.newItems;
                }
                return itemsReceived.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.newItems;
            }

            public final ItemsReceived copy(List<? extends ItemModel> newItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                return new ItemsReceived(newItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsReceived) && Intrinsics.areEqual(this.newItems, ((ItemsReceived) other).newItems);
            }

            public int hashCode() {
                return this.newItems.hashCode();
            }

            public String toString() {
                return "ItemsReceived(newItems=" + this.newItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ItemsReceived(List<? extends ItemModel> newItems) {
                super(null);
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                this.newItems = newItems;
            }

            public final List<ItemModel> getNewItems() {
                return this.newItems;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshFromRemoteFailed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFromRemoteFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ RefreshFromRemoteFailed copy$default(RefreshFromRemoteFailed refreshFromRemoteFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = refreshFromRemoteFailed.error;
                }
                return refreshFromRemoteFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final RefreshFromRemoteFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new RefreshFromRemoteFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshFromRemoteFailed) && Intrinsics.areEqual(this.error, ((RefreshFromRemoteFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "RefreshFromRemoteFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshFromRemoteFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadItemsFailed;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadItemsFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ LoadItemsFailed copy$default(LoadItemsFailed loadItemsFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = loadItemsFailed.error;
                }
                return loadItemsFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final LoadItemsFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new LoadItemsFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadItemsFailed) && Intrinsics.areEqual(this.error, ((LoadItemsFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "LoadItemsFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadItemsFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$Multiselect;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Multiselect extends Action implements Embedded<MultiselectReducer.Action> {
            public static final int $stable = MultiselectReducer.Action.$stable;
            private final MultiselectReducer.Action action;

            public static /* synthetic */ Multiselect copy$default(Multiselect multiselect, MultiselectReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = multiselect.action;
                }
                return multiselect.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MultiselectReducer.Action getAction() {
                return this.action;
            }

            public final Multiselect copy(MultiselectReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Multiselect(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Multiselect) && Intrinsics.areEqual(this.action, ((Multiselect) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Multiselect(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Multiselect(MultiselectReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final MultiselectReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$FilesConfig;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesConfig extends Action implements Embedded<FilesDisplayConfigReducer.Action> {
            public static final int $stable = 0;
            private final FilesDisplayConfigReducer.Action action;

            public static /* synthetic */ FilesConfig copy$default(FilesConfig filesConfig, FilesDisplayConfigReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = filesConfig.action;
                }
                return filesConfig.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesDisplayConfigReducer.Action getAction() {
                return this.action;
            }

            public final FilesConfig copy(FilesDisplayConfigReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FilesConfig(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilesConfig) && Intrinsics.areEqual(this.action, ((FilesConfig) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FilesConfig(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesConfig(FilesDisplayConfigReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FilesDisplayConfigReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$PulledToRefresh;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PulledToRefresh extends Action {
            public static final int $stable = 0;
            public static final PulledToRefresh INSTANCE = new PulledToRefresh();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PulledToRefresh)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 182006288;
            }

            public String toString() {
                return "PulledToRefresh";
            }

            private PulledToRefresh() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LoadFromLegacyCache;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadFromLegacyCache extends Action {
            public static final int $stable = 0;
            public static final LoadFromLegacyCache INSTANCE = new LoadFromLegacyCache();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadFromLegacyCache)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1033371939;
            }

            public String toString() {
                return "LoadFromLegacyCache";
            }

            private LoadFromLegacyCache() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$LegacyCacheError;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LegacyCacheError extends Action {
            public static final int $stable = 0;
            public static final LegacyCacheError INSTANCE = new LegacyCacheError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LegacyCacheError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -694739109;
            }

            public String toString() {
                return "LegacyCacheError";
            }

            private LegacyCacheError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$RefreshToken;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshToken extends Action {
            public static final int $stable = 0;
            public static final RefreshToken INSTANCE = new RefreshToken();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshToken)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1947619562;
            }

            public String toString() {
                return "RefreshToken";
            }

            private RefreshToken() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$TabChanged;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "folderId", "", "<init>", "(Ljava/lang/String;)V", "getFolderId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabChanged extends Action {
            public static final int $stable = 0;
            private final String folderId;

            public static /* synthetic */ TabChanged copy$default(TabChanged tabChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = tabChanged.folderId;
                }
                return tabChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFolderId() {
                return this.folderId;
            }

            public final TabChanged copy(String folderId) {
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                return new TabChanged(folderId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TabChanged) && Intrinsics.areEqual(this.folderId, ((TabChanged) other).folderId);
            }

            public int hashCode() {
                return this.folderId.hashCode();
            }

            public String toString() {
                return "TabChanged(folderId=" + this.folderId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TabChanged(String folderId) {
                super(null);
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                this.folderId = folderId;
            }

            public final String getFolderId() {
                return this.folderId;
            }
        }

        /* JADX INFO: compiled from: ItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action$ScreenUpdated;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenUpdated extends Action {
            public static final int $stable = 0;
            public static final ScreenUpdated INSTANCE = new ScreenUpdated();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenUpdated)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1149419741;
            }

            public String toString() {
                return "ScreenUpdated";
            }

            private ScreenUpdated() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceItemsList(State state, Action action) {
        Effect effectNone;
        if (action instanceof Action.RefreshFromRemote) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, RefreshState.IN_PROGRESS, null, false, false, 61439, null), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, null))).cancellable(INSTANCE.refreshItemsEffectId(state.getUniqueCancelEffectKey()), true));
        }
        if (action instanceof Action.LoadItems) {
            Effect.Companion companion = Effect.INSTANCE;
            final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(this.environment.getItemsViewUseCase().fetchItems(ItemModelKt.toItemIdRemoteId(state.getCurrentFolder())));
            return new ReducerResult<>(state, companion.merge(EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$$inlined$mapNotNull$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super ItemsListReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$$inlined$mapNotNull$1$2", f = "ItemsListReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {62}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                            Result.Error error = (Result) obj;
                            if (error instanceof Result.Success) {
                                error = new Result.Success(new ItemsListReducer.Action.ItemsReceived((List) ((Result.Success) error).getValue()));
                            } else if (!(error instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(new ItemsListReducer.Action.LoadItemsFailed((DomainError) ((Result.Error) error).getValue()));
                            }
                            Object obj3 = com.box.android.domain.utils.result.ResultKt.get(error);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.Action");
                            ItemsListReducer.Action action = (ItemsListReducer.Action) obj3;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(action);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(action, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj4 = anonymousClass1.L$2;
                            Object obj5 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }).cancellable(INSTANCE.fetchItemsEffectId(state.getUniqueCancelEffectKey()), true), new Effect(new Action.FilesConfig(FilesDisplayConfigReducer.Action.Initialize.INSTANCE))));
        }
        if (action instanceof Action.RefreshCompleted) {
            return new ReducerResult<>(State.copy$default(state, loadingStateAfterRefreshCompleted(state), null, null, null, false, null, null, false, null, null, null, null, RefreshState.COMPLETED, null, false, false, 28670, null), new Effect(Action.LoadItems.INSTANCE));
        }
        if (action instanceof Action.RefreshFeatureBannerVisibility) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, shouldShowFeatureBanner(state.getFeatureBanner()), null, null, null, null, null, null, false, false, 65407, null), null, 2, null);
        }
        if (action instanceof Action.FeatureBannerDismissed) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass3(action, null)), new Effect(Action.RefreshFeatureBannerVisibility.INSTANCE)));
        }
        if (action instanceof Action.FeatureBannerDisplayed) {
            BoxFeatureBanner featureBanner = state.getFeatureBanner();
            if (featureBanner == null || (effectNone = Effect.INSTANCE.fireAndForget(new ItemsListReducer$reduceItemsList$4$1(this, featureBanner, null))) == null) {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.FetchItems) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(Action.RefreshFromRemote.INSTANCE), new Effect(Action.LoadItems.INSTANCE), Effect.INSTANCE.fireAndForget(new AnonymousClass5(state, null))));
        }
        if (action instanceof Action.ItemsReceived) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass6(action, state, null)));
        }
        if (action instanceof Action.UpdateItems) {
            LoadingState loadingStateLoadingStateAfterItemsUpdated = loadingStateAfterItemsUpdated(state);
            return new ReducerResult<>(State.copy$default(state, loadingStateLoadingStateAfterItemsUpdated, ((Action.UpdateItems) action).getNewItems(), null, null, false, null, null, false, null, null, null, null, null, CacheState.HAS_DATA, false, false, 57340, null), Effect.INSTANCE.fireAndForget(new AnonymousClass7(loadingStateLoadingStateAfterItemsUpdated, this, action, state, null)));
        }
        if (action instanceof Action.RefreshFromRemoteFailed) {
            DomainError error = ((Action.RefreshFromRemoteFailed) action).getError();
            Effect effectFireAndForget = Effect.INSTANCE.fireAndForget(new ItemsListReducer$reduceItemsList$effects$1(this, state, null));
            if (DomainErrorKt.isNetworkConnectionError(error) && Intrinsics.areEqual(state.getItemLoadingState(), LoadingState.Loading.INSTANCE) && state.getAllowLegacyCache()) {
                effectFireAndForget.merge(new Effect(Action.LoadFromLegacyCache.INSTANCE));
            } else if (error instanceof DomainError.Unauthorized) {
                effectFireAndForget.merge(new Effect(Action.RefreshToken.INSTANCE));
            }
            return new ReducerResult<>(State.copy$default(state, loadingStateAfterFetchFromRemoteFailed(state, error), null, Integer.valueOf(getErrorResString(error)), null, false, null, null, false, null, null, null, null, RefreshState.COMPLETED, null, false, false, 28666, null), effectFireAndForget);
        }
        if (action instanceof Action.LoadItemsFailed) {
            return reduceLoadItemsFailed(state, (Action.LoadItemsFailed) action);
        }
        if (action instanceof Action.HandledError) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, 65531, null), null, 2, null);
        }
        if (action instanceof Action.LoadFromLegacyCache) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass8(state, null)));
        }
        if (action instanceof Action.RefreshToken) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass9(null)));
        }
        if (action instanceof Action.LegacyCacheError) {
            return new ReducerResult<>(State.copy$default(state, LoadingState.Error.INSTANCE, null, Integer.valueOf(R.string.boxsdk_error_network_connection), null, false, null, null, false, null, null, null, null, null, null, false, false, 65530, null), null, 2, null);
        }
        if (action instanceof Action.ItemAction) {
            Action.ItemAction itemAction = (Action.ItemAction) action;
            return reduceItem(state, itemAction.getId(), itemAction.getAction());
        }
        if (!(action instanceof Action.PulledToRefresh)) {
            return action instanceof Action.FilesConfig ? reduceFilesConfig(state, (Action.FilesConfig) action) : new ReducerResult<>(state, null, 2, null);
        }
        if (state.getRefreshState() != RefreshState.IN_PROGRESS) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, null, null, false, true, 32767, null), new Effect(Action.RefreshFromRemote.INSTANCE));
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, null, null, false, true, 32767, null), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$1", f = "ItemsListReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {192, 195, 197}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-ItemsListReducer$reduceItemsList$1$1", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-ItemsListReducer$reduceItemsList$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ItemsListReducer.this.new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0093  */
        /* JADX WARN: Code duplicated, block: B:26:0x0097  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c0  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
        
            if (r0.emit(r4, r8) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.itemsList.ItemsListReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$3, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$3", f = "ItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Action action, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemsListReducer.this.new AnonymousClass3(this.$action, continuation);
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
            ItemsListReducer.this.getEnvironment().getFeatureBannerUtils().setBannerDismissed(((Action.FeatureBannerDismissed) this.$action).getBanner());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$5, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$5", f = "ItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(State state, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemsListReducer.this.new AnonymousClass5(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ItemsListReducer.this.logTTIStart(ItemModelKt.toItemIdRemoteId(this.$state.getCurrentFolder()));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$6, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$6", f = "ItemsListReducer.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Action action, State state, Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemsListReducer.this.new AnonymousClass6(this.$action, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ItemsListReducer.this.createUpdatedItemsList(((Action.ItemsReceived) this.$action).getNewItems(), this.$state, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.UpdateItems((IdentifiedList) obj);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$7, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$7", f = "ItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ LoadingState $nextLoadingState;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ ItemsListReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(LoadingState loadingState, ItemsListReducer itemsListReducer, Action action, State state, Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
            this.$nextLoadingState = loadingState;
            this.this$0 = itemsListReducer;
            this.$action = action;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass7(this.$nextLoadingState, this.this$0, this.$action, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(this.$nextLoadingState, LoadingState.Loading.INSTANCE)) {
                this.this$0.logTTIEnd(((Action.UpdateItems) this.$action).getNewItems().size(), ItemModelKt.toItemIdRemoteId(this.$state.getCurrentFolder()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$8, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$8", f = "ItemsListReducer.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(State state, Continuation<? super AnonymousClass8> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemsListReducer.this.new AnonymousClass8(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass8) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ItemsListReducer.this.getEnvironment().getItemsViewUseCase().fetchItemsFromLegacyCache(ItemModelKt.toItemIdRemoteId(this.$state.getCurrentFolder()), this);
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
                error = new Result.Success(new Action.ItemsReceived((List) ((Result.Success) error).getValue()));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(Action.LegacyCacheError.INSTANCE);
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemsListReducer.Action");
            return (Action) obj2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$9, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$reduceItemsList$9", f = "ItemsListReducer.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemsListReducer.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ItemsListReducer.this.getEnvironment().getSessionManager().refreshSession(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ItemsListReducer itemsListReducer = ItemsListReducer.this;
            if (!((Boolean) obj).booleanValue()) {
                itemsListReducer.getEnvironment().getUserContextManager().destroyUser(itemsListReducer.getEnvironment().getUserContextManager().getCurrentContextId());
            }
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceLoadItemsFailed(State state, Action.LoadItemsFailed action) {
        if (state.getRefreshState() != RefreshState.COMPLETED) {
            DomainError error = action.getError();
            if (error instanceof DomainError.NoResultFoundError) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, null, CacheState.EMPTY, false, false, GeneratorBase.SURR2_LAST, null), null, 2, null);
            }
            if (error instanceof DomainError.Unauthorized) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, null, null, false, null, null, null, null, null, CacheState.EMPTY, false, false, GeneratorBase.SURR2_LAST, null), new Effect(Action.RefreshToken.INSTANCE));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        LoadingState.Error error2 = LoadingState.Error.INSTANCE;
        Integer error3 = state.getError();
        return new ReducerResult<>(State.copy$default(state, error2, null, Integer.valueOf(error3 != null ? error3.intValue() : R.string.LS_Unable_to_load_), null, false, null, null, false, null, null, null, null, null, null, false, false, 65530, null), null, 2, null);
    }

    private final boolean shouldShowFeatureBanner(BoxFeatureBanner featureBanner) {
        if (featureBanner != null) {
            return this.environment.getFeatureBannerUtils().shouldShowFeatureBanner(featureBanner);
        }
        return false;
    }

    private final LoadingState loadingStateAfterRefreshCompleted(State state) {
        return Intrinsics.areEqual(state.getItemLoadingState(), LoadingState.PartiallyLoaded.INSTANCE) ? LoadingState.FullyLoaded.INSTANCE : state.getItemLoadingState();
    }

    private final int getErrorResString(DomainError error) {
        if (DomainErrorKt.isNetworkConnectionError(error)) {
            return R.string.boxsdk_error_network_connection;
        }
        if (error instanceof DomainError.TermsOfServiceError) {
            return R.string.boxsdk_error_accept_terms_of_service;
        }
        if (error instanceof DomainError.ForbiddenByShieldPolicy) {
            return R.string.shield_blocked_state;
        }
        if (error instanceof DomainError.APIAuthError) {
            return R.string.permission_denied_general;
        }
        if (error instanceof DomainError.APINotFoundError) {
            return R.string.error_item_unavailable;
        }
        return R.string.LS_Unable_to_load_;
    }

    private final ReducerResult<State, Action> reduceItem(State state, ItemId.Remote itemId, ItemReducer.Action action) {
        ItemReducer.State state2 = (ItemReducer.State) state.getItems().getById(itemId);
        ItemModel itemModel = state2 != null ? state2.getItemModel() : null;
        if (action instanceof ItemReducer.Action.LongClicked) {
            return reduceItemLongClick(state, itemModel);
        }
        if (action instanceof ItemReducer.Action.Clicked) {
            return reduceItemClick(state, itemId, itemModel);
        }
        if (action instanceof ItemReducer.Action.CheckboxClicked) {
            return reduceItemCheckboxClick(state, itemModel);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceItemLongClick(State state, ItemModel itemModel) {
        if (state.getMultiselect() instanceof MultiselectReducer.State.Selecting) {
            if (((MultiselectReducer.State.Selecting) state.getMultiselect()).getSelectionInfo().getCanExit()) {
                return new ReducerResult<>(state, new Effect(new Action.Multiselect(MultiselectReducer.Action.ExitMultiSelectMode.INSTANCE)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (itemModel != null) {
            return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceItemClick(State state, ItemId.Remote itemId, ItemModel itemModel) {
        MultiselectReducer.State multiselect = state.getMultiselect();
        MultiselectReducer.State.Selecting selecting = multiselect instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) multiselect : null;
        MultiselectReducer.SelectionInfo selectionInfo = selecting != null ? selecting.getSelectionInfo() : null;
        if (selectionInfo != null) {
            if ((itemModel instanceof FolderModel) && selectionInfo.getAllowFolderNavigation()) {
                return new ReducerResult<>(state, new Effect(new Action.OpenItem(itemId)));
            }
            return handleMultiSelectItemToggling(itemModel, state);
        }
        return new ReducerResult<>(state, new Effect(new Action.OpenItem(itemId)));
    }

    private final ReducerResult<State, Action> reduceItemCheckboxClick(State state, ItemModel itemModel) {
        return handleMultiSelectItemToggling(itemModel, state);
    }

    private final ReducerResult<State, Action> handleMultiSelectItemToggling(ItemModel itemModel, State state) {
        if (itemModel != null) {
            return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTTIStart(ItemId.Remote folderId) {
        this.environment.getGen204PerformanceLogger().registerStart(PerformanceType.BROWSE_TTI_V2, folderId.getBoxId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTTIEnd(final int size, final ItemId.Remote folderId) {
        this.environment.getGen204PerformanceLogger().registerEnd(PerformanceType.BROWSE_TTI_V2, folderId.getBoxId(), new Function1() { // from class: com.box.android.browse.cpl.itemsList.ItemsListReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemsListReducer.logTTIEnd$lambda$0(folderId, size, ((Long) obj).longValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gen204Event logTTIEnd$lambda$0(ItemId.Remote remote, int i, long j) {
        return new BrowsePerformanceEvent(new BrowsePerformanceEvent.Type.FolderTTIV2(remote.getBoxId()), j, i, null, null, null, 56, null);
    }

    private final LoadingState loadingStateAfterItemsUpdated(State state) {
        LoadingState itemLoadingState = state.getItemLoadingState();
        if (!Intrinsics.areEqual(itemLoadingState, LoadingState.Loading.INSTANCE) && !Intrinsics.areEqual(itemLoadingState, LoadingState.PartiallyLoaded.INSTANCE)) {
            return itemLoadingState;
        }
        if (state.getRefreshState() == RefreshState.COMPLETED) {
            return LoadingState.FullyLoaded.INSTANCE;
        }
        return LoadingState.PartiallyLoaded.INSTANCE;
    }

    private final LoadingState loadingStateAfterFetchFromRemoteFailed(State state, DomainError error) {
        if (error instanceof DomainError.APINotFoundError) {
            return LoadingState.Error.INSTANCE;
        }
        if (error instanceof DomainError.ForbiddenByShieldPolicy) {
            return LoadingState.ForbiddenByPolicy.INSTANCE;
        }
        LoadingState itemLoadingState = state.getItemLoadingState();
        if (!Intrinsics.areEqual(itemLoadingState, LoadingState.Loading.INSTANCE)) {
            return Intrinsics.areEqual(itemLoadingState, LoadingState.Error.INSTANCE) ? LoadingState.Error.INSTANCE : LoadingState.FullyLoaded.INSTANCE;
        }
        if (DomainErrorKt.isNetworkConnectionError(error) && (state.getCacheState() != CacheState.EMPTY || state.getAllowLegacyCache())) {
            return state.getItemLoadingState();
        }
        return LoadingState.Error.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListReducer$createUpdatedItemsList$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListReducer$createUpdatedItemsList$2", f = "ItemsListReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {596}, m = "invokeSuspend", n = {"filteredItems", "updatedItems", "$this$mapTo$iv", "destination$iv", "item$iv", "item", "$i$f$mapTo", "$i$a$-mapTo-ItemsListReducer$createUpdatedItemsList$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$7", "L$8", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifiedList<ItemId.Remote, ItemReducer.State>>, Object> {
        final /* synthetic */ List<ItemModel> $items;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ ItemsListReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(State state, List<? extends ItemModel> list, ItemsListReducer itemsListReducer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$items = list;
            this.this$0 = itemsListReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$state, this.$items, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IdentifiedList<ItemId.Remote, ItemReducer.State>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:23:0x00e4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x00e5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e5 -> B:25:0x00e6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.itemsList.ItemsListReducer.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createUpdatedItemsList(List<? extends ItemModel> list, State state, Continuation<? super IdentifiedList<ItemId.Remote, ItemReducer.State>> continuation) {
        return BuildersKt.withContext(this.environment.getDispatcher(), new AnonymousClass2(state, list, this, null), continuation);
    }

    private final ReducerResult<State, Action> reduceFilesConfig(State state, Action.FilesConfig action) {
        FilesDisplayConfigReducer.Action action2 = action.getAction();
        if ((action2 instanceof FilesDisplayConfigReducer.Action.SortByChanged) || (action2 instanceof FilesDisplayConfigReducer.Action.FilterSelected) || (action2 instanceof FilesDisplayConfigReducer.Action.SortDirectionToggled)) {
            return new ReducerResult<>(state, new Effect(Action.LoadItems.INSTANCE));
        }
        if (action2 instanceof FilesDisplayConfigReducer.Action.Initialize) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action2 instanceof FilesDisplayConfigReducer.Action.SortingClicked) && !(action2 instanceof FilesDisplayConfigReducer.Action.FilteringClicked)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Companion;", "", "<init>", "()V", "refreshItemsEffectId", "", "cancelKey", "fetchItemsEffectId", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String refreshItemsEffectId(String cancelKey) {
            Intrinsics.checkNotNullParameter(cancelKey, "cancelKey");
            String str = String.format("REFRESH_ITEMS_EFFECT_ID:%s", Arrays.copyOf(new Object[]{cancelKey}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String fetchItemsEffectId(String cancelKey) {
            Intrinsics.checkNotNullParameter(cancelKey, "cancelKey");
            String str = String.format("FETCH_ITEMS_EFFECT_ID:%s", Arrays.copyOf(new Object[]{cancelKey}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
