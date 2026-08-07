package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessengerBus.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/margelo/nitro/boxcontext/MessengerEvent;", "", "recipientId", "", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "content", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRecipientId", "()Ljava/lang/String;", "getTopic", "getContent", "getStatus", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MessengerEvent {
    private final String content;
    private final String recipientId;
    private final String status;
    private final String topic;

    public static /* synthetic */ MessengerEvent copy$default(MessengerEvent messengerEvent, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messengerEvent.recipientId;
        }
        if ((i & 2) != 0) {
            str2 = messengerEvent.topic;
        }
        if ((i & 4) != 0) {
            str3 = messengerEvent.content;
        }
        if ((i & 8) != 0) {
            str4 = messengerEvent.status;
        }
        return messengerEvent.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRecipientId() {
        return this.recipientId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MessengerEvent copy(String recipientId, String topic, String content, String status) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(status, "status");
        return new MessengerEvent(recipientId, topic, content, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessengerEvent)) {
            return false;
        }
        MessengerEvent messengerEvent = (MessengerEvent) other;
        return Intrinsics.areEqual(this.recipientId, messengerEvent.recipientId) && Intrinsics.areEqual(this.topic, messengerEvent.topic) && Intrinsics.areEqual(this.content, messengerEvent.content) && Intrinsics.areEqual(this.status, messengerEvent.status);
    }

    public int hashCode() {
        return (((((this.recipientId.hashCode() * 31) + this.topic.hashCode()) * 31) + this.content.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "MessengerEvent(recipientId=" + this.recipientId + ", topic=" + this.topic + ", content=" + this.content + ", status=" + this.status + ")";
    }

    public MessengerEvent(String recipientId, String topic, String content, String status) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(status, "status");
        this.recipientId = recipientId;
        this.topic = topic;
        this.content = content;
        this.status = status;
    }

    public final String getRecipientId() {
        return this.recipientId;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getContent() {
        return this.content;
    }

    public /* synthetic */ MessengerEvent(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? MessengerBus.STATUS_OK : str4);
    }

    public final String getStatus() {
        return this.status;
    }
}
