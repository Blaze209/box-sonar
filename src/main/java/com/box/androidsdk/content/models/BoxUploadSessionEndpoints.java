package com.box.androidsdk.content.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUploadSessionEndpoints extends BoxJsonObject {
    public static final String FIELD_ABORT = "abort";
    public static final String FIELD_COMMIT = "commit";
    public static final String FIELD_LIST_PARTS = "list_parts";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_UPLOAD_PART = "upload_part";

    public String getListPartsEndpoint() {
        return getPropertyAsString(FIELD_LIST_PARTS);
    }

    public String getCommitEndpoint() {
        return getPropertyAsString(FIELD_COMMIT);
    }

    public String getUploadPartEndpoint() {
        return getPropertyAsString(FIELD_UPLOAD_PART);
    }

    public String getStatusEndpoint() {
        return getPropertyAsString("status");
    }

    public String getAbortEndpoint() {
        return getPropertyAsString(FIELD_ABORT);
    }

    public Map<String, String> getEndpointsMap() {
        List<String> propertiesKeySet = getPropertiesKeySet();
        HashMap map = new HashMap(propertiesKeySet.size());
        for (String str : propertiesKeySet) {
            map.put(str, getPropertyAsString(str));
        }
        return map;
    }
}
