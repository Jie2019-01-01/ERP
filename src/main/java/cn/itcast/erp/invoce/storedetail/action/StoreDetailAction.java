package cn.itcast.erp.invoce.storedetail.action;

import java.util.List;
import cn.itcast.erp.invoce.storedetail.business.ebi.StoreDetailEbi;
import cn.itcast.erp.invoce.storedetail.vo.StoreDetailModel;
import cn.itcast.erp.invoce.storedetail.vo.StoreDetailQueryModel;
import cn.itcast.erp.utils.base.BaseAction;

public class StoreDetailAction extends BaseAction{

	private StoreDetailEbi storeDetailEbi;
	public void setStoreDetailEbi(StoreDetailEbi storeDetailEbi) {this.storeDetailEbi = storeDetailEbi;}

	public StoreDetailModel sm = new StoreDetailModel();
	public StoreDetailQueryModel sqm = new StoreDetailQueryModel();

	public String list() {
		setRecords(storeDetailEbi.getCount(sqm));
		List<StoreDetailModel> storeDetailList = storeDetailEbi.list(sqm, curPage, pageCount);
		put("storeDetailList", storeDetailList);
		return "list";
	}

	public String input() {
		if(sm.getUuid()!=null) {
			sm = storeDetailEbi.getByUuid(sm.getUuid());
		}
		return "input";
	}

	public String saveOrUpdate() {
		if(sm.getUuid()!=null) {
			storeDetailEbi.update(sm);
		}else {
			storeDetailEbi.save(sm);
		}
		return "toList";
	}

	public String delete() {
		storeDetailEbi.delete(sm);
		return "toList";
	}

}