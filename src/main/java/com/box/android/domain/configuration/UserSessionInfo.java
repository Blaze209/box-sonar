package com.box.android.domain.configuration;

import android.os.SystemClock;
import com.box.android.domain.models.ItemId;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserSessionInfo.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/configuration/UserSessionInfo;", "", "<init>", "()V", "preflightCheckFolderMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "isFolderSuccessfulPreviously", "", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "updatePreflightFolderSuccess", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserSessionInfo {
    public static final int ONE_HOUR_MS = 3600000;
    private final HashMap<String, Long> preflightCheckFolderMap = new HashMap<>();

    @Inject
    public UserSessionInfo() {
    }

    public final boolean isFolderSuccessfulPreviously(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Long l = this.preflightCheckFolderMap.get(folderId.getBoxId());
        return l != null && l.longValue() + ((long) ONE_HOUR_MS) > SystemClock.elapsedRealtime();
    }

    public final void updatePreflightFolderSuccess(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        this.preflightCheckFolderMap.put(folderId.getBoxId(), Long.valueOf(SystemClock.elapsedRealtime()));
    }
}
