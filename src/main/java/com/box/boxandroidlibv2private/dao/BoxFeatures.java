package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;
import java.util.HashSet;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFeatures extends BoxEntity {
    public static final String FEATURE_MOBILE_AUTO_CONTENT_UPLOAD = "mobile_auto_upload";
    public static final String USER_FEATURE_LIST = "user_feature_list";

    public BoxFeatures() {
    }

    public BoxFeatures(JsonObject jsonObject) {
        super(jsonObject);
    }

    public HashSet<String> getFeatures() {
        return getPropertyAsStringHashSet("user_feature_list");
    }

    public boolean hasFeature(String str) {
        if (getFeatures() != null) {
            return getFeatures().contains(str);
        }
        return false;
    }

    public boolean hasAutoContentUpload() {
        return hasFeature(FEATURE_MOBILE_AUTO_CONTENT_UPLOAD);
    }
}
