package com.box.android.preview.preview.previewbar.topbar;

import com.box.android.base.models.ButtonState;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileModelKt;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.UserModel;
import com.box.android.preview.fileactions.FileAction;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBarReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0016\u0017\u0018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$State;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "environment", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;", "<init>", "(Lcom/box/android/preview/preview/previewbar/topbar/TopBarEnvironment;)V", "topBarActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "getActions", "availableAction", "", "getSubtitleState", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "State", "SubtitleState", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopBarReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final TopBarEnvironment environment;
    private final List<FileAction> topBarActions;

    public TopBarReducer(TopBarEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.topBarActions = CollectionsKt.listOf((Object[]) new FileAction[]{FileAction.Gallery, FileAction.Playlist, FileAction.Search, FileAction.PageView, FileAction.ThumbnailsView, FileAction.OutlineView, FileAction.ViewSettings, FileAction.Collections, FileAction.Download, FileAction.Print, FileAction.RemoveFromOffline, FileAction.MakeAvailableOffline, FileAction.FileInformation, FileAction.Rename, FileAction.MoveOrCopy, FileAction.OpenIn, FileAction.ViewContainingFolder, FileAction.Watermarking, FileAction.AddTask, FileAction.Delete, FileAction.EndCollaboration});
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: TopBarReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$State;", "", "isFileDetailsShown", "", "moreActionsButtonState", "Lcom/box/android/base/models/ButtonState;", "moreActionsExpanded", "moreActionItems", "", "Lcom/box/android/preview/fileactions/FileAction;", "subtitle", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "<init>", "(ZLcom/box/android/base/models/ButtonState;ZLjava/util/List;Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;)V", "()Z", "getMoreActionsButtonState", "()Lcom/box/android/base/models/ButtonState;", "getMoreActionsExpanded", "getMoreActionItems", "()Ljava/util/List;", "getSubtitle", "()Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final boolean isFileDetailsShown;
        private final List<FileAction> moreActionItems;
        private final ButtonState moreActionsButtonState;
        private final boolean moreActionsExpanded;
        private final SubtitleState subtitle;

        public State() {
            this(false, null, false, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, ButtonState buttonState, boolean z2, List list, SubtitleState subtitleState, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isFileDetailsShown;
            }
            if ((i & 2) != 0) {
                buttonState = state.moreActionsButtonState;
            }
            if ((i & 4) != 0) {
                z2 = state.moreActionsExpanded;
            }
            if ((i & 8) != 0) {
                list = state.moreActionItems;
            }
            if ((i & 16) != 0) {
                subtitleState = state.subtitle;
            }
            SubtitleState subtitleState2 = subtitleState;
            boolean z3 = z2;
            return state.copy(z, buttonState, z3, list, subtitleState2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsFileDetailsShown() {
            return this.isFileDetailsShown;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ButtonState getMoreActionsButtonState() {
            return this.moreActionsButtonState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getMoreActionsExpanded() {
            return this.moreActionsExpanded;
        }

        public final List<FileAction> component4() {
            return this.moreActionItems;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final SubtitleState getSubtitle() {
            return this.subtitle;
        }

        public final State copy(boolean isFileDetailsShown, ButtonState moreActionsButtonState, boolean moreActionsExpanded, List<? extends FileAction> moreActionItems, SubtitleState subtitle) {
            Intrinsics.checkNotNullParameter(moreActionsButtonState, "moreActionsButtonState");
            Intrinsics.checkNotNullParameter(moreActionItems, "moreActionItems");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            return new State(isFileDetailsShown, moreActionsButtonState, moreActionsExpanded, moreActionItems, subtitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isFileDetailsShown == state.isFileDetailsShown && this.moreActionsButtonState == state.moreActionsButtonState && this.moreActionsExpanded == state.moreActionsExpanded && Intrinsics.areEqual(this.moreActionItems, state.moreActionItems) && Intrinsics.areEqual(this.subtitle, state.subtitle);
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.isFileDetailsShown) * 31) + this.moreActionsButtonState.hashCode()) * 31) + Boolean.hashCode(this.moreActionsExpanded)) * 31) + this.moreActionItems.hashCode()) * 31) + this.subtitle.hashCode();
        }

        public String toString() {
            return "State(isFileDetailsShown=" + this.isFileDetailsShown + ", moreActionsButtonState=" + this.moreActionsButtonState + ", moreActionsExpanded=" + this.moreActionsExpanded + ", moreActionItems=" + this.moreActionItems + ", subtitle=" + this.subtitle + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(boolean z, ButtonState moreActionsButtonState, boolean z2, List<? extends FileAction> moreActionItems, SubtitleState subtitle) {
            Intrinsics.checkNotNullParameter(moreActionsButtonState, "moreActionsButtonState");
            Intrinsics.checkNotNullParameter(moreActionItems, "moreActionItems");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            this.isFileDetailsShown = z;
            this.moreActionsButtonState = moreActionsButtonState;
            this.moreActionsExpanded = z2;
            this.moreActionItems = moreActionItems;
            this.subtitle = subtitle;
        }

        public final boolean isFileDetailsShown() {
            return this.isFileDetailsShown;
        }

        public /* synthetic */ State(boolean z, ButtonState buttonState, boolean z2, List list, SubtitleState.ViewOnly viewOnly, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? ButtonState.ENABLED : buttonState, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? SubtitleState.ViewOnly.INSTANCE : viewOnly);
        }

        public final ButtonState getMoreActionsButtonState() {
            return this.moreActionsButtonState;
        }

        public final boolean getMoreActionsExpanded() {
            return this.moreActionsExpanded;
        }

        public final List<FileAction> getMoreActionItems() {
            return this.moreActionItems;
        }

        public final SubtitleState getSubtitle() {
            return this.subtitle;
        }
    }

    /* JADX INFO: compiled from: TopBarReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "", "<init>", "()V", "None", "ViewOnly", "Locked", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$Locked;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$None;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$ViewOnly;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class SubtitleState {
        public static final int $stable = 0;

        public /* synthetic */ SubtitleState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$None;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends SubtitleState {
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
                return -123211019;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private SubtitleState() {
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$ViewOnly;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ViewOnly extends SubtitleState {
            public static final int $stable = 0;
            public static final ViewOnly INSTANCE = new ViewOnly();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ViewOnly)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1605955282;
            }

            public String toString() {
                return "ViewOnly";
            }

            private ViewOnly() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState$Locked;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$SubtitleState;", "lockedByUsername", "", "<init>", "(Ljava/lang/String;)V", "getLockedByUsername", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Locked extends SubtitleState {
            public static final int $stable = 0;
            private final String lockedByUsername;

            /* JADX WARN: Multi-variable type inference failed */
            public Locked() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Locked copy$default(Locked locked, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = locked.lockedByUsername;
                }
                return locked.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getLockedByUsername() {
                return this.lockedByUsername;
            }

            public final Locked copy(String lockedByUsername) {
                return new Locked(lockedByUsername);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Locked) && Intrinsics.areEqual(this.lockedByUsername, ((Locked) other).lockedByUsername);
            }

            public int hashCode() {
                String str = this.lockedByUsername;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Locked(lockedByUsername=" + this.lockedByUsername + ")";
            }

            public Locked(String str) {
                super(null);
                this.lockedByUsername = str;
            }

            public /* synthetic */ Locked(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getLockedByUsername() {
                return this.lockedByUsername;
            }
        }
    }

    /* JADX INFO: compiled from: TopBarReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "", "<init>", "()V", "Update", "ShowMoreActionsMenu", "CloseMoreActionsMenu", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$CloseMoreActionsMenu;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$ShowMoreActionsMenu;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$Update;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$Update;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "availableActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "hasUserLostAccessToFile", "", "isMoreActionsEnabled", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/Set;ZZ)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getAvailableActions", "()Ljava/util/Set;", "getHasUserLostAccessToFile", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Update extends Action {
            public static final int $stable = 8;
            private final Set<FileAction> availableActions;
            private final FileModel fileModel;
            private final boolean hasUserLostAccessToFile;
            private final boolean isMoreActionsEnabled;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Update copy$default(Update update, FileModel fileModel, Set set, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = update.fileModel;
                }
                if ((i & 2) != 0) {
                    set = update.availableActions;
                }
                if ((i & 4) != 0) {
                    z = update.hasUserLostAccessToFile;
                }
                if ((i & 8) != 0) {
                    z2 = update.isMoreActionsEnabled;
                }
                return update.copy(fileModel, set, z, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final Set<FileAction> component2() {
                return this.availableActions;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getHasUserLostAccessToFile() {
                return this.hasUserLostAccessToFile;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsMoreActionsEnabled() {
                return this.isMoreActionsEnabled;
            }

            public final Update copy(FileModel fileModel, Set<? extends FileAction> availableActions, boolean hasUserLostAccessToFile, boolean isMoreActionsEnabled) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                return new Update(fileModel, availableActions, hasUserLostAccessToFile, isMoreActionsEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return Intrinsics.areEqual(this.fileModel, update.fileModel) && Intrinsics.areEqual(this.availableActions, update.availableActions) && this.hasUserLostAccessToFile == update.hasUserLostAccessToFile && this.isMoreActionsEnabled == update.isMoreActionsEnabled;
            }

            public int hashCode() {
                return (((((this.fileModel.hashCode() * 31) + this.availableActions.hashCode()) * 31) + Boolean.hashCode(this.hasUserLostAccessToFile)) * 31) + Boolean.hashCode(this.isMoreActionsEnabled);
            }

            public String toString() {
                return "Update(fileModel=" + this.fileModel + ", availableActions=" + this.availableActions + ", hasUserLostAccessToFile=" + this.hasUserLostAccessToFile + ", isMoreActionsEnabled=" + this.isMoreActionsEnabled + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(FileModel fileModel, Set<? extends FileAction> availableActions, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                this.fileModel = fileModel;
                this.availableActions = availableActions;
                this.hasUserLostAccessToFile = z;
                this.isMoreActionsEnabled = z2;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final Set<FileAction> getAvailableActions() {
                return this.availableActions;
            }

            public final boolean getHasUserLostAccessToFile() {
                return this.hasUserLostAccessToFile;
            }

            public final boolean isMoreActionsEnabled() {
                return this.isMoreActionsEnabled;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$ShowMoreActionsMenu;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowMoreActionsMenu extends Action {
            public static final int $stable = 0;
            public static final ShowMoreActionsMenu INSTANCE = new ShowMoreActionsMenu();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowMoreActionsMenu)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 974163706;
            }

            public String toString() {
                return "ShowMoreActionsMenu";
            }

            private ShowMoreActionsMenu() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: TopBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action$CloseMoreActionsMenu;", "Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CloseMoreActionsMenu extends Action {
            public static final int $stable = 0;
            public static final CloseMoreActionsMenu INSTANCE = new CloseMoreActionsMenu();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseMoreActionsMenu)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1665911807;
            }

            public String toString() {
                return "CloseMoreActionsMenu";
            }

            private CloseMoreActionsMenu() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        ButtonState buttonState;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ShowMoreActionsMenu) {
            return new ReducerResult<>(State.copy$default(state, false, null, true, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.CloseMoreActionsMenu) {
            return new ReducerResult<>(State.copy$default(state, false, null, false, null, null, 27, null), null, 2, null);
        }
        if (!(action instanceof Action.Update)) {
            throw new NoWhenBranchMatchedException();
        }
        Action.Update update = (Action.Update) action;
        if (update.getHasUserLostAccessToFile()) {
            buttonState = ButtonState.HIDDEN;
        } else {
            buttonState = update.isMoreActionsEnabled() ? ButtonState.ENABLED : ButtonState.DISABLED;
        }
        return new ReducerResult<>(State.copy$default(state, !update.getHasUserLostAccessToFile(), buttonState, false, getActions(update.getAvailableActions()), getSubtitleState(update.getFileModel()), 4, null), null, 2, null);
    }

    private final List<FileAction> getActions(Set<? extends FileAction> availableAction) {
        List<FileAction> list = this.topBarActions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (availableAction.contains((FileAction) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final SubtitleState getSubtitleState(FileModel fileModel) {
        UserModel createdBy;
        FileLockModel fileLock = fileModel.getFileLock();
        String name = null;
        if (fileLock != null && (createdBy = fileLock.getCreatedBy()) != null) {
            if (!Intrinsics.areEqual(createdBy.getId(), this.environment.getBoxAccountManagerHelper().getCurrentUser().getId())) {
                name = createdBy.getName();
            }
        }
        if (name != null) {
            return new SubtitleState.Locked(name);
        }
        if (ItemModelKt.isViewOnly(fileModel) || FileModelKt.isReadOnlyBoxNote(fileModel)) {
            return SubtitleState.ViewOnly.INSTANCE;
        }
        return SubtitleState.None.INSTANCE;
    }
}
