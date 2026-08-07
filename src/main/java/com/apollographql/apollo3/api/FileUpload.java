package com.apollographql.apollo3.api;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.io.File;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: FileUpload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003¨\u0006\f"}, d2 = {PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/api/Upload;", "mimetype", "", "filePath", "content", "Lcom/apollographql/apollo3/api/DefaultUpload$Builder;", "file", "Ljava/io/File;", "toUpload", "Lcom/apollographql/apollo3/api/DefaultUpload;", "contentType", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FileUpload {
    @Deprecated(message = "Use File.toUpload() instead")
    public static final DefaultUpload.Builder content(DefaultUpload.Builder builder, final File file) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        return builder.content(new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.FileUpload.content.1
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
                BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(file));
                try {
                    sink.writeAll(bufferedSourceBuffer);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedSourceBuffer, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedSourceBuffer, th);
                        throw th2;
                    }
                }
            }
        }).contentLength(file.length());
    }

    public static final DefaultUpload toUpload(final File file, String contentType) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        DefaultUpload.Builder builderContentType = new DefaultUpload.Builder().content(new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.FileUpload.toUpload.1
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
                BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(file));
                try {
                    sink.writeAll(bufferedSourceBuffer);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedSourceBuffer, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedSourceBuffer, th);
                        throw th2;
                    }
                }
            }
        }).contentLength(file.length()).contentType(contentType);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return builderContentType.fileName(name).build();
    }

    @Deprecated(message = "This is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "File(filePath).toUpload(mimetype)", imports = {"java.io.File"}))
    public static final Upload create(String mimetype, String filePath) {
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return toUpload(new File(filePath), mimetype);
    }
}
