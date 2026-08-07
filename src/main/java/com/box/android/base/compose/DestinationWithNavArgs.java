package com.box.android.base.compose;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: DestinationWithNavArgs.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0016¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/box/android/base/compose/DestinationWithNavArgs;", "", "getNavArgs", "", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DestinationWithNavArgs {

    /* JADX INFO: compiled from: DestinationWithNavArgs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Map<String, Object> getNavArgs(DestinationWithNavArgs destinationWithNavArgs) {
            return DestinationWithNavArgs.super.getNavArgs();
        }
    }

    default Map<String, Object> getNavArgs() {
        return MapsKt.emptyMap();
    }
}
