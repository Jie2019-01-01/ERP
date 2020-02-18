package cn.itcast.erp.auth.dep.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.itcast.erp.auth.dep.business.ebi.DepEbi;
import cn.itcast.erp.auth.dep.vo.DepModel;
import cn.itcast.erp.auth.dep.vo.DepQueryModel;

public class DepAction extends ActionSupport{

	private static final long serialVersionUID = -4760804136155553658L;

	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {this.depEbi = depEbi;}
	
	public DepModel dm = new DepModel();
	public DepQueryModel dqm = new DepQueryModel();
	public Integer curPage = 1;	// 当前页
	public Integer pageCount = 3; // 每页显示数量
	public Integer totalRecords; // 总记录数
	public Integer lastPage; // 最后一页

	// 部门列表
	public String list() {
		// 获取总条目
		totalRecords = depEbi.getCount(dqm);
		// 计算最后一页
		lastPage = (totalRecords-1)/pageCount+1;
		// 分页查找
		List<DepModel> depList = depEbi.list(dqm, curPage, pageCount);
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
