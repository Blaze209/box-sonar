package com.box.android.data.api.models.inboxnotifications;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = false)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\nR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001b\u0010\nR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001f\u0010\nR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010\nR!\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b'\u0010\nR\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "<init>", "()V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "sendSharedLinkAdapter", "Lcom/box/android/data/api/models/inboxnotifications/SendSharedLinkPayloadDTOInbox;", "getSendSharedLinkAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "sendSharedLinkAdapter$delegate", "Lkotlin/Lazy;", "collabInviteAdapter", "Lcom/box/android/data/api/models/inboxnotifications/CollabInvitePayloadDTOInbox;", "getCollabInviteAdapter", "collabInviteAdapter$delegate", "atMentionAdapter", "Lcom/box/android/data/api/models/inboxnotifications/AtMentionPayloadDTOInbox;", "getAtMentionAdapter", "atMentionAdapter$delegate", "notifyCollabAdapter", "Lcom/box/android/data/api/models/inboxnotifications/NotifyCollabPayloadDTOInbox;", "getNotifyCollabAdapter", "notifyCollabAdapter$delegate", "taskUpdatedAdapter", "Lcom/box/android/data/api/models/inboxnotifications/TaskUpdatedPayloadDTOInbox;", "getTaskUpdatedAdapter", "taskUpdatedAdapter$delegate", "commentAdapter", "Lcom/box/android/data/api/models/inboxnotifications/CommentPayloadDTOInbox;", "getCommentAdapter", "commentAdapter$delegate", "editFileAdapter", "Lcom/box/android/data/api/models/inboxnotifications/EditFilePayloadDTOInbox;", "getEditFileAdapter", "editFileAdapter$delegate", "commonAdapter", "Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "getCommonAdapter", "commonAdapter$delegate", "moshi", "Lcom/squareup/moshi/Moshi;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationPayloadAdapter extends JsonAdapter<InboxNotificationPayloadDTO> {

    /* JADX INFO: renamed from: atMentionAdapter$delegate, reason: from kotlin metadata */
    private final Lazy atMentionAdapter;

    /* JADX INFO: renamed from: collabInviteAdapter$delegate, reason: from kotlin metadata */
    private final Lazy collabInviteAdapter;

    /* JADX INFO: renamed from: commentAdapter$delegate, reason: from kotlin metadata */
    private final Lazy commentAdapter;

    /* JADX INFO: renamed from: commonAdapter$delegate, reason: from kotlin metadata */
    private final Lazy commonAdapter;

    /* JADX INFO: renamed from: editFileAdapter$delegate, reason: from kotlin metadata */
    private final Lazy editFileAdapter;
    private Moshi moshi;

    /* JADX INFO: renamed from: notifyCollabAdapter$delegate, reason: from kotlin metadata */
    private final Lazy notifyCollabAdapter;
    private final JsonReader.Options options;

    /* JADX INFO: renamed from: sendSharedLinkAdapter$delegate, reason: from kotlin metadata */
    private final Lazy sendSharedLinkAdapter;

    /* JADX INFO: renamed from: taskUpdatedAdapter$delegate, reason: from kotlin metadata */
    private final Lazy taskUpdatedAdapter;

    public InboxNotificationPayloadAdapter() {
        JsonReader.Options optionsOf = JsonReader.Options.of("type");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        this.sendSharedLinkAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.sendSharedLinkAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.collabInviteAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.collabInviteAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.atMentionAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.atMentionAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.notifyCollabAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.notifyCollabAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.taskUpdatedAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.taskUpdatedAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.commentAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.commentAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.editFileAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.editFileAdapter_delegate$lambda$0(this.f$0);
            }
        });
        this.commonAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadAdapter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InboxNotificationPayloadAdapter.commonAdapter_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: compiled from: InboxNotificationPayloadAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadAdapter$Factory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Factory implements JsonAdapter.Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            if (!Intrinsics.areEqual(Types.getRawType(type), InboxNotificationPayloadDTO.class)) {
                return null;
            }
            InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter = new InboxNotificationPayloadAdapter();
            inboxNotificationPayloadAdapter.moshi = moshi;
            return inboxNotificationPayloadAdapter;
        }
    }

    private final JsonAdapter<SendSharedLinkPayloadDTOInbox> getSendSharedLinkAdapter() {
        Object value = this.sendSharedLinkAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter sendSharedLinkAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(SendSharedLinkPayloadDTOInbox.class);
    }

    private final JsonAdapter<CollabInvitePayloadDTOInbox> getCollabInviteAdapter() {
        Object value = this.collabInviteAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter collabInviteAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(CollabInvitePayloadDTOInbox.class);
    }

    private final JsonAdapter<AtMentionPayloadDTOInbox> getAtMentionAdapter() {
        Object value = this.atMentionAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter atMentionAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(AtMentionPayloadDTOInbox.class);
    }

    private final JsonAdapter<NotifyCollabPayloadDTOInbox> getNotifyCollabAdapter() {
        Object value = this.notifyCollabAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter notifyCollabAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(NotifyCollabPayloadDTOInbox.class);
    }

    private final JsonAdapter<TaskUpdatedPayloadDTOInbox> getTaskUpdatedAdapter() {
        Object value = this.taskUpdatedAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter taskUpdatedAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(TaskUpdatedPayloadDTOInbox.class);
    }

    private final JsonAdapter<CommentPayloadDTOInbox> getCommentAdapter() {
        Object value = this.commentAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter commentAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(CommentPayloadDTOInbox.class);
    }

    private final JsonAdapter<EditFilePayloadDTOInbox> getEditFileAdapter() {
        Object value = this.editFileAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter editFileAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(EditFilePayloadDTOInbox.class);
    }

    private final JsonAdapter<CommonPayloadDTOInbox> getCommonAdapter() {
        Object value = this.commonAdapter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter commonAdapter_delegate$lambda$0(InboxNotificationPayloadAdapter inboxNotificationPayloadAdapter) {
        Moshi moshi = inboxNotificationPayloadAdapter.moshi;
        if (moshi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
            moshi = null;
        }
        return moshi.adapter(CommonPayloadDTOInbox.class);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.squareup.moshi.JsonAdapter
    public InboxNotificationPayloadDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Object jsonValue = reader.readJsonValue();
        Map map = jsonValue instanceof Map ? (Map) jsonValue : null;
        if (map == null) {
            return null;
        }
        Object obj = map.get("type");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            throw new JsonDataException("Payload type is missing.");
        }
        switch (str.hashCode()) {
            case -606856649:
                if (str.equals("atMention")) {
                    return getAtMentionAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 343013287:
                if (str.equals("sendSharedLink")) {
                    return getSendSharedLinkAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 950398559:
                if (str.equals("comment")) {
                    return getCommentAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 1006950582:
                if (str.equals("notifyCollab")) {
                    return getNotifyCollabAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 1141034358:
                if (str.equals("collabInvite")) {
                    return getCollabInviteAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 1183984539:
                if (str.equals("commonCard")) {
                    return getCommonAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 1601618598:
                if (str.equals("editFile")) {
                    return getEditFileAdapter().fromJsonValue(jsonValue);
                }
                return null;
            case 2048397028:
                if (str.equals("taskStatusUpdated")) {
                    return getTaskUpdatedAdapter().fromJsonValue(jsonValue);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, InboxNotificationPayloadDTO value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == 0) {
            writer.nullValue();
            return;
        }
        if (value instanceof SendSharedLinkPayloadDTOInbox) {
            getSendSharedLinkAdapter().toJson(writer, value);
            return;
        }
        if (value instanceof CollabInvitePayloadDTOInbox) {
            getCollabInviteAdapter().toJson(writer, value);
            return;
        }
        if (value instanceof AtMentionPayloadDTOInbox) {
            getAtMentionAdapter().toJson(writer, value);
            return;
        }
        if (value instanceof NotifyCollabPayloadDTOInbox) {
            getNotifyCollabAdapter().toJson(writer, value);
            return;
        }
        if (value instanceof TaskUpdatedPayloadDTOInbox) {
            getTaskUpdatedAdapter().toJson(writer, value);
            return;
        }
        if (value instanceof CommentPayloadDTOInbox) {
            getCommentAdapter().toJson(writer, value);
        } else if (value instanceof EditFilePayloadDTOInbox) {
            getEditFileAdapter().toJson(writer, value);
        } else {
            if (!(value instanceof CommonPayloadDTOInbox)) {
                throw new NoWhenBranchMatchedException();
            }
            getCommonAdapter().toJson(writer, value);
        }
    }
}
