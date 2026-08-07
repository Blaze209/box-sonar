package sdk.pendo.io.j7;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0010¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/j7/f;", "Lsdk/pendo/io/j7/x;", "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "jsonObject", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "styleAttributes", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lorg/json/JSONObject;Ljava/lang/StringBuilder;)V", "Landroid/graphics/Bitmap;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/Bitmap;", "imageBitmap", "", "id", ViewProps.Z_INDEX, "", "elementName", "<init>", "(IILandroid/graphics/Bitmap;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f extends x {

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private final Bitmap imageBitmap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i, int i2, Bitmap imageBitmap, String elementName) {
        super(i, i2, elementName, "img");
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        this.imageBitmap = imageBitmap;
    }

    @Override // sdk.pendo.io.j7.v
    public void a(JSONObject jsonObject, StringBuilder styleAttributes) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(styleAttributes, "styleAttributes");
        JSONObject jSONObject = new JSONObject();
        String strA = sdk.pendo.io.b7.b.a(this.imageBitmap);
        if (strA != null) {
            jSONObject.put("src", "data:image/webp;base64," + strA);
        }
        styleAttributes.append("position: " + u.a.RELATIVE);
        jsonObject.put(NativeAuthConstants.GrantType.ATTRIBUTES, jSONObject.put("style", styleAttributes.toString()));
    }

    @Override // sdk.pendo.io.j7.x, sdk.pendo.io.j7.v
    public JSONArray c() {
        return new JSONArray();
    }
}
