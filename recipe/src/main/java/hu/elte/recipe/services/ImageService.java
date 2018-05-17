package hu.elte.recipe.services;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import hu.elte.recipe.exceptions.InternalServerError;
import hu.elte.recipe.io.SFTPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageService.
 */
@Service
public class ImageService {

    /** The SFTP connection. */
    private SFTPConnection SFTPConnection;

    /**
     * Instantiates a new image service.
     *
     * @param SFTPConnection the SFTP connection
     */
    @Autowired
    public ImageService(SFTPConnection SFTPConnection) {
        this.SFTPConnection = SFTPConnection;
    }

    /**
     * Upload file.
     *
     * @param multipartFile the multipart file
     * @return the string
     */
    public String uploadFile(MultipartFile multipartFile){
        try {
            return SFTPConnection.upload(multipartFile.getInputStream());
        } catch (IOException | SftpException | JSchException e) {
            throw new InternalServerError(e.getMessage());
        }
    }

    /**
     * Download file.
     *
     * @param imgUrl the img url
     * @return the byte[]
     */
    public byte[] downloadFile(String imgUrl){
        try {
            return SFTPConnection.download(imgUrl);
        } catch (IOException | JSchException e) {
            throw new InternalServerError(e.getMessage());
        }
    }
}
