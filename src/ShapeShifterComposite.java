import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class ShapeShifterComposite implements IShapeShifter {
	List<IShapeShifter> compositions = new ArrayList<>();
	public ShapeShifterComposite(IShapeShifter shape1, IShapeShifter shape2) {
		this.compositions.add(shape1);
		this.compositions.add(shape2);
	}

	public ShapeShifterComposite(List<IShapeShifter> list) {
		this.compositions = list;
	}

	@Override
	public IShapeShifter compose(IShapeShifter shifter){
		return new ShapeShifterComposite(this, shifter);
	}

	@Override
	public int deepest() {
		OptionalInt max = this.compositions.stream().mapToInt(IShapeShifter::deepest).max();
		return  1 + (max.isPresent()? max.getAsInt() : 0);
	}

	@Override
	public IShapeShifter flat() {
		return  null;
	}

	@Override
	public List<Integer> values() {
		ArrayList<Integer> values = new ArrayList<>();

		this.compositions.stream().forEach(
			shifter -> values.addAll(shifter.values())
		);

		return  values;
	}
}
