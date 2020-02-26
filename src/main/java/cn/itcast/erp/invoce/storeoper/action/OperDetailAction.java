package cn.itcast.erp.invoce.storeoper.action;

import java.util.List;
import cn.itcast.erp.invoce.storeoper.business.ebi.OperDetailEbi;
import cn.itcast.erp.invoce.storeoper.vo.OperDetailModel;
import cn.itcast.erp.invoce.storeoper.vo.OperDetailQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class OperDetailAction extends BaseAction{

	private OperDetailEbi operDetailEbi;
	public void setOperDetailEbi(OperDetailEbi operDetailEbi) {this.operDetailEbi = operDetailEbi;}

	public OperDetailModel om = new OperDetailModel();
	public OperDetailQueryModel oqm = new OperDetailQueryModel();

	public String list() {
		setRecords(operDetailEbi.getCount(oqm));
		List<OperDetailModel> operDetailList = operDetailEbi.list(oqm, curPage, pageCount);
		put("operDetailList", operDetailList);
		return "list";
	}

	public String input() {
		if(om.getUuid()!=null) {
			om = operDetailEbi.getByUuid(om.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(om.getUuid()!=null) {
			operDetailEbi.update(om);
		}else {
			operDetailEbi.save(om);
		}
		return "toList";
	}

	public String delete() {
		operDetailEbi.delete(om);
		return "toList";
	}

}