package com.box.android.data.persistence;

import com.box.androidsdk.content.models.BoxOrder;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: DateToLongConverter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/persistence/DateToLongConverter;", "", "<init>", "()V", "fromTimestamp", "Ljava/util/Date;", "value", "", "(Ljava/lang/Long;)Ljava/util/Date;", "dateToTimestamp", BoxOrder.SORT_DATE, "(Ljava/util/Date;)Ljava/lang/Long;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateToLongConverter {
    public final Date fromTimestamp(Long value) {
        if (value != null) {
            return new Date(value.longValue());
        }
        return null;
    }

    public final Long dateToTimestamp(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }
}
