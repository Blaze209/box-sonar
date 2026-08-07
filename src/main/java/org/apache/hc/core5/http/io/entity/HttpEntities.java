package org.apache.hc.core5.http.io.entity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.io.IOCallback;
import org.apache.hc.core5.net.WWWFormCodec;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpEntities {
    private HttpEntities() {
    }

    public static HttpEntity create(String str, ContentType contentType) {
        return new StringEntity(str, contentType);
    }

    public static HttpEntity create(String str, Charset charset) {
        return new StringEntity(str, ContentType.TEXT_PLAIN.withCharset(charset));
    }

    public static HttpEntity create(String str) {
        return new StringEntity(str, ContentType.TEXT_PLAIN);
    }

    public static HttpEntity create(byte[] bArr, ContentType contentType) {
        return new ByteArrayEntity(bArr, contentType);
    }

    public static HttpEntity create(File file, ContentType contentType) {
        return new FileEntity(file, contentType);
    }

    public static HttpEntity create(Serializable serializable, ContentType contentType) {
        return new SerializableEntity(serializable, contentType);
    }

    public static HttpEntity createUrlEncoded(Iterable<? extends NameValuePair> iterable, Charset charset) {
        ContentType contentTypeWithCharset = charset != null ? ContentType.APPLICATION_FORM_URLENCODED.withCharset(charset) : ContentType.APPLICATION_FORM_URLENCODED;
        return create(WWWFormCodec.format(iterable, contentTypeWithCharset.getCharset()), contentTypeWithCharset);
    }

    public static HttpEntity create(IOCallback<OutputStream> iOCallback, ContentType contentType) {
        return new EntityTemplate(-1L, contentType, null, iOCallback);
    }

    public static HttpEntity gzip(HttpEntity httpEntity) {
        return new HttpEntityWrapper(httpEntity) { // from class: org.apache.hc.core5.http.io.entity.HttpEntities.1
            @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
            public long getContentLength() {
                return -1L;
            }

            @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
            public String getContentEncoding() {
                return "gzip";
            }

            @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
            public InputStream getContent() throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
            public void writeTo(OutputStream outputStream) throws IOException {
                Args.notNull(outputStream, "Output stream");
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                super.writeTo(gZIPOutputStream);
                gZIPOutputStream.close();
            }
        };
    }

    public static HttpEntity createGzipped(String str, ContentType contentType) {
        return gzip(create(str, contentType));
    }

    public static HttpEntity createGzipped(String str, Charset charset) {
        return gzip(create(str, charset));
    }

    public static HttpEntity createGzipped(String str) {
        return gzip(create(str));
    }

    public static HttpEntity createGzipped(byte[] bArr, ContentType contentType) {
        return gzip(create(bArr, contentType));
    }

    public static HttpEntity createGzipped(File file, ContentType contentType) {
        return gzip(create(file, contentType));
    }

    public static HttpEntity createGzipped(Serializable serializable, ContentType contentType) {
        return gzip(create(serializable, contentType));
    }

    public static HttpEntity createGzipped(IOCallback<OutputStream> iOCallback, ContentType contentType) {
        return gzip(create(iOCallback, contentType));
    }

    public static HttpEntity createGzipped(Path path, ContentType contentType) {
        return gzip(create(path, contentType));
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.io.entity.HttpEntities$2, reason: invalid class name */
    static class AnonymousClass2 extends HttpEntityWrapper {
        final /* synthetic */ Header[] val$trailers;

        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
        public long getContentLength() {
            return -1L;
        }

        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
        public boolean isChunked() {
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpEntity httpEntity, Header[] headerArr) {
            super(httpEntity);
            this.val$trailers = headerArr;
        }

        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
        public Supplier<List<? extends Header>> getTrailers() {
            final Header[] headerArr = this.val$trailers;
            return new Supplier() { // from class: org.apache.hc.core5.http.io.entity.HttpEntities$2$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.function.Supplier
                public final Object get() {
                    return Arrays.asList(headerArr);
                }
            };
        }

        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
        public Set<String> getTrailerNames() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Header header : this.val$trailers) {
                linkedHashSet.add(header.getName());
            }
            return linkedHashSet;
        }
    }

    public static HttpEntity withTrailers(HttpEntity httpEntity, Header... headerArr) {
        return new AnonymousClass2(httpEntity, headerArr);
    }

    public static HttpEntity create(String str, ContentType contentType, Header... headerArr) {
        return withTrailers(create(str, contentType), headerArr);
    }

    public static HttpEntity create(String str, Charset charset, Header... headerArr) {
        return withTrailers(create(str, charset), headerArr);
    }

    public static HttpEntity create(String str, Header... headerArr) {
        return withTrailers(create(str), headerArr);
    }

    public static HttpEntity create(byte[] bArr, ContentType contentType, Header... headerArr) {
        return withTrailers(create(bArr, contentType), headerArr);
    }

    public static HttpEntity create(File file, ContentType contentType, Header... headerArr) {
        return withTrailers(create(file, contentType), headerArr);
    }

    public static HttpEntity create(Serializable serializable, ContentType contentType, Header... headerArr) {
        return withTrailers(create(serializable, contentType), headerArr);
    }

    public static HttpEntity create(IOCallback<OutputStream> iOCallback, ContentType contentType, Header... headerArr) {
        return withTrailers(create(iOCallback, contentType), headerArr);
    }

    public static HttpEntity create(Path path, ContentType contentType) {
        return new PathEntity(path, contentType);
    }

    public static HttpEntity create(Path path, ContentType contentType, Header... headerArr) {
        return withTrailers(create(path, contentType), headerArr);
    }
}
