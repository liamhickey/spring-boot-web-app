package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BuddyInfoPrefixTest {

    @Test
    public void changePrefix() throws Exception {
        BuddyInfo buddyInfo = new BuddyInfo();
        assert(buddyInfo.getPrefix().equals("Mr."));
        buddyInfo.setPrefix("Sir");
        assert(buddyInfo.getPrefix().equals("Sir"));
    }

}