package com.pspdfkit.utils;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class EdgeInsets {
    public final float bottom;
    public final float left;
    public final float right;
    public final float top;

    public EdgeInsets() {
        this.top = 0.0f;
        this.left = 0.0f;
        this.right = 0.0f;
        this.bottom = 0.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeInsets)) {
            return false;
        }
        EdgeInsets edgeInsets = (EdgeInsets) obj;
        return this.top == edgeInsets.top && this.left == edgeInsets.left && this.right == edgeInsets.right && this.bottom == edgeInsets.bottom;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.top), Float.valueOf(this.left), Float.valueOf(this.bottom), Float.valueOf(this.right));
    }

    public EdgeInsets inverted() {
        return new EdgeInsets(-this.top, -this.left, -this.bottom, -this.right);
    }

    public String toString() {
        return "EdgeInsets{top=" + this.top + ", left=" + this.left + ", bottom=" + this.bottom + ", right=" + this.right + AbstractJsonLexerKt.END_OBJ;
    }

    public EdgeInsets(float f, float f2, float f3, float f4) {
        this.top = f;
        this.left = f2;
        this.bottom = f3;
        this.right = f4;
    }
}
