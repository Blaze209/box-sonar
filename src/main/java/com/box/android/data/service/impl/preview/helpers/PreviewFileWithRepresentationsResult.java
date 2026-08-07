package com.box.android.data.service.impl.preview.helpers;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.androidsdk.content.models.BoxFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "", "<init>", "()V", "Success", "Error", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult$Error;", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult$Success;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PreviewFileWithRepresentationsResult {
    public /* synthetic */ PreviewFileWithRepresentationsResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PreviewFileWithRepresentationsResult() {
    }

    /* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult$Success;", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxFile.FIELD_REPRESENTATIONS, "", "Lcom/box/android/domain/models/RepresentationModel;", "remoteFetchError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/List;Lcom/box/android/domain/models/DomainError;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getRepresentations", "()Ljava/util/List;", "getRemoteFetchError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends PreviewFileWithRepresentationsResult {
        private final FileModel fileModel;
        private final DomainError remoteFetchError;
        private final List<RepresentationModel> representations;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, FileModel fileModel, List list, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = success.fileModel;
            }
            if ((i & 2) != 0) {
                list = success.representations;
            }
            if ((i & 4) != 0) {
                domainError = success.remoteFetchError;
            }
            return success.copy(fileModel, list, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final List<RepresentationModel> component2() {
            return this.representations;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }

        public final Success copy(FileModel fileModel, List<RepresentationModel> representations, DomainError remoteFetchError) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(representations, "representations");
            return new Success(fileModel, representations, remoteFetchError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.fileModel, success.fileModel) && Intrinsics.areEqual(this.representations, success.representations) && Intrinsics.areEqual(this.remoteFetchError, success.remoteFetchError);
        }

        public int hashCode() {
            int iHashCode = ((this.fileModel.hashCode() * 31) + this.representations.hashCode()) * 31;
            DomainError domainError = this.remoteFetchError;
            return iHashCode + (domainError == null ? 0 : domainError.hashCode());
        }

        public String toString() {
            return "Success(fileModel=" + this.fileModel + ", representations=" + this.representations + ", remoteFetchError=" + this.remoteFetchError + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(FileModel fileModel, List<RepresentationModel> representations, DomainError domainError) {
            super(null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(representations, "representations");
            this.fileModel = fileModel;
            this.representations = representations;
            this.remoteFetchError = domainError;
        }

        public /* synthetic */ Success(FileModel fileModel, List list, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, list, (i & 4) != 0 ? null : domainError);
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final List<RepresentationModel> getRepresentations() {
            return this.representations;
        }

        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }
    }

    /* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult$Error;", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "error", "Lcom/box/android/domain/models/DomainError;", "isProhibitedForPreviewByServer", "", "<init>", "(Lcom/box/android/domain/models/DomainError;Z)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends PreviewFileWithRepresentationsResult {
        private final DomainError error;
        private final boolean isProhibitedForPreviewByServer;

        public static /* synthetic */ Error copy$default(Error error, DomainError domainError, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                domainError = error.error;
            }
            if ((i & 2) != 0) {
                z = error.isProhibitedForPreviewByServer;
            }
            return error.copy(domainError, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsProhibitedForPreviewByServer() {
            return this.isProhibitedForPreviewByServer;
        }

        public final Error copy(DomainError error, boolean isProhibitedForPreviewByServer) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error, isProhibitedForPreviewByServer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.error, error.error) && this.isProhibitedForPreviewByServer == error.isProhibitedForPreviewByServer;
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + Boolean.hashCode(this.isProhibitedForPreviewByServer);
        }

        public String toString() {
            return "Error(error=" + this.error + ", isProhibitedForPreviewByServer=" + this.isProhibitedForPreviewByServer + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(DomainError error, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
            this.isProhibitedForPreviewByServer = z;
        }

        public /* synthetic */ Error(DomainError domainError, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(domainError, (i & 2) != 0 ? false : z);
        }

        public final DomainError getError() {
            return this.error;
        }

        public final boolean isProhibitedForPreviewByServer() {
            return this.isProhibitedForPreviewByServer;
        }
    }
}
