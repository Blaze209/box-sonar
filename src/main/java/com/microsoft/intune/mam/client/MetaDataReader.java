package com.microsoft.intune.mam.client;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;

/* JADX INFO: loaded from: classes3.dex */
public class MetaDataReader {
    private static final int ARBITRARY_SENTINEL = -2;
    public static final String DATA_EXTRACTION_RULES_TAG_NAME = "com.microsoft.intune.mam.DataExtractionRules";
    public static final String FULL_BACKUP_CONTENT_TAG_NAME = "com.microsoft.intune.mam.FullBackupContent";
    public static final int FULL_BACKUP_DESIRED = 0;
    public static final int REGULAR_BACKUP_DESIRED = -1;
    private AgentType mAgent;
    private final Boolean mAllowIsolatedProcesses;
    private boolean mConfigOnlyMode;
    private final int mDataExtractionRules;
    private boolean mDebugAllowHTTPMAMService;
    private boolean mDebuggable;
    private boolean mDisableOfflineLogging;
    private final int mFullBackupContent;
    private final String mMAMSvcFWLinkOverride;
    private final Boolean mMultiIdentityEnabled;
    private final Boolean mMultiManagedIdentitiesEnabled;
    private final Boolean mPolicyRequired;
    private final Boolean mTestOnly;
    private Boolean mUseDefaultMAMEnrollment;
    private final Boolean mWorkingTimeSupported;

    public Boolean isPolicyRequired() {
        return this.mPolicyRequired;
    }

    public Boolean isMultiIdentityEnabled() {
        return this.mMultiIdentityEnabled;
    }

    public Boolean isMultiManagedIdentitiesEnabled() {
        return this.mMultiManagedIdentitiesEnabled;
    }

    public Boolean allowIsolatedProcesses() {
        return this.mAllowIsolatedProcesses;
    }

    public Boolean isWorkingTimeSupported() {
        return this.mWorkingTimeSupported;
    }

    public Boolean isTestOnly() {
        return this.mTestOnly;
    }

    public boolean isDebuggable() {
        return this.mDebuggable;
    }

    public int getFullBackupContent() {
        return this.mFullBackupContent;
    }

    public int getDataExtractionRules() {
        return this.mDataExtractionRules;
    }

    public String getMAMServiceFWLinkOverride() {
        return this.mMAMSvcFWLinkOverride;
    }

    public boolean isDebugHTTPMAMServiceAllowed() {
        return this.mDebugAllowHTTPMAMService;
    }

    public Boolean isDefaultMAMEnrollmentEnabled() {
        return this.mUseDefaultMAMEnrollment;
    }

    public AgentType getAgentType() {
        return this.mAgent;
    }

    public boolean isOfflineLoggingDisabled() {
        return this.mDisableOfflineLogging;
    }

    public boolean isConfigOnlyMode() {
        return this.mConfigOnlyMode;
    }

    public MetaDataReader(Context context) {
        this(context, context.getPackageName());
    }

    public MetaDataReader(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = PackageManagerCompat.getApplicationInfo(context.getPackageManager(), str, 128L);
            this.mTestOnly = Boolean.valueOf((applicationInfo.flags & 256) != 0);
            this.mDebuggable = (applicationInfo.flags & 2) != 0;
            Bundle bundle = applicationInfo.metaData;
            this.mPolicyRequired = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.MAMPolicyRequired", false) : false);
            Boolean boolValueOf = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.MAMMultiIdentity", false) : false);
            Boolean boolValueOf2 = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.MAMMultiManagedIdentities", false) : false);
            this.mMultiManagedIdentitiesEnabled = boolValueOf2;
            if (boolValueOf2.booleanValue()) {
                this.mMultiIdentityEnabled = true;
            } else {
                this.mMultiIdentityEnabled = boolValueOf;
            }
            this.mMAMSvcFWLinkOverride = bundle != null ? bundle.getString("com.microsoft.intune.mam.policy.MAMServiceLookup.FWLinkOverride") : null;
            this.mUseDefaultMAMEnrollment = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.DefaultMAMServiceEnrollment", false) : false);
            this.mFullBackupContent = determineFullBackupContent(bundle);
            this.mDataExtractionRules = determineDataExtractionRules(bundle);
            this.mDebugAllowHTTPMAMService = bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.DebugMAMServiceAllowHTTP", false) : false;
            this.mDisableOfflineLogging = bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.DisableOfflineLogging", false) : false;
            this.mConfigOnlyMode = bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.ConfigOnlyMode", false) : false;
            this.mAllowIsolatedProcesses = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.AllowIsolatedProcesses", false) : false);
            this.mWorkingTimeSupported = Boolean.valueOf(bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.WorkingTime", false) : false);
            AgentType agentTypeFromString = AgentType.fromString(bundle != null ? bundle.getString("com.microsoft.intune.mam.Agent", null) : null);
            this.mAgent = agentTypeFromString;
            if (agentTypeFromString == null) {
                if (bundle != null ? bundle.getBoolean("com.microsoft.intune.mam.ForceProductionAgent", false) : false) {
                    this.mAgent = AgentType.PRODUCTION;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Application info for calling app could not be found");
        }
    }

    private int determineFullBackupContent(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(FULL_BACKUP_CONTENT_TAG_NAME)) {
            return 0;
        }
        int i = bundle.getInt(FULL_BACKUP_CONTENT_TAG_NAME, -2);
        if (i != -2) {
            return i;
        }
        return bundle.getBoolean(FULL_BACKUP_CONTENT_TAG_NAME, false) ? 0 : -1;
    }

    private int determineDataExtractionRules(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(DATA_EXTRACTION_RULES_TAG_NAME)) {
            return 0;
        }
        int i = bundle.getInt(DATA_EXTRACTION_RULES_TAG_NAME, -2);
        if (i != -2) {
            return i;
        }
        return bundle.getBoolean(DATA_EXTRACTION_RULES_TAG_NAME, false) ? 0 : -1;
    }
}
