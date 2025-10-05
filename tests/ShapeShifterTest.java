import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


public class ShapeShifterTest {
	ShapeShifter shifterA = new ShapeShifter(1);
	ShapeShifter shifterB = new ShapeShifter(2);
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
			compositeSubject = new ShapeShifterComposite(shifterA, compositeSubject);
		}
	}

	@Test
	void shifterValueReturnSingleton(){
		Assertions.assertEquals(
			List.of(1),
			shifterA.values());
		Assertions.assertEquals(
			List.of(2),
			shifterB.values());
	}

	@Test
	void compositionBetweenShifterChangeValueReturn(){
		ArrayList<Integer> expectedList = new ArrayList<>();
		IShapeShifter composition = new ShapeShifter(0);
		expectedList.add(0);
		for(int i=0; i < 5; i++) {
			composition = composition.compose(
				new ShapeShifter(i)
			);
			expectedList.add(i);
			Assertions.assertEquals(
				expectedList,
				composition.values()
			);
		}
	}

	@Test
	void flatShifterPersistValues() {
		IShapeShifter shifterC = shifterA.compose(shifterB);
		IShapeShifter shifterD = shifterC.compose(
			new ShapeShifter(3)
		);

		List<Integer> preFlatValues = shifterD.values();
		IShapeShifter flatShifterD = shifterD.flat();

		Assertions.assertEquals(preFlatValues, flatShifterD.values());
	}

}
