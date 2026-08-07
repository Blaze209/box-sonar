package com.box.android.domain.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiAnswerModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/domain/models/DomainModel;", "AnswerPart", "CitationsPart", "ContextSession", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$AnswerPart;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$CitationsPart;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$ContextSession;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AiAnswerStreamingModel extends DomainModel {

    /* JADX INFO: compiled from: AiAnswerModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$AnswerPart;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "answer", "", "<init>", "(Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnswerPart implements AiAnswerStreamingModel {
        private final String answer;

        public static /* synthetic */ AnswerPart copy$default(AnswerPart answerPart, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answerPart.answer;
            }
            return answerPart.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnswer() {
            return this.answer;
        }

        public final AnswerPart copy(String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            return new AnswerPart(answer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnswerPart) && Intrinsics.areEqual(this.answer, ((AnswerPart) other).answer);
        }

        public int hashCode() {
            return this.answer.hashCode();
        }

        public String toString() {
            return "AnswerPart(answer=" + this.answer + ")";
        }

        public AnswerPart(String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            this.answer = answer;
        }

        public final String getAnswer() {
            return this.answer;
        }
    }

    /* JADX INFO: compiled from: AiAnswerModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$CitationsPart;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Ljava/util/List;)V", "getCitations", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CitationsPart implements AiAnswerStreamingModel {
        private final List<AiCitationModel> citations;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CitationsPart copy$default(CitationsPart citationsPart, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = citationsPart.citations;
            }
            return citationsPart.copy(list);
        }

        public final List<AiCitationModel> component1() {
            return this.citations;
        }

        public final CitationsPart copy(List<AiCitationModel> citations) {
            Intrinsics.checkNotNullParameter(citations, "citations");
            return new CitationsPart(citations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CitationsPart) && Intrinsics.areEqual(this.citations, ((CitationsPart) other).citations);
        }

        public int hashCode() {
            return this.citations.hashCode();
        }

        public String toString() {
            return "CitationsPart(citations=" + this.citations + ")";
        }

        public CitationsPart(List<AiCitationModel> citations) {
            Intrinsics.checkNotNullParameter(citations, "citations");
            this.citations = citations;
        }

        public final List<AiCitationModel> getCitations() {
            return this.citations;
        }
    }

    /* JADX INFO: compiled from: AiAnswerModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$ContextSession;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "contextSession", "", "<init>", "(Ljava/lang/String;)V", "getContextSession", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ContextSession implements AiAnswerStreamingModel {
        private final String contextSession;

        public static /* synthetic */ ContextSession copy$default(ContextSession contextSession, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contextSession.contextSession;
            }
            return contextSession.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContextSession() {
            return this.contextSession;
        }

        public final ContextSession copy(String contextSession) {
            Intrinsics.checkNotNullParameter(contextSession, "contextSession");
            return new ContextSession(contextSession);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContextSession) && Intrinsics.areEqual(this.contextSession, ((ContextSession) other).contextSession);
        }

        public int hashCode() {
            return this.contextSession.hashCode();
        }

        public String toString() {
            return "ContextSession(contextSession=" + this.contextSession + ")";
        }

        public ContextSession(String contextSession) {
            Intrinsics.checkNotNullParameter(contextSession, "contextSession");
            this.contextSession = contextSession;
        }

        public final String getContextSession() {
            return this.contextSession;
        }
    }
}
