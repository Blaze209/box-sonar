package com.box.android.coreservices.models;

import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.jobcollections.DeleteBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.ExportBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.coreservices.jobmanager.jobs.ExportBoxJob;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.coreservices.jobmanager.tasks.DeleteTask;
import com.box.android.coreservices.jobmanager.tasks.ExportTask;
import com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareExportTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareOfflineTask;
import com.box.android.coreservices.jobmanager.tasks.RemoveOfflineTask;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPersistableObjectUtility.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/box/android/coreservices/models/BoxPersistableObjectUtility;", "", "<init>", "()V", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPersistableObjectUtility {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Map<String, BoxPersistableObject.BoxPersistableEntityCreator> ENTITY_ADDON_MAP;

    @JvmStatic
    public static final BoxPersistableObject createEntityFromJson(JsonObject jsonObject) {
        return INSTANCE.createEntityFromJson(jsonObject);
    }

    @JvmStatic
    public static final BoxPersistableObject createEntityFromJson(String str) {
        return INSTANCE.createEntityFromJson(str);
    }

    /* JADX INFO: compiled from: BoxPersistableObjectUtility.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/coreservices/models/BoxPersistableObjectUtility$Companion;", "", "<init>", "()V", "ENTITY_ADDON_MAP", "", "", "Lcom/box/android/coreservices/models/BoxPersistableObject$BoxPersistableEntityCreator;", "addEntityType", "", "type", "creator", "createEntityFromJson", "Lcom/box/android/coreservices/models/BoxPersistableObject;", "json", "Lcom/eclipsesource/json/JsonObject;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addEntityType(String type, BoxPersistableObject.BoxPersistableEntityCreator creator) {
            BoxPersistableObjectUtility.ENTITY_ADDON_MAP.put(type, creator);
        }

        @JvmStatic
        public final BoxPersistableObject createEntityFromJson(JsonObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("type");
            if (!jsonValue.isString()) {
                return null;
            }
            BoxPersistableObject.BoxPersistableEntityCreator boxPersistableEntityCreator = (BoxPersistableObject.BoxPersistableEntityCreator) BoxPersistableObjectUtility.ENTITY_ADDON_MAP.get(jsonValue.asString());
            BoxPersistableObject boxPersistableObjectCreateEntity = boxPersistableEntityCreator != null ? boxPersistableEntityCreator.createEntity() : null;
            if (boxPersistableObjectCreateEntity != null) {
                boxPersistableObjectCreateEntity.createFromJson(json);
            }
            return boxPersistableObjectCreateEntity;
        }

        @JvmStatic
        public final BoxPersistableObject createEntityFromJson(String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonObject from = JsonObject.readFrom(json);
            Intrinsics.checkNotNull(from);
            return createEntityFromJson(from);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        ENTITY_ADDON_MAP = new LinkedHashMap();
        companion.addEntityType(PrepareOfflineTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$0();
            }
        });
        companion.addEntityType(RemoveOfflineTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda11
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$1();
            }
        });
        companion.addEntityType(ExportTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda12
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$2();
            }
        });
        companion.addEntityType(PrepareExportTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda13
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$3();
            }
        });
        companion.addEntityType(JobCollectionList.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda14
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$4();
            }
        });
        companion.addEntityType(DeleteTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$5();
            }
        });
        companion.addEntityType(OfflinePreviewTask.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda2
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$6();
            }
        });
        companion.addEntityType(OfflineBoxJobCollection.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda3
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$7();
            }
        });
        companion.addEntityType(RemoveOfflineBoxJobCollection.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda4
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$8();
            }
        });
        companion.addEntityType(ExportBoxJobCollection.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda5
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$9();
            }
        });
        companion.addEntityType(DeleteBoxJobCollection.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda6
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$10();
            }
        });
        companion.addEntityType(OfflineBoxJob.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda7
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$11();
            }
        });
        companion.addEntityType(RemoveOfflineBoxJob.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda8
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$12();
            }
        });
        companion.addEntityType(ExportBoxJob.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda9
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$13();
            }
        });
        companion.addEntityType(DeleteBoxJob.TYPE, new BoxPersistableObject.BoxPersistableEntityCreator() { // from class: com.box.android.coreservices.models.BoxPersistableObjectUtility$$ExternalSyntheticLambda10
            @Override // com.box.android.coreservices.models.BoxPersistableObject.BoxPersistableEntityCreator
            public final BoxPersistableObject createEntity() {
                return BoxPersistableObjectUtility._init_$lambda$14();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$0() {
        return new PrepareOfflineTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$1() {
        return new RemoveOfflineTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$2() {
        return new ExportTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$3() {
        return new PrepareExportTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$4() {
        return new JobCollectionList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$5() {
        return new DeleteTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$6() {
        return new OfflinePreviewTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$7() {
        return new OfflineBoxJobCollection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$8() {
        return new RemoveOfflineBoxJobCollection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$9() {
        return new ExportBoxJobCollection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$10() {
        return new DeleteBoxJobCollection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$11() {
        return new OfflineBoxJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$12() {
        return new RemoveOfflineBoxJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$13() {
        return new ExportBoxJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxPersistableObject _init_$lambda$14() {
        return new DeleteBoxJob();
    }
}
