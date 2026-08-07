package com.box.android.browse.cpl.createfolder;

import com.box.android.browse.utilities.ICreateFolderHelper;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.data.CreateFolderMutation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CreateFolderReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "environment", "Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final CreateFolderEnvironment environment;

    public CreateFolderReducer(CreateFolderEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: CreateFolderReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016JZ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "", BoxCommonConstants.EXTRA_FOLDER_NAME, "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId$Remote;", "createFolderError", "nameError", "isPendingCreation", "", "isCreatedEnabled", "inviteCollaborators", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;)V", "getFolderName", "()Ljava/lang/String;", "getParentId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getCreateFolderError", "getNameError", "()Z", "getInviteCollaborators", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;)Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "equals", "other", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String createFolderError;
        private final String folderName;
        private final Boolean inviteCollaborators;
        private final boolean isCreatedEnabled;
        private final boolean isPendingCreation;
        private final String nameError;
        private final ItemId.Remote parentId;

        public static /* synthetic */ State copy$default(State state, String str, ItemId.Remote remote, String str2, String str3, boolean z, boolean z2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.folderName;
            }
            if ((i & 2) != 0) {
                remote = state.parentId;
            }
            if ((i & 4) != 0) {
                str2 = state.createFolderError;
            }
            if ((i & 8) != 0) {
                str3 = state.nameError;
            }
            if ((i & 16) != 0) {
                z = state.isPendingCreation;
            }
            if ((i & 32) != 0) {
                z2 = state.isCreatedEnabled;
            }
            if ((i & 64) != 0) {
                bool = state.inviteCollaborators;
            }
            boolean z3 = z2;
            Boolean bool2 = bool;
            boolean z4 = z;
            String str4 = str2;
            return state.copy(str, remote, str4, str3, z4, z3, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFolderName() {
            return this.folderName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemId.Remote getParentId() {
            return this.parentId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCreateFolderError() {
            return this.createFolderError;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNameError() {
            return this.nameError;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPendingCreation() {
            return this.isPendingCreation;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsCreatedEnabled() {
            return this.isCreatedEnabled;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getInviteCollaborators() {
            return this.inviteCollaborators;
        }

        public final State copy(String folderName, ItemId.Remote parentId, String createFolderError, String nameError, boolean isPendingCreation, boolean isCreatedEnabled, Boolean inviteCollaborators) {
            Intrinsics.checkNotNullParameter(folderName, "folderName");
            Intrinsics.checkNotNullParameter(parentId, "parentId");
            return new State(folderName, parentId, createFolderError, nameError, isPendingCreation, isCreatedEnabled, inviteCollaborators);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.folderName, state.folderName) && Intrinsics.areEqual(this.parentId, state.parentId) && Intrinsics.areEqual(this.createFolderError, state.createFolderError) && Intrinsics.areEqual(this.nameError, state.nameError) && this.isPendingCreation == state.isPendingCreation && this.isCreatedEnabled == state.isCreatedEnabled && Intrinsics.areEqual(this.inviteCollaborators, state.inviteCollaborators);
        }

        public int hashCode() {
            int iHashCode = ((this.folderName.hashCode() * 31) + this.parentId.hashCode()) * 31;
            String str = this.createFolderError;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.nameError;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isPendingCreation)) * 31) + Boolean.hashCode(this.isCreatedEnabled)) * 31;
            Boolean bool = this.inviteCollaborators;
            return iHashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "State(folderName=" + this.folderName + ", parentId=" + this.parentId + ", createFolderError=" + this.createFolderError + ", nameError=" + this.nameError + ", isPendingCreation=" + this.isPendingCreation + ", isCreatedEnabled=" + this.isCreatedEnabled + ", inviteCollaborators=" + this.inviteCollaborators + ")";
        }

        public State(String folderName, ItemId.Remote parentId, String str, String str2, boolean z, boolean z2, Boolean bool) {
            Intrinsics.checkNotNullParameter(folderName, "folderName");
            Intrinsics.checkNotNullParameter(parentId, "parentId");
            this.folderName = folderName;
            this.parentId = parentId;
            this.createFolderError = str;
            this.nameError = str2;
            this.isPendingCreation = z;
            this.isCreatedEnabled = z2;
            this.inviteCollaborators = bool;
        }

        public /* synthetic */ State(String str, ItemId.Remote remote, String str2, String str3, boolean z, boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, remote, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? null : bool);
        }

        public final String getFolderName() {
            return this.folderName;
        }

        public final ItemId.Remote getParentId() {
            return this.parentId;
        }

        public final String getCreateFolderError() {
            return this.createFolderError;
        }

        public final String getNameError() {
            return this.nameError;
        }

        public final boolean isPendingCreation() {
            return this.isPendingCreation;
        }

        public final boolean isCreatedEnabled() {
            return this.isCreatedEnabled;
        }

        public final Boolean getInviteCollaborators() {
            return this.inviteCollaborators;
        }
    }

    /* JADX INFO: compiled from: CreateFolderReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "", "<init>", "()V", "FolderCreationCancelled", CreateFolderMutation.OPERATION_NAME, "CreateFolderErrorHandled", "FolderCreated", "FolderCreationFailed", "FolderNameUpdated", "InviteCollaboratorsChecked", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$CreateFolderErrorHandled;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreated;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreationCancelled;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreationFailed;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderNameUpdated;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$InviteCollaboratorsChecked;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreationCancelled;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class FolderCreationCancelled extends Action {
            public static final int $stable = 0;
            public static final FolderCreationCancelled INSTANCE = new FolderCreationCancelled();

            private FolderCreationCancelled() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$CreateFolder;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CreateFolder extends Action {
            public static final int $stable = 0;
            public static final CreateFolder INSTANCE = new CreateFolder();

            private CreateFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$CreateFolderErrorHandled;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CreateFolderErrorHandled extends Action {
            public static final int $stable = 0;
            public static final CreateFolderErrorHandled INSTANCE = new CreateFolderErrorHandled();

            private CreateFolderErrorHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreated;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderCreated extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ FolderCreated copy$default(FolderCreated folderCreated, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = folderCreated.folder;
                }
                return folderCreated.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final FolderCreated copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new FolderCreated(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderCreated) && Intrinsics.areEqual(this.folder, ((FolderCreated) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "FolderCreated(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderCreated(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderCreationFailed;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderCreationFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ FolderCreationFailed copy$default(FolderCreationFailed folderCreationFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = folderCreationFailed.error;
                }
                return folderCreationFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final FolderCreationFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new FolderCreationFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderCreationFailed) && Intrinsics.areEqual(this.error, ((FolderCreationFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "FolderCreationFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderCreationFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$FolderNameUpdated;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderNameUpdated extends Action {
            public static final int $stable = 0;
            private final String name;

            public static /* synthetic */ FolderNameUpdated copy$default(FolderNameUpdated folderNameUpdated, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = folderNameUpdated.name;
                }
                return folderNameUpdated.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final FolderNameUpdated copy(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new FolderNameUpdated(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderNameUpdated) && Intrinsics.areEqual(this.name, ((FolderNameUpdated) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            public String toString() {
                return "FolderNameUpdated(name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderNameUpdated(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: CreateFolderReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action$InviteCollaboratorsChecked;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InviteCollaboratorsChecked extends Action {
            public static final int $stable = 0;
            private final boolean checked;

            public static /* synthetic */ InviteCollaboratorsChecked copy$default(InviteCollaboratorsChecked inviteCollaboratorsChecked, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = inviteCollaboratorsChecked.checked;
                }
                return inviteCollaboratorsChecked.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getChecked() {
                return this.checked;
            }

            public final InviteCollaboratorsChecked copy(boolean checked) {
                return new InviteCollaboratorsChecked(checked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InviteCollaboratorsChecked) && this.checked == ((InviteCollaboratorsChecked) other).checked;
            }

            public int hashCode() {
                return Boolean.hashCode(this.checked);
            }

            public String toString() {
                return "InviteCollaboratorsChecked(checked=" + this.checked + ")";
            }

            public InviteCollaboratorsChecked(boolean z) {
                super(null);
                this.checked = z;
            }

            public final boolean getChecked() {
                return this.checked;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        String incorrectCharacterError;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.FolderNameUpdated) {
            Action.FolderNameUpdated folderNameUpdated = (Action.FolderNameUpdated) action;
            if (folderNameUpdated.getName().length() == 0 || this.environment.getItemNameValidator().isItemNameValidForSD(folderNameUpdated.getName())) {
                incorrectCharacterError = null;
            } else {
                ICreateFolderHelper createFolderHelper = this.environment.getCreateFolderHelper();
                Character itemIncorrectCharacter = this.environment.getItemNameValidator().getItemIncorrectCharacter(folderNameUpdated.getName());
                incorrectCharacterError = createFolderHelper.getIncorrectCharacterError(itemIncorrectCharacter != null ? itemIncorrectCharacter.charValue() : StringsKt.last(folderNameUpdated.getName()));
            }
            return new ReducerResult<>(State.copy$default(state, folderNameUpdated.getName(), null, null, incorrectCharacterError, false, CommonBoxUtil.isFilenameValidForSD(folderNameUpdated.getName()), null, 86, null), null, 2, null);
        }
        if (action instanceof Action.CreateFolder) {
            String string = StringsKt.trim((CharSequence) state.getFolderName()).toString();
            return new ReducerResult<>(State.copy$default(state, string, null, null, null, true, false, null, 110, null), new Effect((Function1) new AnonymousClass1(string, state, null)));
        }
        if (action instanceof Action.FolderCreationFailed) {
            return new ReducerResult<>(State.copy$default(state, null, null, this.environment.getCreateFolderHelper().getCreateFolderError(((Action.FolderCreationFailed) action).getError()), null, false, false, null, 107, null), null, 2, null);
        }
        if (action instanceof Action.CreateFolderErrorHandled) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, null, 123, null), null, 2, null);
        }
        if (action instanceof Action.InviteCollaboratorsChecked) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, false, false, Boolean.valueOf(((Action.InviteCollaboratorsChecked) action).getChecked()), 63, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.createfolder.CreateFolderReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateFolderReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.createfolder.CreateFolderReducer$reduce$1", f = "CreateFolderReducer.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ String $folderNameTrimmed;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$folderNameTrimmed = str;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CreateFolderReducer.this.new AnonymousClass1(this.$folderNameTrimmed, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CreateFolderReducer.this.environment.getCreateFolderUseCase().createFolder(this.$folderNameTrimmed, this.$state.getParentId(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Action.FolderCreated((FolderModel) ((Result.Success) result).getValue());
            }
            if (result instanceof Result.Error) {
                return new Action.FolderCreationFailed((DomainError) ((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
