package com.microsoft.identity.client.claims;

/* JADX INFO: loaded from: classes14.dex */
public class WWWAuthenticateHeader {
    static final String CLAIMS_DIRECTIVE = "claims=";
    static final char COMMA = ',';
    static final char DOUBLE_QUOTE = '\"';
    static final char SINGLE_QUOTE = '\'';
    static final char SPACE = ' ';

    public static ClaimsRequest getClaimsRequestFromWWWAuthenticateHeaderValue(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(CLAIMS_DIRECTIVE);
        if (iIndexOf == -1) {
            return null;
        }
        int length = iIndexOf + CLAIMS_DIRECTIVE.length();
        int i = length + 1;
        char cCharAt = str.substring(length, i).charAt(0);
        if (cCharAt == '\'') {
            strSubstring = str.substring(i, str.indexOf(39, i));
        } else if (cCharAt == '\"') {
            strSubstring = str.substring(i, str.indexOf("}\"", i) + 1);
        } else {
            int iIndexOf2 = str.indexOf(44, length);
            int iIndexOf3 = str.indexOf(32, length);
            if (iIndexOf2 == -1 && iIndexOf3 == -1) {
                strSubstring = str.substring(length);
            } else if (iIndexOf2 != -1) {
                strSubstring = str.substring(length, iIndexOf2);
            } else {
                strSubstring = str.substring(length, iIndexOf3);
            }
        }
        return ClaimsRequest.getClaimsRequestFromJsonString(strSubstring);
    }

    public static Boolean hasClaimsDirective(String str) {
        if (str.indexOf(CLAIMS_DIRECTIVE) == -1) {
            return false;
        }
        return true;
    }
}
