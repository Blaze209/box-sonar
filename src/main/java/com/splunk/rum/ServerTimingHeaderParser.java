package com.splunk.rum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
class ServerTimingHeaderParser {
    private static final String[] UNPARSEABLE_RESULT = new String[0];
    private static final Pattern headerPattern = Pattern.compile("traceparent;desc=['\"]00-([0-9a-f]{32})-([0-9a-f]{16})-01['\"]");

    ServerTimingHeaderParser() {
    }

    String[] parse(String str) {
        if (str == null) {
            return UNPARSEABLE_RESULT;
        }
        Matcher matcher = headerPattern.matcher(str);
        if (!matcher.matches()) {
            return UNPARSEABLE_RESULT;
        }
        return new String[]{matcher.group(1), matcher.group(2)};
    }
}
