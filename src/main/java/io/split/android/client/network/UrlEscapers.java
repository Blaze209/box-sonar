package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
final class UrlEscapers {
    private static final String URL_PATH_OTHER_SAFE_CHARS_LACKING_PLUS = "-._~!$'()*,;&=@:";
    private static final PercentEscaper URL_PATH_SEGMENT_ESCAPER = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    private UrlEscapers() {
    }

    public static PercentEscaper urlPathSegmentEscaper() {
        return URL_PATH_SEGMENT_ESCAPER;
    }
}
