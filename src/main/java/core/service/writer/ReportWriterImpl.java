package core.service.writer;

import core.model.MyConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    private static final String FIRST_LINE_IN_REPORT =
            "fruit,quantity" + MyConstants.LINE_SEPARATOR;

    @Override
    public void write(List<String> reportStrings, String filePath) {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(FIRST_LINE_IN_REPORT);
            for (String string : reportStrings) {
                writer.write(string + MyConstants.LINE_SEPARATOR);
            }
        } catch (IOException e) {
            throw new RuntimeException("File wasn't written!");
        }
    }
}