package timer;

/**
 * @author Cay Horstmann
 * @version 1.02 2017-12-14
 */

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();

        // 构造每个 1 秒调用一次 listener 对象的 actionPerformed 方法的定时器
        var timer = new Timer(1000, listener);

        // 启动定时器
        timer.start();

        // 打开一个对话框，当用户点击 "OK" 时则结束程序
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}

class TimePrinter implements ActionListener {
    // 实现 ActionListener 接口的 actionPerformed 方法：定时器每次调用此方法
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep(); // 响一声
    }
}
