package utils;

import com.google.common.io.Resources;
import lombok.SneakyThrows;

import java.io.File;

public class ComparisonUtility {

    @SneakyThrows
    // метод, который получает файл по указанному пути
    public static File getFileFromResources(String pathToFile) {
        return new File(Resources.getResource(pathToFile).getFile());
    }

}
