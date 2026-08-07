package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class UsbSmartCardConnection extends UsbYubiKeyConnection implements SmartCardConnection {
    private static final byte POWER_ON_MESSAGE_TYPE = 98;
    private static final byte REQUEST_MESSAGE_TYPE = 111;
    private static final byte RESPONSE_DATA_BLOCK = -128;
    private static final byte STATUS_TIME_EXTENSION = -128;
    private static final int TIMEOUT = 1000;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbSmartCardConnection.class);
    private final byte[] atr;
    private final UsbDeviceConnection connection;
    private final UsbEndpoint endpointIn;
    private final UsbEndpoint endpointOut;
    private byte sequence;

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public boolean isExtendedLengthApduSupported() {
        return true;
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.UsbYubiKeyConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    UsbSmartCardConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface, UsbEndpoint usbEndpoint, UsbEndpoint usbEndpoint2) throws IOException {
        super(usbDeviceConnection, usbInterface);
        this.sequence = (byte) 0;
        this.connection = usbDeviceConnection;
        this.endpointIn = usbEndpoint;
        this.endpointOut = usbEndpoint2;
        this.atr = transceive(POWER_ON_MESSAGE_TYPE, new byte[0]);
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public Transport getTransport() {
        return Transport.USB;
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] sendAndReceive(byte[] bArr) throws IOException {
        return transceive(REQUEST_MESSAGE_TYPE, bArr);
    }

    @Override // com.yubico.yubikit.core.smartcard.SmartCardConnection
    public byte[] getAtr() {
        return (byte[]) this.atr.clone();
    }

    private byte[] transceive(byte b, byte[] bArr) throws IOException {
        int length = bArr.length;
        byte b2 = this.sequence;
        this.sequence = (byte) (b2 + 1);
        MessageHeader messageHeader = new MessageHeader(b, length, b2);
        byte[] bArrArray = ByteBuffer.allocate(messageHeader.size() + bArr.length).order(ByteOrder.LITTLE_ENDIAN).put(messageHeader.array()).put(bArr).array();
        int iBulkTransfer = 0;
        int i = 0;
        while (true) {
            if (i >= bArrArray.length && iBulkTransfer != this.endpointOut.getMaxPacketSize()) {
                break;
            }
            iBulkTransfer = this.connection.bulkTransfer(this.endpointOut, bArrArray, i, bArrArray.length - i, 1000);
            if (iBulkTransfer <= 0) {
                if (iBulkTransfer >= 0) {
                    break;
                }
                throw new IOException("Failed to send " + (bArrArray.length - i) + " bytes");
            }
            com.yubico.yubikit.core.internal.Logger.trace(logger, "{} bytes sent over ccid: {}", Integer.valueOf(iBulkTransfer), StringUtils.bytesToHex(bArrArray, i, iBulkTransfer));
            i += iBulkTransfer;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int maxPacketSize = this.endpointIn.getMaxPacketSize();
        byte[] bArr2 = new byte[maxPacketSize];
        boolean z = false;
        boolean z2 = false;
        MessageHeader messageHeader2 = null;
        while (true) {
            int iBulkTransfer2 = this.connection.bulkTransfer(this.endpointIn, bArr2, maxPacketSize, 1000);
            if (iBulkTransfer2 > 0) {
                Logger logger2 = logger;
                com.yubico.yubikit.core.internal.Logger.trace(logger2, "{} bytes received: {}", Integer.valueOf(iBulkTransfer2), StringUtils.bytesToHex(bArr2, 0, iBulkTransfer2));
                if (z) {
                    byteArrayOutputStream.write(bArr2, 0, iBulkTransfer2);
                } else {
                    messageHeader2 = new MessageHeader(bArr2);
                    z2 = (messageHeader2.status & (-128)) == -128;
                    if (messageHeader2.verify((byte) (this.sequence - 1))) {
                        byteArrayOutputStream.write(bArr2, 0, iBulkTransfer2);
                        z = true;
                    } else if (messageHeader2.error != 0 && !z2) {
                        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Invalid response from card reader bStatus={} and bError={}", String.format(Locale.ROOT, "0x%02X", Byte.valueOf(messageHeader2.status)), String.format(Locale.ROOT, "0x%02X", Byte.valueOf(messageHeader2.error)));
                        throw new IOException("Invalid response from card reader");
                    }
                }
            } else if (iBulkTransfer2 < 0) {
                throw new IOException("Failed to read response");
            }
            if (iBulkTransfer2 <= 0 || iBulkTransfer2 != maxPacketSize) {
                if (!z2) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (messageHeader2 == null || byteArray.length < messageHeader2.size()) {
                        throw new IOException("Response is invalid");
                    }
                    return Arrays.copyOfRange(byteArray, messageHeader2.size(), messageHeader2.size() + Math.min(byteArray.length - messageHeader2.size(), messageHeader2.dataLength));
                }
            }
        }
    }

    private static class MessageHeader {
        private static final byte[] MESSAGE_SPECIFIC_BYTES = {0, 0, 0};
        private static final int SIZE_OF_CCID_PREFIX = 10;
        private static final byte SLOT_NUMBER = 0;
        private int dataLength;
        private byte error;
        private byte messageSpecificByte;
        private byte sequence;
        private byte slot;
        private byte status;
        private byte type;

        /* JADX INFO: Access modifiers changed from: private */
        public int size() {
            return 10;
        }

        private MessageHeader(byte[] bArr) {
            if (bArr.length > 10) {
                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, 0, 10).order(ByteOrder.LITTLE_ENDIAN);
                this.type = byteBufferOrder.get();
                this.dataLength = byteBufferOrder.getInt();
                this.slot = byteBufferOrder.get();
                this.sequence = byteBufferOrder.get();
                this.status = byteBufferOrder.get();
                this.error = byteBufferOrder.get();
                this.messageSpecificByte = byteBufferOrder.get();
            }
        }

        private MessageHeader(byte b, int i, byte b2) {
            this.type = b;
            this.dataLength = i;
            this.slot = (byte) 0;
            this.sequence = b2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] array() {
            return ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN).put(this.type).putInt(this.dataLength).put(this.slot).put(this.sequence).put(MESSAGE_SPECIFIC_BYTES).array();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean verify(byte b) {
            return this.type == -128 && this.slot == 0 && this.sequence == b && this.status == 0;
        }
    }
}
