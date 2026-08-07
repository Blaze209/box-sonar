package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class yc implements wc.a {
    public final /* synthetic */ wc.a a;

    public yc(wc.a aVar) {
        aVar.getClass();
        this.a = aVar;
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getCornerRadius() {
        return this.a.getCornerRadius();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitleColor() {
        return this.a.getTitleColor();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitleHeight() {
        return this.a.getTitleHeight();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitleIconsColor() {
        return this.a.getTitleIconsColor();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitlePadding() {
        return this.a.getTitlePadding();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitleTextColor() {
        return this.a.getTitleTextColor();
    }

    @Override // com.pspdfkit.internal.wc.a
    public final int getTitleTextSize() {
        return this.a.getTitleTextSize();
    }
}
