package io.split.android.client.storage.attributes;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesEntity;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentAttributesStorage implements PersistentAttributesStorage {
    private static final Type ATTRIBUTES_MAP_TYPE = new TypeToken<Map<String, Object>>() { // from class: io.split.android.client.storage.attributes.SqLitePersistentAttributesStorage.1
    }.getType();
    private final AttributesDao mAttributesDao;
    private final SplitCipher mSplitCipher;

    public SqLitePersistentAttributesStorage(AttributesDao attributesDao, SplitCipher splitCipher) {
        this.mAttributesDao = (AttributesDao) Utils.checkNotNull(attributesDao);
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public void set(String matchingKey, Map<String, Object> attributes) {
        if (attributes == null) {
            return;
        }
        String strEncrypt = this.mSplitCipher.encrypt(matchingKey);
        String strEncrypt2 = this.mSplitCipher.encrypt(Json.toJson(attributes));
        if (strEncrypt2 != null) {
            this.mAttributesDao.update(new AttributesEntity(strEncrypt, strEncrypt2, System.currentTimeMillis() / 1000));
        } else {
            Logger.e("Error encrypting attributes");
        }
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public Map<String, Object> getAll(String matchingKey) {
        return getAttributesMapFromEntity(this.mAttributesDao.getByUserKey(this.mSplitCipher.encrypt(matchingKey)));
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public void clear(String matchingKey) {
        this.mAttributesDao.deleteAll(matchingKey);
    }

    private Map<String, Object> getAttributesMapFromEntity(AttributesEntity attributesEntity) {
        HashMap map = new HashMap();
        if (attributesEntity != null) {
            try {
                return Json.genericValueMapFromJson(this.mSplitCipher.decrypt(attributesEntity.getAttributes()), ATTRIBUTES_MAP_TYPE);
            } catch (JsonSyntaxException e) {
                Logger.e(e);
            }
        }
        return map;
    }
}
