package sdk.pendo.io.models;

import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.actions.configurations.GuideTransition;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public class GuideConfigurationModel {

    @c("delayMs")
    private long mDelayMs;

    @c("timeoutMs")
    private long mTimeoutMs;

    @c("transition")
    private i mTransition;

    public long getDelayMs() {
        return this.mDelayMs;
    }

    public long getTimeoutMs() {
        return this.mTimeoutMs;
    }

    public i getTransition() {
        return this.mTransition;
    }

    public final GuideTransition getTransition(String str) {
        i iVar = this.mTransition;
        if (iVar != null) {
            try {
                if (!iVar.h()) {
                    if (this.mTransition.j()) {
                        PendoLogger.d("Transition should be an array, not an object", new Object[0]);
                    }
                    return null;
                }
                f<l> fVarD = this.mTransition.d();
                if (fVarD != null && fVarD.size() > 0) {
                    for (l lVar : fVarD) {
                        i iVarA = lVar.a("type");
                        if (iVarA != null && str.equals(iVarA.g())) {
                            return GuideTransition.getGuideTransition(lVar);
                        }
                    }
                }
                PendoLogger.d("No transitions to return", new Object[0]);
                return null;
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "inOut: " + str);
            }
        }
        return null;
    }
}
