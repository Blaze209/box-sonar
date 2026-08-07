package sdk.pendo.io.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommandParameterInjector;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/models/ContentError;", "Lsdk/pendo/io/models/GuideStatus;", "()V", "hasError", "", "getHasError", "()Z", "status", "", "getStatus", "()I", "sendError", "", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "Lsdk/pendo/io/models/GuideModel;", "pcpi", "Lsdk/pendo/io/actions/PendoCommandParameterInjector;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ContentError extends GuideStatus {
    private final boolean hasError;
    private final int status;

    public ContentError() {
        super(null);
        this.status = GuideStatus.INSTANCE.getCONTENT_ERROR();
        this.hasError = true;
    }

    @Override // sdk.pendo.io.models.GuideStatus
    public boolean getHasError() {
        return this.hasError;
    }

    @Override // sdk.pendo.io.models.GuideStatus
    public int getStatus() {
        return this.status;
    }

    @Override // sdk.pendo.io.models.GuideStatus
    public void sendError(GuideModel guide, PendoCommandParameterInjector pcpi) {
        Intrinsics.checkNotNullParameter(guide, "guide");
        Intrinsics.checkNotNullParameter(pcpi, "pcpi");
        pcpi.handleGuideNotSeenContentError(guide);
    }
}
