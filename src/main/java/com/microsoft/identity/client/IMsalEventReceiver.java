package com.microsoft.identity.client;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IMsalEventReceiver {
    void onEventsReceived(List<Map<String, String>> list);
}
