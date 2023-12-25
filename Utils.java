import java.io.*;

public class Utils {

    // a. Đọc nội dung từ tệp .txt
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // b. Ghi nội dung vào tệp, xóa nội dung cũ
    public static void writeContentToFile(String path, String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.print(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // c. Ghi nội dung vào cuối tệp
    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.append(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // d. Tìm kiếm một tệp trong thư mục
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Đọc nội dung từ tệp .txt
        String filePath = "C:\\Users\\ACER\\IdeaProjects\\IO utility\\Ex1.txt";
        String content = Utils.readContentFromFile(filePath);
        System.out.println("Content of the file:\n" + content);

        // Ghi nội dung vào tệp, xóa nội dung cũ
        String newPath = "C:\\Users\\ACER\\IdeaProjects\\IO utility\\Ex2.txt";
        Utils.writeContentToFile(newPath, "New content");

        // Ghi nội dung vào cuối tệp
        String existingPath = "C:\\Users\\ACER\\IdeaProjects\\IO utility\\Ex3.txt";
        Utils.appendContentToFile(existingPath, "\nAppended content");

        // Tìm kiếm một tệp trong thư mục
        String folderPath = "C:\\Users\\ACER\\IdeaProjects";
        String fileNameToFind = "C:\\Users\\ACER\\IdeaProjects\\IO utility\\Ex4.txt";
        File foundFile = Utils.findFileByName(folderPath, fileNameToFind);

        if (foundFile != null) {
            System.out.println("File found: " + foundFile.getAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}
