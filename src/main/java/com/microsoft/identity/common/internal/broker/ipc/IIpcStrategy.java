package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import kotlin.Metadata;

/* JADX INFO: compiled from: IIpcStrategy.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "", "communicateToBroker", "Landroid/os/Bundle;", "bundle", "Lcom/microsoft/identity/common/internal/broker/ipc/BrokerOperationBundle;", "getType", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "isSupportedByTargetedBroker", "", "targetedBrokerPackageName", "", "Type", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IIpcStrategy {
    Bundle communicateToBroker(BrokerOperationBundle bundle) throws BrokerCommunicationException;

    Type getType();

    boolean isSupportedByTargetedBroker(String targetedBrokerPackageName);

    /* JADX INFO: compiled from: IIpcStrategy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "BOUND_SERVICE", "ACCOUNT_MANAGER_ADD_ACCOUNT", "CONTENT_PROVIDER", "LEGACY_ACCOUNT_AUTHENTICATOR_FOR_WPJ_API", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Type {
        BOUND_SERVICE(TelemetryEventStrings.Value.BOUND_SERVICE),
        ACCOUNT_MANAGER_ADD_ACCOUNT("account_manager_add_account"),
        CONTENT_PROVIDER(TelemetryEventStrings.Value.CONTENT_PROVIDER),
        LEGACY_ACCOUNT_AUTHENTICATOR_FOR_WPJ_API("legacy_account_authenticator_for_wpj_api");

        private final String value;

        Type(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }
}
