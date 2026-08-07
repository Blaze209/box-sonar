package com.reactnativekeyboardcontroller.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: UIThread.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reactnativekeyboardcontroller/constants/UIThread;", "", "<init>", "()V", "MILLISECONDS_IN_SECOND", "", "FPS", "", "NEXT_FRAME", "", "getNEXT_FRAME", "()J", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIThread {
    public static final int FPS = 60;
    public static final double MILLISECONDS_IN_SECOND = 1000.0d;
    public static final UIThread INSTANCE = new UIThread();
    private static final long NEXT_FRAME = (long) Math.floor(16.666666666666668d);

    private UIThread() {
    }

    public final long getNEXT_FRAME() {
        return NEXT_FRAME;
    }
}
