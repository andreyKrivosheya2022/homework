package com.company;


public class FileData {
    private final String name;
    private final String path;
    private final int size;


    public FileData(String name, String link, int size) {

        this.name = name;
        this.path = link;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + name + '\'' +
                ", size=" + size +
                ", filePath='" + path + '\'' +
                '}';
    }
}
