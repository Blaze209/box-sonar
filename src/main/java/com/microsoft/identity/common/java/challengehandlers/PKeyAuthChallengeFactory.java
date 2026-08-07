package com.microsoft.identity.common.java.challengehandlers;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public class PKeyAuthChallengeFactory {
    private static final String CHALLENGE_REQUEST_CERT_AUTH_DELIMITER = ";";
    private static final String TAG = "PKeyAuthChallengeFactory";

    public PKeyAuthChallenge getPKeyAuthChallengeFromWebViewRedirect(String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        Map<String, String> parameters = UrlUtil.getParameters(str);
        validatePKeyAuthChallengeFromWebViewRedirect(parameters);
        PKeyAuthChallenge.PKeyAuthChallengeBuilder pKeyAuthChallengeBuilder = new PKeyAuthChallenge.PKeyAuthChallengeBuilder();
        pKeyAuthChallengeBuilder.nonce(parameters.get(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))).context(parameters.get(PKeyAuthChallenge.RequestField.Context.name())).version(parameters.get(PKeyAuthChallenge.RequestField.Version.name())).submitUrl(parameters.get(PKeyAuthChallenge.RequestField.SubmitUrl.name())).tenantId(parameters.get(PKeyAuthChallenge.RequestField.TenantId.name()));
        if (parameters.containsKey(PKeyAuthChallenge.RequestField.CertAuthorities.name())) {
            pKeyAuthChallengeBuilder.certAuthorities(StringUtil.getStringTokens(parameters.get(PKeyAuthChallenge.RequestField.CertAuthorities.name()), ";"));
        }
        return pKeyAuthChallengeBuilder.build();
    }

    public PKeyAuthChallenge getPKeyAuthChallengeFromTokenEndpointResponse(String str, String str2) throws UnsupportedEncodingException, ClientException {
        if (str == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        validateHeaderForPkeyAuthChallenge(str);
        Map<String, String> pKeyAuthHeader = getPKeyAuthHeader(str);
        validatePKeyAuthChallengeFromTokenEndpointResponse(pKeyAuthHeader);
        PKeyAuthChallenge.PKeyAuthChallengeBuilder pKeyAuthChallengeBuilder = new PKeyAuthChallenge.PKeyAuthChallengeBuilder();
        pKeyAuthChallengeBuilder.submitUrl(str2).nonce(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))).context(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Context.name())).version(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.Version.name())).tenantId(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.TenantId.name()));
        if (!StringUtil.isNullOrEmpty(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.CertThumbprint.name()))) {
            pKeyAuthChallengeBuilder.thumbprint(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.CertThumbprint.name()));
        } else if (pKeyAuthHeader.containsKey(PKeyAuthChallenge.RequestField.CertAuthorities.name())) {
            pKeyAuthChallengeBuilder.certAuthorities(StringUtil.getStringTokens(pKeyAuthHeader.get(PKeyAuthChallenge.RequestField.CertAuthorities.name()), ";"));
        }
        return pKeyAuthChallengeBuilder.build();
    }

    private void validateHeaderForPkeyAuthChallenge(String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "header value is empty.");
        }
        if (!StringUtil.hasPrefixInHeader(str, "PKeyAuth")) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "challenge response type is wrong.");
        }
    }

    private void validatePKeyAuthChallengeFromTokenEndpointResponse(Map<String, String> map) throws ClientException {
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Nonce.name()) && !map.containsKey(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Nonce is empty.");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Context.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Context is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Version.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Version name is empty");
        }
    }

    private void validatePKeyAuthChallengeFromWebViewRedirect(Map<String, String> map) throws ClientException {
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Nonce.name()) && !map.containsKey(PKeyAuthChallenge.RequestField.Nonce.name().toLowerCase(Locale.US))) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Nonce is empty.");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Context.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Context is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.Version.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "Version name is empty");
        }
        if (!map.containsKey(PKeyAuthChallenge.RequestField.SubmitUrl.name())) {
            throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, "SubmitUrl is empty");
        }
    }

    private Map<String, String> getPKeyAuthHeader(String str) throws UnsupportedEncodingException, ClientException {
        String strSubstring = str.substring("PKeyAuth".length());
        ArrayList<String> arrayListSplitWithQuotes = StringUtil.splitWithQuotes(strSubstring, AbstractJsonLexerKt.COMMA);
        HashMap map = new HashMap();
        Iterator<String> it = arrayListSplitWithQuotes.iterator();
        while (it.hasNext()) {
            ArrayList<String> arrayListSplitWithQuotes2 = StringUtil.splitWithQuotes(it.next(), '=');
            if (arrayListSplitWithQuotes2.size() == 2 && !StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(0)) && !StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(1))) {
                String str2 = arrayListSplitWithQuotes2.get(0);
                String str3 = arrayListSplitWithQuotes2.get(1);
                map.put(StringUtil.urlFormDecode(str2).trim(), StringUtil.removeQuoteInHeaderValue(StringUtil.urlFormDecode(str3).trim()));
            } else if (arrayListSplitWithQuotes2.size() == 1 && !StringUtil.isNullOrEmpty(arrayListSplitWithQuotes2.get(0))) {
                map.put(StringUtil.urlFormDecode(arrayListSplitWithQuotes2.get(0)).trim(), StringUtil.urlFormDecode(""));
            } else {
                throw new ClientException(ErrorStrings.DEVICE_CERTIFICATE_REQUEST_INVALID, strSubstring);
            }
        }
        return map;
    }
}
