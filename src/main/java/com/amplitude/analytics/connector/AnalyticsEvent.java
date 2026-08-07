package com.amplitude.analytics.connector;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventBridge.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J#\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0005HÆ\u0003JO\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/amplitude/analytics/connector/AnalyticsEvent;", "", "eventType", "", "eventProperties", "", "userProperties", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getEventProperties", "()Ljava/util/Map;", "getEventType", "()Ljava/lang/String;", "getUserProperties", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "analytics-connector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class AnalyticsEvent {
    private final Map<String, Object> eventProperties;
    private final String eventType;
    private final Map<String, Map<String, Object>> userProperties;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnalyticsEvent copy$default(AnalyticsEvent analyticsEvent, String str, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analyticsEvent.eventType;
        }
        if ((i & 2) != 0) {
            map = analyticsEvent.eventProperties;
        }
        if ((i & 4) != 0) {
            map2 = analyticsEvent.userProperties;
        }
        return analyticsEvent.copy(str, map, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> component2() {
        return this.eventProperties;
    }

    public final Map<String, Map<String, Object>> component3() {
        return this.userProperties;
    }

    public final AnalyticsEvent copy(String eventType, Map<String, ? extends Object> eventProperties, Map<String, ? extends Map<String, ? extends Object>> userProperties) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return new AnalyticsEvent(eventType, eventProperties, userProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyticsEvent)) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) other;
        return Intrinsics.areEqual(this.eventType, analyticsEvent.eventType) && Intrinsics.areEqual(this.eventProperties, analyticsEvent.eventProperties) && Intrinsics.areEqual(this.userProperties, analyticsEvent.userProperties);
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Map<String, Object> map = this.eventProperties;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Map<String, Object>> map2 = this.userProperties;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "AnalyticsEvent(eventType=" + this.eventType + ", eventProperties=" + this.eventProperties + ", userProperties=" + this.userProperties + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnalyticsEvent(String eventType, Map<String, ? extends Object> map, Map<String, ? extends Map<String, ? extends Object>> map2) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.eventProperties = map;
        this.userProperties = map2;
    }

    public /* synthetic */ AnalyticsEvent(String str, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2);
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> getEventProperties() {
        return this.eventProperties;
    }

    public final Map<String, Map<String, Object>> getUserProperties() {
        return this.userProperties;
    }
}
