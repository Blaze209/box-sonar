package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiMetadata extends BoxApi {
    public static final String BOX_API_METADATA = "metadata";
    public static final String BOX_API_METADATA_SCHEMA = "schema";
    public static final String BOX_API_METADATA_TEMPLATES = "metadata_templates";
    public static final String BOX_API_SCOPE_ENTERPRISE = "enterprise";
    public static final String BOX_API_SCOPE_GLOBAL = "global";

    public BoxApiMetadata(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getFilesUrl() {
        return String.format(Locale.ENGLISH, "%s/files", getBaseUri());
    }

    protected String getFoldersUrl() {
        return String.format(Locale.ENGLISH, "%s/folders", getBaseUri());
    }

    protected String getFileInfoUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFilesUrl(), str);
    }

    protected String getFileMetadataUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFileInfoUrl(str), "metadata");
    }

    protected String getFileMetadataUrl(String str, String str2, String str3) {
        return String.format(Locale.ENGLISH, "%s/%s/%s", getFileMetadataUrl(str), str2, str3);
    }

    protected String getFileMetadataUrl(String str, String str2) {
        return getFileMetadataUrl(str, "enterprise", str2);
    }

    protected String getMetadataTemplatesUrl(String str) {
        return String.format(Locale.ENGLISH, "%s/%s/%s", getBaseUri(), BOX_API_METADATA_TEMPLATES, str);
    }

    protected String getMetadataTemplatesUrl() {
        return getMetadataTemplatesUrl("enterprise");
    }

    protected String getMetadataTemplatesUrl(String str, String str2) {
        return String.format(Locale.ENGLISH, "%s/%s/%s", getMetadataTemplatesUrl(str), str2, BOX_API_METADATA_SCHEMA);
    }

    protected String getFolderInfoUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFoldersUrl(), str);
    }

    protected String getFolderMetadataUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFolderInfoUrl(str), "metadata");
    }

    protected String getFolderMetadataUrl(String str, String str2, String str3) {
        return String.format(Locale.ENGLISH, "%s/%s/%s", getFolderMetadataUrl(str), str2, str3);
    }

    protected String getFolderMetadataUrl(String str, String str2) {
        return getFolderMetadataUrl(str, "enterprise", str2);
    }

    @Deprecated
    public BoxRequestsMetadata.AddFileMetadata getAddMetadataRequest(String str, LinkedHashMap<String, Object> linkedHashMap, String str2, String str3) {
        return getAddFileMetadataRequest(str, linkedHashMap, str2, str3);
    }

    public BoxRequestsMetadata.AddFileMetadata getAddFileMetadataRequest(String str, LinkedHashMap<String, Object> linkedHashMap, String str2, String str3) {
        return new BoxRequestsMetadata.AddFileMetadata(linkedHashMap, getFileMetadataUrl(str, str2, str3), this.mSession);
    }

    public BoxRequestsMetadata.AddItemMetadata getAddFolderMetadataRequest(String str, LinkedHashMap<String, Object> linkedHashMap, String str2, String str3) {
        return new BoxRequestsMetadata.AddItemMetadata(linkedHashMap, getFolderMetadataUrl(str, str2, str3), this.mSession);
    }

    public BoxRequestsMetadata.GetFileMetadata getMetadataRequest(String str) {
        return new BoxRequestsMetadata.GetFileMetadata(getFileMetadataUrl(str), this.mSession);
    }

    public BoxRequestsMetadata.GetFileMetadata getFileMetadataRequest(String str) {
        return new BoxRequestsMetadata.GetFileMetadata(getFileMetadataUrl(str), this.mSession);
    }

    public BoxRequestsMetadata.GetItemMetadata getFolderMetadataRequest(String str) {
        return new BoxRequestsMetadata.GetFileMetadata(getFolderMetadataUrl(str), this.mSession);
    }

    @Deprecated
    public BoxRequestsMetadata.GetFileMetadata getMetadataRequest(String str, String str2) {
        return new BoxRequestsMetadata.GetFileMetadata(getFileMetadataUrl(str, str2), this.mSession);
    }

    public BoxRequestsMetadata.GetFileMetadata getFileMetadataRequest(String str, String str2) {
        return new BoxRequestsMetadata.GetFileMetadata(getFileMetadataUrl(str, str2), this.mSession);
    }

    public BoxRequestsMetadata.GetItemMetadata getFolderMetadataRequest(String str, String str2) {
        return new BoxRequestsMetadata.GetItemMetadata(getFolderMetadataUrl(str, str2), this.mSession);
    }

    @Deprecated
    public BoxRequestsMetadata.UpdateFileMetadata getUpdateMetadataRequest(String str, String str2, String str3) {
        return getUpdateFileMetadataRequest(str, str2, str3);
    }

    public BoxRequestsMetadata.UpdateFileMetadata getUpdateFileMetadataRequest(String str, String str2, String str3) {
        return new BoxRequestsMetadata.UpdateFileMetadata(getFileMetadataUrl(str, str2, str3), this.mSession);
    }

    public BoxRequestsMetadata.UpdateItemMetadata getUpdateFolderMetadataRequest(String str, String str2, String str3) {
        return new BoxRequestsMetadata.UpdateItemMetadata(getFolderMetadataUrl(str, str2, str3), this.mSession);
    }

    @Deprecated
    public BoxRequestsMetadata.DeleteFileMetadata getDeleteMetadataTemplateRequest(String str, String str2) {
        return getDeleteFileMetadataTemplateRequest(str, str2);
    }

    public BoxRequestsMetadata.DeleteFileMetadata getDeleteFileMetadataTemplateRequest(String str, String str2) {
        return new BoxRequestsMetadata.DeleteFileMetadata(getFileMetadataUrl(str, str2), this.mSession);
    }

    public BoxRequestsMetadata.DeleteItemMetadata getDeleteFolderMetadataTemplateRequest(String str, String str2) {
        return new BoxRequestsMetadata.DeleteItemMetadata(getFolderMetadataUrl(str, str2), this.mSession);
    }

    public BoxRequestsMetadata.GetMetadataTemplates getMetadataTemplatesRequest() {
        return new BoxRequestsMetadata.GetMetadataTemplates(getMetadataTemplatesUrl(), this.mSession);
    }

    public BoxRequestsMetadata.GetMetadataTemplateSchema getMetadataTemplateSchemaRequest(String str, String str2) {
        return new BoxRequestsMetadata.GetMetadataTemplateSchema(getMetadataTemplatesUrl(str, str2), this.mSession);
    }

    public BoxRequestsMetadata.GetMetadataTemplateSchema getMetadataTemplateSchemaRequest(String str) {
        return getMetadataTemplateSchemaRequest("enterprise", str);
    }
}
