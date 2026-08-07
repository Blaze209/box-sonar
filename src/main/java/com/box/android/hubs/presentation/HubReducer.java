package com.box.android.hubs.presentation;

import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.cpl.ThumbnailSource;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.hubs.HubModel;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: HubReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/hubs/presentation/HubReducer$State;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "environment", "Lcom/box/android/hubs/presentation/HubsEnvironment;", "observabilityId", "", "<init>", "(Lcom/box/android/hubs/presentation/HubsEnvironment;Ljava/lang/String;)V", "formatObservabilityId", "state", "assetType", "reduceObservability", "Lcom/box/android/cpl/ReducerResult;", Analytics.Data.ACTION, "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "Action", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final HubsEnvironment environment;
    private final String observabilityId;

    public HubReducer(HubsEnvironment environment, String observabilityId) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
        this.environment = environment;
        this.observabilityId = observabilityId;
        Reduce reduce = new Reduce(new HubReducer$build$1(this));
        final HubReducer$build$2 hubReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.hubs.presentation.HubReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((HubReducer.State) obj).getBannerThumbnailState();
            }
        };
        final HubReducer$build$3 hubReducer$build$3 = HubReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new ItemThumbnailReducer(environment.getThumbnailEnvironment()), new Function1<State, ItemThumbnailReducer.State>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemThumbnailReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.State invoke(HubReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return hubReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ItemThumbnailReducer.Action>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.Action invoke(HubReducer.Action action) {
                if (!(action instanceof HubReducer.Action.BannerThumbnailAction)) {
                    action = null;
                }
                HubReducer.Action.BannerThumbnailAction bannerThumbnailAction = (HubReducer.Action.BannerThumbnailAction) action;
                if (bannerThumbnailAction != null) {
                    return bannerThumbnailAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemThumbnailReducer.State, State>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final HubReducer.State invoke(HubReducer.State parentState, ItemThumbnailReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = hubReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(HubReducer.State.class)).iterator();
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
                            return (HubReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemThumbnailReducer.Action, Action>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HubReducer.Action invoke(ItemThumbnailReducer.Action action) {
                Object objInvoke = hubReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (HubReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubReducer.Action");
            }
        });
        final HubReducer$build$5 hubReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.hubs.presentation.HubReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((HubReducer.State) obj).getIconThumbnailState();
            }
        };
        final HubReducer$build$6 hubReducer$build$6 = HubReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new ItemThumbnailReducer(environment.getThumbnailEnvironment()), new Function1<State, ItemThumbnailReducer.State>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemThumbnailReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.State invoke(HubReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return hubReducer$build$5.invoke(it);
            }
        }, new Function1<Action, ItemThumbnailReducer.Action>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.Action invoke(HubReducer.Action action) {
                if (!(action instanceof HubReducer.Action.IconThumbnailAction)) {
                    action = null;
                }
                HubReducer.Action.IconThumbnailAction iconThumbnailAction = (HubReducer.Action.IconThumbnailAction) action;
                if (iconThumbnailAction != null) {
                    return iconThumbnailAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemThumbnailReducer.State, State>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final HubReducer.State invoke(HubReducer.State parentState, ItemThumbnailReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = hubReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(HubReducer.State.class)).iterator();
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
                            return (HubReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemThumbnailReducer.Action, Action>() { // from class: com.box.android.hubs.presentation.HubReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HubReducer.Action invoke(ItemThumbnailReducer.Action action) {
                Object objInvoke = hubReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (HubReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.hubs.presentation.HubReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: HubReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0002HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jf\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\t\u0010.\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$State;", "Lcom/box/android/cpl/Identifiable;", "", "id", "hubModel", "Lcom/box/android/domain/models/hubs/HubModel;", "title", "bannerThumbnailState", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "iconThumbnailState", "accessCount", "", "description", "updatedDate", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/hubs/HubModel;Ljava/lang/String;Lcom/box/android/base/cpl/ItemThumbnailReducer$State;Lcom/box/android/base/cpl/ItemThumbnailReducer$State;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getHubModel", "()Lcom/box/android/domain/models/hubs/HubModel;", "getTitle", "getBannerThumbnailState", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "getIconThumbnailState", "getAccessCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getUpdatedDate", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/hubs/HubModel;Ljava/lang/String;Lcom/box/android/base/cpl/ItemThumbnailReducer$State;Lcom/box/android/base/cpl/ItemThumbnailReducer$State;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Date;)Lcom/box/android/hubs/presentation/HubReducer$State;", "equals", "", "other", "", "hashCode", "toString", "Companion", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<String> {
        private final Integer accessCount;
        private final ItemThumbnailReducer.State bannerThumbnailState;
        private final String description;
        private final HubModel hubModel;
        private final ItemThumbnailReducer.State iconThumbnailState;
        private final String id;
        private final String title;
        private final Date updatedDate;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ State copy$default(State state, String str, HubModel hubModel, String str2, ItemThumbnailReducer.State state2, ItemThumbnailReducer.State state3, Integer num, String str3, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.id;
            }
            if ((i & 2) != 0) {
                hubModel = state.hubModel;
            }
            if ((i & 4) != 0) {
                str2 = state.title;
            }
            if ((i & 8) != 0) {
                state2 = state.bannerThumbnailState;
            }
            if ((i & 16) != 0) {
                state3 = state.iconThumbnailState;
            }
            if ((i & 32) != 0) {
                num = state.accessCount;
            }
            if ((i & 64) != 0) {
                str3 = state.description;
            }
            if ((i & 128) != 0) {
                date = state.updatedDate;
            }
            String str4 = str3;
            Date date2 = date;
            ItemThumbnailReducer.State state4 = state3;
            Integer num2 = num;
            return state.copy(str, hubModel, str2, state2, state4, num2, str4, date2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final HubModel getHubModel() {
            return this.hubModel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ItemThumbnailReducer.State getBannerThumbnailState() {
            return this.bannerThumbnailState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ItemThumbnailReducer.State getIconThumbnailState() {
            return this.iconThumbnailState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getAccessCount() {
            return this.accessCount;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Date getUpdatedDate() {
            return this.updatedDate;
        }

        public final State copy(String id, HubModel hubModel, String title, ItemThumbnailReducer.State bannerThumbnailState, ItemThumbnailReducer.State iconThumbnailState, Integer accessCount, String description, Date updatedDate) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(hubModel, "hubModel");
            Intrinsics.checkNotNullParameter(bannerThumbnailState, "bannerThumbnailState");
            Intrinsics.checkNotNullParameter(iconThumbnailState, "iconThumbnailState");
            return new State(id, hubModel, title, bannerThumbnailState, iconThumbnailState, accessCount, description, updatedDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.id, state.id) && Intrinsics.areEqual(this.hubModel, state.hubModel) && Intrinsics.areEqual(this.title, state.title) && Intrinsics.areEqual(this.bannerThumbnailState, state.bannerThumbnailState) && Intrinsics.areEqual(this.iconThumbnailState, state.iconThumbnailState) && Intrinsics.areEqual(this.accessCount, state.accessCount) && Intrinsics.areEqual(this.description, state.description) && Intrinsics.areEqual(this.updatedDate, state.updatedDate);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.hubModel.hashCode()) * 31;
            String str = this.title;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.bannerThumbnailState.hashCode()) * 31) + this.iconThumbnailState.hashCode()) * 31;
            Integer num = this.accessCount;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.description;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Date date = this.updatedDate;
            return iHashCode4 + (date != null ? date.hashCode() : 0);
        }

        public String toString() {
            return "State(id=" + this.id + ", hubModel=" + this.hubModel + ", title=" + this.title + ", bannerThumbnailState=" + this.bannerThumbnailState + ", iconThumbnailState=" + this.iconThumbnailState + ", accessCount=" + this.accessCount + ", description=" + this.description + ", updatedDate=" + this.updatedDate + ")";
        }

        public State(String id, HubModel hubModel, String str, ItemThumbnailReducer.State bannerThumbnailState, ItemThumbnailReducer.State iconThumbnailState, Integer num, String str2, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(hubModel, "hubModel");
            Intrinsics.checkNotNullParameter(bannerThumbnailState, "bannerThumbnailState");
            Intrinsics.checkNotNullParameter(iconThumbnailState, "iconThumbnailState");
            this.id = id;
            this.hubModel = hubModel;
            this.title = str;
            this.bannerThumbnailState = bannerThumbnailState;
            this.iconThumbnailState = iconThumbnailState;
            this.accessCount = num;
            this.description = str2;
            this.updatedDate = date;
        }

        @Override // com.box.android.cpl.Identifiable
        public String getId() {
            return this.id;
        }

        public final HubModel getHubModel() {
            return this.hubModel;
        }

        public final String getTitle() {
            return this.title;
        }

        public final ItemThumbnailReducer.State getBannerThumbnailState() {
            return this.bannerThumbnailState;
        }

        public final ItemThumbnailReducer.State getIconThumbnailState() {
            return this.iconThumbnailState;
        }

        public final Integer getAccessCount() {
            return this.accessCount;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Date getUpdatedDate() {
            return this.updatedDate;
        }

        /* JADX INFO: compiled from: HubReducer.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$State$Companion;", "", "<init>", "()V", "createState", "Lcom/box/android/hubs/presentation/HubReducer$State;", "hubModel", "Lcom/box/android/domain/models/hubs/HubModel;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final State createState(HubModel hubModel) {
                Intrinsics.checkNotNullParameter(hubModel, "hubModel");
                return new State(hubModel.getId(), hubModel, hubModel.getTitle(), new ItemThumbnailReducer.State(new ThumbnailSource.HubAsset(hubModel.getBannerImage()), null, false, 6, null), new ItemThumbnailReducer.State(new ThumbnailSource.HubAsset(hubModel.getIconImage()), null, false, 6, null), hubModel.getAccessCount(), hubModel.getDescriptionPreview(), hubModel.getUpdatedAt());
            }
        }
    }

    /* JADX INFO: compiled from: HubReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$Action;", "", "<init>", "()V", "Clicked", "CheckboxClicked", "BannerThumbnailAction", "IconThumbnailAction", "Lcom/box/android/hubs/presentation/HubReducer$Action$BannerThumbnailAction;", "Lcom/box/android/hubs/presentation/HubReducer$Action$CheckboxClicked;", "Lcom/box/android/hubs/presentation/HubReducer$Action$Clicked;", "Lcom/box/android/hubs/presentation/HubReducer$Action$IconThumbnailAction;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$Action$Clicked;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Clicked extends Action {
            public static final int $stable = 0;
            public static final Clicked INSTANCE = new Clicked();

            private Clicked() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: HubReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$Action$CheckboxClicked;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CheckboxClicked extends Action {
            public static final int $stable = 0;
            public static final CheckboxClicked INSTANCE = new CheckboxClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckboxClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1554159184;
            }

            public String toString() {
                return "CheckboxClicked";
            }

            private CheckboxClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$Action$BannerThumbnailAction;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BannerThumbnailAction extends Action implements Embedded<ItemThumbnailReducer.Action> {
            public static final int $stable = ItemThumbnailReducer.Action.$stable;
            private final ItemThumbnailReducer.Action action;

            public static /* synthetic */ BannerThumbnailAction copy$default(BannerThumbnailAction bannerThumbnailAction, ItemThumbnailReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = bannerThumbnailAction.action;
                }
                return bannerThumbnailAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }

            public final BannerThumbnailAction copy(ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new BannerThumbnailAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BannerThumbnailAction) && Intrinsics.areEqual(this.action, ((BannerThumbnailAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "BannerThumbnailAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BannerThumbnailAction(ItemThumbnailReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: HubReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/hubs/presentation/HubReducer$Action$IconThumbnailAction;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class IconThumbnailAction extends Action implements Embedded<ItemThumbnailReducer.Action> {
            public static final int $stable = ItemThumbnailReducer.Action.$stable;
            private final ItemThumbnailReducer.Action action;

            public static /* synthetic */ IconThumbnailAction copy$default(IconThumbnailAction iconThumbnailAction, ItemThumbnailReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = iconThumbnailAction.action;
                }
                return iconThumbnailAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }

            public final IconThumbnailAction copy(ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new IconThumbnailAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof IconThumbnailAction) && Intrinsics.areEqual(this.action, ((IconThumbnailAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "IconThumbnailAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IconThumbnailAction(ItemThumbnailReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatObservabilityId(State state, String assetType) {
        return this.observabilityId + "_" + state.getId() + "_" + assetType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceObservability(State state, Action action) {
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, this, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.hubs.presentation.HubReducer$reduceObservability$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.presentation.HubReducer$reduceObservability$1", f = "HubReducer.kt", i = {}, l = {64, 69, 75, 86, 91, 97}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;
        final /* synthetic */ HubReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Action action, HubReducer hubReducer, State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.this$0 = hubReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.this$0, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
        
            if (com.box.android.domain.metrics.hubs.HubsObservability.hubAssetLoadingStarted$default(r11.this$0.environment.getHubsObservability(), r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_BANNER), com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_BANNER, 0, r11, 4, null) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x007f, code lost:
        
            if (r11.this$0.environment.getHubsObservability().sendHubAssetFetchFailure(r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_BANNER), ((com.box.android.base.cpl.ItemThumbnailReducer.Action.ThumbnailError) ((com.box.android.hubs.presentation.HubReducer.Action.BannerThumbnailAction) r11.$action).getAction()).getError(), r11) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
        
            if (com.box.android.domain.metrics.hubs.HubsObservability.sendHubAssetFetchSuccess$default(r11.this$0.environment.getHubsObservability(), r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_BANNER), 0, r11, 2, null) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
        
            if (com.box.android.domain.metrics.hubs.HubsObservability.hubAssetLoadingStarted$default(r11.this$0.environment.getHubsObservability(), r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_ICON), com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_ICON, 0, r11, 4, null) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x010e, code lost:
        
            if (r11.this$0.environment.getHubsObservability().sendHubAssetFetchFailure(r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_ICON), ((com.box.android.base.cpl.ItemThumbnailReducer.Action.ThumbnailError) ((com.box.android.hubs.presentation.HubReducer.Action.IconThumbnailAction) r11.$action).getAction()).getError(), r11) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0135, code lost:
        
            if (com.box.android.domain.metrics.hubs.HubsObservability.sendHubAssetFetchSuccess$default(r11.this$0.environment.getHubsObservability(), r11.this$0.formatObservabilityId(r11.$state, com.box.android.domain.metrics.hubs.HubsObservability.HUB_ASSET_ICON), 0, r11, 2, null) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0137, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 334
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.hubs.presentation.HubReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}
