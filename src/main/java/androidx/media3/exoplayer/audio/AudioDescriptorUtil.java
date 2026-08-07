package androidx.media3.exoplayer.audio;

import android.media.AudioDescriptor;
import android.os.Build;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.android.material.internal.ViewUtils;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes8.dex */
final class AudioDescriptorUtil {
    static final String TAG = "AudioDescriptorUtil";

    private AudioDescriptorUtil() {
    }

    public static ImmutableList<Integer> getAllLpcmChannelMasksFromPcmSads(List<AudioDescriptor> list) {
        if (Build.VERSION.SDK_INT < 31 || list == null) {
            return ImmutableList.of();
        }
        TreeSet treeSet = new TreeSet(Comparator.comparing(new Function() { // from class: androidx.media3.exoplayer.audio.AudioDescriptorUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.bitCount(((Integer) obj).intValue()));
            }
        }).reversed());
        for (AudioDescriptor audioDescriptor : list) {
            if (audioDescriptor.getStandard() == 1) {
                byte[] descriptor = audioDescriptor.getDescriptor();
                if (descriptor.length != 3) {
                    Log.w(TAG, "Invalid SAD length: " + descriptor.length);
                } else {
                    byte b = descriptor[0];
                    int i = (b & 7) + 1;
                    if (((b >> 3) & 15) == 1) {
                        treeSet.add(Integer.valueOf(Util.getAudioTrackChannelConfig(i)));
                    }
                }
            }
        }
        return ImmutableList.copyOf((Collection) treeSet);
    }

    public static ImmutableList<Integer> getAllChannelMasksFromSadbs(List<AudioDescriptor> list) {
        if (Build.VERSION.SDK_INT < 34 || list == null) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        for (AudioDescriptor audioDescriptor : list) {
            if (audioDescriptor.getStandard() == 2) {
                byte[] descriptor = audioDescriptor.getDescriptor();
                if (descriptor.length != 3) {
                    Log.w(TAG, "Invalid SADB length: " + descriptor.length);
                } else {
                    arrayList.add(Integer.valueOf(getChannelMaskFromSadb(descriptor)));
                }
            }
        }
        arrayList.sort(new Comparator() { // from class: androidx.media3.exoplayer.audio.AudioDescriptorUtil$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AudioDescriptorUtil.lambda$getAllChannelMasksFromSadbs$0((Integer) obj, (Integer) obj2);
            }
        });
        return ImmutableList.copyOf((Collection) arrayList);
    }

    static /* synthetic */ int lambda$getAllChannelMasksFromSadbs$0(Integer num, Integer num2) {
        return Integer.bitCount(num2.intValue()) - Integer.bitCount(num.intValue());
    }

    static int getChannelMaskFromSadb(byte[] bArr) {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 34 && bArr.length == 3) {
            byte b = bArr[0];
            i = (b & 1) != 0 ? 12 : 0;
            if ((b & 2) != 0) {
                i |= 32;
            }
            if ((b & 4) != 0) {
                i |= 16;
            }
            if ((b & 8) != 0) {
                i |= 192;
            }
            if ((b & Ascii.DLE) != 0) {
                i |= 1024;
            }
            if ((b & 32) != 0) {
                i |= ViewUtils.EDGE_TO_EDGE_FLAGS;
            }
            if ((b & 128) != 0) {
                i |= 201326592;
            }
            byte b2 = bArr[1];
            if ((b2 & 1) != 0) {
                i |= 81920;
            }
            if ((b2 & 2) != 0) {
                i |= 8192;
            }
            if ((b2 & 4) != 0) {
                i |= 32768;
            }
            if ((b2 & 8) != 0) {
                i |= 6144;
            }
            if ((b2 & Ascii.DLE) != 0) {
                i |= 33554432;
            }
            if ((b2 & 32) != 0) {
                i |= 262144;
            }
            if ((b2 & 64) != 0) {
                i |= 6144;
            }
            if ((b2 & 128) != 0) {
                i |= 3145728;
            }
            byte b3 = bArr[2];
            if ((b3 & 1) != 0) {
                i |= 655360;
            }
            if ((b3 & 2) != 0) {
                i |= 8388608;
            }
            if ((b3 & 4) != 0) {
                return 20971520 | i;
            }
        }
        return i;
    }
}
