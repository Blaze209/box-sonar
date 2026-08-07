package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.JsonParseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.net.HttpConstants;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.ITokenResponseHandler;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.telemetry.CliTelemInfo;
import com.microsoft.identity.common.java.util.HeaderSerializationUtil;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.ResultUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractMicrosoftStsTokenResponseHandler implements ITokenResponseHandler<TokenResult> {
    private static final String TAG = "AbstractMicrosoftStsTokenResponseHandler";

    protected abstract MicrosoftStsTokenResponse getSuccessfulResponse(HttpResponse httpResponse) throws ClientException;

    @Override // com.microsoft.identity.common.java.providers.oauth2.ITokenResponseHandler
    public TokenResult handleTokenResponse(HttpResponse httpResponse) throws ClientException {
        MicrosoftTokenErrorResponse errorResponse;
        if (httpResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        String str = TAG + ":handleTokenResponse";
        MicrosoftStsTokenResponse successfulResponse = null;
        if (httpResponse.getStatusCode() >= 400) {
            errorResponse = getErrorResponse(httpResponse);
        } else {
            successfulResponse = getSuccessfulResponse(httpResponse);
            errorResponse = null;
        }
        TokenResult tokenResult = new TokenResult(successfulResponse, errorResponse);
        ResultUtil.logResult(str, tokenResult);
        if (httpResponse.getHeaders() != null) {
            List<String> list = httpResponse.getHeaders().get(HttpConstants.HeaderField.X_MS_CLITELEM);
            if (list != null && !list.isEmpty()) {
                CliTelemInfo cliTelemInfoFromXMsCliTelemHeader = CliTelemInfo.fromXMsCliTelemHeader(list.get(0));
                tokenResult.setCliTelemInfo(cliTelemInfoFromXMsCliTelemHeader);
                if (successfulResponse != null && cliTelemInfoFromXMsCliTelemHeader != null) {
                    successfulResponse.setSpeRing(cliTelemInfoFromXMsCliTelemHeader.getSpeRing());
                    successfulResponse.setRefreshTokenAge(cliTelemInfoFromXMsCliTelemHeader.getRefreshTokenAge());
                    successfulResponse.setCliTelemErrorCode(cliTelemInfoFromXMsCliTelemHeader.getServerErrorCode());
                    successfulResponse.setCliTelemSubErrorCode(cliTelemInfoFromXMsCliTelemHeader.getServerSubErrorCode());
                }
            }
            HashMap map = new HashMap();
            String headerValue = httpResponse.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_ID, 0);
            if (headerValue != null) {
                SpanExtension.current().setAttribute(AttributeName.ccs_request_id.name(), headerValue);
                if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE)) {
                    map.put(HttpConstants.HeaderField.XMS_CCS_REQUEST_ID, headerValue);
                }
            }
            String headerValue2 = httpResponse.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_SEQUENCE, 0);
            if (headerValue2 != null) {
                SpanExtension.current().setAttribute(AttributeName.ccs_request_sequence.name(), headerValue2);
                if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.EXPOSE_CCS_REQUEST_SEQUENCE_IN_TOKENRESPONSE)) {
                    map.put(HttpConstants.HeaderField.XMS_CCS_REQUEST_SEQUENCE, headerValue2);
                }
            }
            if (successfulResponse != null) {
                if (successfulResponse.getExtraParameters() != null) {
                    for (Map.Entry<String, String> entry : successfulResponse.getExtraParameters()) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
                successfulResponse.setExtraParameters(map.entrySet());
            }
        }
        return tokenResult;
    }

    private MicrosoftTokenErrorResponse getErrorResponse(HttpResponse httpResponse) throws ClientException {
        MicrosoftTokenErrorResponse microsoftTokenErrorResponse;
        if (httpResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        try {
            microsoftTokenErrorResponse = (MicrosoftTokenErrorResponse) ObjectMapper.deserializeJsonStringToObject(getBodyFromUnsuccessfulResponse(httpResponse.getBody()), MicrosoftTokenErrorResponse.class);
        } catch (JsonParseException unused) {
            microsoftTokenErrorResponse = new MicrosoftTokenErrorResponse();
            String strValueOf = String.valueOf(httpResponse.getStatusCode());
            microsoftTokenErrorResponse.setError(strValueOf);
            microsoftTokenErrorResponse.setErrorDescription("Received " + strValueOf + " status code from Server ");
        }
        microsoftTokenErrorResponse.setStatusCode(httpResponse.getStatusCode());
        if (httpResponse.getHeaders() != null) {
            microsoftTokenErrorResponse.setResponseHeadersJson(HeaderSerializationUtil.toJson(httpResponse.getHeaders()));
        }
        microsoftTokenErrorResponse.setResponseBody(httpResponse.getBody());
        return microsoftTokenErrorResponse;
    }

    private String getBodyFromUnsuccessfulResponse(String str) {
        if (str != null) {
            return str.isEmpty() ? "{}" : str;
        }
        throw new NullPointerException("responseBody is marked non-null but is null");
    }
}
