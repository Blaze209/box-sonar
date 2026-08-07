package sdk.pendo.io.network.socketio.configuration;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
public class TestModeDetails {

    @c("data")
    public GuideModel data;

    @c(TypedValues.TransitionType.S_FROM)
    public String from;

    @c(CmcdConfiguration.KEY_SESSION_ID)
    public String sessionId;

    @c("timestamp")
    public long timestamp;

    @c(TypedValues.TransitionType.S_TO)
    public String to;
}
