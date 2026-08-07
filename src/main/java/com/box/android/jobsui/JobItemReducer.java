package com.box.android.jobsui;

import com.box.android.base.compose.ItemThumbnail;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: JobItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000b\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/jobsui/JobItemReducer$State;", "Lcom/box/android/jobsui/JobItemReducer$Action;", "environment", "Lcom/box/android/jobsui/JobsUIEnvironment;", "<init>", "(Lcom/box/android/jobsui/JobsUIEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "Action", "Companion", "State", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobItemReducer implements Reducable<State, Action> {
    private final Reducable<State, Action> build;
    private final JobsUIEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$Action;", "", "<init>", "()V", "SecondaryAction", "ToggleSelection", "PrimaryAction", "Lcom/box/android/jobsui/JobItemReducer$Action$PrimaryAction;", "Lcom/box/android/jobsui/JobItemReducer$Action$SecondaryAction;", "Lcom/box/android/jobsui/JobItemReducer$Action$ToggleSelection;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: JobItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$Action$SecondaryAction;", "Lcom/box/android/jobsui/JobItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SecondaryAction extends Action {
            public static final int $stable = 0;
            public static final SecondaryAction INSTANCE = new SecondaryAction();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SecondaryAction)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -532996721;
            }

            public String toString() {
                return "SecondaryAction";
            }

            private SecondaryAction() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: JobItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$Action$ToggleSelection;", "Lcom/box/android/jobsui/JobItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleSelection extends Action {
            public static final int $stable = 0;
            public static final ToggleSelection INSTANCE = new ToggleSelection();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ToggleSelection)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2135915869;
            }

            public String toString() {
                return "ToggleSelection";
            }

            private ToggleSelection() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$Action$PrimaryAction;", "Lcom/box/android/jobsui/JobItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PrimaryAction extends Action {
            public static final int $stable = 0;
            public static final PrimaryAction INSTANCE = new PrimaryAction();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PrimaryAction)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -284097315;
            }

            public String toString() {
                return "PrimaryAction";
            }

            private PrimaryAction() {
                super(null);
            }
        }
    }

    public JobItemReducer(JobsUIEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.jobsui.JobItemReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return JobItemReducer.build$lambda$0(this.f$0, (JobItemReducer.State) obj, (JobItemReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$Companion;", "", "<init>", "()V", "isSelectableForAction", "", "jobStatus", "Lcom/box/android/domain/models/JobInfo$Status;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSelectableForAction(JobInfo.Status jobStatus) {
            Intrinsics.checkNotNullParameter(jobStatus, "jobStatus");
            return !(jobStatus instanceof JobInfo.Status.Succeeded);
        }
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0002HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\bHÆ\u0003J\t\u0010,\u001a\u00020\u0011HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003Ju\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\rHÖ\u0001J\t\u00103\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0018¨\u00064"}, d2 = {"Lcom/box/android/jobsui/JobItemReducer$State;", "Lcom/box/android/cpl/Identifiable;", "", "jobItemId", "Lcom/box/android/jobsui/JobItemId;", "title", "description", "thumbnail", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/box/android/base/compose/ItemThumbnail;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "iconRes", "", "progress", "Lcom/box/android/jobsui/JobStatusUIState;", "isSelected", "", "contentUrl", "<init>", "(Lcom/box/android/jobsui/JobItemId;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/flow/StateFlow;Lcom/box/android/domain/models/item/ItemModel;ILkotlinx/coroutines/flow/StateFlow;ZLjava/lang/String;)V", "getJobItemId", "()Lcom/box/android/jobsui/JobItemId;", "getTitle", "()Ljava/lang/String;", "getDescription", "getThumbnail", "()Lkotlinx/coroutines/flow/StateFlow;", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "getIconRes", "()I", "getProgress", "()Z", "getContentUrl", "id", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<String> {
        public static final int $stable = 8;
        private final String contentUrl;
        private final String description;
        private final int iconRes;
        private final boolean isSelected;
        private final ItemModel item;
        private final JobItemId jobItemId;
        private final StateFlow<JobStatusUIState> progress;
        private final StateFlow<ItemThumbnail> thumbnail;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, JobItemId jobItemId, String str, String str2, StateFlow stateFlow, ItemModel itemModel, int i, StateFlow stateFlow2, boolean z, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                jobItemId = state.jobItemId;
            }
            if ((i2 & 2) != 0) {
                str = state.title;
            }
            if ((i2 & 4) != 0) {
                str2 = state.description;
            }
            if ((i2 & 8) != 0) {
                stateFlow = state.thumbnail;
            }
            if ((i2 & 16) != 0) {
                itemModel = state.item;
            }
            if ((i2 & 32) != 0) {
                i = state.iconRes;
            }
            if ((i2 & 64) != 0) {
                stateFlow2 = state.progress;
            }
            if ((i2 & 128) != 0) {
                z = state.isSelected;
            }
            if ((i2 & 256) != 0) {
                str3 = state.contentUrl;
            }
            boolean z2 = z;
            String str4 = str3;
            int i3 = i;
            StateFlow stateFlow3 = stateFlow2;
            ItemModel itemModel2 = itemModel;
            String str5 = str2;
            return state.copy(jobItemId, str, str5, stateFlow, itemModel2, i3, stateFlow3, z2, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final JobItemId getJobItemId() {
            return this.jobItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final StateFlow<ItemThumbnail> component4() {
            return this.thumbnail;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ItemModel getItem() {
            return this.item;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        public final StateFlow<JobStatusUIState> component7() {
            return this.progress;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getContentUrl() {
            return this.contentUrl;
        }

        public final State copy(JobItemId jobItemId, String title, String description, StateFlow<? extends ItemThumbnail> thumbnail, ItemModel item, int iconRes, StateFlow<JobStatusUIState> progress, boolean isSelected, String contentUrl) {
            Intrinsics.checkNotNullParameter(jobItemId, "jobItemId");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            Intrinsics.checkNotNullParameter(progress, "progress");
            return new State(jobItemId, title, description, thumbnail, item, iconRes, progress, isSelected, contentUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.jobItemId, state.jobItemId) && Intrinsics.areEqual(this.title, state.title) && Intrinsics.areEqual(this.description, state.description) && Intrinsics.areEqual(this.thumbnail, state.thumbnail) && Intrinsics.areEqual(this.item, state.item) && this.iconRes == state.iconRes && Intrinsics.areEqual(this.progress, state.progress) && this.isSelected == state.isSelected && Intrinsics.areEqual(this.contentUrl, state.contentUrl);
        }

        public int hashCode() {
            int iHashCode = ((this.jobItemId.hashCode() * 31) + this.title.hashCode()) * 31;
            String str = this.description;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.thumbnail.hashCode()) * 31;
            ItemModel itemModel = this.item;
            int iHashCode3 = (((((((iHashCode2 + (itemModel == null ? 0 : itemModel.hashCode())) * 31) + Integer.hashCode(this.iconRes)) * 31) + this.progress.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31;
            String str2 = this.contentUrl;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "State(jobItemId=" + this.jobItemId + ", title=" + this.title + ", description=" + this.description + ", thumbnail=" + this.thumbnail + ", item=" + this.item + ", iconRes=" + this.iconRes + ", progress=" + this.progress + ", isSelected=" + this.isSelected + ", contentUrl=" + this.contentUrl + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(JobItemId jobItemId, String title, String str, StateFlow<? extends ItemThumbnail> thumbnail, ItemModel itemModel, int i, StateFlow<JobStatusUIState> progress, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(jobItemId, "jobItemId");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.jobItemId = jobItemId;
            this.title = title;
            this.description = str;
            this.thumbnail = thumbnail;
            this.item = itemModel;
            this.iconRes = i;
            this.progress = progress;
            this.isSelected = z;
            this.contentUrl = str2;
        }

        public /* synthetic */ State(JobItemId jobItemId, String str, String str2, StateFlow stateFlow, ItemModel itemModel, int i, StateFlow stateFlow2, boolean z, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(jobItemId, str, str2, stateFlow, itemModel, i, stateFlow2, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? null : str3);
        }

        public final JobItemId getJobItemId() {
            return this.jobItemId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDescription() {
            return this.description;
        }

        public final StateFlow<ItemThumbnail> getThumbnail() {
            return this.thumbnail;
        }

        public final ItemModel getItem() {
            return this.item;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final StateFlow<JobStatusUIState> getProgress() {
            return this.progress;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final String getContentUrl() {
            return this.contentUrl;
        }

        @Override // com.box.android.cpl.Identifiable
        /* JADX INFO: renamed from: getId, reason: avoid collision after fix types in other method */
        public String getActivityId() {
            return this.jobItemId.getIdentifier();
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f9, code lost:
    
        if (r3.retryJob(r2, r0) == r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012d, code lost:
    
        if (r4.retryJob(r7, r5, r6, r0) == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object build$lambda$0$retryJob(com.box.android.jobsui.JobItemReducer.State r8, com.box.android.jobsui.JobItemReducer r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobItemReducer.build$lambda$0$retryJob(com.box.android.jobsui.JobItemReducer$State, com.box.android.jobsui.JobItemReducer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(JobItemReducer jobItemReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (action instanceof Action.SecondaryAction) {
            return new ReducerResult(state, Effect.INSTANCE.fireAndForget(new JobItemReducer$build$1$1(state, jobItemReducer, null)));
        }
        int i = 2;
        if (action instanceof Action.ToggleSelection) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, 0, null, !state.isSelected(), null, 383, null), effect, i, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
