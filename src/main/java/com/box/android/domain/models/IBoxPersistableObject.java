package com.box.android.domain.models;

import com.eclipsesource.json.JsonObject;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public interface IBoxPersistableObject {
    void createFromJson(JsonObject jsonObject);

    void createFromJson(String str);

    Object get(String str);

    String getId();

    Set<String> getPropertiesKeySet();

    Object getPropertyValue(String str);

    String getType();

    void parseNullJsonMember(JsonObject.Member member);

    void put(String str, Object obj);

    String toJson();
}
