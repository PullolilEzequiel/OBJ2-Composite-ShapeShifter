import java.util.List;

public class ShapeShifter implements IShapeShifter {
	private Integer value;
	public  ShapeShifter(int value){
		this.value = value;
	}
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
		return this;
	}

	@Override
	public List<Integer> values() {
		return List.of(this.value);
	}
}
