package io.split.android.client.service.sseclient;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SseJwtParser {
    static final Type ALL_TOKEN_TYPE = new TypeToken<Map<String, Object>>() { // from class: io.split.android.client.service.sseclient.SseJwtParser.1
    }.getType();
    private static final Type CHANNEL_TYPE = new TypeToken<Map<String, List<String>>>() { // from class: io.split.android.client.service.sseclient.SseJwtParser.2
    }.getType();
    private static final String PUBLISHERS_CHANNEL_METADATA = "channel-metadata:publishers";
    private static final String PUBLISHERS_CHANNEL_PREFIX = "[?occupancy=metrics.publishers]";

    public SseJwtToken parse(String rawToken) throws InvalidJwtTokenException {
        if (rawToken == null) {
            Logger.e("Error: JWT is null.");
            throw new InvalidJwtTokenException();
        }
        String strExtractTokenData = extractTokenData(rawToken);
        if (strExtractTokenData == null) {
            Logger.e("SSE authentication JWT payload is not valid.");
            throw new InvalidJwtTokenException();
        }
        String strDecode = Base64Util.decode(strExtractTokenData);
        if (strDecode == null) {
            Logger.e("Could not decode SSE authentication JWT payload.");
            throw new InvalidJwtTokenException();
        }
        try {
            SseAuthToken sseAuthToken = (SseAuthToken) Json.fromJson(strDecode, SseAuthToken.class);
            if (sseAuthToken == null || sseAuthToken.getChannelList() == null) {
                Logger.e("SSE JWT data is empty or not valid.");
                throw new InvalidJwtTokenException();
            }
            Map map = (Map) Json.fromJson(sseAuthToken.getChannelList(), CHANNEL_TYPE);
            if (map == null) {
                Logger.e("SSE JWT has not channels.");
                throw new InvalidJwtTokenException();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                List list = (List) map.get(str);
                if (list != null && list.contains(PUBLISHERS_CHANNEL_METADATA)) {
                    arrayList.add(PUBLISHERS_CHANNEL_PREFIX + str);
                } else {
                    arrayList.add(str);
                }
            }
            return new SseJwtToken(sseAuthToken.getIssuedAt(), sseAuthToken.getExpirationAt(), arrayList, rawToken);
        } catch (JsonSyntaxException e) {
            Logger.e("Error parsing SSE authentication JWT json " + e.getLocalizedMessage());
            throw new InvalidJwtTokenException();
        } catch (Exception e2) {
            Logger.e("Unknown error while parsing SSE authentication JWT: " + e2.getLocalizedMessage());
            throw new InvalidJwtTokenException();
        }
    }

    private String extractTokenData(String token) {
        String[] strArrSplit = token.split("\\.");
        if (strArrSplit.length > 1) {
            return strArrSplit[1];
        }
        return null;
    }

    private List<String> emptyChannelList() {
        return new ArrayList();
    }
}
