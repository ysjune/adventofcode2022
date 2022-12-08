import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Directory {
        private String name;
        private List<File> files = new ArrayList<>();
        private List<Directory> directories = new ArrayList<>();
        private Directory frontDirectory;

        public Long getAllFileSize() {
            return files.stream().mapToLong(v -> v.getFileSize()).sum();
        }

        public Directory(final String name) {
            this.name = name;
        }

        public long getAll() {
            return getAllFileSize() + directories.stream().mapToLong(v -> v.getAll()).sum();
        }

        @Override
        public String toString() {
            return "Directory";
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class File {
        private String name;
        private long fileSize;

        @Override
        public String toString() {
            return "File";
        }
    }

    public static List<Long> lists = new ArrayList<>();

    public static long sumDirectories(String path) {

        List<String> directoryNames = new ArrayList<>();
        Directory cur = null;
        Directory top = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.contains("$ ls")) {
                    continue;
                }
                if (readLine.contains("$ cd ..")) {
                    cur = cur.getFrontDirectory();
                    continue;
                }
                if (readLine.contains("$ cd")) {
                    String[] s = readLine.split(" ");
                    Directory directory = null;
                    if (directoryNames.contains(s[2])) {
                        Directory sub = cur.getDirectories().stream().filter(v -> v.getName().equals(s[2])).findFirst().get();
                        directory = sub;
                    } else {
                        directory = new Directory(s[2]);
                    }
                    directory.setFrontDirectory(cur);
                    cur = directory;
                    if (readLine.contains("/")) {
                        top = cur;
                    }
                    continue;
                }
                String[] s = readLine.split(" ");
                if (readLine.contains("dir ")) {
                    Directory directory = new Directory(s[1]);
                    cur.getDirectories().add(directory);
                    directoryNames.add(s[1]);
                } else {
                    File file = new File(s[1], Integer.parseInt(s[0]));
                    cur.getFiles().add(file);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tops(top);
        return lists.stream().filter(v -> v < 100000).mapToLong(v -> v).sum();
    }

    public static long deleteDirectories(String path) {

        List<String> directoryNames = new ArrayList<>();
        Directory cur = null;
        Directory top = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.contains("$ ls")) {
                    continue;
                }
                if (readLine.contains("$ cd ..")) {
                    cur = cur.getFrontDirectory();
                    continue;
                }
                if (readLine.contains("$ cd")) {
                    String[] s = readLine.split(" ");
                    Directory directory = null;
                    if (directoryNames.contains(s[2])) {
                        Directory sub = cur.getDirectories().stream().filter(v -> v.getName().equals(s[2])).findFirst().get();
                        directory = sub;
                    } else {
                        directory = new Directory(s[2]);
                    }
                    directory.setFrontDirectory(cur);
                    cur = directory;
                    if (readLine.contains("/")) {
                        top = cur;
                    }
                    continue;
                }
                String[] s = readLine.split(" ");
                if (readLine.contains("dir ")) {
                    Directory directory = new Directory(s[1]);
                    cur.getDirectories().add(directory);
                    directoryNames.add(s[1]);
                } else {
                    File file = new File(s[1], Integer.parseInt(s[0]));
                    cur.getFiles().add(file);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tops(top);

        long all = top.getAll();
        long avail = 70000000;
        long atLeast = 30000000;
        long need = atLeast - (avail - all);

        return lists.stream().filter(v -> v > need).min(Comparator.comparingLong(value -> value)).get();
    }

    public static void tops(Directory top) {
        lists.add(top.getAll());
        if (top.getDirectories() != null && top.getDirectories().size() != 0) {
            for (int i = 0; i < top.getDirectories().size(); i++) {
                tops(top.getDirectories().get(i));
            }
        }
    }


    public static void main(String[] args) {

//        long total = sumDirectories("src/main/resources/day7");
//        System.out.println(total);

        long total = deleteDirectories("src/main/resources/day7");
        System.out.println(total);

        System.out.println("Aaa");

    }
}
