package com.box.android.domain.configuration;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: BoxEnterpriseIds.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"BOX_ENTERPRISE_IDS", "", "", "getBOX_ENTERPRISE_IDS", "()Ljava/util/Set;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxEnterpriseIdsKt {
    private static final Set<String> BOX_ENTERPRISE_IDS = SetsKt.setOf((Object[]) new String[]{"27335", "985949", "19298130", "985961", "213857487", "551633", "985953", "19297853"});

    public static final Set<String> getBOX_ENTERPRISE_IDS() {
        return BOX_ENTERPRISE_IDS;
    }
}
