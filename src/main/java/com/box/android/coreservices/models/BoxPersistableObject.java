package com.box.android.coreservices.models;

import com.box.android.domain.models.IBoxPersistableObject;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class BoxPersistableObject extends BoxObject implements IBoxPersistableObject {
    public static final String FIELD_ID = "id";
    public static final String FIELD_ITEM_ID = "item_id";
    public static final String FIELD_ITEM_TYPE = "item_type";
    public static final String FIELD_TYPE = "type";
    private static final long serialVersionUID = 1626798809346520004L;
    protected final Map<String, Object> mProperties;

    public interface BoxPersistableEntityCreator {
        BoxPersistableObject createEntity();
    }

    public BoxPersistableObject() {
        this.mProperties = Collections.synchronizedMap(new LinkedHashMap());
    }

    public BoxPersistableObject(Map<String, Object> map) {
        this.mProperties = Collections.synchronizedMap(new LinkedHashMap(map));
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public void put(String str, Object obj) {
        this.mProperties.put(str, obj);
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public Object get(String str) {
        return this.mProperties.get(str);
    }

    public String getId() {
        String str = (String) this.mProperties.get("id");
        return str == null ? (String) this.mProperties.get("item_id") : str;
    }

    public String getType() {
        String str = (String) this.mProperties.get("type");
        return str == null ? (String) this.mProperties.get("item_type") : str;
    }

    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("id")) {
            this.mProperties.put("id", value.asString());
            return;
        }
        if (name.equals("type")) {
            this.mProperties.put("type", value.asString());
            return;
        }
        if (name.equals("item_type")) {
            this.mProperties.put("item_type", value.asString());
            return;
        }
        if (name.equals("item_id")) {
            this.mProperties.put("item_id", value.asString());
        } else {
            if (!(this instanceof BoxPersistableObject)) {
                throw new RuntimeException("unhandled json member '" + name + "' xxx  " + value + " current object " + getClass());
            }
            try {
                this.mProperties.put(name, parseJSONMember(value));
            } catch (UnsupportedOperationException unused) {
                this.mProperties.put(name, value.toString());
            }
        }
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public void createFromJson(String str) {
        createFromJson(JsonObject.readFrom(str));
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public void createFromJson(JsonObject jsonObject) {
        for (JsonObject.Member member : jsonObject) {
            if (member.getValue().isNull()) {
                parseNullJsonMember(member);
            } else {
                parseJSONMember(member);
            }
        }
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public void parseNullJsonMember(JsonObject.Member member) {
        if (SdkUtils.isEmptyString(member.getName())) {
            return;
        }
        this.mProperties.put(member.getName(), null);
    }

    private Object parseJSONMember(JsonValue jsonValue) {
        if (jsonValue.isArray()) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = jsonValue.asArray().iterator();
            while (it.hasNext()) {
                arrayList.add(parseJSONMember(it.next()));
            }
            return arrayList;
        }
        if (jsonValue.isBoolean()) {
            return Boolean.valueOf(jsonValue.asBoolean());
        }
        if (jsonValue.isNumber()) {
            return Long.valueOf(jsonValue.asLong());
        }
        if (jsonValue.isObject()) {
            return jsonValue.asObject();
        }
        if (jsonValue.isString()) {
            return jsonValue.asString();
        }
        jsonValue.isNull();
        return null;
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public String toJson() {
        return toJsonObject().toString();
    }

    protected JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        for (String str : this.mProperties.keySet()) {
            jsonObject.add(str, parseJsonObject(this.mProperties.get(str)));
        }
        return jsonObject;
    }

    protected JsonValue parseJsonObject(Map.Entry<String, Object> entry) {
        return parseJsonObject(entry.getValue());
    }

    private JsonValue parseJsonObject(Object obj) {
        if (obj instanceof BoxPersistableObject) {
            return ((BoxPersistableObject) obj).toJsonObject();
        }
        if (obj instanceof BoxJsonObject) {
            return ((BoxJsonObject) obj).toJsonObject();
        }
        if (obj instanceof Integer) {
            return JsonValue.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return JsonValue.valueOf(((Long) obj).longValue());
        }
        if (obj instanceof Float) {
            return JsonValue.valueOf(((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            return JsonValue.valueOf(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return JsonValue.valueOf(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Enum) {
            return JsonValue.valueOf(obj.toString());
        }
        if (obj instanceof Date) {
            return JsonValue.valueOf(BoxDateFormat.format((Date) obj));
        }
        if (obj instanceof String) {
            return JsonValue.valueOf((String) obj);
        }
        return obj instanceof Collection ? parseJsonArray((Collection) obj) : JsonValue.valueOf((String) null);
    }

    private JsonArray parseJsonArray(Collection collection) {
        JsonArray jsonArray = new JsonArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            jsonArray.add(parseJsonObject(it.next()));
        }
        return jsonArray;
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public Set<String> getPropertiesKeySet() {
        return this.mProperties.keySet();
    }

    @Override // com.box.android.domain.models.IBoxPersistableObject
    public Object getPropertyValue(String str) {
        return this.mProperties.get(str);
    }
}
