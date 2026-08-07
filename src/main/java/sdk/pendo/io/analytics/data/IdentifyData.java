package sdk.pendo.io.analytics.data;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.r5.d;
import sdk.pendo.io.s7.u0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/analytics/data/IdentifyData;", "", "Lorg/json/JSONObject;", "b", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getNewVisitor", "()Ljava/lang/String;", "newVisitor", "oldAnonymousVisitor", "c", "getNewAccount", "newAccount", "d", "getOldAccount", "oldAccount", "", "e", "J", "getTime", "()J", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class IdentifyData {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String newVisitor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String oldAnonymousVisitor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String newAccount;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String oldAccount;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final long time;

    public IdentifyData(String newVisitor, String oldAnonymousVisitor, String newAccount, String oldAccount, long j) {
        Intrinsics.checkNotNullParameter(newVisitor, "newVisitor");
        Intrinsics.checkNotNullParameter(oldAnonymousVisitor, "oldAnonymousVisitor");
        Intrinsics.checkNotNullParameter(newAccount, "newAccount");
        Intrinsics.checkNotNullParameter(oldAccount, "oldAccount");
        this.newVisitor = newVisitor;
        this.oldAnonymousVisitor = oldAnonymousVisitor;
        this.newAccount = newAccount;
        this.oldAccount = oldAccount;
        this.time = j;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getOldAnonymousVisitor() {
        return this.oldAnonymousVisitor;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("event", d.IDENTIFY.b()).put("device_time", this.time).put("props", new JSONObject().put("visitor_id", this.newVisitor).put("old_visitor_id", this.oldAnonymousVisitor).put("account_id", this.newAccount).put("old_account_id", this.oldAccount)).put("sdkVersion", u0.a());
        Intrinsics.checkNotNull(jSONObjectPut);
        return jSONObjectPut;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentifyData)) {
            return false;
        }
        IdentifyData identifyData = (IdentifyData) other;
        return Intrinsics.areEqual(this.newVisitor, identifyData.newVisitor) && Intrinsics.areEqual(this.oldAnonymousVisitor, identifyData.oldAnonymousVisitor) && Intrinsics.areEqual(this.newAccount, identifyData.newAccount) && Intrinsics.areEqual(this.oldAccount, identifyData.oldAccount) && this.time == identifyData.time;
    }

    public int hashCode() {
        return (((((((this.newVisitor.hashCode() * 31) + this.oldAnonymousVisitor.hashCode()) * 31) + this.newAccount.hashCode()) * 31) + this.oldAccount.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "IdentifyData(newVisitor=" + this.newVisitor + ", oldAnonymousVisitor=" + this.oldAnonymousVisitor + ", newAccount=" + this.newAccount + ", oldAccount=" + this.oldAccount + ", time=" + this.time + ")";
    }

    public /* synthetic */ IdentifyData(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? System.currentTimeMillis() : j);
    }
}
