package com.pspdfkit.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.annotations.AnnotationReplyFeatures;
import com.pspdfkit.configuration.annotations.CopyPasteFeatures;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.configuration.signatures.SignatureColorOptions;
import com.pspdfkit.configuration.signatures.SignatureCreationMode;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.configuration.theming.ThemeMode;
import com.pspdfkit.document.OutlineElementState;
import com.pspdfkit.internal.kv;
import com.pspdfkit.internal.lv;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0003\b\u008a\u0001\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ë\u00012\u00020\u0001:\u0004ê\u0001ë\u0001BÕ\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020\r\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&\u0012\u0006\u0010*\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020\r\u0012\u0006\u0010,\u001a\u00020\r\u0012\u0006\u0010-\u001a\u00020\u0018\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180&\u0012\u0006\u0010/\u001a\u00020\r\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u00101\u001a\u00020\r\u0012\u0006\u00102\u001a\u00020\u0011\u0012\u0006\u00103\u001a\u00020\r\u0012\u0006\u00104\u001a\u00020\r\u0012\u0006\u00105\u001a\u00020\r\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020807\u0012\u0006\u00109\u001a\u00020\r\u0012\u0006\u0010:\u001a\u00020\r\u0012\u0006\u0010;\u001a\u00020<\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010>\u001a\u00020\r\u0012\u0006\u0010?\u001a\u00020@\u0012\u0006\u0010A\u001a\u00020B\u0012\u0006\u0010C\u001a\u00020D\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0&\u0012\u0006\u0010G\u001a\u00020\r\u0012\u0006\u0010H\u001a\u00020\r\u0012\u0006\u0010I\u001a\u00020\r\u0012\u0006\u0010J\u001a\u00020\r\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L07\u0012\u0006\u0010M\u001a\u00020\r\u0012\u0006\u0010N\u001a\u00020\r\u0012\u0006\u0010O\u001a\u00020\r\u0012\u0006\u0010P\u001a\u00020\u0011\u0012\u0006\u0010Q\u001a\u00020\r\u0012\u0006\u0010R\u001a\u00020\r\u0012\u0006\u0010S\u001a\u00020\r\u0012\u0006\u0010T\u001a\u00020\r\u0012\u0006\u0010U\u001a\u00020V\u0012\u0006\u0010W\u001a\u00020\r\u0012\u0006\u0010X\u001a\u00020\r\u0012\u0006\u0010Y\u001a\u00020\r¢\u0006\u0004\bZ\u0010[J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\rHÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0011HÆ\u0003J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010kJ\n\u0010¢\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010£\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\rHÆ\u0003J\n\u0010©\u0001\u001a\u00020\rHÆ\u0003J\n\u0010ª\u0001\u001a\u00020\rHÆ\u0003J\n\u0010«\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\rHÆ\u0003J\n\u0010®\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¯\u0001\u001a\u00020\rHÆ\u0003J\n\u0010°\u0001\u001a\u00020\rHÆ\u0003J\n\u0010±\u0001\u001a\u00020\rHÆ\u0003J\n\u0010²\u0001\u001a\u00020\rHÆ\u0003J\u0010\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020'0&HÆ\u0003J\u0010\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020)0&HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¶\u0001\u001a\u00020\rHÆ\u0003J\n\u0010·\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0018HÆ\u0003J\u0010\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180&HÆ\u0003J\n\u0010º\u0001\u001a\u00020\rHÆ\u0003J\u0010\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020'0&HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\rHÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\rHÆ\u0003J\n\u0010¿\u0001\u001a\u00020\rHÆ\u0003J\n\u0010À\u0001\u001a\u00020\rHÆ\u0003J\u0010\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020807HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ä\u0001\u001a\u00020<HÆ\u0003J\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010kJ\n\u0010Æ\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ç\u0001\u001a\u00020@HÆ\u0003J\n\u0010È\u0001\u001a\u00020BHÆ\u0003J\n\u0010É\u0001\u001a\u00020DHÆ\u0003J\u0010\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020F0&HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\rHÆ\u0003J\u0010\u0010Ï\u0001\u001a\b\u0012\u0004\u0012\u00020L07HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\rHÆ\u0003J\n\u0010×\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020VHÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\rHÆ\u0003J\n\u0010Û\u0001\u001a\u00020\rHÆ\u0003Jæ\u0005\u0010Ü\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\r2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\r2\b\b\u0002\u0010-\u001a\u00020\u00182\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180&2\b\b\u0002\u0010/\u001a\u00020\r2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u00101\u001a\u00020\r2\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\r2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u000208072\b\b\u0002\u00109\u001a\u00020\r2\b\b\u0002\u0010:\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020D2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020F0&2\b\b\u0002\u0010G\u001a\u00020\r2\b\b\u0002\u0010H\u001a\u00020\r2\b\b\u0002\u0010I\u001a\u00020\r2\b\b\u0002\u0010J\u001a\u00020\r2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020L072\b\b\u0002\u0010M\u001a\u00020\r2\b\b\u0002\u0010N\u001a\u00020\r2\b\b\u0002\u0010O\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00112\b\b\u0002\u0010Q\u001a\u00020\r2\b\b\u0002\u0010R\u001a\u00020\r2\b\b\u0002\u0010S\u001a\u00020\r2\b\b\u0002\u0010T\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020\r2\b\b\u0002\u0010X\u001a\u00020\r2\b\b\u0002\u0010Y\u001a\u00020\rHÆ\u0001¢\u0006\u0003\u0010Ý\u0001J\u0007\u0010Þ\u0001\u001a\u00020\u0011J\u0017\u0010ß\u0001\u001a\u00020\r2\n\u0010à\u0001\u001a\u0005\u0018\u00010á\u0001HÖ\u0083\u0004J\u000b\u0010â\u0001\u001a\u00020\u0011HÖ\u0081\u0004J\f\u0010ã\u0001\u001a\u00030ä\u0001HÖ\u0081\u0004J\u001b\u0010å\u0001\u001a\u00030æ\u00012\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010é\u0001\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010fR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bg\u0010fR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010fR\u0013\u0010\u0010\u001a\u00020\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\n\n\u0002\u0010l\u001a\u0004\bj\u0010kR\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bm\u0010iR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010fR\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bn\u0010fR\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010fR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bq\u0010pR\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\br\u0010fR\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010fR\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010fR\u0011\u0010\u001d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010fR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010fR\u0011\u0010\u001f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010fR\u0011\u0010 \u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010fR\u0011\u0010!\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010fR\u0011\u0010\"\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010fR\u0011\u0010#\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010fR\u0011\u0010$\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bs\u0010fR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&¢\u0006\b\n\u0000\u001a\u0004\bv\u0010uR\u0011\u0010*\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bw\u0010fR\u0011\u0010+\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bx\u0010fR\u0011\u0010,\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\by\u0010fR\u0013\u0010-\u001a\u00020\u00188\u0007¢\u0006\b\n\u0000\u001a\u0004\bz\u0010pR\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180&8\u0007¢\u0006\b\n\u0000\u001a\u0004\b{\u0010uR\u0011\u0010/\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010fR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b|\u0010uR\u0011\u00101\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u0010fR\u0011\u00102\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b}\u0010iR\u0011\u00103\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u0010fR\u0011\u00104\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u0010fR\u0011\u00105\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u0010fR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020807¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0011\u00109\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u0010fR\u0011\u0010:\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010fR\u0013\u0010;\u001a\u00020<¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010=\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010l\u001a\u0005\b\u0082\u0001\u0010kR\u0011\u0010>\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010fR\u0013\u0010?\u001a\u00020@¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0013\u0010A\u001a\u00020B¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0013\u0010C\u001a\u00020D¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020F0&8\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010uR\u0011\u0010G\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bG\u0010fR\u0011\u0010H\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bH\u0010fR\u001e\u0010I\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0004\bI\u0010fR\u0011\u0010J\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010fR\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020L07¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u007fR\u0012\u0010M\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010fR\u0012\u0010N\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010fR\u0012\u0010O\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010fR\u0012\u0010P\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010iR\u0011\u0010Q\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010fR\u0012\u0010R\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010fR\u0012\u0010S\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010fR\u0012\u0010T\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010fR\u0013\u0010U\u001a\u00020V¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0012\u0010W\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010fR\u0011\u0010X\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bX\u0010fR\u0012\u0010Y\u001a\u00020\r¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010f¨\u0006ì\u0001"}, d2 = {"Lcom/pspdfkit/configuration/PdfConfiguration;", "Landroid/os/Parcelable;", "scrollDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "scrollMode", "Lcom/pspdfkit/configuration/page/PageScrollMode;", "fitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "layoutMode", "Lcom/pspdfkit/configuration/page/PageLayoutMode;", "themeMode", "Lcom/pspdfkit/configuration/theming/ThemeMode;", "isFirstPageAlwaysSingle", "", "showGapBetweenPages", "isScrollbarsEnabled", "backgroundColor", "", "loadingProgressDrawable", "memoryCacheSize", "isInvertColors", "automaticallyInvertColorsForNightTheme", "isToGrayscale", "startZoomScale", "", "maxZoomScale", "shouldZoomOutBounce", "isTextSelectionEnabled", "isFormEditingEnabled", "isAutoSelectNextFormElementEnabled", "isFormElementDateAndTimePickerEnabled", "isAnnotationEditingEnabled", "isAnnotationRotationEnabled", "isContentEditingEnabled", "isMeasurementsEnabled", "isAnnotationLimitedToPageBounds", "useRectangleSelectionForMarkupAnnotations", "editableAnnotationTypes", "", "Lcom/pspdfkit/annotations/AnnotationType;", "enabledAnnotationTools", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "selectedAnnotationResizeEnabled", "selectedAnnotationResizeGuidesEnabled", "selectedAnnotationFontScalingOnResizeEnabled", "resizeGuideSnapAllowance", "guideLineIntervals", "isAnnotationInspectorEnabled", "excludedAnnotationTypes", "isAutosaveEnabled", "pagePadding", "isLastViewedPageRestorationEnabled", "isAutomaticLinkGenerationEnabled", "isCopyPasteEnabled", "enabledCopyPasteFeatures", "Ljava/util/EnumSet;", "Lcom/pspdfkit/configuration/annotations/CopyPasteFeatures;", "isUndoEnabled", "isRedoEnabled", "annotationReplyFeatures", "Lcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;", "fixedLowResRenderPixelCount", "isMultithreadedRenderingEnabled", "signaturePickerOrientation", "Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "signatureSavingStrategy", "Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "signatureColorOptions", "Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "signatureCreationModes", "Lcom/pspdfkit/configuration/signatures/SignatureCreationMode;", "isNoteAnnotationNoZoomHandlingEnabled", "isJavaScriptEnabled", "isTextSelectionPopupToolbarEnabled", "isAnnotationPopupToolbarEnabled", "enabledShareFeatures", "Lcom/pspdfkit/configuration/sharing/ShareFeatures;", "allowMultipleBookmarksPerPage", "scrollOnEdgeTapEnabled", "animateScrollOnEdgeTaps", "scrollOnEdgeTapMargin", "isMagnifierEnabled", "showSignHereOverlay", "showNoteEditorForNewNoteAnnotations", "enableStylusOnDetection", "outlineElementState", "Lcom/pspdfkit/document/OutlineElementState;", "useCubicInterpolationForInkAnnotations", "isAiAssistantEnabled", "annotationsBlockLinks", "<init>", "(Lcom/pspdfkit/configuration/page/PageScrollDirection;Lcom/pspdfkit/configuration/page/PageScrollMode;Lcom/pspdfkit/configuration/page/PageFitMode;Lcom/pspdfkit/configuration/page/PageLayoutMode;Lcom/pspdfkit/configuration/theming/ThemeMode;ZZZILjava/lang/Integer;IZZZFFZZZZZZZZZZZLjava/util/List;Ljava/util/List;ZZZFLjava/util/List;ZLjava/util/List;ZIZZZLjava/util/EnumSet;ZZLcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;Ljava/lang/Integer;ZLcom/pspdfkit/configuration/forms/SignaturePickerOrientation;Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;Ljava/util/List;ZZZZLjava/util/EnumSet;ZZZIZZZZLcom/pspdfkit/document/OutlineElementState;ZZZ)V", "getScrollDirection", "()Lcom/pspdfkit/configuration/page/PageScrollDirection;", "getScrollMode", "()Lcom/pspdfkit/configuration/page/PageScrollMode;", "getFitMode", "()Lcom/pspdfkit/configuration/page/PageFitMode;", "getLayoutMode", "()Lcom/pspdfkit/configuration/page/PageLayoutMode;", "getThemeMode", "()Lcom/pspdfkit/configuration/theming/ThemeMode;", "()Z", "getShowGapBetweenPages", "getBackgroundColor", "()I", "getLoadingProgressDrawable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMemoryCacheSize", "getAutomaticallyInvertColorsForNightTheme", "getStartZoomScale", "()F", "getMaxZoomScale", "getShouldZoomOutBounce", "getUseRectangleSelectionForMarkupAnnotations", "getEditableAnnotationTypes", "()Ljava/util/List;", "getEnabledAnnotationTools", "getSelectedAnnotationResizeEnabled", "getSelectedAnnotationResizeGuidesEnabled", "getSelectedAnnotationFontScalingOnResizeEnabled", "getResizeGuideSnapAllowance", "getGuideLineIntervals", "getExcludedAnnotationTypes", "getPagePadding", "getEnabledCopyPasteFeatures", "()Ljava/util/EnumSet;", "getAnnotationReplyFeatures", "()Lcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;", "getFixedLowResRenderPixelCount", "getSignaturePickerOrientation", "()Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "getSignatureSavingStrategy", "()Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "getSignatureColorOptions", "()Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "getSignatureCreationModes", "isTextSelectionPopupToolbarEnabled$annotations", "()V", "getEnabledShareFeatures", "getAllowMultipleBookmarksPerPage", "getScrollOnEdgeTapEnabled", "getAnimateScrollOnEdgeTaps", "getScrollOnEdgeTapMargin", "getShowSignHereOverlay", "getShowNoteEditorForNewNoteAnnotations", "getEnableStylusOnDetection", "getOutlineElementState", "()Lcom/pspdfkit/document/OutlineElementState;", "getUseCubicInterpolationForInkAnnotations", "getAnnotationsBlockLinks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/pspdfkit/configuration/page/PageScrollDirection;Lcom/pspdfkit/configuration/page/PageScrollMode;Lcom/pspdfkit/configuration/page/PageFitMode;Lcom/pspdfkit/configuration/page/PageLayoutMode;Lcom/pspdfkit/configuration/theming/ThemeMode;ZZZILjava/lang/Integer;IZZZFFZZZZZZZZZZZLjava/util/List;Ljava/util/List;ZZZFLjava/util/List;ZLjava/util/List;ZIZZZLjava/util/EnumSet;ZZLcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;Ljava/lang/Integer;ZLcom/pspdfkit/configuration/forms/SignaturePickerOrientation;Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;Ljava/util/List;ZZZZLjava/util/EnumSet;ZZZIZZZZLcom/pspdfkit/document/OutlineElementState;ZZZ)Lcom/pspdfkit/configuration/PdfConfiguration;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PdfConfiguration implements Parcelable {
    private final boolean allowMultipleBookmarksPerPage;
    private final boolean animateScrollOnEdgeTaps;
    private final AnnotationReplyFeatures annotationReplyFeatures;
    private final boolean annotationsBlockLinks;
    private final boolean automaticallyInvertColorsForNightTheme;
    private final int backgroundColor;
    private final List<AnnotationType> editableAnnotationTypes;
    private final boolean enableStylusOnDetection;
    private final List<AnnotationTool> enabledAnnotationTools;
    private final EnumSet<CopyPasteFeatures> enabledCopyPasteFeatures;
    private final EnumSet<ShareFeatures> enabledShareFeatures;
    private final List<AnnotationType> excludedAnnotationTypes;
    private final PageFitMode fitMode;
    private final Integer fixedLowResRenderPixelCount;
    private final List<Float> guideLineIntervals;
    private final boolean isAiAssistantEnabled;
    private final boolean isAnnotationEditingEnabled;
    private final boolean isAnnotationInspectorEnabled;
    private final boolean isAnnotationLimitedToPageBounds;
    private final boolean isAnnotationPopupToolbarEnabled;
    private final boolean isAnnotationRotationEnabled;
    private final boolean isAutoSelectNextFormElementEnabled;
    private final boolean isAutomaticLinkGenerationEnabled;
    private final boolean isAutosaveEnabled;
    private final boolean isContentEditingEnabled;
    private final boolean isCopyPasteEnabled;
    private final boolean isFirstPageAlwaysSingle;
    private final boolean isFormEditingEnabled;
    private final boolean isFormElementDateAndTimePickerEnabled;
    private final boolean isInvertColors;
    private final boolean isJavaScriptEnabled;
    private final boolean isLastViewedPageRestorationEnabled;
    private final boolean isMagnifierEnabled;
    private final boolean isMeasurementsEnabled;
    private final boolean isMultithreadedRenderingEnabled;
    private final boolean isNoteAnnotationNoZoomHandlingEnabled;
    private final boolean isRedoEnabled;
    private final boolean isScrollbarsEnabled;
    private final boolean isTextSelectionEnabled;
    private final boolean isTextSelectionPopupToolbarEnabled;
    private final boolean isToGrayscale;
    private final boolean isUndoEnabled;
    private final PageLayoutMode layoutMode;
    private final Integer loadingProgressDrawable;
    private final float maxZoomScale;
    private final int memoryCacheSize;
    private final OutlineElementState outlineElementState;
    private final int pagePadding;
    private final float resizeGuideSnapAllowance;
    private final PageScrollDirection scrollDirection;
    private final PageScrollMode scrollMode;
    private final boolean scrollOnEdgeTapEnabled;
    private final int scrollOnEdgeTapMargin;
    private final boolean selectedAnnotationFontScalingOnResizeEnabled;
    private final boolean selectedAnnotationResizeEnabled;
    private final boolean selectedAnnotationResizeGuidesEnabled;
    private final boolean shouldZoomOutBounce;
    private final boolean showGapBetweenPages;
    private final boolean showNoteEditorForNewNoteAnnotations;
    private final boolean showSignHereOverlay;
    private final SignatureColorOptions signatureColorOptions;
    private final List<SignatureCreationMode> signatureCreationModes;
    private final SignaturePickerOrientation signaturePickerOrientation;
    private final SignatureSavingStrategy signatureSavingStrategy;
    private final float startZoomScale;
    private final ThemeMode themeMode;
    private final boolean useCubicInterpolationForInkAnnotations;
    private final boolean useRectangleSelectionForMarkupAnnotations;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<PdfConfiguration> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/pspdfkit/configuration/PdfConfiguration$Companion;", "", "<init>", "()V", "validateSignatureCreationModes", "", "signatureCreationModes", "", "Lcom/pspdfkit/configuration/signatures/SignatureCreationMode;", "validateSignatureCreationModes$sdk_nutrient", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void validateSignatureCreationModes$sdk_nutrient(List<? extends SignatureCreationMode> signatureCreationModes) {
            signatureCreationModes.getClass();
            if (signatureCreationModes.isEmpty() || signatureCreationModes.size() > 3) {
                throw new IllegalArgumentException(("`signatureCreationModes` must have 1 to 3 elements. Found: " + signatureCreationModes.size()).toString());
            }
            if (new HashSet(signatureCreationModes).size() < signatureCreationModes.size()) {
                throw new IllegalArgumentException("`signatureCreationModes` must not have duplicates.");
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PdfConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PdfConfiguration createFromParcel(Parcel parcel) {
            Integer numValueOf;
            Object obj;
            parcel.getClass();
            PageScrollDirection pageScrollDirectionValueOf = PageScrollDirection.valueOf(parcel.readString());
            PageScrollMode pageScrollModeValueOf = PageScrollMode.valueOf(parcel.readString());
            PageFitMode pageFitModeValueOf = PageFitMode.valueOf(parcel.readString());
            PageLayoutMode pageLayoutModeValueOf = PageLayoutMode.valueOf(parcel.readString());
            ThemeMode themeModeValueOf = ThemeMode.valueOf(parcel.readString());
            boolean z = false;
            if (parcel.readInt() != 0) {
                z = true;
            }
            boolean z2 = parcel.readInt() != 0 ? true : z;
            boolean z3 = parcel.readInt() != 0 ? true : z;
            int i = parcel.readInt();
            if (parcel.readInt() == 0) {
                numValueOf = null;
                obj = null;
            } else {
                numValueOf = Integer.valueOf(parcel.readInt());
                obj = null;
            }
            int i2 = parcel.readInt();
            boolean z4 = parcel.readInt() != 0 ? true : z;
            boolean z5 = parcel.readInt() != 0 ? true : z;
            boolean z6 = parcel.readInt() != 0 ? true : z;
            float f = parcel.readFloat();
            float f2 = parcel.readFloat();
            boolean z7 = parcel.readInt() != 0 ? true : z;
            boolean z8 = parcel.readInt() != 0 ? true : z;
            boolean z9 = parcel.readInt() != 0 ? true : z;
            boolean z10 = parcel.readInt() != 0 ? true : z;
            boolean z11 = parcel.readInt() != 0 ? true : z;
            boolean z12 = parcel.readInt() != 0 ? true : z;
            boolean z13 = parcel.readInt() != 0 ? true : z;
            boolean z14 = parcel.readInt() != 0 ? true : z;
            boolean z15 = parcel.readInt() != 0 ? true : z;
            boolean z16 = parcel.readInt() != 0 ? true : z;
            boolean z17 = parcel.readInt() != 0;
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (i4 != i3) {
                arrayList.add(AnnotationType.valueOf(parcel.readString()));
                i4++;
                i3 = i3;
            }
            int i5 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i5);
            int i6 = 0;
            while (i6 != i5) {
                arrayList2.add(AnnotationTool.valueOf(parcel.readString()));
                i6++;
                i5 = i5;
            }
            boolean z18 = parcel.readInt() != 0;
            boolean z19 = parcel.readInt() != 0;
            boolean z20 = parcel.readInt() != 0;
            float f3 = parcel.readFloat();
            int i7 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i7);
            int i8 = 0;
            while (i8 != i7) {
                arrayList3.add(Float.valueOf(parcel.readFloat()));
                i8++;
                i7 = i7;
            }
            boolean z21 = parcel.readInt() != 0;
            int i9 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(i9);
            for (int i10 = 0; i10 != i9; i10++) {
                arrayList4.add(AnnotationType.valueOf(parcel.readString()));
            }
            boolean z22 = parcel.readInt() != 0;
            int i11 = parcel.readInt();
            boolean z23 = parcel.readInt() != 0;
            boolean z24 = parcel.readInt() != 0;
            boolean z25 = parcel.readInt() != 0;
            EnumSet enumSet = (EnumSet) parcel.readSerializable();
            boolean z26 = parcel.readInt() != 0;
            boolean z27 = parcel.readInt() != 0;
            AnnotationReplyFeatures annotationReplyFeaturesValueOf = AnnotationReplyFeatures.valueOf(parcel.readString());
            Integer numValueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z28 = parcel.readInt() != 0;
            SignaturePickerOrientation signaturePickerOrientationValueOf = SignaturePickerOrientation.valueOf(parcel.readString());
            SignatureSavingStrategy signatureSavingStrategyValueOf = SignatureSavingStrategy.valueOf(parcel.readString());
            SignatureColorOptions signatureColorOptions = (SignatureColorOptions) parcel.readParcelable(PdfConfiguration.class.getClassLoader());
            int i12 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i12);
            int i13 = 0;
            while (i13 != i12) {
                arrayList5.add(SignatureCreationMode.valueOf(parcel.readString()));
                i13++;
                i12 = i12;
            }
            return new PdfConfiguration(pageScrollDirectionValueOf, pageScrollModeValueOf, pageFitModeValueOf, pageLayoutModeValueOf, themeModeValueOf, z, z2, z3, i, numValueOf, i2, z4, z5, z6, f, f2, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, arrayList, arrayList2, z18, z19, z20, f3, arrayList3, z21, arrayList4, z22, i11, z23, z24, z25, enumSet, z26, z27, annotationReplyFeaturesValueOf, numValueOf2, z28, signaturePickerOrientationValueOf, signatureSavingStrategyValueOf, signatureColorOptions, arrayList5, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (EnumSet) parcel.readSerializable(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, OutlineElementState.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PdfConfiguration[] newArray(int i) {
            return new PdfConfiguration[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PdfConfiguration(PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, PageFitMode pageFitMode, PageLayoutMode pageLayoutMode, ThemeMode themeMode, boolean z, boolean z2, boolean z3, int i, Integer num, int i2, boolean z4, boolean z5, boolean z6, float f, float f2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, List<? extends AnnotationType> list, List<? extends AnnotationTool> list2, boolean z18, boolean z19, boolean z20, float f3, List<Float> list3, boolean z21, List<? extends AnnotationType> list4, boolean z22, int i3, boolean z23, boolean z24, boolean z25, EnumSet<CopyPasteFeatures> enumSet, boolean z26, boolean z27, AnnotationReplyFeatures annotationReplyFeatures, Integer num2, boolean z28, SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List<? extends SignatureCreationMode> list5, boolean z29, boolean z30, boolean z31, boolean z32, EnumSet<ShareFeatures> enumSet2, boolean z33, boolean z34, boolean z35, int i4, boolean z36, boolean z37, boolean z38, boolean z39, OutlineElementState outlineElementState, boolean z40, boolean z41, boolean z42) {
        pageScrollDirection.getClass();
        pageScrollMode.getClass();
        pageFitMode.getClass();
        pageLayoutMode.getClass();
        themeMode.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        enumSet.getClass();
        annotationReplyFeatures.getClass();
        signaturePickerOrientation.getClass();
        signatureSavingStrategy.getClass();
        signatureColorOptions.getClass();
        list5.getClass();
        enumSet2.getClass();
        outlineElementState.getClass();
        this.scrollDirection = pageScrollDirection;
        this.scrollMode = pageScrollMode;
        this.fitMode = pageFitMode;
        this.layoutMode = pageLayoutMode;
        this.themeMode = themeMode;
        this.isFirstPageAlwaysSingle = z;
        this.showGapBetweenPages = z2;
        this.isScrollbarsEnabled = z3;
        this.backgroundColor = i;
        this.loadingProgressDrawable = num;
        this.memoryCacheSize = i2;
        this.isInvertColors = z4;
        this.automaticallyInvertColorsForNightTheme = z5;
        this.isToGrayscale = z6;
        this.startZoomScale = f;
        this.maxZoomScale = f2;
        this.shouldZoomOutBounce = z7;
        this.isTextSelectionEnabled = z8;
        this.isFormEditingEnabled = z9;
        this.isAutoSelectNextFormElementEnabled = z10;
        this.isFormElementDateAndTimePickerEnabled = z11;
        this.isAnnotationEditingEnabled = z12;
        this.isAnnotationRotationEnabled = z13;
        this.isContentEditingEnabled = z14;
        this.isMeasurementsEnabled = z15;
        this.isAnnotationLimitedToPageBounds = z16;
        this.useRectangleSelectionForMarkupAnnotations = z17;
        this.editableAnnotationTypes = list;
        this.enabledAnnotationTools = list2;
        this.selectedAnnotationResizeEnabled = z18;
        this.selectedAnnotationResizeGuidesEnabled = z19;
        this.selectedAnnotationFontScalingOnResizeEnabled = z20;
        this.resizeGuideSnapAllowance = f3;
        this.guideLineIntervals = list3;
        this.isAnnotationInspectorEnabled = z21;
        this.excludedAnnotationTypes = list4;
        this.isAutosaveEnabled = z22;
        this.pagePadding = i3;
        this.isLastViewedPageRestorationEnabled = z23;
        this.isAutomaticLinkGenerationEnabled = z24;
        this.isCopyPasteEnabled = z25;
        this.enabledCopyPasteFeatures = enumSet;
        this.isUndoEnabled = z26;
        this.isRedoEnabled = z27;
        this.annotationReplyFeatures = annotationReplyFeatures;
        this.fixedLowResRenderPixelCount = num2;
        this.isMultithreadedRenderingEnabled = z28;
        this.signaturePickerOrientation = signaturePickerOrientation;
        this.signatureSavingStrategy = signatureSavingStrategy;
        this.signatureColorOptions = signatureColorOptions;
        this.signatureCreationModes = list5;
        this.isNoteAnnotationNoZoomHandlingEnabled = z29;
        this.isJavaScriptEnabled = z30;
        this.isTextSelectionPopupToolbarEnabled = z31;
        this.isAnnotationPopupToolbarEnabled = z32;
        this.enabledShareFeatures = enumSet2;
        this.allowMultipleBookmarksPerPage = z33;
        this.scrollOnEdgeTapEnabled = z34;
        this.animateScrollOnEdgeTaps = z35;
        this.scrollOnEdgeTapMargin = i4;
        this.isMagnifierEnabled = z36;
        this.showSignHereOverlay = z37;
        this.showNoteEditorForNewNoteAnnotations = z38;
        this.enableStylusOnDetection = z39;
        this.outlineElementState = outlineElementState;
        this.useCubicInterpolationForInkAnnotations = z40;
        this.isAiAssistantEnabled = z41;
        this.annotationsBlockLinks = z42;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PdfConfiguration copy$default(PdfConfiguration pdfConfiguration, PageScrollDirection pageScrollDirection, PageScrollMode pageScrollMode, PageFitMode pageFitMode, PageLayoutMode pageLayoutMode, ThemeMode themeMode, boolean z, boolean z2, boolean z3, int i, Integer num, int i2, boolean z4, boolean z5, boolean z6, float f, float f2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, List list, List list2, boolean z18, boolean z19, boolean z20, float f3, List list3, boolean z21, List list4, boolean z22, int i3, boolean z23, boolean z24, boolean z25, EnumSet enumSet, boolean z26, boolean z27, AnnotationReplyFeatures annotationReplyFeatures, Integer num2, boolean z28, SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List list5, boolean z29, boolean z30, boolean z31, boolean z32, EnumSet enumSet2, boolean z33, boolean z34, boolean z35, int i4, boolean z36, boolean z37, boolean z38, boolean z39, OutlineElementState outlineElementState, boolean z40, boolean z41, boolean z42, int i5, int i6, int i7, Object obj) {
        boolean z43;
        boolean z44;
        PageScrollDirection pageScrollDirection2 = (i5 & 1) != 0 ? pdfConfiguration.scrollDirection : pageScrollDirection;
        PageScrollMode pageScrollMode2 = (i5 & 2) != 0 ? pdfConfiguration.scrollMode : pageScrollMode;
        PageFitMode pageFitMode2 = (i5 & 4) != 0 ? pdfConfiguration.fitMode : pageFitMode;
        PageLayoutMode pageLayoutMode2 = (i5 & 8) != 0 ? pdfConfiguration.layoutMode : pageLayoutMode;
        ThemeMode themeMode2 = (i5 & 16) != 0 ? pdfConfiguration.themeMode : themeMode;
        boolean z45 = (i5 & 32) != 0 ? pdfConfiguration.isFirstPageAlwaysSingle : z;
        boolean z46 = (i5 & 64) != 0 ? pdfConfiguration.showGapBetweenPages : z2;
        boolean z47 = (i5 & 128) != 0 ? pdfConfiguration.isScrollbarsEnabled : z3;
        int i8 = (i5 & 256) != 0 ? pdfConfiguration.backgroundColor : i;
        Integer num3 = (i5 & 512) != 0 ? pdfConfiguration.loadingProgressDrawable : num;
        int i9 = (i5 & 1024) != 0 ? pdfConfiguration.memoryCacheSize : i2;
        boolean z48 = (i5 & 2048) != 0 ? pdfConfiguration.isInvertColors : z4;
        boolean z49 = (i5 & 4096) != 0 ? pdfConfiguration.automaticallyInvertColorsForNightTheme : z5;
        PageScrollDirection pageScrollDirection3 = pageScrollDirection2;
        boolean z50 = (i5 & 8192) != 0 ? pdfConfiguration.isToGrayscale : z6;
        float f4 = (i5 & 16384) != 0 ? pdfConfiguration.startZoomScale : f;
        float f5 = (i5 & 32768) != 0 ? pdfConfiguration.maxZoomScale : f2;
        boolean z51 = (i5 & 65536) != 0 ? pdfConfiguration.shouldZoomOutBounce : z7;
        boolean z52 = (i5 & 131072) != 0 ? pdfConfiguration.isTextSelectionEnabled : z8;
        boolean z53 = (i5 & 262144) != 0 ? pdfConfiguration.isFormEditingEnabled : z9;
        boolean z54 = (i5 & 524288) != 0 ? pdfConfiguration.isAutoSelectNextFormElementEnabled : z10;
        boolean z55 = (i5 & 1048576) != 0 ? pdfConfiguration.isFormElementDateAndTimePickerEnabled : z11;
        boolean z56 = (i5 & 2097152) != 0 ? pdfConfiguration.isAnnotationEditingEnabled : z12;
        boolean z57 = (i5 & 4194304) != 0 ? pdfConfiguration.isAnnotationRotationEnabled : z13;
        boolean z58 = (i5 & 8388608) != 0 ? pdfConfiguration.isContentEditingEnabled : z14;
        boolean z59 = (i5 & 16777216) != 0 ? pdfConfiguration.isMeasurementsEnabled : z15;
        boolean z60 = (i5 & 33554432) != 0 ? pdfConfiguration.isAnnotationLimitedToPageBounds : z16;
        boolean z61 = (i5 & 67108864) != 0 ? pdfConfiguration.useRectangleSelectionForMarkupAnnotations : z17;
        List list6 = (i5 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? pdfConfiguration.editableAnnotationTypes : list;
        List list7 = (i5 & 268435456) != 0 ? pdfConfiguration.enabledAnnotationTools : list2;
        boolean z62 = (i5 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? pdfConfiguration.selectedAnnotationResizeEnabled : z18;
        boolean z63 = (i5 & 1073741824) != 0 ? pdfConfiguration.selectedAnnotationResizeGuidesEnabled : z19;
        boolean z64 = (i5 & Integer.MIN_VALUE) != 0 ? pdfConfiguration.selectedAnnotationFontScalingOnResizeEnabled : z20;
        float f6 = (i6 & 1) != 0 ? pdfConfiguration.resizeGuideSnapAllowance : f3;
        List list8 = (i6 & 2) != 0 ? pdfConfiguration.guideLineIntervals : list3;
        boolean z65 = (i6 & 4) != 0 ? pdfConfiguration.isAnnotationInspectorEnabled : z21;
        List list9 = (i6 & 8) != 0 ? pdfConfiguration.excludedAnnotationTypes : list4;
        boolean z66 = (i6 & 16) != 0 ? pdfConfiguration.isAutosaveEnabled : z22;
        int i10 = (i6 & 32) != 0 ? pdfConfiguration.pagePadding : i3;
        boolean z67 = (i6 & 64) != 0 ? pdfConfiguration.isLastViewedPageRestorationEnabled : z23;
        boolean z68 = (i6 & 128) != 0 ? pdfConfiguration.isAutomaticLinkGenerationEnabled : z24;
        boolean z69 = (i6 & 256) != 0 ? pdfConfiguration.isCopyPasteEnabled : z25;
        EnumSet enumSet3 = (i6 & 512) != 0 ? pdfConfiguration.enabledCopyPasteFeatures : enumSet;
        boolean z70 = (i6 & 1024) != 0 ? pdfConfiguration.isUndoEnabled : z26;
        boolean z71 = (i6 & 2048) != 0 ? pdfConfiguration.isRedoEnabled : z27;
        AnnotationReplyFeatures annotationReplyFeatures2 = (i6 & 4096) != 0 ? pdfConfiguration.annotationReplyFeatures : annotationReplyFeatures;
        Integer num4 = (i6 & 8192) != 0 ? pdfConfiguration.fixedLowResRenderPixelCount : num2;
        boolean z72 = (i6 & 16384) != 0 ? pdfConfiguration.isMultithreadedRenderingEnabled : z28;
        SignaturePickerOrientation signaturePickerOrientation2 = (i6 & 32768) != 0 ? pdfConfiguration.signaturePickerOrientation : signaturePickerOrientation;
        SignatureSavingStrategy signatureSavingStrategy2 = (i6 & 65536) != 0 ? pdfConfiguration.signatureSavingStrategy : signatureSavingStrategy;
        SignatureColorOptions signatureColorOptions2 = (i6 & 131072) != 0 ? pdfConfiguration.signatureColorOptions : signatureColorOptions;
        List list10 = (i6 & 262144) != 0 ? pdfConfiguration.signatureCreationModes : list5;
        boolean z73 = (i6 & 524288) != 0 ? pdfConfiguration.isNoteAnnotationNoZoomHandlingEnabled : z29;
        boolean z74 = (i6 & 1048576) != 0 ? pdfConfiguration.isJavaScriptEnabled : z30;
        boolean z75 = (i6 & 2097152) != 0 ? pdfConfiguration.isTextSelectionPopupToolbarEnabled : z31;
        boolean z76 = (i6 & 4194304) != 0 ? pdfConfiguration.isAnnotationPopupToolbarEnabled : z32;
        EnumSet enumSet4 = (i6 & 8388608) != 0 ? pdfConfiguration.enabledShareFeatures : enumSet2;
        boolean z77 = (i6 & 16777216) != 0 ? pdfConfiguration.allowMultipleBookmarksPerPage : z33;
        boolean z78 = (i6 & 33554432) != 0 ? pdfConfiguration.scrollOnEdgeTapEnabled : z34;
        boolean z79 = (i6 & 67108864) != 0 ? pdfConfiguration.animateScrollOnEdgeTaps : z35;
        int i11 = (i6 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? pdfConfiguration.scrollOnEdgeTapMargin : i4;
        boolean z80 = (i6 & 268435456) != 0 ? pdfConfiguration.isMagnifierEnabled : z36;
        boolean z81 = (i6 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? pdfConfiguration.showSignHereOverlay : z37;
        boolean z82 = (i6 & 1073741824) != 0 ? pdfConfiguration.showNoteEditorForNewNoteAnnotations : z38;
        boolean z83 = (i6 & Integer.MIN_VALUE) != 0 ? pdfConfiguration.enableStylusOnDetection : z39;
        boolean z84 = z82;
        OutlineElementState outlineElementState2 = (i7 & 1) != 0 ? pdfConfiguration.outlineElementState : outlineElementState;
        boolean z85 = (i7 & 2) != 0 ? pdfConfiguration.useCubicInterpolationForInkAnnotations : z40;
        boolean z86 = (i7 & 4) != 0 ? pdfConfiguration.isAiAssistantEnabled : z41;
        if ((i7 & 8) != 0) {
            z44 = z86;
            z43 = pdfConfiguration.annotationsBlockLinks;
        } else {
            z43 = z42;
            z44 = z86;
        }
        return pdfConfiguration.copy(pageScrollDirection3, pageScrollMode2, pageFitMode2, pageLayoutMode2, themeMode2, z45, z46, z47, i8, num3, i9, z48, z49, z50, f4, f5, z51, z52, z53, z54, z55, z56, z57, z58, z59, z60, z61, list6, list7, z62, z63, z64, f6, list8, z65, list9, z66, i10, z67, z68, z69, enumSet3, z70, z71, annotationReplyFeatures2, num4, z72, signaturePickerOrientation2, signatureSavingStrategy2, signatureColorOptions2, list10, z73, z74, z75, z76, enumSet4, z77, z78, z79, i11, z80, z81, z84, z83, outlineElementState2, z85, z44, z43);
    }

    @Deprecated(message = "The legacy text selection toolbar is deprecated. The popup toolbar will be the only option in a future version.")
    public static /* synthetic */ void isTextSelectionPopupToolbarEnabled$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageScrollDirection getScrollDirection() {
        return this.scrollDirection;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getLoadingProgressDrawable() {
        return this.loadingProgressDrawable;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsInvertColors() {
        return this.isInvertColors;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getAutomaticallyInvertColorsForNightTheme() {
        return this.automaticallyInvertColorsForNightTheme;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsToGrayscale() {
        return this.isToGrayscale;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getStartZoomScale() {
        return this.startZoomScale;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final float getMaxZoomScale() {
        return this.maxZoomScale;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getShouldZoomOutBounce() {
        return this.shouldZoomOutBounce;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getIsTextSelectionEnabled() {
        return this.isTextSelectionEnabled;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getIsFormEditingEnabled() {
        return this.isFormEditingEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PageScrollMode getScrollMode() {
        return this.scrollMode;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIsAutoSelectNextFormElementEnabled() {
        return this.isAutoSelectNextFormElementEnabled;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getIsFormElementDateAndTimePickerEnabled() {
        return this.isFormElementDateAndTimePickerEnabled;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsAnnotationEditingEnabled() {
        return this.isAnnotationEditingEnabled;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getIsAnnotationRotationEnabled() {
        return this.isAnnotationRotationEnabled;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsContentEditingEnabled() {
        return this.isContentEditingEnabled;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getIsMeasurementsEnabled() {
        return this.isMeasurementsEnabled;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getIsAnnotationLimitedToPageBounds() {
        return this.isAnnotationLimitedToPageBounds;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getUseRectangleSelectionForMarkupAnnotations() {
        return this.useRectangleSelectionForMarkupAnnotations;
    }

    public final List<AnnotationType> component28() {
        return this.editableAnnotationTypes;
    }

    public final List<AnnotationTool> component29() {
        return this.enabledAnnotationTools;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageFitMode getFitMode() {
        return this.fitMode;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getSelectedAnnotationResizeEnabled() {
        return this.selectedAnnotationResizeEnabled;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final boolean getSelectedAnnotationResizeGuidesEnabled() {
        return this.selectedAnnotationResizeGuidesEnabled;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final boolean getSelectedAnnotationFontScalingOnResizeEnabled() {
        return this.selectedAnnotationFontScalingOnResizeEnabled;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final float getResizeGuideSnapAllowance() {
        return this.resizeGuideSnapAllowance;
    }

    public final List<Float> component34() {
        return this.guideLineIntervals;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final boolean getIsAnnotationInspectorEnabled() {
        return this.isAnnotationInspectorEnabled;
    }

    public final List<AnnotationType> component36() {
        return this.excludedAnnotationTypes;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getIsAutosaveEnabled() {
        return this.isAutosaveEnabled;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final int getPagePadding() {
        return this.pagePadding;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final boolean getIsLastViewedPageRestorationEnabled() {
        return this.isLastViewedPageRestorationEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PageLayoutMode getLayoutMode() {
        return this.layoutMode;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final boolean getIsAutomaticLinkGenerationEnabled() {
        return this.isAutomaticLinkGenerationEnabled;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final boolean getIsCopyPasteEnabled() {
        return this.isCopyPasteEnabled;
    }

    public final EnumSet<CopyPasteFeatures> component42() {
        return this.enabledCopyPasteFeatures;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final boolean getIsUndoEnabled() {
        return this.isUndoEnabled;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final boolean getIsRedoEnabled() {
        return this.isRedoEnabled;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final AnnotationReplyFeatures getAnnotationReplyFeatures() {
        return this.annotationReplyFeatures;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Integer getFixedLowResRenderPixelCount() {
        return this.fixedLowResRenderPixelCount;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final boolean getIsMultithreadedRenderingEnabled() {
        return this.isMultithreadedRenderingEnabled;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final SignaturePickerOrientation getSignaturePickerOrientation() {
        return this.signaturePickerOrientation;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ThemeMode getThemeMode() {
        return this.themeMode;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final SignatureColorOptions getSignatureColorOptions() {
        return this.signatureColorOptions;
    }

    public final List<SignatureCreationMode> component51() {
        return this.signatureCreationModes;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final boolean getIsNoteAnnotationNoZoomHandlingEnabled() {
        return this.isNoteAnnotationNoZoomHandlingEnabled;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final boolean getIsJavaScriptEnabled() {
        return this.isJavaScriptEnabled;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final boolean getIsTextSelectionPopupToolbarEnabled() {
        return this.isTextSelectionPopupToolbarEnabled;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final boolean getIsAnnotationPopupToolbarEnabled() {
        return this.isAnnotationPopupToolbarEnabled;
    }

    public final EnumSet<ShareFeatures> component56() {
        return this.enabledShareFeatures;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final boolean getAllowMultipleBookmarksPerPage() {
        return this.allowMultipleBookmarksPerPage;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final boolean getScrollOnEdgeTapEnabled() {
        return this.scrollOnEdgeTapEnabled;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final boolean getAnimateScrollOnEdgeTaps() {
        return this.animateScrollOnEdgeTaps;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFirstPageAlwaysSingle() {
        return this.isFirstPageAlwaysSingle;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final int getScrollOnEdgeTapMargin() {
        return this.scrollOnEdgeTapMargin;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final boolean getIsMagnifierEnabled() {
        return this.isMagnifierEnabled;
    }

    /* JADX INFO: renamed from: component62, reason: from getter */
    public final boolean getShowSignHereOverlay() {
        return this.showSignHereOverlay;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final boolean getShowNoteEditorForNewNoteAnnotations() {
        return this.showNoteEditorForNewNoteAnnotations;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final boolean getEnableStylusOnDetection() {
        return this.enableStylusOnDetection;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final OutlineElementState getOutlineElementState() {
        return this.outlineElementState;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final boolean getUseCubicInterpolationForInkAnnotations() {
        return this.useCubicInterpolationForInkAnnotations;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final boolean getIsAiAssistantEnabled() {
        return this.isAiAssistantEnabled;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final boolean getAnnotationsBlockLinks() {
        return this.annotationsBlockLinks;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowGapBetweenPages() {
        return this.showGapBetweenPages;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsScrollbarsEnabled() {
        return this.isScrollbarsEnabled;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final PdfConfiguration copy(PageScrollDirection scrollDirection, PageScrollMode scrollMode, PageFitMode fitMode, PageLayoutMode layoutMode, ThemeMode themeMode, boolean isFirstPageAlwaysSingle, boolean showGapBetweenPages, boolean isScrollbarsEnabled, int backgroundColor, Integer loadingProgressDrawable, int memoryCacheSize, boolean isInvertColors, boolean automaticallyInvertColorsForNightTheme, boolean isToGrayscale, float startZoomScale, float maxZoomScale, boolean shouldZoomOutBounce, boolean isTextSelectionEnabled, boolean isFormEditingEnabled, boolean isAutoSelectNextFormElementEnabled, boolean isFormElementDateAndTimePickerEnabled, boolean isAnnotationEditingEnabled, boolean isAnnotationRotationEnabled, boolean isContentEditingEnabled, boolean isMeasurementsEnabled, boolean isAnnotationLimitedToPageBounds, boolean useRectangleSelectionForMarkupAnnotations, List<? extends AnnotationType> editableAnnotationTypes, List<? extends AnnotationTool> enabledAnnotationTools, boolean selectedAnnotationResizeEnabled, boolean selectedAnnotationResizeGuidesEnabled, boolean selectedAnnotationFontScalingOnResizeEnabled, float resizeGuideSnapAllowance, List<Float> guideLineIntervals, boolean isAnnotationInspectorEnabled, List<? extends AnnotationType> excludedAnnotationTypes, boolean isAutosaveEnabled, int pagePadding, boolean isLastViewedPageRestorationEnabled, boolean isAutomaticLinkGenerationEnabled, boolean isCopyPasteEnabled, EnumSet<CopyPasteFeatures> enabledCopyPasteFeatures, boolean isUndoEnabled, boolean isRedoEnabled, AnnotationReplyFeatures annotationReplyFeatures, Integer fixedLowResRenderPixelCount, boolean isMultithreadedRenderingEnabled, SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List<? extends SignatureCreationMode> signatureCreationModes, boolean isNoteAnnotationNoZoomHandlingEnabled, boolean isJavaScriptEnabled, boolean isTextSelectionPopupToolbarEnabled, boolean isAnnotationPopupToolbarEnabled, EnumSet<ShareFeatures> enabledShareFeatures, boolean allowMultipleBookmarksPerPage, boolean scrollOnEdgeTapEnabled, boolean animateScrollOnEdgeTaps, int scrollOnEdgeTapMargin, boolean isMagnifierEnabled, boolean showSignHereOverlay, boolean showNoteEditorForNewNoteAnnotations, boolean enableStylusOnDetection, OutlineElementState outlineElementState, boolean useCubicInterpolationForInkAnnotations, boolean isAiAssistantEnabled, boolean annotationsBlockLinks) {
        scrollDirection.getClass();
        scrollMode.getClass();
        fitMode.getClass();
        layoutMode.getClass();
        themeMode.getClass();
        editableAnnotationTypes.getClass();
        enabledAnnotationTools.getClass();
        guideLineIntervals.getClass();
        excludedAnnotationTypes.getClass();
        enabledCopyPasteFeatures.getClass();
        annotationReplyFeatures.getClass();
        signaturePickerOrientation.getClass();
        signatureSavingStrategy.getClass();
        signatureColorOptions.getClass();
        signatureCreationModes.getClass();
        enabledShareFeatures.getClass();
        outlineElementState.getClass();
        return new PdfConfiguration(scrollDirection, scrollMode, fitMode, layoutMode, themeMode, isFirstPageAlwaysSingle, showGapBetweenPages, isScrollbarsEnabled, backgroundColor, loadingProgressDrawable, memoryCacheSize, isInvertColors, automaticallyInvertColorsForNightTheme, isToGrayscale, startZoomScale, maxZoomScale, shouldZoomOutBounce, isTextSelectionEnabled, isFormEditingEnabled, isAutoSelectNextFormElementEnabled, isFormElementDateAndTimePickerEnabled, isAnnotationEditingEnabled, isAnnotationRotationEnabled, isContentEditingEnabled, isMeasurementsEnabled, isAnnotationLimitedToPageBounds, useRectangleSelectionForMarkupAnnotations, editableAnnotationTypes, enabledAnnotationTools, selectedAnnotationResizeEnabled, selectedAnnotationResizeGuidesEnabled, selectedAnnotationFontScalingOnResizeEnabled, resizeGuideSnapAllowance, guideLineIntervals, isAnnotationInspectorEnabled, excludedAnnotationTypes, isAutosaveEnabled, pagePadding, isLastViewedPageRestorationEnabled, isAutomaticLinkGenerationEnabled, isCopyPasteEnabled, enabledCopyPasteFeatures, isUndoEnabled, isRedoEnabled, annotationReplyFeatures, fixedLowResRenderPixelCount, isMultithreadedRenderingEnabled, signaturePickerOrientation, signatureSavingStrategy, signatureColorOptions, signatureCreationModes, isNoteAnnotationNoZoomHandlingEnabled, isJavaScriptEnabled, isTextSelectionPopupToolbarEnabled, isAnnotationPopupToolbarEnabled, enabledShareFeatures, allowMultipleBookmarksPerPage, scrollOnEdgeTapEnabled, animateScrollOnEdgeTaps, scrollOnEdgeTapMargin, isMagnifierEnabled, showSignHereOverlay, showNoteEditorForNewNoteAnnotations, enableStylusOnDetection, outlineElementState, useCubicInterpolationForInkAnnotations, isAiAssistantEnabled, annotationsBlockLinks);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PdfConfiguration)) {
            return false;
        }
        PdfConfiguration pdfConfiguration = (PdfConfiguration) other;
        return this.scrollDirection == pdfConfiguration.scrollDirection && this.scrollMode == pdfConfiguration.scrollMode && this.fitMode == pdfConfiguration.fitMode && this.layoutMode == pdfConfiguration.layoutMode && this.themeMode == pdfConfiguration.themeMode && this.isFirstPageAlwaysSingle == pdfConfiguration.isFirstPageAlwaysSingle && this.showGapBetweenPages == pdfConfiguration.showGapBetweenPages && this.isScrollbarsEnabled == pdfConfiguration.isScrollbarsEnabled && this.backgroundColor == pdfConfiguration.backgroundColor && Intrinsics.areEqual(this.loadingProgressDrawable, pdfConfiguration.loadingProgressDrawable) && this.memoryCacheSize == pdfConfiguration.memoryCacheSize && this.isInvertColors == pdfConfiguration.isInvertColors && this.automaticallyInvertColorsForNightTheme == pdfConfiguration.automaticallyInvertColorsForNightTheme && this.isToGrayscale == pdfConfiguration.isToGrayscale && Float.compare(this.startZoomScale, pdfConfiguration.startZoomScale) == 0 && Float.compare(this.maxZoomScale, pdfConfiguration.maxZoomScale) == 0 && this.shouldZoomOutBounce == pdfConfiguration.shouldZoomOutBounce && this.isTextSelectionEnabled == pdfConfiguration.isTextSelectionEnabled && this.isFormEditingEnabled == pdfConfiguration.isFormEditingEnabled && this.isAutoSelectNextFormElementEnabled == pdfConfiguration.isAutoSelectNextFormElementEnabled && this.isFormElementDateAndTimePickerEnabled == pdfConfiguration.isFormElementDateAndTimePickerEnabled && this.isAnnotationEditingEnabled == pdfConfiguration.isAnnotationEditingEnabled && this.isAnnotationRotationEnabled == pdfConfiguration.isAnnotationRotationEnabled && this.isContentEditingEnabled == pdfConfiguration.isContentEditingEnabled && this.isMeasurementsEnabled == pdfConfiguration.isMeasurementsEnabled && this.isAnnotationLimitedToPageBounds == pdfConfiguration.isAnnotationLimitedToPageBounds && this.useRectangleSelectionForMarkupAnnotations == pdfConfiguration.useRectangleSelectionForMarkupAnnotations && Intrinsics.areEqual(this.editableAnnotationTypes, pdfConfiguration.editableAnnotationTypes) && Intrinsics.areEqual(this.enabledAnnotationTools, pdfConfiguration.enabledAnnotationTools) && this.selectedAnnotationResizeEnabled == pdfConfiguration.selectedAnnotationResizeEnabled && this.selectedAnnotationResizeGuidesEnabled == pdfConfiguration.selectedAnnotationResizeGuidesEnabled && this.selectedAnnotationFontScalingOnResizeEnabled == pdfConfiguration.selectedAnnotationFontScalingOnResizeEnabled && Float.compare(this.resizeGuideSnapAllowance, pdfConfiguration.resizeGuideSnapAllowance) == 0 && Intrinsics.areEqual(this.guideLineIntervals, pdfConfiguration.guideLineIntervals) && this.isAnnotationInspectorEnabled == pdfConfiguration.isAnnotationInspectorEnabled && Intrinsics.areEqual(this.excludedAnnotationTypes, pdfConfiguration.excludedAnnotationTypes) && this.isAutosaveEnabled == pdfConfiguration.isAutosaveEnabled && this.pagePadding == pdfConfiguration.pagePadding && this.isLastViewedPageRestorationEnabled == pdfConfiguration.isLastViewedPageRestorationEnabled && this.isAutomaticLinkGenerationEnabled == pdfConfiguration.isAutomaticLinkGenerationEnabled && this.isCopyPasteEnabled == pdfConfiguration.isCopyPasteEnabled && Intrinsics.areEqual(this.enabledCopyPasteFeatures, pdfConfiguration.enabledCopyPasteFeatures) && this.isUndoEnabled == pdfConfiguration.isUndoEnabled && this.isRedoEnabled == pdfConfiguration.isRedoEnabled && this.annotationReplyFeatures == pdfConfiguration.annotationReplyFeatures && Intrinsics.areEqual(this.fixedLowResRenderPixelCount, pdfConfiguration.fixedLowResRenderPixelCount) && this.isMultithreadedRenderingEnabled == pdfConfiguration.isMultithreadedRenderingEnabled && this.signaturePickerOrientation == pdfConfiguration.signaturePickerOrientation && this.signatureSavingStrategy == pdfConfiguration.signatureSavingStrategy && Intrinsics.areEqual(this.signatureColorOptions, pdfConfiguration.signatureColorOptions) && Intrinsics.areEqual(this.signatureCreationModes, pdfConfiguration.signatureCreationModes) && this.isNoteAnnotationNoZoomHandlingEnabled == pdfConfiguration.isNoteAnnotationNoZoomHandlingEnabled && this.isJavaScriptEnabled == pdfConfiguration.isJavaScriptEnabled && this.isTextSelectionPopupToolbarEnabled == pdfConfiguration.isTextSelectionPopupToolbarEnabled && this.isAnnotationPopupToolbarEnabled == pdfConfiguration.isAnnotationPopupToolbarEnabled && Intrinsics.areEqual(this.enabledShareFeatures, pdfConfiguration.enabledShareFeatures) && this.allowMultipleBookmarksPerPage == pdfConfiguration.allowMultipleBookmarksPerPage && this.scrollOnEdgeTapEnabled == pdfConfiguration.scrollOnEdgeTapEnabled && this.animateScrollOnEdgeTaps == pdfConfiguration.animateScrollOnEdgeTaps && this.scrollOnEdgeTapMargin == pdfConfiguration.scrollOnEdgeTapMargin && this.isMagnifierEnabled == pdfConfiguration.isMagnifierEnabled && this.showSignHereOverlay == pdfConfiguration.showSignHereOverlay && this.showNoteEditorForNewNoteAnnotations == pdfConfiguration.showNoteEditorForNewNoteAnnotations && this.enableStylusOnDetection == pdfConfiguration.enableStylusOnDetection && this.outlineElementState == pdfConfiguration.outlineElementState && this.useCubicInterpolationForInkAnnotations == pdfConfiguration.useCubicInterpolationForInkAnnotations && this.isAiAssistantEnabled == pdfConfiguration.isAiAssistantEnabled && this.annotationsBlockLinks == pdfConfiguration.annotationsBlockLinks;
    }

    public final boolean getAllowMultipleBookmarksPerPage() {
        return this.allowMultipleBookmarksPerPage;
    }

    public final boolean getAnimateScrollOnEdgeTaps() {
        return this.animateScrollOnEdgeTaps;
    }

    public final AnnotationReplyFeatures getAnnotationReplyFeatures() {
        return this.annotationReplyFeatures;
    }

    public final boolean getAnnotationsBlockLinks() {
        return this.annotationsBlockLinks;
    }

    public final boolean getAutomaticallyInvertColorsForNightTheme() {
        return this.automaticallyInvertColorsForNightTheme;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<AnnotationType> getEditableAnnotationTypes() {
        return this.editableAnnotationTypes;
    }

    public final boolean getEnableStylusOnDetection() {
        return this.enableStylusOnDetection;
    }

    public final List<AnnotationTool> getEnabledAnnotationTools() {
        return this.enabledAnnotationTools;
    }

    public final EnumSet<CopyPasteFeatures> getEnabledCopyPasteFeatures() {
        return this.enabledCopyPasteFeatures;
    }

    public final EnumSet<ShareFeatures> getEnabledShareFeatures() {
        return this.enabledShareFeatures;
    }

    public final List<AnnotationType> getExcludedAnnotationTypes() {
        return this.excludedAnnotationTypes;
    }

    public final PageFitMode getFitMode() {
        return this.fitMode;
    }

    public final Integer getFixedLowResRenderPixelCount() {
        return this.fixedLowResRenderPixelCount;
    }

    public final List<Float> getGuideLineIntervals() {
        return this.guideLineIntervals;
    }

    public final PageLayoutMode getLayoutMode() {
        return this.layoutMode;
    }

    public final Integer getLoadingProgressDrawable() {
        return this.loadingProgressDrawable;
    }

    public final float getMaxZoomScale() {
        return this.maxZoomScale;
    }

    public final int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public final OutlineElementState getOutlineElementState() {
        return this.outlineElementState;
    }

    public final int getPagePadding() {
        return this.pagePadding;
    }

    public final float getResizeGuideSnapAllowance() {
        return this.resizeGuideSnapAllowance;
    }

    public final PageScrollDirection getScrollDirection() {
        return this.scrollDirection;
    }

    public final PageScrollMode getScrollMode() {
        return this.scrollMode;
    }

    public final boolean getScrollOnEdgeTapEnabled() {
        return this.scrollOnEdgeTapEnabled;
    }

    public final int getScrollOnEdgeTapMargin() {
        return this.scrollOnEdgeTapMargin;
    }

    public final boolean getSelectedAnnotationFontScalingOnResizeEnabled() {
        return this.selectedAnnotationFontScalingOnResizeEnabled;
    }

    public final boolean getSelectedAnnotationResizeEnabled() {
        return this.selectedAnnotationResizeEnabled;
    }

    public final boolean getSelectedAnnotationResizeGuidesEnabled() {
        return this.selectedAnnotationResizeGuidesEnabled;
    }

    public final boolean getShouldZoomOutBounce() {
        return this.shouldZoomOutBounce;
    }

    public final boolean getShowGapBetweenPages() {
        return this.showGapBetweenPages;
    }

    public final boolean getShowNoteEditorForNewNoteAnnotations() {
        return this.showNoteEditorForNewNoteAnnotations;
    }

    public final boolean getShowSignHereOverlay() {
        return this.showSignHereOverlay;
    }

    public final SignatureColorOptions getSignatureColorOptions() {
        return this.signatureColorOptions;
    }

    public final List<SignatureCreationMode> getSignatureCreationModes() {
        return this.signatureCreationModes;
    }

    public final SignaturePickerOrientation getSignaturePickerOrientation() {
        return this.signaturePickerOrientation;
    }

    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    public final float getStartZoomScale() {
        return this.startZoomScale;
    }

    public final ThemeMode getThemeMode() {
        return this.themeMode;
    }

    public final boolean getUseCubicInterpolationForInkAnnotations() {
        return this.useCubicInterpolationForInkAnnotations;
    }

    public final boolean getUseRectangleSelectionForMarkupAnnotations() {
        return this.useRectangleSelectionForMarkupAnnotations;
    }

    public int hashCode() {
        int iA = nd.a(this.backgroundColor, mv.a(this.isScrollbarsEnabled, mv.a(this.showGapBetweenPages, mv.a(this.isFirstPageAlwaysSingle, (this.themeMode.hashCode() + ((this.layoutMode.hashCode() + ((this.fitMode.hashCode() + ((this.scrollMode.hashCode() + (this.scrollDirection.hashCode() * 31)) * 31)) * 31)) * 31)) * 31, 31), 31), 31), 31);
        Integer num = this.loadingProgressDrawable;
        int iHashCode = (this.annotationReplyFeatures.hashCode() + mv.a(this.isRedoEnabled, mv.a(this.isUndoEnabled, (this.enabledCopyPasteFeatures.hashCode() + mv.a(this.isCopyPasteEnabled, mv.a(this.isAutomaticLinkGenerationEnabled, mv.a(this.isLastViewedPageRestorationEnabled, nd.a(this.pagePadding, mv.a(this.isAutosaveEnabled, lv.a(this.excludedAnnotationTypes, mv.a(this.isAnnotationInspectorEnabled, lv.a(this.guideLineIntervals, kv.a(this.resizeGuideSnapAllowance, mv.a(this.selectedAnnotationFontScalingOnResizeEnabled, mv.a(this.selectedAnnotationResizeGuidesEnabled, mv.a(this.selectedAnnotationResizeEnabled, lv.a(this.enabledAnnotationTools, lv.a(this.editableAnnotationTypes, mv.a(this.useRectangleSelectionForMarkupAnnotations, mv.a(this.isAnnotationLimitedToPageBounds, mv.a(this.isMeasurementsEnabled, mv.a(this.isContentEditingEnabled, mv.a(this.isAnnotationRotationEnabled, mv.a(this.isAnnotationEditingEnabled, mv.a(this.isFormElementDateAndTimePickerEnabled, mv.a(this.isAutoSelectNextFormElementEnabled, mv.a(this.isFormEditingEnabled, mv.a(this.isTextSelectionEnabled, mv.a(this.shouldZoomOutBounce, kv.a(this.maxZoomScale, kv.a(this.startZoomScale, mv.a(this.isToGrayscale, mv.a(this.automaticallyInvertColorsForNightTheme, mv.a(this.isInvertColors, nd.a(this.memoryCacheSize, (iA + (num == null ? 0 : num.hashCode())) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31), 31)) * 31;
        Integer num2 = this.fixedLowResRenderPixelCount;
        return Boolean.hashCode(this.annotationsBlockLinks) + mv.a(this.isAiAssistantEnabled, mv.a(this.useCubicInterpolationForInkAnnotations, (this.outlineElementState.hashCode() + mv.a(this.enableStylusOnDetection, mv.a(this.showNoteEditorForNewNoteAnnotations, mv.a(this.showSignHereOverlay, mv.a(this.isMagnifierEnabled, nd.a(this.scrollOnEdgeTapMargin, mv.a(this.animateScrollOnEdgeTaps, mv.a(this.scrollOnEdgeTapEnabled, mv.a(this.allowMultipleBookmarksPerPage, (this.enabledShareFeatures.hashCode() + mv.a(this.isAnnotationPopupToolbarEnabled, mv.a(this.isTextSelectionPopupToolbarEnabled, mv.a(this.isJavaScriptEnabled, mv.a(this.isNoteAnnotationNoZoomHandlingEnabled, lv.a(this.signatureCreationModes, (this.signatureColorOptions.hashCode() + ((this.signatureSavingStrategy.hashCode() + ((this.signaturePickerOrientation.hashCode() + mv.a(this.isMultithreadedRenderingEnabled, (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31, 31)) * 31)) * 31)) * 31, 31), 31), 31), 31), 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31), 31);
    }

    public final boolean isAiAssistantEnabled() {
        return this.isAiAssistantEnabled;
    }

    public final boolean isAnnotationEditingEnabled() {
        return this.isAnnotationEditingEnabled;
    }

    public final boolean isAnnotationInspectorEnabled() {
        return this.isAnnotationInspectorEnabled;
    }

    public final boolean isAnnotationLimitedToPageBounds() {
        return this.isAnnotationLimitedToPageBounds;
    }

    public final boolean isAnnotationPopupToolbarEnabled() {
        return this.isAnnotationPopupToolbarEnabled;
    }

    public final boolean isAnnotationRotationEnabled() {
        return this.isAnnotationRotationEnabled;
    }

    public final boolean isAutoSelectNextFormElementEnabled() {
        return this.isAutoSelectNextFormElementEnabled;
    }

    public final boolean isAutomaticLinkGenerationEnabled() {
        return this.isAutomaticLinkGenerationEnabled;
    }

    public final boolean isAutosaveEnabled() {
        return this.isAutosaveEnabled;
    }

    public final boolean isContentEditingEnabled() {
        return this.isContentEditingEnabled;
    }

    public final boolean isCopyPasteEnabled() {
        return this.isCopyPasteEnabled;
    }

    public final boolean isFirstPageAlwaysSingle() {
        return this.isFirstPageAlwaysSingle;
    }

    public final boolean isFormEditingEnabled() {
        return this.isFormEditingEnabled;
    }

    public final boolean isFormElementDateAndTimePickerEnabled() {
        return this.isFormElementDateAndTimePickerEnabled;
    }

    public final boolean isInvertColors() {
        return this.isInvertColors;
    }

    public final boolean isJavaScriptEnabled() {
        return this.isJavaScriptEnabled;
    }

    public final boolean isLastViewedPageRestorationEnabled() {
        return this.isLastViewedPageRestorationEnabled;
    }

    public final boolean isMagnifierEnabled() {
        return this.isMagnifierEnabled;
    }

    public final boolean isMeasurementsEnabled() {
        return this.isMeasurementsEnabled;
    }

    public final boolean isMultithreadedRenderingEnabled() {
        return this.isMultithreadedRenderingEnabled;
    }

    public final boolean isNoteAnnotationNoZoomHandlingEnabled() {
        return this.isNoteAnnotationNoZoomHandlingEnabled;
    }

    public final boolean isRedoEnabled() {
        return this.isRedoEnabled;
    }

    public final boolean isScrollbarsEnabled() {
        return this.isScrollbarsEnabled;
    }

    public final boolean isTextSelectionEnabled() {
        return this.isTextSelectionEnabled;
    }

    public final boolean isTextSelectionPopupToolbarEnabled() {
        return this.isTextSelectionPopupToolbarEnabled;
    }

    public final boolean isToGrayscale() {
        return this.isToGrayscale;
    }

    public final boolean isUndoEnabled() {
        return this.isUndoEnabled;
    }

    public String toString() {
        return "PdfConfiguration(scrollDirection=" + this.scrollDirection + ", scrollMode=" + this.scrollMode + ", fitMode=" + this.fitMode + ", layoutMode=" + this.layoutMode + ", themeMode=" + this.themeMode + ", isFirstPageAlwaysSingle=" + this.isFirstPageAlwaysSingle + ", showGapBetweenPages=" + this.showGapBetweenPages + ", isScrollbarsEnabled=" + this.isScrollbarsEnabled + ", backgroundColor=" + this.backgroundColor + ", loadingProgressDrawable=" + this.loadingProgressDrawable + ", memoryCacheSize=" + this.memoryCacheSize + ", isInvertColors=" + this.isInvertColors + ", automaticallyInvertColorsForNightTheme=" + this.automaticallyInvertColorsForNightTheme + ", isToGrayscale=" + this.isToGrayscale + ", startZoomScale=" + this.startZoomScale + ", maxZoomScale=" + this.maxZoomScale + ", shouldZoomOutBounce=" + this.shouldZoomOutBounce + ", isTextSelectionEnabled=" + this.isTextSelectionEnabled + ", isFormEditingEnabled=" + this.isFormEditingEnabled + ", isAutoSelectNextFormElementEnabled=" + this.isAutoSelectNextFormElementEnabled + ", isFormElementDateAndTimePickerEnabled=" + this.isFormElementDateAndTimePickerEnabled + ", isAnnotationEditingEnabled=" + this.isAnnotationEditingEnabled + ", isAnnotationRotationEnabled=" + this.isAnnotationRotationEnabled + ", isContentEditingEnabled=" + this.isContentEditingEnabled + ", isMeasurementsEnabled=" + this.isMeasurementsEnabled + ", isAnnotationLimitedToPageBounds=" + this.isAnnotationLimitedToPageBounds + ", useRectangleSelectionForMarkupAnnotations=" + this.useRectangleSelectionForMarkupAnnotations + ", editableAnnotationTypes=" + this.editableAnnotationTypes + ", enabledAnnotationTools=" + this.enabledAnnotationTools + ", selectedAnnotationResizeEnabled=" + this.selectedAnnotationResizeEnabled + ", selectedAnnotationResizeGuidesEnabled=" + this.selectedAnnotationResizeGuidesEnabled + ", selectedAnnotationFontScalingOnResizeEnabled=" + this.selectedAnnotationFontScalingOnResizeEnabled + ", resizeGuideSnapAllowance=" + this.resizeGuideSnapAllowance + ", guideLineIntervals=" + this.guideLineIntervals + ", isAnnotationInspectorEnabled=" + this.isAnnotationInspectorEnabled + ", excludedAnnotationTypes=" + this.excludedAnnotationTypes + ", isAutosaveEnabled=" + this.isAutosaveEnabled + ", pagePadding=" + this.pagePadding + ", isLastViewedPageRestorationEnabled=" + this.isLastViewedPageRestorationEnabled + ", isAutomaticLinkGenerationEnabled=" + this.isAutomaticLinkGenerationEnabled + ", isCopyPasteEnabled=" + this.isCopyPasteEnabled + ", enabledCopyPasteFeatures=" + this.enabledCopyPasteFeatures + ", isUndoEnabled=" + this.isUndoEnabled + ", isRedoEnabled=" + this.isRedoEnabled + ", annotationReplyFeatures=" + this.annotationReplyFeatures + ", fixedLowResRenderPixelCount=" + this.fixedLowResRenderPixelCount + ", isMultithreadedRenderingEnabled=" + this.isMultithreadedRenderingEnabled + ", signaturePickerOrientation=" + this.signaturePickerOrientation + ", signatureSavingStrategy=" + this.signatureSavingStrategy + ", signatureColorOptions=" + this.signatureColorOptions + ", signatureCreationModes=" + this.signatureCreationModes + ", isNoteAnnotationNoZoomHandlingEnabled=" + this.isNoteAnnotationNoZoomHandlingEnabled + ", isJavaScriptEnabled=" + this.isJavaScriptEnabled + ", isTextSelectionPopupToolbarEnabled=" + this.isTextSelectionPopupToolbarEnabled + ", isAnnotationPopupToolbarEnabled=" + this.isAnnotationPopupToolbarEnabled + ", enabledShareFeatures=" + this.enabledShareFeatures + ", allowMultipleBookmarksPerPage=" + this.allowMultipleBookmarksPerPage + ", scrollOnEdgeTapEnabled=" + this.scrollOnEdgeTapEnabled + ", animateScrollOnEdgeTaps=" + this.animateScrollOnEdgeTaps + ", scrollOnEdgeTapMargin=" + this.scrollOnEdgeTapMargin + ", isMagnifierEnabled=" + this.isMagnifierEnabled + ", showSignHereOverlay=" + this.showSignHereOverlay + ", showNoteEditorForNewNoteAnnotations=" + this.showNoteEditorForNewNoteAnnotations + ", enableStylusOnDetection=" + this.enableStylusOnDetection + ", outlineElementState=" + this.outlineElementState + ", useCubicInterpolationForInkAnnotations=" + this.useCubicInterpolationForInkAnnotations + ", isAiAssistantEnabled=" + this.isAiAssistantEnabled + ", annotationsBlockLinks=" + this.annotationsBlockLinks + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.scrollDirection.name());
        dest.writeString(this.scrollMode.name());
        dest.writeString(this.fitMode.name());
        dest.writeString(this.layoutMode.name());
        dest.writeString(this.themeMode.name());
        dest.writeInt(this.isFirstPageAlwaysSingle ? 1 : 0);
        dest.writeInt(this.showGapBetweenPages ? 1 : 0);
        dest.writeInt(this.isScrollbarsEnabled ? 1 : 0);
        dest.writeInt(this.backgroundColor);
        Integer num = this.loadingProgressDrawable;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeInt(this.memoryCacheSize);
        dest.writeInt(this.isInvertColors ? 1 : 0);
        dest.writeInt(this.automaticallyInvertColorsForNightTheme ? 1 : 0);
        dest.writeInt(this.isToGrayscale ? 1 : 0);
        dest.writeFloat(this.startZoomScale);
        dest.writeFloat(this.maxZoomScale);
        dest.writeInt(this.shouldZoomOutBounce ? 1 : 0);
        dest.writeInt(this.isTextSelectionEnabled ? 1 : 0);
        dest.writeInt(this.isFormEditingEnabled ? 1 : 0);
        dest.writeInt(this.isAutoSelectNextFormElementEnabled ? 1 : 0);
        dest.writeInt(this.isFormElementDateAndTimePickerEnabled ? 1 : 0);
        dest.writeInt(this.isAnnotationEditingEnabled ? 1 : 0);
        dest.writeInt(this.isAnnotationRotationEnabled ? 1 : 0);
        dest.writeInt(this.isContentEditingEnabled ? 1 : 0);
        dest.writeInt(this.isMeasurementsEnabled ? 1 : 0);
        dest.writeInt(this.isAnnotationLimitedToPageBounds ? 1 : 0);
        dest.writeInt(this.useRectangleSelectionForMarkupAnnotations ? 1 : 0);
        List<AnnotationType> list = this.editableAnnotationTypes;
        dest.writeInt(list.size());
        Iterator<AnnotationType> it = list.iterator();
        while (it.hasNext()) {
            dest.writeString(it.next().name());
        }
        List<AnnotationTool> list2 = this.enabledAnnotationTools;
        dest.writeInt(list2.size());
        Iterator<AnnotationTool> it2 = list2.iterator();
        while (it2.hasNext()) {
            dest.writeString(it2.next().name());
        }
        dest.writeInt(this.selectedAnnotationResizeEnabled ? 1 : 0);
        dest.writeInt(this.selectedAnnotationResizeGuidesEnabled ? 1 : 0);
        dest.writeInt(this.selectedAnnotationFontScalingOnResizeEnabled ? 1 : 0);
        dest.writeFloat(this.resizeGuideSnapAllowance);
        List<Float> list3 = this.guideLineIntervals;
        dest.writeInt(list3.size());
        Iterator<Float> it3 = list3.iterator();
        while (it3.hasNext()) {
            dest.writeFloat(it3.next().floatValue());
        }
        dest.writeInt(this.isAnnotationInspectorEnabled ? 1 : 0);
        List<AnnotationType> list4 = this.excludedAnnotationTypes;
        dest.writeInt(list4.size());
        Iterator<AnnotationType> it4 = list4.iterator();
        while (it4.hasNext()) {
            dest.writeString(it4.next().name());
        }
        dest.writeInt(this.isAutosaveEnabled ? 1 : 0);
        dest.writeInt(this.pagePadding);
        dest.writeInt(this.isLastViewedPageRestorationEnabled ? 1 : 0);
        dest.writeInt(this.isAutomaticLinkGenerationEnabled ? 1 : 0);
        dest.writeInt(this.isCopyPasteEnabled ? 1 : 0);
        dest.writeSerializable(this.enabledCopyPasteFeatures);
        dest.writeInt(this.isUndoEnabled ? 1 : 0);
        dest.writeInt(this.isRedoEnabled ? 1 : 0);
        dest.writeString(this.annotationReplyFeatures.name());
        Integer num2 = this.fixedLowResRenderPixelCount;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeInt(this.isMultithreadedRenderingEnabled ? 1 : 0);
        dest.writeString(this.signaturePickerOrientation.name());
        dest.writeString(this.signatureSavingStrategy.name());
        dest.writeParcelable(this.signatureColorOptions, flags);
        List<SignatureCreationMode> list5 = this.signatureCreationModes;
        dest.writeInt(list5.size());
        Iterator<SignatureCreationMode> it5 = list5.iterator();
        while (it5.hasNext()) {
            dest.writeString(it5.next().name());
        }
        dest.writeInt(this.isNoteAnnotationNoZoomHandlingEnabled ? 1 : 0);
        dest.writeInt(this.isJavaScriptEnabled ? 1 : 0);
        dest.writeInt(this.isTextSelectionPopupToolbarEnabled ? 1 : 0);
        dest.writeInt(this.isAnnotationPopupToolbarEnabled ? 1 : 0);
        dest.writeSerializable(this.enabledShareFeatures);
        dest.writeInt(this.allowMultipleBookmarksPerPage ? 1 : 0);
        dest.writeInt(this.scrollOnEdgeTapEnabled ? 1 : 0);
        dest.writeInt(this.animateScrollOnEdgeTaps ? 1 : 0);
        dest.writeInt(this.scrollOnEdgeTapMargin);
        dest.writeInt(this.isMagnifierEnabled ? 1 : 0);
        dest.writeInt(this.showSignHereOverlay ? 1 : 0);
        dest.writeInt(this.showNoteEditorForNewNoteAnnotations ? 1 : 0);
        dest.writeInt(this.enableStylusOnDetection ? 1 : 0);
        dest.writeString(this.outlineElementState.name());
        dest.writeInt(this.useCubicInterpolationForInkAnnotations ? 1 : 0);
        dest.writeInt(this.isAiAssistantEnabled ? 1 : 0);
        dest.writeInt(this.annotationsBlockLinks ? 1 : 0);
    }

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b?\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010e\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0017\u0010\u001a\u001a\u00020\u00002\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010fJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010j\u001a\u00020!J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0012J\u0014\u00109\u001a\u00020\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u0002000/J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0012J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010o\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0012J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0012J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0012J\u000e\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u0012J\u0006\u0010w\u001a\u00020\u0000J\u000e\u0010x\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u0016\u0010.\u001a\u00020\u00002\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\u0014\u00101\u001a\u00020\u00002\f\u00101\u001a\b\u0012\u0004\u0012\u0002020/J\u000e\u0010y\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010z\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u0010\u0010|\u001a\u00020\u00002\b\b\u0001\u0010}\u001a\u00020!J\u0016\u0010~\u001a\u00020\u00002\u000e\b\u0001\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020!0/J\u0010\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\u0012J\u000f\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0012J\u0010\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\u0012J\u000f\u0010\u0085\u0001\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0019J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0012J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0012J\u000f\u0010\u0086\u0001\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0012J\u0016\u0010\u0087\u0001\u001a\u00020\u00002\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020A0@J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010E\u001a\u00020FJ\u0015\u0010\u0089\u0001\u001a\u00020\u00002\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0@J\u000f\u0010\u008a\u0001\u001a\u00020\u00002\u0006\u0010h\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NJ\u0016\u0010O\u001a\u00020\u00002\u000e\b\u0001\u0010O\u001a\b\u0012\u0004\u0012\u00020P0/J\u0010\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u0012J\u0010\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\u0012J\u0011\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012H\u0007J\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000f\u0010[\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020\u0012J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000f\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u0012\u0010\u0092\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0019J\u000f\u0010\u0094\u0001\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0012J\u000f\u0010`\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0012J\u0010\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u0012J\u000f\u0010\u0097\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u0012J\u0007\u0010\u0098\u0001\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\b\u0012\u0004\u0012\u00020!0/8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010A0A0@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010H\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010O\u001a\b\u0012\u0004\u0012\u00020P0/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010Y\u001a&\u0012\f\u0012\n B*\u0004\u0018\u00010Z0Z B*\u0012\u0012\f\u0012\n B*\u0004\u0018\u00010Z0Z\u0018\u00010@0@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/pspdfkit/configuration/PdfConfiguration$Builder;", "", "<init>", "()V", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "(Lcom/pspdfkit/configuration/PdfConfiguration;)V", "scrollDirection", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "fitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "scrollMode", "Lcom/pspdfkit/configuration/page/PageScrollMode;", "layoutMode", "Lcom/pspdfkit/configuration/page/PageLayoutMode;", "themeMode", "Lcom/pspdfkit/configuration/theming/ThemeMode;", "enableStylusOnDetection", "", "outlineElementState", "Lcom/pspdfkit/document/OutlineElementState;", "firstPageAlwaysSingle", "showGapBetweenPages", "scrollbarsEnabled", "backgroundColor", "", "loadingProgressDrawable", "Ljava/lang/Integer;", "memoryCacheSize", "invertColors", "automaticallyInvertColorsForNightTheme", "toGrayscale", "startZoomScale", "", "maxZoomScale", "zoomOutBounce", "isTextSelectionEnabled", "isFormEditingEnabled", "isAutoSelectNextFormElementEnabled", "isFormElementDateAndTimePickerEnabled", "isAnnotationEditingEnabled", "isAnnotationRotationEnabled", "isContentEditingEnabled", "isMeasurementsEnabled", "isAnnotationLimitedToPageBounds", "useRectangleSelectionForMarkupAnnotations", "editableAnnotationTypes", "", "Lcom/pspdfkit/annotations/AnnotationType;", "enabledAnnotationTools", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "selectedAnnotationResizeEnabled", "selectedAnnotationResizeGuidesEnabled", "selectedAnnotationFontScalingOnResizeEnabled", "resizeGuideSnapAllowance", "resizeGuideLineIntervals", "isAnnotationInspectorEnabled", "excludedAnnotationTypes", "isAutosaveEnabled", "pagePaddingDp", "restoreLastViewedPage", "automaticallyGenerateLinks", "copyPasteEnabled", "enabledCopyPasteFeatures", "Ljava/util/EnumSet;", "Lcom/pspdfkit/configuration/annotations/CopyPasteFeatures;", "kotlin.jvm.PlatformType", "undoEnabled", "redoEnabled", "annotationReplyFeatures", "Lcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;", "fixedLowResRenderPixelCount", "isMultithreadedRenderingEnabled", "signaturePickerOrientation", "Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "signatureSavingStrategy", "Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "signatureColorOptions", "Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "signatureCreationModes", "Lcom/pspdfkit/configuration/signatures/SignatureCreationMode;", "getSignatureCreationModes", "()Ljava/util/List;", "setSignatureCreationModes", "(Ljava/util/List;)V", "isNoteAnnotationNoZoomHandlingEnabled", "isJavaScriptEnabled", "isTextSelectionPopupToolbarEnabled", "isAnnotationPopupToolbarEnabled", "enabledShareFeatures", "Lcom/pspdfkit/configuration/sharing/ShareFeatures;", "allowMultipleBookmarksPerPage", "scrollOnEdgeTapEnabled", "animateScrollOnEdgeTapsEnabled", "scrollOnEdgeTapMarginDp", "isMagnifierEnabled", "showSignHereOverlay", "showNoteEditorForNewNotes", "useCubicInterpolationForInkAnnotations", "isAiAssistantEnabled", "annotationsBlockLinks", "setFixedLowResRenderPixelCount", "(Ljava/lang/Integer;)Lcom/pspdfkit/configuration/PdfConfiguration$Builder;", "setMultithreadedRenderingEnabled", "orientation", DiagnosisParams.DIAGNOSIS_MODE, "scale", "autosaveEnabled", "textSelectionEnabled", "formEditingEnabled", "enabled", "autoSelectNextFormElementEnabled", "formElementDateAndTimePickerEnabled", "annotationEditingEnabled", "enable", "annotationRotationEnabled", "contentEditingEnabled", "setMeasurementToolsEnabled", "measurementToolsEnabled", "disableAnnotationLimitedToPageBounds", "rectangleSelectionForMarkupAnnotationsEnabled", "setSelectedAnnotationResizeEnabled", "setSelectedAnnotationResizeGuidesEnabled", "setSelectedAnnotationFontScalingOnResizeEnabled", "setResizeGuideSnapAllowance", "snapAllowance", "setResizeGuideLineIntervals", "intervals", "setAnnotationInspectorEnabled", "isEnabled", "setAiAssistantEnabled", "setMarkupAnnotationsBlockLinks", "markupBlocksLink", "pagePadding", "copyPastEnabled", "setEnabledCopyPasteFeatures", "enabledFeatures", "setEnabledShareFeatures", "setSignaturePickerOrientation", "setEnableNoteAnnotationNoZoomHandling", "noZoomHandlingEnabled", "setJavaScriptEnabled", "textSelectionPopupToolbarEnabled", "annotationPopupToolbarEnabled", "allowed", "animateScrollOnEdgeTaps", "scrollOnEdgeTapMargin", "marginDp", "magnifierEnabled", "showOverlay", "showNoteEditorForNewNoteAnnotations", "setOutlineElementState", "build", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean allowMultipleBookmarksPerPage;
        private boolean animateScrollOnEdgeTapsEnabled;
        private AnnotationReplyFeatures annotationReplyFeatures;
        private boolean annotationsBlockLinks;
        private boolean automaticallyGenerateLinks;
        private boolean automaticallyInvertColorsForNightTheme;
        private int backgroundColor;
        private boolean copyPasteEnabled;
        private List<? extends AnnotationType> editableAnnotationTypes;
        private boolean enableStylusOnDetection;
        private List<? extends AnnotationTool> enabledAnnotationTools;
        private EnumSet<CopyPasteFeatures> enabledCopyPasteFeatures;
        private EnumSet<ShareFeatures> enabledShareFeatures;
        private List<? extends AnnotationType> excludedAnnotationTypes;
        private boolean firstPageAlwaysSingle;
        private PageFitMode fitMode;
        private Integer fixedLowResRenderPixelCount;
        private boolean invertColors;
        private boolean isAiAssistantEnabled;
        private boolean isAnnotationEditingEnabled;
        private boolean isAnnotationInspectorEnabled;
        private boolean isAnnotationLimitedToPageBounds;
        private boolean isAnnotationPopupToolbarEnabled;
        private boolean isAnnotationRotationEnabled;
        private boolean isAutoSelectNextFormElementEnabled;
        private boolean isAutosaveEnabled;
        private boolean isContentEditingEnabled;
        private boolean isFormEditingEnabled;
        private boolean isFormElementDateAndTimePickerEnabled;
        private boolean isJavaScriptEnabled;
        private boolean isMagnifierEnabled;
        private boolean isMeasurementsEnabled;
        private boolean isMultithreadedRenderingEnabled;
        private boolean isNoteAnnotationNoZoomHandlingEnabled;
        private boolean isTextSelectionEnabled;
        private boolean isTextSelectionPopupToolbarEnabled;
        private PageLayoutMode layoutMode;
        private Integer loadingProgressDrawable;
        private float maxZoomScale;
        private int memoryCacheSize;
        private OutlineElementState outlineElementState;
        private int pagePaddingDp;
        private boolean redoEnabled;
        private List<Float> resizeGuideLineIntervals;
        private float resizeGuideSnapAllowance;
        private boolean restoreLastViewedPage;
        private PageScrollDirection scrollDirection;
        private PageScrollMode scrollMode;
        private boolean scrollOnEdgeTapEnabled;
        private int scrollOnEdgeTapMarginDp;
        private boolean scrollbarsEnabled;
        private boolean selectedAnnotationFontScalingOnResizeEnabled;
        private boolean selectedAnnotationResizeEnabled;
        private boolean selectedAnnotationResizeGuidesEnabled;
        private boolean showGapBetweenPages;
        private boolean showNoteEditorForNewNotes;
        private boolean showSignHereOverlay;
        private SignatureColorOptions signatureColorOptions;
        private List<? extends SignatureCreationMode> signatureCreationModes;
        private SignaturePickerOrientation signaturePickerOrientation;
        private SignatureSavingStrategy signatureSavingStrategy;
        private float startZoomScale;
        private ThemeMode themeMode;
        private boolean toGrayscale;
        private boolean undoEnabled;
        private boolean useCubicInterpolationForInkAnnotations;
        private boolean useRectangleSelectionForMarkupAnnotations;
        private boolean zoomOutBounce;

        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class EntriesMappings {
            public static final /* synthetic */ EnumEntries<AnnotationTool> entries$0 = EnumEntriesKt.enumEntries(AnnotationTool.values());
        }

        public Builder() {
            this.scrollDirection = PageScrollDirection.HORIZONTAL;
            this.fitMode = PageFitMode.FIT_TO_SCREEN;
            this.scrollMode = PageScrollMode.PER_PAGE;
            this.layoutMode = PageLayoutMode.AUTO;
            this.themeMode = ThemeMode.DEFAULT;
            this.enableStylusOnDetection = true;
            this.outlineElementState = OutlineElementState.DEFAULT;
            this.scrollbarsEnabled = true;
            this.backgroundColor = -1;
            this.loadingProgressDrawable = Integer.MIN_VALUE;
            this.memoryCacheSize = ((int) Runtime.getRuntime().maxMemory()) / 4;
            this.automaticallyInvertColorsForNightTheme = true;
            this.startZoomScale = 1.0f;
            this.maxZoomScale = 26.0f;
            this.zoomOutBounce = true;
            this.isTextSelectionEnabled = true;
            this.isFormEditingEnabled = true;
            this.isFormElementDateAndTimePickerEnabled = true;
            this.isAnnotationEditingEnabled = true;
            this.isAnnotationRotationEnabled = true;
            this.isContentEditingEnabled = true;
            this.isMeasurementsEnabled = true;
            this.isAnnotationLimitedToPageBounds = true;
            this.editableAnnotationTypes = CollectionsKt.emptyList();
            this.enabledAnnotationTools = CollectionsKt.emptyList();
            this.selectedAnnotationResizeEnabled = true;
            this.selectedAnnotationResizeGuidesEnabled = true;
            this.selectedAnnotationFontScalingOnResizeEnabled = true;
            this.resizeGuideSnapAllowance = 30.0f;
            this.resizeGuideLineIntervals = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(5.0f), Float.valueOf(20.0f)});
            this.isAnnotationInspectorEnabled = true;
            this.excludedAnnotationTypes = CollectionsKt.emptyList();
            this.isAutosaveEnabled = true;
            this.pagePaddingDp = 16;
            this.restoreLastViewedPage = true;
            this.copyPasteEnabled = true;
            EnumSet<CopyPasteFeatures> enumSetAllFeatures = CopyPasteFeatures.allFeatures();
            enumSetAllFeatures.getClass();
            this.enabledCopyPasteFeatures = enumSetAllFeatures;
            this.undoEnabled = true;
            this.redoEnabled = true;
            this.annotationReplyFeatures = AnnotationReplyFeatures.ENABLED;
            this.isMultithreadedRenderingEnabled = true;
            this.signaturePickerOrientation = SignaturePickerOrientation.AUTOMATIC;
            this.signatureSavingStrategy = SignatureSavingStrategy.SAVE_IF_SELECTED;
            SignatureColorOptions signatureColorOptionsFromDefaults = SignatureColorOptions.fromDefaults();
            signatureColorOptionsFromDefaults.getClass();
            this.signatureColorOptions = signatureColorOptionsFromDefaults;
            this.signatureCreationModes = CollectionsKt.listOf((Object[]) new SignatureCreationMode[]{SignatureCreationMode.DRAW, SignatureCreationMode.IMAGE, SignatureCreationMode.TYPE});
            this.isJavaScriptEnabled = true;
            this.isTextSelectionPopupToolbarEnabled = true;
            this.isAnnotationPopupToolbarEnabled = true;
            this.enabledShareFeatures = EnumSet.copyOf((Collection) ShareFeatures.getEntries());
            this.scrollOnEdgeTapEnabled = true;
            this.scrollOnEdgeTapMarginDp = 24;
            this.isMagnifierEnabled = true;
            this.showSignHereOverlay = true;
            this.showNoteEditorForNewNotes = true;
            this.useCubicInterpolationForInkAnnotations = true;
        }

        public final Builder allowMultipleBookmarksPerPage(boolean allowed) {
            this.allowMultipleBookmarksPerPage = allowed;
            return this;
        }

        public final Builder animateScrollOnEdgeTaps(boolean enabled) {
            this.animateScrollOnEdgeTapsEnabled = enabled;
            return this;
        }

        public final Builder annotationEditingEnabled(boolean enable) {
            this.isAnnotationEditingEnabled = enable;
            return this;
        }

        public final Builder annotationPopupToolbarEnabled(boolean enabled) {
            this.isAnnotationPopupToolbarEnabled = enabled;
            return this;
        }

        public final Builder annotationReplyFeatures(AnnotationReplyFeatures annotationReplyFeatures) {
            annotationReplyFeatures.getClass();
            this.annotationReplyFeatures = annotationReplyFeatures;
            return this;
        }

        public final Builder annotationRotationEnabled(boolean enable) {
            this.isAnnotationRotationEnabled = enable;
            return this;
        }

        public final Builder autoSelectNextFormElementEnabled(boolean enabled) {
            this.isAutoSelectNextFormElementEnabled = enabled;
            return this;
        }

        public final Builder automaticallyGenerateLinks(boolean automaticallyGenerateLinks) {
            this.automaticallyGenerateLinks = automaticallyGenerateLinks;
            return this;
        }

        public final Builder autosaveEnabled(boolean isAutosaveEnabled) {
            this.isAutosaveEnabled = isAutosaveEnabled;
            return this;
        }

        public final Builder backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public final PdfConfiguration build() {
            List<? extends AnnotationTool> list = this.enabledAnnotationTools;
            if (list.isEmpty()) {
                Set mutableSet = CollectionsKt.toMutableSet(EntriesMappings.entries$0);
                mutableSet.remove(AnnotationTool.INSTANT_COMMENT_MARKER);
                mutableSet.remove(AnnotationTool.INSTANT_HIGHLIGHT_COMMENT);
                list = CollectionsKt.toList(mutableSet);
            }
            List<? extends AnnotationTool> list2 = list;
            PageScrollDirection pageScrollDirection = this.scrollDirection;
            PageScrollMode pageScrollMode = this.scrollMode;
            PageFitMode pageFitMode = this.fitMode;
            PageLayoutMode pageLayoutMode = this.layoutMode;
            ThemeMode themeMode = this.themeMode;
            boolean z = this.firstPageAlwaysSingle;
            boolean z2 = this.showGapBetweenPages;
            boolean z3 = this.scrollbarsEnabled;
            int i = this.backgroundColor;
            Integer num = this.loadingProgressDrawable;
            int i2 = this.memoryCacheSize;
            boolean z4 = this.invertColors;
            boolean z5 = this.automaticallyInvertColorsForNightTheme;
            boolean z6 = this.toGrayscale;
            float f = this.startZoomScale;
            float f2 = this.maxZoomScale;
            boolean z7 = this.zoomOutBounce;
            boolean z8 = this.isTextSelectionEnabled;
            boolean z9 = this.isFormEditingEnabled;
            boolean z10 = this.isAutoSelectNextFormElementEnabled;
            boolean z11 = this.isFormElementDateAndTimePickerEnabled;
            boolean z12 = this.isAnnotationEditingEnabled;
            boolean z13 = this.isAnnotationRotationEnabled;
            boolean z14 = this.isContentEditingEnabled;
            boolean z15 = this.isMeasurementsEnabled;
            boolean z16 = this.isAnnotationLimitedToPageBounds;
            boolean z17 = this.useRectangleSelectionForMarkupAnnotations;
            List<? extends AnnotationType> list3 = this.editableAnnotationTypes;
            boolean z18 = this.selectedAnnotationResizeEnabled;
            boolean z19 = this.selectedAnnotationResizeGuidesEnabled;
            boolean z20 = this.selectedAnnotationFontScalingOnResizeEnabled;
            float f3 = this.resizeGuideSnapAllowance;
            List<Float> list4 = this.resizeGuideLineIntervals;
            boolean z21 = this.isAnnotationInspectorEnabled;
            List<? extends AnnotationType> list5 = this.excludedAnnotationTypes;
            boolean z22 = this.isAutosaveEnabled;
            int i3 = this.pagePaddingDp;
            boolean z23 = this.restoreLastViewedPage;
            boolean z24 = this.automaticallyGenerateLinks;
            boolean z25 = this.copyPasteEnabled;
            EnumSet<CopyPasteFeatures> enumSet = this.enabledCopyPasteFeatures;
            boolean z26 = this.undoEnabled;
            boolean z27 = this.redoEnabled;
            AnnotationReplyFeatures annotationReplyFeatures = this.annotationReplyFeatures;
            Integer num2 = this.fixedLowResRenderPixelCount;
            boolean z28 = this.isMultithreadedRenderingEnabled;
            SignaturePickerOrientation signaturePickerOrientation = this.signaturePickerOrientation;
            SignatureSavingStrategy signatureSavingStrategy = this.signatureSavingStrategy;
            SignatureColorOptions signatureColorOptions = this.signatureColorOptions;
            List<? extends SignatureCreationMode> list6 = this.signatureCreationModes;
            boolean z29 = this.isNoteAnnotationNoZoomHandlingEnabled;
            boolean z30 = this.isJavaScriptEnabled;
            boolean z31 = this.isTextSelectionPopupToolbarEnabled;
            boolean z32 = this.isAnnotationPopupToolbarEnabled;
            EnumSet<ShareFeatures> enumSet2 = this.enabledShareFeatures;
            enumSet2.getClass();
            return new PdfConfiguration(pageScrollDirection, pageScrollMode, pageFitMode, pageLayoutMode, themeMode, z, z2, z3, i, num, i2, z4, z5, z6, f, f2, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, list3, list2, z18, z19, z20, f3, list4, z21, list5, z22, i3, z23, z24, z25, enumSet, z26, z27, annotationReplyFeatures, num2, z28, signaturePickerOrientation, signatureSavingStrategy, signatureColorOptions, list6, z29, z30, z31, z32, enumSet2, this.allowMultipleBookmarksPerPage, this.scrollOnEdgeTapEnabled, this.animateScrollOnEdgeTapsEnabled, this.scrollOnEdgeTapMarginDp, this.isMagnifierEnabled, this.showSignHereOverlay, this.showNoteEditorForNewNotes, this.enableStylusOnDetection, this.outlineElementState, this.useCubicInterpolationForInkAnnotations, this.isAiAssistantEnabled, this.annotationsBlockLinks);
        }

        public final Builder contentEditingEnabled(boolean enable) {
            this.isContentEditingEnabled = enable;
            return this;
        }

        public final Builder copyPastEnabled(boolean enable) {
            this.copyPasteEnabled = enable;
            return this;
        }

        public final Builder disableAnnotationLimitedToPageBounds() {
            this.isAnnotationLimitedToPageBounds = false;
            return this;
        }

        public final Builder editableAnnotationTypes(List<? extends AnnotationType> editableAnnotationTypes) {
            if (editableAnnotationTypes == null) {
                this.editableAnnotationTypes = CollectionsKt.emptyList();
                return this;
            }
            this.editableAnnotationTypes = editableAnnotationTypes;
            return this;
        }

        public final Builder enableStylusOnDetection(boolean enableStylusOnDetection) {
            this.enableStylusOnDetection = enableStylusOnDetection;
            return this;
        }

        public final Builder enabledAnnotationTools(List<? extends AnnotationTool> enabledAnnotationTools) {
            enabledAnnotationTools.getClass();
            this.enabledAnnotationTools = enabledAnnotationTools;
            return this;
        }

        public final Builder excludedAnnotationTypes(List<? extends AnnotationType> excludedAnnotationTypes) {
            excludedAnnotationTypes.getClass();
            this.excludedAnnotationTypes = excludedAnnotationTypes;
            return this;
        }

        public final Builder firstPageAlwaysSingle(boolean firstPageAlwaysSingle) {
            this.firstPageAlwaysSingle = firstPageAlwaysSingle;
            return this;
        }

        public final Builder fitMode(PageFitMode mode) {
            mode.getClass();
            this.fitMode = mode;
            return this;
        }

        public final Builder formEditingEnabled(boolean enabled) {
            this.isFormEditingEnabled = enabled;
            return this;
        }

        public final Builder formElementDateAndTimePickerEnabled(boolean enabled) {
            this.isFormElementDateAndTimePickerEnabled = enabled;
            return this;
        }

        public final List<SignatureCreationMode> getSignatureCreationModes() {
            return this.signatureCreationModes;
        }

        public final Builder invertColors(boolean invertColors) {
            this.invertColors = invertColors;
            return this;
        }

        public final Builder layoutMode(PageLayoutMode mode) {
            mode.getClass();
            this.layoutMode = mode;
            return this;
        }

        public final Builder loadingProgressDrawable(Integer loadingProgressDrawable) {
            this.loadingProgressDrawable = loadingProgressDrawable;
            return this;
        }

        public final Builder magnifierEnabled(boolean enabled) {
            this.isMagnifierEnabled = enabled;
            return this;
        }

        public final Builder maxZoomScale(float scale) {
            this.maxZoomScale = Math.max(1.0f, Math.min(scale, 100.0f));
            return this;
        }

        public final Builder memoryCacheSize(int memoryCacheSize) {
            this.memoryCacheSize = memoryCacheSize;
            return this;
        }

        public final Builder pagePadding(int pagePaddingDp) {
            this.pagePaddingDp = pagePaddingDp;
            return this;
        }

        public final Builder rectangleSelectionForMarkupAnnotationsEnabled(boolean enabled) {
            this.useRectangleSelectionForMarkupAnnotations = enabled;
            return this;
        }

        public final Builder redoEnabled(boolean redoEnabled) {
            this.redoEnabled = redoEnabled && this.undoEnabled;
            return this;
        }

        public final Builder restoreLastViewedPage(boolean restoreLastViewedPage) {
            this.restoreLastViewedPage = restoreLastViewedPage;
            return this;
        }

        public final Builder scrollDirection(PageScrollDirection orientation) {
            orientation.getClass();
            this.scrollDirection = orientation;
            return this;
        }

        public final Builder scrollMode(PageScrollMode mode) {
            mode.getClass();
            this.scrollMode = mode;
            return this;
        }

        public final Builder scrollOnEdgeTapEnabled(boolean enabled) {
            this.scrollOnEdgeTapEnabled = enabled;
            return this;
        }

        public final Builder scrollOnEdgeTapMargin(int marginDp) {
            uw.b(marginDp > 0, "marginDp needs to be at least 1.");
            this.scrollOnEdgeTapMarginDp = marginDp;
            return this;
        }

        public final Builder scrollbarsEnabled(boolean scrollbarsEnabled) {
            this.scrollbarsEnabled = scrollbarsEnabled;
            return this;
        }

        public final Builder setAiAssistantEnabled(boolean isAiAssistantEnabled) {
            this.isAiAssistantEnabled = isAiAssistantEnabled;
            return this;
        }

        public final Builder setAnnotationInspectorEnabled(boolean isEnabled) {
            this.isAnnotationInspectorEnabled = isEnabled;
            return this;
        }

        public final Builder setEnableNoteAnnotationNoZoomHandling(boolean noZoomHandlingEnabled) {
            this.isNoteAnnotationNoZoomHandlingEnabled = noZoomHandlingEnabled;
            return this;
        }

        public final Builder setEnabledCopyPasteFeatures(EnumSet<CopyPasteFeatures> enabledFeatures) {
            enabledFeatures.getClass();
            this.enabledCopyPasteFeatures = enabledFeatures;
            return this;
        }

        public final Builder setEnabledShareFeatures(EnumSet<ShareFeatures> enabledShareFeatures) {
            enabledShareFeatures.getClass();
            this.enabledShareFeatures = EnumSet.copyOf((EnumSet) enabledShareFeatures);
            return this;
        }

        public final Builder setFixedLowResRenderPixelCount(Integer fixedLowResRenderPixelCount) {
            this.fixedLowResRenderPixelCount = fixedLowResRenderPixelCount;
            return this;
        }

        public final Builder setJavaScriptEnabled(boolean isEnabled) {
            this.isJavaScriptEnabled = isEnabled;
            return this;
        }

        public final Builder setMarkupAnnotationsBlockLinks(boolean markupBlocksLink) {
            this.annotationsBlockLinks = markupBlocksLink;
            return this;
        }

        public final Builder setMeasurementToolsEnabled(boolean measurementToolsEnabled) {
            this.isMeasurementsEnabled = measurementToolsEnabled;
            return this;
        }

        public final Builder setMultithreadedRenderingEnabled(boolean isMultithreadedRenderingEnabled) {
            this.isMultithreadedRenderingEnabled = isMultithreadedRenderingEnabled;
            return this;
        }

        public final Builder setOutlineElementState(OutlineElementState outlineElementState) {
            outlineElementState.getClass();
            this.outlineElementState = outlineElementState;
            return this;
        }

        public final Builder setResizeGuideLineIntervals(List<Float> intervals) {
            intervals.getClass();
            if (intervals.size() < 2 || intervals.size() % 2 != 0) {
                throw new IllegalArgumentException(("intervals must contain at least 2 elements and an even number. Found: " + intervals.size()).toString());
            }
            this.resizeGuideLineIntervals = intervals;
            return this;
        }

        public final Builder setResizeGuideSnapAllowance(float snapAllowance) {
            this.resizeGuideSnapAllowance = snapAllowance;
            return this;
        }

        public final Builder setSelectedAnnotationFontScalingOnResizeEnabled(boolean enabled) {
            this.selectedAnnotationFontScalingOnResizeEnabled = enabled;
            return this;
        }

        public final Builder setSelectedAnnotationResizeEnabled(boolean enabled) {
            this.selectedAnnotationResizeEnabled = enabled;
            return this;
        }

        public final Builder setSelectedAnnotationResizeGuidesEnabled(boolean enabled) {
            this.selectedAnnotationResizeGuidesEnabled = enabled;
            return this;
        }

        public final void setSignatureCreationModes(List<? extends SignatureCreationMode> list) {
            list.getClass();
            this.signatureCreationModes = list;
        }

        public final Builder setSignaturePickerOrientation(SignaturePickerOrientation orientation) {
            orientation.getClass();
            this.signaturePickerOrientation = orientation;
            return this;
        }

        public final Builder showGapBetweenPages(boolean showGapBetweenPages) {
            this.showGapBetweenPages = showGapBetweenPages;
            return this;
        }

        public final Builder showNoteEditorForNewNoteAnnotations(boolean showNoteEditorForNewNoteAnnotations) {
            this.showNoteEditorForNewNotes = showNoteEditorForNewNoteAnnotations;
            return this;
        }

        public final Builder showSignHereOverlay(boolean showOverlay) {
            this.showSignHereOverlay = showOverlay;
            return this;
        }

        public final Builder signatureColorOptions(SignatureColorOptions signatureColorOptions) {
            signatureColorOptions.getClass();
            this.signatureColorOptions = signatureColorOptions;
            return this;
        }

        public final Builder signatureCreationModes(List<? extends SignatureCreationMode> signatureCreationModes) {
            signatureCreationModes.getClass();
            PdfConfiguration.INSTANCE.validateSignatureCreationModes$sdk_nutrient(signatureCreationModes);
            this.signatureCreationModes = signatureCreationModes;
            return this;
        }

        public final Builder signatureSavingStrategy(SignatureSavingStrategy signatureSavingStrategy) {
            signatureSavingStrategy.getClass();
            this.signatureSavingStrategy = signatureSavingStrategy;
            return this;
        }

        public final Builder startZoomScale(float startZoomScale) {
            this.startZoomScale = startZoomScale;
            return this;
        }

        public final Builder textSelectionEnabled(boolean isTextSelectionEnabled) {
            this.isTextSelectionEnabled = isTextSelectionEnabled;
            return this;
        }

        @Deprecated(message = "The legacy text selection toolbar is deprecated. The popup toolbar will be the only option in a future version.")
        public final Builder textSelectionPopupToolbarEnabled(boolean enabled) {
            this.isTextSelectionPopupToolbarEnabled = enabled;
            return this;
        }

        public final Builder themeMode(ThemeMode mode) {
            mode.getClass();
            this.themeMode = mode;
            return this;
        }

        public final Builder toGrayscale(boolean toGrayscale) {
            this.toGrayscale = toGrayscale;
            return this;
        }

        public final Builder undoEnabled(boolean undoEnabled) {
            this.undoEnabled = undoEnabled;
            if (!undoEnabled) {
                this.redoEnabled = false;
            }
            return this;
        }

        public final Builder useCubicInterpolationForInkAnnotations(boolean useCubicInterpolationForInkAnnotations) {
            this.useCubicInterpolationForInkAnnotations = useCubicInterpolationForInkAnnotations;
            return this;
        }

        public final Builder zoomOutBounce(boolean zoomOutBounce) {
            this.zoomOutBounce = zoomOutBounce;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(message = "v2024.8: Will be removed in a future version.", replaceWith = @ReplaceWith(expression = "PdfConfiguration.copy", imports = {}))
        public Builder(PdfConfiguration pdfConfiguration) {
            this();
            pdfConfiguration.getClass();
            this.scrollDirection = pdfConfiguration.getScrollDirection();
            this.scrollMode = pdfConfiguration.getScrollMode();
            this.fitMode = pdfConfiguration.getFitMode();
            this.layoutMode = pdfConfiguration.getLayoutMode();
            this.themeMode = pdfConfiguration.getThemeMode();
            this.firstPageAlwaysSingle = pdfConfiguration.isFirstPageAlwaysSingle();
            this.showGapBetweenPages = pdfConfiguration.getShowGapBetweenPages();
            this.scrollbarsEnabled = pdfConfiguration.isScrollbarsEnabled();
            this.backgroundColor = pdfConfiguration.getBackgroundColor();
            this.loadingProgressDrawable = pdfConfiguration.getLoadingProgressDrawable();
            this.invertColors = pdfConfiguration.isInvertColors();
            this.toGrayscale = pdfConfiguration.isToGrayscale();
            this.isAutosaveEnabled = pdfConfiguration.isAutosaveEnabled();
            this.isTextSelectionEnabled = pdfConfiguration.isTextSelectionEnabled();
            this.isFormEditingEnabled = pdfConfiguration.isFormEditingEnabled();
            this.isAutoSelectNextFormElementEnabled = pdfConfiguration.isAutoSelectNextFormElementEnabled();
            this.isFormElementDateAndTimePickerEnabled = pdfConfiguration.isFormElementDateAndTimePickerEnabled();
            this.isAnnotationEditingEnabled = pdfConfiguration.isAnnotationEditingEnabled();
            this.isAnnotationRotationEnabled = pdfConfiguration.isAnnotationRotationEnabled();
            this.isContentEditingEnabled = pdfConfiguration.isContentEditingEnabled();
            this.isMeasurementsEnabled = pdfConfiguration.isMeasurementsEnabled();
            this.isAnnotationLimitedToPageBounds = pdfConfiguration.isAnnotationLimitedToPageBounds();
            this.useRectangleSelectionForMarkupAnnotations = pdfConfiguration.getUseRectangleSelectionForMarkupAnnotations();
            this.editableAnnotationTypes = pdfConfiguration.getEditableAnnotationTypes();
            this.enabledAnnotationTools = pdfConfiguration.getEnabledAnnotationTools();
            this.selectedAnnotationResizeEnabled = pdfConfiguration.getSelectedAnnotationResizeEnabled();
            this.selectedAnnotationResizeGuidesEnabled = pdfConfiguration.getSelectedAnnotationResizeGuidesEnabled();
            this.selectedAnnotationFontScalingOnResizeEnabled = pdfConfiguration.getSelectedAnnotationFontScalingOnResizeEnabled();
            this.resizeGuideSnapAllowance = pdfConfiguration.getResizeGuideSnapAllowance();
            this.resizeGuideLineIntervals = pdfConfiguration.getGuideLineIntervals();
            this.isAnnotationInspectorEnabled = pdfConfiguration.isAnnotationInspectorEnabled();
            this.excludedAnnotationTypes = pdfConfiguration.getExcludedAnnotationTypes();
            this.pagePaddingDp = pdfConfiguration.getPagePadding();
            this.restoreLastViewedPage = pdfConfiguration.isLastViewedPageRestorationEnabled();
            this.memoryCacheSize = pdfConfiguration.getMemoryCacheSize();
            this.startZoomScale = pdfConfiguration.getStartZoomScale();
            this.maxZoomScale = pdfConfiguration.getMaxZoomScale();
            this.zoomOutBounce = pdfConfiguration.getShouldZoomOutBounce();
            this.automaticallyGenerateLinks = pdfConfiguration.isAutomaticLinkGenerationEnabled();
            this.copyPasteEnabled = pdfConfiguration.isCopyPasteEnabled();
            this.undoEnabled = pdfConfiguration.isUndoEnabled();
            this.redoEnabled = pdfConfiguration.isRedoEnabled();
            this.signaturePickerOrientation = pdfConfiguration.getSignaturePickerOrientation();
            this.signatureSavingStrategy = pdfConfiguration.getSignatureSavingStrategy();
            this.signatureColorOptions = pdfConfiguration.getSignatureColorOptions();
            this.signatureCreationModes = pdfConfiguration.getSignatureCreationModes();
            this.fixedLowResRenderPixelCount = pdfConfiguration.getFixedLowResRenderPixelCount();
            this.isMultithreadedRenderingEnabled = pdfConfiguration.isMultithreadedRenderingEnabled();
            this.enabledCopyPasteFeatures = pdfConfiguration.getEnabledCopyPasteFeatures();
            this.isNoteAnnotationNoZoomHandlingEnabled = pdfConfiguration.isNoteAnnotationNoZoomHandlingEnabled();
            this.annotationReplyFeatures = pdfConfiguration.getAnnotationReplyFeatures();
            this.isJavaScriptEnabled = pdfConfiguration.isJavaScriptEnabled();
            this.isTextSelectionPopupToolbarEnabled = pdfConfiguration.isTextSelectionPopupToolbarEnabled();
            this.isAnnotationPopupToolbarEnabled = pdfConfiguration.isAnnotationPopupToolbarEnabled();
            this.enabledShareFeatures = EnumSet.copyOf((EnumSet) pdfConfiguration.getEnabledShareFeatures());
            this.allowMultipleBookmarksPerPage = pdfConfiguration.getAllowMultipleBookmarksPerPage();
            this.scrollOnEdgeTapEnabled = pdfConfiguration.getScrollOnEdgeTapEnabled();
            this.animateScrollOnEdgeTapsEnabled = pdfConfiguration.getAnimateScrollOnEdgeTaps();
            this.scrollOnEdgeTapMarginDp = pdfConfiguration.getScrollOnEdgeTapMargin();
            this.isMagnifierEnabled = pdfConfiguration.isMagnifierEnabled();
            this.enableStylusOnDetection = pdfConfiguration.getEnableStylusOnDetection();
            this.outlineElementState = pdfConfiguration.getOutlineElementState();
            this.useCubicInterpolationForInkAnnotations = pdfConfiguration.getUseCubicInterpolationForInkAnnotations();
            this.isAiAssistantEnabled = pdfConfiguration.isAiAssistantEnabled();
            this.annotationsBlockLinks = pdfConfiguration.getAnnotationsBlockLinks();
        }
    }
}
