package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public class BoxLocalRecentItem extends BoxRecentItem {
    private static final String FIELD_INTERACTED_AT = "interacted_at";
    private static final String FIELD_INTERACTION_TYPE = "interaction_type";
    private static final String FIELD_ITEM = "item";
    private static final String FIELD_ITERACTION_SHARED_LINK = "interaction_shared_link";

    public BoxLocalRecentItem(BoxItem boxItem, String str, Date date, String str2) {
        set("interacted_at", BoxDateFormat.format(date));
        set("interaction_type", str);
        set("item", boxItem);
        set("interaction_shared_link", str2);
    }
}
