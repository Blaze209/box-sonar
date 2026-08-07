package com.box.android.browse.filters;

import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes10.dex */
public interface BoxItemFilter {
    boolean accept(BoxItem boxItem);

    boolean isEnabled(BoxItem boxItem);
}
