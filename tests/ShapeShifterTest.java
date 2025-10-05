import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeShifterTest {
	ShapeShifter shifterA;
	ShapeShifter shifterB;
	@BeforeEach
	void setup(){
		shifterA = new ShapeShifter();
		shifterB = new ShapeShifter();
	}
	@Test
	void ShapeShifterLevelZeroGenerateShapeShifterCompositeTest(){
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
