package expo.modules.ui;

import androidx.compose.material3.MaterialShapes;
import androidx.graphics.shapes.RoundedPolygon;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MaterialShapes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010#\u001a\u00020$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006%"}, d2 = {"Lexpo/modules/ui/MaterialShapeType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COOKIE_4_SIDED", "COOKIE_6_SIDED", "COOKIE_7_SIDED", "COOKIE_9_SIDED", "COOKIE_12_SIDED", "CLOVER_4_LEAF", "CLOVER_8_LEAF", "SOFT_BURST", "BOOM", "OVAL", "PILL", "TRIANGLE", "DIAMOND", "PENTAGON", "SUNNY", "VERY_SUNNY", "FAN", "PIXEL_CIRCLE", "PIXEL_TRIANGLE", "GHOSTISH", "BUN", "HEART", "ARCH", "SLANTED", "PUFFY", "PUFFY_DIAMOND", "toRoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum MaterialShapeType implements Enumerable {
    COOKIE_4_SIDED("cookie4Sided"),
    COOKIE_6_SIDED("cookie6Sided"),
    COOKIE_7_SIDED("cookie7Sided"),
    COOKIE_9_SIDED("cookie9Sided"),
    COOKIE_12_SIDED("cookie12Sided"),
    CLOVER_4_LEAF("clover4Leaf"),
    CLOVER_8_LEAF("clover8Leaf"),
    SOFT_BURST("softBurst"),
    BOOM("boom"),
    OVAL("oval"),
    PILL("pill"),
    TRIANGLE("triangle"),
    DIAMOND("diamond"),
    PENTAGON("pentagon"),
    SUNNY("sunny"),
    VERY_SUNNY("verySunny"),
    FAN("fan"),
    PIXEL_CIRCLE("pixelCircle"),
    PIXEL_TRIANGLE("pixelTriangle"),
    GHOSTISH("ghostish"),
    BUN("bun"),
    HEART("heart"),
    ARCH("arch"),
    SLANTED("slanted"),
    PUFFY("puffy"),
    PUFFY_DIAMOND("puffyDiamond");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: MaterialShapes.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MaterialShapeType.values().length];
            try {
                iArr[MaterialShapeType.COOKIE_4_SIDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaterialShapeType.COOKIE_6_SIDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaterialShapeType.COOKIE_7_SIDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaterialShapeType.COOKIE_9_SIDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MaterialShapeType.COOKIE_12_SIDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MaterialShapeType.CLOVER_4_LEAF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MaterialShapeType.CLOVER_8_LEAF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MaterialShapeType.SOFT_BURST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MaterialShapeType.BOOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MaterialShapeType.OVAL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MaterialShapeType.PILL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MaterialShapeType.TRIANGLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MaterialShapeType.DIAMOND.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MaterialShapeType.PENTAGON.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MaterialShapeType.SUNNY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MaterialShapeType.VERY_SUNNY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MaterialShapeType.FAN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[MaterialShapeType.PIXEL_CIRCLE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[MaterialShapeType.PIXEL_TRIANGLE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[MaterialShapeType.GHOSTISH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[MaterialShapeType.BUN.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[MaterialShapeType.HEART.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[MaterialShapeType.ARCH.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[MaterialShapeType.SLANTED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[MaterialShapeType.PUFFY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[MaterialShapeType.PUFFY_DIAMOND.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<MaterialShapeType> getEntries() {
        return $ENTRIES;
    }

    MaterialShapeType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final RoundedPolygon toRoundedPolygon() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return MaterialShapes.INSTANCE.getCookie4Sided();
            case 2:
                return MaterialShapes.INSTANCE.getCookie6Sided();
            case 3:
                return MaterialShapes.INSTANCE.getCookie7Sided();
            case 4:
                return MaterialShapes.INSTANCE.getCookie9Sided();
            case 5:
                return MaterialShapes.INSTANCE.getCookie12Sided();
            case 6:
                return MaterialShapes.INSTANCE.getClover4Leaf();
            case 7:
                return MaterialShapes.INSTANCE.getClover8Leaf();
            case 8:
                return MaterialShapes.INSTANCE.getSoftBurst();
            case 9:
                return MaterialShapes.INSTANCE.getBoom();
            case 10:
                return MaterialShapes.INSTANCE.getOval();
            case 11:
                return MaterialShapes.INSTANCE.getPill();
            case 12:
                return MaterialShapes.INSTANCE.getTriangle();
            case 13:
                return MaterialShapes.INSTANCE.getDiamond();
            case 14:
                return MaterialShapes.INSTANCE.getPentagon();
            case 15:
                return MaterialShapes.INSTANCE.getSunny();
            case 16:
                return MaterialShapes.INSTANCE.getVerySunny();
            case 17:
                return MaterialShapes.INSTANCE.getFan();
            case 18:
                return MaterialShapes.INSTANCE.getPixelCircle();
            case 19:
                return MaterialShapes.INSTANCE.getPixelTriangle();
            case 20:
                return MaterialShapes.INSTANCE.getGhostish();
            case 21:
                return MaterialShapes.INSTANCE.getBun();
            case 22:
                return MaterialShapes.INSTANCE.getHeart();
            case 23:
                return MaterialShapes.INSTANCE.getArch();
            case 24:
                return MaterialShapes.INSTANCE.getSlanted();
            case 25:
                return MaterialShapes.INSTANCE.getPuffy();
            case 26:
                return MaterialShapes.INSTANCE.getPuffyDiamond();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
