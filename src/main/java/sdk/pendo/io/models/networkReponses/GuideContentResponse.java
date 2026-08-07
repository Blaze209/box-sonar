package sdk.pendo.io.models.networkReponses;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JM\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lsdk/pendo/io/models/networkReponses/GuideContentResponse;", "", "", "component1", "component2", "component3", "", "component4", "", "Lsdk/pendo/io/models/networkReponses/StepsGuideContent;", "component5", "Lsdk/pendo/io/a0/f;", "component6", "guideId", RemoteConfigConstants.RequestFieldKey.APP_ID, "guideName", "iat", "steps", "carousels", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getGuideId", "()Ljava/lang/String;", "getAppId", "getGuideName", "J", "getIat", "()J", "Ljava/util/List;", "getSteps", "()Ljava/util/List;", "Lsdk/pendo/io/a0/f;", "getCarousels", "()Lsdk/pendo/io/a0/f;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Lsdk/pendo/io/a0/f;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class GuideContentResponse {

    @c(RemoteConfigConstants.RequestFieldKey.APP_ID)
    private final String appId;

    @c("carousels")
    private final f carousels;

    @c("guideId")
    private final String guideId;

    @c("guideName")
    private final String guideName;

    @c("iat")
    private final long iat;

    @c("steps")
    private final List<StepsGuideContent> steps;

    public GuideContentResponse(String guideId, String appId, String guideName, long j, List<StepsGuideContent> steps, f fVar) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(guideName, "guideName");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.guideId = guideId;
        this.appId = appId;
        this.guideName = guideName;
        this.iat = j;
        this.steps = steps;
        this.carousels = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuideContentResponse copy$default(GuideContentResponse guideContentResponse, String str, String str2, String str3, long j, List list, f fVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guideContentResponse.guideId;
        }
        if ((i & 2) != 0) {
            str2 = guideContentResponse.appId;
        }
        if ((i & 4) != 0) {
            str3 = guideContentResponse.guideName;
        }
        if ((i & 8) != 0) {
            j = guideContentResponse.iat;
        }
        if ((i & 16) != 0) {
            list = guideContentResponse.steps;
        }
        if ((i & 32) != 0) {
            fVar = guideContentResponse.carousels;
        }
        long j2 = j;
        String str4 = str3;
        return guideContentResponse.copy(str, str2, str4, j2, list, fVar);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGuideId() {
        return this.guideId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGuideName() {
        return this.guideName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getIat() {
        return this.iat;
    }

    public final List<StepsGuideContent> component5() {
        return this.steps;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final f getCarousels() {
        return this.carousels;
    }

    public final GuideContentResponse copy(String guideId, String appId, String guideName, long iat, List<StepsGuideContent> steps, f carousels) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(guideName, "guideName");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new GuideContentResponse(guideId, appId, guideName, iat, steps, carousels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideContentResponse)) {
            return false;
        }
        GuideContentResponse guideContentResponse = (GuideContentResponse) other;
        return Intrinsics.areEqual(this.guideId, guideContentResponse.guideId) && Intrinsics.areEqual(this.appId, guideContentResponse.appId) && Intrinsics.areEqual(this.guideName, guideContentResponse.guideName) && this.iat == guideContentResponse.iat && Intrinsics.areEqual(this.steps, guideContentResponse.steps) && Intrinsics.areEqual(this.carousels, guideContentResponse.carousels);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final f getCarousels() {
        return this.carousels;
    }

    public final String getGuideId() {
        return this.guideId;
    }

    public final String getGuideName() {
        return this.guideName;
    }

    public final long getIat() {
        return this.iat;
    }

    public final List<StepsGuideContent> getSteps() {
        return this.steps;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.guideId.hashCode() * 31) + this.appId.hashCode()) * 31) + this.guideName.hashCode()) * 31) + Long.hashCode(this.iat)) * 31) + this.steps.hashCode()) * 31;
        f fVar = this.carousels;
        return iHashCode + (fVar == null ? 0 : fVar.hashCode());
    }

    public String toString() {
        return "GuideContentResponse(guideId=" + this.guideId + ", appId=" + this.appId + ", guideName=" + this.guideName + ", iat=" + this.iat + ", steps=" + this.steps + ", carousels=" + this.carousels + ")";
    }

    public /* synthetic */ GuideContentResponse(String str, String str2, String str3, long j, List list, f fVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, list, (i & 32) != 0 ? null : fVar);
    }
}
