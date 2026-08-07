package com.pspdfkit.internal;

import com.pspdfkit.instant.internal.jni.NativeHTTPDownloadEventHandler;
import com.pspdfkit.instant.internal.jni.NativeHTTPError;
import com.pspdfkit.instant.internal.jni.NativeHTTPRequest;
import com.pspdfkit.instant.internal.jni.NativeHTTPRequestState;
import com.pspdfkit.instant.internal.jni.NativeHTTPResponse;
import com.pspdfkit.instant.internal.jni.NativeHTTPUploadEventHandler;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes3.dex */
public final class wj extends NativeHTTPRequest implements Callback {
    public final sj a;
    public final int b;
    public final String c;
    public final HashMap<String, String> d;
    public final byte[] e;
    public final String f;
    public NativeHTTPDownloadEventHandler g;
    public NativeHTTPUploadEventHandler h;
    public Call i;
    public NativeHTTPRequestState j = NativeHTTPRequestState.IDLE;

    /* JADX WARN: Incorrect types in method signature: (Lcom/pspdfkit/internal/sj;Ljava/lang/Object;Ljava/lang/String;[BLjava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;Lcom/pspdfkit/instant/internal/jni/NativeHTTPDownloadEventHandler;Lcom/pspdfkit/instant/internal/jni/NativeHTTPUploadEventHandler;)V */
    public wj(sj sjVar, int i, String str, byte[] bArr, String str2, HashMap map, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler) {
        this.a = sjVar;
        this.b = i;
        this.c = str;
        this.e = bArr;
        this.f = str2;
        this.d = map;
        this.g = nativeHTTPDownloadEventHandler;
        this.h = nativeHTTPUploadEventHandler;
    }

    public final NativeHTTPResponse a(Call call, Response response, boolean z) {
        if (call != this.i) {
            throw new IllegalStateException("Cannot handle events for unrelated http call " + call);
        }
        try {
            if (b()) {
                return null;
            }
            if (!response.isSuccessful() && response.code() >= 200 && (response.code() < 300 || response.code() >= 400)) {
                return b(response, z);
            }
            return a(response, z);
        } finally {
            xg.a(response);
        }
    }

