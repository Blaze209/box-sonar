package sdk.pendo.io.network.responses;

import java.util.Date;
import java.util.List;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class KillSwitchModel {
    public static final String KILL_SWITCH_EXPIRATION = "expiration";
    private static final Long KILL_SWITCH_NEVER_EXPIRES = null;
    public static final String KILL_SWITCH_VERSIONS = "versions";

    @c(KILL_SWITCH_VERSIONS)
    private List<String> mAffectedVersions;
    private Date mExpirationDate;

    @c(KILL_SWITCH_EXPIRATION)
    private Long mExpirationInMilliseconds;

    private Date getExpirationDate() {
        if (this.mExpirationDate == null) {
            this.mExpirationDate = new Date(this.mExpirationInMilliseconds.longValue());
        }
        return this.mExpirationDate;
    }

    public List<String> getAffectedVersions() {
        return this.mAffectedVersions;
    }

    public Long getExpiration() {
        return this.mExpirationInMilliseconds;
    }

    public boolean isCurrentSDKVersionAffected(String str) {
        List<String> list = this.mAffectedVersions;
        return list != null && list.contains(str);
    }

    public synchronized boolean isExpired() {
        if (this.mExpirationInMilliseconds == KILL_SWITCH_NEVER_EXPIRES) {
            return false;
        }
        Date date = new Date();
        date.getTime();
        return date.after(getExpirationDate());
    }

    public void setAffectedVersions(List<String> list) {
        this.mAffectedVersions = list;
    }

    public void setExpiration(Long l) {
        this.mExpirationInMilliseconds = l;
    }
}
