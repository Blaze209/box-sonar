package com.microsoft.identity.common.java.nativeauth.providers.responses;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.fido.FidoChallenge;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAttributeApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "name", "", "type", FidoChallenge.DEFAULT_USER_VERIFICATION_POLICY, "", "options", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;)V", "getName", "()Ljava/lang/String;", "getOptions", "()Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;", "getRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;)Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "equals", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserAttributeApiResult implements ILoggable {

    @SerializedName("name")
    private final String name;

    @SerializedName("options")
    private final UserAttributeOptionsApiResult options;

    @SerializedName(FidoChallenge.DEFAULT_USER_VERIFICATION_POLICY)
    private final Boolean required;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ UserAttributeApiResult copy$default(UserAttributeApiResult userAttributeApiResult, String str, String str2, Boolean bool, UserAttributeOptionsApiResult userAttributeOptionsApiResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAttributeApiResult.name;
        }
        if ((i & 2) != 0) {
            str2 = userAttributeApiResult.type;
        }
        if ((i & 4) != 0) {
            bool = userAttributeApiResult.required;
        }
        if ((i & 8) != 0) {
            userAttributeOptionsApiResult = userAttributeApiResult.options;
        }
        return userAttributeApiResult.copy(str, str2, bool, userAttributeOptionsApiResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
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
    public final UserAttributeOptionsApiResult getOptions() {
        return this.options;
    }

    public final UserAttributeApiResult copy(String name, String type, Boolean required, UserAttributeOptionsApiResult options) {
        return new UserAttributeApiResult(name, type, required, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAttributeApiResult)) {
            return false;
        }
        UserAttributeApiResult userAttributeApiResult = (UserAttributeApiResult) other;
        return Intrinsics.areEqual(this.name, userAttributeApiResult.name) && Intrinsics.areEqual(this.type, userAttributeApiResult.type) && Intrinsics.areEqual(this.required, userAttributeApiResult.required) && Intrinsics.areEqual(this.options, userAttributeApiResult.options);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.required;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        UserAttributeOptionsApiResult userAttributeOptionsApiResult = this.options;
        return iHashCode3 + (userAttributeOptionsApiResult != null ? userAttributeOptionsApiResult.hashCode() : 0);
    }

    public UserAttributeApiResult(String str, String str2, Boolean bool, UserAttributeOptionsApiResult userAttributeOptionsApiResult) {
        this.name = str;
        this.type = str2;
        this.required = bool;
        this.options = userAttributeOptionsApiResult;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final UserAttributeOptionsApiResult getOptions() {
        return this.options;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "UserAttributeApiResult(name=" + this.name + ", type=" + this.type + ", required=" + this.required + "options=" + this.options + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return toUnsanitizedString();
    }
}
