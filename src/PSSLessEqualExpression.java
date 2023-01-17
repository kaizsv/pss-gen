import java.util.*;

public class PSSLessEqualExpression extends PSSExpression {

	PSSExpression	m_left;
	PSSExpression	m_right;

	public PSSLessEqualExpression(PSSExpression left, PSSExpression right) {
		m_left = left;
		m_right = right;
	}

	public PSSVal eval(PSSInst var) {
		PSSVal result;
		PSSVal leftVal = m_left.eval(var);
		PSSVal rightVal = m_right.eval(var);

		return leftVal.LessEqual(rightVal);
	}

	public PSSDomainMap deduceDomain(PSSInst var) {
		PSSDomainMap map = new PSSDomainMap();

		PSSInst leftInst = m_left.getInst(var);
		if (leftInst != null) {
			PSSVal rightVal = m_right.eval(var);
			PSSDomain left_domain = leftInst.getInitDomain();
			left_domain = left_domain.reduceDomainLessEqual(rightVal);
			map.add(leftInst, left_domain);
		}
		return map;
	}

	public String getText() {
		return m_left.getText() + "<=" + m_right.getText();
	}
}
