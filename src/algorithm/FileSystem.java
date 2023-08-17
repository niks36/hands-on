package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

  public static void main(String[] args) {
    //
    FileSystem fileSystem = new FileSystem();

    System.out.println(fileSystem.ls("/"));
    fileSystem.mkDir("/a/b/c");
    fileSystem.addContentToFile("/a/b/c/d", "test");
    System.out.println(fileSystem.ls("/"));
    fileSystem.mkDir("/a/b/c/e");
    System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    System.out.println(fileSystem.ls("/a/b/c"));

  }

  File root;

  public FileSystem() {
    root = new File(true);
  }

  public List<String> ls(String path) {
    if (Utils.isBlank(path)) return Collections.emptyList();

    List<String> strings = new ArrayList<>();
    File file = root;
    if (!path.equals("/")) {
      String[] split = path.split("/");
      for (String subPath : split) {
        if(Utils.isBlank(subPath)) continue;
        file = file.child.get(subPath);
        if (!file.isDir) {
          strings.add(subPath);
          return strings;
        }
      }
    }
    strings = new ArrayList<>(file.child.keySet());
    Collections.sort(strings);
    return strings;
  }

  public void mkDir(String path) {
    File file = root;
    if (!path.equals("/")) {
      String[] split = path.split("/");
      for (String subPath : split) {
        if(Utils.isBlank(subPath)) continue;
        if (!file.child.containsKey(subPath)) {
          file.child.put(subPath, new File(true));
        }
        file = file.child.get(subPath);
      }
    }
    //System.out.println(root);
  }

  public void addContentToFile(String path, String content){
    File file = root;
    String[] split = path.split("/");
    for (int i = 1; i< split.length - 1; i++){
      file = file.child.get(split[i]);
    }
    if(!file.child.containsKey(split[split.length - 1])){
      file.child.put(split[split.length-1], new File(false));
    }

    File file1 = file.child.get(split[split.length - 1]);
    file1.content = file1.content + content;
  }

  public String readContentFromFile(String path){
    File file = root;
    String[] split = path.split("/");
    for (int i = 1; i< split.length - 1; i++){
      file = file.child.get(split[i]);
    }
    return file.child.get(split[split.length - 1]).content;
  }

  class File {
    String content = "";
    boolean isDir;
    Map<String, File> child = new HashMap<>();

    public File(boolean isDir) {
      this.isDir = isDir;
    }

    @Override
    public String toString() {
      return "File{" + "isDir=" + isDir + ", child=" + child + '}';
    }
  }
}
