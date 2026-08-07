package com.box.android.cpl.mainphone;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.browse.cpl.NestedViewState;
import com.box.android.browse.cpl.None;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.ISessionManager;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: MainPhoneReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\u0012\u0013\u0014\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "environment", "Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;", "<init>", "(Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceMainPhone", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "refreshHierarchy", "reduceBrowse", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "State", "MoreOptionsMenuState", "Action", "HierarchyModel", "HierarchyModelType", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneReducer implements Reducable<State, Action> {
    public static final String BROWSE_INITIAL_COLLECTION_ID = "browse_initial_collection_id";
    public static final String BROWSE_INITIAL_FOLDER_ID = "browse_initial_folder_id";
    public static final String BROWSE_INITIAL_FOLDER_NAME = "browse_initial_folder_name";
    private static final String REFRESH_HIERARCHY_ID = "REFRESH_HIERARCHY_ID";
    private final Reducable<State, Action> build;
    private final MainPhoneEnvironment environment;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModelType;", "", "<init>", "(Ljava/lang/String;I)V", "FOLDER", "COLLECTION", "MY_COLLECTIONS", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum HierarchyModelType {
        FOLDER,
        COLLECTION,
        MY_COLLECTIONS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<HierarchyModelType> getEntries() {
            return $ENTRIES;
        }
    }

    public MainPhoneReducer(MainPhoneEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new MainPhoneReducer$build$1(this));
        final MainPhoneReducer$build$2 mainPhoneReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((MainPhoneReducer.State) obj).getNestedViewState();
            }
        };
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CollectionReducer.State.class);
        final MainPhoneReducer$build$3 mainPhoneReducer$build$3 = MainPhoneReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new CollectionReducer(environment.getBrowseEnvironment()), new Function1<State, CollectionReducer.State>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.browse.cpl.CollectionReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CollectionReducer.State invoke(MainPhoneReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass, mainPhoneReducer$build$2.invoke(it));
            }
        }, new Function1<Action, CollectionReducer.Action>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final CollectionReducer.Action invoke(MainPhoneReducer.Action action) {
                if (!(action instanceof MainPhoneReducer.Action.CollectionAction)) {
                    action = null;
                }
                MainPhoneReducer.Action.CollectionAction collectionAction = (MainPhoneReducer.Action.CollectionAction) action;
                if (collectionAction != null) {
                    return collectionAction.getState();
                }
                return null;
            }
        }, new Function2<State, CollectionReducer.State, State>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final MainPhoneReducer.State invoke(MainPhoneReducer.State parentState, CollectionReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = mainPhoneReducer$build$2;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(MainPhoneReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (MainPhoneReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.mainphone.MainPhoneReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CollectionReducer.Action, Action>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MainPhoneReducer.Action invoke(CollectionReducer.Action action) {
                Object objInvoke = mainPhoneReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (MainPhoneReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.mainphone.MainPhoneReducer.Action");
            }
        });
        final MainPhoneReducer$build$5 mainPhoneReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((MainPhoneReducer.State) obj).getNestedViewState();
            }
        };
        final KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(BrowseReducer.State.class);
        final MainPhoneReducer$build$6 mainPhoneReducer$build$6 = MainPhoneReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new BrowseReducer(environment.getBrowseEnvironment()), new Function1<State, BrowseReducer.State>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.browse.cpl.browse.BrowseReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.State invoke(MainPhoneReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KClasses.safeCast(orCreateKotlinClass2, mainPhoneReducer$build$5.invoke(it));
            }
        }, new Function1<Action, BrowseReducer.Action>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(MainPhoneReducer.Action action) {
                if (!(action instanceof MainPhoneReducer.Action.BrowseNestedAction)) {
                    action = null;
                }
                MainPhoneReducer.Action.BrowseNestedAction browseNestedAction = (MainPhoneReducer.Action.BrowseNestedAction) action;
                if (browseNestedAction != null) {
                    return browseNestedAction.getState();
                }
                return null;
            }
        }, new Function2<State, BrowseReducer.State, State>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final MainPhoneReducer.State invoke(MainPhoneReducer.State parentState, BrowseReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = mainPhoneReducer$build$5;
                Iterator<T> it = kotlin.reflect.full.KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(MainPhoneReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (MainPhoneReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.mainphone.MainPhoneReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BrowseReducer.Action, Action>() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MainPhoneReducer.Action invoke(BrowseReducer.Action action) {
                Object objInvoke = mainPhoneReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (MainPhoneReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.mainphone.MainPhoneReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J9\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001e\u0010\u000fR\u001b\u0010 \u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b \u0010\u000fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*¨\u00066"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "", "nestedViewState", "Lcom/box/android/browse/cpl/NestedViewState;", "debugBuild", "", ComposeIdentificationData.HIERARCHY, "", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "hierarchyRefreshing", "<init>", "(Lcom/box/android/browse/cpl/NestedViewState;ZLjava/util/List;Z)V", "getNestedViewState", "()Lcom/box/android/browse/cpl/NestedViewState;", "getDebugBuild", "()Z", "getHierarchy", "()Ljava/util/List;", "getHierarchyRefreshing", "currentlyVisibleBrowse", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "getCurrentlyVisibleBrowse", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "currentlyVisibleBrowse$delegate", "Lkotlin/Lazy;", "currentlyVisibleFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getCurrentlyVisibleFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "currentlyVisibleFolder$delegate", "isFolderInitialized", "isFolderInitialized$delegate", "isOnCollectionsScreen", "isOnCollectionsScreen$delegate", "currentlyVisibleFolderName", "", "getCurrentlyVisibleFolderName", "()Ljava/lang/String;", "currentlyVisibleFolderName$delegate", "moreOptionsMenu", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$MoreOptionsMenuState;", "getMoreOptionsMenu", "()Lcom/box/android/cpl/mainphone/MainPhoneReducer$MoreOptionsMenuState;", "moreOptionsMenu$delegate", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;

        /* JADX INFO: renamed from: currentlyVisibleBrowse$delegate, reason: from kotlin metadata */
        private final Lazy currentlyVisibleBrowse;

        /* JADX INFO: renamed from: currentlyVisibleFolder$delegate, reason: from kotlin metadata */
        private final Lazy currentlyVisibleFolder;

        /* JADX INFO: renamed from: currentlyVisibleFolderName$delegate, reason: from kotlin metadata */
        private final Lazy currentlyVisibleFolderName;
        private final boolean debugBuild;
        private final List<HierarchyModel> hierarchy;
        private final boolean hierarchyRefreshing;

        /* JADX INFO: renamed from: isFolderInitialized$delegate, reason: from kotlin metadata */
        private final Lazy isFolderInitialized;

        /* JADX INFO: renamed from: isOnCollectionsScreen$delegate, reason: from kotlin metadata */
        private final Lazy isOnCollectionsScreen;

        /* JADX INFO: renamed from: moreOptionsMenu$delegate, reason: from kotlin metadata */
        private final Lazy moreOptionsMenu;
        private final NestedViewState nestedViewState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, NestedViewState nestedViewState, boolean z, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                nestedViewState = state.nestedViewState;
            }
            if ((i & 2) != 0) {
                z = state.debugBuild;
            }
            if ((i & 4) != 0) {
                list = state.hierarchy;
            }
            if ((i & 8) != 0) {
                z2 = state.hierarchyRefreshing;
            }
            return state.copy(nestedViewState, z, list, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NestedViewState getNestedViewState() {
            return this.nestedViewState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getDebugBuild() {
            return this.debugBuild;
        }

        public final List<HierarchyModel> component3() {
            return this.hierarchy;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getHierarchyRefreshing() {
            return this.hierarchyRefreshing;
        }

        public final State copy(NestedViewState nestedViewState, boolean debugBuild, List<HierarchyModel> hierarchy, boolean hierarchyRefreshing) {
            Intrinsics.checkNotNullParameter(nestedViewState, "nestedViewState");
            return new State(nestedViewState, debugBuild, hierarchy, hierarchyRefreshing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.nestedViewState, state.nestedViewState) && this.debugBuild == state.debugBuild && Intrinsics.areEqual(this.hierarchy, state.hierarchy) && this.hierarchyRefreshing == state.hierarchyRefreshing;
        }

        public int hashCode() {
            int iHashCode = ((this.nestedViewState.hashCode() * 31) + Boolean.hashCode(this.debugBuild)) * 31;
            List<HierarchyModel> list = this.hierarchy;
            return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.hierarchyRefreshing);
        }

        public String toString() {
            return "State(nestedViewState=" + this.nestedViewState + ", debugBuild=" + this.debugBuild + ", hierarchy=" + this.hierarchy + ", hierarchyRefreshing=" + this.hierarchyRefreshing + ")";
        }

        public State(NestedViewState nestedViewState, boolean z, List<HierarchyModel> list, boolean z2) {
            Intrinsics.checkNotNullParameter(nestedViewState, "nestedViewState");
            this.nestedViewState = nestedViewState;
            this.debugBuild = z;
            this.hierarchy = list;
            this.hierarchyRefreshing = z2;
            this.currentlyVisibleBrowse = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainPhoneReducer.State.currentlyVisibleBrowse_delegate$lambda$0(this.f$0);
                }
            });
            this.currentlyVisibleFolder = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainPhoneReducer.State.currentlyVisibleFolder_delegate$lambda$0(this.f$0);
                }
            });
            this.isFolderInitialized = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(MainPhoneReducer.State.isFolderInitialized_delegate$lambda$0(this.f$0));
                }
            });
            this.isOnCollectionsScreen = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(MainPhoneReducer.State.isOnCollectionsScreen_delegate$lambda$0(this.f$0));
                }
            });
            this.currentlyVisibleFolderName = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainPhoneReducer.State.currentlyVisibleFolderName_delegate$lambda$0(this.f$0);
                }
            });
            this.moreOptionsMenu = LazyKt.lazy(new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneReducer$State$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainPhoneReducer.State.moreOptionsMenu_delegate$lambda$0(this.f$0);
                }
            });
        }

        public /* synthetic */ State(NestedViewState nestedViewState, boolean z, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(nestedViewState, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : list, (i & 8) != 0 ? false : z2);
        }

        public final NestedViewState getNestedViewState() {
            return this.nestedViewState;
        }

        public final boolean getDebugBuild() {
            return this.debugBuild;
        }

        public final List<HierarchyModel> getHierarchy() {
            return this.hierarchy;
        }

        public final boolean getHierarchyRefreshing() {
            return this.hierarchyRefreshing;
        }

        private final BrowseReducer.State getCurrentlyVisibleBrowse() {
            return (BrowseReducer.State) this.currentlyVisibleBrowse.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BrowseReducer.State currentlyVisibleBrowse_delegate$lambda$0(State state) {
            BrowseReducer.State state2;
            NestedViewState nestedViewState = state.nestedViewState;
            if (nestedViewState instanceof BrowseReducer.State) {
                return ((BrowseReducer.State) nestedViewState).getCurrentlyVisibleBrowse();
            }
            if (nestedViewState instanceof CollectionReducer.State) {
                CollectionReducer.Route navigationRoute = ((CollectionReducer.State) nestedViewState).getNavigationRoute();
                CollectionReducer.Route.Folder folder = navigationRoute instanceof CollectionReducer.Route.Folder ? (CollectionReducer.Route.Folder) navigationRoute : null;
                if (folder != null && (state2 = folder.getState()) != null) {
                    return state2.getCurrentlyVisibleBrowse();
                }
            }
            return null;
        }

        public final FolderModel getCurrentlyVisibleFolder() {
            return (FolderModel) this.currentlyVisibleFolder.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FolderModel currentlyVisibleFolder_delegate$lambda$0(State state) {
            BrowseReducer.State currentlyVisibleBrowse = state.getCurrentlyVisibleBrowse();
            if (currentlyVisibleBrowse != null) {
                return currentlyVisibleBrowse.getCurrentlyVisibleFolder();
            }
            return null;
        }

        public final boolean isFolderInitialized() {
            return ((Boolean) this.isFolderInitialized.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean isFolderInitialized_delegate$lambda$0(State state) {
            BrowseReducer.State currentlyVisibleBrowse = state.getCurrentlyVisibleBrowse();
            return currentlyVisibleBrowse != null && currentlyVisibleBrowse.getFolderInitialized();
        }

        public final boolean isOnCollectionsScreen() {
            return ((Boolean) this.isOnCollectionsScreen.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean isOnCollectionsScreen_delegate$lambda$0(State state) {
            NestedViewState nestedViewState = state.nestedViewState;
            return (nestedViewState instanceof CollectionReducer.State) && Intrinsics.areEqual(((CollectionReducer.State) nestedViewState).getNavigationRoute(), CollectionReducer.Route.None.INSTANCE);
        }

        public final String getCurrentlyVisibleFolderName() {
            return (String) this.currentlyVisibleFolderName.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String currentlyVisibleFolderName_delegate$lambda$0(State state) {
            FolderModel currentlyVisibleFolder = state.getCurrentlyVisibleFolder();
            if (currentlyVisibleFolder != null) {
                return currentlyVisibleFolder.getName();
            }
            return null;
        }

        public final MoreOptionsMenuState getMoreOptionsMenu() {
            return (MoreOptionsMenuState) this.moreOptionsMenu.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MoreOptionsMenuState moreOptionsMenu_delegate$lambda$0(State state) {
            BrowseReducer.State currentlyVisibleBrowse = state.getCurrentlyVisibleBrowse();
            if (currentlyVisibleBrowse != null) {
                return new MoreOptionsMenuState(currentlyVisibleBrowse.getCurrentlyVisibleFolder().isRooted(), state.debugBuild, !currentlyVisibleBrowse.getActionableItemsListState().getItemsListViewState().getItems().isEmpty());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$MoreOptionsMenuState;", "", "collectionsMenuVisible", "", "debugMenuVisible", "multiSelectVisible", "<init>", "(ZZZ)V", "getCollectionsMenuVisible", "()Z", "getDebugMenuVisible", "getMultiSelectVisible", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MoreOptionsMenuState {
        public static final int $stable = 0;
        private final boolean collectionsMenuVisible;
        private final boolean debugMenuVisible;
        private final boolean multiSelectVisible;

        public MoreOptionsMenuState() {
            this(false, false, false, 7, null);
        }

        public static /* synthetic */ MoreOptionsMenuState copy$default(MoreOptionsMenuState moreOptionsMenuState, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = moreOptionsMenuState.collectionsMenuVisible;
            }
            if ((i & 2) != 0) {
                z2 = moreOptionsMenuState.debugMenuVisible;
            }
            if ((i & 4) != 0) {
                z3 = moreOptionsMenuState.multiSelectVisible;
            }
            return moreOptionsMenuState.copy(z, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCollectionsMenuVisible() {
            return this.collectionsMenuVisible;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getDebugMenuVisible() {
            return this.debugMenuVisible;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getMultiSelectVisible() {
            return this.multiSelectVisible;
        }

        public final MoreOptionsMenuState copy(boolean collectionsMenuVisible, boolean debugMenuVisible, boolean multiSelectVisible) {
            return new MoreOptionsMenuState(collectionsMenuVisible, debugMenuVisible, multiSelectVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoreOptionsMenuState)) {
                return false;
            }
            MoreOptionsMenuState moreOptionsMenuState = (MoreOptionsMenuState) other;
            return this.collectionsMenuVisible == moreOptionsMenuState.collectionsMenuVisible && this.debugMenuVisible == moreOptionsMenuState.debugMenuVisible && this.multiSelectVisible == moreOptionsMenuState.multiSelectVisible;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.collectionsMenuVisible) * 31) + Boolean.hashCode(this.debugMenuVisible)) * 31) + Boolean.hashCode(this.multiSelectVisible);
        }

        public String toString() {
            return "MoreOptionsMenuState(collectionsMenuVisible=" + this.collectionsMenuVisible + ", debugMenuVisible=" + this.debugMenuVisible + ", multiSelectVisible=" + this.multiSelectVisible + ")";
        }

        public MoreOptionsMenuState(boolean z, boolean z2, boolean z3) {
            this.collectionsMenuVisible = z;
            this.debugMenuVisible = z2;
            this.multiSelectVisible = z3;
        }

        public /* synthetic */ MoreOptionsMenuState(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
        }

        public final boolean getCollectionsMenuVisible() {
            return this.collectionsMenuVisible;
        }

        public final boolean getDebugMenuVisible() {
            return this.debugMenuVisible;
        }

        public final boolean getMultiSelectVisible() {
            return this.multiSelectVisible;
        }
    }

    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "", "<init>", "()V", "BrowseNestedAction", "CollectionAction", "NavigateToFolder", "RefreshHierarchy", "StartRefreshHierarchy", "HierarchyRefreshFailed", "HierarchyRefreshed", "Initialize", "ExpireToken", "ForBrowse", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$BrowseNestedAction;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$CollectionAction;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$ExpireToken;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$ForBrowse;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$HierarchyRefreshFailed;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$HierarchyRefreshed;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$Initialize;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$NavigateToFolder;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$RefreshHierarchy;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$StartRefreshHierarchy;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$BrowseNestedAction;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "browseAction", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", "getBrowseAction", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BrowseNestedAction extends Action implements Embedded<BrowseReducer.Action> {
            public static final int $stable = BrowseReducer.Action.$stable;
            private final BrowseReducer.Action browseAction;

            public static /* synthetic */ BrowseNestedAction copy$default(BrowseNestedAction browseNestedAction, BrowseReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = browseNestedAction.browseAction;
                }
                return browseNestedAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.Action getState() {
                return this.browseAction;
            }

            public final BrowseNestedAction copy(BrowseReducer.Action browseAction) {
                Intrinsics.checkNotNullParameter(browseAction, "browseAction");
                return new BrowseNestedAction(browseAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BrowseNestedAction) && Intrinsics.areEqual(this.browseAction, ((BrowseNestedAction) other).browseAction);
            }

            public int hashCode() {
                return this.browseAction.hashCode();
            }

            public String toString() {
                return "BrowseNestedAction(browseAction=" + this.browseAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BrowseNestedAction(BrowseReducer.Action browseAction) {
                super(null);
                Intrinsics.checkNotNullParameter(browseAction, "browseAction");
                this.browseAction = browseAction;
            }

            public final BrowseReducer.Action getBrowseAction() {
                return this.browseAction;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$CollectionAction;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "collectionAction", "<init>", "(Lcom/box/android/browse/cpl/CollectionReducer$Action;)V", "getCollectionAction", "()Lcom/box/android/browse/cpl/CollectionReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionAction extends Action implements Embedded<CollectionReducer.Action> {
            public static final int $stable = CollectionReducer.Action.$stable;
            private final CollectionReducer.Action collectionAction;

            public static /* synthetic */ CollectionAction copy$default(CollectionAction collectionAction, CollectionReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = collectionAction.collectionAction;
                }
                return collectionAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionReducer.Action getState() {
                return this.collectionAction;
            }

            public final CollectionAction copy(CollectionReducer.Action collectionAction) {
                Intrinsics.checkNotNullParameter(collectionAction, "collectionAction");
                return new CollectionAction(collectionAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollectionAction) && Intrinsics.areEqual(this.collectionAction, ((CollectionAction) other).collectionAction);
            }

            public int hashCode() {
                return this.collectionAction.hashCode();
            }

            public String toString() {
                return "CollectionAction(collectionAction=" + this.collectionAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionAction(CollectionReducer.Action collectionAction) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionAction, "collectionAction");
                this.collectionAction = collectionAction;
            }

            public final CollectionReducer.Action getCollectionAction() {
                return this.collectionAction;
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$NavigateToFolder;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$RefreshHierarchy;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class RefreshHierarchy extends Action {
            public static final int $stable = 0;
            public static final RefreshHierarchy INSTANCE = new RefreshHierarchy();

            private RefreshHierarchy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$StartRefreshHierarchy;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class StartRefreshHierarchy extends Action {
            public static final int $stable = 0;
            public static final StartRefreshHierarchy INSTANCE = new StartRefreshHierarchy();

            private StartRefreshHierarchy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$HierarchyRefreshFailed;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class HierarchyRefreshFailed extends Action {
            public static final int $stable = 0;
            public static final HierarchyRefreshFailed INSTANCE = new HierarchyRefreshFailed();

            private HierarchyRefreshFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$HierarchyRefreshed;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", ComposeIdentificationData.HIERARCHY, "", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "<init>", "(Ljava/util/List;)V", "getHierarchy", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HierarchyRefreshed extends Action {
            public static final int $stable = 8;
            private final List<HierarchyModel> hierarchy;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ HierarchyRefreshed copy$default(HierarchyRefreshed hierarchyRefreshed, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = hierarchyRefreshed.hierarchy;
                }
                return hierarchyRefreshed.copy(list);
            }

            public final List<HierarchyModel> component1() {
                return this.hierarchy;
            }

            public final HierarchyRefreshed copy(List<HierarchyModel> hierarchy) {
                Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
                return new HierarchyRefreshed(hierarchy);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HierarchyRefreshed) && Intrinsics.areEqual(this.hierarchy, ((HierarchyRefreshed) other).hierarchy);
            }

            public int hashCode() {
                return this.hierarchy.hashCode();
            }

            public String toString() {
                return "HierarchyRefreshed(hierarchy=" + this.hierarchy + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HierarchyRefreshed(List<HierarchyModel> hierarchy) {
                super(null);
                Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
                this.hierarchy = hierarchy;
            }

            public final List<HierarchyModel> getHierarchy() {
                return this.hierarchy;
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$Initialize;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            private Initialize() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$ExpireToken;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ExpireToken extends Action {
            public static final int $stable = 0;
            public static final ExpireToken INSTANCE = new ExpireToken();

            private ExpireToken() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action$ForBrowse;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ForBrowse extends Action {
            public static final int $stable = BrowseReducer.Action.$stable;
            private final BrowseReducer.Action action;

            public static /* synthetic */ ForBrowse copy$default(ForBrowse forBrowse, BrowseReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = forBrowse.action;
                }
                return forBrowse.copy(action);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.Action getAction() {
                return this.action;
            }

            public final ForBrowse copy(BrowseReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ForBrowse(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ForBrowse) && Intrinsics.areEqual(this.action, ((ForBrowse) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ForBrowse(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ForBrowse(BrowseReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BrowseReducer.Action getAction() {
                return this.action;
            }
        }
    }

    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "Landroid/os/Parcelable;", "id", "", "name", "type", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModelType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModelType;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModelType;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HierarchyModel implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<HierarchyModel> CREATOR = new Creator();
        private final String id;
        private final String name;
        private final HierarchyModelType type;

        /* JADX INFO: compiled from: MainPhoneReducer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<HierarchyModel> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HierarchyModel createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HierarchyModel(parcel.readString(), parcel.readString(), HierarchyModelType.valueOf(parcel.readString()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HierarchyModel[] newArray(int i) {
                return new HierarchyModel[i];
            }
        }

        public static /* synthetic */ HierarchyModel copy$default(HierarchyModel hierarchyModel, String str, String str2, HierarchyModelType hierarchyModelType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hierarchyModel.id;
            }
            if ((i & 2) != 0) {
                str2 = hierarchyModel.name;
            }
            if ((i & 4) != 0) {
                hierarchyModelType = hierarchyModel.type;
            }
            return hierarchyModel.copy(str, str2, hierarchyModelType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HierarchyModelType getType() {
            return this.type;
        }

        public final HierarchyModel copy(String id, String name, HierarchyModelType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new HierarchyModel(id, name, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HierarchyModel)) {
                return false;
            }
            HierarchyModel hierarchyModel = (HierarchyModel) other;
            return Intrinsics.areEqual(this.id, hierarchyModel.id) && Intrinsics.areEqual(this.name, hierarchyModel.name) && this.type == hierarchyModel.type;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "HierarchyModel(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeString(this.type.name());
        }

        public HierarchyModel(String str, String str2, HierarchyModelType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = str;
            this.name = str2;
            this.type = type;
        }

        public /* synthetic */ HierarchyModel(String str, String str2, HierarchyModelType hierarchyModelType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, hierarchyModelType);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final HierarchyModelType getType() {
            return this.type;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceMainPhone(State state, Action action) {
        Object collectionAction;
        Effect effectNone;
        if (Intrinsics.areEqual(action, Action.Initialize.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, BuildConfigProvider.INSTANCE.isDebugBuild(), null, false, 13, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ExpireToken.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.RefreshHierarchy.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, true, 7, null), new Effect(Action.StartRefreshHierarchy.INSTANCE));
        }
        if (Intrinsics.areEqual(action, Action.StartRefreshHierarchy.INSTANCE)) {
            return refreshHierarchy(state);
        }
        if (action instanceof Action.HierarchyRefreshed) {
            return new ReducerResult<>(State.copy$default(state, null, false, ((Action.HierarchyRefreshed) action).getHierarchy(), false, 3, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.HierarchyRefreshFailed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, CollectionsKt.emptyList(), false, 3, null), null, 2, null);
        }
        if (action instanceof Action.NavigateToFolder) {
            NestedViewState nestedViewState = state.getNestedViewState();
            if (nestedViewState instanceof BrowseReducer.State) {
                effectNone = new Effect(new Action.BrowseNestedAction(new BrowseReducer.Action.NavigateToFolder(((Action.NavigateToFolder) action).getFolder())));
            } else if (nestedViewState instanceof CollectionReducer.State) {
                effectNone = new Effect(new Action.CollectionAction(new CollectionReducer.Action.NavigateToFolder(((Action.NavigateToFolder) action).getFolder())));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.BrowseNestedAction) {
            return reduceBrowse(state, ((Action.BrowseNestedAction) action).getBrowseAction());
        }
        if (action instanceof Action.ForBrowse) {
            NestedViewState nestedViewState2 = state.getNestedViewState();
            if (nestedViewState2 instanceof BrowseReducer.State) {
                collectionAction = new Action.BrowseNestedAction(((Action.ForBrowse) action).getAction());
            } else {
                collectionAction = nestedViewState2 instanceof CollectionReducer.State ? new Action.CollectionAction(new CollectionReducer.Action.ChildBrowseAction(((Action.ForBrowse) action).getAction())) : null;
            }
            if (collectionAction != null) {
                return new ReducerResult<>(state, new Effect(collectionAction));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.cpl.mainphone.MainPhoneReducer$reduceMainPhone$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainPhoneReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.cpl.mainphone.MainPhoneReducer$reduceMainPhone$1", f = "MainPhoneReducer.kt", i = {0}, l = {Token.LOCAL_BLOCK}, m = "invokeSuspend", n = {"sessionManager"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MainPhoneReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainPhoneReducer.this.environment.getMUserContextManager().expireAccessTokenForDebug();
                ISessionManager sessionManager = MainPhoneReducer.this.environment.getBrowseEnvironment().getActionableItemsListEnvironment().getItemListViewEnvironment().getSessionManager();
                this.L$0 = SpillingKt.nullOutSpilledVariable(sessionManager);
                this.label = 1;
                obj = sessionManager.refreshSession(this);
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
                MainPhoneReducer.this.environment.getMUserContextManager().destroyUser(MainPhoneReducer.this.environment.getMUserContextManager().getCurrentContextId());
            }
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> refreshHierarchy(State state) {
        if (state.isOnCollectionsScreen()) {
            ArrayList arrayList = new ArrayList();
            NestedViewState nestedViewState = state.getNestedViewState();
            Intrinsics.checkNotNull(nestedViewState, "null cannot be cast to non-null type com.box.android.browse.cpl.CollectionReducer.State");
            CollectionReducer.State state2 = (CollectionReducer.State) nestedViewState;
            arrayList.add(new HierarchyModel(null, null, HierarchyModelType.MY_COLLECTIONS, 3, null));
            arrayList.add(new HierarchyModel(state2.getCollectionId(), state2.getCollectionName(), HierarchyModelType.COLLECTION));
            return new ReducerResult<>(state, new Effect(new Action.HierarchyRefreshed(arrayList)));
        }
        FolderModel currentlyVisibleFolder = state.getCurrentlyVisibleFolder();
        if (currentlyVisibleFolder != null) {
            return new ReducerResult<>(state, EffectKt.toEffect(new Effect((Function1) new MainPhoneReducer$refreshHierarchy$1$1(this, currentlyVisibleFolder, null)).cancellable(REFRESH_HIERARCHY_ID, true)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceBrowse(State state, BrowseReducer.Action action) {
        if (action instanceof BrowseReducer.Action.ChildBrowseAction) {
            if (((BrowseReducer.Action.ChildBrowseAction) action).getAction() instanceof BrowseReducer.Action.CloseScreen) {
                return new ReducerResult<>(State.copy$default(state, null, false, null, false, 7, null), Effect.INSTANCE.cancel(REFRESH_HIERARCHY_ID));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof BrowseReducer.Action.CloseScreen) {
            return new ReducerResult<>(State.copy$default(state, None.INSTANCE, false, null, false, 14, null), Effect.INSTANCE.cancel(REFRESH_HIERARCHY_ID));
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
