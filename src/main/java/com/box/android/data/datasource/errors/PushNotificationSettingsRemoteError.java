package com.box.android.data.datasource.errors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/errors/PushNotificationSettingsRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "<init>", "(I)V", "DeviceAlreadyExists", "Lcom/box/android/data/datasource/errors/PushNotificationSettingsRemoteError$DeviceAlreadyExists;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PushNotificationSettingsRemoteError extends RemoteError {
    public /* synthetic */ PushNotificationSettingsRemoteError(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/PushNotificationSettingsRemoteError$DeviceAlreadyExists;", "Lcom/box/android/data/datasource/errors/PushNotificationSettingsRemoteError;", "deviceID", "", "<init>", "(Ljava/lang/String;)V", "getDeviceID", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DeviceAlreadyExists extends PushNotificationSettingsRemoteError {
        private final String deviceID;

        public static /* synthetic */ DeviceAlreadyExists copy$default(DeviceAlreadyExists deviceAlreadyExists, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceAlreadyExists.deviceID;
            }
            return deviceAlreadyExists.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceID() {
            return this.deviceID;
        }

        public final DeviceAlreadyExists copy(String deviceID) {
            Intrinsics.checkNotNullParameter(deviceID, "deviceID");
            return new DeviceAlreadyExists(deviceID);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceAlreadyExists) && Intrinsics.areEqual(this.deviceID, ((DeviceAlreadyExists) other).deviceID);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.deviceID.hashCode();
        }

        public String toString() {
            return "DeviceAlreadyExists(deviceID=" + this.deviceID + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceAlreadyExists(String deviceID) {
            super(409, null);
            Intrinsics.checkNotNullParameter(deviceID, "deviceID");
            this.deviceID = deviceID;
        }

        public final String getDeviceID() {
            return this.deviceID;
        }
    }

    private PushNotificationSettingsRemoteError(int i) {
        super(i, null, 2, null);
    }
}
