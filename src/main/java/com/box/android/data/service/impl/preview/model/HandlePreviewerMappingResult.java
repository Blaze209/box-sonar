package com.box.android.data.service.impl.preview.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.preview.PreviewData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HandlePreviewerMappingResult.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult;", "", "<init>", "()V", "Success", "Error", "CachedPreview", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$CachedPreview;", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$Error;", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$Success;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class HandlePreviewerMappingResult {
    public /* synthetic */ HandlePreviewerMappingResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HandlePreviewerMappingResult() {
    }

    /* JADX INFO: compiled from: HandlePreviewerMappingResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$Success;", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends HandlePreviewerMappingResult {
        public static final Success INSTANCE = new Success();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 563234366;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HandlePreviewerMappingResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$Error;", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends HandlePreviewerMappingResult {
        private final DomainError error;

        public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                domainError = error.error;
            }
            return error.copy(domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final Error copy(DomainError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(DomainError error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final DomainError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: HandlePreviewerMappingResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult$CachedPreview;", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult;", "previewData", "Lcom/box/android/domain/models/preview/PreviewData;", "<init>", "(Lcom/box/android/domain/models/preview/PreviewData;)V", "getPreviewData", "()Lcom/box/android/domain/models/preview/PreviewData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CachedPreview extends HandlePreviewerMappingResult {
        private final PreviewData previewData;

        public static /* synthetic */ CachedPreview copy$default(CachedPreview cachedPreview, PreviewData previewData, int i, Object obj) {
            if ((i & 1) != 0) {
                previewData = cachedPreview.previewData;
            }
            return cachedPreview.copy(previewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PreviewData getPreviewData() {
            return this.previewData;
        }

        public final CachedPreview copy(PreviewData previewData) {
            Intrinsics.checkNotNullParameter(previewData, "previewData");
            return new CachedPreview(previewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CachedPreview) && Intrinsics.areEqual(this.previewData, ((CachedPreview) other).previewData);
        }

        public int hashCode() {
            return this.previewData.hashCode();
        }

        public String toString() {
            return "CachedPreview(previewData=" + this.previewData + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CachedPreview(PreviewData previewData) {
            super(null);
            Intrinsics.checkNotNullParameter(previewData, "previewData");
            this.previewData = previewData;
        }

        public final PreviewData getPreviewData() {
            return this.previewData;
        }
    }
}
