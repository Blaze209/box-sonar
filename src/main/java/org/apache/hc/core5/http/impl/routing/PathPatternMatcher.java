package org.apache.hc.core5.http.impl.routing;

/* JADX INFO: loaded from: classes5.dex */
public final class PathPatternMatcher {
    public static final PathPatternMatcher INSTANCE = new PathPatternMatcher();

    public boolean match(String str, String str2) {
        if (str.equals("*") || str.equals(str2)) {
            return true;
        }
        return (str.endsWith("*") && str2.startsWith(str.substring(0, str.length() - 1))) || (str.startsWith("*") && str2.endsWith(str.substring(1)));
    }

    public boolean isBetter(String str, String str2) {
        if (str2 == null || str2.length() < str.length()) {
            return true;
        }
        return str2.length() == str.length() && str.endsWith("*");
    }
}
