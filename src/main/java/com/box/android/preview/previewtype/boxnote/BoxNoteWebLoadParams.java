package com.box.android.preview.previewtype.boxnote;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteWebViewContainer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebLoadParams;", "", "url", "", "headers", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class BoxNoteWebLoadParams {
    private final Map<String, String> headers;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoxNoteWebLoadParams copy$default(BoxNoteWebLoadParams boxNoteWebLoadParams, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boxNoteWebLoadParams.url;
        }
        if ((i & 2) != 0) {
            map = boxNoteWebLoadParams.headers;
        }
        return boxNoteWebLoadParams.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final BoxNoteWebLoadParams copy(String url, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new BoxNoteWebLoadParams(url, headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxNoteWebLoadParams)) {
            return false;
        }
        BoxNoteWebLoadParams boxNoteWebLoadParams = (BoxNoteWebLoadParams) other;
        return Intrinsics.areEqual(this.url, boxNoteWebLoadParams.url) && Intrinsics.areEqual(this.headers, boxNoteWebLoadParams.headers);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "BoxNoteWebLoadParams(url=" + this.url + ", headers=" + this.headers + ")";
    }

    public BoxNoteWebLoadParams(String url, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.headers = headers;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getUrl() {
        return this.url;
    }
}
