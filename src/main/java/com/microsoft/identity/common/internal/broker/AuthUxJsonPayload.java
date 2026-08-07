package com.microsoft.identity.common.internal.broker;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthUxJsonPayload.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxJsonPayload;", "", "correlationId", "", "actionName", "actionComponent", SerializedNames.PARAMS, "Lcom/microsoft/identity/common/internal/broker/AuthUxParams;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/common/internal/broker/AuthUxParams;)V", "getActionComponent", "()Ljava/lang/String;", "getActionName", "getCorrelationId", "getParams", "()Lcom/microsoft/identity/common/internal/broker/AuthUxParams;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthUxJsonPayload {
    private final String actionComponent;
    private final String actionName;
    private final String correlationId;
    private final AuthUxParams params;

    public static /* synthetic */ AuthUxJsonPayload copy$default(AuthUxJsonPayload authUxJsonPayload, String str, String str2, String str3, AuthUxParams authUxParams, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authUxJsonPayload.correlationId;
        }
        if ((i & 2) != 0) {
            str2 = authUxJsonPayload.actionName;
        }
        if ((i & 4) != 0) {
            str3 = authUxJsonPayload.actionComponent;
        }
        if ((i & 8) != 0) {
            authUxParams = authUxJsonPayload.params;
        }
        return authUxJsonPayload.copy(str, str2, str3, authUxParams);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCorrelationId() {
        return this.correlationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActionName() {
        return this.actionName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActionComponent() {
        return this.actionComponent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AuthUxParams getParams() {
        return this.params;
    }

    public final AuthUxJsonPayload copy(String correlationId, String actionName, String actionComponent, AuthUxParams params) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(actionComponent, "actionComponent");
        return new AuthUxJsonPayload(correlationId, actionName, actionComponent, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthUxJsonPayload)) {
            return false;
        }
        AuthUxJsonPayload authUxJsonPayload = (AuthUxJsonPayload) other;
        return Intrinsics.areEqual(this.correlationId, authUxJsonPayload.correlationId) && Intrinsics.areEqual(this.actionName, authUxJsonPayload.actionName) && Intrinsics.areEqual(this.actionComponent, authUxJsonPayload.actionComponent) && Intrinsics.areEqual(this.params, authUxJsonPayload.params);
    }

    public int hashCode() {
        int iHashCode = ((((this.correlationId.hashCode() * 31) + this.actionName.hashCode()) * 31) + this.actionComponent.hashCode()) * 31;
        AuthUxParams authUxParams = this.params;
        return iHashCode + (authUxParams == null ? 0 : authUxParams.hashCode());
    }

    public String toString() {
        return "AuthUxJsonPayload(correlationId=" + this.correlationId + ", actionName=" + this.actionName + ", actionComponent=" + this.actionComponent + ", params=" + this.params + ')';
    }

    public AuthUxJsonPayload(String correlationId, String actionName, String actionComponent, AuthUxParams authUxParams) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(actionComponent, "actionComponent");
        this.correlationId = correlationId;
        this.actionName = actionName;
        this.actionComponent = actionComponent;
        this.params = authUxParams;
    }

    public final String getCorrelationId() {
        return this.correlationId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getActionComponent() {
        return this.actionComponent;
    }

    public final AuthUxParams getParams() {
        return this.params;
    }
}
