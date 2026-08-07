package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes8.dex */
public final class MediaCodecUtil {
    private static final String TAG = "MediaCodecUtil";
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    private interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i);

        boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface ScoreProvider<T> {
        int getScore(T t);
    }

    private static int avcLevelToMaxFrameSize(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private MediaCodecUtil() {
    }

    public static void warmDecoderInfoCache(String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (DecoderQueryException e) {
            Log.e(TAG, "Codec warming failed", e);
        }
    }

    public static synchronized void clearDecoderInfoCache() {
        decoderInfosCache.clear();
    }

    public static MediaCodecInfo getDecryptOnlyDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
    }

    public static MediaCodecInfo getDecoderInfo(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws DecoderQueryException {
        CodecKey codecKey = new CodecKey(str, z, z2);
        HashMap<CodecKey, List<MediaCodecInfo>> map = decoderInfosCache;
        List<MediaCodecInfo> list = map.get(codecKey);
        if (list != null) {
            return list;
        }
        ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV21(z, z2, str.equals(MimeTypes.VIDEO_MV_HEVC)));
        if (z) {
            decoderInfosInternal.isEmpty();
        }
        applyWorkarounds(str, decoderInfosInternal);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) decoderInfosInternal);
        map.put(codecKey, immutableListCopyOf);
        return immutableListCopyOf;
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List<MediaCodecInfo> getDecoderInfosSoftMatch(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z, z2);
        return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) getAlternativeDecoderInfos(mediaCodecSelector, format, z, z2)).build();
    }

    public static List<MediaCodecInfo> getAlternativeDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws DecoderQueryException {
        String alternativeCodecMimeType = getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.of();
        }
        return mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, z2);
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(final Context context, List<MediaCodecInfo> list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda3
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int getScore(Object obj) {
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(context, format, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    static /* synthetic */ int lambda$getDecoderInfosSortedByFormatSupport$0(Context context, Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isFormatFunctionallySupported(context, format) ? 1 : 0;
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFullFormatSupport(final Context context, List<MediaCodecInfo> list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda1
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int getScore(Object obj) {
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFullFormatSupport$1(context, format, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    static /* synthetic */ int lambda$getDecoderInfosSortedByFullFormatSupport$1(Context context, Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isFormatSupported(context, format) ? 1 : 0;
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedBySoftwareOnly(List<MediaCodecInfo> list) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda0
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int getScore(Object obj) {
                return MediaCodecUtil.lambda$getDecoderInfosSortedBySoftwareOnly$2((MediaCodecInfo) obj);
            }
        });
        return ImmutableList.copyOf((Collection) arrayList);
    }

    static /* synthetic */ int lambda$getDecoderInfosSortedBySoftwareOnly$2(MediaCodecInfo mediaCodecInfo) {
        return (mediaCodecInfo.softwareOnly ? 2 : 0) + (!mediaCodecInfo.vendor ? 1 : 0);
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int iMax = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false, false);
            if (decoderInfo != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(avcLevelToMaxFrameSize(profileLevels[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, 345600);
            }
            maxH264DecodableFrameSize = iMax;
        }
        return maxH264DecodableFrameSize;
    }

    public static android.media.MediaCodecInfo.CodecProfileLevel createCodecProfileLevel(int i, int i2) {
        android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel = new android.media.MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i;
        codecProfileLevel.level = i2;
        return codecProfileLevel;
    }

    @Deprecated
    public static Pair<Integer, Integer> getCodecProfileAndLevel(Format format) {
        return CodecSpecificDataUtil.getCodecProfileAndLevel(format);
    }

    public static Pair<Integer, Integer> getHevcBaseLayerCodecProfileAndLevel(Format format) {
        String h265BaseLayerCodecsString = NalUnitUtil.getH265BaseLayerCodecsString(format.initializationData);
        if (h265BaseLayerCodecsString == null) {
            return null;
        }
        return CodecSpecificDataUtil.getHevcProfileAndLevel(h265BaseLayerCodecsString, Util.split(h265BaseLayerCodecsString.trim(), "\\."), format.colorInfo);
    }

    public static String getAlternativeCodecMimeType(Format format) {
        Pair<Integer, Integer> codecProfileAndLevel;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return MimeTypes.VIDEO_H265;
            }
            if (iIntValue == 512) {
                return MimeTypes.VIDEO_H264;
            }
            if (iIntValue == 1024) {
                if (format.colorInfo != null && format.colorInfo.colorTransfer == 6 && format.colorInfo.colorRange == 1) {
                    return null;
                }
                return MimeTypes.VIDEO_AV1;
            }
        }
        if (MimeTypes.VIDEO_MV_HEVC.equals(format.sampleMimeType)) {
            return MimeTypes.VIDEO_H265;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0056  */
    private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        String codecMimeType;
        String str;
        int i;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
            String str2 = codecKey.mimeType;
            int codecCount = mediaCodecListCompat2.getCodecCount();
            boolean zSecureDecodersExplicit = mediaCodecListCompat2.secureDecodersExplicit();
            int i2 = 0;
            while (i2 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i2);
                if (isAlias(codecInfoAt)) {
                    i = i2;
                } else {
                    int i3 = i2;
                    String name = codecInfoAt.getName();
                    if (isCodecUsableDecoder(codecInfoAt, name, zSecureDecodersExplicit, str2) && (codecMimeType = getCodecMimeType(codecInfoAt, name, str2)) != null) {
                        try {
                            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(codecMimeType);
                            boolean zIsFeatureSupported = mediaCodecListCompat2.isFeatureSupported("tunneled-playback", codecMimeType, capabilitiesForType);
                            boolean zIsFeatureRequired = mediaCodecListCompat2.isFeatureRequired("tunneled-playback", codecMimeType, capabilitiesForType);
                            if ((codecKey.tunneling || !zIsFeatureRequired) && (!codecKey.tunneling || zIsFeatureSupported)) {
                                boolean zIsFeatureSupported2 = mediaCodecListCompat2.isFeatureSupported("secure-playback", codecMimeType, capabilitiesForType);
                                boolean zIsFeatureRequired2 = mediaCodecListCompat2.isFeatureRequired("secure-playback", codecMimeType, capabilitiesForType);
                                if ((codecKey.secure || !zIsFeatureRequired2) && (!codecKey.secure || zIsFeatureSupported2)) {
                                    try {
                                        boolean zIsHardwareAccelerated = isHardwareAccelerated(codecInfoAt, str2);
                                        boolean zIsSoftwareOnly = isSoftwareOnly(codecInfoAt, str2);
                                        boolean zIsVendor = isVendor(codecInfoAt);
                                        try {
                                            if (zSecureDecodersExplicit) {
                                                if (codecKey.secure != zIsFeatureSupported2) {
                                                }
                                                str = codecMimeType;
                                                i = i3;
                                                arrayList.add(MediaCodecInfo.newInstance(name, str2, str, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, false));
                                            }
                                            arrayList.add(MediaCodecInfo.newInstance(name, str2, str, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, false));
                                        } catch (Exception e) {
                                            e = e;
                                            Log.e(TAG, "Failed to query codec " + name + " (" + str + ")");
                                            throw e;
                                        }
                                        if (zSecureDecodersExplicit || codecKey.secure) {
                                            str = codecMimeType;
                                            i = i3;
                                            if (!zSecureDecodersExplicit && zIsFeatureSupported2) {
                                                try {
                                                    try {
                                                        arrayList.add(MediaCodecInfo.newInstance(name + ".secure", str2, str, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, true));
                                                        return arrayList;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        name = name;
                                                        Log.e(TAG, "Failed to query codec " + name + " (" + str + ")");
                                                        throw e;
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                }
                                            }
                                        }
                                        str = codecMimeType;
                                        i = i3;
                                    } catch (Exception e4) {
                                        e = e4;
                                        str = codecMimeType;
                                    }
                                } else {
                                    i = i3;
                                }
                            } else {
                                i = i3;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str = codecMimeType;
                        }
                    } else {
                        i = i3;
                    }
                }
                i2 = i + 1;
                mediaCodecListCompat2 = mediaCodecListCompat;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new DecoderQueryException(e6);
        }
    }

    private static String getCodecMimeType(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.VIDEO_MV_HEVC)) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        return z || !str.endsWith(".secure");
    }

    private static void applyWorkarounds(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            sortByScore(list, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda4
                @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
                public final int getScore(Object obj) {
                    return MediaCodecUtil.lambda$applyWorkarounds$3((MediaCodecInfo) obj);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            return;
        }
        list.add(list.remove(0));
    }

    static /* synthetic */ int lambda$applyWorkarounds$3(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        return (str.startsWith("OMX.google") || str.startsWith("c2.android")) ? 1 : 0;
    }

    private static boolean isAlias(android.media.MediaCodecInfo mediaCodecInfo) {
        return isAliasV29(mediaCodecInfo);
    }

    private static boolean isAliasV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean isHardwareAccelerated(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        return isHardwareAcceleratedV29(mediaCodecInfo);
    }

    private static boolean isHardwareAcceleratedV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        return isSoftwareOnlyV29(mediaCodecInfo);
    }

    private static boolean isSoftwareOnlyV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(android.media.MediaCodecInfo mediaCodecInfo) {
        return isVendorV29(mediaCodecInfo);
    }

    private static boolean isVendorV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    static /* synthetic */ int lambda$sortByScore$4(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
    }

    private static <T> void sortByScore(List<T> list, final ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new Comparator() { // from class: androidx.media3.exoplayer.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.lambda$sortByScore$4(scoreProvider, obj, obj2);
            }
        });
    }

    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z, boolean z2, boolean z3) {
            this.codecKind = (z || z2 || z3) ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i];
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }
    }

    private static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z, boolean z2) {
            this.mimeType = str;
            this.secure = z;
            this.tunneling = z2;
        }

        public int hashCode() {
            return ((((this.mimeType.hashCode() + 31) * 31) + (this.secure ? 1231 : 1237)) * 31) + (this.tunneling ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling) {
                    return true;
                }
            }
            return false;
        }
    }
}
