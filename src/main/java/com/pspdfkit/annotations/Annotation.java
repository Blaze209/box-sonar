package com.pspdfkit.annotations;

import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import androidx.media3.common.MimeTypes;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.measurements.MeasurementInfo;
import com.pspdfkit.configuration.rendering.AnnotationRenderConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.bm;
import com.pspdfkit.internal.c1;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.h4;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeAttachmentResult;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.jr;
import com.pspdfkit.internal.k3;
import com.pspdfkit.internal.k4;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.pt;
import com.pspdfkit.internal.rp;
import com.pspdfkit.internal.xp;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000³\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001}\b'\u0018\u0000 \u0094\u00022\u00020\u0001:\u0002\u0094\u0002B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0004¢\u0006\u0004\b!\u0010\u0010J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001d\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b$\u0010(J\u001b\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0)2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b*\u0010+J#\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0)2\u0006\u0010#\u001a\u00020\"2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b*\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0000¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020-H\u0016¢\u0006\u0004\b7\u0010/J\u001f\u0010:\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0019H&¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0007¢\u0006\u0004\b<\u0010\rJ\r\u0010>\u001a\u00020=¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b@\u0010\u0017J\u0017\u0010B\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\bB\u0010CJ\u0013\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00000D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\b¢\u0006\u0004\bG\u0010\u0010J\u0017\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u001f\u0010O\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010-¢\u0006\u0004\bO\u0010PJ\u0019\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010R\u001a\u00020QH\u0014¢\u0006\u0004\bT\u0010UJ!\u0010X\u001a\u00020\u000b2\b\u0010V\u001a\u0004\u0018\u00010\u00192\u0006\u0010W\u001a\u00020\bH\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020ZH\u0014¢\u0006\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00068\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR(\u0010e\u001a\u0004\u0018\u00010\u00122\b\u0010d\u001a\u0004\u0018\u00010\u00128\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR$\u0010p\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bp\u0010q\u0012\u0004\br\u0010\rR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010{R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u008b\u0001\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u001b\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R7\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u001d0\u008c\u00012\r\u0010d\u001a\t\u0012\u0004\u0012\u00020\u001d0\u008c\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0095\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0092\u0001\u0010/\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u0098\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u0096\u0001\u0010/\"\u0006\b\u0097\u0001\u0010\u0094\u0001R,\u0010\u009b\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0099\u0001\u0010/\"\u0006\b\u009a\u0001\u0010\u0094\u0001R,\u0010\u009e\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u009c\u0001\u0010/\"\u0006\b\u009d\u0001\u0010\u0094\u0001R/\u0010¤\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010d\u001a\u0005\u0018\u00010\u009f\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R/\u0010§\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010d\u001a\u0005\u0018\u00010\u009f\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¥\u0001\u0010¡\u0001\"\u0006\b¦\u0001\u0010£\u0001R,\u0010ª\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b¨\u0001\u0010/\"\u0006\b©\u0001\u0010\u0094\u0001R)\u0010\u00ad\u0001\u001a\u00020\u00022\b\b\u0001\u0010d\u001a\u00020\u00028G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b«\u0001\u00101\"\u0005\b¬\u0001\u0010\u0005R)\u0010°\u0001\u001a\u00020\u00022\b\b\u0001\u0010d\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b®\u0001\u00101\"\u0005\b¯\u0001\u0010\u0005R-\u0010¶\u0001\u001a\u00030±\u00012\t\b\u0001\u0010d\u001a\u00030±\u00018G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R-\u0010¹\u0001\u001a\u00030±\u00012\t\b\u0001\u0010d\u001a\u00030±\u00018G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b·\u0001\u0010³\u0001\"\u0006\b¸\u0001\u0010µ\u0001R)\u0010¼\u0001\u001a\u00020\u00022\b\b\u0001\u0010d\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bº\u0001\u00101\"\u0005\b»\u0001\u0010\u0005R+\u0010Â\u0001\u001a\u00030½\u00012\u0007\u0010d\u001a\u00030½\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R+\u0010È\u0001\u001a\u00030Ã\u00012\u0007\u0010d\u001a\u00030Ã\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R-\u0010Ë\u0001\u001a\u00030±\u00012\t\b\u0001\u0010d\u001a\u00030±\u00018G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÉ\u0001\u0010³\u0001\"\u0006\bÊ\u0001\u0010µ\u0001R-\u0010Î\u0001\u001a\u00030±\u00012\t\b\u0001\u0010d\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÌ\u0001\u0010³\u0001\"\u0006\bÍ\u0001\u0010µ\u0001R;\u0010Ô\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010Ï\u00012\u000f\u0010d\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010Ï\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R+\u0010Ú\u0001\u001a\u00030Õ\u00012\u0007\u0010d\u001a\u00030Õ\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R\u0012\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\bÛ\u0001\u00101R\u0013\u0010Ý\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\bÜ\u0001\u00101R,\u0010à\u0001\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bÞ\u0001\u0010/\"\u0006\bß\u0001\u0010\u0094\u0001R\u0016\u0010á\u0001\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bá\u0001\u0010\u0010R\u0016\u0010â\u0001\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010\u0010R\u0013\u0010ä\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bã\u0001\u0010\u0010R\u0013\u0010å\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bå\u0001\u0010\u0010R\u0018\u0010é\u0001\u001a\u00030æ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bç\u0001\u0010è\u0001R\u0013\u0010ê\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bê\u0001\u0010\u0010R\u0013\u0010ë\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bë\u0001\u0010\u0010R-\u0010ð\u0001\u001a\u0004\u0018\u00010s2\b\u0010d\u001a\u0004\u0018\u00010s8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R\u0013\u0010ñ\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\bñ\u0001\u0010\u0010R/\u0010÷\u0001\u001a\u0005\u0018\u00010ò\u00012\t\u0010d\u001a\u0005\u0018\u00010ò\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R\u0013\u0010ù\u0001\u001a\u00020-8F¢\u0006\u0007\u001a\u0005\bø\u0001\u0010/R\u0015\u0010û\u0001\u001a\u0004\u0018\u00010-8F¢\u0006\u0007\u001a\u0005\bú\u0001\u0010/R\u0016\u0010ü\u0001\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bü\u0001\u0010\u0010R\u0017\u0010\u0080\u0002\u001a\u0005\u0018\u00010ý\u00018F¢\u0006\b\u001a\u0006\bþ\u0001\u0010ÿ\u0001R\u0016\u0010\u0081\u0002\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0002\u0010\u0010R,\u0010\u0084\u0002\u001a\u0004\u0018\u00010-2\b\u0010d\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0082\u0002\u0010/\"\u0006\b\u0083\u0002\u0010\u0094\u0001R+\u0010\u0087\u0002\u001a\u00030±\u00012\u0007\u0010d\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0002\u0010³\u0001\"\u0006\b\u0086\u0002\u0010µ\u0001R+\u0010\u008d\u0002\u001a\u00030\u0088\u00022\u0007\u0010d\u001a\u00030\u0088\u00028F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R+\u0010\u0093\u0002\u001a\u00030\u008e\u00022\u0007\u0010d\u001a\u00030\u008e\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002¨\u0006\u0095\u0002"}, d2 = {"Lcom/pspdfkit/annotations/Annotation;", "", "", "pageIndex", "<init>", "(I)V", "Lcom/pspdfkit/internal/j3;", "copyFrom", "", "markDirty", "(Lcom/pspdfkit/internal/j3;Z)V", "", "setUpDefaultProperties", "()V", "markPreferredForPlatformRendering", "updateMeasurementContentsString", "()Z", "refreshBorderEffectEdgeInsets", "Lcom/pspdfkit/internal/lm;", "document", "checkIfInReplyToAnnotationIsAttachedToDocument", "(Lcom/pspdfkit/internal/lm;)V", "getCopy", "()Lcom/pspdfkit/annotations/Annotation;", "(I)Lcom/pspdfkit/annotations/Annotation;", "Landroid/graphics/RectF;", "rect", "getBoundingBox", "(Landroid/graphics/RectF;)Landroid/graphics/RectF;", "Lcom/pspdfkit/annotations/AnnotationFlags;", "flag", "hasFlag", "(Lcom/pspdfkit/annotations/AnnotationFlags;)Z", "hasCustomMinimumSize", "Landroid/graphics/Bitmap;", "bitmap", "renderToBitmap", "(Landroid/graphics/Bitmap;)V", "Lcom/pspdfkit/configuration/rendering/AnnotationRenderConfiguration;", "configuration", "(Landroid/graphics/Bitmap;Lcom/pspdfkit/configuration/rendering/AnnotationRenderConfiguration;)V", "Lio/reactivex/rxjava3/core/Single;", "renderToBitmapAsync", "(Landroid/graphics/Bitmap;)Lio/reactivex/rxjava3/core/Single;", "(Landroid/graphics/Bitmap;Lcom/pspdfkit/configuration/rendering/AnnotationRenderConfiguration;)Lio/reactivex/rxjava3/core/Single;", "", "toInstantJson", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "hasSamePropertiesAs", "(Lcom/pspdfkit/annotations/Annotation;)Z", "toString", "newBoundingBox", "oldBoundingBox", "updateTransformationProperties", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "generateAppearanceStream", "Lio/reactivex/rxjava3/core/Completable;", "generateAppearanceStreamAsync", "()Lio/reactivex/rxjava3/core/Completable;", "getInReplyTo", "parentAnnotation", "setInReplyTo", "(Lcom/pspdfkit/annotations/Annotation;)V", "Lio/reactivex/rxjava3/core/Maybe;", "getInReplyToAsync", "()Lio/reactivex/rxjava3/core/Maybe;", "hasBinaryInstantJsonAttachment", "Ljava/io/OutputStream;", "outputStream", "fetchBinaryInstantJsonAttachment", "(Ljava/io/OutputStream;)Ljava/lang/String;", "Lcom/pspdfkit/document/providers/DataProvider;", "dataProvider", "mimeType", "attachBinaryInstantJsonAttachment", "(Lcom/pspdfkit/document/providers/DataProvider;Ljava/lang/String;)V", "Lcom/pspdfkit/internal/xp;", "measurementProperties", "Lcom/pspdfkit/internal/rp;", "getMeasurementLabelValue", "(Lcom/pspdfkit/internal/xp;)Lcom/pspdfkit/internal/rp;", "contentSize", "adjustedForPageRotation", "setContentSize", "(Landroid/graphics/RectF;Z)V", "Lcom/pspdfkit/internal/jni/NativeAnnotation;", "nativeAnnotation", "onBeforeAttachToDocument", "(Lcom/pspdfkit/internal/jni/NativeAnnotation;)V", "propertyManager", "Lcom/pspdfkit/internal/j3;", "Lcom/pspdfkit/internal/go;", "Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "onAnnotationUpdatedListeners", "Lcom/pspdfkit/internal/go;", "value", "internalDocument", "Lcom/pspdfkit/internal/lm;", "getInternalDocument", "()Lcom/pspdfkit/internal/lm;", "Lcom/pspdfkit/internal/jr;", "nativeAnnotationHolder", "Lcom/pspdfkit/internal/jr;", "detachedAnnotationLookupKey", "Ljava/lang/Integer;", "Ljava/lang/ref/WeakReference;", "Lcom/pspdfkit/internal/jni/NativeAnnotationManager;", "detachedAnnotationManager", "Ljava/lang/ref/WeakReference;", "getDetachedAnnotationManager$annotations", "Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "_appearanceStreamGenerator", "Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "_inReplyTo", "Lcom/pspdfkit/annotations/Annotation;", "inReplyToAnnotationUpdatedListener", "Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "adjustContentSizeOnAttachToDocument", "Z", "prefersPlatformRendering", "com/pspdfkit/annotations/Annotation$internalAPI$1", "internalAPI", "Lcom/pspdfkit/annotations/Annotation$internalAPI$1;", "Lcom/pspdfkit/internal/bm;", "getInternal", "()Lcom/pspdfkit/internal/bm;", "internal", "Lcom/pspdfkit/annotations/AnnotationType;", "getType", "()Lcom/pspdfkit/annotations/AnnotationType;", "type", "()Landroid/graphics/RectF;", "setBoundingBox", "(Landroid/graphics/RectF;)V", "boundingBox", "Ljava/util/EnumSet;", "getFlags", "()Ljava/util/EnumSet;", "setFlags", "(Ljava/util/EnumSet;)V", "flags", "getName", "setName", "(Ljava/lang/String;)V", "name", "getContents", "setContents", "contents", "getRichText", "setRichText", "richText", "getSubject", "setSubject", "subject", "Ljava/util/Date;", "getCreatedDate", "()Ljava/util/Date;", "setCreatedDate", "(Ljava/util/Date;)V", "createdDate", "getModifiedDate", "setModifiedDate", "modifiedDate", "getCreator", "setCreator", "creator", "getColor", "setColor", "color", "getFillColor", "setFillColor", "fillColor", "", "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "getFillAlpha", "setFillAlpha", "fillAlpha", "getBorderColor", "setBorderColor", ViewProps.BORDER_COLOR, "Lcom/pspdfkit/annotations/BorderStyle;", "getBorderStyle", "()Lcom/pspdfkit/annotations/BorderStyle;", "setBorderStyle", "(Lcom/pspdfkit/annotations/BorderStyle;)V", "borderStyle", "Lcom/pspdfkit/annotations/BorderEffect;", "getBorderEffect", "()Lcom/pspdfkit/annotations/BorderEffect;", "setBorderEffect", "(Lcom/pspdfkit/annotations/BorderEffect;)V", "borderEffect", "getBorderEffectIntensity", "setBorderEffectIntensity", "borderEffectIntensity", "getBorderWidth", "setBorderWidth", ViewProps.BORDER_WIDTH, "", "getBorderDashArray", "()Ljava/util/List;", "setBorderDashArray", "(Ljava/util/List;)V", "borderDashArray", "Lcom/pspdfkit/annotations/BlendMode;", "getBlendMode", "()Lcom/pspdfkit/annotations/BlendMode;", "setBlendMode", "(Lcom/pspdfkit/annotations/BlendMode;)V", "blendMode", "getPageIndex", "getObjectNumber", "objectNumber", "getGroup", "setGroup", "group", "isResizable", "isLocked", "getHasLockedContents", "hasLockedContents", "isSignature", "Lcom/pspdfkit/utils/Size;", "getMinimumSize", "()Lcom/pspdfkit/utils/Size;", "minimumSize", "isModified", "isAttached", "getAppearanceStreamGenerator", "()Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "setAppearanceStreamGenerator", "(Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;)V", "appearanceStreamGenerator", "isReply", "Lorg/json/JSONObject;", "getCustomData", "()Lorg/json/JSONObject;", "setCustomData", "(Lorg/json/JSONObject;)V", "customData", "getUuid", "uuid", "getInstantRecordGroup", "instantRecordGroup", "isMeasurement", "Lcom/pspdfkit/annotations/measurements/MeasurementInfo;", "getMeasurementInfo", "()Lcom/pspdfkit/annotations/measurements/MeasurementInfo;", "measurementInfo", "isUiRotationSupported", "getFontName", "setFontName", "fontName", "getTextSize", "setTextSize", "textSize", "Lcom/pspdfkit/annotations/FreeTextAnnotation$FreeTextTextJustification;", "getTextJustification", "()Lcom/pspdfkit/annotations/FreeTextAnnotation$FreeTextTextJustification;", "setTextJustification", "(Lcom/pspdfkit/annotations/FreeTextAnnotation$FreeTextTextJustification;)V", "textJustification", "Lcom/pspdfkit/annotations/VerticalTextAlignment;", "getVerticalTextAlignment", "()Lcom/pspdfkit/annotations/VerticalTextAlignment;", "setVerticalTextAlignment", "(Lcom/pspdfkit/annotations/VerticalTextAlignment;)V", "verticalTextAlignment", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Annotation {
    public static final float DEFAULT_BORDER_WIDTH = 1.0f;
    public static final float DEFAULT_CLOUDY_BORDER_EFFECT_INTENSITY = 2.0f;
    public static final int OBJECT_NUMBER_NOT_SET = Integer.MIN_VALUE;
    public static final int PAGE_NUMBER_NOT_SET = Integer.MIN_VALUE;
    private AppearanceStreamGenerator _appearanceStreamGenerator;
    private Annotation _inReplyTo;
    private boolean adjustContentSizeOnAttachToDocument;
    private Integer detachedAnnotationLookupKey;
    private WeakReference<NativeAnnotationManager> detachedAnnotationManager;
    private AnnotationProvider.OnAnnotationUpdatedListener inReplyToAnnotationUpdatedListener;
    private final Annotation$internalAPI$1 internalAPI;
    private lm internalDocument;
    private jr nativeAnnotationHolder;
    private final go<AnnotationProvider.OnAnnotationUpdatedListener> onAnnotationUpdatedListeners;
    private volatile boolean prefersPlatformRendering;
    protected final j3 propertyManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    protected static final Size DEFAULT_MINIMUM_SIZE = new Size(16.0f, 16.0f);
    private static final HashMap<AnnotationType, Size> minimumAnnotationSizeForType = new HashMap<>();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/annotations/Annotation$Companion;", "", "<init>", "()V", "OBJECT_NUMBER_NOT_SET", "", "PAGE_NUMBER_NOT_SET", "DEFAULT_MINIMUM_SIZE", "Lcom/pspdfkit/utils/Size;", "DEFAULT_BORDER_WIDTH", "", "DEFAULT_CLOUDY_BORDER_EFFECT_INTENSITY", "minimumAnnotationSizeForType", "Ljava/util/HashMap;", "Lcom/pspdfkit/annotations/AnnotationType;", "Lkotlin/collections/HashMap;", "setMinimumAnnotationSizeForType", "", "type", "size", "makeNewGroupId", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String makeNewGroupId() {
            String string = UUID.randomUUID().toString();
            string.getClass();
            return string;
        }

        @JvmStatic
        public final void setMinimumAnnotationSizeForType(AnnotationType type, Size size) {
            type.getClass();
            if (size != null) {
                Annotation.minimumAnnotationSizeForType.put(type, size);
            } else {
                Annotation.minimumAnnotationSizeForType.remove(type);
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<FreeTextAnnotation.FreeTextTextJustification> entries$0 = EnumEntriesKt.enumEntries(FreeTextAnnotation.FreeTextTextJustification.values());
        public static final /* synthetic */ EnumEntries<VerticalTextAlignment> entries$1 = EnumEntriesKt.enumEntries(VerticalTextAlignment.values());
    }

    public Annotation(int i) {
        j3 j3Var = new j3();
        this.propertyManager = j3Var;
        this.onAnnotationUpdatedListeners = new go<>();
        this.internalAPI = new Annotation$internalAPI$1(this);
        setUpDefaultProperties();
        j3Var.f.a(1, Integer.valueOf(i), true);
        j3Var.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfInReplyToAnnotationIsAttachedToDocument(lm document) {
        Annotation annotation = this._inReplyTo;
        if (annotation == null || document == null || !annotation.isAttached() || annotation.internalDocument == document) {
            return;
        }
        PdfLog.w("Nutri.Annotation", "Annotation and its reply are attached to different documents. This can produce unexpected results. Annotation: %s Reply: %s", annotation, this);
    }

    private static /* synthetic */ void getDetachedAnnotationManager$annotations() {
    }

    @JvmStatic
    public static final String makeNewGroupId() {
        return INSTANCE.makeNewGroupId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markPreferredForPlatformRendering() {
        this.prefersPlatformRendering = true;
    }

    private final void refreshBorderEffectEdgeInsets() {
        float borderEffectIntensity = getBorderEffectIntensity();
        RectF boundingBox = getBoundingBox();
        EdgeInsets edgeInsets = getInternal().getEdgeInsets();
        BorderEffect borderEffect = getBorderEffect();
        BorderEffect borderEffect2 = BorderEffect.CLOUDY;
        if (borderEffect == borderEffect2 && borderEffectIntensity > 0.0f) {
            boundingBox.left += edgeInsets.left;
            boundingBox.top -= edgeInsets.top;
            boundingBox.right -= edgeInsets.right;
            boundingBox.bottom += edgeInsets.bottom;
            float f = borderEffectIntensity * 4.25f;
            boundingBox.inset(-f, f);
            setBoundingBox(boundingBox);
            getInternal().setEdgeInsets(new EdgeInsets(f, f, f, f));
            return;
        }
        if (getBorderEffect() == borderEffect2 || borderEffectIntensity != 0.0f || edgeInsets.top == 0.0f) {
            return;
        }
        getInternal().setEdgeInsets(new EdgeInsets());
        boundingBox.left += edgeInsets.left;
        boundingBox.top -= edgeInsets.top;
        boundingBox.right -= edgeInsets.right;
        boundingBox.bottom += edgeInsets.bottom;
        setBoundingBox(boundingBox);
    }

    @JvmStatic
    public static final void setMinimumAnnotationSizeForType(AnnotationType annotationType, Size size) {
        INSTANCE.setMinimumAnnotationSizeForType(annotationType, size);
    }

    private final void setUpDefaultProperties() {
        this.propertyManager.a(this);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(12, Float.valueOf(1.0f), true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(2, getInternal().getUuid(), true);
        j3Var2.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean updateMeasurementContentsString() {
        xp measurementProperties = getInternal().getMeasurementProperties();
        if (measurementProperties == null) {
            return false;
        }
        rp measurementLabelValue = getMeasurementLabelValue(measurementProperties);
        if (measurementLabelValue == null) {
            throw new IllegalStateException("Can't update measurement text for annotation type " + getType().name());
        }
        if (Intrinsics.areEqual(measurementLabelValue.a, getContents())) {
            return false;
        }
        setContents(measurementLabelValue.a);
        return true;
    }

    public final void attachBinaryInstantJsonAttachment(DataProvider dataProvider, String mimeType) {
        NativeResourceManager nativeResourceManager;
        String strFindResource;
        dataProvider.getClass();
        if (this.internalDocument == null) {
            throw new IllegalStateException("The annotation needs to be attached to a document in order to attach a new binary instant JSON attachment.");
        }
        NativeAnnotation nativeAnnotationRequireNativeAnnotation = getInternal().requireNativeAnnotation();
        NativeResult nativeResultAttachBinaryInstantJson = NativeAnnotationManager.attachBinaryInstantJson(nativeAnnotationRequireNativeAnnotation, new DataProviderShim(dataProvider), mimeType);
        nativeResultAttachBinaryInstantJson.getClass();
        if (nativeResultAttachBinaryInstantJson.getHasError()) {
            throw new RuntimeException(nativeResultAttachBinaryInstantJson.getErrorString());
        }
        if (StringsKt.equals(MimeTypes.IMAGE_JPEG, mimeType, true)) {
            this.propertyManager.a((k4) null);
            lm lmVar = this.internalDocument;
            if (lmVar == null || (nativeResourceManager = lmVar.q) == null || (strFindResource = nativeResourceManager.findResource(nativeAnnotationRequireNativeAnnotation)) == null) {
                return;
            }
            j3 j3Var = this.propertyManager;
            c1 c1Var = new c1(this);
            c1Var.e = strFindResource;
            j3Var.a(c1Var);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Annotation) {
            return Intrinsics.areEqual(getUuid(), ((Annotation) other).getUuid());
        }
        return false;
    }

    public final String fetchBinaryInstantJsonAttachment(OutputStream outputStream) {
        outputStream.getClass();
        if (this.internalDocument == null) {
            throw new IllegalStateException("The annotation needs to be attached to a document to fetch its binary instant JSON attachment.");
        }
        NativeAttachmentResult nativeAttachmentResultWriteBinaryInstantJsonAttachment = NativeAnnotationManager.writeBinaryInstantJsonAttachment(getInternal().requireNativeAnnotation(), new pt(outputStream));
        nativeAttachmentResultWriteBinaryInstantJsonAttachment.getClass();
        if (nativeAttachmentResultWriteBinaryInstantJsonAttachment.getHasError()) {
            throw new IllegalStateException(nativeAttachmentResultWriteBinaryInstantJsonAttachment.getErrorString());
        }
        return nativeAttachmentResultWriteBinaryInstantJsonAttachment.getMimeType();
    }

    public final void generateAppearanceStream() {
        j3 j3Var = this.propertyManager;
        j3Var.k = true;
        synchronized (j3Var) {
            j3Var.a(true);
        }
    }

    public final Completable generateAppearanceStreamAsync() {
        lm lmVar = this.internalDocument;
        if (lmVar == null) {
            Completable completableComplete = Completable.complete();
            completableComplete.getClass();
            return completableComplete;
        }
        Completable completableSubscribeOn = Completable.fromAction(new Action() { // from class: com.pspdfkit.annotations.Annotation$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                this.f$0.generateAppearanceStream();
            }
        }).subscribeOn(lmVar.b(5));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    public final float getAlpha() {
        j3 j3Var = this.propertyManager;
        return j3Var.a(28, j3Var.a(12, 1.0f));
    }

    /* JADX INFO: renamed from: getAppearanceStreamGenerator, reason: from getter */
    public final AppearanceStreamGenerator get_appearanceStreamGenerator() {
        return this._appearanceStreamGenerator;
    }

    public final BlendMode getBlendMode() {
        return (BlendMode) this.propertyManager.a(23, BlendMode.NORMAL);
    }

    public int getBorderColor() {
        return getColor();
    }

    public final List<Integer> getBorderDashArray() {
        List listE = this.propertyManager.e(15);
        if (listE instanceof List) {
            return listE;
        }
        return null;
    }

    public final BorderEffect getBorderEffect() {
        return (BorderEffect) this.propertyManager.a(24, BorderEffect.NO_EFFECT);
    }

    public final float getBorderEffectIntensity() {
        return this.propertyManager.a(25, 0.0f);
    }

    public BorderStyle getBorderStyle() {
        return (BorderStyle) this.propertyManager.a(14, BorderStyle.NONE);
    }

    public final float getBorderWidth() {
        return this.propertyManager.a(101, 1.0f);
    }

    public RectF getBoundingBox() {
        return getBoundingBox(null);
    }

    public final int getColor() {
        return this.propertyManager.a(10, 0);
    }

    public String getContents() {
        return this.propertyManager.g(3);
    }

    public Annotation getCopy() {
        return null;
    }

    public final Date getCreatedDate() {
        return this.propertyManager.c(7);
    }

    public final String getCreator() {
        return this.propertyManager.g(6);
    }

    public final JSONObject getCustomData() {
        return this.propertyManager.e();
    }

    public final float getFillAlpha() {
        j3 j3Var = this.propertyManager;
        return j3Var.a(29, j3Var.a(12, 1.0f));
    }

    public int getFillColor() {
        return this.propertyManager.a(11, 0);
    }

    public EnumSet<AnnotationFlags> getFlags() {
        EnumSet<AnnotationFlags> enumSetCopyOf;
        EnumSet<?> enumSetD = this.propertyManager.d(16);
        if (!(enumSetD instanceof EnumSet)) {
            enumSetD = null;
        }
        if (enumSetD != null && (enumSetCopyOf = EnumSet.copyOf((EnumSet) enumSetD)) != null) {
            return enumSetCopyOf;
        }
        EnumSet<AnnotationFlags> enumSetNoneOf = EnumSet.noneOf(AnnotationFlags.class);
        enumSetNoneOf.getClass();
        return enumSetNoneOf;
    }

    public final String getFontName() {
        return this.propertyManager.g(1001);
    }

    public final String getGroup() {
        return this.propertyManager.g(27);
    }

    public final boolean getHasLockedContents() {
        return hasFlag(AnnotationFlags.LOCKEDCONTENTS);
    }

    public final Annotation getInReplyTo() {
        if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
            return null;
        }
        Annotation annotation = this._inReplyTo;
        if (annotation != null) {
            return annotation;
        }
        String inReplyToUuid = getInternal().getInReplyToUuid();
        lm lmVar = this.internalDocument;
        if (lmVar == null || inReplyToUuid == null) {
            return null;
        }
        Annotation annotationBlocking = AnnotationProviderBlocking.getAnnotationBlocking(lmVar.getAnnotationProvider(), getPageIndex(), inReplyToUuid);
        this._inReplyTo = annotationBlocking;
        return annotationBlocking;
    }

    public final Maybe<Annotation> getInReplyToAsync() {
        lm lmVar = this.internalDocument;
        if (lmVar == null || !isReply()) {
            Maybe<Annotation> maybeEmpty = Maybe.empty();
            maybeEmpty.getClass();
            return maybeEmpty;
        }
        Maybe<Annotation> maybeSubscribeOn = Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.annotations.Annotation$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getInReplyTo();
            }
        }).subscribeOn(lmVar.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    public final String getInstantRecordGroup() {
        NativeAnnotation nativeAnnotation = getInternal().getNativeAnnotation();
        if (nativeAnnotation != null) {
            return nativeAnnotation.getInstantRecordGroup();
        }
        return null;
    }

    public bm getInternal() {
        return this.internalAPI;
    }

    public final lm getInternalDocument() {
        return this.internalDocument;
    }

    public final MeasurementInfo getMeasurementInfo() {
        if (!ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow for measurement tools.");
        }
        if (!isMeasurement()) {
            return null;
        }
        xp measurementProperties = this.internalAPI.getMeasurementProperties();
        if (measurementProperties == null) {
            throw new IllegalStateException("Cannot get measurement info for measurement annotation as the measurement properties are null.");
        }
        rp measurementLabelValue = getMeasurementLabelValue(measurementProperties);
        if (measurementLabelValue != null) {
            return new MeasurementInfo(measurementProperties.a, measurementProperties.b, measurementProperties.c, measurementLabelValue.b, getContents());
        }
        throw new IllegalStateException("Cannot calculate measurement value for measurement annotation.");
    }

    public rp getMeasurementLabelValue(xp measurementProperties) {
        measurementProperties.getClass();
        return null;
    }

    public Size getMinimumSize() {
        Size size = minimumAnnotationSizeForType.get(getType());
        return size == null ? DEFAULT_MINIMUM_SIZE : size;
    }

    public final Date getModifiedDate() {
        return this.propertyManager.c(8);
    }

    public final String getName() {
        return this.propertyManager.g(2);
    }

    public final int getObjectNumber() {
        return this.propertyManager.a(0, Integer.MIN_VALUE);
    }

    public final int getPageIndex() {
        return this.propertyManager.a(1, Integer.MIN_VALUE);
    }

    public final String getRichText() {
        return this.propertyManager.g(5);
    }

    public final String getSubject() {
        return this.propertyManager.g(4);
    }

    public final FreeTextAnnotation.FreeTextTextJustification getTextJustification() {
        return EntriesMappings.entries$0.get(this.propertyManager.b(1005));
    }

    public final float getTextSize() {
        return this.propertyManager.a(1002, 18.0f);
    }

    public abstract AnnotationType getType();

    public final String getUuid() {
        return getInternal().getUuid();
    }

    public VerticalTextAlignment getVerticalTextAlignment() {
        return EntriesMappings.entries$1.get(this.propertyManager.b(1006));
    }

    public final boolean hasBinaryInstantJsonAttachment() {
        if (this.internalDocument == null) {
            throw new IllegalStateException("The annotation needs to be attached to a document to check if it has a binary instant JSON attachment.");
        }
        NativeAnnotation nativeAnnotation = getInternal().getNativeAnnotation();
        if (nativeAnnotation == null) {
            return false;
        }
        return NativeAnnotationManager.hasBinaryInstantJsonAttachment(nativeAnnotation);
    }

    public final boolean hasCustomMinimumSize() {
        return minimumAnnotationSizeForType.get(getType()) != null;
    }

    public final boolean hasFlag(AnnotationFlags flag) {
        flag.getClass();
        return getFlags().contains(flag);
    }

    public final boolean hasSamePropertiesAs(Annotation other) {
        other.getClass();
        if (this == other) {
            return true;
        }
        return Intrinsics.areEqual(this.propertyManager, other.propertyManager);
    }

    public int hashCode() {
        return getUuid().hashCode();
    }

    public final boolean isAttached() {
        NativeAnnotation nativeAnnotation = getInternal().getNativeAnnotation();
        if (this.internalDocument != null) {
            return (nativeAnnotation != null ? nativeAnnotation.getAnnotationId() : null) != null;
        }
        return false;
    }

    public boolean isLocked() {
        return hasFlag(AnnotationFlags.LOCKED);
    }

    public boolean isMeasurement() {
        return false;
    }

    public final boolean isModified() {
        boolean zIsEmpty;
        k4 k4Var;
        j3 j3Var = this.propertyManager;
        k3 k3Var = j3Var.f;
        synchronized (k3Var) {
            zIsEmpty = k3Var.b.isEmpty();
        }
        return !zIsEmpty || j3Var.f.f() || ((k4Var = j3Var.j) != null && k4Var.b);
    }

    public final boolean isReply() {
        return (this._inReplyTo == null && this.internalAPI.getInReplyToUuid() == null) ? false : true;
    }

    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        return true;
    }

    public final boolean isSignature() {
        return this.propertyManager.a(2000);
    }

    public boolean isUiRotationSupported() {
        return false;
    }

    public void onBeforeAttachToDocument(NativeAnnotation nativeAnnotation) {
        nativeAnnotation.getClass();
    }

    public final void renderToBitmap(Bitmap bitmap) {
        bitmap.getClass();
        AnnotationRenderConfiguration annotationRenderConfigurationBuild = new AnnotationRenderConfiguration.Builder().build();
        annotationRenderConfigurationBuild.getClass();
        renderToBitmap(bitmap, annotationRenderConfigurationBuild);
    }

    public final Single<Bitmap> renderToBitmapAsync(Bitmap bitmap) {
        bitmap.getClass();
        AnnotationRenderConfiguration annotationRenderConfigurationBuild = new AnnotationRenderConfiguration.Builder().build();
        annotationRenderConfigurationBuild.getClass();
        return renderToBitmapAsync(bitmap, annotationRenderConfigurationBuild);
    }

    public final void setAlpha(float f) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(12, Float.valueOf(f), true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(28, Float.valueOf(f), true);
        j3Var2.l();
    }

    public final void setAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator) {
        if (Intrinsics.areEqual(appearanceStreamGenerator, this._appearanceStreamGenerator)) {
            return;
        }
        this._appearanceStreamGenerator = appearanceStreamGenerator;
        j3 j3Var = this.propertyManager;
        j3Var.k = true;
        if (this instanceof StampAnnotation) {
            if (appearanceStreamGenerator != null) {
                j3Var.f.a(4000, StampAnnotation.CUSTOM_AP_STREAM.getName(), true);
                j3Var.l();
            } else {
                j3Var.h(4000);
            }
        }
        lm lmVar = this.internalDocument;
        if (lmVar != null) {
            if (appearanceStreamGenerator != null) {
                lmVar.getAnnotationProvider().g.a(this);
            } else {
                lmVar.getAnnotationProvider().g.b(this);
            }
        }
        generateAppearanceStream();
    }

    public final void setBlendMode(BlendMode blendMode) {
        blendMode.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(23, blendMode, true);
        j3Var.l();
    }

    public void setBorderColor(int i) {
        setColor(i);
    }

    public final void setBorderDashArray(List<Integer> list) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(15, list, true);
        j3Var.l();
    }

    public final void setBorderEffect(BorderEffect borderEffect) {
        borderEffect.getClass();
        boolean zA = this.propertyManager.f.a(24);
        if (getBorderEffect() != borderEffect) {
            j3 j3Var = this.propertyManager;
            j3Var.f.a(24, borderEffect, true);
            j3Var.l();
            if (zA) {
                refreshBorderEffectEdgeInsets();
            }
        }
    }

    public final void setBorderEffectIntensity(float f) {
        boolean zA = this.propertyManager.f.a(25);
        if (getBorderEffectIntensity() == f) {
            return;
        }
        j3 j3Var = this.propertyManager;
        j3Var.f.a(25, Float.valueOf(f), true);
        j3Var.l();
        if (zA) {
            refreshBorderEffectEdgeInsets();
        }
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        borderStyle.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(14, borderStyle, true);
        j3Var.l();
    }

    public final void setBorderWidth(float f) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(101, Float.valueOf(f), true);
        j3Var.l();
    }

    public void setBoundingBox(RectF rectF) {
        rectF.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, new RectF(rectF), true);
        j3Var.l();
        AnnotationType type = getType();
        type.getClass();
        if (type == AnnotationType.SQUARE || type == AnnotationType.CIRCLE) {
            updateMeasurementContentsString();
        }
    }

    public final void setColor(int i) {
        j3 j3Var = this.propertyManager;
        if (i != 0) {
            i = ColorUtils.setAlphaComponent(i, 255);
        }
        j3Var.f.a(10, Integer.valueOf(i), true);
        j3Var.l();
    }

    public void setContentSize(RectF contentSize, boolean adjustedForPageRotation) {
        RectF rectF = new RectF(contentSize);
        float f = rectF.left;
        float f2 = rectF.right;
        if (f > f2) {
            rectF.left = f2;
            rectF.right = f;
        }
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        if (f3 > f4) {
            rectF.bottom = f4;
            rectF.top = f3;
        }
        if (!isAttached()) {
            j3 j3Var = this.propertyManager;
            j3Var.f.a(22, rectF, true);
            j3Var.l();
            if (adjustedForPageRotation) {
                return;
            }
            this.adjustContentSizeOnAttachToDocument = true;
            return;
        }
        if (!this.internalAPI.needsFlippedContentSize() || adjustedForPageRotation) {
            j3 j3Var2 = this.propertyManager;
            j3Var2.f.a(22, rectF, true);
            j3Var2.l();
        } else {
            j3 j3Var3 = this.propertyManager;
            j3Var3.f.a(22, new RectF(0.0f, rectF.width(), rectF.height(), 0.0f), true);
            j3Var3.l();
        }
        this.adjustContentSizeOnAttachToDocument = false;
    }

    public void setContents(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(3, str, true);
        synchronized (j3Var) {
            j3Var.a(true);
        }
    }

    public final void setCreatedDate(Date date) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(7, date, true);
        j3Var.l();
    }

    public final void setCreator(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(6, str, true);
        j3Var.l();
    }

    public final void setCustomData(JSONObject jSONObject) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9001, jSONObject, true);
        j3Var.l();
    }

    public final void setFillAlpha(float f) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(29, Float.valueOf(f), true);
        j3Var.l();
    }

    public void setFillColor(int i) {
        j3 j3Var = this.propertyManager;
        if (i != 0) {
            i = ColorUtils.setAlphaComponent(i, 255);
        }
        j3Var.f.a(11, Integer.valueOf(i), true);
        j3Var.l();
    }

    public void setFlags(EnumSet<AnnotationFlags> enumSet) {
        enumSet.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(16, enumSet, true);
        j3Var.l();
    }

    public final void setFontName(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1001, str, true);
        j3Var.l();
    }

    public final void setGroup(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(27, str, true);
        j3Var.l();
    }

    public final void setInReplyTo(final Annotation parentAnnotation) {
        AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener;
        if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
            throw new InvalidNutrientLicenseException("Your current license doesn't allow creating annotation replies.");
        }
        if (parentAnnotation == this._inReplyTo) {
            return;
        }
        if (parentAnnotation != null && parentAnnotation.getPageIndex() != getPageIndex()) {
            throw new IllegalArgumentException("The annotation that this annotation replies to must have the same page index.");
        }
        Annotation annotation = this._inReplyTo;
        if (annotation != null && (onAnnotationUpdatedListener = this.inReplyToAnnotationUpdatedListener) != null) {
            annotation.internalAPI.removeOnAnnotationUpdatedListener(onAnnotationUpdatedListener);
            this.inReplyToAnnotationUpdatedListener = null;
        }
        this._inReplyTo = parentAnnotation;
        if (parentAnnotation != null) {
            checkIfInReplyToAnnotationIsAttachedToDocument(this.internalDocument);
            AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener2 = new AnnotationProvider.OnAnnotationUpdatedListener() { // from class: com.pspdfkit.annotations.Annotation$setInReplyTo$listener$1
                @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
                public void onAnnotationCreated(Annotation annotation2) {
                    annotation2.getClass();
                    if (annotation2 != this.$parentAnnotation) {
                        return;
                    }
                    Annotation annotation3 = this;
                    annotation3.checkIfInReplyToAnnotationIsAttachedToDocument(annotation3.getInternalDocument());
                    Annotation annotation4 = this._inReplyTo;
                    if (annotation4 != null) {
                        this.internalAPI.setInReplyToUuid(annotation4.getInternal().getUuid());
                    }
                }

                @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
                public void onAnnotationRemoved(Annotation annotation2) {
                    annotation2.getClass();
                }

                @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
                public void onAnnotationUpdated(Annotation annotation2) {
                    annotation2.getClass();
                }

                @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
                public void onAnnotationZOrderChanged(int pageIndex, List<? extends Annotation> oldOrder, List<? extends Annotation> newOrder) {
                    oldOrder.getClass();
                    newOrder.getClass();
                }
            };
            this.inReplyToAnnotationUpdatedListener = onAnnotationUpdatedListener2;
            parentAnnotation.getInternal().addOnAnnotationUpdatedListener(onAnnotationUpdatedListener2);
            this.internalAPI.setInReplyToUuid(parentAnnotation.getInternal().getUuid());
        }
    }

    public final void setModifiedDate(Date date) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(8, date, true);
        j3Var.l();
    }

    public final void setName(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(2, str, true);
        j3Var.l();
    }

    public final void setRichText(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(5, str, true);
        j3Var.l();
    }

    public final void setSubject(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4, str, true);
        j3Var.l();
    }

    public final void setTextJustification(FreeTextAnnotation.FreeTextTextJustification freeTextTextJustification) {
        freeTextTextJustification.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1005, Byte.valueOf((byte) freeTextTextJustification.ordinal()), true);
        j3Var.l();
    }

    public final void setTextSize(float f) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1002, Float.valueOf(f), true);
        j3Var.l();
    }

    public void setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
        verticalTextAlignment.getClass();
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1006, Byte.valueOf((byte) verticalTextAlignment.ordinal()), true);
        j3Var.l();
    }

    public String toInstantJson() {
        lm lmVar = this.internalDocument;
        if (!isAttached() || lmVar == null) {
            throw new IllegalStateException("Can't create json from annotation when annotation is not attached!");
        }
        String instantJson = lmVar.getAnnotationProvider().d.toInstantJson(getInternal().requireNativeAnnotation());
        instantJson.getClass();
        return instantJson;
    }

    public String toString() {
        return "Annotation[" + getType() + "]{" + this.propertyManager + "}";
    }

    public abstract void updateTransformationProperties(RectF newBoundingBox, RectF oldBoundingBox);

    public final RectF getBoundingBox(RectF rect) {
        RectF rectFF = this.propertyManager.f(9);
        if (rect == null) {
            rect = new RectF();
        }
        if (rectFF != null) {
            rect.set(rectFF);
        }
        return rect;
    }

    public final Annotation getCopy(int pageIndex) {
        if (pageIndex < 0) {
            throw new IllegalArgumentException("pageIndex can't be smaller than 0.");
        }
        Annotation copy = getInternal().getCopy();
        if (copy == null) {
            return null;
        }
        copy.getInternal().setPageIndex(pageIndex);
        return copy;
    }

    public final void renderToBitmap(Bitmap bitmap, AnnotationRenderConfiguration configuration) {
        bitmap.getClass();
        configuration.getClass();
        renderToBitmapAsync(bitmap, configuration).ignoreElement().blockingAwait();
    }

    public final Single<Bitmap> renderToBitmapAsync(Bitmap bitmap, AnnotationRenderConfiguration configuration) {
        bitmap.getClass();
        configuration.getClass();
        if (!isAttached()) {
            throw new IllegalStateException("Can't render annotations that aren't attached to a document page!");
        }
        lm lmVar = this.internalDocument;
        if (lmVar == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Single<Bitmap> singleA = h4.a(lmVar, this, bitmap, configuration);
        singleA.getClass();
        return singleA;
    }

    public Annotation(j3 j3Var, boolean z) {
        j3Var.getClass();
        j3 j3Var2 = new j3();
        this.propertyManager = j3Var2;
        this.onAnnotationUpdatedListeners = new go<>();
        this.internalAPI = new Annotation$internalAPI$1(this);
        setUpDefaultProperties();
        j3Var2.a(j3Var, z);
    }
}
