package org.tinylog.path;

import com.box.androidsdk.content.models.BoxOrder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
public final class DynamicPath {
    private static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd_HH-mm-ss";
    private static final String DEFAULT_LOG_FILENAME = "log";
    private final File folder;
    private final List<String> plainTexts;
    private final List<Segment> segments;
    private final String suffix;

    public DynamicPath(String str) {
        String strReplace = str.replace('/', File.separatorChar);
        this.segments = new ArrayList();
        this.plainTexts = new ArrayList();
        String strSubstring = "";
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < strReplace.length(); i2++) {
            char cCharAt = strReplace.charAt(i2);
            if (cCharAt == '{') {
                if (z) {
                    throw new IllegalArgumentException("Closing curly bracket is missing: '" + str + "'");
                }
                if (i2 > 0 && strReplace.charAt(i2 - 1) == '}') {
                    throw new IllegalArgumentException("Two patterns must be separated by at least one character: '" + str + "'");
                }
                if (i2 > i) {
                    if (strSubstring.isEmpty() && this.segments.isEmpty()) {
                        strSubstring = strReplace.substring(0, i2);
                    }
                    String strSubstring2 = strReplace.substring(i, i2);
                    this.segments.add(new PlainTextSegment(strSubstring2));
                    this.plainTexts.add(strSubstring2);
                }
                i = i2 + 1;
                z = true;
            } else if (cCharAt != '}') {
                continue;
            } else if (z) {
                this.segments.add(parseSegment(strReplace, strReplace.substring(i, i2)));
                i = i2 + 1;
                z = false;
            } else {
                throw new IllegalArgumentException("Opening curly bracket is missing: '" + str + "'");
            }
        }
        if (z) {
            throw new IllegalArgumentException("Closing curly bracket is missing: '" + str + "'");
        }
        if (i < strReplace.length() - 1) {
            if (strSubstring.isEmpty() && this.segments.isEmpty()) {
                strSubstring = strReplace;
            }
            String strSubstring3 = strReplace.substring(i);
            int iMax = Math.max(strSubstring3.lastIndexOf(File.separatorChar), strSubstring3.lastIndexOf(47));
            this.segments.add(new PlainTextSegment(strSubstring3));
            this.plainTexts.add(strSubstring3);
            this.suffix = iMax != -1 ? strSubstring3.substring(iMax + 1) : strSubstring3;
        } else {
            this.suffix = "";
        }
        int iMax2 = Math.max(strSubstring.lastIndexOf(File.separatorChar), strSubstring.lastIndexOf(47));
        this.folder = new File(iMax2 != -1 ? strSubstring.substring(0, iMax2) : "").getAbsoluteFile();
    }

    public String resolve() {
        Timestamp timestampCreateTimestamp = RuntimeProvider.createTimestamp();
        StringBuilder sb = new StringBuilder();
        Iterator<Segment> it = this.segments.iterator();
        while (it.hasNext()) {
            sb.append(it.next().createToken(sb.toString(), timestampCreateTimestamp));
        }
        return sb.toString();
    }

    public List<FileTuple> getAllFiles(String str) {
        ArrayList arrayList = new ArrayList();
        Collection<File> arrayList2 = str == null ? new ArrayList<>() : new HashSet<>();
        collectFiles(this.folder, this.suffix, arrayList2);
        if (str != null) {
            ArrayList arrayList3 = new ArrayList();
            collectFiles(this.folder, this.suffix + str, arrayList3);
            for (File file : arrayList3) {
                String absolutePath = file.getAbsolutePath();
                File file2 = new File(absolutePath.substring(0, absolutePath.length() - str.length()));
                arrayList.add(new FileTuple(file2, file));
                arrayList2.remove(file2);
            }
        }
        for (File file3 : arrayList2) {
            String absolutePath2 = file3.getAbsolutePath();
            if (str != null) {
                absolutePath2 = absolutePath2 + str;
            }
            arrayList.add(new FileTuple(file3, new File(absolutePath2)));
        }
        Collections.sort(arrayList, LastModifiedFileTupleComparator.INSTANCE);
        return arrayList;
    }

    public boolean isValid(File file) {
        return isValid(file.getAbsolutePath(), 0, 0);
    }

    private void collectFiles(File file, String str, Collection<File> collection) {
        String next;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    collectFiles(file2, str, collection);
                } else if (file2.isFile() && file2.getAbsolutePath().endsWith(str)) {
                    Iterator<String> it = this.plainTexts.iterator();
                    int iIndexOf = 0;
                    while (it.hasNext() && (iIndexOf = file2.getAbsolutePath().indexOf((next = it.next()), iIndexOf)) != -1) {
                        iIndexOf += next.length();
                    }
                    if (iIndexOf >= 0) {
                        collection.add(file2.getAbsoluteFile());
                    }
                }
            }
        }
    }

    private boolean isValid(String str, int i, int i2) {
        Segment segment = this.segments.get(i2);
        String staticText = segment.getStaticText();
        if (i == 0) {
            if (staticText == null) {
                staticText = "";
            }
            File absoluteFile = new File(staticText).getAbsoluteFile();
            if (absoluteFile.isDirectory()) {
                staticText = absoluteFile.getAbsolutePath() + File.separator;
            } else {
                staticText = absoluteFile.getAbsolutePath();
            }
        }
        if (staticText == null) {
            if (i2 == this.segments.size() - 1) {
                return segment.validateToken(str.substring(i));
            }
            int i3 = i2 + 1;
            String staticText2 = this.segments.get(i3).getStaticText();
            int iIndexOf = str.indexOf(staticText2, i);
            while (iIndexOf >= 0) {
                if (segment.validateToken(str.substring(i, iIndexOf)) && isValid(str, iIndexOf, i3)) {
                    return true;
                }
                iIndexOf = str.indexOf(staticText2, iIndexOf + 1);
            }
            return false;
        }
        if (!str.startsWith(staticText, i)) {
            return false;
        }
        if (i2 == this.segments.size() - 1) {
            return i + staticText.length() == str.length();
        }
        return isValid(str, i + staticText.length(), i2 + 1);
    }

    private static Segment parseSegment(String str, String str2) {
        String strTrim;
        String strTrim2;
        int iIndexOf = str2.indexOf(58);
        if (iIndexOf == -1) {
            strTrim2 = str2.trim();
            strTrim = null;
        } else {
            String strTrim3 = str2.substring(0, iIndexOf).trim();
            strTrim = str2.substring(iIndexOf + 1).trim();
            strTrim2 = strTrim3;
        }
        if (BoxOrder.SORT_DATE.equals(strTrim2)) {
            if (strTrim == null) {
                strTrim = DEFAULT_DATE_FORMAT_PATTERN;
            }
            return new DateSegment(strTrim);
        }
        if ("count".equals(strTrim2) && strTrim == null) {
            return new CountSegment();
        }
        if ("pid".equals(strTrim2) && strTrim == null) {
            return new ProcessIdSegment();
        }
        if ("dynamic".equals(strTrim2)) {
            if (strTrim == null) {
                strTrim = DEFAULT_LOG_FILENAME;
            }
            return new DynamicSegment(strTrim);
        }
        throw new IllegalArgumentException("Invalid token '" + str2 + "' in '" + str + "'");
    }
}
