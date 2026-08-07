package com.microsoft.identity.common.java;

import com.microsoft.identity.common.java.dto.IAccountRecord;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseAccount implements IAccountRecord {
    public abstract List<String> getCacheIdentifiers();

    public abstract String getUniqueIdentifier();
}
