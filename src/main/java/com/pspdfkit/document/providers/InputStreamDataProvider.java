package com.pspdfkit.document.providers;

import android.system.ErrnoException;
import android.system.OsConstants;
import com.pspdfkit.utils.PdfLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InputStreamDataProvider extends ContextDataProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final String LOG_TAG = "Nutri.InputStreamDataProv";
    private final ConcurrentHashMap<Thread, InputStream> inputStreams = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Thread, FileChannel> fileChannels = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Thread, Long> inputStreamPositions = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Thread, byte[]> tmpBuffers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Thread, ByteBuffer> tmpBufferBBs = new ConcurrentHashMap<>();
    private boolean isFileStreamSeekable = true;

    private FileChannel fileChannelForCurrentThread() {
        return this.fileChannels.get(Thread.currentThread());
    }

    private InputStream inputStreamForCurrentThread() {
        return this.inputStreams.get(Thread.currentThread());
    }

    private boolean isExceptionFromIllegalSeek(IOException iOException) {
        return (iOException.getCause() instanceof ErrnoException) && ((ErrnoException) iOException.getCause()).errno == OsConstants.ESPIPE;
    }

    public void finalize() throws Throwable {
        try {
            release();
        } finally {
            super.finalize();
        }
    }

    public InputStream getInputStream() throws Exception {
        if (inputStreamForCurrentThread() == null) {
            reopenInputStream();
        }
        return inputStreamForCurrentThread();
    }

    public long getInputStreamPosition() {
        Long l = this.inputStreamPositions.get(Thread.currentThread());
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public abstract InputStream openInputStream() throws Exception;

    @Override // com.pspdfkit.document.providers.DataProvider
    public byte[] read(long j, long j2) {
        byte[] bArr = this.tmpBuffers.get(Thread.currentThread());
        ByteBuffer byteBufferWrap = this.tmpBufferBBs.get(Thread.currentThread());
        if (bArr == null || byteBufferWrap == null || j > bArr.length) {
            bArr = new byte[(int) Math.max(262144L, j)];
            this.tmpBuffers.put(Thread.currentThread(), bArr);
            byteBufferWrap = ByteBuffer.wrap(bArr);
            this.tmpBufferBBs.put(Thread.currentThread(), byteBufferWrap);
        }
        ByteBuffer byteBuffer = byteBufferWrap;
        byte[] bArr2 = bArr;
        long inputStreamPosition = getInputStreamPosition();
        try {
            try {
                if (inputStreamForCurrentThread() == null || inputStreamPosition > j2) {
                    reopenInputStream();
                    inputStreamPosition = 0;
                }
                InputStream inputStreamInputStreamForCurrentThread = inputStreamForCurrentThread();
                FileChannel fileChannelFileChannelForCurrentThread = fileChannelForCurrentThread();
                if (fileChannelFileChannelForCurrentThread != null) {
                    try {
                        byteBuffer.rewind();
                        fileChannelFileChannelForCurrentThread.read(byteBuffer, j2);
                        PdfLog.v(LOG_TAG, "Read %d from stream via FileChannel at offset %d.", Long.valueOf(j), Long.valueOf(j2));
                        this.inputStreamPositions.put(Thread.currentThread(), Long.valueOf(inputStreamPosition));
                        return bArr2;
                    } catch (ClosedChannelException e) {
                        PdfLog.v(LOG_TAG, "FileChannel is closed. Removing closed channel and falling back to stream access.", new Object[0]);
                        this.fileChannels.remove(Thread.currentThread());
                        if (e instanceof ClosedByInterruptException) {
                            Thread.interrupted();
                        }
                        reopenInputStream();
                        inputStreamInputStreamForCurrentThread = inputStreamForCurrentThread();
                        if (inputStreamInputStreamForCurrentThread == null) {
                            byte[] bArr3 = DataProvider.NO_DATA_AVAILABLE;
                            this.inputStreamPositions.put(Thread.currentThread(), Long.valueOf(inputStreamPosition));
                            return bArr3;
                        }
                        inputStreamPosition = 0;
                    } catch (IOException e2) {
                        if (!isExceptionFromIllegalSeek(e2)) {
                            throw e2;
                        }
                        PdfLog.v(LOG_TAG, "Cannot read data from FileChannel. File descriptor is most likely associated with a pipe, FIFO, or socket. Switching to stream access.", new Object[0]);
                        this.fileChannels.remove(Thread.currentThread());
                        this.isFileStreamSeekable = false;
                    }
                }
                long j3 = j2 - inputStreamPosition;
                PdfLog.v(LOG_TAG, "Need to skip %d bytes to new offset %d", Long.valueOf(j3), Long.valueOf(j2));
                while (j3 > 0) {
                    PdfLog.v(LOG_TAG, "Still %d bytes left to reach final offset %d", Long.valueOf(j3), Long.valueOf(j2));
                    long jSkip = inputStreamInputStreamForCurrentThread.skip(j3);
                    inputStreamPosition += jSkip;
                    j3 -= jSkip;
                    PdfLog.v(LOG_TAG, "Skipped %d bytes to offset %d.", Long.valueOf(jSkip), Long.valueOf(inputStreamPosition));
                }
                int i = (int) j;
                int i2 = 0;
                while (i > 0) {
                    int i3 = inputStreamInputStreamForCurrentThread.read(bArr2, i2, i);
                    if (i3 < 0) {
                        break;
                    }
                    i2 += i3;
                    inputStreamPosition += (long) i3;
                    i -= i3;
                    PdfLog.v(LOG_TAG, "Tried to read %d bytes from stream (actually read %d bytes, %d bytes left). New input position is %d.", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i), Long.valueOf(inputStreamPosition));
                }
                this.inputStreamPositions.put(Thread.currentThread(), Long.valueOf(inputStreamPosition));
                return bArr2;
            } catch (Exception e3) {
                PdfLog.e(LOG_TAG, e3, "Could not read data from stream!", new Object[0]);
                byte[] bArr4 = DataProvider.NO_DATA_AVAILABLE;
                this.inputStreamPositions.put(Thread.currentThread(), Long.valueOf(inputStreamPosition));
                return bArr4;
            }
        } catch (Throwable th) {
            this.inputStreamPositions.put(Thread.currentThread(), Long.valueOf(inputStreamPosition));
            throw th;
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public void release() {
        Iterator<FileChannel> it = this.fileChannels.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
        this.fileChannels.clear();
        Iterator<InputStream> it2 = this.inputStreams.values().iterator();
        while (it2.hasNext()) {
            try {
                it2.next().close();
            } catch (IOException unused2) {
            }
        }
        this.inputStreams.clear();
        this.inputStreamPositions.clear();
        this.tmpBuffers.clear();
        this.tmpBufferBBs.clear();
    }

    public final void reopenInputStream() throws Exception {
        Thread threadCurrentThread = Thread.currentThread();
        InputStream inputStreamInputStreamForCurrentThread = inputStreamForCurrentThread();
        if (inputStreamInputStreamForCurrentThread != null) {
            inputStreamInputStreamForCurrentThread.close();
        }
        InputStream inputStreamOpenInputStream = openInputStream();
        this.inputStreams.put(threadCurrentThread, inputStreamOpenInputStream);
        this.inputStreamPositions.put(Thread.currentThread(), 0L);
        if (this.isFileStreamSeekable && (inputStreamOpenInputStream instanceof FileInputStream)) {
            this.fileChannels.put(threadCurrentThread, ((FileInputStream) inputStreamOpenInputStream).getChannel());
        }
    }
}
