package com.microsoft.identity.common.java.dto;

import com.google.gson.JsonElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AccountCredentialBase implements Cloneable {
    private transient Map<String, JsonElement> mAdditionalFields = Collections.synchronizedMap(new HashMap());

    public Map<String, JsonElement> getAdditionalFields() {
        return this.mAdditionalFields;
    }

    public void setAdditionalFields(Map<String, JsonElement> map) {
        if (map == null) {
            throw new NullPointerException("additionalFields is marked non-null but is null");
        }
        this.mAdditionalFields = Collections.synchronizedMap(map);
    }

    public void mergeAdditionalFields(AccountCredentialBase accountCredentialBase) {
        if (accountCredentialBase == null) {
            throw new NullPointerException("other is marked non-null but is null");
        }
        if (this.mAdditionalFields == null) {
            this.mAdditionalFields = Collections.synchronizedMap(new HashMap());
        }
        if (accountCredentialBase.getAdditionalFields() != null) {
            for (Map.Entry<String, JsonElement> entry : accountCredentialBase.getAdditionalFields().entrySet()) {
                if (!this.mAdditionalFields.containsKey(entry.getKey())) {
                    this.mAdditionalFields.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AccountCredentialBase m13856clone() throws CloneNotSupportedException {
        AccountCredentialBase accountCredentialBase = (AccountCredentialBase) super.clone();
        accountCredentialBase.setAdditionalFields(new HashMap(this.mAdditionalFields));
        return accountCredentialBase;
    }

    public String toString() {
        return "AccountCredentialBase{mAdditionalFields=" + this.mAdditionalFields + AbstractJsonLexerKt.END_OBJ;
    }
}
