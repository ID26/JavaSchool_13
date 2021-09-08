package load.interfaces;

import java.io.File;
import java.nio.file.Path;

public class LoadViewPhotoImpl implements LoadViewPhoto {
    @Override
    public File loadPhoto(String path) {
        return new File(path);
    }
}
