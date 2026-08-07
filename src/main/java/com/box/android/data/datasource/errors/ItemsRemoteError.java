package com.box.android.data.datasource.errors;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "<init>", "(I)V", "ItemNotFound", "NameConflict", "ForbiddenByShieldPolicy", "SharedLinkPasswordValidationError", "Lcom/box/android/data/datasource/errors/ItemsRemoteError$ForbiddenByShieldPolicy;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError$ItemNotFound;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError$NameConflict;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError$SharedLinkPasswordValidationError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemsRemoteError extends RemoteError {
    public /* synthetic */ ItemsRemoteError(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/ItemsRemoteError$ItemNotFound;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemNotFound extends ItemsRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemNotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ItemNotFound copy$default(ItemNotFound itemNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemNotFound.message;
            }
            return itemNotFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ItemNotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ItemNotFound(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemNotFound) && Intrinsics.areEqual(this.message, ((ItemNotFound) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ItemNotFound(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemNotFound(String message) {
            super(404, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ ItemNotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    private ItemsRemoteError(int i) {
        super(i, null, 2, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/datasource/errors/ItemsRemoteError$NameConflict;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "itemDTOs", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "<init>", "(Ljava/util/List;)V", "getItemDTOs", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NameConflict extends ItemsRemoteError {
        private final List<IItemDTO> itemDTOs;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NameConflict copy$default(NameConflict nameConflict, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = nameConflict.itemDTOs;
            }
            return nameConflict.copy(list);
        }

        public final List<IItemDTO> component1() {
            return this.itemDTOs;
        }

        public final NameConflict copy(List<? extends IItemDTO> itemDTOs) {
            Intrinsics.checkNotNullParameter(itemDTOs, "itemDTOs");
            return new NameConflict(itemDTOs);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NameConflict) && Intrinsics.areEqual(this.itemDTOs, ((NameConflict) other).itemDTOs);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.itemDTOs.hashCode();
        }

        public String toString() {
            return "NameConflict(itemDTOs=" + this.itemDTOs + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NameConflict(List<? extends IItemDTO> itemDTOs) {
            super(409, null);
            Intrinsics.checkNotNullParameter(itemDTOs, "itemDTOs");
            this.itemDTOs = itemDTOs;
        }

        public final List<IItemDTO> getItemDTOs() {
            return this.itemDTOs;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/ItemsRemoteError$ForbiddenByShieldPolicy;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ForbiddenByShieldPolicy extends ItemsRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public ForbiddenByShieldPolicy() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ForbiddenByShieldPolicy copy$default(ForbiddenByShieldPolicy forbiddenByShieldPolicy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = forbiddenByShieldPolicy.message;
            }
            return forbiddenByShieldPolicy.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ForbiddenByShieldPolicy copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ForbiddenByShieldPolicy(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ForbiddenByShieldPolicy) && Intrinsics.areEqual(this.message, ((ForbiddenByShieldPolicy) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ForbiddenByShieldPolicy(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForbiddenByShieldPolicy(String message) {
            super(403, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ ForbiddenByShieldPolicy(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/datasource/errors/ItemsRemoteError$SharedLinkPasswordValidationError;", "Lcom/box/android/data/datasource/errors/ItemsRemoteError;", "message", "", BoxAnalyticsParams.CATEGORY_ERRORS, "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLinkPasswordValidationError extends ItemsRemoteError {
        private final List<String> errors;
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SharedLinkPasswordValidationError copy$default(SharedLinkPasswordValidationError sharedLinkPasswordValidationError, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLinkPasswordValidationError.message;
            }
            if ((i & 2) != 0) {
                list = sharedLinkPasswordValidationError.errors;
            }
            return sharedLinkPasswordValidationError.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final List<String> component2() {
            return this.errors;
        }

        public final SharedLinkPasswordValidationError copy(String message, List<String> errors) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new SharedLinkPasswordValidationError(message, errors);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLinkPasswordValidationError)) {
                return false;
            }
            SharedLinkPasswordValidationError sharedLinkPasswordValidationError = (SharedLinkPasswordValidationError) other;
            return Intrinsics.areEqual(this.message, sharedLinkPasswordValidationError.message) && Intrinsics.areEqual(this.errors, sharedLinkPasswordValidationError.errors);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return (this.message.hashCode() * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "SharedLinkPasswordValidationError(message=" + this.message + ", errors=" + this.errors + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SharedLinkPasswordValidationError(String message, List<String> errors) {
            super(400, null);
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.message = message;
            this.errors = errors;
        }

        public /* synthetic */ SharedLinkPasswordValidationError(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, list);
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }
}
