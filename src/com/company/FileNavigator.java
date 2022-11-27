package com.company;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> map = new HashMap<>();

    public void add(String filePath, FileData fileData) {
        if (!fileData.getPath().equals(filePath)) {
            throw new IllegalArgumentException(String.format(
                    "Path-Key isn`t equals with way\n Path-Key: %s \n FileDate: {name: %s, size: %s, path: %s}",
                    filePath, fileData.getName(), fileData.getSize(), fileData.getPath()));
        }
        if (map.containsKey(fileData.getPath())) {
            map.get(fileData.getPath()).add(fileData);
        } else {
            List<FileData> list = new ArrayList<>();
            list.add(fileData);
            map.put(fileData.getPath(), list);
        }
    }

    public List<FileData> find(String link) {
        return map.get(link);
    }

    public List<FileData> filterBySize(int maxSize) {
        List<FileData> list = new ArrayList<>();
        for (List<FileData> value : map.values())
            for (FileData file : value) {
                if ((file.getSize() <= maxSize)) {
                    list.add(file);
                }
            }
        return list;
    }

    public void remove(String link) {
        map.remove(link);
    }

    public List<FileData> sortBySize() {
        List<FileData> list = new ArrayList<>();
        for (List<FileData> value : map.values()) {
            list.addAll(value);
        }
        list.sort(Comparator.comparingInt(FileData::getSize));
        return list;
    }
}
