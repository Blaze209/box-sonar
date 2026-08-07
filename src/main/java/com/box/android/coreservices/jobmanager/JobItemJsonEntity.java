package com.box.android.coreservices.jobmanager;

import android.util.Log;
import android.util.Pair;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.models.BoxPersistableObject;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/* JADX INFO: loaded from: classes9.dex */
public class JobItemJsonEntity extends BoxPersistableObject {
    public static final String ID = "id";
    public static final String SCHEME = "jobitem";
    public static final String TYPE = "type";
    private transient IKeyValueStore mKVStore;

    public static class TypedId extends Pair<String, String> {
        public TypedId(String str, String str2) {
            super(str, str2);
        }

        public String getType() {
            return (String) this.first;
        }

        public String getId() {
            return (String) this.second;
        }

        public static TypedId splitTypeAndIdFromTypedId(String str) {
            String[] strArrSplit = str.split(",");
            return new TypedId(strArrSplit[0], strArrSplit[1]);
        }
    }

    public JobItemJsonEntity() {
    }

    public JobItemJsonEntity(String str, String str2) {
        setType(str);
        setId(str2);
    }

    public void init(IKeyValueStore iKeyValueStore) {
        this.mKVStore = iKeyValueStore;
    }

    @Override // com.box.android.coreservices.models.BoxPersistableObject, com.box.android.domain.models.IBoxPersistableObject
    public String getType() {
        return (String) this.mProperties.get("type");
    }

    public void setType(String str) {
        this.mProperties.put("type", str);
    }

    @Override // com.box.android.coreservices.models.BoxPersistableObject, com.box.android.domain.models.IBoxPersistableObject
    public String getId() {
        return (String) this.mProperties.get("id");
    }

    public void setId(String str) {
        this.mProperties.put("id", str);
    }

    @Override // com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("type")) {
            setType(value.asString());
        } else if (name.equals("id")) {
            setId(value.asString());
        } else {
            super.parseJSONMember(member);
        }
    }

    public String getKeyNamerKey(IKeyValueStore.KeyNamer keyNamer) {
        return keyNamer.getKey(SCHEME, getType(), getId());
    }

    public void saveToLevelDB() {
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            Log.i("JobItemJsonEntity", "Level DB putting key " + getKeyNamerKey(this.mKVStore.keyNamer()) + " with val: " + toJson());
        }
        IKeyValueStore iKeyValueStore = this.mKVStore;
        iKeyValueStore.put(getKeyNamerKey(iKeyValueStore.keyNamer()), toJson());
    }

    public void deleteFromLevelDB() {
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            Log.i("LevelDB", "deleting item with key " + getKeyNamerKey(this.mKVStore.keyNamer()));
        }
        IKeyValueStore iKeyValueStore = this.mKVStore;
        iKeyValueStore.delete(getKeyNamerKey(iKeyValueStore.keyNamer()));
    }

    public String getTypedId() {
        return getType() + "," + getId();
    }
}
