package resource;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import javax.swing.*;

public class ResourceTest {
    public static void main(String[] args) throws IOException {
        // 获取 ResourceTest 的 Class 对象
        Class cl = ResourceTest.class;  // Class 实际上是一个泛型类，应写作 Class<ResourceTest>
        URL aboutURL = cl.getResource("about.gif");  // 再 ResourceTest 类的相同位置上获取资源位置的 URL
        var icon = new ImageIcon(aboutURL);

        // 使用 getResourceAsStream 方法获取一个输入流来读取文件中的内容
        InputStream stream = cl.getResourceAsStream("data/about.txt");
        var about = new String(stream.readAllBytes(), "UTF-8");

        InputStream stream2 = cl.getResourceAsStream("/corejava/title.txt");
        var title = new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

        // 输出对话框
        JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
