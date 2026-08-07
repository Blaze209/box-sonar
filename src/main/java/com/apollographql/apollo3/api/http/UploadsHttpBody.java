package com.apollographql.apollo3.api.http;

import com.apollographql.apollo3.api.Upload;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.JsonWriters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DefaultHttpRequestComposer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/apollographql/apollo3/api/http/UploadsHttpBody;", "Lcom/apollographql/apollo3/api/http/HttpBody;", "uploads", "", "", "Lcom/apollographql/apollo3/api/Upload;", "operationByteString", "Lokio/ByteString;", "(Ljava/util/Map;Lokio/ByteString;)V", "boundary", "contentLength", "", "getContentLength", "()J", "contentLength$delegate", "Lkotlin/Lazy;", "contentType", "getContentType", "()Ljava/lang/String;", "buildUploadMap", "writeTo", "", "bufferedSink", "Lokio/BufferedSink;", "writeBoundaries", "writeUploadContents", "", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UploadsHttpBody implements HttpBody {
    private final String boundary;

    /* JADX INFO: renamed from: contentLength$delegate, reason: from kotlin metadata */
    private final Lazy contentLength;
    private final String contentType;
    private final ByteString operationByteString;
    private final Map<String, Upload> uploads;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadsHttpBody(Map<String, ? extends Upload> uploads, ByteString operationByteString) {
        Intrinsics.checkNotNullParameter(uploads, "uploads");
        Intrinsics.checkNotNullParameter(operationByteString, "operationByteString");
        this.uploads = uploads;
        this.operationByteString = operationByteString;
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String string = uuidRandomUUID.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uuid4().toString()");
        this.boundary = string;
        this.contentType = "multipart/form-data; boundary=" + string;
        this.contentLength = LazyKt.lazy(new Function0<Long>() { // from class: com.apollographql.apollo3.api.http.UploadsHttpBody$contentLength$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() throws IOException {
                CountingSink countingSink = new CountingSink(Okio.blackhole());
                BufferedSink bufferedSinkBuffer = Okio.buffer(countingSink);
                this.this$0.writeBoundaries(bufferedSinkBuffer, false);
                bufferedSinkBuffer.flush();
                long bytesWritten = countingSink.getBytesWritten();
                Iterator it = this.this$0.uploads.values().iterator();
                long contentLength = 0;
                while (it.hasNext()) {
                    contentLength += ((Upload) it.next()).getContentLength();
                }
                return Long.valueOf(bytesWritten + contentLength);
            }
        });
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public long getContentLength() {
        return ((Number) this.contentLength.getValue()).longValue();
    }

    @Override // com.apollographql.apollo3.api.http.HttpBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "bufferedSink");
        writeBoundaries(bufferedSink, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeBoundaries(BufferedSink bufferedSink, boolean z) throws IOException {
        bufferedSink.writeUtf8("--" + this.boundary + IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.writeUtf8("Content-Disposition: form-data; name=\"operations\"\r\n");
        bufferedSink.writeUtf8("Content-Type: application/json\r\n");
        bufferedSink.writeUtf8("Content-Length: " + this.operationByteString.size() + IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.write(this.operationByteString);
        ByteString byteStringBuildUploadMap = buildUploadMap(this.uploads);
        bufferedSink.writeUtf8("\r\n--" + this.boundary + IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.writeUtf8("Content-Disposition: form-data; name=\"map\"\r\n");
        bufferedSink.writeUtf8("Content-Type: application/json\r\n");
        bufferedSink.writeUtf8("Content-Length: " + byteStringBuildUploadMap.size() + IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        bufferedSink.write(byteStringBuildUploadMap);
        int i = 0;
        for (Object obj : this.uploads.values()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Upload upload = (Upload) obj;
            bufferedSink.writeUtf8("\r\n--" + this.boundary + IOUtils.LINE_SEPARATOR_WINDOWS);
            bufferedSink.writeUtf8("Content-Disposition: form-data; name=\"" + i + '\"');
            if (upload.getFileName() != null) {
                bufferedSink.writeUtf8("; filename=\"" + upload.getFileName() + '\"');
            }
            bufferedSink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            bufferedSink.writeUtf8("Content-Type: " + upload.getContentType() + IOUtils.LINE_SEPARATOR_WINDOWS);
            long contentLength = upload.getContentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: " + contentLength + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            bufferedSink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            if (z) {
                upload.writeTo(bufferedSink);
            }
            i = i2;
        }
        bufferedSink.writeUtf8("\r\n--" + this.boundary + "--\r\n");
    }

    private final ByteString buildUploadMap(Map<String, ? extends Upload> uploads) {
        Buffer buffer = new Buffer();
        BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(buffer, null);
        Set<Map.Entry<String, ? extends Upload>> setEntrySet = uploads.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        int i = 0;
        for (Object obj : setEntrySet) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(String.valueOf(i), CollectionsKt.listOf(((Map.Entry) obj).getKey())));
            i = i2;
        }
        JsonWriters.writeAny(bufferedSinkJsonWriter, MapsKt.toMap(arrayList));
        return buffer.readByteString();
    }
}
