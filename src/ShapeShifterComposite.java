import java.util.*;

public class ShapeShifterComposite implements IShapeShifter {
	List<IShapeShifter> compositions = new ArrayList<>();
	public ShapeShifterComposite(IShapeShifter shape1, IShapeShifter shape2) {
		this.compositions.add(shape1);
		this.compositions.add(shape2);
	}

	public ShapeShifterComposite() {}

	public ShapeShifterComposite(IShapeShifter shapeShifter) {
		this.compositions.add(shapeShifter);
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
		IShapeShifter flatter = new ShapeShifterFlat();
		this.compositions.forEach(flatter::compose);
		return flatter;
	}

	@Override
	public List<Integer> values() {
		ArrayList<Integer> values = new ArrayList<>();

		this.compositions.forEach(
			shifter -> values.addAll(shifter.values())
		);

		return  values;
	}
}
