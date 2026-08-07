package com.pspdfkit.configuration.policy;

import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultApplicationPolicy extends ApplicationPolicy {
    private static final String LOG_TAG = "DefaultApplicationPolicy";

    /* JADX INFO: renamed from: com.pspdfkit.configuration.policy.DefaultApplicationPolicy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$configuration$policy$ApplicationPolicy$PolicyEvent;

        static {
            int[] iArr = new int[ApplicationPolicy.PolicyEvent.values().length];
            $SwitchMap$com$pspdfkit$configuration$policy$ApplicationPolicy$PolicyEvent = iArr;
            try {
                iArr[ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$configuration$policy$ApplicationPolicy$PolicyEvent[ApplicationPolicy.PolicyEvent.ANNOTATION_COPY_PASTE_SYSTEM_INTEGRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.pspdfkit.configuration.policy.ApplicationPolicy
    public boolean hasPermissionForEvent(ApplicationPolicy.PolicyEvent policyEvent) {
        uw.a(policyEvent, "event", null);
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$configuration$policy$ApplicationPolicy$PolicyEvent[policyEvent.ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        PdfLog.e(LOG_TAG, "event %s not included in current policy: %s", policyEvent, getClass().getSimpleName());
        return false;
    }
}
