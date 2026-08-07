package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsUser;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiUser extends BoxApi {
    public BoxApiUser(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getUsersUrl() {
        return String.format("%s/users", getBaseUri());
    }

    protected String getAvatarDownloadUrl(String str) {
        return getUserInformationUrl(str) + "/avatar";
    }

    protected String getUserInformationUrl(String str) {
        return String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, getUsersUrl(), str);
    }

    public BoxRequestsUser.GetUserInfo getCurrentUserInfoRequest() {
        return new BoxRequestsUser.GetUserInfo(getUserInformationUrl("me"), this.mSession);
    }

    public BoxRequestsUser.GetUserInfo getUserInfoRequest(String str) {
        return new BoxRequestsUser.GetUserInfo(getUserInformationUrl(str), this.mSession);
    }

    public BoxRequestsUser.GetEnterpriseUsers getEnterpriseUsersRequest() {
        return new BoxRequestsUser.GetEnterpriseUsers(getUsersUrl(), this.mSession);
    }

    public BoxRequestsUser.CreateEnterpriseUser getCreateEnterpriseUserRequest(String str, String str2) {
        return new BoxRequestsUser.CreateEnterpriseUser(getUsersUrl(), this.mSession, str, str2);
    }

    public BoxRequestsUser.DeleteEnterpriseUser getDeleteEnterpriseUserRequest(String str) {
        return new BoxRequestsUser.DeleteEnterpriseUser(getUserInformationUrl(str), this.mSession, str);
    }

    public BoxRequestsFile.DownloadAvatar getDownloadAvatarRequest(File file, String str) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return new BoxRequestsFile.DownloadAvatar(str, file, getAvatarDownloadUrl(str), this.mSession).setAvatarType(BoxRequestsFile.DownloadAvatar.LARGE);
    }

    public BoxRequestsFile.DownloadFile getDownloadAvatarRequest(OutputStream outputStream, String str) {
        return new BoxRequestsFile.DownloadFile(str, outputStream, getAvatarDownloadUrl(str), this.mSession);
    }
}
