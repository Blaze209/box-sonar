package com.box.android.activities.addcontent;

import androidx.media3.effect.DebugTraceUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.usecases.notes.NewNoteData;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NewNoteCreationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J0\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$State;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "environment", "Lcom/box/android/activities/addcontent/NewNoteCreationEnvironment;", "<init>", "(Lcom/box/android/activities/addcontent/NewNoteCreationEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceNewNote", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceResolution", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", "reducePersistResult", "resolveLocation", "Lcom/box/android/cpl/Effect;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "persistDefaultNoteFolder", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "State", "ViewEffect", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewNoteCreationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final NewNoteCreationEnvironment environment;

    public NewNoteCreationReducer(NewNoteCreationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new NewNoteCreationReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$State;", "", "isLoading", "", "viewEffect", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "<init>", "(ZLcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;)V", "()Z", "getViewEffect", "()Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final boolean isLoading;
        private final ViewEffect viewEffect;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, ViewEffect viewEffect, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isLoading;
            }
            if ((i & 2) != 0) {
                viewEffect = state.viewEffect;
            }
            return state.copy(z, viewEffect);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final State copy(boolean isLoading, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            return new State(isLoading, viewEffect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isLoading == state.isLoading && Intrinsics.areEqual(this.viewEffect, state.viewEffect);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isLoading) * 31) + this.viewEffect.hashCode();
        }

        public String toString() {
            return "State(isLoading=" + this.isLoading + ", viewEffect=" + this.viewEffect + ")";
        }

        public State(boolean z, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            this.isLoading = z;
            this.viewEffect = viewEffect;
        }

        public /* synthetic */ State(boolean z, ViewEffect.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? ViewEffect.None.INSTANCE : none);
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }
    }

    /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "", "<init>", "()V", "None", "CreateNote", "PickDefaultNoteFolder", "ShowError", "Close", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$Close;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$CreateNote;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$None;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$PickDefaultNoteFolder;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$ShowError;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$None;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends ViewEffect {
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
                return 755413761;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private ViewEffect() {
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$CreateNote;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "noteData", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "<init>", "(Lcom/box/android/domain/usecases/notes/NewNoteData;)V", "getNoteData", "()Lcom/box/android/domain/usecases/notes/NewNoteData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNote extends ViewEffect {
            public static final int $stable = 8;
            private final NewNoteData noteData;

            public static /* synthetic */ CreateNote copy$default(CreateNote createNote, NewNoteData newNoteData, int i, Object obj) {
                if ((i & 1) != 0) {
                    newNoteData = createNote.noteData;
                }
                return createNote.copy(newNoteData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final NewNoteData getNoteData() {
                return this.noteData;
            }

            public final CreateNote copy(NewNoteData noteData) {
                Intrinsics.checkNotNullParameter(noteData, "noteData");
                return new CreateNote(noteData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateNote) && Intrinsics.areEqual(this.noteData, ((CreateNote) other).noteData);
            }

            public int hashCode() {
                return this.noteData.hashCode();
            }

            public String toString() {
                return "CreateNote(noteData=" + this.noteData + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNote(NewNoteData noteData) {
                super(null);
                Intrinsics.checkNotNullParameter(noteData, "noteData");
                this.noteData = noteData;
            }

            public final NewNoteData getNoteData() {
                return this.noteData;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$PickDefaultNoteFolder;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "previousFolderNotWritable", "", "<init>", "(Z)V", "getPreviousFolderNotWritable", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PickDefaultNoteFolder extends ViewEffect {
            public static final int $stable = 0;
            private final boolean previousFolderNotWritable;

            public PickDefaultNoteFolder() {
                this(false, 1, null);
            }

            public static /* synthetic */ PickDefaultNoteFolder copy$default(PickDefaultNoteFolder pickDefaultNoteFolder, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = pickDefaultNoteFolder.previousFolderNotWritable;
                }
                return pickDefaultNoteFolder.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getPreviousFolderNotWritable() {
                return this.previousFolderNotWritable;
            }

            public final PickDefaultNoteFolder copy(boolean previousFolderNotWritable) {
                return new PickDefaultNoteFolder(previousFolderNotWritable);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PickDefaultNoteFolder) && this.previousFolderNotWritable == ((PickDefaultNoteFolder) other).previousFolderNotWritable;
            }

            public int hashCode() {
                return Boolean.hashCode(this.previousFolderNotWritable);
            }

            public String toString() {
                return "PickDefaultNoteFolder(previousFolderNotWritable=" + this.previousFolderNotWritable + ")";
            }

            public PickDefaultNoteFolder(boolean z) {
                super(null);
                this.previousFolderNotWritable = z;
            }

            public /* synthetic */ PickDefaultNoteFolder(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean getPreviousFolderNotWritable() {
                return this.previousFolderNotWritable;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$ShowError;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "error", "Lcom/box/android/domain/models/NoteCreationError;", "<init>", "(Lcom/box/android/domain/models/NoteCreationError;)V", "getError", "()Lcom/box/android/domain/models/NoteCreationError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowError extends ViewEffect {
            public static final int $stable = 8;
            private final NoteCreationError error;

            public static /* synthetic */ ShowError copy$default(ShowError showError, NoteCreationError noteCreationError, int i, Object obj) {
                if ((i & 1) != 0) {
                    noteCreationError = showError.error;
                }
                return showError.copy(noteCreationError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final NoteCreationError getError() {
                return this.error;
            }

            public final ShowError copy(NoteCreationError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ShowError(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowError) && Intrinsics.areEqual(this.error, ((ShowError) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ShowError(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowError(NoteCreationError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final NoteCreationError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect$Close;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends ViewEffect {
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
                return 1932743503;
            }

            public String toString() {
                return "Close";
            }

            private Close() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "", "<init>", "()V", DebugTraceUtil.EVENT_START, "LocationResolved", "DefaultNoteFolderPicked", "DefaultNoteFolderSelectionCancelled", "DefaultNoteFolderPersisted", "NoteCreationFailed", "ViewEffectHandled", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderPersisted;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderPicked;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderSelectionCancelled;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$LocationResolved;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$NoteCreationFailed;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$Start;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$ViewEffectHandled;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$Start;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "<init>", "(Lcom/box/android/domain/models/NewNoteLocation;)V", "getLocation", "()Lcom/box/android/domain/models/NewNoteLocation;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Start extends Action {
            public static final int $stable = 8;
            private final NewNoteLocation location;

            public static /* synthetic */ Start copy$default(Start start, NewNoteLocation newNoteLocation, int i, Object obj) {
                if ((i & 1) != 0) {
                    newNoteLocation = start.location;
                }
                return start.copy(newNoteLocation);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final NewNoteLocation getLocation() {
                return this.location;
            }

            public final Start copy(NewNoteLocation location) {
                Intrinsics.checkNotNullParameter(location, "location");
                return new Start(location);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Start) && Intrinsics.areEqual(this.location, ((Start) other).location);
            }

            public int hashCode() {
                return this.location.hashCode();
            }

            public String toString() {
                return "Start(location=" + this.location + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(NewNoteLocation location) {
                super(null);
                Intrinsics.checkNotNullParameter(location, "location");
                this.location = location;
            }

            public final NewNoteLocation getLocation() {
                return this.location;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$LocationResolved;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", "<init>", "(Lcom/box/android/domain/utils/result/Result;)V", "getResult", "()Lcom/box/android/domain/utils/result/Result;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LocationResolved extends Action {
            public static final int $stable = 8;
            private final Result<NewNoteData, NoteCreationError> result;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LocationResolved copy$default(LocationResolved locationResolved, Result result, int i, Object obj) {
                if ((i & 1) != 0) {
                    result = locationResolved.result;
                }
                return locationResolved.copy(result);
            }

            public final Result<NewNoteData, NoteCreationError> component1() {
                return this.result;
            }

            public final LocationResolved copy(Result<NewNoteData, ? extends NoteCreationError> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new LocationResolved(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LocationResolved) && Intrinsics.areEqual(this.result, ((LocationResolved) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "LocationResolved(result=" + this.result + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public LocationResolved(Result<NewNoteData, ? extends NoteCreationError> result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final Result<NewNoteData, NoteCreationError> getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderPicked;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DefaultNoteFolderPicked extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ DefaultNoteFolderPicked copy$default(DefaultNoteFolderPicked defaultNoteFolderPicked, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = defaultNoteFolderPicked.folder;
                }
                return defaultNoteFolderPicked.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final DefaultNoteFolderPicked copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new DefaultNoteFolderPicked(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DefaultNoteFolderPicked) && Intrinsics.areEqual(this.folder, ((DefaultNoteFolderPicked) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "DefaultNoteFolderPicked(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DefaultNoteFolderPicked(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderSelectionCancelled;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DefaultNoteFolderSelectionCancelled extends Action {
            public static final int $stable = 0;
            public static final DefaultNoteFolderSelectionCancelled INSTANCE = new DefaultNoteFolderSelectionCancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DefaultNoteFolderSelectionCancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1175045283;
            }

            public String toString() {
                return "DefaultNoteFolderSelectionCancelled";
            }

            private DefaultNoteFolderSelectionCancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$DefaultNoteFolderPersisted;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", "<init>", "(Lcom/box/android/domain/utils/result/Result;)V", "getResult", "()Lcom/box/android/domain/utils/result/Result;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DefaultNoteFolderPersisted extends Action {
            public static final int $stable = 8;
            private final Result<NewNoteData, NoteCreationError> result;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DefaultNoteFolderPersisted copy$default(DefaultNoteFolderPersisted defaultNoteFolderPersisted, Result result, int i, Object obj) {
                if ((i & 1) != 0) {
                    result = defaultNoteFolderPersisted.result;
                }
                return defaultNoteFolderPersisted.copy(result);
            }

            public final Result<NewNoteData, NoteCreationError> component1() {
                return this.result;
            }

            public final DefaultNoteFolderPersisted copy(Result<NewNoteData, ? extends NoteCreationError> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new DefaultNoteFolderPersisted(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DefaultNoteFolderPersisted) && Intrinsics.areEqual(this.result, ((DefaultNoteFolderPersisted) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "DefaultNoteFolderPersisted(result=" + this.result + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public DefaultNoteFolderPersisted(Result<NewNoteData, ? extends NoteCreationError> result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final Result<NewNoteData, NoteCreationError> getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$NoteCreationFailed;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoteCreationFailed extends Action {
            public static final int $stable = 0;
            public static final NoteCreationFailed INSTANCE = new NoteCreationFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoteCreationFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -655079561;
            }

            public String toString() {
                return "NoteCreationFailed";
            }

            private NoteCreationFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action$ViewEffectHandled;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ViewEffectHandled extends Action {
            public static final int $stable = 0;
            public static final ViewEffectHandled INSTANCE = new ViewEffectHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ViewEffectHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -132179523;
            }

            public String toString() {
                return "ViewEffectHandled";
            }

            private ViewEffectHandled() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceNewNote(State state, Action action) {
        if (action instanceof Action.Start) {
            return new ReducerResult<>(state.copy(true, ViewEffect.None.INSTANCE), resolveLocation(((Action.Start) action).getLocation()));
        }
        if (action instanceof Action.LocationResolved) {
            return reduceResolution(state, ((Action.LocationResolved) action).getResult());
        }
        if (action instanceof Action.DefaultNoteFolderPicked) {
            return new ReducerResult<>(state.copy(true, ViewEffect.None.INSTANCE), persistDefaultNoteFolder(((Action.DefaultNoteFolderPicked) action).getFolder()));
        }
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (Intrinsics.areEqual(action, Action.DefaultNoteFolderSelectionCancelled.INSTANCE)) {
            return new ReducerResult<>(state.copy(false, ViewEffect.Close.INSTANCE), effect, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.DefaultNoteFolderPersisted) {
            return reducePersistResult(state, ((Action.DefaultNoteFolderPersisted) action).getResult());
        }
        if (Intrinsics.areEqual(action, Action.NoteCreationFailed.INSTANCE)) {
            this.environment.getDefaultNoteFolderService().clearCache();
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.ViewEffectHandled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, ViewEffect.None.INSTANCE, 1, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceResolution(State state, Result<NewNoteData, ? extends NoteCreationError> result) {
        int i = 1;
        int i2 = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        if (result instanceof Result.Success) {
            return new ReducerResult<>(state.copy(true, new ViewEffect.CreateNote((NewNoteData) ((Result.Success) result).getValue())), effect, i2, objArr6 == true ? 1 : 0);
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        NoteCreationError noteCreationError = (NoteCreationError) ((Result.Error) result).getValue();
        boolean z = false;
        if (noteCreationError instanceof NoteCreationError.DefaultNoteFolderNotAccessible) {
            return new ReducerResult<>(state.copy(false, new ViewEffect.PickDefaultNoteFolder(z, i, objArr5 == true ? 1 : 0)), objArr4 == true ? 1 : 0, i2, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult<>(state.copy(false, new ViewEffect.ShowError(noteCreationError)), objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reducePersistResult(State state, Result<NewNoteData, ? extends NoteCreationError> result) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (result instanceof Result.Success) {
            return new ReducerResult<>(state.copy(true, new ViewEffect.CreateNote((NewNoteData) ((Result.Success) result).getValue())), effect, i, objArr5 == true ? 1 : 0);
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        NoteCreationError noteCreationError = (NoteCreationError) ((Result.Error) result).getValue();
        if ((noteCreationError instanceof NoteCreationError.PermissionDenied) || (noteCreationError instanceof NoteCreationError.DefaultNoteFolderNotAccessible)) {
            return new ReducerResult<>(state.copy(false, new ViewEffect.PickDefaultNoteFolder(true)), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        return new ReducerResult<>(state.copy(false, new ViewEffect.ShowError(noteCreationError)), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: com.box.android.activities.addcontent.NewNoteCreationReducer$resolveLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.activities.addcontent.NewNoteCreationReducer$resolveLocation$1", f = "NewNoteCreationReducer.kt", i = {0, 1}, l = {109, 109}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C09181 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ NewNoteLocation $location;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09181(NewNoteLocation newNoteLocation, Continuation<? super C09181> continuation) {
            super(2, continuation);
            this.$location = newNoteLocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09181 c09181 = NewNoteCreationReducer.this.new C09181(this.$location, continuation);
            c09181.L$0 = obj;
            return c09181;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C09181) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        
            if (r2.emit(new com.box.android.activities.addcontent.NewNoteCreationReducer.Action.LocationResolved((com.box.android.domain.utils.result.Result) r8), r7) == r1) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r2 = r7.L$1
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4a
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.activities.addcontent.NewNoteCreationReducer r8 = com.box.android.activities.addcontent.NewNoteCreationReducer.this
                com.box.android.activities.addcontent.NewNoteCreationEnvironment r8 = com.box.android.activities.addcontent.NewNoteCreationReducer.access$getEnvironment$p(r8)
                com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase r8 = r8.getResolveNewNoteLocationUseCase()
                com.box.android.domain.models.NewNoteLocation r2 = r7.$location
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                r7.L$1 = r0
                r7.label = r4
                java.lang.Object r8 = r8.invoke(r2, r5)
                if (r8 != r1) goto L49
                goto L65
            L49:
                r2 = r0
            L4a:
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                com.box.android.activities.addcontent.NewNoteCreationReducer$Action$LocationResolved r4 = new com.box.android.activities.addcontent.NewNoteCreationReducer$Action$LocationResolved
                r4.<init>(r8)
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r0
                r0 = 0
                r7.L$1 = r0
                r7.label = r3
                java.lang.Object r7 = r2.emit(r4, r8)
                if (r7 != r1) goto L66
            L65:
                return r1
            L66:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.activities.addcontent.NewNoteCreationReducer.C09181.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> resolveLocation(NewNoteLocation location) {
        return EffectKt.toEffect(FlowKt.flow(new C09181(location, null)));
    }

    /* JADX INFO: renamed from: com.box.android.activities.addcontent.NewNoteCreationReducer$persistDefaultNoteFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: NewNoteCreationReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.activities.addcontent.NewNoteCreationReducer$persistDefaultNoteFolder$1", f = "NewNoteCreationReducer.kt", i = {0, 1}, l = {113, 113}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ FolderModel $folder;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FolderModel folderModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$folder = folderModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = NewNoteCreationReducer.this.new AnonymousClass1(this.$folder, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        
            if (r2.emit(new com.box.android.activities.addcontent.NewNoteCreationReducer.Action.DefaultNoteFolderPersisted((com.box.android.domain.utils.result.Result) r8), r7) == r1) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r2 = r7.L$1
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4a
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.activities.addcontent.NewNoteCreationReducer r8 = com.box.android.activities.addcontent.NewNoteCreationReducer.this
                com.box.android.activities.addcontent.NewNoteCreationEnvironment r8 = com.box.android.activities.addcontent.NewNoteCreationReducer.access$getEnvironment$p(r8)
                com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase r8 = r8.getSetDefaultNoteFolderUseCase()
                com.box.android.domain.models.item.FolderModel r2 = r7.$folder
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                r7.L$1 = r0
                r7.label = r4
                java.lang.Object r8 = r8.invoke(r2, r5)
                if (r8 != r1) goto L49
                goto L65
            L49:
                r2 = r0
            L4a:
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                com.box.android.activities.addcontent.NewNoteCreationReducer$Action$DefaultNoteFolderPersisted r4 = new com.box.android.activities.addcontent.NewNoteCreationReducer$Action$DefaultNoteFolderPersisted
                r4.<init>(r8)
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r0
                r0 = 0
                r7.L$1 = r0
                r7.label = r3
                java.lang.Object r7 = r2.emit(r4, r8)
                if (r7 != r1) goto L66
            L65:
                return r1
            L66:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.activities.addcontent.NewNoteCreationReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> persistDefaultNoteFolder(FolderModel folder) {
        return EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(folder, null)));
    }
}
