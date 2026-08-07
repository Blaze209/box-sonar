package com.pspdfkit.ui.overlay;

import android.graphics.RectF;
import android.view.ViewGroup;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public class OverlayLayoutParams extends ViewGroup.LayoutParams {
    public Size fixedScreenSize;
    public LayoutPosition layoutPosition;
    public Size minSize;
    public boolean noZoom;
    public final PageRect pageRect;
    public final SizingMode sizingMode;

    public enum LayoutPosition {
        CENTER,
        TOP_LEFT
    }

    public enum SizingMode {
        LAYOUT,
        SCALING
    }

    public OverlayLayoutParams(PageRect pageRect, SizingMode sizingMode) {
        super(-2, -2);
        this.noZoom = false;
        this.minSize = new Size(0.0f, 0.0f);
        this.layoutPosition = LayoutPosition.TOP_LEFT;
        uw.a(pageRect, "pageRect", null);
        uw.a(sizingMode, "layoutSpace", null);
        this.pageRect = pageRect;
        this.sizingMode = sizingMode;
    }

    public OverlayLayoutParams(RectF rectF, SizingMode sizingMode) {
        this(new PageRect(rectF), sizingMode);
    }

    public OverlayLayoutParams() {
        this(new PageRect(), SizingMode.LAYOUT);
    }
}
