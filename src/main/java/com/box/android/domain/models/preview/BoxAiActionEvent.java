package com.box.android.domain.models.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiActionEvent.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0011\u0012\u0013\u0014\u0015B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0005\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "", "metricsName", "", "<init>", "(Ljava/lang/String;)V", "getMetricsName", "()Ljava/lang/String;", "failReason", "Lcom/box/android/domain/models/DomainError;", "getFailReason", "()Lcom/box/android/domain/models/DomainError;", "wordCount", "", "getWordCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "AiEnabledFilePreview", "AiEnabledMultiselect", "PromptSubmitted", "AiSessionCreated", "AnswerReceived", "Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiEnabledFilePreview;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiEnabledMultiselect;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiSessionCreated;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent$AnswerReceived;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent$PromptSubmitted;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BoxAiActionEvent {
    private final DomainError failReason;
    private final String metricsName;
    private final Integer wordCount;

    public /* synthetic */ BoxAiActionEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: BoxAiActionEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiEnabledFilePreview;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AiEnabledFilePreview extends BoxAiActionEvent {
        public static final AiEnabledFilePreview INSTANCE = new AiEnabledFilePreview();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AiEnabledFilePreview)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1333576641;
        }

        public String toString() {
            return "AiEnabledFilePreview";
        }

        private AiEnabledFilePreview() {
            super("BoxAI_enabled_file_previewed", null);
        }
    }

    private BoxAiActionEvent(String str) {
        this.metricsName = str;
    }

    public final String getMetricsName() {
        return this.metricsName;
    }

    /* JADX INFO: compiled from: BoxAiActionEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiEnabledMultiselect;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AiEnabledMultiselect extends BoxAiActionEvent {
        public static final AiEnabledMultiselect INSTANCE = new AiEnabledMultiselect();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AiEnabledMultiselect)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 395091082;
        }

        public String toString() {
            return "AiEnabledMultiselect";
        }

        private AiEnabledMultiselect() {
            super("BoxAI_enabled_multiselect", null);
        }
    }

    /* JADX INFO: compiled from: BoxAiActionEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent$PromptSubmitted;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "wordCount", "", "<init>", "(I)V", "getWordCount", "()Ljava/lang/Integer;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PromptSubmitted extends BoxAiActionEvent {
        private final int wordCount;

        public static /* synthetic */ PromptSubmitted copy$default(PromptSubmitted promptSubmitted, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = promptSubmitted.wordCount;
            }
            return promptSubmitted.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWordCount() {
            return this.wordCount;
        }

        public final PromptSubmitted copy(int wordCount) {
            return new PromptSubmitted(wordCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PromptSubmitted) && this.wordCount == ((PromptSubmitted) other).wordCount;
        }

        public int hashCode() {
            return Integer.hashCode(this.wordCount);
        }

        public String toString() {
            return "PromptSubmitted(wordCount=" + this.wordCount + ")";
        }

        public PromptSubmitted(int i) {
            super("Prompt_submitted", null);
            this.wordCount = i;
        }

        @Override // com.box.android.domain.models.preview.BoxAiActionEvent
        public Integer getWordCount() {
            return Integer.valueOf(this.wordCount);
        }
    }

    /* JADX INFO: compiled from: BoxAiActionEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent$AiSessionCreated;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "fileSizeType", "", "failReason", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;)V", "getFileSizeType", "()Ljava/lang/String;", "getFailReason", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AiSessionCreated extends BoxAiActionEvent {
        private final DomainError failReason;
        private final String fileSizeType;

        public static /* synthetic */ AiSessionCreated copy$default(AiSessionCreated aiSessionCreated, String str, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aiSessionCreated.fileSizeType;
            }
            if ((i & 2) != 0) {
                domainError = aiSessionCreated.failReason;
            }
            return aiSessionCreated.copy(str, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFileSizeType() {
            return this.fileSizeType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DomainError getFailReason() {
            return this.failReason;
        }

        public final AiSessionCreated copy(String fileSizeType, DomainError failReason) {
            Intrinsics.checkNotNullParameter(fileSizeType, "fileSizeType");
            return new AiSessionCreated(fileSizeType, failReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AiSessionCreated)) {
                return false;
            }
            AiSessionCreated aiSessionCreated = (AiSessionCreated) other;
            return Intrinsics.areEqual(this.fileSizeType, aiSessionCreated.fileSizeType) && Intrinsics.areEqual(this.failReason, aiSessionCreated.failReason);
        }

        public int hashCode() {
            int iHashCode = this.fileSizeType.hashCode() * 31;
            DomainError domainError = this.failReason;
            return iHashCode + (domainError == null ? 0 : domainError.hashCode());
        }

        public String toString() {
            return "AiSessionCreated(fileSizeType=" + this.fileSizeType + ", failReason=" + this.failReason + ")";
        }

        public /* synthetic */ AiSessionCreated(String str, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : domainError);
        }

        @Override // com.box.android.domain.models.preview.BoxAiActionEvent
        public DomainError getFailReason() {
            return this.failReason;
        }

        public final String getFileSizeType() {
            return this.fileSizeType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiSessionCreated(String fileSizeType, DomainError domainError) {
            super("AI_session_created", null);
            Intrinsics.checkNotNullParameter(fileSizeType, "fileSizeType");
            this.fileSizeType = fileSizeType;
            this.failReason = domainError;
        }
    }

    /* JADX INFO: compiled from: BoxAiActionEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/preview/BoxAiActionEvent$AnswerReceived;", "Lcom/box/android/domain/models/preview/BoxAiActionEvent;", "timeToReceiveResponse", "", "wordCount", "", "failReason", "Lcom/box/android/domain/models/DomainError;", "<init>", "(JLjava/lang/Integer;Lcom/box/android/domain/models/DomainError;)V", "getTimeToReceiveResponse", "()J", "getWordCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFailReason", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(JLjava/lang/Integer;Lcom/box/android/domain/models/DomainError;)Lcom/box/android/domain/models/preview/BoxAiActionEvent$AnswerReceived;", "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnswerReceived extends BoxAiActionEvent {
        private final DomainError failReason;
        private final long timeToReceiveResponse;
        private final Integer wordCount;

        public static /* synthetic */ AnswerReceived copy$default(AnswerReceived answerReceived, long j, Integer num, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                j = answerReceived.timeToReceiveResponse;
            }
            if ((i & 2) != 0) {
                num = answerReceived.wordCount;
            }
            if ((i & 4) != 0) {
                domainError = answerReceived.failReason;
            }
            return answerReceived.copy(j, num, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimeToReceiveResponse() {
            return this.timeToReceiveResponse;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getWordCount() {
            return this.wordCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DomainError getFailReason() {
            return this.failReason;
        }

        public final AnswerReceived copy(long timeToReceiveResponse, Integer wordCount, DomainError failReason) {
            return new AnswerReceived(timeToReceiveResponse, wordCount, failReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnswerReceived)) {
                return false;
            }
            AnswerReceived answerReceived = (AnswerReceived) other;
            return this.timeToReceiveResponse == answerReceived.timeToReceiveResponse && Intrinsics.areEqual(this.wordCount, answerReceived.wordCount) && Intrinsics.areEqual(this.failReason, answerReceived.failReason);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.timeToReceiveResponse) * 31;
            Integer num = this.wordCount;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            DomainError domainError = this.failReason;
            return iHashCode2 + (domainError != null ? domainError.hashCode() : 0);
        }

        public String toString() {
            return "AnswerReceived(timeToReceiveResponse=" + this.timeToReceiveResponse + ", wordCount=" + this.wordCount + ", failReason=" + this.failReason + ")";
        }

        public /* synthetic */ AnswerReceived(long j, Integer num, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : domainError);
        }

        public final long getTimeToReceiveResponse() {
            return this.timeToReceiveResponse;
        }

        @Override // com.box.android.domain.models.preview.BoxAiActionEvent
        public Integer getWordCount() {
            return this.wordCount;
        }

        @Override // com.box.android.domain.models.preview.BoxAiActionEvent
        public DomainError getFailReason() {
            return this.failReason;
        }

        public AnswerReceived(long j, Integer num, DomainError domainError) {
            super("Answer_received", null);
            this.timeToReceiveResponse = j;
            this.wordCount = num;
            this.failReason = domainError;
        }
    }

    public DomainError getFailReason() {
        return this.failReason;
    }

    public Integer getWordCount() {
        return this.wordCount;
    }
}
