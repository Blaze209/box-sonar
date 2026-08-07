package sdk.pendo.io.m;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.e;
import sdk.pendo.io.e.b;
import sdk.pendo.io.e.g;
import sdk.pendo.io.e.h;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ImageDecoder.OnHeaderDecodedListener {
    private final e a = e.b();
    private final int b;
    private final int c;
    private final b d;
    private final external.sdk.pendo.io.glide.load.resource.bitmap.a e;
    private final boolean f;
    private final h g;

    /* JADX INFO: renamed from: sdk.pendo.io.m.a$a, reason: collision with other inner class name */
    class C0417a implements ImageDecoder.OnPartialImageListener {
        C0417a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public a(int i, int i2, Options options) {
        this.b = i;
        this.c = i2;
        this.d = (b) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.b.f);
        this.e = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        g<Boolean> gVar = external.sdk.pendo.io.glide.load.resource.bitmap.b.j;
        this.f = options.get(gVar) != null && ((Boolean) options.get(gVar)).booleanValue();
        this.g = (h) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.b.g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setAllocator(this.a.a(this.b, this.c, this.f, false) ? 3 : 1);
        if (this.d == b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0417a());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        h hVar = this.g;
        if (hVar != null) {
            imageDecoder.setTargetColorSpace(ColorSpace.get((hVar == h.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}
