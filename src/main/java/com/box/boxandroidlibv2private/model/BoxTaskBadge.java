package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxJsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxTaskBadge extends BoxJsonObject {
    public static final String FIELD_COUNT = "count";
    public static final String FIELD_HAS_MORE = "has_more";

    public Integer getCount() {
        return getPropertyAsInt("count");
    }

    public Boolean hasMore() {
        return getPropertyAsBoolean(FIELD_HAS_MORE);
    }
}
