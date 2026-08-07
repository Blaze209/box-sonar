package sdk.pendo.io.v6;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.events.ComposeIdentificationData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.s7.y0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 n2\u00020\u0001:\u0001\u0004BY\u0012\u0006\u0010j\u001a\u00020(\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0006\u0010k\u001a\u00020R\u0012\u0018\b\u0002\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00000!j\b\u0012\u0004\u0012\u00020\u0000`\"¢\u0006\u0004\bl\u0010mJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000H\u0002J\u000f\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0001J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0016\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rR0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR'\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00000!j\b\u0012\u0004\u0012\u00020\u0000`\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R(\u0010/\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00100\u001a\u0004\b1\u00102\"\u0004\b+\u00103R$\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b\u0004\u00103R$\u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00100\u001a\u0004\b9\u00102\"\u0004\b:\u00103R$\u0010=\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00100\u001a\u0004\b)\u00102\"\u0004\b\u0006\u00103R$\u0010?\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00100\u001a\u0004\b>\u00102\"\u0004\b\u0016\u00103R$\u0010A\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u00100\u001a\u0004\b@\u00102\"\u0004\b)\u00103R$\u0010B\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b<\u00102\"\u0004\b#\u00103R$\u0010D\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00100\u001a\u0004\bC\u00102\"\u0004\b>\u00103R$\u0010F\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00100\u001a\u0004\bE\u00102\"\u0004\b<\u00103R$\u0010G\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00100\u001a\u0004\b:\u00102\"\u0004\b8\u00103R$\u0010\u0005\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010H\u001a\u0004\b8\u0010I\"\u0004\bJ\u0010KR\"\u0010Q\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\b\u0004\u0010PR\"\u0010X\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\b\u0006\u0010U\"\u0004\bV\u0010WR\"\u0010[\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\b\u0004\u0010U\"\u0004\bZ\u0010WR(\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u00100\u001a\u0004\be\u00102\"\u0004\b5\u00103R2\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\f0!j\b\u0012\u0004\u0012\u00020\f`\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010$\u001a\u0004\b5\u0010%\"\u0004\b\u0004\u0010h¨\u0006o"}, d2 = {"Lsdk/pendo/io/v6/a;", "", "child", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "parent", "b", "o", "()V", "layoutNode", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Ljava/lang/Object;)Landroidx/compose/ui/layout/MeasurePolicy;", "", "", "n", "", "toString", "forCapture", "includeTexts", "Lsdk/pendo/io/events/ComposeIdentificationData;", "", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "data", "I", "getIndexInParent", "()I", "setIndexInParent", "(I)V", IdentificationData.FIELD_INDEX_IN_PARENT, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "children", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/semantics/SemanticsNode;", "d", "Ljava/lang/ref/WeakReference;", "j", "()Ljava/lang/ref/WeakReference;", "setSemanticsNodeRef", "(Ljava/lang/ref/WeakReference;)V", "semanticsNodeRef", "Ljava/lang/String;", "getTextBase64", "()Ljava/lang/String;", "(Ljava/lang/String;)V", IdentificationData.FIELD_TEXT_BASE64, "f", "getContentDescriptionBase64", "contentDescriptionBase64", "g", CmcdData.OBJECT_TYPE_MANIFEST, "k", "textHash", CmcdData.STREAMING_FORMAT_HLS, "contentDescriptionHash", "i", "pendoTagHash", "getPendoTagBase64", ComposeIdentificationData.PENDO_TAG_BASE64, ComposeIdentificationData.PENDO_TAG_HASHED, CmcdData.STREAM_TYPE_LIVE, "testTagHash", "getTestTagBase64", ComposeIdentificationData.FIELD_TEST_TAG_BASE64, ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "Lsdk/pendo/io/v6/a;", "()Lsdk/pendo/io/v6/a;", "setParent", "(Lsdk/pendo/io/v6/a;)V", "p", "Z", "getClickable", "()Z", "(Z)V", "clickable", "Landroidx/compose/ui/geometry/Rect;", "q", "Landroidx/compose/ui/geometry/Rect;", "()Landroidx/compose/ui/geometry/Rect;", "setBoundsInWindow", "(Landroidx/compose/ui/geometry/Rect;)V", "boundsInWindow", "r", "setBoundsInScreen", "boundsInScreen", "", "s", "Ljava/util/List;", "getHierarchy", "()Ljava/util/List;", "setHierarchy", "(Ljava/util/List;)V", ComposeIdentificationData.HIERARCHY, "t", "getPredicate", IdentificationData.PREDICATE, "u", "(Ljava/util/ArrayList;)V", ComposeIdentificationData.FIELD_DEPTH, "semanticsNode", "rootPositionOnScreen", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;Lsdk/pendo/io/v6/a;ILandroidx/compose/ui/geometry/Rect;Ljava/util/ArrayList;)V", "v", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Map<String, ? extends Object> data;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private int indexInParent;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ArrayList<a> children;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private WeakReference<SemanticsNode> semanticsNodeRef;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private String textBase64;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String contentDescriptionBase64;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private String textHash;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private String contentDescriptionHash;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private String pendoTagHash;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private String pendoTagBase64;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private String pendoTag;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private String testTagHash;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private String testTagBase64;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private String testTag;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private a parent;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private boolean clickable;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private Rect boundsInWindow;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private Rect boundsInScreen;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private List<String> hierarchy;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private String predicate;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private ArrayList<Integer> depth;

    /* JADX INFO: renamed from: sdk.pendo.io.v6.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u0018\u0010\f\u001a\u00020\n2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u0018\u0010\r\u001a\u00020\n2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002J\u0010\u0010\u0006\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/v6/a$a;", "", "", "", "data", CmcdData.STREAMING_FORMAT_HLS, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "e", "g", "f", "", "d", "b", "c", "text", "Lsdk/pendo/io/v6/f;", "TAG", "Ljava/lang/String;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(String text) {
            String string = text != null ? StringsKt.trim((CharSequence) text).toString() : null;
            if (string == null || StringsKt.isBlank(string)) {
                return new f(null, null);
            }
            try {
                String strA = y0.a(string);
                sdk.pendo.io.v7.a aVar = sdk.pendo.io.v7.a.a;
                Intrinsics.checkNotNull(strA);
                String strA2 = aVar.a(strA);
                if (!v0.a(strA) && !v0.a(strA2)) {
                    return new f(strA, strA2);
                }
                return new f(null, null);
            } catch (Exception e) {
                PendoLogger.d("ComposeElement", "encodeAndHash " + e.getMessage() + " " + e.getStackTrace());
                return new f(null, null);
            }
        }

        public final boolean b(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.get("EditableText") != null;
        }

        public final boolean c(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.get("Selected") != null;
        }

        public final boolean d(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.get("ToggleableState") != null;
        }

        public final String e(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = data.get("pendoTagKey");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String f(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = data.get("Role");
            String string = obj != null ? obj.toString() : null;
            if (string == null || string.length() == 0 || Intrinsics.areEqual(string, "Unknown")) {
                return null;
            }
            return string;
        }

        public final String g(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = data.get("TestTag");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String h(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = data.get("Text");
            List list = obj instanceof List ? (List) obj : null;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object obj2 = list.get(0);
            if (obj2 instanceof AnnotatedString) {
                return ((AnnotatedString) obj2).getText();
            }
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            if (obj2 instanceof CharSequence) {
                return obj2.toString();
            }
            return null;
        }

        public final String a(Map<String, ?> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Object obj = data.get("ContentDescription");
            List list = obj instanceof List ? (List) obj : null;
            if (list != null && (!list.isEmpty())) {
                Object obj2 = list.get(0);
                if (obj2 instanceof String) {
                    return (String) obj2;
                }
            }
            return null;
        }
    }

    public a(SemanticsNode semanticsNode, Map<String, ? extends Object> data, a aVar, int i, Rect rootPositionOnScreen, ArrayList<a> children) {
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rootPositionOnScreen, "rootPositionOnScreen");
        Intrinsics.checkNotNullParameter(children, "children");
        this.data = data;
        this.indexInParent = i;
        this.children = children;
        this.semanticsNodeRef = new WeakReference<>(semanticsNode);
        this.boundsInWindow = new Rect(semanticsNode.getBoundsInWindow().getLeft(), semanticsNode.getBoundsInWindow().getTop(), semanticsNode.getBoundsInWindow().getRight(), semanticsNode.getBoundsInWindow().getBottom());
        this.boundsInScreen = new Rect(rootPositionOnScreen.getLeft() + this.boundsInWindow.getLeft(), rootPositionOnScreen.getTop() + this.boundsInWindow.getTop(), rootPositionOnScreen.getLeft() + this.boundsInWindow.getRight(), rootPositionOnScreen.getTop() + this.boundsInWindow.getBottom());
        this.hierarchy = new ArrayList();
        this.depth = new ArrayList<>();
        b(aVar);
        b.a(semanticsNode, this);
        o();
        b.d(this);
        b.e(this);
        b.f(this);
    }

    private final void a(a child) {
        this.children.add(child);
    }

    private final void b(a parent) {
        this.parent = parent;
        if (parent != null) {
            parent.a(this);
        }
    }

    public final ArrayList<a> c() {
        return this.children;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getContentDescriptionHash() {
        return this.contentDescriptionHash;
    }

    public final Map<String, Object> e() {
        return this.data;
    }

    public final ArrayList<Integer> f() {
        return this.depth;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final a getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getPendoTag() {
        return this.pendoTag;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getPendoTagHash() {
        return this.pendoTagHash;
    }

    public final WeakReference<SemanticsNode> j() {
        return this.semanticsNodeRef;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getTestTag() {
        return this.testTag;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getTestTagHash() {
        return this.testTagHash;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getTextHash() {
        return this.textHash;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getClickable() {
        return this.clickable;
    }

    public final void o() {
        a aVar = this.parent;
        if (aVar != null) {
            this.hierarchy = CollectionsKt.toMutableList((Collection) aVar.hierarchy);
        }
        String str = this.predicate;
        if (str != null) {
            this.hierarchy.add(str);
        }
    }

    public String toString() {
        return "[...\nBounds in screen: " + this.boundsInScreen + " \nBounds in window: " + this.boundsInWindow + " \nData: " + this.data + " \nHierarchy: " + this.hierarchy + " \nPredicate: " + this.predicate + " \nDepth: " + this.depth + " \n...]";
    }

    public /* synthetic */ a(SemanticsNode semanticsNode, Map map, a aVar, int i, Rect rect, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(semanticsNode, map, aVar, i, rect, (i2 & 32) != 0 ? new ArrayList() : arrayList);
    }

    public final ComposeIdentificationData a(boolean forCapture, boolean includeTexts) {
        ComposeIdentificationData composeIdentificationData = new ComposeIdentificationData();
        if (includeTexts) {
            String strA = y0.a(this.textHash, 8);
            String strA2 = y0.a(this.contentDescriptionHash, 8);
            composeIdentificationData.setTextHashed(strA);
            composeIdentificationData.setAccessibilityHashed(strA2);
            if (forCapture) {
                composeIdentificationData.setTextBase64(this.textBase64);
                composeIdentificationData.setAccessibilityBase64(this.contentDescriptionBase64);
            }
        }
        String str = this.pendoTagHash;
        if (str != null) {
            composeIdentificationData.setPendoTagHashed(str);
        }
        String str2 = this.testTagHash;
        if (str2 != null) {
            composeIdentificationData.setTestTagHashed(str2);
        }
        if (forCapture) {
            String str3 = this.pendoTagBase64;
            if (str3 != null) {
                composeIdentificationData.setPendoTagBase64(str3);
            }
            String str4 = this.testTagBase64;
            if (str4 != null) {
                composeIdentificationData.setTestTagBase64(str4);
            }
        }
        composeIdentificationData.setIndexInParent(Integer.valueOf(this.indexInParent));
        Companion companion = INSTANCE;
        composeIdentificationData.setRole(companion.f(this.data));
        composeIdentificationData.setPredicate(this.predicate);
        composeIdentificationData.setHierarchy(this.hierarchy);
        composeIdentificationData.setDepth(this.depth);
        composeIdentificationData.setIsSelectable(companion.c(this.data));
        composeIdentificationData.setIsToggleable(companion.d(this.data));
        composeIdentificationData.setIsEditableText(companion.b(this.data));
        return composeIdentificationData;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Rect getBoundsInWindow() {
        return this.boundsInWindow;
    }

    public final void c(String str) {
        this.pendoTag = str;
    }

    public final void d(String str) {
        this.pendoTagBase64 = str;
    }

    public final void e(String str) {
        this.pendoTagHash = str;
    }

    public final void f(String str) {
        this.predicate = str;
    }

    public final void g(String str) {
        this.testTag = str;
    }

    public final void h(String str) {
        this.testTagBase64 = str;
    }

    public final void i(String str) {
        this.testTagHash = str;
    }

    public final void j(String str) {
        this.textBase64 = str;
    }

    public final void k(String str) {
        this.textHash = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Rect getBoundsInScreen() {
        return this.boundsInScreen;
    }

    public final MeasurePolicy b(Object layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        try {
            Field declaredField = layoutNode.getClass().getDeclaredField("measurePolicy");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(layoutNode);
            if (obj instanceof MeasurePolicy) {
                return (MeasurePolicy) obj;
            }
            return null;
        } catch (Exception e) {
            PendoLogger.d("ComposeElement", "getMeasurePolicy failed - error: " + e);
            return null;
        }
    }

    public final int a(Object layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        try {
            Field declaredField = layoutNode.getClass().getDeclaredField(ComposeIdentificationData.FIELD_DEPTH);
            declaredField.setAccessible(true);
            return declaredField.getInt(layoutNode);
        } catch (Exception e) {
            PendoLogger.d("ComposeElement", "getDepthField failed - error: " + e);
            return -1;
        }
    }

    public final void b(String str) {
        this.contentDescriptionHash = str;
    }

    public final void a(boolean z) {
        this.clickable = z;
    }

    public final void a(String str) {
        this.contentDescriptionBase64 = str;
    }

    public final void a(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.depth = arrayList;
    }
}
