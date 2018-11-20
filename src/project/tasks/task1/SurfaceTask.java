package project.tasks.task1;

import project.tasks.Content;

import java.util.List;

public class SurfaceTask extends Content {

    private Character characterMark = 'x';

    private int totalSurface = 0;

    public SurfaceTask() { }

    public SurfaceTask(String filePath) {
        super(filePath);
        this.getAllSurface(this.contentList);
    }

    private int getRoomSurface(String strSurface) {
        int
                l = 0,
                w = 0,
                h = 0,
                surface = 0,
                countIndex = 0;

        int [] indexArr = new int [2];
        for(int i = 0; i < strSurface.length(); i++)
        {
            if(strSurface.charAt(i) == this.characterMark)
            {
                indexArr[countIndex] = i;
                countIndex++;
            }
        }

        l = Integer.parseInt(strSurface.substring(0, indexArr[0]));
        w = Integer.parseInt(strSurface.substring(indexArr[0] + 1, indexArr[1]));
        h = Integer.parseInt(strSurface.substring(indexArr[1] + 1, strSurface.length()));

        surface = 2 * l * w + 2 * w * h + 2 * h * l;

        System.out.println("Current surface: " + surface);
        return surface;
    }

    private void getAllSurface(List <String> roomList) {
        for (String room : roomList)
        { this.totalSurface += this.getRoomSurface(room); }
    }

    public void showTotalSurface() {
        System.out.println("total surface: " + this.totalSurface);
    }
}
