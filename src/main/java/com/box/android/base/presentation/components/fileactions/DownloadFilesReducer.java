package com.box.android.base.presentation.components.fileactions;

import androidx.media3.effect.DebugTraceUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFilesReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;)V", "getEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceDownload", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "toError", "Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "Action", "State", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFilesReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final DownloadEnvironment environment;

    public DownloadFilesReducer(DownloadEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new DownloadFilesReducer$build$1(this));
    }

    public final DownloadEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: DownloadFilesReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "", "<init>", "()V", DebugTraceUtil.EVENT_START, "SelectFolder", "DownloadToFolder", "Finish", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$DownloadToFolder;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$Finish;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$SelectFolder;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$Start;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: DownloadFilesReducer.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$Start;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "file", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;)V", "getItemModels", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Start extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> itemModels;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Start copy$default(Start start, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = start.itemModels;
                }
                return start.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.itemModels;
            }

            public final Start copy(List<? extends ItemModel> itemModels) {
                Intrinsics.checkNotNullParameter(itemModels, "itemModels");
                return new Start(itemModels);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Start) && Intrinsics.areEqual(this.itemModels, ((Start) other).itemModels);
            }

            public int hashCode() {
                return this.itemModels.hashCode();
            }

            public String toString() {
                return "Start(itemModels=" + this.itemModels + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Start(List<? extends ItemModel> itemModels) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModels, "itemModels");
                this.itemModels = itemModels;
            }

            public final List<ItemModel> getItemModels() {
                return this.itemModels;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Start(FileModel file) {
                this((List<? extends ItemModel>) CollectionsKt.listOf(file));
                Intrinsics.checkNotNullParameter(file, "file");
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: DownloadFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$SelectFolder;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectFolder extends Action {
            public static final int $stable = 0;
            public static final SelectFolder INSTANCE = new SelectFolder();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectFolder)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1466224528;
            }

            public String toString() {
                return "SelectFolder";
            }

            private SelectFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DownloadFilesReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$DownloadToFolder;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "downloadFolder", "", "<init>", "(Ljava/lang/String;)V", "getDownloadFolder", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DownloadToFolder extends Action {
            public static final int $stable = 0;
            private final String downloadFolder;

            public static /* synthetic */ DownloadToFolder copy$default(DownloadToFolder downloadToFolder, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = downloadToFolder.downloadFolder;
                }
                return downloadToFolder.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDownloadFolder() {
                return this.downloadFolder;
            }

            public final DownloadToFolder copy(String downloadFolder) {
                return new DownloadToFolder(downloadFolder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DownloadToFolder) && Intrinsics.areEqual(this.downloadFolder, ((DownloadToFolder) other).downloadFolder);
            }

            public int hashCode() {
                String str = this.downloadFolder;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "DownloadToFolder(downloadFolder=" + this.downloadFolder + ")";
            }

            public DownloadToFolder(String str) {
                super(null);
                this.downloadFolder = str;
            }

            public final String getDownloadFolder() {
                return this.downloadFolder;
            }
        }

        /* JADX INFO: compiled from: DownloadFilesReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action$Finish;", "Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Finish extends Action {
            public static final int $stable = 0;
            public static final Finish INSTANCE = new Finish();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finish)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -649096967;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: DownloadFilesReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/fileactions/DownloadFilesReducer$State;", "", "error", "Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/base/presentation/components/fileactions/FileActionsError;Ljava/util/List;)V", "getError", "()Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "getItemModels", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final FileActionsError error;
        private final List<ItemModel> itemModels;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileActionsError fileActionsError, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                fileActionsError = state.error;
            }
            if ((i & 2) != 0) {
                list = state.itemModels;
            }
            return state.copy(fileActionsError, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileActionsError getError() {
            return this.error;
        }

        public final List<ItemModel> component2() {
            return this.itemModels;
        }

        public final State copy(FileActionsError error, List<? extends ItemModel> itemModels) {
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            return new State(error, itemModels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.error == state.error && Intrinsics.areEqual(this.itemModels, state.itemModels);
        }

        public int hashCode() {
            FileActionsError fileActionsError = this.error;
            return ((fileActionsError == null ? 0 : fileActionsError.hashCode()) * 31) + this.itemModels.hashCode();
        }

        public String toString() {
            return "State(error=" + this.error + ", itemModels=" + this.itemModels + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FileActionsError fileActionsError, List<? extends ItemModel> itemModels) {
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            this.error = fileActionsError;
            this.itemModels = itemModels;
        }

        public /* synthetic */ State(FileActionsError fileActionsError, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fileActionsError, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final FileActionsError getError() {
            return this.error;
        }

        public final List<ItemModel> getItemModels() {
            return this.itemModels;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceDownload(State state, Action action) {
        FileActionsError fileActionsError = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (action instanceof Action.Start) {
            Result<Unit, AdminSettingsDomainError> resultCheckDownloadActionAdminSettings = this.environment.getFileActionsManager().checkDownloadActionAdminSettings();
            if (resultCheckDownloadActionAdminSettings instanceof Result.Error) {
                return new ReducerResult<>(State.copy$default(state, toError((AdminSettingsDomainError) ((Result.Error) resultCheckDownloadActionAdminSettings).getValue()), null, 2, null), null, 2, null);
            }
            if (!(resultCheckDownloadActionAdminSettings instanceof Result.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, null, ((Action.Start) action).getItemModels(), 1, null), new Effect(Action.SelectFolder.INSTANCE));
        }
        if (action instanceof Action.DownloadToFolder) {
            if (state.getItemModels().isEmpty() || ((Action.DownloadToFolder) action).getDownloadFolder() == null) {
                return new ReducerResult<>(state, new Effect(Action.Finish.INSTANCE));
            }
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, this, action, null)), new Effect(Action.Finish.INSTANCE)));
        }
        if (action instanceof Action.SelectFolder) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.Finish) {
            return new ReducerResult<>(new State(fileActionsError, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.fileactions.DownloadFilesReducer$reduceDownload$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFilesReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.fileactions.DownloadFilesReducer$reduceDownload$1", f = "DownloadFilesReducer.kt", i = {0, 0, 0, 0, 0, 0}, l = {74}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-DownloadFilesReducer$reduceDownload$1$1", "useMigrated"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ DownloadFilesReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, DownloadFilesReducer downloadFilesReducer, Action action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = downloadFilesReducer;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.this$0, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v16 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v7, types: [int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Action action;
            DownloadFilesReducer downloadFilesReducer;
            Iterator it;
            Iterable iterable;
            int i;
            ?? r11;
            boolean enabled;
            boolean enabled2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 1;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<ItemModel> itemModels = this.$state.getItemModels();
                DownloadFilesReducer downloadFilesReducer2 = this.this$0;
                action = this.$action;
                downloadFilesReducer = downloadFilesReducer2;
                it = itemModels.iterator();
                iterable = itemModels;
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$3;
                action = (Action) this.L$2;
                downloadFilesReducer = (DownloadFilesReducer) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                ItemModel itemModel = (ItemModel) next;
                if (itemModel instanceof FileModel) {
                    enabled2 = downloadFilesReducer.getEnvironment().getFeatureFlips().getFileDownloadJobMigration().getEnabled();
                } else if (itemModel instanceof FolderModel) {
                    enabled = downloadFilesReducer.getEnvironment().getFeatureFlips().getDownloadFolderJobMigration().getEnabled();
                } else {
                    r11 = 0;
                }
                if (r11 != 0) {
                    r11 = enabled;
                    r11 = enabled2;
                    ILocalItemService itemService = downloadFilesReducer.getEnvironment().getItemService();
                    List<? extends ItemModel> listListOf = CollectionsKt.listOf(itemModel);
                    String downloadFolder = ((Action.DownloadToFolder) action).getDownloadFolder();
                    JobTags.JobSource jobSource = JobTags.JobSource.DOWNLOAD_FROM_PREVIEW;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$1 = downloadFilesReducer;
                    this.L$2 = action;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(itemModel);
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.I$2 = r11;
                    i3 = 1;
                    this.label = 1;
                    if (itemService.enqueueDownloadJobForItems(listListOf, downloadFolder, jobSource, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    r11 = enabled;
                    r11 = enabled2;
                    downloadFilesReducer.getEnvironment().getJobManager().exportItems(CollectionsKt.listOf(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, itemModel, false, i3, null)), ((Action.DownloadToFolder) action).getDownloadFolder());
                    Unit unit = Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final FileActionsError toError(AdminSettingsDomainError adminSettingsDomainError) {
        if (adminSettingsDomainError instanceof AdminSettingsDomainError.SaveToLocationDisabled) {
            return FileActionsError.SAVE_TO_LOCATION_NOT_ALLOWED;
        }
        if (adminSettingsDomainError instanceof AdminSettingsDomainError.EncryptedDeviceRequired) {
            return FileActionsError.ENCRYPTED_DEVICE_REQUIRED;
        }
        return adminSettingsDomainError instanceof AdminSettingsDomainError.FeatureDisabled ? FileActionsError.FEATURE_DISABLED : FileActionsError.FEATURE_DISABLED;
    }
}
