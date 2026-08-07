package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public interface GeneralInfoDao {
    GeneralInfoEntity getByName(String name);

    void update(GeneralInfoEntity info);
}
