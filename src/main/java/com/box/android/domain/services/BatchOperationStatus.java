package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IBatchOperationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/services/BatchOperationStatus;", "", "<init>", "()V", "Failed", "Successful", "Started", "Lcom/box/android/domain/services/BatchOperationStatus$Failed;", "Lcom/box/android/domain/services/BatchOperationStatus$Started;", "Lcom/box/android/domain/services/BatchOperationStatus$Successful;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BatchOperationStatus {
    public /* synthetic */ BatchOperationStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: IBatchOperationsService.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/services/BatchOperationStatus$Failed;", "Lcom/box/android/domain/services/BatchOperationStatus;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends BatchOperationStatus {
        private final Exception exception;

        public static /* synthetic */ Failed copy$default(Failed failed, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = failed.exception;
            }
            return failed.copy(exc);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final Failed copy(Exception exception) {
            return new Failed(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && Intrinsics.areEqual(this.exception, ((Failed) other).exception);
        }

        public int hashCode() {
            Exception exc = this.exception;
            if (exc == null) {
                return 0;
            }
            return exc.hashCode();
        }

        public String toString() {
            return "Failed(exception=" + this.exception + ")";
        }

        public Failed(Exception exc) {
            super(null);
            this.exception = exc;
        }

        public final Exception getException() {
            return this.exception;
        }
    }

    private BatchOperationStatus() {
    }

    /* JADX INFO: compiled from: IBatchOperationsService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/services/BatchOperationStatus$Successful;", "Lcom/box/android/domain/services/BatchOperationStatus;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Successful extends BatchOperationStatus {
        public static final Successful INSTANCE = new Successful();

        private Successful() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: IBatchOperationsService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/services/BatchOperationStatus$Started;", "Lcom/box/android/domain/services/BatchOperationStatus;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Started extends BatchOperationStatus {
        public static final Started INSTANCE = new Started();

        private Started() {
            super(null);
        }
    }
}
