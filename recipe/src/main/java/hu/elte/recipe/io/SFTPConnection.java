package hu.elte.recipe.io;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Properties;

/**
 * Created by doma on 2017.11.02..
 */
public class SFTPConnection {

    private static final String SERVER_IMAGES_URL = "images";
    private static final String SFTP = "sftp";
    private static final Properties config = new Properties();
    static {
        config.put("StrictHostKeyChecking","no");
    }

    private final JSch client = new JSch();
    private Session session;
    private ChannelSftp channelSftp;
    private String url;
    private int port;
    private String username;
    private String password;

    public SFTPConnection(String url, int port, String username, String password) {
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    private String generateRandomFileName(){
        return RandomStringUtils.randomAlphabetic(10);
    }

    private void connect() throws IOException, JSchException, SftpException {
        session = client.getSession(username, url, port);
        session.setPassword(password);
        session.setConfig(config);
        session.connect();
        channelSftp = (ChannelSftp) session.openChannel(SFTP);
        channelSftp.connect();
        channelSftp.cd(SERVER_IMAGES_URL);
    }

    private void disconnect() throws IOException {
        try{
            session.disconnect();
            channelSftp.disconnect();
        }catch (Exception e){
            //ignore this sh**
        }
    }

    public String upload(InputStream fileInputStream) throws IOException, JSchException, SftpException {
            connect();
            String randomFileName = "";
            while(true){
                randomFileName = generateRandomFileName()+".jpg";

                if(!channelSftp.ls(".").contains(randomFileName)){
                    channelSftp.put(fileInputStream,randomFileName);
                    break;
                }
            }
            disconnect();
            return randomFileName;
    }

    public byte[] download(String fileName) throws IOException, JSchException{
        try {
            connect();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            channelSftp.get(fileName+".jpg", outputStream);
            return outputStream.toByteArray();
        } catch (SftpException e) {
            disconnect();
            return defaultImage();
        }
    }

    private byte[] defaultImage() throws IOException {
        Resource resource = new ClassPathResource("default.jpg");
        return IOUtils.toByteArray(resource.getInputStream());
    }
}
