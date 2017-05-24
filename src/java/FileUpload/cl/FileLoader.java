package FileUpload.cl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/images/*")
public class FileLoader extends javax.servlet.http.HttpServlet {

    private String imagePath;

    @Override
    public void init() throws ServletException {
        this.imagePath = "C:/x-images/images";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getPathInfo()/*.substring(1)*/;
        if (filename == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        File file = new File(imagePath, filename);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        response.reset();
        response.setContentType("image/*");
        response.setContentLength((int) file.length());
        try (FileInputStream in = new FileInputStream(file); OutputStream out = response.getOutputStream()) {
            byte[] buf = new byte[(1024 * 1024 * 10)];
            int count = 0;
            while ((count = in.read(buf)) >= 0) {
                out.write(buf, 0, count);
            }
        }
    }

}
