package com.box.android.coreservices.models;

import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;
import java.util.HashSet;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFeatures extends BoxJsonObject {
    public static final String FEATURE_PASSWORD_PROTECT_LINKS = "password_protected_shared_links";
    public static final String USER_FEATURE_LIST = "user_feature_list";

    public BoxFeatures() {
    }

    public BoxFeatures(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxFeatures createEntityFromJson(JsonObject jsonObject) {
        BoxFeatures boxFeatures = new BoxFeatures();
        if (jsonObject == null) {
            return null;
        }
        boxFeatures.createFromJson(jsonObject);
        return boxFeatures;
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

    public boolean hasPasswordProtectForSharedLinks() {
        return hasFeature(FEATURE_PASSWORD_PROTECT_LINKS);
    }
}
