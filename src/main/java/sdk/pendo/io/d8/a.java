package sdk.pendo.io.d8;

import android.graphics.Point;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0011\u0010$\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010#¨\u0006'"}, d2 = {"Lsdk/pendo/io/d8/a;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "f", "()Ljava/lang/String;", "imageUrl", "b", "e", "imageFillType", "c", "I", "()I", "backgroundColor", "d", ViewProps.BORDER_COLOR, ViewProps.BORDER_WIDTH, "", "[F", "getCornerRadii", "()[F", "cornerRadii", "Landroid/graphics/Point;", "g", "Landroid/graphics/Point;", "()Landroid/graphics/Point;", "screenSize", "", "()F", "cornerRadius", "<init>", "(Ljava/lang/String;Ljava/lang/String;III[FLandroid/graphics/Point;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String imageUrl;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String imageFillType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int backgroundColor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int borderColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int borderWidth;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final float[] cornerRadii;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Point screenSize;

    public a(String str, String str2, int i, int i2, int i3, float[] fArr, Point screenSize) {
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        this.imageUrl = str;
        this.imageFillType = str2;
        this.backgroundColor = i;
        this.borderColor = i2;
        this.borderWidth = i3;
        this.cornerRadii = fArr;
        this.screenSize = screenSize;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final float d() {
        Float fFirstOrNull;
        float[] fArr = this.cornerRadii;
        if (fArr == null || (fFirstOrNull = ArraysKt.firstOrNull(fArr)) == null) {
            return 0.0f;
        }
        return fFirstOrNull.floatValue();
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getImageFillType() {
        return this.imageFillType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Intrinsics.areEqual(this.imageUrl, aVar.imageUrl) && Intrinsics.areEqual(this.imageFillType, aVar.imageFillType) && this.backgroundColor == aVar.backgroundColor && this.borderColor == aVar.borderColor && this.borderWidth == aVar.borderWidth && Intrinsics.areEqual(this.cornerRadii, aVar.cornerRadii) && Intrinsics.areEqual(this.screenSize, aVar.screenSize);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Point getScreenSize() {
        return this.screenSize;
    }

    public int hashCode() {
        String str = this.imageUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageFillType;
        int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.borderColor)) * 31) + Integer.hashCode(this.borderWidth)) * 31;
        float[] fArr = this.cornerRadii;
        return ((iHashCode2 + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.screenSize.hashCode();
    }

    public String toString() {
        return "BackgroundRenderConfig(imageUrl=" + this.imageUrl + ", imageFillType=" + this.imageFillType + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", cornerRadii=" + Arrays.toString(this.cornerRadii) + ", screenSize=" + this.screenSize + ")";
    }
}
