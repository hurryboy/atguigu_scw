package pojo;

/*import java.util.Collection;*/
import java.util.List;

public class ApiReturn<T> {
	
	private Integer code;//状态码  0：表示成功  1：表示失败
	private String msg;//信息提示；处理完请求以后的额外提示
	private List<T> content;//交给页面的内容  List<book>
	private Object ext;//可扩展的数据
	
	public static<E> ApiReturn<E> success(String msg,List<E> content,Object ext){
		ApiReturn<E> apiReturn = new ApiReturn<E>();
		apiReturn.setContent(content);
		apiReturn.setCode(0);
		apiReturn.setMsg(msg);
		apiReturn.setExt(ext);
		return apiReturn;
	}
	
	public static<E> ApiReturn<E> fail(String msg,List<E> content,Object ext){
		ApiReturn<E> apiReturn = new ApiReturn<E>();
		apiReturn.setContent(content);
		apiReturn.setCode(1);
		apiReturn.setMsg(msg);
		apiReturn.setExt(ext);
		return apiReturn;
	}
	
	
	
	
	
	public Object getExt() {
		return ext;
	}

	public void setExt(Object ext) {
		this.ext = ext;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	
	

}
