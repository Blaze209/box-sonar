package com.box.android.base.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxColors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"enabled", "Landroidx/compose/ui/graphics/Color;", "", "alpha", "", "enabled-ek8zF_U", "(JZF)J", "lightBoxColors", "Lcom/box/android/base/compose/BoxColors;", "getLightBoxColors", "()Lcom/box/android/base/compose/BoxColors;", "darkBoxColors", "getDarkBoxColors", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxColorsKt {
    private static final BoxColors darkBoxColors;
    private static final BoxColors lightBoxColors;

    /* JADX INFO: renamed from: enabled-ek8zF_U, reason: not valid java name */
    public static final long m11586enabledek8zF_U(long j, boolean z, float f) {
        return z ? j : Color.m6813copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: renamed from: enabled-ek8zF_U$default, reason: not valid java name */
    public static /* synthetic */ long m11587enabledek8zF_U$default(long j, boolean z, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.4f;
        }
        return m11586enabledek8zF_U(j, z, f);
    }

    public static final BoxColors getLightBoxColors() {
        return lightBoxColors;
    }

    static {
        long jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11362getBOX_GRAY_050d7_KjU = BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM6851getWhite0d7_KjU2 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11361getBOX_GRAY_020d7_KjU = BoxColorPalette.INSTANCE.m11361getBOX_GRAY_020d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM6851getWhite0d7_KjU3 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM6851getWhite0d7_KjU4 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU2 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM6851getWhite0d7_KjU5 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU3 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM11368getBOX_GRAY_500d7_KjU = BoxColorPalette.INSTANCE.m11368getBOX_GRAY_500d7_KjU();
        long jM6851getWhite0d7_KjU6 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU2 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11353getBOX_BLUE_100d7_KjU = BoxColorPalette.INSTANCE.m11353getBOX_BLUE_100d7_KjU();
        long jM6851getWhite0d7_KjU7 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11367getBOX_GRAY_400d7_KjU = BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU();
        long jM11380getLIGHT_BLUE_050d7_KjU = BoxColorPalette.INSTANCE.m11380getLIGHT_BLUE_050d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU2 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM6851getWhite0d7_KjU8 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU2 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11368getBOX_GRAY_500d7_KjU2 = BoxColorPalette.INSTANCE.m11368getBOX_GRAY_500d7_KjU();
        long jM11361getBOX_GRAY_020d7_KjU2 = BoxColorPalette.INSTANCE.m11361getBOX_GRAY_020d7_KjU();
        long jM11404getYELLOW_ORANGE0d7_KjU = BoxColorPalette.INSTANCE.m11404getYELLOW_ORANGE0d7_KjU();
        long jM11377getGREEN0d7_KjU = BoxColorPalette.INSTANCE.m11377getGREEN0d7_KjU();
        long jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11384getLIGHT_GREEN0d7_KjU = BoxColorPalette.INSTANCE.m11384getLIGHT_GREEN0d7_KjU();
        long jM11403getYELLOW0d7_KjU = BoxColorPalette.INSTANCE.m11403getYELLOW0d7_KjU();
        long jM6851getWhite0d7_KjU9 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU2 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM6851getWhite0d7_KjU10 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11400getWATERMELON_RED_1100d7_KjU = BoxColorPalette.INSTANCE.m11400getWATERMELON_RED_1100d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU4 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU3 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU3 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11400getWATERMELON_RED_1100d7_KjU2 = BoxColorPalette.INSTANCE.m11400getWATERMELON_RED_1100d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU4 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU5 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU3 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU4 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11355getBOX_BLUE_300d7_KjU = BoxColorPalette.INSTANCE.m11355getBOX_BLUE_300d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU6 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11372getDARK_BLUE0d7_KjU = BoxColorPalette.INSTANCE.m11372getDARK_BLUE0d7_KjU();
        long jM11372getDARK_BLUE0d7_KjU2 = BoxColorPalette.INSTANCE.m11372getDARK_BLUE0d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU3 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM11361getBOX_GRAY_020d7_KjU3 = BoxColorPalette.INSTANCE.m11361getBOX_GRAY_020d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11362getBOX_GRAY_050d7_KjU2 = BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU4 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU4 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM6851getWhite0d7_KjU11 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11353getBOX_BLUE_100d7_KjU2 = BoxColorPalette.INSTANCE.m11353getBOX_BLUE_100d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU5 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU5 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11362getBOX_GRAY_050d7_KjU3 = BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU6 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11353getBOX_BLUE_100d7_KjU3 = BoxColorPalette.INSTANCE.m11353getBOX_BLUE_100d7_KjU();
        long jM11363getBOX_GRAY_100d7_KjU7 = BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU();
        long jM11355getBOX_BLUE_300d7_KjU2 = BoxColorPalette.INSTANCE.m11355getBOX_BLUE_300d7_KjU();
        long jM11362getBOX_GRAY_050d7_KjU4 = BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU7 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM6851getWhite0d7_KjU12 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11365getBOX_GRAY_200d7_KjU = BoxColorPalette.INSTANCE.m11365getBOX_GRAY_200d7_KjU();
        long jM11375getGOLD0d7_KjU = BoxColorPalette.INSTANCE.m11375getGOLD0d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU8 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU6 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU7 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11373getDARK_BLUE_100d7_KjU = BoxColorPalette.INSTANCE.m11373getDARK_BLUE_100d7_KjU();
        long jM11374getDARK_BLUE_1000d7_KjU = BoxColorPalette.INSTANCE.m11374getDARK_BLUE_1000d7_KjU();
        long jM11405getYELLOW_ORANGE_1100d7_KjU = BoxColorPalette.INSTANCE.m11405getYELLOW_ORANGE_1100d7_KjU();
        lightBoxColors = new BoxColors(jM6851getWhite0d7_KjU, jM11362getBOX_GRAY_050d7_KjU, jM11364getBOX_GRAY_1000d7_KjU, jM6851getWhite0d7_KjU2, jM6813copywmQWz5c$default, jM11369getBOX_GRAY_650d7_KjU2, jM11370getBOX_GRAY_800d7_KjU, jM11361getBOX_GRAY_020d7_KjU, jM11369getBOX_GRAY_650d7_KjU, jM11354getBOX_BLUE_1000d7_KjU, jM6851getWhite0d7_KjU3, jM6851getWhite0d7_KjU4, jM11364getBOX_GRAY_1000d7_KjU2, jM6851getWhite0d7_KjU5, jM11364getBOX_GRAY_1000d7_KjU3, jM11368getBOX_GRAY_500d7_KjU, jM6851getWhite0d7_KjU6, jM11362getBOX_GRAY_050d7_KjU2, jM11363getBOX_GRAY_100d7_KjU4, jM11369getBOX_GRAY_650d7_KjU4, jM11354getBOX_BLUE_1000d7_KjU2, jM11367getBOX_GRAY_400d7_KjU, jM11353getBOX_BLUE_100d7_KjU, jM6851getWhite0d7_KjU7, jM11380getLIGHT_BLUE_050d7_KjU, jM6851getWhite0d7_KjU8, jM11370getBOX_GRAY_800d7_KjU2, jM11368getBOX_GRAY_500d7_KjU2, jM11361getBOX_GRAY_020d7_KjU2, jM11404getYELLOW_ORANGE0d7_KjU, jM11377getGREEN0d7_KjU, jM6813copywmQWz5c$default2, jM11384getLIGHT_GREEN0d7_KjU, jM11403getYELLOW0d7_KjU, jM6851getWhite0d7_KjU9, jM11363getBOX_GRAY_100d7_KjU, jM11363getBOX_GRAY_100d7_KjU2, jM6851getWhite0d7_KjU10, jM11400getWATERMELON_RED_1100d7_KjU, jM11364getBOX_GRAY_1000d7_KjU4, jM11363getBOX_GRAY_100d7_KjU3, jM11354getBOX_BLUE_1000d7_KjU3, jM11400getWATERMELON_RED_1100d7_KjU2, jM11354getBOX_BLUE_1000d7_KjU4, jM11354getBOX_BLUE_1000d7_KjU5, jM11370getBOX_GRAY_800d7_KjU3, jM11370getBOX_GRAY_800d7_KjU4, jM11355getBOX_BLUE_300d7_KjU, jM11354getBOX_BLUE_1000d7_KjU6, jM11372getDARK_BLUE0d7_KjU, jM11372getDARK_BLUE0d7_KjU2, jM11369getBOX_GRAY_650d7_KjU3, jM11371getBOX_GRAY_900d7_KjU, jM11361getBOX_GRAY_020d7_KjU3, jM11356getBOX_BLUE_500d7_KjU, jM6851getWhite0d7_KjU11, jM11353getBOX_BLUE_100d7_KjU2, jM11363getBOX_GRAY_100d7_KjU5, jM11369getBOX_GRAY_650d7_KjU5, jM11362getBOX_GRAY_050d7_KjU3, jM11363getBOX_GRAY_100d7_KjU6, jM11353getBOX_BLUE_100d7_KjU3, jM11363getBOX_GRAY_100d7_KjU7, jM11355getBOX_BLUE_300d7_KjU2, jM11362getBOX_GRAY_050d7_KjU4, jM11354getBOX_BLUE_1000d7_KjU7, jM6851getWhite0d7_KjU12, jM11365getBOX_GRAY_200d7_KjU, jM11375getGOLD0d7_KjU, jM11354getBOX_BLUE_1000d7_KjU8, jM11369getBOX_GRAY_650d7_KjU6, jM11369getBOX_GRAY_650d7_KjU7, jM11373getDARK_BLUE_100d7_KjU, jM11374getDARK_BLUE_1000d7_KjU, BoxColorPalette.INSTANCE.m11406getYELLOW_ORANGE_200d7_KjU(), jM11405getYELLOW_ORANGE_1100d7_KjU, BoxColorPalette.INSTANCE.m11361getBOX_GRAY_020d7_KjU(), BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU(), BoxColorPalette.INSTANCE.m11368getBOX_GRAY_500d7_KjU(), BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU(), BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU(), BoxColorPalette.INSTANCE.m11352getBOX_BLUE_050d7_KjU(), BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU(), BoxColorPalette.INSTANCE.m11365getBOX_GRAY_200d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11394getPURPLE_RAIN_1000d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11391getPINK_PANTHER_1200d7_KjU(), BoxColorPalette.INSTANCE.m11382getLIGHT_BLUE_1200d7_KjU(), null);
        long jM11364getBOX_GRAY_1000d7_KjU5 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM6840getBlack0d7_KjU = Color.INSTANCE.m6840getBlack0d7_KjU();
        long jM6851getWhite0d7_KjU13 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU2 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11364getBOX_GRAY_1000d7_KjU6 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM11365getBOX_GRAY_200d7_KjU2 = BoxColorPalette.INSTANCE.m11365getBOX_GRAY_200d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU3 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU4 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM6851getWhite0d7_KjU14 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM6851getWhite0d7_KjU15 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU2 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU3 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11366getBOX_GRAY_300d7_KjU = BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU5 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU4 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM6851getWhite0d7_KjU16 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11368getBOX_GRAY_500d7_KjU3 = BoxColorPalette.INSTANCE.m11368getBOX_GRAY_500d7_KjU();
        long jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11360getBOX_DARK_BLUE0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11370getBOX_GRAY_800d7_KjU5 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11367getBOX_GRAY_400d7_KjU2 = BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU();
        long jM11367getBOX_GRAY_400d7_KjU3 = BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU();
        long jM11376getGRAY_150d7_KjU = BoxColorPalette.INSTANCE.m11376getGRAY_150d7_KjU();
        long jM11367getBOX_GRAY_400d7_KjU4 = BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU();
        long jM11369getBOX_GRAY_650d7_KjU8 = BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU6 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11404getYELLOW_ORANGE0d7_KjU2 = BoxColorPalette.INSTANCE.m11404getYELLOW_ORANGE0d7_KjU();
        long jM11377getGREEN0d7_KjU2 = BoxColorPalette.INSTANCE.m11377getGREEN0d7_KjU();
        long jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11384getLIGHT_GREEN0d7_KjU2 = BoxColorPalette.INSTANCE.m11384getLIGHT_GREEN0d7_KjU();
        long jM11403getYELLOW0d7_KjU2 = BoxColorPalette.INSTANCE.m11403getYELLOW0d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU7 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU6 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU8 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM6851getWhite0d7_KjU17 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11400getWATERMELON_RED_1100d7_KjU3 = BoxColorPalette.INSTANCE.m11400getWATERMELON_RED_1100d7_KjU();
        long jM6851getWhite0d7_KjU18 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11371getBOX_GRAY_900d7_KjU7 = BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU5 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11402getWATERMELON_RED_500d7_KjU = BoxColorPalette.INSTANCE.m11402getWATERMELON_RED_500d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU6 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11356getBOX_BLUE_500d7_KjU7 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11366getBOX_GRAY_300d7_KjU2 = BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU();
        long jM11366getBOX_GRAY_300d7_KjU3 = BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU();
        long jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11356getBOX_BLUE_500d7_KjU8 = BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU();
        long jM11379getLIGHT_BLUE0d7_KjU = BoxColorPalette.INSTANCE.m11379getLIGHT_BLUE0d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU9 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11366getBOX_GRAY_300d7_KjU4 = BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU();
        long jM6851getWhite0d7_KjU19 = Color.INSTANCE.m6851getWhite0d7_KjU();
        long jM11364getBOX_GRAY_1000d7_KjU9 = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
        long jM11354getBOX_BLUE_1000d7_KjU10 = BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU7 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU8 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        long jM11367getBOX_GRAY_400d7_KjU5 = BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU();
        long jM11370getBOX_GRAY_800d7_KjU9 = BoxColorPalette.INSTANCE.m11370getBOX_GRAY_800d7_KjU();
        darkBoxColors = new BoxColors(jM11364getBOX_GRAY_1000d7_KjU5, jM6840getBlack0d7_KjU, jM6851getWhite0d7_KjU13, jM11371getBOX_GRAY_900d7_KjU2, jM6813copywmQWz5c$default3, jM11367getBOX_GRAY_400d7_KjU2, jM11367getBOX_GRAY_400d7_KjU3, jM11364getBOX_GRAY_1000d7_KjU6, jM11365getBOX_GRAY_200d7_KjU2, jM11371getBOX_GRAY_900d7_KjU3, jM11371getBOX_GRAY_900d7_KjU4, jM6851getWhite0d7_KjU14, jM6851getWhite0d7_KjU15, jM11356getBOX_BLUE_500d7_KjU2, jM11356getBOX_BLUE_500d7_KjU3, jM11366getBOX_GRAY_300d7_KjU, jM11371getBOX_GRAY_900d7_KjU5, jM11370getBOX_GRAY_800d7_KjU7, jM11370getBOX_GRAY_800d7_KjU8, jM11367getBOX_GRAY_400d7_KjU5, jM11356getBOX_BLUE_500d7_KjU4, jM11368getBOX_GRAY_500d7_KjU3, jM6813copywmQWz5c$default4, jM6851getWhite0d7_KjU16, jM11370getBOX_GRAY_800d7_KjU5, jM11376getGRAY_150d7_KjU, jM11367getBOX_GRAY_400d7_KjU4, jM11369getBOX_GRAY_650d7_KjU8, jM11370getBOX_GRAY_800d7_KjU6, jM11404getYELLOW_ORANGE0d7_KjU2, jM11377getGREEN0d7_KjU2, jM6813copywmQWz5c$default5, jM11384getLIGHT_GREEN0d7_KjU2, jM11403getYELLOW0d7_KjU2, jM11364getBOX_GRAY_1000d7_KjU7, jM11371getBOX_GRAY_900d7_KjU6, jM11364getBOX_GRAY_1000d7_KjU8, jM6851getWhite0d7_KjU17, jM11400getWATERMELON_RED_1100d7_KjU3, jM6851getWhite0d7_KjU18, jM11371getBOX_GRAY_900d7_KjU7, jM11356getBOX_BLUE_500d7_KjU5, jM11402getWATERMELON_RED_500d7_KjU, jM11356getBOX_BLUE_500d7_KjU6, jM11356getBOX_BLUE_500d7_KjU7, jM11366getBOX_GRAY_300d7_KjU2, jM11366getBOX_GRAY_300d7_KjU3, jM6813copywmQWz5c$default6, jM11356getBOX_BLUE_500d7_KjU8, jM11354getBOX_BLUE_1000d7_KjU9, jM11379getLIGHT_BLUE0d7_KjU, jM11366getBOX_GRAY_300d7_KjU4, jM6851getWhite0d7_KjU19, jM11364getBOX_GRAY_1000d7_KjU9, jM11354getBOX_BLUE_1000d7_KjU10, BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU(), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU()), jM11370getBOX_GRAY_800d7_KjU9, BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU(), BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU(), BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU(), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11360getBOX_DARK_BLUE0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU()), BoxColorPalette.INSTANCE.m11369getBOX_GRAY_650d7_KjU(), BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU(), BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU(), BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU(), BoxColorPalette.INSTANCE.m11375getGOLD0d7_KjU(), BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU(), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU(), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU(), Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11359getBOX_BLUE_900d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11357getBOX_BLUE_650d7_KjU(), Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11407getYELLOW_ORANGE_900d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11405getYELLOW_ORANGE_1100d7_KjU(), BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU(), BoxColorPalette.INSTANCE.m11368getBOX_GRAY_500d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), BoxColorPalette.INSTANCE.m11371getBOX_GRAY_900d7_KjU(), BoxColorPalette.INSTANCE.m11356getBOX_BLUE_500d7_KjU(), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11360getBOX_DARK_BLUE0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU()), BoxColorPalette.INSTANCE.m11354getBOX_BLUE_1000d7_KjU(), BoxColorPalette.INSTANCE.m11367getBOX_GRAY_400d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11397getPURPLE_RAIN_900d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11391getPINK_PANTHER_1200d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6851getWhite0d7_KjU()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(BoxColorPalette.INSTANCE.m11382getLIGHT_BLUE_1200d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6851getWhite0d7_KjU()), null);
    }

    public static final BoxColors getDarkBoxColors() {
        return darkBoxColors;
    }
}
