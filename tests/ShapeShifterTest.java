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
	void compositionIncrementDeepestNumberTest(){
		IShapeShifter compositeSubject = shifterA;
		for(int i= 0; i < 5; i++){
			Assertions.assertEquals(i, compositeSubject.deepest());
			compositeSubject = new ShapeShifterComposite(shifterA, compositeSubject);;
		}
	}
}
