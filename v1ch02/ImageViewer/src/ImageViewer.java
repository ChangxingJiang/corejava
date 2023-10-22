import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * A Program for viewing images.
 *
 * @author Cay Horstman
 * @version 1.31 2018-04-10
 */
public class ImageViewer {
    public static void main(String[] args) {
        // 执行事件分配线程中的语句（讲解位于第 10 章）
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a label to show in image.
 * 自定义类 ImageViewFrame 并继承 JFrame（讲解位于第 4 章和第 5 章）
 */
class ImageViewFrame extends JFrame {
    // 定义 2 个静态常量（讲解位于 4.4.2）
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    // 设置窗口相关组件（讲解位于第 10 章）
    public ImageViewFrame() {
        // 设置窗口尺寸
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 使用 JLabel 标签用于展示图片
        var label = new JLabel();
        add(label);

        // 设置文件选择器
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // 设置主菜单
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(event -> {
            // 打开文件对话框
            int result = chooser.showOpenDialog(null);

            // 如果文件已被选择，则将其作为 ImageIcon 添加到 JLabel 标签上
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        }); // 绑定事件

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}