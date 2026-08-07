package sdk.pendo.io;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sdk.pendo.io.events.ComposeIdentificationData;
import sdk.pendo.io.v6.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\"\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0007\u001a\u0018\u0010%\u001a\u00020#*\u00020#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007\u001a\u001e\u0010\u001e\u001a\u00020#*\u00020#2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\" \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n\"/\u0010\u0012\u001a\u00020\u0006*\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\"/\u0010\u001a\u001a\u00020\u0006*\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017\"/\u0010\u001e\u001a\u00020\u0006*\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006*"}, d2 = {"MAX_SCREEN_ID_LENGTH", "", "VALID_SCREEN_ID_REGEX", "Lkotlin/text/Regex;", "pendoScreenModifierKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getPendoScreenModifierKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "setPendoScreenModifierKey", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)V", "pendoStateModifierKey", "getPendoStateModifierKey", "setPendoStateModifierKey", "pendoTagKey", "getPendoTagKey", "setPendoTagKey", "<set-?>", "pendoRootNodeToScan", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getPendoRootNodeToScan", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setPendoRootNodeToScan", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "pendoRootNodeToScan$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "pendoScreen", "getPendoScreen", "setPendoScreen", "pendoScreen$delegate", ComposeIdentificationData.PENDO_TAG_HASHED, "getPendoTag", "setPendoTag", "pendoTag$delegate", "pendoScreenId", "Landroidx/compose/ui/Modifier;", "screenId", "pendoStateModifier", "state", "", "mergeDescendants", "", "pendoIO_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PendoJetpackComposeKt {
    private static final int MAX_SCREEN_ID_LENGTH = 100;
    private static final Regex VALID_SCREEN_ID_REGEX;
    private static final SemanticsPropertyKey pendoRootNodeToScan$delegate;
    private static final SemanticsPropertyKey pendoScreen$delegate;
    private static SemanticsPropertyKey<String> pendoScreenModifierKey;
    private static final SemanticsPropertyKey pendoTag$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PendoJetpackComposeKt.class, ComposeIdentificationData.PENDO_TAG_HASHED, "getPendoTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PendoJetpackComposeKt.class, "pendoRootNodeToScan", "getPendoRootNodeToScan(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(PendoJetpackComposeKt.class, "pendoScreen", "getPendoScreen(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1))};
    private static SemanticsPropertyKey<String> pendoTagKey = new SemanticsPropertyKey<>("pendoTagKey", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static SemanticsPropertyKey<String> pendoStateModifierKey = new SemanticsPropertyKey<>("pendoStateModifierKey", (Function2) null, 2, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.a = str;
        }

        public final void a(SemanticsPropertyReceiver semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            PendoJetpackComposeKt.setPendoScreen(semantics, this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
        public static final b a = new b();

        b() {
            super(1);
        }

        public final void a(SemanticsPropertyReceiver semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            PendoJetpackComposeKt.setPendoRootNodeToScan(semantics, "pendoStateComposable");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.a = str;
        }

        public final void a(SemanticsPropertyReceiver semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            PendoJetpackComposeKt.setPendoTag(semantics, this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }
    }

    static {
        SemanticsPropertyKey<String> semanticsPropertyKey = new SemanticsPropertyKey<>("pendoScreenIdModifierKey", (Function2) null, 2, (DefaultConstructorMarker) null);
        pendoScreenModifierKey = semanticsPropertyKey;
        pendoTag$delegate = pendoTagKey;
        pendoRootNodeToScan$delegate = pendoStateModifierKey;
        pendoScreen$delegate = semanticsPropertyKey;
        VALID_SCREEN_ID_REGEX = new Regex("^[a-zA-Z0-9._-]+$");
    }

    private static final String getPendoRootNodeToScan(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (String) pendoRootNodeToScan$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    private static final String getPendoScreen(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (String) pendoScreen$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[2]);
    }

    public static final SemanticsPropertyKey<String> getPendoScreenModifierKey() {
        return pendoScreenModifierKey;
    }

    public static final SemanticsPropertyKey<String> getPendoStateModifierKey() {
        return pendoStateModifierKey;
    }

    private static final String getPendoTag(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return (String) pendoTag$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final SemanticsPropertyKey<String> getPendoTagKey() {
        return pendoTagKey;
    }

    public static final Modifier pendoScreenId(Modifier modifier, String screenId) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        String string = StringsKt.trim((CharSequence) screenId).toString();
        if (string.length() <= 0) {
            throw new IllegalArgumentException("screenId must not be blank".toString());
        }
        if (string.length() > 100) {
            throw new IllegalArgumentException("screenId must not exceed 100 characters".toString());
        }
        if (VALID_SCREEN_ID_REGEX.matches(string)) {
            return SemanticsModifierKt.semantics$default(modifier, false, new a(string), 1, null);
        }
        throw new IllegalArgumentException("screenId must contain only alphanumeric characters, underscores, hyphens, or dots".toString());
    }

    public static final Modifier pendoStateModifier(Modifier modifier, Object obj) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (obj != null) {
            j.a.a(obj);
        }
        return SemanticsModifierKt.semantics$default(modifier, false, b.a, 1, null);
    }

    public static /* synthetic */ Modifier pendoStateModifier$default(Modifier modifier, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return pendoStateModifier(modifier, obj);
    }

    public static final Modifier pendoTag(Modifier modifier, String pendoTagKey2, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(pendoTagKey2, "pendoTagKey");
        return SemanticsModifierKt.semantics(modifier, z, new c(pendoTagKey2));
    }

    public static /* synthetic */ Modifier pendoTag$default(Modifier modifier, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pendoTag(modifier, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPendoRootNodeToScan(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        pendoRootNodeToScan$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[1], str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPendoScreen(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        pendoScreen$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void setPendoScreenModifierKey(SemanticsPropertyKey<String> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "<set-?>");
        pendoScreenModifierKey = semanticsPropertyKey;
    }

    public static final void setPendoStateModifierKey(SemanticsPropertyKey<String> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "<set-?>");
        pendoStateModifierKey = semanticsPropertyKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPendoTag(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        pendoTag$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], str);
    }

    public static final void setPendoTagKey(SemanticsPropertyKey<String> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "<set-?>");
        pendoTagKey = semanticsPropertyKey;
    }
}
