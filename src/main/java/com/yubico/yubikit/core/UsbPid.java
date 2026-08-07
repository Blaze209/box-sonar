package com.yubico.yubikit.core;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.facebook.imageutils.TiffUtil;

/* JADX INFO: loaded from: classes3.dex */
public enum UsbPid {
    YKS_OTP(16, YubiKeyType.YKS, 1),
    NEO_OTP(272, YubiKeyType.NEO, 1),
    NEO_OTP_CCID(273, YubiKeyType.NEO, 5),
    NEO_CCID(TiffUtil.TIFF_TAG_ORIENTATION, YubiKeyType.NEO, 4),
    NEO_FIDO(275, YubiKeyType.NEO, 2),
    NEO_OTP_FIDO(276, YubiKeyType.NEO, 3),
    NEO_FIDO_CCID(277, YubiKeyType.NEO, 6),
    NEO_OTP_FIDO_CCID(278, YubiKeyType.NEO, 7),
    SKY_FIDO(288, YubiKeyType.SKY, 2),
    YK4_OTP(1025, YubiKeyType.YK4, 1),
    YK4_FIDO(AnalyticsListener.EVENT_DRM_KEYS_REMOVED, YubiKeyType.YK4, 2),
    YK4_OTP_FIDO(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, YubiKeyType.YK4, 3),
    YK4_CCID(AnalyticsListener.EVENT_PLAYER_RELEASED, YubiKeyType.YK4, 4),
    YK4_OTP_CCID(AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, YubiKeyType.YK4, 5),
    YK4_FIDO_CCID(AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, YubiKeyType.YK4, 6),
    YK4_OTP_FIDO_CCID(AnalyticsListener.EVENT_AUDIO_TRACK_INITIALIZED, YubiKeyType.YK4, 7),
    YKP_OTP_FIDO(1040, YubiKeyType.YKP, 3);

    public final YubiKeyType type;
    public final int usbInterfaces;
    public final int value;

    UsbPid(int i, YubiKeyType yubiKeyType, int i2) {
        this.value = i;
        this.type = yubiKeyType;
        this.usbInterfaces = i2;
    }

    public static UsbPid fromValue(int i) throws IllegalArgumentException {
        for (UsbPid usbPid : values()) {
            if (usbPid.value == i) {
                return usbPid;
            }
        }
        throw new IllegalArgumentException("invalid pid value");
    }
}
