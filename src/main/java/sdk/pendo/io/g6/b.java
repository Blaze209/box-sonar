package sdk.pendo.io.g6;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.GuideStatus;
import sdk.pendo.io.network.guides.GuideActor;
import sdk.pendo.io.q3.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR6\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/g6/b;", "", "Lsdk/pendo/io/models/GuideModel;", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/network/guides/GuideActor;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "actors", "<init>", "(Landroid/content/Context;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final HashMap<String, GuideActor> actors;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/models/GuideStatus;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/models/GuideStatus;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<GuideStatus, Boolean> {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(GuideStatus guideStatus) {
            return Boolean.valueOf(guideStatus.getStatus() == GuideStatus.INSTANCE.getREADY());
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.g6.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/models/GuideStatus;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/models/GuideStatus;)V"}, k = 3, mv = {1, 9, 0})
    static final class C0388b extends Lambda implements Function1<GuideStatus, Unit> {
        final /* synthetic */ GuideModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0388b(GuideModel guideModel) {
            super(1);
            this.b = guideModel;
        }

        public final void a(GuideStatus guideStatus) {
            b.this.a().remove(this.b.getGuideId());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuideStatus guideStatus) {
            a(guideStatus);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/models/GuideStatus;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/models/GuideStatus;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<GuideStatus, Boolean> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(GuideStatus guideStatus) {
            return Boolean.valueOf(guideStatus.getStatus() == GuideStatus.INSTANCE.getREADY());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/models/GuideStatus;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/models/GuideStatus;)V"}, k = 3, mv = {1, 9, 0})
    static final class d extends Lambda implements Function1<GuideStatus, Unit> {
        final /* synthetic */ GuideModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(GuideModel guideModel) {
            super(1);
            this.b = guideModel;
        }

        public final void a(GuideStatus guideStatus) {
            b.this.a().remove(this.b.getGuideId());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuideStatus guideStatus) {
            a(guideStatus);
            return Unit.INSTANCE;
        }
    }

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.actors = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final HashMap<String, GuideActor> a() {
        return this.actors;
    }

    public final void a(final GuideModel guide) {
        Intrinsics.checkNotNullParameter(guide, "guide");
        GuideActor guideActor = new GuideActor(guide, GuidesManager.INSTANCE, this.context);
        HashMap<String, GuideActor> map = this.actors;
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        map.put(guideId, guideActor);
        j<GuideStatus> status = guide.getStatus();
        final a aVar = a.a;
        g<GuideStatus> gVarF = status.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return b.a(aVar, obj);
            }
        }).f();
        final C0388b c0388b = new C0388b(guide);
        gVarF.a(new e() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                b.b(c0388b, obj);
            }
        });
        guide.getStatus().a(new sdk.pendo.io.q3.a() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.a
            public final void run() {
                b.a(this.f$0, guide);
            }
        });
        guideActor.prepareGuideContent();
    }

    public final void b(final GuideModel guide) {
        Intrinsics.checkNotNullParameter(guide, "guide");
        GuideActor guideActor = new GuideActor(guide, GuidesManager.INSTANCE, this.context);
        HashMap<String, GuideActor> map = this.actors;
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        map.put(guideId, guideActor);
        j<GuideStatus> status = guide.getStatus();
        final c cVar = c.a;
        g<GuideStatus> gVarF = status.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return b.c(cVar, obj);
            }
        }).f();
        final d dVar = new d(guide);
        gVarF.a(new e() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                b.d(dVar, obj);
            }
        });
        guide.getStatus().a(new sdk.pendo.io.q3.a() { // from class: sdk.pendo.io.g6.b$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.q3.a
            public final void run() {
                b.b(this.f$0, guide);
            }
        });
        guideActor.prepareGuideImages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0, GuideModel guide) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guide, "$guide");
        this$0.actors.remove(guide.getGuideId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b this$0, GuideModel guide) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guide, "$guide");
        this$0.actors.remove(guide.getGuideId());
    }
}
