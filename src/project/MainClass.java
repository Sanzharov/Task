package project;

import project.tasks.task1.SurfaceTask;
import project.tasks.task2.TextTask;

public class MainClass {
    public static void main(String[] args) {

        String pathFirstTask = "..\\Task\\src\\project\\resources\\input1.txt",
                pathSecondTask = "..\\Task\\src\\project\\resources\\input2.txt";


        System.out.println("\nFirst task:");
        SurfaceTask surface = new SurfaceTask(pathFirstTask);
        surface.showTotalSurface();

        System.out.println("\nSecond task:");
        TextTask text = new TextTask(pathSecondTask);
        text.showWordStatistic();




    }
}
