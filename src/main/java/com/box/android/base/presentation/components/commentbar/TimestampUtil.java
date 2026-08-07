package com.box.android.base.presentation.components.commentbar;

import com.amplitude.api.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TimestampUtil.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/TimestampUtil;", "", "<init>", "()V", "SUBMISSION_FORMAT_REGEX", "Lkotlin/text/Regex;", "getSUBMISSION_FORMAT_REGEX", "()Lkotlin/text/Regex;", "DISPLAY_FORMAT_WITH_HOURS", "", "SUBMISSION_FORMAT", "formatTimestampForDisplay", "timestampMs", "", "formatTimestampForSubmission", Constants.AMP_PLAN_VERSION_ID, "processTimestamp", "Lcom/box/android/base/presentation/components/commentbar/TimestampProcessingResult;", "text", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimestampUtil {
    public static final String DISPLAY_FORMAT_WITH_HOURS = "%d:%02d:%02d";
    public static final String SUBMISSION_FORMAT = "#[timestamp:%d,versionId:%s]";
    public static final TimestampUtil INSTANCE = new TimestampUtil();
    private static final Regex SUBMISSION_FORMAT_REGEX = new Regex("#\\[timestamp:(\\d+),versionId:([^]]+)\\]");
    public static final int $stable = 8;

    private TimestampUtil() {
    }

    public final Regex getSUBMISSION_FORMAT_REGEX() {
        return SUBMISSION_FORMAT_REGEX;
    }

    public final String formatTimestampForDisplay(long timestampMs) {
        int i = (int) (timestampMs / 1000.0d);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, DISPLAY_FORMAT_WITH_HOURS, Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String formatTimestampForSubmission(long timestampMs, String versionId) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        String str = String.format(SUBMISSION_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(timestampMs), versionId}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final TimestampProcessingResult processTimestamp(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Regex regex = SUBMISSION_FORMAT_REGEX;
        final ArrayList arrayList = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        String strReplace = regex.replace(text, new Function1() { // from class: com.box.android.base.presentation.components.commentbar.TimestampUtil$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimestampUtil.processTimestamp$lambda$0(intRef, arrayList, (MatchResult) obj);
            }
        });
        if (arrayList.size() > 1 || (!arrayList.isEmpty() && ((TimestampData) arrayList.get(0)).getRange().getFirst() > 0)) {
            return new TimestampProcessingResult(text, CollectionsKt.emptyList());
        }
        return new TimestampProcessingResult(strReplace, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence processTimestamp$lambda$0(Ref.IntRef intRef, List list, MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Long longOrNull = StringsKt.toLongOrNull(matchResult.getGroupValues().get(1));
        long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
        String str = matchResult.getGroupValues().get(2);
        String timestampForDisplay = INSTANCE.formatTimestampForDisplay(jLongValue);
        int first = matchResult.getRange().getFirst() + intRef.element;
        list.add(new TimestampData(jLongValue, str, new IntRange(first, (timestampForDisplay.length() + first) - 1)));
        intRef.element += timestampForDisplay.length() - matchResult.getValue().length();
        return timestampForDisplay;
    }
}
