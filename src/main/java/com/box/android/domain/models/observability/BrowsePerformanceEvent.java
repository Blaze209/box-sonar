package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/BE\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003JK\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "type", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "ttiMs", "", "numberOfItems", "", "testSuiteMetric", "Lcom/box/android/domain/models/observability/TestSuiteMetric;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;JILcom/box/android/domain/models/observability/TestSuiteMetric;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getType", "()Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "getTtiMs", "()J", "getNumberOfItems", "()I", "getTestSuiteMetric", "()Lcom/box/android/domain/models/observability/TestSuiteMetric;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "Type", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BrowsePerformanceEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final int numberOfItems;
    private final TestSuiteMetric testSuiteMetric;
    private final long ttiMs;
    private final Type type;
    private UserMetric user;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrowsePerformanceEvent(Type type, long j, int i) {
        this(type, j, i, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrowsePerformanceEvent(Type type, long j, int i, TestSuiteMetric testSuiteMetric) {
        this(type, j, i, testSuiteMetric, null, null, 48, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrowsePerformanceEvent(Type type, long j, int i, TestSuiteMetric testSuiteMetric, DeviceMetric deviceMetric) {
        this(type, j, i, testSuiteMetric, deviceMetric, null, 32, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public static /* synthetic */ BrowsePerformanceEvent copy$default(BrowsePerformanceEvent browsePerformanceEvent, Type type, long j, int i, TestSuiteMetric testSuiteMetric, DeviceMetric deviceMetric, UserMetric userMetric, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            type = browsePerformanceEvent.type;
        }
        if ((i2 & 2) != 0) {
            j = browsePerformanceEvent.ttiMs;
        }
        if ((i2 & 4) != 0) {
            i = browsePerformanceEvent.numberOfItems;
        }
        if ((i2 & 8) != 0) {
            testSuiteMetric = browsePerformanceEvent.testSuiteMetric;
        }
        if ((i2 & 16) != 0) {
            deviceMetric = browsePerformanceEvent.device;
        }
        if ((i2 & 32) != 0) {
            userMetric = browsePerformanceEvent.user;
        }
        return browsePerformanceEvent.copy(type, j, i, testSuiteMetric, deviceMetric, userMetric);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTtiMs() {
        return this.ttiMs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumberOfItems() {
        return this.numberOfItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TestSuiteMetric getTestSuiteMetric() {
        return this.testSuiteMetric;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final BrowsePerformanceEvent copy(Type type, long ttiMs, int numberOfItems, TestSuiteMetric testSuiteMetric, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new BrowsePerformanceEvent(type, ttiMs, numberOfItems, testSuiteMetric, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrowsePerformanceEvent)) {
            return false;
        }
        BrowsePerformanceEvent browsePerformanceEvent = (BrowsePerformanceEvent) other;
        return Intrinsics.areEqual(this.type, browsePerformanceEvent.type) && this.ttiMs == browsePerformanceEvent.ttiMs && this.numberOfItems == browsePerformanceEvent.numberOfItems && Intrinsics.areEqual(this.testSuiteMetric, browsePerformanceEvent.testSuiteMetric) && Intrinsics.areEqual(this.device, browsePerformanceEvent.device) && Intrinsics.areEqual(this.user, browsePerformanceEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + Long.hashCode(this.ttiMs)) * 31) + Integer.hashCode(this.numberOfItems)) * 31;
        TestSuiteMetric testSuiteMetric = this.testSuiteMetric;
        int iHashCode2 = (iHashCode + (testSuiteMetric == null ? 0 : testSuiteMetric.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode3 = (iHashCode2 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode3 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "BrowsePerformanceEvent(type=" + this.type + ", ttiMs=" + this.ttiMs + ", numberOfItems=" + this.numberOfItems + ", testSuiteMetric=" + this.testSuiteMetric + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrowsePerformanceEvent(Type type, long j, int i, TestSuiteMetric testSuiteMetric, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.ttiMs = j;
        this.numberOfItems = i;
        this.testSuiteMetric = testSuiteMetric;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ BrowsePerformanceEvent(Type type, long j, int i, TestSuiteMetric testSuiteMetric, DeviceMetric deviceMetric, UserMetric userMetric, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, j, i, (i2 & 8) != 0 ? null : testSuiteMetric, (i2 & 16) != 0 ? null : deviceMetric, (i2 & 32) != 0 ? null : userMetric);
    }

    public final Type getType() {
        return this.type;
    }

    public final long getTtiMs() {
        return this.ttiMs;
    }

    public final int getNumberOfItems() {
        return this.numberOfItems;
    }

    public final TestSuiteMetric getTestSuiteMetric() {
        return this.testSuiteMetric;
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

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "", "<init>", "()V", "FullFolderLoad", "FolderTTIV2", "FolderTTI", "AllFilesTTI", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$AllFilesTTI;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FolderTTI;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FolderTTIV2;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FullFolderLoad;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Type {
        public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: Gen204EventModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FullFolderLoad;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FullFolderLoad extends Type {
            private final String id;

            public static /* synthetic */ FullFolderLoad copy$default(FullFolderLoad fullFolderLoad, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fullFolderLoad.id;
                }
                return fullFolderLoad.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final FullFolderLoad copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new FullFolderLoad(id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FullFolderLoad) && Intrinsics.areEqual(this.id, ((FullFolderLoad) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "FullFolderLoad(id=" + this.id + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FullFolderLoad(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public final String getId() {
                return this.id;
            }
        }

        private Type() {
        }

        /* JADX INFO: compiled from: Gen204EventModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FolderTTIV2;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderTTIV2 extends Type {
            private final String id;

            public static /* synthetic */ FolderTTIV2 copy$default(FolderTTIV2 folderTTIV2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = folderTTIV2.id;
                }
                return folderTTIV2.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final FolderTTIV2 copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new FolderTTIV2(id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderTTIV2) && Intrinsics.areEqual(this.id, ((FolderTTIV2) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "FolderTTIV2(id=" + this.id + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderTTIV2(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public final String getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: Gen204EventModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$FolderTTI;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FolderTTI extends Type {
            private final String id;

            public static /* synthetic */ FolderTTI copy$default(FolderTTI folderTTI, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = folderTTI.id;
                }
                return folderTTI.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final FolderTTI copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new FolderTTI(id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FolderTTI) && Intrinsics.areEqual(this.id, ((FolderTTI) other).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "FolderTTI(id=" + this.id + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FolderTTI(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public final String getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: Gen204EventModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type$AllFilesTTI;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent$Type;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class AllFilesTTI extends Type {
            public static final AllFilesTTI INSTANCE = new AllFilesTTI();

            private AllFilesTTI() {
                super(null);
            }
        }
    }
}
