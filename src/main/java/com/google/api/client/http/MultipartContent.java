package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import cz.msebera.android.httpclient.entity.mime.MIME;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public class MultipartContent extends AbstractHttpContent {
    static final String NEWLINE = "\r\n";
    private static final String TWO_DASHES = "--";
    private ArrayList<Part> parts;

    public MultipartContent() {
        this("__END_OF_PART__" + UUID.randomUUID().toString() + "__");
    }

    public MultipartContent(String str) {
        super(new HttpMediaType("multipart/related").setParameter("boundary", str));
        this.parts = new ArrayList<>();
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        StreamingContent streamingContent;
        StreamingContent streamingContent2;
        long length;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, getCharset());
        String boundary = getBoundary();
        for (Part part : this.parts) {
            HttpHeaders acceptEncoding = new HttpHeaders().setAcceptEncoding(null);
            if (part.headers != null) {
                acceptEncoding.fromHttpHeaders(part.headers);
            }
            acceptEncoding.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set(MIME.CONTENT_TRANSFER_ENC, (Object) null);
            HttpContent httpContent = part.content;
            if (httpContent != null) {
                acceptEncoding.set(MIME.CONTENT_TRANSFER_ENC, (Object) Arrays.asList(MIME.ENC_BINARY));
                acceptEncoding.setContentType(httpContent.getType());
                HttpEncoding httpEncoding = part.encoding;
                if (httpEncoding == null) {
                    length = httpContent.getLength();
                    streamingContent2 = httpContent;
                } else {
                    acceptEncoding.setContentEncoding(httpEncoding.getName());
                    HttpEncodingStreamingContent httpEncodingStreamingContent = new HttpEncodingStreamingContent(httpContent, httpEncoding);
                    long jComputeLength = AbstractHttpContent.computeLength(httpContent);
                    streamingContent2 = httpEncodingStreamingContent;
                    length = jComputeLength;
                }
                streamingContent = streamingContent2;
                if (length != -1) {
                    acceptEncoding.setContentLength(Long.valueOf(length));
                    streamingContent = streamingContent2;
                }
            } else {
                streamingContent = null;
            }
            outputStreamWriter.write(TWO_DASHES);
            outputStreamWriter.write(boundary);
            outputStreamWriter.write("\r\n");
            HttpHeaders.serializeHeadersForMultipartRequests(acceptEncoding, null, null, outputStreamWriter);
            if (streamingContent != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                streamingContent.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write(TWO_DASHES);
        outputStreamWriter.write(boundary);
        outputStreamWriter.write(TWO_DASHES);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    @Override // com.google.api.client.http.AbstractHttpContent, com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        Iterator<Part> it = this.parts.iterator();
        while (it.hasNext()) {
            if (!it.next().content.retrySupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.api.client.http.AbstractHttpContent
    public MultipartContent setMediaType(HttpMediaType httpMediaType) {
        super.setMediaType(httpMediaType);
        return this;
    }

    public final Collection<Part> getParts() {
        return Collections.unmodifiableCollection(this.parts);
    }

    public MultipartContent addPart(Part part) {
        this.parts.add((Part) Preconditions.checkNotNull(part));
        return this;
    }

    public MultipartContent setParts(Collection<Part> collection) {
        this.parts = new ArrayList<>(collection);
        return this;
    }

    public MultipartContent setContentParts(Collection<? extends HttpContent> collection) {
        this.parts = new ArrayList<>(collection.size());
        Iterator<? extends HttpContent> it = collection.iterator();
        while (it.hasNext()) {
            addPart(new Part(it.next()));
        }
        return this;
    }

    public final String getBoundary() {
        return getMediaType().getParameter("boundary");
    }

    public MultipartContent setBoundary(String str) {
        getMediaType().setParameter("boundary", (String) Preconditions.checkNotNull(str));
        return this;
    }

    public static final class Part {
        HttpContent content;
        HttpEncoding encoding;
        HttpHeaders headers;

        public Part() {
            this(null);
        }

        public Part(HttpContent httpContent) {
            this(null, httpContent);
        }

        public Part(HttpHeaders httpHeaders, HttpContent httpContent) {
            setHeaders(httpHeaders);
            setContent(httpContent);
        }

        public Part setContent(HttpContent httpContent) {
            this.content = httpContent;
            return this;
        }

        public HttpContent getContent() {
            return this.content;
        }

        public Part setHeaders(HttpHeaders httpHeaders) {
            this.headers = httpHeaders;
            return this;
        }

        public HttpHeaders getHeaders() {
            return this.headers;
        }

        public Part setEncoding(HttpEncoding httpEncoding) {
            this.encoding = httpEncoding;
            return this;
        }

        public HttpEncoding getEncoding() {
            return this.encoding;
        }
    }
}
