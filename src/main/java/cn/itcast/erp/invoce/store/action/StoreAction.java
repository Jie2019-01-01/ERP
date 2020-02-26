package cn.itcast.erp.invoce.store.action;

import java.util.List;
import cn.itcast.erp.auth.emp.business.ebi.EmpEbi;
import cn.itcast.erp.auth.emp.vo.EmpModel;
import cn.itcast.erp.invoce.store.business.ebi.StoreEbi;
import cn.itcast.erp.invoce.store.vo.StoreModel;
import cn.itcast.erp.invoce.store.vo.StoreQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class StoreAction extends BaseAction{

	private StoreEbi storeEbi;
	public void setStoreEbi(StoreEbi storeEbi) {this.storeEbi = storeEbi;}
	private EmpEbi empEbi;
	public void setEmpEbi(EmpEbi empEbi) {this.empEbi = empEbi;}

	public StoreModel sm = new StoreModel();
	public StoreQueryModel sqm = new StoreQueryModel();

	public String list() {
		setRecords(storeEbi.getCount(sqm));
		List<StoreModel> storeList = storeEbi.list(sqm, curPage, pageCount);
		put("storeList", storeList);
		return "list";
	}

	public String input() {
		if(sm.getUuid()!=null) {
			sm = storeEbi.getByUuid(sm.getUuid());
		}
		List<EmpModel> empList = empEbi.getByDep(getLoginEm().getDm().getUuid());
		put("empList", empList);
		return "input";
	}

	public String saveOrUpdate() {
		if(sm.getUuid()!=null) {
			storeEbi.update(sm);
		}else {
			storeEbi.save(sm);
		}
		return "toList";
	}

	public String delete() {
		storeEbi.delete(sm);
		return "toList";
	}

}