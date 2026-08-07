package com.box.android.data.datasource.errors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/datasource/errors/CreateFolderRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "ItemNameTooLong", "InvalidName", "OperationBlockedTemporary", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$InvalidName;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$ItemNameTooLong;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$OperationBlockedTemporary;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CreateFolderRemoteError extends RemoteError {
    public /* synthetic */ CreateFolderRemoteError(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$ItemNameTooLong;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemNameTooLong extends CreateFolderRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemNameTooLong() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ItemNameTooLong copy$default(ItemNameTooLong itemNameTooLong, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemNameTooLong.message;
            }
            return itemNameTooLong.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ItemNameTooLong copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ItemNameTooLong(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemNameTooLong) && Intrinsics.areEqual(this.message, ((ItemNameTooLong) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ItemNameTooLong(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemNameTooLong(String message) {
            super(400, message, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ ItemNameTooLong(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    private CreateFolderRemoteError(int i, String str) {
        super(i, str, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$InvalidName;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InvalidName extends CreateFolderRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public InvalidName() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InvalidName copy$default(InvalidName invalidName, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidName.message;
            }
            return invalidName.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final InvalidName copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new InvalidName(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidName) && Intrinsics.areEqual(this.message, ((InvalidName) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "InvalidName(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidName(String message) {
            super(400, message, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ InvalidName(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/CreateFolderRemoteError$OperationBlockedTemporary;", "Lcom/box/android/data/datasource/errors/CreateFolderRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OperationBlockedTemporary extends CreateFolderRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public OperationBlockedTemporary() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ OperationBlockedTemporary copy$default(OperationBlockedTemporary operationBlockedTemporary, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = operationBlockedTemporary.message;
            }
            return operationBlockedTemporary.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final OperationBlockedTemporary copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new OperationBlockedTemporary(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OperationBlockedTemporary) && Intrinsics.areEqual(this.message, ((OperationBlockedTemporary) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "OperationBlockedTemporary(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OperationBlockedTemporary(String message) {
            super(409, message, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ OperationBlockedTemporary(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }
}
