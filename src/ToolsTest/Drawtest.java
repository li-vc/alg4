package ToolsTest;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 *
 * 标准绘图库
 *         StdDraw.setYscale(4,-2);
 *         StdDraw.setXscale(-2,2);
 *    设置坐标轴从左往右（x）、从下到上（y）的两个值，坐标系原点会随之变化；
 *    例如：setYscale(4,-2) 则左下角为y的4，左上角为y的-2
 *
 *    api地址：https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdDraw.html#line-double-double-double-double-
 */
public class Drawtest {
    //绘图方法
    private static void Drawing() {
        /**
         * 标准绘图库的静态方法
         *  默认的画布是单位画布，也就是0-1
         * */
//      1、画出一条直线：A(0.3,0.2)、B(0,0)，两个坐标连接成的直线，因为默认是单位画布，所以坐标如果超过1的话是显示不出来的
//        StdDraw.line(0.5, 0.9, -1, -1);

        StdDraw.setYscale(4,-2);
        StdDraw.setXscale(-2,2);
        StdDraw.line(0, 0, -1, -1);
        StdDraw.line(0, 0, 1, 1);

//      2、画出一个同心圆：圆心是(0.5,0.5)、半径是0.2
//        StdDraw.circle(0.5, 0.5, 0.2);

//      3、画出一个正方形中心点是(0.5,0.5),中心点做垂线到边的距离是0.2
//        StdDraw.square(0.5, 0.5, 0.2);
//      4、画出一个正方形并进行填充
//        StdDraw.filledSquare(0.5,0.5,0.2);

        /*
         * 5、画出一个多边形
         * 各个点分别是(0.2,0.1),(0.3,0.6),(0.4,0.9)
         * 各点之间连线，可得到一个多边形
         * */
        double[] x = {0.2, 0.3, 0.4};
        double[] y = {0.1, 0.6, 0.9};
//        StdDraw.polygon(x, y);
//      6、画出多边型，并进行填充，默认是黑色
//        StdDraw.filledPolygon(x, y);

//      7、画出单一的一个坐标点
//        StdDraw.point(0.3,0.4);
        /*
         * 8、画出一个椭圆形：中心点(0.2,0.3);
         * 水平线上的半轴长:0.4;
         * 垂直线上的半轴长:0.2
         * */
//        StdDraw.ellipse(0.2, 0.3, 0.4, 0.2);
//        9、画出椭圆形，并进行填充
//        StdDraw.filledEllipse(0.2, 0.3, 0.4, 0.2);

//        10、画出一个矩形，分别对应的是，中心点、半宽度、半长度
//        StdDraw.rectangle(0.5,0.5,0.2,0.4);

//        11、画出一个矩形，并进行填充
        StdDraw.filledRectangle(1,2,0.02,0.5);

    }

    //控制方法
    //例如：改变画布的大小和比例，直线的颜色和宽度、文本字体等等
    private static void control() {
        //将x坐标轴设置为0-10
        StdDraw.setXscale(0, 10);
        //将y坐标轴设置为0-10
        StdDraw.setYscale(0, 10);

        //对画笔的粗细进行设定
//        StdDraw.setPenRadius(0.01);

        //设置画笔的颜色
        StdDraw.setPenColor(StdDraw.RED);

        //设置画布的宽和高
//        StdDraw.setCanvasSize(200,300);

        //清空画布并用颜色C对其进行填充
//        StdDraw.clear(StdDraw.BLUE);
//        StdDraw.line(3, 1, 9, 2);

        //显示所有图像，并暂停**毫秒
//        StdDraw.show();

    }

    /**
     * 绘图举例
     */
    //函数值
    private static void def_value() {

        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);

        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * Math.log(i));
            StdDraw.point(i, i * i);
        }
    }

    //随机数组
    private static void random_array() {
        int N = 50;
        double[] a = new double[N];
        //随机得到0-1之间的实数,并对数组进行赋值
        for (int i = 0; i < N; i++) a[i] = StdRandom.random();

        for (int i = 0; i < N; i++) {
            //乘以1.0为的是将其变为double类型
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;

            double width = 0.5 / N;

            double high = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, width, high);
        }
    }

    //已排序的随机数组
    private static void random_array_sort() {
        int N = 50;
        double[] a = new double[N];
        //随机得到0-1之间的实数,并对数组进行赋值
        for (int i = 0; i < N; i++) a[i] = StdRandom.random();
        //对数组中的值进行排序
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            //乘以1.0为的是将其变为double类型
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;

            double width = 0.5 / N;

            double high = a[i] / 4.0;
            StdDraw.filledRectangle(x, y, width, high);
        }
    }


    public static void main(String[] args) {
        //控制方法
//        control();
        //绘图方法
        Drawing();

        //控制方法
//        control();

        //函数值
//        def_value();

        //随机数组
//        random_array();

        //以排序的随机数组
//        random_array_sort();

    }
}
