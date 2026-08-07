package io.split.android.client.service.sseclient;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class EventStreamParser {
    public static final String DATA_FIELD = "data";
    public static final String EVENT_FIELD = "event";
    private static final String FIELD_SEPARATOR = ":";
    public static final String ID_FIELD = "data";
    public static final String KEEP_ALIVE_EVENT = "keepalive";
    private static final String KEEP_ALIVE_TOKEN = ":keepalive";

    public boolean parseLineAndAppendValue(String streamLine, Map<String, String> messageValues) {
        if (streamLine == null) {
            return false;
        }
        String strTrim = streamLine.trim();
        if (KEEP_ALIVE_TOKEN.equals(strTrim)) {
            messageValues.put("event", KEEP_ALIVE_EVENT);
            return true;
        }
        if (strTrim.isEmpty() && messageValues.size() == 0) {
            return false;
        }
        if (strTrim.isEmpty()) {
            return true;
        }
        int iIndexOf = strTrim.indexOf(FIELD_SEPARATOR);
        if (iIndexOf == 0) {
            return false;
        }
        String strTrim2 = "";
        if (iIndexOf <= -1) {
            messageValues.put(strTrim.trim(), "");
        } else {
            String strTrim3 = strTrim.substring(0, iIndexOf).trim();
            if (iIndexOf < strTrim.length() - 1) {
                strTrim2 = strTrim.substring(iIndexOf + 1, strTrim.length()).trim();
            }
            messageValues.put(strTrim3, strTrim2);
        }
        return false;
    }

    public boolean isKeepAlive(Map<String, String> values) {
        return KEEP_ALIVE_EVENT.equals(values.get("event"));
    }
}
