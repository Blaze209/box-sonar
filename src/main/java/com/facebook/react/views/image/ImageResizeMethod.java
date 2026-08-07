package com.facebook.react.views.image;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageResizeMethod.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/react/views/image/ImageResizeMethod;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "RESIZE", "SCALE", "NONE", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ImageResizeMethod {
    AUTO,
    RESIZE,
    SCALE,
    NONE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ImageResizeMethod> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final ImageResizeMethod parse(String str) {
        return INSTANCE.parse(str);
    }

    /* JADX INFO: compiled from: ImageResizeMethod.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/views/image/ImageResizeMethod$Companion;", "", "<init>", "()V", "parse", "Lcom/facebook/react/views/image/ImageResizeMethod;", ViewProps.RESIZE_METHOD, "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        
            if (r2.equals("auto") == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
        
            if (r2.equals("") == false) goto L31;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.facebook.react.views.image.ImageResizeMethod parse(java.lang.String r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L71
                int r1 = r2.hashCode()
                r0 = -934437708(0xffffffffc84d9cb4, float:-210546.81)
                if (r1 == r0) goto L48
                if (r1 == 0) goto L3f
                r0 = 3005871(0x2dddaf, float:4.212122E-39)
                if (r1 == r0) goto L36
                r0 = 3387192(0x33af38, float:4.746467E-39)
                if (r1 == r0) goto L2a
                r0 = 109250890(0x683094a, float:4.929037E-35)
                if (r1 == r0) goto L1d
                goto L51
            L1d:
                java.lang.String r1 = "scale"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L27
                goto L51
            L27:
                com.facebook.react.views.image.ImageResizeMethod r1 = com.facebook.react.views.image.ImageResizeMethod.SCALE
                return r1
            L2a:
                java.lang.String r1 = "none"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L33
                goto L51
            L33:
                com.facebook.react.views.image.ImageResizeMethod r1 = com.facebook.react.views.image.ImageResizeMethod.NONE
                return r1
            L36:
                java.lang.String r1 = "auto"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L71
                goto L51
            L3f:
                java.lang.String r1 = ""
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L71
                goto L51
            L48:
                java.lang.String r1 = "resize"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L6e
            L51:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r0 = "Invalid resize method: '"
                r1.<init>(r0)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = "'"
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "ReactNative"
                com.facebook.common.logging.FLog.w(r2, r1)
                com.facebook.react.views.image.ImageResizeMethod r1 = com.facebook.react.views.image.ImageResizeMethod.AUTO
                return r1
            L6e:
                com.facebook.react.views.image.ImageResizeMethod r1 = com.facebook.react.views.image.ImageResizeMethod.RESIZE
                return r1
            L71:
                com.facebook.react.views.image.ImageResizeMethod r1 = com.facebook.react.views.image.ImageResizeMethod.AUTO
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ImageResizeMethod.Companion.parse(java.lang.String):com.facebook.react.views.image.ImageResizeMethod");
        }
    }
}
