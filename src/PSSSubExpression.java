import java.util.*;

public class PSSSubExpression extends PSSExpression {

	PSSExpression	m_left;
	PSSExpression	m_right;

	public PSSSubExpression(PSSExpression left, PSSExpression right) {
		m_left = left;
		m_right = right;
	}

	public PSSVal eval(PSSInst var) {
		PSSVal result;
		PSSVal leftVal = m_left.eval(var);
		PSSVal rightVal = m_right.eval(var);

		return leftVal.Sub(rightVal);
	}

	public String getText() {
		return m_left.getText() + "-" + m_right.getText();
	}
}
