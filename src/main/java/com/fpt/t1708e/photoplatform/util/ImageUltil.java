package com.fpt.t1708e.photoplatform.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Calendar;
import java.util.regex.Pattern;

public class ImageUltil {
    public String SaveAndGetImgUrl(HttpServletRequest req, MultipartFile file) throws IOException, ServletException {
        String uploadsDir = "/uploads/";
        String realPathToUploads =  req.getServletContext().getRealPath(uploadsDir);
        if(! new File(realPathToUploads).exists())
        {
            new File(realPathToUploads).mkdir();
        }

        String orgName = file.getOriginalFilename();
        String filePath = realPathToUploads + orgName;
        File dest = new File(filePath);
        file.transferTo(dest);
        return filePath;
    }
}
