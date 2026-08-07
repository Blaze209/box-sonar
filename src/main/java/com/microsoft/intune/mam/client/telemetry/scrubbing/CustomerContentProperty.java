package com.microsoft.intune.mam.client.telemetry.scrubbing;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CustomerContentProperty {
    List<CustomerContentType> getCustomerContentTypes();

    Enum getKey();
}
