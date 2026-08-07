package com.box.android.data.datasource.gql;

import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: QueryDebouncer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/gql/DefaultDateProvider;", "Lcom/box/android/data/datasource/gql/DateProviding;", "<init>", "()V", "currentDate", "Ljava/util/Date;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultDateProvider implements DateProviding {
    @Override // com.box.android.data.datasource.gql.DateProviding
    public Date currentDate() {
        return new Date();
    }
}
