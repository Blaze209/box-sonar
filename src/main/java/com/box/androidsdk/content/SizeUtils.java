package com.box.androidsdk.content;

import com.box.androidsdk.content.utils.SdkUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: SizeUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005*\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/androidsdk/content/SizeUtils;", "", "<init>", "()V", "toFormattedSize", "", "kotlin.jvm.PlatformType", "", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SizeUtils {
    public static final SizeUtils INSTANCE = new SizeUtils();

    private SizeUtils() {
    }

    public final String toFormattedSize(long j) {
        return SdkUtils.getLocalizedFileSize(j);
    }
}
