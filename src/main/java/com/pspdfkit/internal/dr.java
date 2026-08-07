package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.RichMediaExecuteAction;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class dr {
    public static final Map<RichMediaExecuteAction.RichMediaExecuteActionType, String> a = MapsKt.mapOf(TuplesKt.to(RichMediaExecuteAction.RichMediaExecuteActionType.PLAY, "multimedia_play"), TuplesKt.to(RichMediaExecuteAction.RichMediaExecuteActionType.PAUSE, "multimedia_pause"), TuplesKt.to(RichMediaExecuteAction.RichMediaExecuteActionType.SEEK, "multimedia_seek"), TuplesKt.to(RichMediaExecuteAction.RichMediaExecuteActionType.REWIND, "multimedia_rewind"), TuplesKt.to(RichMediaExecuteAction.RichMediaExecuteActionType.UNKNOWN, ""));
}
