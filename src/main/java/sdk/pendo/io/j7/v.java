package sdk.pendo.io.j7;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b \u0018\u0000 \u0085\u00012\u00020\u0001:\u0001\bB)\u0012\u0006\u00109\u001a\u00020\u0002\u0012\u0006\u0010:\u001a\u00020\u0002\u0012\u0006\u0010>\u001a\u00020\u0011\u0012\u0006\u0010?\u001a\u00020\u0011¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J&\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002J&\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\b\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010\b\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!J\u0017\u0010\b\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\b\u0010%J\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010'J\b\u0010\b\u001a\u00020)H\u0016J\u000f\u0010\u0004\u001a\u00020*H ¢\u0006\u0004\b\u0004\u0010+J\u0013\u0010.\u001a\u00060,j\u0002`-H\u0010¢\u0006\u0004\b.\u0010/J#\u0010\b\u001a\u0002022\u0006\u00100\u001a\u00020)2\n\u00101\u001a\u00060,j\u0002`-H\u0010¢\u0006\u0004\b\b\u00103J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u0002H\u0004J\u0010\u00105\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0002H\u0004J\b\u0010\u0010\u001a\u00020)H\u0016R\"\u00109\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u00106\u001a\u0004\b\u001b\u00107\"\u0004\b.\u00108R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00106R\u0017\u0010>\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0004\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010;R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010AR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010CR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010CR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010DR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010CR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010;R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010CR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010;R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010;¨\u0006\u0086\u0001"}, d2 = {"Lsdk/pendo/io/j7/v;", "Lsdk/pendo/io/h7/q;", "", "left", "c", "(Ljava/lang/Integer;)Lsdk/pendo/io/j7/v;", "Lsdk/pendo/io/j7/y;", "width", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/j7/g;", "height", "Lsdk/pendo/io/j7/u;", ViewProps.POSITION, "gravity", "k", CmcdData.STREAM_TYPE_LIVE, "b", "", ViewProps.FLEX_GROW, ViewProps.TOP, "right", ViewProps.BOTTOM, "j", "i", "g", "f", CmcdData.STREAMING_FORMAT_HLS, "e", "backgroundColor", "Lsdk/pendo/io/h7/c;", ViewProps.BORDER_WIDTH, "Lsdk/pendo/io/h7/a;", ViewProps.BORDER_COLOR, "Lsdk/pendo/io/h7/b;", ViewProps.BORDER_RADIUS, "", ViewProps.OPACITY, "(Ljava/lang/Float;)Lsdk/pendo/io/j7/v;", "elevation", "Landroid/graphics/Rect;", "locationOnScreen", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "()Lorg/json/JSONArray;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "()Ljava/lang/StringBuilder;", "jsonObject", "styleAttributes", "", "(Lorg/json/JSONObject;Ljava/lang/StringBuilder;)V", "color", CmcdData.OBJECT_TYPE_MANIFEST, "I", "()I", "(I)V", "id", ViewProps.Z_INDEX, "Ljava/lang/String;", "getElementName", "()Ljava/lang/String;", "elementName", "tag", "", "Z", "showDebuggingBorders", "Ljava/lang/Integer;", "Lsdk/pendo/io/j7/y;", "Lsdk/pendo/io/j7/g;", "Lsdk/pendo/io/j7/r;", "Lsdk/pendo/io/j7/r;", ViewProps.PADDING_LEFT, "Lsdk/pendo/io/j7/s;", "Lsdk/pendo/io/j7/s;", ViewProps.PADDING_RIGHT, "Lsdk/pendo/io/j7/t;", "Lsdk/pendo/io/j7/t;", ViewProps.PADDING_TOP, "Lsdk/pendo/io/j7/q;", "Lsdk/pendo/io/j7/q;", ViewProps.PADDING_BOTTOM, "Lsdk/pendo/io/j7/l;", "n", "Lsdk/pendo/io/j7/l;", ViewProps.MARGIN_LEFT, "Lsdk/pendo/io/j7/m;", "o", "Lsdk/pendo/io/j7/m;", ViewProps.MARGIN_RIGHT, "Lsdk/pendo/io/j7/n;", "p", "Lsdk/pendo/io/j7/n;", ViewProps.MARGIN_TOP, "Lsdk/pendo/io/j7/k;", "q", "Lsdk/pendo/io/j7/k;", ViewProps.MARGIN_BOTTOM, "r", "Lsdk/pendo/io/j7/u;", "Lsdk/pendo/io/j7/j;", "s", "Lsdk/pendo/io/j7/j;", "selfHorizontalAlignment", "Lsdk/pendo/io/j7/b;", "t", "Lsdk/pendo/io/j7/b;", "selfVerticalAlignment", "Lsdk/pendo/io/j7/i;", "u", "Lsdk/pendo/io/j7/i;", "containerHorizontalAlignment", "Lsdk/pendo/io/j7/a;", "v", "Lsdk/pendo/io/j7/a;", "containerVerticalAlignment", "w", "x", "Lsdk/pendo/io/h7/c;", "y", "borderStyle", "z", "Lsdk/pendo/io/h7/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/h7/b;", "B", "Ljava/lang/Float;", "C", "D", "direction", ExifInterface.LONGITUDE_EAST, "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "F", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class v implements sdk.pendo.io.h7.q {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private sdk.pendo.io.h7.b borderRadius;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private Float opacity;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private Integer elevation;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private String direction;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private String flexGrow;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int zIndex;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String elementName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String tag;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean showDebuggingBorders;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Integer left;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Integer top;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private y width;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private g height;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private r paddingLeft;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private s paddingRight;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private t paddingTop;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private q paddingBottom;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private l marginLeft;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private m marginRight;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private n marginTop;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private k marginBottom;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private u position;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private j selfHorizontalAlignment;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private b selfVerticalAlignment;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private i containerHorizontalAlignment;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private a containerVerticalAlignment;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private Integer backgroundColor;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private sdk.pendo.io.h7.c borderWidth;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private String borderStyle;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private sdk.pendo.io.h7.a borderColor;

    public v(int i, int i2, String elementName, String tag) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.id = i;
        this.zIndex = i2;
        this.elementName = elementName;
        this.tag = tag;
        this.showDebuggingBorders = sdk.pendo.io.h7.r.a.i();
        this.position = new u(u.a.ABSOLUTE);
    }

    public void a(JSONObject jsonObject, StringBuilder styleAttributes) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(styleAttributes, "styleAttributes");
        jsonObject.put(NativeAuthConstants.GrantType.ATTRIBUTES, new JSONObject().put("style", styleAttributes.toString()));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:12:0x0018  */
    public final v b(int gravity) {
        i.a aVar;
        int i = gravity & 7;
        if (i == 3) {
            aVar = i.a.FLEX_START;
        } else if (i == 5) {
            aVar = i.a.FLEX_END;
        } else if (i == 8388611) {
            aVar = i.a.FLEX_START;
        } else if (i != 8388613) {
            aVar = i.a.CENTER;
        } else {
            aVar = i.a.FLEX_END;
        }
        this.containerHorizontalAlignment = new i(aVar);
        return this;
    }

    public abstract JSONArray c();

    public final v c(int gravity) {
        a.EnumC0403a enumC0403a;
        int i = gravity & 112;
        if (i != 48) {
            enumC0403a = i != 80 ? a.EnumC0403a.CENTER : a.EnumC0403a.FLEX_END;
        } else {
            enumC0403a = a.EnumC0403a.FLEX_START;
        }
        this.containerVerticalAlignment = new a(enumC0403a);
        return this;
    }

    public StringBuilder d() {
        String str;
        String strC;
        StringBuilder sb;
        String strA;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("elementName: " + this.elementName + "; ");
        Integer num = this.left;
        if (num != null) {
            sb2.append("left: " + num.intValue() + "px; ");
        }
        Integer num2 = this.top;
        if (num2 != null) {
            sb2.append("top: " + num2.intValue() + "px; ");
        }
        y yVar = this.width;
        if (yVar != null) {
            sb2.append(yVar.c());
        }
        g gVar = this.height;
        if (gVar != null) {
            sb2.append(gVar.c());
        }
        b bVar = this.selfVerticalAlignment;
        if (bVar != null) {
            sb2.append(bVar.c());
        }
        j jVar = this.selfHorizontalAlignment;
        if (jVar != null) {
            sb2.append(jVar.c());
        }
        a aVar = this.containerVerticalAlignment;
        if (aVar != null) {
            sb2.append(aVar.c());
        }
        i iVar = this.containerHorizontalAlignment;
        if (iVar != null) {
            sb2.append(iVar.c());
        }
        String str2 = this.direction;
        if (str2 != null) {
            sb2.append("direction: " + str2 + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        }
        u uVar = this.position;
        if (uVar != null) {
            sb2.append(uVar.c());
        }
        r rVar = this.paddingLeft;
        if (rVar != null) {
            sb2.append(rVar.c());
        }
        s sVar = this.paddingRight;
        if (sVar != null) {
            sb2.append(sVar.c());
        }
        t tVar = this.paddingTop;
        if (tVar != null) {
            sb2.append(tVar.c());
        }
        q qVar = this.paddingBottom;
        if (qVar != null) {
            sb2.append(qVar.c());
        }
        l lVar = this.marginLeft;
        if (lVar != null) {
            sb2.append(lVar.c());
        }
        m mVar = this.marginRight;
        if (mVar != null) {
            sb2.append(mVar.c());
        }
        n nVar = this.marginTop;
        if (nVar != null) {
            sb2.append(nVar.c());
        }
        k kVar = this.marginBottom;
        if (kVar != null) {
            sb2.append(kVar.c());
        }
        Integer num3 = this.backgroundColor;
        if (num3 != null) {
            sb2.append("background-color: " + m(num3.intValue()) + "; ");
        }
        if (this.showDebuggingBorders) {
            str = "inset 0px 0px 0px 3px " + m(-46986);
        } else {
            sdk.pendo.io.h7.c cVar = this.borderWidth;
            if (cVar != null) {
                sb2.append((cVar.e() ? new StringBuilder("border-width: ").append(cVar.getTop()).append("px; ") : new StringBuilder("border-width: ").append(cVar.f()).append("; ")).toString());
                sb2.append("border-style: solid; ");
            }
            String str3 = this.borderStyle;
            if (str3 != null) {
                sb2.append("border-style: " + str3 + "; ");
            }
            sdk.pendo.io.h7.a aVar2 = this.borderColor;
            if (aVar2 != null) {
                if (aVar2.b()) {
                    strC = m(aVar2.getTop());
                    sb = new StringBuilder("border-color: ");
                } else {
                    strC = aVar2.c();
                    sb = new StringBuilder("border-color: ");
                }
                sb2.append(sb.append(strC).append("; ").toString());
            }
            str = null;
        }
        sdk.pendo.io.h7.b bVar2 = this.borderRadius;
        if (bVar2 != null) {
            sb2.append("border-radius: " + bVar2.e() + "; ");
            sb2.append("box-sizing: border-box; ");
        }
        sb2.append("z-index: " + this.zIndex + "; ");
        Integer num4 = this.elevation;
        if (num4 != null && (strA = a(num4.intValue())) != null) {
            sb2.append("box-shadow: " + strA + "; ");
            if (str != null) {
                str = ((Object) str) + ", " + strA;
            }
        }
        Float f = this.opacity;
        if (f != null) {
            sb2.append("opacity: " + f.floatValue() + "; ");
        }
        if (str != null) {
            sb2.append("box-shadow: " + str + "; ");
        }
        sb2.append("box-sizing: border-box;");
        String str4 = this.flexGrow;
        if (str4 != null) {
            sb2.append("flex-grow: " + str4 + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        }
        return sb2;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final v f(int right) {
        this.marginRight = new m(right);
        return this;
    }

    public final v g(int left) {
        this.marginLeft = new l(left);
        return this;
    }

    public final v h(int top) {
        this.marginTop = new n(top);
        return this;
    }

    public final v i(int right) {
        this.paddingRight = new s(right);
        return this;
    }

    public final v j(int left) {
        this.paddingLeft = new r(left);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:12:0x0018  */
    public final v k(int gravity) {
        j.a aVar;
        int i = gravity & 7;
        if (i == 3) {
            aVar = j.a.START;
        } else if (i == 5) {
            aVar = j.a.END;
        } else if (i == 8388611) {
            aVar = j.a.START;
        } else if (i != 8388613) {
            aVar = j.a.CENTER;
        } else {
            aVar = j.a.END;
        }
        this.selfHorizontalAlignment = new j(aVar);
        this.left = null;
        return this;
    }

    public final v l(int gravity) {
        b.a aVar;
        int i = gravity & 112;
        if (i != 48) {
            aVar = i != 80 ? b.a.CENTER : b.a.FLEX_END;
        } else {
            aVar = b.a.FLEX_START;
        }
        this.selfVerticalAlignment = new b(aVar);
        this.top = null;
        return this;
    }

    protected final String m(int color) {
        String str;
        int i = (color >>> 24) & 255;
        int i2 = (color >>> 16) & 255;
        int i3 = (color >>> 8) & 255;
        int i4 = color & 255;
        if (i < 255) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("#%02X%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i)}, 4));
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format("#%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
        }
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    protected final String a(int elevation) {
        if (elevation < 0) {
            return null;
        }
        float f = elevation;
        float f2 = 0.5f * f;
        return ("0px " + f2 + "px " + (1.0f * f) + "px 0px rgba(0, 0, 0, 0.2)") + ", " + ("0px " + (f * 0.25f) + "px " + f2 + "px 0px rgba(0, 0, 0, 0.14)");
    }

    public final v b(Integer elevation) {
        this.elevation = elevation;
        return this;
    }

    public final v c(Integer left) {
        this.left = left;
        return this;
    }

    public final void d(int i) {
        this.id = i;
    }

    public final v e(int bottom) {
        this.marginBottom = new k(bottom);
        return this;
    }

    public final v a(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public final v b(int left, int top, int right, int bottom) {
        if (left != 0) {
            this.paddingLeft = new r(left);
        }
        if (top != 0) {
            this.paddingTop = new t(top);
        }
        if (right != 0) {
            this.paddingRight = new s(right);
        }
        if (bottom != 0) {
            this.paddingBottom = new q(bottom);
        }
        return this;
    }

    public final v a(sdk.pendo.io.h7.a borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject b() {
        return new JSONObject();
    }

    public final v a(sdk.pendo.io.h7.b borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public final v a(sdk.pendo.io.h7.c borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public final v a(String flexGrow) {
        this.flexGrow = flexGrow;
        return this;
    }

    public final v a(g height) {
        this.height = height;
        return this;
    }

    public final v a(Rect locationOnScreen) {
        this.left = locationOnScreen != null ? Integer.valueOf(locationOnScreen.left) : null;
        this.top = locationOnScreen != null ? Integer.valueOf(locationOnScreen.top) : null;
        if (locationOnScreen != null) {
            this.width = new y(Integer.valueOf(locationOnScreen.right), y.a.LENGTH);
        }
        if (locationOnScreen != null) {
            this.height = new g(Integer.valueOf(locationOnScreen.bottom), g.a.LENGTH);
        }
        return this;
    }

    public final v a(int left, int top, int right, int bottom) {
        if (left != 0) {
            this.marginLeft = new l(left);
        }
        if (top != 0) {
            this.marginTop = new n(top);
        }
        if (right != 0) {
            this.marginRight = new m(right);
        }
        if (bottom != 0) {
            this.marginBottom = new k(bottom);
        }
        return this;
    }

    public final v a(Float opacity) {
        this.opacity = opacity;
        return this;
    }

    public final v a(u position) {
        this.position = position;
        return this;
    }

    public final v a(y width) {
        this.width = width;
        return this;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("type", sdk.pendo.io.h7.k.ELEMENT.getValue());
        jSONObject.put("tagName", this.tag);
        a(jSONObject, d());
        jSONObject.put("childNodes", c());
        return jSONObject;
    }
}
