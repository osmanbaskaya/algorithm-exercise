package exposed;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;


/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 18.Jun.2014 | 17:59
 */
public class Chapter18Test {

    @Test
    public void connectStreams() throws IOException {
        final String exampleText = "Text to be streamed";
        final InputStream inputStream =
                new ByteArrayInputStream(exampleText.getBytes());
        final OutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, outputStream);
        final String streamContents = outputStream.toString();
        assertEquals(exampleText, streamContents);
        assertNotSame(exampleText, streamContents);
    }
}
