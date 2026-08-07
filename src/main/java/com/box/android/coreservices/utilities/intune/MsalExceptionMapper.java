package com.box.android.coreservices.utilities.intune;

import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: MsalExceptionMapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/MsalExceptionMapper;", "", "<init>", "()V", "errorMap", "", "", "", "getErrorCode", "exception", "Lcom/microsoft/identity/client/exception/MsalException;", "(Lcom/microsoft/identity/client/exception/MsalException;)Ljava/lang/Integer;", "getCanceledErrorCode", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MsalExceptionMapper {
    public static final MsalExceptionMapper INSTANCE = new MsalExceptionMapper();
    private static final Map<String, Integer> errorMap = MapsKt.mapOf(TuplesKt.to(MsalClientException.INVALID_PARAMETER, -60001), TuplesKt.to("multiple_matching_tokens_detected", -60002), TuplesKt.to("device_network_not_available", -60003), TuplesKt.to("scope_empty_or_null", -60004), TuplesKt.to("json_parse_failure", -60005), TuplesKt.to("io_error", -60006), TuplesKt.to("malformed_url", -60007), TuplesKt.to("unknown_authority", -60008), TuplesKt.to("unsupported_encoding", -60009), TuplesKt.to("no_such_algorithm", -60010), TuplesKt.to("invalid_jwt", -60011), TuplesKt.to("state_mismatch", -60012), TuplesKt.to("unsupported_url", -60013), TuplesKt.to("authority_validation_not_supported", -60014), TuplesKt.to("chrome_not_installed", -60015), TuplesKt.to("user_mismatch", -60016), TuplesKt.to("duplicate_query_parameter", -60017), TuplesKt.to("Failed to bind the service in broker app", -60018), TuplesKt.to("unknown_error", -60019), TuplesKt.to(MsalClientException.BROKER_NOT_INSTALLED, -60020), TuplesKt.to(MsalClientException.NOT_ELIGIBLE_TO_USE_BROKER, -60021), TuplesKt.to(MsalClientException.NO_CURRENT_ACCOUNT, -60022), TuplesKt.to(MsalClientException.CURRENT_ACCOUNT_MISMATCH, -60023), TuplesKt.to("duplicate_command", -60024), TuplesKt.to(MsalClientException.APP_MANIFEST_VALIDATION_ERROR, -60025), TuplesKt.to(MsalClientException.REDIRECT_URI_VALIDATION_ERROR, -60026), TuplesKt.to(MsalClientException.SAPCA_USE_WITH_MULTI_POLICY_B2C, -60028), TuplesKt.to("invalid_request", -60031), TuplesKt.to("unauthorized_client", -60032), TuplesKt.to("access_denied", -60033), TuplesKt.to("invalid_scope", -60034), TuplesKt.to("service_not_available", -60035), TuplesKt.to("request_timeout", -60036), TuplesKt.to("invalid_instance", -60037));

    public final int getCanceledErrorCode() {
        return -60030;
    }

    private MsalExceptionMapper() {
    }

    public static /* synthetic */ Integer getErrorCode$default(MsalExceptionMapper msalExceptionMapper, MsalException msalException, int i, Object obj) {
        if ((i & 1) != 0) {
            msalException = null;
        }
        return msalExceptionMapper.getErrorCode(msalException);
    }

    public final Integer getErrorCode(MsalException exception) {
        if (exception instanceof MsalIntuneAppProtectionPolicyRequiredException) {
            return -60029;
        }
        return errorMap.get(exception != null ? exception.getErrorCode() : null);
    }
}
