package com.box.android.domain.models.observability;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/observability/ThrowableMetric;", "", BoxCommonConstants.EXTRA_FILE_NAME, "", "methodName", "methodLine", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getFileName", "()Ljava/lang/String;", "getMethodName", "getMethodLine", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "Factory", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ThrowableMetric {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fileName;
    private final int methodLine;
    private final String methodName;

    public static /* synthetic */ ThrowableMetric copy$default(ThrowableMetric throwableMetric, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = throwableMetric.fileName;
        }
        if ((i2 & 2) != 0) {
            str2 = throwableMetric.methodName;
        }
        if ((i2 & 4) != 0) {
            i = throwableMetric.methodLine;
        }
        return throwableMetric.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMethodLine() {
        return this.methodLine;
    }

    public final ThrowableMetric copy(String fileName, String methodName, int methodLine) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return new ThrowableMetric(fileName, methodName, methodLine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThrowableMetric)) {
            return false;
        }
        ThrowableMetric throwableMetric = (ThrowableMetric) other;
        return Intrinsics.areEqual(this.fileName, throwableMetric.fileName) && Intrinsics.areEqual(this.methodName, throwableMetric.methodName) && this.methodLine == throwableMetric.methodLine;
    }

    public int hashCode() {
        return (((this.fileName.hashCode() * 31) + this.methodName.hashCode()) * 31) + Integer.hashCode(this.methodLine);
    }

    public String toString() {
        return "ThrowableMetric(fileName=" + this.fileName + ", methodName=" + this.methodName + ", methodLine=" + this.methodLine + ")";
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.observability.ThrowableMetric$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MetricsModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/observability/ThrowableMetric$Factory;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/box/android/domain/models/observability/ThrowableMetric;", "throwable", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThrowableMetric from(Throwable throwable) {
            if (throwable == null) {
                return null;
            }
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
            if (stackTrace.length == 0) {
                return null;
            }
            String className = throwable.getStackTrace()[0].getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            String methodName = throwable.getStackTrace()[0].getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "getMethodName(...)");
            return new ThrowableMetric(className, methodName, throwable.getStackTrace()[0].getLineNumber());
        }
    }

    public ThrowableMetric(String fileName, String methodName, int i) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        this.fileName = fileName;
        this.methodName = methodName;
        this.methodLine = i;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getMethodLine() {
        return this.methodLine;
    }

    public final String getMethodName() {
        return this.methodName;
    }
}
