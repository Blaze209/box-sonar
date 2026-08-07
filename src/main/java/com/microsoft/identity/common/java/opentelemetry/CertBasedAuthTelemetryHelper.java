package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes14.dex */
public class CertBasedAuthTelemetryHelper implements ICertBasedAuthTelemetryHelper {
    private final Span mSpan;

    public CertBasedAuthTelemetryHelper(SpanContext spanContext) {
        if (spanContext == null) {
            throw new NullPointerException("spanContext is marked non-null but is null");
        }
        this.mSpan = OTelUtility.createSpanFromParent(SpanName.CertBasedAuth.name(), spanContext);
    }

    public CertBasedAuthTelemetryHelper() {
        this.mSpan = OTelUtility.createSpan(SpanName.CertBasedAuth.name());
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setCertBasedAuthChallengeHandler(String str) {
        if (str == null) {
            throw new NullPointerException("challengeHandlerName is marked non-null but is null");
        }
        this.mSpan.setAttribute(AttributeName.cert_based_auth_challenge_handler.name(), str);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setExistingPivProviderPresent(boolean z) {
        this.mSpan.setAttribute(AttributeName.cert_based_auth_existing_piv_provider_present.name(), z);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setResultSuccess() {
        this.mSpan.setStatus(StatusCode.OK);
        this.mSpan.end();
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setResultFailure(String str) {
        if (str == null) {
            throw new NullPointerException("message is marked non-null but is null");
        }
        this.mSpan.setStatus(StatusCode.ERROR, str);
        this.mSpan.end();
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setResultFailure(Exception exc) {
        if (exc == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        this.mSpan.recordException(exc);
        this.mSpan.setStatus(StatusCode.ERROR);
        this.mSpan.end();
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.opentelemetry.CertBasedAuthTelemetryHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$opentelemetry$CertBasedAuthChoice;

        static {
            int[] iArr = new int[CertBasedAuthChoice.values().length];
            $SwitchMap$com$microsoft$identity$common$java$opentelemetry$CertBasedAuthChoice = iArr;
            try {
                iArr[CertBasedAuthChoice.ON_DEVICE_CHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$opentelemetry$CertBasedAuthChoice[CertBasedAuthChoice.SMARTCARD_CHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setUserChoice(CertBasedAuthChoice certBasedAuthChoice) {
        if (certBasedAuthChoice == null) {
            throw new NullPointerException("choice is marked non-null but is null");
        }
        int i = AnonymousClass1.$SwitchMap$com$microsoft$identity$common$java$opentelemetry$CertBasedAuthChoice[certBasedAuthChoice.ordinal()];
        if (i == 1) {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "on-device");
        } else if (i == 2) {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "smartcard");
        } else {
            this.mSpan.setAttribute(AttributeName.cert_based_auth_user_choice.name(), "N/A");
        }
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper
    public void setPublicKeyAlgoType(String str) {
        if (str == null) {
            throw new NullPointerException("type is marked non-null but is null");
        }
        this.mSpan.setAttribute(AttributeName.cert_based_auth_public_key_algo_type.name(), str);
    }
}
