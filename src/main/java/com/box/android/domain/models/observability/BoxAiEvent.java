package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.preview.BoxAiActionEvent;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003JL\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/box/android/domain/models/observability/BoxAiEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "boxAiActionEvent", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "extensions", "", "", "numFiles", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/preview/BoxAiActionEvent;Ljava/util/Set;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getBoxAiActionEvent", "()Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "getExtensions", "()Ljava/util/Set;", "getNumFiles", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/preview/BoxAiActionEvent;Ljava/util/Set;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/BoxAiEvent;", "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxAiEvent extends Gen204Event implements DomainModel {
    private final BoxAiActionEvent boxAiActionEvent;
    private DeviceMetric device;
    private final Set<String> extensions;
    private final Integer numFiles;
    private UserMetric user;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoxAiEvent copy$default(BoxAiEvent boxAiEvent, BoxAiActionEvent boxAiActionEvent, Set set, Integer num, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            boxAiActionEvent = boxAiEvent.boxAiActionEvent;
        }
        if ((i & 2) != 0) {
            set = boxAiEvent.extensions;
        }
        if ((i & 4) != 0) {
            num = boxAiEvent.numFiles;
        }
        if ((i & 8) != 0) {
            deviceMetric = boxAiEvent.device;
        }
        if ((i & 16) != 0) {
            userMetric = boxAiEvent.user;
        }
        UserMetric userMetric2 = userMetric;
        Integer num2 = num;
        return boxAiEvent.copy(boxAiActionEvent, set, num2, deviceMetric, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BoxAiActionEvent getBoxAiActionEvent() {
        return this.boxAiActionEvent;
    }

    public final Set<String> component2() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getNumFiles() {
        return this.numFiles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final BoxAiEvent copy(BoxAiActionEvent boxAiActionEvent, Set<String> extensions, Integer numFiles, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(boxAiActionEvent, "boxAiActionEvent");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        return new BoxAiEvent(boxAiActionEvent, extensions, numFiles, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxAiEvent)) {
            return false;
        }
        BoxAiEvent boxAiEvent = (BoxAiEvent) other;
        return Intrinsics.areEqual(this.boxAiActionEvent, boxAiEvent.boxAiActionEvent) && Intrinsics.areEqual(this.extensions, boxAiEvent.extensions) && Intrinsics.areEqual(this.numFiles, boxAiEvent.numFiles) && Intrinsics.areEqual(this.device, boxAiEvent.device) && Intrinsics.areEqual(this.user, boxAiEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((this.boxAiActionEvent.hashCode() * 31) + this.extensions.hashCode()) * 31;
        Integer num = this.numFiles;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode3 = (iHashCode2 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode3 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "BoxAiEvent(boxAiActionEvent=" + this.boxAiActionEvent + ", extensions=" + this.extensions + ", numFiles=" + this.numFiles + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAiEvent(BoxAiActionEvent boxAiActionEvent, Set<String> extensions, Integer num, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(boxAiActionEvent, "boxAiActionEvent");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.boxAiActionEvent = boxAiActionEvent;
        this.extensions = extensions;
        this.numFiles = num;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ BoxAiEvent(BoxAiActionEvent boxAiActionEvent, Set set, Integer num, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(boxAiActionEvent, set, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : deviceMetric, (i & 16) != 0 ? null : userMetric);
    }

    public final BoxAiActionEvent getBoxAiActionEvent() {
        return this.boxAiActionEvent;
    }

    public final Set<String> getExtensions() {
        return this.extensions;
    }

    public final Integer getNumFiles() {
        return this.numFiles;
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
