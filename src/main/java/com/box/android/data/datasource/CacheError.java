package com.box.android.data.datasource;

import com.box.android.domain.models.IGenericError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CacheError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/datasource/CacheError;", "Lcom/box/android/domain/models/IGenericError;", "<init>", "()V", "NoUserLoggedInError", "DatabaseInitError", "SaveError", "ReadError", "DeleteError", "NoResultFound", "Lcom/box/android/data/datasource/CacheError$DatabaseInitError;", "Lcom/box/android/data/datasource/CacheError$DeleteError;", "Lcom/box/android/data/datasource/CacheError$NoResultFound;", "Lcom/box/android/data/datasource/CacheError$NoUserLoggedInError;", "Lcom/box/android/data/datasource/CacheError$ReadError;", "Lcom/box/android/data/datasource/CacheError$SaveError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CacheError implements IGenericError {
    public /* synthetic */ CacheError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CacheError() {
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$NoUserLoggedInError;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NoUserLoggedInError extends CacheError {
        public static final NoUserLoggedInError INSTANCE = new NoUserLoggedInError();

        private NoUserLoggedInError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$DatabaseInitError;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DatabaseInitError extends CacheError {
        public static final DatabaseInitError INSTANCE = new DatabaseInitError();

        private DatabaseInitError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$SaveError;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SaveError extends CacheError {
        public static final SaveError INSTANCE = new SaveError();

        private SaveError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$ReadError;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ReadError extends CacheError {
        public static final ReadError INSTANCE = new ReadError();

        private ReadError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$DeleteError;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DeleteError extends CacheError {
        public static final DeleteError INSTANCE = new DeleteError();

        private DeleteError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CacheError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/CacheError$NoResultFound;", "Lcom/box/android/data/datasource/CacheError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NoResultFound extends CacheError {
        public static final NoResultFound INSTANCE = new NoResultFound();

        private NoResultFound() {
            super(null);
        }
    }
}
