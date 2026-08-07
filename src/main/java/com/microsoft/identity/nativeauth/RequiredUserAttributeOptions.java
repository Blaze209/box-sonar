package com.microsoft.identity.nativeauth;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequiredUserAttributeOptions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "regex", "", "(Ljava/lang/String;)V", "getRegex", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequiredUserAttributeOptions implements ILoggable {
    private final String regex;

    public static /* synthetic */ RequiredUserAttributeOptions copy$default(RequiredUserAttributeOptions requiredUserAttributeOptions, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requiredUserAttributeOptions.regex;
        }
        return requiredUserAttributeOptions.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRegex() {
        return this.regex;
    }

    public final RequiredUserAttributeOptions copy(String regex) {
        return new RequiredUserAttributeOptions(regex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequiredUserAttributeOptions) && Intrinsics.areEqual(this.regex, ((RequiredUserAttributeOptions) other).regex);
    }

    public int hashCode() {
        String str = this.regex;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public RequiredUserAttributeOptions(String str) {
        this.regex = str;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    public final String getRegex() {
        return this.regex;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "RequiredUserAttributeOptions(regex=" + this.regex + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return toUnsanitizedString();
    }
}
