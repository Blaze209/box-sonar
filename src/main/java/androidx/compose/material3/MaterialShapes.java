package androidx.compose.material3;

import androidx.compose.material3.internal.ShapeUtilKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.RoundedPolygonKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.annotations.NoteAnnotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MaterialShapes.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b7\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/material3/MaterialShapes;", "", "<init>", "()V", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MaterialShapes {
    public static final int $stable = 0;
    private static RoundedPolygon _arch;
    private static RoundedPolygon _arrow;
    private static RoundedPolygon _boom;
    private static RoundedPolygon _bun;
    private static RoundedPolygon _burst;
    private static RoundedPolygon _circle;
    private static RoundedPolygon _clamShell;
    private static RoundedPolygon _clover4Leaf;
    private static RoundedPolygon _clover8Leaf;
    private static RoundedPolygon _cookie12Sided;
    private static RoundedPolygon _cookie4Sided;
    private static RoundedPolygon _cookie6Sided;
    private static RoundedPolygon _cookie7Sided;
    private static RoundedPolygon _cookie9Sided;
    private static RoundedPolygon _diamond;
    private static RoundedPolygon _fan;
    private static RoundedPolygon _flower;
    private static RoundedPolygon _gem;
    private static RoundedPolygon _ghostish;
    private static RoundedPolygon _heart;
    private static RoundedPolygon _oval;
    private static RoundedPolygon _pentagon;
    private static RoundedPolygon _pill;
    private static RoundedPolygon _pixelCircle;
    private static RoundedPolygon _pixelTriangle;
    private static RoundedPolygon _puffy;
    private static RoundedPolygon _puffyDiamond;
    private static RoundedPolygon _semiCircle;
    private static RoundedPolygon _slanted;
    private static RoundedPolygon _softBoom;
    private static RoundedPolygon _softBurst;
    private static RoundedPolygon _square;
    private static RoundedPolygon _sunny;
    private static RoundedPolygon _triangle;
    private static RoundedPolygon _verySunny;
    private static final float[] rotateNeg135;
    private static final float[] rotateNeg45;
    private static final float[] rotateNeg90;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CornerRounding cornerRound15 = new CornerRounding(0.15f, 0.0f, 2, null);
    private static final CornerRounding cornerRound20 = new CornerRounding(0.2f, 0.0f, 2, null);
    private static final CornerRounding cornerRound30 = new CornerRounding(0.3f, 0.0f, 2, null);
    private static final CornerRounding cornerRound50 = new CornerRounding(0.5f, 0.0f, 2, null);
    private static final CornerRounding cornerRound100 = new CornerRounding(1.0f, 0.0f, 2, null);

    public /* synthetic */ MaterialShapes(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MaterialShapes() {
    }

    /* JADX INFO: compiled from: MaterialShapes.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0010\b\n\u0002\bF\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002Ú\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010z\u001a\u00020\u00102\b\b\u0002\u0010{\u001a\u00020|H\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0085\u0001J\u000f\u0010\u0086\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0087\u0001J\u000f\u0010\u0088\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0089\u0001J\u000f\u0010\u008a\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u008b\u0001J\u000f\u0010\u008c\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u008f\u0001J\u000f\u0010\u0090\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0091\u0001J\u000f\u0010\u0092\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0093\u0001J\u000f\u0010\u0094\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0095\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0097\u0001J\u000f\u0010\u0098\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u009d\u0001J\u000f\u0010\u009e\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u009f\u0001J\u000f\u0010 \u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¡\u0001J\u000f\u0010¢\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b£\u0001J\u000f\u0010¤\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¥\u0001J\u000f\u0010¦\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b§\u0001J\u000f\u0010¨\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b©\u0001J\u000f\u0010ª\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b«\u0001J\u000f\u0010¬\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¯\u0001J\u000f\u0010°\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b±\u0001J\u000f\u0010²\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b³\u0001J\u000f\u0010´\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bµ\u0001J\u000f\u0010¶\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b·\u0001J\u000f\u0010¸\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b»\u0001J\u000f\u0010¼\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b½\u0001J\u000f\u0010¾\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¿\u0001J\u000f\u0010À\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÁ\u0001JH\u0010Â\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010Ã\u00012\u000f\u0010Å\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020|2\b\u0010Ç\u0001\u001a\u00030È\u00012\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001J.\u0010Í\u0001\u001a\u00030È\u0001*\u00030È\u00012\b\u0010Î\u0001\u001a\u00030Ï\u00012\n\b\u0002\u0010Ç\u0001\u001a\u00030È\u0001H\u0002¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u000f\u0010Ò\u0001\u001a\u00030Ï\u0001*\u00030Ï\u0001H\u0002J\u0018\u0010Ó\u0001\u001a\u00030Ï\u0001*\u00030È\u0001H\u0002¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001JD\u0010Ö\u0001\u001a\u00020\u00102\u000f\u0010×\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020|2\n\b\u0002\u0010Ç\u0001\u001a\u00030È\u00012\n\b\u0002\u0010É\u0001\u001a\u00030Ê\u0001H\u0002¢\u0006\u0006\bØ\u0001\u0010Ù\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b7\u00105R\u0011\u00108\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b9\u00105R\u0011\u0010:\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b;\u00105R\u0011\u0010<\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b=\u00105R\u0011\u0010>\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b?\u00105R\u0011\u0010@\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bA\u00105R\u0011\u0010B\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bC\u00105R\u0011\u0010D\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bE\u00105R\u0011\u0010F\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bG\u00105R\u0011\u0010H\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bI\u00105R\u0011\u0010J\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bK\u00105R\u0011\u0010L\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bM\u00105R\u0011\u0010N\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bO\u00105R\u0011\u0010P\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bQ\u00105R\u0011\u0010R\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bS\u00105R\u0011\u0010T\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bU\u00105R\u0011\u0010V\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bW\u00105R\u0011\u0010X\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bY\u00105R\u0011\u0010Z\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b[\u00105R\u0011\u0010\\\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b]\u00105R\u0011\u0010^\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b_\u00105R\u0011\u0010`\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\ba\u00105R\u0011\u0010b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bc\u00105R\u0011\u0010d\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\be\u00105R\u0011\u0010f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bg\u00105R\u0011\u0010h\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bi\u00105R\u0011\u0010j\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bk\u00105R\u0011\u0010l\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bm\u00105R\u0011\u0010n\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bo\u00105R\u0011\u0010p\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bq\u00105R\u0011\u0010r\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bs\u00105R\u0011\u0010t\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bu\u00105R\u0011\u0010v\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bw\u00105R\u0011\u0010x\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\by\u00105¨\u0006Û\u0001"}, d2 = {"Landroidx/compose/material3/MaterialShapes$Companion;", "", "<init>", "()V", "cornerRound15", "Landroidx/graphics/shapes/CornerRounding;", "cornerRound20", "cornerRound30", "cornerRound50", "cornerRound100", "rotateNeg45", "Landroidx/compose/ui/graphics/Matrix;", "[F", "rotateNeg90", "rotateNeg135", "_circle", "Landroidx/graphics/shapes/RoundedPolygon;", "_square", "_slanted", "_arch", "_fan", "_arrow", "_semiCircle", "_oval", "_pill", "_triangle", "_diamond", "_clamShell", "_pentagon", "_gem", "_verySunny", "_sunny", "_cookie4Sided", "_cookie6Sided", "_cookie7Sided", "_cookie9Sided", "_cookie12Sided", "_ghostish", "_clover4Leaf", "_clover8Leaf", "_burst", "_softBurst", "_boom", "_softBoom", "_flower", "_puffy", "_puffyDiamond", "_pixelCircle", "_pixelTriangle", "_bun", "_heart", NoteAnnotation.CIRCLE, "getCircle", "()Landroidx/graphics/shapes/RoundedPolygon;", "Square", "getSquare", "Slanted", "getSlanted", "Arch", "getArch", "Fan", "getFan", "Arrow", "getArrow", "SemiCircle", "getSemiCircle", "Oval", "getOval", "Pill", "getPill", "Triangle", "getTriangle", "Diamond", "getDiamond", "ClamShell", "getClamShell", "Pentagon", "getPentagon", "Gem", "getGem", "Sunny", "getSunny", "VerySunny", "getVerySunny", "Cookie4Sided", "getCookie4Sided", "Cookie6Sided", "getCookie6Sided", "Cookie7Sided", "getCookie7Sided", "Cookie9Sided", "getCookie9Sided", "Cookie12Sided", "getCookie12Sided", "Ghostish", "getGhostish", "Clover4Leaf", "getClover4Leaf", "Clover8Leaf", "getClover8Leaf", "Burst", "getBurst", "SoftBurst", "getSoftBurst", "Boom", "getBoom", "SoftBoom", "getSoftBoom", "Flower", "getFlower", "Puffy", "getPuffy", "PuffyDiamond", "getPuffyDiamond", "PixelCircle", "getPixelCircle", "PixelTriangle", "getPixelTriangle", "Bun", "getBun", "Heart", "getHeart", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, "numVertices", "", "circle$material3", "square", "square$material3", "slanted", "slanted$material3", "arch", "arch$material3", "fan", "fan$material3", "arrow", "arrow$material3", "semiCircle", "semiCircle$material3", "oval", "oval$material3", "pill", "pill$material3", "triangle", "triangle$material3", "diamond", "diamond$material3", "clamShell", "clamShell$material3", "pentagon", "pentagon$material3", "gem", "gem$material3", "sunny", "sunny$material3", "verySunny", "verySunny$material3", "cookie4", "cookie4$material3", "cookie6", "cookie6$material3", "cookie7", "cookie7$material3", "cookie9", "cookie9$material3", "cookie12", "cookie12$material3", "ghostish", "ghostish$material3", "clover4", "clover4$material3", "clover8", "clover8$material3", "burst", "burst$material3", "softBurst", "softBurst$material3", "boom", "boom$material3", "softBoom", "softBoom$material3", "flower", "flower$material3", "puffy", "puffy$material3", "puffyDiamond", "puffyDiamond$material3", "pixelCircle", "pixelCircle$material3", "pixelTriangle", "pixelTriangle$material3", "bun", "bun$material3", "heart", "heart$material3", "doRepeat", "", "Landroidx/compose/material3/MaterialShapes$Companion$PointNRound;", "points", "reps", TtmlNode.CENTER, "Landroidx/compose/ui/geometry/Offset;", "mirroring", "", "doRepeat-Rg1IO4c", "(Ljava/util/List;IJZ)Ljava/util/List;", "rotateDegrees", "angle", "", "rotateDegrees-Ho4pAXE", "(JFJ)J", "toRadians", "angleDegrees", "angleDegrees-k-4lQ0M", "(J)F", "customPolygon", "pnr", "customPolygon-Rg1IO4c", "(Ljava/util/List;IJZ)Landroidx/graphics/shapes/RoundedPolygon;", "PointNRound", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float toRadians(float f) {
            return (f / 360.0f) * 2 * 3.1415927f;
        }

        private Companion() {
        }

        public final RoundedPolygon getCircle() {
            RoundedPolygon roundedPolygon = MaterialShapes._circle;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = circle$material3$default(this, 0, 1, null).normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._circle = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSquare() {
            RoundedPolygon roundedPolygon = MaterialShapes._square;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = square$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._square = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSlanted() {
            RoundedPolygon roundedPolygon = MaterialShapes._slanted;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = slanted$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._slanted = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getArch() {
            RoundedPolygon roundedPolygon = MaterialShapes._arch;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = arch$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._arch = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getFan() {
            RoundedPolygon roundedPolygon = MaterialShapes._fan;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = fan$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._fan = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getArrow() {
            RoundedPolygon roundedPolygon = MaterialShapes._arrow;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = arrow$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._arrow = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSemiCircle() {
            RoundedPolygon roundedPolygon = MaterialShapes._semiCircle;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = semiCircle$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._semiCircle = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getOval() {
            RoundedPolygon roundedPolygon = MaterialShapes._oval;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = oval$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._oval = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPill() {
            RoundedPolygon roundedPolygon = MaterialShapes._pill;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = pill$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._pill = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getTriangle() {
            RoundedPolygon roundedPolygon = MaterialShapes._triangle;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = triangle$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._triangle = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getDiamond() {
            RoundedPolygon roundedPolygon = MaterialShapes._diamond;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = diamond$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._diamond = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getClamShell() {
            RoundedPolygon roundedPolygon = MaterialShapes._clamShell;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = clamShell$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._clamShell = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPentagon() {
            RoundedPolygon roundedPolygon = MaterialShapes._pentagon;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = pentagon$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._pentagon = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getGem() {
            RoundedPolygon roundedPolygon = MaterialShapes._gem;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = gem$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._gem = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSunny() {
            RoundedPolygon roundedPolygon = MaterialShapes._sunny;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = sunny$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._sunny = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getVerySunny() {
            RoundedPolygon roundedPolygon = MaterialShapes._verySunny;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = verySunny$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._verySunny = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getCookie4Sided() {
            RoundedPolygon roundedPolygon = MaterialShapes._cookie4Sided;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = cookie4$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._cookie4Sided = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getCookie6Sided() {
            RoundedPolygon roundedPolygon = MaterialShapes._cookie6Sided;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = cookie6$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._cookie6Sided = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getCookie7Sided() {
            RoundedPolygon roundedPolygon = MaterialShapes._cookie7Sided;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = cookie7$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._cookie7Sided = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getCookie9Sided() {
            RoundedPolygon roundedPolygon = MaterialShapes._cookie9Sided;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = cookie9$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._cookie9Sided = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getCookie12Sided() {
            RoundedPolygon roundedPolygon = MaterialShapes._cookie12Sided;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = cookie12$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._cookie12Sided = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getGhostish() {
            RoundedPolygon roundedPolygon = MaterialShapes._ghostish;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = ghostish$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._ghostish = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getClover4Leaf() {
            RoundedPolygon roundedPolygon = MaterialShapes._clover4Leaf;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = clover4$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._clover4Leaf = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getClover8Leaf() {
            RoundedPolygon roundedPolygon = MaterialShapes._clover8Leaf;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = clover8$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._clover8Leaf = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getBurst() {
            RoundedPolygon roundedPolygon = MaterialShapes._burst;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = burst$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._burst = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSoftBurst() {
            RoundedPolygon roundedPolygon = MaterialShapes._softBurst;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = softBurst$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._softBurst = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getBoom() {
            RoundedPolygon roundedPolygon = MaterialShapes._boom;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = boom$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._boom = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getSoftBoom() {
            RoundedPolygon roundedPolygon = MaterialShapes._softBoom;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = softBoom$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._softBoom = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getFlower() {
            RoundedPolygon roundedPolygon = MaterialShapes._flower;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = flower$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._flower = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPuffy() {
            RoundedPolygon roundedPolygon = MaterialShapes._puffy;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = puffy$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._puffy = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPuffyDiamond() {
            RoundedPolygon roundedPolygon = MaterialShapes._puffyDiamond;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = puffyDiamond$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._puffyDiamond = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPixelCircle() {
            RoundedPolygon roundedPolygon = MaterialShapes._pixelCircle;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = pixelCircle$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._pixelCircle = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getPixelTriangle() {
            RoundedPolygon roundedPolygon = MaterialShapes._pixelTriangle;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = pixelTriangle$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._pixelTriangle = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getBun() {
            RoundedPolygon roundedPolygon = MaterialShapes._bun;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = bun$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._bun = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public final RoundedPolygon getHeart() {
            RoundedPolygon roundedPolygon = MaterialShapes._heart;
            if (roundedPolygon != null) {
                return roundedPolygon;
            }
            RoundedPolygon roundedPolygonNormalized = heart$material3().normalized();
            Companion companion = MaterialShapes.INSTANCE;
            MaterialShapes._heart = roundedPolygonNormalized;
            return roundedPolygonNormalized;
        }

        public static /* synthetic */ RoundedPolygon circle$material3$default(Companion companion, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 10;
            }
            return companion.circle$material3(i);
        }

        public final RoundedPolygon circle$material3(int numVertices) {
            return androidx.graphics.shapes.ShapesKt.circle$default(RoundedPolygon.INSTANCE, numVertices, 0.0f, 0.0f, 0.0f, 14, null);
        }

        public final RoundedPolygon square$material3() {
            return androidx.graphics.shapes.ShapesKt.rectangle$default(RoundedPolygon.INSTANCE, 1.0f, 1.0f, MaterialShapes.cornerRound30, null, 0.0f, 0.0f, 56, null);
        }

        public final RoundedPolygon slanted$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.926f)) << 32) | (((long) Float.floatToRawIntBits(0.97f)) & 4294967295L)), new CornerRounding(0.189f, 0.811f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-0.021f)) << 32) | (((long) Float.floatToRawIntBits(0.967f)) & 4294967295L)), new CornerRounding(0.187f, 0.057f), defaultConstructorMarker)}), 2, 0L, false, 12, null);
        }

        public final RoundedPolygon arch$material3() {
            return ShapeUtilKt.m4999transformedEL8BTi8(RoundedPolygonKt.RoundedPolygon$default(4, 0.0f, 0.0f, 0.0f, null, CollectionsKt.listOf((Object[]) new CornerRounding[]{MaterialShapes.cornerRound100, MaterialShapes.cornerRound100, MaterialShapes.cornerRound20, MaterialShapes.cornerRound20}), 30, null), MaterialShapes.rotateNeg135);
        }

        public final RoundedPolygon fan$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.004f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L)), new CornerRounding(0.148f, 0.417f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)), new CornerRounding(0.151f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(-0.003f)) & 4294967295L)), new CornerRounding(0.148f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.978f)) << 32) | (((long) Float.floatToRawIntBits(0.02f)) & 4294967295L)), new CornerRounding(0.803f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, false, 12, null);
        }

        public final RoundedPolygon arrow$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.892f)) & 4294967295L)), new CornerRounding(0.313f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-0.216f)) << 32) | (((long) Float.floatToRawIntBits(1.05f)) & 4294967295L)), new CornerRounding(0.207f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.499f)) << 32) | (((long) Float.floatToRawIntBits(-0.16f)) & 4294967295L)), new CornerRounding(0.215f, 1.0f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.225f)) << 32) | (((long) Float.floatToRawIntBits(1.06f)) & 4294967295L)), new CornerRounding(0.211f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, false, 12, null);
        }

        public final RoundedPolygon semiCircle$material3() {
            return androidx.graphics.shapes.ShapesKt.rectangle$default(RoundedPolygon.INSTANCE, 1.6f, 1.0f, null, CollectionsKt.listOf((Object[]) new CornerRounding[]{MaterialShapes.cornerRound20, MaterialShapes.cornerRound20, MaterialShapes.cornerRound100, MaterialShapes.cornerRound100}), 0.0f, 0.0f, 52, null);
        }

        public final RoundedPolygon oval$material3() {
            float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
            Matrix.m7076scaleimpl$default(fArrM7060constructorimpl$default, 1.0f, 0.64f, 0.0f, 4, null);
            return ShapeUtilKt.m4999transformedEL8BTi8(ShapeUtilKt.m4999transformedEL8BTi8(androidx.graphics.shapes.ShapesKt.circle$default(RoundedPolygon.INSTANCE, 0, 0.0f, 0.0f, 0.0f, 15, null), fArrM7060constructorimpl$default), MaterialShapes.rotateNeg45);
        }

        public final RoundedPolygon pill$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.961f)) << 32) | (((long) Float.floatToRawIntBits(0.039f)) & 4294967295L)), new CornerRounding(0.426f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.001f)) << 32) | (((long) Float.floatToRawIntBits(0.428f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(0.609f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker)}), 2, 0L, true, 4, null);
        }

        public final RoundedPolygon triangle$material3() {
            return ShapeUtilKt.m4999transformedEL8BTi8(RoundedPolygonKt.RoundedPolygon$default(3, 0.0f, 0.0f, 0.0f, MaterialShapes.cornerRound20, null, 46, null), MaterialShapes.rotateNeg90);
        }

        public final RoundedPolygon diamond$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(1.096f)) & 4294967295L)), new CornerRounding(0.151f, 0.524f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.04f)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L)), new CornerRounding(0.159f, 0.0f, 2, null), defaultConstructorMarker)}), 2, 0L, false, 12, null);
        }

        public final RoundedPolygon clamShell$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.171f)) << 32) | (((long) Float.floatToRawIntBits(0.841f)) & 4294967295L)), new CornerRounding(0.159f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-0.02f)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L)), new CornerRounding(0.14f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.17f)) << 32) | (((long) Float.floatToRawIntBits(0.159f)) & 4294967295L)), new CornerRounding(0.159f, 0.0f, 2, null), defaultConstructorMarker)}), 2, 0L, false, 12, null);
        }

        public final RoundedPolygon pentagon$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(-0.009f)) & 4294967295L)), new CornerRounding(0.172f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.03f)) << 32) | (((long) Float.floatToRawIntBits(0.365f)) & 4294967295L)), new CornerRounding(0.164f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.828f)) << 32) | (((long) Float.floatToRawIntBits(0.97f)) & 4294967295L)), new CornerRounding(0.169f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, true, 4, null);
        }

        public final RoundedPolygon gem$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.499f)) << 32) | (((long) Float.floatToRawIntBits(1.023f)) & 4294967295L)), new CornerRounding(0.241f, 0.778f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-0.005f)) << 32) | (((long) Float.floatToRawIntBits(0.792f)) & 4294967295L)), new CornerRounding(0.208f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.073f)) << 32) | (((long) Float.floatToRawIntBits(0.258f)) & 4294967295L)), new CornerRounding(0.228f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.433f)) << 32) | (((long) Float.floatToRawIntBits(-0.0f)) & 4294967295L)), new CornerRounding(0.491f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, true, 4, null);
        }

        public final RoundedPolygon sunny$material3() {
            return androidx.graphics.shapes.ShapesKt.star$default(RoundedPolygon.INSTANCE, 8, 0.0f, 0.8f, MaterialShapes.cornerRound15, null, null, 0.0f, 0.0f, 242, null);
        }

        public final RoundedPolygon verySunny$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(1.08f)) & 4294967295L)), new CornerRounding(0.085f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.358f)) << 32) | (((long) Float.floatToRawIntBits(0.843f)) & 4294967295L)), new CornerRounding(0.085f, 0.0f, 2, null), defaultConstructorMarker)}), 8, 0L, false, 12, null);
        }

        public final RoundedPolygon cookie4$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.237f)) << 32) | (((long) Float.floatToRawIntBits(1.236f)) & 4294967295L)), new CornerRounding(0.258f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.918f)) & 4294967295L)), new CornerRounding(0.233f, 0.0f, 2, null), defaultConstructorMarker)}), 4, 0L, false, 12, null);
        }

        public final RoundedPolygon cookie6$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.723f)) << 32) | (((long) Float.floatToRawIntBits(0.884f)) & 4294967295L)), new CornerRounding(0.394f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(1.099f)) & 4294967295L)), new CornerRounding(0.398f, 0.0f, 2, null), defaultConstructorMarker)}), 6, 0L, false, 12, null);
        }

        public final RoundedPolygon cookie7$material3() {
            return ShapeUtilKt.m4999transformedEL8BTi8(androidx.graphics.shapes.ShapesKt.star$default(RoundedPolygon.INSTANCE, 7, 0.0f, 0.75f, MaterialShapes.cornerRound50, null, null, 0.0f, 0.0f, 242, null), MaterialShapes.rotateNeg90);
        }

        public final RoundedPolygon cookie9$material3() {
            return ShapeUtilKt.m4999transformedEL8BTi8(androidx.graphics.shapes.ShapesKt.star$default(RoundedPolygon.INSTANCE, 9, 0.0f, 0.8f, MaterialShapes.cornerRound50, null, null, 0.0f, 0.0f, 242, null), MaterialShapes.rotateNeg90);
        }

        public final RoundedPolygon cookie12$material3() {
            return ShapeUtilKt.m4999transformedEL8BTi8(androidx.graphics.shapes.ShapesKt.star$default(RoundedPolygon.INSTANCE, 12, 0.0f, 0.8f, MaterialShapes.cornerRound50, null, null, 0.0f, 0.0f, 242, null), MaterialShapes.rotateNeg90);
        }

        public final RoundedPolygon ghostish$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.14f)) & 4294967295L)), new CornerRounding(0.254f, 0.106f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.575f)) << 32) | (((long) Float.floatToRawIntBits(0.906f)) & 4294967295L)), new CornerRounding(0.253f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, true, 4, null);
        }

        public final RoundedPolygon clover4$material3() {
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.074f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.725f)) << 32) | (((long) Float.floatToRawIntBits(-0.099f)) & 4294967295L)), new CornerRounding(0.476f, 0.0f, 2, null), null)}), 4, 0L, true, 4, null);
        }

        public final RoundedPolygon clover8$material3() {
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.036f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.758f)) << 32) | (((long) Float.floatToRawIntBits(-0.101f)) & 4294967295L)), new CornerRounding(0.209f, 0.0f, 2, null), null)}), 8, 0L, false, 12, null);
        }

        public final RoundedPolygon burst$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(-0.006f)) & 4294967295L)), new CornerRounding(0.006f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.592f)) << 32) | (((long) Float.floatToRawIntBits(0.158f)) & 4294967295L)), new CornerRounding(0.006f, 0.0f, 2, null), defaultConstructorMarker)}), 12, 0L, false, 12, null);
        }

        public final RoundedPolygon softBurst$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.193f)) << 32) | (((long) Float.floatToRawIntBits(0.277f)) & 4294967295L)), new CornerRounding(0.053f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.176f)) << 32) | (((long) Float.floatToRawIntBits(0.055f)) & 4294967295L)), new CornerRounding(0.053f, 0.0f, 2, null), defaultConstructorMarker)}), 10, 0L, false, 12, null);
        }

        public final RoundedPolygon boom$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.457f)) << 32) | (((long) Float.floatToRawIntBits(0.296f)) & 4294967295L)), new CornerRounding(0.007f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(-0.051f)) & 4294967295L)), new CornerRounding(0.007f, 0.0f, 2, null), defaultConstructorMarker)}), 15, 0L, false, 12, null);
        }

        public final RoundedPolygon softBoom$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.733f)) << 32) | (((long) Float.floatToRawIntBits(0.454f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.839f)) << 32) | (((long) Float.floatToRawIntBits(0.437f)) & 4294967295L)), new CornerRounding(0.532f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.949f)) << 32) | (((long) Float.floatToRawIntBits(0.449f)) & 4294967295L)), new CornerRounding(0.439f, 1.0f), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.998f)) << 32) | (((long) Float.floatToRawIntBits(0.478f)) & 4294967295L)), new CornerRounding(0.174f, 0.0f, 2, null), defaultConstructorMarker)}), 16, 0L, true, 4, null);
        }

        public final RoundedPolygon flower$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.37f)) << 32) | (((long) Float.floatToRawIntBits(0.187f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.416f)) << 32) | (((long) Float.floatToRawIntBits(0.049f)) & 4294967295L)), new CornerRounding(0.381f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.479f)) << 32) | (((long) Float.floatToRawIntBits(0.001f)) & 4294967295L)), new CornerRounding(0.095f, 0.0f, 2, null), defaultConstructorMarker)}), 8, 0L, true, 4, null);
        }

        public final RoundedPolygon puffy$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
            Matrix.m7076scaleimpl$default(fArrM7060constructorimpl$default, 1.0f, 0.742f, 0.0f, 4, null);
            int i = 2;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            CornerRounding cornerRounding = null;
            return ShapeUtilKt.m4999transformedEL8BTi8(m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.053f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.545f)) << 32) | (((long) Float.floatToRawIntBits(-0.04f)) & 4294967295L)), new CornerRounding(0.405f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.67f)) << 32) | (((long) Float.floatToRawIntBits(-0.035f)) & 4294967295L)), new CornerRounding(0.426f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.717f)) << 32) | (((long) Float.floatToRawIntBits(0.066f)) & 4294967295L)), new CornerRounding(0.574f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.722f)) << 32) | (((long) Float.floatToRawIntBits(0.128f)) & 4294967295L)), cornerRounding, i, defaultConstructorMarker2), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.777f)) << 32) | (((long) Float.floatToRawIntBits(0.002f)) & 4294967295L)), new CornerRounding(0.36f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.914f)) << 32) | (((long) Float.floatToRawIntBits(0.149f)) & 4294967295L)), new CornerRounding(0.66f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.926f)) << 32) | (((long) Float.floatToRawIntBits(0.289f)) & 4294967295L)), new CornerRounding(0.66f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.881f)) << 32) | (((long) Float.floatToRawIntBits(0.346f)) & 4294967295L)), cornerRounding, i, defaultConstructorMarker2), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.94f)) << 32) | (((long) Float.floatToRawIntBits(0.344f)) & 4294967295L)), new CornerRounding(0.126f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.003f)) << 32) | (((long) Float.floatToRawIntBits(0.437f)) & 4294967295L)), new CornerRounding(0.255f, 0.0f, 2, null), defaultConstructorMarker)}), 2, 0L, true, 4, null), fArrM7060constructorimpl$default);
        }

        public final RoundedPolygon puffyDiamond$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.87f)) << 32) | (((long) Float.floatToRawIntBits(0.13f)) & 4294967295L)), new CornerRounding(0.146f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.818f)) << 32) | (((long) Float.floatToRawIntBits(0.357f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(0.332f)) & 4294967295L)), new CornerRounding(0.853f, 0.0f, 2, null), defaultConstructorMarker)}), 4, 0L, true, 4, null);
        }

        public final RoundedPolygon pixelCircle$material3() {
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((Float.floatToRawIntBits(0.5f) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((Float.floatToRawIntBits(0.704f) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((Float.floatToRawIntBits(0.704f) << 32) | (((long) Float.floatToRawIntBits(0.065f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.065f)) & 4294967295L) | (Float.floatToRawIntBits(0.843f) << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.843f)) << 32) | (((long) Float.floatToRawIntBits(0.148f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.148f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.926f)) << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.926f)) << 32) | (((long) Float.floatToRawIntBits(0.296f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(0.296f)) & 4294967295L)), null, 2, null)}), 2, 0L, true, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RoundedPolygon pixelTriangle$material3() {
            long jFloatToRawIntBits = Float.floatToRawIntBits(0.11f);
            long jFloatToRawIntBits2 = Float.floatToRawIntBits(0.113f);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(0.287f);
            long jFloatToRawIntBits4 = ((long) Float.floatToRawIntBits(0.0f)) & 4294967295L;
            long jFloatToRawIntBits5 = Float.floatToRawIntBits(0.287f);
            long jFloatToRawIntBits6 = Float.floatToRawIntBits(0.421f);
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((jFloatToRawIntBits << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((jFloatToRawIntBits2 << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl(jFloatToRawIntBits4 | (jFloatToRawIntBits3 << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((jFloatToRawIntBits5 << 32) | (((long) Float.floatToRawIntBits(0.087f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.087f)) & 4294967295L) | (jFloatToRawIntBits6 << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((Float.floatToRawIntBits(0.421f) << 32) | (((long) Float.floatToRawIntBits(0.17f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.17f)) & 4294967295L) | (Float.floatToRawIntBits(0.56f) << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.56f)) << 32) | (((long) Float.floatToRawIntBits(0.265f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.674f)) << 32) | (((long) Float.floatToRawIntBits(0.265f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.675f)) << 32) | (((long) Float.floatToRawIntBits(0.344f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.344f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.789f)) << 32)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.789f)) << 32) | (((long) Float.floatToRawIntBits(0.439f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.888f)) << 32) | (((long) Float.floatToRawIntBits(0.439f)) & 4294967295L)), null, 2, 0 == true ? 1 : 0)}), 1, 0L, true, 4, null);
        }

        public final RoundedPolygon bun$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.796f)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L)), null, 2, null), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.853f)) << 32) | (((long) Float.floatToRawIntBits(0.518f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.992f)) << 32) | (((long) Float.floatToRawIntBits(0.631f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.968f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker)}), 2, 0L, true, 4, null);
        }

        public final RoundedPolygon heart$material3() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return m3738customPolygonRg1IO4c$default(this, CollectionsKt.listOf((Object[]) new PointNRound[]{new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.268f)) & 4294967295L)), new CornerRounding(0.016f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.792f)) << 32) | (((long) Float.floatToRawIntBits(-0.066f)) & 4294967295L)), new CornerRounding(0.958f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(1.064f)) << 32) | (((long) Float.floatToRawIntBits(0.276f)) & 4294967295L)), new CornerRounding(1.0f, 0.0f, 2, null), defaultConstructorMarker), new PointNRound(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.501f)) << 32) | (((long) Float.floatToRawIntBits(0.946f)) & 4294967295L)), new CornerRounding(0.129f, 0.0f, 2, null), defaultConstructorMarker)}), 1, 0L, true, 4, null);
        }

        /* JADX INFO: compiled from: MaterialShapes.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/MaterialShapes$Companion$PointNRound;", "", "o", "Landroidx/compose/ui/geometry/Offset;", "r", "Landroidx/graphics/shapes/CornerRounding;", "<init>", "(JLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getO-F1C5BW0", "()J", "J", "getR", "()Landroidx/graphics/shapes/CornerRounding;", "component1", "component1-F1C5BW0", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-3MmeM6k", "(JLandroidx/graphics/shapes/CornerRounding;)Landroidx/compose/material3/MaterialShapes$Companion$PointNRound;", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final /* data */ class PointNRound {
            private final long o;
            private final CornerRounding r;

            public /* synthetic */ PointNRound(long j, CornerRounding cornerRounding, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, cornerRounding);
            }

            /* JADX INFO: renamed from: copy-3MmeM6k$default, reason: not valid java name */
            public static /* synthetic */ PointNRound m3742copy3MmeM6k$default(PointNRound pointNRound, long j, CornerRounding cornerRounding, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = pointNRound.o;
                }
                if ((i & 2) != 0) {
                    cornerRounding = pointNRound.r;
                }
                return pointNRound.m3744copy3MmeM6k(j, cornerRounding);
            }

            /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name and from getter */
            public final long getO() {
                return this.o;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final CornerRounding getR() {
                return this.r;
            }

            /* JADX INFO: renamed from: copy-3MmeM6k, reason: not valid java name */
            public final PointNRound m3744copy3MmeM6k(long o, CornerRounding r) {
                return new PointNRound(o, r, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PointNRound)) {
                    return false;
                }
                PointNRound pointNRound = (PointNRound) other;
                return Offset.m6566equalsimpl0(this.o, pointNRound.o) && Intrinsics.areEqual(this.r, pointNRound.r);
            }

            public int hashCode() {
                return (Offset.m6571hashCodeimpl(this.o) * 31) + this.r.hashCode();
            }

            public String toString() {
                return "PointNRound(o=" + ((Object) Offset.m6577toStringimpl(this.o)) + ", r=" + this.r + ')';
            }

            private PointNRound(long j, CornerRounding cornerRounding) {
                this.o = j;
                this.r = cornerRounding;
            }

            /* JADX INFO: renamed from: getO-F1C5BW0, reason: not valid java name */
            public final long m3745getOF1C5BW0() {
                return this.o;
            }

            public /* synthetic */ PointNRound(long j, CornerRounding cornerRounding, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? CornerRounding.Unrounded : cornerRounding, null);
            }

            public final CornerRounding getR() {
                return this.r;
            }
        }

        /* JADX INFO: renamed from: doRepeat-Rg1IO4c, reason: not valid java name */
        private final List<PointNRound> m3739doRepeatRg1IO4c(List<PointNRound> points, int reps, long center, boolean mirroring) {
            float fFloatValue;
            long j = center;
            if (mirroring) {
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                ArrayList arrayList = new ArrayList(points.size());
                List<PointNRound> list = points;
                int i = 0;
                for (int size = list.size(); i < size; size = size) {
                    arrayList.add(Float.valueOf(MaterialShapes.INSTANCE.m3736angleDegreesk4lQ0M(Offset.m6573minusMKHz9U(points.get(i).m3745getOF1C5BW0(), j))));
                    i++;
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(points.size());
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList3.add(Float.valueOf(Offset.m6567getDistanceimpl(Offset.m6573minusMKHz9U(points.get(i2).m3745getOF1C5BW0(), j))));
                }
                ArrayList arrayList4 = arrayList3;
                int i3 = 2;
                int i4 = reps * 2;
                float f = 360.0f / i4;
                int i5 = 0;
                while (i5 < i4) {
                    Iterator<Integer> it = CollectionsKt.getIndices(list).iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((IntIterator) it).nextInt();
                        int i6 = i5 % 2;
                        if (i6 != 0) {
                            iNextInt = CollectionsKt.getLastIndex(points) - iNextInt;
                        }
                        if (iNextInt > 0 || i6 == 0) {
                            Companion companion = MaterialShapes.INSTANCE;
                            float f2 = i5 * f;
                            if (i6 == 0) {
                                fFloatValue = ((Number) arrayList2.get(iNextInt)).floatValue();
                            } else {
                                fFloatValue = (f - ((Number) arrayList2.get(iNextInt)).floatValue()) + (i3 * ((Number) arrayList2.get(0)).floatValue());
                            }
                            double radians = companion.toRadians(f2 + fFloatValue);
                            listCreateListBuilder.add(new PointNRound(Offset.m6574plusMKHz9U(Offset.m6576timestuRUvjQ(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((float) Math.cos(radians))) << 32) | (((long) Float.floatToRawIntBits((float) Math.sin(radians))) & 4294967295L)), ((Number) arrayList4.get(iNextInt)).floatValue()), j), points.get(iNextInt).getR(), null));
                        } else {
                            i4 = i4;
                        }
                        i4 = i4;
                        i3 = 2;
                    }
                    i5++;
                    i3 = 2;
                }
                return CollectionsKt.build(listCreateListBuilder);
            }
            int size3 = points.size();
            IntRange intRangeUntil = RangesKt.until(0, size3 * reps);
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                int iNextInt2 = ((IntIterator) it2).nextInt();
                int i7 = iNextInt2 % size3;
                arrayList5.add(new PointNRound(MaterialShapes.INSTANCE.m3740rotateDegreesHo4pAXE(points.get(i7).m3745getOF1C5BW0(), ((iNextInt2 / size3) * 360.0f) / reps, j), points.get(i7).getR(), null));
                j = center;
            }
            return arrayList5;
        }

        /* JADX INFO: renamed from: rotateDegrees-Ho4pAXE$default, reason: not valid java name */
        static /* synthetic */ long m3741rotateDegreesHo4pAXE$default(Companion companion, long j, float f, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = Offset.INSTANCE.m6585getZeroF1C5BW0();
            }
            return companion.m3740rotateDegreesHo4pAXE(j, f, j2);
        }

        /* JADX INFO: renamed from: rotateDegrees-Ho4pAXE, reason: not valid java name */
        private final long m3740rotateDegreesHo4pAXE(long j, float f, long j2) {
            float radians = toRadians(f);
            long jM6573minusMKHz9U = Offset.m6573minusMKHz9U(j, j2);
            int i = (int) (jM6573minusMKHz9U >> 32);
            double d = radians;
            int i2 = (int) (jM6573minusMKHz9U & 4294967295L);
            float fIntBitsToFloat = (Float.intBitsToFloat(i) * ((float) Math.cos(d))) - (Float.intBitsToFloat(i2) * ((float) Math.sin(d)));
            return Offset.m6574plusMKHz9U(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((Float.intBitsToFloat(i) * ((float) Math.sin(d))) + (Float.intBitsToFloat(i2) * ((float) Math.cos(d))))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), j2);
        }

        /* JADX INFO: renamed from: customPolygon-Rg1IO4c, reason: not valid java name */
        private final RoundedPolygon m3737customPolygonRg1IO4c(List<PointNRound> pnr, int reps, long center, boolean mirroring) {
            List<PointNRound> listM3739doRepeatRg1IO4c = m3739doRepeatRg1IO4c(pnr, reps, center, mirroring);
            int size = listM3739doRepeatRg1IO4c.size() * 2;
            float[] fArr = new float[size];
            for (int i = 0; i < size; i++) {
                long jM3745getOF1C5BW0 = listM3739doRepeatRg1IO4c.get(i / 2).m3745getOF1C5BW0();
                fArr[i] = Float.intBitsToFloat((int) (i % 2 == 0 ? jM3745getOF1C5BW0 >> 32 : 4294967295L & jM3745getOF1C5BW0));
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator<PointNRound> it = listM3739doRepeatRg1IO4c.iterator();
            while (it.hasNext()) {
                listCreateListBuilder.add(it.next().getR());
            }
            Unit unit = Unit.INSTANCE;
            return RoundedPolygonKt.RoundedPolygon$default(fArr, null, CollectionsKt.build(listCreateListBuilder), Float.intBitsToFloat((int) (center >> 32)), Float.intBitsToFloat((int) (center & 4294967295L)), 2, null);
        }

        /* JADX INFO: renamed from: angleDegrees-k-4lQ0M, reason: not valid java name */
        private final float m3736angleDegreesk4lQ0M(long j) {
            return (((float) Math.atan2(Float.intBitsToFloat((int) (4294967295L & j)), Float.intBitsToFloat((int) (j >> 32)))) * 180.0f) / 3.1415927f;
        }

        /* JADX INFO: renamed from: customPolygon-Rg1IO4c$default, reason: not valid java name */
        static /* synthetic */ RoundedPolygon m3738customPolygonRg1IO4c$default(Companion companion, List list, int i, long j, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                j = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.5f)) & 4294967295L) | (Float.floatToRawIntBits(0.5f) << 32));
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                z = false;
            }
            return companion.m3737customPolygonRg1IO4c(list, i, j2, z);
        }
    }

    static {
        float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
        Matrix.m7074rotateZimpl(fArrM7060constructorimpl$default, -45.0f);
        rotateNeg45 = fArrM7060constructorimpl$default;
        float[] fArrM7060constructorimpl$default2 = Matrix.m7060constructorimpl$default(null, 1, null);
        Matrix.m7074rotateZimpl(fArrM7060constructorimpl$default2, -90.0f);
        rotateNeg90 = fArrM7060constructorimpl$default2;
        float[] fArrM7060constructorimpl$default3 = Matrix.m7060constructorimpl$default(null, 1, null);
        Matrix.m7074rotateZimpl(fArrM7060constructorimpl$default3, -135.0f);
        rotateNeg135 = fArrM7060constructorimpl$default3;
    }
}
