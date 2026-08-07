package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003JM\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/box/android/domain/models/observability/LogEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "message", "", "logLevel", "Lcom/box/android/domain/models/observability/LogEvent$Priority;", "tag", "throwable", "Lcom/box/android/domain/models/observability/ThrowableMetric;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/observability/LogEvent$Priority;Ljava/lang/String;Lcom/box/android/domain/models/observability/ThrowableMetric;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getMessage", "()Ljava/lang/String;", "getLogLevel", "()Lcom/box/android/domain/models/observability/LogEvent$Priority;", "getTag", "getThrowable", "()Lcom/box/android/domain/models/observability/ThrowableMetric;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Priority", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LogEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final Priority logLevel;
    private final String message;
    private final String tag;
    private final ThrowableMetric throwable;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/models/observability/LogEvent$Priority;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "UNKNOWN", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Priority {
        WARNING,
        ERROR,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Priority> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ LogEvent copy$default(LogEvent logEvent, String str, Priority priority, String str2, ThrowableMetric throwableMetric, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logEvent.message;
        }
        if ((i & 2) != 0) {
            priority = logEvent.logLevel;
        }
        if ((i & 4) != 0) {
            str2 = logEvent.tag;
        }
        if ((i & 8) != 0) {
            throwableMetric = logEvent.throwable;
        }
        if ((i & 16) != 0) {
            deviceMetric = logEvent.device;
        }
        if ((i & 32) != 0) {
            userMetric = logEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        return logEvent.copy(str, priority, str2, throwableMetric, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Priority getLogLevel() {
        return this.logLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThrowableMetric getThrowable() {
        return this.throwable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final LogEvent copy(String message, Priority logLevel, String tag, ThrowableMetric throwable, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        return new LogEvent(message, logLevel, tag, throwable, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) other;
        return Intrinsics.areEqual(this.message, logEvent.message) && this.logLevel == logEvent.logLevel && Intrinsics.areEqual(this.tag, logEvent.tag) && Intrinsics.areEqual(this.throwable, logEvent.throwable) && Intrinsics.areEqual(this.device, logEvent.device) && Intrinsics.areEqual(this.user, logEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((this.message.hashCode() * 31) + this.logLevel.hashCode()) * 31;
        String str = this.tag;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ThrowableMetric throwableMetric = this.throwable;
        int iHashCode3 = (iHashCode2 + (throwableMetric == null ? 0 : throwableMetric.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode4 = (iHashCode3 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode4 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent(message=" + this.message + ", logLevel=" + this.logLevel + ", tag=" + this.tag + ", throwable=" + this.throwable + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogEvent(String message, Priority logLevel, String str, ThrowableMetric throwableMetric, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.message = message;
        this.logLevel = logLevel;
        this.tag = str;
        this.throwable = throwableMetric;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ LogEvent(String str, Priority priority, String str2, ThrowableMetric throwableMetric, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, priority, str2, throwableMetric, (i & 16) != 0 ? null : deviceMetric, (i & 32) != 0 ? null : userMetric);
    }

    public final String getMessage() {
        return this.message;
    }

    public final Priority getLogLevel() {
        return this.logLevel;
    }

    public final String getTag() {
        return this.tag;
    }

    public final ThrowableMetric getThrowable() {
        return this.throwable;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public DeviceMetric getDevice() {
        return this.device;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public void setDevice(DeviceMetric deviceMetric) {
        this.device = deviceMetric;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public UserMetric getUser() {
        return this.user;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public void setUser(UserMetric userMetric) {
        this.user = userMetric;
    }
}
