package com.box.android.coreservices.jobmanager.dao;

import com.box.androidsdk.content.models.BoxEntity;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalFileData extends BoxEntity {
    private static final String FIELD_LAST_MODIFIED_DATE = "lastModifiedDate";
    private static final String FIELD_PATH = "path";
    private static final String FIELD_SHA_1 = "sha1";
    private static final String FIELD_SIZE = "size";
    public static final String TYPE = "local_file_data";
    private static final long serialVersionUID = 1;

    public BoxLocalFileData() {
    }

    public BoxLocalFileData(String str, String str2, long j, long j2) {
        set("type", TYPE);
        setPath(str);
        setSha1(str2);
        setLastModifiedDate(Long.valueOf(j));
        setSize(Long.valueOf(j2));
    }

    public String getPath() {
        return getPropertyAsString("path");
    }

    private void setPath(String str) {
        set("path", str);
    }

    public String getSha1() {
        return getPropertyAsString("sha1");
    }

    private void setSha1(String str) {
        set("sha1", str);
    }

    public Long getLastModifiedDate() {
        return getPropertyAsLong(FIELD_LAST_MODIFIED_DATE);
    }

    private void setLastModifiedDate(Long l) {
        set(FIELD_LAST_MODIFIED_DATE, l);
    }

    public Long getSize() {
        return getPropertyAsLong("size");
    }

    private void setSize(Long l) {
        set("size", l);
    }

    public boolean isConsistentWith(File file) {
        return file.lastModified() == getLastModifiedDate().longValue() && file.length() == getSize().longValue();
    }
}
