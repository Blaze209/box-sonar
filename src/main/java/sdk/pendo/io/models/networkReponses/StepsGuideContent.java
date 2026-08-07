package sdk.pendo.io.models.networkReponses;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/models/networkReponses/StepsGuideContent;", "", "content", "Lsdk/pendo/io/models/networkReponses/StepsGuideContentGuide;", "(Lsdk/pendo/io/models/networkReponses/StepsGuideContentGuide;)V", "getContent", "()Lsdk/pendo/io/models/networkReponses/StepsGuideContentGuide;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class StepsGuideContent {

    @c("content")
    private final StepsGuideContentGuide content;

    public StepsGuideContent(StepsGuideContentGuide content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public static /* synthetic */ StepsGuideContent copy$default(StepsGuideContent stepsGuideContent, StepsGuideContentGuide stepsGuideContentGuide, int i, Object obj) {
        if ((i & 1) != 0) {
            stepsGuideContentGuide = stepsGuideContent.content;
        }
        return stepsGuideContent.copy(stepsGuideContentGuide);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StepsGuideContentGuide getContent() {
        return this.content;
    }

    public final StepsGuideContent copy(StepsGuideContentGuide content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new StepsGuideContent(content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StepsGuideContent) && Intrinsics.areEqual(this.content, ((StepsGuideContent) other).content);
    }

    public final StepsGuideContentGuide getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "StepsGuideContent(content=" + this.content + ")";
    }
}
