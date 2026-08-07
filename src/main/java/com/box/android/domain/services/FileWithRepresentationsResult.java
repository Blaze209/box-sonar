package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.androidsdk.content.models.BoxFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/services/FileWithRepresentationsResult;", "", "<init>", "()V", "Success", "Cached", "Error", "Lcom/box/android/domain/services/FileWithRepresentationsResult$Cached;", "Lcom/box/android/domain/services/FileWithRepresentationsResult$Error;", "Lcom/box/android/domain/services/FileWithRepresentationsResult$Success;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileWithRepresentationsResult {
    public /* synthetic */ FileWithRepresentationsResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FileWithRepresentationsResult() {
    }

    /* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/services/FileWithRepresentationsResult$Success;", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxFile.FIELD_REPRESENTATIONS, "", "Lcom/box/android/domain/models/RepresentationModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/List;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getRepresentations", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends FileWithRepresentationsResult {
        private final FileModel fileModel;
        private final List<RepresentationModel> representations;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, FileModel fileModel, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = success.fileModel;
            }
            if ((i & 2) != 0) {
                list = success.representations;
            }
            return success.copy(fileModel, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final List<RepresentationModel> component2() {
            return this.representations;
        }

        public final Success copy(FileModel fileModel, List<RepresentationModel> representations) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(representations, "representations");
            return new Success(fileModel, representations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.fileModel, success.fileModel) && Intrinsics.areEqual(this.representations, success.representations);
        }

        public int hashCode() {
            return (this.fileModel.hashCode() * 31) + this.representations.hashCode();
        }

        public String toString() {
            return "Success(fileModel=" + this.fileModel + ", representations=" + this.representations + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(FileModel fileModel, List<RepresentationModel> representations) {
            super(null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(representations, "representations");
            this.fileModel = fileModel;
            this.representations = representations;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final List<RepresentationModel> getRepresentations() {
            return this.representations;
        }
    }

    /* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/services/FileWithRepresentationsResult$Cached;", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "cachedFileModel", "Lcom/box/android/domain/models/item/FileModel;", "cachedRepresentations", "", "Lcom/box/android/domain/models/RepresentationModel;", "remoteFetchError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/List;Lcom/box/android/domain/models/DomainError;)V", "getCachedFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getCachedRepresentations", "()Ljava/util/List;", "getRemoteFetchError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Cached extends FileWithRepresentationsResult {
        private final FileModel cachedFileModel;
        private final List<RepresentationModel> cachedRepresentations;
        private final DomainError remoteFetchError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Cached copy$default(Cached cached, FileModel fileModel, List list, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = cached.cachedFileModel;
            }
            if ((i & 2) != 0) {
                list = cached.cachedRepresentations;
            }
            if ((i & 4) != 0) {
                domainError = cached.remoteFetchError;
            }
            return cached.copy(fileModel, list, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getCachedFileModel() {
            return this.cachedFileModel;
        }

        public final List<RepresentationModel> component2() {
            return this.cachedRepresentations;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }

        public final Cached copy(FileModel cachedFileModel, List<RepresentationModel> cachedRepresentations, DomainError remoteFetchError) {
            Intrinsics.checkNotNullParameter(cachedFileModel, "cachedFileModel");
            Intrinsics.checkNotNullParameter(cachedRepresentations, "cachedRepresentations");
            Intrinsics.checkNotNullParameter(remoteFetchError, "remoteFetchError");
            return new Cached(cachedFileModel, cachedRepresentations, remoteFetchError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cached)) {
                return false;
            }
            Cached cached = (Cached) other;
            return Intrinsics.areEqual(this.cachedFileModel, cached.cachedFileModel) && Intrinsics.areEqual(this.cachedRepresentations, cached.cachedRepresentations) && Intrinsics.areEqual(this.remoteFetchError, cached.remoteFetchError);
        }

        public int hashCode() {
            return (((this.cachedFileModel.hashCode() * 31) + this.cachedRepresentations.hashCode()) * 31) + this.remoteFetchError.hashCode();
        }

        public String toString() {
            return "Cached(cachedFileModel=" + this.cachedFileModel + ", cachedRepresentations=" + this.cachedRepresentations + ", remoteFetchError=" + this.remoteFetchError + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cached(FileModel cachedFileModel, List<RepresentationModel> cachedRepresentations, DomainError remoteFetchError) {
            super(null);
            Intrinsics.checkNotNullParameter(cachedFileModel, "cachedFileModel");
            Intrinsics.checkNotNullParameter(cachedRepresentations, "cachedRepresentations");
            Intrinsics.checkNotNullParameter(remoteFetchError, "remoteFetchError");
            this.cachedFileModel = cachedFileModel;
            this.cachedRepresentations = cachedRepresentations;
            this.remoteFetchError = remoteFetchError;
        }

        public final FileModel getCachedFileModel() {
            return this.cachedFileModel;
        }

        public final List<RepresentationModel> getCachedRepresentations() {
            return this.cachedRepresentations;
        }

        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }
    }

    /* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/services/FileWithRepresentationsResult$Error;", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "remoteFetchError", "Lcom/box/android/domain/models/DomainError;", "cacheFetchError", "<init>", "(Lcom/box/android/domain/models/DomainError;Lcom/box/android/domain/models/DomainError;)V", "getRemoteFetchError", "()Lcom/box/android/domain/models/DomainError;", "getCacheFetchError", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends FileWithRepresentationsResult {
        private final DomainError cacheFetchError;
        private final DomainError remoteFetchError;

        public static /* synthetic */ Error copy$default(Error error, DomainError domainError, DomainError domainError2, int i, Object obj) {
            if ((i & 1) != 0) {
                domainError = error.remoteFetchError;
            }
            if ((i & 2) != 0) {
                domainError2 = error.cacheFetchError;
            }
            return error.copy(domainError, domainError2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DomainError getCacheFetchError() {
            return this.cacheFetchError;
        }

        public final Error copy(DomainError remoteFetchError, DomainError cacheFetchError) {
            Intrinsics.checkNotNullParameter(remoteFetchError, "remoteFetchError");
            Intrinsics.checkNotNullParameter(cacheFetchError, "cacheFetchError");
            return new Error(remoteFetchError, cacheFetchError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.remoteFetchError, error.remoteFetchError) && Intrinsics.areEqual(this.cacheFetchError, error.cacheFetchError);
        }

        public int hashCode() {
            return (this.remoteFetchError.hashCode() * 31) + this.cacheFetchError.hashCode();
        }

        public String toString() {
            return "Error(remoteFetchError=" + this.remoteFetchError + ", cacheFetchError=" + this.cacheFetchError + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(DomainError remoteFetchError, DomainError cacheFetchError) {
            super(null);
            Intrinsics.checkNotNullParameter(remoteFetchError, "remoteFetchError");
            Intrinsics.checkNotNullParameter(cacheFetchError, "cacheFetchError");
            this.remoteFetchError = remoteFetchError;
            this.cacheFetchError = cacheFetchError;
        }

        public final DomainError getCacheFetchError() {
            return this.cacheFetchError;
        }

        public final DomainError getRemoteFetchError() {
            return this.remoteFetchError;
        }
    }
}
