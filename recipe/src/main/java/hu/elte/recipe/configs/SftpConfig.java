package hu.elte.recipe.configs;

import hu.elte.recipe.io.SFTPConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class SFTPConfig.
 */
@Configuration
public class SftpConfig {

  /** The url. */
  @Value("${ftp.server.url}")
  private String url;

  /** The port. */
  @Value("${ftp.server.port}")
  private int port;

  /** The username. */
  @Value("${ftp.server.username}")
  private String username;

  /** The password. */
  @Value("${ftp.server.password}")
  private String password;

  /**
   * Ftp connection.
   *
   * @return the SFTP connection
   */
  @Bean
  public SFTPConnection ftpConnection() {
    return new SFTPConnection(url,port,username,password);
  }
}
