package com.microsoft.intune.mam.client.strict;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface StrictGlobalSettings {
    void disable();

    void disable(MAMStrictCheck mAMStrictCheck);

    void disable(EnumSet<MAMStrictCheck> enumSet);

    void enable();

    void setHandler(MAMStrictViolationHandler mAMStrictViolationHandler);
}
