package com.box.androidsdk.content.utils.logging;

import kotlin.Metadata;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/DataMaskingConfig;", "", "<init>", "()V", "replaceWith", "", "mask", "value", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DataMaskingConfig {
    private final String replaceWith = Configuration.INSTANCE.getDefaultMaskWith();

    public final String mask(Object value) {
        return this.replaceWith;
    }
}
