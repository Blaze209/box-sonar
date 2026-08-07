package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class BoxError extends BoxJsonObject {
    public static final String FIELD_CODE = "code";
    public static final String FIELD_CONTEXT_INFO = "context_info";
    public static final String FIELD_ERROR = "error";
    public static final String FIELD_ERROR_DESCRIPTION = "error_description";
    public static final String FIELD_HELP_URL = "help_url";
    public static final String FIELD_MESSAGE = "message";
    public static final String FIELD_REQUEST_ID = "request_id";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TYPE = "type";

    public BoxError() {
    }

    public BoxError(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getType() {
        return getPropertyAsString("type");
    }

    public Integer getStatus() {
        return getPropertyAsInt("status");
    }

    public String getCode() {
        return getPropertyAsString("code");
    }

    public ErrorContext getContextInfo() {
        return (ErrorContext) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(ErrorContext.class), "context_info");
    }

    public String getFieldHelpUrl() {
        return getPropertyAsString(FIELD_HELP_URL);
    }

    public String getMessage() {
        return getPropertyAsString("message");
    }

    public String getRequestId() {
        return getPropertyAsString(FIELD_REQUEST_ID);
    }

    public String getError() {
        String propertyAsString = getPropertyAsString("error");
        return propertyAsString == null ? getCode() : propertyAsString;
    }

    public String getErrorDescription() {
        return getPropertyAsString("error_description");
    }

    public static class ErrorContext extends BoxJsonObject {
        public static final String FIELD_CONFLICTING_PART = "conflicting_part";
        public static final String FIELD_CONFLICTS = "conflicts";

        public ArrayList<BoxEntity> getConflicts() {
            return getPropertyAsJsonObjectArray(BoxEntity.getBoxJsonObjectCreator(), "conflicts");
        }

        public BoxUploadSessionPart getConflictingPart() {
            return (BoxUploadSessionPart) getPropertyAsJsonObject(getBoxJsonObjectCreator(BoxUploadSessionPart.class), FIELD_CONFLICTING_PART);
        }
    }
}
