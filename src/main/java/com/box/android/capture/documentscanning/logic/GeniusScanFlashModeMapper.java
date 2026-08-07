package com.box.android.capture.documentscanning.logic;

import com.geniusscansdk.camera.FlashMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeniusScanFlashModeMapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/GeniusScanFlashModeMapper;", "", "<init>", "()V", "toDomainFlashModel", "Lcom/box/android/domain/models/capture/FlashMode;", "Lcom/geniusscansdk/camera/FlashMode;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeniusScanFlashModeMapper {
    public static final int $stable = 0;
    public static final GeniusScanFlashModeMapper INSTANCE = new GeniusScanFlashModeMapper();

    /* JADX INFO: compiled from: GeniusScanFlashModeMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlashMode.values().length];
            try {
                iArr[FlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlashMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlashMode.ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GeniusScanFlashModeMapper() {
    }

    public final com.box.android.domain.models.capture.FlashMode toDomainFlashModel(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[flashMode.ordinal()];
        if (i == 1) {
            return com.box.android.domain.models.capture.FlashMode.AUTO;
        }
        if (i == 2) {
            return com.box.android.domain.models.capture.FlashMode.OFF;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return com.box.android.domain.models.capture.FlashMode.ON;
    }
}
