import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeShifterTest {
	@Test
	void ShapeShifterLevelZeroGenerateShapeShifterCompositeTest(){
		ShapeShifter shifterA = new ShapeShifter();
		ShapeShifter shifterB = new ShapeShifter();


		Assertions.assertInstanceOf(ShapeShifterComposite.class, shifterA.compose(shifterB));
		Assertions.assertInstanceOf(ShapeShifterComposite.class, shifterB.compose(shifterA));
	}

	@Test
	void ShapeShifterDeepestIncrement(){
		ShapeShifter shifterA = new ShapeShifter();
		ShapeShifter shifterB = new ShapeShifter();
		Assertions.assertEquals(0, shifterA.deepest());

		IShapeShifter shifter = shifterA.compose(shifterB);
		Assertions.assertEquals(1, shifter.deepest());
	}
}
