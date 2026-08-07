package sdk.pendo.io.j7;

import android.graphics.Bitmap;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0010¢\u0006\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/j7/h;", "Lsdk/pendo/io/j7/v;", "Lsdk/pendo/io/j7/o;", "objectFit", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "jsonObject", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "styleAttributes", "(Lorg/json/JSONObject;Ljava/lang/StringBuilder;)V", "Landroid/graphics/Bitmap;", "G", "Landroid/graphics/Bitmap;", "imageBitmap", "H", "Lsdk/pendo/io/j7/o;", "", "id", ViewProps.Z_INDEX, "", "elementName", "<init>", "(IILandroid/graphics/Bitmap;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class h extends v {

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private Bitmap imageBitmap;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private o objectFit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i, int i2, Bitmap imageBitmap, String elementName) {
        super(i, i2, elementName, "img");
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        this.imageBitmap = imageBitmap;
        this.objectFit = new o(o.a.CONTAIN);
    }

    @Override // sdk.pendo.io.j7.v
    public void a(JSONObject jsonObject, StringBuilder styleAttributes) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(styleAttributes, "styleAttributes");
        JSONObject jSONObject = new JSONObject();
        String strA = sdk.pendo.io.b7.b.a(this.imageBitmap);
        if (strA != null) {
            jSONObject.put("src", "data:image/webp;base64," + strA);
            o oVar = this.objectFit;
            if (oVar != null) {
                styleAttributes.append(oVar.c());
            }
        }
        jsonObject.put(NativeAuthConstants.GrantType.ATTRIBUTES, jSONObject.put("style", styleAttributes.toString()));
    }

    @Override // sdk.pendo.io.j7.v
    public JSONArray c() {
        return new JSONArray();
    }

    public final void a(o objectFit) {
        this.objectFit = objectFit;
    }
}
