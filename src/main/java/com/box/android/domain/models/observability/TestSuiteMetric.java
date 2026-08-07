package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/observability/TestSuiteMetric;", "", "job", "", "testName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getJob", "()Ljava/lang/String;", "getTestName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TestSuiteMetric {
    private final String job;
    private final String testName;

    public static /* synthetic */ TestSuiteMetric copy$default(TestSuiteMetric testSuiteMetric, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = testSuiteMetric.job;
        }
        if ((i & 2) != 0) {
            str2 = testSuiteMetric.testName;
        }
        return testSuiteMetric.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getJob() {
        return this.job;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTestName() {
        return this.testName;
    }

    public final TestSuiteMetric copy(String job, String testName) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(testName, "testName");
        return new TestSuiteMetric(job, testName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestSuiteMetric)) {
            return false;
        }
        TestSuiteMetric testSuiteMetric = (TestSuiteMetric) other;
        return Intrinsics.areEqual(this.job, testSuiteMetric.job) && Intrinsics.areEqual(this.testName, testSuiteMetric.testName);
    }

    public int hashCode() {
        return (this.job.hashCode() * 31) + this.testName.hashCode();
    }

    public String toString() {
        return "TestSuiteMetric(job=" + this.job + ", testName=" + this.testName + ")";
    }

    public TestSuiteMetric(String job, String testName) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(testName, "testName");
        this.job = job;
        this.testName = testName;
    }

    public final String getJob() {
        return this.job;
    }

    public final String getTestName() {
        return this.testName;
    }
}
