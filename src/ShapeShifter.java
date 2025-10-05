import java.util.List;

public class ShapeShifter implements IShapeShifter {
	@Override
	public IShapeShifter compose(IShapeShifter shifter) {
		return new ShapeShifterComposite(this, shifter);
	}

	@Override
	public int deepest() {
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		return null;
	}

	@Override
	public List<Integer> values() {
		return List.of();
	}
}
