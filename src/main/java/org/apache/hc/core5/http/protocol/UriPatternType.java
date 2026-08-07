package org.apache.hc.core5.http.protocol;

/* JADX INFO: loaded from: classes5.dex */
public enum UriPatternType {
    REGEX,
    URI_PATTERN,
    URI_PATTERN_IN_ORDER;

    @Deprecated
    public static <T> LookupRegistry<T> newMatcher(UriPatternType uriPatternType) {
        if (uriPatternType == null) {
            return new UriPatternMatcher();
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[uriPatternType.ordinal()];
        if (i == 1) {
            return new UriRegexMatcher();
        }
        if (i == 2) {
            return new UriPatternOrderedMatcher();
        }
        return new UriPatternMatcher();
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.protocol.UriPatternType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType;

        static {
            int[] iArr = new int[UriPatternType.values().length];
            $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType = iArr;
            try {
                iArr[UriPatternType.REGEX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.URI_PATTERN_IN_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.URI_PATTERN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
