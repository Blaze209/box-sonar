package com.microsoft.intune.mam.client.strict;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface StrictThreadSettings {
    void disable();

    void disable(MAMStrictCheck mAMStrictCheck);

    void disable(EnumSet<MAMStrictCheck> enumSet);

    StrictScopedDisable disableScoped();

    StrictScopedDisable disableScoped(MAMStrictCheck mAMStrictCheck);

    StrictScopedDisable disableScoped(EnumSet<MAMStrictCheck> enumSet);
}
