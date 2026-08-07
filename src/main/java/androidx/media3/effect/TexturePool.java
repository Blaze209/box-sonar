package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.GlUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
final class TexturePool {
    private final int capacity;
    private final Deque<GlTextureInfo> freeTextures;
    private final Deque<GlTextureInfo> inUseTextures;
    private final boolean useHighPrecisionColorComponents;

    public TexturePool(boolean z, int i) {
        this.capacity = i;
        this.useHighPrecisionColorComponents = z;
        this.freeTextures = new ArrayDeque(i);
        this.inUseTextures = new ArrayDeque(i);
    }

    public boolean isConfigured() {
        return getIteratorToAllTextures().hasNext();
    }

    public int capacity() {
        return this.capacity;
    }

    public int freeTextureCount() {
        if (!isConfigured()) {
            return this.capacity;
        }
        return this.freeTextures.size();
    }

    public void ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws GlUtil.GlException {
        if (!isConfigured()) {
            createTextures(glObjectsProvider, i, i2);
            return;
        }
        GlTextureInfo next = getIteratorToAllTextures().next();
        if (next.width == i && next.height == i2) {
            return;
        }
        deleteAllTextures();
        createTextures(glObjectsProvider, i, i2);
    }

    public GlTextureInfo useTexture() {
        if (this.freeTextures.isEmpty()) {
            throw new IllegalStateException("Textures are all in use. Please release in-use textures before calling useTexture.");
        }
        GlTextureInfo glTextureInfoRemove = this.freeTextures.remove();
        this.inUseTextures.add(glTextureInfoRemove);
        return glTextureInfoRemove;
    }

    public GlTextureInfo getMostRecentlyUsedTexture() {
        if (this.inUseTextures.isEmpty()) {
            return null;
        }
        return this.inUseTextures.getLast();
    }

    public void freeTexture(GlTextureInfo glTextureInfo) {
        Preconditions.checkState(this.inUseTextures.contains(glTextureInfo));
        this.inUseTextures.remove(glTextureInfo);
        this.freeTextures.add(glTextureInfo);
    }

    public boolean isUsingTexture(GlTextureInfo glTextureInfo) {
        return this.inUseTextures.contains(glTextureInfo);
    }

    public void freeTexture() {
        Preconditions.checkState(!this.inUseTextures.isEmpty());
        this.freeTextures.add(this.inUseTextures.remove());
    }

    public void freeAllTextures() {
        this.freeTextures.addAll(this.inUseTextures);
        this.inUseTextures.clear();
    }

    public void deleteAllTextures() throws GlUtil.GlException {
        Iterator<GlTextureInfo> iteratorToAllTextures = getIteratorToAllTextures();
        while (iteratorToAllTextures.hasNext()) {
            iteratorToAllTextures.next().release();
        }
        this.freeTextures.clear();
        this.inUseTextures.clear();
    }

    private void createTextures(GlObjectsProvider glObjectsProvider, int i, int i2) throws GlUtil.GlException {
        Preconditions.checkState(this.freeTextures.isEmpty());
        Preconditions.checkState(this.inUseTextures.isEmpty());
        for (int i3 = 0; i3 < this.capacity; i3++) {
            this.freeTextures.add(glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(i, i2, this.useHighPrecisionColorComponents), i, i2));
        }
    }

    private Iterator<GlTextureInfo> getIteratorToAllTextures() {
        return Iterables.concat(this.freeTextures, this.inUseTextures).iterator();
    }
}
