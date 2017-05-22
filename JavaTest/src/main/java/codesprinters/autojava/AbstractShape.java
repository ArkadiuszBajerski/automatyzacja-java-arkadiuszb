package codesprinters.autojava;

public abstract class AbstractShape extends Shapes {

	public String getName() {
		return this.getClass().getSimpleName();
	}
}