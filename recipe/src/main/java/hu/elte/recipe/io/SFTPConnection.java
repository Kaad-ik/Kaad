package hu.elte.recipe.io;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * The Class SFTPConnection.
 */
public class SFTPConnection {

  /** The Constant SERVER_IMAGES_URL. */
  private static final String SERVER_IMAGES_URL = "images";
    
  /** The Constant SFTP. */
  private static final String SFTP = "sftp";
    
  /** The Constant config. */
  private static final Properties config = new Properties();
  
  static {
    config.put("StrictHostKeyChecking","no");
  }

  /** The client. */
  private final JSch client = new JSch();
    
  /** The session. */
  private Session session;
    
  /** The channel sftp. */
  private ChannelSftp channelSftp;
    
  /** The url. */
  private String url;
   
  /** The port. */
  private int port;
    
  /** The username. */
  private String username;
    
  /** The password. */
  private String password;

  /**
   * Instantiates a new SFTP connection.
   *
   * @param url the url
   * @param port the port
   * @param username the username
   * @param password the password
   */
  public SFTPConnection(String url, int port, String username, String password) {
    this.url = url;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  /**
   * Generate random file name.
   *
   * @return the string
   */
  @SuppressWarnings("deprecation")
  private String generateRandomFileName() {
    return RandomStringUtils.randomAlphabetic(10);
  }

  /**
   * Connect.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws JSchException the j sch exception
   * @throws SftpException the sftp exception
   */
  private void connect() throws IOException, JSchException, SftpException {
    session = client.getSession(username, url, port);
    session.setPassword(password);
    session.setConfig(config);
    session.connect();
    channelSftp = (ChannelSftp) session.openChannel(SFTP);
    channelSftp.connect();
    channelSftp.cd(SERVER_IMAGES_URL);
  }

  /**
   * Disconnect.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void disconnect() throws IOException {
    try {
      session.disconnect();
      channelSftp.disconnect();
    } catch (Exception e) {
      //ignore this sh**
    }
  }

  /**
   * Upload.
   *
   * @param fileInputStream the file input stream
   * @return the string
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws JSchException the j sch exception
   * @throws SftpException the sftp exception
   */
  public String upload(InputStream fileInputStream)
      throws IOException, JSchException, SftpException {
    connect();
    String randomFileName = "";
    while (true) {
      randomFileName = generateRandomFileName() + ".jpg";
      if (!channelSftp.ls(".").contains(randomFileName)) {
        channelSftp.put(fileInputStream,randomFileName);
        break;
      }
    }
    disconnect();
    return randomFileName;
  }

  /**
   * Download.
   *
   * @param fileName the file name
   * @return the byte[]
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws JSchException the j sch exception
   */
  public byte[] download(String fileName) throws IOException, JSchException {
    try {
      connect();
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      channelSftp.get(fileName + ".jpg", outputStream);
      return outputStream.toByteArray();
    } catch (SftpException e) {
      disconnect();
      return defaultImage();
    }
  }

  /**
   * Default image.
   *
   * @return the byte[]
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private byte[] defaultImage() throws IOException {
    Resource resource = new ClassPathResource("default.jpg");
    return IOUtils.toByteArray(resource.getInputStream());
  }
}
