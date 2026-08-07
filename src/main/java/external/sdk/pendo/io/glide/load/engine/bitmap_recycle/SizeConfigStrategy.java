package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class SizeConfigStrategy implements e {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    private final c keyPool = new c();
    private final d<b, Bitmap> groupedMap = new d<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class b implements f {
        private final c a;
        int b;
        private Bitmap.Config c;

        public b(c cVar) {
            this.a = cVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b && l.b(this.c, bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.b, this.c);
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f
        public void a() {
            this.a.a(this);
        }
    }

    static class c extends external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b a(int i, Bitmap.Config config) {
            b bVarB = b();
            bVarB.a(i, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        ARGB_8888_IN_CONFIGS = configArr;
        RGBA_F16_IN_CONFIGS = configArr;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num2 = (Integer) sizesForConfig.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        }
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b findBestKey(int i, Bitmap.Config config) {
        b bVarA = this.keyPool.a(i, config);
        for (Bitmap.Config config2 : getInConfigs(config)) {
            Integer numCeilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                this.keyPool.a(bVarA);
                return this.keyPool.a(numCeilingKey.intValue(), config2);
            }
        }
        return bVarA;
    }

    static String getBitmapString(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return RGBA_F16_IN_CONFIGS;
        }
        int i = a.a[config.ordinal()];
        if (i == 1) {
            return ARGB_8888_IN_CONFIGS;
        }
        if (i == 2) {
            return RGB_565_IN_CONFIGS;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS;
        }
        return ARGB_4444_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        b bVarFindBestKey = findBestKey(l.a(i, i2, config), config);
        Bitmap bitmapA = this.groupedMap.a(bVarFindBestKey);
        if (bitmapA != null) {
            decrementBitmapOfSize(Integer.valueOf(bVarFindBestKey.b), bitmapA);
            bitmapA.reconfigure(i, i2, config);
        }
        return bitmapA;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public int getSize(Bitmap bitmap) {
        return l.a(bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(l.a(i, i2, config), config);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public void put(Bitmap bitmap) {
        b bVarA = this.keyPool.a(l.a(bitmap), bitmap.getConfig());
        this.groupedMap.a(bVarA, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = (Integer) sizesForConfig.get(Integer.valueOf(bVarA.b));
        sizesForConfig.put(Integer.valueOf(bVarA.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap removeLast() {
        Bitmap bitmapA = this.groupedMap.a();
        if (bitmapA != null) {
            decrementBitmapOfSize(Integer.valueOf(l.a(bitmapA)), bitmapA);
        }
        return bitmapA;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.groupedMap).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            sbAppend.append(entry.getKey()).append(AbstractJsonLexerKt.BEGIN_LIST).append(entry.getValue()).append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            sbAppend.replace(sbAppend.length() - 2, sbAppend.length(), "");
        }
        return sbAppend.append(")}").toString();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(l.a(bitmap), bitmap.getConfig());
    }
}
