import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShapeShifterTest {
	ShapeShifter shifterA;
	ShapeShifter shifterB;
	@BeforeEach
	void setup(){
		shifterA = new ShapeShifter(1);
		shifterB = new ShapeShifter(2);
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

	@Test
	void compositionChangeValue(){
		ArrayList<Integer> expectedList = new ArrayList<>();
		Assertions.assertEquals(
			Arrays.asList(1),
			shifterA.values());
		Assertions.assertEquals(
			Arrays.asList(2),
			shifterB.values());



		IShapeShifter composition = shifterA.compose(shifterB);
		expectedList.add(1);
		expectedList.add(2);

		Assertions.assertEquals(
			expectedList,
			composition.values()
		);

		composition = composition.compose(
			new ShapeShifter(5)
		);
		expectedList.add(5);
		Assertions.assertEquals(
			expectedList,
			composition.values()
		);
	}
}
