package hu.elte.recipe.configs;

import hu.elte.recipe.io.SFTPConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by doma on 2017.11.02..
 */
@Configuration
public class SFTPConfig {

    @Value("${ftp.server.url}")
    private String url;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    @Bean
    public SFTPConnection ftpConnection(){
        return new SFTPConnection(url,port,username,password);
    }
}
