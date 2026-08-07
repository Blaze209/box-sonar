package com.microsoft.intune.mam.policy;

import android.content.Intent;
import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface AppPolicy {
    boolean areIntentActivitiesAllowed(Intent intent);

    boolean diagnosticHasOpenRestriction();

    boolean diagnosticHasSaveRestriction();

    boolean diagnosticIsFileEncryptionInUse();

    boolean getIsContactSyncAllowed();

    boolean getIsManagedBrowserRequired();

    boolean getIsOpenFromContentUriAllowed(Uri uri);

    boolean getIsOpenFromLocalStorageAllowed(File file);

    @Deprecated
    boolean getIsOpenFromLocationAllowed(OpenLocation openLocation, String str);

    boolean getIsOpenFromLocationAllowedForOID(OpenLocation openLocation, String str);

    boolean getIsPinRequired();

    boolean getIsSaveToLocationAllowed(Uri uri);

    @Deprecated
    boolean getIsSaveToLocationAllowed(SaveLocation saveLocation, String str);

    boolean getIsSaveToLocationAllowedForOID(SaveLocation saveLocation, String str);

    @Deprecated
    boolean getIsSaveToPersonalAllowed();

    boolean getIsScreenCaptureAllowed();

    NotificationRestriction getNotificationRestriction();

    String toString();
}
