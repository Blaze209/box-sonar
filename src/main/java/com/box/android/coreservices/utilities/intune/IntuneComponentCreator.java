package com.box.android.coreservices.utilities.intune;

import android.content.Context;
import com.box.android.coreservices.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry;
import com.microsoft.intune.mam.policy.MAMComplianceManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntuneComponentCreator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/IntuneComponentCreator;", "", "<init>", "()V", "createSingleApp", "Lcom/microsoft/identity/client/ISingleAccountPublicClientApplication;", "context", "Landroid/content/Context;", "createSingleAppAsync", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/microsoft/identity/client/IPublicClientApplication$ISingleAccountApplicationCreatedListener;", "createEnrollmentManager", "Lcom/microsoft/intune/mam/policy/MAMEnrollmentManager;", "createComplianceManager", "Lcom/microsoft/intune/mam/policy/MAMComplianceManager;", "createNotificationRegistry", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntuneComponentCreator {
    @Inject
    public IntuneComponentCreator() {
    }

    public final ISingleAccountPublicClientApplication createSingleApp(Context context) throws MsalException, InterruptedException {
        Intrinsics.checkNotNullParameter(context, "context");
        ISingleAccountPublicClientApplication iSingleAccountPublicClientApplicationCreateSingleAccountPublicClientApplication = PublicClientApplication.createSingleAccountPublicClientApplication(context, R.raw.msal_auth_default);
        Intrinsics.checkNotNullExpressionValue(iSingleAccountPublicClientApplicationCreateSingleAccountPublicClientApplication, "createSingleAccountPublicClientApplication(...)");
        return iSingleAccountPublicClientApplicationCreateSingleAccountPublicClientApplication;
    }

    public final void createSingleAppAsync(Context context, IPublicClientApplication.ISingleAccountApplicationCreatedListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PublicClientApplication.createSingleAccountPublicClientApplication(context, R.raw.msal_auth_default, listener);
    }

    public final MAMEnrollmentManager createEnrollmentManager() {
        Object obj = MAMComponents.get(MAMEnrollmentManager.class);
        Intrinsics.checkNotNull(obj);
        return (MAMEnrollmentManager) obj;
    }

    public final MAMComplianceManager createComplianceManager() {
        Object obj = MAMComponents.get(MAMComplianceManager.class);
        Intrinsics.checkNotNull(obj);
        return (MAMComplianceManager) obj;
    }

    public final MAMNotificationReceiverRegistry createNotificationRegistry() {
        Object obj = MAMComponents.get(MAMNotificationReceiverRegistry.class);
        Intrinsics.checkNotNull(obj);
        return (MAMNotificationReceiverRegistry) obj;
    }
}
