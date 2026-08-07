package com.microsoft.intune.mam.policy.notification;

import com.microsoft.intune.mam.client.telemetry.events.ScenarioEvent;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMWEError;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMEnrollmentNotification extends MAMUserNotification {
    MAMEnrollmentManager.Result getEnrollmentResult();

    MAMWEError getError();

    ScenarioEvent.Scenario getScenario();

    String getSessionId();
}
