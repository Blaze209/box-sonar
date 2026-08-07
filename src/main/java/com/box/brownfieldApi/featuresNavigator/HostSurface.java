package com.box.brownfieldApi.featuresNavigator;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AI_HOME", "PREVIEW", "FILES", "HUBS", "NOTES", "BOX_APPS", "AI_STUDIO", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum HostSurface {
    AI_HOME("ai-home"),
    PREVIEW(BoxAnalyticsParams.CTA_PAGE_PREVIEW),
    FILES("files"),
    HUBS("hubs"),
    NOTES("notes"),
    BOX_APPS("boxapps"),
    AI_STUDIO("ai-studio");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<HostSurface> getEntries() {
        return $ENTRIES;
    }

    HostSurface(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
