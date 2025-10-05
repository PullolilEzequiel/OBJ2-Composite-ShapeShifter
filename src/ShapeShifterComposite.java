import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class ShapeShifterComposite implements IShapeShifter {
	List<IShapeShifter> compositions = new ArrayList<>();
	public ShapeShifterComposite(IShapeShifter shape1, IShapeShifter shape2) {
		this.compositions.add(shape1);
		this.compositions.add(shape2);
	}

	@Override
	public IShapeShifter compose(IShapeShifter shifter){
		return new ShapeShifterComposite(this, shifter);
	}

	@Override
	public int deepest() {
		OptionalInt max = compositions.stream().mapToInt(IShapeShifter::deepest).max();
		if (max.isEmpty()){
			return  1;
		}else{
			return  max.getAsInt() + 1;
		}
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
