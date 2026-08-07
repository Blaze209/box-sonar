package com.box.android.data.datasource.gql;

import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: QueryDebouncer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/box/android/data/datasource/gql/DateProviding;", "", "currentDate", "Ljava/util/Date;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DateProviding {

    /* JADX INFO: compiled from: QueryDebouncer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Date currentDate(DateProviding dateProviding) {
            return DateProviding.super.currentDate();
        }
    }

    default Date currentDate() {
        return new Date();
    }
}
