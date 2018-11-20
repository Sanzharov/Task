package project.tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Content {

    protected List<String> contentList;
    protected String filePath;

    public Content() { }

    public Content(String filePath) {
        this.filePath = filePath;
        this.getContent();
    }

    private void getContent()
    {
        this.contentList = Collections.emptyList();

        try
        { this.contentList = Files.readAllLines(Paths.get(this.filePath), StandardCharsets.UTF_8); }
        catch (IOException e)
        { e.printStackTrace(); }
    }
}
