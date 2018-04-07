package hu.elte.recipe.services;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import hu.elte.recipe.exceptions.InternalServerError;
import hu.elte.recipe.io.SFTPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    private SFTPConnection SFTPConnection;

    @Autowired
    public ImageService(SFTPConnection SFTPConnection) {
        this.SFTPConnection = SFTPConnection;
    }

    public String uploadFile(MultipartFile multipartFile){
        try {
            return SFTPConnection.upload(multipartFile.getInputStream());
        } catch (IOException | SftpException | JSchException e) {
            throw new InternalServerError(e.getMessage());
        }
    }

    public byte[] downloadFile(String imgUrl){
        try {
            return SFTPConnection.download(imgUrl);
        } catch (IOException | JSchException e) {
            throw new InternalServerError(e.getMessage());
        }
    }
}
