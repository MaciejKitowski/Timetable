package com.maciejkitowski.timetable.Date;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

final class DateFileLoader implements ILoader {
    private static final String logcat = "DateFileLoader";
    static final String filename = "dates.json";

    @Override
    public void load(Context context) {
        Log.i(logcat, "Load dates from file.");
        Log.e(logcat, "Getting dates from file not implemented yet.");
    }

    @Override
    public ArrayList<String> getJson() {
        Log.e(logcat, "Getting json dates from file not implemented yet.");
        return null;
    }

    static boolean isDatesSavedOnDevice(Context context) {
        Log.i(logcat, String.format("Check if %s exists on device.", filename));
        File file = new File(context.getFilesDir(), filename);

        Log.i(logcat, String.format("File %s found: %s", filename, file.exists()));
        return file.exists();
    }
}
