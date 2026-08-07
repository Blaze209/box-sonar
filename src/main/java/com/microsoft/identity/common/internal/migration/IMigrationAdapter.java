package com.microsoft.identity.common.internal.migration;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IMigrationAdapter<T extends BaseAccount, U extends RefreshToken> {
    List<Map.Entry<T, U>> adapt(Map<String, String> map);
}
