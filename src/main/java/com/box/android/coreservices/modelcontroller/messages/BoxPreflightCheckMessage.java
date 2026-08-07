package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.androidsdk.content.BoxException;

/* JADX INFO: loaded from: classes9.dex */
public class BoxPreflightCheckMessage extends BoxMessage<Boolean> {
    public static final String ACTION_PREFLIGHT_CHECK = "com.box.android.preflight.check";

    public BoxPreflightCheckMessage() {
        setAction(ACTION_PREFLIGHT_CHECK);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(Boolean bool) {
        putExtra("box_message_payload", bool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public Boolean getPayload() {
        return Boolean.valueOf(getBooleanExtra("box_message_payload", false));
    }

    public CoreServiceUtils.ErrorType getErrorType() {
        if (getException() instanceof BoxException) {
            return CoreServiceUtils.ErrorType.INSTANCE.getErrorType((BoxException) getException());
        }
        return CoreServiceUtils.ErrorType.OTHER;
    }
}
