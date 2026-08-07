package com.box.android.hubs.presentation;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.base.presentation.multiselect.SelectionIdKt;
import com.box.android.common.utilities.BoxCommonConstants;
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
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.services.IHubsService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: HubsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0019\u001a\u001b\u001cB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/hubs/presentation/HubsReducer$State;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "environment", "Lcom/box/android/hubs/presentation/HubsEnvironment;", "observabilityId", "", "<init>", "(Lcom/box/android/hubs/presentation/HubsEnvironment;Ljava/lang/String;)V", "handleItemsUpdated", "Lcom/box/android/cpl/ReducerResult;", "state", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/hubs/HubModel;", "reduceHubs", Analytics.Data.ACTION, "reduceObservability", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "handleHubAction", "Lcom/box/android/hubs/presentation/HubsReducer$Action$HubAction;", "ConfigBarMode", "State", "ScreenState", "Action", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Combine<State, Action> build;
    private final HubsEnvironment environment;
    private final String observabilityId;

    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$ConfigBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL", "SORT_ONLY", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum ConfigBarMode {
        FULL,
        SORT_ONLY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ConfigBarMode> getEntries() {
            return $ENTRIES;
        }
    }

    public HubsReducer(HubsEnvironment environment, String observabilityId) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
        this.environment = environment;
        this.observabilityId = observabilityId;
        Reduce reduce = new Reduce(new HubsReducer$build$2(this));
        final HubsReducer$build$3 hubsReducer$build$3 = new PropertyReference1Impl() { // from class: com.box.android.hubs.presentation.HubsReducer$build$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((HubsReducer.State) obj).getMultiselect();
            }
        };
        final HubsReducer$build$4 hubsReducer$build$4 = HubsReducer$build$4.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new MultiselectReducer(environment.getMultiselectEnvironment()), new Function1<State, MultiselectReducer.State>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.multiselect.MultiselectReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.State invoke(HubsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return hubsReducer$build$3.invoke(it);
            }
        }, new Function1<Action, MultiselectReducer.Action>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.Action invoke(HubsReducer.Action action) {
                if (!(action instanceof HubsReducer.Action.Multiselect)) {
                    action = null;
                }
                HubsReducer.Action.Multiselect multiselect = (HubsReducer.Action.Multiselect) action;
                if (multiselect != null) {
                    return multiselect.getState();
                }
                return null;
            }
        }, new Function2<State, MultiselectReducer.State, State>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final HubsReducer.State invoke(HubsReducer.State parentState, MultiselectReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = hubsReducer$build$3;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(HubsReducer.State.class)).iterator();
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
                            return (HubsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<MultiselectReducer.Action, Action>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HubsReducer.Action invoke(MultiselectReducer.Action action) {
                Object objInvoke = hubsReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (HubsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubsReducer.Action");
            }
        });
        final HubsReducer$build$6 hubsReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.hubs.presentation.HubsReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((HubsReducer.State) obj).getHubsList();
            }
        };
        final HubsReducer$build$7 hubsReducer$build$7 = HubsReducer$build$7.INSTANCE;
        this.build = new Combine<>(new Reduce(new HubsReducer$build$1(this)), new ForEachReducer(ifLetReducer, new HubReducer(environment, observabilityId), hubsReducer$build$6, new Function1<Action, EmbeddedItem<String, HubReducer.Action>>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<String, HubReducer.Action> invoke(HubsReducer.Action action) {
                if (!(action instanceof HubsReducer.Action.HubAction)) {
                    action = null;
                }
                return (HubsReducer.Action.HubAction) action;
            }
        }, new Function2<State, HubReducer.State, State>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final HubsReducer.State invoke(HubsReducer.State parentState, HubReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) hubsReducer$build$6.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = hubsReducer$build$6;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(HubsReducer.State.class)).iterator();
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
                            return (HubsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<String, HubReducer.Action, Action>() { // from class: com.box.android.hubs.presentation.HubsReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final HubsReducer.Action invoke(String id, HubReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = hubsReducer$build$7.invoke(id, action);
                if (objInvoke != null) {
                    return (HubsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubsReducer.Action");
            }
        }));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HubsReducer(HubsEnvironment hubsEnvironment, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        this(hubsEnvironment, str);
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000eJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003Jy\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b+\u0010%¨\u0006>"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$State;", "", "screenState", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "sortBy", "Lcom/box/android/domain/models/hubs/HubsSort;", "sortDirection", "Lcom/box/android/domain/models/hubs/HubsDirection;", "itemsScreenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "configBarMode", "Lcom/box/android/hubs/presentation/HubsReducer$ConfigBarMode;", "hubsList", "Lcom/box/android/cpl/IdentifiedList;", "", "Lcom/box/android/hubs/presentation/HubReducer$State;", "isPullToRefreshing", "", "shouldShowSearchButton", "route", "Lcom/box/android/hubs/presentation/HubsRoute;", "multiselect", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "<init>", "(Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;Lcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;Lcom/box/android/domain/models/ItemsScreenMode;Lcom/box/android/hubs/presentation/HubsReducer$ConfigBarMode;Lcom/box/android/cpl/IdentifiedList;ZZLcom/box/android/hubs/presentation/HubsRoute;Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;)V", "getScreenState", "()Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "getSortBy", "()Lcom/box/android/domain/models/hubs/HubsSort;", "getSortDirection", "()Lcom/box/android/domain/models/hubs/HubsDirection;", "getItemsScreenMode", "()Lcom/box/android/domain/models/ItemsScreenMode;", "getConfigBarMode", "()Lcom/box/android/hubs/presentation/HubsReducer$ConfigBarMode;", "getHubsList", "()Lcom/box/android/cpl/IdentifiedList;", "()Z", "getShouldShowSearchButton", "getRoute", "()Lcom/box/android/hubs/presentation/HubsRoute;", "getMultiselect", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "isSelecting", "isHubSelected", HubDetailsInitialContext.HUB_ID_KEY, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ConfigBarMode configBarMode;
        private final IdentifiedList<String, HubReducer.State> hubsList;
        private final boolean isPullToRefreshing;
        private final ItemsScreenMode itemsScreenMode;
        private final MultiselectReducer.State multiselect;
        private final HubsRoute route;
        private final ScreenState screenState;
        private final boolean shouldShowSearchButton;
        private final HubsSort sortBy;
        private final HubsDirection sortDirection;

        public State() {
            this(null, null, null, null, null, null, false, false, null, null, 1023, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ScreenState screenState, HubsSort hubsSort, HubsDirection hubsDirection, ItemsScreenMode itemsScreenMode, ConfigBarMode configBarMode, IdentifiedList identifiedList, boolean z, boolean z2, HubsRoute hubsRoute, MultiselectReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                screenState = state.screenState;
            }
            if ((i & 2) != 0) {
                hubsSort = state.sortBy;
            }
            if ((i & 4) != 0) {
                hubsDirection = state.sortDirection;
            }
            if ((i & 8) != 0) {
                itemsScreenMode = state.itemsScreenMode;
            }
            if ((i & 16) != 0) {
                configBarMode = state.configBarMode;
            }
            if ((i & 32) != 0) {
                identifiedList = state.hubsList;
            }
            if ((i & 64) != 0) {
                z = state.isPullToRefreshing;
            }
            if ((i & 128) != 0) {
                z2 = state.shouldShowSearchButton;
            }
            if ((i & 256) != 0) {
                hubsRoute = state.route;
            }
            if ((i & 512) != 0) {
                state2 = state.multiselect;
            }
            HubsRoute hubsRoute2 = hubsRoute;
            MultiselectReducer.State state3 = state2;
            boolean z3 = z;
            boolean z4 = z2;
            ConfigBarMode configBarMode2 = configBarMode;
            IdentifiedList identifiedList2 = identifiedList;
            return state.copy(screenState, hubsSort, hubsDirection, itemsScreenMode, configBarMode2, identifiedList2, z3, z4, hubsRoute2, state3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScreenState getScreenState() {
            return this.screenState;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final HubsSort getSortBy() {
            return this.sortBy;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HubsDirection getSortDirection() {
            return this.sortDirection;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ItemsScreenMode getItemsScreenMode() {
            return this.itemsScreenMode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        public final IdentifiedList<String, HubReducer.State> component6() {
            return this.hubsList;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsPullToRefreshing() {
            return this.isPullToRefreshing;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getShouldShowSearchButton() {
            return this.shouldShowSearchButton;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final HubsRoute getRoute() {
            return this.route;
        }

        public final State copy(ScreenState screenState, HubsSort sortBy, HubsDirection sortDirection, ItemsScreenMode itemsScreenMode, ConfigBarMode configBarMode, IdentifiedList<String, HubReducer.State> hubsList, boolean isPullToRefreshing, boolean shouldShowSearchButton, HubsRoute route, MultiselectReducer.State multiselect) {
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(sortBy, "sortBy");
            Intrinsics.checkNotNullParameter(sortDirection, "sortDirection");
            Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            Intrinsics.checkNotNullParameter(hubsList, "hubsList");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            return new State(screenState, sortBy, sortDirection, itemsScreenMode, configBarMode, hubsList, isPullToRefreshing, shouldShowSearchButton, route, multiselect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.screenState, state.screenState) && this.sortBy == state.sortBy && this.sortDirection == state.sortDirection && this.itemsScreenMode == state.itemsScreenMode && this.configBarMode == state.configBarMode && Intrinsics.areEqual(this.hubsList, state.hubsList) && this.isPullToRefreshing == state.isPullToRefreshing && this.shouldShowSearchButton == state.shouldShowSearchButton && Intrinsics.areEqual(this.route, state.route) && Intrinsics.areEqual(this.multiselect, state.multiselect);
        }

        public int hashCode() {
            return (((((((((((((((((this.screenState.hashCode() * 31) + this.sortBy.hashCode()) * 31) + this.sortDirection.hashCode()) * 31) + this.itemsScreenMode.hashCode()) * 31) + this.configBarMode.hashCode()) * 31) + this.hubsList.hashCode()) * 31) + Boolean.hashCode(this.isPullToRefreshing)) * 31) + Boolean.hashCode(this.shouldShowSearchButton)) * 31) + this.route.hashCode()) * 31) + this.multiselect.hashCode();
        }

        public String toString() {
            return "State(screenState=" + this.screenState + ", sortBy=" + this.sortBy + ", sortDirection=" + this.sortDirection + ", itemsScreenMode=" + this.itemsScreenMode + ", configBarMode=" + this.configBarMode + ", hubsList=" + this.hubsList + ", isPullToRefreshing=" + this.isPullToRefreshing + ", shouldShowSearchButton=" + this.shouldShowSearchButton + ", route=" + this.route + ", multiselect=" + this.multiselect + ")";
        }

        public State(ScreenState screenState, HubsSort sortBy, HubsDirection sortDirection, ItemsScreenMode itemsScreenMode, ConfigBarMode configBarMode, IdentifiedList<String, HubReducer.State> hubsList, boolean z, boolean z2, HubsRoute route, MultiselectReducer.State multiselect) {
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(sortBy, "sortBy");
            Intrinsics.checkNotNullParameter(sortDirection, "sortDirection");
            Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            Intrinsics.checkNotNullParameter(hubsList, "hubsList");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            this.screenState = screenState;
            this.sortBy = sortBy;
            this.sortDirection = sortDirection;
            this.itemsScreenMode = itemsScreenMode;
            this.configBarMode = configBarMode;
            this.hubsList = hubsList;
            this.isPullToRefreshing = z;
            this.shouldShowSearchButton = z2;
            this.route = route;
            this.multiselect = multiselect;
        }

        public /* synthetic */ State(ScreenState.Loading loading, HubsSort hubsSort, HubsDirection hubsDirection, ItemsScreenMode itemsScreenMode, ConfigBarMode configBarMode, IdentifiedList identifiedList, boolean z, boolean z2, HubsRoute.None none, MultiselectReducer.State.Unavailable unavailable, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ScreenState.Loading.INSTANCE : loading, (i & 2) != 0 ? HubsSort.DateUpdated : hubsSort, (i & 4) != 0 ? HubsDirection.DESC : hubsDirection, (i & 8) != 0 ? ItemsScreenMode.LIST : itemsScreenMode, (i & 16) != 0 ? ConfigBarMode.FULL : configBarMode, (i & 32) != 0 ? new IdentifiedList() : identifiedList, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? HubsRoute.None.INSTANCE : none, (i & 512) != 0 ? MultiselectReducer.State.Unavailable.INSTANCE : unavailable);
        }

        public final ScreenState getScreenState() {
            return this.screenState;
        }

        public final HubsSort getSortBy() {
            return this.sortBy;
        }

        public final HubsDirection getSortDirection() {
            return this.sortDirection;
        }

        public final ItemsScreenMode getItemsScreenMode() {
            return this.itemsScreenMode;
        }

        public final ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        public final IdentifiedList<String, HubReducer.State> getHubsList() {
            return this.hubsList;
        }

        public final boolean isPullToRefreshing() {
            return this.isPullToRefreshing;
        }

        public final boolean getShouldShowSearchButton() {
            return this.shouldShowSearchButton;
        }

        public final HubsRoute getRoute() {
            return this.route;
        }

        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final boolean isSelecting() {
            return this.multiselect instanceof MultiselectReducer.State.Selecting;
        }

        public final boolean isHubSelected(String hubId) {
            Intrinsics.checkNotNullParameter(hubId, "hubId");
            MultiselectReducer.State state = this.multiselect;
            MultiselectReducer.State.Selecting selecting = state instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) state : null;
            if (selecting == null) {
                return false;
            }
            return selecting.isItemSelected(SelectionIdKt.hubSelectionId(hubId));
        }
    }

    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "", "<init>", "()V", "Loading", "Error", "Loaded", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Error;", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Loaded;", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Loading;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ScreenState {
        public static final int $stable = 0;

        public /* synthetic */ ScreenState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Loading;", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Loading extends ScreenState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ScreenState() {
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Error;", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends ScreenState {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.domainError;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final Error copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new Error(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.domainError, ((Error) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "Error(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$ScreenState$Loaded;", "Lcom/box/android/hubs/presentation/HubsReducer$ScreenState;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Loaded extends ScreenState {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            private Loaded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000e\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action;", "", "<init>", "()V", "ScreenViewed", "Fetch", "Retry", "PulledToRefresh", "HubsRouteHandled", "Error", "ItemsUpdated", "ToggleScreenMode", "Search", "SortingClicked", "ChangeSortBy", "ToggleSortDirection", "HubAction", "Multiselect", "Lcom/box/android/hubs/presentation/HubsReducer$Action$ChangeSortBy;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$Error;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$Fetch;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$HubAction;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$HubsRouteHandled;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$ItemsUpdated;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$Multiselect;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$PulledToRefresh;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$Retry;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$ScreenViewed;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$Search;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$SortingClicked;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$ToggleScreenMode;", "Lcom/box/android/hubs/presentation/HubsReducer$Action$ToggleSortDirection;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$ScreenViewed;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenViewed extends Action {
            public static final int $stable = 0;
            public static final ScreenViewed INSTANCE = new ScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1746616523;
            }

            public String toString() {
                return "ScreenViewed";
            }

            private ScreenViewed() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$Fetch;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Fetch extends Action {
            public static final int $stable = 0;
            public static final Fetch INSTANCE = new Fetch();

            private Fetch() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$Retry;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Retry extends Action {
            public static final int $stable = 0;
            public static final Retry INSTANCE = new Retry();

            private Retry() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$PulledToRefresh;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PulledToRefresh extends Action {
            public static final int $stable = 0;
            public static final PulledToRefresh INSTANCE = new PulledToRefresh();

            private PulledToRefresh() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$HubsRouteHandled;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class HubsRouteHandled extends Action {
            public static final int $stable = 0;
            public static final HubsRouteHandled INSTANCE = new HubsRouteHandled();

            private HubsRouteHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$Error;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.domainError;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final Error copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new Error(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.domainError, ((Error) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "Error(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$ItemsUpdated;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/hubs/HubModel;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsUpdated extends Action {
            public static final int $stable = 8;
            private final List<HubModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsUpdated copy$default(ItemsUpdated itemsUpdated, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsUpdated.items;
                }
                return itemsUpdated.copy(list);
            }

            public final List<HubModel> component1() {
                return this.items;
            }

            public final ItemsUpdated copy(List<HubModel> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new ItemsUpdated(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsUpdated) && Intrinsics.areEqual(this.items, ((ItemsUpdated) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "ItemsUpdated(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemsUpdated(List<HubModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<HubModel> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$ToggleScreenMode;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ToggleScreenMode extends Action {
            public static final int $stable = 0;
            public static final ToggleScreenMode INSTANCE = new ToggleScreenMode();

            private ToggleScreenMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$Search;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Search extends Action {
            public static final int $stable = 0;
            public static final Search INSTANCE = new Search();

            private Search() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$SortingClicked;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SortingClicked extends Action {
            public static final int $stable = 0;
            public static final SortingClicked INSTANCE = new SortingClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SortingClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 22372968;
            }

            public String toString() {
                return "SortingClicked";
            }

            private SortingClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$ChangeSortBy;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "sortBy", "Lcom/box/android/domain/models/hubs/HubsSort;", "<init>", "(Lcom/box/android/domain/models/hubs/HubsSort;)V", "getSortBy", "()Lcom/box/android/domain/models/hubs/HubsSort;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChangeSortBy extends Action {
            public static final int $stable = 0;
            private final HubsSort sortBy;

            public static /* synthetic */ ChangeSortBy copy$default(ChangeSortBy changeSortBy, HubsSort hubsSort, int i, Object obj) {
                if ((i & 1) != 0) {
                    hubsSort = changeSortBy.sortBy;
                }
                return changeSortBy.copy(hubsSort);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubsSort getSortBy() {
                return this.sortBy;
            }

            public final ChangeSortBy copy(HubsSort sortBy) {
                Intrinsics.checkNotNullParameter(sortBy, "sortBy");
                return new ChangeSortBy(sortBy);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeSortBy) && this.sortBy == ((ChangeSortBy) other).sortBy;
            }

            public int hashCode() {
                return this.sortBy.hashCode();
            }

            public String toString() {
                return "ChangeSortBy(sortBy=" + this.sortBy + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChangeSortBy(HubsSort sortBy) {
                super(null);
                Intrinsics.checkNotNullParameter(sortBy, "sortBy");
                this.sortBy = sortBy;
            }

            public final HubsSort getSortBy() {
                return this.sortBy;
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$ToggleSortDirection;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleSortDirection extends Action {
            public static final int $stable = 0;
            public static final ToggleSortDirection INSTANCE = new ToggleSortDirection();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ToggleSortDirection)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 381619016;
            }

            public String toString() {
                return "ToggleSortDirection";
            }

            private ToggleSortDirection() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$HubAction;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "id", "hubAction", "<init>", "(Ljava/lang/String;Lcom/box/android/hubs/presentation/HubReducer$Action;)V", "getId", "()Ljava/lang/String;", "getHubAction", "()Lcom/box/android/hubs/presentation/HubReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HubAction extends Action implements EmbeddedItem<String, HubReducer.Action> {
            public static final int $stable = 0;
            private final HubReducer.Action hubAction;
            private final String id;

            public static /* synthetic */ HubAction copy$default(HubAction hubAction, String str, HubReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hubAction.id;
                }
                if ((i & 2) != 0) {
                    action = hubAction.hubAction;
                }
                return hubAction.copy(str, action);
            }

            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: avoid collision after fix types in other method and from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final HubReducer.Action getAction() {
                return this.hubAction;
            }

            public final HubAction copy(String id, HubReducer.Action hubAction) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(hubAction, "hubAction");
                return new HubAction(id, hubAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HubAction)) {
                    return false;
                }
                HubAction hubAction = (HubAction) other;
                return Intrinsics.areEqual(this.id, hubAction.id) && Intrinsics.areEqual(this.hubAction, hubAction.hubAction);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.hubAction.hashCode();
            }

            public String toString() {
                return "HubAction(id=" + this.id + ", hubAction=" + this.hubAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HubAction(String id, HubReducer.Action hubAction) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(hubAction, "hubAction");
                this.id = id;
                this.hubAction = hubAction;
            }

            public final HubReducer.Action getHubAction() {
                return this.hubAction;
            }

            public final String getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: HubsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/hubs/presentation/HubsReducer$Action$Multiselect;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final MultiselectReducer.Action getState() {
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
    }

    private final ReducerResult<State, Action> handleItemsUpdated(State state, List<HubModel> items) {
        ItemThumbnailReducer.State bannerThumbnailState;
        ItemThumbnailReducer.State iconThumbnailState;
        List<HubModel> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return new ReducerResult<>(State.copy$default(state, ScreenState.Loaded.INSTANCE, null, null, null, null, new IdentifiedList((Identifiable[]) arrayList.toArray(new HubReducer.State[0])), false, false, null, null, 926, null), null, 2, null);
            }
            HubModel hubModel = (HubModel) it.next();
            HubReducer.State stateCreateState = HubReducer.State.INSTANCE.createState(hubModel);
            HubReducer.State state2 = (HubReducer.State) state.getHubsList().getById(hubModel.getId());
            if (hubModel.getUpdatedAt() != null) {
                if (Intrinsics.areEqual(hubModel.getUpdatedAt(), state2 != null ? state2.getUpdatedDate() : null)) {
                    if (state2 == null || (bannerThumbnailState = state2.getBannerThumbnailState()) == null) {
                        bannerThumbnailState = stateCreateState.getBannerThumbnailState();
                    }
                    ItemThumbnailReducer.State state3 = bannerThumbnailState;
                    if (state2 == null || (iconThumbnailState = state2.getIconThumbnailState()) == null) {
                        iconThumbnailState = stateCreateState.getIconThumbnailState();
                    }
                    stateCreateState = HubReducer.State.copy$default(stateCreateState, null, null, null, state3, iconThumbnailState, null, null, null, 231, null);
                }
            }
            arrayList.add(stateCreateState);
        }
    }

    public final ReducerResult<State, Action> reduceHubs(State state, Action action) {
        ItemsScreenMode itemsScreenMode;
        HubsDirection hubsDirection;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.ScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.SortingClicked.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        if (Intrinsics.areEqual(action, Action.Fetch.INSTANCE)) {
            final Flow hubs$default = IHubsService.getHubs$default(this.environment.getHubsService(), state.getSortBy(), state.getSortDirection(), null, null, 12, null);
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.hubs.presentation.HubsReducer$reduceHubs$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super HubsReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = hubs$default.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$$inlined$map$1$2", f = "HubsReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                        HubsReducer.Action error;
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
                            Result result = (Result) obj;
                            if (result instanceof Result.Success) {
                                error = new HubsReducer.Action.ItemsUpdated((List) ((Result.Success) result).getValue());
                            } else {
                                if (!(result instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new HubsReducer.Action.Error((DomainError) ((Result.Error) result).getValue());
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(error, anonymousClass1) == coroutine_suspended) {
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
            }).cancellable("HubsFetch", true));
        }
        if (Intrinsics.areEqual(action, Action.PulledToRefresh.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, true, false, null, null, 959, null), new Effect(Action.Fetch.INSTANCE));
        }
        if (Intrinsics.areEqual(action, Action.HubsRouteHandled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, false, false, HubsRoute.None.INSTANCE, null, 767, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.Retry.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, ScreenState.Loading.INSTANCE, null, null, null, null, null, false, false, null, null, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, null), new Effect(Action.Fetch.INSTANCE));
        }
        if (action instanceof Action.ToggleSortDirection) {
            if (state.getSortDirection() == HubsDirection.ASC) {
                hubsDirection = HubsDirection.DESC;
            } else {
                hubsDirection = HubsDirection.ASC;
            }
            HubsDirection hubsDirection2 = hubsDirection;
            return new ReducerResult<>(State.copy$default(state, ScreenState.Loading.INSTANCE, null, hubsDirection2, null, null, null, false, false, null, null, 1018, null), new Effect((Function1) new AnonymousClass4(hubsDirection2, null)));
        }
        if (action instanceof Action.ChangeSortBy) {
            return new ReducerResult<>(State.copy$default(state, ScreenState.Loading.INSTANCE, ((Action.ChangeSortBy) action).getSortBy(), null, null, null, null, false, false, null, null, 1020, null), new Effect((Function1) new AnonymousClass5(action, null)));
        }
        if (action instanceof Action.Error) {
            return new ReducerResult<>(State.copy$default(state, new ScreenState.Error(((Action.Error) action).getDomainError()), null, null, null, null, null, false, false, null, null, 958, null), null, 2, null);
        }
        if (action instanceof Action.ItemsUpdated) {
            return handleItemsUpdated(state, ((Action.ItemsUpdated) action).getItems());
        }
        if (action instanceof Action.ToggleScreenMode) {
            if (state.getItemsScreenMode() == ItemsScreenMode.LIST) {
                itemsScreenMode = ItemsScreenMode.GRID;
            } else {
                itemsScreenMode = ItemsScreenMode.LIST;
            }
            ItemsScreenMode itemsScreenMode2 = itemsScreenMode;
            return new ReducerResult<>(State.copy$default(state, null, null, null, itemsScreenMode2, null, null, false, false, null, null, 1015, null), Effect.INSTANCE.fireAndForget(new AnonymousClass6(itemsScreenMode2, null)));
        }
        if (action instanceof Action.HubAction) {
            return handleHubAction(state, (Action.HubAction) action);
        }
        return action instanceof Action.Search ? new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, false, false, HubsRoute.Search.INSTANCE, null, 767, null), null, 2, null) : new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$1", f = "HubsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubsReducer.this.new AnonymousClass1(continuation);
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
            HubsReducer.this.environment.getAnalytics().hubsScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$2, reason: invalid class name */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$2", f = "HubsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubsReducer.this.new AnonymousClass2(continuation);
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
            HubsReducer.this.environment.getAnalytics().sortingClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$4, reason: invalid class name */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/hubs/presentation/HubsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$4", f = "HubsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ HubsDirection $toggledValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(HubsDirection hubsDirection, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$toggledValue = hubsDirection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubsReducer.this.new AnonymousClass4(this.$toggledValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HubsReducer.this.environment.getHubsScreenPreferences().saveSortDirectionPreference(this.$toggledValue);
                return Action.Fetch.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$5, reason: invalid class name */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/hubs/presentation/HubsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$5", f = "HubsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Action action, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubsReducer.this.new AnonymousClass5(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HubsReducer.this.environment.getHubsScreenPreferences().saveSortByPreference(((Action.ChangeSortBy) this.$action).getSortBy());
                return Action.Fetch.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceHubs$6, reason: invalid class name */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceHubs$6", f = "HubsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemsScreenMode $toggledValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(ItemsScreenMode itemsScreenMode, Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
            this.$toggledValue = itemsScreenMode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubsReducer.this.new AnonymousClass6(this.$toggledValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HubsReducer.this.environment.getHubsScreenPreferences().saveScreenModePreference(this.$toggledValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceObservability(State state, Action action) {
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C16491(action, this, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubsReducer$reduceObservability$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HubsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubsReducer$reduceObservability$1", f = "HubsReducer.kt", i = {}, l = {201, 208, BoxCommonConstants.REQUEST_OPTIONS}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16491 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ HubsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16491(Action action, HubsReducer hubsReducer, State state, Continuation<? super C16491> continuation) {
            super(1, continuation);
            this.$action = action;
            this.this$0 = hubsReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C16491(this.$action, this.this$0, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16491) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        
            if (r16.this$0.environment.getHubsObservability().hubListLoadingStarted(r16.this$0.observabilityId, r16.$state.getSortDirection(), r16.$state.getSortBy(), r16.$state.getItemsScreenMode(), (16 & 16) != 0 ? android.os.SystemClock.elapsedRealtime() : 0, r16) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
        
            if (r16.this$0.environment.getHubsObservability().sendHubListFetchError(r16.this$0.observabilityId, ((com.box.android.hubs.presentation.HubsReducer.Action.Error) r16.$action).getDomainError(), r16) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a6, code lost:
        
            if (com.box.android.domain.metrics.hubs.HubsObservability.sendHubListFetchSuccess$default(r16.this$0.environment.getHubsObservability(), r16.this$0.observabilityId, 0, r16, 2, null) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L21
                if (r2 == r5) goto L1c
                if (r2 == r4) goto L1c
                if (r2 != r3) goto L14
                goto L1c
            L14:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1c:
                kotlin.ResultKt.throwOnFailure(r17)
                goto La9
            L21:
                kotlin.ResultKt.throwOnFailure(r17)
                com.box.android.hubs.presentation.HubsReducer$Action r2 = r0.$action
                boolean r6 = r2 instanceof com.box.android.hubs.presentation.HubsReducer.Action.Fetch
                if (r6 == 0) goto L5d
                com.box.android.hubs.presentation.HubsReducer r2 = r0.this$0
                com.box.android.hubs.presentation.HubsEnvironment r2 = com.box.android.hubs.presentation.HubsReducer.access$getEnvironment$p(r2)
                com.box.android.domain.metrics.hubs.HubsObservability r6 = r2.getHubsObservability()
                com.box.android.hubs.presentation.HubsReducer r2 = r0.this$0
                java.lang.String r7 = com.box.android.hubs.presentation.HubsReducer.access$getObservabilityId$p(r2)
                com.box.android.hubs.presentation.HubsReducer$State r2 = r0.$state
                com.box.android.domain.models.hubs.HubsDirection r8 = r2.getSortDirection()
                com.box.android.hubs.presentation.HubsReducer$State r2 = r0.$state
                com.box.android.domain.models.hubs.HubsSort r9 = r2.getSortBy()
                com.box.android.hubs.presentation.HubsReducer$State r2 = r0.$state
                com.box.android.domain.models.ItemsScreenMode r10 = r2.getItemsScreenMode()
                r13 = r0
                kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
                r0.label = r5
                r11 = 0
                r14 = 16
                r15 = 0
                java.lang.Object r0 = com.box.android.domain.metrics.hubs.HubsObservability.hubListLoadingStarted$default(r6, r7, r8, r9, r10, r11, r13, r14, r15)
                if (r0 != r1) goto La9
                goto La8
            L5d:
                boolean r5 = r2 instanceof com.box.android.hubs.presentation.HubsReducer.Action.Error
                if (r5 == 0) goto L85
                com.box.android.hubs.presentation.HubsReducer r2 = r0.this$0
                com.box.android.hubs.presentation.HubsEnvironment r2 = com.box.android.hubs.presentation.HubsReducer.access$getEnvironment$p(r2)
                com.box.android.domain.metrics.hubs.HubsObservability r2 = r2.getHubsObservability()
                com.box.android.hubs.presentation.HubsReducer r3 = r0.this$0
                java.lang.String r3 = com.box.android.hubs.presentation.HubsReducer.access$getObservabilityId$p(r3)
                com.box.android.hubs.presentation.HubsReducer$Action r5 = r0.$action
                com.box.android.hubs.presentation.HubsReducer$Action$Error r5 = (com.box.android.hubs.presentation.HubsReducer.Action.Error) r5
                com.box.android.domain.models.DomainError r5 = r5.getDomainError()
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.label = r4
                java.lang.Object r0 = r2.sendHubListFetchError(r3, r5, r6)
                if (r0 != r1) goto La9
                goto La8
            L85:
                boolean r2 = r2 instanceof com.box.android.hubs.presentation.HubsReducer.Action.ItemsUpdated
                if (r2 == 0) goto La9
                com.box.android.hubs.presentation.HubsReducer r2 = r0.this$0
                com.box.android.hubs.presentation.HubsEnvironment r2 = com.box.android.hubs.presentation.HubsReducer.access$getEnvironment$p(r2)
                com.box.android.domain.metrics.hubs.HubsObservability r4 = r2.getHubsObservability()
                com.box.android.hubs.presentation.HubsReducer r2 = r0.this$0
                java.lang.String r5 = com.box.android.hubs.presentation.HubsReducer.access$getObservabilityId$p(r2)
                r8 = r0
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r0.label = r3
                r6 = 0
                r9 = 2
                r10 = 0
                java.lang.Object r0 = com.box.android.domain.metrics.hubs.HubsObservability.sendHubListFetchSuccess$default(r4, r5, r6, r8, r9, r10)
                if (r0 != r1) goto La9
            La8:
                return r1
            La9:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.hubs.presentation.HubsReducer.C16491.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    private final ReducerResult<State, Action> handleHubAction(State state, Action.HubAction action) {
        HubReducer.Action hubAction = action.getHubAction();
        if (hubAction instanceof HubReducer.Action.Clicked) {
            if (state.isSelecting()) {
                return new ReducerResult<>(state, new Effect(new Action.HubAction(action.getId(), HubReducer.Action.CheckboxClicked.INSTANCE)));
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, null, false, false, new HubsRoute.HubDetails(action.getId()), null, 767, null), null, 2, null);
        }
        if (hubAction instanceof HubReducer.Action.CheckboxClicked) {
            HubReducer.State state2 = (HubReducer.State) state.getHubsList().getById(action.getId());
            HubModel hubModel = state2 != null ? state2.getHubModel() : null;
            if (hubModel != null) {
                return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.ToggleHub(hubModel))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
