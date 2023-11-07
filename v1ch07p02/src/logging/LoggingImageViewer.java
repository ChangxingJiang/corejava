package logging;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

/**
 * 修改版的记录各种事件的图像查看器
 *
 * @author Cay Horstmann
 * @version 1.03 2015-08-20
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);  // 设置日志级别为 ALL
                final int LOG_ROTATION_COUNT = 10;

                // 初始化写入文件的日志处理器并将日志处理器关联到日志记录器
                var handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.horstmann.corejava").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }

        EventQueue.invokeLater(() -> {
            // 初始化输出到窗口的日志处理器并将日志处理器关联到日志记录器
            var windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);

            // 初始化主窗口
            var frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}

/**
 * 用于展示窗口的 Frame
 */
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("com.horstmann.corejava");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");  // 用于跟踪执行流的日志
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);  // 设置窗口大小

        // 设置主菜单
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menuBar.add(openItem);
        openItem.addActionListener(new FileOpenListener());  // 使用内部类为 openItem 添加监听器

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                logger.fine("Exiting.");   // 使用 fine 方法打印 FINE 级别日志
                System.exit(0);
            }
        });  // 使用匿名内部类为 exitItem 添加监听器

        // 使用一个 label 展示图像
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");  // 用于跟踪执行流的日志
    }

    // 使用内部类定义监听器 FileOpenListener
    private class FileOpenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);  // 用于跟踪执行流的日志

            // 设置一个文件选择器
            var chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // 接受以 .gif 结尾的所有文件
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                public String getDescription() {
                    return "GIF Images";
                }
            });

            // 显示文件选择对话框
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // 如果图像文件被选择，则设置 Label 图标
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name); // 使用在 log 方法中选择 FINE 来打印 FINE 级别日志
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled."); // 使用 fine 方法打印 FINE 级别日志
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");    // 用于跟踪执行流的日志
        }
    }
}

class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        var output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        // 使用匿名内部类定义输出到文本框的流
        setOutputStream(new OutputStream() {
            public void write(int b) {
            }

            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    // 覆盖 publish 方法以便在处理器获得每个记录之后刷新输出缓冲区
    public void publish(LogRecord record) {
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
