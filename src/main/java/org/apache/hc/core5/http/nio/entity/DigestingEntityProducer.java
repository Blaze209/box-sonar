package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DigestingEntityProducer implements AsyncEntityProducer {
    private volatile byte[] digest;
    private final MessageDigest digester;
    private final AsyncEntityProducer wrapped;

    public DigestingEntityProducer(String str, AsyncEntityProducer asyncEntityProducer) {
        this.wrapped = (AsyncEntityProducer) Args.notNull(asyncEntityProducer, "Entity consumer");
        try {
            this.digester = MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalArgumentException("Unsupported digest algorithm: " + str);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public boolean isRepeatable() {
        return this.wrapped.isRepeatable();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.wrapped.getContentLength();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return this.wrapped.getContentType();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return this.wrapped.getContentEncoding();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.wrapped.isChunked();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Set<String> trailerNames = this.wrapped.getTrailerNames();
        if (trailerNames != null) {
            linkedHashSet.addAll(trailerNames);
        }
        linkedHashSet.add("digest-algo");
        linkedHashSet.add("digest");
        return linkedHashSet;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return this.wrapped.available();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(final DataStreamChannel dataStreamChannel) throws IOException {
        this.wrapped.produce(new DataStreamChannel() { // from class: org.apache.hc.core5.http.nio.entity.DigestingEntityProducer.1
            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void requestOutput() {
                dataStreamChannel.requestOutput();
            }

            @Override // org.apache.hc.core5.http.nio.DataStreamChannel, org.apache.hc.core5.http.nio.StreamChannel
            public int write(ByteBuffer byteBuffer) throws IOException {
                ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                int iWrite = dataStreamChannel.write(byteBuffer);
                if (iWrite > 0) {
                    byteBufferDuplicate.limit(byteBufferDuplicate.position() + iWrite);
                    DigestingEntityProducer.this.digester.update(byteBufferDuplicate);
                }
                return iWrite;
            }

            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void endStream(List<? extends Header> list) throws IOException {
                DigestingEntityProducer digestingEntityProducer = DigestingEntityProducer.this;
                digestingEntityProducer.digest = digestingEntityProducer.digester.digest();
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                arrayList.add(new BasicHeader("digest-algo", DigestingEntityProducer.this.digester.getAlgorithm()));
                arrayList.add(new BasicHeader("digest", TextUtils.toHexString(DigestingEntityProducer.this.digest)));
                dataStreamChannel.endStream(arrayList);
            }

            @Override // org.apache.hc.core5.http.nio.StreamChannel
            public void endStream() throws IOException {
                endStream(null);
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public void failed(Exception exc) {
        this.wrapped.failed(exc);
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.wrapped.releaseResources();
    }

    public byte[] getDigest() {
        return this.digest;
    }
}
