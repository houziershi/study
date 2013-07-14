package net.jade;

/**
* 这是 <b>一个简单的类</b> 注释。
*
* @author Jade
* @author 阿左
*
*
*/
public class Hello {
	
	/**
	 * 这是 <b>doc</b> 注释。
	 *
	 * @param name 用户的名字
	 *
	 */
	public String genWelcomeMessage(String name) {
		return "Welcome " + name + "!";
	}
	
	/**
	 * 这是一个<b>过期的</b>方法，很有可能在下一个版本中被移除。
	 *
	 * @deprecated 已经过期
	 *
	 * @param name 用户的名字
	 *
	 * @see net.jade.Hello#genWelcomeMessage(String)
	 * 		genWelcomeMessage
	 *
	 */
	public String outOfDate(String name) {
		return "Welcome " + name + "!";
	}
}
