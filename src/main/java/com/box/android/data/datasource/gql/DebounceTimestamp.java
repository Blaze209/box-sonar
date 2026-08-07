package com.box.android.data.datasource.gql;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueryDebouncer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/gql/DebounceTimestamp;", "", "<init>", "()V", "Executing", "RecentlySucceeded", "Lcom/box/android/data/datasource/gql/DebounceTimestamp$Executing;", "Lcom/box/android/data/datasource/gql/DebounceTimestamp$RecentlySucceeded;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DebounceTimestamp {
    public /* synthetic */ DebounceTimestamp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: QueryDebouncer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/gql/DebounceTimestamp$Executing;", "Lcom/box/android/data/datasource/gql/DebounceTimestamp;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Executing extends DebounceTimestamp {
        public static final Executing INSTANCE = new Executing();

        private Executing() {
            super(null);
        }
    }

    private DebounceTimestamp() {
    }

    /* JADX INFO: compiled from: QueryDebouncer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/gql/DebounceTimestamp$RecentlySucceeded;", "Lcom/box/android/data/datasource/gql/DebounceTimestamp;", "timestamp", "Ljava/util/Date;", "<init>", "(Ljava/util/Date;)V", "getTimestamp", "()Ljava/util/Date;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RecentlySucceeded extends DebounceTimestamp {
        private final Date timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentlySucceeded(Date timestamp) {
            super(null);
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.timestamp = timestamp;
        }

        public final Date getTimestamp() {
            return this.timestamp;
        }
    }
}
