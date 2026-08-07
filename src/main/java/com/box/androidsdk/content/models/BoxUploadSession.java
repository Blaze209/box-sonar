package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUploadSession extends BoxJsonObject {
    public static final String FIELD_ID = "id";
    private static final long serialVersionUID = -9126113409457878881L;
    public static final String FIELD_TYPE = "upload_session";
    public static final String FIELD_TOTAL_PARTS = "total_parts";
    public static final String FIELD_NUM_PARTS_PROCESSED = "num_parts_processed";
    public static final String FIELD_PART_SIZE = "part_size";
    public static final String FIELD_SESSION_ENDPOINTS = "session_endpoints";
    public static final String FIELD_SESSION_EXPIRES_AT = "session_expires_at";
    private static final String FIELD_SHA1 = "fileSha1";
    private static final String FIELD_PARTS_SHA1 = "partsSha1";
    public static final String[] ALL_FIELDS = {FIELD_TYPE, "id", FIELD_TOTAL_PARTS, FIELD_NUM_PARTS_PROCESSED, FIELD_PART_SIZE, FIELD_SESSION_ENDPOINTS, FIELD_SESSION_EXPIRES_AT, FIELD_SHA1, FIELD_PARTS_SHA1};

    public BoxUploadSession() {
    }

    public BoxUploadSession(JsonObject jsonObject) {
        super(jsonObject);
    }

    public int getTotalParts() {
        return getPropertyAsInt(FIELD_TOTAL_PARTS).intValue();
    }

    public int getNumPartsProcessed() {
        return getPropertyAsInt(FIELD_NUM_PARTS_PROCESSED).intValue();
    }

    public int getPartSize() {
        return getPropertyAsInt(FIELD_PART_SIZE).intValue();
    }

    public BoxUploadSessionEndpoints getEndpoints() {
        return (BoxUploadSessionEndpoints) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUploadSessionEndpoints.class), FIELD_SESSION_ENDPOINTS);
    }

    public Date getExpiresAt() {
        return getPropertyAsDate(FIELD_SESSION_EXPIRES_AT);
    }

    public String getId() {
        return getPropertyAsString("id");
    }

    public void setSha1(String str) {
        set(FIELD_SHA1, str);
    }

    public String getSha1() {
        return getPropertyAsString(FIELD_SHA1);
    }

    public void setPartsSha1(List<String> list) {
        JsonArray jsonArray = new JsonArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next());
        }
        set(FIELD_PARTS_SHA1, jsonArray);
    }

    public ArrayList<String> getFieldPartsSha1() {
        return getPropertyAsStringArray(FIELD_PARTS_SHA1);
    }

    public static int getChunkSize(BoxUploadSession boxUploadSession, int i, long j) {
        if (i == boxUploadSession.getTotalParts() - 1) {
            return (int) (j - ((long) (i * boxUploadSession.getPartSize())));
        }
        return boxUploadSession.getPartSize();
    }
}
