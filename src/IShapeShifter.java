import java.util.List;

public interface IShapeShifter {
	IShapeShifter compose(IShapeShifter shifter);
	int deepest();
	IShapeShifter flat();
	List<Integer> values();

}
