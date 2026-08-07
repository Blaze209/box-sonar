package com.microsoft.intune.mam.client.strict;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineStrictThreadSettings implements StrictThreadSettings {
    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public void disable() {
    }

    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public void disable(MAMStrictCheck mAMStrictCheck) {
    }

    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public void disable(EnumSet<MAMStrictCheck> enumSet) {
    }

    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public StrictScopedDisable disableScoped() {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public StrictScopedDisable disableScoped(MAMStrictCheck mAMStrictCheck) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.strict.StrictThreadSettings
    public StrictScopedDisable disableScoped(EnumSet<MAMStrictCheck> enumSet) {
        return null;
    }
}
