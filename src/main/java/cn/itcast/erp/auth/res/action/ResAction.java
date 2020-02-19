package cn.itcast.erp.auth.res.action;

import java.util.List;
import cn.itcast.erp.auth.res.business.ebi.ResEbi;
import cn.itcast.erp.auth.res.vo.ResModel;
import cn.itcast.erp.auth.res.vo.ResQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class ResAction extends BaseAction{

	private ResEbi resEbi;
	public void setResEbi(ResEbi resEbi) {this.resEbi = resEbi;}
	
	public ResModel rm = new ResModel();
	public ResQueryModel rqm = new ResQueryModel();
	
	public String list() {
		setRecords(resEbi.getCount(rqm));
		List<ResModel> resList = resEbi.list(rqm, curPage, pageCount);
		put("resList", resList);
		return "list";
	}
	
	public String input() {
		if(rm.getUuid()!=null) {
			rm = resEbi.getByUuid(rm.getUuid());
		}
		return "input";
	}
	
	public String saveOrUpdate() {
		if(rm.getUuid()==null) {
			resEbi.save(rm);
		}else {
			resEbi.update(rm);
		}
		return "toList";
	}
	
	public String delete() {
		resEbi.delete(rm);
		return "toList";
	}
}
