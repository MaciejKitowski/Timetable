package com.maciejkitowski.timetable.utilities;

import java.util.List;

public interface DownloadListener {
    void onDownloadBegin();
    void onDownloadSuccess(List<String> data);
    void onDownloadFailed(String message);
}
