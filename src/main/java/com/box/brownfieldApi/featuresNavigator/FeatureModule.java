package com.box.brownfieldApi.featuresNavigator;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureModule.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0014"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;", "", "moduleName", "", "topics", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getModuleName", "()Ljava/lang/String;", "getTopics", "()Ljava/util/List;", "AGENT_GALLERY", "AI_CENTER", "AI_PROMPT_LIBRARY", "HUB_DETAILS", "UNIT_TESTS", "hasTopics", "", "Companion", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum FeatureModule {
    AGENT_GALLERY("agent-gallery", CollectionsKt.emptyList()),
    AI_CENTER("ai-center", CollectionsKt.listOf("session_changed")),
    AI_PROMPT_LIBRARY("ai-prompt-library", CollectionsKt.listOf((Object[]) new String[]{"prompt_selected", "prompt_cancelled"})),
    HUB_DETAILS("hub-details", CollectionsKt.emptyList()),
    UNIT_TESTS("unit-tests", CollectionsKt.emptyList());

    private final String moduleName;
    private final List<String> topics;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<FeatureModule> getEntries() {
        return $ENTRIES;
    }

    FeatureModule(String str, List list) {
        this.moduleName = str;
        this.topics = list;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    /* synthetic */ FeatureModule(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getTopics() {
        return this.topics;
    }

    public final boolean hasTopics() {
        return !this.topics.isEmpty();
    }

    /* JADX INFO: compiled from: FeatureModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/FeatureModule$Companion;", "", "<init>", "()V", "fromModuleName", "Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;", "name", "", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FeatureModule fromModuleName(String name) {
            FeatureModule next;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterator<FeatureModule> it = FeatureModule.getEntries().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(next.getModuleName(), name)) {
                    return next;
                }
            }
            next = null;
            return next;
        }
    }
}
