package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public class BoxEntity extends BoxJsonObject {
    private static HashMap<String, BoxEntityCreator> ENTITY_ADDON_MAP = new HashMap<>();
    public static final String FIELD_ID = "id";
    public static final String FIELD_ITEM_ID = "item_id";
    public static final String FIELD_ITEM_TYPE = "item_type";
    public static final String FIELD_TYPE = "type";
    private static final long serialVersionUID = 1626798809346520004L;

    public interface BoxEntityCreator {
        BoxEntity createEntity();
    }

    static {
        addEntityType(BoxCollection.TYPE, new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.1
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxCollection();
            }
        });
        addEntityType("comment", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.2
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxComment();
            }
        });
        addEntityType(BoxCollaboration.TYPE, new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.3
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxCollaboration();
            }
        });
        addEntityType("enterprise", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.4
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxEnterprise();
            }
        });
        addEntityType("file_version", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.5
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxFileVersion();
            }
        });
        addEntityType("event", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.6
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxEvent();
            }
        });
        addEntityType("file", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.7
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxFile();
            }
        });
        addEntityType("folder", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.8
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxFolder();
            }
        });
        addEntityType(BoxBookmark.TYPE, new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.9
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxBookmark();
            }
        });
        addEntityType("user", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.10
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxUser();
            }
        });
        addEntityType("group", new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.11
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxGroup();
            }
        });
        addEntityType(BoxRealTimeServer.TYPE, new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.12
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxRealTimeServer();
            }
        });
        addEntityType(BoxSearchItem.TYPE, new BoxEntityCreator() { // from class: com.box.androidsdk.content.models.BoxEntity.13
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxSearchItem();
            }
        });
    }

    public BoxEntity() {
    }

    public BoxEntity(JsonObject jsonObject) {
        super(jsonObject);
    }

    /* JADX INFO: renamed from: getId */
    public String getUserId() {
        String propertyAsString = getPropertyAsString("id");
        return propertyAsString == null ? getPropertyAsString("item_id") : propertyAsString;
    }

    public String getType() {
        String propertyAsString = getPropertyAsString("type");
        return propertyAsString == null ? getPropertyAsString("item_type") : propertyAsString;
    }

    public static BoxEntity createEntityFromJson(String str) {
        return createEntityFromJson(JsonObject.readFrom(str));
    }

    public static BoxEntity createEntityFromJson(JsonObject jsonObject) {
        BoxEntity boxEntityCreateEntity;
        JsonValue jsonValue = jsonObject.get("type");
        if (!jsonValue.isString()) {
            return null;
        }
        BoxEntityCreator boxEntityCreator = ENTITY_ADDON_MAP.get(jsonValue.asString());
        if (boxEntityCreator == null) {
            boxEntityCreateEntity = new BoxEntity();
        } else {
            boxEntityCreateEntity = boxEntityCreator.createEntity();
        }
        boxEntityCreateEntity.createFromJson(jsonObject);
        return boxEntityCreateEntity;
    }

    public static void addEntityType(String str, BoxEntityCreator boxEntityCreator) {
        ENTITY_ADDON_MAP.put(str, boxEntityCreator);
    }

    public static BoxJsonObject.BoxJsonObjectCreator<BoxEntity> getBoxJsonObjectCreator() {
        return new BoxJsonObject.BoxJsonObjectCreator<BoxEntity>() { // from class: com.box.androidsdk.content.models.BoxEntity.14
            @Override // com.box.androidsdk.content.models.BoxJsonObject.BoxJsonObjectCreator
            public BoxEntity createFromJsonObject(JsonObject jsonObject) {
                return BoxEntity.createEntityFromJson(jsonObject);
            }
        };
    }
}
