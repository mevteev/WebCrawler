package org.evteev.implementations;

import org.evteev.interfaces.Receiver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Created by mike on 03.08.17.
 */
public class WebPageReceiverTest {

    @Test
    void GooglePageReceiveTest() throws Exception {
        Receiver receiver = new WebPageReceiver();
        //System.out.println(receiver.receive("http://google.com"));
        assertNotNull(receiver.receive("http://google.com"));
    }
}
