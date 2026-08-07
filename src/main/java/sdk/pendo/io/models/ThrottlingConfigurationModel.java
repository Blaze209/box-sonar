package sdk.pendo.io.models;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public class ThrottlingConfigurationModel {

    @c("count")
    private int mCount;

    @c("enabled")
    private boolean mEnabled;

    @c(MicrosoftAuthorizationResponse.INTERVAL)
    private int mInterval;

    @c("unit")
    private String mUnit;

    public int getInterval() {
        return this.mInterval;
    }

    public String getUnit() {
        return this.mUnit;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }
}
