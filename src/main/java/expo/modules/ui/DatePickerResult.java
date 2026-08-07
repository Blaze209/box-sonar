package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxOrder;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/DatePickerResult;", "Lexpo/modules/kotlin/records/Record;", BoxOrder.SORT_DATE, "", "<init>", "(Ljava/lang/Long;)V", "getDate$annotations", "()V", "getDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Long;)Lexpo/modules/ui/DatePickerResult;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DatePickerResult implements Record {
    public static final int $stable = 0;
    private final Long date;

    public static /* synthetic */ DatePickerResult copy$default(DatePickerResult datePickerResult, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = datePickerResult.date;
        }
        return datePickerResult.copy(l);
    }

    @Field
    public static /* synthetic */ void getDate$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getDate() {
        return this.date;
    }

    public final DatePickerResult copy(Long date) {
        return new DatePickerResult(date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DatePickerResult) && Intrinsics.areEqual(this.date, ((DatePickerResult) other).date);
    }

    public int hashCode() {
        Long l = this.date;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "DatePickerResult(date=" + this.date + ")";
    }

    public DatePickerResult(Long l) {
        this.date = l;
    }

    public final Long getDate() {
        return this.date;
    }
}