    public final NativeHTTPResponse b(Response response, boolean z) {
        NativeHTTPError nativeHTTPError;
        NativeHTTPResponse nativeHTTPResponse;
        if (!a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.FAILED)) {
            return null;
        }
        if (this.g == null && this.h == null && !z) {
            return null;
        }
        if (response.code() < 400) {
            throw new IllegalStateException("Publishing error response with unsupported response code: " + response.code());
        }
        int iCode = response.code();
        if (iCode < 500 || iCode > 599) {
            nativeHTTPError = (iCode < 400 || iCode > 499) ? NativeHTTPError.UNKNOWN : NativeHTTPError.INVALID_REQUEST;
        } else {
            nativeHTTPError = NativeHTTPError.SERVER_HICCUP;
        }
        String strMessage = response.message();
        try {
            nativeHTTPResponse = new NativeHTTPResponse(response.code(), lr.a(response.headers()), response.body().bytes());
        } catch (IOException unused) {
            nativeHTTPResponse = new NativeHTTPResponse(response.code(), lr.a(response.headers()), null);
        }
        NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler = this.g;
        if (nativeHTTPDownloadEventHandler != null) {
            nativeHTTPDownloadEventHandler.onResponse(this, nativeHTTPResponse);
            this.g.onFailure(this, nativeHTTPError, strMessage, nativeHTTPResponse);
        }
        NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler = this.h;
        if (nativeHTTPUploadEventHandler != null) {
            nativeHTTPUploadEventHandler.onResponse(this, nativeHTTPResponse);
            this.h.onFailure(this, nativeHTTPError, strMessage, nativeHTTPResponse);
        }
        return nativeHTTPResponse;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final void cancel() {
        if (a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.CANCELLED)) {
            a().cancel();
            NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler = this.h;
            if (nativeHTTPUploadEventHandler != null) {
                nativeHTTPUploadEventHandler.onFailure(this, NativeHTTPError.USER_CANCELLED, null, null);
            }
            NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler = this.g;
            if (nativeHTTPDownloadEventHandler != null) {
                nativeHTTPDownloadEventHandler.onFailure(this, NativeHTTPError.USER_CANCELLED, null, null);
            }
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final byte[] getBodyData() {
        return this.e;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final NativeHTTPDownloadEventHandler getDownloadEventHandler() {
        return this.g;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final String getFilePath() {
        return this.f;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final HashMap<String, String> getHeaders() {
        return lr.a(a().request().headers());
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final NativeHTTPRequestState getRequestState() {
        return this.j;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final NativeHTTPUploadEventHandler getUploadEventHandler() {
        return this.h;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final String getUri() {
        return this.c;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        if (a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.FAILED)) {
            NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler = this.g;
            if (nativeHTTPDownloadEventHandler != null) {
                nativeHTTPDownloadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, iOException.getMessage(), null);
            }
            NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler = this.h;
            if (nativeHTTPUploadEventHandler != null) {
                nativeHTTPUploadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, iOException.getMessage(), null);
            }
        }
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) throws IOException {
        if (this.g == null && this.h == null) {
            return;
        }
        a(call, response, false);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final NativeHTTPResponse stallThisThread() throws Throwable {
        Response responseExecute;
        Response response = null;
        if (!a(NativeHTTPRequestState.IDLE, NativeHTTPRequestState.RUNNING)) {
            return null;
        }
        this.h = null;
        this.g = null;
        try {
            Call callA = a();
            if (b()) {
                return null;
            }
            responseExecute = callA.execute();
            try {
                try {
                    NativeHTTPResponse nativeHTTPResponseA = a(callA, responseExecute, true);
                    xg.a(responseExecute);
                    return nativeHTTPResponseA;
                } catch (IOException e) {
                    e = e;
                    onFailure(this.i, e);
                    xg.a(responseExecute);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                response = responseExecute;
                xg.a(response);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            responseExecute = null;
        } catch (Throwable th2) {
            th = th2;
            xg.a(response);
            throw th;
        }
        onFailure(this.i, e);
        xg.a(responseExecute);
        return null;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
    public final synchronized boolean start() {
        if (!a(NativeHTTPRequestState.IDLE, NativeHTTPRequestState.RUNNING)) {
            return false;
        }
        a().enqueue(this);
        return true;
    }

    public final synchronized boolean b() {
        NativeHTTPRequestState nativeHTTPRequestState = this.j;
        return (nativeHTTPRequestState == NativeHTTPRequestState.RUNNING || nativeHTTPRequestState == NativeHTTPRequestState.IDLE) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0132  */
    /* JADX WARN: Code duplicated, block: B:81:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x013b A[Catch: all -> 0x0166, TRY_ENTER, TryCatch #1 {all -> 0x0166, blocks: (B:77:0x0125, B:82:0x013b, B:83:0x014c, B:85:0x0150, B:86:0x0156, B:88:0x015a), top: B:100:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0150 A[Catch: all -> 0x0166, TryCatch #1 {all -> 0x0166, blocks: (B:77:0x0125, B:82:0x013b, B:83:0x014c, B:85:0x0150, B:86:0x0156, B:88:0x015a), top: B:100:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0156 A[Catch: all -> 0x0166, TryCatch #1 {all -> 0x0166, blocks: (B:77:0x0125, B:82:0x013b, B:83:0x014c, B:85:0x0150, B:86:0x0156, B:88:0x015a), top: B:100:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x015a A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #1 {all -> 0x0166, blocks: (B:77:0x0125, B:82:0x013b, B:83:0x014c, B:85:0x0150, B:86:0x0156, B:88:0x015a), top: B:100:0x0125 }] */
    public final NativeHTTPResponse a(Response response, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        NativeHTTPResponse nativeHTTPResponse;
        FileOutputStream fileOutputStream2;
        BufferedSource source;
        NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler;
        NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler;
        ByteArrayOutputStream byteArrayOutputStream;
        NativeHTTPResponse nativeHTTPResponse2;
        sj sjVar = this.a;
        sjVar.getClass();
        File file = sjVar.a;
        q70.a();
        String string = UUID.randomUUID().toString();
        string.getClass();
        File file2 = new File(file, "pspdfkit_http_".concat(string));
        BufferedSource bufferedSource = null;
        try {
            long j = 0;
            if (this.g != null) {
                file2.getParentFile().mkdirs();
                file2.createNewFile();
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    try {
                        if (b()) {
                            xg.a(fileOutputStream2);
                            return null;
                        }
                        nativeHTTPResponse = new NativeHTTPResponse(response.code(), lr.a(response.headers()), null);
                        try {
                            this.g.onResponse(this, nativeHTTPResponse);
                            NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler2 = this.h;
                            if (nativeHTTPUploadEventHandler2 != null) {
                                nativeHTTPUploadEventHandler2.onResponse(this, nativeHTTPResponse);
                            }
                            fileOutputStream = fileOutputStream2;
                            nativeHTTPResponse2 = nativeHTTPResponse;
                            byteArrayOutputStream = null;
                        } catch (IOException unused) {
                            source = null;
                            try {
                                file2.delete();
                                if (!a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.FAILED)) {
                                    xg.a(source);
                                    xg.a(fileOutputStream2);
                                    return null;
                                }
                                if (nativeHTTPResponse == null) {
                                    nativeHTTPResponse = new NativeHTTPResponse(response.code(), lr.a(response.headers()), null);
                                }
                                nativeHTTPDownloadEventHandler = this.g;
                                if (nativeHTTPDownloadEventHandler != null) {
                                    nativeHTTPDownloadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, null, nativeHTTPResponse);
                                } else {
                                    nativeHTTPUploadEventHandler = this.h;
                                    if (nativeHTTPUploadEventHandler != null) {
                                        nativeHTTPUploadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, null, nativeHTTPResponse);
                                    }
                                }
                                xg.a(source);
                                xg.a(fileOutputStream2);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                bufferedSource = source;
                                fileOutputStream2 = fileOutputStream;
                                xg.a(bufferedSource);
                                xg.a(fileOutputStream2);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        xg.a(bufferedSource);
                        xg.a(fileOutputStream2);
                        throw th;
                    }
                } catch (IOException unused2) {
                    nativeHTTPResponse = null;
                    source = null;
                }
            } else {
                if (this.h == null && !z) {
                    return null;
                }
                long contentLength = response.body().getContentLength();
                byteArrayOutputStream = new ByteArrayOutputStream(contentLength >= 0 ? (int) contentLength : 16384);
                nativeHTTPResponse2 = null;
                fileOutputStream = null;
            }
            try {
                source = response.body().getSource();
                try {
                    byte[] bArr = new byte[16384];
                    long jCurrentTimeMillis = 0;
                    while (true) {
                        int i = source.read(bArr);
                        if (i == -1 || b()) {
                            break;
                            break;
                        }
                        j += (long) i;
                        if (fileOutputStream != null) {
                            fileOutputStream.write(bArr, 0, i);
                            if (System.currentTimeMillis() > jCurrentTimeMillis + 100) {
                                synchronized (this) {
                                    if (!b()) {
                                        this.g.onProgress(this, j);
                                        jCurrentTimeMillis = System.currentTimeMillis();
                                    }
                                }
                                break;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        nativeHTTPResponse2 = new NativeHTTPResponse(response.code(), lr.a(response.headers()), byteArrayOutputStream.toByteArray());
                    }
                    xg.a(source);
                    xg.a(fileOutputStream);
                    if (!a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.SUCCEEDED)) {
                        return null;
                    }
                    NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler2 = this.g;
                    if (nativeHTTPDownloadEventHandler2 != null) {
                        nativeHTTPDownloadEventHandler2.onSuccess(this, file2.getAbsolutePath());
                        file2.delete();
                        return nativeHTTPResponse2;
                    }
                    NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler3 = this.h;
                    if (nativeHTTPUploadEventHandler3 != null) {
                        nativeHTTPUploadEventHandler3.onResponse(this, nativeHTTPResponse2);
                    }
                    return nativeHTTPResponse2;
                } catch (IOException unused3) {
                    nativeHTTPResponse = nativeHTTPResponse2;
                    fileOutputStream2 = fileOutputStream;
                    file2.delete();
                    if (!a(NativeHTTPRequestState.RUNNING, NativeHTTPRequestState.FAILED)) {
                        xg.a(source);
                        xg.a(fileOutputStream2);
                        return null;
                    }
                    if (nativeHTTPResponse == null) {
                        nativeHTTPResponse = new NativeHTTPResponse(response.code(), lr.a(response.headers()), null);
                    }
                    nativeHTTPDownloadEventHandler = this.g;
                    if (nativeHTTPDownloadEventHandler != null) {
                        nativeHTTPDownloadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, null, nativeHTTPResponse);
                    } else {
                        nativeHTTPUploadEventHandler = this.h;
                        if (nativeHTTPUploadEventHandler != null) {
                            nativeHTTPUploadEventHandler.onFailure(this, NativeHTTPError.CONNECTION_DROPPED, null, nativeHTTPResponse);
                        }
                    }
                    xg.a(source);
                    xg.a(fileOutputStream2);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedSource = source;
                    fileOutputStream2 = fileOutputStream;
                    xg.a(bufferedSource);
                    xg.a(fileOutputStream2);
                    throw th;
                }
            } catch (IOException unused4) {
                source = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                xg.a(bufferedSource);
                xg.a(fileOutputStream2);
                throw th;
            }
        } catch (IOException unused5) {
            nativeHTTPResponse = null;
            fileOutputStream2 = null;
            source = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public final boolean a(NativeHTTPRequestState nativeHTTPRequestState, NativeHTTPRequestState nativeHTTPRequestState2) {
        synchronized (this) {
            if (this.j != nativeHTTPRequestState) {
                return false;
            }
            this.j = nativeHTTPRequestState2;
            return true;
        }
    }

    public final synchronized Call a() {
        if (this.i == null) {
            Request.Builder builder = new Request.Builder();
            builder.url(this.c);
            HashMap<String, String> map = this.d;
            MediaType mediaType = null;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        builder.addHeader(entry.getKey(), entry.getValue());
                        if (entry.getKey().equalsIgnoreCase("Content-Type")) {
                            mediaType = MediaType.parse(entry.getValue());
                        }
                    }
                }
            }
            int iA = y30.a(this.b);
            if (iA == 0) {
                builder.get();
            } else if (iA == 1) {
                builder.post(a(mediaType));
            } else if (iA == 2) {
                builder.put(a(mediaType));
            } else if (iA == 3) {
                builder.delete(a(mediaType));
            }
            sj sjVar = this.a;
            this.i = sjVar.b.newCall(builder.build());
        }
        return this.i;
    }

    public final RequestBody a(MediaType mediaType) {
        int i = this.b;
        if (i != 3 && i != 2 && i != 4) {
            throw new IllegalStateException("Can't create request body for method: ".concat(vj.a(i)));
        }
        byte[] bArr = this.e;
        if (bArr != null) {
            return new tj(this, mediaType, bArr);
        }
        if (this.f != null) {
            return new uj(this, mediaType, new File(this.f));
        }
        throw new IllegalStateException("Body data was not specified.");
    }

    public final void a(Source source, BufferedSink bufferedSink) throws IOException {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(source);
            byte[] bArr = new byte[16384];
            long j = 0;
            long jCurrentTimeMillis = 0;
            while (true) {
                int i = bufferedSourceBuffer.read(bArr);
                if (i == -1) {
                    break;
                }
                j += (long) i;
                bufferedSink.write(bArr, 0, i);
                if (this.h != null && System.currentTimeMillis() > 100 + jCurrentTimeMillis) {
                    synchronized (this) {
                        if (!b()) {
                            this.h.onProgress(this, j);
                            jCurrentTimeMillis = System.currentTimeMillis();
                        }
                    }
                    break;
                }
            }
            xg.a(source);
        } catch (Throwable th) {
            xg.a(source);
            throw th;
        }
    }
}
