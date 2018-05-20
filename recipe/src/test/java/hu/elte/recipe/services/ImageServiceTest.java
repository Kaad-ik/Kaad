package hu.elte.recipe.services;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import hu.elte.recipe.exceptions.InternalServerError;
import hu.elte.recipe.io.SFTPConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {

    /** The mocks collector. */
    private final MocksCollector mocksCollector = new MocksCollector();

    /** The Constant IMAGE_URL. */
    private static final String IMAGE_URL = "imgeurl";
    
    /** The Constant ERROR_MESSAGE. */
    private static final String ERROR_MESSAGE = "bednyúz srácok";
    
    /** The Constant BYTES. */
    private static final byte[] BYTES = new byte[]{'a','b','c'};
    
    /** The Constant DUMMY_INPUT_STREAM. */
    private static final InputStream DUMMY_INPUT_STREAM = new InputStream() {
        @Override
        public int read() throws IOException {
            return 0;
        }
    };

    /** The sftp connection mock. */
    @Mock
    private SFTPConnection sftpConnectionMock;

    /** The mock multipart file. */
    @Mock
    private MockMultipartFile mockMultipartFile;

    /** The image service. */
    @InjectMocks
    private ImageService imageService;

    /**
     * Setup.
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        verifyNoMoreInteractions(mocksCollector.getMocks());
    }

    /**
     * Should upload image.
     *
     * @throws JSchException the j sch exception
     * @throws SftpException the sftp exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void shouldUploadImage() throws JSchException, SftpException, IOException {
        when(mockMultipartFile.getInputStream()).thenReturn(DUMMY_INPUT_STREAM);
        when(sftpConnectionMock.upload(DUMMY_INPUT_STREAM)).thenReturn(IMAGE_URL);
        String actual = imageService.uploadFile(mockMultipartFile);
        assertEquals(IMAGE_URL, actual);
        verify(mockMultipartFile).getInputStream();
        verify(sftpConnectionMock).upload(DUMMY_INPUT_STREAM);
    }

    /**
     * Should throw internal server error on IO exception.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test(expected = InternalServerError.class)
    public void shouldThrowInternalServerErrorOnIOException() throws IOException {
        when(mockMultipartFile.getInputStream()).thenThrow(new IOException(ERROR_MESSAGE));
        try {
            imageService.uploadFile(mockMultipartFile);
        } catch (InternalServerError e) {
            assertEquals(ERROR_MESSAGE, e.getMessage());
            verify(mockMultipartFile).getInputStream();
            throw e;
        }
    }

    /**
     * Should throw internal server error on sftp exception.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SftpException the sftp exception
     * @throws JSchException the j sch exception
     */
    @Test(expected = InternalServerError.class)
    public void shouldThrowInternalServerErrorOnSftpException() throws IOException, SftpException, JSchException {
        when(mockMultipartFile.getInputStream()).thenReturn(DUMMY_INPUT_STREAM);
        when(sftpConnectionMock.upload(DUMMY_INPUT_STREAM)).thenThrow(new SftpException(0, ERROR_MESSAGE));
        try{
            imageService.uploadFile(mockMultipartFile);
        }catch (InternalServerError e){
            assertEquals(ERROR_MESSAGE, e.getMessage());
            verify(mockMultipartFile).getInputStream();
            verify(sftpConnectionMock).upload(DUMMY_INPUT_STREAM);
            throw e;
        }
    }

    /**
     * Should throw internal server error on J sch exception.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SftpException the sftp exception
     * @throws JSchException the j sch exception
     */
    @Test(expected = InternalServerError.class)
    public void shouldThrowInternalServerErrorOnJSchException() throws IOException, SftpException, JSchException {
        when(mockMultipartFile.getInputStream()).thenReturn(DUMMY_INPUT_STREAM);
        when(sftpConnectionMock.upload(DUMMY_INPUT_STREAM)).thenThrow(new JSchException(ERROR_MESSAGE));
        try{
            imageService.uploadFile(mockMultipartFile);
        }catch (InternalServerError e){
            assertEquals(ERROR_MESSAGE, e.getMessage());
            verify(mockMultipartFile).getInputStream();
            verify(sftpConnectionMock).upload(DUMMY_INPUT_STREAM);
            throw e;
        }
    }

    /**
     * Should download file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JSchException the j sch exception
     */
    @Test
    public void shouldDownloadFile() throws IOException, JSchException {
        when(sftpConnectionMock.download(IMAGE_URL)).thenReturn(BYTES);
        byte[] actual = imageService.downloadFile(IMAGE_URL);
        assertArrayEquals(BYTES, actual);
        verify(sftpConnectionMock).download(IMAGE_URL);
    }

    /**
     * Should throw internal server error on IO exception on download.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JSchException the j sch exception
     */
    @Test(expected = InternalServerError.class)
    public void shouldThrowInternalServerErrorOnIOExceptionOnDownload() throws IOException, JSchException {
        when(sftpConnectionMock.download(IMAGE_URL)).thenThrow(new IOException(ERROR_MESSAGE));
        try{
            imageService.downloadFile(IMAGE_URL);
        }catch (InternalServerError e){
            assertEquals(ERROR_MESSAGE, e.getMessage());
            verify(sftpConnectionMock).download(IMAGE_URL);
            throw e;
        }
    }

    /**
     * Should throw internal server error on J sch exception on download.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JSchException the j sch exception
     */
    @Test(expected = InternalServerError.class)
    public void shouldThrowInternalServerErrorOnJSchExceptionOnDownload() throws IOException, JSchException {
        when(sftpConnectionMock.download(IMAGE_URL)).thenThrow(new JSchException(ERROR_MESSAGE));
        try{
            imageService.downloadFile(IMAGE_URL);
        }catch (InternalServerError e){
            assertEquals(ERROR_MESSAGE, e.getMessage());
            verify(sftpConnectionMock).download(IMAGE_URL);
            throw e;
        }
    }
}
