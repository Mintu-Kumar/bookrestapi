package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:\\springbootproject\\bootrestbook\\src\\main\\resources\\static\\image";

    public Boolean uploadFile(MultipartFile multipartFile) {

        boolean b = false;
        /*
         * try {
         * 
         * InputStream is = multipartFile.getInputStream();
         * byte data[] = new byte[is.available()];
         * is.read(data);
         * 
         * FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.pathSeparator +
         * multipartFile.getName());
         * fos.write(data);
         * 
         * fos.flush();
         * fos.close();
         * 
         * b = true;
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        // one line code
        try {
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;

    }

}
