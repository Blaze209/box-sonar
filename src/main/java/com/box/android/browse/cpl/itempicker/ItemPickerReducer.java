package com.box.android.browse.cpl.itempicker;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.cpl.createfolder.CreateFolderReducer;
import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.common.utilities.CPLExtensionsKt;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachInListReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.data.CreateFolderMutation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ItemPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0019\u001a\u001b\u001cB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "environment", "Lcom/box/android/browse/cpl/itempicker/ItemPickerEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/itempicker/ItemPickerEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceItemPicker", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceCreateFolder", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "reduceItemsList", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "reduceOpenItem", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "navigateToFolder", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "State", "Route", "Action", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemPickerReducer implements Reducable<State, Action> {
    private static final String GLOBAL_SELECTION_OBSERVER_EFFECT_ID = "ITEM_PICKER_GLOBAL_SELECTION_OBSERVER";
    private final Reducable<State, Action> build;
    private final ItemPickerEnvironment environment;
    public static final int $stable = 8;

    public ItemPickerReducer(ItemPickerEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemPickerReducer.build$lambda$0(this.f$0, (ItemPickerReducer.State) obj, (ItemPickerReducer.Action) obj2);
            }
        });
        final ItemPickerReducer$build$2 itemPickerReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPickerReducer.State) obj).getStack();
            }
        };
        final ItemPickerReducer$build$3 itemPickerReducer$build$3 = ItemPickerReducer$build$3.INSTANCE;
        ForEachInListReducer forEachInListReducer = new ForEachInListReducer(reduce, new ItemsListReducer(environment.getItemsListViewEnvironment()), itemPickerReducer$build$2, new Function1<Action, EmbeddedItem<Integer, ItemsListReducer.Action>>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$forEachInList$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<Integer, ItemsListReducer.Action> invoke(ItemPickerReducer.Action action) {
                if (!(action instanceof ItemPickerReducer.Action.ItemsList)) {
                    action = null;
                }
                return (ItemPickerReducer.Action.ItemsList) action;
            }
        }, new Function3<State, ItemsListReducer.State, Integer, State>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$forEachInList$2
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.browse.cpl.itempicker.ItemPickerReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ ItemPickerReducer.State invoke(ItemPickerReducer.State state, ItemsListReducer.State state2, Integer num) {
                return invoke(state, state2, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final ItemPickerReducer.State invoke(ItemPickerReducer.State parentState, ItemsListReducer.State state, int i) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                List mutableList = CollectionsKt.toMutableList((Collection) itemPickerReducer$build$2.get(parentState));
                mutableList.set(i, state);
                KProperty1 kProperty1 = itemPickerReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPickerReducer.State.class)).iterator();
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
                            return (ItemPickerReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itempicker.ItemPickerReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<Integer, ItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$forEachInList$3
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.browse.cpl.itempicker.ItemPickerReducer$Action, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ItemPickerReducer.Action invoke(Integer num, ItemsListReducer.Action action) {
                return invoke(num.intValue(), action);
            }

            public final ItemPickerReducer.Action invoke(int i, ItemsListReducer.Action action) {
                Object objInvoke = itemPickerReducer$build$3.invoke(Integer.valueOf(i), action);
                if (objInvoke != null) {
                    return (ItemPickerReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itempicker.ItemPickerReducer.Action");
            }
        });
        final ItemPickerReducer$build$5 itemPickerReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPickerReducer.State) obj).getCreateFolderState();
            }
        };
        final ItemPickerReducer$build$6 itemPickerReducer$build$6 = ItemPickerReducer$build$6.INSTANCE;
        this.build = new IfLetReducer(forEachInListReducer, new CreateFolderReducer(environment.getCreateFolderEnvironment()), new Function1<State, CreateFolderReducer.State>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.createfolder.CreateFolderReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.State invoke(ItemPickerReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemPickerReducer$build$5.invoke(it);
            }
        }, new Function1<Action, CreateFolderReducer.Action>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CreateFolderReducer.Action invoke(ItemPickerReducer.Action action) {
                if (!(action instanceof ItemPickerReducer.Action.CreateFolderParentAction)) {
                    action = null;
                }
                ItemPickerReducer.Action.CreateFolderParentAction createFolderParentAction = (ItemPickerReducer.Action.CreateFolderParentAction) action;
                if (createFolderParentAction != null) {
                    return createFolderParentAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CreateFolderReducer.State, State>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemPickerReducer.State invoke(ItemPickerReducer.State parentState, CreateFolderReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemPickerReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemPickerReducer.State.class)).iterator();
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
                            return (ItemPickerReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itempicker.ItemPickerReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CreateFolderReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemPickerReducer.Action invoke(CreateFolderReducer.Action action) {
                Object objInvoke = itemPickerReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (ItemPickerReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itempicker.ItemPickerReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemPickerReducer.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0001IBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010:\u001a\u00020\u0003H\u0002J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010B\u001a\u00020\u0012HÆ\u0003Jj\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0010HÖ\u0001J\t\u0010H\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u00100\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b1\u0010!R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0015R\u0011\u00108\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0015¨\u0006J"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "", "isClosing", "", StackTraceHelper.STACK_KEY, "", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "itemPickerMode", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "createFolderState", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "navigationRoute", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;", "subtitle", "", "selectButtonName", "", "configBarMode", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "<init>", "(ZLjava/util/List;Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;)V", "()Z", "getStack", "()Ljava/util/List;", "getItemPickerMode", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "getCreateFolderState", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "getNavigationRoute", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;", "getSubtitle", "()Ljava/lang/String;", "getSelectButtonName", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfigBarMode", "()Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "selectedItem", "Lcom/box/android/domain/models/item/ItemModel;", "getSelectedItem", "()Lcom/box/android/domain/models/item/ItemModel;", "itemsListViewState", "getItemsListViewState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "currentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getCurrentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "error", "getError", "currentlyDisplayedFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "getCurrentlyDisplayedFolderId", "()Lcom/box/android/domain/models/ItemId$Remote;", "createFolderEnabled", "getCreateFolderEnabled", "selectFolderEnabled", "getSelectFolderEnabled", "isLoadingOrForbiddenState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ZLjava/util/List;Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;)Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "equals", "other", "hashCode", "toString", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        private final FilesDisplayConfigReducer.ConfigBarMode configBarMode;
        private final boolean createFolderEnabled;
        private final CreateFolderReducer.State createFolderState;
        private final FolderModel currentFolder;
        private final Integer error;
        private final boolean isClosing;
        private final ItemPickerMode itemPickerMode;
        private final ItemsListReducer.State itemsListViewState;
        private final Route navigationRoute;
        private final Integer selectButtonName;
        private final boolean selectFolderEnabled;
        private final List<ItemsListReducer.State> stack;
        private final String subtitle;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, List list, ItemPickerMode itemPickerMode, CreateFolderReducer.State state2, Route route, String str, Integer num, FilesDisplayConfigReducer.ConfigBarMode configBarMode, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isClosing;
            }
            if ((i & 2) != 0) {
                list = state.stack;
            }
            if ((i & 4) != 0) {
                itemPickerMode = state.itemPickerMode;
            }
            if ((i & 8) != 0) {
                state2 = state.createFolderState;
            }
            if ((i & 16) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 32) != 0) {
                str = state.subtitle;
            }
            if ((i & 64) != 0) {
                num = state.selectButtonName;
            }
            if ((i & 128) != 0) {
                configBarMode = state.configBarMode;
            }
            Integer num2 = num;
            FilesDisplayConfigReducer.ConfigBarMode configBarMode2 = configBarMode;
            Route route2 = route;
            String str2 = str;
            return state.copy(z, list, itemPickerMode, state2, route2, str2, num2, configBarMode2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        public final List<ItemsListReducer.State> component2() {
            return this.stack;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemPickerMode getItemPickerMode() {
            return this.itemPickerMode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getSelectButtonName() {
            return this.selectButtonName;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final FilesDisplayConfigReducer.ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        public final State copy(boolean isClosing, List<ItemsListReducer.State> stack, ItemPickerMode itemPickerMode, CreateFolderReducer.State createFolderState, Route navigationRoute, String subtitle, Integer selectButtonName, FilesDisplayConfigReducer.ConfigBarMode configBarMode) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(itemPickerMode, "itemPickerMode");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            return new State(isClosing, stack, itemPickerMode, createFolderState, navigationRoute, subtitle, selectButtonName, configBarMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isClosing == state.isClosing && Intrinsics.areEqual(this.stack, state.stack) && Intrinsics.areEqual(this.itemPickerMode, state.itemPickerMode) && Intrinsics.areEqual(this.createFolderState, state.createFolderState) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.subtitle, state.subtitle) && Intrinsics.areEqual(this.selectButtonName, state.selectButtonName) && this.configBarMode == state.configBarMode;
        }

        public int hashCode() {
            int iHashCode = ((((Boolean.hashCode(this.isClosing) * 31) + this.stack.hashCode()) * 31) + this.itemPickerMode.hashCode()) * 31;
            CreateFolderReducer.State state = this.createFolderState;
            int iHashCode2 = (((iHashCode + (state == null ? 0 : state.hashCode())) * 31) + this.navigationRoute.hashCode()) * 31;
            String str = this.subtitle;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.selectButtonName;
            return ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + this.configBarMode.hashCode();
        }

        public String toString() {
            return "State(isClosing=" + this.isClosing + ", stack=" + this.stack + ", itemPickerMode=" + this.itemPickerMode + ", createFolderState=" + this.createFolderState + ", navigationRoute=" + this.navigationRoute + ", subtitle=" + this.subtitle + ", selectButtonName=" + this.selectButtonName + ", configBarMode=" + this.configBarMode + ")";
        }

        public State(boolean z, List<ItemsListReducer.State> stack, ItemPickerMode itemPickerMode, CreateFolderReducer.State state, Route navigationRoute, String str, Integer num, FilesDisplayConfigReducer.ConfigBarMode configBarMode) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(itemPickerMode, "itemPickerMode");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            this.isClosing = z;
            this.stack = stack;
            this.itemPickerMode = itemPickerMode;
            this.createFolderState = state;
            this.navigationRoute = navigationRoute;
            this.subtitle = str;
            this.selectButtonName = num;
            this.configBarMode = configBarMode;
            ItemsListReducer.State state2 = (ItemsListReducer.State) CollectionsKt.last((List) stack);
            this.itemsListViewState = state2;
            this.currentFolder = state2.getCurrentFolder();
            this.error = state2.getError();
            this.createFolderEnabled = !isLoadingOrForbiddenState();
            this.selectFolderEnabled = !isLoadingOrForbiddenState();
        }

        public final boolean isClosing() {
            return this.isClosing;
        }

        public final List<ItemsListReducer.State> getStack() {
            return this.stack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(boolean z, List list, ItemPickerMode.Single single, CreateFolderReducer.State state, Route.None none, String str, Integer num, FilesDisplayConfigReducer.ConfigBarMode configBarMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, list, (i & 4) != 0 ? new ItemPickerMode.Single(null, 1, 0 == true ? 1 : 0) : single, (i & 8) != 0 ? null : state, (i & 16) != 0 ? Route.None.INSTANCE : none, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : num, (i & 128) != 0 ? FilesDisplayConfigReducer.ConfigBarMode.NONE : configBarMode);
        }

        public final ItemPickerMode getItemPickerMode() {
            return this.itemPickerMode;
        }

        public final CreateFolderReducer.State getCreateFolderState() {
            return this.createFolderState;
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final Integer getSelectButtonName() {
            return this.selectButtonName;
        }

        public final FilesDisplayConfigReducer.ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        public final ItemModel getSelectedItem() {
            ItemPickerMode itemPickerMode = this.itemPickerMode;
            ItemPickerMode.Single single = itemPickerMode instanceof ItemPickerMode.Single ? (ItemPickerMode.Single) itemPickerMode : null;
            if (single != null) {
                return single.getSelectedItem();
            }
            return null;
        }

        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        public final Integer getError() {
            return this.error;
        }

        public final ItemId.Remote getCurrentlyDisplayedFolderId() {
            return ItemModelKt.toItemIdRemoteId(this.currentFolder);
        }

        public final boolean getCreateFolderEnabled() {
            return this.createFolderEnabled;
        }

        public final boolean getSelectFolderEnabled() {
            return this.selectFolderEnabled;
        }

        private final boolean isLoadingOrForbiddenState() {
            return Intrinsics.areEqual(this.itemsListViewState.getItemLoadingState(), ItemsListReducer.LoadingState.Loading.INSTANCE) || Intrinsics.areEqual(this.itemsListViewState.getItemLoadingState(), ItemsListReducer.LoadingState.ForbiddenByPolicy.INSTANCE);
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "startingFolder", "Lcom/box/android/domain/models/item/FolderModel;", "itemPickerMode", "Lcom/box/android/browse/cpl/itempicker/ItemPickerMode;", "shouldDisableNonFolderItems", "", "configBarMode", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ State create$default(Companion companion, FolderModel folderModel, ItemPickerMode itemPickerMode, boolean z, FilesDisplayConfigReducer.ConfigBarMode configBarMode, int i, Object obj) {
                if ((i & 2) != 0) {
                    itemPickerMode = new ItemPickerMode.Single(null, 1, 0 == true ? 1 : 0);
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    configBarMode = FilesDisplayConfigReducer.ConfigBarMode.NONE;
                }
                return companion.create(folderModel, itemPickerMode, z, configBarMode);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final State create(FolderModel startingFolder, ItemPickerMode itemPickerMode, boolean shouldDisableNonFolderItems, FilesDisplayConfigReducer.ConfigBarMode configBarMode) {
                Intrinsics.checkNotNullParameter(startingFolder, "startingFolder");
                Intrinsics.checkNotNullParameter(itemPickerMode, "itemPickerMode");
                Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
                LocalSortPreferences.SortBy sortBy = null;
                LocalSortPreferences.SortOrder sortOrder = null;
                ItemsFilter itemsFilter = null;
                ItemsListReducer.LoadingState loadingState = null;
                IdentifiedList identifiedList = null;
                Integer num = null;
                Set set = null;
                boolean z = false;
                Function1 function1 = null;
                String str = null;
                ItemsListReducer.RefreshState refreshState = null;
                ItemsListReducer.CacheState cacheState = null;
                boolean z2 = false;
                boolean z3 = false;
                Object[] objArr = 0 == true ? 1 : 0;
                Object[] objArr2 = 0 == true ? 1 : 0;
                boolean z4 = false;
                CreateFolderReducer.State state = null;
                Route route = null;
                Object[] objArr3 = 0 == true ? 1 : 0;
                return new State(z4, CollectionsKt.listOf(new ItemsListReducer.State(loadingState, identifiedList, num, startingFolder, shouldDisableNonFolderItems, set, objArr, z, objArr2, function1, new FilesDisplayConfigReducer.State(configBarMode, sortBy, sortOrder, itemsFilter, 14, null), str, refreshState, cacheState, z2, z3, 64487, null)), itemPickerMode, state, route, 0 == true ? 1 : 0, objArr3, configBarMode, 121, 0 == true ? 1 : 0);
            }
        }
    }

    /* JADX INFO: compiled from: ItemPickerReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;", "", "<init>", "()V", "InviteCollaborators", "None", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route$InviteCollaborators;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route$None;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route$InviteCollaborators;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InviteCollaborators extends Route {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ InviteCollaborators copy$default(InviteCollaborators inviteCollaborators, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = inviteCollaborators.folder;
                }
                return inviteCollaborators.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
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

        private Route() {
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route$None;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1948620681;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: ItemPickerReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "", "<init>", "()V", "Close", "GoBack", "GoBackTo", "ConfirmSelection", CreateFolderMutation.OPERATION_NAME, "NavigatedToRoute", "HandleItemPickerMode", "ItemsList", "CreateFolderParentAction", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$Close;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$ConfirmSelection;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$CreateFolderParentAction;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$GoBack;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$GoBackTo;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$HandleItemPickerMode;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$ItemsList;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$NavigatedToRoute;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$Close;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends Action {
            public static final int $stable = 0;
            public static final Close INSTANCE = new Close();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Close)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1068631244;
            }

            public String toString() {
                return "Close";
            }

            private Close() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$GoBack;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1116240485;
            }

            public String toString() {
                return "GoBack";
            }

            private GoBack() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$GoBackTo;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;)V", "getFolderId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GoBackTo extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote folderId;

            public static /* synthetic */ GoBackTo copy$default(GoBackTo goBackTo, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = goBackTo.folderId;
                }
                return goBackTo.copy(remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getFolderId() {
                return this.folderId;
            }

            public final GoBackTo copy(ItemId.Remote folderId) {
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                return new GoBackTo(folderId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof GoBackTo) && Intrinsics.areEqual(this.folderId, ((GoBackTo) other).folderId);
            }

            public int hashCode() {
                return this.folderId.hashCode();
            }

            public String toString() {
                return "GoBackTo(folderId=" + this.folderId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GoBackTo(ItemId.Remote folderId) {
                super(null);
                Intrinsics.checkNotNullParameter(folderId, "folderId");
                this.folderId = folderId;
            }

            public final ItemId.Remote getFolderId() {
                return this.folderId;
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$ConfirmSelection;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ConfirmSelection extends Action {
            public static final int $stable = 0;
            public static final ConfirmSelection INSTANCE = new ConfirmSelection();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConfirmSelection)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -716288168;
            }

            public String toString() {
                return "ConfirmSelection";
            }

            private ConfirmSelection() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1487421238;
            }

            public String toString() {
                return CreateFolderMutation.OPERATION_NAME;
            }

            private CreateFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$NavigatedToRoute;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigatedToRoute extends Action {
            public static final int $stable = 0;
            public static final NavigatedToRoute INSTANCE = new NavigatedToRoute();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigatedToRoute)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1374763175;
            }

            public String toString() {
                return "NavigatedToRoute";
            }

            private NavigatedToRoute() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$HandleItemPickerMode;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandleItemPickerMode extends Action {
            public static final int $stable = 0;
            public static final HandleItemPickerMode INSTANCE = new HandleItemPickerMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleItemPickerMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 164480440;
            }

            public String toString() {
                return "HandleItemPickerMode";
            }

            private HandleItemPickerMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$ItemsList;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", FirebaseAnalytics.Param.INDEX, Analytics.Data.ACTION, "<init>", "(ILcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", "getIndex", "()I", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "component1", "()Ljava/lang/Integer;", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            public final ItemsListReducer.Action getHubAction() {
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

        /* JADX INFO: compiled from: ItemPickerReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action$CreateFolderParentAction;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "createFolderAction", "<init>", "(Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;)V", "getCreateFolderAction", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    public static final ReducerResult build$lambda$0(ItemPickerReducer itemPickerReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return itemPickerReducer.reduceItemPicker(state, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceItemPicker(State state, Action action) {
        MultiselectReducer.Action.DisableMultiSelectMode disableMultiSelectMode;
        Effect effectNone;
        if (Intrinsics.areEqual(action, Action.Close.INSTANCE)) {
            if (state.getItemPickerMode() instanceof ItemPickerMode.Multi) {
                effectNone = Effect.INSTANCE.cancel(GLOBAL_SELECTION_OBSERVER_EFFECT_ID);
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(State.copy$default(state, true, null, null, null, null, null, null, null, 254, null), effectNone);
        }
        if (Intrinsics.areEqual(action, Action.HandleItemPickerMode.INSTANCE)) {
            if (state.getItemPickerMode() instanceof ItemPickerMode.Multi) {
                disableMultiSelectMode = MultiselectReducer.Action.StartMultiSelectMode.INSTANCE;
            } else {
                disableMultiSelectMode = MultiselectReducer.Action.DisableMultiSelectMode.INSTANCE;
            }
            return new ReducerResult<>(state, new Effect(new Action.ItemsList(CollectionsKt.getLastIndex(state.getStack()), new ItemsListReducer.Action.Multiselect(disableMultiSelectMode))));
        }
        int i = 2;
        if (Intrinsics.areEqual(action, Action.GoBack.INSTANCE)) {
            Effect effectCancel = CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state.getItemsListViewState().getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state.getItemsListViewState().getUniqueCancelEffectKey()));
            if (state.getStack().size() > 1) {
                List mutableList = CollectionsKt.toMutableList((Collection) state.getStack());
                mutableList.remove(CollectionsKt.getLastIndex(mutableList));
                return new ReducerResult<>(State.copy$default(state, false, mutableList, null, null, null, null, null, null, 253, null), effectCancel);
            }
            return new ReducerResult<>(state, Effect.INSTANCE.merge(effectCancel, new Effect(Action.Close.INSTANCE)));
        }
        Effect effect = null;
        if (!(action instanceof Action.GoBackTo)) {
            if (Intrinsics.areEqual(action, Action.CreateFolder.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, new CreateFolderReducer.State("", state.getCurrentlyDisplayedFolderId(), null, null, false, false, false, 60, null), null, null, null, null, 247, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(action, Action.NavigatedToRoute.INSTANCE)) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, null, Route.None.INSTANCE, null, null, null, 231, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
            }
            if (action instanceof Action.CreateFolderParentAction) {
                return reduceCreateFolder(state, ((Action.CreateFolderParentAction) action).getCreateFolderAction());
            }
            if (action instanceof Action.ItemsList) {
                return reduceItemsList(state, ((Action.ItemsList) action).getAction());
            }
            if (action instanceof Action.ConfirmSelection) {
                ItemPickerMode itemPickerMode = state.getItemPickerMode();
                ItemPickerMode.Single single = itemPickerMode instanceof ItemPickerMode.Single ? (ItemPickerMode.Single) itemPickerMode : null;
                if (single == null) {
                    return new ReducerResult<>(state, null == true ? 1 : 0, i, null == true ? 1 : 0);
                }
                return new ReducerResult<>(State.copy$default(state, false, null, single.copy(state.getItemsListViewState().getCurrentFolder()), null, null, null, null, null, 251, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
            }
            return new ReducerResult<>(state, null == true ? 1 : 0, i, null == true ? 1 : 0);
        }
        Iterator<ItemsListReducer.State> it = state.getStack().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (Intrinsics.areEqual(ItemModelKt.toItemIdRemoteId(it.next().getCurrentFolder()), ((Action.GoBackTo) action).getFolderId())) {
                break;
            }
            i2++;
        }
        if (i2 < 0 || i2 >= CollectionsKt.getLastIndex(state.getStack())) {
            return new ReducerResult<>(state, effect, i, null == true ? 1 : 0);
        }
        int i3 = i2 + 1;
        IntRange intRange = new IntRange(i3, CollectionsKt.getLastIndex(state.getStack()));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it2 = intRange.iterator();
        while (it2.hasNext()) {
            ItemsListReducer.State state2 = state.getStack().get(((IntIterator) it2).nextInt());
            arrayList.add(CPLExtensionsKt.cancel(Effect.INSTANCE, ItemsListReducer.INSTANCE.fetchItemsEffectId(state2.getUniqueCancelEffectKey()), ItemsListReducer.INSTANCE.refreshItemsEffectId(state2.getUniqueCancelEffectKey())));
        }
        State stateCopy$default = State.copy$default(state, false, new ArrayList(state.getStack().subList(0, i3)), null, null, null, null, null, null, 253, null);
        Effect.Companion companion = Effect.INSTANCE;
        Effect[] effectArr = (Effect[]) arrayList.toArray(new Effect[0]);
        return new ReducerResult<>(stateCopy$default, companion.merge((Effect[]) Arrays.copyOf(effectArr, effectArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceCreateFolder(State state, CreateFolderReducer.Action action) {
        int i = 2;
        Effect effect = null;
        if (action instanceof CreateFolderReducer.Action.FolderCreationCancelled) {
            return new ReducerResult<>(State.copy$default(state, false, null, null, null, null, null, null, null, 247, null), effect, i, null == true ? 1 : 0);
        }
        if (action instanceof CreateFolderReducer.Action.FolderCreated) {
            CreateFolderReducer.State createFolderState = state.getCreateFolderState();
            if (createFolderState != null ? Intrinsics.areEqual((Object) createFolderState.getInviteCollaborators(), (Object) true) : false) {
                return new ReducerResult<>(State.copy$default(state, false, null, null, null, new Route.InviteCollaborators(((CreateFolderReducer.Action.FolderCreated) action).getFolder()), null, null, null, 231, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
            }
            return new ReducerResult<>(State.copy$default(state, false, null, null, null, null, null, null, null, 247, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
        }
        return new ReducerResult<>(state, null == true ? 1 : 0, i, null == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceItemsList(State state, ItemsListReducer.Action action) {
        if (action instanceof ItemsListReducer.Action.OpenItem) {
            return reduceOpenItem(state, ((ItemsListReducer.Action.OpenItem) action).getId());
        }
        return new ReducerResult<>(state, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceOpenItem(State state, ItemId.Remote itemId) {
        ItemModel item = state.getItemsListViewState().getItem(itemId);
        ItemPickerMode itemPickerMode = state.getItemPickerMode();
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (itemPickerMode instanceof ItemPickerMode.Single) {
            if (item instanceof FolderModel) {
                return navigateToFolder(state, (FolderModel) item);
            }
            return new ReducerResult<>(State.copy$default(state, false, null, ((ItemPickerMode.Single) itemPickerMode).copy(item), null, null, null, null, null, 251, null), effect, i, objArr3 == true ? 1 : 0);
        }
        if (!(itemPickerMode instanceof ItemPickerMode.Multi)) {
            throw new NoWhenBranchMatchedException();
        }
        if (item instanceof FolderModel) {
            return navigateToFolder(state, (FolderModel) item);
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> navigateToFolder(State state, FolderModel folder) {
        List mutableList = CollectionsKt.toMutableList((Collection) state.getStack());
        ItemsListReducer.LoadingState loadingState = null;
        IdentifiedList identifiedList = null;
        Integer num = null;
        Set set = null;
        BoxFeatureBanner boxFeatureBanner = null;
        boolean z = false;
        ItemsListReducer.RefreshState refreshState = null;
        ItemsListReducer.CacheState cacheState = null;
        boolean z2 = false;
        boolean z3 = false;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        mutableList.add(new ItemsListReducer.State(loadingState, identifiedList, num, folder, state.getItemsListViewState().getShouldDisableNonFolderItems(), set, boxFeatureBanner, z, objArr2, objArr3, new FilesDisplayConfigReducer.State(state.getConfigBarMode(), null, null, null, 14, null), objArr, refreshState, cacheState, z2, z3, 64487, null));
        return new ReducerResult<>(State.copy$default(state, false, mutableList, null, null, null, null, null, null, 253, null), new Effect(Action.HandleItemPickerMode.INSTANCE));
    }
}
