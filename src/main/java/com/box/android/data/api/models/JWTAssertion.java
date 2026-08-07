package com.box.android.data.api.models;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/JWTAssertion;", "", "subjectType", "", "subject", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubjectType", "()Ljava/lang/String;", "getSubject", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JWTAssertion {
    private final String subject;
    private final String subjectType;

    public static /* synthetic */ JWTAssertion copy$default(JWTAssertion jWTAssertion, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jWTAssertion.subjectType;
        }
        if ((i & 2) != 0) {
            str2 = jWTAssertion.subject;
        }
        return jWTAssertion.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectType() {
        return this.subjectType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final JWTAssertion copy(@Json(name = AuthenticationRemoteDataSource.SUBJECT_TYPE_KEY) String subjectType, @Json(name = "sub") String subject) {
        Intrinsics.checkNotNullParameter(subjectType, "subjectType");
        Intrinsics.checkNotNullParameter(subject, "subject");
        return new JWTAssertion(subjectType, subject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JWTAssertion)) {
            return false;
        }
        JWTAssertion jWTAssertion = (JWTAssertion) other;
        return Intrinsics.areEqual(this.subjectType, jWTAssertion.subjectType) && Intrinsics.areEqual(this.subject, jWTAssertion.subject);
    }

    public int hashCode() {
        return (this.subjectType.hashCode() * 31) + this.subject.hashCode();
    }

    public String toString() {
        return "JWTAssertion(subjectType=" + this.subjectType + ", subject=" + this.subject + ")";
    }

    public JWTAssertion(@Json(name = AuthenticationRemoteDataSource.SUBJECT_TYPE_KEY) String subjectType, @Json(name = "sub") String subject) {
        Intrinsics.checkNotNullParameter(subjectType, "subjectType");
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.subjectType = subjectType;
        this.subject = subject;
    }

    public final String getSubjectType() {
        return this.subjectType;
    }

    public final String getSubject() {
        return this.subject;
    }
}
