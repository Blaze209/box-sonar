package com.box.android.domain.models.metadata;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTemplateModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "", "scope", "", "templateKey", "displayName", ViewProps.HIDDEN, "", "fields", "", "Lcom/box/android/domain/models/metadata/MetadataTemplateFieldModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getScope", "()Ljava/lang/String;", "getTemplateKey", "getDisplayName", "getHidden", "()Z", "getFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetadataTemplateModel {
    private final String displayName;
    private final List<MetadataTemplateFieldModel> fields;
    private final boolean hidden;
    private final String scope;
    private final String templateKey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataTemplateModel copy$default(MetadataTemplateModel metadataTemplateModel, String str, String str2, String str3, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadataTemplateModel.scope;
        }
        if ((i & 2) != 0) {
            str2 = metadataTemplateModel.templateKey;
        }
        if ((i & 4) != 0) {
            str3 = metadataTemplateModel.displayName;
        }
        if ((i & 8) != 0) {
            z = metadataTemplateModel.hidden;
        }
        if ((i & 16) != 0) {
            list = metadataTemplateModel.fields;
        }
        List list2 = list;
        String str4 = str3;
        return metadataTemplateModel.copy(str, str2, str4, z, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTemplateKey() {
        return this.templateKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHidden() {
        return this.hidden;
    }

    public final List<MetadataTemplateFieldModel> component5() {
        return this.fields;
    }

    public final MetadataTemplateModel copy(String scope, String templateKey, String displayName, boolean hidden, List<MetadataTemplateFieldModel> fields) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(templateKey, "templateKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(fields, "fields");
        return new MetadataTemplateModel(scope, templateKey, displayName, hidden, fields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataTemplateModel)) {
            return false;
        }
        MetadataTemplateModel metadataTemplateModel = (MetadataTemplateModel) other;
        return Intrinsics.areEqual(this.scope, metadataTemplateModel.scope) && Intrinsics.areEqual(this.templateKey, metadataTemplateModel.templateKey) && Intrinsics.areEqual(this.displayName, metadataTemplateModel.displayName) && this.hidden == metadataTemplateModel.hidden && Intrinsics.areEqual(this.fields, metadataTemplateModel.fields);
    }

    public int hashCode() {
        return (((((((this.scope.hashCode() * 31) + this.templateKey.hashCode()) * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.hidden)) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "MetadataTemplateModel(scope=" + this.scope + ", templateKey=" + this.templateKey + ", displayName=" + this.displayName + ", hidden=" + this.hidden + ", fields=" + this.fields + ")";
    }

    public MetadataTemplateModel(String scope, String templateKey, String displayName, boolean z, List<MetadataTemplateFieldModel> fields) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(templateKey, "templateKey");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.scope = scope;
        this.templateKey = templateKey;
        this.displayName = displayName;
        this.hidden = z;
        this.fields = fields;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getTemplateKey() {
        return this.templateKey;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public /* synthetic */ MetadataTemplateModel(String str, String str2, String str3, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<MetadataTemplateFieldModel> getFields() {
        return this.fields;
    }
}
