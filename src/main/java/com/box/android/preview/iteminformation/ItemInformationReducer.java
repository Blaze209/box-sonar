package com.box.android.preview.iteminformation;

import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.cpl.ThumbnailSource;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemCollaborationModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.metadata.FileMetadataInstanceModel;
import com.box.android.domain.models.metadata.MetadataTemplateModel;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.androidsdk.content.SizeUtils;
import com.box.androidsdk.content.models.BoxFile;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableMap;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0012\u0013\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "environment", "Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;", "<init>", "(Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "analyticEventsEffect", "", "Lcom/box/android/cpl/Effect;", "state", "(Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;)[Lcom/box/android/cpl/Effect;", "Route", "Error", "State", "ItemDetails", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final ItemInformationEnvironment environment;

    public ItemInformationReducer(ItemInformationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemInformationReducer.build$lambda$0(this.f$0, (ItemInformationReducer.State) obj, (ItemInformationReducer.Action) obj2);
            }
        });
        final ItemInformationReducer$build$2 itemInformationReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemInformationReducer.State) obj).getUpdateItemInfoState();
            }
        };
        final ItemInformationReducer$build$3 itemInformationReducer$build$3 = ItemInformationReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new UpdateItemInfoReducer(environment.getUpdateItemInfoEnvironment()), new Function1<State, UpdateItemInfoReducer.State>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.preview.fileactions.UpdateItemInfoReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final UpdateItemInfoReducer.State invoke(ItemInformationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemInformationReducer$build$2.invoke(it);
            }
        }, new Function1<Action, UpdateItemInfoReducer.Action>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final UpdateItemInfoReducer.Action invoke(ItemInformationReducer.Action action) {
                if (!(action instanceof ItemInformationReducer.Action.UpdateItemInfo)) {
                    action = null;
                }
                ItemInformationReducer.Action.UpdateItemInfo updateItemInfo = (ItemInformationReducer.Action.UpdateItemInfo) action;
                if (updateItemInfo != null) {
                    return updateItemInfo.getCreateFolderAction();
                }
                return null;
            }
        }, new Function2<State, UpdateItemInfoReducer.State, State>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemInformationReducer.State invoke(ItemInformationReducer.State parentState, UpdateItemInfoReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemInformationReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemInformationReducer.State.class)).iterator();
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
                            return (ItemInformationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.iteminformation.ItemInformationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<UpdateItemInfoReducer.Action, Action>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemInformationReducer.Action invoke(UpdateItemInfoReducer.Action action) {
                Object objInvoke = itemInformationReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ItemInformationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.iteminformation.ItemInformationReducer.Action");
            }
        });
        final ItemInformationReducer$build$5 itemInformationReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemInformationReducer.State) obj).getItemThumbnailState();
            }
        };
        final ItemInformationReducer$build$6 itemInformationReducer$build$6 = ItemInformationReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new ItemThumbnailReducer(environment.getItemThumbnailEnvironment()), new Function1<State, ItemThumbnailReducer.State>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemThumbnailReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.State invoke(ItemInformationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemInformationReducer$build$5.invoke(it);
            }
        }, new Function1<Action, ItemThumbnailReducer.Action>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.Action invoke(ItemInformationReducer.Action action) {
                if (!(action instanceof ItemInformationReducer.Action.ItemThumbnail)) {
                    action = null;
                }
                ItemInformationReducer.Action.ItemThumbnail itemThumbnail = (ItemInformationReducer.Action.ItemThumbnail) action;
                if (itemThumbnail != null) {
                    return itemThumbnail.getCreateFolderAction();
                }
                return null;
            }
        }, new Function2<State, ItemThumbnailReducer.State, State>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemInformationReducer.State invoke(ItemInformationReducer.State parentState, ItemThumbnailReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemInformationReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemInformationReducer.State.class)).iterator();
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
                            return (ItemInformationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.iteminformation.ItemInformationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemThumbnailReducer.Action, Action>() { // from class: com.box.android.preview.iteminformation.ItemInformationReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemInformationReducer.Action invoke(ItemThumbnailReducer.Action action) {
                Object objInvoke = itemInformationReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ItemInformationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.iteminformation.ItemInformationReducer.Action");
            }
        });
    }

    public final ItemInformationEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "", "<init>", "()V", "None", "Collaborators", "Exit", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$Collaborators;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$Exit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$None;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$None;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 442802510;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$Collaborators;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Collaborators extends Route {
            public static final int $stable = 0;
            public static final Collaborators INSTANCE = new Collaborators();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Collaborators)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -482142249;
            }

            public String toString() {
                return "Collaborators";
            }

            private Collaborators() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route$Exit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Exit extends Route {
            public static final int $stable = 0;
            public static final Exit INSTANCE = new Exit();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Exit)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 442542900;
            }

            public String toString() {
                return "Exit";
            }

            private Exit() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error;", "", "<init>", "()V", "RefreshFailed", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error$RefreshFailed;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Error {
        public static final int $stable = 0;

        public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error$RefreshFailed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFailed extends Error {
            public static final int $stable = 0;
            public static final RefreshFailed INSTANCE = new RefreshFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1482190625;
            }

            public String toString() {
                return "RefreshFailed";
            }

            private RefreshFailed() {
                super(null);
            }
        }

        private Error() {
        }
    }

    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007HÆ\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0081\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010:\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010$¨\u0006?"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "itemThumbnailState", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "collaborations", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "navigationRoute", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "updateItemInfoState", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "showUnsavedInfoConfirmationDialog", "", "metadataItems", "Lcom/box/android/preview/iteminformation/MetadataItem;", "templates", "Lkotlinx/collections/immutable/ImmutableMap;", "", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "error", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/base/cpl/ItemThumbnailReducer$State;Lkotlinx/collections/immutable/ImmutableList;Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;ZLkotlinx/collections/immutable/ImmutableList;Lkotlinx/collections/immutable/ImmutableMap;Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getItemThumbnailState", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "getCollaborations", "()Lkotlinx/collections/immutable/ImmutableList;", "getNavigationRoute", "()Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "getUpdateItemInfoState", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "getShowUnsavedInfoConfirmationDialog", "()Z", "getMetadataItems", "getTemplates", "()Lkotlinx/collections/immutable/ImmutableMap;", "getError", "()Lcom/box/android/preview/iteminformation/ItemInformationReducer$Error;", "details", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$ItemDetails;", "getDetails", "()Lcom/box/android/preview/iteminformation/ItemInformationReducer$ItemDetails;", "hasUnsavedInfo", "getHasUnsavedInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final ImmutableList<ItemCollaborationModel> collaborations;
        private final ItemDetails details;
        private final Error error;
        private final ItemModel itemModel;
        private final ItemThumbnailReducer.State itemThumbnailState;
        private final ImmutableList<MetadataItem> metadataItems;
        private final Route navigationRoute;
        private final boolean showUnsavedInfoConfirmationDialog;
        private final ImmutableMap<String, MetadataTemplateModel> templates;
        private final UpdateItemInfoReducer.State updateItemInfoState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemModel itemModel, ItemThumbnailReducer.State state2, ImmutableList immutableList, Route route, UpdateItemInfoReducer.State state3, boolean z, ImmutableList immutableList2, ImmutableMap immutableMap, Error error, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = state.itemModel;
            }
            if ((i & 2) != 0) {
                state2 = state.itemThumbnailState;
            }
            if ((i & 4) != 0) {
                immutableList = state.collaborations;
            }
            if ((i & 8) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 16) != 0) {
                state3 = state.updateItemInfoState;
            }
            if ((i & 32) != 0) {
                z = state.showUnsavedInfoConfirmationDialog;
            }
            if ((i & 64) != 0) {
                immutableList2 = state.metadataItems;
            }
            if ((i & 128) != 0) {
                immutableMap = state.templates;
            }
            if ((i & 256) != 0) {
                error = state.error;
            }
            ImmutableMap immutableMap2 = immutableMap;
            Error error2 = error;
            boolean z2 = z;
            ImmutableList immutableList3 = immutableList2;
            UpdateItemInfoReducer.State state4 = state3;
            ImmutableList immutableList4 = immutableList;
            return state.copy(itemModel, state2, immutableList4, route, state4, z2, immutableList3, immutableMap2, error2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemThumbnailReducer.State getItemThumbnailState() {
            return this.itemThumbnailState;
        }

        public final ImmutableList<ItemCollaborationModel> component3() {
            return this.collaborations;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final UpdateItemInfoReducer.State getUpdateItemInfoState() {
            return this.updateItemInfoState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getShowUnsavedInfoConfirmationDialog() {
            return this.showUnsavedInfoConfirmationDialog;
        }

        public final ImmutableList<MetadataItem> component7() {
            return this.metadataItems;
        }

        public final ImmutableMap<String, MetadataTemplateModel> component8() {
            return this.templates;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Error getError() {
            return this.error;
        }

        public final State copy(ItemModel itemModel, ItemThumbnailReducer.State itemThumbnailState, ImmutableList<ItemCollaborationModel> collaborations, Route navigationRoute, UpdateItemInfoReducer.State updateItemInfoState, boolean showUnsavedInfoConfirmationDialog, ImmutableList<MetadataItem> metadataItems, ImmutableMap<String, MetadataTemplateModel> templates, Error error) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            Intrinsics.checkNotNullParameter(itemThumbnailState, "itemThumbnailState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(updateItemInfoState, "updateItemInfoState");
            Intrinsics.checkNotNullParameter(templates, "templates");
            return new State(itemModel, itemThumbnailState, collaborations, navigationRoute, updateItemInfoState, showUnsavedInfoConfirmationDialog, metadataItems, templates, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemModel, state.itemModel) && Intrinsics.areEqual(this.itemThumbnailState, state.itemThumbnailState) && Intrinsics.areEqual(this.collaborations, state.collaborations) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.updateItemInfoState, state.updateItemInfoState) && this.showUnsavedInfoConfirmationDialog == state.showUnsavedInfoConfirmationDialog && Intrinsics.areEqual(this.metadataItems, state.metadataItems) && Intrinsics.areEqual(this.templates, state.templates) && Intrinsics.areEqual(this.error, state.error);
        }

        public int hashCode() {
            int iHashCode = ((this.itemModel.hashCode() * 31) + this.itemThumbnailState.hashCode()) * 31;
            ImmutableList<ItemCollaborationModel> immutableList = this.collaborations;
            int iHashCode2 = (((((((iHashCode + (immutableList == null ? 0 : immutableList.hashCode())) * 31) + this.navigationRoute.hashCode()) * 31) + this.updateItemInfoState.hashCode()) * 31) + Boolean.hashCode(this.showUnsavedInfoConfirmationDialog)) * 31;
            ImmutableList<MetadataItem> immutableList2 = this.metadataItems;
            int iHashCode3 = (((iHashCode2 + (immutableList2 == null ? 0 : immutableList2.hashCode())) * 31) + this.templates.hashCode()) * 31;
            Error error = this.error;
            return iHashCode3 + (error != null ? error.hashCode() : 0);
        }

        public String toString() {
            return "State(itemModel=" + this.itemModel + ", itemThumbnailState=" + this.itemThumbnailState + ", collaborations=" + this.collaborations + ", navigationRoute=" + this.navigationRoute + ", updateItemInfoState=" + this.updateItemInfoState + ", showUnsavedInfoConfirmationDialog=" + this.showUnsavedInfoConfirmationDialog + ", metadataItems=" + this.metadataItems + ", templates=" + this.templates + ", error=" + this.error + ")";
        }

        public State(ItemModel itemModel, ItemThumbnailReducer.State itemThumbnailState, ImmutableList<ItemCollaborationModel> immutableList, Route navigationRoute, UpdateItemInfoReducer.State updateItemInfoState, boolean z, ImmutableList<MetadataItem> immutableList2, ImmutableMap<String, MetadataTemplateModel> templates, Error error) {
            String name;
            String formattedSize;
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            Intrinsics.checkNotNullParameter(itemThumbnailState, "itemThumbnailState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(updateItemInfoState, "updateItemInfoState");
            Intrinsics.checkNotNullParameter(templates, "templates");
            this.itemModel = itemModel;
            this.itemThumbnailState = itemThumbnailState;
            this.collaborations = immutableList;
            this.navigationRoute = navigationRoute;
            this.updateItemInfoState = updateItemInfoState;
            this.showUnsavedInfoConfirmationDialog = z;
            this.metadataItems = immutableList2;
            this.templates = templates;
            this.error = error;
            String str = "";
            String fileExtension = CommonBoxUtil.getFileExtension(itemModel.getName(), "");
            Long size = itemModel.getSize();
            String string = (size == null || (formattedSize = SizeUtils.INSTANCE.toFormattedSize(size.longValue())) == null || (string = StringsKt.trim((CharSequence) formattedSize).toString()) == null) ? "" : string;
            UserModel owner = itemModel.getOwner();
            String name2 = (owner == null || (name2 = owner.getName()) == null) ? "" : name2;
            UserModel updatedBy = itemModel.getUpdatedBy();
            if (updatedBy != null && (name = updatedBy.getName()) != null) {
                str = name;
            }
            this.details = new ItemDetails(fileExtension, string, name2, str, ItemModelKt.type(itemModel) == ItemType.FILE);
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public /* synthetic */ State(ItemModel itemModel, ItemThumbnailReducer.State state, ImmutableList immutableList, Route route, UpdateItemInfoReducer.State state2, boolean z, ImmutableList immutableList2, ImmutableMap immutableMap, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemModel, (i & 2) != 0 ? new ItemThumbnailReducer.State(new ThumbnailSource.Item(itemModel, true), null, false, 6, null) : state, (i & 4) != 0 ? null : immutableList, (i & 8) != 0 ? Route.None.INSTANCE : route, (i & 16) != 0 ? UpdateItemInfoReducer.State.Companion.createInitialState$default(UpdateItemInfoReducer.State.INSTANCE, itemModel, null, null, null, false, false, 62, null) : state2, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : immutableList2, (i & 128) != 0 ? ExtensionsKt.persistentMapOf() : immutableMap, (i & 256) != 0 ? null : error);
        }

        public final ItemThumbnailReducer.State getItemThumbnailState() {
            return this.itemThumbnailState;
        }

        public final ImmutableList<ItemCollaborationModel> getCollaborations() {
            return this.collaborations;
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final UpdateItemInfoReducer.State getUpdateItemInfoState() {
            return this.updateItemInfoState;
        }

        public final boolean getShowUnsavedInfoConfirmationDialog() {
            return this.showUnsavedInfoConfirmationDialog;
        }

        public final ImmutableList<MetadataItem> getMetadataItems() {
            return this.metadataItems;
        }

        public final ImmutableMap<String, MetadataTemplateModel> getTemplates() {
            return this.templates;
        }

        public final Error getError() {
            return this.error;
        }

        public final ItemDetails getDetails() {
            return this.details;
        }

        public final boolean getHasUnsavedInfo() {
            return this.updateItemInfoState.getHasUnsavedNameChanges() || this.updateItemInfoState.getHasUnsavedDescriptionChanges();
        }
    }

    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$ItemDetails;", "", BoxFile.FIELD_EXTENSION, "", "size", "ownerName", "updatedByName", "isFile", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getExtension", "()Ljava/lang/String;", "getSize", "getOwnerName", "getUpdatedByName", "()Z", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemDetails {
        public static final int $stable = 0;
        private final String extension;
        private final boolean isFile;
        private final String ownerName;
        private final String size;
        private final String updatedByName;

        public ItemDetails() {
            this(null, null, null, null, false, 31, null);
        }

        public static /* synthetic */ ItemDetails copy$default(ItemDetails itemDetails, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemDetails.extension;
            }
            if ((i & 2) != 0) {
                str2 = itemDetails.size;
            }
            if ((i & 4) != 0) {
                str3 = itemDetails.ownerName;
            }
            if ((i & 8) != 0) {
                str4 = itemDetails.updatedByName;
            }
            if ((i & 16) != 0) {
                z = itemDetails.isFile;
            }
            boolean z2 = z;
            String str5 = str3;
            return itemDetails.copy(str, str2, str5, str4, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getExtension() {
            return this.extension;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOwnerName() {
            return this.ownerName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUpdatedByName() {
            return this.updatedByName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsFile() {
            return this.isFile;
        }

        public final ItemDetails copy(String extension, String size, String ownerName, String updatedByName, boolean isFile) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(ownerName, "ownerName");
            Intrinsics.checkNotNullParameter(updatedByName, "updatedByName");
            return new ItemDetails(extension, size, ownerName, updatedByName, isFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemDetails)) {
                return false;
            }
            ItemDetails itemDetails = (ItemDetails) other;
            return Intrinsics.areEqual(this.extension, itemDetails.extension) && Intrinsics.areEqual(this.size, itemDetails.size) && Intrinsics.areEqual(this.ownerName, itemDetails.ownerName) && Intrinsics.areEqual(this.updatedByName, itemDetails.updatedByName) && this.isFile == itemDetails.isFile;
        }

        public int hashCode() {
            return (((((((this.extension.hashCode() * 31) + this.size.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.updatedByName.hashCode()) * 31) + Boolean.hashCode(this.isFile);
        }

        public String toString() {
            return "ItemDetails(extension=" + this.extension + ", size=" + this.size + ", ownerName=" + this.ownerName + ", updatedByName=" + this.updatedByName + ", isFile=" + this.isFile + ")";
        }

        public ItemDetails(String extension, String size, String ownerName, String updatedByName, boolean z) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(ownerName, "ownerName");
            Intrinsics.checkNotNullParameter(updatedByName, "updatedByName");
            this.extension = extension;
            this.size = size;
            this.ownerName = ownerName;
            this.updatedByName = updatedByName;
            this.isFile = z;
        }

        public /* synthetic */ ItemDetails(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? true : z);
        }

        public final String getExtension() {
            return this.extension;
        }

        public final String getSize() {
            return this.size;
        }

        public final String getOwnerName() {
            return this.ownerName;
        }

        public final String getUpdatedByName() {
            return this.updatedByName;
        }

        public final boolean isFile() {
            return this.isFile;
        }
    }

    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "", "<init>", "()V", "Initialize", "ErrorHandled", "ItemRefreshed", "ItemRefreshFailed", "FetchCollaborations", "CollaborationsFetchSuccess", "CollaborationsFetchFailed", "FetchMetadata", "MetadataFetchSuccess", "FetchMetadataTemplates", "MetadataTemplatesFetchSuccess", "Navigate", "UpdateItemInfo", "ItemThumbnail", "Save", "DiscardChangesAndExit", "KeepChanges", "TriggerExit", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$CollaborationsFetchFailed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$CollaborationsFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$DiscardChangesAndExit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ErrorHandled;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchCollaborations;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchMetadata;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchMetadataTemplates;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Initialize;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemRefreshFailed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemRefreshed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemThumbnail;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$KeepChanges;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$MetadataFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$MetadataTemplatesFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Navigate;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Save;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$TriggerExit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$UpdateItemInfo;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Initialize;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ErrorHandled;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ErrorHandled extends Action {
            public static final int $stable = 0;
            public static final ErrorHandled INSTANCE = new ErrorHandled();

            private ErrorHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemRefreshed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemRefreshed extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ ItemRefreshed copy$default(ItemRefreshed itemRefreshed, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = itemRefreshed.itemModel;
                }
                return itemRefreshed.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final ItemRefreshed copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new ItemRefreshed(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemRefreshed) && Intrinsics.areEqual(this.itemModel, ((ItemRefreshed) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "ItemRefreshed(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemRefreshed(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemRefreshFailed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemRefreshFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ ItemRefreshFailed copy$default(ItemRefreshFailed itemRefreshFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = itemRefreshFailed.error;
                }
                return itemRefreshFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final ItemRefreshFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ItemRefreshFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemRefreshFailed) && Intrinsics.areEqual(this.error, ((ItemRefreshFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ItemRefreshFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemRefreshFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchCollaborations;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "itemId", "Lcom/box/android/domain/models/ItemId;", "<init>", "(Lcom/box/android/domain/models/ItemId;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchCollaborations extends Action {
            public static final int $stable = 8;
            private final ItemId itemId;

            public static /* synthetic */ FetchCollaborations copy$default(FetchCollaborations fetchCollaborations, ItemId itemId, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemId = fetchCollaborations.itemId;
                }
                return fetchCollaborations.copy(itemId);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId getItemId() {
                return this.itemId;
            }

            public final FetchCollaborations copy(ItemId itemId) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                return new FetchCollaborations(itemId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FetchCollaborations) && Intrinsics.areEqual(this.itemId, ((FetchCollaborations) other).itemId);
            }

            public int hashCode() {
                return this.itemId.hashCode();
            }

            public String toString() {
                return "FetchCollaborations(itemId=" + this.itemId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchCollaborations(ItemId itemId) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                this.itemId = itemId;
            }

            public final ItemId getItemId() {
                return this.itemId;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$CollaborationsFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "collaborations", "", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "<init>", "(Ljava/util/List;)V", "getCollaborations", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationsFetchSuccess extends Action {
            public static final int $stable = 8;
            private final List<ItemCollaborationModel> collaborations;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CollaborationsFetchSuccess copy$default(CollaborationsFetchSuccess collaborationsFetchSuccess, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = collaborationsFetchSuccess.collaborations;
                }
                return collaborationsFetchSuccess.copy(list);
            }

            public final List<ItemCollaborationModel> component1() {
                return this.collaborations;
            }

            public final CollaborationsFetchSuccess copy(List<ItemCollaborationModel> collaborations) {
                Intrinsics.checkNotNullParameter(collaborations, "collaborations");
                return new CollaborationsFetchSuccess(collaborations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaborationsFetchSuccess) && Intrinsics.areEqual(this.collaborations, ((CollaborationsFetchSuccess) other).collaborations);
            }

            public int hashCode() {
                return this.collaborations.hashCode();
            }

            public String toString() {
                return "CollaborationsFetchSuccess(collaborations=" + this.collaborations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollaborationsFetchSuccess(List<ItemCollaborationModel> collaborations) {
                super(null);
                Intrinsics.checkNotNullParameter(collaborations, "collaborations");
                this.collaborations = collaborations;
            }

            public final List<ItemCollaborationModel> getCollaborations() {
                return this.collaborations;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$CollaborationsFetchFailed;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationsFetchFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ CollaborationsFetchFailed copy$default(CollaborationsFetchFailed collaborationsFetchFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = collaborationsFetchFailed.error;
                }
                return collaborationsFetchFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final CollaborationsFetchFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new CollaborationsFetchFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaborationsFetchFailed) && Intrinsics.areEqual(this.error, ((CollaborationsFetchFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "CollaborationsFetchFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollaborationsFetchFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchMetadata;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "itemId", "Lcom/box/android/domain/models/ItemId;", "<init>", "(Lcom/box/android/domain/models/ItemId;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchMetadata extends Action {
            public static final int $stable = 8;
            private final ItemId itemId;

            public static /* synthetic */ FetchMetadata copy$default(FetchMetadata fetchMetadata, ItemId itemId, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemId = fetchMetadata.itemId;
                }
                return fetchMetadata.copy(itemId);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId getItemId() {
                return this.itemId;
            }

            public final FetchMetadata copy(ItemId itemId) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                return new FetchMetadata(itemId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FetchMetadata) && Intrinsics.areEqual(this.itemId, ((FetchMetadata) other).itemId);
            }

            public int hashCode() {
                return this.itemId.hashCode();
            }

            public String toString() {
                return "FetchMetadata(itemId=" + this.itemId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchMetadata(ItemId itemId) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                this.itemId = itemId;
            }

            public final ItemId getItemId() {
                return this.itemId;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$MetadataFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "instances", "", "Lcom/box/android/domain/models/metadata/FileMetadataInstanceModel;", "<init>", "(Ljava/util/List;)V", "getInstances", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MetadataFetchSuccess extends Action {
            public static final int $stable = 8;
            private final List<FileMetadataInstanceModel> instances;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MetadataFetchSuccess copy$default(MetadataFetchSuccess metadataFetchSuccess, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = metadataFetchSuccess.instances;
                }
                return metadataFetchSuccess.copy(list);
            }

            public final List<FileMetadataInstanceModel> component1() {
                return this.instances;
            }

            public final MetadataFetchSuccess copy(List<FileMetadataInstanceModel> instances) {
                Intrinsics.checkNotNullParameter(instances, "instances");
                return new MetadataFetchSuccess(instances);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MetadataFetchSuccess) && Intrinsics.areEqual(this.instances, ((MetadataFetchSuccess) other).instances);
            }

            public int hashCode() {
                return this.instances.hashCode();
            }

            public String toString() {
                return "MetadataFetchSuccess(instances=" + this.instances + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MetadataFetchSuccess(List<FileMetadataInstanceModel> instances) {
                super(null);
                Intrinsics.checkNotNullParameter(instances, "instances");
                this.instances = instances;
            }

            public final List<FileMetadataInstanceModel> getInstances() {
                return this.instances;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$FetchMetadataTemplates;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class FetchMetadataTemplates extends Action {
            public static final int $stable = 0;
            public static final FetchMetadataTemplates INSTANCE = new FetchMetadataTemplates();

            private FetchMetadataTemplates() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$MetadataTemplatesFetchSuccess;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "templates", "Lkotlinx/collections/immutable/ImmutableMap;", "", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "<init>", "(Lkotlinx/collections/immutable/ImmutableMap;)V", "getTemplates", "()Lkotlinx/collections/immutable/ImmutableMap;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MetadataTemplatesFetchSuccess extends Action {
            public static final int $stable = 8;
            private final ImmutableMap<String, MetadataTemplateModel> templates;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MetadataTemplatesFetchSuccess copy$default(MetadataTemplatesFetchSuccess metadataTemplatesFetchSuccess, ImmutableMap immutableMap, int i, Object obj) {
                if ((i & 1) != 0) {
                    immutableMap = metadataTemplatesFetchSuccess.templates;
                }
                return metadataTemplatesFetchSuccess.copy(immutableMap);
            }

            public final ImmutableMap<String, MetadataTemplateModel> component1() {
                return this.templates;
            }

            public final MetadataTemplatesFetchSuccess copy(ImmutableMap<String, MetadataTemplateModel> templates) {
                Intrinsics.checkNotNullParameter(templates, "templates");
                return new MetadataTemplatesFetchSuccess(templates);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MetadataTemplatesFetchSuccess) && Intrinsics.areEqual(this.templates, ((MetadataTemplatesFetchSuccess) other).templates);
            }

            public int hashCode() {
                return this.templates.hashCode();
            }

            public String toString() {
                return "MetadataTemplatesFetchSuccess(templates=" + this.templates + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MetadataTemplatesFetchSuccess(ImmutableMap<String, MetadataTemplateModel> templates) {
                super(null);
                Intrinsics.checkNotNullParameter(templates, "templates");
                this.templates = templates;
            }

            public final ImmutableMap<String, MetadataTemplateModel> getTemplates() {
                return this.templates;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Navigate;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "route", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "<init>", "(Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;)V", "getRoute", "()Lcom/box/android/preview/iteminformation/ItemInformationReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Navigate extends Action {
            public static final int $stable = 0;
            private final Route route;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, Route route, int i, Object obj) {
                if ((i & 1) != 0) {
                    route = navigate.route;
                }
                return navigate.copy(route);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Route getRoute() {
                return this.route;
            }

            public final Navigate copy(Route route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new Navigate(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && Intrinsics.areEqual(this.route, ((Navigate) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "Navigate(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Navigate(Route route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final Route getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$UpdateItemInfo;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;)V", "getAction", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateItemInfo extends Action implements Embedded<UpdateItemInfoReducer.Action> {
            public static final int $stable = 0;
            private final UpdateItemInfoReducer.Action action;

            public static /* synthetic */ UpdateItemInfo copy$default(UpdateItemInfo updateItemInfo, UpdateItemInfoReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = updateItemInfo.action;
                }
                return updateItemInfo.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UpdateItemInfoReducer.Action getCreateFolderAction() {
                return this.action;
            }

            public final UpdateItemInfo copy(UpdateItemInfoReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new UpdateItemInfo(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateItemInfo) && Intrinsics.areEqual(this.action, ((UpdateItemInfo) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "UpdateItemInfo(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateItemInfo(UpdateItemInfoReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final UpdateItemInfoReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$ItemThumbnail;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemThumbnail extends Action implements Embedded<ItemThumbnailReducer.Action> {
            public static final int $stable = ItemThumbnailReducer.Action.$stable;
            private final ItemThumbnailReducer.Action action;

            public static /* synthetic */ ItemThumbnail copy$default(ItemThumbnail itemThumbnail, ItemThumbnailReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = itemThumbnail.action;
                }
                return itemThumbnail.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemThumbnailReducer.Action getCreateFolderAction() {
                return this.action;
            }

            public final ItemThumbnail copy(ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemThumbnail(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemThumbnail) && Intrinsics.areEqual(this.action, ((ItemThumbnail) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ItemThumbnail(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemThumbnail(ItemThumbnailReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$Save;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Save extends Action {
            public static final int $stable = 0;
            public static final Save INSTANCE = new Save();

            private Save() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$DiscardChangesAndExit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DiscardChangesAndExit extends Action {
            public static final int $stable = 0;
            public static final DiscardChangesAndExit INSTANCE = new DiscardChangesAndExit();

            private DiscardChangesAndExit() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$KeepChanges;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class KeepChanges extends Action {
            public static final int $stable = 0;
            public static final KeepChanges INSTANCE = new KeepChanges();

            private KeepChanges() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemInformationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action$TriggerExit;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TriggerExit extends Action {
            public static final int $stable = 0;
            public static final TriggerExit INSTANCE = new TriggerExit();

            private TriggerExit() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(ItemInformationReducer itemInformationReducer, State state, Action action) {
        Effect effectNone;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = false;
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (action instanceof Action.Initialize) {
            boolean z2 = ItemModelKt.type(state.getItemModel()) == ItemType.FILE;
            Effect effect = EffectKt.toEffect(FlowKt.flow(new ItemInformationReducer$build$1$itemRefreshEffect$1(itemInformationReducer, state, null)));
            if (z2) {
                effect = Effect.INSTANCE.merge(effect, new Effect(Action.FetchMetadataTemplates.INSTANCE));
            }
            return new ReducerResult(state, effect);
        }
        if (action instanceof Action.ItemRefreshed) {
            ItemModel itemModel = ((Action.ItemRefreshed) action).getItemModel();
            return new ReducerResult(State.copy$default(state, itemModel, ItemThumbnailReducer.State.copy$default(state.getItemThumbnailState(), new ThumbnailSource.Item(itemModel, z, i, defaultConstructorMarker), null, false, 6, null), null, null, null, false, null, null, null, 508, null), Effect.INSTANCE.merge(new Effect(new Action.FetchCollaborations(itemModel.getItemId())), new Effect(new Action.ItemThumbnail(ItemThumbnailReducer.Action.FetchThumbnail.INSTANCE)), new Effect(new Action.UpdateItemInfo(new UpdateItemInfoReducer.Action.ItemRefreshed(itemModel)))));
        }
        if (action instanceof Action.ItemRefreshFailed) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, Error.RefreshFailed.INSTANCE, 255, null), null, 2, null);
        }
        if (action instanceof Action.FetchCollaborations) {
            return new ReducerResult(state, new Effect((Function1) new ItemInformationReducer$build$1$1(itemInformationReducer, state, null)));
        }
        if (action instanceof Action.CollaborationsFetchSuccess) {
            return new ReducerResult(State.copy$default(state, null, null, ExtensionsKt.toImmutableList(((Action.CollaborationsFetchSuccess) action).getCollaborations()), null, null, false, null, null, null, 507, null), null, 2, null);
        }
        if (action instanceof Action.CollaborationsFetchFailed) {
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.FetchMetadata) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new ItemInformationReducer$build$1$2(itemInformationReducer, action, null))));
        }
        if (action instanceof Action.MetadataFetchSuccess) {
            List<FileMetadataInstanceModel> instances = ((Action.MetadataFetchSuccess) action).getInstances();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = instances.iterator();
            while (it.hasNext()) {
                MetadataItem item = MetadataItemKt.toItem((FileMetadataInstanceModel) it.next(), state.getTemplates());
                if (item != null) {
                    arrayList.add(item);
                }
            }
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, ExtensionsKt.toImmutableList(arrayList), null, null, 447, null), null, 2, null);
        }
        if (action instanceof Action.FetchMetadataTemplates) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new ItemInformationReducer$build$1$3(itemInformationReducer, state, null))));
        }
        if (action instanceof Action.MetadataTemplatesFetchSuccess) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, ((Action.MetadataTemplatesFetchSuccess) action).getTemplates(), null, 383, null), null, 2, null);
        }
        if (action instanceof Action.Navigate) {
            Action.Navigate navigate = (Action.Navigate) action;
            if (Intrinsics.areEqual(navigate.getRoute(), Route.Collaborators.INSTANCE)) {
                effectNone = Effect.INSTANCE.fireAndForget(new ItemInformationReducer$build$1$effect$1(itemInformationReducer, state, null));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult(State.copy$default(state, null, null, null, navigate.getRoute(), null, false, null, null, null, 503, null), effectNone);
        }
        if (action instanceof Action.Save) {
            Effect effectNone2 = Effect.INSTANCE.none();
            if (state.getHasUnsavedInfo()) {
                effectNone2 = new Effect(new Action.UpdateItemInfo(UpdateItemInfoReducer.Action.PerformUpdate.INSTANCE));
                Effect<Action>[] effectArrAnalyticEventsEffect = itemInformationReducer.analyticEventsEffect(state);
                effectNone2.merge((Effect[]) Arrays.copyOf(effectArrAnalyticEventsEffect, effectArrAnalyticEventsEffect.length));
            }
            return new ReducerResult(state, effectNone2);
        }
        if (action instanceof Action.KeepChanges) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, null, 479, null), null, 2, null);
        }
        if (action instanceof Action.DiscardChangesAndExit) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, UpdateItemInfoReducer.State.Companion.createInitialState$default(UpdateItemInfoReducer.State.INSTANCE, state.getItemModel(), null, null, null, false, false, 62, null), false, null, null, null, 463, null), new Effect(Action.TriggerExit.INSTANCE));
        }
        if (action instanceof Action.UpdateItemInfo) {
            Action.UpdateItemInfo updateItemInfo = (Action.UpdateItemInfo) action;
            if (updateItemInfo.getAction() instanceof UpdateItemInfoReducer.Action.Success) {
                return new ReducerResult(State.copy$default(state, ((UpdateItemInfoReducer.Action.Success) updateItemInfo.getAction()).getItemModel(), null, null, null, null, false, null, null, null, 510, null), null, 2, null);
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.ItemThumbnail) {
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.TriggerExit) {
            if (state.getHasUnsavedInfo()) {
                return new ReducerResult(State.copy$default(state, null, null, null, null, null, true, null, null, null, 479, null), null, 2, null);
            }
            return new ReducerResult(state, new Effect(new Action.Navigate(Route.Exit.INSTANCE)));
        }
        if (action instanceof Action.ErrorHandled) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, null, 255, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Effect<Action>[] analyticEventsEffect(State state) {
        ArrayList arrayList = new ArrayList();
        if (state.getUpdateItemInfoState().getHasUnsavedNameChanges()) {
            arrayList.add(Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, null)));
        }
        if (state.getUpdateItemInfoState().getHasUnsavedDescriptionChanges()) {
            arrayList.add(Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)));
        }
        return (Effect[]) arrayList.toArray(new Effect[0]);
    }

    /* JADX INFO: renamed from: com.box.android.preview.iteminformation.ItemInformationReducer$analyticEventsEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$analyticEventsEffect$1", f = "ItemInformationReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ItemInformationReducer.this.new AnonymousClass1(this.$state, continuation);
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
            ItemInformationReducer.this.getEnvironment().getAnalytics().renameTriggered(this.$state.getItemModel());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.iteminformation.ItemInformationReducer$analyticEventsEffect$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemInformationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$analyticEventsEffect$2", f = "ItemInformationReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
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
            return ItemInformationReducer.this.new AnonymousClass2(this.$state, continuation);
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
            ItemInformationReducer.this.getEnvironment().getAnalytics().descriptionUpdateTriggered(this.$state.getItemModel());
            return Unit.INSTANCE;
        }
    }
}
