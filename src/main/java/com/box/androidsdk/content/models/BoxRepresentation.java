package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRepresentation extends BoxJsonObject {
    public static final String DIMENSION_1024 = "1024x1024";
    public static final String DIMENSION_160 = "160x160";
    public static final String DIMENSION_2048 = "2048x2048";
    public static final String DIMENSION_32 = "32x32";
    public static final String DIMENSION_320 = "320x320";
    public static final String DIMENSION_94 = "94x94";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_INFO = "info";
    public static final String FIELD_PROPERTIES = "properties";
    public static final String FIELD_REPRESENTATION = "representation";
    public static final String FIELD_STATUS = "status";
    public static final String REP_HINTS_HEADER = "x-rep-hints";
    public static final String TYPE_DASH = "dash";
    public static final String TYPE_FILMSTRIP = "filmstrip";
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_MP3 = "mp3";
    public static final String TYPE_MP4 = "mp4";
    public static final String TYPE_PDF = "pdf";
    public static final String TYPE_PNG = "png";
    public static final String TYPE_TEXT = "extracted_text";
    private static final long serialVersionUID = -4748896287486795L;

    public BoxRepresentation() {
    }

    public BoxRepresentation(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getRepresentationType() {
        return getPropertyAsString(FIELD_REPRESENTATION);
    }

    public BoxRepPropertiesMap getProperties() {
        return (BoxRepPropertiesMap) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxRepPropertiesMap.class), "properties");
    }

    public BoxRepStatus getStatus() {
        return (BoxRepStatus) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxRepStatus.class), "status");
    }

    public BoxEmbedLink getInfo() {
        return (BoxEmbedLink) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxEmbedLink.class), FIELD_INFO);
    }

    public BoxRepContent getContent() {
        return (BoxRepContent) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxRepContent.class), "content");
    }

    public static class BoxRepPropertiesMap extends BoxMap {
        public static final String FIELD_PROPERTIES_DIMENSIONS = "dimensions";
        public static final String FIELD_PROPERTIES_PAGED = "paged";
        public static final String FIELD_PROPERTIES_THUMB = "thumb";

        public boolean isPaged() {
            String propertyAsString = getPropertyAsString(FIELD_PROPERTIES_PAGED);
            return propertyAsString != null && propertyAsString.equals(Boolean.TRUE.toString());
        }

        public boolean isThumb() {
            String propertyAsString = getPropertyAsString(FIELD_PROPERTIES_THUMB);
            return propertyAsString != null && propertyAsString.equals(Boolean.TRUE.toString());
        }

        public String getDimension() {
            return getPropertyAsString(FIELD_PROPERTIES_DIMENSIONS);
        }
    }

    public static class BoxRepContent extends BoxJsonObject {
        public static final String ASSET_PATH_STRING = "{+asset_path}";
        public static final String FIELD_URL = "url_template";

        public String getUrl() {
            return getPropertyAsString(FIELD_URL);
        }
    }

    public static class BoxRepStatus extends BoxJsonObject {
        public static final String FIELD_STATE = "state";

        public String getState() {
            return getPropertyAsString("state");
        }
    }
}
