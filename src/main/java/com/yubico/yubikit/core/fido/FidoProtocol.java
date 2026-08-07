package com.yubico.yubikit.core.fido;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.CommandState;
import com.yubico.yubikit.core.util.StringUtils;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class FidoProtocol implements Closeable {
    private static final byte CTAPHID_CANCEL = -111;
    private static final byte CTAPHID_CBOR = -112;
    private static final byte CTAPHID_ERROR = -65;
    private static final byte CTAPHID_INIT = -122;
    private static final byte CTAPHID_KEEPALIVE = -69;
    private static final byte CTAPHID_LOCK = -124;
    private static final byte CTAPHID_MSG = -125;
    private static final byte CTAPHID_PING = -127;
    private static final byte CTAPHID_WINK = -120;
    private static final byte TYPE_INIT = -128;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) FidoProtocol.class);
    private int channelId;
    private final FidoConnection connection;
    private final CommandState defaultState = new CommandState();
    private final Version version;

    public FidoProtocol(FidoConnection fidoConnection) throws IOException {
        this.connection = fidoConnection;
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        this.channelId = -1;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(sendAndReceive(CTAPHID_INIT, bArr, null));
        byte[] bArr2 = new byte[8];
        byteBufferWrap.get(bArr2);
        if (!MessageDigest.isEqual(bArr, bArr2)) {
            throw new IOException("Got wrong nonce!");
        }
        this.channelId = byteBufferWrap.getInt();
        byteBufferWrap.get();
        byte[] bArr3 = new byte[3];
        byteBufferWrap.get(bArr3);
        this.version = Version.fromBytes(bArr3);
        byteBufferWrap.get();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "FIDO connection set up with channel ID: {}", String.format("0x%08x", Integer.valueOf(this.channelId)));
    }

    public byte[] sendAndReceive(byte b, byte[] bArr, @Nullable CommandState commandState) throws IOException {
        if (commandState == null) {
            commandState = this.defaultState;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[64];
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr2);
        byteBufferWrap2.putInt(this.channelId).put(b).putShort((short) byteBufferWrap.remaining());
        byte b2 = 0;
        while (true) {
            byteBufferWrap.get(bArr2, byteBufferWrap2.position(), Math.min(byteBufferWrap.remaining(), byteBufferWrap2.remaining()));
            this.connection.send(bArr2);
            com.yubico.yubikit.core.internal.Logger.trace(logger, "{} bytes sent over fido: {}", 64, StringUtils.bytesToHex(bArr2));
            Arrays.fill(bArr2, (byte) 0);
            byteBufferWrap2.clear();
            byte b3 = (byte) (b2 + 1);
            byteBufferWrap2.putInt(this.channelId).put((byte) (b2 & 127));
            if (!byteBufferWrap.hasRemaining()) {
                break;
            }
            b2 = b3;
        }
        ByteBuffer byteBufferAllocate = null;
        byte b4 = 0;
        while (true) {
            byteBufferWrap2.clear();
            if (commandState.waitForCancel(0L)) {
                Logger logger2 = logger;
                com.yubico.yubikit.core.internal.Logger.debug(logger2, "sending CTAP cancel...");
                Arrays.fill(bArr2, (byte) 0);
                byteBufferWrap2.putInt(this.channelId).put(CTAPHID_CANCEL);
                this.connection.send(bArr2);
                com.yubico.yubikit.core.internal.Logger.trace(logger2, "Sent over fido: {}", StringUtils.bytesToHex(bArr2));
                byteBufferWrap2.clear();
            }
            this.connection.receive(bArr2);
            com.yubico.yubikit.core.internal.Logger.trace(logger, "Received over fido: {}", StringUtils.bytesToHex(bArr2));
            int i = byteBufferWrap2.getInt();
            if (i != this.channelId) {
                throw new IOException(String.format("Wrong Channel ID. Expecting: %d, Got: %d", Integer.valueOf(this.channelId), Integer.valueOf(i)));
            }
            if (byteBufferAllocate == null) {
                byte b5 = byteBufferWrap2.get();
                if (b5 == b) {
                    byteBufferAllocate = ByteBuffer.allocate(byteBufferWrap2.getShort());
                } else {
                    if (b5 != -69) {
                        if (b5 == -65) {
                            throw new IOException(String.format("CTAPHID error: %02x", Byte.valueOf(byteBufferWrap2.get())));
                        }
                        throw new IOException(String.format("Wrong response command. Expecting: %x, Got: %x", Byte.valueOf(b), Byte.valueOf(b5)));
                    }
                    commandState.onKeepAliveStatus(byteBufferWrap2.get());
                }
                if (byteBufferAllocate == null && !byteBufferAllocate.hasRemaining()) {
                    return byteBufferAllocate.array();
                }
            } else {
                byte b6 = byteBufferWrap2.get();
                byte b7 = (byte) (b4 + 1);
                if (b6 != b4) {
                    throw new IOException(String.format("Wrong sequence number. Expecting %d, Got: %d", Integer.valueOf(b7 - 1), Byte.valueOf(b6)));
                }
                b4 = b7;
            }
            byteBufferAllocate.put(bArr2, byteBufferWrap2.position(), Math.min(byteBufferWrap2.remaining(), byteBufferAllocate.remaining()));
            if (byteBufferAllocate == null) {
            }
        }
    }

    public Version getVersion() {
        return this.version;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.connection.close();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "fido connection closed");
    }
}
