package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

/**
 * 这个程序展示了如何使用内部类
 *
 * @author Cay Horstmann
 * @version 1.11 2017-12-14
 */
public class InnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();

        // 打开一个对话框，当用户点击 "OK" 时则结束程序
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * 一个每个指定时间间隔打印一次时间的时钟
 */
class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * TalkingClock 的构造器
     *
     * @param interval 每次打印时间信息的时间间隔（单位：毫秒）
     * @param beep     如果需要时钟发出声音则为 True
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    // 在 TalkingClock 类内部定义 Time
    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the this is " + Instant.ofEpochMilli(event.getWhen()));
            // 读取外部类中的 beep 实例字段来判断是否需要发出铃声
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
