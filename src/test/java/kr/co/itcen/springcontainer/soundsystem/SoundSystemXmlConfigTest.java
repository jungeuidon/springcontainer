package kr.co.itcen.springcontainer.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Auto Configuration - xml Config(Annotation Scan)
 * Component Scanning( @Component, @Named, @Autowired, @Inject )
 *                     @Service
 *                     @Controller
 *                     @Repository
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/soundsystem/SoundSystemConfig.xml"})
public class SoundSystemXmlConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
							//System적으로 String값이나 예약어를 바꾸는 역할. 다음줄이동 을 공백으로 바꾸었다.
	@Autowired
	@Qualifier("highSchoolRapper2Final")
	private CompactDisc cd;

	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDNull() {
		assertNotNull(cd);
	}

	@Test
	public void testCDPlayer() {
		assertNotNull(cdPlayer);
	}
	
	//@Ignore
	@Test
	public void testPlay() {
		cdPlayer.play();
		assertEquals("Playing 붕붕 by 김하은", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
