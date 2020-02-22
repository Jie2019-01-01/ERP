package cn.itcast.erp.invoce.goodstype.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.erp.invoce.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.erp.invoce.goodstype.dao.dao.GoodsTypeDao;
import cn.itcast.erp.invoce.goodstype.vo.GoodsTypeModel;
import cn.itcast.erp.utils.base.BaseQueryModel;

@Transactional
public class GoodsTypeEbo implements GoodsTypeEbi {

	private GoodsTypeDao goodsTypeDao;
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {this.goodsTypeDao = goodsTypeDao;}

	public List<GoodsTypeModel> list() {
		return goodsTypeDao.list();
	}

	public void save(GoodsTypeModel gm) {
		goodsTypeDao.save(gm);
	}

	public void update(GoodsTypeModel gm) {
		goodsTypeDao.update(gm);
	}

	public GoodsTypeModel getByUuid(Long uuid) {
		return goodsTypeDao.getByUuid(uuid);
	}

	public void delete(GoodsTypeModel gm) {
		goodsTypeDao.delete(gm);
	}

	public List<GoodsTypeModel> list(BaseQueryModel bqm, Integer curPage, Integer pageCount) {
		return goodsTypeDao.list(bqm,curPage, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return goodsTypeDao.getCount(bqm);
	}

	public List<GoodsTypeModel> getBySupplier(Long uuid) {
		return goodsTypeDao.getBySupplier(uuid);
	}

}