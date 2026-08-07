package com.microsoft.identity.common.java.dto;

import com.amplitude.api.AmplitudeClient;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AadDeviceIdRecord.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/java/dto/AadDeviceIdRecord;", "", "tenantId", "", "deviceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getTenantId", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AadDeviceIdRecord {

    @SerializedName(AmplitudeClient.DEVICE_ID_KEY)
    private final String deviceId;

    @SerializedName("tenant_id")
    private final String tenantId;

    public AadDeviceIdRecord(String tenantId, String deviceId) {
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.tenantId = tenantId;
        this.deviceId = deviceId;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
