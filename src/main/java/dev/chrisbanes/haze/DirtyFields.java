package dev.chrisbanes.haze;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: HazeEffectNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ldev/chrisbanes/haze/DirtyFields;", "", "<init>", "()V", "BlurEnabled", "", "InputScale", "ScreenPosition", "AreaOffsets", "Size", "BlurRadius", "NoiseFactor", "Mask", "BackgroundColor", "Tints", "FallbackTint", "Alpha", "Progressive", "Areas", "RenderEffectAffectingFlags", "InvalidateFlags", "stringify", "", "dirtyTracker", "Ldev/chrisbanes/haze/Bitmask;", "stringify-AI7STRk", "(I)Ljava/lang/String;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DirtyFields {
    public static final int $stable = 0;
    public static final int Alpha = 2048;
    public static final int AreaOffsets = 8;
    public static final int Areas = 8192;
    public static final int BackgroundColor = 256;
    public static final int BlurEnabled = 1;
    public static final int BlurRadius = 32;
    public static final int FallbackTint = 1024;
    public static final DirtyFields INSTANCE = new DirtyFields();
    public static final int InputScale = 2;
    public static final int InvalidateFlags = 14331;
    public static final int Mask = 128;
    public static final int NoiseFactor = 64;
    public static final int Progressive = 4096;
    public static final int RenderEffectAffectingFlags = 5875;
    public static final int ScreenPosition = 4;
    public static final int Size = 16;
    public static final int Tints = 512;

    private DirtyFields() {
    }

    /* JADX INFO: renamed from: stringify-AI7STRk, reason: not valid java name */
    public final String m14446stringifyAI7STRk(int dirtyTracker) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (Bitmask.m14435containsimpl(dirtyTracker, 1)) {
            listCreateListBuilder.add("BlurEnabled");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 2)) {
            listCreateListBuilder.add("InputScale");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 4)) {
            listCreateListBuilder.add("ScreenPosition");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 8)) {
            listCreateListBuilder.add("RelativePosition");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 16)) {
            listCreateListBuilder.add("Size");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 32)) {
            listCreateListBuilder.add("BlurRadius");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 64)) {
            listCreateListBuilder.add("NoiseFactor");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 128)) {
            listCreateListBuilder.add("Mask");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 256)) {
            listCreateListBuilder.add("BackgroundColor");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 512)) {
            listCreateListBuilder.add("Tints");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 1024)) {
            listCreateListBuilder.add("FallbackTint");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 2048)) {
            listCreateListBuilder.add("Alpha");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 4096)) {
            listCreateListBuilder.add("Progressive");
        }
        if (Bitmask.m14435containsimpl(dirtyTracker, 8192)) {
            listCreateListBuilder.add("Areas");
        }
        return CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), ", ", "[", "]", 0, null, null, 56, null);
    }
}
