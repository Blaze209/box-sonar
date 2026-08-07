package com.box.androidsdk.content.models;

import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxJsonObject extends BoxObject {
    private static final long serialVersionUID = 7174936367401884790L;
    private CacheMap mCacheMap;

    public interface BoxJsonObjectCreator<E extends BoxJsonObject> {
        E createFromJsonObject(JsonObject jsonObject);
    }

    @Deprecated
    protected void parseJSONMember(JsonObject.Member member) {
    }

    protected BoxJsonObject() {
        createFromJson(new JsonObject());
    }

    protected BoxJsonObject(JsonObject jsonObject) {
        createFromJson(jsonObject);
    }

    public void createFromJson(String str) {
        createFromJson(JsonObject.readFrom(str));
    }

    public void createFromJson(JsonObject jsonObject) {
        this.mCacheMap = new CacheMap(jsonObject);
    }

    public JsonObject toJsonObject() {
        return JsonObject.readFrom(toJson());
    }

    public String toJson() {
        return this.mCacheMap.toJson();
    }

    public JsonValue getPropertyValue(String str) {
        JsonValue asJsonValue = this.mCacheMap.getAsJsonValue(str);
        if (asJsonValue == null) {
            return null;
        }
        return JsonValue.readFrom(asJsonValue.toString());
    }

    public List<String> getPropertiesKeySet() {
        return this.mCacheMap.getPropertiesKeySet();
    }

    protected String getPropertyAsString(String str) {
        return this.mCacheMap.getAsString(str);
    }

    protected void set(String str, String str2) {
        this.mCacheMap.set(str, str2);
    }

    protected Boolean getPropertyAsBoolean(String str) {
        return this.mCacheMap.getAsBoolean(str);
    }

    protected void set(String str, Boolean bool) {
        this.mCacheMap.set(str, bool.booleanValue());
    }

    protected Date getPropertyAsDate(String str) {
        return this.mCacheMap.getAsDate(str);
    }

    protected Double getPropertyAsDouble(String str) {
        return this.mCacheMap.getAsDouble(str);
    }

    protected void set(String str, Double d) {
        this.mCacheMap.set(str, d);
    }

    protected Float getPropertyAsFloat(String str) {
        return this.mCacheMap.getAsFloat(str);
    }

    protected void set(String str, Float f) {
        this.mCacheMap.set(str, f);
    }

    protected Integer getPropertyAsInt(String str) {
        return this.mCacheMap.getAsInt(str);
    }

    protected void set(String str, Integer num) {
        this.mCacheMap.set(str, num);
    }

    protected Long getPropertyAsLong(String str) {
        if (this.mCacheMap.getAsDouble(str) == null) {
            return null;
        }
        return Long.valueOf(this.mCacheMap.getAsDouble(str).longValue());
    }

    protected void set(String str, Long l) {
        this.mCacheMap.set(str, l);
    }

    protected JsonArray getPropertyAsJsonArray(String str) {
        return this.mCacheMap.getAsJsonArray(str);
    }

    protected void set(String str, JsonArray jsonArray) {
        this.mCacheMap.set(str, jsonArray);
    }

    protected void addInJsonArray(String str, JsonObject jsonObject) {
        this.mCacheMap.addInJsonArray(str, jsonObject);
    }

    protected void addInJsonArray(String str, BoxJsonObject boxJsonObject) {
        this.mCacheMap.addInJsonArray(str, boxJsonObject);
    }

    protected HashSet<String> getPropertyAsStringHashSet(String str) {
        return this.mCacheMap.getPropertyAsStringHashSet(str);
    }

    protected ArrayList<String> getPropertyAsStringArray(String str) {
        return this.mCacheMap.getAsStringArray(str);
    }

    protected <T extends BoxJsonObject> ArrayList<T> getPropertyAsJsonObjectArray(BoxJsonObjectCreator<T> boxJsonObjectCreator, String str) {
        return this.mCacheMap.getAsJsonObjectArray(boxJsonObjectCreator, str);
    }

    protected <T extends BoxJsonObject> T getPropertyAsJsonObject(BoxJsonObjectCreator<T> boxJsonObjectCreator, String str) {
        return (T) this.mCacheMap.getAsJsonObject(boxJsonObjectCreator, str);
    }

    protected boolean remove(String str) {
        return this.mCacheMap.remove(str);
    }

    protected void set(String str, JsonObject jsonObject) {
        this.mCacheMap.set(str, jsonObject);
    }

    protected void set(String str, BoxJsonObject boxJsonObject) {
        this.mCacheMap.set(str, boxJsonObject);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(objectOutputStream));
        this.mCacheMap.writeTo(bufferedWriter);
        bufferedWriter.flush();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        createFromJson(JsonObject.readFrom((Reader) new BufferedReader(new InputStreamReader(objectInputStream))));
    }

    public static <T extends BoxJsonObject> BoxJsonObjectCreator<T> getBoxJsonObjectCreator(final Class<T> cls) {
        return (BoxJsonObjectCreator<T>) new BoxJsonObjectCreator<T>() { // from class: com.box.androidsdk.content.models.BoxJsonObject.1
            /* JADX WARN: Incorrect return type in method signature: (Lcom/eclipsesource/json/JsonObject;)TT; */
            @Override // com.box.androidsdk.content.models.BoxJsonObject.BoxJsonObjectCreator
            public BoxJsonObject createFromJsonObject(JsonObject jsonObject) {
                try {
                    BoxJsonObject boxJsonObject = (BoxJsonObject) cls.newInstance();
                    boxJsonObject.createFromJson(jsonObject);
                    return boxJsonObject;
                } catch (IllegalAccessException e) {
                    BoxLogUtils.e("BoxJsonObject", "getBoxJsonObjectCreator " + cls, e);
                    return null;
                } catch (InstantiationException e2) {
                    BoxLogUtils.e("BoxJsonObject", "getBoxJsonObjectCreator " + cls, e2);
                    return null;
                }
            }
        };
    }

    public boolean equals(Object obj) {
        if (obj instanceof BoxJsonObject) {
            return this.mCacheMap.equals(((BoxJsonObject) obj).mCacheMap);
        }
        return false;
    }

    JsonObject getOriginalJsonObject() {
        return this.mCacheMap.getAsJsonObject();
    }

    public int hashCode() {
        return this.mCacheMap.hashCode();
    }

    class CacheMap implements Serializable {
        private transient HashMap<String, Object> mInternalCache = new LinkedHashMap();
        private JsonObject mJsonObject;

        public CacheMap(JsonObject jsonObject) {
            this.mJsonObject = jsonObject;
        }

        public int hashCode() {
            return this.mJsonObject.hashCode();
        }

        public boolean equals(Object obj) {
            return this.mJsonObject.equals(((CacheMap) obj).mJsonObject);
        }

        public String toJson() {
            return this.mJsonObject.toString();
        }

        public List<String> getPropertiesKeySet() {
            return this.mJsonObject.names();
        }

        public String getAsString(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return asJsonValue.asString();
        }

        public void set(String str, String str2) {
            this.mJsonObject.set(str, str2);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public Boolean getAsBoolean(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null) {
                return null;
            }
            return Boolean.valueOf(asJsonValue.asBoolean());
        }

        public void set(String str, boolean z) {
            this.mJsonObject.set(str, z);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public Date getAsDate(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue != null && !asJsonValue.isNull()) {
                Date date = (Date) this.mInternalCache.get(str);
                if (date != null) {
                    return date;
                }
                try {
                    Date date2 = BoxDateFormat.parse(asJsonValue.asString());
                    this.mInternalCache.put(str, date2);
                    return date2;
                } catch (ParseException e) {
                    BoxLogUtils.e("BoxJsonObject", "getAsDate", e);
                }
            }
            return null;
        }

        public Double getAsDouble(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return Double.valueOf(asJsonValue.asDouble());
        }

        public void set(String str, Double d) {
            this.mJsonObject.set(str, d.doubleValue());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public Float getAsFloat(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return Float.valueOf(asJsonValue.asFloat());
        }

        public void set(String str, Float f) {
            this.mJsonObject.set(str, f.floatValue());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public Integer getAsInt(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return Integer.valueOf(asJsonValue.asInt());
        }

        public void set(String str, Integer num) {
            this.mJsonObject.set(str, num.intValue());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public Long getAsLong(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return Long.valueOf(asJsonValue.asLong());
        }

        public void set(String str, Long l) {
            this.mJsonObject.set(str, l.longValue());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public JsonArray getAsJsonArray(String str) {
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            return asJsonValue.asArray();
        }

        public void set(String str, JsonArray jsonArray) {
            this.mJsonObject.set(str, jsonArray);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public void addInJsonArray(String str, JsonObject jsonObject) {
            getAsJsonArray(str).add(jsonObject);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public void addInJsonArray(String str, BoxJsonObject boxJsonObject) {
            getAsJsonArray(str).add(boxJsonObject.toJsonObject());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public HashSet<String> getPropertyAsStringHashSet(String str) {
            if (this.mInternalCache.get(str) != null) {
                return (HashSet) this.mInternalCache.get(str);
            }
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            HashSet<String> hashSet = new HashSet<>(asJsonValue.asArray().size());
            Iterator<JsonValue> it = asJsonValue.asArray().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().asString());
            }
            this.mInternalCache.put(str, hashSet);
            return hashSet;
        }

        public ArrayList<String> getAsStringArray(String str) {
            if (this.mInternalCache.get(str) != null) {
                return (ArrayList) this.mInternalCache.get(str);
            }
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(asJsonValue.asArray().size());
            Iterator<JsonValue> it = asJsonValue.asArray().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().asString());
            }
            this.mInternalCache.put(str, arrayList);
            return arrayList;
        }

        public <T extends BoxJsonObject> ArrayList<T> getAsJsonObjectArray(BoxJsonObjectCreator<T> boxJsonObjectCreator, String str) {
            if (this.mInternalCache.get(str) != null) {
                return (ArrayList) this.mInternalCache.get(str);
            }
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue != null && !asJsonValue.isArray() && asJsonValue.isObject()) {
                MAMEnrolledIdentitiesCache.CacheEntry.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList(1);
                anonymousClass1.add(boxJsonObjectCreator.createFromJsonObject(asJsonValue.asObject()));
                this.mInternalCache.put(str, anonymousClass1);
                return anonymousClass1;
            }
            JsonArray asJsonArray = getAsJsonArray(str);
            if (asJsonArray == null) {
                return null;
            }
            MAMEnrolledIdentitiesCache.CacheEntry.AnonymousClass1 anonymousClass2 = (ArrayList<T>) new ArrayList(asJsonArray.size());
            if (asJsonArray != null) {
                Iterator<JsonValue> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    anonymousClass2.add(boxJsonObjectCreator.createFromJsonObject(it.next().asObject()));
                }
            }
            this.mInternalCache.put(str, anonymousClass2);
            return anonymousClass2;
        }

        public <T extends BoxJsonObject> T getAsJsonObject(BoxJsonObjectCreator<T> boxJsonObjectCreator, String str) {
            if (this.mInternalCache.get(str) != null) {
                return (T) this.mInternalCache.get(str);
            }
            JsonValue asJsonValue = getAsJsonValue(str);
            if (asJsonValue == null || asJsonValue.isNull() || !asJsonValue.isObject()) {
                return null;
            }
            T t = (T) boxJsonObjectCreator.createFromJsonObject(asJsonValue.asObject());
            this.mInternalCache.put(str, t);
            return t;
        }

        public void set(String str, JsonObject jsonObject) {
            this.mJsonObject.set(str, jsonObject);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public void set(String str, BoxJsonObject boxJsonObject) {
            this.mJsonObject.set(str, boxJsonObject.toJsonObject());
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
        }

        public void writeTo(Writer writer) throws IOException {
            this.mJsonObject.writeTo(writer);
        }

        public boolean remove(String str) {
            boolean z = getAsJsonValue(str) != null;
            this.mJsonObject.remove(str);
            if (this.mInternalCache.containsKey(str)) {
                this.mInternalCache.remove(str);
            }
            return z;
        }

        public JsonValue getAsJsonValue(String str) {
            JsonObject jsonObject = this.mJsonObject;
            if (jsonObject == null) {
                return null;
            }
            return jsonObject.get(str);
        }

        public JsonObject getAsJsonObject() {
            return this.mJsonObject;
        }
    }
}
