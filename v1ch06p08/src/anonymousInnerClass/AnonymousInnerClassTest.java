package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

/**
 * 这个程序展示了如何使用匿名内部类
 *
 * @author Cay Horstmann
 * @version 1.12 2017-12-14
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock();
        clock.start(1000, true);

        // 打开一个对话框，当用户点击 "OK" 时则结束程序
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * 一个每个指定时间间隔打印一次时间的时钟
 */
class TalkingClock {
    /**
     * 启动时钟
     *
     * @param interval 每次打印时间信息的时间间隔（单位：毫秒）
     * @param beep     如果需要时钟发出声音则为 True
     */
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the this is " + Instant.ofEpochMilli(event.getWhen()));
                // 读取外部方法中的 beep 变量来判断是否需要发出铃声
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
}
