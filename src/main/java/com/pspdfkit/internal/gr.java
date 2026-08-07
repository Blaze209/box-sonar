package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.NamedAction;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class gr {
    public static final Map<NamedAction.NamedActionType, String> a = MapsKt.mapOf(TuplesKt.to(NamedAction.NamedActionType.NEXTPAGE, "NextPage"), TuplesKt.to(NamedAction.NamedActionType.PREVIOUSPAGE, "PrevPage"), TuplesKt.to(NamedAction.NamedActionType.FIRSTPAGE, "FirstPage"), TuplesKt.to(NamedAction.NamedActionType.LASTPAGE, "LastPage"), TuplesKt.to(NamedAction.NamedActionType.GOBACK, "GoBack"), TuplesKt.to(NamedAction.NamedActionType.GOFORWARD, "GoForward"), TuplesKt.to(NamedAction.NamedActionType.GOTOPAGE, "GoToPage"), TuplesKt.to(NamedAction.NamedActionType.FIND, "Find"), TuplesKt.to(NamedAction.NamedActionType.PRINT, "Print"), TuplesKt.to(NamedAction.NamedActionType.OUTLINE, "Outline"), TuplesKt.to(NamedAction.NamedActionType.SEARCH, "Search"), TuplesKt.to(NamedAction.NamedActionType.BRIGHTNESS, "Brightness"), TuplesKt.to(NamedAction.NamedActionType.ZOOMIN, "ZoomIn"), TuplesKt.to(NamedAction.NamedActionType.ZOOMOUT, "ZoomOut"), TuplesKt.to(NamedAction.NamedActionType.SAVEAS, "SaveAs"), TuplesKt.to(NamedAction.NamedActionType.INFO, "Info"), TuplesKt.to(NamedAction.NamedActionType.UNKNOWN, "Unknown"));
}
