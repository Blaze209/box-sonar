package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.Matrix;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.datasource.DataSourceBitmapLoader;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BitmapOverlay extends TextureOverlay {
    private final float[] flipVerticallyMatrix;
    private Bitmap lastBitmap;
    private int lastBitmapGenerationId;
    private int lastTextureId;

    public abstract Bitmap getBitmap(long j) throws VideoFrameProcessingException;

    public BitmapOverlay() {
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        Matrix.scaleM(fArrCreate4x4IdentityMatrix, 0, 1.0f, -1.0f, 1.0f);
        this.flipVerticallyMatrix = fArrCreate4x4IdentityMatrix;
        this.lastTextureId = -1;
    }

    public static BitmapOverlay createStaticBitmapOverlay(final Bitmap bitmap) {
        return new BitmapOverlay() { // from class: androidx.media3.effect.BitmapOverlay.1
            @Override // androidx.media3.effect.BitmapOverlay
            public Bitmap getBitmap(long j) {
                return bitmap;
            }
        };
    }

    public static BitmapOverlay createStaticBitmapOverlay(final Bitmap bitmap, final StaticOverlaySettings staticOverlaySettings) {
        return new BitmapOverlay() { // from class: androidx.media3.effect.BitmapOverlay.2
            @Override // androidx.media3.effect.BitmapOverlay
            public Bitmap getBitmap(long j) {
                return bitmap;
            }

            @Override // androidx.media3.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return staticOverlaySettings;
            }
        };
    }

    public static BitmapOverlay createStaticBitmapOverlay(final Context context, final Uri uri, final StaticOverlaySettings staticOverlaySettings) {
        return new BitmapOverlay() { // from class: androidx.media3.effect.BitmapOverlay.3
            private Bitmap lastBitmap;

            @Override // androidx.media3.effect.BitmapOverlay
            public Bitmap getBitmap(long j) throws VideoFrameProcessingException {
                if (this.lastBitmap == null) {
                    try {
                        this.lastBitmap = new DataSourceBitmapLoader.Builder(context).build().loadBitmap(uri).get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new VideoFrameProcessingException(e);
                    } catch (ExecutionException e2) {
                        throw new VideoFrameProcessingException(e2);
                    }
                }
                return this.lastBitmap;
            }

            @Override // androidx.media3.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return staticOverlaySettings;
            }
        };
    }

    @Override // androidx.media3.effect.TextureOverlay
    public Size getTextureSize(long j) {
        return new Size(((Bitmap) Preconditions.checkNotNull(this.lastBitmap)).getWidth(), ((Bitmap) Preconditions.checkNotNull(this.lastBitmap)).getHeight());
    }

    @Override // androidx.media3.effect.TextureOverlay
    public int getTextureId(long j) throws VideoFrameProcessingException {
        Bitmap bitmap = getBitmap(j);
        int generationId = bitmap.getGenerationId();
        if (bitmap != this.lastBitmap || generationId != this.lastBitmapGenerationId) {
            this.lastBitmap = bitmap;
            this.lastBitmapGenerationId = generationId;
            try {
                if (this.lastTextureId == -1) {
                    this.lastTextureId = GlUtil.generateTexture();
                }
                GlUtil.setTexture(this.lastTextureId, bitmap);
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        }
        return this.lastTextureId;
    }

    @Override // androidx.media3.effect.TextureOverlay
    public float[] getVertexTransformation(long j) {
        return this.flipVerticallyMatrix;
    }

    @Override // androidx.media3.effect.TextureOverlay
    public void release() throws VideoFrameProcessingException {
        super.release();
        this.lastBitmap = null;
        int i = this.lastTextureId;
        if (i != -1) {
            try {
                GlUtil.deleteTexture(i);
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        }
        this.lastTextureId = -1;
    }
}
