package com.microsoft.intune.mam.client.app.offline;

import android.content.Intent;
import android.net.Uri;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.policy.AppPolicy;
import com.microsoft.intune.mam.policy.NotificationRestriction;
import com.microsoft.intune.mam.policy.OpenLocation;
import com.microsoft.intune.mam.policy.SaveLocation;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineAppPolicy implements AppPolicy {
    private final IdentityParamConverter mIdentityParamConverter;

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean areIntentActivitiesAllowed(Intent intent) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean diagnosticHasOpenRestriction() {
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean diagnosticHasSaveRestriction() {
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean diagnosticIsFileEncryptionInUse() {
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsContactSyncAllowed() {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsManagedBrowserRequired() {
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsOpenFromContentUriAllowed(Uri uri) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsOpenFromLocalStorageAllowed(File file) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsOpenFromLocationAllowedForOID(OpenLocation openLocation, String str) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsPinRequired() {
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsSaveToLocationAllowed(Uri uri) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsSaveToLocationAllowedForOID(SaveLocation saveLocation, String str) {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    @Deprecated
    public boolean getIsSaveToPersonalAllowed() {
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public boolean getIsScreenCaptureAllowed() {
        return true;
    }

    public OfflineAppPolicy(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    @Deprecated
    public boolean getIsSaveToLocationAllowed(SaveLocation saveLocation, String str) {
        this.mIdentityParamConverter.emitUpnUsageWarnings(str);
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    @Deprecated
    public boolean getIsOpenFromLocationAllowed(OpenLocation openLocation, String str) {
        this.mIdentityParamConverter.emitUpnUsageWarnings(str);
        return true;
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public String toString() {
        return "[No Policy Set]";
    }

    @Override // com.microsoft.intune.mam.policy.AppPolicy
    public NotificationRestriction getNotificationRestriction() {
        return NotificationRestriction.UNRESTRICTED;
    }
}
