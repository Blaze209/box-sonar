package io.split.android.client.utils;

import android.content.Context;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    public String loadFileContent(String name, Context context) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(name);
            String strConvertStreamToString = convertStreamToString(inputStreamOpen);
            inputStreamOpen.close();
            return strConvertStreamToString;
        } catch (FileNotFoundException e) {
            Logger.e("An error has ocurred: Could not find file " + name);
            throw e;
        } catch (IOException e2) {
            Logger.e("An error has ocurred: Could not open file " + name);
            throw e2;
        }
    }

    private String convertStreamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line).append("\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public boolean fileExists(String fileName, Context context) {
        String strLoadFileContent;
        try {
            strLoadFileContent = loadFileContent(fileName, context);
        } catch (IOException unused) {
            strLoadFileContent = null;
        }
        return strLoadFileContent != null;
    }

    public boolean isPropertiesFileName(String fileName) {
        int length = "properties".length();
        if (length < fileName.length()) {
            return fileName.substring(fileName.length() - length).equals("properties");
        }
        return false;
    }
}
