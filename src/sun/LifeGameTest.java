package sun;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LifeGameTest {

	private static LifeGame lg=new LifeGame(8,8);
	@Before
	public void setUp() throws Exception {
		for(int i=1;i<lg.stl.length-1;i++){
			for(int j=1;j<lg.stl[i].length-1;j++){
				lg.stl[i][j]=true;
			}
		}
		lg.stl[1][4]=false;
		lg.stl[2][1]=false;
		lg.stl[2][6]=false;
		lg.stl[3][1]=false;
		lg.stl[3][2]=false;
		lg.stl[3][3]=false;
		lg.stl[3][4]=false;
		lg.stl[3][5]=false;
		lg.stl[4][1]=false;
		lg.stl[4][4]=false;
		lg.stl[4][6]=false;
		lg.stl[5][2]=false;
		lg.stl[6][2]=false;
		lg.stl[6][3]=false;
		lg.stl[6][4]=false;
		lg.stl[6][6]=false;
		lg.updata();
	}

	@Ignore("LifeGame()Not yet implemented")
	@Test
	public void testLifeGame() {
		fail("尚未实现");
	}

	@Ignore("Randomized()Not yet implemented")
	@Test
	public void testRandomized() {
		fail("尚未实现");
	}

	@Test
	public void testGeneration() {
		lg.generation();
		lg.updata();
		assertEquals(lg.stl[1][1],true);
		assertEquals(lg.stl[1][5],true);
		assertEquals(lg.stl[1][6],true);
		assertEquals(lg.stl[2][1],true);
		assertEquals(lg.stl[3][6],true);
		assertEquals(lg.stl[4][2],true);
		assertEquals(lg.stl[4][3],true);
		assertEquals(lg.stl[5][1],true);
		assertEquals(lg.stl[5][3],true);
		assertEquals(lg.stl[5][6],true);
		assertEquals(lg.stl[6][2],true);
		assertEquals(lg.stl[6][5],true);
		assertEquals(lg.stl[6][6],true);
		assertEquals(lg.stl[1][2],false);
		assertEquals(lg.stl[1][3],false);
		assertEquals(lg.stl[1][4],false);
		assertEquals(lg.stl[2][2],false);
		assertEquals(lg.stl[2][3],false);
		assertEquals(lg.stl[2][4],false);
		assertEquals(lg.stl[2][5],false);
		assertEquals(lg.stl[2][6],false);
		assertEquals(lg.stl[3][1],false);
		assertEquals(lg.stl[3][2],false);
		assertEquals(lg.stl[3][3],false);
		assertEquals(lg.stl[3][4],false);
		assertEquals(lg.stl[3][5],false);
		assertEquals(lg.stl[4][1],false);
		assertEquals(lg.stl[4][4],false);
		assertEquals(lg.stl[4][5],false);
		assertEquals(lg.stl[4][6],false);
		assertEquals(lg.stl[5][2],false);
		assertEquals(lg.stl[5][4],false);
		assertEquals(lg.stl[5][5],false);
		assertEquals(lg.stl[6][1],false);
		assertEquals(lg.stl[6][3],false);
		assertEquals(lg.stl[6][4],false);
	}

	@Ignore("Updata()Not yet implemented")
	@Test
	public void testUpdata() {
		fail("尚未实现");
	}

}
