import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Color;

public class PicEditTests {

	@Test
	public void testLumBlack() {
		assertEquals(0, PicEdit.lum(new Color(0,0,0)), 0);		
	}

	@Test
	public void testLumWhite() {
		assertEquals(255, PicEdit.lum(new Color(255,255,255)), 0);		
	}

	@Test
	public void testLumColors() {
		assertEquals(29.9, PicEdit.lum(new Color(100,0,0)), 0.01);		
		assertEquals(58.7, PicEdit.lum(new Color(0,100,0)), 0.01);
		assertEquals(11.4, PicEdit.lum(new Color(0,0,100)), 0.01);
		assertEquals(100.0, PicEdit.lum(new Color(100,100,100)), 0.01);
		assertEquals(90.75, PicEdit.lum(new Color(50,100,150)), 0.01);
	}

	@Test
	public void testAverageLum() {
		Picture pic = new Picture(1,2);
		pic.set(0,0, new Color(10,10,10));
		pic.set(0,1, new Color(20,20,20));
		assertEquals(15.0, PicEdit.averageLum(pic), 0.01);
	}

	@Test
	public void testChangedColorSaturation() {
		Color redGrey = new Color(150,100,100);
		Color grey = PicEdit.changedColorSaturation(redGrey, 0.0);
		assertEquals(new Color(115,115,115), grey);
		Color red = PicEdit.changedColorSaturation(redGrey, 2.0);
		assertEquals(new Color(185, 85, 85), red);
	}

	@Test
	public void testChangedColorSaturationMin() {
		Color a = new Color(10,50,50);
		Color b = PicEdit.changedColorSaturation(a, 2.0);
		assertEquals(new Color(0, 62, 62), b);
	}

	@Test
	public void testChangedColorSaturationMax() {
		Color a = new Color(250,100,100);
		Color b = PicEdit.changedColorSaturation(a, 2.0);
		assertEquals(255, b.getRed());
		assertEquals(55, b.getGreen());
		assertEquals(55, b.getBlue());
	}

	@Test
	public void testChangeSaturation() {
		Picture pic = new Picture(2,1);
		pic.set(0,0, new Color(200,100,100));
		pic.set(1,0, new Color(100,100,200));
		PicEdit.changeSaturation(pic, 0.5);
		assertEquals(new Color(165,115,115), pic.get(0,0));
		assertEquals(new Color(106,106,156), pic.get(1,0));
	}

	@Test
	public void testRotatedLeft() {
		Picture pic = new Picture(3,2);
		pic.set(0,0, new Color(0,0,0));
		pic.set(1,0, new Color(1,0,0));
		pic.set(2,0, new Color(2,0,0));
		pic.set(0,1, new Color(0,1,0));
		pic.set(1,1, new Color(1,1,0));
		pic.set(2,1, new Color(2,1,0));
		Picture rotated = PicEdit.rotatedLeft(pic);
		assertEquals(2, rotated.width());
		assertEquals(3, rotated.height());
		assertEquals(new Color(2,0,0), rotated.get(0,0));
		assertEquals(new Color(2,1,0), rotated.get(1,0));
		assertEquals(new Color(1,0,0), rotated.get(0,1));
		assertEquals(new Color(1,1,0), rotated.get(1,1));
		assertEquals(new Color(0,0,0), rotated.get(0,2));
		assertEquals(new Color(0,1,0), rotated.get(1,2));
	}


}