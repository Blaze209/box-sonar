package com.box.android.data.datasource.comment;

import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.data.api.requests.CommentRequest;
import com.box.android.data.api.requests.CommentV2Request;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentRemoteDataSource_Factory implements Factory<CommentRemoteDataSource> {
    private final Provider<AnnotationsRequest> annotationRequestProvider;
    private final Provider<CommentRequest> commentRequestProvider;
    private final Provider<CommentV2Request> commentsV2RequestProvider;
    private final Provider<Moshi> moshiProvider;

    private CommentRemoteDataSource_Factory(Provider<AnnotationsRequest> annotationRequestProvider, Provider<CommentRequest> commentRequestProvider, Provider<CommentV2Request> commentsV2RequestProvider, Provider<Moshi> moshiProvider) {
        this.annotationRequestProvider = annotationRequestProvider;
        this.commentRequestProvider = commentRequestProvider;
        this.commentsV2RequestProvider = commentsV2RequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentRemoteDataSource get() {
        return newInstance(this.annotationRequestProvider.get(), this.commentRequestProvider.get(), this.commentsV2RequestProvider.get(), this.moshiProvider.get());
    }

    public static CommentRemoteDataSource_Factory create(Provider<AnnotationsRequest> annotationRequestProvider, Provider<CommentRequest> commentRequestProvider, Provider<CommentV2Request> commentsV2RequestProvider, Provider<Moshi> moshiProvider) {
        return new CommentRemoteDataSource_Factory(annotationRequestProvider, commentRequestProvider, commentsV2RequestProvider, moshiProvider);
    }

    public static CommentRemoteDataSource newInstance(AnnotationsRequest annotationRequest, CommentRequest commentRequest, CommentV2Request commentsV2Request, Moshi moshi) {
        return new CommentRemoteDataSource(annotationRequest, commentRequest, commentsV2Request, moshi);
    }
}
