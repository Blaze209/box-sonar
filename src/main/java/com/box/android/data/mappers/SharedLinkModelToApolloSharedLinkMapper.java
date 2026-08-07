package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.fragment.FileFields;
import com.box.android.data.fragment.FolderFields;
import com.box.android.data.fragment.WeblinkFields;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.SharedLinkModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkModelToApolloSharedLinkMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/mappers/SharedLinkModelToApolloSharedLinkMapper;", "", "<init>", "()V", "toScalarFields", "Lcom/box/android/data/mappers/SharedLinkModelToApolloSharedLinkMapper$ScalarFields;", "Lcom/box/android/domain/models/item/SharedLinkModel;", "toGetItemQueryFile", "Lcom/box/android/data/GetItemQuery$SharedLink;", "model", "toGetItemQueryFolder", "Lcom/box/android/data/GetItemQuery$SharedLink1;", "toGetItemQueryWeblink", "Lcom/box/android/data/GetItemQuery$SharedLink2;", "toGetItemWithWatermarkDataQueryFile", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "toGetItemWithWatermarkDataQueryFolder", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "toGetCollectionItemsFile", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "toGetCollectionItemsFolder", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "toGetCollectionItemsWeblink", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "toFileFields", "Lcom/box/android/data/fragment/FileFields$SharedLink;", "toFolderFields", "Lcom/box/android/data/fragment/FolderFields$SharedLink;", "toWeblinkFields", "Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "ScalarFields", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkModelToApolloSharedLinkMapper {
    public static final SharedLinkModelToApolloSharedLinkMapper INSTANCE = new SharedLinkModelToApolloSharedLinkMapper();

    private SharedLinkModelToApolloSharedLinkMapper() {
    }

    /* JADX INFO: compiled from: SharedLinkModelToApolloSharedLinkMapper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/box/android/data/mappers/SharedLinkModelToApolloSharedLinkMapper$ScalarFields;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Z)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Z", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class ScalarFields {
        private final boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ ScalarFields copy$default(ScalarFields scalarFields, String str, String str2, String str3, boolean z, Date date, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = scalarFields.url;
            }
            if ((i & 2) != 0) {
                str2 = scalarFields.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = scalarFields.effectivePermission;
            }
            if ((i & 8) != 0) {
                z = scalarFields.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = scalarFields.unsharedAt;
            }
            if ((i & 32) != 0) {
                z2 = scalarFields.canDownload;
            }
            Date date2 = date;
            boolean z3 = z2;
            return scalarFields.copy(str, str2, str3, z, date2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanDownload() {
            return this.canDownload;
        }

        public final ScalarFields copy(String url, String effectiveAccess, String effectivePermission, boolean isPasswordEnabled, Date unsharedAt, boolean canDownload) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(effectiveAccess, "effectiveAccess");
            Intrinsics.checkNotNullParameter(effectivePermission, "effectivePermission");
            return new ScalarFields(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScalarFields)) {
                return false;
            }
            ScalarFields scalarFields = (ScalarFields) other;
            return Intrinsics.areEqual(this.url, scalarFields.url) && Intrinsics.areEqual(this.effectiveAccess, scalarFields.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, scalarFields.effectivePermission) && this.isPasswordEnabled == scalarFields.isPasswordEnabled && Intrinsics.areEqual(this.unsharedAt, scalarFields.unsharedAt) && this.canDownload == scalarFields.canDownload;
        }

        public int hashCode() {
            int iHashCode = ((((((this.url.hashCode() * 31) + this.effectiveAccess.hashCode()) * 31) + this.effectivePermission.hashCode()) * 31) + Boolean.hashCode(this.isPasswordEnabled)) * 31;
            Date date = this.unsharedAt;
            return ((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + Boolean.hashCode(this.canDownload);
        }

        public String toString() {
            return "ScalarFields(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public ScalarFields(String url, String effectiveAccess, String effectivePermission, boolean z, Date date, boolean z2) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(effectiveAccess, "effectiveAccess");
            Intrinsics.checkNotNullParameter(effectivePermission, "effectivePermission");
            this.url = url;
            this.effectiveAccess = effectiveAccess;
            this.effectivePermission = effectivePermission;
            this.isPasswordEnabled = z;
            this.unsharedAt = date;
            this.canDownload = z2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final boolean getCanDownload() {
            return this.canDownload;
        }
    }

    private final ScalarFields toScalarFields(SharedLinkModel sharedLinkModel) {
        return new ScalarFields(sharedLinkModel.getUrl(), sharedLinkModel.getEffectiveAccess().getValue(), sharedLinkModel.getEffectivePermission().getValue(), sharedLinkModel.isPasswordEnabled(), sharedLinkModel.getUnsharedAt(), sharedLinkModel.getCanDownload());
    }

    public final GetItemQuery.SharedLink toGetItemQueryFile(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetItemQuery.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetItemQuery.SharedLink1 toGetItemQueryFolder(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetItemQuery.SharedLink1(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetItemQuery.SharedLink2 toGetItemQueryWeblink(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetItemQuery.SharedLink2(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetItemWithWatermarkDataQuery.SharedLink toGetItemWithWatermarkDataQueryFile(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetItemWithWatermarkDataQuery.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetItemWithWatermarkDataQuery.SharedLink1 toGetItemWithWatermarkDataQueryFolder(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetItemWithWatermarkDataQuery.SharedLink1(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetCollectionItemsQuery.SharedLink toGetCollectionItemsFile(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetCollectionItemsQuery.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetCollectionItemsQuery.SharedLink1 toGetCollectionItemsFolder(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetCollectionItemsQuery.SharedLink1(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final GetCollectionItemsQuery.SharedLink2 toGetCollectionItemsWeblink(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new GetCollectionItemsQuery.SharedLink2(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final FileFields.SharedLink toFileFields(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new FileFields.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final FolderFields.SharedLink toFolderFields(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new FolderFields.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }

    public final WeblinkFields.SharedLink toWeblinkFields(SharedLinkModel model) {
        if (model == null) {
            return null;
        }
        ScalarFields scalarFields = INSTANCE.toScalarFields(model);
        return new WeblinkFields.SharedLink(scalarFields.getUrl(), scalarFields.getEffectiveAccess(), scalarFields.getEffectivePermission(), Boolean.valueOf(scalarFields.isPasswordEnabled()), scalarFields.getUnsharedAt(), Boolean.valueOf(scalarFields.getCanDownload()));
    }
}
