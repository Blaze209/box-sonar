package com.microsoft.identity.common.java.commands;

import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public interface DeviceCodeFlowCommandCallback<T, U> extends CommandCallback<T, U> {
    void onUserCodeReceived(String str, String str2, String str3, Date date);
}
