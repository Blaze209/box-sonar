package com.apollographql.apollo3.api;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: DefaultUpload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"toUpload", "Lcom/apollographql/apollo3/api/Upload;", "Lokio/Path;", "contentType", "", "fileSystem", "Lokio/FileSystem;", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DefaultUploadKt {
    public static /* synthetic */ Upload toUpload$default(Path path, String str, FileSystem fileSystem, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = _systemFileSystemKt.getSystemFileSystem();
        }
        return toUpload(path, str, fileSystem);
    }

    public static final Upload toUpload(final Path path, String contentType, final FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        DefaultUpload.Builder builderContentType = new DefaultUpload.Builder().content(new Function1<BufferedSink, Unit>() { // from class: com.apollographql.apollo3.api.DefaultUploadKt.toUpload.1
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
                Throwable th;
                Intrinsics.checkNotNullParameter(sink, "sink");
                FileHandle fileHandleOpenReadOnly = fileSystem.openReadOnly(path);
                try {
                    th = null;
                    sink.writeAll(Okio.buffer(FileHandle.source$default(fileHandleOpenReadOnly, 0L, 1, null)));
                    Unit unit = Unit.INSTANCE;
                    if (fileHandleOpenReadOnly != null) {
                        try {
                            fileHandleOpenReadOnly.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileHandleOpenReadOnly != null) {
                        try {
                            fileHandleOpenReadOnly.close();
                        } catch (Throwable th4) {
                            ExceptionsKt.addSuppressed(th, th4);
                        }
                    }
                }
                if (th != null) {
                    throw th;
                }
            }
        }).contentType(contentType);
        Long size = fileSystem.metadata(path).getSize();
        return builderContentType.contentLength(size != null ? size.longValue() : -1L).build();
    }
}
