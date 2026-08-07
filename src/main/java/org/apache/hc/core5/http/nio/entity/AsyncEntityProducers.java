package org.apache.hc.core5.http.nio.entity;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.StreamChannel;
import org.apache.hc.core5.net.WWWFormCodec;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncEntityProducers {
    private AsyncEntityProducers() {
    }

    public static AsyncEntityProducer create(String str, ContentType contentType) {
        return new BasicAsyncEntityProducer(str, contentType);
    }

    public static AsyncEntityProducer create(String str, Charset charset) {
        return new BasicAsyncEntityProducer(str, ContentType.TEXT_PLAIN.withCharset(charset));
    }

    public static AsyncEntityProducer create(String str) {
        return new BasicAsyncEntityProducer(str, ContentType.TEXT_PLAIN);
    }

    public static AsyncEntityProducer create(byte[] bArr, ContentType contentType) {
        return new BasicAsyncEntityProducer(bArr, contentType);
    }

    public static AsyncEntityProducer create(File file, ContentType contentType) {
        return new FileEntityProducer(file, contentType);
    }

    public static AsyncEntityProducer createUrlEncoded(Iterable<? extends NameValuePair> iterable, Charset charset) {
        ContentType contentTypeWithCharset = charset != null ? ContentType.APPLICATION_FORM_URLENCODED.withCharset(charset) : ContentType.APPLICATION_FORM_URLENCODED;
        return create(WWWFormCodec.format(iterable, contentTypeWithCharset.getCharset()), contentTypeWithCharset);
    }

    public static AsyncEntityProducer createBinary(final Callback<StreamChannel<ByteBuffer>> callback, ContentType contentType) {
        return new AbstractBinAsyncEntityProducer(0, contentType) { // from class: org.apache.hc.core5.http.nio.entity.AsyncEntityProducers.1
            @Override // org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityProducer
            protected int availableData() {
                return Integer.MAX_VALUE;
            }

            @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
            public void failed(Exception exc) {
            }

            @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
            public boolean isRepeatable() {
                return false;
            }

            @Override // org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityProducer
            protected void produceData(StreamChannel<ByteBuffer> streamChannel) throws IOException {
                callback.execute(streamChannel);
            }
        };
    }

    public static AsyncEntityProducer createText(final Callback<StreamChannel<CharBuffer>> callback, ContentType contentType) {
        return new AbstractCharAsyncEntityProducer(4096, 2048, contentType) { // from class: org.apache.hc.core5.http.nio.entity.AsyncEntityProducers.2
            @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer
            protected int availableData() {
                return Integer.MAX_VALUE;
            }

            @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
            public void failed(Exception exc) {
            }

            @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
            public boolean isRepeatable() {
                return false;
            }

            @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer
            protected void produceData(StreamChannel<CharBuffer> streamChannel) throws IOException {
                callback.execute(streamChannel);
            }
        };
    }

    public static AsyncEntityProducer withTrailers(AsyncEntityProducer asyncEntityProducer, final Header... headerArr) {
        return new AsyncEntityProducerWrapper(asyncEntityProducer) { // from class: org.apache.hc.core5.http.nio.entity.AsyncEntityProducers.3
            @Override // org.apache.hc.core5.http.nio.entity.AsyncEntityProducerWrapper, org.apache.hc.core5.http.EntityDetails
            public long getContentLength() {
                return -1L;
            }

            @Override // org.apache.hc.core5.http.nio.entity.AsyncEntityProducerWrapper, org.apache.hc.core5.http.EntityDetails
            public boolean isChunked() {
                return true;
            }

            @Override // org.apache.hc.core5.http.nio.entity.AsyncEntityProducerWrapper, org.apache.hc.core5.http.EntityDetails
            public Set<String> getTrailerNames() {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (Header header : headerArr) {
                    linkedHashSet.add(header.getName());
                }
                return linkedHashSet;
            }

            @Override // org.apache.hc.core5.http.nio.entity.AsyncEntityProducerWrapper, org.apache.hc.core5.http.nio.AsyncDataProducer
            public void produce(final DataStreamChannel dataStreamChannel) throws IOException {
                super.produce(new DataStreamChannel() { // from class: org.apache.hc.core5.http.nio.entity.AsyncEntityProducers.3.1
                    @Override // org.apache.hc.core5.http.nio.DataStreamChannel
                    public void requestOutput() {
                        dataStreamChannel.requestOutput();
                    }

                    @Override // org.apache.hc.core5.http.nio.DataStreamChannel, org.apache.hc.core5.http.nio.StreamChannel
                    public int write(ByteBuffer byteBuffer) throws IOException {
                        return dataStreamChannel.write(byteBuffer);
                    }

                    @Override // org.apache.hc.core5.http.nio.DataStreamChannel
                    public void endStream(List<? extends Header> list) throws IOException {
                        List<? extends Header> listAsList;
                        if (list != null && !list.isEmpty()) {
                            listAsList = new ArrayList<>(list);
                            listAsList.addAll(Arrays.asList(headerArr));
                        } else {
                            listAsList = Arrays.asList(headerArr);
                        }
                        dataStreamChannel.endStream(listAsList);
                    }

                    @Override // org.apache.hc.core5.http.nio.StreamChannel
                    public void endStream() throws IOException {
                        dataStreamChannel.endStream();
                    }
                });
            }
        };
    }

    public static AsyncEntityProducer create(String str, ContentType contentType, Header... headerArr) {
        return withTrailers(create(str, contentType), headerArr);
    }

    public static AsyncEntityProducer create(String str, Charset charset, Header... headerArr) {
        return withTrailers(create(str, charset), headerArr);
    }

    public static AsyncEntityProducer create(String str, Header... headerArr) {
        return withTrailers(create(str), headerArr);
    }

    public static AsyncEntityProducer create(byte[] bArr, ContentType contentType, Header... headerArr) {
        return withTrailers(create(bArr, contentType), headerArr);
    }

    public static AsyncEntityProducer create(File file, ContentType contentType, Header... headerArr) {
        return withTrailers(create(file, contentType), headerArr);
    }

    public static AsyncEntityProducer create(Path path, ContentType contentType, Header... headerArr) throws IOException {
        return withTrailers(new PathEntityProducer(path, contentType, StandardOpenOption.READ), headerArr);
    }

    public static AsyncEntityProducer create(Path path, ContentType contentType, OpenOption... openOptionArr) throws IOException {
        return new PathEntityProducer(path, contentType, openOptionArr);
    }

    public static AsyncEntityProducer createBinary(Callback<StreamChannel<ByteBuffer>> callback, ContentType contentType, Header... headerArr) {
        return withTrailers(createBinary(callback, contentType), headerArr);
    }

    public static AsyncEntityProducer createText(Callback<StreamChannel<CharBuffer>> callback, ContentType contentType, Header... headerArr) {
        return withTrailers(createText(callback, contentType), headerArr);
    }
}
