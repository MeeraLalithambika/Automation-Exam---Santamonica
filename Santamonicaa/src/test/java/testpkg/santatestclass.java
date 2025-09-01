package testpkg;

import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.santapageclass;

public class santatestclass extends Baseclass{

@Test
public void test() throws Exception
{
	santapageclass ob = new santapageclass(driver);
	ob.title();
	ob.findCourse();
	ob.hover();
	ob.scroll();
	ob.contactUs();
}
	
}
