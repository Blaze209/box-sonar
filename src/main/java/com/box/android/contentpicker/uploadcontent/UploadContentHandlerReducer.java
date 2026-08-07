package com.box.android.contentpicker.uploadcontent;

import android.net.Uri;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$State;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "environment", "Lcom/box/android/contentpicker/uploadcontent/UploadContentEnvironment;", "<init>", "(Lcom/box/android/contentpicker/uploadcontent/UploadContentEnvironment;)V", "getEnvironment", "()Lcom/box/android/contentpicker/uploadcontent/UploadContentEnvironment;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "ViewEffect", "Action", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadContentHandlerReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final UploadContentEnvironment environment;

    public UploadContentHandlerReducer(UploadContentEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    public final UploadContentEnvironment getEnvironment() {
        return this.environment;
    }

    /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$State;", "", "showPermissionDialog", "", "viewEffect", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "<init>", "(ZLcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;)V", "getShowPermissionDialog", "()Z", "getViewEffect", "()Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final boolean showPermissionDialog;
        private final ViewEffect viewEffect;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, ViewEffect viewEffect, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.showPermissionDialog;
            }
            if ((i & 2) != 0) {
                viewEffect = state.viewEffect;
            }
            return state.copy(z, viewEffect);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowPermissionDialog() {
            return this.showPermissionDialog;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final State copy(boolean showPermissionDialog, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            return new State(showPermissionDialog, viewEffect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.showPermissionDialog == state.showPermissionDialog && Intrinsics.areEqual(this.viewEffect, state.viewEffect);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.showPermissionDialog) * 31) + this.viewEffect.hashCode();
        }

        public String toString() {
            return "State(showPermissionDialog=" + this.showPermissionDialog + ", viewEffect=" + this.viewEffect + ")";
        }

        public State(boolean z, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            this.showPermissionDialog = z;
            this.viewEffect = viewEffect;
        }

        public /* synthetic */ State(boolean z, ViewEffect.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? ViewEffect.None.INSTANCE : none);
        }

        public final boolean getShowPermissionDialog() {
            return this.showPermissionDialog;
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }
    }

    /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "", "<init>", "()V", "None", "LaunchFilePicker", "RequestStorageAccess", "FilesSelected", "Cancelled", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$Cancelled;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$FilesSelected;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$LaunchFilePicker;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$None;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$RequestStorageAccess;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$None;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1765988592;
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

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$LaunchFilePicker;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchFilePicker extends ViewEffect {
            public static final int $stable = 0;
            public static final LaunchFilePicker INSTANCE = new LaunchFilePicker();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchFilePicker)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -198349067;
            }

            public String toString() {
                return "LaunchFilePicker";
            }

            private LaunchFilePicker() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$RequestStorageAccess;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RequestStorageAccess extends ViewEffect {
            public static final int $stable = 0;
            public static final RequestStorageAccess INSTANCE = new RequestStorageAccess();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RequestStorageAccess)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1335643352;
            }

            public String toString() {
                return "RequestStorageAccess";
            }

            private RequestStorageAccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$FilesSelected;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesSelected extends ViewEffect {
            public static final int $stable = 8;
            private final List<SelectionItemInfo> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FilesSelected copy$default(FilesSelected filesSelected, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = filesSelected.items;
                }
                return filesSelected.copy(list);
            }

            public final List<SelectionItemInfo> component1() {
                return this.items;
            }

            public final FilesSelected copy(List<SelectionItemInfo> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new FilesSelected(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilesSelected) && Intrinsics.areEqual(this.items, ((FilesSelected) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "FilesSelected(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesSelected(List<SelectionItemInfo> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<SelectionItemInfo> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect$Cancelled;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Cancelled extends ViewEffect {
            public static final int $stable = 0;
            public static final Cancelled INSTANCE = new Cancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Cancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 895898265;
            }

            public String toString() {
                return "Cancelled";
            }

            private Cancelled() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "", "<init>", "()V", "RequestFilePickerLaunch", "PermissionDialogPositiveClicked", "PermissionDialogDismissed", "StorageAccessResult", "FilesSelected", "FileSelectionCancelled", "OnViewEffectProcessed", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$FileSelectionCancelled;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$FilesSelected;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$PermissionDialogDismissed;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$PermissionDialogPositiveClicked;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$RequestFilePickerLaunch;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$StorageAccessResult;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$RequestFilePickerLaunch;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RequestFilePickerLaunch extends Action {
            public static final int $stable = 0;
            public static final RequestFilePickerLaunch INSTANCE = new RequestFilePickerLaunch();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RequestFilePickerLaunch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1989596948;
            }

            public String toString() {
                return "RequestFilePickerLaunch";
            }

            private RequestFilePickerLaunch() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$PermissionDialogPositiveClicked;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionDialogPositiveClicked extends Action {
            public static final int $stable = 0;
            public static final PermissionDialogPositiveClicked INSTANCE = new PermissionDialogPositiveClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionDialogPositiveClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1753970655;
            }

            public String toString() {
                return "PermissionDialogPositiveClicked";
            }

            private PermissionDialogPositiveClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$PermissionDialogDismissed;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionDialogDismissed extends Action {
            public static final int $stable = 0;
            public static final PermissionDialogDismissed INSTANCE = new PermissionDialogDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionDialogDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1993847130;
            }

            public String toString() {
                return "PermissionDialogDismissed";
            }

            private PermissionDialogDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$StorageAccessResult;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", PermissionsResponse.GRANTED_KEY, "", "<init>", "(Z)V", "getGranted", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessResult extends Action {
            public static final int $stable = 0;
            private final boolean granted;

            public static /* synthetic */ StorageAccessResult copy$default(StorageAccessResult storageAccessResult, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = storageAccessResult.granted;
                }
                return storageAccessResult.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getGranted() {
                return this.granted;
            }

            public final StorageAccessResult copy(boolean granted) {
                return new StorageAccessResult(granted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StorageAccessResult) && this.granted == ((StorageAccessResult) other).granted;
            }

            public int hashCode() {
                return Boolean.hashCode(this.granted);
            }

            public String toString() {
                return "StorageAccessResult(granted=" + this.granted + ")";
            }

            public StorageAccessResult(boolean z) {
                super(null);
                this.granted = z;
            }

            public final boolean getGranted() {
                return this.granted;
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$FilesSelected;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "uris", "", "Landroid/net/Uri;", "<init>", "(Ljava/util/List;)V", "getUris", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesSelected extends Action {
            public static final int $stable = 8;
            private final List<Uri> uris;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FilesSelected copy$default(FilesSelected filesSelected, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = filesSelected.uris;
                }
                return filesSelected.copy(list);
            }

            public final List<Uri> component1() {
                return this.uris;
            }

            public final FilesSelected copy(List<? extends Uri> uris) {
                Intrinsics.checkNotNullParameter(uris, "uris");
                return new FilesSelected(uris);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilesSelected) && Intrinsics.areEqual(this.uris, ((FilesSelected) other).uris);
            }

            public int hashCode() {
                return this.uris.hashCode();
            }

            public String toString() {
                return "FilesSelected(uris=" + this.uris + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public FilesSelected(List<? extends Uri> uris) {
                super(null);
                Intrinsics.checkNotNullParameter(uris, "uris");
                this.uris = uris;
            }

            public final List<Uri> getUris() {
                return this.uris;
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$FileSelectionCancelled;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileSelectionCancelled extends Action {
            public static final int $stable = 0;
            public static final FileSelectionCancelled INSTANCE = new FileSelectionCancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileSelectionCancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1958991399;
            }

            public String toString() {
                return "FileSelectionCancelled";
            }

            private FileSelectionCancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/contentpicker/uploadcontent/UploadContentHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnViewEffectProcessed extends Action {
            public static final int $stable = 0;
            public static final OnViewEffectProcessed INSTANCE = new OnViewEffectProcessed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnViewEffectProcessed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2116465183;
            }

            public String toString() {
                return "OnViewEffectProcessed";
            }

            private OnViewEffectProcessed() {
                super(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        Object[] objArr16 = 0;
        Object[] objArr17 = 0;
        if (Intrinsics.areEqual(action, Action.RequestFilePickerLaunch.INSTANCE)) {
            if (this.environment.getContentFileService().hasStoragePermission()) {
                return new ReducerResult<>(State.copy$default(state, false, ViewEffect.LaunchFilePicker.INSTANCE, 1, null), effect, i, objArr17 == true ? 1 : 0);
            }
            return new ReducerResult<>(State.copy$default(state, true, null, 2, null), objArr16 == true ? 1 : 0, i, objArr15 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.PermissionDialogPositiveClicked.INSTANCE)) {
            return new ReducerResult<>(state.copy(false, ViewEffect.RequestStorageAccess.INSTANCE), objArr14 == true ? 1 : 0, i, objArr13 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.PermissionDialogDismissed.INSTANCE)) {
            return new ReducerResult<>(state.copy(false, ViewEffect.Cancelled.INSTANCE), objArr12 == true ? 1 : 0, i, objArr11 == true ? 1 : 0);
        }
        if (action instanceof Action.StorageAccessResult) {
            if (((Action.StorageAccessResult) action).getGranted()) {
                return new ReducerResult<>(State.copy$default(state, false, ViewEffect.LaunchFilePicker.INSTANCE, 1, null), objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
            }
            return new ReducerResult<>(State.copy$default(state, false, ViewEffect.Cancelled.INSTANCE, 1, null), objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.FilesSelected) {
            List<Uri> uris = ((Action.FilesSelected) action).getUris();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(uris, 10));
            for (Uri uri : uris) {
                ItemId.Local localCreate = ItemId.Local.INSTANCE.create(ItemType.FILE);
                this.environment.getContentFileService().copyFileFromUri(uri, this.environment.getUploadFileProvider().getTemporaryUploadFile(localCreate.getLocalId()));
                arrayList.add(new SelectionItemInfo(localCreate.getLocalId(), this.environment.getContentFileService().getDisplayName(uri), "file", null, null, "upload_file", 24, null));
            }
            return new ReducerResult<>(State.copy$default(state, false, new ViewEffect.FilesSelected(arrayList), 1, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.FileSelectionCancelled.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, false, ViewEffect.Cancelled.INSTANCE, 1, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (!Intrinsics.areEqual(action, Action.OnViewEffectProcessed.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, false, ViewEffect.None.INSTANCE, 1, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
