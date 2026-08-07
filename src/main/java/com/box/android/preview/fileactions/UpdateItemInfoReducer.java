package com.box.android.preview.fileactions;

import com.box.android.base.cpl.StringResourceParams;
import com.box.android.base.cpl.StringResourceWrapper;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FileUploadDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IUpdateItemInfoService;
import com.box.android.domain.utils.result.Result;
import com.box.android.fileactivity.R;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "environment", "Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "<init>", "(Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "performUpdate", "Lcom/box/android/cpl/ReducerResult;", "state", "getNameError", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "name", "", "nameLengthLimit", "", "State", "Action", "NameError", "DescriptionError", AuthenticationConstants.BUNDLE_MESSAGE, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateItemInfoReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final UpdateItemInfoEnvironment environment;

    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;", "", "<init>", "(Ljava/lang/String;I)V", "NAME_CHANGED", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Message {
        NAME_CHANGED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Message> getEntries() {
            return $ENTRIES;
        }
    }

    public UpdateItemInfoReducer(UpdateItemInfoEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.preview.fileactions.UpdateItemInfoReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UpdateItemInfoReducer.build$lambda$0(this.f$0, (UpdateItemInfoReducer.State) obj, (UpdateItemInfoReducer.Action) obj2);
            }
        });
    }

    public final UpdateItemInfoEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0001NB\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\nHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\t\u0010E\u001a\u00020\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0093\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u0010J\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020)HÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010.\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0013\u00106\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006O"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "", "initialName", "", "initialDescription", "updatedName", "updatedDescription", "itemId", "Lcom/box/android/domain/models/ItemId;", "hasUpdatePermission", "", "fileExtension", "updateItemInfoError", "Lcom/box/android/domain/models/DomainError;", "isConfirmEnabled", "isRenamePending", "message", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;", "isDescriptionUpdatePending", "nameError", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/ItemId;ZLjava/lang/String;Lcom/box/android/domain/models/DomainError;ZZLcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;ZLcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;)V", "getInitialName", "()Ljava/lang/String;", "getInitialDescription", "getUpdatedName", "getUpdatedDescription", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getHasUpdatePermission", "()Z", "getFileExtension", "getUpdateItemInfoError", "()Lcom/box/android/domain/models/DomainError;", "getMessage", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;", "getNameError", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "isFile", "nameLengthLimit", "", "getNameLengthLimit", "()I", "hasUnsavedNameChanges", "getHasUnsavedNameChanges", "hasUnsavedDescriptionChanges", "getHasUnsavedDescriptionChanges", "descriptionError", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;", "getDescriptionError", "()Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;", "updateEnabled", "getUpdateEnabled", "updateItemErrorMessage", "Lcom/box/android/base/cpl/StringResourceWrapper;", "getUpdateItemErrorMessage", "()Lcom/box/android/base/cpl/StringResourceWrapper;", "isSavingInProcess", "hasDetailsInputError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int MAX_DESCRIPTION_LENGTH = 255;
        private static final int MAX_NAME_LENGTH = 255;
        private final String fileExtension;
        private final boolean hasUnsavedDescriptionChanges;
        private final boolean hasUnsavedNameChanges;
        private final boolean hasUpdatePermission;
        private final String initialDescription;
        private final String initialName;
        private final boolean isConfirmEnabled;
        private final boolean isDescriptionUpdatePending;
        private final boolean isFile;
        private final boolean isRenamePending;
        private final ItemId itemId;
        private final Message message;
        private final NameError nameError;
        private final boolean updateEnabled;
        private final DomainError updateItemInfoError;
        private final String updatedDescription;
        private final String updatedName;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ State copy$default(State state, String str, String str2, String str3, String str4, ItemId itemId, boolean z, String str5, DomainError domainError, boolean z2, boolean z3, Message message, boolean z4, NameError nameError, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.initialName;
            }
            return state.copy(str, (i & 2) != 0 ? state.initialDescription : str2, (i & 4) != 0 ? state.updatedName : str3, (i & 8) != 0 ? state.updatedDescription : str4, (i & 16) != 0 ? state.itemId : itemId, (i & 32) != 0 ? state.hasUpdatePermission : z, (i & 64) != 0 ? state.fileExtension : str5, (i & 128) != 0 ? state.updateItemInfoError : domainError, (i & 256) != 0 ? state.isConfirmEnabled : z2, (i & 512) != 0 ? state.isRenamePending : z3, (i & 1024) != 0 ? state.message : message, (i & 2048) != 0 ? state.isDescriptionUpdatePending : z4, (i & 4096) != 0 ? state.nameError : nameError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInitialName() {
            return this.initialName;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsRenamePending() {
            return this.isRenamePending;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getIsDescriptionUpdatePending() {
            return this.isDescriptionUpdatePending;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final NameError getNameError() {
            return this.nameError;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getInitialDescription() {
            return this.initialDescription;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUpdatedName() {
            return this.updatedName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUpdatedDescription() {
            return this.updatedDescription;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getHasUpdatePermission() {
            return this.hasUpdatePermission;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getFileExtension() {
            return this.fileExtension;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final DomainError getUpdateItemInfoError() {
            return this.updateItemInfoError;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsConfirmEnabled() {
            return this.isConfirmEnabled;
        }

        public final State copy(String initialName, String initialDescription, String updatedName, String updatedDescription, ItemId itemId, boolean hasUpdatePermission, String fileExtension, DomainError updateItemInfoError, boolean isConfirmEnabled, boolean isRenamePending, Message message, boolean isDescriptionUpdatePending, NameError nameError) {
            Intrinsics.checkNotNullParameter(initialName, "initialName");
            Intrinsics.checkNotNullParameter(initialDescription, "initialDescription");
            Intrinsics.checkNotNullParameter(updatedName, "updatedName");
            Intrinsics.checkNotNullParameter(updatedDescription, "updatedDescription");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new State(initialName, initialDescription, updatedName, updatedDescription, itemId, hasUpdatePermission, fileExtension, updateItemInfoError, isConfirmEnabled, isRenamePending, message, isDescriptionUpdatePending, nameError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.initialName, state.initialName) && Intrinsics.areEqual(this.initialDescription, state.initialDescription) && Intrinsics.areEqual(this.updatedName, state.updatedName) && Intrinsics.areEqual(this.updatedDescription, state.updatedDescription) && Intrinsics.areEqual(this.itemId, state.itemId) && this.hasUpdatePermission == state.hasUpdatePermission && Intrinsics.areEqual(this.fileExtension, state.fileExtension) && Intrinsics.areEqual(this.updateItemInfoError, state.updateItemInfoError) && this.isConfirmEnabled == state.isConfirmEnabled && this.isRenamePending == state.isRenamePending && this.message == state.message && this.isDescriptionUpdatePending == state.isDescriptionUpdatePending && Intrinsics.areEqual(this.nameError, state.nameError);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.initialName.hashCode() * 31) + this.initialDescription.hashCode()) * 31) + this.updatedName.hashCode()) * 31) + this.updatedDescription.hashCode()) * 31) + this.itemId.hashCode()) * 31) + Boolean.hashCode(this.hasUpdatePermission)) * 31;
            String str = this.fileExtension;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DomainError domainError = this.updateItemInfoError;
            int iHashCode3 = (((((iHashCode2 + (domainError == null ? 0 : domainError.hashCode())) * 31) + Boolean.hashCode(this.isConfirmEnabled)) * 31) + Boolean.hashCode(this.isRenamePending)) * 31;
            Message message = this.message;
            int iHashCode4 = (((iHashCode3 + (message == null ? 0 : message.hashCode())) * 31) + Boolean.hashCode(this.isDescriptionUpdatePending)) * 31;
            NameError nameError = this.nameError;
            return iHashCode4 + (nameError != null ? nameError.hashCode() : 0);
        }

        public String toString() {
            return "State(initialName=" + this.initialName + ", initialDescription=" + this.initialDescription + ", updatedName=" + this.updatedName + ", updatedDescription=" + this.updatedDescription + ", itemId=" + this.itemId + ", hasUpdatePermission=" + this.hasUpdatePermission + ", fileExtension=" + this.fileExtension + ", updateItemInfoError=" + this.updateItemInfoError + ", isConfirmEnabled=" + this.isConfirmEnabled + ", isRenamePending=" + this.isRenamePending + ", message=" + this.message + ", isDescriptionUpdatePending=" + this.isDescriptionUpdatePending + ", nameError=" + this.nameError + ")";
        }

        public State(String initialName, String initialDescription, String updatedName, String updatedDescription, ItemId itemId, boolean z, String str, DomainError domainError, boolean z2, boolean z3, Message message, boolean z4, NameError nameError) {
            Intrinsics.checkNotNullParameter(initialName, "initialName");
            Intrinsics.checkNotNullParameter(initialDescription, "initialDescription");
            Intrinsics.checkNotNullParameter(updatedName, "updatedName");
            Intrinsics.checkNotNullParameter(updatedDescription, "updatedDescription");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.initialName = initialName;
            this.initialDescription = initialDescription;
            this.updatedName = updatedName;
            this.updatedDescription = updatedDescription;
            this.itemId = itemId;
            this.hasUpdatePermission = z;
            this.fileExtension = str;
            this.updateItemInfoError = domainError;
            this.isConfirmEnabled = z2;
            this.isRenamePending = z3;
            this.message = message;
            this.isDescriptionUpdatePending = z4;
            this.nameError = nameError;
            boolean z5 = false;
            this.isFile = itemId.getType() == ItemType.FILE;
            this.hasUnsavedNameChanges = !Intrinsics.areEqual(updatedName, initialName);
            this.hasUnsavedDescriptionChanges = !Intrinsics.areEqual(updatedDescription, initialDescription);
            if (z && !hasDetailsInputError() && !isSavingInProcess()) {
                z5 = true;
            }
            this.updateEnabled = z5;
        }

        public /* synthetic */ State(String str, String str2, String str3, String str4, ItemId itemId, boolean z, String str5, DomainError domainError, boolean z2, boolean z3, Message message, boolean z4, NameError nameError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, itemId, z, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : domainError, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? null : message, (i & 2048) != 0 ? false : z4, (i & 4096) != 0 ? null : nameError);
        }

        public final String getInitialName() {
            return this.initialName;
        }

        public final String getInitialDescription() {
            return this.initialDescription;
        }

        public final String getUpdatedName() {
            return this.updatedName;
        }

        public final String getUpdatedDescription() {
            return this.updatedDescription;
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public final boolean getHasUpdatePermission() {
            return this.hasUpdatePermission;
        }

        public final String getFileExtension() {
            return this.fileExtension;
        }

        public final DomainError getUpdateItemInfoError() {
            return this.updateItemInfoError;
        }

        public final boolean isConfirmEnabled() {
            return this.isConfirmEnabled;
        }

        public final boolean isRenamePending() {
            return this.isRenamePending;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final boolean isDescriptionUpdatePending() {
            return this.isDescriptionUpdatePending;
        }

        public final NameError getNameError() {
            return this.nameError;
        }

        /* JADX INFO: renamed from: isFile, reason: from getter */
        public final boolean getIsFile() {
            return this.isFile;
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State$Companion;", "", "<init>", "()V", "createInitialState", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$State;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "updatedName", "", "updatedDescription", "message", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;", "isRenamePending", "", "isDescriptionUpdatePending", "MAX_NAME_LENGTH", "", "MAX_DESCRIPTION_LENGTH", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ State createInitialState$default(Companion companion, ItemModel itemModel, String str, String str2, Message message, boolean z, boolean z2, int i, Object obj) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    message = null;
                }
                if ((i & 16) != 0) {
                    z = false;
                }
                if ((i & 32) != 0) {
                    z2 = false;
                }
                return companion.createInitialState(itemModel, str, str2, message, z, z2);
            }

            public final State createInitialState(ItemModel itemModel, String updatedName, String updatedDescription, Message message, boolean isRenamePending, boolean isDescriptionUpdatePending) {
                String name;
                String str;
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                String str2 = null;
                if (ItemModelKt.type(itemModel) == ItemType.FILE) {
                    name = StringsKt.substringBeforeLast$default(itemModel.getName(), '.', (String) null, 2, (Object) null);
                } else {
                    name = itemModel.getName();
                }
                String str3 = name;
                if (ItemModelKt.type(itemModel) == ItemType.FILE) {
                    String strSubstringAfterLast = StringsKt.substringAfterLast(itemModel.getName(), '.', "");
                    str2 = StringsKt.isBlank(strSubstringAfterLast) ? null : strSubstringAfterLast;
                }
                String str4 = str2;
                String description = itemModel.getDescription();
                String str5 = description == null ? "" : description;
                String str6 = updatedName == null ? str3 : updatedName;
                if (updatedDescription == null) {
                    String description2 = itemModel.getDescription();
                    str = description2 == null ? "" : description2;
                } else {
                    str = updatedDescription;
                }
                ItemId itemId = itemModel.getItemId();
                PermissionsModel permissions = itemModel.getPermissions();
                return new State(str3, str5, str6, str, itemId, permissions != null && permissions.getCanRename(), str4, null, false, isRenamePending, message, isDescriptionUpdatePending, null, 4480, null);
            }
        }

        public final int getNameLengthLimit() {
            String str = this.fileExtension;
            return 255 - (str != null ? str.length() + 1 : 0);
        }

        public final boolean getHasUnsavedNameChanges() {
            return this.hasUnsavedNameChanges;
        }

        public final boolean getHasUnsavedDescriptionChanges() {
            return this.hasUnsavedDescriptionChanges;
        }

        public final DescriptionError getDescriptionError() {
            if (this.updatedDescription.length() > 255) {
                return new DescriptionError.TooLong(this.updatedDescription.length() - 255, 255);
            }
            return null;
        }

        public final boolean getUpdateEnabled() {
            return this.updateEnabled;
        }

        public final StringResourceWrapper getUpdateItemErrorMessage() {
            String str;
            StringResourceParams stringResourceParams;
            DomainError domainError = this.updateItemInfoError;
            if (domainError == null) {
                return null;
            }
            String str2 = this.fileExtension;
            if (str2 == null || (str = this.updatedName + "." + str2) == null) {
                str = this.updatedName;
            }
            if (domainError instanceof FileUploadDomainError.NameExistsErr) {
                return new StringResourceParams(this.isFile ? R.string.file_rename_error_duplicate_name : R.string.folder_rename_error_duplicate_name, str);
            }
            if (domainError instanceof DomainError.NoConnectivityError) {
                return new StringResourceParams(R.string.check_connection_try_again, new String[0]);
            }
            if (!Intrinsics.areEqual(this.updatedDescription, this.initialDescription) && !Intrinsics.areEqual(this.updatedName, this.initialName)) {
                stringResourceParams = new StringResourceParams(R.string.generic_try_again_error, new String[0]);
            } else if (!Intrinsics.areEqual(this.updatedDescription, this.initialDescription)) {
                stringResourceParams = new StringResourceParams(R.string.update_description_error_generic, new String[0]);
            } else if (!Intrinsics.areEqual(this.updatedName, this.initialName)) {
                stringResourceParams = new StringResourceParams(R.string.rename_error_genericerror, new String[0]);
            } else {
                stringResourceParams = new StringResourceParams(R.string.generic_try_again_error, new String[0]);
            }
            return stringResourceParams;
        }

        private final boolean isSavingInProcess() {
            return this.isRenamePending || this.isDescriptionUpdatePending;
        }

        private final boolean hasDetailsInputError() {
            return (getDescriptionError() == null && this.nameError == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "", "<init>", "()V", "PerformUpdate", "Success", "ItemRefreshed", "Failed", "HandledError", "Finish", "SuccessMessageShown", "NameUpdated", "DescriptionUpdated", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$DescriptionUpdated;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Failed;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Finish;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$HandledError;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$ItemRefreshed;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$NameUpdated;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$PerformUpdate;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Success;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$SuccessMessageShown;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$PerformUpdate;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PerformUpdate extends Action {
            public static final int $stable = 0;
            public static final PerformUpdate INSTANCE = new PerformUpdate();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PerformUpdate)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -249712992;
            }

            public String toString() {
                return "PerformUpdate";
            }

            private PerformUpdate() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Success;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Success extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ Success copy$default(Success success, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = success.itemModel;
                }
                return success.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final Success copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new Success(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.itemModel, ((Success) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "Success(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$ItemRefreshed;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Failed;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Failed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Failed copy$default(Failed failed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = failed.error;
                }
                return failed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Failed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Failed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && Intrinsics.areEqual(this.error, ((Failed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Failed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$HandledError;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HandledError extends Action {
            public static final int $stable = 0;
            public static final HandledError INSTANCE = new HandledError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandledError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 21431894;
            }

            public String toString() {
                return "HandledError";
            }

            private HandledError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$Finish;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -623424963;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$SuccessMessageShown;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SuccessMessageShown extends Action {
            public static final int $stable = 0;
            public static final SuccessMessageShown INSTANCE = new SuccessMessageShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuccessMessageShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1011380099;
            }

            public String toString() {
                return "SuccessMessageShown";
            }

            private SuccessMessageShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$NameUpdated;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NameUpdated extends Action {
            public static final int $stable = 0;
            private final String name;

            public static /* synthetic */ NameUpdated copy$default(NameUpdated nameUpdated, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = nameUpdated.name;
                }
                return nameUpdated.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final NameUpdated copy(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new NameUpdated(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NameUpdated) && Intrinsics.areEqual(this.name, ((NameUpdated) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            public String toString() {
                return "NameUpdated(name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NameUpdated(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action$DescriptionUpdated;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "description", "", "<init>", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DescriptionUpdated extends Action {
            public static final int $stable = 0;
            private final String description;

            public static /* synthetic */ DescriptionUpdated copy$default(DescriptionUpdated descriptionUpdated, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = descriptionUpdated.description;
                }
                return descriptionUpdated.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final DescriptionUpdated copy(String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                return new DescriptionUpdated(description);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DescriptionUpdated) && Intrinsics.areEqual(this.description, ((DescriptionUpdated) other).description);
            }

            public int hashCode() {
                return this.description.hashCode();
            }

            public String toString() {
                return "DescriptionUpdated(description=" + this.description + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DescriptionUpdated(String description) {
                super(null);
                Intrinsics.checkNotNullParameter(description, "description");
                this.description = description;
            }

            public final String getDescription() {
                return this.description;
            }
        }
    }

    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "", "<init>", "()V", "EmptyName", "TooLong", "InvalidCharacter", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$EmptyName;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$InvalidCharacter;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$TooLong;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class NameError {
        public static final int $stable = 0;

        public /* synthetic */ NameError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$EmptyName;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "isFile", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EmptyName extends NameError {
            public static final int $stable = 0;
            private final boolean isFile;

            public static /* synthetic */ EmptyName copy$default(EmptyName emptyName, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = emptyName.isFile;
                }
                return emptyName.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsFile() {
                return this.isFile;
            }

            public final EmptyName copy(boolean isFile) {
                return new EmptyName(isFile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EmptyName) && this.isFile == ((EmptyName) other).isFile;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isFile);
            }

            public String toString() {
                return "EmptyName(isFile=" + this.isFile + ")";
            }

            public EmptyName(boolean z) {
                super(null);
                this.isFile = z;
            }

            public final boolean isFile() {
                return this.isFile;
            }
        }

        private NameError() {
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$TooLong;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "exceedsBy", "", BoxIterator.FIELD_LIMIT, "<init>", "(II)V", "getExceedsBy", "()I", "getLimit", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TooLong extends NameError {
            public static final int $stable = 0;
            private final int exceedsBy;
            private final int limit;

            public static /* synthetic */ TooLong copy$default(TooLong tooLong, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = tooLong.exceedsBy;
                }
                if ((i3 & 2) != 0) {
                    i2 = tooLong.limit;
                }
                return tooLong.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getExceedsBy() {
                return this.exceedsBy;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getLimit() {
                return this.limit;
            }

            public final TooLong copy(int exceedsBy, int limit) {
                return new TooLong(exceedsBy, limit);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TooLong)) {
                    return false;
                }
                TooLong tooLong = (TooLong) other;
                return this.exceedsBy == tooLong.exceedsBy && this.limit == tooLong.limit;
            }

            public int hashCode() {
                return (Integer.hashCode(this.exceedsBy) * 31) + Integer.hashCode(this.limit);
            }

            public String toString() {
                return "TooLong(exceedsBy=" + this.exceedsBy + ", limit=" + this.limit + ")";
            }

            public TooLong(int i, int i2) {
                super(null);
                this.exceedsBy = i;
                this.limit = i2;
            }

            public final int getExceedsBy() {
                return this.exceedsBy;
            }

            public final int getLimit() {
                return this.limit;
            }
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError$InvalidCharacter;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$NameError;", "c", "", "<init>", "(C)V", "getC", "()C", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InvalidCharacter extends NameError {
            public static final int $stable = 0;
            private final char c;

            public static /* synthetic */ InvalidCharacter copy$default(InvalidCharacter invalidCharacter, char c, int i, Object obj) {
                if ((i & 1) != 0) {
                    c = invalidCharacter.c;
                }
                return invalidCharacter.copy(c);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final char getC() {
                return this.c;
            }

            public final InvalidCharacter copy(char c) {
                return new InvalidCharacter(c);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InvalidCharacter) && this.c == ((InvalidCharacter) other).c;
            }

            public int hashCode() {
                return Character.hashCode(this.c);
            }

            public String toString() {
                return "InvalidCharacter(c=" + this.c + ")";
            }

            public InvalidCharacter(char c) {
                super(null);
                this.c = c;
            }

            public final char getC() {
                return this.c;
            }
        }
    }

    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;", "", "<init>", "()V", "TooLong", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError$TooLong;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class DescriptionError {
        public static final int $stable = 0;

        public /* synthetic */ DescriptionError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError$TooLong;", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$DescriptionError;", "exceedsBy", "", BoxIterator.FIELD_LIMIT, "<init>", "(II)V", "getExceedsBy", "()I", "getLimit", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TooLong extends DescriptionError {
            public static final int $stable = 0;
            private final int exceedsBy;
            private final int limit;

            public static /* synthetic */ TooLong copy$default(TooLong tooLong, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = tooLong.exceedsBy;
                }
                if ((i3 & 2) != 0) {
                    i2 = tooLong.limit;
                }
                return tooLong.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getExceedsBy() {
                return this.exceedsBy;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getLimit() {
                return this.limit;
            }

            public final TooLong copy(int exceedsBy, int limit) {
                return new TooLong(exceedsBy, limit);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TooLong)) {
                    return false;
                }
                TooLong tooLong = (TooLong) other;
                return this.exceedsBy == tooLong.exceedsBy && this.limit == tooLong.limit;
            }

            public int hashCode() {
                return (Integer.hashCode(this.exceedsBy) * 31) + Integer.hashCode(this.limit);
            }

            public String toString() {
                return "TooLong(exceedsBy=" + this.exceedsBy + ", limit=" + this.limit + ")";
            }

            public TooLong(int i, int i2) {
                super(null);
                this.exceedsBy = i;
                this.limit = i2;
            }

            public final int getExceedsBy() {
                return this.exceedsBy;
            }

            public final int getLimit() {
                return this.limit;
            }
        }

        private DescriptionError() {
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(UpdateItemInfoReducer updateItemInfoReducer, State state, Action action) {
        Effect effect;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Success) {
            State stateCreateInitialState$default = State.Companion.createInitialState$default(State.INSTANCE, ((Action.Success) action).getItemModel(), null, null, state.getHasUnsavedNameChanges() ? Message.NAME_CHANGED : null, false, false, 54, null);
            if (state.getHasUnsavedNameChanges()) {
                effect = Effect.INSTANCE.none();
            } else {
                effect = new Effect(Action.Finish.INSTANCE);
            }
            return new ReducerResult(stateCreateInitialState$default, effect);
        }
        if (action instanceof Action.ItemRefreshed) {
            return new ReducerResult(State.Companion.createInitialState$default(State.INSTANCE, ((Action.ItemRefreshed) action).getItemModel(), state.getHasUnsavedNameChanges() ? state.getUpdatedName() : null, state.getHasUnsavedDescriptionChanges() ? state.getUpdatedDescription() : null, null, state.isRenamePending(), state.isDescriptionUpdatePending(), 8, null), null, 2, null);
        }
        if (action instanceof Action.Failed) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, ((Action.Failed) action).getError(), false, false, null, false, null, 5503, null), null, 2, null);
        }
        if (action instanceof Action.NameUpdated) {
            Action.NameUpdated nameUpdated = (Action.NameUpdated) action;
            NameError nameError = updateItemInfoReducer.getNameError(nameUpdated.getName(), state.getNameLengthLimit());
            return new ReducerResult(State.copy$default(state, null, null, nameUpdated.getName(), null, null, false, null, null, !StringsKt.isBlank(nameUpdated.getName()) && nameError == null, false, null, false, nameError, 3835, null), null, 2, null);
        }
        if (action instanceof Action.PerformUpdate) {
            return updateItemInfoReducer.performUpdate(state);
        }
        if (action instanceof Action.HandledError) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, false, null, false, null, 8063, null), null, 2, null);
        }
        if (action instanceof Action.DescriptionUpdated) {
            return new ReducerResult(State.copy$default(state, null, null, null, ((Action.DescriptionUpdated) action).getDescription(), null, false, null, null, false, false, null, false, null, 8183, null), null, 2, null);
        }
        if (action instanceof Action.SuccessMessageShown) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, null, null, false, false, null, false, null, 7167, null), new Effect(Action.Finish.INSTANCE));
        }
        return new ReducerResult(state, null, 2, null);
    }

    private final ReducerResult<State, Action> performUpdate(State state) {
        if (StringsKt.isBlank(state.getUpdatedName())) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, null, false, false, null, false, new NameError.EmptyName(state.getIsFile()), 4095, null), Effect.INSTANCE.none());
        }
        if (!state.getUpdateEnabled()) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, null, false, state.getHasUnsavedNameChanges(), null, state.getHasUnsavedDescriptionChanges(), null, 5631, null), new Effect((Function1) new AnonymousClass1(state, this, null)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.UpdateItemInfoReducer$performUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateItemInfoReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.UpdateItemInfoReducer$performUpdate$1", f = "UpdateItemInfoReducer.kt", i = {0, 0}, l = {272}, m = "invokeSuspend", n = {"trimmedUpdatedName", "newName"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ UpdateItemInfoReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, UpdateItemInfoReducer updateItemInfoReducer, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = updateItemInfoReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x005a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String string = StringsKt.trim((CharSequence) this.$state.getUpdatedName()).toString();
                if (this.$state.getFileExtension() != null) {
                    str = string + "." + this.$state.getFileExtension();
                    if (str == null) {
                        str = string;
                    }
                } else {
                    str = string;
                }
                IUpdateItemInfoService updateItemInfoService = this.this$0.getEnvironment().getUpdateItemInfoService();
                ItemId itemId = this.$state.getItemId();
                String str2 = this.$state.getHasUnsavedNameChanges() ? str : null;
                String updatedDescription = this.$state.getHasUnsavedDescriptionChanges() ? this.$state.getUpdatedDescription() : null;
                this.L$0 = SpillingKt.nullOutSpilledVariable(string);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 1;
                obj = updateItemInfoService.updateItemInfo(itemId, str2, updatedDescription, this);
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
                return new Action.Success((ItemModel) ((Result.Success) result).getValue());
            }
            if (result instanceof Result.Error) {
                return new Action.Failed((DomainError) ((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final NameError getNameError(String name, int nameLengthLimit) {
        Character chValueOf;
        String str = name;
        if (StringsKt.isBlank(str) || this.environment.getItemNameValidator().isItemNameValidForSD(name)) {
            chValueOf = null;
        } else {
            Character itemIncorrectCharacter = this.environment.getItemNameValidator().getItemIncorrectCharacter(name);
            chValueOf = Character.valueOf(itemIncorrectCharacter != null ? itemIncorrectCharacter.charValue() : StringsKt.last(str));
        }
        if (name.length() > nameLengthLimit) {
            return new NameError.TooLong(name.length() - nameLengthLimit, nameLengthLimit);
        }
        if (chValueOf != null) {
            return new NameError.InvalidCharacter(chValueOf.charValue());
        }
        return null;
    }
}
