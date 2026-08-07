package com.pspdfkit.contentediting.models;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/contentediting/models/TextBlockStyleInfo;", "", "alignment", "Lcom/pspdfkit/contentediting/models/Alignment;", "lineSpacingFactor", "", "Lcom/pspdfkit/contentediting/models/Numeric;", "rotation", "flipY", "", "<init>", "(Lcom/pspdfkit/contentediting/models/Alignment;Ljava/lang/Float;FZ)V", "getAlignment", "()Lcom/pspdfkit/contentediting/models/Alignment;", "getLineSpacingFactor", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRotation", "()F", "getFlipY", "()Z", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TextBlockStyleInfo {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final boolean flipY;
    private final Float lineSpacingFactor;
    private final float rotation;

    public TextBlockStyleInfo(Alignment alignment, Float f, float f2, boolean z) {
        alignment.getClass();
        this.alignment = alignment;
        this.lineSpacingFactor = f;
        this.rotation = f2;
        this.flipY = z;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean getFlipY() {
        return this.flipY;
    }

    public final Float getLineSpacingFactor() {
        return this.lineSpacingFactor;
    }

    public final float getRotation() {
        return this.rotation;
    }
}
