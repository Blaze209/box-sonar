package com.bumptech.glide.integration.compose;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.bumptech.glide.load.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bumptech/glide/integration/compose/RequestState;", "", "()V", "Failure", "Loading", "Success", "Lcom/bumptech/glide/integration/compose/RequestState$Failure;", "Lcom/bumptech/glide/integration/compose/RequestState$Loading;", "Lcom/bumptech/glide/integration/compose/RequestState$Success;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RequestState {
    public static final int $stable = 0;

    public /* synthetic */ RequestState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RequestState() {
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bumptech/glide/integration/compose/RequestState$Loading;", "Lcom/bumptech/glide/integration/compose/RequestState;", "()V", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Loading extends RequestState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bumptech/glide/integration/compose/RequestState$Success;", "Lcom/bumptech/glide/integration/compose/RequestState;", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Lcom/bumptech/glide/load/DataSource;)V", "getDataSource", "()Lcom/bumptech/glide/load/DataSource;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success extends RequestState {
        public static final int $stable = 0;
        private final DataSource dataSource;

        public static /* synthetic */ Success copy$default(Success success, DataSource dataSource, int i, Object obj) {
            if ((i & 1) != 0) {
                dataSource = success.dataSource;
            }
            return success.copy(dataSource);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final Success copy(DataSource dataSource) {
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            return new Success(dataSource);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && this.dataSource == ((Success) other).dataSource;
        }

        public int hashCode() {
            return this.dataSource.hashCode();
        }

        public String toString() {
            return "Success(dataSource=" + this.dataSource + ')';
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(DataSource dataSource) {
            super(null);
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            this.dataSource = dataSource;
        }
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bumptech/glide/integration/compose/RequestState$Failure;", "Lcom/bumptech/glide/integration/compose/RequestState;", "()V", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Failure extends RequestState {
        public static final int $stable = 0;
        public static final Failure INSTANCE = new Failure();

        private Failure() {
            super(null);
        }
    }
}
