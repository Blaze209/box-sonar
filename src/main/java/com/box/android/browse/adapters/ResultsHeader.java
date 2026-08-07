package com.box.android.browse.adapters;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes10.dex */
public class ResultsHeader extends BoxItem {
    public ResultsHeader(BoxFolder boxFolder) {
        super(BoxFolder.createFromIdAndName(boxFolder.getUserId(), boxFolder.getName()).toJsonObject());
    }
}
