package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;
    private String ext = ".log";
    static List<File> list;
    List<LogObjects> logList;

    public LogParser(Path logDir) throws Exception {
        this.logDir = logDir;
        list = findFiles(logDir, ext);
        logList = getLogObjects();
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) throws ParseException {
        return  getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) throws ParseException {
        return getIPSet(null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) throws ParseException {
        return getIPSet(user, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) throws ParseException {
        return getIPSet(event, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) throws ParseException {
        return getIPSet(status, after, before);
    }

    public static class MyFileNameFilter implements FilenameFilter {
        private String ext;

        public MyFileNameFilter(String ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }

    public static List<File> findFiles(Path dir, String ext) {
        List<File> files = new ArrayList<>();
        File file = new File(String.valueOf(dir));
        if (!file.exists()) {
            System.out.println(dir + " папка не существует");
        }
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if (listFiles.length == 0) {
            System.out.println(dir + " не содержит файлов с расширением " + ext);
        } else {
            for (File f : listFiles)
                files.add(f);
        }
        return files;
    }

    private class LogObjects {
        String IP;
        String username;
        Date date;
        Event event;
        String taskNumber;
        Status status;

        public LogObjects(String IP, String username, Date date, Event event, Status status) {
            this.IP = IP;
            this.username = username;
            this.date = date;
            this.event = event;
            this.status = status;
        }
    }

    private List<LogObjects> getLogObjects() throws ParseException {
        List<LogObjects> logObjectsList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        for (File f : list) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(f), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineSplit = line.split("\t");
                    String ip = lineSplit[0].trim();
                    String user = lineSplit[1];
                    Date docDate = format.parse(lineSplit[2]);
                    String[] eventList = lineSplit[3].split(" ");
                    Event event = Event.valueOf(eventList[0]);
                    Status status = Status.valueOf(lineSplit[4]);
                    LogObjects log = new LogObjects(ip, user, docDate, event, status);
                    if (eventList.length > 1) {
                        log.taskNumber = eventList[1];
                    }
                    logObjectsList.add(log);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logObjectsList;
    }

    private boolean includeToInterval(Date date, Date after, Date before) {
        boolean isInclude = true;
        if (after != null && after != null) {
            isInclude = date.getTime() >= after.getTime() && date.getTime() <= before.getTime();
        } else if (after == null && before != null) {
            isInclude = date.getTime() <= before.getTime();
        } else if (after != null && before == null) {
            isInclude = date.getTime() >= after.getTime();
        }
        return isInclude;
    }

    private List<LogObjects> includeToInterval(Date after, Date before){
        ArrayList<LogObjects> list = new ArrayList<>();
        for (LogObjects element : logList) {
            if (includeToInterval(element.date, after, before))
                list.add(element);
        }
        return list;
    }

    private boolean matchesType(Object type, LogObjects element) {
        boolean matches = false;
        if (type == null) {
            return true;
        }
        if (type instanceof String) {
            return element.username.equals(type);
        }
        if (type instanceof Event) {
            return element.event.equals(type);
        }
        if (type instanceof Status) {
            return element.status.equals(type);
        }
        return matches;
    }

    private Set<String> getIPSet(Object fieldLog, Date after, Date before){
        Set<String> setIp = new HashSet<>();
        for (LogObjects element : includeToInterval(after, before)){
            if (matchesType(fieldLog, element))
                setIp.add(element.IP);
        }
        return setIp;
    }
}