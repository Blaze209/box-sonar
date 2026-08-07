package com.box.brownfieldApi.featuresNavigator;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "", "NewSession", "ResumeSession", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode$NewSession;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode$ResumeSession;", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AiCenterLaunchMode {

    /* JADX INFO: compiled from: AICenterCompose.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode$NewSession;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "seed", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;", "<init>", "(Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;)V", "getSeed", "()Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class NewSession implements AiCenterLaunchMode {
        public static final int $stable = 8;
        private final AiCenterInitialContext seed;

        /* JADX WARN: Multi-variable type inference failed */
        public NewSession() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NewSession copy$default(NewSession newSession, AiCenterInitialContext aiCenterInitialContext, int i, Object obj) {
            if ((i & 1) != 0) {
                aiCenterInitialContext = newSession.seed;
            }
            return newSession.copy(aiCenterInitialContext);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AiCenterInitialContext getSeed() {
            return this.seed;
        }

        public final NewSession copy(AiCenterInitialContext seed) {
            return new NewSession(seed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NewSession) && Intrinsics.areEqual(this.seed, ((NewSession) other).seed);
        }

        public int hashCode() {
            AiCenterInitialContext aiCenterInitialContext = this.seed;
            if (aiCenterInitialContext == null) {
                return 0;
            }
            return aiCenterInitialContext.hashCode();
        }

        public String toString() {
            return "NewSession(seed=" + this.seed + ")";
        }

        public NewSession(AiCenterInitialContext aiCenterInitialContext) {
            this.seed = aiCenterInitialContext;
        }

        public /* synthetic */ NewSession(AiCenterInitialContext aiCenterInitialContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : aiCenterInitialContext);
        }

        public final AiCenterInitialContext getSeed() {
            return this.seed;
        }
    }

    /* JADX INFO: compiled from: AICenterCompose.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode$ResumeSession;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ResumeSession implements AiCenterLaunchMode {
        public static final int $stable = 0;
        private final String sessionId;

        public static /* synthetic */ ResumeSession copy$default(ResumeSession resumeSession, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resumeSession.sessionId;
            }
            return resumeSession.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final ResumeSession copy(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new ResumeSession(sessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResumeSession) && Intrinsics.areEqual(this.sessionId, ((ResumeSession) other).sessionId);
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "ResumeSession(sessionId=" + this.sessionId + ")";
        }

        public ResumeSession(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.sessionId = sessionId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }
    }
}
