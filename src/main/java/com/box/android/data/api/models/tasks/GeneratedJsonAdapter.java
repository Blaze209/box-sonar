package com.box.android.data.api.models.tasks;

import com.box.boxandroidlibv2private.model.BoxTask;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.tasks.CreateTaskDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: CreateTaskDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/tasks/CreateTaskDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/tasks/CreateTaskDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "taskBodyDTOAdapter", "Lcom/box/android/data/api/models/tasks/TaskBodyDTO;", "listOfAssigneeTargetDTOAdapter", "", "Lcom/box/android/data/api/models/tasks/AssigneeTargetDTO;", "listOfTaskLinkTargetDTOAdapter", "Lcom/box/android/data/api/models/tasks/TaskLinkTargetDTO;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<CreateTaskDTO> {
    private final JsonAdapter<List<AssigneeTargetDTO>> listOfAssigneeTargetDTOAdapter;
    private final JsonAdapter<List<TaskLinkTargetDTO>> listOfTaskLinkTargetDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<TaskBodyDTO> taskBodyDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("task", BoxTask.FIELD_ASSIGNMENT_COLLABORATORS, BoxTask.FIELD_TASK_LINKS);
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<TaskBodyDTO> jsonAdapterAdapter = moshi.adapter(TaskBodyDTO.class, SetsKt.emptySet(), "task");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.taskBodyDTOAdapter = jsonAdapterAdapter;
        JsonAdapter<List<AssigneeTargetDTO>> jsonAdapterAdapter2 = moshi.adapter(Types.newParameterizedType(List.class, AssigneeTargetDTO.class), SetsKt.emptySet(), "assignedTo");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.listOfAssigneeTargetDTOAdapter = jsonAdapterAdapter2;
        JsonAdapter<List<TaskLinkTargetDTO>> jsonAdapterAdapter3 = moshi.adapter(Types.newParameterizedType(List.class, TaskLinkTargetDTO.class), SetsKt.emptySet(), "taskLinks");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.listOfTaskLinkTargetDTOAdapter = jsonAdapterAdapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(CreateTaskDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CreateTaskDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        TaskBodyDTO taskBodyDTOFromJson = null;
        List<AssigneeTargetDTO> listFromJson = null;
        List<TaskLinkTargetDTO> listFromJson2 = null;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                taskBodyDTOFromJson = this.taskBodyDTOAdapter.fromJson(reader);
                if (taskBodyDTOFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("task", "task", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
            } else if (iSelectName == 1) {
                listFromJson = this.listOfAssigneeTargetDTOAdapter.fromJson(reader);
                if (listFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("assignedTo", BoxTask.FIELD_ASSIGNMENT_COLLABORATORS, reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull2;
                }
            } else if (iSelectName == 2 && (listFromJson2 = this.listOfTaskLinkTargetDTOAdapter.fromJson(reader)) == null) {
                JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("taskLinks", BoxTask.FIELD_TASK_LINKS, reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                throw jsonDataExceptionUnexpectedNull3;
            }
        }
        reader.endObject();
        if (taskBodyDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("task", "task", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty;
        }
        if (listFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("assignedTo", BoxTask.FIELD_ASSIGNMENT_COLLABORATORS, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty2;
        }
        if (listFromJson2 != null) {
            return new CreateTaskDTO(taskBodyDTOFromJson, listFromJson, listFromJson2);
        }
        JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("taskLinks", BoxTask.FIELD_TASK_LINKS, reader);
        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
        throw jsonDataExceptionMissingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CreateTaskDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("task");
        this.taskBodyDTOAdapter.toJson(writer, value_.getTask());
        writer.name(BoxTask.FIELD_ASSIGNMENT_COLLABORATORS);
        this.listOfAssigneeTargetDTOAdapter.toJson(writer, value_.getAssignedTo());
        writer.name(BoxTask.FIELD_TASK_LINKS);
        this.listOfTaskLinkTargetDTOAdapter.toJson(writer, value_.getTaskLinks());
        writer.endObject();
    }
}
