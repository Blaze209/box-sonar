package com.box.android.browse.cpl.copymove;

import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.CPLExtensionsKt;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachInListReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.data.CreateFolderMutation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.ILocalItemService;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Collection;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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

/* JADX INFO: compiled from: CopyOrMoveReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$State;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "environment", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/copymove/CopyOrMoveEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCopyOrMove", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceItemsList", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "addFolderToStack", "", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "selectedItem", "Lcom/box/android/domain/models/item/FolderModel;", "getUpdatedState", StackTraceHelper.STACK_KEY, "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyOrMoveReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CopyOrMoveEnvironment environment;

    public CopyOrMoveReducer(CopyOrMoveEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CopyOrMoveReducer.build$lambda$0(this.f$0, (CopyOrMoveReducer.State) obj, (CopyOrMoveReducer.Action) obj2);
            }
        });
        final CopyOrMoveReducer$build$2 copyOrMoveReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CopyOrMoveReducer.State) obj).getStack();
            }
        };
        final CopyOrMoveReducer$build$3 copyOrMoveReducer$build$3 = CopyOrMoveReducer$build$3.INSTANCE;
        ForEachInListReducer forEachInListReducer = new ForEachInListReducer(reduce, new ItemsListReducer(environment.getFolderViewEnvironment()), copyOrMoveReducer$build$2, new Function1<Action, EmbeddedItem<Integer, ItemsListReducer.Action>>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$forEachInList$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<Integer, ItemsListReducer.Action> invoke(CopyOrMoveReducer.Action action) {
                if (!(action instanceof CopyOrMoveReducer.Action.ItemsList)) {
                    action = null;
                }
                return (CopyOrMoveReducer.Action.ItemsList) action;
            }
        }, new Function3<State, ItemsListReducer.State, Integer, State>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$forEachInList$2
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.browse.cpl.copymove.CopyOrMoveReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ CopyOrMoveReducer.State invoke(CopyOrMoveReducer.State state, ItemsListReducer.State state2, Integer num) {
                return invoke(state, state2, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final CopyOrMoveReducer.State invoke(CopyOrMoveReducer.State parentState, ItemsListReducer.State state, int i) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                List mutableList = CollectionsKt.toMutableList((Collection) copyOrMoveReducer$build$2.get(parentState));
                mutableList.set(i, state);
                KProperty1 kProperty1 = copyOrMoveReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CopyOrMoveReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, mutableList)));
                        if (rCallBy != 0) {
                            return (CopyOrMoveReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.copymove.CopyOrMoveReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<Integer, ItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$forEachInList$3
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.browse.cpl.copymove.CopyOrMoveReducer$Action, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CopyOrMoveReducer.Action invoke(Integer num, ItemsListReducer.Action action) {
                return invoke(num.intValue(), action);
            }

            public final CopyOrMoveReducer.Action invoke(int i, ItemsListReducer.Action action) {
                Object objInvoke = copyOrMoveReducer$build$3.invoke(Integer.valueOf(i), action);
                if (objInvoke != null) {
                    return (CopyOrMoveReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.copymove.CopyOrMoveReducer.Action");
            }
        });
        final CopyOrMoveReducer$build$5 copyOrMoveReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CopyOrMoveReducer.State) obj).getCreateFolderState();
            }
        };
        final CopyOrMoveReducer$build$6 copyOrMoveReducer$build$6 = CopyOrMoveReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(forEachInListReducer, new CreateFolderReducer(environment.getCreateFolderEnvironment()), new Function1<State, CreateFolderReducer.State>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.createfolder.CreateFolderReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.State invoke(CopyOrMoveReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return copyOrMoveReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CreateFolderReducer.Action>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.Action invoke(CopyOrMoveReducer.Action action) {
                if (!(action instanceof CopyOrMoveReducer.Action.CreateFolderParentAction)) {
                    action = null;
                }
                CopyOrMoveReducer.Action.CreateFolderParentAction createFolderParentAction = (CopyOrMoveReducer.Action.CreateFolderParentAction) action;
                if (createFolderParentAction != null) {
                    return createFolderParentAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CreateFolderReducer.State, State>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CopyOrMoveReducer.State invoke(CopyOrMoveReducer.State parentState, CreateFolderReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = copyOrMoveReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CopyOrMoveReducer.State.class)).iterator();
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
                            return (CopyOrMoveReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.copymove.CopyOrMoveReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateFolderReducer.Action, Action>() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CopyOrMoveReducer.Action invoke(CreateFolderReducer.Action action) {
                Object objInvoke = copyOrMoveReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (CopyOrMoveReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.copymove.CopyOrMoveReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jg\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\u0016¨\u00065"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$State;", "", "isClosing", "", "createFolderState", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "originFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", StackTraceHelper.STACK_KEY, "", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "itemsToCopy", "Lcom/box/android/domain/models/item/ItemModel;", "canCopy", "canMove", "createFolderEnabled", "<init>", "(ZLcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;Lcom/box/android/domain/models/ItemId$Remote;Ljava/util/List;Ljava/util/List;ZZZ)V", "()Z", "getCreateFolderState", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "getOriginFolderId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getStack", "()Ljava/util/List;", "getItemsToCopy", "getCanCopy", "getCanMove", "getCreateFolderEnabled", "itemsListViewState", "getItemsListViewState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "currentlyDisplayedFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getCurrentlyDisplayedFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "currentlyDisplayedFolderId", "getCurrentlyDisplayedFolderId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean canCopy;
        private final boolean canMove;
        private final boolean createFolderEnabled;
        private final CreateFolderReducer.State createFolderState;
        private final FolderModel currentlyDisplayedFolder;
        private final boolean isClosing;
        private final ItemsListReducer.State itemsListViewState;
        private final List<ItemModel> itemsToCopy;
        private final ItemId.Remote originFolderId;
        private final List<ItemsListReducer.State> stack;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, CreateFolderReducer.State state2, ItemId.Remote remote, List list, List list2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isClosing;
            }
            if ((i & 2) != 0) {
                state2 = state.createFolderState;
            }
            if ((i & 4) != 0) {
                remote = state.originFolderId;
            }
            if ((i & 8) != 0) {
                list = state.stack;
            }
            if ((i & 16) != 0) {
                list2 = state.itemsToCopy;
            }
            if ((i & 32) != 0) {
                z2 = state.canCopy;
            }
            if ((i & 64) != 0) {
                z3 = state.canMove;
            }
            if ((i & 128) != 0) {
                z4 = state.createFolderEnabled;
            }
            boolean z5 = z3;
            boolean z6 = z4;
            List list3 = list2;
            boolean z7 = z2;
            return state.copy(z, state2, remote, list, list3, z7, z5, z6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemId.Remote getOriginFolderId() {
            return this.originFolderId;
        }

        public final List<ItemsListReducer.State> component4() {
            return this.stack;
        }

        public final List<ItemModel> component5() {
            return this.itemsToCopy;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanCopy() {
            return this.canCopy;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getCanMove() {
            return this.canMove;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getCreateFolderEnabled() {
            return this.createFolderEnabled;
        }

        public final State copy(boolean isClosing, CreateFolderReducer.State createFolderState, ItemId.Remote originFolderId, List<ItemsListReducer.State> stack, List<? extends ItemModel> itemsToCopy, boolean canCopy, boolean canMove, boolean createFolderEnabled) {
            Intrinsics.checkNotNullParameter(originFolderId, "originFolderId");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            return new State(isClosing, createFolderState, originFolderId, stack, itemsToCopy, canCopy, canMove, createFolderEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isClosing == state.isClosing && Intrinsics.areEqual(this.createFolderState, state.createFolderState) && Intrinsics.areEqual(this.originFolderId, state.originFolderId) && Intrinsics.areEqual(this.stack, state.stack) && Intrinsics.areEqual(this.itemsToCopy, state.itemsToCopy) && this.canCopy == state.canCopy && this.canMove == state.canMove && this.createFolderEnabled == state.createFolderEnabled;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isClosing) * 31;
            CreateFolderReducer.State state = this.createFolderState;
            return ((((((((((((iHashCode + (state == null ? 0 : state.hashCode())) * 31) + this.originFolderId.hashCode()) * 31) + this.stack.hashCode()) * 31) + this.itemsToCopy.hashCode()) * 31) + Boolean.hashCode(this.canCopy)) * 31) + Boolean.hashCode(this.canMove)) * 31) + Boolean.hashCode(this.createFolderEnabled);
        }

        public String toString() {
            return "State(isClosing=" + this.isClosing + ", createFolderState=" + this.createFolderState + ", originFolderId=" + this.originFolderId + ", stack=" + this.stack + ", itemsToCopy=" + this.itemsToCopy + ", canCopy=" + this.canCopy + ", canMove=" + this.canMove + ", createFolderEnabled=" + this.createFolderEnabled + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(boolean z, CreateFolderReducer.State state, ItemId.Remote originFolderId, List<ItemsListReducer.State> stack, List<? extends ItemModel> itemsToCopy, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(originFolderId, "originFolderId");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            this.isClosing = z;
            this.createFolderState = state;
            this.originFolderId = originFolderId;
            this.stack = stack;
            this.itemsToCopy = itemsToCopy;
            this.canCopy = z2;
            this.canMove = z3;
            this.createFolderEnabled = z4;
            ItemsListReducer.State state2 = (ItemsListReducer.State) CollectionsKt.last((List) stack);
            this.itemsListViewState = state2;
            this.currentlyDisplayedFolder = state2.getCurrentFolder();
        }

        public /* synthetic */ State(boolean z, CreateFolderReducer.State state, ItemId.Remote remote, List list, List list2, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, state, remote, list, list2, z2, z3, z4);
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        public final ItemId.Remote getOriginFolderId() {
            return this.originFolderId;
        }

        public final List<ItemsListReducer.State> getStack() {
            return this.stack;
        }

        public final List<ItemModel> getItemsToCopy() {
            return this.itemsToCopy;
        }

        public final boolean getCanCopy() {
            return this.canCopy;
        }

        public final boolean getCanMove() {
            return this.canMove;
        }

        public final boolean getCreateFolderEnabled() {
            return this.createFolderEnabled;
        }

        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        public final FolderModel getCurrentlyDisplayedFolder() {
            return this.currentlyDisplayedFolder;
        }

        public final ItemId.Remote getCurrentlyDisplayedFolderId() {
            return ItemModelKt.toItemIdRemoteId(this.currentlyDisplayedFolder);
        }
    }

    /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "", "<init>", "()V", CreateFolderMutation.OPERATION_NAME, "GoBack", "CopyActionTriggered", "MoveActionTriggered", "CloseScreen", "ItemsList", "CreateFolderParentAction", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CloseScreen;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CopyActionTriggered;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CreateFolderParentAction;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$GoBack;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$ItemsList;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$MoveActionTriggered;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateFolder extends Action {
            public static final int $stable = 0;
            public static final CreateFolder INSTANCE = new CreateFolder();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateFolder)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1750961101;
            }

            public String toString() {
                return CreateFolderMutation.OPERATION_NAME;
            }

            private CreateFolder() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$GoBack;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GoBack extends Action {
            public static final int $stable = 0;
            public static final GoBack INSTANCE = new GoBack();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GoBack)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -41386920;
            }

            public String toString() {
                return "GoBack";
            }

            private GoBack() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CopyActionTriggered;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyActionTriggered extends Action {
            public static final int $stable = 0;
            public static final CopyActionTriggered INSTANCE = new CopyActionTriggered();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CopyActionTriggered)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -745542973;
            }

            public String toString() {
                return "CopyActionTriggered";
            }

            private CopyActionTriggered() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$MoveActionTriggered;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MoveActionTriggered extends Action {
            public static final int $stable = 0;
            public static final MoveActionTriggered INSTANCE = new MoveActionTriggered();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoveActionTriggered)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 550345447;
            }

            public String toString() {
                return "MoveActionTriggered";
            }

            private MoveActionTriggered() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CloseScreen;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CloseScreen extends Action {
            public static final int $stable = 0;
            public static final CloseScreen INSTANCE = new CloseScreen();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseScreen)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -629301317;
            }

            public String toString() {
                return "CloseScreen";
            }

            private CloseScreen() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$ItemsList;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", FirebaseAnalytics.Param.INDEX, Analytics.Data.ACTION, "<init>", "(ILcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", "getIndex", "()I", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "component1", "()Ljava/lang/Integer;", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsList extends Action implements EmbeddedItem<Integer, ItemsListReducer.Action> {
            public static final int $stable = 0;
            private final ItemsListReducer.Action action;
            private final int index;

            public static /* synthetic */ ItemsList copy$default(ItemsList itemsList, int i, ItemsListReducer.Action action, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = itemsList.index;
                }
                if ((i2 & 2) != 0) {
                    action = itemsList.action;
                }
                return itemsList.copy(i, action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1 */
            public final Integer getId() {
                return Integer.valueOf(this.index);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemsListReducer.Action getAction() {
                return this.action;
            }

            public final ItemsList copy(int index, ItemsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemsList(index, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemsList)) {
                    return false;
                }
                ItemsList itemsList = (ItemsList) other;
                return this.index == itemsList.index && Intrinsics.areEqual(this.action, itemsList.action);
            }

            public int hashCode() {
                return (Integer.hashCode(this.index) * 31) + this.action.hashCode();
            }

            public String toString() {
                return "ItemsList(index=" + this.index + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemsList(int i, ItemsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.index = i;
                this.action = action;
            }

            public final ItemsListReducer.Action getAction() {
                return this.action;
            }

            public final int getIndex() {
                return this.index;
            }
        }

        /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action$CreateFolderParentAction;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "createFolderAction", "<init>", "(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", "getCreateFolderAction", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateFolderParentAction extends Action implements Embedded<CreateFolderReducer.Action> {
            public static final int $stable = 0;
            private final CreateFolderReducer.Action createFolderAction;

            public static /* synthetic */ CreateFolderParentAction copy$default(CreateFolderParentAction createFolderParentAction, CreateFolderReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = createFolderParentAction.createFolderAction;
                }
                return createFolderParentAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CreateFolderReducer.Action getAction() {
                return this.createFolderAction;
            }

            public final CreateFolderParentAction copy(CreateFolderReducer.Action createFolderAction) {
                Intrinsics.checkNotNullParameter(createFolderAction, "createFolderAction");
                return new CreateFolderParentAction(createFolderAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateFolderParentAction) && Intrinsics.areEqual(this.createFolderAction, ((CreateFolderParentAction) other).createFolderAction);
            }

            public int hashCode() {
                return this.createFolderAction.hashCode();
            }

            public String toString() {
                return "CreateFolderParentAction(createFolderAction=" + this.createFolderAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateFolderParentAction(CreateFolderReducer.Action createFolderAction) {
                super(null);
                Intrinsics.checkNotNullParameter(createFolderAction, "createFolderAction");
                this.createFolderAction = createFolderAction;
            }

            public final CreateFolderReducer.Action getCreateFolderAction() {
                return this.createFolderAction;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(CopyOrMoveReducer copyOrMoveReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return copyOrMoveReducer.reduceCopyOrMove(state, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceCopyOrMove(State state, Action action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof Action.CloseScreen) {
            return new ReducerResult<>(State.copy$default(state, true, null, null, null, null, false, false, false, 254, null), effect, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.CopyActionTriggered) {
            return new ReducerResult<>(State.copy$default(state, true, null, null, null, null, false, false, false, 254, null), new Effect(FlowKt.flow(new AnonymousClass1(state, this, null))));
        }
        if (action instanceof Action.GoBack) {
            Effect effectCancel = CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getItemsListViewState().getUniqueCancelEffectKey()));
            if (state.getStack().size() > 1) {
                List<ItemsListReducer.State> mutableList = CollectionsKt.toMutableList((Collection) state.getStack());
                mutableList.remove(CollectionsKt.getLastIndex(mutableList));
                return new ReducerResult<>(getUpdatedState(state, mutableList), effectCancel);
            }
            return new ReducerResult<>(State.copy$default(state, true, null, null, null, null, false, false, false, 254, null), effectCancel);
        }
        if (action instanceof Action.MoveActionTriggered) {
            return new ReducerResult<>(State.copy$default(state, true, null, null, null, null, false, false, false, 254, null), new Effect(FlowKt.flow(new AnonymousClass2(state, this, null))));
        }
        if (action instanceof Action.CreateFolder) {
            return new ReducerResult<>(State.copy$default(state, false, new CreateFolderReducer.State("", state.getCurrentlyDisplayedFolderId(), null, null, false, false, null, 124, null), null, null, null, false, false, false, 253, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.CreateFolderParentAction) {
            CreateFolderReducer.Action createFolderAction = ((Action.CreateFolderParentAction) action).getCreateFolderAction();
            if ((createFolderAction instanceof CreateFolderReducer.Action.FolderCreationCancelled) || (createFolderAction instanceof CreateFolderReducer.Action.FolderCreated)) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, null, null, false, false, false, 253, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (!(action instanceof Action.ItemsList)) {
            throw new NoWhenBranchMatchedException();
        }
        return reduceItemsList(state, ((Action.ItemsList) action).getAction());
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$reduceCopyOrMove$1, reason: invalid class name */
    /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.copymove.CopyOrMoveReducer$reduceCopyOrMove$1", f = "CopyOrMoveReducer.kt", i = {0, 0, 0, 0, 0}, l = {77}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-CopyOrMoveReducer$reduceCopyOrMove$1$1"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ CopyOrMoveReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, CopyOrMoveReducer copyOrMoveReducer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = copyOrMoveReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterable iterable;
            CopyOrMoveReducer copyOrMoveReducer;
            State state;
            Iterator it;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<ItemModel> itemsToCopy = this.$state.getItemsToCopy();
                iterable = itemsToCopy;
                copyOrMoveReducer = this.this$0;
                state = this.$state;
                it = itemsToCopy.iterator();
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = this.I$0;
                Iterator it2 = (Iterator) this.L$3;
                State state2 = (State) this.L$2;
                CopyOrMoveReducer copyOrMoveReducer2 = (CopyOrMoveReducer) this.L$1;
                Iterable iterable2 = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i3;
                it = it2;
                state = state2;
                copyOrMoveReducer = copyOrMoveReducer2;
                iterable = iterable2;
            }
            while (it.hasNext()) {
                Object next = it.next();
                ItemModel itemModel = (ItemModel) next;
                ILocalItemService localItemService = copyOrMoveReducer.environment.getLocalItemService();
                ItemId itemId = itemModel.getItemId();
                ItemId.Remote currentlyDisplayedFolderId = state.getCurrentlyDisplayedFolderId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = copyOrMoveReducer;
                this.L$2 = state;
                this.L$3 = it;
                this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                this.L$5 = SpillingKt.nullOutSpilledVariable(itemModel);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (ILocalItemService.copyItem$default(localItemService, itemId, currentlyDisplayedFolderId, null, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.copymove.CopyOrMoveReducer$reduceCopyOrMove$2, reason: invalid class name */
    /* JADX INFO: compiled from: CopyOrMoveReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.copymove.CopyOrMoveReducer$reduceCopyOrMove$2", f = "CopyOrMoveReducer.kt", i = {0, 0, 0, 0, 0}, l = {104}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-CopyOrMoveReducer$reduceCopyOrMove$2$1"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ CopyOrMoveReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State state, CopyOrMoveReducer copyOrMoveReducer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = copyOrMoveReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterable iterable;
            CopyOrMoveReducer copyOrMoveReducer;
            State state;
            Iterator it;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<ItemModel> itemsToCopy = this.$state.getItemsToCopy();
                iterable = itemsToCopy;
                copyOrMoveReducer = this.this$0;
                state = this.$state;
                it = itemsToCopy.iterator();
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = this.I$0;
                Iterator it2 = (Iterator) this.L$3;
                State state2 = (State) this.L$2;
                CopyOrMoveReducer copyOrMoveReducer2 = (CopyOrMoveReducer) this.L$1;
                Iterable iterable2 = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i3;
                it = it2;
                state = state2;
                copyOrMoveReducer = copyOrMoveReducer2;
                iterable = iterable2;
            }
            while (it.hasNext()) {
                Object next = it.next();
                ItemModel itemModel = (ItemModel) next;
                ILocalItemService localItemService = copyOrMoveReducer.environment.getLocalItemService();
                ItemId itemId = itemModel.getItemId();
                ItemId.Remote currentlyDisplayedFolderId = state.getCurrentlyDisplayedFolderId();
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = copyOrMoveReducer;
                this.L$2 = state;
                this.L$3 = it;
                this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                this.L$5 = SpillingKt.nullOutSpilledVariable(itemModel);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (ILocalItemService.moveItem$default(localItemService, itemId, currentlyDisplayedFolderId, null, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceItemsList(State state, ItemsListReducer.Action action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof ItemsListReducer.Action.OpenItem) {
            ItemModel item = state.getItemsListViewState().getItem(((ItemsListReducer.Action.OpenItem) action).getId());
            if (item instanceof FolderModel) {
                return new ReducerResult<>(getUpdatedState(state, addFolderToStack(state, (FolderModel) item)), effect, i, objArr7 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof ItemsListReducer.Action.UpdateItems) {
            return new ReducerResult<>(getUpdatedState(state, state.getStack()), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    private final List<ItemsListReducer.State> addFolderToStack(State state, FolderModel selectedItem) {
        List<ItemsListReducer.State> mutableList = CollectionsKt.toMutableList((Collection) state.getStack());
        mutableList.add(new ItemsListReducer.State(null, null, null, selectedItem, state.getItemsListViewState().getShouldDisableNonFolderItems(), state.getItemsListViewState().getDisabledItems(), state.getItemsListViewState().getFeatureBanner(), state.getItemsListViewState().getDisplayFeatureBanner(), null, null, null, null, null, null, false, false, 65287, null));
        return mutableList;
    }

    private final State getUpdatedState(State state, List<ItemsListReducer.State> stack) {
        return State.copy$default(state, false, null, null, stack, null, CopyOrMoveHelper.INSTANCE.isCopyEnabled(state.getItemsToCopy(), stack), CopyOrMoveHelper.INSTANCE.isMoveEnabled(state.getItemsToCopy(), stack, state.getOriginFolderId()), CopyOrMoveHelper.INSTANCE.isCreateFolderEnabled((ItemsListReducer.State) CollectionsKt.last((List) stack)), 23, null);
    }
}
