package com.microsoft.identity.client;

import java.io.Serializable;

/* JADX INFO: loaded from: classes14.dex */
public interface IAccount extends Serializable, IClaimable {
    String getAuthority();

    String getId();
}
