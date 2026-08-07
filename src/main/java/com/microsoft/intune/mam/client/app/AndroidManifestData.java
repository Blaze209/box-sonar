package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.Service;
import android.app.job.JobService;
import com.microsoft.intune.mam.Version;
import com.microsoft.intune.mam.client.InterfaceVersion;
import com.microsoft.intune.mam.client.MAMSDKCapability;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidManifestData {
    Class<? extends JobService> getBackgroundJobService();

    Class<? extends Service> getBackgroundService();

    EnumSet<MAMSDKCapability> getCapabilities();

    Class<? extends Activity> getComplianceBlockActivity();

    InterfaceVersion getInterfaceVersion();

    int getIntuneMAMManifestResourceId();

    Class<? extends Activity> getResolverActivity();

    Version getSDKVersion();

    Class<? extends Activity> getStartupActivity();
}
