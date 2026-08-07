package com.box.android.preview.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.FileUploadDomainError;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainErrorPreviewErrorScreenUIModelMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/box/android/preview/preview/DomainErrorPreviewErrorScreenUIModelMapper;", "", "<init>", "()V", "toErrorScreenUIModel", "Lcom/box/android/preview/preview/DomainErrorPreviewErrorScreenUIModelMapper$ErrorScreenUIModel;", "Lcom/box/android/domain/models/DomainError;", "ErrorScreenUIModel", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DomainErrorPreviewErrorScreenUIModelMapper {
    public static final int $stable = 0;
    public static final DomainErrorPreviewErrorScreenUIModelMapper INSTANCE = new DomainErrorPreviewErrorScreenUIModelMapper();

    /* JADX INFO: compiled from: DomainErrorPreviewErrorScreenUIModelMapper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J8\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/preview/DomainErrorPreviewErrorScreenUIModelMapper$ErrorScreenUIModel;", "", "drawableResId", "", "titleResId", "subTitleResId", "retryable", "", "<init>", "(IILjava/lang/Integer;Z)V", "getDrawableResId", "()I", "getTitleResId", "getSubTitleResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetryable", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(IILjava/lang/Integer;Z)Lcom/box/android/preview/preview/DomainErrorPreviewErrorScreenUIModelMapper$ErrorScreenUIModel;", "equals", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ErrorScreenUIModel {
        public static final int $stable = 0;
        private final int drawableResId;
        private final boolean retryable;
        private final Integer subTitleResId;
        private final int titleResId;

        public ErrorScreenUIModel() {
            this(0, 0, null, false, 15, null);
        }

        public static /* synthetic */ ErrorScreenUIModel copy$default(ErrorScreenUIModel errorScreenUIModel, int i, int i2, Integer num, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = errorScreenUIModel.drawableResId;
            }
            if ((i3 & 2) != 0) {
                i2 = errorScreenUIModel.titleResId;
            }
            if ((i3 & 4) != 0) {
                num = errorScreenUIModel.subTitleResId;
            }
            if ((i3 & 8) != 0) {
                z = errorScreenUIModel.retryable;
            }
            return errorScreenUIModel.copy(i, i2, num, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDrawableResId() {
            return this.drawableResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSubTitleResId() {
            return this.subTitleResId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getRetryable() {
            return this.retryable;
        }

        public final ErrorScreenUIModel copy(int drawableResId, int titleResId, Integer subTitleResId, boolean retryable) {
            return new ErrorScreenUIModel(drawableResId, titleResId, subTitleResId, retryable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorScreenUIModel)) {
                return false;
            }
            ErrorScreenUIModel errorScreenUIModel = (ErrorScreenUIModel) other;
            return this.drawableResId == errorScreenUIModel.drawableResId && this.titleResId == errorScreenUIModel.titleResId && Intrinsics.areEqual(this.subTitleResId, errorScreenUIModel.subTitleResId) && this.retryable == errorScreenUIModel.retryable;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.drawableResId) * 31) + Integer.hashCode(this.titleResId)) * 31;
            Integer num = this.subTitleResId;
            return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.retryable);
        }

        public String toString() {
            return "ErrorScreenUIModel(drawableResId=" + this.drawableResId + ", titleResId=" + this.titleResId + ", subTitleResId=" + this.subTitleResId + ", retryable=" + this.retryable + ")";
        }

        public ErrorScreenUIModel(int i, int i2, Integer num, boolean z) {
            this.drawableResId = i;
            this.titleResId = i2;
            this.subTitleResId = num;
            this.retryable = z;
        }

        public /* synthetic */ ErrorScreenUIModel(int i, int i2, Integer num, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? R.drawable.ic_document140 : i, (i3 & 2) != 0 ? R.string.preview_unavailable : i2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? false : z);
        }

        public final int getDrawableResId() {
            return this.drawableResId;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public final Integer getSubTitleResId() {
            return this.subTitleResId;
        }

        public final boolean getRetryable() {
            return this.retryable;
        }
    }

    private DomainErrorPreviewErrorScreenUIModelMapper() {
    }

    public final ErrorScreenUIModel toErrorScreenUIModel(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        if (DomainErrorKt.isNetworkConnectionError(domainError)) {
            return new ErrorScreenUIModel(R.drawable.ic_unplugged140, R.string.no_internet_connection, Integer.valueOf(R.string.check_internet_connection_retry), true);
        }
        if (domainError instanceof FilePreviewDomainError.PasswordProtectedError) {
            return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.preview_unavailable, Integer.valueOf(R.string.password_protected_file_previewed_error), false, 8, null);
        }
        if ((domainError instanceof FileUploadDomainError.AccessDeniedError) || (domainError instanceof FilePreviewDomainError.NoPreviewPermissionsError)) {
            return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.preview_unavailable, Integer.valueOf(R.string.no_permissions_file_previewed_error), false, 8, null);
        }
        if (domainError instanceof FilePreviewDomainError.NutrientError) {
            return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.preview_unavailable, Integer.valueOf(R.string.nutrient_error), false, 8, null);
        }
        if (DomainErrorKt.isItemNotFoundError(domainError)) {
            return new ErrorScreenUIModel(R.drawable.ic_missing140, R.string.box_sharesdk_item_unavailable, null, false, 12, null);
        }
        if (domainError instanceof FilePreviewDomainError.NotSupportedTypeError) {
            return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.preview_unavailable, Integer.valueOf(R.string.not_supported_file_type_error), false, 8, null);
        }
        if (domainError instanceof FilePreviewDomainError.CannotOpenEmptyFile) {
            return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.cannot_open_empty_file_title, Integer.valueOf(R.string.cannot_open_empty_file_subtitle), false, 8, null);
        }
        return new ErrorScreenUIModel(R.drawable.ic_document140, R.string.preview_unavailable, Integer.valueOf(R.string.file_loading_failed_retry), true);
    }
}
