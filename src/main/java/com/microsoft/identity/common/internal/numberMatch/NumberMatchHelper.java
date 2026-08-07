package com.microsoft.identity.common.internal.numberMatch;

import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NumberMatchHelper.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/internal/numberMatch/NumberMatchHelper;", "", "()V", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NumberMatchHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NumberMatchHelper";
    private static final HashMap<String, String> numberMatchMap = new HashMap<>();

    /* JADX INFO: compiled from: NumberMatchHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/numberMatch/NumberMatchHelper$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "numberMatchMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getNumberMatchMap", "()Ljava/util/HashMap;", "clearNumberMatchMap", "", "storeNumberMatch", "sessionId", "numberMatch", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return NumberMatchHelper.TAG;
        }

        public final HashMap<String, String> getNumberMatchMap() {
            return NumberMatchHelper.numberMatchMap;
        }

        public final void storeNumberMatch(String sessionId, String numberMatch) {
            String str = getTAG() + ":storeNumberMatch";
            Logger.info(str, "Adding entry in NumberMatch hashmap for session ID: " + sessionId);
            Span spanCurrent = SpanExtension.current();
            if (sessionId != null && numberMatch != null) {
                getNumberMatchMap().put(sessionId, numberMatch);
                spanCurrent.setAttribute(AttributeName.stored_number_match_entry.name(), true);
            } else {
                Logger.warn(str, "Either session ID or number match is null. Nothing to add for number match.");
                spanCurrent.setAttribute(AttributeName.stored_number_match_entry.name(), false);
            }
        }

        public final void clearNumberMatchMap() {
            getNumberMatchMap().clear();
        }
    }
}
