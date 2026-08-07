package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestCreateBoxNote extends BoxRequestItem<BoxNoteCreation, BoxRequestCreateBoxNote> {
    public static final String FIELD_FILE_NAME = "file_name";
    public static final String FIELD_FOLDER_ID = "folder_id";
    public static final String URI_PATH = "document/boxnote/new";

    public BoxRequestCreateBoxNote(String str, BoxSession boxSession, String str2, String str3) {
        super(BoxNoteCreation.class, str2, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mQueryMap.put("folder_id", str2);
        this.mQueryMap.put(FIELD_FILE_NAME, str3);
    }

    public static String getCompleteUri(String str) {
        return str + URI_PATH;
    }

    public String getFileName() {
        return this.mQueryMap.get(FIELD_FILE_NAME);
    }

    public String getFolderId() {
        return this.mQueryMap.get("folder_id");
    }

    protected String getRequestUrl() {
        return this.mRequestUrlString;
    }
}
