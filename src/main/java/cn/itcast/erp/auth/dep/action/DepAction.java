package cn.itcast.erp.auth.dep.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;

public class DepAction extends ActionSupport{

	private static final long serialVersionUID = -4760804136155553658L;

	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {this.depEbi = depEbi;}
	
	public DepModel dm = new DepModel();

	// 部门列表
	public String list() {
		List<DepModel> depList = depEbi.list();
		ActionContext.getContext().put("depList", depList);
		return "list";
	}
	
	// 进入操作页面
	public String input() {
		if(dm.getUuid()!=null) {
			// 更新
			dm = depEbi.getByUuid(dm.getUuid());
		}
		return "input";
	}
	
	// 保存/更新
	public String saveOrUpdate() {
		if(dm.getUuid()!=null) {
			// 更新
			depEbi.update(dm);
		}else {
			// 保存部门信息
			depEbi.save(dm);
		}
		return "toList";
	}
	
	// 删除
	public String delete() {
		depEbi.delete(dm);
		return "toList";
	}
}
