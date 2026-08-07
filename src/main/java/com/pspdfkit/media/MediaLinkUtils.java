package com.pspdfkit.media;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public class MediaLinkUtils {

    public static class VideoSettings {
        public String coverImage;
        public String coverMode;
        public int offset = 0;
        public boolean autoplay = false;
    }

    public static String[] extractOptionsAndPath(String str) {
        String[] strArr = new String[2];
        if (!str.startsWith("[") || !str.contains("]")) {
            strArr[0] = null;
            strArr[1] = str;
            return strArr;
        }
        String[] strArrSplit = str.split("]");
        strArr[0] = nv.a(new StringBuilder(), strArrSplit[0], "]");
        strArr[1] = strArrSplit[1];
        return strArr;
    }

    public static VideoSettings getVideoSettingsFromOptions(String str) {
        VideoSettings videoSettings = new VideoSettings();
        if (str != null) {
            if (str.contains("[")) {
                str = str.replace("[", "");
            }
            if (str.contains("]")) {
                str = str.replace("]", "");
            }
            for (String str2 : str.split(",")) {
                if (str2.startsWith("autoplay:")) {
                    videoSettings.autoplay = str2.endsWith(TelemetryEventStrings.Value.TRUE);
                } else if (str2.startsWith("offset:")) {
                    videoSettings.offset = Integer.parseInt(str2.replace("offset:", ""));
                } else if (str2.startsWith("coverMode:")) {
                    videoSettings.coverMode = str2.substring(10);
                } else if (str2.startsWith("coverImage:")) {
                    videoSettings.coverImage = str2.substring(11);
                }
            }
        }
        return videoSettings;
    }
}
