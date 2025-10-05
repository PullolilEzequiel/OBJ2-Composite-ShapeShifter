public class ShapeShifterFlat extends   ShapeShifterComposite{
	public ShapeShifterFlat() {
		super();
	}

	public IShapeShifter compose(IShapeShifter shifter) {
		compositions.add(shifter);
		System.out.println(this.compositions);
		return this;
	}



}
