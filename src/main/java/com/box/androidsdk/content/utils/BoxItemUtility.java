package com.box.androidsdk.content.utils;

import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxUser;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxItemUtility {
    private static final String CAPTURE_FOLDER = "Capture_folder";
    private static final String FAUX_FOLDER = "Faux_folder";

    public static BoxFolder getItemParentFolder(BoxItem boxItem) {
        BoxIterator<BoxFolder> pathCollection;
        if (boxItem == null) {
            return null;
        }
        BoxFolder parent = boxItem.getParent();
        return (parent != null || (pathCollection = boxItem.getPathCollection()) == null || pathCollection.size() <= 0) ? parent : (BoxFolder) pathCollection.get(pathCollection.size() - 1);
    }

    public static boolean isSharedWithMe(BoxCollaborationItem boxCollaborationItem, BoxUser boxUser) {
        return (boxCollaborationItem == null || boxUser == null || boxCollaborationItem.getOwnedBy().getUserId().equals(boxUser.getUserId())) ? false : true;
    }

    public static BoxFolder copyFolderWithNoItems(BoxFolder boxFolder) {
        JsonObject jsonObject = new JsonObject();
        for (String str : boxFolder.getPropertiesKeySet()) {
            if (!str.equals(BoxFolder.FIELD_ITEM_COLLECTION)) {
                jsonObject.add(str, boxFolder.getPropertyValue(str));
            } else {
                JsonObject jsonObject2 = new JsonObject();
                BoxIteratorItems itemCollection = boxFolder.getItemCollection();
                for (String str2 : itemCollection.getPropertiesKeySet()) {
                    if (!str2.equals("entries")) {
                        jsonObject2.add(str2, itemCollection.getPropertyValue(str2));
                    } else {
                        jsonObject2.add(str2, new JsonArray());
                    }
                }
                jsonObject.add(str, jsonObject2);
            }
        }
        return new BoxFolder(jsonObject);
    }

    public static class BoxModifiableIterator {
        final BoxIterator mBoxIterator;
        final JsonObject mJsonObject;

        public BoxModifiableIterator(BoxIterator boxIterator) {
            this.mBoxIterator = boxIterator;
            JsonObject jsonObject = boxIterator.toJsonObject();
            this.mJsonObject = jsonObject;
            jsonObject.set("entries", new JsonArray());
        }

        public void add(BoxJsonObject boxJsonObject) {
            this.mJsonObject.get("entries").asArray().add(boxJsonObject.toJsonObject());
        }

        public void add(JsonObject jsonObject) {
            this.mJsonObject.get("entries").asArray().add(jsonObject);
        }

        public BoxIterator build() {
            this.mBoxIterator.createFromJson(this.mJsonObject);
            return this.mBoxIterator;
        }

        public JsonObject getJsonObject() {
            return this.mJsonObject;
        }
    }

    public static String getFauxFolderName(BoxFile boxFile) {
        return boxFile.getUserId() + FAUX_FOLDER;
    }

    public static boolean isFauxFolder(BoxFolder boxFolder) {
        return (boxFolder == null || boxFolder.getUserId() == null || !boxFolder.getUserId().endsWith(FAUX_FOLDER)) ? false : true;
    }

    public static String getCaptureHistoryFolderName(BoxFile boxFile) {
        return boxFile.getUserId() + CAPTURE_FOLDER;
    }

    public static boolean isCaptureFolder(BoxFolder boxFolder) {
        return (boxFolder == null || boxFolder.getUserId() == null || !boxFolder.getUserId().endsWith(CAPTURE_FOLDER)) ? false : true;
    }
}
