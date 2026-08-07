package com.box.android.notes.presentation.cpl;

import com.box.android.browse.cpl.itemsList.ItemsListReducer;
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
import com.box.android.domain.models.item.ItemModel;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.NoteAnnotation;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.Iterator;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NotesListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "environment", "Lcom/box/android/notes/presentation/cpl/NotesEnvironment;", "<init>", "(Lcom/box/android/notes/presentation/cpl/NotesEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceNotes", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceChildItemsList", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ItemsListAction;", "toggleFavorite", "Lcom/box/android/cpl/Effect;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "Route", "State", "Action", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesListReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final NotesEnvironment environment;

    public NotesListReducer(NotesEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new NotesListReducer$build$1(this));
        final NotesListReducer$build$2 notesListReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.notes.presentation.cpl.NotesListReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NotesListReducer.State) obj).getItemsListViewState();
            }
        };
        final NotesListReducer$build$3 notesListReducer$build$3 = NotesListReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new ItemsListReducer(environment.getItemsListViewEnvironment()), new Function1<State, ItemsListReducer.State>() { // from class: com.box.android.notes.presentation.cpl.NotesListReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.ItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.State invoke(NotesListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return notesListReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ItemsListReducer.Action>() { // from class: com.box.android.notes.presentation.cpl.NotesListReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemsListReducer.Action invoke(NotesListReducer.Action action) {
                if (!(action instanceof NotesListReducer.Action.ItemsListAction)) {
                    action = null;
                }
                NotesListReducer.Action.ItemsListAction itemsListAction = (NotesListReducer.Action.ItemsListAction) action;
                if (itemsListAction != null) {
                    return itemsListAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemsListReducer.State, State>() { // from class: com.box.android.notes.presentation.cpl.NotesListReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final NotesListReducer.State invoke(NotesListReducer.State parentState, ItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = notesListReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(NotesListReducer.State.class)).iterator();
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
                            return (NotesListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.notes.presentation.cpl.NotesListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemsListReducer.Action, Action>() { // from class: com.box.android.notes.presentation.cpl.NotesListReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NotesListReducer.Action invoke(ItemsListReducer.Action action) {
                Object objInvoke = notesListReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (NotesListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.notes.presentation.cpl.NotesListReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "", "<init>", "()V", NoteAnnotation.NOTE, "NewNote", "None", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$NewNote;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$None;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$Note;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$Note;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/ItemModel;", "item", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Note extends Route implements Embedded<ItemModel> {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ Note copy$default(Note note, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = note.item;
                }
                return note.copy(itemModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getAction() {
                return this.item;
            }

            public final Note copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new Note(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Note) && Intrinsics.areEqual(this.item, ((Note) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "Note(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Note(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$NewNote;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NewNote extends Route {
            public static final int $stable = 0;
            public static final NewNote INSTANCE = new NewNote();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NewNote)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 768729747;
            }

            public String toString() {
                return "NewNote";
            }

            private NewNote() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route$None;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 70966775;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Je\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "", "itemsListViewState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "canCreateBoxNote", "", "isScrollToTopAfterPreviewEnabled", "currentUserId", "", ViewProps.VISIBLE, "navigationRoute", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "favoriteUpdateError", "Lcom/box/android/domain/models/DomainError;", "navigatedToPreview", "shouldScrollToTop", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;ZZLjava/lang/String;ZLcom/box/android/notes/presentation/cpl/NotesListReducer$Route;Lcom/box/android/domain/models/DomainError;ZZ)V", "getItemsListViewState", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "getCanCreateBoxNote", "()Z", "getCurrentUserId", "()Ljava/lang/String;", "getVisible", "getNavigationRoute", "()Lcom/box/android/notes/presentation/cpl/NotesListReducer$Route;", "getFavoriteUpdateError", "()Lcom/box/android/domain/models/DomainError;", "getNavigatedToPreview", "getShouldScrollToTop", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean canCreateBoxNote;
        private final String currentUserId;
        private final DomainError favoriteUpdateError;
        private final boolean isScrollToTopAfterPreviewEnabled;
        private final ItemsListReducer.State itemsListViewState;
        private final boolean navigatedToPreview;
        private final Route navigationRoute;
        private final boolean shouldScrollToTop;
        private final boolean visible;

        public static /* synthetic */ State copy$default(State state, ItemsListReducer.State state2, boolean z, boolean z2, String str, boolean z3, Route route, DomainError domainError, boolean z4, boolean z5, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.itemsListViewState;
            }
            if ((i & 2) != 0) {
                z = state.canCreateBoxNote;
            }
            if ((i & 4) != 0) {
                z2 = state.isScrollToTopAfterPreviewEnabled;
            }
            if ((i & 8) != 0) {
                str = state.currentUserId;
            }
            if ((i & 16) != 0) {
                z3 = state.visible;
            }
            if ((i & 32) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 64) != 0) {
                domainError = state.favoriteUpdateError;
            }
            if ((i & 128) != 0) {
                z4 = state.navigatedToPreview;
            }
            if ((i & 256) != 0) {
                z5 = state.shouldScrollToTop;
            }
            boolean z6 = z4;
            boolean z7 = z5;
            Route route2 = route;
            DomainError domainError2 = domainError;
            boolean z8 = z3;
            boolean z9 = z2;
            return state.copy(state2, z, z9, str, z8, route2, domainError2, z6, z7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanCreateBoxNote() {
            return this.canCreateBoxNote;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsScrollToTopAfterPreviewEnabled() {
            return this.isScrollToTopAfterPreviewEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCurrentUserId() {
            return this.currentUserId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final DomainError getFavoriteUpdateError() {
            return this.favoriteUpdateError;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getNavigatedToPreview() {
            return this.navigatedToPreview;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getShouldScrollToTop() {
            return this.shouldScrollToTop;
        }

        public final State copy(ItemsListReducer.State itemsListViewState, boolean canCreateBoxNote, boolean isScrollToTopAfterPreviewEnabled, String currentUserId, boolean visible, Route navigationRoute, DomainError favoriteUpdateError, boolean navigatedToPreview, boolean shouldScrollToTop) {
            Intrinsics.checkNotNullParameter(itemsListViewState, "itemsListViewState");
            Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            return new State(itemsListViewState, canCreateBoxNote, isScrollToTopAfterPreviewEnabled, currentUserId, visible, navigationRoute, favoriteUpdateError, navigatedToPreview, shouldScrollToTop);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemsListViewState, state.itemsListViewState) && this.canCreateBoxNote == state.canCreateBoxNote && this.isScrollToTopAfterPreviewEnabled == state.isScrollToTopAfterPreviewEnabled && Intrinsics.areEqual(this.currentUserId, state.currentUserId) && this.visible == state.visible && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.favoriteUpdateError, state.favoriteUpdateError) && this.navigatedToPreview == state.navigatedToPreview && this.shouldScrollToTop == state.shouldScrollToTop;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.itemsListViewState.hashCode() * 31) + Boolean.hashCode(this.canCreateBoxNote)) * 31) + Boolean.hashCode(this.isScrollToTopAfterPreviewEnabled)) * 31) + this.currentUserId.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.navigationRoute.hashCode()) * 31;
            DomainError domainError = this.favoriteUpdateError;
            return ((((iHashCode + (domainError == null ? 0 : domainError.hashCode())) * 31) + Boolean.hashCode(this.navigatedToPreview)) * 31) + Boolean.hashCode(this.shouldScrollToTop);
        }

        public String toString() {
            return "State(itemsListViewState=" + this.itemsListViewState + ", canCreateBoxNote=" + this.canCreateBoxNote + ", isScrollToTopAfterPreviewEnabled=" + this.isScrollToTopAfterPreviewEnabled + ", currentUserId=" + this.currentUserId + ", visible=" + this.visible + ", navigationRoute=" + this.navigationRoute + ", favoriteUpdateError=" + this.favoriteUpdateError + ", navigatedToPreview=" + this.navigatedToPreview + ", shouldScrollToTop=" + this.shouldScrollToTop + ")";
        }

        public State(ItemsListReducer.State itemsListViewState, boolean z, boolean z2, String currentUserId, boolean z3, Route navigationRoute, DomainError domainError, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(itemsListViewState, "itemsListViewState");
            Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            this.itemsListViewState = itemsListViewState;
            this.canCreateBoxNote = z;
            this.isScrollToTopAfterPreviewEnabled = z2;
            this.currentUserId = currentUserId;
            this.visible = z3;
            this.navigationRoute = navigationRoute;
            this.favoriteUpdateError = domainError;
            this.navigatedToPreview = z4;
            this.shouldScrollToTop = z5;
        }

        public final ItemsListReducer.State getItemsListViewState() {
            return this.itemsListViewState;
        }

        public final boolean getCanCreateBoxNote() {
            return this.canCreateBoxNote;
        }

        public final boolean isScrollToTopAfterPreviewEnabled() {
            return this.isScrollToTopAfterPreviewEnabled;
        }

        public final String getCurrentUserId() {
            return this.currentUserId;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public /* synthetic */ State(ItemsListReducer.State state, boolean z, boolean z2, String str, boolean z3, Route.None none, DomainError domainError, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, str, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? Route.None.INSTANCE : none, (i & 64) != 0 ? null : domainError, (i & 128) != 0 ? false : z4, (i & 256) != 0 ? false : z5);
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final DomainError getFavoriteUpdateError() {
            return this.favoriteUpdateError;
        }

        public final boolean getNavigatedToPreview() {
            return this.navigatedToPreview;
        }

        public final boolean getShouldScrollToTop() {
            return this.shouldScrollToTop;
        }
    }

    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "", "<init>", "()V", "Init", "ToggleFavorite", "FavoriteUpdateFailed", "FavoriteUpdateFailureHandled", "CreateNewNote", "TabHidden", "TabVisible", "NavigationCompleted", "ScrollToTopHandled", "ItemsListAction", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$CreateNewNote;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$FavoriteUpdateFailed;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$FavoriteUpdateFailureHandled;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$Init;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ItemsListAction;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$NavigationCompleted;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ScrollToTopHandled;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$TabHidden;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$TabVisible;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ToggleFavorite;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$Init;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Init extends Action {
            public static final int $stable = 0;
            public static final Init INSTANCE = new Init();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Init)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1645307122;
            }

            public String toString() {
                return "Init";
            }

            private Init() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ToggleFavorite;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "id", "Lcom/box/android/domain/models/ItemId$Remote;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;)V", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleFavorite extends Action {
            public static final int $stable = 8;
            private final ItemId.Remote id;

            public static /* synthetic */ ToggleFavorite copy$default(ToggleFavorite toggleFavorite, ItemId.Remote remote, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = toggleFavorite.id;
                }
                return toggleFavorite.copy(remote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getId() {
                return this.id;
            }

            public final ToggleFavorite copy(ItemId.Remote id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new ToggleFavorite(id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleFavorite) && Intrinsics.areEqual(this.id, ((ToggleFavorite) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "ToggleFavorite(id=" + this.id + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ToggleFavorite(ItemId.Remote id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public final ItemId.Remote getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$FavoriteUpdateFailed;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FavoriteUpdateFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ FavoriteUpdateFailed copy$default(FavoriteUpdateFailed favoriteUpdateFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = favoriteUpdateFailed.error;
                }
                return favoriteUpdateFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final FavoriteUpdateFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new FavoriteUpdateFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FavoriteUpdateFailed) && Intrinsics.areEqual(this.error, ((FavoriteUpdateFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "FavoriteUpdateFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavoriteUpdateFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$FavoriteUpdateFailureHandled;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FavoriteUpdateFailureHandled extends Action {
            public static final int $stable = 0;
            public static final FavoriteUpdateFailureHandled INSTANCE = new FavoriteUpdateFailureHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FavoriteUpdateFailureHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1040511797;
            }

            public String toString() {
                return "FavoriteUpdateFailureHandled";
            }

            private FavoriteUpdateFailureHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$CreateNewNote;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewNote extends Action {
            public static final int $stable = 0;
            public static final CreateNewNote INSTANCE = new CreateNewNote();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateNewNote)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 269273304;
            }

            public String toString() {
                return "CreateNewNote";
            }

            private CreateNewNote() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$TabHidden;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabHidden extends Action {
            public static final int $stable = 0;
            public static final TabHidden INSTANCE = new TabHidden();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TabHidden)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -554344863;
            }

            public String toString() {
                return "TabHidden";
            }

            private TabHidden() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$TabVisible;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -450672997;
            }

            public String toString() {
                return "TabVisible";
            }

            private TabVisible() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$NavigationCompleted;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1040092967;
            }

            public String toString() {
                return "NavigationCompleted";
            }

            private NavigationCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ScrollToTopHandled;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScrollToTopHandled extends Action {
            public static final int $stable = 0;
            public static final ScrollToTopHandled INSTANCE = new ScrollToTopHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScrollToTopHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 991531501;
            }

            public String toString() {
                return "ScrollToTopHandled";
            }

            private ScrollToTopHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action$ItemsListAction;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsListAction extends Action implements Embedded<ItemsListReducer.Action> {
            public static final int $stable = ItemsListReducer.Action.$stable;
            private final ItemsListReducer.Action action;

            public static /* synthetic */ ItemsListAction copy$default(ItemsListAction itemsListAction, ItemsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = itemsListAction.action;
                }
                return itemsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemsListReducer.Action getAction() {
                return this.action;
            }

            public final ItemsListAction copy(ItemsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemsListAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsListAction) && Intrinsics.areEqual(this.action, ((ItemsListAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ItemsListAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemsListAction(ItemsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemsListReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceNotes(State state, Action action) {
        ItemsListReducer.Action.LoadItems loadItems;
        if (Intrinsics.areEqual(action, Action.Init.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(new Action.ItemsListAction(ItemsListReducer.Action.FetchItems.INSTANCE)));
        }
        if (action instanceof Action.ToggleFavorite) {
            Action.ToggleFavorite toggleFavorite = (Action.ToggleFavorite) action;
            ItemModel item = state.getItemsListViewState().getItem(toggleFavorite.getId());
            if (item == null || !NotesItemViewDataKt.canBeFavorited(item)) {
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(state, toggleFavorite(item, toggleFavorite.getId()));
        }
        if (Intrinsics.areEqual(action, Action.CreateNewNote.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, Route.NewNote.INSTANCE, null, true, false, 351, null), Effect.INSTANCE.fireAndForget(new C16631(null)));
        }
        if (action instanceof Action.FavoriteUpdateFailed) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, null, ((Action.FavoriteUpdateFailed) action).getError(), false, false, 447, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.FavoriteUpdateFailureHandled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, null, null, false, false, 447, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.TabVisible.INSTANCE)) {
            boolean z = state.isScrollToTopAfterPreviewEnabled() && state.getNavigatedToPreview();
            ItemsListReducer.LoadingState itemLoadingState = state.getItemsListViewState().getItemLoadingState();
            if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.FullyLoaded.INSTANCE)) {
                loadItems = ItemsListReducer.Action.RefreshFromRemote.INSTANCE;
            } else {
                loadItems = Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Error.INSTANCE) ? ItemsListReducer.Action.FetchItems.INSTANCE : ItemsListReducer.Action.LoadItems.INSTANCE;
            }
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, true, null, null, false, state.getShouldScrollToTop() || z, 111, null), new Effect(new Action.ItemsListAction(loadItems)));
        }
        if (Intrinsics.areEqual(action, Action.TabHidden.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, null, null, false, false, 495, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.NavigationCompleted.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, Route.None.INSTANCE, null, false, false, 479, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ScrollToTopHandled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, null, null, false, false, 255, null), null, 2, null);
        }
        if (!(action instanceof Action.ItemsListAction)) {
            throw new NoWhenBranchMatchedException();
        }
        return reduceChildItemsList((Action.ItemsListAction) action, state);
    }

    /* JADX INFO: renamed from: com.box.android.notes.presentation.cpl.NotesListReducer$reduceNotes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.presentation.cpl.NotesListReducer$reduceNotes$1", f = "NotesListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16631 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        C16631(Continuation<? super C16631> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesListReducer.this.new C16631(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16631) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NotesListReducer.this.environment.getAnalytics().noteCreateTapped();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final ReducerResult<State, Action> reduceChildItemsList(Action.ItemsListAction action, State state) {
        ItemsListReducer.Action action2 = action.getAction();
        if (action2 instanceof ItemsListReducer.Action.OpenItem) {
            ItemModel item = state.getItemsListViewState().getItem(((ItemsListReducer.Action.OpenItem) action2).getId());
            return item == null ? new ReducerResult<>(state, null, 2, null) : new ReducerResult<>(State.copy$default(state, null, false, false, null, false, new Route.Note(item), null, true, false, 351, null), Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.notes.presentation.cpl.NotesListReducer$reduceChildItemsList$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.presentation.cpl.NotesListReducer$reduceChildItemsList$1", f = "NotesListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesListReducer.this.new AnonymousClass1(continuation);
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
                NotesListReducer.this.environment.getAnalytics().noteListItemTapped();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.notes.presentation.cpl.NotesListReducer$toggleFavorite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotesListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.presentation.cpl.NotesListReducer$toggleFavorite$1", f = "NotesListReducer.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {Token.LAST_TOKEN, 169, 171}, m = "invokeSuspend", n = {"$this$flow", "isCurrentlyFavorite", "$this$flow", "isCurrentlyFavorite", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "error", "isCurrentlyFavorite", "$i$f$onError", "$i$a$-onError-NotesListReducer$toggleFavorite$1$1"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C16641 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId.Remote $itemId;
        final /* synthetic */ ItemModel $itemModel;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        final /* synthetic */ NotesListReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16641(ItemModel itemModel, NotesListReducer notesListReducer, ItemId.Remote remote, Continuation<? super C16641> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
            this.this$0 = notesListReducer;
            this.$itemId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16641 c16641 = new C16641(this.$itemModel, this.this$0, this.$itemId, continuation);
            c16641.L$0 = obj;
            return c16641;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16641) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
        
            if (r8 == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
        
            if (r8 == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c8, code lost:
        
            if (r0.emit(r5, r7) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.notes.presentation.cpl.NotesListReducer.C16641.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> toggleFavorite(ItemModel itemModel, ItemId.Remote itemId) {
        return EffectKt.toEffect(FlowKt.flow(new C16641(itemModel, this, itemId, null)));
    }
}
