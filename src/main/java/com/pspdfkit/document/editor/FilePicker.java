package com.pspdfkit.document.editor;

import android.net.Uri;
import io.reactivex.rxjava3.core.Maybe;

/* JADX INFO: loaded from: classes3.dex */
public interface FilePicker {
    default Maybe<Uri> getDestinationUri(String str) {
        return getDestinationUri(str, null);
    }

    Maybe<Uri> getDestinationUri(String str, String str2);
}
