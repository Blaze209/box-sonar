package com.bumptech.glide.integration.ktx;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.bumptech.glide.load.DataSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0015\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bumptech/glide/integration/ktx/Resource;", "ResourceT", "Lcom/bumptech/glide/integration/ktx/GlideFlowInstant;", "status", "Lcom/bumptech/glide/integration/ktx/Status;", "resource", "isFirstResource", "", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Lcom/bumptech/glide/integration/ktx/Status;Ljava/lang/Object;ZLcom/bumptech/glide/load/DataSource;)V", "getDataSource", "()Lcom/bumptech/glide/load/DataSource;", "()Z", "getResource", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Lcom/bumptech/glide/integration/ktx/Status;", "asFailure", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/bumptech/glide/integration/ktx/Status;Ljava/lang/Object;ZLcom/bumptech/glide/load/DataSource;)Lcom/bumptech/glide/integration/ktx/Resource;", "equals", "other", "", "hashCode", "", "toString", "", "ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Resource<ResourceT> extends GlideFlowInstant<ResourceT> {
    private final DataSource dataSource;
    private final boolean isFirstResource;
    private final ResourceT resource;
    private final Status status;

    /* JADX INFO: compiled from: Flows.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.CLEARED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Resource copy$default(Resource resource, Status status, Object obj, boolean z, DataSource dataSource, int i, Object obj2) {
        if ((i & 1) != 0) {
            status = resource.status;
        }
        if ((i & 2) != 0) {
            obj = resource.resource;
        }
        if ((i & 4) != 0) {
            z = resource.isFirstResource;
        }
        if ((i & 8) != 0) {
            dataSource = resource.dataSource;
        }
        return resource.copy(status, obj, z, dataSource);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final ResourceT component2() {
        return this.resource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFirstResource() {
        return this.isFirstResource;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final Resource<ResourceT> copy(Status status, ResourceT resource, boolean isFirstResource, DataSource dataSource) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        return new Resource<>(status, resource, isFirstResource, dataSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) other;
        return this.status == resource.status && Intrinsics.areEqual(this.resource, resource.resource) && this.isFirstResource == resource.isFirstResource && this.dataSource == resource.dataSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        ResourceT resourcet = this.resource;
        int iHashCode2 = (iHashCode + (resourcet == null ? 0 : resourcet.hashCode())) * 31;
        boolean z = this.isFirstResource;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode2 + r1) * 31) + this.dataSource.hashCode();
    }

    public String toString() {
        return "Resource(status=" + this.status + ", resource=" + this.resource + ", isFirstResource=" + this.isFirstResource + ", dataSource=" + this.dataSource + ')';
    }

    @Override // com.bumptech.glide.integration.ktx.GlideFlowInstant
    public Status getStatus() {
        return this.status;
    }

    public final ResourceT getResource() {
        return this.resource;
    }

    public final boolean isFirstResource() {
        return this.isFirstResource;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Resource(Status status, ResourceT resourcet, boolean z, DataSource dataSource) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.status = status;
        this.resource = resourcet;
        this.isFirstResource = z;
        this.dataSource = dataSource;
        int i = WhenMappings.$EnumSwitchMapping$0[getStatus().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        if (i == 4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Resource<ResourceT> asFailure() {
        return new Resource<>(Status.FAILED, this.resource, this.isFirstResource, this.dataSource);
    }
}
