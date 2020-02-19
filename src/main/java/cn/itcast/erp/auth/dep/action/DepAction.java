package cn.itcast.erp.auth.dep.action;

import java.util.List;
import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class DepAction extends BaseAction{

	private static final long serialVersionUID = -4760804136155553658L;

	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {this.depEbi = depEbi;}
	
	public DepModel dm = new DepModel();
	public DepQueryModel dqm = new DepQueryModel();

	// 部门列表
	public String list() {
		setRecords(depEbi.getCount(dqm));
		// 分页查找
		List<DepModel> depList = depEbi.list(dqm, curPage, pageCount);
		put("depList", depList);
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
