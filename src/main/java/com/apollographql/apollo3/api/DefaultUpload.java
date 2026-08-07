package com.apollographql.apollo3.api;

import com.box.android.common.utilities.BoxCommonConstants;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Utf8;

/* JADX INFO: compiled from: DefaultUpload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B5\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/apollographql/apollo3/api/DefaultUpload;", "Lcom/apollographql/apollo3/api/Upload;", "writeTo", "Lkotlin/Function1;", "Lokio/BufferedSink;", "", "contentType", "", "contentLength", "", BoxCommonConstants.EXTRA_FILE_NAME, "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;JLjava/lang/String;)V", "getContentLength", "()J", "getContentType", "()Ljava/lang/String;", "getFileName", "newBuilder", "Lcom/apollographql/apollo3/api/DefaultUpload$Builder;", "sink", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultUpload implements Upload {
    private final long contentLength;
    private final String contentType;
    private final String fileName;
    private final Function1<BufferedSink, Unit> writeTo;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultUpload(Function1<? super BufferedSink, Unit> writeTo, String contentType, long j, String str) {
        Intrinsics.checkNotNullParameter(writeTo, "writeTo");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.writeTo = writeTo;
        this.contentType = contentType;
        this.contentLength = j;
        this.fileName = str;
    }

    @Override // com.apollographql.apollo3.api.Upload
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.apollographql.apollo3.api.Upload
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // com.apollographql.apollo3.api.Upload
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.apollographql.apollo3.api.Upload
    public void writeTo(BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.writeTo.invoke(sink);
    }

    public final Builder newBuilder() {
        Builder builderContentLength = new Builder().content(this.writeTo).contentType(getContentType()).contentLength(getContentLength());
        if (getFileName() != null) {
            builderContentLength.fileName(getFileName());
        }
        return builderContentLength;
    }

    /* JADX INFO: compiled from: DefaultUpload.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0011H\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/apollographql/apollo3/api/DefaultUpload$Builder;", "", "()V", "contentLength", "", "contentType", "", BoxCommonConstants.EXTRA_FILE_NAME, "writeTo", "Lkotlin/Function1;", "Lokio/BufferedSink;", "", "build", "Lcom/apollographql/apollo3/api/DefaultUpload;", "content", "byteArray", "", "Lokio/BufferedSource;", "byteString", "Lokio/ByteString;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private long contentLength = -1;
        private String contentType;
        private String fileName;
        private Function1<? super BufferedSink, Unit> writeTo;

        @Deprecated(message = "This API is dangerous because the resulting upload can only be used once and can also lead to resource leaks.", replaceWith = @ReplaceWith(expression = "content {sink ->\nval source = openSource()\nsource.use {sink.writeAll(it)}\n}", imports = {}))
        public final Builder content(final BufferedSource content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (this.writeTo != null) {
                throw new IllegalStateException("content() can only be called once".toString());
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            this.writeTo = new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.DefaultUpload$Builder$content$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BufferedSink bufferedSink) throws Throwable {
                    invoke2(bufferedSink);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BufferedSink sink) throws Throwable {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    if (booleanRef.element) {
                        throw new IllegalStateException("Apollo: DefaultUpload BufferedSource body can only be read once. If you want to read it several times for logging or other purposes, either use a different kind of body or use your own `Upload` implementation.".toString());
                    }
                    BufferedSource bufferedSource = content;
                    try {
                        Long.valueOf(sink.writeAll(bufferedSource));
                        if (bufferedSource != null) {
                            try {
                                bufferedSource.close();
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedSource != null) {
                            try {
                                bufferedSource.close();
                            } catch (Throwable th3) {
                                ExceptionsKt.addSuppressed(th, th3);
                            }
                        }
                    }
                    if (th == null) {
                        booleanRef.element = true;
                        return;
                    }
                    throw th;
                }
            };
            return this;
        }

        public final Builder content(Function1<? super BufferedSink, Unit> writeTo) {
            Intrinsics.checkNotNullParameter(writeTo, "writeTo");
            if (this.writeTo != null) {
                throw new IllegalStateException("content() can only be called once".toString());
            }
            this.writeTo = writeTo;
            return this;
        }

        public final Builder content(final String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (this.writeTo != null) {
                throw new IllegalStateException("content() can only be called once".toString());
            }
            this.writeTo = new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.DefaultUpload$Builder$content$3$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BufferedSink bufferedSink) throws IOException {
                    invoke2(bufferedSink);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.writeUtf8(content);
                }
            };
            this.contentLength = Utf8.size$default(content, 0, 0, 3, null);
            return this;
        }

        public final Builder content(final ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "byteString");
            if (this.writeTo != null) {
                throw new IllegalStateException("content() can only be called once".toString());
            }
            this.writeTo = new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.DefaultUpload$Builder$content$4$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BufferedSink bufferedSink) throws IOException {
                    invoke2(bufferedSink);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write(byteString);
                }
            };
            this.contentLength = byteString.size();
            return this;
        }

        public final Builder content(final byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (this.writeTo != null) {
                throw new IllegalStateException("content() can only be called once".toString());
            }
            this.writeTo = new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.DefaultUpload$Builder$content$5$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BufferedSink bufferedSink) throws IOException {
                    invoke2(bufferedSink);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write(byteArray);
                }
            };
            this.contentLength = byteArray.length;
            return this;
        }

        public final Builder contentType(String contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        public final Builder contentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        public final Builder fileName(String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            this.fileName = fileName;
            return this;
        }

        public final DefaultUpload build() {
            Function1<? super BufferedSink, Unit> function1 = this.writeTo;
            if (function1 == null) {
                throw new IllegalStateException("DefaultUpload content is missing".toString());
            }
            String str = this.contentType;
            if (str == null) {
                str = "application/octet-stream";
            }
            return new DefaultUpload(function1, str, this.contentLength, this.fileName);
        }
    }
}
