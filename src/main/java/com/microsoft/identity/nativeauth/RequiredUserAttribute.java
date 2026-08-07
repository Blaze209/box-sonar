package com.microsoft.identity.nativeauth;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.fido.FidoChallenge;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequiredUserAttribute.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/nativeauth/RequiredUserAttribute;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "attributeName", "", "type", FidoChallenge.DEFAULT_USER_VERIFICATION_POLICY, "", "options", "Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;)V", "getAttributeName", "()Ljava/lang/String;", "getOptions", "()Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "getRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;)Lcom/microsoft/identity/nativeauth/RequiredUserAttribute;", "equals", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequiredUserAttribute implements ILoggable {
    private final String attributeName;
    private final RequiredUserAttributeOptions options;
    private final Boolean required;
    private final String type;

    public static /* synthetic */ RequiredUserAttribute copy$default(RequiredUserAttribute requiredUserAttribute, String str, String str2, Boolean bool, RequiredUserAttributeOptions requiredUserAttributeOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requiredUserAttribute.attributeName;
        }
        if ((i & 2) != 0) {
            str2 = requiredUserAttribute.type;
        }
        if ((i & 4) != 0) {
            bool = requiredUserAttribute.required;
        }
        if ((i & 8) != 0) {
            requiredUserAttributeOptions = requiredUserAttribute.options;
        }
        return requiredUserAttribute.copy(str, str2, bool, requiredUserAttributeOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttributeName() {
        return this.attributeName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RequiredUserAttributeOptions getOptions() {
        return this.options;
    }

    public final RequiredUserAttribute copy(String attributeName, String type, Boolean required, RequiredUserAttributeOptions options) {
        return new RequiredUserAttribute(attributeName, type, required, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequiredUserAttribute)) {
            return false;
        }
        RequiredUserAttribute requiredUserAttribute = (RequiredUserAttribute) other;
        return Intrinsics.areEqual(this.attributeName, requiredUserAttribute.attributeName) && Intrinsics.areEqual(this.type, requiredUserAttribute.type) && Intrinsics.areEqual(this.required, requiredUserAttribute.required) && Intrinsics.areEqual(this.options, requiredUserAttribute.options);
    }

    public int hashCode() {
        String str = this.attributeName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.required;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        RequiredUserAttributeOptions requiredUserAttributeOptions = this.options;
        return iHashCode3 + (requiredUserAttributeOptions != null ? requiredUserAttributeOptions.hashCode() : 0);
    }

    public RequiredUserAttribute(String str, String str2, Boolean bool, RequiredUserAttributeOptions requiredUserAttributeOptions) {
        this.attributeName = str;
        this.type = str2;
        this.required = bool;
        this.options = requiredUserAttributeOptions;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    public final String getAttributeName() {
        return this.attributeName;
    }

    public final String getType() {
        return this.type;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final RequiredUserAttributeOptions getOptions() {
        return this.options;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "RequiredUserAttribute(attributeName=" + this.attributeName + ", type=" + this.type + ", required=" + this.required + ", options=" + this.options + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return toUnsanitizedString();
    }
}
