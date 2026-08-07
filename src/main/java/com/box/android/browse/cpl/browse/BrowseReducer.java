package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.NestedViewState;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducerKt;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.common.utilities.CPLExtensionsKt;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.cpl.reducers.RecursiveReducer;
import com.box.android.data.CreateFolderMutation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.models.observability.FolderNavApdex;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u001f !\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006#"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "environment", "Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceBrowse", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceCreateFolder", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CreateFolderChildAction;", "reduceChildActionableItemsList", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildActionableItemsListAction;", "reduceChildItemsList", "actionableItemAction", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "reduceChildBrowse", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildBrowseAction;", "reduceNavigateToFolder", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$NavigateToFolder;", "reduceTabVisible", "createNavigation", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "Route", "State", "FeatureBannerActionData", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final BrowseEnvironment environment;

    public BrowseReducer(BrowseEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new BrowseReducer$build$1(this));
        final BrowseReducer$build$2 browseReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BrowseReducer.State) obj).getActionableItemsListState();
            }
        };
        final BrowseReducer$build$3 browseReducer$build$3 = BrowseReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new ActionableItemsListReducer(environment.getActionableItemsListEnvironment()), new Function1<State, ActionableItemsListReducer.State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.State invoke(BrowseReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return browseReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ActionableItemsListReducer.Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(BrowseReducer.Action action) {
                if (!(action instanceof BrowseReducer.Action.ChildActionableItemsListAction)) {
                    action = null;
                }
                BrowseReducer.Action.ChildActionableItemsListAction childActionableItemsListAction = (BrowseReducer.Action.ChildActionableItemsListAction) action;
                if (childActionableItemsListAction != null) {
                    return childActionableItemsListAction.getRecentsAction();
                }
                return null;
            }
        }, new Function2<State, ActionableItemsListReducer.State, State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BrowseReducer.State invoke(BrowseReducer.State parentState, ActionableItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = browseReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BrowseReducer.State.class)).iterator();
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
                            return (BrowseReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ActionableItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(ActionableItemsListReducer.Action action) {
                Object objInvoke = browseReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (BrowseReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.Action");
            }
        });
        final BrowseReducer$build$5 browseReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BrowseReducer.State) obj).getCreateFolderState();
            }
        };
        final BrowseReducer$build$6 browseReducer$build$6 = BrowseReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new CreateFolderReducer(environment.getCreateFolderEnvironment()), new Function1<State, CreateFolderReducer.State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.createfolder.CreateFolderReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.State invoke(BrowseReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return browseReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CreateFolderReducer.Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.Action invoke(BrowseReducer.Action action) {
                if (!(action instanceof BrowseReducer.Action.CreateFolderChildAction)) {
                    action = null;
                }
                BrowseReducer.Action.CreateFolderChildAction createFolderChildAction = (BrowseReducer.Action.CreateFolderChildAction) action;
                if (createFolderChildAction != null) {
                    return createFolderChildAction.getRecentsAction();
                }
                return null;
            }
        }, new Function2<State, CreateFolderReducer.State, State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BrowseReducer.State invoke(BrowseReducer.State parentState, CreateFolderReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = browseReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BrowseReducer.State.class)).iterator();
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
                            return (BrowseReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateFolderReducer.Action, Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(CreateFolderReducer.Action action) {
                Object objInvoke = browseReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (BrowseReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.Action");
            }
        });
        final BrowseReducer$build$8 browseReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BrowseReducer.State) obj).getFabMenuState();
            }
        };
        final BrowseReducer$build$9 browseReducer$build$9 = BrowseReducer$build$9.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new FilesFabReducer(environment.getFabEnvironment()), new Function1<State, FilesFabReducer.State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.browse.fab.FilesFabReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final FilesFabReducer.State invoke(BrowseReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return browseReducer$build$8.invoke(it);
            }
        }, new Function1<Action, FilesFabReducer.Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final FilesFabReducer.Action invoke(BrowseReducer.Action action) {
                if (!(action instanceof BrowseReducer.Action.FabMenuChildAction)) {
                    action = null;
                }
                BrowseReducer.Action.FabMenuChildAction fabMenuChildAction = (BrowseReducer.Action.FabMenuChildAction) action;
                if (fabMenuChildAction != null) {
                    return fabMenuChildAction.getRecentsAction();
                }
                return null;
            }
        }, new Function2<State, FilesFabReducer.State, State>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final BrowseReducer.State invoke(BrowseReducer.State parentState, FilesFabReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = browseReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(BrowseReducer.State.class)).iterator();
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
                            return (BrowseReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<FilesFabReducer.Action, Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(FilesFabReducer.Action action) {
                Object objInvoke = browseReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (BrowseReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.Action");
            }
        });
        Function1 function1 = new Function1() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseReducer.build$lambda$3((BrowseReducer.State) obj);
            }
        };
        Function2 function2 = new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseReducer.build$lambda$4((BrowseReducer.State) obj, (BrowseReducer.State) obj2);
            }
        };
        final BrowseReducer$build$13 browseReducer$build$13 = BrowseReducer$build$13.INSTANCE;
        this.build = new RecursiveReducer(ifLetReducer3, function1, new Function1<Action, Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$recursive$1
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(BrowseReducer.Action action) {
                if (!(action instanceof BrowseReducer.Action.ChildBrowseAction)) {
                    action = null;
                }
                BrowseReducer.Action.ChildBrowseAction childBrowseAction = (BrowseReducer.Action.ChildBrowseAction) action;
                if (childBrowseAction != null) {
                    return childBrowseAction.getRecentsAction();
                }
                return null;
            }
        }, function2, new Function1<Action, Action>() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$special$$inlined$recursive$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(BrowseReducer.Action action) {
                Object objInvoke = browseReducer$build$13.invoke(action);
                if (objInvoke != null) {
                    return (BrowseReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "", "<init>", "()V", "Folder", "File", "WebLink", "FeatureBanner", "ItemAction", "InviteCollaborators", "None", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$FeatureBanner;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$File;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$Folder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$InviteCollaborators;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$None;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$WebLink;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$Folder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "state", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;)V", "getState", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends Route implements Embedded<State> {
            public static final int $stable = 8;
            private final State state;

            public static /* synthetic */ Folder copy$default(Folder folder, State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = folder.state;
                }
                return folder.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final State getRecentsAction() {
                return this.state;
            }

            public final Folder copy(State state) {
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
            public Folder(State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final State getState() {
                return this.state;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$File;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/FileModel;", "file", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final FileModel getRecentsAction() {
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

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$WebLink;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/WebLinkModel;", "file", "<init>", "(Lcom/box/android/domain/models/item/WebLinkModel;)V", "getFile", "()Lcom/box/android/domain/models/item/WebLinkModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WebLink extends Route implements Embedded<WebLinkModel> {
            public static final int $stable = 8;
            private final WebLinkModel file;

            public static /* synthetic */ WebLink copy$default(WebLink webLink, WebLinkModel webLinkModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    webLinkModel = webLink.file;
                }
                return webLink.copy(webLinkModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WebLinkModel getRecentsAction() {
                return this.file;
            }

            public final WebLink copy(WebLinkModel file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new WebLink(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof WebLink) && Intrinsics.areEqual(this.file, ((WebLink) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "WebLink(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WebLink(WebLinkModel file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final WebLinkModel getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$FeatureBanner;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;", "data", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;)V", "getData", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeatureBanner extends Route implements Embedded<FeatureBannerActionData> {
            public static final int $stable = 0;
            private final FeatureBannerActionData data;

            public static /* synthetic */ FeatureBanner copy$default(FeatureBanner featureBanner, FeatureBannerActionData featureBannerActionData, int i, Object obj) {
                if ((i & 1) != 0) {
                    featureBannerActionData = featureBanner.data;
                }
                return featureBanner.copy(featureBannerActionData);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FeatureBannerActionData getRecentsAction() {
                return this.data;
            }

            public final FeatureBanner copy(FeatureBannerActionData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new FeatureBanner(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureBanner) && Intrinsics.areEqual(this.data, ((FeatureBanner) other).data);
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "FeatureBanner(data=" + this.data + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureBanner(FeatureBannerActionData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public final FeatureBannerActionData getData() {
                return this.data;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "route", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;)V", "getRoute", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final ActionableItemsListReducer.Route getRecentsAction() {
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

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$InviteCollaborators;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/FolderModel;", "folder", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InviteCollaborators extends Route implements Embedded<FolderModel> {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ InviteCollaborators copy$default(InviteCollaborators inviteCollaborators, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = inviteCollaborators.folder;
                }
                return inviteCollaborators.copy(folderModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getRecentsAction() {
                return this.folder;
            }

            public final InviteCollaborators copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new InviteCollaborators(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InviteCollaborators) && Intrinsics.areEqual(this.folder, ((InviteCollaborators) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "InviteCollaborators(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InviteCollaborators(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$None;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends Route {
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
                return 710579657;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00063"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/NestedViewState;", "actionableItemsListState", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "navigationRoute", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "createFolderState", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "folderInitialized", "", "fabMenuState", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;ZLcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;)V", "getActionableItemsListState", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "getNavigationRoute", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", "getCreateFolderState", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "getFolderInitialized", "()Z", "getFabMenuState", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;", "currentlyVisibleBrowse", "getCurrentlyVisibleBrowse", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "currentlyVisibleBrowse$delegate", "Lkotlin/Lazy;", "currentlyVisibleFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getCurrentlyVisibleFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "currentlyVisibleFolder$delegate", "currentFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "getCurrentFolderId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State extends NestedViewState {
        public static final int $stable = 8;
        private final ActionableItemsListReducer.State actionableItemsListState;
        private final CreateFolderReducer.State createFolderState;
        private final ItemId.Remote currentFolderId;

        /* JADX INFO: renamed from: currentlyVisibleBrowse$delegate, reason: from kotlin metadata */
        private final Lazy currentlyVisibleBrowse;

        /* JADX INFO: renamed from: currentlyVisibleFolder$delegate, reason: from kotlin metadata */
        private final Lazy currentlyVisibleFolder;
        private final FilesFabReducer.State fabMenuState;
        private final boolean folderInitialized;
        private final Route navigationRoute;

        public static /* synthetic */ State copy$default(State state, ActionableItemsListReducer.State state2, Route route, CreateFolderReducer.State state3, boolean z, FilesFabReducer.State state4, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.actionableItemsListState;
            }
            if ((i & 2) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 4) != 0) {
                state3 = state.createFolderState;
            }
            if ((i & 8) != 0) {
                z = state.folderInitialized;
            }
            if ((i & 16) != 0) {
                state4 = state.fabMenuState;
            }
            FilesFabReducer.State state5 = state4;
            CreateFolderReducer.State state6 = state3;
            return state.copy(state2, route, state6, z, state5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getFolderInitialized() {
            return this.folderInitialized;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FilesFabReducer.State getFabMenuState() {
            return this.fabMenuState;
        }

        public final State copy(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, CreateFolderReducer.State createFolderState, boolean folderInitialized, FilesFabReducer.State fabMenuState) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            return new State(actionableItemsListState, navigationRoute, createFolderState, folderInitialized, fabMenuState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.actionableItemsListState, state.actionableItemsListState) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.createFolderState, state.createFolderState) && this.folderInitialized == state.folderInitialized && Intrinsics.areEqual(this.fabMenuState, state.fabMenuState);
        }

        public int hashCode() {
            int iHashCode = ((this.actionableItemsListState.hashCode() * 31) + this.navigationRoute.hashCode()) * 31;
            CreateFolderReducer.State state = this.createFolderState;
            int iHashCode2 = (((iHashCode + (state == null ? 0 : state.hashCode())) * 31) + Boolean.hashCode(this.folderInitialized)) * 31;
            FilesFabReducer.State state2 = this.fabMenuState;
            return iHashCode2 + (state2 != null ? state2.hashCode() : 0);
        }

        public String toString() {
            return "State(actionableItemsListState=" + this.actionableItemsListState + ", navigationRoute=" + this.navigationRoute + ", createFolderState=" + this.createFolderState + ", folderInitialized=" + this.folderInitialized + ", fabMenuState=" + this.fabMenuState + ")";
        }

        public State(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, CreateFolderReducer.State state, boolean z, FilesFabReducer.State state2) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            this.actionableItemsListState = actionableItemsListState;
            this.navigationRoute = navigationRoute;
            this.createFolderState = state;
            this.folderInitialized = z;
            this.fabMenuState = state2;
            this.currentlyVisibleBrowse = LazyKt.lazy(new Function0() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$State$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseReducer.State.currentlyVisibleBrowse_delegate$lambda$0(this.f$0);
                }
            });
            this.currentlyVisibleFolder = LazyKt.lazy(new Function0() { // from class: com.box.android.browse.cpl.browse.BrowseReducer$State$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseReducer.State.currentlyVisibleFolder_delegate$lambda$0(this.f$0);
                }
            });
            this.currentFolderId = ItemModelKt.toItemIdRemoteId(actionableItemsListState.getItemsListViewState().getCurrentFolder());
        }

        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        public /* synthetic */ State(ActionableItemsListReducer.State state, Route.None none, CreateFolderReducer.State state2, boolean z, FilesFabReducer.State state3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, (i & 2) != 0 ? Route.None.INSTANCE : none, (i & 4) != 0 ? null : state2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : state3);
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        public final boolean getFolderInitialized() {
            return this.folderInitialized;
        }

        public final FilesFabReducer.State getFabMenuState() {
            return this.fabMenuState;
        }

        public final State getCurrentlyVisibleBrowse() {
            return (State) this.currentlyVisibleBrowse.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final State currentlyVisibleBrowse_delegate$lambda$0(State state) {
            while (true) {
                Route route = state.navigationRoute;
                if (!(route instanceof Route.Folder)) {
                    return state;
                }
                Intrinsics.checkNotNull(route, "null cannot be cast to non-null type com.box.android.browse.cpl.browse.BrowseReducer.Route.Folder");
                state = ((Route.Folder) route).getState();
            }
        }

        public final FolderModel getCurrentlyVisibleFolder() {
            return (FolderModel) this.currentlyVisibleFolder.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FolderModel currentlyVisibleFolder_delegate$lambda$0(State state) {
            return state.getCurrentlyVisibleBrowse().actionableItemsListState.getCurrentFolder();
        }

        public final ItemId.Remote getCurrentFolderId() {
            return this.currentFolderId;
        }
    }

    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;", "", HubsObservability.HUB_ASSET_BANNER, "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "folderId", "", "<init>", "(Lcom/box/android/browse/utilities/BoxFeatureBanner;Ljava/lang/String;)V", "getBanner", "()Lcom/box/android/browse/utilities/BoxFeatureBanner;", "getFolderId", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FeatureBannerActionData {
        public static final int $stable = 0;
        private final BoxFeatureBanner banner;
        private final String folderId;

        public static /* synthetic */ FeatureBannerActionData copy$default(FeatureBannerActionData featureBannerActionData, BoxFeatureBanner boxFeatureBanner, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                boxFeatureBanner = featureBannerActionData.banner;
            }
            if ((i & 2) != 0) {
                str = featureBannerActionData.folderId;
            }
            return featureBannerActionData.copy(boxFeatureBanner, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BoxFeatureBanner getBanner() {
            return this.banner;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFolderId() {
            return this.folderId;
        }

        public final FeatureBannerActionData copy(BoxFeatureBanner banner, String folderId) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            return new FeatureBannerActionData(banner, folderId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureBannerActionData)) {
                return false;
            }
            FeatureBannerActionData featureBannerActionData = (FeatureBannerActionData) other;
            return this.banner == featureBannerActionData.banner && Intrinsics.areEqual(this.folderId, featureBannerActionData.folderId);
        }

        public int hashCode() {
            return (this.banner.hashCode() * 31) + this.folderId.hashCode();
        }

        public String toString() {
            return "FeatureBannerActionData(banner=" + this.banner + ", folderId=" + this.folderId + ")";
        }

        public FeatureBannerActionData(BoxFeatureBanner banner, String folderId) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            this.banner = banner;
            this.folderId = folderId;
        }

        public final BoxFeatureBanner getBanner() {
            return this.banner;
        }

        public final String getFolderId() {
            return this.folderId;
        }
    }

    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0011\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%¨\u0006&"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "", "<init>", "()V", "LoadItems", "TabVisible", "CloseScreen", "ChildScreenClosed", "ChildActionableItemsListAction", "ChildBrowseAction", "NavigateToFolder", "ShowFolderActions", "InitializeFolder", "FolderFetched", "FolderDeleted", "SortPreferencesChanged", CreateFolderMutation.OPERATION_NAME, "CreateFolderChildAction", "NavigationCompleted", "FabMenuChildAction", "ChangeFabVisibility", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChangeFabVisibility;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildBrowseAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildScreenClosed;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CloseScreen;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CreateFolderChildAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FabMenuChildAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FolderDeleted;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FolderFetched;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$InitializeFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$NavigateToFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ShowFolderActions;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$SortPreferencesChanged;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$TabVisible;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1335935602;
            }

            public String toString() {
                return "LoadItems";
            }

            private LoadItems() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$TabVisible;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabVisible extends Action {
            public static final int $stable = 0;
            public static final TabVisible INSTANCE = new TabVisible();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TabVisible)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1678868855;
            }

            public String toString() {
                return "TabVisible";
            }

            private TabVisible() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CloseScreen;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1085036904;
            }

            public String toString() {
                return "CloseScreen";
            }

            private CloseScreen() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildScreenClosed;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChildScreenClosed extends Action {
            public static final int $stable = 0;
            public static final ChildScreenClosed INSTANCE = new ChildScreenClosed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChildScreenClosed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 598582088;
            }

            public String toString() {
                return "ChildScreenClosed";
            }

            private ChildScreenClosed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final ActionableItemsListReducer.Action getRecentsAction() {
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

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChildBrowseAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "Lcom/box/android/cpl/Embedded;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChildBrowseAction extends Action implements Embedded<Action> {
            public static final int $stable = 0;
            private final Action action;

            public static /* synthetic */ ChildBrowseAction copy$default(ChildBrowseAction childBrowseAction, Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = childBrowseAction.action;
                }
                return childBrowseAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Action getRecentsAction() {
                return this.action;
            }

            public final ChildBrowseAction copy(Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ChildBrowseAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChildBrowseAction) && Intrinsics.areEqual(this.action, ((ChildBrowseAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ChildBrowseAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChildBrowseAction(Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$NavigateToFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToFolder extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ NavigateToFolder copy$default(NavigateToFolder navigateToFolder, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = navigateToFolder.folder;
                }
                return navigateToFolder.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final NavigateToFolder copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new NavigateToFolder(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToFolder) && Intrinsics.areEqual(this.folder, ((NavigateToFolder) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "NavigateToFolder(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToFolder(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ShowFolderActions;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowFolderActions extends Action {
            public static final int $stable = 0;
            public static final ShowFolderActions INSTANCE = new ShowFolderActions();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFolderActions)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -216990778;
            }

            public String toString() {
                return "ShowFolderActions";
            }

            private ShowFolderActions() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$InitializeFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "closeOnFailure", "", "<init>", "(Z)V", "getCloseOnFailure", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitializeFolder extends Action {
            public static final int $stable = 0;
            private final boolean closeOnFailure;

            public static /* synthetic */ InitializeFolder copy$default(InitializeFolder initializeFolder, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = initializeFolder.closeOnFailure;
                }
                return initializeFolder.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getCloseOnFailure() {
                return this.closeOnFailure;
            }

            public final InitializeFolder copy(boolean closeOnFailure) {
                return new InitializeFolder(closeOnFailure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InitializeFolder) && this.closeOnFailure == ((InitializeFolder) other).closeOnFailure;
            }

            public int hashCode() {
                return Boolean.hashCode(this.closeOnFailure);
            }

            public String toString() {
                return "InitializeFolder(closeOnFailure=" + this.closeOnFailure + ")";
            }

            public InitializeFolder(boolean z) {
                super(null);
                this.closeOnFailure = z;
            }

            public final boolean getCloseOnFailure() {
                return this.closeOnFailure;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FolderFetched;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderFetched extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ FolderFetched copy$default(FolderFetched folderFetched, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = folderFetched.folder;
                }
                return folderFetched.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final FolderFetched copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new FolderFetched(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderFetched) && Intrinsics.areEqual(this.folder, ((FolderFetched) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "FolderFetched(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderFetched(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FolderDeleted;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;)V", "getFolderId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderDeleted extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote folderId;

            public static /* synthetic */ FolderDeleted copy$default(FolderDeleted folderDeleted, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = folderDeleted.folderId;
                }
                return folderDeleted.copy(remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getFolderId() {
                return this.folderId;
            }

            public final FolderDeleted copy(ItemId.Remote folderId) {
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                return new FolderDeleted(folderId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderDeleted) && Intrinsics.areEqual(this.folderId, ((FolderDeleted) other).folderId);
            }

            public int hashCode() {
                return this.folderId.hashCode();
            }

            public String toString() {
                return "FolderDeleted(folderId=" + this.folderId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderDeleted(ItemId.Remote folderId) {
                super(null);
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                this.folderId = folderId;
            }

            public final ItemId.Remote getFolderId() {
                return this.folderId;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$SortPreferencesChanged;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SortPreferencesChanged extends Action {
            public static final int $stable = 0;
            public static final SortPreferencesChanged INSTANCE = new SortPreferencesChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SortPreferencesChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2010296250;
            }

            public String toString() {
                return "SortPreferencesChanged";
            }

            private SortPreferencesChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1301104886;
            }

            public String toString() {
                return CreateFolderMutation.OPERATION_NAME;
            }

            private CreateFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$CreateFolderChildAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateFolderChildAction extends Action implements Embedded<CreateFolderReducer.Action> {
            public static final int $stable = 0;
            private final CreateFolderReducer.Action action;

            public static /* synthetic */ CreateFolderChildAction copy$default(CreateFolderChildAction createFolderChildAction, CreateFolderReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = createFolderChildAction.action;
                }
                return createFolderChildAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CreateFolderReducer.Action getRecentsAction() {
                return this.action;
            }

            public final CreateFolderChildAction copy(CreateFolderReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CreateFolderChildAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateFolderChildAction) && Intrinsics.areEqual(this.action, ((CreateFolderChildAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CreateFolderChildAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateFolderChildAction(CreateFolderReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CreateFolderReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1663780011;
            }

            public String toString() {
                return "NavigationCompleted";
            }

            private NavigationCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$FabMenuChildAction;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FabMenuChildAction extends Action implements Embedded<FilesFabReducer.Action> {
            public static final int $stable = 0;
            private final FilesFabReducer.Action action;

            public static /* synthetic */ FabMenuChildAction copy$default(FabMenuChildAction fabMenuChildAction, FilesFabReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = fabMenuChildAction.action;
                }
                return fabMenuChildAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesFabReducer.Action getRecentsAction() {
                return this.action;
            }

            public final FabMenuChildAction copy(FilesFabReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FabMenuChildAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FabMenuChildAction) && Intrinsics.areEqual(this.action, ((FabMenuChildAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FabMenuChildAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FabMenuChildAction(FilesFabReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FilesFabReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: BrowseReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseReducer$Action$ChangeFabVisibility;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "newIsVisible", "", "<init>", "(Z)V", "getNewIsVisible", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChangeFabVisibility extends Action {
            public static final int $stable = 0;
            private final boolean newIsVisible;

            public static /* synthetic */ ChangeFabVisibility copy$default(ChangeFabVisibility changeFabVisibility, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = changeFabVisibility.newIsVisible;
                }
                return changeFabVisibility.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getNewIsVisible() {
                return this.newIsVisible;
            }

            public final ChangeFabVisibility copy(boolean newIsVisible) {
                return new ChangeFabVisibility(newIsVisible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeFabVisibility) && this.newIsVisible == ((ChangeFabVisibility) other).newIsVisible;
            }

            public int hashCode() {
                return Boolean.hashCode(this.newIsVisible);
            }

            public String toString() {
                return "ChangeFabVisibility(newIsVisible=" + this.newIsVisible + ")";
            }

            public ChangeFabVisibility(boolean z) {
                super(null);
                this.newIsVisible = z;
            }

            public final boolean getNewIsVisible() {
                return this.newIsVisible;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State build$lambda$3(State globalState) {
        Intrinsics.checkNotNullParameter(globalState, "globalState");
        Route navigationRoute = globalState.getNavigationRoute();
        Route.Folder folder = navigationRoute instanceof Route.Folder ? (Route.Folder) navigationRoute : null;
        if (folder != null) {
            return folder.getState();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State build$lambda$4(State globalState, State childState) {
        Intrinsics.checkNotNullParameter(globalState, "globalState");
        Intrinsics.checkNotNullParameter(childState, "childState");
        return State.copy$default(globalState, null, new Route.Folder(childState), null, false, null, 29, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceBrowse(State state, Action action) {
        Effect effectNone;
        if (action instanceof Action.TabVisible) {
            return reduceTabVisible(state);
        }
        if (action instanceof Action.LoadItems) {
            return new ReducerResult<>(state, new Effect(new Action.ChildActionableItemsListAction(ActionableItemsListReducerKt.loadItems(ActionableItemsListReducer.Action.INSTANCE))));
        }
        if (action instanceof Action.InitializeFolder) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, action, null))));
        }
        if (action instanceof Action.FolderFetched) {
            Action.FolderFetched folderFetched = (Action.FolderFetched) action;
            State stateCopy$default = State.copy$default(state, ActionableItemsListReducer.State.copy$default(state.getActionableItemsListState(), ItemsListReducer.State.copy$default(state.getActionableItemsListState().getItemsListViewState(), null, null, null, folderFetched.getFolder(), false, null, null, false, null, null, null, null, null, null, false, false, 65527, null), null, null, null, null, null, null, null, null, 510, null), null, null, true, null, 22, null);
            if (state.getFabMenuState() != null) {
                effectNone = new Effect(new Action.FabMenuChildAction(new FilesFabReducer.Action.Initialize(folderFetched.getFolder())));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(stateCopy$default, effectNone);
        }
        if (action instanceof Action.ChildScreenClosed) {
            return new ReducerResult<>(state, new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.FetchItems.INSTANCE))));
        }
        if (action instanceof Action.ShowFolderActions) {
            return new ReducerResult<>(state, new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ShowMoreActionsMenu(state.getCurrentlyVisibleFolder()))));
        }
        if (action instanceof Action.FolderDeleted) {
            if (Intrinsics.areEqual(((Action.FolderDeleted) action).getFolderId(), state.getCurrentFolderId())) {
                return new ReducerResult<>(state, new Effect(Action.CloseScreen.INSTANCE));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.CloseScreen) {
            return new ReducerResult<>(state, CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey())));
        }
        if (action instanceof Action.ChildBrowseAction) {
            return reduceChildBrowse((Action.ChildBrowseAction) action, state);
        }
        if (action instanceof Action.ChildActionableItemsListAction) {
            return reduceChildActionableItemsList((Action.ChildActionableItemsListAction) action, state);
        }
        if (action instanceof Action.NavigateToFolder) {
            return reduceNavigateToFolder((Action.NavigateToFolder) action, state);
        }
        if (action instanceof Action.SortPreferencesChanged) {
            return new ReducerResult<>(state, new Effect(new Action.ChildActionableItemsListAction(ActionableItemsListReducerKt.loadItems(ActionableItemsListReducer.Action.INSTANCE))));
        }
        if (action instanceof Action.CreateFolder) {
            if (Intrinsics.areEqual(state.getNavigationRoute(), Route.None.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, null, null, new CreateFolderReducer.State("", state.getCurrentFolderId(), null, null, false, false, false, 60, null), false, null, 27, null), null, 2, null);
            }
            return new ReducerResult<>(state, new Effect(new Action.ChildBrowseAction(action)));
        }
        if (action instanceof Action.ChangeFabVisibility) {
            if (Intrinsics.areEqual(state.getNavigationRoute(), Route.None.INSTANCE)) {
                return new ReducerResult<>(state, new Effect(new Action.FabMenuChildAction(new FilesFabReducer.Action.ChangeFabVisibility(((Action.ChangeFabVisibility) action).getNewIsVisible()))));
            }
            return new ReducerResult<>(state, new Effect(new Action.ChildBrowseAction(action)));
        }
        if (action instanceof Action.CreateFolderChildAction) {
            return reduceCreateFolder((Action.CreateFolderChildAction) action, state);
        }
        if (Intrinsics.areEqual(action, Action.NavigationCompleted.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, null, false, null, 29, null), null, 2, null);
        }
        if (action instanceof Action.FabMenuChildAction) {
            return ((Action.FabMenuChildAction) action).getAction() instanceof FilesFabReducer.Action.CreateNewFolder ? new ReducerResult<>(state, new Effect(Action.CreateFolder.INSTANCE)) : new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.BrowseReducer$reduceBrowse$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.BrowseReducer$reduceBrowse$1", f = "BrowseReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {JfifUtil.MARKER_EOI, 220, 223}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-BrowseReducer$reduceBrowse$1$1", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-BrowseReducer$reduceBrowse$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Action action, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BrowseReducer.this.new AnonymousClass1(this.$state, this.$action, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x009c  */
        /* JADX WARN: Code duplicated, block: B:26:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:31:0x00ce  */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cb, code lost:
        
            if (r0.emit(r9, r8) == r1) goto L30;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.browse.BrowseReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> reduceCreateFolder(Action.CreateFolderChildAction action, State state) {
        Route.InviteCollaborators navigationRoute;
        CreateFolderReducer.Action action2 = action.getAction();
        if (action2 instanceof CreateFolderReducer.Action.FolderCreationCancelled) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, 27, null), null, 2, null);
        }
        if (action2 instanceof CreateFolderReducer.Action.FolderCreated) {
            CreateFolderReducer.State createFolderState = state.getCreateFolderState();
            boolean zAreEqual = createFolderState != null ? Intrinsics.areEqual((Object) createFolderState.getInviteCollaborators(), (Object) true) : false;
            if (zAreEqual) {
                navigationRoute = new Route.InviteCollaborators(((CreateFolderReducer.Action.FolderCreated) action.getAction()).getFolder());
            } else {
                navigationRoute = state.getNavigationRoute();
            }
            return new ReducerResult<>(State.copy$default(state, null, navigationRoute, null, false, null, 25, null), Effect.INSTANCE.fireAndForget(new C09441(zAreEqual, this, null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.BrowseReducer$reduceCreateFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.BrowseReducer$reduceCreateFolder$1", f = "BrowseReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09441 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isInviteCollaboratorsChecked;
        int label;
        final /* synthetic */ BrowseReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09441(boolean z, BrowseReducer browseReducer, Continuation<? super C09441> continuation) {
            super(1, continuation);
            this.$isInviteCollaboratorsChecked = z;
            this.this$0 = browseReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09441(this.$isInviteCollaboratorsChecked, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09441) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!this.$isInviteCollaboratorsChecked) {
                this.this$0.environment.getCreateFolderEnvironment().getCreateFolderHelper().displayFolderCreatedSuccessfullyToast();
            }
            this.this$0.environment.getCreateFolderEnvironment().getCreateFolderHelper().sendCreateFolderSucceededAmplitudeEvent();
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceChildActionableItemsList(Action.ChildActionableItemsListAction action, State state) {
        ActionableItemsListReducer.Action action2 = action.getAction();
        if (action2 instanceof ActionableItemsListReducer.Action.ItemsListAction) {
            return reduceChildItemsList((ActionableItemsListReducer.Action.ItemsListAction) action2, state);
        }
        if (action2 instanceof ActionableItemsListReducer.Action.NavigateTo) {
            return new ReducerResult<>(State.copy$default(state, null, new Route.ItemAction(((ActionableItemsListReducer.Action.NavigateTo) action2).getRoute()), null, false, null, 29, null), null, 2, null);
        }
        if ((action2 instanceof ActionableItemsListReducer.Action.NavigationCompleted) || (action2 instanceof ActionableItemsListReducer.Action.ExitMultiselectMode)) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, null, false, null, 29, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceChildItemsList(ActionableItemsListReducer.Action.ItemsListAction actionableItemAction, State state) {
        ItemsListReducer.Action itemsListViewAction = actionableItemAction.getItemsListViewAction();
        if (itemsListViewAction instanceof ItemsListReducer.Action.OpenItem) {
            return new ReducerResult<>(State.copy$default(state, null, createNavigation(state.getActionableItemsListState().getItemsListViewState().getItem(((ItemsListReducer.Action.OpenItem) itemsListViewAction).getId()), state), null, false, null, 29, null), CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey())));
        }
        if (itemsListViewAction instanceof ItemsListReducer.Action.FeatureBannerClicked) {
            return new ReducerResult<>(State.copy$default(state, null, new Route.FeatureBanner(new FeatureBannerActionData(((ItemsListReducer.Action.FeatureBannerClicked) itemsListViewAction).getBanner(), state.getCurrentFolderId().getBoxId())), null, false, null, 29, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceChildBrowse(Action.ChildBrowseAction action, State state) {
        Action action2 = action.getAction();
        if (action2 instanceof Action.CloseScreen) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, null, false, null, 29, null), Effect.INSTANCE.merge(CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey())), new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.FetchItems.INSTANCE))), new Effect(new Action.InitializeFolder(true))));
        }
        if (action2 instanceof Action.SortPreferencesChanged) {
            return new ReducerResult<>(state, new Effect(Action.SortPreferencesChanged.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceNavigateToFolder(Action.NavigateToFolder action, State state) {
        if (Intrinsics.areEqual(state.getNavigationRoute(), Route.None.INSTANCE) && !Intrinsics.areEqual(action.getFolder().getItemId(), state.getCurrentFolderId())) {
            return new ReducerResult<>(State.copy$default(state, null, createNavigation(action.getFolder(), state), null, false, null, 29, null), Effect.INSTANCE.merge(CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getActionableItemsListState().getItemsListViewState().getUniqueCancelEffectKey())), Effect.INSTANCE.fireAndForget(new C09451(action, this, null))));
        }
        return new ReducerResult<>(state, new Effect(new Action.ChildBrowseAction(action)));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.BrowseReducer$reduceNavigateToFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.BrowseReducer$reduceNavigateToFolder$1", f = "BrowseReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09451 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.NavigateToFolder $action;
        int label;
        final /* synthetic */ BrowseReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09451(Action.NavigateToFolder navigateToFolder, BrowseReducer browseReducer, Continuation<? super C09451> continuation) {
            super(1, continuation);
            this.$action = navigateToFolder;
            this.this$0 = browseReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09451(this.$action, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09451) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String strBoxIdOrNull = this.$action.getFolder().boxIdOrNull();
            if (strBoxIdOrNull != null) {
                this.this$0.environment.getApdexService().startTracker(FolderNavApdex.INSTANCE, strBoxIdOrNull);
            }
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceTabVisible(State state) {
        return new ReducerResult<>(state, Effect.INSTANCE.merge(new Effect(Action.LoadItems.INSTANCE), new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Route createNavigation(ItemModel itemModel, State state) {
        FilesFabReducer.State state2;
        if (itemModel instanceof FolderModel) {
            ItemsListReducer.State itemsListViewState = state.getActionableItemsListState().getItemsListViewState();
            FolderModel folderModel = (FolderModel) itemModel;
            Object[] objArr = 0 == true ? 1 : 0;
            ActionableItemsListReducer.State state3 = new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, folderModel, itemsListViewState.getShouldDisableNonFolderItems(), itemsListViewState.getDisabledItems(), itemsListViewState.getFeatureBanner(), itemsListViewState.getDisplayFeatureBanner(), null, null, null, null, null, null, itemsListViewState.getAllowLegacyCache(), false, 48903, null), null, objArr, state.getActionableItemsListState().getBottomSheetAvailableActions(), null, null, null, null, 0 == true ? 1 : 0, 502, 0 == true ? 1 : 0);
            if (state.getFabMenuState() != null) {
                state2 = new FilesFabReducer.State(folderModel, false, false, null, false, false, false, null, null, 510, null);
            } else {
                state2 = null;
            }
            return new Route.Folder(new State(state3, null, null, false, state2, 14, null));
        }
        if (itemModel instanceof FileModel) {
            return new Route.File((FileModel) itemModel);
        }
        return itemModel instanceof WebLinkModel ? new Route.WebLink((WebLinkModel) itemModel) : state.getNavigationRoute();
    }
}
