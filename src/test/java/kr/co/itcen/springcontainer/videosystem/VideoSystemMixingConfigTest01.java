package kr.co.itcen.springcontainer.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.VideoSystemConfig01;

/*
 *  Explicit(명시적) Configuration - Java Mixing Config
 *  
 *  JavaConfig <-------- {JavaConfig01, JavaConfig02, JavaConfig03 }
 *  			 import 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {VideoSystemConfig01.class})
public class VideoSystemMixingConfigTest01 {

	
//	@Rule
//	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	DVDPlayer player;
	
	@Test
	public void testPlayerNull() {
		assertNotNull(player);
	}
}
