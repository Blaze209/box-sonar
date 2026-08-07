package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.nio.command.CommandSupport;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.SocketTimeoutExceptionFactory;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class SocksProxyProtocolHandler implements IOEventHandler {
    private static final byte ATYP_DOMAINNAME = 3;
    private static final byte CLIENT_VERSION = 5;
    private static final byte COMMAND_CONNECT = 1;
    private static final int MAX_COMMAND_CONNECT_LENGTH = 262;
    private static final int MAX_DNS_NAME_LENGTH = 255;
    private static final byte NO_AUTHENTICATION_REQUIRED = 0;
    private static final byte SUCCESS = 0;
    private static final byte USERNAME_PASSWORD = 2;
    private static final byte USERNAME_PASSWORD_VERSION = 1;
    private final InternalDataChannel dataChannel;
    private final IOEventHandlerFactory eventHandlerFactory;
    private final IOReactorConfig reactorConfig;
    private final IOSessionRequest sessionRequest;
    private ByteBuffer buffer = ByteBuffer.allocate(512);
    private State state = State.SEND_AUTH;

    private enum State {
        SEND_AUTH,
        RECEIVE_AUTH_METHOD,
        SEND_USERNAME_PASSWORD,
        RECEIVE_AUTH,
        SEND_CONNECT,
        RECEIVE_RESPONSE_CODE,
        RECEIVE_ADDRESS_TYPE,
        RECEIVE_ADDRESS,
        COMPLETE
    }

    SocksProxyProtocolHandler(InternalDataChannel internalDataChannel, IOSessionRequest iOSessionRequest, IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig) {
        this.dataChannel = internalDataChannel;
        this.sessionRequest = iOSessionRequest;
        this.eventHandlerFactory = iOEventHandlerFactory;
        this.reactorConfig = iOReactorConfig;
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void connected(IOSession iOSession) throws IOException {
        this.buffer.put((byte) 5);
        if (this.reactorConfig.getSocksProxyUsername() != null && this.reactorConfig.getSocksProxyPassword() != null) {
            this.buffer.put((byte) 2);
            this.buffer.put((byte) 0);
            this.buffer.put((byte) 2);
        } else {
            this.buffer.put((byte) 1);
            this.buffer.put((byte) 0);
        }
        this.buffer.flip();
        iOSession.setEventMask(4);
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.reactor.SocksProxyProtocolHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State = iArr;
            try {
                iArr[State.SEND_AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.SEND_USERNAME_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.SEND_CONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.RECEIVE_AUTH_METHOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.RECEIVE_AUTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.RECEIVE_ADDRESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.RECEIVE_ADDRESS_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.RECEIVE_RESPONSE_CODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[State.COMPLETE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void outputReady(IOSession iOSession) throws IOException {
        switch (AnonymousClass1.$SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[this.state.ordinal()]) {
            case 1:
                if (writeAndPrepareRead(iOSession, 2)) {
                    iOSession.setEventMask(1);
                    this.state = State.RECEIVE_AUTH_METHOD;
                }
                break;
            case 2:
                if (writeAndPrepareRead(iOSession, 2)) {
                    iOSession.setEventMask(1);
                    this.state = State.RECEIVE_AUTH;
                }
                break;
            case 3:
                if (writeAndPrepareRead(iOSession, 2)) {
                    iOSession.setEventMask(1);
                    this.state = State.RECEIVE_RESPONSE_CODE;
                }
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                iOSession.setEventMask(1);
                break;
        }
    }

    private byte[] cred(String str) throws IOException {
        if (str == null) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        if (bytes.length < 255) {
            return bytes;
        }
        throw new IOException("SOCKS username / password are too long");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:50:0x010c  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Switch 'out' block B:36:0x00b9 for B:14:0x003f already processed. Defaulting to fallback option. */
    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void inputReady(IOSession iOSession, ByteBuffer byteBuffer) throws IOException {
        byte b;
        if (byteBuffer != null) {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException unused) {
                throw new IOException("Unexpected input data");
            }
        }
        int i = 4;
        switch (AnonymousClass1.$SwitchMap$org$apache$hc$core5$reactor$SocksProxyProtocolHandler$State[this.state.ordinal()]) {
            case 1:
            case 2:
            case 3:
                iOSession.setEventMask(4);
                return;
            case 4:
                if (fillBuffer(iOSession)) {
                    this.buffer.flip();
                    byte b2 = this.buffer.get();
                    byte b3 = this.buffer.get();
                    if (b2 != 5) {
                        throw new IOException("SOCKS server returned unsupported version: " + ((int) b2));
                    }
                    if (b3 != 2) {
                        if (b3 == 0) {
                            prepareConnectCommand();
                            iOSession.setEventMask(4);
                            this.state = State.SEND_CONNECT;
                            return;
                        }
                        throw new IOException("SOCKS server return unsupported authentication method: " + ((int) b3));
                    }
                    this.buffer.clear();
                    byte[] bArrCred = cred(this.reactorConfig.getSocksProxyUsername());
                    byte[] bArrCred2 = cred(this.reactorConfig.getSocksProxyPassword());
                    setBufferLimit(bArrCred.length + bArrCred2.length + 3);
                    this.buffer.put((byte) 1);
                    this.buffer.put((byte) bArrCred.length);
                    this.buffer.put(bArrCred);
                    this.buffer.put((byte) bArrCred2.length);
                    this.buffer.put(bArrCred2);
                    this.buffer.flip();
                    iOSession.setEventMask(4);
                    this.state = State.SEND_USERNAME_PASSWORD;
                    return;
                }
                return;
            case 5:
                if (fillBuffer(iOSession)) {
                    this.buffer.flip();
                    this.buffer.get();
                    if (this.buffer.get() != 0) {
                        throw new IOException("Authentication failed for external SOCKS proxy");
                    }
                    prepareConnectCommand();
                    iOSession.setEventMask(4);
                    this.state = State.SEND_CONNECT;
                    return;
                }
                return;
            case 6:
                if (fillBuffer(iOSession)) {
                    this.buffer.clear();
                    this.state = State.COMPLETE;
                    this.dataChannel.upgrade(this.eventHandlerFactory.createHandler(this.dataChannel, this.sessionRequest.attachment));
                    this.sessionRequest.completed(this.dataChannel);
                    this.dataChannel.handleIOEvent(8);
                    return;
                }
                return;
            case 7:
                if (fillBuffer(iOSession)) {
                    this.buffer.flip();
                    this.buffer.get();
                    b = this.buffer.get();
                    if (b != 1) {
                        if (b == 4) {
                            i = 16;
                        } else if (b == 3) {
                            i = this.buffer.get() & 255;
                        } else {
                            throw new IOException("SOCKS server returned unsupported address type: " + ((int) b));
                        }
                    }
                    this.buffer.compact();
                    this.buffer.limit(i + 2);
                    this.state = State.RECEIVE_ADDRESS;
                    if (fillBuffer(iOSession)) {
                        this.buffer.clear();
                        this.state = State.COMPLETE;
                        this.dataChannel.upgrade(this.eventHandlerFactory.createHandler(this.dataChannel, this.sessionRequest.attachment));
                        this.sessionRequest.completed(this.dataChannel);
                        this.dataChannel.handleIOEvent(8);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                if (fillBuffer(iOSession)) {
                    this.buffer.flip();
                    byte b4 = this.buffer.get();
                    byte b5 = this.buffer.get();
                    if (b4 != 5) {
                        throw new IOException("SOCKS server returned unsupported version: " + ((int) b4));
                    }
                    switch (b5) {
                        case 0:
                            this.buffer.compact();
                            this.buffer.limit(3);
                            this.state = State.RECEIVE_ADDRESS_TYPE;
                            if (fillBuffer(iOSession)) {
                                this.buffer.flip();
                                this.buffer.get();
                                b = this.buffer.get();
                                if (b != 1) {
                                    if (b == 4) {
                                        i = 16;
                                    } else if (b == 3) {
                                        i = this.buffer.get() & 255;
                                    } else {
                                        throw new IOException("SOCKS server returned unsupported address type: " + ((int) b));
                                    }
                                }
                                this.buffer.compact();
                                this.buffer.limit(i + 2);
                                this.state = State.RECEIVE_ADDRESS;
                                if (fillBuffer(iOSession)) {
                                    this.buffer.clear();
                                    this.state = State.COMPLETE;
                                    this.dataChannel.upgrade(this.eventHandlerFactory.createHandler(this.dataChannel, this.sessionRequest.attachment));
                                    this.sessionRequest.completed(this.dataChannel);
                                    this.dataChannel.handleIOEvent(8);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 1:
                            throw new IOException("SOCKS: General SOCKS server failure");
                        case 2:
                            throw new IOException("SOCKS5: Connection not allowed by ruleset");
                        case 3:
                            throw new IOException("SOCKS5: Network unreachable");
                        case 4:
                            throw new IOException("SOCKS5: Host unreachable");
                        case 5:
                            throw new IOException("SOCKS5: Connection refused");
                        case 6:
                            throw new IOException("SOCKS5: TTL expired");
                        case 7:
                            throw new IOException("SOCKS5: Command not supported");
                        case 8:
                            throw new IOException("SOCKS5: Address type not supported");
                        default:
                            throw new IOException("SOCKS5: Unexpected SOCKS response code " + ((int) b5));
                    }
                }
                return;
            default:
                return;
        }
    }

    private void prepareConnectCommand() throws IOException {
        this.buffer.clear();
        setBufferLimit(MAX_COMMAND_CONNECT_LENGTH);
        this.buffer.put((byte) 5);
        this.buffer.put((byte) 1);
        this.buffer.put((byte) 0);
        if (!(this.sessionRequest.remoteAddress instanceof InetSocketAddress)) {
            throw new IOException("Unsupported address class: " + this.sessionRequest.remoteAddress.getClass());
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.sessionRequest.remoteAddress;
        if (inetSocketAddress.isUnresolved()) {
            this.buffer.put((byte) 3);
            byte[] bytes = inetSocketAddress.getHostName().getBytes(StandardCharsets.US_ASCII);
            if (bytes.length > 255) {
                throw new IOException("Host name exceeds 255 bytes");
            }
            this.buffer.put((byte) bytes.length);
            this.buffer.put(bytes);
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet4Address) {
                this.buffer.put((byte) 1);
            } else if (address instanceof Inet6Address) {
                this.buffer.put((byte) 4);
            } else {
                throw new IOException("Unsupported remote address class: " + address.getClass().getName());
            }
            this.buffer.put(address.getAddress());
        }
        this.buffer.putShort((short) inetSocketAddress.getPort());
        this.buffer.flip();
    }

    private void setBufferLimit(int i) {
        if (this.buffer.capacity() < i) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.buffer.flip();
            byteBufferAllocate.put(this.buffer);
            this.buffer = byteBufferAllocate;
            return;
        }
        this.buffer.limit(i);
    }

    private boolean writeAndPrepareRead(ByteChannel byteChannel, int i) throws IOException {
        if (!writeBuffer(byteChannel)) {
            return false;
        }
        this.buffer.clear();
        setBufferLimit(i);
        return true;
    }

    private boolean writeBuffer(ByteChannel byteChannel) throws IOException {
        if (this.buffer.hasRemaining()) {
            byteChannel.write(this.buffer);
        }
        return !this.buffer.hasRemaining();
    }

    private boolean fillBuffer(ByteChannel byteChannel) throws IOException {
        if (this.buffer.hasRemaining()) {
            byteChannel.read(this.buffer);
        }
        return !this.buffer.hasRemaining();
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void timeout(IOSession iOSession, Timeout timeout) throws IOException {
        exception(iOSession, SocketTimeoutExceptionFactory.create(timeout));
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void exception(IOSession iOSession, Exception exc) {
        try {
            this.sessionRequest.failed(exc);
        } finally {
            iOSession.close(CloseMode.IMMEDIATE);
            CommandSupport.failCommands(iOSession, exc);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void disconnected(IOSession iOSession) {
        this.sessionRequest.cancel();
        CommandSupport.cancelCommands(iOSession);
    }
}
