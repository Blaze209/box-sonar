package sdk.pendo.io.models;

import com.box.androidsdk.content.models.BoxIterator;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public class GuidesConfigurationModel {

    @c("lastStepSeen")
    private LastStepSeenConfigurationModel mLastStepSeenConfigurationModel;

    @c(BoxIterator.FIELD_ORDER)
    private f mOrder;

    @c("throttling")
    private ThrottlingConfigurationModel mThrottlingConfigurationModel;

    public LastStepSeenConfigurationModel getLastStepSeenConfigurationModel() {
        return this.mLastStepSeenConfigurationModel;
    }

    public ThrottlingConfigurationModel getThrottlingConfigurationModel() {
        return this.mThrottlingConfigurationModel;
    }
}
