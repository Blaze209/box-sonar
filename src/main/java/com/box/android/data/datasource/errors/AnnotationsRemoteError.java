package com.box.android.data.datasource.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/errors/AnnotationsRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "<init>", "(I)V", "AnnotationFetchError", "VersionsFetchError", "CommentsFetchError", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$AnnotationFetchError;", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$CommentsFetchError;", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$VersionsFetchError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationsRemoteError extends RemoteError {
    public /* synthetic */ AnnotationsRemoteError(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$AnnotationFetchError;", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError;", "code", "", "<init>", "(I)V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnnotationFetchError extends AnnotationsRemoteError {
        public AnnotationFetchError(int i) {
            super(i, null);
        }
    }

    private AnnotationsRemoteError(int i) {
        super(i, null, 2, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$VersionsFetchError;", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError;", "code", "", "<init>", "(I)V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class VersionsFetchError extends AnnotationsRemoteError {
        public VersionsFetchError(int i) {
            super(i, null);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/errors/AnnotationsRemoteError$CommentsFetchError;", "Lcom/box/android/data/datasource/errors/AnnotationsRemoteError;", "code", "", "<init>", "(I)V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CommentsFetchError extends AnnotationsRemoteError {
        public CommentsFetchError(int i) {
            super(i, null);
        }
    }
}
