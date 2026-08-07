package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiFile extends BoxApi {
    public BoxApiFile(BoxSession boxSession) {
        super(boxSession);
    }

    public String getFilesUrl() {
        return String.format(Locale.ENGLISH, "%s/files", getBaseUri());
    }

    protected String getFileInfoUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFilesUrl(), str);
    }

    protected String getFileCopyUrl(String str) {
        return String.format(Locale.ENGLISH, getFileInfoUrl(str) + "/copy", new Object[0]);
    }

    protected String getFileUploadUrl() {
        return String.format(Locale.ENGLISH, "%s/files/content", getBaseUploadUri());
    }

    protected String getFileUploadNewVersionUrl(String str) {
        return String.format(Locale.ENGLISH, "%s/files/%s/content", getBaseUploadUri(), str);
    }

    protected String getTrashedFileUrl(String str) {
        return getFileInfoUrl(str) + "/trash";
    }

    protected String getFileCommentsUrl(String str) {
        return getFileInfoUrl(str) + BoxApiComment.COMMENTS_ENDPOINT;
    }

    protected String getFileCollaborationsUrl(String str) {
        return getFileInfoUrl(str) + "/collaborations";
    }

    protected String getFileCollaboratorsUrl(String str) {
        return getFileInfoUrl(str) + "/collaborators";
    }

    protected String getFileVersionsUrl(String str) {
        return getFileInfoUrl(str) + "/versions";
    }

    protected String getPromoteFileVersionUrl(String str) {
        return getFileVersionsUrl(str) + "/current";
    }

    protected String getDeleteFileVersionUrl(String str, String str2) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getFileVersionsUrl(str), str2);
    }

    protected String getFileDownloadUrl(String str) {
        return getFileInfoUrl(str) + "/content";
    }

    protected String getThumbnailFileDownloadUrl(String str) {
        return getFileInfoUrl(str) + "/thumbnail";
    }

    protected String getCommentUrl() {
        return getBaseUri() + BoxApiComment.COMMENTS_ENDPOINT;
    }

    protected String getPreviewFileUrl() {
        return getBaseUri() + BoxApiEvent.EVENTS_ENDPOINT;
    }

    protected String getUploadSessionForNewFileUrl() {
        return getBaseUploadUri() + "/files/upload_sessions";
    }

    protected String getUploadSessionForNewFileVersionUrl(String str) {
        return String.format(Locale.ENGLISH, "%s/files/%s/upload_sessions", getBaseUploadUri(), str);
    }

    public BoxRequestsFile.GetFileInfo getInfoRequest(String str) {
        return new BoxRequestsFile.GetFileInfo(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.GetEmbedLinkFileInfo getEmbedLinkRequest(String str) {
        return new BoxRequestsFile.GetEmbedLinkFileInfo(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.UpdateFile getUpdateRequest(String str) {
        return new BoxRequestsFile.UpdateFile(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.CopyFile getCopyRequest(String str, String str2) {
        return new BoxRequestsFile.CopyFile(str, str2, getFileCopyUrl(str), this.mSession);
    }

    public BoxRequestsFile.UpdateFile getMoveRequest(String str, String str2) {
        BoxRequestsFile.UpdateFile updateFile = new BoxRequestsFile.UpdateFile(str, getFileInfoUrl(str), this.mSession);
        updateFile.setParentId(str2);
        return updateFile;
    }

    public BoxRequestsFile.DeleteFile getDeleteRequest(String str) {
        return new BoxRequestsFile.DeleteFile(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.DeleteFile getDeleteRequest(BoxItem boxItem) {
        return new BoxRequestsFile.DeleteFile(boxItem, getFileInfoUrl(boxItem.getUserId()), this.mSession);
    }

    public BoxRequestsFile.UpdatedSharedFile getCreateSharedLinkRequest(String str) {
        return new BoxRequestsFile.UpdatedSharedFile(str, getFileInfoUrl(str), this.mSession).setAccess(null);
    }

    public BoxRequestsFile.UpdateFile getDisableSharedLinkRequest(String str) {
        return new BoxRequestsFile.UpdateFile(str, getFileInfoUrl(str), this.mSession).setSharedLink(null);
    }

    public BoxRequestsFile.AddCommentToFile getAddCommentRequest(String str, String str2) {
        return new BoxRequestsFile.AddCommentToFile(str, str2, getCommentUrl(), this.mSession);
    }

    public BoxRequestsFile.AddTaggedCommentToFile getAddTaggedCommentRequest(String str, String str2) {
        return new BoxRequestsFile.AddTaggedCommentToFile(str, str2, getCommentUrl(), this.mSession);
    }

    public BoxRequestsFile.UploadFile getUploadRequest(InputStream inputStream, String str, String str2) {
        return new BoxRequestsFile.UploadFile(inputStream, str, str2, getFileUploadUrl(), this.mSession);
    }

    public BoxRequestsFile.UploadFile getUploadRequest(File file, String str) {
        return new BoxRequestsFile.UploadFile(file, str, getFileUploadUrl(), this.mSession);
    }

    public BoxRequestsFile.UploadNewVersion getUploadNewVersionRequest(InputStream inputStream, String str) {
        return new BoxRequestsFile.UploadNewVersion(inputStream, getFileUploadNewVersionUrl(str), this.mSession);
    }

    public BoxRequestsFile.UploadNewVersion getUploadNewVersionRequest(File file, String str) {
        try {
            BoxRequestsFile.UploadNewVersion uploadNewVersionRequest = getUploadNewVersionRequest(new FileInputStream(file), str);
            uploadNewVersionRequest.setUploadSize(file.length());
            uploadNewVersionRequest.setModifiedDate(new Date(file.lastModified()));
            return uploadNewVersionRequest;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public BoxRequestsFile.DownloadFile getDownloadRequest(File file, String str) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return new BoxRequestsFile.DownloadFile(str, file, getFileDownloadUrl(str), this.mSession);
    }

    public BoxRequestsFile.DownloadFile getDownloadUrlRequest(File file, String str) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return new BoxRequestsFile.DownloadFile(file, str, this.mSession);
    }

    public BoxRequestsFile.DownloadFile getDownloadRequest(OutputStream outputStream, String str) {
        return new BoxRequestsFile.DownloadFile(str, outputStream, getFileDownloadUrl(str), this.mSession);
    }

    public BoxRequestsFile.DownloadThumbnail getDownloadThumbnailRequest(File file, String str) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (file.isDirectory()) {
            throw new RuntimeException("This endpoint only supports files and does not support directories");
        }
        return new BoxRequestsFile.DownloadThumbnail(str, file, getThumbnailFileDownloadUrl(str), this.mSession);
    }

    public BoxRequestsFile.DownloadThumbnail getDownloadThumbnailRequest(OutputStream outputStream, String str) {
        return new BoxRequestsFile.DownloadThumbnail(str, outputStream, getThumbnailFileDownloadUrl(str), this.mSession);
    }

    public BoxRequestsFile.DownloadRepresentation getDownloadRepresentationRequest(String str, File file, BoxRepresentation boxRepresentation) {
        return new BoxRequestsFile.DownloadRepresentation(str, file, boxRepresentation, this.mSession);
    }

    public BoxRequestsFile.DownloadRepresentation getDownloadRepresentationRequest(String str, OutputStream outputStream, BoxRepresentation boxRepresentation) {
        return new BoxRequestsFile.DownloadRepresentation(str, outputStream, boxRepresentation, this.mSession);
    }

    public BoxRequestsFile.GetTrashedFile getTrashedFileRequest(String str) {
        return new BoxRequestsFile.GetTrashedFile(str, getTrashedFileUrl(str), this.mSession);
    }

    public BoxRequestsFile.DeleteTrashedFile getDeleteTrashedFileRequest(String str) {
        return new BoxRequestsFile.DeleteTrashedFile(str, getTrashedFileUrl(str), this.mSession);
    }

    public BoxRequestsFile.RestoreTrashedFile getRestoreTrashedFileRequest(String str) {
        return new BoxRequestsFile.RestoreTrashedFile(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.GetFileComments getCommentsRequest(String str) {
        return new BoxRequestsFile.GetFileComments(str, getFileCommentsUrl(str), this.mSession);
    }

    public BoxRequestsFile.GetCollaborations getCollaborationsRequest(String str) {
        return new BoxRequestsFile.GetCollaborations(str, getFileCollaborationsUrl(str), this.mSession);
    }

    public BoxRequestsFile.GetCollaborators getCollaboratorsRequest(String str) {
        return new BoxRequestsFile.GetCollaborators(str, getFileCollaboratorsUrl(str), this.mSession);
    }

    public BoxRequestsFile.GetFileVersions getVersionsRequest(String str) {
        return new BoxRequestsFile.GetFileVersions(str, getFileVersionsUrl(str), this.mSession);
    }

    public BoxRequestsFile.AddFileToCollection getAddToCollectionRequest(String str, String str2) {
        return new BoxRequestsFile.AddFileToCollection(str, str2, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.DeleteFileFromCollection getDeleteFromCollectionRequest(String str) {
        return new BoxRequestsFile.DeleteFileFromCollection(str, getFileInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.FilePreviewed getFilePreviewedRequest(String str) {
        return new BoxRequestsFile.FilePreviewed(str, getPreviewFileUrl(), this.mSession);
    }

    public BoxRequestsFile.CreateUploadSession getCreateUploadSessionRequest(File file, String str) throws FileNotFoundException {
        return new BoxRequestsFile.CreateUploadSession(file, str, getUploadSessionForNewFileUrl(), this.mSession);
    }

    public BoxRequestsFile.CreateUploadSession getCreateUploadSessionRequest(InputStream inputStream, String str, long j, String str2) {
        return new BoxRequestsFile.CreateUploadSession(inputStream, str, j, str2, getUploadSessionForNewFileUrl(), this.mSession);
    }

    public BoxRequestsFile.CreateNewVersionUploadSession getCreateUploadVersionSessionRequest(File file, String str) throws FileNotFoundException {
        return new BoxRequestsFile.CreateNewVersionUploadSession(file, getUploadSessionForNewFileVersionUrl(str), this.mSession);
    }

    public BoxRequestsFile.CreateNewVersionUploadSession getCreateUploadVersionSessionRequest(InputStream inputStream, String str, long j, String str2) throws FileNotFoundException {
        return new BoxRequestsFile.CreateNewVersionUploadSession(inputStream, str, j, getUploadSessionForNewFileVersionUrl(str2), this.mSession);
    }

    public BoxRequestsFile.UploadSessionPart getUploadSessionPartRequest(File file, BoxUploadSession boxUploadSession, int i) throws IOException {
        return new BoxRequestsFile.UploadSessionPart(file, boxUploadSession, i, this.mSession);
    }

    public BoxRequestsFile.UploadSessionPart getUploadSessionPartRequest(InputStream inputStream, long j, BoxUploadSession boxUploadSession, int i) throws IOException {
        return new BoxRequestsFile.UploadSessionPart(inputStream, j, boxUploadSession, i, this.mSession);
    }

    public BoxRequestsFile.CommitUploadSession getCommitSessionRequest(List<BoxUploadSessionPart> list, Map<String, String> map, String str, String str2, BoxUploadSession boxUploadSession) {
        return new BoxRequestsFile.CommitUploadSession(list, map, str, str2, boxUploadSession, this.mSession);
    }

    public BoxRequestsFile.CommitUploadSession getCommitSessionRequest(List<BoxUploadSessionPart> list, BoxUploadSession boxUploadSession) {
        return new BoxRequestsFile.CommitUploadSession(list, null, null, null, boxUploadSession, this.mSession);
    }

    protected String getUploadSessionInfoUrl(String str) {
        return String.format(Locale.ENGLISH, CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getUploadSessionForNewFileUrl(), str);
    }

    public BoxRequestsFile.GetUploadSession getUploadSession(String str) {
        return new BoxRequestsFile.GetUploadSession(str, getUploadSessionInfoUrl(str), this.mSession);
    }

    public BoxRequestsFile.ListUploadSessionParts getListUploadSessionRequest(BoxUploadSession boxUploadSession) {
        return new BoxRequestsFile.ListUploadSessionParts(boxUploadSession, this.mSession);
    }

    public BoxRequestsFile.AbortUploadSession getAbortUploadSessionRequest(BoxUploadSession boxUploadSession) {
        return new BoxRequestsFile.AbortUploadSession(boxUploadSession, this.mSession);
    }
}
