package exp.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Condition;

public class AllUpperCaseCondition implements Condition{
	private String value;

	public boolean eval() {
		if(value == null){
			throw new BuildException("value attribute is not set");
		}
		return value.toUpperCase().equals(value);
	}

	public void setValue(String value) {
		this.value = value;
	}
}
