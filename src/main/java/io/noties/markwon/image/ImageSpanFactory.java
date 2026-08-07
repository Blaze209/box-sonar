package io.noties.markwon.image;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;

/* JADX INFO: loaded from: classes4.dex */
public class ImageSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new AsyncDrawableSpan(markwonConfiguration.theme(), new AsyncDrawable(ImageProps.DESTINATION.require(renderProps), markwonConfiguration.asyncDrawableLoader(), markwonConfiguration.imageSizeResolver(), ImageProps.IMAGE_SIZE.get(renderProps)), 0, ImageProps.REPLACEMENT_TEXT_IS_LINK.get(renderProps, false).booleanValue());
    }
}
