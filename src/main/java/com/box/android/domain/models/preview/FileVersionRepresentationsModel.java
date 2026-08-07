package com.box.android.domain.models.preview;

import android.net.Uri;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationPropertiesModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.RepresentationType;
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileVersionRepresentationsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel;", "Lcom/box/android/domain/models/DomainModel;", BoxCommonConstants.EXTRA_FILE_NAME, "", BoxFile.FIELD_REPRESENTATIONS, "", "Lcom/box/android/domain/models/RepresentationModel;", "fileDownloadUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getRepresentations", "()Ljava/util/List;", "getFileDownloadUrl", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionRepresentationsModel implements DomainModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fileDownloadUrl;
    private final String fileName;
    private final List<RepresentationModel> representations;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileVersionRepresentationsModel copy$default(FileVersionRepresentationsModel fileVersionRepresentationsModel, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionRepresentationsModel.fileName;
        }
        if ((i & 2) != 0) {
            list = fileVersionRepresentationsModel.representations;
        }
        if ((i & 4) != 0) {
            str2 = fileVersionRepresentationsModel.fileDownloadUrl;
        }
        return fileVersionRepresentationsModel.copy(str, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final List<RepresentationModel> component2() {
        return this.representations;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFileDownloadUrl() {
        return this.fileDownloadUrl;
    }

    public final FileVersionRepresentationsModel copy(String fileName, List<RepresentationModel> representations, String fileDownloadUrl) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(representations, "representations");
        return new FileVersionRepresentationsModel(fileName, representations, fileDownloadUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionRepresentationsModel)) {
            return false;
        }
        FileVersionRepresentationsModel fileVersionRepresentationsModel = (FileVersionRepresentationsModel) other;
        return Intrinsics.areEqual(this.fileName, fileVersionRepresentationsModel.fileName) && Intrinsics.areEqual(this.representations, fileVersionRepresentationsModel.representations) && Intrinsics.areEqual(this.fileDownloadUrl, fileVersionRepresentationsModel.fileDownloadUrl);
    }

    public int hashCode() {
        int iHashCode = ((this.fileName.hashCode() * 31) + this.representations.hashCode()) * 31;
        String str = this.fileDownloadUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FileVersionRepresentationsModel(fileName=" + this.fileName + ", representations=" + this.representations + ", fileDownloadUrl=" + this.fileDownloadUrl + ")";
    }

    public FileVersionRepresentationsModel(String fileName, List<RepresentationModel> representations, String str) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(representations, "representations");
        this.fileName = fileName;
        this.representations = representations;
        this.fileDownloadUrl = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final List<RepresentationModel> getRepresentations() {
        return this.representations;
    }

    public final String getFileDownloadUrl() {
        return this.fileDownloadUrl;
    }

    /* JADX INFO: compiled from: FileVersionRepresentationsModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel$Companion;", "", "<init>", "()V", "getOriginalPdfRepresentationModel", "Lcom/box/android/domain/models/RepresentationModel;", "downloadUrl", "", "name", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RepresentationModel getOriginalPdfRepresentationModel(String downloadUrl, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (downloadUrl == null || !StringsKt.endsWith(name, "pdf", true)) {
                return null;
            }
            String string = Uri.parse(downloadUrl).buildUpon().appendQueryParameter(BoxAnalyticsParams.CTA_PAGE_PREVIEW, TelemetryEventStrings.Value.TRUE).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new RepresentationModel(string, "", new RepresentationPropertiesModel(null, false, false), RepresentationType.PDF, new RepresentationStatus(RepresentationStatus.State.SUCCESS, null, 2, null));
        }
    }
}
