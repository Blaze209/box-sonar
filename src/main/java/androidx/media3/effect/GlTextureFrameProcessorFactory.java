package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
final class GlTextureFrameProcessorFactory {
    private final Context context;
    private final GlObjectsProvider glObjectsProvider;
    private final ListeningExecutorService glThreadExecutorService;

    public GlTextureFrameProcessorFactory(Context context, ListeningExecutorService listeningExecutorService, GlObjectsProvider glObjectsProvider) {
        this.context = context;
        this.glThreadExecutorService = listeningExecutorService;
        this.glObjectsProvider = glObjectsProvider;
    }

    public BitmapToGlTextureFrameProcessor buildBitmapToGlTextureFrameProcessor(ColorInfo colorInfo, ColorInfo colorInfo2, Consumer<VideoFrameProcessingException> consumer) throws VideoFrameProcessingException {
        return BitmapToGlTextureFrameProcessor.create(this.context, this.glThreadExecutorService, this.glObjectsProvider, colorInfo, colorInfo2, consumer);
    }

    public GlTextureToBitmapFrameProcessor buildGlTextureToBitmapFrameProcessor(boolean z) throws VideoFrameProcessingException {
        return new GlTextureToBitmapFrameProcessor(this.context, z, this.glThreadExecutorService, this.glObjectsProvider);
    }

    public List<GlShaderProgramFrameProcessor> buildFrameProcessors(List<GlEffect> list, boolean z) throws VideoFrameProcessingException {
        ImmutableList<GlShaderProgram> immutableListBuildShaderPrograms = buildShaderPrograms(this.context, list, z);
        ArrayList arrayList = new ArrayList();
        UnmodifiableIterator<GlShaderProgram> it = immutableListBuildShaderPrograms.iterator();
        while (it.hasNext()) {
            arrayList.add(GlShaderProgramFrameProcessor.create(this.glThreadExecutorService, it.next(), this.glObjectsProvider));
        }
        return arrayList;
    }

    private ImmutableList<GlShaderProgram> buildShaderPrograms(Context context, List<GlEffect> list, boolean z) throws VideoFrameProcessingException {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        for (GlEffect glEffect : list) {
            if (glEffect instanceof GlMatrixTransformation) {
                builder2.add((GlMatrixTransformation) glEffect);
            } else if (glEffect instanceof RgbMatrix) {
                builder3.add((RgbMatrix) glEffect);
            } else {
                ImmutableList immutableListBuild = builder2.build();
                ImmutableList immutableListBuild2 = builder3.build();
                if (!immutableListBuild.isEmpty() || !immutableListBuild2.isEmpty()) {
                    builder.add(DefaultShaderProgram.create(context, immutableListBuild, immutableListBuild2, z));
                    builder2 = new ImmutableList.Builder();
                    builder3 = new ImmutableList.Builder();
                }
                builder.add(glEffect.toGlShaderProgram(context, z));
            }
        }
        ImmutableList immutableListBuild3 = builder2.build();
        ImmutableList immutableListBuild4 = builder3.build();
        if (!immutableListBuild3.isEmpty() || !immutableListBuild4.isEmpty()) {
            builder.add(DefaultShaderProgram.create(context, immutableListBuild3, immutableListBuild4, z));
        }
        return builder.build();
    }
}
