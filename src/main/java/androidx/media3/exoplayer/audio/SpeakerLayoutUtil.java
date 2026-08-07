package androidx.media3.exoplayer.audio;

import android.media.AudioDescriptor;
import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import android.os.Build;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes8.dex */
final class SpeakerLayoutUtil {
    private static final ImmutableList<Integer> DEFAULT_CHANNEL_MASK = ImmutableList.of(12);
    private static final String TAG = "SpeakerLayoutUtil";

    private SpeakerLayoutUtil() {
    }

    public static ImmutableList<Integer> getLoudspeakerLayoutChannelMasks(AudioDeviceInfo audioDeviceInfo) {
        if (DeviceTypeUtil.isBluetoothDevice(audioDeviceInfo.getType())) {
            return getChannelMasksForBluetooth();
        }
        if (DeviceTypeUtil.isBuiltInEarpiece(audioDeviceInfo.getType())) {
            return ImmutableList.of(4);
        }
        if (DeviceTypeUtil.isBuiltInSpeaker(audioDeviceInfo.getType())) {
            return getChannelMasksForBuiltInSpeakers(audioDeviceInfo);
        }
        if (Build.VERSION.SDK_INT >= 31 && DeviceTypeUtil.isHdmiArc(audioDeviceInfo.getType())) {
            return getChannelMasksForHdmiArc(audioDeviceInfo);
        }
        if (Build.VERSION.SDK_INT >= 31 && DeviceTypeUtil.isHdmiEarc(audioDeviceInfo.getType())) {
            return getChannelMasksForHdmiEarc(audioDeviceInfo);
        }
        if (Build.VERSION.SDK_INT >= 31 && DeviceTypeUtil.isUsbDevice(audioDeviceInfo.getType())) {
            return getChannelMasksForUsb(audioDeviceInfo);
        }
        return DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksForBluetooth() {
        return DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksForBuiltInSpeakers(AudioDeviceInfo audioDeviceInfo) {
        int speakerLayoutChannelMask;
        if (Build.VERSION.SDK_INT >= 36 && (speakerLayoutChannelMask = audioDeviceInfo.getSpeakerLayoutChannelMask()) != 0 && speakerLayoutChannelMask != 1) {
            return ImmutableList.of(Integer.valueOf(speakerLayoutChannelMask));
        }
        Log.w(TAG, "Built-in speaker's getSpeakerLayoutChannelMask not usable, defaulting to stereo.");
        return DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksForHdmiArc(AudioDeviceInfo audioDeviceInfo) {
        ImmutableList<Integer> channelMasksFromPcmAudioProfiles = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
        if (!channelMasksFromPcmAudioProfiles.isEmpty()) {
            return channelMasksFromPcmAudioProfiles;
        }
        ImmutableList<Integer> allLpcmChannelMasksFromPcmSads = AudioDescriptorUtil.getAllLpcmChannelMasksFromPcmSads(audioDeviceInfo.getAudioDescriptors());
        return !allLpcmChannelMasksFromPcmSads.isEmpty() ? allLpcmChannelMasksFromPcmSads : DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksForHdmiEarc(AudioDeviceInfo audioDeviceInfo) {
        ImmutableList<Integer> channelMasksFromPcmAudioProfiles = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
        if (!channelMasksFromPcmAudioProfiles.isEmpty()) {
            return channelMasksFromPcmAudioProfiles;
        }
        List<AudioDescriptor> audioDescriptors = audioDeviceInfo.getAudioDescriptors();
        if (Build.VERSION.SDK_INT >= 34) {
            ImmutableList<Integer> allChannelMasksFromSadbs = AudioDescriptorUtil.getAllChannelMasksFromSadbs(audioDescriptors);
            if (!allChannelMasksFromSadbs.isEmpty()) {
                return allChannelMasksFromSadbs;
            }
        }
        ImmutableList<Integer> allLpcmChannelMasksFromPcmSads = AudioDescriptorUtil.getAllLpcmChannelMasksFromPcmSads(audioDescriptors);
        return !allLpcmChannelMasksFromPcmSads.isEmpty() ? allLpcmChannelMasksFromPcmSads : DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksForUsb(AudioDeviceInfo audioDeviceInfo) {
        ImmutableList<Integer> channelMasksFromPcmAudioProfiles = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
        return !channelMasksFromPcmAudioProfiles.isEmpty() ? channelMasksFromPcmAudioProfiles : DEFAULT_CHANNEL_MASK;
    }

    private static ImmutableList<Integer> getChannelMasksFromPcmAudioProfiles(AudioDeviceInfo audioDeviceInfo) {
        List<AudioProfile> audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(new Function() { // from class: androidx.media3.exoplayer.audio.SpeakerLayoutUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.bitCount(((Integer) obj).intValue()));
            }
        }).reversed());
        for (AudioProfile audioProfile : audioProfiles) {
            if (audioProfile.getEncapsulationType() != 1 && Util.isEncodingLinearPcm(audioProfile.getFormat())) {
                for (int i : audioProfile.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf((Collection) treeSet);
    }
}
