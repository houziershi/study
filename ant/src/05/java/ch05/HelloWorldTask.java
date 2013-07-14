package ch05;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class HelloWorldTask extends Task {
	/* inner class */
	public class Message {
		String msg;

		public Message() {
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		};
	}

	/* inside message list */
	List<Message> messages = new ArrayList<Message>();

	/* Call back function to create Message for ant */
	public Message createMessage(){
		Message msg = new Message();
		this.messages.add(msg);
		return msg;
	}

	String message; /* message to set */
	boolean fail; /* to mark is build failed */

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFail(boolean b) {
		this.fail = b;
	}

	/* set nasted attribute */
	public void addText(String text) {
		this.message = text;
	}

	/* main function */
	public void execute() {
		if (this.fail)
			throw new BuildException("HelloWorld Task Build Failed.");

		if (null != this.message)
			this.log(this.message);

		for (Message msg : this.messages) {
			this.log(msg.getMsg());
		}
	}
}
