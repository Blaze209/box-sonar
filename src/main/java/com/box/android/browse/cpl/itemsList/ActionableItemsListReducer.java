package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import com.box.android.base.presentation.components.fileactions.FileActionsError;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.boxai.BoxAiReducer;
import com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer;
import com.box.android.boxai.multidoc.BoxAiMultidocStatus;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuAction;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuActionsVisibility;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003+,-B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006."}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "environment", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceActionableItemsList", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "batchExport", "batchRemoveOffline", "batchSaveOffline", "logAdminSettingsErrorEffect", "Lcom/box/android/cpl/Effect;", "adminError", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "openBoxAiForSelectedFiles", "openBoxAiForItem", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "reduceDownload", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "reduceItemsList", "itemViewAction", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "reduceMultiselect", "multiselectAction", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "reduceOfflineFiles", "offlineAction", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "reduceBoxAiMultidocAvailability", "boxAiAvailabilityAction", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "reduceBoxAi", "boxAiAction", "Lcom/box/android/boxai/BoxAiReducer$Action;", "Route", "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final ActionableItemsListEnvironment environment;

    public ActionableItemsListReducer(ActionableItemsListEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new ActionableItemsListReducer$build$1(this));
        final ActionableItemsListReducer$build$2 actionableItemsListReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
            }
        };
        final ActionableItemsListReducer$build$3 actionableItemsListReducer$build$3 = ActionableItemsListReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new ItemsListReducer(environment.getItemListViewEnvironment()), new Function1<State, ItemsListReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.ItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ItemsListReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.ItemsListAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.ItemsListAction itemsListAction = (ActionableItemsListReducer.Action.ItemsListAction) action;
                if (itemsListAction != null) {
                    return itemsListAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemsListReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, ItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(ItemsListReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
        final ActionableItemsListReducer$build$5 actionableItemsListReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getOfflineFilesState();
            }
        };
        final ActionableItemsListReducer$build$6 actionableItemsListReducer$build$6 = ActionableItemsListReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new OfflineFilesReducer(environment.getOfflineFilesEnvironment()), new Function1<State, OfflineFilesReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.fileactions.OfflineFilesReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final OfflineFilesReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$5.invoke(it);
            }
        }, new Function1<Action, OfflineFilesReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final OfflineFilesReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.OfflineFilesAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.OfflineFilesAction offlineFilesAction = (ActionableItemsListReducer.Action.OfflineFilesAction) action;
                if (offlineFilesAction != null) {
                    return offlineFilesAction.getAction();
                }
                return null;
            }
        }, new Function2<State, OfflineFilesReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, OfflineFilesReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<OfflineFilesReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(OfflineFilesReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
        final ActionableItemsListReducer$build$8 actionableItemsListReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getDownloadState();
            }
        };
        final ActionableItemsListReducer$build$9 actionableItemsListReducer$build$9 = ActionableItemsListReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new DownloadFilesReducer(environment.getDownloadEnvironment()), new Function1<State, DownloadFilesReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.fileactions.DownloadFilesReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final DownloadFilesReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$8.invoke(it);
            }
        }, new Function1<Action, DownloadFilesReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final DownloadFilesReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.DownloadAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.DownloadAction downloadAction = (ActionableItemsListReducer.Action.DownloadAction) action;
                if (downloadAction != null) {
                    return downloadAction.getAction();
                }
                return null;
            }
        }, new Function2<State, DownloadFilesReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, DownloadFilesReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<DownloadFilesReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(DownloadFilesReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
        final ActionableItemsListReducer$build$11 actionableItemsListReducer$build$11 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getBoxAiMultidocAvailabilityState();
            }
        };
        final ActionableItemsListReducer$build$12 actionableItemsListReducer$build$12 = ActionableItemsListReducer$build$12.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, new BoxAiMultidocAvailabilityReducer(environment.getBoxAiEnvironment()), new Function1<State, BoxAiMultidocAvailabilityReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$13
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiMultidocAvailabilityReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$11.invoke(it);
            }
        }, new Function1<Action, BoxAiMultidocAvailabilityReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$14
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiMultidocAvailabilityReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction boxAiMultidocAvailabilityAction = (ActionableItemsListReducer.Action.BoxAiMultidocAvailabilityAction) action;
                if (boxAiMultidocAvailabilityAction != null) {
                    return boxAiMultidocAvailabilityAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiMultidocAvailabilityReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$15
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, BoxAiMultidocAvailabilityReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$11;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiMultidocAvailabilityReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(BoxAiMultidocAvailabilityReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$12.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
        final ActionableItemsListReducer$build$14 actionableItemsListReducer$build$14 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$14
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
            }
        };
        final ActionableItemsListReducer$build$15 actionableItemsListReducer$build$15 = ActionableItemsListReducer$build$15.INSTANCE;
        IfLetReducer ifLetReducer5 = new IfLetReducer(ifLetReducer4, new BoxAiReducer(environment.getBoxAiEnvironment()), new Function1<State, BoxAiReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$17
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.BoxAiReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$14.invoke(it);
            }
        }, new Function1<Action, BoxAiReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$18
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.BoxAiAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.BoxAiAction boxAiAction = (ActionableItemsListReducer.Action.BoxAiAction) action;
                if (boxAiAction != null) {
                    return boxAiAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$19
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, BoxAiReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$14;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(BoxAiReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$15.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
        final ActionableItemsListReducer$build$17 actionableItemsListReducer$build$17 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$build$17
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
            }
        };
        final ActionableItemsListReducer$build$18 actionableItemsListReducer$build$18 = ActionableItemsListReducer$build$18.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer5, new BoxAiCenterReducer(), new Function1<State, BoxAiCenterReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$21
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.boxai.BoxAiCenterReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCenterReducer.State invoke(ActionableItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return actionableItemsListReducer$build$17.invoke(it);
            }
        }, new Function1<Action, BoxAiCenterReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$22
            @Override // kotlin.jvm.functions.Function1
            public final BoxAiCenterReducer.Action invoke(ActionableItemsListReducer.Action action) {
                if (!(action instanceof ActionableItemsListReducer.Action.BoxAiCenterAction)) {
                    action = null;
                }
                ActionableItemsListReducer.Action.BoxAiCenterAction boxAiCenterAction = (ActionableItemsListReducer.Action.BoxAiCenterAction) action;
                if (boxAiCenterAction != null) {
                    return boxAiCenterAction.getAction();
                }
                return null;
            }
        }, new Function2<State, BoxAiCenterReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$23
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ActionableItemsListReducer.State invoke(ActionableItemsListReducer.State parentState, BoxAiCenterReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = actionableItemsListReducer$build$17;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ActionableItemsListReducer.State.class)).iterator();
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
                            return (ActionableItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BoxAiCenterReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$special$$inlined$scope$24
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(BoxAiCenterReducer.Action action) {
                Object objInvoke = actionableItemsListReducer$build$18.invoke(action);
                if (objInvoke != null) {
                    return (ActionableItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "", "<init>", "()V", "Batch", "MoreActions", "UpdateApp", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$MoreActions;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$UpdateApp;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Route() {
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0017\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "files", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "BatchCopyMove", "BatchDelete", "BatchExport", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchCopyMove;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchDelete;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchExport;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static abstract class Batch extends Route {
            public static final int $stable = 8;
            private final List<ItemModel> files;

            public /* synthetic */ Batch(List list, DefaultConstructorMarker defaultConstructorMarker) {
                this(list);
            }

            /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchCopyMove;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch;", "files", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class BatchCopyMove extends Batch {
                public static final int $stable = 8;
                private final List<ItemModel> files;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BatchCopyMove copy$default(BatchCopyMove batchCopyMove, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = batchCopyMove.files;
                    }
                    return batchCopyMove.copy(list);
                }

                public final List<ItemModel> component1() {
                    return this.files;
                }

                public final BatchCopyMove copy(List<? extends ItemModel> files) {
                    Intrinsics.checkNotNullParameter(files, "files");
                    return new BatchCopyMove(files);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof BatchCopyMove) && Intrinsics.areEqual(this.files, ((BatchCopyMove) other).files);
                }

                public int hashCode() {
                    return this.files.hashCode();
                }

                public String toString() {
                    return "BatchCopyMove(files=" + this.files + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public BatchCopyMove(List<? extends ItemModel> files) {
                    super(files, null);
                    Intrinsics.checkNotNullParameter(files, "files");
                    this.files = files;
                }

                @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Route.Batch
                public List<ItemModel> getFiles() {
                    return this.files;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            private Batch(List<? extends ItemModel> list) {
                super(null);
                this.files = list;
            }

            public List<ItemModel> getFiles() {
                return this.files;
            }

            /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchDelete;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch;", "files", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class BatchDelete extends Batch {
                public static final int $stable = 8;
                private final List<ItemModel> files;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BatchDelete copy$default(BatchDelete batchDelete, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = batchDelete.files;
                    }
                    return batchDelete.copy(list);
                }

                public final List<ItemModel> component1() {
                    return this.files;
                }

                public final BatchDelete copy(List<? extends ItemModel> files) {
                    Intrinsics.checkNotNullParameter(files, "files");
                    return new BatchDelete(files);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof BatchDelete) && Intrinsics.areEqual(this.files, ((BatchDelete) other).files);
                }

                public int hashCode() {
                    return this.files.hashCode();
                }

                public String toString() {
                    return "BatchDelete(files=" + this.files + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public BatchDelete(List<? extends ItemModel> files) {
                    super(files, null);
                    Intrinsics.checkNotNullParameter(files, "files");
                    this.files = files;
                }

                @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Route.Batch
                public List<ItemModel> getFiles() {
                    return this.files;
                }
            }

            /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch$BatchExport;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$Batch;", "files", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class BatchExport extends Batch {
                public static final int $stable = 8;
                private final List<ItemModel> files;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BatchExport copy$default(BatchExport batchExport, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = batchExport.files;
                    }
                    return batchExport.copy(list);
                }

                public final List<ItemModel> component1() {
                    return this.files;
                }

                public final BatchExport copy(List<? extends ItemModel> files) {
                    Intrinsics.checkNotNullParameter(files, "files");
                    return new BatchExport(files);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof BatchExport) && Intrinsics.areEqual(this.files, ((BatchExport) other).files);
                }

                public int hashCode() {
                    return this.files.hashCode();
                }

                public String toString() {
                    return "BatchExport(files=" + this.files + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public BatchExport(List<? extends ItemModel> files) {
                    super(files, null);
                    Intrinsics.checkNotNullParameter(files, "files");
                    this.files = files;
                }

                @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListReducer.Route.Batch
                public List<ItemModel> getFiles() {
                    return this.files;
                }
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$MoreActions;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "availableActions", "", "Lcom/box/android/browse/cpl/itemsList/BottomSheetItemAction;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/util/List;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "getAvailableActions", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MoreActions extends Route {
            public static final int $stable = 8;
            private final List<BottomSheetItemAction> availableActions;
            private final ItemModel item;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MoreActions copy$default(MoreActions moreActions, ItemModel itemModel, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = moreActions.item;
                }
                if ((i & 2) != 0) {
                    list = moreActions.availableActions;
                }
                return moreActions.copy(itemModel, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final List<BottomSheetItemAction> component2() {
                return this.availableActions;
            }

            public final MoreActions copy(ItemModel item, List<? extends BottomSheetItemAction> availableActions) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                return new MoreActions(item, availableActions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoreActions)) {
                    return false;
                }
                MoreActions moreActions = (MoreActions) other;
                return Intrinsics.areEqual(this.item, moreActions.item) && Intrinsics.areEqual(this.availableActions, moreActions.availableActions);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.availableActions.hashCode();
            }

            public String toString() {
                return "MoreActions(item=" + this.item + ", availableActions=" + this.availableActions + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public MoreActions(ItemModel item, List<? extends BottomSheetItemAction> availableActions) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                this.item = item;
                this.availableActions = availableActions;
            }

            public /* synthetic */ MoreActions(ItemModel itemModel, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(itemModel, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final List<BottomSheetItemAction> getAvailableActions() {
                return this.availableActions;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$UpdateApp;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateApp extends Route {
            public static final int $stable = 0;
            public static final UpdateApp INSTANCE = new UpdateApp();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateApp)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1362717449;
            }

            public String toString() {
                return "UpdateApp";
            }

            private UpdateApp() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001LBk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010B\u001a\u00020\u0010HÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003J\t\u0010D\u001a\u00020\u0014HÆ\u0003Jo\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010F\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020KHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b-\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006M"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "", "itemsListViewState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "menuActionsVisibility", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;", "permissionRequest", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State$PermissionRequest;", "bottomSheetAvailableActions", "", "Lcom/box/android/browse/cpl/itemsList/BottomSheetItemAction;", "offlineFilesState", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "downloadState", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "boxAiMultidocAvailabilityState", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "boxAiState", "Lcom/box/android/boxai/BoxAiReducer$State;", "boxAiCenterState", "Lcom/box/android/boxai/BoxAiCenterReducer$State;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State$PermissionRequest;Ljava/util/List;Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;Lcom/box/android/boxai/BoxAiReducer$State;Lcom/box/android/boxai/BoxAiCenterReducer$State;)V", "getItemsListViewState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "getMenuActionsVisibility", "()Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;", "getPermissionRequest", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State$PermissionRequest;", "getBottomSheetAvailableActions", "()Ljava/util/List;", "getOfflineFilesState", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "getDownloadState", "()Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "getBoxAiMultidocAvailabilityState", "()Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "getBoxAiState", "()Lcom/box/android/boxai/BoxAiReducer$State;", "getBoxAiCenterState", "()Lcom/box/android/boxai/BoxAiCenterReducer$State;", "currentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getCurrentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "isSelecting", "", "()Z", "multiselect", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "getMultiselect", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "error", "Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "getError", "()Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "boxAiMultidocStatus", "Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;", "getBoxAiMultidocStatus", "()Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "PermissionRequest", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<BottomSheetItemAction> bottomSheetAvailableActions;
        private final BoxAiCenterReducer.State boxAiCenterState;
        private final BoxAiMultidocAvailabilityReducer.State boxAiMultidocAvailabilityState;
        private final BoxAiReducer.State boxAiState;
        private final FolderModel currentFolder;
        private final DownloadFilesReducer.State downloadState;
        private final FileActionsError error;
        private final boolean isSelecting;
        private final ItemsListReducer.State itemsListViewState;
        private final MultiselectMenuActionsVisibility menuActionsVisibility;
        private final MultiselectReducer.State multiselect;
        private final OfflineFilesReducer.State offlineFilesState;
        private final PermissionRequest permissionRequest;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemsListReducer.State state2, MultiselectMenuActionsVisibility multiselectMenuActionsVisibility, PermissionRequest permissionRequest, List list, OfflineFilesReducer.State state3, DownloadFilesReducer.State state4, BoxAiMultidocAvailabilityReducer.State state5, BoxAiReducer.State state6, BoxAiCenterReducer.State state7, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.itemsListViewState;
            }
            if ((i & 2) != 0) {
                multiselectMenuActionsVisibility = state.menuActionsVisibility;
            }
            if ((i & 4) != 0) {
                permissionRequest = state.permissionRequest;
            }
            if ((i & 8) != 0) {
                list = state.bottomSheetAvailableActions;
            }
            if ((i & 16) != 0) {
                state3 = state.offlineFilesState;
            }
            if ((i & 32) != 0) {
                state4 = state.downloadState;
            }
            if ((i & 64) != 0) {
                state5 = state.boxAiMultidocAvailabilityState;
            }
            if ((i & 128) != 0) {
                state6 = state.boxAiState;
            }
            if ((i & 256) != 0) {
                state7 = state.boxAiCenterState;
            }
            BoxAiReducer.State state8 = state6;
            BoxAiCenterReducer.State state9 = state7;
            DownloadFilesReducer.State state10 = state4;
            BoxAiMultidocAvailabilityReducer.State state11 = state5;
            OfflineFilesReducer.State state12 = state3;
            PermissionRequest permissionRequest2 = permissionRequest;
            return state.copy(state2, multiselectMenuActionsVisibility, permissionRequest2, list, state12, state10, state11, state8, state9);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MultiselectMenuActionsVisibility getMenuActionsVisibility() {
            return this.menuActionsVisibility;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PermissionRequest getPermissionRequest() {
            return this.permissionRequest;
        }

        public final List<BottomSheetItemAction> component4() {
            return this.bottomSheetAvailableActions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final OfflineFilesReducer.State getOfflineFilesState() {
            return this.offlineFilesState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final DownloadFilesReducer.State getDownloadState() {
            return this.downloadState;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BoxAiMultidocAvailabilityReducer.State getBoxAiMultidocAvailabilityState() {
            return this.boxAiMultidocAvailabilityState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final BoxAiReducer.State getBoxAiState() {
            return this.boxAiState;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final BoxAiCenterReducer.State getBoxAiCenterState() {
            return this.boxAiCenterState;
        }

        public final State copy(ItemsListReducer.State itemsListViewState, MultiselectMenuActionsVisibility menuActionsVisibility, PermissionRequest permissionRequest, List<? extends BottomSheetItemAction> bottomSheetAvailableActions, OfflineFilesReducer.State offlineFilesState, DownloadFilesReducer.State downloadState, BoxAiMultidocAvailabilityReducer.State boxAiMultidocAvailabilityState, BoxAiReducer.State boxAiState, BoxAiCenterReducer.State boxAiCenterState) {
            Intrinsics.checkNotNullParameter(itemsListViewState, "itemsListViewState");
            Intrinsics.checkNotNullParameter(menuActionsVisibility, "menuActionsVisibility");
            Intrinsics.checkNotNullParameter(bottomSheetAvailableActions, "bottomSheetAvailableActions");
            Intrinsics.checkNotNullParameter(boxAiMultidocAvailabilityState, "boxAiMultidocAvailabilityState");
            Intrinsics.checkNotNullParameter(boxAiState, "boxAiState");
            Intrinsics.checkNotNullParameter(boxAiCenterState, "boxAiCenterState");
            return new State(itemsListViewState, menuActionsVisibility, permissionRequest, bottomSheetAvailableActions, offlineFilesState, downloadState, boxAiMultidocAvailabilityState, boxAiState, boxAiCenterState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemsListViewState, state.itemsListViewState) && Intrinsics.areEqual(this.menuActionsVisibility, state.menuActionsVisibility) && Intrinsics.areEqual(this.permissionRequest, state.permissionRequest) && Intrinsics.areEqual(this.bottomSheetAvailableActions, state.bottomSheetAvailableActions) && Intrinsics.areEqual(this.offlineFilesState, state.offlineFilesState) && Intrinsics.areEqual(this.downloadState, state.downloadState) && Intrinsics.areEqual(this.boxAiMultidocAvailabilityState, state.boxAiMultidocAvailabilityState) && Intrinsics.areEqual(this.boxAiState, state.boxAiState) && Intrinsics.areEqual(this.boxAiCenterState, state.boxAiCenterState);
        }

        public int hashCode() {
            int iHashCode = ((this.itemsListViewState.hashCode() * 31) + this.menuActionsVisibility.hashCode()) * 31;
            PermissionRequest permissionRequest = this.permissionRequest;
            int iHashCode2 = (((iHashCode + (permissionRequest == null ? 0 : permissionRequest.hashCode())) * 31) + this.bottomSheetAvailableActions.hashCode()) * 31;
            OfflineFilesReducer.State state = this.offlineFilesState;
            int iHashCode3 = (iHashCode2 + (state == null ? 0 : state.hashCode())) * 31;
            DownloadFilesReducer.State state2 = this.downloadState;
            return ((((((iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31) + this.boxAiMultidocAvailabilityState.hashCode()) * 31) + this.boxAiState.hashCode()) * 31) + this.boxAiCenterState.hashCode();
        }

        public String toString() {
            return "State(itemsListViewState=" + this.itemsListViewState + ", menuActionsVisibility=" + this.menuActionsVisibility + ", permissionRequest=" + this.permissionRequest + ", bottomSheetAvailableActions=" + this.bottomSheetAvailableActions + ", offlineFilesState=" + this.offlineFilesState + ", downloadState=" + this.downloadState + ", boxAiMultidocAvailabilityState=" + this.boxAiMultidocAvailabilityState + ", boxAiState=" + this.boxAiState + ", boxAiCenterState=" + this.boxAiCenterState + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(ItemsListReducer.State itemsListViewState, MultiselectMenuActionsVisibility menuActionsVisibility, PermissionRequest permissionRequest, List<? extends BottomSheetItemAction> bottomSheetAvailableActions, OfflineFilesReducer.State state, DownloadFilesReducer.State state2, BoxAiMultidocAvailabilityReducer.State boxAiMultidocAvailabilityState, BoxAiReducer.State boxAiState, BoxAiCenterReducer.State boxAiCenterState) {
            FileActionsError error;
            Intrinsics.checkNotNullParameter(itemsListViewState, "itemsListViewState");
            Intrinsics.checkNotNullParameter(menuActionsVisibility, "menuActionsVisibility");
            Intrinsics.checkNotNullParameter(bottomSheetAvailableActions, "bottomSheetAvailableActions");
            Intrinsics.checkNotNullParameter(boxAiMultidocAvailabilityState, "boxAiMultidocAvailabilityState");
            Intrinsics.checkNotNullParameter(boxAiState, "boxAiState");
            Intrinsics.checkNotNullParameter(boxAiCenterState, "boxAiCenterState");
            this.itemsListViewState = itemsListViewState;
            this.menuActionsVisibility = menuActionsVisibility;
            this.permissionRequest = permissionRequest;
            this.bottomSheetAvailableActions = bottomSheetAvailableActions;
            this.offlineFilesState = state;
            this.downloadState = state2;
            this.boxAiMultidocAvailabilityState = boxAiMultidocAvailabilityState;
            this.boxAiState = boxAiState;
            this.boxAiCenterState = boxAiCenterState;
            this.currentFolder = itemsListViewState.getCurrentFolder();
            this.isSelecting = itemsListViewState.isSelecting();
            this.multiselect = itemsListViewState.getMultiselect();
            this.error = (state == null || (error = state.getError()) == null) ? state2 != null ? state2.getError() : null : error;
        }

        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        public final MultiselectMenuActionsVisibility getMenuActionsVisibility() {
            return this.menuActionsVisibility;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(ItemsListReducer.State state, MultiselectMenuActionsVisibility multiselectMenuActionsVisibility, PermissionRequest permissionRequest, List list, OfflineFilesReducer.State state2, DownloadFilesReducer.State state3, BoxAiMultidocAvailabilityReducer.State state4, BoxAiReducer.State state5, BoxAiCenterReducer.State state6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            MultiselectMenuActionsVisibility multiselectMenuActionsVisibility2;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if ((i & 2) != 0) {
                multiselectMenuActionsVisibility2 = new MultiselectMenuActionsVisibility(objArr2 == true ? 1 : 0, 1, objArr == true ? 1 : 0);
            } else {
                multiselectMenuActionsVisibility2 = multiselectMenuActionsVisibility;
            }
            this(state, multiselectMenuActionsVisibility2, (i & 4) != 0 ? null : permissionRequest, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : state2, (i & 32) == 0 ? state3 : null, (i & 64) != 0 ? new BoxAiMultidocAvailabilityReducer.State(null, null, null, false, false, 31, null) : state4, (i & 128) != 0 ? new BoxAiReducer.State(null, null, true, null, false, false, false, null, 251, null) : state5, (i & 256) != 0 ? new BoxAiCenterReducer.State(null, true, false, null, 13, null) : state6);
        }

        public final PermissionRequest getPermissionRequest() {
            return this.permissionRequest;
        }

        public final List<BottomSheetItemAction> getBottomSheetAvailableActions() {
            return this.bottomSheetAvailableActions;
        }

        public final OfflineFilesReducer.State getOfflineFilesState() {
            return this.offlineFilesState;
        }

        public final DownloadFilesReducer.State getDownloadState() {
            return this.downloadState;
        }

        public final BoxAiMultidocAvailabilityReducer.State getBoxAiMultidocAvailabilityState() {
            return this.boxAiMultidocAvailabilityState;
        }

        public final BoxAiReducer.State getBoxAiState() {
            return this.boxAiState;
        }

        public final BoxAiCenterReducer.State getBoxAiCenterState() {
            return this.boxAiCenterState;
        }

        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        /* JADX INFO: renamed from: isSelecting, reason: from getter */
        public final boolean getIsSelecting() {
            return this.isSelecting;
        }

        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final FileActionsError getError() {
            return this.error;
        }

        public final BoxAiMultidocStatus getBoxAiMultidocStatus() {
            BoxAiMultidocStatus availabilityStatus = this.boxAiMultidocAvailabilityState.getAvailabilityStatus();
            return (availabilityStatus == BoxAiMultidocStatus.AVAILABLE && (this.boxAiCenterState.isSessionActive() || this.boxAiState.hasPrompts())) ? BoxAiMultidocStatus.ACTIVE : availabilityStatus;
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State$PermissionRequest;", "", "permission", "", "actionOnPermissionGranted", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "(Ljava/lang/String;Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", "getPermission", "()Ljava/lang/String;", "getActionOnPermissionGranted", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionRequest {
            public static final int $stable = 0;
            private final Action actionOnPermissionGranted;
            private final String permission;

            public static /* synthetic */ PermissionRequest copy$default(PermissionRequest permissionRequest, String str, Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = permissionRequest.permission;
                }
                if ((i & 2) != 0) {
                    action = permissionRequest.actionOnPermissionGranted;
                }
                return permissionRequest.copy(str, action);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPermission() {
                return this.permission;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Action getActionOnPermissionGranted() {
                return this.actionOnPermissionGranted;
            }

            public final PermissionRequest copy(String permission, Action actionOnPermissionGranted) {
                Intrinsics.checkNotNullParameter(permission, "permission");
                return new PermissionRequest(permission, actionOnPermissionGranted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionRequest)) {
                    return false;
                }
                PermissionRequest permissionRequest = (PermissionRequest) other;
                return Intrinsics.areEqual(this.permission, permissionRequest.permission) && Intrinsics.areEqual(this.actionOnPermissionGranted, permissionRequest.actionOnPermissionGranted);
            }

            public int hashCode() {
                int iHashCode = this.permission.hashCode() * 31;
                Action action = this.actionOnPermissionGranted;
                return iHashCode + (action == null ? 0 : action.hashCode());
            }

            public String toString() {
                return "PermissionRequest(permission=" + this.permission + ", actionOnPermissionGranted=" + this.actionOnPermissionGranted + ")";
            }

            public PermissionRequest(String permission, Action action) {
                Intrinsics.checkNotNullParameter(permission, "permission");
                this.permission = permission;
                this.actionOnPermissionGranted = action;
            }

            public /* synthetic */ PermissionRequest(String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : action);
            }

            public final Action getActionOnPermissionGranted() {
                return this.actionOnPermissionGranted;
            }

            public final String getPermission() {
                return this.permission;
            }
        }
    }

    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00192\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0015\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-.¨\u0006/"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "", "<init>", "()V", "ItemsListAction", "ShowMoreActionsMenu", "BatchSelect", "BatchCopyMove", "BatchDelete", "BatchExport", "BatchSaveOffline", "BatchRemoveOffline", "StartMultiSelectMode", "ExitMultiselectMode", "OpenBoxAiForSelectedFiles", "OpenBoxAiForItem", "PermissionResultReceived", "NavigateTo", "NavigationCompleted", "UpdateMenuActionsVisibility", "OfflineFilesAction", "DownloadAction", "BoxAiMultidocAvailabilityAction", "BoxAiAction", "BoxAiCenterAction", "Companion", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchCopyMove;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchDelete;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchExport;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchRemoveOffline;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchSaveOffline;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchSelect;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiCenterAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiMultidocAvailabilityAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$DownloadAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ExitMultiselectMode;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$NavigateTo;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OfflineFilesAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OpenBoxAiForItem;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OpenBoxAiForSelectedFiles;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$PermissionResultReceived;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ShowMoreActionsMenu;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$StartMultiSelectMode;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$UpdateMenuActionsVisibility;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "itemsListViewAction", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", "getItemsListViewAction", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsListAction extends Action implements Embedded<ItemsListReducer.Action> {
            public static final int $stable = 0;
            private final ItemsListReducer.Action itemsListViewAction;

            public static /* synthetic */ ItemsListAction copy$default(ItemsListAction itemsListAction, ItemsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = itemsListAction.itemsListViewAction;
                }
                return itemsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemsListReducer.Action getAction() {
                return this.itemsListViewAction;
            }

            public final ItemsListAction copy(ItemsListReducer.Action itemsListViewAction) {
                Intrinsics.checkNotNullParameter(itemsListViewAction, "itemsListViewAction");
                return new ItemsListAction(itemsListViewAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsListAction) && Intrinsics.areEqual(this.itemsListViewAction, ((ItemsListAction) other).itemsListViewAction);
            }

            public int hashCode() {
                return this.itemsListViewAction.hashCode();
            }

            public String toString() {
                return "ItemsListAction(itemsListViewAction=" + this.itemsListViewAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemsListAction(ItemsListReducer.Action itemsListViewAction) {
                super(null);
                Intrinsics.checkNotNullParameter(itemsListViewAction, "itemsListViewAction");
                this.itemsListViewAction = itemsListViewAction;
            }

            public final ItemsListReducer.Action getItemsListViewAction() {
                return this.itemsListViewAction;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ShowMoreActionsMenu;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowMoreActionsMenu extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ ShowMoreActionsMenu copy$default(ShowMoreActionsMenu showMoreActionsMenu, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = showMoreActionsMenu.itemModel;
                }
                return showMoreActionsMenu.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final ShowMoreActionsMenu copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new ShowMoreActionsMenu(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowMoreActionsMenu) && Intrinsics.areEqual(this.itemModel, ((ShowMoreActionsMenu) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "ShowMoreActionsMenu(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowMoreActionsMenu(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchSelect;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchSelect extends Action {
            public static final int $stable = 0;
            public static final BatchSelect INSTANCE = new BatchSelect();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchSelect)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -991881062;
            }

            public String toString() {
                return "BatchSelect";
            }

            private BatchSelect() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchCopyMove;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchCopyMove extends Action {
            public static final int $stable = 0;
            public static final BatchCopyMove INSTANCE = new BatchCopyMove();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchCopyMove)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1412689660;
            }

            public String toString() {
                return "BatchCopyMove";
            }

            private BatchCopyMove() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchDelete;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchDelete extends Action {
            public static final int $stable = 0;
            public static final BatchDelete INSTANCE = new BatchDelete();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchDelete)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1421317815;
            }

            public String toString() {
                return "BatchDelete";
            }

            private BatchDelete() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchExport;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchExport extends Action {
            public static final int $stable = 0;
            public static final BatchExport INSTANCE = new BatchExport();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchExport)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1375013038;
            }

            public String toString() {
                return "BatchExport";
            }

            private BatchExport() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchSaveOffline;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchSaveOffline extends Action {
            public static final int $stable = 0;
            public static final BatchSaveOffline INSTANCE = new BatchSaveOffline();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchSaveOffline)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -531735352;
            }

            public String toString() {
                return "BatchSaveOffline";
            }

            private BatchSaveOffline() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BatchRemoveOffline;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchRemoveOffline extends Action {
            public static final int $stable = 0;
            public static final BatchRemoveOffline INSTANCE = new BatchRemoveOffline();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BatchRemoveOffline)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -390709407;
            }

            public String toString() {
                return "BatchRemoveOffline";
            }

            private BatchRemoveOffline() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$StartMultiSelectMode;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartMultiSelectMode extends Action {
            public static final int $stable = 0;
            public static final StartMultiSelectMode INSTANCE = new StartMultiSelectMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartMultiSelectMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1330401582;
            }

            public String toString() {
                return "StartMultiSelectMode";
            }

            private StartMultiSelectMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ExitMultiselectMode;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitMultiselectMode extends Action {
            public static final int $stable = 0;
            public static final ExitMultiselectMode INSTANCE = new ExitMultiselectMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitMultiselectMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 383202686;
            }

            public String toString() {
                return "ExitMultiselectMode";
            }

            private ExitMultiselectMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OpenBoxAiForSelectedFiles;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenBoxAiForSelectedFiles extends Action {
            public static final int $stable = 0;
            public static final OpenBoxAiForSelectedFiles INSTANCE = new OpenBoxAiForSelectedFiles();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenBoxAiForSelectedFiles)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1950488672;
            }

            public String toString() {
                return "OpenBoxAiForSelectedFiles";
            }

            private OpenBoxAiForSelectedFiles() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OpenBoxAiForItem;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenBoxAiForItem extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ OpenBoxAiForItem copy$default(OpenBoxAiForItem openBoxAiForItem, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openBoxAiForItem.itemModel;
                }
                return openBoxAiForItem.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final OpenBoxAiForItem copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new OpenBoxAiForItem(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenBoxAiForItem) && Intrinsics.areEqual(this.itemModel, ((OpenBoxAiForItem) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "OpenBoxAiForItem(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenBoxAiForItem(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$PermissionResultReceived;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "isGranted", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionResultReceived extends Action {
            public static final int $stable = 0;
            private final boolean isGranted;

            public static /* synthetic */ PermissionResultReceived copy$default(PermissionResultReceived permissionResultReceived, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = permissionResultReceived.isGranted;
                }
                return permissionResultReceived.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsGranted() {
                return this.isGranted;
            }

            public final PermissionResultReceived copy(boolean isGranted) {
                return new PermissionResultReceived(isGranted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PermissionResultReceived) && this.isGranted == ((PermissionResultReceived) other).isGranted;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isGranted);
            }

            public String toString() {
                return "PermissionResultReceived(isGranted=" + this.isGranted + ")";
            }

            public PermissionResultReceived(boolean z) {
                super(null);
                this.isGranted = z;
            }

            public final boolean isGranted() {
                return this.isGranted;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$NavigateTo;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "route", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;)V", "getRoute", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateTo extends Action {
            public static final int $stable = 0;
            private final Route route;

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Route route, int i, Object obj) {
                if ((i & 1) != 0) {
                    route = navigateTo.route;
                }
                return navigateTo.copy(route);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Route getRoute() {
                return this.route;
            }

            public final NavigateTo copy(Route route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new NavigateTo(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateTo) && Intrinsics.areEqual(this.route, ((NavigateTo) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "NavigateTo(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateTo(Route route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final Route getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigationCompleted extends Action {
            public static final int $stable = 0;
            public static final NavigationCompleted INSTANCE = new NavigationCompleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigationCompleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1510665637;
            }

            public String toString() {
                return "NavigationCompleted";
            }

            private NavigationCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$UpdateMenuActionsVisibility;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateMenuActionsVisibility extends Action {
            public static final int $stable = 0;
            public static final UpdateMenuActionsVisibility INSTANCE = new UpdateMenuActionsVisibility();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateMenuActionsVisibility)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -64131381;
            }

            public String toString() {
                return "UpdateMenuActionsVisibility";
            }

            private UpdateMenuActionsVisibility() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$OfflineFilesAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OfflineFilesAction extends Action implements Embedded<OfflineFilesReducer.Action> {
            public static final int $stable = OfflineFilesReducer.Action.$stable;
            private final OfflineFilesReducer.Action action;

            public static /* synthetic */ OfflineFilesAction copy$default(OfflineFilesAction offlineFilesAction, OfflineFilesReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = offlineFilesAction.action;
                }
                return offlineFilesAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final OfflineFilesReducer.Action getAction() {
                return this.action;
            }

            public final OfflineFilesAction copy(OfflineFilesReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new OfflineFilesAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OfflineFilesAction) && Intrinsics.areEqual(this.action, ((OfflineFilesAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "OfflineFilesAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OfflineFilesAction(OfflineFilesReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final OfflineFilesReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$DownloadAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DownloadAction extends Action implements Embedded<DownloadFilesReducer.Action> {
            public static final int $stable = DownloadFilesReducer.Action.$stable;
            private final DownloadFilesReducer.Action action;

            public static /* synthetic */ DownloadAction copy$default(DownloadAction downloadAction, DownloadFilesReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = downloadAction.action;
                }
                return downloadAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DownloadFilesReducer.Action getAction() {
                return this.action;
            }

            public final DownloadAction copy(DownloadFilesReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new DownloadAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DownloadAction) && Intrinsics.areEqual(this.action, ((DownloadAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "DownloadAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DownloadAction(DownloadFilesReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final DownloadFilesReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiMultidocAvailabilityAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxAiMultidocAvailabilityAction extends Action implements Embedded<BoxAiMultidocAvailabilityReducer.Action> {
            public static final int $stable = BoxAiMultidocAvailabilityReducer.Action.$stable;
            private final BoxAiMultidocAvailabilityReducer.Action action;

            public static /* synthetic */ BoxAiMultidocAvailabilityAction copy$default(BoxAiMultidocAvailabilityAction boxAiMultidocAvailabilityAction, BoxAiMultidocAvailabilityReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxAiMultidocAvailabilityAction.action;
                }
                return boxAiMultidocAvailabilityAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiMultidocAvailabilityReducer.Action getAction() {
                return this.action;
            }

            public final BoxAiMultidocAvailabilityAction copy(BoxAiMultidocAvailabilityReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxAiMultidocAvailabilityAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxAiMultidocAvailabilityAction) && Intrinsics.areEqual(this.action, ((BoxAiMultidocAvailabilityAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxAiMultidocAvailabilityAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxAiMultidocAvailabilityAction(BoxAiMultidocAvailabilityReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiMultidocAvailabilityReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/BoxAiReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/BoxAiReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/BoxAiReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxAiAction extends Action implements Embedded<BoxAiReducer.Action> {
            public static final int $stable = BoxAiReducer.Action.$stable;
            private final BoxAiReducer.Action action;

            public static /* synthetic */ BoxAiAction copy$default(BoxAiAction boxAiAction, BoxAiReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxAiAction.action;
                }
                return boxAiAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiReducer.Action getAction() {
                return this.action;
            }

            public final BoxAiAction copy(BoxAiReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxAiAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxAiAction) && Intrinsics.areEqual(this.action, ((BoxAiAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxAiAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxAiAction(BoxAiReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$BoxAiCenterAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/boxai/BoxAiCenterReducer$Action;)V", "getAction", "()Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BoxAiCenterAction extends Action implements Embedded<BoxAiCenterReducer.Action> {
            public static final int $stable = BoxAiCenterReducer.Action.$stable;
            private final BoxAiCenterReducer.Action action;

            public static /* synthetic */ BoxAiCenterAction copy$default(BoxAiCenterAction boxAiCenterAction, BoxAiCenterReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = boxAiCenterAction.action;
                }
                return boxAiCenterAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxAiCenterReducer.Action getAction() {
                return this.action;
            }

            public final BoxAiCenterAction copy(BoxAiCenterReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BoxAiCenterAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BoxAiCenterAction) && Intrinsics.areEqual(this.action, ((BoxAiCenterAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BoxAiCenterAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoxAiCenterAction(BoxAiCenterReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BoxAiCenterReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$Companion;", "", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    public final ReducerResult<State, Action> reduceActionableItemsList(State state, Action action) {
        Effect effectNone;
        if (action instanceof Action.ShowMoreActionsMenu) {
            Action.ShowMoreActionsMenu showMoreActionsMenu = (Action.ShowMoreActionsMenu) action;
            return new ReducerResult<>(state, new Effect(new Action.NavigateTo(new Route.MoreActions(showMoreActionsMenu.getItemModel(), new BottomSheetItemsActionsValidator().filterInvalid(state.getBottomSheetAvailableActions(), showMoreActionsMenu.getItemModel())))));
        }
        if (action instanceof Action.PermissionResultReceived) {
            if (state.getPermissionRequest() != null) {
                Action actionOnPermissionGranted = state.getPermissionRequest().getActionOnPermissionGranted();
                State stateCopy$default = State.copy$default(state, null, null, null, null, null, null, null, null, null, 507, null);
                if (((Action.PermissionResultReceived) action).isGranted() && actionOnPermissionGranted != null) {
                    effectNone = new Effect(actionOnPermissionGranted);
                } else {
                    effectNone = Effect.INSTANCE.none();
                }
                return new ReducerResult<>(stateCopy$default, effectNone);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.ItemsListAction) {
            return reduceItemsList(((Action.ItemsListAction) action).getItemsListViewAction(), state);
        }
        if (action instanceof Action.StartMultiSelectMode) {
            return new ReducerResult<>(state, new Effect(new Action.ItemsListAction(new ItemsListReducer.Action.Multiselect(MultiselectReducer.Action.StartMultiSelectMode.INSTANCE))));
        }
        if (action instanceof Action.ExitMultiselectMode) {
            return new ReducerResult<>(state, new Effect(new Action.ItemsListAction(new ItemsListReducer.Action.Multiselect(MultiselectReducer.Action.ExitMultiSelectMode.INSTANCE))));
        }
        if (action instanceof Action.BatchSaveOffline) {
            return batchSaveOffline(state);
        }
        if (action instanceof Action.BatchRemoveOffline) {
            return batchRemoveOffline(state);
        }
        if (action instanceof Action.BatchSelect) {
            IdentifiedList<ItemId.Remote, ItemReducer.State> items = state.getItemsListViewState().getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<ItemReducer.State> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getItemModel());
            }
            return new ReducerResult<>(state, new Effect(new Action.ItemsListAction(new ItemsListReducer.Action.Multiselect(new MultiselectReducer.Action.BatchSelect(CollectionsKt.toSet(arrayList))))));
        }
        if (action instanceof Action.BatchCopyMove) {
            return new ReducerResult<>(state, new Effect(new Action.NavigateTo(new Route.Batch.BatchCopyMove(state.getItemsListViewState().getSelectedItemModels()))));
        }
        if (action instanceof Action.BatchDelete) {
            return new ReducerResult<>(state, new Effect(new Action.NavigateTo(new Route.Batch.BatchDelete(state.getItemsListViewState().getSelectedItemModels()))));
        }
        if (action instanceof Action.BatchExport) {
            return batchExport(state);
        }
        if (action instanceof Action.OpenBoxAiForSelectedFiles) {
            return openBoxAiForSelectedFiles(state);
        }
        if (action instanceof Action.OpenBoxAiForItem) {
            return openBoxAiForItem(state, ((Action.OpenBoxAiForItem) action).getItemModel());
        }
        if (action instanceof Action.UpdateMenuActionsVisibility) {
            return new ReducerResult<>(State.copy$default(state, null, MultiselectMenuActionsVisibility.INSTANCE.generateFrom(state.getItemsListViewState().getCurrentFolder(), state.getItemsListViewState(), state.getBoxAiMultidocAvailabilityState(), this.environment.getItemListViewEnvironment().getMultiselectEnvironment(), (MultiselectMenuAction[]) state.getMenuActionsVisibility().getVisibility().keySet().toArray(new MultiselectMenuAction[0])), null, null, null, null, null, null, null, 509, null), null, 2, null);
        }
        if (action instanceof Action.OfflineFilesAction) {
            return reduceOfflineFiles(((Action.OfflineFilesAction) action).getAction(), state);
        }
        if (action instanceof Action.DownloadAction) {
            return reduceDownload(((Action.DownloadAction) action).getAction(), state);
        }
        if (action instanceof Action.BoxAiMultidocAvailabilityAction) {
            return reduceBoxAiMultidocAvailability(((Action.BoxAiMultidocAvailabilityAction) action).getAction(), state);
        }
        return action instanceof Action.BoxAiAction ? reduceBoxAi(((Action.BoxAiAction) action).getAction(), state) : new ReducerResult<>(state, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> batchExport(State state) {
        List<ItemModel> selectedItemModels = state.getItemsListViewState().getSelectedItemModels();
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, new DownloadFilesReducer.State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), null, null, null, 479, null), new Effect(new Action.DownloadAction(new DownloadFilesReducer.Action.Start(selectedItemModels))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> batchRemoveOffline(State state) {
        List<ItemModel> selectedItemModels = state.getItemsListViewState().getSelectedItemModels();
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, new OfflineFilesReducer.State(selectedItemModels, null, 2, 0 == true ? 1 : 0), null, null, null, null, 495, null), Effect.INSTANCE.merge(new Effect(new Action.OfflineFilesAction(OfflineFilesReducer.Action.StartRemoveFromOffline.INSTANCE)), Effect.INSTANCE.fireAndForget(new AnonymousClass1(selectedItemModels, null))));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$batchRemoveOffline$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$batchRemoveOffline$1", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ItemModel> $selectedItems;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends ItemModel> list, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$selectedItems = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new AnonymousClass1(this.$selectedItems, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionableItemsListReducer.this.environment.getBrowseAnalytics().sendBatchRemoveFromOfflineEventFor(this.$selectedItems);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> batchSaveOffline(State state) {
        List<ItemModel> selectedItemModels = state.getItemsListViewState().getSelectedItemModels();
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, new OfflineFilesReducer.State(selectedItemModels, null, 2, 0 == true ? 1 : 0), null, null, null, null, 495, null), Effect.INSTANCE.merge(new Effect(new Action.OfflineFilesAction(OfflineFilesReducer.Action.StartMakeAvailableOffline.INSTANCE)), Effect.INSTANCE.fireAndForget(new C09521(selectedItemModels, null))));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$batchSaveOffline$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$batchSaveOffline$1", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09521 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ItemModel> $selectedItems;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09521(List<? extends ItemModel> list, Continuation<? super C09521> continuation) {
            super(1, continuation);
            this.$selectedItems = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new C09521(this.$selectedItems, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09521) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionableItemsListReducer.this.environment.getBrowseAnalytics().sendBatchSaveOfflineEventFor(this.$selectedItems);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$logAdminSettingsErrorEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$logAdminSettingsErrorEffect$1", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09531 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C09531(Continuation<? super C09531> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new C09531(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09531) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ActionableItemsListReducer.this.environment.getBrowseAnalytics().sendBatchSaveOfflineErrorEvent(ActionableItemsListReducer.this.environment.getBoxAccountManagerHelper().getEncryptedDeviceRequiredMessage());
            return Unit.INSTANCE;
        }
    }

    private final Effect<Action> logAdminSettingsErrorEffect(AdminSettingsDomainError adminError) {
        return adminError instanceof AdminSettingsDomainError.EncryptedDeviceRequired ? Effect.INSTANCE.fireAndForget(new C09531(null)) : Effect.INSTANCE.fireAndForget(new AnonymousClass2(null));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$logAdminSettingsErrorEffect$2, reason: invalid class name */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$logAdminSettingsErrorEffect$2", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new AnonymousClass2(continuation);
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
            ActionableItemsListReducer.this.environment.getBrowseAnalytics().sendBatchSaveOfflineErrorEvent(ActionableItemsListReducer.this.environment.getBoxAccountManagerHelper().getFeatureDisabledMessage());
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> openBoxAiForSelectedFiles(State state) {
        BoxAiMultidocAvailabilityReducer.ItemsAvailability availableAndUnavailableItems = state.getBoxAiMultidocAvailabilityState().getAvailableAndUnavailableItems();
        List<FileModel> listComponent1 = availableAndUnavailableItems.component1();
        List<Pair<ItemModel, AiUnavailabilityReason>> listComponent2 = availableAndUnavailableItems.component2();
        Effect.Companion companion = Effect.INSTANCE;
        Effect[] effectArr = new Effect[3];
        effectArr[0] = new Effect(new Action.BoxAiAction(new BoxAiReducer.Action.LaunchWithFiles(listComponent1, listComponent2)));
        List<FileModel> list = listComponent1;
        List<Pair<ItemModel, AiUnavailabilityReason>> list2 = listComponent2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((ItemModel) ((Pair) it.next()).getFirst());
        }
        effectArr[1] = new Effect(new Action.BoxAiCenterAction(new BoxAiCenterReducer.Action.Show(CollectionsKt.plus((Collection) list, (Iterable) arrayList))));
        effectArr[2] = Effect.INSTANCE.fireAndForget(new C09552(listComponent1, null));
        return new ReducerResult<>(state, companion.merge(effectArr));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$openBoxAiForSelectedFiles$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$openBoxAiForSelectedFiles$2", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09552 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FileModel> $availableFiles;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09552(List<FileModel> list, Continuation<? super C09552> continuation) {
            super(1, continuation);
            this.$availableFiles = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new C09552(this.$availableFiles, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09552) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionableItemsListReducer.this.environment.getBoxAiEnvironment().getBoxAiAnalytics().boxAiLaunchedFromMultiselect(this.$availableFiles);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> openBoxAiForItem(State state, ItemModel itemModel) {
        FileModel fileModel = ItemModelKt.fileModel(itemModel);
        int i = 2;
        List list = null;
        Object[] objArr = 0;
        if (fileModel == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(new Action.BoxAiAction(BoxAiReducer.Action.ResetSession.INSTANCE)), new Effect(new Action.BoxAiAction(new BoxAiReducer.Action.LaunchWithFiles(CollectionsKt.listOf(fileModel), list, i, objArr == true ? 1 : 0))), new Effect(new Action.BoxAiCenterAction(new BoxAiCenterReducer.Action.Show(CollectionsKt.listOf(fileModel)))), Effect.INSTANCE.fireAndForget(new C09541(fileModel, null))));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$openBoxAiForItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$openBoxAiForItem$1", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09541 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09541(FileModel fileModel, Continuation<? super C09541> continuation) {
            super(1, continuation);
            this.$fileModel = fileModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new C09541(this.$fileModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09541) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionableItemsListReducer.this.environment.getBoxAiEnvironment().getBoxAiAnalytics().boxAiLaunchedFromQuickAction(this.$fileModel);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final ReducerResult<State, Action> reduceDownload(DownloadFilesReducer.Action action, State state) {
        if (action instanceof DownloadFilesReducer.Action.SelectFolder) {
            return new ReducerResult<>(state, new Effect(new Action.NavigateTo(new Route.Batch.BatchExport(state.getItemsListViewState().getSelectedItemModels()))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceItemsList(ItemsListReducer.Action itemViewAction, State state) {
        Effect effectNone;
        if (itemViewAction instanceof ItemsListReducer.Action.ItemAction) {
            ItemsListReducer.Action.ItemAction itemAction = (ItemsListReducer.Action.ItemAction) itemViewAction;
            ItemReducer.Action action = itemAction.getAction();
            if (action instanceof ItemReducer.Action.MenuClicked) {
                ItemReducer.State state2 = (ItemReducer.State) state.getItemsListViewState().getItems().getById(itemAction.getId());
                ItemModel itemModel = state2 != null ? state2.getItemModel() : null;
                if (itemModel != null) {
                    return new ReducerResult<>(state, new Effect(new Action.ShowMoreActionsMenu(itemModel)));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            if (action instanceof ItemReducer.Action.UpdateClicked) {
                ItemReducer.State state3 = (ItemReducer.State) state.getItemsListViewState().getItems().getById(itemAction.getId());
                ItemModel itemModel2 = state3 != null ? state3.getItemModel() : null;
                if (itemModel2 != null) {
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09562(CollectionsKt.listOf(itemModel2), null)));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (itemViewAction instanceof ItemsListReducer.Action.Multiselect) {
            return reduceMultiselect(((ItemsListReducer.Action.Multiselect) itemViewAction).getAction(), state);
        }
        if (itemViewAction instanceof ItemsListReducer.Action.OpenItem) {
            ItemModel item = state.getItemsListViewState().getItem(((ItemsListReducer.Action.OpenItem) itemViewAction).getId());
            FolderModel folderModel = item instanceof FolderModel ? (FolderModel) item : null;
            if (folderModel == null || (effectNone = Effect.INSTANCE.fireAndForget(new ActionableItemsListReducer$reduceItemsList$effect$1$1(this, folderModel, null))) == null) {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$reduceItemsList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActionableItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$reduceItemsList$2", f = "ActionableItemsListReducer.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09562 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ItemModel> $items;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09562(List<? extends ItemModel> list, Continuation<? super C09562> continuation) {
            super(1, continuation);
            this.$items = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ActionableItemsListReducer.this.new C09562(this.$items, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09562) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ActionableItemsListReducer.this.environment.getOfflineFilesEnvironment().getOfflineService().syncOfflineItems(this.$items, this) == coroutine_suspended) {
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

    private final ReducerResult<State, Action> reduceMultiselect(MultiselectReducer.Action multiselectAction, State state) {
        if (multiselectAction instanceof MultiselectReducer.Action.MultiSelectModeChanged) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Action.UpdateMenuActionsVisibility.INSTANCE, new Action.BoxAiMultidocAvailabilityAction(new BoxAiMultidocAvailabilityReducer.Action.SetSelectedItems(state.getItemsListViewState().getSelectedItemModels()))));
        }
        if (multiselectAction instanceof MultiselectReducer.Action.ExitMultiSelectMode) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(new Action.BoxAiAction(BoxAiReducer.Action.ResetSession.INSTANCE), new Action.BoxAiCenterAction(BoxAiCenterReducer.Action.ResetSession.INSTANCE)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceOfflineFiles(OfflineFilesReducer.Action offlineAction, State state) {
        if (offlineAction instanceof OfflineFilesReducer.Action.AdminSettingsErrorOccurred) {
            return new ReducerResult<>(state, logAdminSettingsErrorEffect(((OfflineFilesReducer.Action.AdminSettingsErrorOccurred) offlineAction).getAdminError()));
        }
        if (offlineAction instanceof OfflineFilesReducer.Action.Finish) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, null, null, null, 495, null), new Effect(Action.ExitMultiselectMode.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceBoxAiMultidocAvailability(BoxAiMultidocAvailabilityReducer.Action boxAiAvailabilityAction, State state) {
        if (boxAiAvailabilityAction instanceof BoxAiMultidocAvailabilityReducer.Action.AvailabilityUpdated) {
            return new ReducerResult<>(state, new Effect(Action.UpdateMenuActionsVisibility.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceBoxAi(BoxAiReducer.Action boxAiAction, State state) {
        if (boxAiAction instanceof BoxAiReducer.Action.UpdateAppAlertAccepted) {
            return new ReducerResult<>(state, new Effect(new Action.NavigateTo(Route.UpdateApp.INSTANCE)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
