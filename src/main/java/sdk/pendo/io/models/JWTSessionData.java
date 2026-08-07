package sdk.pendo.io.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent;
import sdk.pendo.io.s7.l0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B)\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0016J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\b\u0010\u001f\u001a\u00020\u0001H\u0016J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lsdk/pendo/io/models/JWTSessionData;", "Lsdk/pendo/io/models/SessionData;", TypedValues.TransitionType.S_FROM, "(Lsdk/pendo/io/models/JWTSessionData;)V", "jwt", "", "signingKeyName", "isJwtModeOn", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setJwtModeOn", "(Z)V", "getJwt", "()Ljava/lang/String;", "setJwt", "(Ljava/lang/String;)V", "getSigningKeyName", "setSigningKeyName", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "persistData", "", "removeDuplicatesAndTransformKeys", "removeDuplicatesKeepingOriginalKeys", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class JWTSessionData extends SessionData {
    private boolean isJwtModeOn;
    private String jwt;
    private String signingKeyName;

    public JWTSessionData() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ JWTSessionData copy$default(JWTSessionData jWTSessionData, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jWTSessionData.jwt;
        }
        if ((i & 2) != 0) {
            str2 = jWTSessionData.signingKeyName;
        }
        if ((i & 4) != 0) {
            z = jWTSessionData.isJwtModeOn;
        }
        return jWTSessionData.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getJwt() {
        return this.jwt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSigningKeyName() {
        return this.signingKeyName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsJwtModeOn() {
        return this.isJwtModeOn;
    }

    @Override // sdk.pendo.io.models.SessionData
    public JWTSessionData copy() {
        return new JWTSessionData(this.jwt, this.signingKeyName, false, 4, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JWTSessionData)) {
            return false;
        }
        JWTSessionData jWTSessionData = (JWTSessionData) other;
        return Intrinsics.areEqual(this.jwt, jWTSessionData.jwt) && Intrinsics.areEqual(this.signingKeyName, jWTSessionData.signingKeyName) && this.isJwtModeOn == jWTSessionData.isJwtModeOn;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final String getSigningKeyName() {
        return this.signingKeyName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String str = this.jwt;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.signingKeyName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isJwtModeOn;
        ?? r3 = z;
        if (z) {
            r3 = 1;
        }
        return iHashCode2 + r3;
    }

    @Override // sdk.pendo.io.models.SessionData
    /* JADX INFO: renamed from: isJwtModeOn */
    public boolean getIsJwtModeOn() {
        return this.isJwtModeOn;
    }

    @Override // sdk.pendo.io.models.SessionData
    public void persistData() {
        super.persistData();
        l0.a(this.jwt, this.signingKeyName);
    }

    @Override // sdk.pendo.io.models.SessionData
    public SessionData removeDuplicatesAndTransformKeys() {
        JWTSessionData jWTSessionData = new JWTSessionData(this);
        jWTSessionData.setVisitorData(removeDuplicates(getVisitorData(), false));
        jWTSessionData.setAccountData(removeDuplicates(getAccountData(), false));
        return jWTSessionData;
    }

    @Override // sdk.pendo.io.models.SessionData
    public SessionData removeDuplicatesKeepingOriginalKeys() {
        JWTSessionData jWTSessionData = new JWTSessionData(this);
        jWTSessionData.setVisitorData(removeDuplicates(getVisitorData(), true));
        jWTSessionData.setAccountData(removeDuplicates(getAccountData(), true));
        return jWTSessionData;
    }

    public final void setJwt(String str) {
        this.jwt = str;
    }

    @Override // sdk.pendo.io.models.SessionData
    public void setJwtModeOn(boolean z) {
        this.isJwtModeOn = z;
    }

    public final void setSigningKeyName(String str) {
        this.signingKeyName = str;
    }

    public String toString() {
        return "JWTSessionData(jwt=" + this.jwt + ", signingKeyName=" + this.signingKeyName + ", isJwtModeOn=" + this.isJwtModeOn + ")";
    }

    public JWTSessionData(String str) {
        this(str, null, false, 6, null);
    }

    public final JWTSessionData copy(String jwt, String signingKeyName, boolean isJwtModeOn) {
        return new JWTSessionData(jwt, signingKeyName, isJwtModeOn);
    }

    public JWTSessionData(String str, String str2) {
        this(str, str2, false, 4, null);
    }

    public JWTSessionData(String str, String str2, boolean z) {
        super((String) null, (String) null, (Map) null, (Map) null, false, (AnonDataForIdentifyEvent) null, 63, (DefaultConstructorMarker) null);
        this.jwt = str;
        this.signingKeyName = str2;
        this.isJwtModeOn = z;
    }

    public /* synthetic */ JWTSessionData(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JWTSessionData(JWTSessionData from) {
        this(from.jwt, from.signingKeyName, false, 4, null);
        Intrinsics.checkNotNullParameter(from, "from");
        setVisitorId(from.getVisitorId());
        setAccountId(from.getAccountId());
        setVisitorData(from.getVisitorData());
        setAccountData(from.getAccountData());
        setVisitorExternalData(from.getVisitorExternalData());
        setAccountExternalData(from.getAccountExternalData());
    }
}
