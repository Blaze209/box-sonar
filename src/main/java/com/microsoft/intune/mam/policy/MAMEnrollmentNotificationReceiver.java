package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.text.TextUtils;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiver;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.notification.MAMComplianceNotification;
import com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import com.microsoft.intune.mam.policy.notification.MAMUserNotification;

/* JADX INFO: loaded from: classes3.dex */
public class MAMEnrollmentNotificationReceiver implements MAMNotificationReceiver {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMEnrollmentNotificationReceiver.class);
    private final Context mContext;
    private final boolean mIsOffline;
    private final MAMIdentityManager mMAMIdentityManager;
    private final MAMLogPIIFactory mMAMLogPIIFactory;
    private final TelemetryLogger mTelemetryLogger;

    public MAMEnrollmentNotificationReceiver(Context context, TelemetryLogger telemetryLogger, boolean z, MAMLogPIIFactory mAMLogPIIFactory, MAMIdentityManager mAMIdentityManager) {
        this.mTelemetryLogger = telemetryLogger;
        this.mContext = context;
        this.mIsOffline = z;
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
        this.mMAMIdentityManager = mAMIdentityManager;
    }

    @Override // com.microsoft.intune.mam.client.notification.MAMNotificationReceiver
    public boolean onReceive(MAMNotification mAMNotification) {
        MAMIdentity mAMIdentityCreate;
        if (mAMNotification instanceof MAMUserNotification) {
            MAMUserNotification mAMUserNotification = (MAMUserNotification) mAMNotification;
            mAMIdentityCreate = this.mMAMIdentityManager.create(mAMUserNotification.getUserIdentity(), mAMUserNotification.getUserOid());
        } else {
            mAMIdentityCreate = null;
        }
        int i = AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$policy$notification$MAMNotificationType[mAMNotification.getType().ordinal()];
        if (i == 1) {
            MAMEnrollmentNotification mAMEnrollmentNotification = (MAMEnrollmentNotification) mAMNotification;
            LOGGER.info("Received MAM enrollment result for package {0}, user {1}: {2}", this.mContext.getPackageName(), this.mMAMLogPIIFactory.getPIIUPN(mAMIdentityCreate), mAMEnrollmentNotification.getEnrollmentResult().toString());
            this.mTelemetryLogger.logMAMEnrollmentResult(this.mContext.getPackageName(), mAMEnrollmentNotification, mAMIdentityCreate != null ? mAMIdentityCreate.tenantId() : null, this.mIsOffline);
        } else if (i == 2) {
            MAMComplianceNotification mAMComplianceNotification = (MAMComplianceNotification) mAMNotification;
            MAMCAComplianceStatus complianceStatus = mAMComplianceNotification.getComplianceStatus();
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.info("Received compliance status notification for package {0}, user {1}: {2}", this.mContext.getPackageName(), this.mMAMLogPIIFactory.getPIIUPN(mAMIdentityCreate), complianceStatus.toString());
            if (!TextUtils.isEmpty(mAMComplianceNotification.getComplianceErrorMessage())) {
                mAMLogger.warning("Compliance error message: " + mAMComplianceNotification.getComplianceErrorMessage(), new Object[0]);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.policy.MAMEnrollmentNotificationReceiver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$policy$notification$MAMNotificationType;

        static {
            int[] iArr = new int[MAMNotificationType.values().length];
            $SwitchMap$com$microsoft$intune$mam$policy$notification$MAMNotificationType = iArr;
            try {
                iArr[MAMNotificationType.MAM_ENROLLMENT_RESULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$notification$MAMNotificationType[MAMNotificationType.COMPLIANCE_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
