package com.box.android.preview.item.labels;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.item.labels.classification.PreviewClassificationReducer;
import com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "environment", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;", "<init>", "(Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/item/labels/ItemPreviewLabelsEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceLabels", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemPreviewLabelsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final ItemPreviewLabelsEnvironment environment;

    public ItemPreviewLabelsReducer(ItemPreviewLabelsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new ItemPreviewLabelsReducer$build$1(this));
        final ItemPreviewLabelsReducer$build$2 itemPreviewLabelsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewLabelsReducer.State) obj).getOffline();
            }
        };
        final ItemPreviewLabelsReducer$build$3 itemPreviewLabelsReducer$build$3 = ItemPreviewLabelsReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new PreviewOfflineLabelReducer(environment.getOfflineLabelEnvironment()), new Function1<State, PreviewOfflineLabelReducer.State>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PreviewOfflineLabelReducer.State invoke(ItemPreviewLabelsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemPreviewLabelsReducer$build$2.invoke(it);
            }
        }, new Function1<Action, PreviewOfflineLabelReducer.Action>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final PreviewOfflineLabelReducer.Action invoke(ItemPreviewLabelsReducer.Action action) {
                if (!(action instanceof ItemPreviewLabelsReducer.Action.Offline)) {
                    action = null;
                }
                ItemPreviewLabelsReducer.Action.Offline offline = (ItemPreviewLabelsReducer.Action.Offline) action;
                if (offline != null) {
                    return offline.getAction();
                }
                return null;
            }
        }, new Function2<State, PreviewOfflineLabelReducer.State, State>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewLabelsReducer.State invoke(ItemPreviewLabelsReducer.State parentState, PreviewOfflineLabelReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemPreviewLabelsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewLabelsReducer.State.class)).iterator();
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
                            return (ItemPreviewLabelsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.labels.ItemPreviewLabelsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PreviewOfflineLabelReducer.Action, Action>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewLabelsReducer.Action invoke(PreviewOfflineLabelReducer.Action action) {
                Object objInvoke = itemPreviewLabelsReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewLabelsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.labels.ItemPreviewLabelsReducer.Action");
            }
        });
        final ItemPreviewLabelsReducer$build$5 itemPreviewLabelsReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewLabelsReducer.State) obj).getClassification();
            }
        };
        final ItemPreviewLabelsReducer$build$6 itemPreviewLabelsReducer$build$6 = ItemPreviewLabelsReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new PreviewClassificationReducer(), new Function1<State, PreviewClassificationReducer.State>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.item.labels.classification.PreviewClassificationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PreviewClassificationReducer.State invoke(ItemPreviewLabelsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemPreviewLabelsReducer$build$5.invoke(it);
            }
        }, new Function1<Action, PreviewClassificationReducer.Action>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final PreviewClassificationReducer.Action invoke(ItemPreviewLabelsReducer.Action action) {
                if (!(action instanceof ItemPreviewLabelsReducer.Action.Classification)) {
                    action = null;
                }
                ItemPreviewLabelsReducer.Action.Classification classification = (ItemPreviewLabelsReducer.Action.Classification) action;
                if (classification != null) {
                    return classification.getAction();
                }
                return null;
            }
        }, new Function2<State, PreviewClassificationReducer.State, State>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPreviewLabelsReducer.State invoke(ItemPreviewLabelsReducer.State parentState, PreviewClassificationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemPreviewLabelsReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPreviewLabelsReducer.State.class)).iterator();
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
                            return (ItemPreviewLabelsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.labels.ItemPreviewLabelsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PreviewClassificationReducer.Action, Action>() { // from class: com.box.android.preview.item.labels.ItemPreviewLabelsReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPreviewLabelsReducer.Action invoke(PreviewClassificationReducer.Action action) {
                Object objInvoke = itemPreviewLabelsReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ItemPreviewLabelsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.item.labels.ItemPreviewLabelsReducer.Action");
            }
        });
    }

    public final ItemPreviewLabelsEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;", "", BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "<init>", "(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;)V", "getOffline", "()Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;", "getClassification", "()Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$State;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final PreviewClassificationReducer.State classification;
        private final PreviewOfflineLabelReducer.State offline;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, PreviewOfflineLabelReducer.State state2, PreviewClassificationReducer.State state3, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.offline;
            }
            if ((i & 2) != 0) {
                state3 = state.classification;
            }
            return state.copy(state2, state3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PreviewOfflineLabelReducer.State getOffline() {
            return this.offline;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PreviewClassificationReducer.State getClassification() {
            return this.classification;
        }

        public final State copy(PreviewOfflineLabelReducer.State offline, PreviewClassificationReducer.State classification) {
            Intrinsics.checkNotNullParameter(offline, "offline");
            Intrinsics.checkNotNullParameter(classification, "classification");
            return new State(offline, classification);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.offline, state.offline) && Intrinsics.areEqual(this.classification, state.classification);
        }

        public int hashCode() {
            return (this.offline.hashCode() * 31) + this.classification.hashCode();
        }

        public String toString() {
            return "State(offline=" + this.offline + ", classification=" + this.classification + ")";
        }

        public State(PreviewOfflineLabelReducer.State offline, PreviewClassificationReducer.State classification) {
            Intrinsics.checkNotNullParameter(offline, "offline");
            Intrinsics.checkNotNullParameter(classification, "classification");
            this.offline = offline;
            this.classification = classification;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(PreviewOfflineLabelReducer.State state, PreviewClassificationReducer.State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            int i2 = 1;
            this((i & 1) != 0 ? new PreviewOfflineLabelReducer.State(null, i2, 0 == true ? 1 : 0) : state, (i & 2) != 0 ? new PreviewClassificationReducer.State(0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : state2);
        }

        public final PreviewOfflineLabelReducer.State getOffline() {
            return this.offline;
        }

        public final PreviewClassificationReducer.State getClassification() {
            return this.classification;
        }
    }

    /* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "", "<init>", "()V", "Classification", "Offline", "UpdateLabels", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$Classification;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$Offline;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$UpdateLabels;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$Classification;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;)V", "getAction", "()Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Classification extends Action implements Embedded<PreviewClassificationReducer.Action> {
            public static final int $stable = 0;
            private final PreviewClassificationReducer.Action action;

            public static /* synthetic */ Classification copy$default(Classification classification, PreviewClassificationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = classification.action;
                }
                return classification.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewClassificationReducer.Action getAction() {
                return this.action;
            }

            public final Classification copy(PreviewClassificationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Classification(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Classification) && Intrinsics.areEqual(this.action, ((Classification) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Classification(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Classification(PreviewClassificationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PreviewClassificationReducer.Action getAction() {
                return this.action;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$Offline;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;)V", "getAction", "()Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Offline extends Action implements Embedded<PreviewOfflineLabelReducer.Action> {
            public static final int $stable = 0;
            private final PreviewOfflineLabelReducer.Action action;

            public static /* synthetic */ Offline copy$default(Offline offline, PreviewOfflineLabelReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = offline.action;
                }
                return offline.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PreviewOfflineLabelReducer.Action getAction() {
                return this.action;
            }

            public final Offline copy(PreviewOfflineLabelReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Offline(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Offline) && Intrinsics.areEqual(this.action, ((Offline) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Offline(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Offline(PreviewOfflineLabelReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PreviewOfflineLabelReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action$UpdateLabels;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateLabels extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ UpdateLabels copy$default(UpdateLabels updateLabels, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = updateLabels.fileModel;
                }
                return updateLabels.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final UpdateLabels copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new UpdateLabels(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateLabels) && Intrinsics.areEqual(this.fileModel, ((UpdateLabels) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "UpdateLabels(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateLabels(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceLabels(State state, Action action) {
        Action.Offline offline;
        if (action instanceof Action.UpdateLabels) {
            Effect.Companion companion = Effect.INSTANCE;
            Action[] actionArr = new Action[3];
            if (this.environment.getFeatureFlips().getMigrateOfflineInfoToDb().getEnabled()) {
                offline = new Action.Offline(new PreviewOfflineLabelReducer.Action.ObserveOfflineState(((Action.UpdateLabels) action).getFileModel()));
            } else {
                offline = new Action.Offline(new PreviewOfflineLabelReducer.Action.ObserveOfflineJob(((Action.UpdateLabels) action).getFileModel()));
            }
            actionArr[0] = offline;
            Action.UpdateLabels updateLabels = (Action.UpdateLabels) action;
            actionArr[1] = new Action.Offline(new PreviewOfflineLabelReducer.Action.UpdateLabel(updateLabels.getFileModel()));
            actionArr[2] = new Action.Classification(new PreviewClassificationReducer.Action.UpdateLabel(updateLabels.getFileModel()));
            return new ReducerResult<>(state, companion.merge(actionArr));
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
