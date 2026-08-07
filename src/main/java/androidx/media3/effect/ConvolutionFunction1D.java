package androidx.media3.effect;

import androidx.media3.common.util.Size;

/* JADX INFO: loaded from: classes8.dex */
public interface ConvolutionFunction1D {

    public interface Provider {
        Size configure(Size size);

        ConvolutionFunction1D getConvolution(long j);
    }

    float domainEnd();

    float domainStart();

    float value(float f);

    default float width() {
        return domainEnd() - domainStart();
    }
}
